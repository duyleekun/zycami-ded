/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity;

import com.zhiyun.net.BaseEntity;
import java.util.List;

public class BaseInfoList
extends BaseEntity {
    private int count;
    private List list;

    public int getCount() {
        return this.count;
    }

    public List getList() {
        return this.list;
    }

    public void setCount(int n10) {
        this.count = n10;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateDataList{list=");
        Object object = this.list;
        stringBuilder.append(object);
        stringBuilder.append(", errcode=");
        int n10 = this.errcode;
        stringBuilder.append(n10);
        stringBuilder.append(", errmsg='");
        object = this.errmsg;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

