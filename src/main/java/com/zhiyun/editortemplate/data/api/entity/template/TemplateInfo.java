/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;
import com.zhiyun.net.BaseEntity;

public class TemplateInfo
extends BaseEntity {
    private TemplateInfoData data;

    public TemplateInfoData getData() {
        return this.data;
    }

    public void setData(TemplateInfoData templateInfoData) {
        this.data = templateInfoData;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateProtocol{data=");
        TemplateInfoData templateInfoData = this.data;
        stringBuilder.append(templateInfoData);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

