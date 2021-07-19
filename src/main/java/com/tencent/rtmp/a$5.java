/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener;
import com.tencent.rtmp.a;

public class a$5
implements Runnable {
    public final /* synthetic */ TXLivePlayer$ITXSnapshotListener a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ a c;

    public a$5(a a10, TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener, Bitmap bitmap) {
        this.c = a10;
        this.a = tXLivePlayer$ITXSnapshotListener;
        this.b = bitmap;
    }

    public void run() {
        TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener = this.a;
        if (tXLivePlayer$ITXSnapshotListener != null) {
            Bitmap bitmap = this.b;
            tXLivePlayer$ITXSnapshotListener.onSnapshot(bitmap);
        }
        com.tencent.rtmp.a.a(this.c, false);
    }
}

