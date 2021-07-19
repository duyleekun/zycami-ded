/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.scheduler.Requirements;

public interface DownloadManager$Listener {
    default public void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exception) {
    }

    default public void onDownloadRemoved(DownloadManager downloadManager, Download download) {
    }

    default public void onDownloadsPausedChanged(DownloadManager downloadManager, boolean bl2) {
    }

    default public void onIdle(DownloadManager downloadManager) {
    }

    default public void onInitialized(DownloadManager downloadManager) {
    }

    default public void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int n10) {
    }

    default public void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean bl2) {
    }
}

