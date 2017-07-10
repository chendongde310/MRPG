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
     * @param body
     * @param talkCallback
     */
    public void talking(String body, TalkCallback talkCallback) {
        DataBody dataBody =   CharAnalysisTool.tool.getOutput(body);
        if(dataBody!=null&&dataBody.getOutput()!=null)
        talkCallback.onNext(dataBody.getOutput().get(0));  //// TODO: 2017/7/11 0011 添加随机 ，判断情绪
        else {
            talkCallback.onError();
        }
    }




}
