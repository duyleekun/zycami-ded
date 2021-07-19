/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package d.c.a.p;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import d.c.a.p.c;
import d.c.a.p.c$a;
import d.c.a.p.d;
import d.c.a.p.e;
import d.c.a.p.j;

public class f
implements d {
    private static final String a = "ConnectivityMonitor";
    private static final String b = "android.permission.ACCESS_NETWORK_STATE";

    public c a(Context context, c$a c$a) {
        Object object = b;
        int n10 = ContextCompat.checkSelfPermission(context, (String)object);
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        String string2 = a;
        boolean bl2 = Log.isLoggable((String)string2, (int)3);
        if (bl2) {
            String string3 = n10 != 0 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            Log.d((String)string2, (String)string3);
        }
        object = n10 != 0 ? new e(context, c$a) : new j();
        return object;
    }
}

