package cn.com.cdgame.mrpg.abst;

/**
 *
 * Author：陈东
 * Time：2017/7/6 - 下午2:37
 * Notes:情绪
 */
public class Emotion {

//    static final String BAD = "坏的情绪";
//    static final String NORMAL = "平静的情绪";
//    static final String GOOD = "好的情绪";

    //暂时不用，情绪之分好和坏： int type ; //情绪分类，-2：愤怒， -1：伤心， 0：平静，   1：开心，  2：感激
    /**
     *  基本为0 情绪为一般   ，0以下为差的情绪  0以上为好的情绪   取值范围（-10 - 10）
     *
     *  -5 以下会拒绝回答玩家的提问，-10会主动（逃离／攻击）玩家
     */
    int value;









}
