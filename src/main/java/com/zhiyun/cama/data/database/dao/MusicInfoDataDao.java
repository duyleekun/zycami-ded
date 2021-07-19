/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.dao.BaseDao;
import com.zhiyun.cama.data.database.model.music.MusicInfoData;
import d.v.c.v0.o.b.c;
import d.v.c.v0.o.b.d;
import d.v.j.b;
import java.util.List;
import java.util.stream.Collectors;

public interface MusicInfoDataDao
extends BaseDao {
    public static final String DELETE_ALL = "DELETE FROM music_info_data";

    public static /* synthetic */ List d(List stream) {
        stream = stream.stream();
        Object object = c.a;
        stream = stream.filter(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    public static /* synthetic */ boolean e(MusicInfoData musicInfoData) {
        return b.b(musicInfoData.getMusicPath()) ^ true;
    }

    public void deleteAll();

    public void deleteMusicInfoDataByPath(List var1);

    default public LiveData getAllExistMusicInfoDataList() {
        LiveData liveData = this.getAllMusicInfoDataList();
        d d10 = d.a;
        return Transformations.map(liveData, d10);
    }

    public LiveData getAllMusicInfoDataList();

    public LiveData getMusicInfoDataListByAlbumType(int var1);

    public List getMusicInfoDataListByMusicName(String var1);

    public LiveData getMusicInfoDataLiveDataByMusicName(String var1);
}

