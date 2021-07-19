/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateFileRelationDao;
import e.a.i0;
import e.a.z;
import java.util.List;

public interface G_TemplateFileRelationDao
extends TemplateFileRelationDao {
    public LiveData loadRelationFromFile_LiveData(String var1);

    public LiveData loadRelationFromFile_LiveData(List var1);

    public z loadRelationFromFile_Observable(String var1);

    public z loadRelationFromFile_Observable(List var1);

    public i0 loadRelationFromFile_Single(String var1);

    public i0 loadRelationFromFile_Single(List var1);

    public LiveData loadRelationFromTemplate_LiveData(long var1);

    public LiveData loadRelationFromTemplate_LiveData(List var1);

    public z loadRelationFromTemplate_Observable(long var1);

    public z loadRelationFromTemplate_Observable(List var1);

    public i0 loadRelationFromTemplate_Single(long var1);

    public i0 loadRelationFromTemplate_Single(List var1);
}

