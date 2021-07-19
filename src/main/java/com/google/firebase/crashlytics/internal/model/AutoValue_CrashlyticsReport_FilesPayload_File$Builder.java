/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_FilesPayload_File$Builder
extends CrashlyticsReport$FilesPayload$File$Builder {
    private byte[] contents;
    private String filename;

    public CrashlyticsReport$FilesPayload$File build() {
        boolean bl2;
        Object object = this.filename;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" filename");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = (Object)this.contents) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" contents");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            string2 = this.filename;
            byte[] byArray = this.contents;
            object = new AutoValue_CrashlyticsReport_FilesPayload_File(string2, byArray, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$FilesPayload$File$Builder setContents(byte[] byArray) {
        Objects.requireNonNull(byArray, "Null contents");
        this.contents = byArray;
        return this;
    }

    public CrashlyticsReport$FilesPayload$File$Builder setFilename(String string2) {
        Objects.requireNonNull(string2, "Null filename");
        this.filename = string2;
        return this;
    }
}

