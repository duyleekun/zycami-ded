/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateMusicDao;
import e.a.i0;
import e.a.z;

public interface G_TemplateMusicDao
extends TemplateMusicDao {
    public LiveData getTemplateMusics_LiveData(long var1);

    public z getTemplateMusics_Observable(long var1);

    public i0 getTemplateMusics_Single(long var1);
}

