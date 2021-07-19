/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import java.util.List;

public interface TemplateStickerDao
extends BaseDao {
    public List getTemplateStick(long var1);

    default public void insertSticker(List list, long l10) {
        List list2 = this.getTemplateStick(l10);
        this.delete(list2);
        this.replace(list);
    }
}

