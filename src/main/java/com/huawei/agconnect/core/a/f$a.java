/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.agconnect.core.a;

import com.huawei.agconnect.core.a.f$b;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

public class f$a
implements Comparator,
Serializable {
    private f$a() {
    }

    public /* synthetic */ f$a(f.b b10) {
        this();
    }

    public int a(Map.Entry entry, Map.Entry entry2) {
        int n10 = (Integer)entry.getValue();
        int n11 = (Integer)entry2.getValue();
        return n10 - n11;
    }
}

