/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zal
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final String className;
    private final int versionCode;
    public final ArrayList zaqy;

    static {
        zao zao2 = new zao();
        CREATOR = zao2;
    }

    public zal(int n10, String string2, ArrayList arrayList) {
        this.versionCode = n10;
        this.className = string2;
        this.zaqy = arrayList;
    }

    public zal(String arrayList, Map map) {
        int n10;
        this.versionCode = n10 = 1;
        this.className = arrayList;
        if (map == null) {
            arrayList = null;
        } else {
            boolean bl2;
            arrayList = new ArrayList<zam>();
            Iterator iterator2 = map.keySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                String string2 = (String)iterator2.next();
                FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field)map.get(string2);
                zam zam2 = new zam(string2, fastJsonResponse$Field);
                arrayList.add(zam2);
            }
        }
        this.zaqy = arrayList;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.versionCode;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        Object object = this.className;
        SafeParcelWriter.writeString(parcel, 2, (String)object, false);
        object = this.zaqy;
        SafeParcelWriter.writeTypedList(parcel, 3, (List)object, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

