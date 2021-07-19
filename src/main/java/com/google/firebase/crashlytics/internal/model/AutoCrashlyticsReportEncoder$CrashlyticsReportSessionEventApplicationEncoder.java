/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationEncoder
implements ObjectEncoder {
    private static final FieldDescriptor BACKGROUND_DESCRIPTOR;
    private static final FieldDescriptor CUSTOMATTRIBUTES_DESCRIPTOR;
    private static final FieldDescriptor EXECUTION_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationEncoder INSTANCE;
    private static final FieldDescriptor UIORIENTATION_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationEncoder();
        EXECUTION_DESCRIPTOR = FieldDescriptor.of("execution");
        CUSTOMATTRIBUTES_DESCRIPTOR = FieldDescriptor.of("customAttributes");
        BACKGROUND_DESCRIPTOR = FieldDescriptor.of("background");
        UIORIENTATION_DESCRIPTOR = FieldDescriptor.of("uiOrientation");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationEncoder() {
    }

    public void encode(CrashlyticsReport$Session$Event$Application crashlyticsReport$Session$Event$Application, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = EXECUTION_DESCRIPTOR;
        Object object = crashlyticsReport$Session$Event$Application.getExecution();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = CUSTOMATTRIBUTES_DESCRIPTOR;
        object = crashlyticsReport$Session$Event$Application.getCustomAttributes();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = BACKGROUND_DESCRIPTOR;
        object = crashlyticsReport$Session$Event$Application.getBackground();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = UIORIENTATION_DESCRIPTOR;
        int n10 = crashlyticsReport$Session$Event$Application.getUiOrientation();
        objectEncoderContext.add(fieldDescriptor, n10);
    }
}

