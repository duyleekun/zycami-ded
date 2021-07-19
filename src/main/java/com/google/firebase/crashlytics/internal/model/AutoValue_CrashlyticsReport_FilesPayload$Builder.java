/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_FilesPayload$Builder
extends CrashlyticsReport$FilesPayload$Builder {
    private ImmutableList files;
    private String orgId;

    public AutoValue_CrashlyticsReport_FilesPayload$Builder() {
    }

    private AutoValue_CrashlyticsReport_FilesPayload$Builder(CrashlyticsReport$FilesPayload object) {
        ImmutableList immutableList;
        this.files = immutableList = ((CrashlyticsReport$FilesPayload)object).getFiles();
        this.orgId = object = ((CrashlyticsReport$FilesPayload)object).getOrgId();
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_FilesPayload$Builder(CrashlyticsReport$FilesPayload crashlyticsReport$FilesPayload, AutoValue_CrashlyticsReport_FilesPayload$1 autoValue_CrashlyticsReport_FilesPayload$1) {
        this(crashlyticsReport$FilesPayload);
    }

    public CrashlyticsReport$FilesPayload build() {
        boolean bl2;
        Object object = this.files;
        Object object2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" files");
            object2 = ((StringBuilder)object).toString();
        }
        if (bl2 = ((String)object2).isEmpty()) {
            object2 = this.files;
            String string2 = this.orgId;
            object = new AutoValue_CrashlyticsReport_FilesPayload((ImmutableList)object2, string2, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append((String)object2);
        object2 = stringBuilder.toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public CrashlyticsReport$FilesPayload$Builder setFiles(ImmutableList immutableList) {
        Objects.requireNonNull(immutableList, "Null files");
        this.files = immutableList;
        return this;
    }

    public CrashlyticsReport$FilesPayload$Builder setOrgId(String string2) {
        this.orgId = string2;
        return this;
    }
}

