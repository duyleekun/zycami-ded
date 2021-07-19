/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.sticker;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class StickerFile
extends FileData {
    public StickerFile(FileData object) {
        super((FileData)object);
        object = EditConfig$ResourceType.STICKER;
        this.setCategory((EditConfig$ResourceType)object);
    }

    public StickerFile(String string2, String string3, String string4, int n10, String string5, String string6, long l10) {
        EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.STICKER;
        super(string2, string3, editConfig$ResourceType, string4, n10, string5, string6, l10);
    }
}

