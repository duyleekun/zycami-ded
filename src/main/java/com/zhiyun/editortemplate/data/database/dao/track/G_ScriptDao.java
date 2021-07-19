/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptDao;
import e.a.i0;
import e.a.z;

public interface G_ScriptDao
extends ScriptDao {
    public LiveData getSmartMaxReferenceId_LiveData();

    public z getSmartMaxReferenceId_Observable();

    public i0 getSmartMaxReferenceId_Single();

    public LiveData getTemplatePOJOFromScriptId_LiveData(long var1);

    public z getTemplatePOJOFromScriptId_Observable(long var1);

    public i0 getTemplatePOJOFromScriptId_Single(long var1);

    public LiveData getTemplatePOJOFromSmartReferenceId_LiveData(long var1);

    public z getTemplatePOJOFromSmartReferenceId_Observable(long var1);

    public i0 getTemplatePOJOFromSmartReferenceId_Single(long var1);
}

