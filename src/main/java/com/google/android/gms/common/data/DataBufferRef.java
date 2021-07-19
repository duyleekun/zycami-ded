/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 */
package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public class DataBufferRef {
    public final DataHolder mDataHolder;
    public int mDataRow;
    private int zaln;

    public DataBufferRef(DataHolder dataHolder, int n10) {
        this.mDataHolder = dataHolder = (DataHolder)Preconditions.checkNotNull(dataHolder);
        this.zag(n10);
    }

    public void copyToBuffer(String string2, CharArrayBuffer charArrayBuffer) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        dataHolder.zaa(string2, n10, n11, charArrayBuffer);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof DataBufferRef;
        if (bl2) {
            int n10;
            Integer n11;
            object = (DataBufferRef)object;
            Object object2 = ((DataBufferRef)object).mDataRow;
            bl2 = Objects.equal(object2, n11 = Integer.valueOf(n10 = this.mDataRow));
            if (bl2 && (bl2 = Objects.equal(object2 = Integer.valueOf(((DataBufferRef)object).zaln), n11 = Integer.valueOf(n10 = this.zaln))) && (object = ((DataBufferRef)object).mDataHolder) == (object2 = this.mDataHolder)) {
                return true;
            }
        }
        return false;
    }

    public boolean getBoolean(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        return dataHolder.getBoolean(string2, n10, n11);
    }

    public byte[] getByteArray(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        return dataHolder.getByteArray(string2, n10, n11);
    }

    public int getDataRow() {
        return this.mDataRow;
    }

    public double getDouble(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        return dataHolder.zab(string2, n10, n11);
    }

    public float getFloat(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        return dataHolder.zaa(string2, n10, n11);
    }

    public int getInteger(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        return dataHolder.getInteger(string2, n10, n11);
    }

    public long getLong(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        return dataHolder.getLong(string2, n10, n11);
    }

    public String getString(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        return dataHolder.getString(string2, n10, n11);
    }

    public boolean hasColumn(String string2) {
        return this.mDataHolder.hasColumn(string2);
    }

    public boolean hasNull(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        return dataHolder.hasNull(string2, n10, n11);
    }

    public int hashCode() {
        Object object = this.mDataRow;
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.zaln), object = this.mDataHolder};
        return Objects.hashCode(objectArray);
    }

    public boolean isDataValid() {
        DataHolder dataHolder = this.mDataHolder;
        boolean bl2 = dataHolder.isClosed();
        return !bl2;
    }

    public Uri parseUri(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.zaln;
        if ((string2 = dataHolder.getString(string2, n10, n11)) == null) {
            return null;
        }
        return Uri.parse((String)string2);
    }

    public final void zag(int n10) {
        DataHolder dataHolder;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (dataHolder = this.mDataHolder).getCount())) {
            n11 = 1;
        } else {
            n11 = 0;
            dataHolder = null;
        }
        Preconditions.checkState(n11 != 0);
        this.mDataRow = n10;
        this.zaln = n10 = this.mDataHolder.getWindowIndex(n10);
    }
}

