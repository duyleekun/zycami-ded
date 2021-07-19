/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadIndex;

public interface WritableDownloadIndex
extends DownloadIndex {
    public void putDownload(Download var1);

    public void removeDownload(String var1);

    public void setDownloadingStatesToQueued();

    public void setStatesToRemoving();

    public void setStopReason(int var1);

    public void setStopReason(String var1, int var2);
}

