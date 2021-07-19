/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.music;

import java.util.HashMap;

public class MusicBeatData {
    private HashMap beatMaps;
    private long id;
    private String musicPath;

    public MusicBeatData(String string2, HashMap hashMap) {
        this.musicPath = string2;
        this.beatMaps = hashMap;
    }

    public HashMap getBeatMaps() {
        return this.beatMaps;
    }

    public long getId() {
        return this.id;
    }

    public String getMusicPath() {
        return this.musicPath;
    }

    public void setBeatMaps(HashMap hashMap) {
        this.beatMaps = hashMap;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setMusicPath(String string2) {
        this.musicPath = string2;
    }
}

