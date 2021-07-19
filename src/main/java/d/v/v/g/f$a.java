/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.g;

import d.v.h.e.a;
import d.v.h.e.d;
import d.v.h.e.g;
import d.v.v.g.f;
import d.v.v.q.g$b;

public class f$a
implements g$b {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ d b;
    public final /* synthetic */ int c;
    public final /* synthetic */ g d;
    public final /* synthetic */ f e;

    public f$a(f f10, boolean bl2, d d10, int n10, g g10) {
        this.e = f10;
        this.a = bl2;
        this.b = d10;
        this.c = n10;
        this.d = g10;
    }

    public void onCancel() {
        g g10 = this.d;
        if (g10 != null) {
            g10.cancel();
        }
    }

    public void onError(String string2) {
        g g10 = this.d;
        if (g10 != null) {
            g10.a(string2);
        }
    }

    public void onProgress(float f10) {
        g g10 = this.d;
        if (g10 != null) {
            g10.c(f10);
        }
    }

    public void onSuccess(String object) {
        String string2 = "unKnow error";
        if (object != null) {
            Object object2;
            int n10 = this.a;
            if (n10 != 0) {
                object2 = this.b;
                ((a)object2).l((String)object);
            } else {
                object2 = this.b;
                ((a)object2).o((String)object);
            }
            object = this.e;
            n10 = this.c;
            boolean bl2 = f.a((f)object, n10);
            object2 = this.d;
            if (object2 != null) {
                if (bl2) {
                    object = this.b.E();
                    object2.b((String)object);
                } else {
                    object2.a(string2);
                }
            }
        } else {
            object = this.d;
            if (object != null) {
                object.a(string2);
            }
        }
    }
}

