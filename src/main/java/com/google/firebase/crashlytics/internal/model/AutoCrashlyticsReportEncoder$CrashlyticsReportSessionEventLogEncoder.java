/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventLogEncoder
implements ObjectEncoder {
    private static final FieldDescriptor CONTENT_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventLogEncoder INSTANCE;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventLogEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventLogEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventLogEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventLogEncoder();
        CONTENT_DESCRIPTOR = FieldDescriptor.of("content");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventLogEncoder() {
    }

    public void encode(CrashlyticsReport$Session$Event$Log object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = CONTENT_DESCRIPTOR;
        object = ((CrashlyticsReport$Session$Event$Log)object).getContent();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

