/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.aa;
import com.xiaomi.push.al$b;
import com.xiaomi.push.dm;

public class dn
extends al$b {
    public final /* synthetic */ dm a;

    public dn(dm dm2) {
        this.a = dm2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object = dm.a();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return;
        }
        try {
            bl2 = aa.d();
            if (!bl2) {
                object = this.a;
                object = dm.a((dm)object);
                String string2 = "SDCard is unavailable.";
                Log.w((String)object, (String)string2);
                return;
            }
            object = this.a;
            dm.a((dm)object);
            return;
        }
        catch (Exception exception) {
            String string3 = dm.a(this.a);
            String string4 = "";
            Log.e((String)string3, (String)string4, (Throwable)exception);
        }
    }
}

