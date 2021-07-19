/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package d.v.c.s0;

import android.graphics.RectF;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import d.v.c.s0.w6;
import e.a.e1.b;
import m.a.a;

public class w6$a
extends b {
    public final /* synthetic */ Consumer b;
    public final /* synthetic */ Supplier c;
    public final /* synthetic */ w6 d;

    public w6$a(w6 w62, Consumer consumer, Supplier supplier) {
        this.d = w62;
        this.b = consumer;
        this.c = supplier;
    }

    public void b() {
        this.c(1L);
    }

    public void d(RectF object) {
        long l10 = 1L;
        try {
            Object object2 = this.d;
            ((w6)object2).b0((RectF)object);
            object2 = this.b;
            float f10 = 0.1f;
            object = w6.b(object, f10);
            object2.accept(object);
            object = this.d;
            object2 = this.c;
            w6.c((w6)object, (Supplier)object2);
            return;
        }
        finally {
            this.c(l10);
        }
    }

    public void onComplete() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("onComplete: ", objectArray);
    }

    public void onError(Throwable throwable) {
        this.b.accept(null);
        m.a.a.y(throwable);
    }
}

