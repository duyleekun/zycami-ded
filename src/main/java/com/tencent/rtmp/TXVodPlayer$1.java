/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener;
import com.tencent.rtmp.TXVodPlayer;

public class TXVodPlayer$1
implements Runnable {
    public final /* synthetic */ TXLivePlayer$ITXSnapshotListener a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ TXVodPlayer c;

    public TXVodPlayer$1(TXVodPlayer tXVodPlayer, TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener, Bitmap bitmap) {
        this.c = tXVodPlayer;
        this.a = tXLivePlayer$ITXSnapshotListener;
        this.b = bitmap;
    }

    public void run() {
        TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener = this.a;
        if (tXLivePlayer$ITXSnapshotListener != null) {
            Bitmap bitmap = this.b;
            tXLivePlayer$ITXSnapshotListener.onSnapshot(bitmap);
        }
        TXVodPlayer.access$002(this.c, false);
    }
}

