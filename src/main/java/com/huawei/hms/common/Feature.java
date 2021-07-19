/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.FeatureCreator;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Objects$ToStringHelper;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;

public class Feature
extends AbstractSafeParcelable {
    public static final int ARGS_NAME = 1;
    public static final int ARGS_SVC_VER = 2;
    public static final int ARGS_VER = 3;
    public static final Parcelable.Creator CREATOR;
    private static final int SVC_VER = 255;
    private final long apiVersion;
    private final String name;
    private final int serviceVersion;

    static {
        FeatureCreator featureCreator = new FeatureCreator();
        CREATOR = featureCreator;
    }

    public Feature(String string2, int n10, long l10) {
        this.name = string2;
        this.serviceVersion = n10;
        this.apiVersion = l10;
    }

    public Feature(String string2, long l10) {
        this(string2, -1, l10);
    }

    public boolean equals(Object object) {
        long l10;
        boolean bl2 = object instanceof Feature;
        if (!bl2) {
            return false;
        }
        String string2 = this.name;
        String string3 = ((Feature)(object = (Feature)object)).getName();
        bl2 = string2.equals(string3);
        if (!bl2) {
            return false;
        }
        long l11 = this.getVersion();
        long l12 = l11 - (l10 = ((Feature)object).getVersion());
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object2 == false;
    }

    public String getName() {
        return this.name;
    }

    public long getVersion() {
        long l10 = -1;
        long l11 = this.apiVersion;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            int n10 = this.serviceVersion;
            l11 = n10;
        }
        return l11;
    }

    public int hashCode() {
        Object object = this.getName();
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.getVersion())};
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        Objects$ToStringHelper objects$ToStringHelper = Objects.toStringHelper(this);
        Object object = this.getName();
        objects$ToStringHelper = objects$ToStringHelper.add("name", object);
        object = this.getVersion();
        return objects$ToStringHelper.add("version", object).toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        String string2 = this.getName();
        SafeParcelWriter.writeString(parcel, 1, string2, false);
        int n11 = this.serviceVersion;
        SafeParcelWriter.writeInt(parcel, 2, n11);
        long l10 = this.getVersion();
        SafeParcelWriter.writeLong(parcel, 3, l10);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

