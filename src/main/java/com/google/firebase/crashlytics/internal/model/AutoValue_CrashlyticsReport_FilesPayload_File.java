/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File;
import java.util.Arrays;

public final class AutoValue_CrashlyticsReport_FilesPayload_File
extends CrashlyticsReport$FilesPayload$File {
    private final byte[] contents;
    private final String filename;

    private AutoValue_CrashlyticsReport_FilesPayload_File(String string2, byte[] byArray) {
        this.filename = string2;
        this.contents = byArray;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_FilesPayload_File(String string2, byte[] byArray, AutoValue_CrashlyticsReport_FilesPayload_File$1 autoValue_CrashlyticsReport_FilesPayload_File$1) {
        this(string2, byArray);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof CrashlyticsReport$FilesPayload$File;
        if (bl3) {
            boolean bl4;
            boolean bl5;
            Object object2 = this.filename;
            String string2 = ((CrashlyticsReport$FilesPayload$File)(object = (CrashlyticsReport$FilesPayload$File)object)).getFilename();
            bl3 = ((String)object2).equals(string2);
            if (!bl3 || !(bl5 = Arrays.equals((byte[])(object2 = (Object)this.contents), (byte[])(object = (bl4 = object instanceof AutoValue_CrashlyticsReport_FilesPayload_File) ? (Object)((AutoValue_CrashlyticsReport_FilesPayload_File)object).contents : (Object)((CrashlyticsReport$FilesPayload$File)object).getContents())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public byte[] getContents() {
        return this.contents;
    }

    public String getFilename() {
        return this.filename;
    }

    public int hashCode() {
        int n10 = this.filename.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = Arrays.hashCode(this.contents);
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File{filename=");
        String string2 = this.filename;
        stringBuilder.append(string2);
        stringBuilder.append(", contents=");
        string2 = Arrays.toString(this.contents);
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

