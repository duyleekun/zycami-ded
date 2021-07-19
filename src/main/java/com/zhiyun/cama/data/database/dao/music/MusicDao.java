/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;
import com.zhiyun.cama.data.database.model.music.MusicData;
import java.util.List;

public interface MusicDao
extends BaseDao {
    public static final String DELETE_ALBUM_MUSIC = "DELETE FROM music_data WHERE album_id = :albumId";
    public static final String DELETE_ALBUM_MUSIC_NO_ALBUM_ID = "DELETE FROM music_data WHERE album_id IS NULL";
    public static final String DELETE_ALBUM_MUSIC_NO_HASH = "DELETE FROM music_data WHERE album_id = :albumId AND hash IS NULL";
    public static final String DELETE_ALL = "DELETE FROM music_data";
    public static final String DELETE_ASSETS_MUSIC = "DELETE FROM music_data WHERE album_id < 0";
    public static final String DELETE_DOWNLOAD_ALBUM_MUSIC = "DELETE FROM music_data WHERE album_id >= 0 AND album_id = :albumId";
    public static final String DELETE_DOWNLOAD_MUSIC = "DELETE FROM music_data WHERE album_id > 0";
    public static final String DELETE_DOWNLOAD_MUSIC_BY_PATH = "DELETE FROM music_data WHERE path IN (:paths)";
    public static final String GET_ALBUM_ID_MUSIC = "SELECT * FROM music_data WHERE album_id = :albumId ORDER BY sort desc";
    public static final String GET_ALL_MUSIC = "SELECT * FROM music_data ORDER BY sort desc";
    public static final String GET_MUSIC_DATA_BY_HASH = "SELECT * FROM music_data WHERE hash = :hash";
    public static final String GET_NO_ALBUM_ID_MUSIC = "SELECT * FROM music_data WHERE album_id IS NULL ORDER BY sort desc";

    public void deleteAlbumMusic(long var1);

    public void deleteAlbumMusicNoHash(long var1);

    public void deleteAll();

    public void deleteAssetsMusic();

    public void deleteDownloadAlbumMusic(long var1);

    public void deleteDownloadMusic();

    public void deleteDownloadMusic(List var1);

    public void deleteMusicNoAlbumId();

    public LiveData getAllMusicDataLiveData();

    default public LiveData getDistinctMusicDataByAlbumIdLiveData(long l10) {
        return Transformations.distinctUntilChanged(this.getMusicDataByAlbumIdLiveData(l10));
    }

    default public LiveData getDistinctMusicDataLiveData() {
        return Transformations.distinctUntilChanged(this.getAllMusicDataLiveData());
    }

    default public LiveData getDistinctMusicDataNoAlbumIdLiveData() {
        return Transformations.distinctUntilChanged(this.getMusicDataNoAlbumIdLiveData());
    }

    public LiveData getMusicDataByAlbumIdLiveData(long var1);

    public MusicData getMusicDataByHash(String var1);

    public LiveData getMusicDataNoAlbumIdLiveData();

    default public void updateMusicPath(String string2, String object, long l10) {
        object = this.getMusicDataByHash((String)object);
        ((MusicData)object).setPath(string2);
        ((MusicData)object).setFileDownloadTimestamp(l10);
        this.update(object);
    }
}

