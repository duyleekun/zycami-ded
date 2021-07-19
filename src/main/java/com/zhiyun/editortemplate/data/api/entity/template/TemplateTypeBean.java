/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import d.v.j.e.e.a;
import d.v.j.e.e.b;

public class TemplateTypeBean
implements b,
a {
    private int count;
    private long id;
    private Long local_id;
    private int sort;
    private String textEn;
    private String textZh;
    private String textZhTw;

    public int getCount() {
        return this.count;
    }

    public long getId() {
        return this.id;
    }

    public Long getLocal_id() {
        return this.local_id;
    }

    public long getRealTypeId() {
        long l10;
        Long l11 = this.getLocal_id();
        if (l11 == null) {
            l10 = this.getId();
        } else {
            l11 = this.getLocal_id();
            l10 = l11;
        }
        return l10;
    }

    public int getSort() {
        return this.sort;
    }

    public String getTextEn() {
        return this.textEn;
    }

    public String getTextZh() {
        return this.textZh;
    }

    public String getTextZhTw() {
        return this.textZhTw;
    }

    public void setCount(int n10) {
        this.count = n10;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setLocal_id(Long l10) {
        this.local_id = l10;
    }

    public void setSort(int n10) {
        this.sort = n10;
    }

    public void setTextEn(String string2) {
        this.textEn = string2;
    }

    public void setTextZh(String string2) {
        this.textZh = string2;
    }

    public void setTextZhTw(String string2) {
        this.textZhTw = string2;
    }
}

