/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder
implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder INSTANCE;
    private static final FieldDescriptor MOBILESUBTYPE_DESCRIPTOR;
    private static final FieldDescriptor NETWORKTYPE_DESCRIPTOR;

    static {
        AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder;
        INSTANCE = autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder = new AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder();
        NETWORKTYPE_DESCRIPTOR = FieldDescriptor.of("networkType");
        MOBILESUBTYPE_DESCRIPTOR = FieldDescriptor.of("mobileSubtype");
    }

    private AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder() {
    }

    public void encode(NetworkConnectionInfo object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = NETWORKTYPE_DESCRIPTOR;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType = object.getNetworkType();
        objectEncoderContext.add(fieldDescriptor, (Object)networkConnectionInfo$NetworkType);
        fieldDescriptor = MOBILESUBTYPE_DESCRIPTOR;
        object = object.getMobileSubtype();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

