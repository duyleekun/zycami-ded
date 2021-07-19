/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.util.Size
 */
package d.v.d.g.d;

import android.media.ImageReader;
import android.os.Handler;
import android.util.Size;
import d.v.d.g.d.o;
import d.v.d.h.f;
import d.v.d.i.a.c$a;

public class o$a
implements c$a {
    public final /* synthetic */ o a;

    public o$a(o o10) {
        this.a = o10;
    }

    public void b(Size object, int n10) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("preview size notify zySize=");
        ((StringBuilder)object2).append(object);
        f.a(((StringBuilder)object2).toString());
        object2 = this.a;
        int n11 = object.getWidth();
        int n12 = object.getHeight();
        object = ImageReader.newInstance((int)n11, (int)n12, (int)35, (int)2);
        ((o)object2).d = object;
        object = this.a;
        object2 = object.d;
        object = o.a((o)object);
        Handler handler = this.a.s();
        object2.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)object, handler);
    }
}

