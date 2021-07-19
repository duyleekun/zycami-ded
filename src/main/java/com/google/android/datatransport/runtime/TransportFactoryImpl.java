/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportImpl;
import com.google.android.datatransport.runtime.TransportInternal;
import java.util.Set;

public final class TransportFactoryImpl
implements TransportFactory {
    private final Set supportedPayloadEncodings;
    private final TransportContext transportContext;
    private final TransportInternal transportInternal;

    public TransportFactoryImpl(Set set, TransportContext transportContext, TransportInternal transportInternal) {
        this.supportedPayloadEncodings = set;
        this.transportContext = transportContext;
        this.transportInternal = transportInternal;
    }

    public Transport getTransport(String object, Class object2, Encoding encoding, Transformer object3) {
        object2 = this.supportedPayloadEncodings;
        boolean bl2 = object2.contains(encoding);
        if (bl2) {
            TransportContext transportContext = this.transportContext;
            TransportInternal transportInternal = this.transportInternal;
            object2 = new TransportImpl(transportContext, (String)object, encoding, (Transformer)object3, transportInternal);
            return object2;
        }
        object3 = this.supportedPayloadEncodings;
        object2 = new Object[]{encoding, object3};
        object2 = String.format("%s is not supported byt this factory. Supported encodings are: %s.", object2);
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public Transport getTransport(String string2, Class clazz, Transformer transformer) {
        Encoding encoding = Encoding.of("proto");
        return this.getTransport(string2, clazz, encoding, transformer);
    }
}

