/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadCursor;

public interface DownloadIndex {
    public Download getDownload(String var1);

    public DownloadCursor getDownloads(int ... var1);
}

