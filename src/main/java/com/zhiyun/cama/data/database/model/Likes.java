/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import java.util.Objects;

public class Likes {
    private String commentCnt;
    private String des;
    private String duration;
    private long id;
    private String likeCnt;
    private long likeId;
    private String publishAt;
    private String pv;
    private String shareCnt;
    private String sourceUrls;
    private String thumbwh;
    private long user;
    private String userId;

    public Likes(long l10, long l11, long l12, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
        this.likeId = l10;
        this.user = l11;
        this.id = l12;
        this.sourceUrls = string2;
        this.des = string3;
        this.commentCnt = string4;
        this.likeCnt = string5;
        this.shareCnt = string6;
        this.publishAt = string7;
        this.pv = string8;
        this.duration = string9;
        this.thumbwh = string10;
        this.userId = string11;
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
            long l10;
            long l11;
            object = (Likes)object;
            long l12 = this.likeId;
            long l13 = ((Likes)object).likeId;
            long l14 = l12 - l13;
            Object object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (l11 = (l12 = this.user) - (l13 = ((Likes)object).user)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false || (object4 = (l10 = (l12 = this.id) - (l13 = ((Likes)object).id)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object4 = (Object)Objects.equals(object3 = this.sourceUrls, object2 = ((Likes)object).sourceUrls)) == false || (object4 = (Object)Objects.equals(object3 = this.des, object2 = ((Likes)object).des)) == false || (object4 = (Object)Objects.equals(object3 = this.commentCnt, object2 = ((Likes)object).commentCnt)) == false || (object4 = (Object)Objects.equals(object3 = this.likeCnt, object2 = ((Likes)object).likeCnt)) == false || (object4 = (Object)Objects.equals(object3 = this.shareCnt, object2 = ((Likes)object).shareCnt)) == false || (object4 = (Object)Objects.equals(object3 = this.publishAt, object2 = ((Likes)object).publishAt)) == false || (object4 = (Object)Objects.equals(object3 = this.pv, object2 = ((Likes)object).pv)) == false || (object4 = (Object)Objects.equals(object3 = this.duration, object2 = ((Likes)object).duration)) == false || (object4 = (Object)Objects.equals(object3 = this.thumbwh, object2 = ((Likes)object).thumbwh)) == false || !(bl3 = Objects.equals(object3 = this.userId, object = ((Likes)object).userId))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getCommentCnt() {
        return this.commentCnt;
    }

    public String getDes() {
        return this.des;
    }

    public String getDuration() {
        return this.duration;
    }

    public long getId() {
        return this.id;
    }

    public String getLikeCnt() {
        return this.likeCnt;
    }

    public long getLikeId() {
        return this.likeId;
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

    public String getThumbwh() {
        return this.thumbwh;
    }

    public long getUser() {
        return this.user;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        Object object = this.likeId;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.user), object = Long.valueOf(this.id), object = this.sourceUrls, object = this.des, object = this.commentCnt, object = this.likeCnt, object = this.shareCnt, object = this.publishAt, object = this.pv, object = this.duration, object = this.thumbwh, object = this.userId};
        return Objects.hash(objectArray);
    }

    public void setCommentCnt(String string2) {
        this.commentCnt = string2;
    }

    public void setDes(String string2) {
        this.des = string2;
    }

    public void setDuration(String string2) {
        this.duration = string2;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setLikeCnt(String string2) {
        this.likeCnt = string2;
    }

    public void setLikeId(long l10) {
        this.likeId = l10;
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

    public void setThumbwh(String string2) {
        this.thumbwh = string2;
    }

    public void setUser(long l10) {
        this.user = l10;
    }

    public void setUserId(String string2) {
        this.userId = string2;
    }
}

