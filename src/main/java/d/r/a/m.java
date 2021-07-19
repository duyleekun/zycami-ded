/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a;

import android.content.Context;
import d.r.a.h$o;
import d.r.a.l;
import d.r.a.o;
import d.r.a.u.s;

public abstract class m
implements Runnable {
    public Context a;
    public int b;
    private o c;

    public m(o object) {
        int n10;
        int n11;
        this.b = n11 = -1;
        this.c = object;
        this.b = n10 = ((o)object).a;
        if (n10 >= 0) {
            object = l.b().g;
            this.a = object;
            return;
        }
        object = new IllegalArgumentException("PushTask need a > 0 task id.");
        throw object;
    }

    public abstract void a(o var1);

    public final void run() {
        Object object;
        boolean bl2;
        Object object2 = this.a;
        if (object2 != null && !(bl2 = (object = this.c) instanceof h$o)) {
            object = new StringBuilder("[\u6267\u884c\u6307\u4ee4]");
            o o10 = this.c;
            ((StringBuilder)object).append(o10);
            object = ((StringBuilder)object).toString();
            s.e(object2, (String)object);
        }
        object2 = this.c;
        this.a((o)object2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append("{");
        object = this.c;
        object = object == null ? "[null]" : ((o)object).toString();
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

