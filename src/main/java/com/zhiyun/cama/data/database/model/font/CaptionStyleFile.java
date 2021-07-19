/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.font;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class CaptionStyleFile
extends FileData {
    public CaptionStyleFile() {
    }

    public CaptionStyleFile(FileData object) {
        super((FileData)object);
        object = EditConfig$ResourceType.CAPTION;
        this.setCategory((EditConfig$ResourceType)object);
    }

    public CaptionStyleFile(String string2, String string3, String string4, int n10, String string5, String string6, long l10) {
        EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.CAPTION;
        super(string2, string3, editConfig$ResourceType, string4, n10, string5, string6, l10);
    }
}

