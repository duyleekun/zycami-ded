/*
 * Decompiled with CFR 0.151.
 */
package d.r.a.s;

import d.r.a.s.e;
import d.r.a.u.s;
import java.lang.reflect.Method;

public final class e$a
implements Runnable {
    public final /* synthetic */ Method a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object[] c;
    public final /* synthetic */ e d;

    public e$a(e e10, Method method, Object object, Object[] objectArray) {
        this.d = e10;
        this.a = method;
        this.b = object;
        this.c = objectArray;
    }

    public final void run() {
        Method method;
        try {
            method = this.a;
        }
        catch (Exception exception) {
            s.i("CommandWorker", "reflect e: ", exception);
            return;
        }
        Object object = this.b;
        Object[] objectArray = this.c;
        method.invoke(object, objectArray);
    }
}

