/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;
import com.zhiyun.cama.data.database.model.filter.FilterData;
import java.util.List;

public interface FilterDataDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM filter_data";
    public static final String DELETE_ASSETS_FILTER = "DELETE FROM filter_data WHERE res_id < 0";
    public static final String DELETE_DOWNLOAD_FILTER = "DELETE FROM filter_data WHERE res_id > 0";
    public static final String GET_ALL_FILTER = "SELECT * FROM filter_data ORDER BY main_sort desc,sort desc";
    public static final String UPDATE_FILTER_PATH = "UPDATE filter_data SET path = :path WHERE hash = :hash";
    public static final String UPDATE_FILTER_THUMB_PATH = "UPDATE filter_data SET thumb = :thumbPath WHERE hash = :hash";

    public void deleteAll();

    public void deleteAssetsFilter();

    public void deleteDownloadFilter();

    public LiveData getAllFilterData();

    default public LiveData getDistinctFilterDataLiveData() {
        return Transformations.distinctUntilChanged(this.getAllFilterData());
    }

    public FilterData getFilterDataByHash(String var1);

    public List getFilterDataByResId(int var1);

    public int updateFilterPath(String var1, String var2);

    public void updateFilterThumbPath(String var1, String var2);
}

