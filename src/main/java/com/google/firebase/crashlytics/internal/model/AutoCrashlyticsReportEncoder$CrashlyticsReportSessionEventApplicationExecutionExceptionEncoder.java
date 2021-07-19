/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder
implements ObjectEncoder {
    private static final FieldDescriptor CAUSEDBY_DESCRIPTOR;
    private static final FieldDescriptor FRAMES_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder INSTANCE;
    private static final FieldDescriptor OVERFLOWCOUNT_DESCRIPTOR;
    private static final FieldDescriptor REASON_DESCRIPTOR;
    private static final FieldDescriptor TYPE_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();
        TYPE_DESCRIPTOR = FieldDescriptor.of("type");
        REASON_DESCRIPTOR = FieldDescriptor.of("reason");
        FRAMES_DESCRIPTOR = FieldDescriptor.of("frames");
        CAUSEDBY_DESCRIPTOR = FieldDescriptor.of("causedBy");
        OVERFLOWCOUNT_DESCRIPTOR = FieldDescriptor.of("overflowCount");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder() {
    }

    public void encode(CrashlyticsReport$Session$Event$Application$Execution$Exception crashlyticsReport$Session$Event$Application$Execution$Exception, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = TYPE_DESCRIPTOR;
        Object object = crashlyticsReport$Session$Event$Application$Execution$Exception.getType();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = REASON_DESCRIPTOR;
        object = crashlyticsReport$Session$Event$Application$Execution$Exception.getReason();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = FRAMES_DESCRIPTOR;
        object = crashlyticsReport$Session$Event$Application$Execution$Exception.getFrames();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = CAUSEDBY_DESCRIPTOR;
        object = crashlyticsReport$Session$Event$Application$Execution$Exception.getCausedBy();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = OVERFLOWCOUNT_DESCRIPTOR;
        int n10 = crashlyticsReport$Session$Event$Application$Execution$Exception.getOverflowCount();
        objectEncoderContext.add(fieldDescriptor, n10);
    }
}

