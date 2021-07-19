/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.u;
import g.h$b;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class h {
    public static final h A;
    public static final h A0;
    public static final h B;
    public static final h B0;
    public static final h C;
    public static final h C0;
    public static final h D;
    public static final h D0;
    public static final h E;
    public static final h E0;
    public static final h F;
    public static final h F0;
    public static final h G;
    public static final h G0;
    public static final h H;
    public static final h H0;
    public static final h I;
    public static final h I0;
    public static final h J;
    public static final h J0;
    public static final h K;
    public static final h K0;
    public static final h L;
    public static final h L0;
    public static final h M;
    public static final h M0;
    public static final h N;
    public static final h N0;
    public static final h O;
    public static final h O0;
    public static final h P;
    public static final h P0;
    public static final h Q;
    public static final h Q0;
    public static final h R;
    public static final h R0;
    public static final h S;
    public static final h S0;
    public static final h T;
    public static final h T0;
    public static final h U;
    public static final h U0;
    public static final h V;
    public static final h V0;
    public static final h W;
    public static final h W0;
    public static final h X;
    public static final h X0;
    public static final h Y;
    public static final h Y0;
    public static final h Z;
    public static final h Z0;
    public static final h a0;
    public static final h a1;
    private static final Comparator b;
    public static final h b0;
    public static final h b1;
    private static final Map c;
    public static final h c0;
    public static final h c1;
    public static final h d;
    public static final h d0;
    public static final h d1;
    public static final h e;
    public static final h e0;
    public static final h e1;
    public static final h f;
    public static final h f0;
    public static final h f1;
    public static final h g;
    public static final h g0;
    public static final h g1;
    public static final h h;
    public static final h h0;
    public static final h h1;
    public static final h i;
    public static final h i0;
    public static final h i1;
    public static final h j;
    public static final h j0;
    public static final h j1;
    public static final h k;
    public static final h k0;
    public static final h k1;
    public static final h l;
    public static final h l0;
    public static final h l1;
    public static final h m;
    public static final h m0;
    public static final h m1;
    public static final h n;
    public static final h n0;
    public static final h n1;
    public static final h o;
    public static final h o0;
    public static final h o1;
    public static final h p;
    public static final h p0;
    public static final h p1;
    public static final h q;
    public static final h q0;
    public static final h q1;
    public static final h r;
    public static final h r0;
    public static final h r1;
    public static final h s;
    public static final h s0;
    public static final h$b s1;
    public static final h t;
    public static final h t0;
    public static final h u;
    public static final h u0;
    public static final h v;
    public static final h v0;
    public static final h w;
    public static final h w0;
    public static final h x;
    public static final h x0;
    public static final h y;
    public static final h y0;
    public static final h z;
    public static final h z0;
    private final String a;

    static {
        h$b h$b;
        s1 = h$b = new h$b(null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        b = linkedHashMap;
        c = linkedHashMap = new LinkedHashMap();
        d = h$b.a(h$b, "SSL_RSA_WITH_NULL_MD5", 1);
        e = h$b.a(h$b, "SSL_RSA_WITH_NULL_SHA", 2);
        f = h$b.a(h$b, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        g = h$b.a(h$b, "SSL_RSA_WITH_RC4_128_MD5", 4);
        h = h$b.a(h$b, "SSL_RSA_WITH_RC4_128_SHA", 5);
        i = h$b.a(h$b, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        j = h$b.a(h$b, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        k = h$b.a(h$b, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        l = h$b.a(h$b, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        m = h$b.a(h$b, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        n = h$b.a(h$b, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        o = h$b.a(h$b, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        p = h$b.a(h$b, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        q = h$b.a(h$b, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        r = h$b.a(h$b, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        s = h$b.a(h$b, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        t = h$b.a(h$b, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        u = h$b.a(h$b, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        v = h$b.a(h$b, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        w = h$b.a(h$b, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        x = h$b.a(h$b, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        y = h$b.a(h$b, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        z = h$b.a(h$b, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        A = h$b.a(h$b, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        B = h$b.a(h$b, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        C = h$b.a(h$b, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        D = h$b.a(h$b, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        E = h$b.a(h$b, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        F = h$b.a(h$b, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        G = h$b.a(h$b, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        H = h$b.a(h$b, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        I = h$b.a(h$b, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        J = h$b.a(h$b, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        K = h$b.a(h$b, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        L = h$b.a(h$b, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        M = h$b.a(h$b, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        N = h$b.a(h$b, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        O = h$b.a(h$b, "TLS_RSA_WITH_NULL_SHA256", 59);
        P = h$b.a(h$b, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        Q = h$b.a(h$b, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        R = h$b.a(h$b, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        S = h$b.a(h$b, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        T = h$b.a(h$b, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        U = h$b.a(h$b, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        V = h$b.a(h$b, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        W = h$b.a(h$b, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        X = h$b.a(h$b, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        Y = h$b.a(h$b, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        h$b = s1;
        Z = h$b.a(h$b, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        a0 = h$b.a(h$b, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        b0 = h$b.a(h$b, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        c0 = h$b.a(h$b, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        d0 = h$b.a(h$b, "TLS_PSK_WITH_RC4_128_SHA", 138);
        e0 = h$b.a(h$b, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        f0 = h$b.a(h$b, "TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        g0 = h$b.a(h$b, "TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        h0 = h$b.a(h$b, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        i0 = h$b.a(h$b, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        j0 = h$b.a(h$b, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        k0 = h$b.a(h$b, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        l0 = h$b.a(h$b, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        m0 = h$b.a(h$b, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        n0 = h$b.a(h$b, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        o0 = h$b.a(h$b, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        p0 = h$b.a(h$b, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        q0 = h$b.a(h$b, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        r0 = h$b.a(h$b, "TLS_FALLBACK_SCSV", 22016);
        s0 = h$b.a(h$b, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        t0 = h$b.a(h$b, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        u0 = h$b.a(h$b, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        v0 = h$b.a(h$b, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        w0 = h$b.a(h$b, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        x0 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        y0 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        z0 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        A0 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        B0 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        C0 = h$b.a(h$b, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        D0 = h$b.a(h$b, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        E0 = h$b.a(h$b, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        F0 = h$b.a(h$b, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        G0 = h$b.a(h$b, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        H0 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        I0 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        J0 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        K0 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        L0 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        M0 = h$b.a(h$b, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        N0 = h$b.a(h$b, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        O0 = h$b.a(h$b, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        P0 = h$b.a(h$b, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        Q0 = h$b.a(h$b, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        R0 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        S0 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        T0 = h$b.a(h$b, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        U0 = h$b.a(h$b, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        V0 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        W0 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        h$b = s1;
        X0 = h$b.a(h$b, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        Y0 = h$b.a(h$b, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        Z0 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        a1 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        b1 = h$b.a(h$b, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        c1 = h$b.a(h$b, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        d1 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        e1 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        f1 = h$b.a(h$b, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        g1 = h$b.a(h$b, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        h1 = h$b.a(h$b, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        i1 = h$b.a(h$b, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        j1 = h$b.a(h$b, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        k1 = h$b.a(h$b, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        l1 = h$b.a(h$b, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        m1 = h$b.a(h$b, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        n1 = h$b.a(h$b, "TLS_AES_128_GCM_SHA256", 4865);
        o1 = h$b.a(h$b, "TLS_AES_256_GCM_SHA384", 4866);
        p1 = h$b.a(h$b, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        q1 = h$b.a(h$b, "TLS_AES_128_CCM_SHA256", 4868);
        r1 = h$b.a(h$b, "TLS_AES_128_CCM_8_SHA256", 4869);
    }

    private h(String string2) {
        this.a = string2;
    }

    public /* synthetic */ h(String string2, u u10) {
        this(string2);
    }

    public static final /* synthetic */ Map b() {
        return c;
    }

    public static final /* synthetic */ Comparator c() {
        return b;
    }

    public static final h d(String object) {
        Class<h> clazz = h.class;
        synchronized (clazz) {
            h$b h$b = s1;
            object = h$b.b((String)object);
            return object;
        }
    }

    public final String a() {
        return this.a;
    }

    public final String e() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }
}

