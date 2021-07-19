/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;

public interface FontFileDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM font_file";
    public static final String DELETE_ALL_ASSETS_FILE = "DELETE FROM font_file WHERE hash < 0";
    public static final String GET_ALL_FONT_FILE = "SELECT * FROM font_file";

    public void deleteAll();

    public void deleteAllAssetsFontFile();

    public LiveData getAllFontFile();

    default public LiveData getDistinctFontFileLiveData() {
        return Transformations.distinctUntilChanged(this.getAllFontFile());
    }
}

