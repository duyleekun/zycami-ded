/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;
import java.util.List;

public interface StickerDataDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM sticker_data";
    public static final String DELETE_ASSETS_STICKER = "DELETE FROM sticker_data WHERE res_id < 0";
    public static final String DELETE_DOWNLOAD_STICKER = "DELETE FROM sticker_data WHERE res_id > 0";
    public static final String GET_ALL_STICKER = "SELECT * FROM sticker_data ORDER BY sort desc";
    public static final String UPDATE_STICKER_PATH = "UPDATE sticker_data SET path = :path WHERE hash = :hash";

    public void deleteAll();

    public void deleteAssetsSticker();

    public void deleteDownloadSticker();

    public void deleteDownloadStickerByType(int var1);

    public LiveData getAllStickerData();

    default public LiveData getDistinctStickerDataLiveData() {
        return Transformations.distinctUntilChanged(this.getAllStickerData());
    }

    public List getStickerDataByResId(int var1);

    public LiveData getStickerDataByType(int var1);

    public int updateStickerPath(String var1, String var2);
}

