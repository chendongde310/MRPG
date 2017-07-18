package cn.com.cdgame.mrpg.ai;

import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

import cn.com.cdgame.mrpg.handler.InputBodyHandler;
import cn.com.cdgame.mrpg.handler.OutputBodyHandler;
import cn.com.cdgame.mrpg.object.npc.BaseNPC;
import cn.com.cdgame.mrpg.object.npc.TalkCallback;
import cn.com.cdgame.mrpg.tools.CharAnalysisTool;

/**
 * 通用智能，词汇检索，基本回答
 */

public class BaseAI {
    BaseNPC baseNPC;
    InputBodyHandler inputBody;
    OutputBodyHandler outputBody;
    List<Term> keys; //关键词


    public BaseAI(BaseNPC baseNPC) {
        this.baseNPC = baseNPC;
    }


    /**
     * 首先分词，
     * 优先检索 基本词汇库
     * 然后进行分词-关键词检索
     * 用关键词匹配相关语料库
     *
     * @param body
     * @param talkCallback
     */
    public void talking(String body, TalkCallback talkCallback) {
        DataBody dataBody = CharAnalysisTool.tool.getOutput(body);
        if (dataBody != null && dataBody.getOutput() != null) {
            //先判断下情绪
            List<DataBody.Item> replys;
            if (baseNPC.getFriendliness().value > 0) {
                replys = dataBody.getOutput1();
            } else if (baseNPC.getFriendliness().value < 0) {
                replys = dataBody.getOutput2();
            } else {
                replys = dataBody.getOutput();

            }

            if (replys == null || replys.size() == 0) {
                replys = dataBody.getOutput();
                if (replys == null || replys.size() == 0) {
                    talkCallback.onError();
                    return;
                }
            }
            //再随机
            int num = (int) (Math.random() * replys.size());
            if (num < 0||num >=replys.size() ) {
                num = 0;
            }
            DataBody.Item item =replys.get(num);
            String reply = item.getBody();
            reply = reply.replace("@job", baseNPC.getJob().getName()).
                    replace("@name", baseNPC.getName());
            //行为

            //友好度
            if(item.getFriendly()!=null)
            baseNPC.getFriendliness().change(item.getFriendly());

            talkCallback.onNext(reply+baseNPC.getFriendliness().value);  //// TODO: 2017/7/11 0011 添加随机 ，判断情绪
        } else {
            talkCallback.onError();
        }
    }


}
