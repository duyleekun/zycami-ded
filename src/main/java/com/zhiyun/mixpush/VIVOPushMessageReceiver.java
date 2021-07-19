/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.mixpush;

import android.content.Context;
import cn.leancloud.AVVIVOPushMessageReceiver;
import d.r.a.r.c;
import m.a.a;

public class VIVOPushMessageReceiver
extends AVVIVOPushMessageReceiver {
    public void onNotificationMessageClicked(Context objectArray, c object) {
        objectArray = new Object[]{object = ((c)object).toString()};
        a.b("vivo received MessageClick Event. %s", objectArray);
    }
}

