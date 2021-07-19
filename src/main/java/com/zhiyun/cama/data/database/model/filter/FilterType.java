/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.filter;

import com.zhiyun.cama.data.database.model.ResourceData;

public class FilterType
extends ResourceData {
    private String thumb;

    public FilterType() {
    }

    public FilterType(long l10, String string2, String string3, String string4, int n10, String string5) {
        super(l10, string2, string3, string4, n10);
        this.thumb = string5;
    }

    public FilterType(String string2) {
        this.thumb = string2;
    }

    public FilterType clone() {
        ResourceData resourceData = super.clone();
        long l10 = resourceData.getResId();
        String string2 = resourceData.getLabel();
        String string3 = resourceData.getLabel_tw();
        String string4 = resourceData.getLabel_en();
        int n10 = resourceData.getSort();
        String string5 = this.thumb;
        FilterType filterType = new FilterType(l10, string2, string3, string4, n10, string5);
        return filterType;
    }

    public String getThumb() {
        return this.thumb;
    }

    public void setThumb(String string2) {
        this.thumb = string2;
    }
}

