/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;
import com.zhiyun.cama.data.database.model.music.MusicFile;
import d.v.c.v0.o.b.f.a;
import d.v.j.b;
import java.util.List;
import java.util.stream.Collectors;

public interface MusicFileDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM music_file";
    public static final String DELETE_ALL_ASSETS_FILE = "DELETE FROM music_file WHERE hash < 0";
    public static final String DELETE_DOWNLOAD_MUSIC_BY_PATH = "DELETE FROM music_file WHERE path IN (:paths)";
    public static final String GET_ALL_MUSIC_FILE = "SELECT * FROM music_file ORDER BY download_timestamp desc";

    public static /* synthetic */ boolean c(MusicFile musicFile) {
        return b.b(musicFile.getPath()) ^ true;
    }

    public static /* synthetic */ List f(List stream) {
        stream = stream.stream();
        Object object = d.v.c.v0.o.b.f.b.a;
        stream = stream.filter(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    public void deleteAll();

    public void deleteAllAssetsFile();

    public void deleteDownloadMusic(List var1);

    default public LiveData getAllDistinctMusicFileListLiveData() {
        LiveData liveData = this.getAllMusicFileListLiveData();
        a a10 = a.a;
        return Transformations.distinctUntilChanged(Transformations.map(liveData, a10));
    }

    public LiveData getAllMusicFileListLiveData();
}

