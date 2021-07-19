/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.net.BaseEntity;

public class TemplateResUrl
extends BaseEntity {
    private String downloadUrl;

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String string2) {
        this.downloadUrl = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateResUrl{downloadUrl='");
        String string2 = this.downloadUrl;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", errcode=");
        int n10 = this.errcode;
        stringBuilder.append(n10);
        stringBuilder.append(", errmsg='");
        String string3 = this.errmsg;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

