/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder
implements ObjectEncoder {
    private static final FieldDescriptor BASEADDRESS_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder INSTANCE;
    private static final FieldDescriptor NAME_DESCRIPTOR;
    private static final FieldDescriptor SIZE_DESCRIPTOR;
    private static final FieldDescriptor UUID_DESCRIPTOR;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();
        BASEADDRESS_DESCRIPTOR = FieldDescriptor.of("baseAddress");
        SIZE_DESCRIPTOR = FieldDescriptor.of("size");
        NAME_DESCRIPTOR = FieldDescriptor.of("name");
        UUID_DESCRIPTOR = FieldDescriptor.of("uuid");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder() {
    }

    public void encode(CrashlyticsReport$Session$Event$Application$Execution$BinaryImage object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = BASEADDRESS_DESCRIPTOR;
        long l10 = ((CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)object).getBaseAddress();
        objectEncoderContext.add(fieldDescriptor, l10);
        fieldDescriptor = SIZE_DESCRIPTOR;
        l10 = ((CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)object).getSize();
        objectEncoderContext.add(fieldDescriptor, l10);
        fieldDescriptor = NAME_DESCRIPTOR;
        String string2 = ((CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)object).getName();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = UUID_DESCRIPTOR;
        object = ((CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)object).getUuidUtf8Bytes();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

