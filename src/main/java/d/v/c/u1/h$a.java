/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1;

import d.v.c.u1.h;
import d.v.e.l.m2$a;
import d.v.j0.d;
import m.a.a;

public class h$a
implements m2$a {
    public final /* synthetic */ d a;
    public final /* synthetic */ h b;

    public h$a(h h10, d d10) {
        this.b = h10;
        this.a = d10;
    }

    public void a(Long l10) {
        int n10 = this.a.getCurrentPosition();
        int n11 = this.a.getDuration();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("currentPosition:");
        charSequence.append(n10);
        charSequence.append(",percent:");
        float f10 = n10;
        float f11 = 1.0f * f10;
        float f12 = n11;
        charSequence.append(f11 /= f12);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)charSequence, objectArray);
        n10 = (int)(f10 * 100.0f / f12);
        this.b.n(n10);
    }

    public void onComplete() {
    }
}

