/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.transition;

import com.zhiyun.cama.data.api.entity.transition.TransitionListBean$TransitionBean$PlatformBean;

public class TransitionListBean$TransitionBean {
    private int requiredPrime;
    private int sort;
    private String thumb;
    private String title;
    private String title_en;
    private String title_tw;
    private TransitionListBean$TransitionBean$PlatformBean z_film;
    private TransitionListBean$TransitionBean$PlatformBean zy_play;

    public int getRequiredPrime() {
        return this.requiredPrime;
    }

    public int getSort() {
        return this.sort;
    }

    public String getThumb() {
        return this.thumb;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitle_en() {
        return this.title_en;
    }

    public String getTitle_tw() {
        return this.title_tw;
    }

    public TransitionListBean$TransitionBean$PlatformBean getZ_film() {
        return this.z_film;
    }

    public TransitionListBean$TransitionBean$PlatformBean getZy_play() {
        return this.zy_play;
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

    public void setTitle(String string2) {
        this.title = string2;
    }

    public void setTitle_en(String string2) {
        this.title_en = string2;
    }

    public void setTitle_tw(String string2) {
        this.title_tw = string2;
    }

    public void setZ_film(TransitionListBean$TransitionBean$PlatformBean transitionListBean$TransitionBean$PlatformBean) {
        this.z_film = transitionListBean$TransitionBean$PlatformBean;
    }

    public void setZy_play(TransitionListBean$TransitionBean$PlatformBean transitionListBean$TransitionBean$PlatformBean) {
        this.zy_play = transitionListBean$TransitionBean$PlatformBean;
    }
}

