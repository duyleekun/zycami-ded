/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import java.util.Objects;

public class MessageLike {
    public static final String WORK_TYPE_ARTICLE = "circle_article";
    private String avatar;
    private int circleArticleId;
    private String createAt;
    private int id;
    private int isRead;
    private String nickname;
    private int postId;
    private String sourceUrls;
    private String targetText;
    private int userId;
    private int verified;
    private String workType;

    public MessageLike() {
    }

    public MessageLike(int n10, int n11, String string2, String string3, int n12, String string4, int n13, int n14, String string5, String string6, int n15, String string7) {
        this.id = n10;
        this.userId = n11;
        this.nickname = string2;
        this.avatar = string3;
        this.verified = n12;
        this.workType = string4;
        this.circleArticleId = n13;
        this.postId = n14;
        this.sourceUrls = string5;
        this.createAt = string6;
        this.isRead = n15;
        this.targetText = string7;
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
            object = (MessageLike)object;
            int n10 = this.id;
            int n11 = ((MessageLike)object).id;
            if (n10 != n11 || (n10 = this.userId) != (n11 = ((MessageLike)object).userId) || (n10 = this.verified) != (n11 = ((MessageLike)object).verified) || (n10 = this.circleArticleId) != (n11 = ((MessageLike)object).circleArticleId) || (n10 = this.postId) != (n11 = ((MessageLike)object).postId) || (n10 = this.isRead) != (n11 = ((MessageLike)object).isRead) || (n10 = (int)(Objects.equals(object3 = this.nickname, object2 = ((MessageLike)object).nickname) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.avatar, object2 = ((MessageLike)object).avatar) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.workType, object2 = ((MessageLike)object).workType) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.sourceUrls, object2 = ((MessageLike)object).sourceUrls) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.createAt, object2 = ((MessageLike)object).createAt) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.targetText, object = ((MessageLike)object).targetText))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getCircleArticleId() {
        return this.circleArticleId;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public int getId() {
        return this.id;
    }

    public int getIsRead() {
        return this.isRead;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getPostId() {
        return this.postId;
    }

    public String getSourceUrls() {
        return this.sourceUrls;
    }

    public String getTargetText() {
        return this.targetText;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getVerified() {
        return this.verified;
    }

    public String getWorkType() {
        return this.workType;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.userId), object = this.nickname, object = this.avatar, object = Integer.valueOf(this.verified), object = this.workType, object = Integer.valueOf(this.circleArticleId), object = Integer.valueOf(this.postId), object = this.sourceUrls, object = this.createAt, object = Integer.valueOf(this.isRead), object = this.targetText};
        return Objects.hash(objectArray);
    }

    public void setAvatar(String string2) {
        this.avatar = string2;
    }

    public void setCircleArticleId(int n10) {
        this.circleArticleId = n10;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setIsRead(int n10) {
        this.isRead = n10;
    }

    public void setNickname(String string2) {
        this.nickname = string2;
    }

    public void setPostId(int n10) {
        this.postId = n10;
    }

    public void setSourceUrls(String string2) {
        this.sourceUrls = string2;
    }

    public void setTargetText(String string2) {
        this.targetText = string2;
    }

    public void setUserId(int n10) {
        this.userId = n10;
    }

    public void setVerified(int n10) {
        this.verified = n10;
    }

    public void setWorkType(String string2) {
        this.workType = string2;
    }
}

