/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.api;

import java.util.List;

public class ProtocolNegotiate {
    private static ProtocolNegotiate b;
    private int a = 1;

    static {
        ProtocolNegotiate protocolNegotiate;
        b = protocolNegotiate = new ProtocolNegotiate();
    }

    public static ProtocolNegotiate getInstance() {
        return b;
    }

    public int getVersion() {
        return this.a;
    }

    public int negotiate(List object) {
        int n10;
        int n11 = 1;
        if (object != null && (n10 = object.isEmpty()) == 0) {
            n10 = 2;
            Integer n12 = n10;
            boolean bl2 = object.contains(n12);
            if (!bl2) {
                int n13;
                n10 = object.size() - n11;
                object = (Integer)object.get(n10);
                this.a = n13 = ((Integer)object).intValue();
            } else {
                this.a = n10;
            }
            return this.a;
        }
        this.a = n11;
        return n11;
    }
}

