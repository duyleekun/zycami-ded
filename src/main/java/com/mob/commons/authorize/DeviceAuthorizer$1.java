/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.mob.commons.authorize;

import android.text.TextUtils;
import com.mob.commons.MobProduct;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public final class DeviceAuthorizer$1
extends Thread {
    public final /* synthetic */ MobProduct a;

    public DeviceAuthorizer$1(MobProduct mobProduct) {
        this.a = mobProduct;
    }

    public void run() {
        block6: {
            Object object = this.a;
            Object object2 = DeviceAuthorizer.a;
            object = DeviceAuthorizer.a((MobProduct)object, (String)object2);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block6;
            try {
                DeviceAuthorizer.a = object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
    }
}

