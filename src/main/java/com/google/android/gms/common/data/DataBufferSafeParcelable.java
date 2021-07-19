/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.DataHolder$Builder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DataBufferSafeParcelable
extends AbstractDataBuffer {
    private static final String[] zalo = new String[]{"data"};
    private final Parcelable.Creator zalp;

    public DataBufferSafeParcelable(DataHolder dataHolder, Parcelable.Creator creator) {
        super(dataHolder);
        this.zalp = creator;
    }

    public static void addValue(DataHolder$Builder dataHolder$Builder, SafeParcelable safeParcelable) {
        Parcel parcel = Parcel.obtain();
        safeParcelable.writeToParcel(parcel, 0);
        safeParcelable = new ContentValues();
        byte[] byArray = parcel.marshall();
        safeParcelable.put("data", byArray);
        dataHolder$Builder.withRow((ContentValues)safeParcelable);
        parcel.recycle();
    }

    public static DataHolder$Builder buildDataHolder() {
        return DataHolder.builder(zalo);
    }

    public SafeParcelable get(int n10) {
        DataHolder dataHolder = this.mDataHolder;
        int n11 = dataHolder.getWindowIndex(n10);
        Object object = dataHolder.getByteArray("data", n10, n11);
        dataHolder = Parcel.obtain();
        n11 = ((byte[])object).length;
        dataHolder.unmarshall((byte[])object, 0, n11);
        dataHolder.setDataPosition(0);
        object = (SafeParcelable)this.zalp.createFromParcel((Parcel)dataHolder);
        dataHolder.recycle();
        return object;
    }
}

