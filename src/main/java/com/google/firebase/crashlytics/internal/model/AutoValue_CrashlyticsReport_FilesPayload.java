/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload$1;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public final class AutoValue_CrashlyticsReport_FilesPayload
extends CrashlyticsReport$FilesPayload {
    private final ImmutableList files;
    private final String orgId;

    private AutoValue_CrashlyticsReport_FilesPayload(ImmutableList immutableList, String string2) {
        this.files = immutableList;
        this.orgId = string2;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_FilesPayload(ImmutableList immutableList, String string2, AutoValue_CrashlyticsReport_FilesPayload$1 autoValue_CrashlyticsReport_FilesPayload$1) {
        this(immutableList, string2);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof CrashlyticsReport$FilesPayload;
        if (bl3) {
            boolean bl4;
            Object object2 = this.files;
            ImmutableList immutableList = ((CrashlyticsReport$FilesPayload)(object = (CrashlyticsReport$FilesPayload)object)).getFiles();
            bl3 = ((ImmutableList)object2).equals(immutableList);
            if (!bl3 || !((object2 = this.orgId) == null ? (object = ((CrashlyticsReport$FilesPayload)object).getOrgId()) == null : (bl4 = ((String)object2).equals(object = ((CrashlyticsReport$FilesPayload)object).getOrgId())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public ImmutableList getFiles() {
        return this.files;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public int hashCode() {
        ImmutableList immutableList = this.files;
        int n10 = immutableList.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        String string2 = this.orgId;
        if (string2 == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = string2.hashCode();
        }
        return n10 ^ n11;
    }

    public CrashlyticsReport$FilesPayload$Builder toBuilder() {
        AutoValue_CrashlyticsReport_FilesPayload$Builder autoValue_CrashlyticsReport_FilesPayload$Builder = new AutoValue_CrashlyticsReport_FilesPayload$Builder(this, null);
        return autoValue_CrashlyticsReport_FilesPayload$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FilesPayload{files=");
        Object object = this.files;
        stringBuilder.append(object);
        stringBuilder.append(", orgId=");
        object = this.orgId;
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

