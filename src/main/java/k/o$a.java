/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package k;

import android.os.Build;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import k.o;
import k.o$a$a;

public final class o$a
extends o {
    public o$a() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        n10 = n10 >= n11 ? 1 : 0;
        super(n10 != 0);
    }

    public Executor c() {
        o$a$a o$a$a = new o$a$a();
        return o$a$a;
    }

    public Object h(Method object, Class clazz, Object object2, Object ... objectArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return super.h((Method)object, clazz, object2, objectArray);
        }
        object = new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        throw object;
    }
}

