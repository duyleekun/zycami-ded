/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.os.Build$VERSION
 *  android.util.LruCache
 */
package d.v.b0.c.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.LruCache;
import d.v.b0.c.e.a$a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a {
    private LruCache a;
    private Set b;

    public a() {
        HashSet hashSet;
        this.b = hashSet = new HashSet();
        int n10 = (int)(Runtime.getRuntime().maxMemory() / (long)8);
        a$a a$a = new a$a(this, n10);
        this.a = a$a;
    }

    private Bitmap c(int n10, int n11, Bitmap.Config config) {
        Bitmap bitmap = this.e(n10, n11, config);
        if (bitmap != null) {
            return bitmap;
        }
        return Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
    }

    private String d(int n10, int n11, int n12) {
        StringBuilder stringBuilder = new StringBuilder();
        n10 = n10 + n11 ^ n12;
        stringBuilder.append(n10);
        stringBuilder.append("");
        return stringBuilder.toString();
    }

    private Bitmap e(int n10, int n11, Bitmap.Config config) {
        boolean bl2;
        Iterator iterator2 = this.b.iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            LruCache lruCache = this.a;
            if ((string2 = (Bitmap)lruCache.get((Object)string2)) == null) {
                iterator2.remove();
                continue;
            }
            int n12 = string2.getWidth();
            if (n12 < n10 || (n12 = string2.getHeight()) < n11 || config != null && (lruCache = string2.getConfig()) != config) continue;
            return string2;
        }
        return null;
    }

    public Bitmap a(byte[] byArray, int n10, int n11) {
        Bitmap bitmap;
        int n12;
        int n13 = Build.VERSION.SDK_INT;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int n14 = 11;
        if (n13 > n14) {
            options.inJustDecodeBounds = n12 = 1;
            BitmapFactory.decodeByteArray((byte[])byArray, (int)n10, (int)n11, (BitmapFactory.Options)options);
            options.inMutable = n12;
            n12 = options.outWidth;
            int n15 = options.outHeight;
            Bitmap.Config config = options.inPreferredConfig;
            bitmap = this.c(n12, n15, config);
            if (bitmap != null) {
                options.inBitmap = bitmap;
            }
        }
        n12 = 0;
        bitmap = null;
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeByteArray((byte[])byArray, (int)n10, (int)n11, (BitmapFactory.Options)options);
        }
        catch (Exception exception) {
            if (n13 > n14) {
                n13 = 0;
                options.inBitmap = null;
            }
            return BitmapFactory.decodeByteArray((byte[])byArray, (int)n10, (int)n11, (BitmapFactory.Options)options);
        }
    }

    public Bitmap b(String string2) {
        Bitmap bitmap;
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int n12 = 11;
        if (n11 > n12) {
            options.inJustDecodeBounds = n10 = 1;
            BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)options);
            options.inMutable = n10;
            n10 = options.outWidth;
            int n13 = options.outHeight;
            Bitmap.Config config = options.inPreferredConfig;
            bitmap = this.c(n10, n13, config);
            if (bitmap != null) {
                options.inBitmap = bitmap;
            }
        }
        n10 = 0;
        bitmap = null;
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)options);
        }
        catch (Exception exception) {
            if (n11 > n12) {
                n11 = 0;
                options.inBitmap = null;
            }
            return BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)options);
        }
    }

    public Bitmap f(int n10, int n11, Bitmap.Config config) {
        return this.c(n10, n11, config);
    }

    public void g() {
        this.a.evictAll();
    }

    public void h(Bitmap bitmap) {
        int n10;
        if (bitmap != null && (n10 = bitmap.isRecycled()) == 0) {
            n10 = bitmap.getWidth();
            int n11 = bitmap.getHeight();
            int n12 = bitmap.hashCode();
            String string2 = this.d(n10, n11, n12);
            this.b.add(string2);
            LruCache lruCache = this.a;
            lruCache.put((Object)string2, (Object)bitmap);
        }
    }
}

