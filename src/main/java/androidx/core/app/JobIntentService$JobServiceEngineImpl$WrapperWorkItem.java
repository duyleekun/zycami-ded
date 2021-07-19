/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobWorkItem
 *  android.content.Intent
 */
package androidx.core.app;

import android.app.job.JobWorkItem;
import android.content.Intent;
import androidx.core.app.JobIntentService$GenericWorkItem;
import androidx.core.app.JobIntentService$JobServiceEngineImpl;

public final class JobIntentService$JobServiceEngineImpl$WrapperWorkItem
implements JobIntentService$GenericWorkItem {
    public final JobWorkItem mJobWork;
    public final /* synthetic */ JobIntentService$JobServiceEngineImpl this$0;

    public JobIntentService$JobServiceEngineImpl$WrapperWorkItem(JobIntentService$JobServiceEngineImpl jobIntentService$JobServiceEngineImpl, JobWorkItem jobWorkItem) {
        this.this$0 = jobIntentService$JobServiceEngineImpl;
        this.mJobWork = jobWorkItem;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void complete() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            JobIntentService$JobServiceEngineImpl jobIntentService$JobServiceEngineImpl = this.this$0;
            jobIntentService$JobServiceEngineImpl = jobIntentService$JobServiceEngineImpl.mParams;
            if (jobIntentService$JobServiceEngineImpl != null) {
                JobWorkItem jobWorkItem = this.mJobWork;
                jobIntentService$JobServiceEngineImpl.completeWork(jobWorkItem);
            }
            return;
        }
    }

    public Intent getIntent() {
        return this.mJobWork.getIntent();
    }
}

