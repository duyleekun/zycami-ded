/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.database.model;

import com.zhiyun.net.BaseEntity;
import java.util.Objects;

public class UserInfo
extends BaseEntity {
    public static final int SEX_FEMALE = 2;
    public static final int SEX_MALE = 1;
    public static final int SEX_UNKNOWN = 3;
    public static final int STATE_FOLLOWING = 1;
    public static final int STATE_FRIEND = 2;
    public static final int STATE_UN_FOLLOW;
    private int activity;
    public int actorId;
    private int adnotification;
    private int applicantId;
    private String avatar;
    private String birthday;
    private int blocked;
    private String city;
    public int count;
    private String country;
    private int followed;
    public int followerCnt;
    private int followers_count = 0;
    public int follows;
    private int follows_count = 0;
    private String hobby;
    private int id;
    private String introduction;
    private boolean isAgree;
    private double latitude;
    private double longitude;
    private String mail;
    private int memberId;
    private String mobile;
    public int myfollowsCnt;
    private String nickname;
    private int prime;
    private int primeId;
    private int rank;
    private int sex;
    private int share_post_count = 0;
    private String status;
    public int to;
    private String token;
    public int userId;
    private int verified;

    public UserInfo() {
        double d10;
        this.longitude = d10 = 0.0;
        this.latitude = d10;
        this.memberId = 0;
        this.applicantId = 0;
        this.activity = 0;
        this.rank = 0;
        this.isAgree = false;
        this.blocked = 0;
        this.prime = 0;
        this.primeId = 0;
    }

    public UserInfo(int n10) {
        double d10;
        this.longitude = d10 = 0.0;
        this.latitude = d10;
        this.memberId = 0;
        this.applicantId = 0;
        this.activity = 0;
        this.rank = 0;
        this.isAgree = false;
        this.blocked = 0;
        this.prime = 0;
        this.primeId = 0;
        this.id = n10;
    }

    public UserInfo(int n10, String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n11, int n12, int n13, int n14, String string9, int n15, int n16, String string10, String string11, int n17, String string12, double d10, double d11, int n18, int n19, int n20, int n21, boolean bl2, int n22) {
        double d12;
        this.longitude = d12 = 0.0;
        this.latitude = d12;
        this.memberId = 0;
        this.applicantId = 0;
        this.activity = 0;
        this.rank = 0;
        this.isAgree = false;
        this.blocked = 0;
        this.prime = 0;
        this.primeId = 0;
        this.id = n10;
        this.avatar = string2;
        this.nickname = string3;
        this.birthday = string4;
        this.country = string5;
        this.city = string6;
        this.introduction = string7;
        this.hobby = string8;
        this.sex = n11;
        this.share_post_count = n12;
        this.follows_count = n13;
        this.followers_count = n14;
        this.token = string9;
        this.followed = n15;
        this.verified = n16;
        this.mobile = string10;
        this.mail = string11;
        this.adnotification = n17;
        this.status = string12;
        this.longitude = d10;
        this.latitude = d11;
        this.memberId = n18;
        this.applicantId = n19;
        this.activity = n20;
        this.rank = n21;
        this.isAgree = bl2;
        this.blocked = n22;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            double d10;
            double d11;
            object = (UserInfo)object;
            int n10 = this.id;
            int n11 = ((UserInfo)object).id;
            if (n10 != n11 || (n10 = this.sex) != (n11 = ((UserInfo)object).sex) || (n10 = this.share_post_count) != (n11 = ((UserInfo)object).share_post_count) || (n10 = this.follows_count) != (n11 = ((UserInfo)object).follows_count) || (n10 = this.followers_count) != (n11 = ((UserInfo)object).followers_count) || (n10 = this.followed) != (n11 = ((UserInfo)object).followed) || (n10 = this.verified) != (n11 = ((UserInfo)object).verified) || (n10 = this.adnotification) != (n11 = ((UserInfo)object).adnotification) || (n10 = Double.compare(d11 = ((UserInfo)object).longitude, d10 = this.longitude)) != 0 || (n10 = Double.compare(d11 = ((UserInfo)object).latitude, d10 = this.latitude)) != 0 || (n10 = this.memberId) != (n11 = ((UserInfo)object).memberId) || (n10 = this.applicantId) != (n11 = ((UserInfo)object).applicantId) || (n10 = this.activity) != (n11 = ((UserInfo)object).activity) || (n10 = this.rank) != (n11 = ((UserInfo)object).rank) || (n10 = (int)(this.isAgree ? 1 : 0)) != (n11 = (int)(((UserInfo)object).isAgree ? 1 : 0)) || (n10 = this.blocked) != (n11 = ((UserInfo)object).blocked) || (n10 = (int)(Objects.equals(object3 = this.avatar, object2 = ((UserInfo)object).avatar) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.nickname, object2 = ((UserInfo)object).nickname) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.birthday, object2 = ((UserInfo)object).birthday) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.country, object2 = ((UserInfo)object).country) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.city, object2 = ((UserInfo)object).city) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.introduction, object2 = ((UserInfo)object).introduction) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.hobby, object2 = ((UserInfo)object).hobby) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.token, object2 = ((UserInfo)object).token) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.mobile, object2 = ((UserInfo)object).mobile) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.mail, object2 = ((UserInfo)object).mail) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.status, object = ((UserInfo)object).status))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getActivity() {
        return this.activity;
    }

    public int getAdnotification() {
        return this.adnotification;
    }

    public int getApplicantId() {
        return this.applicantId;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public int getBlocked() {
        return this.blocked;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public int getFollowed() {
        return this.followed;
    }

    public int getFollowers_count() {
        return this.followers_count;
    }

    public int getFollows_count() {
        return this.follows_count;
    }

    public String getHobby() {
        return this.hobby;
    }

    public int getId() {
        return this.id;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getMail() {
        return this.mail;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getPrime() {
        return this.prime;
    }

    public int getPrimeId() {
        return this.primeId;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSex() {
        return this.sex;
    }

    public int getShare_post_count() {
        return this.share_post_count;
    }

    public String getStatus() {
        return this.status;
    }

    public String getToken() {
        return this.token;
    }

    public int getVerified() {
        return this.verified;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.avatar, object = this.nickname, object = this.birthday, object = this.country, object = this.city, object = this.introduction, object = this.hobby, object = Integer.valueOf(this.sex), object = Integer.valueOf(this.share_post_count), object = Integer.valueOf(this.follows_count), object = Integer.valueOf(this.followers_count), object = this.token, object = Integer.valueOf(this.followed), object = Integer.valueOf(this.verified), object = this.mobile, object = this.mail, object = Integer.valueOf(this.adnotification), object = this.status, object = Double.valueOf(this.longitude), object = Double.valueOf(this.latitude), object = Integer.valueOf(this.memberId), object = Integer.valueOf(this.applicantId), object = Integer.valueOf(this.activity), object = Integer.valueOf(this.rank), object = Boolean.valueOf(this.isAgree), object = Integer.valueOf(this.blocked)};
        return Objects.hash(objectArray);
    }

    public boolean isAgree() {
        return this.isAgree;
    }

    public void setActivity(int n10) {
        this.activity = n10;
    }

    public void setAdnotification(int n10) {
        this.adnotification = n10;
    }

    public void setAgree(boolean bl2) {
        this.isAgree = bl2;
    }

    public void setApplicantId(int n10) {
        this.applicantId = n10;
    }

    public void setAvatar(String string2) {
        this.avatar = string2;
    }

    public void setBirthday(String string2) {
        this.birthday = string2;
    }

    public void setBlocked(int n10) {
        this.blocked = n10;
    }

    public void setCity(String string2) {
        this.city = string2;
    }

    public void setCountry(String string2) {
        this.country = string2;
    }

    public void setFollowed(int n10) {
        this.followed = n10;
    }

    public void setFollowers_count(int n10) {
        this.followers_count = n10;
    }

    public void setFollows_count(int n10) {
        this.follows_count = n10;
    }

    public void setHobby(String string2) {
        this.hobby = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setIntroduction(String string2) {
        this.introduction = string2;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public void setMail(String string2) {
        this.mail = string2;
    }

    public void setMemberId(int n10) {
        this.memberId = n10;
    }

    public void setMobile(String string2) {
        this.mobile = string2;
    }

    public void setNickname(String string2) {
        this.nickname = string2;
    }

    public void setPrime(int n10) {
        this.prime = n10;
    }

    public void setPrimeId(int n10) {
        this.primeId = n10;
    }

    public void setRank(int n10) {
        this.rank = n10;
    }

    public void setSex(int n10) {
        this.sex = n10;
    }

    public void setShare_post_count(int n10) {
        this.share_post_count = n10;
    }

    public void setStatus(String string2) {
        this.status = string2;
    }

    public void setToken(String string2) {
        this.token = string2;
    }

    public void setVerified(int n10) {
        this.verified = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserInfo{id=");
        int n10 = this.id;
        stringBuilder.append(n10);
        stringBuilder.append(", avatar='");
        String string2 = this.avatar;
        stringBuilder.append(string2);
        n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", nickname='");
        String string3 = this.nickname;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", birthday='");
        string3 = this.birthday;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", country='");
        string3 = this.country;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", city='");
        string3 = this.city;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", introduction='");
        string3 = this.introduction;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", hobby='");
        string3 = this.hobby;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", sex=");
        int n11 = this.sex;
        stringBuilder.append(n11);
        stringBuilder.append(", share_post_count=");
        n11 = this.share_post_count;
        stringBuilder.append(n11);
        stringBuilder.append(", follows_count=");
        n11 = this.follows_count;
        stringBuilder.append(n11);
        stringBuilder.append(", followers_count=");
        n11 = this.followers_count;
        stringBuilder.append(n11);
        stringBuilder.append(", token='");
        string3 = this.token;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", followed=");
        n11 = this.followed;
        stringBuilder.append(n11);
        stringBuilder.append(", verified=");
        n11 = this.verified;
        stringBuilder.append(n11);
        stringBuilder.append(", mobile='");
        string3 = this.mobile;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", mail='");
        string3 = this.mail;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", adnotification=");
        n11 = this.adnotification;
        stringBuilder.append(n11);
        stringBuilder.append(", status='");
        string3 = this.status;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", longitude=");
        double d10 = this.longitude;
        stringBuilder.append(d10);
        stringBuilder.append(", latitude=");
        d10 = this.latitude;
        stringBuilder.append(d10);
        stringBuilder.append(", memberId=");
        n10 = this.memberId;
        stringBuilder.append(n10);
        stringBuilder.append(", applicantId=");
        n10 = this.applicantId;
        stringBuilder.append(n10);
        stringBuilder.append(", activity=");
        n10 = this.activity;
        stringBuilder.append(n10);
        stringBuilder.append(", rank=");
        n10 = this.rank;
        stringBuilder.append(n10);
        stringBuilder.append(", isAgree=");
        n10 = (int)(this.isAgree ? 1 : 0);
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", blocked=");
        n10 = this.blocked;
        stringBuilder.append(n10);
        stringBuilder.append(", prime=");
        n10 = this.prime;
        stringBuilder.append(n10);
        stringBuilder.append(", primeId=");
        n10 = this.primeId;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

