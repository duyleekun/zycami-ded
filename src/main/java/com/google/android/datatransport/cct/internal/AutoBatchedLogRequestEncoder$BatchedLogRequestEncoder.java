/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder
implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder INSTANCE;
    private static final FieldDescriptor LOGREQUEST_DESCRIPTOR;

    static {
        AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder autoBatchedLogRequestEncoder$BatchedLogRequestEncoder;
        INSTANCE = autoBatchedLogRequestEncoder$BatchedLogRequestEncoder = new AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder();
        LOGREQUEST_DESCRIPTOR = FieldDescriptor.of("logRequest");
    }

    private AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder() {
    }

    public void encode(BatchedLogRequest object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = LOGREQUEST_DESCRIPTOR;
        object = ((BatchedLogRequest)object).getLogRequests();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

