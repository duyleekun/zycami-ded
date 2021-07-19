/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity;

import com.zhiyun.editortemplate.data.api.entity.FileResourceUrlBean$DataBean;
import com.zhiyun.net.BaseEntity;

public class FileResourceUrlBean
extends BaseEntity {
    private FileResourceUrlBean$DataBean data;

    public FileResourceUrlBean$DataBean getData() {
        return this.data;
    }

    public void setData(FileResourceUrlBean$DataBean fileResourceUrlBean$DataBean) {
        this.data = fileResourceUrlBean$DataBean;
    }
}

