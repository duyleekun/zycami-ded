/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.h;
import g.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import okhttp3.TlsVersion;

public final class k$a {
    private boolean a;
    private String[] b;
    private String[] c;
    private boolean d;

    public k$a(k k10) {
        boolean bl2;
        boolean bl3;
        f0.p(k10, "connectionSpec");
        this.a = bl3 = k10.i();
        String[] stringArray = k.d(k10);
        this.b = stringArray;
        stringArray = k.e(k10);
        this.c = stringArray;
        this.d = bl2 = k10.k();
    }

    public k$a(boolean bl2) {
        this.a = bl2;
    }

    public final k$a a() {
        boolean bl2 = this.a;
        if (bl2) {
            this.b = null;
            return this;
        }
        String string2 = "no cipher suites for cleartext connections".toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final k$a b() {
        boolean bl2 = this.a;
        if (bl2) {
            this.c = null;
            return this;
        }
        String string2 = "no TLS versions for cleartext connections".toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final k c() {
        boolean bl2 = this.a;
        boolean bl3 = this.d;
        String[] stringArray = this.b;
        String[] stringArray2 = this.c;
        k k10 = new k(bl2, bl3, stringArray, stringArray2);
        return k10;
    }

    public final k$a d(String ... object) {
        String string2 = "cipherSuites";
        f0.p(object, string2);
        int n10 = this.a;
        if (n10 != 0) {
            n10 = ((String[])object).length;
            int n11 = 1;
            if (n10 == 0) {
                n10 = n11;
            } else {
                n10 = 0;
                string2 = null;
            }
            if ((n10 ^= n11) != 0) {
                object = object.clone();
                Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                object = (String[])object;
                this.b = object;
                return this;
            }
            string2 = "At least one cipher suite is required".toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        string2 = "no cipher suites for cleartext connections".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final k$a e(h ... object) {
        ArrayList<String> arrayList = "cipherSuites";
        f0.p(object, (String)((Object)arrayList));
        int n10 = this.a;
        if (n10 != 0) {
            int n11 = ((h[])object).length;
            arrayList = new ArrayList<String>(n11);
            n11 = ((h[])object).length;
            for (int i10 = 0; i10 < n11; ++i10) {
                String string2 = object[i10].e();
                arrayList.add(string2);
            }
            object = new String[]{};
            object = arrayList.toArray((T[])object);
            Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.Array<T>");
            object = (String[])object;
            n10 = ((h[])object).length;
            object = (String[])Arrays.copyOf(object, n10);
            return this.d((String[])object);
        }
        arrayList = "no cipher suites for cleartext connections".toString();
        object = new IllegalArgumentException((String)((Object)arrayList));
        throw object;
    }

    public final String[] f() {
        return this.b;
    }

    public final boolean g() {
        return this.d;
    }

    public final boolean h() {
        return this.a;
    }

    public final String[] i() {
        return this.c;
    }

    public final void j(String[] stringArray) {
        this.b = stringArray;
    }

    public final void k(boolean bl2) {
        this.d = bl2;
    }

    public final void l(boolean bl2) {
        this.a = bl2;
    }

    public final void m(String[] stringArray) {
        this.c = stringArray;
    }

    public final k$a n(boolean bl2) {
        boolean bl3 = this.a;
        if (bl3) {
            this.d = bl2;
            return this;
        }
        String string2 = "no TLS extensions for cleartext connections".toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final k$a o(String ... object) {
        String string2 = "tlsVersions";
        f0.p(object, string2);
        int n10 = this.a;
        if (n10 != 0) {
            n10 = ((String[])object).length;
            int n11 = 1;
            if (n10 == 0) {
                n10 = n11;
            } else {
                n10 = 0;
                string2 = null;
            }
            if ((n10 ^= n11) != 0) {
                object = object.clone();
                Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                object = (String[])object;
                this.c = object;
                return this;
            }
            string2 = "At least one TLS version is required".toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        string2 = "no TLS versions for cleartext connections".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final k$a p(TlsVersion ... object) {
        ArrayList<String> arrayList = "tlsVersions";
        f0.p(object, (String)((Object)arrayList));
        int n10 = this.a;
        if (n10 != 0) {
            int n11 = ((TlsVersion[])object).length;
            arrayList = new ArrayList<String>(n11);
            n11 = ((TlsVersion[])object).length;
            for (int i10 = 0; i10 < n11; ++i10) {
                String string2 = object[i10].javaName();
                arrayList.add(string2);
            }
            object = new String[]{};
            object = arrayList.toArray((T[])object);
            Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.Array<T>");
            object = (String[])object;
            n10 = ((TlsVersion[])object).length;
            object = (String[])Arrays.copyOf(object, n10);
            return this.o((String[])object);
        }
        arrayList = "no TLS versions for cleartext connections".toString();
        object = new IllegalArgumentException((String)((Object)arrayList));
        throw object;
    }
}

