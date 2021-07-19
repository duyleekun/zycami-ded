/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadEncoder
implements ObjectEncoder {
    private static final FieldDescriptor FRAMES_DESCRIPTOR;
    private static final FieldDescriptor IMPORTANCE_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadEncoder INSTANCE;
    private static final FieldDescriptor NAME_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();
        NAME_DESCRIPTOR = FieldDescriptor.of("name");
        IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");
        FRAMES_DESCRIPTOR = FieldDescriptor.of("frames");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionThreadEncoder() {
    }

    public void encode(CrashlyticsReport$Session$Event$Application$Execution$Thread object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = NAME_DESCRIPTOR;
        String string2 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread)object).getName();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = IMPORTANCE_DESCRIPTOR;
        int n10 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread)object).getImportance();
        objectEncoderContext.add(fieldDescriptor, n10);
        fieldDescriptor = FRAMES_DESCRIPTOR;
        object = ((CrashlyticsReport$Session$Event$Application$Execution$Thread)object).getFrames();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

