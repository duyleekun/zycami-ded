/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package cn.sharesdk.twitter;

import android.content.Context;
import android.content.Intent;

public class a {
    public static boolean a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 0).isEmpty() ^ true;
    }
}

