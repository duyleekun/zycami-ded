/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob;

import android.os.Handler;
import android.os.Message;
import com.mob.MobSDK$2;
import com.mob.PrivacyPolicy;

public class MobSDK$2$1
implements Handler.Callback {
    public final /* synthetic */ PrivacyPolicy a;
    public final /* synthetic */ MobSDK$2 b;

    public MobSDK$2$1(MobSDK$2 var1_1, PrivacyPolicy privacyPolicy) {
        this.b = var1_1;
        this.a = privacyPolicy;
    }

    public boolean handleMessage(Message object) {
        object = this.b.c;
        PrivacyPolicy privacyPolicy = this.a;
        object.onComplete(privacyPolicy);
        return false;
    }
}

