/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEncoder
implements ObjectEncoder {
    private static final FieldDescriptor APP_DESCRIPTOR;
    private static final FieldDescriptor CRASHED_DESCRIPTOR;
    private static final FieldDescriptor DEVICE_DESCRIPTOR;
    private static final FieldDescriptor ENDEDAT_DESCRIPTOR;
    private static final FieldDescriptor EVENTS_DESCRIPTOR;
    private static final FieldDescriptor GENERATORTYPE_DESCRIPTOR;
    private static final FieldDescriptor GENERATOR_DESCRIPTOR;
    private static final FieldDescriptor IDENTIFIER_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEncoder INSTANCE;
    private static final FieldDescriptor OS_DESCRIPTOR;
    private static final FieldDescriptor STARTEDAT_DESCRIPTOR;
    private static final FieldDescriptor USER_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEncoder();
        GENERATOR_DESCRIPTOR = FieldDescriptor.of("generator");
        IDENTIFIER_DESCRIPTOR = FieldDescriptor.of("identifier");
        STARTEDAT_DESCRIPTOR = FieldDescriptor.of("startedAt");
        ENDEDAT_DESCRIPTOR = FieldDescriptor.of("endedAt");
        CRASHED_DESCRIPTOR = FieldDescriptor.of("crashed");
        APP_DESCRIPTOR = FieldDescriptor.of("app");
        USER_DESCRIPTOR = FieldDescriptor.of("user");
        OS_DESCRIPTOR = FieldDescriptor.of("os");
        DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
        EVENTS_DESCRIPTOR = FieldDescriptor.of("events");
        GENERATORTYPE_DESCRIPTOR = FieldDescriptor.of("generatorType");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEncoder() {
    }

    public void encode(CrashlyticsReport$Session crashlyticsReport$Session, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = GENERATOR_DESCRIPTOR;
        Object object = crashlyticsReport$Session.getGenerator();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = IDENTIFIER_DESCRIPTOR;
        object = crashlyticsReport$Session.getIdentifierUtf8Bytes();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = STARTEDAT_DESCRIPTOR;
        long l10 = crashlyticsReport$Session.getStartedAt();
        objectEncoderContext.add(fieldDescriptor, l10);
        fieldDescriptor = ENDEDAT_DESCRIPTOR;
        object = crashlyticsReport$Session.getEndedAt();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = CRASHED_DESCRIPTOR;
        boolean bl2 = crashlyticsReport$Session.isCrashed();
        objectEncoderContext.add(fieldDescriptor, bl2);
        fieldDescriptor = APP_DESCRIPTOR;
        object = crashlyticsReport$Session.getApp();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = USER_DESCRIPTOR;
        object = crashlyticsReport$Session.getUser();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = OS_DESCRIPTOR;
        object = crashlyticsReport$Session.getOs();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = DEVICE_DESCRIPTOR;
        object = crashlyticsReport$Session.getDevice();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = EVENTS_DESCRIPTOR;
        object = crashlyticsReport$Session.getEvents();
        objectEncoderContext.add(fieldDescriptor, object);
        fieldDescriptor = GENERATORTYPE_DESCRIPTOR;
        int n10 = crashlyticsReport$Session.getGeneratorType();
        objectEncoderContext.add(fieldDescriptor, n10);
    }
}

