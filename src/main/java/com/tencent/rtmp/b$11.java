/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.rtmp.TXLivePusher$ITXSnapshotListener;
import com.tencent.rtmp.b;

public class b$11
implements o {
    public final /* synthetic */ TXLivePusher$ITXSnapshotListener a;
    public final /* synthetic */ b b;

    public b$11(b b10, TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener) {
        this.b = b10;
        this.a = tXLivePusher$ITXSnapshotListener;
    }

    public void a(Bitmap bitmap) {
        Object object = this.b;
        TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener = this.a;
        com.tencent.rtmp.b.a((b)object, tXLivePusher$ITXSnapshotListener, bitmap);
        com.tencent.rtmp.b.a(this.b, false);
        bitmap = com.tencent.rtmp.b.d(this.b);
        object = com.tencent.rtmp.b.f(this.b);
        bitmap.removeCallbacks((Runnable)object);
    }
}

