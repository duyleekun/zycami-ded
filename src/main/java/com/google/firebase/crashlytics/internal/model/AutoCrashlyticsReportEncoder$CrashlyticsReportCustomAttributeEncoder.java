/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportCustomAttributeEncoder
implements ObjectEncoder {
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportCustomAttributeEncoder INSTANCE;
    private static final FieldDescriptor KEY_DESCRIPTOR;
    private static final FieldDescriptor VALUE_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportCustomAttributeEncoder autoCrashlyticsReportEncoder$CrashlyticsReportCustomAttributeEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportCustomAttributeEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportCustomAttributeEncoder();
        KEY_DESCRIPTOR = FieldDescriptor.of("key");
        VALUE_DESCRIPTOR = FieldDescriptor.of("value");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportCustomAttributeEncoder() {
    }

    public void encode(CrashlyticsReport$CustomAttribute object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = KEY_DESCRIPTOR;
        String string2 = ((CrashlyticsReport$CustomAttribute)object).getKey();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = VALUE_DESCRIPTOR;
        object = ((CrashlyticsReport$CustomAttribute)object).getValue();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

