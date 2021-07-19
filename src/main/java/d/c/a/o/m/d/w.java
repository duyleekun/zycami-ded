/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.ImageDecoder
 *  android.graphics.ImageDecoder$Source
 */
package d.c.a.o.m.d;

import android.graphics.ImageDecoder;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.u.a;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class w
implements g {
    private final d.c.a.o.m.d.f a;

    public w() {
        d.c.a.o.m.d.f f10;
        this.a = f10 = new d.c.a.o.m.d.f();
    }

    public s c(InputStream inputStream, int n10, int n11, f f10) {
        inputStream = ImageDecoder.createSource((ByteBuffer)d.c.a.u.a.b(inputStream));
        return this.a.d((ImageDecoder.Source)inputStream, n10, n11, f10);
    }

    public boolean d(InputStream inputStream, f f10) {
        return true;
    }
}

