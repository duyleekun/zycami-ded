/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.d0;
import d.c.a.o.m.d.g;
import d.c.a.o.m.d.p$a;

public final class p {
    private static final String a = "DrawableToBitmap";
    private static final e b;

    static {
        p$a p$a = new p$a();
        b = p$a;
    }

    private p() {
    }

    public static s a(e e10, Drawable drawable2, int n10, int n11) {
        drawable2 = drawable2.getCurrent();
        boolean bl2 = drawable2 instanceof BitmapDrawable;
        boolean bl3 = false;
        if (bl2) {
            drawable2 = ((BitmapDrawable)drawable2).getBitmap();
        } else {
            bl2 = drawable2 instanceof Animatable;
            if (!bl2) {
                drawable2 = p.b(e10, drawable2, n10, n11);
                bl3 = true;
            } else {
                drawable2 = null;
            }
        }
        if (!bl3) {
            e10 = b;
        }
        return g.d((Bitmap)drawable2, e10);
    }

    private static Bitmap b(e object, Drawable object2, int n10, int n11) {
        int n12;
        Object object3 = "Unable to draw ";
        int n13 = 5;
        int n14 = -1 << -1;
        String string2 = a;
        if (n10 == n14 && (n12 = object2.getIntrinsicWidth()) <= 0) {
            boolean bl2 = Log.isLoggable((String)string2, (int)n13);
            if (bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(object2);
                object2 = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                Log.w((String)string2, (String)object);
            }
            return null;
        }
        if (n11 == n14 && (n14 = object2.getIntrinsicHeight()) <= 0) {
            boolean bl3 = Log.isLoggable((String)string2, (int)n13);
            if (bl3) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(object2);
                object2 = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                Log.w((String)string2, (String)object);
            }
            return null;
        }
        int n15 = object2.getIntrinsicWidth();
        if (n15 > 0) {
            n10 = object2.getIntrinsicWidth();
        }
        if ((n15 = object2.getIntrinsicHeight()) > 0) {
            n11 = object2.getIntrinsicHeight();
        }
        object3 = d0.i();
        object3.lock();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        object = object.f(n10, n11, config);
        try {
            config = new Canvas((Bitmap)object);
            n14 = 0;
            object2.setBounds(0, 0, n10, n11);
            object2.draw((Canvas)config);
            config.setBitmap(null);
            return object;
        }
        finally {
            object3.unlock();
        }
    }
}

