/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.music;

import com.zhiyun.cama.data.database.model.music.MusicBeatData;
import java.util.List;

public interface MusicBeatDao {
    public static final String DELETE_MUSIC_BEAT_BY_PATH = "DELETE FROM music_beat_data WHERE music_path IN (:paths)";
    public static final String GET_MUSIC_DATA_BY_HASH = "SELECT * FROM music_beat_data WHERE music_path = :path";

    public int delete(MusicBeatData var1);

    public void deleteMusicBeatList(List var1);

    public MusicBeatData getMusicBeatDataByPath(String var1);

    public void insertMusicBeatData(MusicBeatData var1);

    public void update(MusicBeatData var1);
}

