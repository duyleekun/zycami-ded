/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import okhttp3.Protocol$a;

public final class Protocol
extends Enum {
    public static final Protocol$a Companion;
    public static final /* enum */ Protocol H2_PRIOR_KNOWLEDGE;
    public static final /* enum */ Protocol HTTP_1_0;
    public static final /* enum */ Protocol HTTP_1_1;
    public static final /* enum */ Protocol HTTP_2;
    public static final /* enum */ Protocol QUIC;
    public static final /* enum */ Protocol SPDY_3;
    private static final /* synthetic */ Protocol[] a;
    private final String protocol;

    static {
        Protocol protocol;
        Object object = new Protocol[6];
        HTTP_1_0 = protocol = new Protocol("HTTP_1_0", 0, "http/1.0");
        object[0] = protocol;
        int n10 = 1;
        HTTP_1_1 = protocol = new Protocol("HTTP_1_1", n10, "http/1.1");
        object[n10] = protocol;
        n10 = 2;
        SPDY_3 = protocol = new Protocol("SPDY_3", n10, "spdy/3.1");
        object[n10] = protocol;
        n10 = 3;
        HTTP_2 = protocol = new Protocol("HTTP_2", n10, "h2");
        object[n10] = protocol;
        n10 = 4;
        H2_PRIOR_KNOWLEDGE = protocol = new Protocol("H2_PRIOR_KNOWLEDGE", n10, "h2_prior_knowledge");
        object[n10] = protocol;
        n10 = 5;
        QUIC = protocol = new Protocol("QUIC", n10, "quic");
        object[n10] = protocol;
        a = object;
        Companion = object = new Protocol$a(null);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Protocol() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.protocol = var3_1;
    }

    public static final /* synthetic */ String access$getProtocol$p(Protocol protocol) {
        return protocol.protocol;
    }

    public static final Protocol get(String string2) {
        return Companion.a(string2);
    }

    public static Protocol valueOf(String string2) {
        return Enum.valueOf(Protocol.class, string2);
    }

    public static Protocol[] values() {
        return (Protocol[])a.clone();
    }

    public String toString() {
        return this.protocol;
    }
}

