/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;

public interface SortResultDao
extends BaseDao {
    public static final String SELECT_FROM_SORT_RESULT_WHERE_PAGE_TYPE_PAGE_TYPE = "SELECT * FROM SortResult WHERE page_type = :pageType";

    public SortResult getSortResult(String var1);
}

