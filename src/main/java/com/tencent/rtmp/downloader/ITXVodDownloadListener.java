/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.downloader;

import com.tencent.rtmp.downloader.TXVodDownloadMediaInfo;

public interface ITXVodDownloadListener {
    public int hlsKeyVerify(TXVodDownloadMediaInfo var1, String var2, byte[] var3);

    public void onDownloadError(TXVodDownloadMediaInfo var1, int var2, String var3);

    public void onDownloadFinish(TXVodDownloadMediaInfo var1);

    public void onDownloadProgress(TXVodDownloadMediaInfo var1);

    public void onDownloadStart(TXVodDownloadMediaInfo var1);

    public void onDownloadStop(TXVodDownloadMediaInfo var1);
}

