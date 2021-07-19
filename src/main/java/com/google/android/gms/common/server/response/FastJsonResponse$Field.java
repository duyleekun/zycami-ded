/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zai;
import com.google.android.gms.common.server.response.zak;
import java.util.Map;

public class FastJsonResponse$Field
extends AbstractSafeParcelable {
    public static final zai CREATOR;
    private final int zalf;
    public final int zapr;
    public final boolean zaps;
    public final int zapt;
    public final boolean zapu;
    public final String zapv;
    public final int zapw;
    public final Class zapx;
    private final String zapy;
    private zak zapz;
    private FastJsonResponse$FieldConverter zaqa;

    static {
        zai zai2;
        CREATOR = zai2 = new zai();
    }

    public FastJsonResponse$Field(int n10, int n11, boolean bl2, int n12, boolean bl3, String string2, int n13, String string3, zaa zaa2) {
        this.zalf = n10;
        this.zapr = n11;
        this.zaps = bl2;
        this.zapt = n12;
        this.zapu = bl3;
        this.zapv = string2;
        this.zapw = n13;
        n10 = 0;
        FastJsonResponse$FieldConverter fastJsonResponse$FieldConverter = null;
        if (string3 == null) {
            this.zapx = null;
            this.zapy = null;
        } else {
            Class<SafeParcelResponse> clazz;
            this.zapx = clazz = SafeParcelResponse.class;
            this.zapy = string3;
        }
        if (zaa2 == null) {
            this.zaqa = null;
            return;
        }
        this.zaqa = fastJsonResponse$FieldConverter = zaa2.zaci();
    }

    private FastJsonResponse$Field(int n10, boolean bl2, int n11, boolean bl3, String string2, int n12, Class clazz, FastJsonResponse$FieldConverter fastJsonResponse$FieldConverter) {
        int n13;
        this.zalf = n13 = 1;
        this.zapr = n10;
        this.zaps = bl2;
        this.zapt = n11;
        this.zapu = bl3;
        this.zapv = string2;
        this.zapw = n12;
        this.zapx = clazz;
        if (clazz == null) {
            n10 = 0;
            Object var10_10 = null;
            this.zapy = null;
        } else {
            String string3;
            this.zapy = string3 = clazz.getCanonicalName();
        }
        this.zaqa = fastJsonResponse$FieldConverter;
    }

    public static FastJsonResponse$Field forBase64(String string2, int n10) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(8, false, 8, false, string2, n10, null, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field forBoolean(String string2, int n10) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(6, false, 6, false, string2, n10, null, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field forConcreteType(String string2, int n10, Class clazz) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(11, false, 11, false, string2, n10, clazz, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field forConcreteTypeArray(String string2, int n10, Class clazz) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(11, true, 11, true, string2, n10, clazz, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field forDouble(String string2, int n10) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(4, false, 4, false, string2, n10, null, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field forFloat(String string2, int n10) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(3, false, 3, false, string2, n10, null, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field forInteger(String string2, int n10) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(0, false, 0, false, string2, n10, null, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field forLong(String string2, int n10) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(2, false, 2, false, string2, n10, null, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field forString(String string2, int n10) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(7, false, 7, false, string2, n10, null, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field forStrings(String string2, int n10) {
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(7, true, 7, true, string2, n10, null, null);
        return fastJsonResponse$Field;
    }

    public static FastJsonResponse$Field withConverter(String string2, int n10, FastJsonResponse$FieldConverter fastJsonResponse$FieldConverter, boolean bl2) {
        int n11 = fastJsonResponse$FieldConverter.zacj();
        int n12 = fastJsonResponse$FieldConverter.zack();
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(n11, bl2, n12, false, string2, n10, null, fastJsonResponse$FieldConverter);
        return fastJsonResponse$Field;
    }

    public static /* synthetic */ FastJsonResponse$FieldConverter zaa(FastJsonResponse$Field fastJsonResponse$Field) {
        return fastJsonResponse$Field.zaqa;
    }

    private final String zacm() {
        String string2 = this.zapy;
        if (string2 == null) {
            string2 = null;
        }
        return string2;
    }

    private final zaa zaco() {
        FastJsonResponse$FieldConverter fastJsonResponse$FieldConverter = this.zaqa;
        if (fastJsonResponse$FieldConverter == null) {
            return null;
        }
        return zaa.zaa(fastJsonResponse$FieldConverter);
    }

    public final Object convert(Object object) {
        return this.zaqa.convert(object);
    }

    public final Object convertBack(Object object) {
        return this.zaqa.convertBack(object);
    }

    public int getSafeParcelableFieldId() {
        return this.zapw;
    }

    public String toString() {
        Objects$ToStringHelper objects$ToStringHelper = Objects.toStringHelper(this);
        Object object = this.zalf;
        objects$ToStringHelper = objects$ToStringHelper.add("versionCode", object);
        object = this.zapr;
        objects$ToStringHelper = objects$ToStringHelper.add("typeIn", object);
        object = this.zaps;
        objects$ToStringHelper = objects$ToStringHelper.add("typeInArray", object);
        object = this.zapt;
        objects$ToStringHelper = objects$ToStringHelper.add("typeOut", object);
        object = this.zapu;
        objects$ToStringHelper = objects$ToStringHelper.add("typeOutArray", object);
        object = this.zapv;
        objects$ToStringHelper = objects$ToStringHelper.add("outputFieldName", object);
        int n10 = this.zapw;
        object = n10;
        objects$ToStringHelper = objects$ToStringHelper.add("safeParcelFieldId", object);
        object = this.zacm();
        String string2 = "concreteTypeName";
        objects$ToStringHelper = objects$ToStringHelper.add(string2, object);
        object = this.zapx;
        if (object != null) {
            object = ((Class)object).getCanonicalName();
            string2 = "concreteType.class";
            objects$ToStringHelper.add(string2, object);
        }
        if ((object = this.zaqa) != null) {
            object = object.getClass().getCanonicalName();
            string2 = "converterName";
            objects$ToStringHelper.add(string2, object);
        }
        return objects$ToStringHelper.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        n12 = this.zapr;
        SafeParcelWriter.writeInt(parcel, 2, n12);
        n12 = (int)(this.zaps ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 3, n12 != 0);
        n12 = this.zapt;
        SafeParcelWriter.writeInt(parcel, 4, n12);
        n12 = (int)(this.zapu ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 5, n12 != 0);
        Object object = this.zapv;
        SafeParcelWriter.writeString(parcel, 6, (String)object, false);
        n12 = this.getSafeParcelableFieldId();
        SafeParcelWriter.writeInt(parcel, 7, n12);
        object = this.zacm();
        SafeParcelWriter.writeString(parcel, 8, (String)object, false);
        object = this.zaco();
        SafeParcelWriter.writeParcelable(parcel, 9, (Parcelable)object, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }

    public final void zaa(zak zak2) {
        this.zapz = zak2;
    }

    public final FastJsonResponse$Field zacl() {
        int n10 = this.zalf;
        int n11 = this.zapr;
        boolean bl2 = this.zaps;
        int n12 = this.zapt;
        boolean bl3 = this.zapu;
        String string2 = this.zapv;
        int n13 = this.zapw;
        String string3 = this.zapy;
        zaa zaa2 = this.zaco();
        FastJsonResponse$Field fastJsonResponse$Field = new FastJsonResponse$Field(n10, n11, bl2, n12, bl3, string2, n13, string3, zaa2);
        return fastJsonResponse$Field;
    }

    public final boolean zacn() {
        FastJsonResponse$FieldConverter fastJsonResponse$FieldConverter = this.zaqa;
        return fastJsonResponse$FieldConverter != null;
    }

    public final FastJsonResponse zacp() {
        Object object = this.zapx;
        Class<SafeParcelResponse> clazz = SafeParcelResponse.class;
        if (object == clazz) {
            Preconditions.checkNotNull(this.zapz, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
            clazz = this.zapz;
            String string2 = this.zapy;
            object = new SafeParcelResponse((zak)((Object)clazz), string2);
            return object;
        }
        return (FastJsonResponse)((Class)object).newInstance();
    }

    public final Map zacq() {
        Preconditions.checkNotNull(this.zapy);
        Preconditions.checkNotNull(this.zapz);
        zak zak2 = this.zapz;
        String string2 = this.zapy;
        return zak2.zai(string2);
    }
}

