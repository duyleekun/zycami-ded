/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.a.d.h;

import com.huawei.updatesdk.a.a.d.h.b$a;

public class b
extends com.huawei.updatesdk.a.b.c.c.b {
    private String abis_;
    private String deviceFeatures_;
    private int dpi_;
    private String preferLan_;

    private b() {
    }

    public /* synthetic */ b(b$a b$a) {
        this();
    }

    public static /* synthetic */ int a(b b10, int n10) {
        b10.dpi_ = n10;
        return n10;
    }

    public static /* synthetic */ String a(b b10, String string2) {
        b10.abis_ = string2;
        return string2;
    }

    public static /* synthetic */ String b(b b10, String string2) {
        b10.preferLan_ = string2;
        return string2;
    }

    public static /* synthetic */ String c(b b10, String string2) {
        b10.deviceFeatures_ = string2;
        return string2;
    }
}

