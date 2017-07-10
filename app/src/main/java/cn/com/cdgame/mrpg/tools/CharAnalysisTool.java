package cn.com.cdgame.mrpg.tools;

import android.content.Context;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Author：陈东
 * Time：2017/7/10 - 上午11:00
 * Notes:字符解析工具
 */

public class CharAnalysisTool {


    public static CharAnalysisTool tool = new CharAnalysisTool();

    /**
     * 初始化这个工具，在打开应用的时候加载语料库
     */
    public void init(Context context ) {
        loadBaseData(context);


    }

    /**
     * 加载基本语料，例如  {你好 ; 再见}  等回答
     * @param context
     */
    private void loadBaseData(Context context) {
//            context.getAssets().open()

//        1.读取XML文件,获得document对象
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("data/tongyong.xml"));

        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }


}
