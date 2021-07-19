/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.Downloader$ProgressListener;

public interface Downloader {
    public void cancel();

    public void download(Downloader$ProgressListener var1);

    public void remove();
}

