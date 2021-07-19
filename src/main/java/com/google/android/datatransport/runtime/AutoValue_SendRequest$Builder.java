/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_SendRequest;
import com.google.android.datatransport.runtime.SendRequest;
import com.google.android.datatransport.runtime.SendRequest$Builder;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Objects;

public final class AutoValue_SendRequest$Builder
extends SendRequest$Builder {
    private Encoding encoding;
    private Event event;
    private Transformer transformer;
    private TransportContext transportContext;
    private String transportName;

    public SendRequest build() {
        boolean bl2;
        Object object = this.transportContext;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" transportContext");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.transportName) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" transportName");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.event) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" event");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.transformer) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" transformer");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.encoding) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" encoding");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            TransportContext transportContext = this.transportContext;
            String string3 = this.transportName;
            Event event = this.event;
            Transformer transformer = this.transformer;
            Encoding encoding = this.encoding;
            Object object2 = object;
            object = new AutoValue_SendRequest(transportContext, string3, event, transformer, encoding, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public SendRequest$Builder setEncoding(Encoding encoding) {
        Objects.requireNonNull(encoding, "Null encoding");
        this.encoding = encoding;
        return this;
    }

    public SendRequest$Builder setEvent(Event event) {
        Objects.requireNonNull(event, "Null event");
        this.event = event;
        return this;
    }

    public SendRequest$Builder setTransformer(Transformer transformer) {
        Objects.requireNonNull(transformer, "Null transformer");
        this.transformer = transformer;
        return this;
    }

    public SendRequest$Builder setTransportContext(TransportContext transportContext) {
        Objects.requireNonNull(transportContext, "Null transportContext");
        this.transportContext = transportContext;
        return this;
    }

    public SendRequest$Builder setTransportName(String string2) {
        Objects.requireNonNull(string2, "Null transportName");
        this.transportName = string2;
        return this;
    }
}

