/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.downloader;

import com.tencent.liteav.network.f;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;

public class TXVodDownloadMediaInfo {
    public TXVodDownloadDataSource dataSource;
    public int downloadSize;
    public int duration;
    public boolean isStop;
    public f netApi;
    public String playPath;
    public float progress;
    public int size;
    public int tid = -1;
    public String url;

    public TXVodDownloadDataSource getDataSource() {
        return this.dataSource;
    }

    public int getDownloadSize() {
        return this.downloadSize;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getPlayPath() {
        return this.playPath;
    }

    public float getProgress() {
        int n10 = this.size;
        if (n10 > 0) {
            float f10 = this.downloadSize;
            float f11 = n10;
            return f10 / f11;
        }
        return 0.0f;
    }

    public int getSize() {
        return this.size;
    }

    public int getTaskId() {
        return this.tid;
    }

    public String getUrl() {
        return this.url;
    }
}

