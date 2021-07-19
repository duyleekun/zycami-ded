/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;

public interface TransitionFileDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM transition_file";
    public static final String DELETE_ALL_ASSETS_TRANSITION_FILE = "delete from transition_file where hash < 0";
    public static final String GET_ALL_TRANSITION_FILE = "select * from transition_file";

    public void deleteAll();

    public void deleteAllAssetsFile();

    public LiveData getAllTransitionFile();

    default public LiveData getDistinctTransitionFileLiveData() {
        return Transformations.distinctUntilChanged(this.getAllTransitionFile());
    }
}

