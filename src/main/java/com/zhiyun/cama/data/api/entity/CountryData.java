/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.net.BaseEntity;

public class CountryData
extends BaseEntity {
    private String bucket_acl;
    private String bucket_name;
    private String city;
    private String country;
    private int is_overseas;
    private String province;
    private int storage_type;
    private String ts;
    private String url_base;

    public CountryData(String string2, String string3, String string4, String string5, String string6, int n10, String string7, String string8, int n11) {
        this.bucket_name = string2;
        this.bucket_acl = string3;
        this.city = string4;
        this.country = string5;
        this.province = string6;
        this.is_overseas = n10;
        this.ts = string7;
        this.url_base = string8;
        this.storage_type = n11;
    }

    public String getBucket_acl() {
        return this.bucket_acl;
    }

    public String getBucket_name() {
        return this.bucket_name;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public int getIs_overseas() {
        return this.is_overseas;
    }

    public String getProvince() {
        return this.province;
    }

    public int getStorage_type() {
        return this.storage_type;
    }

    public String getTs() {
        return this.ts;
    }

    public String getUrl_base() {
        return this.url_base;
    }

    public void setBucket_acl(String string2) {
        this.bucket_acl = string2;
    }

    public void setBucket_name(String string2) {
        this.bucket_name = string2;
    }

    public void setCity(String string2) {
        this.city = string2;
    }

    public void setCountry(String string2) {
        this.country = string2;
    }

    public void setIs_overseas(int n10) {
        this.is_overseas = n10;
    }

    public void setProvince(String string2) {
        this.province = string2;
    }

    public void setStorage_type(int n10) {
        this.storage_type = n10;
    }

    public void setTs(String string2) {
        this.ts = string2;
    }

    public void setUrl_base(String string2) {
        this.url_base = string2;
    }
}

