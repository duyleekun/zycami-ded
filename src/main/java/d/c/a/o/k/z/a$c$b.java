/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.k.z;

import android.util.Log;
import d.c.a.o.k.z.a$c;

public class a$c$b
implements a$c {
    public void a(Throwable throwable) {
        String string2;
        boolean bl2;
        if (throwable != null && (bl2 = Log.isLoggable((String)(string2 = "GlideExecutor"), (int)6))) {
            String string3 = "Request threw uncaught throwable";
            Log.e((String)string2, (String)string3, (Throwable)throwable);
        }
    }
}

