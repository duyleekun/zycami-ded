/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.runtime.EncodedDestination;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.EventInternal$Builder;
import com.google.android.datatransport.runtime.SendRequest;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportContext$Builder;
import com.google.android.datatransport.runtime.TransportFactoryImpl;
import com.google.android.datatransport.runtime.TransportInternal;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Callable;

public class TransportRuntime
implements TransportInternal {
    private static volatile TransportRuntimeComponent instance;
    private final Clock eventClock;
    private final Scheduler scheduler;
    private final Uploader uploader;
    private final Clock uptimeClock;

    public TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.eventClock = clock;
        this.uptimeClock = clock2;
        this.scheduler = scheduler;
        this.uploader = uploader;
        workInitializer.ensureContextsScheduled();
    }

    private EventInternal convert(SendRequest object) {
        EventInternal$Builder eventInternal$Builder = EventInternal.builder();
        long l10 = this.eventClock.getTime();
        eventInternal$Builder = eventInternal$Builder.setEventMillis(l10);
        l10 = this.uptimeClock.getTime();
        eventInternal$Builder = eventInternal$Builder.setUptimeMillis(l10);
        Object object2 = ((SendRequest)object).getTransportName();
        eventInternal$Builder = eventInternal$Builder.setTransportName((String)object2);
        Encoding encoding = ((SendRequest)object).getEncoding();
        byte[] byArray = ((SendRequest)object).getPayload();
        object2 = new EncodedPayload(encoding, byArray);
        eventInternal$Builder = eventInternal$Builder.setEncodedPayload((EncodedPayload)object2);
        object = ((SendRequest)object).getEvent().getCode();
        return eventInternal$Builder.setCode((Integer)object).build();
    }

    public static TransportRuntime getInstance() {
        Object object = instance;
        if (object != null) {
            return ((TransportRuntimeComponent)object).getTransportRuntime();
        }
        object = new IllegalStateException("Not initialized!");
        throw object;
    }

    private static Set getSupportedEncodings(Destination destination) {
        boolean bl2 = destination instanceof EncodedDestination;
        if (bl2) {
            return Collections.unmodifiableSet(((EncodedDestination)destination).getSupportedEncodings());
        }
        return Collections.singleton(Encoding.of("proto"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void initialize(Context object) {
        Object object2 = instance;
        if (object2 != null) return;
        object2 = TransportRuntime.class;
        synchronized (object2) {
            Object object3 = instance;
            if (object3 != null) return;
            object3 = DaggerTransportRuntimeComponent.builder();
            object = object3.setApplicationContext((Context)object);
            instance = object = object.build();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void withInstance(TransportRuntimeComponent transportRuntimeComponent, Callable callable) {
        TransportRuntimeComponent transportRuntimeComponent2;
        Class<TransportRuntime> clazz = TransportRuntime.class;
        synchronized (clazz) {
            transportRuntimeComponent2 = instance;
            instance = transportRuntimeComponent;
        }
        try {
            callable.call();
            return;
        }
        finally {
            synchronized (clazz) {
                instance = transportRuntimeComponent2;
            }
        }
    }

    public Uploader getUploader() {
        return this.uploader;
    }

    public TransportFactory newFactory(Destination object) {
        Set set = TransportRuntime.getSupportedEncodings((Destination)object);
        TransportContext$Builder transportContext$Builder = TransportContext.builder();
        String string2 = object.getName();
        transportContext$Builder = transportContext$Builder.setBackendName(string2);
        object = object.getExtras();
        object = transportContext$Builder.setExtras((byte[])object).build();
        TransportFactoryImpl transportFactoryImpl = new TransportFactoryImpl(set, (TransportContext)object, this);
        return transportFactoryImpl;
    }

    public TransportFactory newFactory(String object) {
        Set set = TransportRuntime.getSupportedEncodings(null);
        object = TransportContext.builder().setBackendName((String)object).build();
        TransportFactoryImpl transportFactoryImpl = new TransportFactoryImpl(set, (TransportContext)object, this);
        return transportFactoryImpl;
    }

    public void send(SendRequest object, TransportScheduleCallback transportScheduleCallback) {
        Scheduler scheduler = this.scheduler;
        TransportContext transportContext = ((SendRequest)object).getTransportContext();
        Priority priority = ((SendRequest)object).getEvent().getPriority();
        transportContext = transportContext.withPriority(priority);
        object = this.convert((SendRequest)object);
        scheduler.schedule(transportContext, (EventInternal)object, transportScheduleCallback);
    }
}

