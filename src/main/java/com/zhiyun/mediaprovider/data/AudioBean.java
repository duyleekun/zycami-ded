/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data;

import com.zhiyun.mediaprovider.data.MediaBean;

public class AudioBean
extends MediaBean {
    private String album;
    private String albumArtUri;
    private String artist;
    private long duration;
    private String title;

    public String getAlbum() {
        return this.album;
    }

    public String getAlbumArtUri() {
        return this.albumArtUri;
    }

    public String getArtist() {
        return this.artist;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getTitle() {
        return this.title;
    }

    public AudioBean setAlbum(String string2) {
        this.album = string2;
        return this;
    }

    public AudioBean setAlbumArtUri(String string2) {
        this.albumArtUri = string2;
        return this;
    }

    public AudioBean setArtist(String string2) {
        this.artist = string2;
        return this;
    }

    public AudioBean setDuration(long l10) {
        this.duration = l10;
        return this;
    }

    public AudioBean setTitle(String string2) {
        this.title = string2;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioBean{duration=");
        long l10 = this.duration;
        stringBuilder.append(l10);
        stringBuilder.append(", album='");
        String string2 = this.album;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", title='");
        String string3 = this.title;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", artist='");
        string3 = this.artist;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", albumArtUri='");
        string3 = this.albumArtUri;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

