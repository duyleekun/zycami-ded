/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ap;
import com.xiaomi.push.ar;
import com.xiaomi.push.as;
import com.xiaomi.push.av;

public class at {
    public static ar a(Context object) {
        boolean bl2 = as.a(object);
        if (bl2) {
            as as2 = new as((Context)object);
            return as2;
        }
        bl2 = ap.a(object);
        if (bl2) {
            ap ap2 = new ap((Context)object);
            return ap2;
        }
        object = new av();
        return object;
    }
}

