/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder;
import java.nio.charset.Charset;

public abstract class CrashlyticsReport$Session$Event$Application$Execution$BinaryImage {
    public static CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$Builder autoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$Builder = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$Builder();
        return autoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$Builder;
    }

    public abstract long getBaseAddress();

    public abstract String getName();

    public abstract long getSize();

    public abstract String getUuid();

    public byte[] getUuidUtf8Bytes() {
        Object object = this.getUuid();
        if (object != null) {
            Charset charset = CrashlyticsReport.access$000();
            object = ((String)object).getBytes(charset);
        } else {
            object = null;
        }
        return object;
    }
}

