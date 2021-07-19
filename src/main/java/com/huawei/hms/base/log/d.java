/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.base.log.b;

public class d
implements b {
    public b a;

    public void a(Context context, String string2) {
        b b10 = this.a;
        if (b10 != null) {
            b10.a(context, string2);
        }
    }

    public void a(String string2, int n10, String string3, String string4) {
        Object object = new StringBuilder();
        String string5 = "HMSSDK_";
        ((StringBuilder)object).append(string5);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        Log.println((int)n10, (String)object, (String)string4);
        object = this.a;
        if (object != null) {
            object.a(string2, n10, string3, string4);
        }
    }
}

