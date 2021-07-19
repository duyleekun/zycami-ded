/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener;
import com.tencent.rtmp.a;

public class a$1
implements o {
    public final /* synthetic */ TXLivePlayer$ITXSnapshotListener a;
    public final /* synthetic */ a b;

    public a$1(a a10, TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener) {
        this.b = a10;
        this.a = tXLivePlayer$ITXSnapshotListener;
    }

    public void a(Bitmap bitmap) {
        a a10 = this.b;
        TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener = this.a;
        com.tencent.rtmp.a.a(a10, tXLivePlayer$ITXSnapshotListener, bitmap);
    }
}

