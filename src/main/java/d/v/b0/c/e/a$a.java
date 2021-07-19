/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.LruCache
 */
package d.v.b0.c.e;

import android.graphics.Bitmap;
import android.util.LruCache;
import d.v.b0.c.e.a;

public class a$a
extends LruCache {
    public final /* synthetic */ a a;

    public a$a(a a10, int n10) {
        this.a = a10;
        super(n10);
    }

    public void a(boolean bl2, String string2, Bitmap bitmap, Bitmap bitmap2) {
        super.entryRemoved(bl2, (Object)string2, (Object)bitmap, (Object)bitmap2);
        if (bitmap != null && !(bl2 = bitmap.isRecycled()) && bitmap != bitmap2) {
            bitmap.recycle();
        }
    }

    public int b(String string2, Bitmap bitmap) {
        return bitmap.getByteCount();
    }
}

