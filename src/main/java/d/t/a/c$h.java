/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.t.a;

import android.net.Uri;
import d.t.a.c;
import d.t.a.f.a;

public class c$h
implements a {
    public final /* synthetic */ c a;

    public c$h(c c10) {
        this.a = c10;
    }

    public void a(Uri uri, int n10, int n11, int n12, int n13) {
        c c10 = this.a;
        float f10 = c.k(c10).getTargetAspectRatio();
        c10.C(uri, f10, n10, n11, n12, n13);
        this.a.finish();
    }

    public void b(Throwable throwable) {
        this.a.B(throwable);
        this.a.finish();
    }
}

