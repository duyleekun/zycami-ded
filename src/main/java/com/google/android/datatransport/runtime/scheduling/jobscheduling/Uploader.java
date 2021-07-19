/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendRequest$Builder;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendResponse$Status;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$1;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$2;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$3;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$4;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$5;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class Uploader {
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler workScheduler;

    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock) {
        this.context = context;
        this.backendRegistry = backendRegistry;
        this.eventStore = eventStore;
        this.workScheduler = workScheduler;
        this.executor = executor;
        this.guard = synchronizationGuard;
        this.clock = clock;
    }

    public static /* synthetic */ Iterable lambda$logAndUpdateState$2(Uploader uploader, TransportContext transportContext) {
        return uploader.eventStore.loadBatch(transportContext);
    }

    public static /* synthetic */ Object lambda$logAndUpdateState$3(Uploader object, BackendResponse object2, Iterable object3, TransportContext transportContext, int n10) {
        BackendResponse$Status backendResponse$Status = ((BackendResponse)object2).getStatus();
        BackendResponse$Status backendResponse$Status2 = BackendResponse$Status.TRANSIENT_ERROR;
        int n11 = 1;
        if (backendResponse$Status == backendResponse$Status2) {
            object2 = ((Uploader)object).eventStore;
            object2.recordFailure((Iterable)object3);
            object = ((Uploader)object).workScheduler;
            object.schedule(transportContext, n10 += n11);
        } else {
            boolean bl2;
            ((Uploader)object).eventStore.recordSuccess((Iterable)object3);
            object3 = ((BackendResponse)object2).getStatus();
            Object object4 = BackendResponse$Status.OK;
            if (object3 == object4) {
                object3 = ((Uploader)object).eventStore;
                object4 = ((Uploader)object).clock;
                long l10 = object4.getTime();
                long l11 = ((BackendResponse)object2).getNextRequestWaitMillis();
                object3.recordNextCallTime(transportContext, l10 += l11);
            }
            if (bl2 = (object2 = ((Uploader)object).eventStore).hasPendingEventsFor(transportContext)) {
                object = ((Uploader)object).workScheduler;
                object.schedule(transportContext, n11, n11 != 0);
            }
        }
        return null;
    }

    public static /* synthetic */ Object lambda$upload$0(Uploader object, TransportContext transportContext, int n10) {
        object = ((Uploader)object).workScheduler;
        object.schedule(transportContext, ++n10);
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void lambda$upload$1(Uploader object, TransportContext transportContext, int n10, Runnable runnable) {
        Throwable throwable2222222;
        block7: {
            block6: {
                SynchronizationGuard synchronizationGuard = ((Uploader)object).guard;
                Object object2 = ((Uploader)object).eventStore;
                object2.getClass();
                object2 = Uploader$$Lambda$4.lambdaFactory$((EventStore)object2);
                synchronizationGuard.runCriticalSection((SynchronizationGuard$CriticalSection)object2);
                boolean bl2 = ((Uploader)object).isNetworkAvailable();
                if (!bl2) {
                    synchronizationGuard = ((Uploader)object).guard;
                    object2 = Uploader$$Lambda$5.lambdaFactory$((Uploader)object, transportContext, n10);
                    synchronizationGuard.runCriticalSection((SynchronizationGuard$CriticalSection)object2);
                    break block6;
                } else {
                    ((Uploader)object).logAndUpdateState(transportContext, n10);
                }
                {
                    catch (Throwable throwable2222222) {
                        break block7;
                    }
                    catch (SynchronizationException synchronizationException) {}
                    {
                        object = ((Uploader)object).workScheduler;
                        object.schedule(transportContext, ++n10);
                    }
                }
            }
            runnable.run();
            return;
        }
        runnable.run();
        throw throwable2222222;
    }

    public boolean isNetworkAvailable() {
        boolean bl2;
        Context context = this.context;
        String string2 = "connectivity";
        if ((context = ((ConnectivityManager)context.getSystemService(string2)).getActiveNetworkInfo()) != null && (bl2 = context.isConnected())) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    public void logAndUpdateState(TransportContext object, int n10) {
        Object object2 = this.backendRegistry;
        Object object3 = ((TransportContext)object).getBackendName();
        object2 = object2.get((String)object3);
        object3 = this.guard;
        Object object4 = Uploader$$Lambda$2.lambdaFactory$(this, (TransportContext)object);
        boolean bl2 = (object4 = (object3 = (Iterable)object3.runCriticalSection((SynchronizationGuard$CriticalSection)object4)).iterator()).hasNext();
        if (!bl2) {
            return;
        }
        if (object2 == null) {
            object4 = "Unknown backend for %s, deleting event batch for it...";
            Logging.d(LOG_TAG, object4, object);
            object2 = BackendResponse.fatalError();
        } else {
            boolean bl3;
            object4 = new ArrayList();
            Object object5 = object3.iterator();
            while (bl3 = object5.hasNext()) {
                EventInternal eventInternal = ((PersistedEvent)object5.next()).getEvent();
                object4.add(eventInternal);
            }
            object4 = BackendRequest.builder().setEvents((Iterable)object4);
            object5 = ((TransportContext)object).getExtras();
            object4 = ((BackendRequest$Builder)object4).setExtras((byte[])object5).build();
            object2 = object2.send((BackendRequest)object4);
        }
        object4 = this.guard;
        object = Uploader$$Lambda$3.lambdaFactory$(this, (BackendResponse)object2, (Iterable)object3, (TransportContext)object, n10);
        object4.runCriticalSection((SynchronizationGuard$CriticalSection)object);
    }

    public void upload(TransportContext object, int n10, Runnable runnable) {
        Executor executor = this.executor;
        object = Uploader$$Lambda$1.lambdaFactory$(this, (TransportContext)object, n10, runnable);
        executor.execute((Runnable)object);
    }
}

