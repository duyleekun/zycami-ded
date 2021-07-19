/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
 *  android.os.IBinder
 */
package androidx.core.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.JobIntentService$CommandProcessor;
import androidx.core.app.JobIntentService$CompatJobEngine;
import androidx.core.app.JobIntentService$CompatWorkEnqueuer;
import androidx.core.app.JobIntentService$CompatWorkItem;
import androidx.core.app.JobIntentService$GenericWorkItem;
import androidx.core.app.JobIntentService$JobServiceEngineImpl;
import androidx.core.app.JobIntentService$JobWorkEnqueuer;
import androidx.core.app.JobIntentService$WorkEnqueuer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;

public abstract class JobIntentService
extends Service {
    public static final boolean DEBUG = false;
    public static final String TAG = "JobIntentService";
    public static final HashMap sClassWorkEnqueuer;
    public static final Object sLock;
    public final ArrayList mCompatQueue;
    public JobIntentService$WorkEnqueuer mCompatWorkEnqueuer;
    public JobIntentService$CommandProcessor mCurProcessor;
    public boolean mDestroyed;
    public boolean mInterruptIfStopped;
    public JobIntentService$CompatJobEngine mJobImpl;
    public boolean mStopped;

    static {
        HashMap hashMap = new HashMap();
        sLock = hashMap;
        sClassWorkEnqueuer = hashMap = new HashMap();
    }

    public JobIntentService() {
        ArrayList arrayList = null;
        this.mInterruptIfStopped = false;
        this.mStopped = false;
        this.mDestroyed = false;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            n10 = 0;
            arrayList = null;
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = arrayList = new ArrayList();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void enqueueWork(Context object, ComponentName componentName, int n10, Intent intent) {
        if (intent != null) {
            Object object2 = sLock;
            synchronized (object2) {
                boolean bl2 = true;
                object = JobIntentService.getWorkEnqueuer((Context)object, componentName, bl2, n10);
                ((JobIntentService$WorkEnqueuer)object).ensureJobId(n10);
                ((JobIntentService$WorkEnqueuer)object).enqueueWork(intent);
                return;
            }
        }
        object = new IllegalArgumentException("work must not be null");
        throw object;
    }

    public static void enqueueWork(Context context, Class clazz, int n10, Intent intent) {
        ComponentName componentName = new ComponentName(context, clazz);
        JobIntentService.enqueueWork(context, componentName, n10, intent);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static JobIntentService$WorkEnqueuer getWorkEnqueuer(Context object, ComponentName componentName, boolean bl2, int n10) {
        void var1_2;
        HashMap hashMap = sClassWorkEnqueuer;
        JobIntentService$WorkEnqueuer jobIntentService$WorkEnqueuer = (JobIntentService$WorkEnqueuer)hashMap.get(var1_2);
        if (jobIntentService$WorkEnqueuer == null) {
            void var8_11;
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 26;
            if (n11 >= n12) {
                void var3_4;
                void var2_3;
                if (var2_3 == false) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't be here without a job id");
                    throw illegalArgumentException;
                }
                JobIntentService$JobWorkEnqueuer jobIntentService$JobWorkEnqueuer = new JobIntentService$JobWorkEnqueuer((Context)object, (ComponentName)var1_2, (int)var3_4);
            } else {
                JobIntentService$CompatWorkEnqueuer jobIntentService$CompatWorkEnqueuer = new JobIntentService$CompatWorkEnqueuer((Context)object, (ComponentName)var1_2);
            }
            jobIntentService$WorkEnqueuer = var8_11;
            hashMap.put(var1_2, var8_11);
        }
        return jobIntentService$WorkEnqueuer;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public JobIntentService$GenericWorkItem dequeueWork() {
        Object object = this.mJobImpl;
        if (object != null) {
            return object.dequeueWork();
        }
        object = this.mCompatQueue;
        synchronized (object) {
            Object object2 = this.mCompatQueue;
            int n10 = ((ArrayList)object2).size();
            if (n10 <= 0) return null;
            object2 = this.mCompatQueue;
            object2 = ((ArrayList)object2).remove(0);
            return (JobIntentService$GenericWorkItem)object2;
        }
    }

    public boolean doStopCurrentWork() {
        JobIntentService$CommandProcessor jobIntentService$CommandProcessor = this.mCurProcessor;
        if (jobIntentService$CommandProcessor != null) {
            boolean bl2 = this.mInterruptIfStopped;
            jobIntentService$CommandProcessor.cancel(bl2);
        }
        this.mStopped = true;
        return this.onStopCurrentWork();
    }

    public void ensureProcessorRunningLocked(boolean bl2) {
        Object object = this.mCurProcessor;
        if (object == null) {
            object = new JobIntentService$CommandProcessor(this);
            this.mCurProcessor = object;
            object = this.mCompatWorkEnqueuer;
            if (object != null && bl2) {
                ((JobIntentService$WorkEnqueuer)object).serviceProcessingStarted();
            }
            JobIntentService$CommandProcessor jobIntentService$CommandProcessor = this.mCurProcessor;
            object = AsyncTask.THREAD_POOL_EXECUTOR;
            Object[] objectArray = new Void[]{};
            jobIntentService$CommandProcessor.executeOnExecutor((Executor)object, objectArray);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    public IBinder onBind(Intent object) {
        object = this.mJobImpl;
        if (object != null) {
            return object.compatGetBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        int n10 = Build.VERSION.SDK_INT;
        Class<?> clazz = null;
        int n11 = 26;
        if (n10 >= n11) {
            JobIntentService$JobServiceEngineImpl jobIntentService$JobServiceEngineImpl = new JobIntentService$JobServiceEngineImpl(this);
            this.mJobImpl = jobIntentService$JobServiceEngineImpl;
            this.mCompatWorkEnqueuer = null;
        } else {
            this.mJobImpl = null;
            clazz = ((Object)((Object)this)).getClass();
            Object object = new ComponentName((Context)this, clazz);
            clazz = null;
            object = JobIntentService.getWorkEnqueuer((Context)this, object, false, 0);
            this.mCompatWorkEnqueuer = object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.mCompatQueue;
        if (arrayList == null) return;
        synchronized (arrayList) {
            boolean bl2;
            this.mDestroyed = bl2 = true;
            JobIntentService$WorkEnqueuer jobIntentService$WorkEnqueuer = this.mCompatWorkEnqueuer;
            jobIntentService$WorkEnqueuer.serviceProcessingFinished();
            return;
        }
    }

    public abstract void onHandleWork(Intent var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int onStartCommand(Intent intent, int n10, int n11) {
        ArrayList arrayList = this.mCompatQueue;
        if (arrayList == null) {
            return 2;
        }
        this.mCompatWorkEnqueuer.serviceStartReceived();
        arrayList = this.mCompatQueue;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.mCompatQueue;
            if (intent == null) {
                intent = new Intent();
            }
            JobIntentService$CompatWorkItem jobIntentService$CompatWorkItem = new JobIntentService$CompatWorkItem(this, intent, n11);
            arrayList2.add(jobIntentService$CompatWorkItem);
            boolean bl2 = true;
            this.ensureProcessorRunningLocked(bl2);
            return 3;
        }
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void processorFinished() {
        ArrayList arrayList = this.mCompatQueue;
        if (arrayList == null) return;
        synchronized (arrayList) {
            int n10 = 0;
            Object object = null;
            this.mCurProcessor = null;
            object = this.mCompatQueue;
            if (object != null && (n10 = ((ArrayList)object).size()) > 0) {
                n10 = 0;
                object = null;
                this.ensureProcessorRunningLocked(false);
            } else {
                n10 = (int)(this.mDestroyed ? 1 : 0);
                if (n10 != 0) return;
                object = this.mCompatWorkEnqueuer;
                ((JobIntentService$WorkEnqueuer)object).serviceProcessingFinished();
            }
            return;
        }
    }

    public void setInterruptIfStopped(boolean bl2) {
        this.mInterruptIfStopped = bl2;
    }
}

