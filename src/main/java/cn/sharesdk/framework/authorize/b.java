/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package cn.sharesdk.framework.authorize;

import android.app.Activity;

public class b {
    private static volatile b a;
    private Activity b;
    private boolean c;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static b c() {
        Class<b> clazz = b.class;
        // MONITORENTER : clazz
        b b10 = a;
        if (b10 == null) {
            // MONITORENTER : clazz
            b10 = a;
            if (b10 == null) {
                a = b10 = new b();
            }
            // MONITOREXIT : clazz
        }
        // MONITOREXIT : clazz
        return a;
    }

    public void a(Activity activity) {
        this.b = activity;
    }

    public void a(boolean bl2) {
        this.c = bl2;
    }

    public boolean a() {
        return this.c;
    }

    public Activity b() {
        return this.b;
    }
}

