/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import java.util.concurrent.Callable;

public class IntentCallable
implements Callable {
    public Context a;
    public Intent b;
    public String c;

    public IntentCallable(Context context, Intent intent, String string2) {
        this.a = context;
        this.b = intent;
        this.c = string2;
    }

    public Void call() {
        Context context = this.a;
        Object object = this.b;
        context.sendBroadcast(object);
        context = this.a;
        object = this.c;
        ErrorEnum errorEnum = ErrorEnum.SUCCESS;
        PushBiUtil.reportExit(context, "push.setNotifyFlag", (String)object, errorEnum);
        return null;
    }
}

