package cn.com.cdgame.mrpg.tools;

import android.content.Context;

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

    public DataBody getOutput(String input) {

        return datas.get(input);
    }





    /**
     * 初始化这个工具，在打开应用的时候加载语料库
     */
    public void init(Context context ) {
        loadBaseData(context );


    }

    /**
     * 加载基本语料，例如  {你好 ; 再见}  等回答
     *
     */
    private void loadBaseData(Context context) {



//        1.读取XML文件,获得document对象
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(context.getAssets().open("tongyong.xml"));
            for (Element item : document.getRootElement().elements("item")) {
                DataBody body = new DataBody();
                body.setInput(item.element("i").getText());
                List<String> s = new ArrayList<>();
                for (Element output:item.elements("o")) {
                    s.add(output.getText());
                }
                body.setOutput(s);
                datas.put(body.getInput(),body);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   // List<DataBody> datas = new ArrayList<>();
    HashMap<String ,DataBody> datas = new HashMap<>();
}
