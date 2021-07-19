/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.f;

import d.v.d.g.f.c;
import d.v.d.h.f;
import java.nio.ByteBuffer;

public class c$a
implements Runnable {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void run() {
        Object object;
        int n10;
        int n11 = c.a(this.a);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n11);
        while ((n10 = c.b((c)(object = this.a))) != 0) {
            byteBuffer.clear();
            object = c.c(this.a);
            n10 = object.read(byteBuffer, 4096);
            int n12 = -3;
            if (n10 != n12 && n10 != (n12 = -2)) {
                if (n10 < 0) continue;
                byteBuffer.position(n10);
                byteBuffer.flip();
                n10 = byteBuffer.remaining();
                object = new byte[n10];
                byteBuffer.get((byte[])object);
                c c10 = this.a;
                c.e(c10, (byte[])object);
                continue;
            }
            object = "audio record read error";
            f.a((String)object);
        }
        f.a("release audio record");
        c.f(this.a).clear();
        c.c(this.a).stop();
        c.c(this.a).release();
        c.d(this.a, null);
    }
}

