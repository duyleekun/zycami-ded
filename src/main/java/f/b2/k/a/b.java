/*
 * Decompiled with CFR 0.151.
 */
package f.b2.k.a;

import f.b2.c;
import kotlin.coroutines.CoroutineContext;

public final class b
implements c {
    public static final b a;

    static {
        b b10;
        a = b10 = new b();
    }

    private b() {
    }

    public CoroutineContext getContext() {
        String string2 = "This continuation is already complete".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public void resumeWith(Object object) {
        String string2 = "This continuation is already complete".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public String toString() {
        return "This continuation is already complete";
    }
}

