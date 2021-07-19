/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.io.IOException;
import k.a;
import k.b;
import k.d;
import k.f;
import k.i$b;
import k.r;

public class i$b$a
implements f {
    public final /* synthetic */ f a;
    public final /* synthetic */ i$b b;

    public i$b$a(i$b i$b, f f10) {
        this.b = i$b;
        this.a = f10;
    }

    private /* synthetic */ void a(f f10, Throwable throwable) {
        i$b i$b = this.b;
        f10.onFailure(i$b, throwable);
    }

    private /* synthetic */ void c(f f10, r object) {
        Object object2 = this.b.b;
        boolean bl2 = object2.isCanceled();
        if (bl2) {
            object = this.b;
            String string2 = "Canceled";
            object2 = new IOException(string2);
            f10.onFailure((d)object, (Throwable)object2);
        } else {
            object2 = this.b;
            f10.onResponse((d)object2, (r)object);
        }
    }

    public /* synthetic */ void b(f f10, Throwable throwable) {
        this.a(f10, throwable);
    }

    public /* synthetic */ void d(f f10, r r10) {
        this.c(f10, r10);
    }

    public void onFailure(d object, Throwable throwable) {
        object = this.b.a;
        f f10 = this.a;
        a a10 = new a(this, f10, throwable);
        object.execute(a10);
    }

    public void onResponse(d object, r r10) {
        object = this.b.a;
        f f10 = this.a;
        b b10 = new b(this, f10, r10);
        object.execute(b10);
    }
}

