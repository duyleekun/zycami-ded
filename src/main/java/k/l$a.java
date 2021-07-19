/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.c0;
import g.e;
import java.io.IOException;
import k.f;
import k.l;
import k.r;
import k.w;

public class l$a
implements g.f {
    public final /* synthetic */ f a;
    public final /* synthetic */ l b;

    public l$a(l l10, f f10) {
        this.b = l10;
        this.a = f10;
    }

    private void a(Throwable throwable) {
        f f10 = this.a;
        l l10 = this.b;
        try {
            f10.onFailure(l10, throwable);
        }
        catch (Throwable throwable2) {
            w.s(throwable2);
            throwable2.printStackTrace();
        }
    }

    public void onFailure(e e10, IOException iOException) {
        this.a(iOException);
    }

    public void onResponse(e object, c0 object2) {
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            w.s(throwable);
            this.a(throwable);
            return;
        }
        object = ((l)object).d((c0)object2);
        object2 = this.a;
        l l10 = this.b;
        try {
            object2.onResponse(l10, (r)object);
        }
        catch (Throwable throwable) {
            w.s(throwable);
            throwable.printStackTrace();
        }
    }
}

