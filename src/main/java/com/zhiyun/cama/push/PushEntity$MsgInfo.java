/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.push;

public class PushEntity$MsgInfo {
    private String avatar;
    private String circleAvatar;
    private String circleName;
    private String content;
    private String createAt;
    private String nickname;
    private String notifyId;
    private String objectId;
    private String page_id;
    private String sourceUrls;
    private String title;
    private String type;
    private String type_id;

    public String getAvatar() {
        return this.avatar;
    }

    public String getCircleAvatar() {
        return this.circleAvatar;
    }

    public String getCircleName() {
        return this.circleName;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getNotifyId() {
        return this.notifyId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getPage_id() {
        return this.page_id;
    }

    public String getSourceUrls() {
        return this.sourceUrls;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getType_id() {
        return this.type_id;
    }

    public void setAvatar(String string2) {
        this.avatar = string2;
    }

    public void setCircleAvatar(String string2) {
        this.circleAvatar = string2;
    }

    public void setCircleName(String string2) {
        this.circleName = string2;
    }

    public void setContent(String string2) {
        this.content = string2;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setNickname(String string2) {
        this.nickname = string2;
    }

    public void setNotifyId(String string2) {
        this.notifyId = string2;
    }

    public void setObjectId(String string2) {
        this.objectId = string2;
    }

    public void setPage_id(String string2) {
        this.page_id = string2;
    }

    public void setSourceUrls(String string2) {
        this.sourceUrls = string2;
    }

    public void setTitle(String string2) {
        this.title = string2;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public void setType_id(String string2) {
        this.type_id = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MsgInfo{type='");
        String string2 = this.type;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", type_id='");
        String string3 = this.type_id;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", page_id='");
        string3 = this.page_id;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", notifyId='");
        string3 = this.notifyId;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", objectId='");
        string3 = this.objectId;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", nickname='");
        string3 = this.nickname;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", avatar='");
        string3 = this.avatar;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", circleName='");
        string3 = this.circleName;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", circleAvatar='");
        string3 = this.circleAvatar;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", sourceUrls='");
        string3 = this.sourceUrls;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", title='");
        string3 = this.title;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", content='");
        string3 = this.content;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", createAt='");
        string3 = this.createAt;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

