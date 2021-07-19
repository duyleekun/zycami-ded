/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;

public interface AlbumDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM album_data";
    public static final String DELETE_ASSETS_ALBUM = "DELETE FROM album_data WHERE id < 0";
    public static final String DELETE_DOWNLOAD_ALBUM = "DELETE FROM album_data WHERE id >=0";
    public static final String GET_ALL_ALBUM = "SELECT * FROM album_data ORDER BY sort desc";

    public void deleteAll();

    public void deleteAssetsAlbum();

    public void deleteDownloadAlbum();

    public LiveData getAllAlbumDataLiveData();

    default public LiveData getDistinctAlbumDataLiveData() {
        return Transformations.distinctUntilChanged(this.getAllAlbumDataLiveData());
    }
}

