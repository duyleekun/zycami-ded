/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoBatchedLogRequestEncoder$LogRequestEncoder
implements ObjectEncoder {
    private static final FieldDescriptor CLIENTINFO_DESCRIPTOR;
    public static final AutoBatchedLogRequestEncoder$LogRequestEncoder INSTANCE;
    private static final FieldDescriptor LOGEVENT_DESCRIPTOR;
    private static final FieldDescriptor LOGSOURCENAME_DESCRIPTOR;
    private static final FieldDescriptor LOGSOURCE_DESCRIPTOR;
    private static final FieldDescriptor QOSTIER_DESCRIPTOR;
    private static final FieldDescriptor REQUESTTIMEMS_DESCRIPTOR;
    private static final FieldDescriptor REQUESTUPTIMEMS_DESCRIPTOR;

    static {
        AutoBatchedLogRequestEncoder$LogRequestEncoder autoBatchedLogRequestEncoder$LogRequestEncoder;
        INSTANCE = autoBatchedLogRequestEncoder$LogRequestEncoder = new AutoBatchedLogRequestEncoder$LogRequestEncoder();
        REQUESTTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestTimeMs");
        REQUESTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestUptimeMs");
        CLIENTINFO_DESCRIPTOR = FieldDescriptor.of("clientInfo");
        LOGSOURCE_DESCRIPTOR = FieldDescriptor.of("logSource");
        LOGSOURCENAME_DESCRIPTOR = FieldDescriptor.of("logSourceName");
        LOGEVENT_DESCRIPTOR = FieldDescriptor.of("logEvent");
        QOSTIER_DESCRIPTOR = FieldDescriptor.of("qosTier");
    }

    private AutoBatchedLogRequestEncoder$LogRequestEncoder() {
    }

    public void encode(LogRequest object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = REQUESTTIMEMS_DESCRIPTOR;
        long l10 = object.getRequestTimeMs();
        objectEncoderContext.add(fieldDescriptor, l10);
        fieldDescriptor = REQUESTUPTIMEMS_DESCRIPTOR;
        l10 = object.getRequestUptimeMs();
        objectEncoderContext.add(fieldDescriptor, l10);
        fieldDescriptor = CLIENTINFO_DESCRIPTOR;
        Object object2 = object.getClientInfo();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = LOGSOURCE_DESCRIPTOR;
        object2 = object.getLogSource();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = LOGSOURCENAME_DESCRIPTOR;
        object2 = object.getLogSourceName();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = LOGEVENT_DESCRIPTOR;
        object2 = object.getLogEvents();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = QOSTIER_DESCRIPTOR;
        object = object.getQosTier();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

