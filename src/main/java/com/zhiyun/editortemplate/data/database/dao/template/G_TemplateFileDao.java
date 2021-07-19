/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateFileDao;
import e.a.i0;
import e.a.z;
import java.util.List;

public interface G_TemplateFileDao
extends TemplateFileDao {
    public LiveData getAllFilePath_LiveData();

    public z getAllFilePath_Observable();

    public i0 getAllFilePath_Single();

    public LiveData getFileDataCount_LiveData(String var1);

    public z getFileDataCount_Observable(String var1);

    public i0 getFileDataCount_Single(String var1);

    public LiveData getFileData_LiveData(String var1);

    public z getFileData_Observable(String var1);

    public i0 getFileData_Single(String var1);

    public LiveData getFilePathsFromTemplateOnlyUse_LiveData(long var1);

    public z getFilePathsFromTemplateOnlyUse_Observable(long var1);

    public i0 getFilePathsFromTemplateOnlyUse_Single(long var1);

    public LiveData getFilePathsFromTemplates_LiveData(List var1);

    public z getFilePathsFromTemplates_Observable(List var1);

    public i0 getFilePathsFromTemplates_Single(List var1);

    public LiveData getUnuseFilePaths_LiveData();

    public z getUnuseFilePaths_Observable();

    public i0 getUnuseFilePaths_Single();
}

