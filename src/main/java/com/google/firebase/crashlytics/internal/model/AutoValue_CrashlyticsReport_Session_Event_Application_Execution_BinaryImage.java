/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage
extends CrashlyticsReport$Session$Event$Application$Execution$BinaryImage {
    private final long baseAddress;
    private final String name;
    private final long size;
    private final String uuid;

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long l10, long l11, String string2, String string3) {
        this.baseAddress = l10;
        this.size = l11;
        this.name = string2;
        this.uuid = string3;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long l10, long l11, String string2, String string3, AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$1) {
        this(l10, l11, string2, string3);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof CrashlyticsReport$Session$Event$Application$Execution$BinaryImage;
        if (object2) {
            boolean bl3;
            String string2;
            String string3;
            long l10;
            long l11 = this.baseAddress;
            long l12 = ((CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)(object = (CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)object)).getBaseAddress();
            long l13 = l11 - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 || (object2 = (l10 = (l11 = this.size) - (l12 = ((CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)object).getSize())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) || !(object2 = (string3 = this.name).equals(string2 = ((CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)object).getName())) || !((string3 = this.uuid) == null ? (object = ((CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)object).getUuid()) == null : (bl3 = string3.equals(object = ((CrashlyticsReport$Session$Event$Application$Execution$BinaryImage)object).getUuid())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getBaseAddress() {
        return this.baseAddress;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        long l10 = this.baseAddress;
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^= l11);
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        l11 = this.size;
        long l12 = l11 >>> n10;
        long l13 = l12 ^ l11;
        n10 = (int)l13;
        n11 = (n11 ^ n10) * n12;
        String string2 = this.name;
        n10 = string2.hashCode();
        n11 = (n11 ^ n10) * n12;
        String string3 = this.uuid;
        if (string3 == null) {
            n12 = 0;
            string3 = null;
        } else {
            n12 = string3.hashCode();
        }
        return n11 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BinaryImage{baseAddress=");
        long l10 = this.baseAddress;
        stringBuilder.append(l10);
        stringBuilder.append(", size=");
        l10 = this.size;
        stringBuilder.append(l10);
        stringBuilder.append(", name=");
        String string2 = this.name;
        stringBuilder.append(string2);
        stringBuilder.append(", uuid=");
        string2 = this.uuid;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

