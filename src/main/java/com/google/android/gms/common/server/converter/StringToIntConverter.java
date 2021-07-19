/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 */
package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.StringToIntConverter$zaa;
import com.google.android.gms.common.server.converter.zac;
import com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter
extends AbstractSafeParcelable
implements FastJsonResponse$FieldConverter {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private final HashMap zapm;
    private final SparseArray zapn;
    private final ArrayList zapo;

    static {
        zac zac2 = new zac();
        CREATOR = zac2;
    }

    public StringToIntConverter() {
        SparseArray sparseArray;
        this.zalf = 1;
        this.zapm = sparseArray = new HashMap();
        this.zapn = sparseArray = new SparseArray();
        this.zapo = null;
    }

    public StringToIntConverter(int n10, ArrayList arrayList) {
        SparseArray sparseArray;
        this.zalf = n10;
        this.zapm = sparseArray = new HashMap();
        this.zapn = sparseArray = new SparseArray();
        sparseArray = null;
        this.zapo = null;
        n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = arrayList.get(i10);
            object = (StringToIntConverter$zaa)object;
            String string2 = ((StringToIntConverter$zaa)object).zapp;
            int n11 = ((StringToIntConverter$zaa)object).zapq;
            this.add(string2, n11);
        }
    }

    public final StringToIntConverter add(String string2, int n10) {
        HashMap hashMap = this.zapm;
        Integer n11 = n10;
        hashMap.put(string2, n11);
        this.zapn.put(n10, (Object)string2);
        return this;
    }

    public final /* synthetic */ Object convert(Object object) {
        object = (String)object;
        Object object2 = this.zapm;
        if ((object = (Integer)((HashMap)object2).get(object)) == null) {
            object = this.zapm;
            object2 = "gms_unknown";
            object = (Integer)((HashMap)object).get(object2);
        }
        return object;
    }

    public final /* synthetic */ Object convertBack(Object object) {
        String string2;
        boolean bl2;
        object = (Integer)object;
        Object object2 = this.zapn;
        int n10 = (Integer)object;
        if ((object = (String)object2.get(n10)) == null && (bl2 = ((HashMap)(object2 = this.zapm)).containsKey(string2 = "gms_unknown"))) {
            return string2;
        }
        return object;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        boolean bl2;
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.zalf;
        int n12 = 1;
        SafeParcelWriter.writeInt(parcel, n12, n11);
        ArrayList<StringToIntConverter$zaa> arrayList = new ArrayList<StringToIntConverter$zaa>();
        Iterator iterator2 = this.zapm.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            Integer n13 = (Integer)this.zapm.get(string2);
            int n14 = n13;
            StringToIntConverter$zaa stringToIntConverter$zaa = new StringToIntConverter$zaa(string2, n14);
            arrayList.add(stringToIntConverter$zaa);
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }

    public final int zacj() {
        return 7;
    }

    public final int zack() {
        return 0;
    }
}

