package cn.com.cdgame.mrpg.object.npc;

/**
 *
 * Author：陈东
 * Time：2017/7/7 - 下午12:51
 * Notes:和npc对话的回调
 */

public interface TalkCallback {

    void onNext(String reply);

    void onError();

}
