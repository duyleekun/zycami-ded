/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package d.v.c.s0.e7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import d.v.c.s0.e7.p;

public class p$a
extends BroadcastReceiver {
    public final /* synthetic */ p a;

    public p$a(p p10) {
        this.a = p10;
    }

    public void onReceive(Context context, Intent intent) {
        TextUtils.equals((CharSequence)intent.getAction(), (CharSequence)"android.intent.action.CONFIGURATION_CHANGED");
    }
}

