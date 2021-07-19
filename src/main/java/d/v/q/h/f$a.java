/*
 * Decompiled with CFR 0.151.
 */
package d.v.q.h;

import d.v.e.l.s1;
import d.v.q.h.f;
import g.d0;
import java.io.File;
import k.d;
import k.r;

public class f$a
implements k.f {
    public final /* synthetic */ File a;
    public final /* synthetic */ long b;
    public final /* synthetic */ f c;

    public f$a(f f10, File file, long l10) {
        this.c = f10;
        this.a = file;
        this.b = l10;
    }

    public void onFailure(d d10, Throwable throwable) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onResponse(d object, r object2) {
        boolean bl2;
        object = f.e(this.c);
        if (object != null) {
            Object object3;
            bl2 = false;
            object = null;
            try {
                object3 = ((r)object2).a();
                if (object3 != null) {
                    object3 = ((r)object2).a();
                    object3 = (d0)object3;
                    object = ((d0)object3).bytes();
                }
            }
            catch (Exception exception) {}
            object3 = f.e(this.c);
            int n10 = ((r)object2).b();
            object3.a(n10, (byte[])object);
        }
        f.f(this.c);
        object = this.c;
        object2 = this.a;
        long l10 = this.b;
        s1.h(f.g((f)object, (File)object2, l10));
        object = this.a.getName();
        object2 = ".copy";
        bl2 = ((String)object).contains((CharSequence)object2);
        if (bl2) {
            object = this.a;
            s1.g((File)object);
        }
    }
}

