/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.sticker;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.database.dao.BaseDao;

public interface StickerTypeDao
extends BaseDao {
    public static final String DELETE_ASSETS_STICKER_TYPE = "DELETE FROM sticker_type WHERE res_id < 0";
    public static final String DELETE_DOWNLOAD_STICKER_TYPE = "DELETE FROM sticker_type WHERE res_id > 0";
    public static final String GET_ALL_STICKER_TYPE = "SELECT * FROM sticker_type ORDER BY sort desc";

    public void deleteAssetsStickerType();

    public void deleteDownloadStickerType();

    public LiveData getAllStickerTypeData();
}

