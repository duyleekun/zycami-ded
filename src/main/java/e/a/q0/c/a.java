/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package e.a.q0.c;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import e.a.h0;
import e.a.q0.c.a$a;
import e.a.q0.c.b;
import java.util.Objects;

public final class a {
    private static final h0 a;

    static {
        a$a a$a = new a$a();
        a = e.a.q0.b.a.f(a$a);
    }

    private a() {
        AssertionError assertionError = new AssertionError((Object)"No instances.");
        throw assertionError;
    }

    public static h0 a(Looper looper) {
        return e.a.q0.c.a.b(looper, false);
    }

    public static h0 b(Looper looper, boolean bl2) {
        int n10;
        Object object = "looper == null";
        Objects.requireNonNull(looper, (String)object);
        int bl3 = Build.VERSION.SDK_INT;
        int bl4 = 16;
        if (bl3 < bl4) {
            bl2 = false;
        } else if (bl2 && bl3 < (n10 = 22)) {
            object = Message.obtain();
            boolean bl5 = true;
            try {
                object.setAsynchronous(bl5);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                bl2 = false;
            }
            object.recycle();
        }
        Handler handler = new Handler(looper);
        object = new b(handler, bl2);
        return object;
    }

    public static h0 c() {
        return e.a.q0.b.a.g(a);
    }
}

