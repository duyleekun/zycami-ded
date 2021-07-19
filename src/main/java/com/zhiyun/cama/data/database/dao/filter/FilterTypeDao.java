/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;
import java.util.List;

public interface FilterTypeDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM filter_type";
    public static final String DELETE_ASSETS_FILTER_TYPE = "DELETE FROM filter_type WHERE res_id < 0";
    public static final String DELETE_DOWNLOAD_FILTER_TYPE = "DELETE FROM filter_type WHERE res_id > 0";
    public static final String GET_ALL_FILTER_TYPE = "SELECT * FROM filter_type ORDER BY sort desc";

    public void deleteAll();

    public void deleteAssetsFilterType();

    public void deleteDownloadFilterType();

    public LiveData getAllFilterTypeData();

    default public LiveData getDistinctFilterTypeDataLiveData() {
        return Transformations.distinctUntilChanged(this.getAllFilterTypeData());
    }

    public List getFilterTypeDataByResId(int var1);
}

