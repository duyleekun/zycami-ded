/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 */
package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.huawei.hms.common.data.DataHolder;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

public class DataBufferRef {
    public final DataHolder mDataHolder;
    public int mDataRow;
    private int windowIndex;

    public DataBufferRef(DataHolder dataHolder, int n10) {
        Preconditions.checkNotNull(dataHolder, "dataHolder cannot be null");
        this.mDataHolder = dataHolder;
        this.getWindowIndex(n10);
    }

    public void copyToBuffer(String string2, CharArrayBuffer charArrayBuffer) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        dataHolder.copyToBuffer(string2, n10, n11, charArrayBuffer);
    }

    public boolean equals(Object object) {
        int n10 = object instanceof DataBufferRef;
        boolean bl2 = false;
        if (n10 != 0) {
            DataHolder dataHolder;
            object = (DataBufferRef)object;
            n10 = ((DataBufferRef)object).mDataRow;
            int n11 = this.mDataRow;
            if (n10 == n11 && (n10 = ((DataBufferRef)object).windowIndex) == (n11 = this.windowIndex) && (object = ((DataBufferRef)object).mDataHolder) == (dataHolder = this.mDataHolder)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public boolean getBoolean(String object) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        String string2 = "type_boolean";
        if ((object = dataHolder.getValue((String)object, n10, n11, string2)) != null) {
            return (Boolean)object;
        }
        return false;
    }

    public byte[] getByteArray(String object) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        String string2 = "type_byte_array";
        if ((object = dataHolder.getValue((String)object, n10, n11, string2)) != null) {
            return (byte[])object;
        }
        return null;
    }

    public int getDataRow() {
        return this.mDataRow;
    }

    public double getDouble(String object) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        String string2 = "type_double";
        if ((object = dataHolder.getValue((String)object, n10, n11, string2)) != null) {
            return (Double)object;
        }
        return -1.0;
    }

    public float getFloat(String object) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        String string2 = "type_float";
        if ((object = dataHolder.getValue((String)object, n10, n11, string2)) != null) {
            return ((Float)object).floatValue();
        }
        return -1.0f;
    }

    public int getInteger(String object) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        String string2 = "type_int";
        if ((object = dataHolder.getValue((String)object, n10, n11, string2)) != null) {
            return (Integer)object;
        }
        return -1;
    }

    public long getLong(String object) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        String string2 = "type_long";
        if ((object = dataHolder.getValue((String)object, n10, n11, string2)) != null) {
            return (Long)object;
        }
        return -1;
    }

    public String getString(String object) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        String string2 = "type_string";
        if ((object = dataHolder.getValue((String)object, n10, n11, string2)) != null) {
            return (String)object;
        }
        return "";
    }

    public final void getWindowIndex(int n10) {
        DataHolder dataHolder;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (dataHolder = this.mDataHolder).getCount())) {
            n11 = 1;
        } else {
            n11 = 0;
            dataHolder = null;
        }
        Preconditions.checkArgument(n11 != 0, "rowNum is out of index");
        this.mDataRow = n10;
        this.windowIndex = n10 = this.mDataHolder.getWindowIndex(n10);
    }

    public boolean hasColumn(String string2) {
        return this.mDataHolder.hasColumn(string2);
    }

    public boolean hasNull(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        return dataHolder.hasNull(string2, n10, n11);
    }

    public int hashCode() {
        Object object = this.mDataRow;
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.windowIndex), object = this.mDataHolder};
        return Objects.hashCode(objectArray);
    }

    public boolean isDataValid() {
        return this.mDataHolder.isClosed() ^ true;
    }

    public Uri parseUri(String string2) {
        DataHolder dataHolder = this.mDataHolder;
        int n10 = this.mDataRow;
        int n11 = this.windowIndex;
        String string3 = "type_string";
        if ((string2 = (String)dataHolder.getValue(string2, n10, n11, string3)) == null) {
            return null;
        }
        return Uri.parse((String)string2);
    }
}

