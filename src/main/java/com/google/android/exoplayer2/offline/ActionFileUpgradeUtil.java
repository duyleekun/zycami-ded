/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.ActionFile;
import com.google.android.exoplayer2.offline.ActionFileUpgradeUtil$DownloadIdProvider;
import com.google.android.exoplayer2.offline.DefaultDownloadIndex;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadRequest;
import java.io.File;

public final class ActionFileUpgradeUtil {
    private ActionFileUpgradeUtil() {
    }

    public static void mergeRequest(DownloadRequest downloadRequest, DefaultDownloadIndex defaultDownloadIndex, boolean bl2, long l10) {
        Object object = downloadRequest.id;
        if ((object = defaultDownloadIndex.getDownload((String)object)) != null) {
            int n10 = ((Download)object).stopReason;
            object = DownloadManager.mergeRequest((Download)object, downloadRequest, n10, l10);
        } else {
            Download download;
            int n11;
            if (bl2) {
                n11 = 3;
            } else {
                n11 = 0;
                object = null;
            }
            int n12 = n11;
            long l11 = -1;
            object = download;
            download = new Download(downloadRequest, n11, l10, l10, l11, 0, 0);
        }
        defaultDownloadIndex.putDownload((Download)object);
    }

    public static void upgradeAndDelete(File downloadRequestArray, ActionFileUpgradeUtil$DownloadIdProvider actionFileUpgradeUtil$DownloadIdProvider, DefaultDownloadIndex defaultDownloadIndex, boolean bl2, boolean bl3) {
        ActionFile actionFile = new ActionFile((File)downloadRequestArray);
        boolean bl4 = actionFile.exists();
        if (bl4) {
            int n10;
            long l10 = System.currentTimeMillis();
            downloadRequestArray = actionFile.load();
            try {
                n10 = downloadRequestArray.length;
            }
            catch (Throwable throwable) {
                if (bl2) {
                    actionFile.delete();
                }
                throw throwable;
            }
            for (int i10 = 0; i10 < n10; ++i10) {
                DownloadRequest downloadRequest;
                block11: {
                    downloadRequest = downloadRequestArray[i10];
                    if (actionFileUpgradeUtil$DownloadIdProvider == null) break block11;
                    String string2 = actionFileUpgradeUtil$DownloadIdProvider.getId(downloadRequest);
                    downloadRequest = downloadRequest.copyWithId(string2);
                }
                ActionFileUpgradeUtil.mergeRequest(downloadRequest, defaultDownloadIndex, bl3, l10);
                continue;
            }
            actionFile.delete();
        }
    }
}

