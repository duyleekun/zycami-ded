/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Binder
 *  android.os.Handler
 *  android.os.Message
 */
package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ba;
import com.xiaomi.push.service.XMJobService$a$a;
import com.xiaomi.push.service.XMPushService;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMJobService$a
extends JobService {
    public Binder a;
    private Handler a = null;

    public XMJobService$a(Service service) {
        int n10 = 1;
        Binder binder = new Object[n10];
        Intent intent = new Intent();
        binder[0] = intent;
        this.a = binder = (Binder)ba.a((Object)this, "onBind", (Object[])binder);
        Object[] objectArray = new Object[n10];
        objectArray[0] = service;
        ba.a((Object)this, "attachBaseContext", objectArray);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        Object object = new StringBuilder();
        object.append("Job started ");
        int bl2 = jobParameters.getJobId();
        object.append(bl2);
        b.a(object.toString());
        object = new Intent((Context)this, XMPushService.class);
        object.setAction("com.xiaomi.push.timer");
        String string2 = this.getPackageName();
        object.setPackage(string2);
        this.startService((Intent)object);
        object = this.a;
        if (object == null) {
            object = new XMJobService$a$a(this);
            this.a = object;
        }
        object = this.a;
        boolean bl3 = true;
        jobParameters = Message.obtain((Handler)object, (int)(bl3 ? 1 : 0), (Object)jobParameters);
        object.sendMessage((Message)jobParameters);
        return bl3;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Job stop ");
        int n10 = jobParameters.getJobId();
        stringBuilder.append(n10);
        b.a(stringBuilder.toString());
        return false;
    }
}

