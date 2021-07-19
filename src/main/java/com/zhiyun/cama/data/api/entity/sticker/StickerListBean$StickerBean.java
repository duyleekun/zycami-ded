/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.sticker;

import com.zhiyun.cama.data.api.entity.filter.FilterListBean$FilterBean$Ext;
import com.zhiyun.cama.data.api.entity.sticker.StickerListBean$StickerBean$PlatformBean;

public class StickerListBean$StickerBean {
    private FilterListBean$FilterBean$Ext ext;
    private int localId;
    private int requiredPrime;
    private int sort;
    private String thumb;
    private String title;
    private int typeId;
    private StickerListBean$StickerBean$PlatformBean z_film;
    private StickerListBean$StickerBean$PlatformBean zy_play;

    public FilterListBean$FilterBean$Ext getExt() {
        return this.ext;
    }

    public int getLocalId() {
        return this.localId;
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

    public int getTypeId() {
        return this.typeId;
    }

    public StickerListBean$StickerBean$PlatformBean getZ_film() {
        return this.z_film;
    }

    public StickerListBean$StickerBean$PlatformBean getZy_play() {
        return this.zy_play;
    }

    public void setExt(FilterListBean$FilterBean$Ext filterListBean$FilterBean$Ext) {
        this.ext = filterListBean$FilterBean$Ext;
    }

    public void setLocalId(int n10) {
        this.localId = n10;
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

    public void setTypeId(int n10) {
        this.typeId = n10;
    }

    public void setZ_film(StickerListBean$StickerBean$PlatformBean stickerListBean$StickerBean$PlatformBean) {
        this.z_film = stickerListBean$StickerBean$PlatformBean;
    }

    public void setZy_play(StickerListBean$StickerBean$PlatformBean stickerListBean$StickerBean$PlatformBean) {
        this.zy_play = stickerListBean$StickerBean$PlatformBean;
    }
}

