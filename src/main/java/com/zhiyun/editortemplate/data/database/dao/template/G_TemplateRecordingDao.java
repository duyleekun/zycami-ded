/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateRecordingDao;
import e.a.i0;
import e.a.z;

public interface G_TemplateRecordingDao
extends TemplateRecordingDao {
    public LiveData getTemplateRecording_LiveData(long var1);

    public z getTemplateRecording_Observable(long var1);

    public i0 getTemplateRecording_Single(long var1);
}

