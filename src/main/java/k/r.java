/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.a0;
import g.a0$a;
import g.c0;
import g.c0$a;
import g.d0;
import g.s;
import g.v;
import java.util.Objects;
import k.l$c;
import okhttp3.Protocol;

public final class r {
    private final c0 a;
    private final Object b;
    private final d0 c;

    private r(c0 c02, Object object, d0 d02) {
        this.a = c02;
        this.b = object;
        this.c = d02;
    }

    public static r c(int n10, d0 object) {
        Object object2 = "body == null";
        Objects.requireNonNull(object, (String)object2);
        int n11 = 400;
        if (n10 >= n11) {
            object2 = new c0$a();
            v v10 = ((d0)object).contentType();
            long l10 = ((d0)object).contentLength();
            l$c l$c = new l$c(v10, l10);
            Object object3 = ((c0$a)object2).b(l$c).g(n10).y("Response.error()");
            object2 = Protocol.HTTP_1_1;
            object3 = ((c0$a)object3).B((Protocol)((Object)object2));
            object2 = new a0$a();
            object2 = ((a0$a)object2).B("http://localhost/").b();
            object3 = ((c0$a)object3).E((a0)object2).c();
            return r.d((d0)object, (c0)object3);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("code < 400: ");
        ((StringBuilder)object2).append(n10);
        String string2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static r d(d0 object, c0 c02) {
        Objects.requireNonNull(object, "body == null");
        Object object2 = "rawResponse == null";
        Objects.requireNonNull(c02, (String)object2);
        boolean bl2 = c02.isSuccessful();
        if (!bl2) {
            object2 = new r(c02, null, (d0)object);
            return object2;
        }
        object = new IllegalArgumentException("rawResponse should not be successful response");
        throw object;
    }

    public static r j(int n10, Object object) {
        int n11 = 200;
        if (n10 >= n11 && n10 < (n11 = 300)) {
            Object object2 = new c0$a();
            Object object3 = ((c0$a)object2).g(n10).y("Response.success()");
            object2 = Protocol.HTTP_1_1;
            object3 = ((c0$a)object3).B((Protocol)((Object)object2));
            object2 = new a0$a();
            object2 = ((a0$a)object2).B("http://localhost/").b();
            object3 = ((c0$a)object3).E((a0)object2).c();
            return r.m(object, (c0)object3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("code < 200 or >= 300: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static r k(Object object) {
        Object object2 = new c0$a();
        object2 = ((c0$a)object2).g(200).y("OK");
        Object object3 = Protocol.HTTP_1_1;
        object2 = ((c0$a)object2).B((Protocol)((Object)object3));
        object3 = new a0$a();
        object3 = ((a0$a)object3).B("http://localhost/").b();
        object2 = ((c0$a)object2).E((a0)object3).c();
        return r.m(object, (c0)object2);
    }

    public static r l(Object object, s object2) {
        Objects.requireNonNull(object2, "headers == null");
        Object object3 = new c0$a();
        object3 = ((c0$a)object3).g(200).y("OK");
        Protocol protocol = Protocol.HTTP_1_1;
        object2 = ((c0$a)object3).B(protocol).w((s)object2);
        object3 = new a0$a();
        object3 = ((a0$a)object3).B("http://localhost/").b();
        object2 = ((c0$a)object2).E((a0)object3).c();
        return r.m(object, (c0)object2);
    }

    public static r m(Object object, c0 c02) {
        Object object2 = "rawResponse == null";
        Objects.requireNonNull(c02, (String)object2);
        boolean bl2 = c02.isSuccessful();
        if (bl2) {
            object2 = new r(c02, object, null);
            return object2;
        }
        object = new IllegalArgumentException("rawResponse must be successful response");
        throw object;
    }

    public Object a() {
        return this.b;
    }

    public int b() {
        return this.a.v0();
    }

    public d0 e() {
        return this.c;
    }

    public s f() {
        return this.a.C0();
    }

    public boolean g() {
        return this.a.isSuccessful();
    }

    public String h() {
        return this.a.E0();
    }

    public c0 i() {
        return this.a;
    }

    public String toString() {
        return this.a.toString();
    }
}

