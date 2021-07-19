/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.exoplayer2.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public final class PlatformScheduler$PlatformSchedulerService
extends JobService {
    public boolean onStartJob(JobParameters object) {
        CharSequence charSequence;
        Object object2 = object.getExtras();
        int n10 = object2.getInt((String)(charSequence = "requirements"));
        Object object3 = new Requirements(n10);
        int n11 = ((Requirements)object3).getNotMetRequirements((Context)this);
        if (n11 == 0) {
            object = (String)Assertions.checkNotNull(object2.getString("service_action"));
            object2 = (String)Assertions.checkNotNull(object2.getString("service_package"));
            object3 = new Intent((String)object);
            object = object3.setPackage((String)object2);
            Util.startForegroundService((Context)this, (Intent)object);
        } else {
            charSequence = new StringBuilder(33);
            ((StringBuilder)charSequence).append("Requirements not met: ");
            ((StringBuilder)charSequence).append(n11);
            object2 = ((StringBuilder)charSequence).toString();
            object3 = "PlatformScheduler";
            Log.w((String)object3, (String)object2);
            boolean bl2 = true;
            this.jobFinished((JobParameters)object, bl2);
        }
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}

