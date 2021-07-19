/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationOrganizationEncoder
implements ObjectEncoder {
    private static final FieldDescriptor CLSID_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationOrganizationEncoder INSTANCE;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationOrganizationEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationOrganizationEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationOrganizationEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationOrganizationEncoder();
        CLSID_DESCRIPTOR = FieldDescriptor.of("clsId");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionApplicationOrganizationEncoder() {
    }

    public void encode(CrashlyticsReport$Session$Application$Organization object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = CLSID_DESCRIPTOR;
        object = ((CrashlyticsReport$Session$Application$Organization)object).getClsId();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

