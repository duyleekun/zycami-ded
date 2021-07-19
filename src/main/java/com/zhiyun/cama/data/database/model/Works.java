/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import com.zhiyun.cama.data.database.model.Appeal;
import com.zhiyun.cama.data.database.model.Approval;
import java.util.Objects;

public class Works {
    public static final String STATUS_DELETE = "0";
    public static final String STATUS_NORMAL = "1";
    public static final String STATUS_UNDER_APPROVAL = "2";
    public static final String STATUS_UNKNOWN = "-1";
    public static final String STATUS_VIOLATION = "3";
    private String address;
    private Appeal appeal;
    private Approval approval;
    private String avatar;
    private String city;
    private String commentCnt;
    private String country;
    private String des;
    private String deviceTags;
    private String duration;
    private long id;
    private String isChoice;
    private String likeCnt;
    private String nickname;
    private String publishAt;
    private String pv;
    private String shareCnt;
    private String sourceUrls;
    private String status;
    private String tags;
    private String thumbwh;
    private String userId;
    private String verified;

    public Works(long l10) {
        this.id = l10;
    }

    public Works(long l10, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, String string17, String string18, String string19, String string20, String string21) {
        this.id = l10;
        this.sourceUrls = string2;
        this.des = string3;
        this.commentCnt = string4;
        this.likeCnt = string5;
        this.shareCnt = string6;
        this.publishAt = string7;
        this.duration = string8;
        this.thumbwh = string9;
        this.pv = string10;
        this.address = string11;
        this.status = string12;
        this.isChoice = string13;
        this.userId = string14;
        this.avatar = string15;
        this.verified = string16;
        this.nickname = string17;
        this.country = string18;
        this.city = string19;
        this.tags = string20;
        this.deviceTags = string21;
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
            object = (Works)object;
            long l10 = this.id;
            long l11 = ((Works)object).id;
            long l12 = l10 - l11;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (Object)Objects.equals(object3 = this.sourceUrls, object2 = ((Works)object).sourceUrls)) == false || (object4 = (Object)Objects.equals(object3 = this.des, object2 = ((Works)object).des)) == false || (object4 = (Object)Objects.equals(object3 = this.commentCnt, object2 = ((Works)object).commentCnt)) == false || (object4 = (Object)Objects.equals(object3 = this.likeCnt, object2 = ((Works)object).likeCnt)) == false || (object4 = (Object)Objects.equals(object3 = this.shareCnt, object2 = ((Works)object).shareCnt)) == false || (object4 = (Object)Objects.equals(object3 = this.publishAt, object2 = ((Works)object).publishAt)) == false || (object4 = (Object)Objects.equals(object3 = this.duration, object2 = ((Works)object).duration)) == false || (object4 = (Object)Objects.equals(object3 = this.thumbwh, object2 = ((Works)object).thumbwh)) == false || (object4 = (Object)Objects.equals(object3 = this.pv, object2 = ((Works)object).pv)) == false || (object4 = (Object)Objects.equals(object3 = this.address, object2 = ((Works)object).address)) == false || (object4 = (Object)Objects.equals(object3 = this.status, object2 = ((Works)object).status)) == false || (object4 = (Object)Objects.equals(object3 = this.isChoice, object2 = ((Works)object).isChoice)) == false || (object4 = (Object)Objects.equals(object3 = this.userId, object2 = ((Works)object).userId)) == false || (object4 = (Object)Objects.equals(object3 = this.avatar, object2 = ((Works)object).avatar)) == false || (object4 = (Object)Objects.equals(object3 = this.verified, object2 = ((Works)object).verified)) == false || (object4 = (Object)Objects.equals(object3 = this.nickname, object2 = ((Works)object).nickname)) == false || (object4 = (Object)Objects.equals(object3 = this.country, object2 = ((Works)object).country)) == false || (object4 = (Object)Objects.equals(object3 = this.city, object2 = ((Works)object).city)) == false || (object4 = (Object)Objects.equals(object3 = this.tags, object2 = ((Works)object).tags)) == false || !(bl3 = Objects.equals(object3 = this.deviceTags, object = ((Works)object).deviceTags))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getAddress() {
        return this.address;
    }

    public Appeal getAppeal() {
        return this.appeal;
    }

    public Approval getApproval() {
        return this.approval;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getCity() {
        return this.city;
    }

    public String getCommentCnt() {
        return this.commentCnt;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDes() {
        return this.des;
    }

    public String getDeviceTags() {
        return this.deviceTags;
    }

    public String getDuration() {
        return this.duration;
    }

    public long getId() {
        return this.id;
    }

    public String getIsChoice() {
        return this.isChoice;
    }

    public String getLikeCnt() {
        return this.likeCnt;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPublishAt() {
        return this.publishAt;
    }

    public String getPv() {
        return this.pv;
    }

    public String getShareCnt() {
        return this.shareCnt;
    }

    public String getSourceUrls() {
        return this.sourceUrls;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTags() {
        return this.tags;
    }

    public String getThumbwh() {
        return this.thumbwh;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getVerified() {
        return this.verified;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.sourceUrls, object = this.des, object = this.commentCnt, object = this.likeCnt, object = this.shareCnt, object = this.publishAt, object = this.duration, object = this.thumbwh, object = this.pv, object = this.address, object = this.status, object = this.isChoice, object = this.userId, object = this.avatar, object = this.verified, object = this.nickname, object = this.country, object = this.city, object = this.tags, object = this.deviceTags};
        return Objects.hash(objectArray);
    }

    public void setAddress(String string2) {
        this.address = string2;
    }

    public void setAppeal(Appeal appeal) {
        this.appeal = appeal;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    public void setAvatar(String string2) {
        this.avatar = string2;
    }

    public void setCity(String string2) {
        this.city = string2;
    }

    public void setCommentCnt(String string2) {
        this.commentCnt = string2;
    }

    public void setCountry(String string2) {
        this.country = string2;
    }

    public void setDes(String string2) {
        this.des = string2;
    }

    public void setDeviceTags(String string2) {
        this.deviceTags = string2;
    }

    public void setDuration(String string2) {
        this.duration = string2;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setIsChoice(String string2) {
        this.isChoice = string2;
    }

    public void setLikeCnt(String string2) {
        this.likeCnt = string2;
    }

    public void setNickname(String string2) {
        this.nickname = string2;
    }

    public void setPublishAt(String string2) {
        this.publishAt = string2;
    }

    public void setPv(String string2) {
        this.pv = string2;
    }

    public void setShareCnt(String string2) {
        this.shareCnt = string2;
    }

    public void setSourceUrls(String string2) {
        this.sourceUrls = string2;
    }

    public void setStatus(String string2) {
        this.status = string2;
    }

    public void setTags(String string2) {
        this.tags = string2;
    }

    public void setThumbwh(String string2) {
        this.thumbwh = string2;
    }

    public void setUserId(String string2) {
        this.userId = string2;
    }

    public void setVerified(String string2) {
        this.verified = string2;
    }
}

