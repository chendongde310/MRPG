package cn.com.cdgame.mrpg.object.role;

import cn.com.cdgame.mrpg.object.BaseObject;

/**
 * 角色类
 *
 */
public class BaseRole extends BaseObject {

    String gender ; //性别
    String age; //年龄

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
