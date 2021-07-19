/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;
import java.util.List;

public interface CaptionStyleDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM caption_style_data";
    public static final String DELETE_ASSETS_CAPTION_STYLE = "DELETE FROM caption_style_data WHERE res_id < 0";
    public static final String DELETE_DOWNLOAD_CAPTION_STYLE = "DELETE FROM caption_style_data WHERE res_id > 0";
    public static final String GET_ALL_CAPTION_STYLE = "SELECT * FROM caption_style_data ORDER BY sort desc";
    public static final String UPDATE_CAPTION_PATH = "UPDATE caption_style_data SET path = :path WHERE hash = :hash";

    public void deleteAll();

    public void deleteAssetsCaptionStyle();

    public void deleteDownloadCaptionStyle();

    public LiveData getAllCaptionStyleData();

    public List getCaptionStyleDataByResId(int var1);

    default public LiveData getDistinctCaptionStyleDataLiveData() {
        return Transformations.distinctUntilChanged(this.getAllCaptionStyleData());
    }

    public int updateCaptionPath(String var1, String var2);
}

