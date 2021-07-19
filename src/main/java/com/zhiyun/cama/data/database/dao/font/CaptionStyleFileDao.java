/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;

public interface CaptionStyleFileDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM caption_style_file";
    public static final String DELETE_ALL_ASSETS_CAPTION_STYLE_FILE = "DELETE FROM caption_style_file WHERE hash < 0";
    public static final String GET_ALL_CAPTION_STYLE_FILE = "SELECT * FROM caption_style_file";

    public void deleteAll();

    public void deleteAllAssetsCaptionStyleFile();

    public LiveData getAllCaptionStyleFile();

    default public LiveData getDistinctCaptionStyleLiveData() {
        return Transformations.distinctUntilChanged(this.getAllCaptionStyleFile());
    }
}

