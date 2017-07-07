package cn.com.cdgame.mrpg.abst;

import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

/**
 * 职业
 */

public class Job {

    String jobId ;//职业ID
    String name; //职业名称
    String lv;//等级
    List<Term> keys; //关键词，用语筛选职业词汇

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLv() {
        return lv;
    }

    public void setLv(String lv) {
        this.lv = lv;
    }


    public List<Term> getKeys() {
        return keys;
    }

    public void setKeys(List<Term> keys) {
        this.keys = keys;
    }
}
