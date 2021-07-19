/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package com.meishe.cafconvertor.webpcoder;

import android.graphics.Bitmap;
import d.m.a.g.a$e;
import java.util.HashSet;

public class WebpImageView$a
implements a$e {
    public HashSet a;

    public WebpImageView$a() {
        HashSet hashSet;
        this.a = hashSet = new HashSet();
    }

    public Bitmap a(int n10, int n11) {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = Bitmap.createBitmap((int)n10, (int)(n11 += 4), (Bitmap.Config)config);
        this.a.add(bitmap);
        return bitmap;
    }

    public void b(Bitmap object) {
        HashSet hashSet = this.a;
        boolean bl2 = hashSet.contains(object);
        if (bl2) {
            this.a.remove(object);
            object.recycle();
            return;
        }
        object = new IllegalStateException();
        throw object;
    }

    public void c() {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    public boolean d() {
        return this.a.isEmpty();
    }
}

