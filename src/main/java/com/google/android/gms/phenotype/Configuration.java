/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.phenotype.zzc;
import com.google.android.gms.phenotype.zzi;
import com.google.android.gms.phenotype.zzn;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Configuration
extends AbstractSafeParcelable
implements Comparable {
    public static final Parcelable.Creator CREATOR;
    private final int zzc;
    private final zzi[] zzd;
    private final String[] zze;
    private final Map zzf;

    static {
        zzc zzc2 = new zzc();
        CREATOR = zzc2;
    }

    public Configuration(int n10, zzi[] zziArray, String[] stringArray) {
        TreeMap treeMap;
        this.zzc = n10;
        this.zzd = zziArray;
        this.zzf = treeMap = new TreeMap();
        for (zzi zzi2 : zziArray) {
            Map map = this.zzf;
            String string2 = zzi2.name;
            map.put(string2, zzi2);
        }
        this.zze = stringArray;
        if (stringArray != null) {
            Arrays.sort(stringArray);
        }
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (Configuration)object;
        int n10 = this.zzc;
        int n11 = ((Configuration)object).zzc;
        return n10 - n11;
    }

    public boolean equals(Object objectArray) {
        int n10 = objectArray instanceof Configuration;
        if (n10 != 0) {
            boolean bl2;
            Map map;
            Object[] objectArray2;
            objectArray = (Configuration)objectArray;
            n10 = this.zzc;
            int n11 = objectArray.zzc;
            if (n10 == n11 && (n10 = (int)(zzn.equals(objectArray2 = this.zzf, map = objectArray.zzf) ? 1 : 0)) != 0 && (bl2 = Arrays.equals(objectArray2 = this.zze, objectArray = objectArray.zze))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        int n10;
        StringBuilder stringBuilder = new StringBuilder("Configuration(");
        int n11 = this.zzc;
        stringBuilder.append(n11);
        String string2 = ", ";
        stringBuilder.append(string2);
        String[] stringArray = "(";
        stringBuilder.append((String)stringArray);
        Object object = this.zzf.values().iterator();
        while ((n10 = object.hasNext()) != 0) {
            zzi zzi2 = (zzi)object.next();
            stringBuilder.append(zzi2);
            stringBuilder.append(string2);
        }
        object = ")";
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        stringBuilder.append((String)stringArray);
        stringArray = this.zze;
        if (stringArray != null) {
            for (String string3 : stringArray) {
                stringBuilder.append(string3);
                stringBuilder.append(string2);
            }
        } else {
            string2 = "null";
            stringBuilder.append(string2);
        }
        stringBuilder.append((String)object);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zzc;
        SafeParcelWriter.writeInt(parcel, 2, n12);
        Parcelable[] parcelableArray = this.zzd;
        SafeParcelWriter.writeTypedArray(parcel, 3, parcelableArray, n10, false);
        String[] stringArray = this.zze;
        SafeParcelWriter.writeStringArray(parcel, 4, stringArray, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

