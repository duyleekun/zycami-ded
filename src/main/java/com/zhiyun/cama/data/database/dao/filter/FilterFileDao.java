/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.database.dao.BaseDao;

public interface FilterFileDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM filter_file";
    public static final String GET_ALL_FILTER_FILE = "SELECT * FROM filter_file";

    public void deleteAll();

    public LiveData getAllFilterFile();
}

