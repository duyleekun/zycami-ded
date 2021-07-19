/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.SendRequest;
import com.google.android.datatransport.runtime.SendRequest$Builder;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportImpl$$Lambda$1;
import com.google.android.datatransport.runtime.TransportInternal;

public final class TransportImpl
implements Transport {
    private final String name;
    private final Encoding payloadEncoding;
    private final Transformer transformer;
    private final TransportContext transportContext;
    private final TransportInternal transportInternal;

    public TransportImpl(TransportContext transportContext, String string2, Encoding encoding, Transformer transformer, TransportInternal transportInternal) {
        this.transportContext = transportContext;
        this.name = string2;
        this.payloadEncoding = encoding;
        this.transformer = transformer;
        this.transportInternal = transportInternal;
    }

    public static /* synthetic */ void lambda$send$0(Exception exception) {
    }

    public void schedule(Event object, TransportScheduleCallback transportScheduleCallback) {
        TransportInternal transportInternal = this.transportInternal;
        Object object2 = SendRequest.builder();
        TransportContext transportContext = this.transportContext;
        object = ((SendRequest$Builder)object2).setTransportContext(transportContext).setEvent((Event)object);
        object2 = this.name;
        object = ((SendRequest$Builder)object).setTransportName((String)object2);
        object2 = this.transformer;
        object = ((SendRequest$Builder)object).setTransformer((Transformer)object2);
        object2 = this.payloadEncoding;
        object = ((SendRequest$Builder)object).setEncoding((Encoding)object2).build();
        transportInternal.send((SendRequest)object, transportScheduleCallback);
    }

    public void send(Event event) {
        TransportScheduleCallback transportScheduleCallback = TransportImpl$$Lambda$1.lambdaFactory$();
        this.schedule(event, transportScheduleCallback);
    }
}

