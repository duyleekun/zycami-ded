/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote.data;

public class KwaiShareData$OssBean {
    private String bucket_name;
    private int is_private;
    private String object_name;

    public KwaiShareData$OssBean(String string2, String string3, int n10) {
        this.bucket_name = string2;
        this.object_name = string3;
        this.is_private = n10;
    }

    public String getBucket_name() {
        return this.bucket_name;
    }

    public int getIs_private() {
        return this.is_private;
    }

    public String getObject_name() {
        return this.object_name;
    }

    public void setBucket_name(String string2) {
        this.bucket_name = string2;
    }

    public void setIs_private(int n10) {
        this.is_private = n10;
    }

    public void setObject_name(String string2) {
        this.object_name = string2;
    }
}

