/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;
import java.util.List;

public interface TransitionDataDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM transition_data";
    public static final String DELETE_ASSETS_TRANSITION = "DELETE FROM transition_data WHERE res_id < 0";
    public static final String DELETE_DOWNLOAD_TRANSITION = "DELETE FROM transition_data WHERE res_id > 0";
    public static final String GET_ALL_TRANSITION = "SELECT * FROM transition_data ORDER BY sort desc";

    public void deleteAll();

    public void deleteAssetsTransition();

    public void deleteDownloadTransition();

    public LiveData getAllTransitionData();

    default public LiveData getDistinctTransitionDataLiveData() {
        return Transformations.distinctUntilChanged(this.getAllTransitionData());
    }

    public List getTransitionDataByResId(int var1);

    public int updateTransitionPath(String var1, String var2);
}

