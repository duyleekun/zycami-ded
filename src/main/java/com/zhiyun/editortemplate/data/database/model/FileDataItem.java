/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.api.entity.template.FileDataBaseBean;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class FileDataItem {
    public boolean enable;
    public FileDataBaseBean entity;
    public EditConfig$ResourceType resourceType;

    public FileDataItem(EditConfig$ResourceType editConfig$ResourceType, FileDataBaseBean fileDataBaseBean) {
        this(editConfig$ResourceType, fileDataBaseBean, true);
    }

    public FileDataItem(EditConfig$ResourceType editConfig$ResourceType, FileDataBaseBean fileDataBaseBean, boolean bl2) {
        this.resourceType = editConfig$ResourceType;
        this.entity = fileDataBaseBean;
        this.enable = bl2;
    }

    public FileDataItem setData() {
        Object object = this.entity;
        if (object != null && (object = ((FileDataBaseBean)object).getFile()) != null) {
            EditConfig$ResourceType editConfig$ResourceType = this.resourceType;
            ((FileData)object).setCategory(editConfig$ResourceType);
        }
        return this;
    }
}

