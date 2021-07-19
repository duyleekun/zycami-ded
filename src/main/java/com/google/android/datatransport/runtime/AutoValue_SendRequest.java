/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_SendRequest$1;
import com.google.android.datatransport.runtime.SendRequest;
import com.google.android.datatransport.runtime.TransportContext;

public final class AutoValue_SendRequest
extends SendRequest {
    private final Encoding encoding;
    private final Event event;
    private final Transformer transformer;
    private final TransportContext transportContext;
    private final String transportName;

    private AutoValue_SendRequest(TransportContext transportContext, String string2, Event event, Transformer transformer, Encoding encoding) {
        this.transportContext = transportContext;
        this.transportName = string2;
        this.event = event;
        this.transformer = transformer;
        this.encoding = encoding;
    }

    public /* synthetic */ AutoValue_SendRequest(TransportContext transportContext, String string2, Event event, Transformer transformer, Encoding encoding, AutoValue_SendRequest$1 autoValue_SendRequest$1) {
        this(transportContext, string2, event, transformer, encoding);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof SendRequest;
        if (bl3) {
            boolean bl4;
            Object object2 = this.transportContext;
            Object object3 = ((SendRequest)(object = (SendRequest)object)).getTransportContext();
            bl3 = object2.equals(object3);
            if (!(bl3 && (bl3 = ((String)(object2 = this.transportName)).equals(object3 = ((SendRequest)object).getTransportName())) && (bl3 = (object2 = this.event).equals(object3 = ((SendRequest)object).getEvent())) && (bl3 = (object2 = this.transformer).equals(object3 = ((SendRequest)object).getTransformer())) && (bl4 = ((Encoding)(object2 = this.encoding)).equals(object = ((SendRequest)object).getEncoding())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public Event getEvent() {
        return this.event;
    }

    public Transformer getTransformer() {
        return this.transformer;
    }

    public TransportContext getTransportContext() {
        return this.transportContext;
    }

    public String getTransportName() {
        return this.transportName;
    }

    public int hashCode() {
        int n10 = this.transportContext.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.transportName.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.event.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.transformer.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = this.encoding.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SendRequest{transportContext=");
        Object object = this.transportContext;
        stringBuilder.append(object);
        stringBuilder.append(", transportName=");
        object = this.transportName;
        stringBuilder.append((String)object);
        stringBuilder.append(", event=");
        object = this.event;
        stringBuilder.append(object);
        stringBuilder.append(", transformer=");
        object = this.transformer;
        stringBuilder.append(object);
        stringBuilder.append(", encoding=");
        object = this.encoding;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

