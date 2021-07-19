/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.filter;

import com.zhiyun.cama.data.api.entity.filter.FilterListBean$FilterBean$ZFilmBean;

public class FilterListBean$FilterBean {
    private int group_id;
    private String group_name;
    private String local_id;
    private int main_sort;
    private int requiredPrime;
    private int sort;
    private String thumb;
    private String title;
    private String title_en;
    private String title_tw;
    private int typeId;
    private FilterListBean$FilterBean$ZFilmBean z_film;

    public int getGroup_id() {
        return this.group_id;
    }

    public String getGroup_name() {
        return this.group_name;
    }

    public String getLocal_id() {
        return this.local_id;
    }

    public int getMain_sort() {
        return this.main_sort;
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

    public String getTitle() {
        return this.title;
    }

    public String getTitle_en() {
        return this.title_en;
    }

    public String getTitle_tw() {
        return this.title_tw;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public FilterListBean$FilterBean$ZFilmBean getZFilm() {
        return this.z_film;
    }

    public FilterListBean$FilterBean setGroup_id(int n10) {
        this.group_id = n10;
        return this;
    }

    public FilterListBean$FilterBean setGroup_name(String string2) {
        this.group_name = string2;
        return this;
    }

    public FilterListBean$FilterBean setLocal_id(String string2) {
        this.local_id = string2;
        return this;
    }

    public FilterListBean$FilterBean setMain_sort(int n10) {
        this.main_sort = n10;
        return this;
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

    public void setTypeId(int n10) {
        this.typeId = n10;
    }

    public void setZFilm(FilterListBean$FilterBean$ZFilmBean filterListBean$FilterBean$ZFilmBean) {
        this.z_film = filterListBean$FilterBean$ZFilmBean;
    }
}

