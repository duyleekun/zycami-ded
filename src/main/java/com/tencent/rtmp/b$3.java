/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.rtmp.TXLivePusher$ITXSnapshotListener;
import com.tencent.rtmp.b;

public class b$3
implements Runnable {
    public final /* synthetic */ TXLivePusher$ITXSnapshotListener a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ b c;

    public b$3(b b10, TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener, Bitmap bitmap) {
        this.c = b10;
        this.a = tXLivePusher$ITXSnapshotListener;
        this.b = bitmap;
    }

    public void run() {
        TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener = this.a;
        if (tXLivePusher$ITXSnapshotListener != null) {
            Bitmap bitmap = this.b;
            tXLivePusher$ITXSnapshotListener.onSnapshot(bitmap);
        }
    }
}

