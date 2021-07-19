/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Image
 */
package d.v.d.g.g.s;

import android.media.Image;
import com.huawei.camera.camerakit.ActionDataCallback;
import com.huawei.camera.camerakit.Mode;
import d.v.d.g.g.s.c;
import d.v.d.h.f;
import d.v.d.i.e.b;
import d.v.d.i.f.u;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class c$a
extends ActionDataCallback {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void onImageAvailable(Mode object, int n10, Image image) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onImageAvailable: getPreviewStatus=");
        Object object2 = c.w(this.a);
        ((StringBuilder)object).append(object2);
        f.a(((StringBuilder)object).toString());
        object = c.x(this.a);
        boolean n11 = ((u)object).o();
        if (!n11) {
            f.a("current is not preview ing");
            return;
        }
        int n12 = 1;
        if (n10 == n12) {
            object = image.getPlanes()[0].getBuffer();
            n10 = ((Buffer)object).remaining();
            byte[] byArray = new byte[n10];
            ((ByteBuffer)object).get(byArray);
            object = c.F(this.a).E0();
            object2 = this.a;
            boolean bl2 = c.D((c)object2);
            Integer n13 = (Integer)c.E(this.a).get();
            int n14 = n13;
            ((b)object).o(byArray, bl2, n14);
            image.close();
        }
    }
}

