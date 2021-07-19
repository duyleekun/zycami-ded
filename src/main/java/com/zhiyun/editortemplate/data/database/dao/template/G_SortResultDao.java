/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.SortResultDao;
import e.a.i0;
import e.a.z;

public interface G_SortResultDao
extends SortResultDao {
    public LiveData getSortResult_LiveData(String var1);

    public z getSortResult_Observable(String var1);

    public i0 getSortResult_Single(String var1);
}

