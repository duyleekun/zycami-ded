/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.ImageDecoder
 *  android.graphics.ImageDecoder$OnHeaderDecodedListener
 *  android.graphics.ImageDecoder$Source
 *  android.util.Log
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.m.a;
import d.c.a.o.m.d.g;

public final class f
extends a {
    private static final String d = "BitmapImageDecoder";
    private final e c;

    public f() {
        d.c.a.o.k.x.f f10 = new d.c.a.o.k.x.f();
        this.c = f10;
    }

    public s c(ImageDecoder.Source source, int n10, int n11, ImageDecoder.OnHeaderDecodedListener object) {
        Object object2;
        source = ImageDecoder.decodeBitmap((ImageDecoder.Source)source, (ImageDecoder.OnHeaderDecodedListener)object);
        object = d;
        boolean bl2 = Log.isLoggable((String)object, (int)2);
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Decoded [");
            int n12 = source.getWidth();
            stringBuilder.append(n12);
            String string2 = "x";
            stringBuilder.append(string2);
            int n13 = source.getHeight();
            stringBuilder.append(n13);
            String string3 = "] for [";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            stringBuilder.append(string2);
            stringBuilder.append(n11);
            stringBuilder.append("]");
            object2 = stringBuilder.toString();
            Log.v((String)object, (String)object2);
        }
        e e10 = this.c;
        object2 = new g((Bitmap)source, e10);
        return object2;
    }
}

