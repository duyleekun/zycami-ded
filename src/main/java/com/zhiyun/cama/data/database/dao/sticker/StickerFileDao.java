/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;

public interface StickerFileDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM sticker_file";
    public static final String DELETE_ALL_ASSETS_STICKER_FILE = "delete from sticker_file where hash < 0";
    public static final String GET_ALL_STICKER_FIL = "select * from sticker_file";

    public void deleteAll();

    public void deleteAllAssetsFile();

    public LiveData getAllStickerFile();

    default public LiveData getDistinctStickerFileLiveData() {
        return Transformations.distinctUntilChanged(this.getAllStickerFile());
    }
}

