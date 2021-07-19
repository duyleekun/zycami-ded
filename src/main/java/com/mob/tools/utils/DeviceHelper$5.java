/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.mob.tools.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ReflectHelper$ReflectRunnable;
import java.util.HashMap;

public class DeviceHelper$5
extends BroadcastReceiver {
    public final /* synthetic */ DeviceHelper this$0;
    public final /* synthetic */ ReflectHelper$ReflectRunnable val$callback;

    public DeviceHelper$5(DeviceHelper deviceHelper, ReflectHelper$ReflectRunnable reflectHelper$ReflectRunnable) {
        this.this$0 = deviceHelper;
        this.val$callback = reflectHelper$ReflectRunnable;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onReceive(Context context, Intent object) {
        Class<BroadcastReceiver> clazz;
        String string2;
        boolean bl2;
        Class[] classArray = new HashMap();
        Object[] objectArray = object.getExtras().keySet().iterator();
        while (bl2 = objectArray.hasNext()) {
            string2 = (String)objectArray.next();
            clazz = object.getExtras().get(string2);
            classArray.put(string2, clazz);
        }
        ReflectHelper$ReflectRunnable reflectHelper$ReflectRunnable = this.val$callback;
        if (reflectHelper$ReflectRunnable != null) {
            reflectHelper$ReflectRunnable.run(classArray);
        }
        String string3 = "unregisterReceiver";
        int n10 = 1;
        try {
            objectArray = new Object[n10];
            bl2 = false;
            string2 = null;
        }
        catch (Throwable throwable) {
            return;
        }
        objectArray[0] = this;
        classArray = new Class[n10];
        clazz = BroadcastReceiver.class;
        classArray[0] = clazz;
        ReflectHelper.invokeInstanceMethod((Object)context, string3, objectArray, classArray);
    }
}

