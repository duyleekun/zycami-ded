/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.font;

import com.zhiyun.cama.data.api.entity.font.FontListBean$FontBean$PlatformBean;

public class FontListBean$FontBean {
    private String name;
    private String name_en;
    private String name_tw;
    private int requiredPrime;
    private int sort;
    private String thumb;
    private FontListBean$FontBean$PlatformBean z_film;
    private FontListBean$FontBean$PlatformBean zy_play;

    public String getName() {
        return this.name;
    }

    public String getName_en() {
        return this.name_en;
    }

    public String getName_tw() {
        return this.name_tw;
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

    public FontListBean$FontBean$PlatformBean getZFilm() {
        return this.z_film;
    }

    public FontListBean$FontBean$PlatformBean getZy_play() {
        return this.zy_play;
    }

    public FontListBean$FontBean setName(String string2) {
        this.name = string2;
        return this;
    }

    public FontListBean$FontBean setName_en(String string2) {
        this.name_en = string2;
        return this;
    }

    public FontListBean$FontBean setName_tw(String string2) {
        this.name_tw = string2;
        return this;
    }

    public void setRequiredPrime(int n10) {
        this.requiredPrime = n10;
    }

    public FontListBean$FontBean setSort(int n10) {
        this.sort = n10;
        return this;
    }

    public FontListBean$FontBean setThumb(String string2) {
        this.thumb = string2;
        return this;
    }

    public FontListBean$FontBean setZFilm(FontListBean$FontBean$PlatformBean fontListBean$FontBean$PlatformBean) {
        this.z_film = fontListBean$FontBean$PlatformBean;
        return this;
    }

    public FontListBean$FontBean setZy_play(FontListBean$FontBean$PlatformBean fontListBean$FontBean$PlatformBean) {
        this.zy_play = fontListBean$FontBean$PlatformBean;
        return this;
    }
}

