/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.h;

import d.v.c.y1.h.j;
import d.v.e.l.l2;
import d.v.e.l.m2$a;
import d.v.j0.d;

public class j$a
implements m2$a {
    public final /* synthetic */ d a;
    public final /* synthetic */ j b;

    public j$a(j j10, d d10) {
        this.b = j10;
        this.a = d10;
    }

    public void a(Long object) {
        object = this.a;
        int n10 = object.isPlaying();
        if (n10 == 0) {
            return;
        }
        n10 = this.a.getCurrentPosition();
        int n11 = this.a.getDuration();
        float f10 = (float)n10 * 100.0f;
        float f11 = n11;
        int n12 = (int)(f10 / f11);
        this.b.n(n12);
        j j10 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        long l10 = n10;
        long l11 = 1000L;
        object = l2.b(l10 * l11);
        stringBuilder.append((String)object);
        stringBuilder.append("/");
        object = l2.b((long)n11 * l11);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        j10.m((String)object);
    }

    public void onComplete() {
    }
}

