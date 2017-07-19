package cn.com.cdgame.mrpg.tools;

import android.content.Context;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.com.cdgame.mrpg.ai.DataBody;

/**
 * Author：陈东
 * Time：2017/7/10 - 上午11:00
 * Notes:字符解析工具
 */

public class CharAnalysisTool {


    public static CharAnalysisTool tool = new CharAnalysisTool();
    // List<DataBody> datas = new ArrayList<>();
    HashMap<String, DataBody> datas = new HashMap<>();

    public DataBody getOutput(String input) {


        return datas.get(input.trim());
    }

    /**
     * 初始化这个工具，在打开应用的时候加载语料库
     */
    public void init(Context context) {
        loadBaseData(context);


    }

    /**
     * 加载基本语料，例如  {你好 ; 再见}  等回答
     * todo -- 1017/7/19
     * {你好 ; 再见}不能算是基本语句，每个人面对这些句子都可能有不同的回答
     * 基本的应该是一些常识语句，例如我们 { }
     *
     */
    private void loadBaseData(Context context) {


//        1.读取XML文件,获得document对象
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(context.getAssets().open("talk/base.xml"));
            for (Element item : document.getRootElement().elements("item")) {
                DataBody body = new DataBody();
                body.setInput(item.element("i").getText());

                body.setOutput(getData(item, "o"));
                body.setOutput1(getData(item, "o1"));
                body.setOutput2(getData(item, "o2"));
                datas.put(body.getInput(), body);
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


    private List<DataBody.Item> getData(Element item, String name) {
        List<DataBody.Item> s = new ArrayList<>();
        for (Element output : item.elements(name)) {
            DataBody.Item itemData = new DataBody.Item();
            itemData.setBody(output.getText());
            Attribute friendly = output.attribute("friendly");
            Attribute action = output.attribute("action");
            if (friendly != null)
                itemData.setFriendly(friendly.getValue());
            if (action != null)
                itemData.setAction(action.getValue());
            s.add(itemData);
        }
        return s;
    }
}
