/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;

public class DeviceHelper$1
implements Handler.Callback {
    public final /* synthetic */ DeviceHelper this$0;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ Intent val$intent;
    public final /* synthetic */ int[] val$res;

    public DeviceHelper$1(DeviceHelper deviceHelper, int[] nArray, Context context, Intent intent) {
        this.this$0 = deviceHelper;
        this.val$res = nArray;
        this.val$context = context;
        this.val$intent = intent;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean handleMessage(Message object) {
        object = this.val$res;
        synchronized (object) {
            Object var2_2 = null;
            try {
                int n10;
                int[] nArray = this.val$res;
                DeviceHelper deviceHelper = this.this$0;
                Context context = this.val$context;
                Intent intent = this.val$intent;
                nArray[0] = n10 = deviceHelper.sa(context, intent);
                nArray = this.val$res;
                nArray.notifyAll();
            }
            catch (Throwable throwable) {
                try {
                    int n11;
                    Object object2 = this.val$res;
                    object2[0] = n11 = 2;
                    object2 = MobLog.getInstance();
                    ((NLog)object2).d(throwable);
                }
                finally {
                    int[] nArray = this.val$res;
                    nArray.notifyAll();
                }
            }
            return false;
        }
    }
}

