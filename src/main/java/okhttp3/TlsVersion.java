/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import okhttp3.TlsVersion$a;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class TlsVersion
extends Enum {
    public static final TlsVersion$a Companion;
    public static final /* enum */ TlsVersion SSL_3_0;
    public static final /* enum */ TlsVersion TLS_1_0;
    public static final /* enum */ TlsVersion TLS_1_1;
    public static final /* enum */ TlsVersion TLS_1_2;
    public static final /* enum */ TlsVersion TLS_1_3;
    private static final /* synthetic */ TlsVersion[] a;
    private final String javaName;

    static {
        TlsVersion tlsVersion;
        Object object = new TlsVersion[5];
        TLS_1_3 = tlsVersion = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        object[0] = tlsVersion;
        int n10 = 1;
        TLS_1_2 = tlsVersion = new TlsVersion("TLS_1_2", n10, "TLSv1.2");
        object[n10] = tlsVersion;
        n10 = 2;
        TLS_1_1 = tlsVersion = new TlsVersion("TLS_1_1", n10, "TLSv1.1");
        object[n10] = tlsVersion;
        n10 = 3;
        TLS_1_0 = tlsVersion = new TlsVersion("TLS_1_0", n10, "TLSv1");
        object[n10] = tlsVersion;
        n10 = 4;
        SSL_3_0 = tlsVersion = new TlsVersion("SSL_3_0", n10, "SSLv3");
        object[n10] = tlsVersion;
        a = object;
        Companion = object = new TlsVersion$a(null);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TlsVersion() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.javaName = var3_1;
    }

    public static final TlsVersion forJavaName(String string2) {
        return Companion.a(string2);
    }

    public static TlsVersion valueOf(String string2) {
        return Enum.valueOf(TlsVersion.class, string2);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[])a.clone();
    }

    public final String -deprecated_javaName() {
        return this.javaName;
    }

    public final String javaName() {
        return this.javaName;
    }
}

