/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.BitmapRegionDecoder
 */
package com.tencent.rtmp.a;

import android.graphics.BitmapRegionDecoder;
import com.tencent.rtmp.a.b;

public class b$1
implements Runnable {
    public final /* synthetic */ b a;

    public b$1(b b10) {
        this.a = b10;
    }

    public void run() {
        Object object = b.a(this.a);
        if (object != null) {
            object = b.a(this.a);
            object.clear();
        }
        if ((object = b.b(this.a)) != null) {
            boolean bl2;
            object = b.b(this.a).values().iterator();
            while (bl2 = object.hasNext()) {
                BitmapRegionDecoder bitmapRegionDecoder = (BitmapRegionDecoder)object.next();
                if (bitmapRegionDecoder == null) continue;
                bitmapRegionDecoder.recycle();
            }
            object = b.b(this.a);
            object.clear();
        }
    }
}

