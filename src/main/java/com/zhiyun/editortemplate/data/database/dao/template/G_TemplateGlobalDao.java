/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateGlobalDao;
import e.a.i0;
import e.a.z;

public interface G_TemplateGlobalDao
extends TemplateGlobalDao {
    public LiveData getTemplateGlobal_LiveData(long var1);

    public z getTemplateGlobal_Observable(long var1);

    public i0 getTemplateGlobal_Single(long var1);
}

