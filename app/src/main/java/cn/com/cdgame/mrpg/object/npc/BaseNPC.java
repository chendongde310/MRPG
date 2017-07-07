package cn.com.cdgame.mrpg.object.npc;

import android.text.TextUtils;

import cn.com.cdgame.mrpg.abst.Emotion;
import cn.com.cdgame.mrpg.abst.Friendliness;
import cn.com.cdgame.mrpg.abst.Job;
import cn.com.cdgame.mrpg.ai.BaseAI;
import cn.com.cdgame.mrpg.object.role.BaseRole;

/**
 * NPC 非玩家控制角色，作为中二世界的独立个体，我们赋予她肉体和灵魂。
 */

public class BaseNPC extends BaseRole {
    Emotion emotion; //当前情绪
    Job job;  //职业
    Friendliness friendliness; //友善值

    /**
     * 交谈
     * @param body
     */
    public void talking(String body,TalkCallback talkCallback){
        if(TextUtils.isEmpty(body)||talkCallback==null){
            return;
        }

        BaseAI ai = new BaseAI(this);
        ai.talking(body,talkCallback);


    }




    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Friendliness getFriendliness() {
        return friendliness;
    }

    public void setFriendliness(Friendliness friendliness) {
        this.friendliness = friendliness;
    }
}
