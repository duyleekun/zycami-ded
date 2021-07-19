/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportEncoder
implements ObjectEncoder {
    private static final FieldDescriptor BUILDVERSION_DESCRIPTOR;
    private static final FieldDescriptor DISPLAYVERSION_DESCRIPTOR;
    private static final FieldDescriptor GMPAPPID_DESCRIPTOR;
    private static final FieldDescriptor INSTALLATIONUUID_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportEncoder INSTANCE;
    private static final FieldDescriptor NDKPAYLOAD_DESCRIPTOR;
    private static final FieldDescriptor PLATFORM_DESCRIPTOR;
    private static final FieldDescriptor SDKVERSION_DESCRIPTOR;
    private static final FieldDescriptor SESSION_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportEncoder autoCrashlyticsReportEncoder$CrashlyticsReportEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportEncoder();
        SDKVERSION_DESCRIPTOR = FieldDescriptor.of("sdkVersion");
        GMPAPPID_DESCRIPTOR = FieldDescriptor.of("gmpAppId");
        PLATFORM_DESCRIPTOR = FieldDescriptor.of("platform");
        INSTALLATIONUUID_DESCRIPTOR = FieldDescriptor.of("installationUuid");
        BUILDVERSION_DESCRIPTOR = FieldDescriptor.of("buildVersion");
        DISPLAYVERSION_DESCRIPTOR = FieldDescriptor.of("displayVersion");
        SESSION_DESCRIPTOR = FieldDescriptor.of("session");
        NDKPAYLOAD_DESCRIPTOR = FieldDescriptor.of("ndkPayload");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportEncoder() {
    }

    public void encode(CrashlyticsReport object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = SDKVERSION_DESCRIPTOR;
        Object object2 = ((CrashlyticsReport)object).getSdkVersion();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = GMPAPPID_DESCRIPTOR;
        object2 = ((CrashlyticsReport)object).getGmpAppId();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = PLATFORM_DESCRIPTOR;
        int n10 = ((CrashlyticsReport)object).getPlatform();
        objectEncoderContext.add(fieldDescriptor, n10);
        fieldDescriptor = INSTALLATIONUUID_DESCRIPTOR;
        object2 = ((CrashlyticsReport)object).getInstallationUuid();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = BUILDVERSION_DESCRIPTOR;
        object2 = ((CrashlyticsReport)object).getBuildVersion();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = DISPLAYVERSION_DESCRIPTOR;
        object2 = ((CrashlyticsReport)object).getDisplayVersion();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = SESSION_DESCRIPTOR;
        object2 = ((CrashlyticsReport)object).getSession();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = NDKPAYLOAD_DESCRIPTOR;
        object = ((CrashlyticsReport)object).getNdkPayload();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

