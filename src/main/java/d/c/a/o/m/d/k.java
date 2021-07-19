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
import java.nio.ByteBuffer;

public final class k
implements g {
    private final d.c.a.o.m.d.f a;

    public k() {
        d.c.a.o.m.d.f f10;
        this.a = f10 = new d.c.a.o.m.d.f();
    }

    public s c(ByteBuffer byteBuffer, int n10, int n11, f f10) {
        byteBuffer = ImageDecoder.createSource((ByteBuffer)byteBuffer);
        return this.a.d((ImageDecoder.Source)byteBuffer, n10, n11, f10);
    }

    public boolean d(ByteBuffer byteBuffer, f f10) {
        return true;
    }
}

