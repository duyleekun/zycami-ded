/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationEncoder
implements ObjectEncoder {
    private static final FieldDescriptor DEVELOPMENTPLATFORMVERSION_DESCRIPTOR;
    private static final FieldDescriptor DEVELOPMENTPLATFORM_DESCRIPTOR;
    private static final FieldDescriptor DISPLAYVERSION_DESCRIPTOR;
    private static final FieldDescriptor IDENTIFIER_DESCRIPTOR;
    private static final FieldDescriptor INSTALLATIONUUID_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationEncoder INSTANCE;
    private static final FieldDescriptor ORGANIZATION_DESCRIPTOR;
    private static final FieldDescriptor VERSION_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationEncoder();
        IDENTIFIER_DESCRIPTOR = FieldDescriptor.of("identifier");
        VERSION_DESCRIPTOR = FieldDescriptor.of("version");
        DISPLAYVERSION_DESCRIPTOR = FieldDescriptor.of("displayVersion");
        ORGANIZATION_DESCRIPTOR = FieldDescriptor.of("organization");
        INSTALLATIONUUID_DESCRIPTOR = FieldDescriptor.of("installationUuid");
        DEVELOPMENTPLATFORM_DESCRIPTOR = FieldDescriptor.of("developmentPlatform");
        DEVELOPMENTPLATFORMVERSION_DESCRIPTOR = FieldDescriptor.of("developmentPlatformVersion");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationEncoder() {
    }

    public void encode(CrashlyticsReport$Session$Application object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = IDENTIFIER_DESCRIPTOR;
        Object object2 = ((CrashlyticsReport$Session$Application)object).getIdentifier();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = VERSION_DESCRIPTOR;
        object2 = ((CrashlyticsReport$Session$Application)object).getVersion();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = DISPLAYVERSION_DESCRIPTOR;
        object2 = ((CrashlyticsReport$Session$Application)object).getDisplayVersion();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = ORGANIZATION_DESCRIPTOR;
        object2 = ((CrashlyticsReport$Session$Application)object).getOrganization();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = INSTALLATIONUUID_DESCRIPTOR;
        object2 = ((CrashlyticsReport$Session$Application)object).getInstallationUuid();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = DEVELOPMENTPLATFORM_DESCRIPTOR;
        object2 = ((CrashlyticsReport$Session$Application)object).getDevelopmentPlatform();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = DEVELOPMENTPLATFORMVERSION_DESCRIPTOR;
        object = ((CrashlyticsReport$Session$Application)object).getDevelopmentPlatformVersion();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

