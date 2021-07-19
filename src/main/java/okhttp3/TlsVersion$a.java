/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.t.f0;
import f.h2.t.u;
import okhttp3.TlsVersion;

public final class TlsVersion$a {
    private TlsVersion$a() {
    }

    public /* synthetic */ TlsVersion$a(u u10) {
        this();
    }

    public final TlsVersion a(String object) {
        Object object2;
        block14: {
            block15: {
                int n10;
                block12: {
                    block13: {
                        object2 = "javaName";
                        f0.p(object, (String)object2);
                        n10 = object.hashCode();
                        int n11 = 79201641;
                        if (n10 == n11) break block12;
                        n11 = 79923350;
                        if (n10 == n11) break block13;
                        switch (n10) {
                            default: {
                                break block14;
                            }
                            case -503070501: {
                                object2 = "TLSv1.3";
                                n10 = (int)(object.equals(object2) ? 1 : 0);
                                if (n10 != 0) {
                                    object = TlsVersion.TLS_1_3;
                                    break;
                                }
                                break block14;
                            }
                            case -503070502: {
                                object2 = "TLSv1.2";
                                n10 = (int)(object.equals(object2) ? 1 : 0);
                                if (n10 != 0) {
                                    object = TlsVersion.TLS_1_2;
                                    break;
                                }
                                break block14;
                            }
                            case -503070503: {
                                object2 = "TLSv1.1";
                                n10 = (int)(object.equals(object2) ? 1 : 0);
                                if (n10 != 0) {
                                    object = TlsVersion.TLS_1_1;
                                    break;
                                }
                                break block14;
                            }
                        }
                        break block15;
                    }
                    object2 = "TLSv1";
                    n10 = (int)(object.equals(object2) ? 1 : 0);
                    if (n10 == 0) break block14;
                    object = TlsVersion.TLS_1_0;
                    break block15;
                }
                object2 = "SSLv3";
                n10 = (int)(object.equals(object2) ? 1 : 0);
                if (n10 == 0) break block14;
                object = TlsVersion.SSL_3_0;
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected TLS version: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }
}

