/*
 * Decompiled with CFR 0.151.
 */
package f.d2;

import f.d2.k$a;
import f.h2.t.f0;
import f.k2.b;
import f.k2.e;
import f.q2.h;
import f.x1.n;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.regex.MatchResult;
import kotlin.collections.CollectionsKt__CollectionsKt;

public class k {
    public void a(Throwable throwable, Throwable throwable2) {
        f0.p(throwable, "cause");
        f0.p(throwable2, "exception");
        Method method = k$a.a;
        if (method != null) {
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = throwable2;
            method.invoke(throwable, objectArray);
        }
    }

    public e b() {
        b b10 = new b();
        return b10;
    }

    public h c(MatchResult object, String string2) {
        f0.p(object, "matchResult");
        f0.p(string2, "name");
        object = new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        throw object;
    }

    public List d(Throwable object) {
        block3: {
            block2: {
                Object[] objectArray;
                f0.p(object, "exception");
                Object object2 = k$a.b;
                if (object2 == null || (object = ((Method)object2).invoke(object, objectArray = new Object[0])) == null) break block2;
                object2 = "null cannot be cast to non-null type kotlin.Array<kotlin.Throwable>";
                Objects.requireNonNull(object, (String)object2);
                object = n.t((Throwable[])object);
                if (object != null) break block3;
            }
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }
}

