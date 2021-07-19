/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.Download;
import java.util.List;

public final class DownloadManager$DownloadUpdate {
    public final Download download;
    public final List downloads;
    public final Exception finalException;
    public final boolean isRemove;

    public DownloadManager$DownloadUpdate(Download download, boolean bl2, List list, Exception exception) {
        this.download = download;
        this.isRemove = bl2;
        this.downloads = list;
        this.finalException = exception;
    }
}

