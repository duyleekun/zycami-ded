/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;
import java.util.List;

public interface FontDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM font_data";
    public static final String DELETE_ASSETS_FONT = "DELETE FROM font_data WHERE res_id < 0";
    public static final String DELETE_DOWNLOAD_FONT = "DELETE FROM font_data WHERE res_id > 0";
    public static final String GET_ALL_FONT = "SELECT * FROM font_data ORDER BY sort desc";
    public static final String UPDATE_FONT_PATH = "UPDATE font_data SET path = :path WHERE hash = :hash";

    public void deleteAll();

    public void deleteAssetsFont();

    public void deleteDownloadFont();

    public LiveData getAllFontData();

    default public LiveData getDistinctFontDataLiveData() {
        return Transformations.distinctUntilChanged(this.getAllFontData());
    }

    public List getFontDataByResId(int var1);

    public int updateFontPath(String var1, String var2);
}

