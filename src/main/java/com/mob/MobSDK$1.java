/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.mob;

import android.content.Context;
import com.mob.MobSDK;
import com.mob.commons.MobProductCollector;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.authorize.a;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public final class MobSDK$1
extends Thread {
    public void run() {
        MobProductCollector.collect();
        Context context = MobSDK.a();
        a.a(context);
        context = null;
        try {
            DeviceAuthorizer.authorize(null);
            MobSDK.b();
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
    }
}

