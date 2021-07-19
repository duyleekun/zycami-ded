/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.UiModeManager
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package com.huawei.updatesdk.b.c;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import com.huawei.updatesdk.b.c.a;
import com.huawei.updatesdk.b.c.c;
import com.huawei.updatesdk.b.c.d;
import com.huawei.updatesdk.b.c.e;
import com.huawei.updatesdk.b.c.f;
import java.util.HashMap;
import java.util.Map;

public class b {
    private static final Map a;
    private static c b;
    private static int c;

    static {
        HashMap<Integer, Class> hashMap;
        a = hashMap = new HashMap<Integer, Class>();
        c = -1;
        Integer n10 = 3;
        hashMap.put(n10, a.class);
        n10 = 1;
        hashMap.put(n10, e.class);
        n10 = 2;
        hashMap.put(n10, f.class);
        n10 = 0;
        hashMap.put(n10, d.class);
    }

    private static int a(Context context) {
        boolean bl2 = com.huawei.updatesdk.b.c.b.c(context);
        if (bl2) {
            return 1;
        }
        bl2 = com.huawei.updatesdk.b.c.b.d(context);
        if (bl2) {
            return 2;
        }
        boolean bl3 = com.huawei.updatesdk.b.c.b.b(context);
        if (bl3) {
            return 3;
        }
        return 0;
    }

    public static c a() {
        Object object = b;
        if (object != null) {
            return object;
        }
        object = com.huawei.updatesdk.a.b.a.a.c().a();
        int n10 = c;
        if (n10 < 0) {
            int n11;
            c = n11 = com.huawei.updatesdk.b.c.b.a((Context)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("deviceType: ");
        n10 = c;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = "DeviceImplFactory";
        com.huawei.updatesdk.a.a.a.b(string2, (String)object);
        object = a;
        int n12 = c;
        Integer n13 = n12;
        object = (Class)object.get(n13);
        if (object == null) {
            b = object = new d();
            return object;
        }
        object = ((Class)object).newInstance();
        object = (c)object;
        try {
            b = object;
        }
        catch (Throwable throwable) {
            b = object = new d();
            object = "createDeviceInfo error and create default phone deviceinfo";
            com.huawei.updatesdk.a.a.a.a(string2, (String)object);
        }
        return b;
    }

    private static boolean b(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private static boolean c(Context context) {
        void var4_7;
        context = (UiModeManager)context.getSystemService("uimode");
        CharSequence charSequence = new StringBuilder();
        charSequence.append("UI mode: ");
        int n10 = context.getCurrentModeType();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "DeviceImplFactory";
        com.huawei.updatesdk.a.a.a.b(string2, (String)charSequence);
        int bl2 = context.getCurrentModeType();
        int n11 = 4;
        if (bl2 == n11) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            context = null;
        }
        return (boolean)var4_7;
    }

    private static boolean d(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        }
        return false;
    }
}

