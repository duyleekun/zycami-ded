/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.util.Size
 */
package d.v.d.g.d.t;

import android.media.ImageReader;
import android.os.Handler;
import android.util.Size;
import d.v.d.g.d.t.a;
import d.v.d.g.d.t.f;
import d.v.d.i.a.c$a;
import d.v.d.i.e.b;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class f$a
implements c$a {
    public final /* synthetic */ f a;

    public f$a(f f10) {
        this.a = f10;
    }

    private /* synthetic */ void b(ImageReader imageReader) {
        Object object = "receiver photo data";
        d.v.d.h.f.a((String)object);
        imageReader = imageReader.acquireNextImage();
        if (imageReader == null) {
            return;
        }
        object = imageReader.getPlanes()[0].getBuffer();
        byte[] byArray = new byte[((Buffer)object).remaining()];
        ((ByteBuffer)object).get(byArray);
        object = this.a.Z0();
        boolean bl2 = f.X0(this.a);
        int n10 = (Integer)this.a.E().get();
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
        int n11 = this.a.I().o();
        ((StringBuilder)object).append(n11 != 0);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        size = ImageReader.newInstance((int)n11, (int)n12, (int)256, (int)1);
        f.W0((f)object, (ImageReader)size);
        size = f.V0(this.a);
        object = new a(this);
        Handler handler = this.a.s();
        size.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)object, handler);
    }
}

