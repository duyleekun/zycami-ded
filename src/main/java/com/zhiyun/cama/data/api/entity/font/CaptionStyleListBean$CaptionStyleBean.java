/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.font;

import com.zhiyun.cama.data.api.entity.font.CaptionStyleListBean$CaptionStyleBean$PlatformBean;

public class CaptionStyleListBean$CaptionStyleBean {
    private String name;
    private int requiredPrime;
    private int sort;
    private String thumb;
    private CaptionStyleListBean$CaptionStyleBean$PlatformBean z_film;
    private CaptionStyleListBean$CaptionStyleBean$PlatformBean zy_play;

    public String getName() {
        return this.name;
    }

    public int getRequiredPrime() {
        return this.requiredPrime;
    }

    public int getSort() {
        return this.sort;
    }

    public String getThumb() {
        return this.thumb;
    }

    public CaptionStyleListBean$CaptionStyleBean$PlatformBean getZ_film() {
        return this.z_film;
    }

    public CaptionStyleListBean$CaptionStyleBean$PlatformBean getZy_play() {
        return this.zy_play;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setRequiredPrime(int n10) {
        this.requiredPrime = n10;
    }

    public void setSort(int n10) {
        this.sort = n10;
    }

    public void setThumb(String string2) {
        this.thumb = string2;
    }

    public void setZ_film(CaptionStyleListBean$CaptionStyleBean$PlatformBean captionStyleListBean$CaptionStyleBean$PlatformBean) {
        this.z_film = captionStyleListBean$CaptionStyleBean$PlatformBean;
    }

    public void setZy_play(CaptionStyleListBean$CaptionStyleBean$PlatformBean captionStyleListBean$CaptionStyleBean$PlatformBean) {
        this.zy_play = captionStyleListBean$CaptionStyleBean$PlatformBean;
    }
}

