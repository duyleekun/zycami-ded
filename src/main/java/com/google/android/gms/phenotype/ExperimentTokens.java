/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.util.Base64
 */
package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.phenotype.ExperimentTokens$zza;
import com.google.android.gms.phenotype.zzd;
import com.google.android.gms.phenotype.zze;
import com.google.android.gms.phenotype.zzf;
import com.google.android.gms.phenotype.zzg;
import com.google.android.gms.phenotype.zzh;
import com.google.android.gms.phenotype.zzn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExperimentTokens
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private static final ExperimentTokens$zza zzaa;
    private static final byte[][] zzn;
    private static final ExperimentTokens zzo;
    private static final ExperimentTokens$zza zzx;
    private static final ExperimentTokens$zza zzy;
    private static final ExperimentTokens$zza zzz;
    private final String zzp;
    private final byte[] zzq;
    private final byte[][] zzr;
    private final byte[][] zzs;
    private final byte[][] zzt;
    private final byte[][] zzu;
    private final int[] zzv;
    private final byte[][] zzw;

    static {
        Object object = new zzh();
        CREATOR = object;
        byte[][] byArrayArray = new byte[][]{};
        zzn = byArrayArray;
        zzo = object = new ExperimentTokens("", null, byArrayArray, byArrayArray, byArrayArray, byArrayArray, null, null);
        zzx = object = new zzd();
        zzy = object = new zze();
        zzz = object = new zzf();
        zzaa = object = new zzg();
    }

    public ExperimentTokens(String string2, byte[] byArray, byte[][] byArray2, byte[][] byArray3, byte[][] byArray4, byte[][] byArray5, int[] nArray, byte[][] byArray6) {
        this.zzp = string2;
        this.zzq = byArray;
        this.zzr = byArray2;
        this.zzs = byArray3;
        this.zzt = byArray4;
        this.zzu = byArray5;
        this.zzv = nArray;
        this.zzw = byArray6;
    }

    private static List zza(int[] nArray) {
        if (nArray == null) {
            return Collections.emptyList();
        }
        int n10 = nArray.length;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(n10);
        for (int n11 : nArray) {
            Integer n12 = n11;
            arrayList.add(n12);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List zza(byte[][] byArray) {
        if (byArray == null) {
            return Collections.emptyList();
        }
        int n10 = byArray.length;
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>(n10);
        for (Object object : byArray) {
            int n11 = 3;
            object = Base64.encodeToString((byte[])object, (int)n11);
            arrayList.add((byte[])object);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void zza(StringBuilder stringBuilder, String string2, byte[][] byArray) {
        stringBuilder.append(string2);
        string2 = "=";
        stringBuilder.append(string2);
        if (byArray == null) {
            string2 = "null";
        } else {
            string2 = "(";
            stringBuilder.append(string2);
            int n10 = byArray.length;
            boolean bl2 = true;
            for (int i10 = 0; i10 < n10; ++i10) {
                String string3;
                byte[] byArray2 = byArray[i10];
                if (!bl2) {
                    string3 = ", ";
                    stringBuilder.append(string3);
                }
                string3 = "'";
                stringBuilder.append(string3);
                int n11 = 3;
                String string4 = Base64.encodeToString((byte[])byArray2, (int)n11);
                stringBuilder.append(string4);
                stringBuilder.append(string3);
                bl2 = false;
                string3 = null;
            }
            string2 = ")";
        }
        stringBuilder.append(string2);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof ExperimentTokens;
        if (bl2) {
            boolean bl3;
            object = (ExperimentTokens)object;
            Object object2 = this.zzp;
            Object object3 = ((ExperimentTokens)object).zzp;
            bl2 = com.google.android.gms.phenotype.zzn.equals(object2, object3);
            if (bl2 && (bl2 = Arrays.equals((byte[])(object2 = (Object)this.zzq), (byte[])(object3 = (Object)((ExperimentTokens)object).zzq))) && (bl2 = com.google.android.gms.phenotype.zzn.equals(object2 = ExperimentTokens.zza(this.zzr), object3 = ExperimentTokens.zza(((ExperimentTokens)object).zzr))) && (bl2 = com.google.android.gms.phenotype.zzn.equals(object2 = ExperimentTokens.zza(this.zzs), object3 = ExperimentTokens.zza(((ExperimentTokens)object).zzs))) && (bl2 = com.google.android.gms.phenotype.zzn.equals(object2 = ExperimentTokens.zza(this.zzt), object3 = ExperimentTokens.zza(((ExperimentTokens)object).zzt))) && (bl2 = com.google.android.gms.phenotype.zzn.equals(object2 = ExperimentTokens.zza(this.zzu), object3 = ExperimentTokens.zza(((ExperimentTokens)object).zzu))) && (bl2 = com.google.android.gms.phenotype.zzn.equals(object2 = ExperimentTokens.zza(this.zzv), object3 = ExperimentTokens.zza(((ExperimentTokens)object).zzv))) && (bl3 = com.google.android.gms.phenotype.zzn.equals(object2 = ExperimentTokens.zza(this.zzw), object = ExperimentTokens.zza(((ExperimentTokens)object).zzw)))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        int n10;
        CharSequence charSequence;
        Object object;
        StringBuilder stringBuilder = new StringBuilder("ExperimentTokens");
        Object object2 = "(";
        stringBuilder.append((String)object2);
        String string2 = this.zzp;
        String string3 = "null";
        Object object3 = "'";
        if (string2 == null) {
            string2 = string3;
        } else {
            object = String.valueOf(string2);
            int n11 = ((String)object).length() + 2;
            charSequence = new StringBuilder(n11);
            ((StringBuilder)charSequence).append((String)object3);
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append((String)object3);
            string2 = ((StringBuilder)charSequence).toString();
        }
        stringBuilder.append(string2);
        string2 = ", ";
        stringBuilder.append(string2);
        object = this.zzq;
        stringBuilder.append("direct");
        charSequence = "=";
        stringBuilder.append((String)charSequence);
        if (object == null) {
            stringBuilder.append(string3);
        } else {
            stringBuilder.append((String)object3);
            n10 = 3;
            object = Base64.encodeToString((byte[])object, (int)n10);
            stringBuilder.append((String)object);
            stringBuilder.append((String)object3);
        }
        stringBuilder.append(string2);
        object3 = this.zzr;
        ExperimentTokens.zza(stringBuilder, "GAIA", (byte[][])object3);
        stringBuilder.append(string2);
        object3 = this.zzs;
        ExperimentTokens.zza(stringBuilder, "PSEUDO", (byte[][])object3);
        stringBuilder.append(string2);
        object3 = this.zzt;
        ExperimentTokens.zza(stringBuilder, "ALWAYS", (byte[][])object3);
        stringBuilder.append(string2);
        object3 = this.zzu;
        ExperimentTokens.zza(stringBuilder, "OTHER", (byte[][])object3);
        stringBuilder.append(string2);
        object3 = this.zzv;
        stringBuilder.append("weak");
        stringBuilder.append((String)charSequence);
        object = ")";
        if (object3 == null) {
            stringBuilder.append(string3);
        } else {
            stringBuilder.append((String)object2);
            int n12 = ((Object)object3).length;
            string3 = null;
            boolean bl2 = true;
            for (n10 = 0; n10 < n12; ++n10) {
                Object object4 = object3[n10];
                if (!bl2) {
                    stringBuilder.append(string2);
                }
                stringBuilder.append((int)object4);
                bl2 = false;
                charSequence = null;
            }
            stringBuilder.append((String)object);
        }
        stringBuilder.append(string2);
        object2 = this.zzw;
        ExperimentTokens.zza(stringBuilder, "directs", (byte[][])object2);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        Object object = this.zzp;
        SafeParcelWriter.writeString(parcel, 2, (String)object, false);
        object = this.zzq;
        SafeParcelWriter.writeByteArray(parcel, 3, (byte[])object, false);
        object = this.zzr;
        SafeParcelWriter.writeByteArrayArray(parcel, 4, (byte[][])object, false);
        object = this.zzs;
        SafeParcelWriter.writeByteArrayArray(parcel, 5, (byte[][])object, false);
        object = this.zzt;
        SafeParcelWriter.writeByteArrayArray(parcel, 6, (byte[][])object, false);
        object = this.zzu;
        SafeParcelWriter.writeByteArrayArray(parcel, 7, (byte[][])object, false);
        object = this.zzv;
        SafeParcelWriter.writeIntArray(parcel, 8, (int[])object, false);
        object = this.zzw;
        SafeParcelWriter.writeByteArrayArray(parcel, 9, (byte[][])object, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

