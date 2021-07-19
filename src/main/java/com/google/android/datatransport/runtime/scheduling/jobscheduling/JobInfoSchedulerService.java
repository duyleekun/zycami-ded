/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.os.PersistableBundle
 *  android.util.Base64
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportContext$Builder;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService$$Lambda$1;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class JobInfoSchedulerService
extends JobService {
    public static /* synthetic */ void lambda$onStartJob$0(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        jobInfoSchedulerService.jobFinished(jobParameters, false);
    }

    public boolean onStartJob(JobParameters object) {
        Object object2 = object.getExtras().getString("backendName");
        Object object3 = object.getExtras().getString("extras");
        int n10 = object.getExtras().getInt("priority");
        PersistableBundle persistableBundle = object.getExtras();
        int n11 = persistableBundle.getInt("attemptNumber");
        TransportRuntime.initialize(this.getApplicationContext());
        TransportContext$Builder transportContext$Builder = TransportContext.builder();
        object2 = transportContext$Builder.setBackendName((String)object2);
        Priority priority = PriorityMapping.valueOf(n10);
        object2 = ((TransportContext$Builder)object2).setPriority(priority);
        if (object3 != null) {
            n10 = 0;
            priority = null;
            object3 = Base64.decode((String)object3, (int)0);
            ((TransportContext$Builder)object2).setExtras((byte[])object3);
        }
        object3 = TransportRuntime.getInstance().getUploader();
        object2 = ((TransportContext$Builder)object2).build();
        object = JobInfoSchedulerService$$Lambda$1.lambdaFactory$(this, object);
        ((Uploader)object3).upload((TransportContext)object2, n11, (Runnable)object);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}

