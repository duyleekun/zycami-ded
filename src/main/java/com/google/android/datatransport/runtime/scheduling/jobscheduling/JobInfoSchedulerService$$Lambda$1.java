/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

public final class JobInfoSchedulerService$$Lambda$1
implements Runnable {
    private final JobInfoSchedulerService arg$1;
    private final JobParameters arg$2;

    private JobInfoSchedulerService$$Lambda$1(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.arg$1 = jobInfoSchedulerService;
        this.arg$2 = jobParameters;
    }

    public static Runnable lambdaFactory$(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        JobInfoSchedulerService$$Lambda$1 jobInfoSchedulerService$$Lambda$1 = new JobInfoSchedulerService$$Lambda$1(jobInfoSchedulerService, jobParameters);
        return jobInfoSchedulerService$$Lambda$1;
    }

    public void run() {
        JobInfoSchedulerService jobInfoSchedulerService = this.arg$1;
        JobParameters jobParameters = this.arg$2;
        JobInfoSchedulerService.lambda$onStartJob$0(jobInfoSchedulerService, jobParameters);
    }
}

