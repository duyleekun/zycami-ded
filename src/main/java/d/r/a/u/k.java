/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 */
package d.r.a.u;

import android.os.Looper;
import android.util.Log;
import d.r.a.u.s;

public final class k {
    public static void a(String string2) {
        Object object;
        Object object2;
        boolean bl2 = s.g();
        if (bl2 && (object2 = Looper.myLooper()) == (object = Looper.getMainLooper())) {
            object2 = new StringBuilder("Operation: ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" in main thread!");
            string2 = ((StringBuilder)object2).toString();
            object2 = new Throwable();
            object = "DebugUtil";
            Log.w((String)object, (String)string2, (Throwable)object2);
        }
    }
}

