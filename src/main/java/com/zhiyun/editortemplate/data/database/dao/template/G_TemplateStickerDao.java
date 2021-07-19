/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateStickerDao;
import e.a.i0;
import e.a.z;

public interface G_TemplateStickerDao
extends TemplateStickerDao {
    public LiveData getTemplateStick_LiveData(long var1);

    public z getTemplateStick_Observable(long var1);

    public i0 getTemplateStick_Single(long var1);
}

