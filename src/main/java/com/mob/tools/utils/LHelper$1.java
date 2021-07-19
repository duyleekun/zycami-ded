/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.utils;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.LHelper;

public class LHelper$1
implements Handler.Callback {
    public final /* synthetic */ LHelper this$0;

    public LHelper$1(LHelper lHelper) {
        this.this$0 = lHelper;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean handleMessage(Message object) {
        try {
            int n10 = object.what;
            if (n10 == 0) {
                LHelper lHelper = this.this$0;
                LHelper.access$000(lHelper);
                return false;
            }
            int n11 = 1;
            if (n10 == n11) {
                LHelper lHelper = this.this$0;
                LHelper.access$100(lHelper);
                return false;
            }
            n11 = 2;
            if (n10 != n11) {
                return false;
            }
            LHelper lHelper = this.this$0;
            LHelper.access$200(lHelper);
            return false;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            LHelper lHelper = this.this$0;
            LHelper.access$300(lHelper);
        }
        return false;
    }
}

