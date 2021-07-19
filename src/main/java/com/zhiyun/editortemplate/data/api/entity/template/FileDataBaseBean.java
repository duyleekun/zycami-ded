/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class FileDataBaseBean {
    public FileData file;
    public boolean isLocalSource;
    public String name;

    public FileData getFile() {
        return this.file;
    }

    public String getName() {
        return this.name;
    }

    public boolean isLocalSource() {
        return this.isLocalSource;
    }

    public void setFile(FileData fileData) {
        this.file = fileData;
    }

    public void setLocalSource(boolean bl2) {
        this.isLocalSource = bl2;
    }

    public void setName(String string2) {
        this.name = string2;
    }
}

