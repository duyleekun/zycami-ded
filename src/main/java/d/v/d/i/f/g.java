/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Image
 *  android.media.ImageReader
 *  d.v.d.h.b
 */
package d.v.d.i.f;

import android.media.Image;
import android.media.ImageReader;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.a.b;

public class g
extends a {
    public g() {
        b b10 = new b();
        this.a = b10;
    }

    public void b() {
        super.b();
    }

    public void n(ImageReader imageReader) {
        imageReader = imageReader.acquireNextImage();
        boolean bl2 = this.j();
        if (!bl2) {
            imageReader.close();
            return;
        }
        Object object = this.a;
        object = (b)object;
        Object object2 = d.v.d.h.b.d((Image)imageReader);
        try {
            ((b)object).c((byte[])object2);
            this.d();
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            String string2 = "set preview Data exception e=";
            ((StringBuilder)object2).append(string2);
            String string3 = exception.toString();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a(string3);
        }
        imageReader.close();
    }

    public void o(byte[] byArray) {
        boolean bl2 = this.j();
        if (!bl2) {
            return;
        }
        ((b)this.a).c(byArray);
        this.d();
    }
}

