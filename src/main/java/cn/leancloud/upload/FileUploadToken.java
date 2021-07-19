/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.utils.AVUtils;

public class FileUploadToken {
    private String bucket = null;
    private String key = null;
    private String objectId = null;
    private String provider = null;
    private String token = null;
    private String uploadUrl = null;
    private String url = null;

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (FileUploadToken)object;
            object3 = this.bucket;
            object2 = ((FileUploadToken)object).bucket;
            boolean bl4 = AVUtils.equals(object3, object2);
            if (!(bl4 && (bl4 = AVUtils.equals(object3 = this.objectId, object2 = ((FileUploadToken)object).objectId)) && (bl4 = AVUtils.equals(object3 = this.uploadUrl, object2 = ((FileUploadToken)object).uploadUrl)) && (bl4 = AVUtils.equals(object3 = this.provider, object2 = ((FileUploadToken)object).provider)) && (bl4 = AVUtils.equals(object3 = this.token, object2 = ((FileUploadToken)object).token)) && (bl4 = AVUtils.equals(object3 = this.url, object2 = ((FileUploadToken)object).url)) && (bl3 = AVUtils.equals(object3 = this.key, object = ((FileUploadToken)object).key)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getToken() {
        return this.token;
    }

    public String getUploadUrl() {
        return this.uploadUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Object[] objectArray = new Object[7];
        String string2 = this.bucket;
        objectArray[0] = string2;
        string2 = this.objectId;
        objectArray[1] = string2;
        string2 = this.uploadUrl;
        objectArray[2] = string2;
        string2 = this.provider;
        objectArray[3] = string2;
        string2 = this.token;
        objectArray[4] = string2;
        string2 = this.url;
        objectArray[5] = string2;
        string2 = this.key;
        objectArray[6] = string2;
        return AVUtils.hash(objectArray);
    }

    public void setBucket(String string2) {
        this.bucket = string2;
    }

    public void setKey(String string2) {
        this.key = string2;
    }

    public void setObjectId(String string2) {
        this.objectId = string2;
    }

    public void setProvider(String string2) {
        this.provider = string2;
    }

    public void setToken(String string2) {
        this.token = string2;
    }

    public void setUploadUrl(String string2) {
        this.uploadUrl = string2;
    }

    public void setUrl(String string2) {
        this.url = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FileUploadToken{bucket='");
        String string2 = this.bucket;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", objectId='");
        String string3 = this.objectId;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", uploadUrl='");
        string3 = this.uploadUrl;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", provider='");
        string3 = this.provider;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", token='");
        string3 = this.token;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", url='");
        string3 = this.url;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", key='");
        string3 = this.key;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

