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
 *  android.util.Base64
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

public class JobInfoScheduler
implements WorkScheduler {
    public static final String ATTEMPT_NUMBER = "attemptNumber";
    public static final String BACKEND_NAME = "backendName";
    public static final String EVENT_PRIORITY = "priority";
    public static final String EXTRAS = "extras";
    private static final String LOG_TAG = "JobInfoScheduler";
    private final SchedulerConfig config;
    private final Context context;
    private final EventStore eventStore;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.context = context;
        this.eventStore = eventStore;
        this.config = schedulerConfig;
    }

    private boolean isJobServiceOn(JobScheduler object, int n10, int n11) {
        boolean bl2;
        block2: {
            int n12;
            JobInfo jobInfo;
            int n13;
            object = object.getAllPendingJobs().iterator();
            do {
                n13 = object.hasNext();
                bl2 = false;
                if (n13 == 0) break block2;
                jobInfo = (JobInfo)object.next();
                PersistableBundle persistableBundle = jobInfo.getExtras();
                String string2 = ATTEMPT_NUMBER;
                n12 = persistableBundle.getInt(string2);
            } while ((n13 = jobInfo.getId()) != n10);
            if (n12 >= n11) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int getJobId(TransportContext object) {
        Adler32 adler32 = new Adler32();
        Object object2 = this.context.getPackageName();
        Object object3 = "UTF-8";
        Charset charset = Charset.forName((String)object3);
        object2 = ((String)object2).getBytes(charset);
        adler32.update((byte[])object2);
        object2 = ((TransportContext)object).getBackendName();
        object3 = Charset.forName((String)object3);
        object2 = ((String)object2).getBytes((Charset)object3);
        adler32.update((byte[])object2);
        int n10 = 4;
        object2 = ByteBuffer.allocate(n10);
        object3 = ((TransportContext)object).getPriority();
        int n11 = PriorityMapping.toInt((Priority)((Object)object3));
        object2 = ((ByteBuffer)object2).putInt(n11).array();
        adler32.update((byte[])object2);
        object2 = ((TransportContext)object).getExtras();
        if (object2 != null) {
            object = ((TransportContext)object).getExtras();
            adler32.update((byte[])object);
        }
        return (int)adler32.getValue();
    }

    public void schedule(TransportContext transportContext, int n10) {
        this.schedule(transportContext, n10, false);
    }

    public void schedule(TransportContext object, int n10, boolean bl2) {
        Context context = this.context;
        Object[] objectArray = new ComponentName(context, JobInfoSchedulerService.class);
        context = this.context;
        Object object2 = "jobscheduler";
        context = (JobScheduler)context.getSystemService((String)object2);
        int n11 = this.getJobId((TransportContext)object);
        String string2 = LOG_TAG;
        if (!bl2 && (bl2 = this.isJobServiceOn((JobScheduler)context, n11, n10))) {
            Logging.d(string2, "Upload for context %s is already scheduled. Returning...", object);
            return;
        }
        long l10 = this.eventStore.getNextCallTime((TransportContext)object);
        Object object3 = this.config;
        JobInfo.Builder builder = new JobInfo.Builder(n11, (ComponentName)objectArray);
        Object object4 = object.getPriority();
        JobInfo.Builder builder2 = ((SchedulerConfig)object3).configureJob(builder, (Priority)((Object)object4), l10, n10);
        objectArray = new PersistableBundle();
        objectArray.putInt(ATTEMPT_NUMBER, n10);
        object3 = object.getBackendName();
        objectArray.putString(BACKEND_NAME, (String)object3);
        int n12 = PriorityMapping.toInt(object.getPriority());
        objectArray.putInt(EVENT_PRIORITY, n12);
        object3 = object.getExtras();
        builder = null;
        if (object3 != null) {
            object3 = Base64.encodeToString((byte[])object.getExtras(), (int)0);
            object4 = EXTRAS;
            objectArray.putString((String)object4, (String)object3);
        }
        builder2.setExtras((PersistableBundle)objectArray);
        objectArray = new Object[5];
        objectArray[0] = object;
        objectArray[1] = object2 = Integer.valueOf(n11);
        object3 = this.config;
        object = object.getPriority();
        object = ((SchedulerConfig)object3).getScheduleDelay((Priority)((Object)object), l10, n10);
        objectArray[2] = object;
        objectArray[3] = object2 = Long.valueOf(l10);
        Integer n13 = n10;
        objectArray[4] = n13;
        Logging.d(string2, "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objectArray);
        object = builder2.build();
        context.schedule((JobInfo)object);
    }
}

