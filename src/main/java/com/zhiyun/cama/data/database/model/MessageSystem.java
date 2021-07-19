/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import java.util.Objects;

public class MessageSystem {
    public static final String OBJECT_TYPE_ACTIVE = "share_activity";
    public static final String OBJECT_TYPE_THEME = "share_cat";
    public static final String OBJECT_TYPE_WORKS = "share_post";
    public static final String VERB_ACTIVE = "activity_notice";
    public static final String VERB_PRIME = "prime_message";
    public static final String VERB_SYNC_UPLOAD = "share_notice";
    public static final String VERB_TEXT = "text_notice";
    public static final String VERB_THEME = "cat_notice";
    public static final String VERB_URL = "url_notice";
    public static final String VERB_WORKS = "post_notice";
    private String avatar;
    private String content;
    private String createAt;
    private String endAt;
    private int id;
    private String image;
    private int isRead;
    private String nickname;
    private int objectId;
    private String objectType;
    private String sourceUrls;
    private String title;
    private int userId;
    private String verb;

    public MessageSystem() {
        String string2;
        this.verb = string2 = "";
        this.objectType = string2;
        this.title = string2;
        this.content = string2;
        this.nickname = string2;
        this.sourceUrls = string2;
        this.endAt = string2;
        this.image = string2;
    }

    public MessageSystem(int n10, String string2, int n11, String string3, int n12, String string4, String string5, String string6, String string7, String string8, String string9, String string10, int n13, String string11) {
        String string12;
        this.verb = string12 = "";
        this.objectType = string12;
        this.title = string12;
        this.content = string12;
        this.nickname = string12;
        this.sourceUrls = string12;
        this.endAt = string12;
        this.image = string12;
        this.id = n10;
        this.createAt = string2;
        this.isRead = n11;
        this.verb = string3;
        this.objectId = n12;
        this.objectType = string4;
        this.title = string5;
        this.content = string6;
        this.nickname = string7;
        this.sourceUrls = string8;
        this.endAt = string9;
        this.image = string10;
        this.userId = n13;
        this.avatar = string11;
    }

    public boolean canGoNext() {
        String string2 = this.verb;
        return VERB_PRIME.equals(string2) ^ true;
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
            object = (MessageSystem)object;
            int n10 = this.id;
            int n11 = ((MessageSystem)object).id;
            if (n10 != n11 || (n10 = this.isRead) != (n11 = ((MessageSystem)object).isRead) || (n10 = this.objectId) != (n11 = ((MessageSystem)object).objectId) || (n10 = this.userId) != (n11 = ((MessageSystem)object).userId) || (n10 = (int)(Objects.equals(object3 = this.createAt, object2 = ((MessageSystem)object).createAt) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.verb, object2 = ((MessageSystem)object).verb) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.objectType, object2 = ((MessageSystem)object).objectType) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.title, object2 = ((MessageSystem)object).title) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.content, object2 = ((MessageSystem)object).content) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.nickname, object2 = ((MessageSystem)object).nickname) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.sourceUrls, object2 = ((MessageSystem)object).sourceUrls) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.endAt, object2 = ((MessageSystem)object).endAt) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.image, object2 = ((MessageSystem)object).image) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.avatar, object = ((MessageSystem)object).avatar))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public String getEndAt() {
        return this.endAt;
    }

    public int getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public int getIsRead() {
        return this.isRead;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getObjectId() {
        return this.objectId;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public String getSourceUrls() {
        return this.sourceUrls;
    }

    public String getTitle() {
        return this.title;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getVerb() {
        return this.verb;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.createAt, object = Integer.valueOf(this.isRead), object = this.verb, object = Integer.valueOf(this.objectId), object = this.objectType, object = this.title, object = this.content, object = this.nickname, object = this.sourceUrls, object = this.endAt, object = this.image, object = Integer.valueOf(this.userId), object = this.avatar};
        return Objects.hash(objectArray);
    }

    public void setAvatar(String string2) {
        this.avatar = string2;
    }

    public void setContent(String string2) {
        this.content = string2;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setEndAt(String string2) {
        this.endAt = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setImage(String string2) {
        this.image = string2;
    }

    public void setIsRead(int n10) {
        this.isRead = n10;
    }

    public void setNickname(String string2) {
        this.nickname = string2;
    }

    public void setObjectId(int n10) {
        this.objectId = n10;
    }

    public void setObjectType(String string2) {
        this.objectType = string2;
    }

    public void setSourceUrls(String string2) {
        this.sourceUrls = string2;
    }

    public void setTitle(String string2) {
        this.title = string2;
    }

    public void setUserId(int n10) {
        this.userId = n10;
    }

    public void setVerb(String string2) {
        this.verb = string2;
    }

    public boolean showContent() {
        String string2 = this.verb;
        return VERB_PRIME.equals(string2);
    }
}

