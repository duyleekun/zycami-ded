/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.heytap.mcssdk.f;

import android.content.Context;

public class d {
    private static final String a = "shared_msg_sdk";
    private static final String b = "hasDefaultChannelCreated";

    public static void a(Context context, boolean bl2) {
        context.getSharedPreferences(a, 0).edit().putBoolean(b, bl2).commit();
    }

    public static boolean a(Context context) {
        return context.getSharedPreferences(a, 0).getBoolean(b, false);
    }
}

