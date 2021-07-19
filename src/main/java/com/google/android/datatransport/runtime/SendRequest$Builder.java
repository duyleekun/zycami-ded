/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;
import com.google.android.datatransport.runtime.TransportContext;

public abstract class SendRequest$Builder {
    public abstract SendRequest build();

    public abstract SendRequest$Builder setEncoding(Encoding var1);

    public abstract SendRequest$Builder setEvent(Event var1);

    public SendRequest$Builder setEvent(Event event, Encoding encoding, Transformer transformer) {
        this.setEvent(event);
        this.setEncoding(encoding);
        this.setTransformer(transformer);
        return this;
    }

    public abstract SendRequest$Builder setTransformer(Transformer var1);

    public abstract SendRequest$Builder setTransportContext(TransportContext var1);

    public abstract SendRequest$Builder setTransportName(String var1);
}

