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
    List<String> output;  //基本回答
    List<String> output1; //正面回答
    List<String> output2; //负面回答



    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public List<String> getOutput1() {
        return output1;
    }

    public void setOutput1(List<String> output1) {
        this.output1 = output1;
    }

    public List<String> getOutput2() {
        return output2;
    }

    public void setOutput2(List<String> output2) {
        this.output2 = output2;
    }
}
