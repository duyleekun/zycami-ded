/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobScheduler
 *  android.app.job.JobWorkItem
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 */
package androidx.core.app;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService$WorkEnqueuer;

public final class JobIntentService$JobWorkEnqueuer
extends JobIntentService$WorkEnqueuer {
    private final JobInfo mJobInfo;
    private final JobScheduler mJobScheduler;

    public JobIntentService$JobWorkEnqueuer(Context context, ComponentName componentName, int n10) {
        super(componentName);
        this.ensureJobId(n10);
        ComponentName componentName2 = this.mComponentName;
        super(n10, componentName2);
        componentName = componentName.setOverrideDeadline(0L).build();
        this.mJobInfo = componentName;
        context = (JobScheduler)context.getApplicationContext().getSystemService("jobscheduler");
        this.mJobScheduler = context;
    }

    public void enqueueWork(Intent intent) {
        JobScheduler jobScheduler = this.mJobScheduler;
        JobInfo jobInfo = this.mJobInfo;
        JobWorkItem jobWorkItem = new JobWorkItem(intent);
        jobScheduler.enqueue(jobInfo, jobWorkItem);
    }
}

