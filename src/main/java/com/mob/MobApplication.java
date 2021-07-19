/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package com.mob;

import android.app.Application;
import android.content.Context;
import com.mob.MobSDK;
import com.mob.tools.proguard.ProtectedMemberKeeper;

public class MobApplication
extends Application
implements ProtectedMemberKeeper {
    public String getAppSecret() {
        return null;
    }

    public String getAppkey() {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        String string2 = this.getAppkey();
        String string3 = this.getAppSecret();
        MobSDK.init((Context)this, string2, string3);
    }
}

