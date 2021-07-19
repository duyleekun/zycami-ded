/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.ClientInfo$ClientType;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoBatchedLogRequestEncoder$ClientInfoEncoder
implements ObjectEncoder {
    private static final FieldDescriptor ANDROIDCLIENTINFO_DESCRIPTOR;
    private static final FieldDescriptor CLIENTTYPE_DESCRIPTOR;
    public static final AutoBatchedLogRequestEncoder$ClientInfoEncoder INSTANCE;

    static {
        AutoBatchedLogRequestEncoder$ClientInfoEncoder autoBatchedLogRequestEncoder$ClientInfoEncoder;
        INSTANCE = autoBatchedLogRequestEncoder$ClientInfoEncoder = new AutoBatchedLogRequestEncoder$ClientInfoEncoder();
        CLIENTTYPE_DESCRIPTOR = FieldDescriptor.of("clientType");
        ANDROIDCLIENTINFO_DESCRIPTOR = FieldDescriptor.of("androidClientInfo");
    }

    private AutoBatchedLogRequestEncoder$ClientInfoEncoder() {
    }

    public void encode(ClientInfo object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = CLIENTTYPE_DESCRIPTOR;
        ClientInfo$ClientType clientInfo$ClientType = ((ClientInfo)object).getClientType();
        objectEncoderContext.add(fieldDescriptor, (Object)clientInfo$ClientType);
        fieldDescriptor = ANDROIDCLIENTINFO_DESCRIPTOR;
        object = ((ClientInfo)object).getAndroidClientInfo();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

