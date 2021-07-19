/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package com.huawei.updatesdk.b.c;

import android.os.Build;
import com.huawei.updatesdk.a.a.d.h.e;
import com.huawei.updatesdk.b.c.d;

public class f
extends d {
    public int b() {
        return 2;
    }

    public String d() {
        boolean bl2 = e.a();
        if (bl2) {
            return Build.PRODUCT;
        }
        return "";
    }
}

