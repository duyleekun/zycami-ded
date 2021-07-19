/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Image
 */
package d.v.d.g.g.q;

import android.media.Image;
import com.huawei.camera.camerakit.ActionDataCallback;
import com.huawei.camera.camerakit.Mode;
import d.v.d.g.g.q.c;
import d.v.d.h.f;
import d.v.d.i.e.b;
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
        Object object2 = "onImageAvailable: type=";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        f.a((String)object);
        int n11 = 1;
        if (n11 == n10) {
            object = image.getPlanes()[0].getBuffer();
            n10 = ((Buffer)object).remaining();
            byte[] byArray = new byte[n10];
            ((ByteBuffer)object).get(byArray);
            object = c.B(this.a).E0();
            object2 = this.a;
            boolean bl2 = c.w((c)object2);
            Integer n12 = (Integer)c.x(this.a).get();
            int n13 = n12;
            ((b)object).o(byArray, bl2, n13);
            image.close();
        }
    }
}

