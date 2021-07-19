/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDataSource
 */
package com.tencent.ijk.media.player;

import android.media.MediaDataSource;
import com.tencent.ijk.media.player.misc.IMediaDataSource;

public class AndroidMediaPlayer$MediaDataSourceProxy
extends MediaDataSource {
    private final IMediaDataSource mMediaDataSource;

    public AndroidMediaPlayer$MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
        this.mMediaDataSource = iMediaDataSource;
    }

    public void close() {
        this.mMediaDataSource.close();
    }

    public long getSize() {
        return this.mMediaDataSource.getSize();
    }

    public int readAt(long l10, byte[] byArray, int n10, int n11) {
        return this.mMediaDataSource.readAt(l10, byArray, n10, n11);
    }
}

