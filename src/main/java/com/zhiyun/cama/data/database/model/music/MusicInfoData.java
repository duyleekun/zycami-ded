/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.music;

import java.util.Objects;

public class MusicInfoData {
    private String albumName;
    private int albumType;
    private long duration;
    private int id;
    private long importTimestamp;
    private String musicImage;
    private String musicName;
    private String musicPath;
    private String musicUrl;
    private long size;

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            object = (MusicInfoData)object;
            int n10 = this.albumType;
            int n11 = ((MusicInfoData)object).albumType;
            if (n10 != n11 || (n10 = (int)((l14 = (l13 = this.duration) - (l12 = ((MusicInfoData)object).duration)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0 || (n10 = (int)((l11 = (l13 = this.size) - (l12 = ((MusicInfoData)object).size)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0 || (n10 = (int)((l10 = (l13 = this.importTimestamp) - (l12 = ((MusicInfoData)object).importTimestamp)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 || (n10 = (int)(Objects.equals(object3 = this.musicName, object2 = ((MusicInfoData)object).musicName) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.albumName, object2 = ((MusicInfoData)object).albumName) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.musicPath, object2 = ((MusicInfoData)object).musicPath) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.musicUrl, object2 = ((MusicInfoData)object).musicUrl) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.musicImage, object = ((MusicInfoData)object).musicImage))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public int getAlbumType() {
        return this.albumType;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getId() {
        return this.id;
    }

    public long getImportTimestamp() {
        return this.importTimestamp;
    }

    public String getMusicImage() {
        return this.musicImage;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public String getMusicPath() {
        return this.musicPath;
    }

    public String getMusicUrl() {
        return this.musicUrl;
    }

    public long getSize() {
        return this.size;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.musicName, object = Integer.valueOf(this.albumType), object = this.albumName, object = this.musicPath, object = this.musicUrl, object = this.musicImage, object = Long.valueOf(this.duration), object = Long.valueOf(this.size), object = Long.valueOf(this.importTimestamp)};
        return Objects.hash(objectArray);
    }

    public void setAlbumName(String string2) {
        this.albumName = string2;
    }

    public void setAlbumType(int n10) {
        this.albumType = n10;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setImportTimestamp(long l10) {
        this.importTimestamp = l10;
    }

    public void setMusicImage(String string2) {
        this.musicImage = string2;
    }

    public void setMusicName(String string2) {
        this.musicName = string2;
    }

    public void setMusicPath(String string2) {
        this.musicPath = string2;
    }

    public void setMusicUrl(String string2) {
        this.musicUrl = string2;
    }

    public void setSize(long l10) {
        this.size = l10;
    }
}

