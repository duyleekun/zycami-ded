/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.net.BaseEntity;

public class HotResEntity
extends BaseEntity {
    private int isPrivate;
    private String md5;
    private String url;
    private int ver;

    public HotResEntity() {
    }

    public HotResEntity(int n10, String string2, String string3, int n11) {
        this.ver = n10;
        this.md5 = string2;
        this.url = string3;
        this.isPrivate = n11;
    }

    public int getIsPrivate() {
        return this.isPrivate;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVer() {
        return this.ver;
    }

    public HotResEntity setIsPrivate(int n10) {
        this.isPrivate = n10;
        return this;
    }

    public HotResEntity setMd5(String string2) {
        this.md5 = string2;
        return this;
    }

    public HotResEntity setUrl(String string2) {
        this.url = string2;
        return this;
    }

    public HotResEntity setVer(int n10) {
        this.ver = n10;
        return this;
    }
}

