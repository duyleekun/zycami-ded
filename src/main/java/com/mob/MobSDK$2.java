/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 */
package com.mob;

import android.os.Handler;
import com.mob.MobSDK$2$1;
import com.mob.MobSDK$2$2;
import com.mob.PrivacyPolicy;
import com.mob.PrivacyPolicy$OnPolicyListener;
import com.mob.commons.h;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.UIHandler;
import java.util.Locale;

public final class MobSDK$2
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Locale b;
    public final /* synthetic */ PrivacyPolicy$OnPolicyListener c;

    public MobSDK$2(int n10, Locale locale, PrivacyPolicy$OnPolicyListener privacyPolicy$OnPolicyListener) {
        this.a = n10;
        this.b = locale;
        this.c = privacyPolicy$OnPolicyListener;
    }

    public void run() {
        int n10;
        block17: {
            n10 = 2;
            Object var2_2 = null;
            int n11 = this.a;
            int n12 = 1;
            if (n11 != n12) break block17;
            n10 = n12;
        }
        Object object = new h();
        Object object2 = this.b;
        PrivacyPolicy privacyPolicy = ((h)object).a(n10, (Locale)object2);
        object = new MobSDK$2$1(this, privacyPolicy);
        try {
            UIHandler.sendEmptyMessage(0, (Handler.Callback)object);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
            object = this.c;
            try {
                object.onComplete(privacyPolicy);
            }
            catch (Throwable throwable2) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable2);
                object = new MobSDK$2$2(this, throwable2);
                try {
                    UIHandler.sendEmptyMessage(0, (Handler.Callback)object);
                }
                catch (Throwable throwable3) {
                    object = MobLog.getInstance();
                    ((NLog)object).d(throwable3);
                    PrivacyPolicy$OnPolicyListener privacyPolicy$OnPolicyListener = this.c;
                    privacyPolicy$OnPolicyListener.onFailure(throwable2);
                }
            }
        }
    }
}

