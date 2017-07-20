package bitoflife.chatterbean.util;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

/**
 * Created by chen on 2017/7/20.
 */

public class LP {


    public static String segment(String text) {
        List<Term> lists = HanLP.segment(text);
        String str = "";
        for (Term term : lists) {
            str = str + term.word + " ";
        }
        return str;
    }


}
