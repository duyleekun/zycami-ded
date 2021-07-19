/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.util.Size
 */
package d.v.d.g.d.u;

import android.media.ImageReader;
import android.os.Handler;
import android.util.Size;
import d.v.d.g.d.u.a;
import d.v.d.g.d.u.e;
import d.v.d.h.f;
import d.v.d.i.a.c$a;
import d.v.d.i.e.b;
import d.v.d.i.f.u;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class e$b
implements c$a {
    public final /* synthetic */ e a;

    public e$b(e e10) {
        this.a = e10;
    }

    private /* synthetic */ void b(ImageReader object) {
        Object object2 = "receiver photo data";
        f.a((String)object2);
        object = object.acquireNextImage();
        if (object == null) {
            return;
        }
        object2 = object.getPlanes()[0].getBuffer();
        byte[] byArray = new byte[((Buffer)object2).remaining()];
        ((ByteBuffer)object2).get(byArray);
        object.close();
        object = this.a.c1();
        boolean bl2 = e.a1(this.a);
        int n10 = this.a.r();
        ((b)object).o(byArray, bl2, n10);
    }

    public /* synthetic */ void c(ImageReader imageReader) {
        this.b(imageReader);
    }

    public void d(Size object, int n10) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("photo size notify size=");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append("\uff0cisPreviewIng=");
        int n11 = this.a.I().o();
        ((StringBuilder)object2).append(n11 != 0);
        f.a(((StringBuilder)object2).toString());
        object2 = this.a;
        n11 = object.getWidth();
        int n12 = object.getHeight();
        int n13 = 256;
        int n14 = 1;
        object = ImageReader.newInstance((int)n11, (int)n12, (int)n13, (int)n14);
        e.X0((e)object2, (ImageReader)object);
        object = e.W0(this.a);
        object2 = new a(this);
        Handler handler = this.a.s();
        object.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)object2, handler);
        object = new StringBuilder();
        ((StringBuilder)object).append("photo size notify isPreviewIng=");
        object2 = this.a.I();
        n10 = (int)(((u)object2).o() ? 1 : 0);
        ((StringBuilder)object).append(n10 != 0);
        f.a(((StringBuilder)object).toString());
        object = this.a.I();
        n12 = (int)(((u)object).o() ? 1 : 0);
        if (n12 != 0) {
            object = this.a.R();
            n10 = 4;
            object2 = n10;
            ((d.v.d.i.b.e)object).n((Integer)object2);
            e.Y0(this.a);
            object = this.a;
            e.Z0((e)object);
        }
    }
}

