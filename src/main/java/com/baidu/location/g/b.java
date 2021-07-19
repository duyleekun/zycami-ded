/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.baidu.location.g;

import android.util.Log;
import com.baidu.location.g.a;
import java.lang.ref.WeakReference;

public class b
implements Runnable {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ a b;

    public b(a a10, WeakReference weakReference) {
        this.b = a10;
        this.a = weakReference;
    }

    public void run() {
        int n10;
        int n11;
        a a10 = (a)this.a.get();
        if (a10 != null && (n11 = com.baidu.location.g.a.a(a10)) == (n10 = 3)) {
            String string2 = "baidu location service force stopped ...";
            Log.d((String)"baidu_location_service", (String)string2);
            n11 = 0;
            com.baidu.location.g.a.a(a10, false);
            com.baidu.location.g.a.b(a10);
        }
    }
}

