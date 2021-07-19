/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionUserEncoder
implements ObjectEncoder {
    private static final FieldDescriptor IDENTIFIER_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionUserEncoder INSTANCE;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionUserEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionUserEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionUserEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionUserEncoder();
        IDENTIFIER_DESCRIPTOR = FieldDescriptor.of("identifier");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionUserEncoder() {
    }

    public void encode(CrashlyticsReport$Session$User object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = IDENTIFIER_DESCRIPTOR;
        object = ((CrashlyticsReport$Session$User)object).getIdentifier();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

