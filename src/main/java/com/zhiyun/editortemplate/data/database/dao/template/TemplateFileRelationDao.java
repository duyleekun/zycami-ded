/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import java.util.List;

public interface TemplateFileRelationDao
extends BaseDao {
    public static final String SELECT_DISTINCT_FILE_HASH = "SELECT DISTINCT file_hash FROM TemplateFileRelation";
    public static final String SELECT_FILE_HASH_FROM_TEMPLATE_DATA_ID = "SELECT file_hash FROM TemplateFileRelation GROUP BY file_hash HAVING COUNT(*) == 1 AND temp_id == :templateDataId";
    public static final String SELECT_FILE_HASH_FROM_TEMPLATE_DATA_IDS = "SELECT DISTINCT file_hash FROM TemplateFileRelation WHERE temp_id IN (:templateDataIds)";

    public void copyAndInsertRelation(long var1, long var3);

    public void deleteRelationFromTemplateData(long var1);

    public List loadRelationFromFile(String var1);

    public List loadRelationFromFile(List var1);

    public List loadRelationFromTemplate(long var1);

    public List loadRelationFromTemplate(List var1);
}

