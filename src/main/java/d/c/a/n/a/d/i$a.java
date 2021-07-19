/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.LruCache
 */
package d.c.a.n.a.d;

import android.graphics.Bitmap;
import android.util.LruCache;
import d.c.a.m.a$a;
import d.c.a.n.a.d.i;

public class i$a
extends LruCache {
    public final /* synthetic */ i a;

    public i$a(i i10, int n10) {
        this.a = i10;
        super(n10);
    }

    public void a(boolean bl2, Integer n10, Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            a$a a$a = i.p(this.a);
            a$a.a(bitmap);
        }
    }
}

