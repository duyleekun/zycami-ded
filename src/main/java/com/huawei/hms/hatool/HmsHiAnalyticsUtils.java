/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.hatool;

import android.content.Context;
import com.huawei.hms.hatool.j1;
import com.huawei.hms.hatool.k1;
import com.huawei.hms.hatool.l1;
import java.util.LinkedHashMap;

public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        l1.a();
    }

    public static boolean getInitFlag() {
        return j1.b();
    }

    public static void init(Context context, boolean bl2, boolean bl3, boolean bl4, String string2, String string3) {
        k1 k12 = new k1(context);
        k12.a(bl2).c(bl3).b(bl4).a(0, string2).a(1, string2).a(string3).a();
    }

    public static void onEvent(int n10, String string2, LinkedHashMap linkedHashMap) {
        j1.a(n10, string2, linkedHashMap);
    }

    public static void onEvent(Context context, String string2, String string3) {
        j1.a(context, string2, string3);
    }

    public static void onReport() {
        j1.c();
    }
}

