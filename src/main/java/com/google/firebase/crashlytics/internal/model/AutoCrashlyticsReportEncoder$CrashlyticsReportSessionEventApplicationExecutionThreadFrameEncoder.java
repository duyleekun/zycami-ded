/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder
implements ObjectEncoder {
    private static final FieldDescriptor FILE_DESCRIPTOR;
    private static final FieldDescriptor IMPORTANCE_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder INSTANCE;
    private static final FieldDescriptor OFFSET_DESCRIPTOR;
    private static final FieldDescriptor PC_DESCRIPTOR;
    private static final FieldDescriptor SYMBOL_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();
        PC_DESCRIPTOR = FieldDescriptor.of("pc");
        SYMBOL_DESCRIPTOR = FieldDescriptor.of("symbol");
        FILE_DESCRIPTOR = FieldDescriptor.of("file");
        OFFSET_DESCRIPTOR = FieldDescriptor.of("offset");
        IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder() {
    }

    public void encode(CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame crashlyticsReport$Session$Event$Application$Execution$Thread$Frame, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = PC_DESCRIPTOR;
        long l10 = crashlyticsReport$Session$Event$Application$Execution$Thread$Frame.getPc();
        objectEncoderContext.add(fieldDescriptor, l10);
        fieldDescriptor = SYMBOL_DESCRIPTOR;
        String string2 = crashlyticsReport$Session$Event$Application$Execution$Thread$Frame.getSymbol();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = FILE_DESCRIPTOR;
        string2 = crashlyticsReport$Session$Event$Application$Execution$Thread$Frame.getFile();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = OFFSET_DESCRIPTOR;
        l10 = crashlyticsReport$Session$Event$Application$Execution$Thread$Frame.getOffset();
        objectEncoderContext.add(fieldDescriptor, l10);
        fieldDescriptor = IMPORTANCE_DESCRIPTOR;
        int n10 = crashlyticsReport$Session$Event$Application$Execution$Thread$Frame.getImportance();
        objectEncoderContext.add(fieldDescriptor, n10);
    }
}

