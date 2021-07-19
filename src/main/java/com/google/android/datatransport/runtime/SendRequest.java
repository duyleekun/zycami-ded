/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_SendRequest$Builder;
import com.google.android.datatransport.runtime.SendRequest$Builder;
import com.google.android.datatransport.runtime.TransportContext;

public abstract class SendRequest {
    public static SendRequest$Builder builder() {
        AutoValue_SendRequest$Builder autoValue_SendRequest$Builder = new AutoValue_SendRequest$Builder();
        return autoValue_SendRequest$Builder;
    }

    public abstract Encoding getEncoding();

    public abstract Event getEvent();

    public byte[] getPayload() {
        Transformer transformer = this.getTransformer();
        Object object = this.getEvent().getPayload();
        return (byte[])transformer.apply(object);
    }

    public abstract Transformer getTransformer();

    public abstract TransportContext getTransportContext();

    public abstract String getTransportName();
}

