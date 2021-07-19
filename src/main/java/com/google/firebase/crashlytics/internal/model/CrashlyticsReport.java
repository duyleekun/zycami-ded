/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Type;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.nio.charset.Charset;

public abstract class CrashlyticsReport {
    public static final String DEVELOPMENT_PLATFORM_UNITY = "Unity";
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static /* synthetic */ Charset access$000() {
        return UTF_8;
    }

    public static CrashlyticsReport$Builder builder() {
        AutoValue_CrashlyticsReport$Builder autoValue_CrashlyticsReport$Builder = new AutoValue_CrashlyticsReport$Builder();
        return autoValue_CrashlyticsReport$Builder;
    }

    public abstract String getBuildVersion();

    public abstract String getDisplayVersion();

    public abstract String getGmpAppId();

    public abstract String getInstallationUuid();

    public abstract CrashlyticsReport$FilesPayload getNdkPayload();

    public abstract int getPlatform();

    public abstract String getSdkVersion();

    public abstract CrashlyticsReport$Session getSession();

    public CrashlyticsReport$Type getType() {
        Object object = this.getSession();
        if (object != null) {
            return CrashlyticsReport$Type.JAVA;
        }
        object = this.getNdkPayload();
        if (object != null) {
            return CrashlyticsReport$Type.NATIVE;
        }
        return CrashlyticsReport$Type.INCOMPLETE;
    }

    public abstract CrashlyticsReport$Builder toBuilder();

    public CrashlyticsReport withEvents(ImmutableList object) {
        Object object2 = this.getSession();
        if (object2 != null) {
            object2 = this.toBuilder();
            object = this.getSession().withEvents((ImmutableList)object);
            return ((CrashlyticsReport$Builder)object2).setSession((CrashlyticsReport$Session)object).build();
        }
        object = new IllegalStateException("Reports without sessions cannot have events added to them.");
        throw object;
    }

    public CrashlyticsReport withNdkPayload(CrashlyticsReport$FilesPayload crashlyticsReport$FilesPayload) {
        return this.toBuilder().setSession(null).setNdkPayload(crashlyticsReport$FilesPayload).build();
    }

    public CrashlyticsReport withOrganizationId(String object) {
        CrashlyticsReport$Builder crashlyticsReport$Builder = this.toBuilder();
        Object object2 = this.getNdkPayload();
        if (object2 != null) {
            object2 = ((CrashlyticsReport$FilesPayload)object2).toBuilder().setOrgId((String)object).build();
            crashlyticsReport$Builder.setNdkPayload((CrashlyticsReport$FilesPayload)object2);
        }
        if ((object2 = this.getSession()) != null) {
            object = ((CrashlyticsReport$Session)object2).withOrganizationId((String)object);
            crashlyticsReport$Builder.setSession((CrashlyticsReport$Session)object);
        }
        return crashlyticsReport$Builder.build();
    }

    public CrashlyticsReport withSessionEndFields(long l10, boolean bl2, String string2) {
        CrashlyticsReport$Builder crashlyticsReport$Builder = this.toBuilder();
        CrashlyticsReport$Session crashlyticsReport$Session = this.getSession();
        if (crashlyticsReport$Session != null) {
            crashlyticsReport$Session = this.getSession();
            CrashlyticsReport$Session crashlyticsReport$Session2 = crashlyticsReport$Session.withSessionEndFields(l10, bl2, string2);
            crashlyticsReport$Builder.setSession(crashlyticsReport$Session2);
        }
        return crashlyticsReport$Builder.build();
    }
}

