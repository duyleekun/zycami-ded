/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.car.Car
 *  android.content.Context
 *  android.content.ServiceConnection
 */
package com.huawei.updatesdk.a.a.d.h;

import android.car.Car;
import android.content.Context;
import android.content.ServiceConnection;
import com.huawei.updatesdk.a.a.d.h.a$a;

public class a {
    private static Car a;
    private static String b;
    private static String c;
    private static boolean d = false;

    public static /* synthetic */ Car a() {
        return a;
    }

    public static /* synthetic */ String a(String string2) {
        c = string2;
        return string2;
    }

    private static void a(Context context) {
        block8: {
            boolean bl2;
            if (context != null && !(bl2 = d)) {
                bl2 = true;
                d = bl2;
                context = context.getApplicationContext();
                Object object = new a$a();
                context = Car.createCar((Context)context, (ServiceConnection)object);
                a = context;
                if (context == null) break block8;
                try {
                    context.connect();
                }
                catch (Throwable throwable) {
                    object = new StringBuilder();
                    String string2 = "Car Service Connect Error";
                    ((StringBuilder)object).append(string2);
                    String string3 = throwable.toString();
                    ((StringBuilder)object).append(string3);
                    string3 = ((StringBuilder)object).toString();
                    object = "CarInfoUtil";
                    com.huawei.updatesdk.a.a.a.a((String)object, string3);
                }
            }
        }
    }

    public static /* synthetic */ String b() {
        return c;
    }

    public static /* synthetic */ String b(String string2) {
        b = string2;
        return string2;
    }

    public static void b(Context context) {
        com.huawei.updatesdk.a.a.d.h.a.a(context);
    }

    public static /* synthetic */ String c() {
        return b;
    }

    public static String d() {
        return c;
    }

    public static String e() {
        return b;
    }
}

