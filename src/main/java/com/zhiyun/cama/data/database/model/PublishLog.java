/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import java.util.Objects;

public class PublishLog {
    private String failAt;
    private int id;
    private String phoneid;
    private String postId;
    private String reason;
    private String reasonCode;
    private String sourceUrl1;
    private String sourceUrl2;
    private String userId;
    private String version;

    public PublishLog(int n10, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
        this.id = n10;
        this.userId = string2;
        this.postId = string3;
        this.phoneid = string4;
        this.reason = string5;
        this.reasonCode = string6;
        this.sourceUrl1 = string7;
        this.sourceUrl2 = string8;
        this.failAt = string9;
        this.version = string10;
    }

    public PublishLog(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
        this.userId = string2;
        this.postId = string3;
        this.phoneid = string4;
        this.reason = string5;
        this.reasonCode = string6;
        this.sourceUrl1 = string7;
        this.sourceUrl2 = string8;
        this.failAt = string9;
        this.version = string10;
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
            object = (PublishLog)object;
            int n10 = this.id;
            int n11 = ((PublishLog)object).id;
            if (n10 != n11 || (n10 = (int)(Objects.equals(object3 = this.userId, object2 = ((PublishLog)object).userId) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.postId, object2 = ((PublishLog)object).postId) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.phoneid, object2 = ((PublishLog)object).phoneid) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.reason, object2 = ((PublishLog)object).reason) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.reasonCode, object2 = ((PublishLog)object).reasonCode) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.sourceUrl1, object2 = ((PublishLog)object).sourceUrl1) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.sourceUrl2, object2 = ((PublishLog)object).sourceUrl2) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.failAt, object2 = ((PublishLog)object).failAt) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.version, object = ((PublishLog)object).version))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getFailAt() {
        return this.failAt;
    }

    public int getId() {
        return this.id;
    }

    public String getPhoneid() {
        return this.phoneid;
    }

    public String getPostId() {
        return this.postId;
    }

    public String getReason() {
        return this.reason;
    }

    public String getReasonCode() {
        return this.reasonCode;
    }

    public String getSourceUrl1() {
        return this.sourceUrl1;
    }

    public String getSourceUrl2() {
        return this.sourceUrl2;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.userId, object = this.postId, object = this.phoneid, object = this.reason, object = this.reasonCode, object = this.sourceUrl1, object = this.sourceUrl2, object = this.failAt, object = this.version};
        return Objects.hash(objectArray);
    }

    public void setFailAt(String string2) {
        this.failAt = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setPhoneid(String string2) {
        this.phoneid = string2;
    }

    public void setPostId(String string2) {
        this.postId = string2;
    }

    public void setReason(String string2) {
        this.reason = string2;
    }

    public void setReasonCode(String string2) {
        this.reasonCode = string2;
    }

    public void setSourceUrl1(String string2) {
        this.sourceUrl1 = string2;
    }

    public void setSourceUrl2(String string2) {
        this.sourceUrl2 = string2;
    }

    public void setUserId(String string2) {
        this.userId = string2;
    }

    public void setVersion(String string2) {
        this.version = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PublishLog{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", userId='");
        String string2 = this.userId;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", postId='");
        String string3 = this.postId;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", phoneid='");
        string3 = this.phoneid;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", reason='");
        string3 = this.reason;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", reasonCode='");
        string3 = this.reasonCode;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", sourceUrl1='");
        string3 = this.sourceUrl1;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", sourceUrl2='");
        string3 = this.sourceUrl2;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", failAt='");
        string3 = this.failAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", version='");
        string3 = this.version;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

