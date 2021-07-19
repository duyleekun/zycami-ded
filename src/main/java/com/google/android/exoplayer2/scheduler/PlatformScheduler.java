/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.PersistableBundle
 */
package com.google.android.exoplayer2.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.scheduler.PlatformScheduler$PlatformSchedulerService;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public final class PlatformScheduler
implements Scheduler {
    private static final String KEY_REQUIREMENTS = "requirements";
    private static final String KEY_SERVICE_ACTION = "service_action";
    private static final String KEY_SERVICE_PACKAGE = "service_package";
    private static final int SUPPORTED_REQUIREMENTS = 0;
    private static final String TAG = "PlatformScheduler";
    private final int jobId;
    private final JobScheduler jobScheduler;
    private final ComponentName jobServiceComponentName;

    static {
        int n10 = Util.SDK_INT;
        int n11 = 26;
        n10 = n10 >= n11 ? 16 : 0;
        SUPPORTED_REQUIREMENTS = n10 | 0xF;
    }

    public PlatformScheduler(Context context, int n10) {
        ComponentName componentName;
        context = context.getApplicationContext();
        this.jobId = n10;
        this.jobServiceComponentName = componentName = new ComponentName(context, PlatformScheduler$PlatformSchedulerService.class);
        context = (JobScheduler)Assertions.checkNotNull((JobScheduler)context.getSystemService("jobscheduler"));
        this.jobScheduler = context;
    }

    private static JobInfo buildJobInfo(int n10, ComponentName componentName, Requirements requirements, String string2, String string3) {
        int n11 = SUPPORTED_REQUIREMENTS;
        Object object = requirements.filterRequirements(n11);
        boolean n12 = ((Requirements)object).equals(requirements);
        if (!n12) {
            n11 = ((Requirements)object).getRequirements();
            int n14 = requirements.getRequirements();
            n14 = 46;
            StringBuilder stringBuilder = new StringBuilder(n14);
            stringBuilder.append("Ignoring unsupported requirements: ");
            stringBuilder.append(n11 ^= n13);
            object = stringBuilder.toString();
            String string4 = TAG;
            Log.w(string4, (String)object);
        }
        object = new JobInfo.Builder(n10, componentName);
        n10 = (int)(requirements.isUnmeteredNetworkRequired() ? 1 : 0);
        int n15 = 1;
        if (n10 != 0) {
            n10 = 2;
            object.setRequiredNetworkType(n10);
        } else {
            n10 = (int)(requirements.isNetworkRequired() ? 1 : 0);
            if (n10 != 0) {
                object.setRequiredNetworkType(n15);
            }
        }
        n10 = (int)(requirements.isIdleRequired() ? 1 : 0);
        object.setRequiresDeviceIdle(n10 != 0);
        n10 = (int)(requirements.isChargingRequired() ? 1 : 0);
        object.setRequiresCharging(n10 != 0);
        n10 = Util.SDK_INT;
        int n16 = 26;
        if (n10 >= n16 && (n10 = (int)(requirements.isStorageNotLowRequired() ? 1 : 0)) != 0) {
            object.setRequiresStorageNotLow(n15 != 0);
        }
        object.setPersisted(n15 != 0);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(KEY_SERVICE_ACTION, string2);
        persistableBundle.putString(KEY_SERVICE_PACKAGE, string3);
        n15 = requirements.getRequirements();
        persistableBundle.putInt(KEY_REQUIREMENTS, n15);
        object.setExtras(persistableBundle);
        return object.build();
    }

    public boolean cancel() {
        JobScheduler jobScheduler = this.jobScheduler;
        int n10 = this.jobId;
        jobScheduler.cancel(n10);
        return true;
    }

    public Requirements getSupportedRequirements(Requirements requirements) {
        int n10 = SUPPORTED_REQUIREMENTS;
        return requirements.filterRequirements(n10);
    }

    public boolean schedule(Requirements requirements, String string2, String string3) {
        int n10;
        string2 = this.jobScheduler;
        int n11 = this.jobId;
        ComponentName componentName = this.jobServiceComponentName;
        int n12 = string2.schedule((JobInfo)(requirements = PlatformScheduler.buildJobInfo(n11, componentName, requirements, string3, string2)));
        if (n12 != (n10 = 1)) {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }
}

