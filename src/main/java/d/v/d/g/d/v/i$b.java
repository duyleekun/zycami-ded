/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.util.Size
 */
package d.v.d.g.d.v;

import android.media.ImageReader;
import android.os.Handler;
import android.util.Size;
import d.v.d.g.d.v.a;
import d.v.d.g.d.v.i;
import d.v.d.h.f;
import d.v.d.i.a.c$a;
import d.v.d.i.e.b;
import d.v.d.i.f.u;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class i$b
implements c$a {
    public final /* synthetic */ i a;

    public i$b(i i10) {
        this.a = i10;
    }

    private /* synthetic */ void b(ImageReader imageReader) {
        Object object = "receiver photo data";
        f.a((String)object);
        imageReader = imageReader.acquireNextImage();
        if (imageReader == null) {
            return;
        }
        object = imageReader.getPlanes()[0].getBuffer();
        byte[] byArray = new byte[((Buffer)object).remaining()];
        ((ByteBuffer)object).get(byArray);
        object = this.a.e1();
        boolean bl2 = i.a1(this.a);
        int n10 = i.b1(this.a);
        ((b)object).o(byArray, bl2, n10);
        imageReader.close();
    }

    public /* synthetic */ void c(ImageReader imageReader) {
        this.b(imageReader);
    }

    public void d(Size size, int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("photo size notify size=");
        ((StringBuilder)object).append(size);
        ((StringBuilder)object).append("\uff0cisPreviewIng=");
        u u10 = this.a.I();
        int n11 = u10.o();
        ((StringBuilder)object).append(n11 != 0);
        f.a(((StringBuilder)object).toString());
        object = this.a.I();
        n10 = (int)(((u)object).o() ? 1 : 0);
        if (n10 != 0) {
            i.W0(this.a);
            i.X0(this.a);
            return;
        }
        object = this.a;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        size = ImageReader.newInstance((int)n11, (int)n12, (int)256, (int)1);
        i.Z0((i)object, (ImageReader)size);
        size = i.Y0(this.a);
        object = new a(this);
        u10 = this.a.s();
        size.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)object, (Handler)u10);
    }
}

