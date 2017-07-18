package cn.com.cdgame.mrpg.abst;

import android.util.Log;

/**
 * Author：陈东
 * Time：2017/7/6 - 下午3:52
 * Notes:友善值、亲密度
 * <p>
 * 会受情绪影响（直接加减情绪数值）
 */
public class Friendliness {

    public int value; //数值

    public void change(String num) {
        if(num == null ){
            return;
        }
        int f = Integer.parseInt(num);
        value = value + f;
        Log.d("TAG","当前好友度"+value);
    }


//暂不设置
//    List<NPCFriendliness>  npcFriendlinesses ;
//
//    /**
//     * 对其他NPC的亲密度
//     */
//    public static class NPCFriendliness {
//        int value; //数值
//        String formId; //对象npc
//
//    }


}




