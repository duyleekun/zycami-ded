/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoCrashlyticsReportEncoder$CrashlyticsReportFilesPayloadFileEncoder
implements ObjectEncoder {
    private static final FieldDescriptor CONTENTS_DESCRIPTOR;
    private static final FieldDescriptor FILENAME_DESCRIPTOR;
    public static final AutoCrashlyticsReportEncoder$CrashlyticsReportFilesPayloadFileEncoder INSTANCE;

    static {
        AutoCrashlyticsReportEncoder$CrashlyticsReportFilesPayloadFileEncoder autoCrashlyticsReportEncoder$CrashlyticsReportFilesPayloadFileEncoder;
        INSTANCE = autoCrashlyticsReportEncoder$CrashlyticsReportFilesPayloadFileEncoder = new AutoCrashlyticsReportEncoder$CrashlyticsReportFilesPayloadFileEncoder();
        FILENAME_DESCRIPTOR = FieldDescriptor.of("filename");
        CONTENTS_DESCRIPTOR = FieldDescriptor.of("contents");
    }

    private AutoCrashlyticsReportEncoder$CrashlyticsReportFilesPayloadFileEncoder() {
    }

    public void encode(CrashlyticsReport$FilesPayload$File object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = FILENAME_DESCRIPTOR;
        String string2 = ((CrashlyticsReport$FilesPayload$File)object).getFilename();
        objectEncoderContext.add(fieldDescriptor, (Object)string2);
        fieldDescriptor = CONTENTS_DESCRIPTOR;
        object = ((CrashlyticsReport$FilesPayload$File)object).getContents();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

