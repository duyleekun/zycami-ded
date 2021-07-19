/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.xiaomi.push.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fc;

public class XMJobService$a$a
extends Handler {
    public JobService a;

    public XMJobService$a$a(JobService jobService) {
        Looper looper = jobService.getMainLooper();
        super(looper);
        this.a = jobService;
    }

    public void handleMessage(Message message) {
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11) {
            message = (JobParameters)message.obj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Job finished ");
            int n12 = message.getJobId();
            stringBuilder.append(n12);
            b.a(stringBuilder.toString());
            stringBuilder = this.a;
            n12 = 0;
            stringBuilder.jobFinished((JobParameters)message, false);
            int n13 = message.getJobId();
            if (n13 == n11) {
                fc.a(false);
            }
        }
    }
}

