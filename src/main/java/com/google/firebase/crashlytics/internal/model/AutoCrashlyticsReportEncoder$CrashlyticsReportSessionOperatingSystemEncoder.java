/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionOperatingSystemEncoder
implements ObjectEncoder {
    private static final FieldDescriptor BUILDVERSION_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionOperatingSystemEncoder INSTANCE;
    private static final FieldDescriptor JAILBROKEN_DESCRIPTOR;
    private static final FieldDescriptor PLATFORM_DESCRIPTOR;
    private static final FieldDescriptor VERSION_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionOperatingSystemEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionOperatingSystemEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionOperatingSystemEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionOperatingSystemEncoder();
        PLATFORM_DESCRIPTOR = FieldDescriptor.of("platform");
        VERSION_DESCRIPTOR = FieldDescriptor.of("version");
        BUILDVERSION_DESCRIPTOR = FieldDescriptor.of("buildVersion");
        JAILBROKEN_DESCRIPTOR = FieldDescriptor.of("jailbroken");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionOperatingSystemEncoder() {
    }

    public void encode(CrashlyticsReport$Session$OperatingSystem crashlyticsReport$Session$OperatingSystem, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = PLATFORM_DESCRIPTOR;
        int n10 = crashlyticsReport$Session$OperatingSystem.getPlatform();
        objectEncoderContext.add(fieldDescriptor, n10);
        fieldDescriptor = VERSION_DESCRIPTOR;
        String string2 = crashlyticsReport$Session$OperatingSystem.getVersion();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = BUILDVERSION_DESCRIPTOR;
        string2 = crashlyticsReport$Session$OperatingSystem.getBuildVersion();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = JAILBROKEN_DESCRIPTOR;
        boolean bl2 = crashlyticsReport$Session$OperatingSystem.isJailbroken();
        objectEncoderContext.add(fieldDescriptor, bl2);
    }
}

