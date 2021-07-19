/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.app.job.JobParameters
 *  android.app.job.JobServiceEngine
 *  android.app.job.JobWorkItem
 *  android.os.IBinder
 */
package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.os.IBinder;
import androidx.core.app.JobIntentService;
import androidx.core.app.JobIntentService$CompatJobEngine;
import androidx.core.app.JobIntentService$GenericWorkItem;
import androidx.core.app.JobIntentService$JobServiceEngineImpl$WrapperWorkItem;

public final class JobIntentService$JobServiceEngineImpl
extends JobServiceEngine
implements JobIntentService$CompatJobEngine {
    public static final boolean DEBUG = false;
    public static final String TAG = "JobServiceEngineImpl";
    public final Object mLock;
    public JobParameters mParams;
    public final JobIntentService mService;

    public JobIntentService$JobServiceEngineImpl(JobIntentService jobIntentService) {
        super((Service)jobIntentService);
        Object object;
        this.mLock = object = new Object();
        this.mService = jobIntentService;
    }

    public IBinder compatGetBinder() {
        return this.getBinder();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public JobIntentService$GenericWorkItem dequeueWork() {
        ClassLoader classLoader;
        JobParameters jobParameters;
        Object object = this.mLock;
        synchronized (object) {
            jobParameters = this.mParams;
            classLoader = null;
            if (jobParameters == null) {
                return null;
            }
            jobParameters = jobParameters.dequeueWork();
        }
        if (jobParameters == null) return null;
        object = jobParameters.getIntent();
        classLoader = this.mService.getClassLoader();
        object.setExtrasClassLoader(classLoader);
        return new JobIntentService$JobServiceEngineImpl$WrapperWorkItem(this, (JobWorkItem)jobParameters);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        this.mParams = jobParameters;
        this.mService.ensureProcessorRunningLocked(false);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onStopJob(JobParameters object) {
        object = this.mService;
        boolean bl2 = ((JobIntentService)((Object)object)).doStopCurrentWork();
        Object object2 = this.mLock;
        synchronized (object2) {
            this.mParams = null;
            return bl2;
        }
    }
}

