/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler$$Lambda$1;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler$$Lambda$2;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class DefaultScheduler
implements Scheduler {
    private static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    private final BackendRegistry backendRegistry;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler workScheduler;

    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.backendRegistry = backendRegistry;
        this.workScheduler = workScheduler;
        this.eventStore = eventStore;
        this.guard = synchronizationGuard;
    }

    public static /* synthetic */ Object lambda$schedule$0(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        defaultScheduler.eventStore.persist(transportContext, eventInternal);
        defaultScheduler.workScheduler.schedule(transportContext, 1);
        return null;
    }

    public static /* synthetic */ void lambda$schedule$1(DefaultScheduler object, TransportContext object2, TransportScheduleCallback transportScheduleCallback, EventInternal objectArray) {
        Object object3;
        block17: {
            object3 = ((DefaultScheduler)object).backendRegistry;
            String string2 = ((TransportContext)object2).getBackendName();
            object3 = object3.get(string2);
            if (object3 != null) break block17;
            object = "Transport backend '%s' is not registered";
            int n10 = 1;
            objectArray = new Object[n10];
            object3 = null;
            object2 = ((TransportContext)object2).getBackendName();
            objectArray[0] = object2;
            object = String.format((String)object, objectArray);
            object2 = LOGGER;
            ((Logger)object2).warning((String)object);
            object2 = new IllegalArgumentException((String)object);
            transportScheduleCallback.onSchedule((Exception)object2);
            return;
        }
        objectArray = object3.decorate((EventInternal)objectArray);
        object3 = ((DefaultScheduler)object).guard;
        object = DefaultScheduler$$Lambda$2.lambdaFactory$((DefaultScheduler)object, (TransportContext)object2, (EventInternal)objectArray);
        object3.runCriticalSection((SynchronizationGuard$CriticalSection)object);
        object = null;
        try {
            transportScheduleCallback.onSchedule(null);
        }
        catch (Exception exception) {
            object2 = LOGGER;
            objectArray = new StringBuilder();
            objectArray.append("Error scheduling event ");
            object3 = exception.getMessage();
            objectArray.append((String)object3);
            objectArray = objectArray.toString();
            ((Logger)object2).warning((String)objectArray);
            transportScheduleCallback.onSchedule(exception);
        }
    }

    public void schedule(TransportContext object, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        Executor executor = this.executor;
        object = DefaultScheduler$$Lambda$1.lambdaFactory$(this, (TransportContext)object, transportScheduleCallback, eventInternal);
        executor.execute((Runnable)object);
    }
}

