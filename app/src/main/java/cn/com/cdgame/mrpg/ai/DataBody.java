package cn.com.cdgame.mrpg.ai;

import java.util.List;

/**
 *
 * Author：陈东
 * Time：2017/7/10 - 上午11:43
 * Notes:语料对象
 */

public class DataBody {

    String input ; //输入
    List<Item> output;  //基本回答
    List<Item> output1; //正面回答
    List<Item> output2; //负面回答




    public static class Item{
        String body; //内容
        String friendly;  //action
        String action;  // 采取的行为反应 （）


        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getFriendly() {
            return friendly;
        }

        public void setFriendly(String friendly) {
            this.friendly = friendly;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<Item> getOutput() {
        return output;
    }

    public void setOutput(List<Item> output) {
        this.output = output;
    }

    public List<Item> getOutput1() {
        return output1;
    }

    public void setOutput1(List<Item> output1) {
        this.output1 = output1;
    }

    public List<Item> getOutput2() {
        return output2;
    }

    public void setOutput2(List<Item> output2) {
        this.output2 = output2;
    }
}
