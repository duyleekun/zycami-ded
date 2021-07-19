/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.util.Base64
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class AlarmManagerScheduler
implements WorkScheduler {
    public static final String ATTEMPT_NUMBER = "attemptNumber";
    public static final String BACKEND_NAME = "backendName";
    public static final String EVENT_PRIORITY = "priority";
    public static final String EXTRAS = "extras";
    private static final String LOG_TAG = "AlarmManagerScheduler";
    private AlarmManager alarmManager;
    private final Clock clock;
    private final SchedulerConfig config;
    private final Context context;
    private final EventStore eventStore;

    public AlarmManagerScheduler(Context context, EventStore eventStore, AlarmManager alarmManager, Clock clock, SchedulerConfig schedulerConfig) {
        this.context = context;
        this.eventStore = eventStore;
        this.alarmManager = alarmManager;
        this.clock = clock;
        this.config = schedulerConfig;
    }

    public AlarmManagerScheduler(Context context, EventStore eventStore, Clock clock, SchedulerConfig schedulerConfig) {
        Object object;
        Object object2 = object = context.getSystemService("alarm");
        object2 = (AlarmManager)object;
        this(context, eventStore, (AlarmManager)object2, clock, schedulerConfig);
    }

    public boolean isJobServiceOn(Intent intent) {
        Context context = this.context;
        boolean bl2 = false;
        int n10 = 0x20000000;
        if ((intent = PendingIntent.getBroadcast((Context)context, (int)0, (Intent)intent, (int)n10)) != null) {
            bl2 = true;
        }
        return bl2;
    }

    public void schedule(TransportContext transportContext, int n10) {
        this.schedule(transportContext, n10, false);
    }

    public void schedule(TransportContext object, int n10, boolean bl2) {
        Object object2;
        Object object3 = new Uri.Builder();
        Object object4 = ((TransportContext)object).getBackendName();
        object3.appendQueryParameter(BACKEND_NAME, (String)object4);
        int n11 = PriorityMapping.toInt(((TransportContext)object).getPriority());
        object4 = String.valueOf(n11);
        object3.appendQueryParameter(EVENT_PRIORITY, (String)object4);
        object4 = ((TransportContext)object).getExtras();
        if (object4 != null) {
            object4 = Base64.encodeToString((byte[])((TransportContext)object).getExtras(), (int)0);
            object2 = EXTRAS;
            object3.appendQueryParameter((String)object2, (String)object4);
        }
        object2 = this.context;
        Class<AlarmManagerSchedulerBroadcastReceiver> clazz = AlarmManagerSchedulerBroadcastReceiver.class;
        object4 = new Intent(object2, clazz);
        object3 = object3.build();
        object4.setData((Uri)object3);
        object4.putExtra(ATTEMPT_NUMBER, n10);
        object3 = LOG_TAG;
        if (!bl2 && (bl2 = this.isJobServiceOn((Intent)object4))) {
            Logging.d((String)object3, "Upload for context %s is already scheduled. Returning...", object);
            return;
        }
        long l10 = this.eventStore.getNextCallTime((TransportContext)object);
        AlarmManager alarmManager = this.config;
        Priority priority = ((TransportContext)object).getPriority();
        long l11 = alarmManager.getScheduleDelay(priority, l10, n10);
        alarmManager = new Object[4];
        alarmManager[0] = object;
        Long l12 = l11;
        alarmManager[1] = l12;
        object2 = l10;
        alarmManager[2] = object2;
        object = n10;
        n10 = 3;
        alarmManager[n10] = object;
        Logging.d((String)object3, "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", (Object[])alarmManager);
        object = PendingIntent.getBroadcast((Context)this.context, (int)0, (Intent)object4, (int)0);
        alarmManager = this.alarmManager;
        long l13 = this.clock.getTime() + l11;
        alarmManager.set(n10, l13, (PendingIntent)object);
    }
}

