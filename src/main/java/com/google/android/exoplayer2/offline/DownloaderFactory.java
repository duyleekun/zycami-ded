/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.Downloader;

public interface DownloaderFactory {
    public Downloader createDownloader(DownloadRequest var1);
}

