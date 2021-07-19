/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.y1.b;
import g.h;
import g.h$b;
import g.h0.d;
import g.k$a;
import g.k$b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt___CollectionsKt;
import okhttp3.TlsVersion;
import okhttp3.TlsVersion$a;

public final class k {
    private static final h[] e;
    private static final h[] f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k$b k;
    private final boolean a;
    private final boolean b;
    private final String[] c;
    private final String[] d;

    static {
        Object object = new k$b(null);
        k = object;
        Object object2 = new h[9];
        Object object3 = g.h.n1;
        object2[0] = object3;
        Object object4 = g.h.o1;
        boolean bl2 = true;
        object2[bl2] = object4;
        Object object5 = g.h.p1;
        int n10 = 2;
        object2[n10] = object5;
        h h10 = g.h.Z0;
        int n11 = 3;
        object2[n11] = h10;
        h h11 = g.h.d1;
        int n12 = 4;
        object2[n12] = h11;
        h h12 = g.h.a1;
        int n13 = 5;
        object2[n13] = h12;
        h h13 = g.h.e1;
        int n14 = 6;
        object2[n14] = h13;
        h h14 = g.h.k1;
        int n15 = 7;
        object2[n15] = h14;
        h h15 = g.h.j1;
        int n16 = 8;
        object2[n16] = h15;
        e = object2;
        object = new h[16];
        object[0] = object3;
        object[bl2] = object4;
        object[n10] = object5;
        object[n11] = h10;
        object[n12] = h11;
        object[n13] = h12;
        object[n14] = h13;
        object[n15] = h14;
        object[n16] = h15;
        object3 = g.h.K0;
        object[9] = object3;
        object3 = g.h.L0;
        object[10] = object3;
        object3 = g.h.i0;
        object[11] = object3;
        object3 = g.h.j0;
        object[12] = object3;
        object3 = g.h.G;
        object[13] = object3;
        object3 = g.h.K;
        object[14] = object3;
        object3 = g.h.k;
        object[15] = object3;
        f = object;
        object3 = new k$a(bl2);
        int n17 = ((h[])object2).length;
        object2 = Arrays.copyOf(object2, n17);
        object2 = object3.e((h[])object2);
        object3 = new TlsVersion[n10];
        object4 = TlsVersion.TLS_1_3;
        object3[0] = object4;
        object5 = TlsVersion.TLS_1_2;
        object3[bl2] = object5;
        g = ((k$a)object2).p((TlsVersion)((Object)object3)).n(bl2).c();
        object2 = new k$a(bl2);
        int n18 = ((h[])object).length;
        object3 = Arrays.copyOf(object, n18);
        object2 = ((k$a)object2).e((h[])object3);
        object3 = new TlsVersion[n10];
        object3[0] = object4;
        object3[bl2] = object5;
        h = ((k$a)object2).p((TlsVersion)((Object)object3)).n(bl2).c();
        object2 = new k$a(bl2);
        n18 = ((h[])object).length;
        object = Arrays.copyOf(object, n18);
        object = ((k$a)object2).e((h[])object);
        object2 = new TlsVersion[n12];
        object2[0] = object4;
        object2[bl2] = object5;
        object2[n10] = object3 = TlsVersion.TLS_1_1;
        object2[n11] = object3 = TlsVersion.TLS_1_0;
        i = ((k$a)object).p((TlsVersion[])object2).n(bl2).c();
        object = new k$a(false);
        j = ((k$a)object).c();
    }

    public k(boolean bl2, boolean bl3, String[] stringArray, String[] stringArray2) {
        this.a = bl2;
        this.b = bl3;
        this.c = stringArray;
        this.d = stringArray2;
    }

    public static final /* synthetic */ String[] d(k k10) {
        return k10.c;
    }

    public static final /* synthetic */ String[] e(k k10) {
        return k10.d;
    }

    private final k j(SSLSocket object, boolean n10) {
        String[] stringArray;
        Object object2;
        String[] stringArray2;
        String[] stringArray3;
        String[] stringArray4 = this.c;
        if (stringArray4 != null) {
            stringArray4 = ((SSLSocket)object).getEnabledCipherSuites();
            f0.o(stringArray4, "sslSocket.enabledCipherSuites");
            stringArray3 = this.c;
            stringArray2 = g.h.s1.c();
            stringArray4 = g.h0.d.I(stringArray4, stringArray3, (Comparator)stringArray2);
        } else {
            stringArray4 = ((SSLSocket)object).getEnabledCipherSuites();
        }
        stringArray3 = this.d;
        if (stringArray3 != null) {
            stringArray3 = ((SSLSocket)object).getEnabledProtocols();
            f0.o(stringArray3, "sslSocket.enabledProtocols");
            stringArray2 = this.d;
            object2 = f.y1.b.l();
            stringArray3 = g.h0.d.I(stringArray3, stringArray2, (Comparator)object2);
        } else {
            stringArray3 = ((SSLSocket)object).getEnabledProtocols();
        }
        object = ((SSLSocket)object).getSupportedCipherSuites();
        f0.o(object, "supportedCipherSuites");
        stringArray2 = g.h.s1.c();
        int n11 = g.h0.d.A((String[])object, "TLS_FALLBACK_SCSV", (Comparator)stringArray2);
        object2 = "cipherSuitesIntersection";
        if (n10 != 0 && n11 != (n10 = -1)) {
            f0.o(stringArray4, (String)object2);
            object = object[n11];
            stringArray = "supportedCipherSuites[indexOfFallbackScsv]";
            f0.o(object, (String)stringArray);
            stringArray4 = g.h0.d.o(stringArray4, (String)object);
        }
        object = new k$a(this);
        f0.o(stringArray4, (String)object2);
        n10 = stringArray4.length;
        stringArray = Arrays.copyOf(stringArray4, n10);
        object = ((k$a)object).d(stringArray);
        f0.o(stringArray3, "tlsVersionsIntersection");
        n10 = stringArray3.length;
        stringArray = Arrays.copyOf(stringArray3, n10);
        return ((k$a)object).o(stringArray).c();
    }

    public final List a() {
        return this.g();
    }

    public final boolean b() {
        return this.b;
    }

    public final List c() {
        return this.l();
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof k;
        if (!bl2) {
            return false;
        }
        bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = this.a;
        object = (k)object;
        boolean bl4 = ((k)object).a;
        if (bl3 != bl4) {
            return false;
        }
        if (bl3) {
            Object[] objectArray = this.c;
            Object[] objectArray2 = ((k)object).c;
            bl3 = Arrays.equals(objectArray, objectArray2);
            if (!bl3) {
                return false;
            }
            objectArray = this.d;
            objectArray2 = ((k)object).d;
            bl3 = Arrays.equals(objectArray, objectArray2);
            if (!bl3) {
                return false;
            }
            bl3 = this.b;
            boolean bl5 = ((k)object).b;
            if (bl3 != bl5) {
                return false;
            }
        }
        return bl2;
    }

    public final void f(SSLSocket sSLSocket, boolean bl2) {
        f0.p(sSLSocket, "sslSocket");
        String[] stringArray = this.j(sSLSocket, bl2);
        String[] stringArray2 = stringArray.l();
        if (stringArray2 != null) {
            stringArray2 = stringArray.d;
            sSLSocket.setEnabledProtocols(stringArray2);
        }
        if ((stringArray2 = stringArray.g()) != null) {
            stringArray = stringArray.c;
            sSLSocket.setEnabledCipherSuites(stringArray);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final List g() {
        void var1_4;
        String[] object = this.c;
        if (object != null) {
            int n10 = object.length;
            ArrayList<h> arrayList = new ArrayList<h>(n10);
            for (String string2 : object) {
                h$b h$b = g.h.s1;
                h h10 = h$b.b(string2);
                arrayList.add(h10);
            }
            List list = CollectionsKt___CollectionsKt.I5(arrayList);
        } else {
            Object var1_3 = null;
        }
        return var1_4;
    }

    public final boolean h(SSLSocket stringArray) {
        boolean bl2;
        Comparator comparator;
        Object object;
        String[] stringArray2 = "socket";
        f0.p(stringArray, (String)stringArray2);
        boolean bl3 = this.a;
        if (!bl3) {
            return false;
        }
        stringArray2 = this.d;
        if (stringArray2 != null && !(bl3 = g.h0.d.w(stringArray2, object = stringArray.getEnabledProtocols(), comparator = f.y1.b.l()))) {
            return false;
        }
        stringArray2 = this.c;
        return stringArray2 == null || (bl2 = g.h0.d.w(stringArray2, stringArray = stringArray.getEnabledCipherSuites(), (Comparator)(object = g.h.s1.c())));
    }

    public int hashCode() {
        int n10 = this.a;
        if (n10 != 0) {
            int n11;
            n10 = 527;
            Object[] objectArray = this.c;
            int n12 = 0;
            if (objectArray != null) {
                n11 = Arrays.hashCode(objectArray);
            } else {
                n11 = 0;
                objectArray = null;
            }
            n10 = (n10 + n11) * 31;
            objectArray = this.d;
            if (objectArray != null) {
                n12 = Arrays.hashCode(objectArray);
            }
            n10 = (n10 + n12) * 31;
            n11 = this.b ^ 1;
            n10 += n11;
        } else {
            n10 = 17;
        }
        return n10;
    }

    public final boolean i() {
        return this.a;
    }

    public final boolean k() {
        return this.b;
    }

    /*
     * WARNING - void declaration
     */
    public final List l() {
        void var1_4;
        String[] object = this.d;
        if (object != null) {
            int n10 = object.length;
            ArrayList<String> arrayList = new ArrayList<String>(n10);
            for (Object object2 : object) {
                TlsVersion$a tlsVersion$a = TlsVersion.Companion;
                object2 = tlsVersion$a.a((String)object2);
                arrayList.add((String)object2);
            }
            List list = CollectionsKt___CollectionsKt.I5(arrayList);
        } else {
            Object var1_3 = null;
        }
        return var1_4;
    }

    public String toString() {
        boolean bl2 = this.a;
        if (!bl2) {
            return "ConnectionSpec()";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectionSpec(");
        stringBuilder.append("cipherSuites=");
        Object object = this.g();
        String string2 = "[all enabled]";
        object = Objects.toString(object, string2);
        stringBuilder.append((String)object);
        object = ", ";
        stringBuilder.append((String)object);
        stringBuilder.append("tlsVersions=");
        string2 = Objects.toString(this.l(), string2);
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append("supportsTlsExtensions=");
        boolean bl3 = this.b;
        stringBuilder.append(bl3);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

