/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import e.a.i0;
import java.util.List;

public interface TemplateFileDao
extends BaseDao {
    public i0 deleteAllFile();

    public int deleteFile(List var1);

    public List getAllFilePath();

    public FileData getFileData(String var1);

    public int getFileDataCount(String var1);

    public List getFilePathsFromTemplateOnlyUse(long var1);

    public List getFilePathsFromTemplates(List var1);

    public List getUnuseFilePaths();
}

