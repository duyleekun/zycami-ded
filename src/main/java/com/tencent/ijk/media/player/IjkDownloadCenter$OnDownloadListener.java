/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IjkDownloadCenter;
import com.tencent.ijk.media.player.IjkDownloadMedia;

public interface IjkDownloadCenter$OnDownloadListener {
    public void downloadBegin(IjkDownloadCenter var1, IjkDownloadMedia var2);

    public void downloadEnd(IjkDownloadCenter var1, IjkDownloadMedia var2);

    public void downloadError(IjkDownloadCenter var1, IjkDownloadMedia var2, int var3, String var4);

    public void downloadFinish(IjkDownloadCenter var1, IjkDownloadMedia var2);

    public void downloadProgress(IjkDownloadCenter var1, IjkDownloadMedia var2);

    public int hlsKeyVerify(IjkDownloadCenter var1, IjkDownloadMedia var2, String var3, byte[] var4);
}

