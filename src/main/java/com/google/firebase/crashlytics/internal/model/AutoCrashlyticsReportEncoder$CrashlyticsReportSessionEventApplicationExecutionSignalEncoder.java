/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionSignalEncoder
implements ObjectEncoder {
    private static final FieldDescriptor ADDRESS_DESCRIPTOR;
    private static final FieldDescriptor CODE_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionSignalEncoder INSTANCE;
    private static final FieldDescriptor NAME_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionSignalEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionSignalEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionSignalEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();
        NAME_DESCRIPTOR = FieldDescriptor.of("name");
        CODE_DESCRIPTOR = FieldDescriptor.of("code");
        ADDRESS_DESCRIPTOR = FieldDescriptor.of("address");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionSignalEncoder() {
    }

    public void encode(CrashlyticsReport$Session$Event$Application$Execution$Signal crashlyticsReport$Session$Event$Application$Execution$Signal, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = NAME_DESCRIPTOR;
        String string2 = crashlyticsReport$Session$Event$Application$Execution$Signal.getName();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = CODE_DESCRIPTOR;
        string2 = crashlyticsReport$Session$Event$Application$Execution$Signal.getCode();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = ADDRESS_DESCRIPTOR;
        long l10 = crashlyticsReport$Session$Event$Application$Execution$Signal.getAddress();
        objectEncoderContext.add(fieldDescriptor, l10);
    }
}

