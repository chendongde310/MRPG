package cn.com.cdgame.mrpg.object.npc;

import cn.com.cdgame.mrpg.abst.Emotion;
import cn.com.cdgame.mrpg.abst.Friendliness;
import cn.com.cdgame.mrpg.abst.Job;
import cn.com.cdgame.mrpg.object.role.BaseRole;

/**
 * NPC 非玩家控制角色，作为中二世界的独立个体，我们赋予她肉体和灵魂。
 */

public class BaseNPC extends BaseRole {
    Emotion emotion; //当前情绪
    Job job;  //职业
    Friendliness friendliness; //友善值
}
