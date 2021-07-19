/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.database.Cursor
 *  android.database.CursorIndexOutOfBoundsException
 *  android.database.CursorWindow
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 */
package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder$Builder;
import com.google.android.gms.common.data.DataHolder$zaa;
import com.google.android.gms.common.data.zab;
import com.google.android.gms.common.data.zac;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Map;

public final class DataHolder
extends AbstractSafeParcelable
implements Closeable {
    public static final Parcelable.Creator CREATOR;
    private static final DataHolder$Builder zaly;
    private boolean mClosed;
    private final int zalf;
    private final String[] zalq;
    private Bundle zalr;
    private final CursorWindow[] zals;
    private final int zalt;
    private final Bundle zalu;
    private int[] zalv;
    private int zalw;
    private boolean zalx;

    static {
        Object object = new zac();
        CREATOR = object;
        String[] stringArray = new String[]{};
        zaly = object = new zab(stringArray, null);
    }

    public DataHolder(int n10, String[] stringArray, CursorWindow[] cursorWindowArray, int n11, Bundle bundle) {
        this.mClosed = false;
        this.zalx = true;
        this.zalf = n10;
        this.zalq = stringArray;
        this.zals = cursorWindowArray;
        this.zalt = n11;
        this.zalu = bundle;
    }

    public DataHolder(Cursor cursor, int n10, Bundle bundle) {
        CursorWrapper cursorWrapper = new CursorWrapper(cursor);
        this(cursorWrapper, n10, bundle);
    }

    private DataHolder(DataHolder$Builder cursorWindowArray, int n10, Bundle stringArray) {
        stringArray = DataHolder$Builder.zaa((DataHolder$Builder)cursorWindowArray);
        cursorWindowArray = DataHolder.zaa((DataHolder$Builder)cursorWindowArray, -1);
        this(stringArray, cursorWindowArray, n10, null);
    }

    private DataHolder(DataHolder$Builder cursorWindowArray, int n10, Bundle bundle, int n11) {
        String[] stringArray = DataHolder$Builder.zaa((DataHolder$Builder)cursorWindowArray);
        cursorWindowArray = DataHolder.zaa((DataHolder$Builder)cursorWindowArray, -1);
        this(stringArray, cursorWindowArray, n10, bundle);
    }

    public /* synthetic */ DataHolder(DataHolder$Builder dataHolder$Builder, int n10, Bundle bundle, int n11, zab zab2) {
        this(dataHolder$Builder, n10, bundle, -1);
    }

    public /* synthetic */ DataHolder(DataHolder$Builder dataHolder$Builder, int n10, Bundle bundle, zab zab2) {
        this(dataHolder$Builder, n10, null);
    }

    private DataHolder(CursorWrapper cursorWindowArray, int n10, Bundle bundle) {
        String[] stringArray = cursorWindowArray.getColumnNames();
        cursorWindowArray = DataHolder.zaa((CursorWrapper)cursorWindowArray);
        this(stringArray, cursorWindowArray, n10, bundle);
    }

    public DataHolder(String[] stringArray, CursorWindow[] cursorWindowArray, int n10, Bundle bundle) {
        boolean bl2;
        this.mClosed = false;
        this.zalx = bl2 = true;
        this.zalf = (int)(bl2 ? 1 : 0);
        stringArray = (String[])Preconditions.checkNotNull(stringArray);
        this.zalq = stringArray;
        stringArray = (CursorWindow[])Preconditions.checkNotNull(cursorWindowArray);
        this.zals = stringArray;
        this.zalt = n10;
        this.zalu = bundle;
        this.zaca();
    }

    public static DataHolder$Builder builder(String[] stringArray) {
        DataHolder$Builder dataHolder$Builder = new DataHolder$Builder(stringArray, null, null);
        return dataHolder$Builder;
    }

    public static DataHolder empty(int n10) {
        DataHolder$Builder dataHolder$Builder = zaly;
        DataHolder dataHolder = new DataHolder(dataHolder$Builder, n10, null);
        return dataHolder;
    }

    private final void zaa(String object, int n10) {
        int n11;
        Object object2 = this.zalr;
        if (object2 != null && (n11 = object2.containsKey((String)object)) != 0) {
            int n12 = this.isClosed();
            if (n12 == 0) {
                if (n10 >= 0 && n10 < (n12 = this.zalw)) {
                    return;
                }
                n11 = this.zalw;
                object = new CursorIndexOutOfBoundsException(n10, n11);
                throw object;
            }
            object = new IllegalArgumentException("Buffer is closed.");
            throw object;
        }
        object2 = "No such column: ";
        int n13 = ((String)(object = String.valueOf(object))).length();
        object = n13 != 0 ? ((String)object2).concat((String)object) : new String((String)object2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static CursorWindow[] zaa(DataHolder$Builder object, int n10) {
        int n11;
        Object object2;
        Object object3 = DataHolder$Builder.zaa((DataHolder$Builder)object);
        int n12 = ((String[])object3).length;
        int n13 = 0;
        if (n12 == 0) {
            return new CursorWindow[0];
        }
        if (n10 >= 0 && n10 < (n12 = ((ArrayList)(object3 = DataHolder$Builder.zab((DataHolder$Builder)object))).size())) {
            object3 = DataHolder$Builder.zab((DataHolder$Builder)object);
            object2 = ((ArrayList)object3).subList(0, n10);
        } else {
            object2 = DataHolder$Builder.zab((DataHolder$Builder)object);
        }
        n12 = object2.size();
        Object object4 = new CursorWindow(false);
        ArrayList<CursorWindow> arrayList = new ArrayList<CursorWindow>();
        arrayList.add((CursorWindow)object4);
        int n14 = DataHolder$Builder.zaa((DataHolder$Builder)object).length;
        object4.setNumColumns(n14);
        int n15 = 0;
        String[] stringArray = null;
        for (n14 = 0; n14 < n12; n14 += n11) {
            int n16;
            String[] stringArray2;
            String string2;
            block87: {
                Object object5;
                Object object6;
                int n17;
                block86: {
                    int n18 = object4.allocRow();
                    string2 = "DataHolder";
                    if (n18 != 0) break block86;
                    n17 = 72;
                    stringArray2 = new StringBuilder(n17);
                    object4 = "Allocating additional cursor window for large data set (row ";
                    stringArray2.append((String)object4);
                    stringArray2.append(n14);
                    object4 = ")";
                    stringArray2.append((String)object4);
                    object4 = stringArray2.toString();
                    Log.d((String)string2, (String)object4);
                    object4 = new CursorWindow(false);
                    object4.setStartPosition(n14);
                    stringArray2 = DataHolder$Builder.zaa((DataHolder$Builder)object);
                    n18 = stringArray2.length;
                    object4.setNumColumns(n18);
                    arrayList.add((CursorWindow)object4);
                    n18 = (int)(object4.allocRow() ? 1 : 0);
                    if (n18 != 0) break block86;
                    object = "Unable to allocate row to hold data.";
                    Log.e((String)string2, (String)object);
                    arrayList.remove(object4);
                    int n19 = arrayList.size();
                    object = new CursorWindow[n19];
                    object = arrayList.toArray((T[])object);
                    return object;
                }
                stringArray2 = object2.get(n14);
                stringArray2 = (Map)stringArray2;
                n11 = 1;
                float f10 = Float.MIN_VALUE;
                int n20 = 0;
                n16 = n11;
                float f11 = f10;
                while (true) {
                    double d10;
                    long l10;
                    block88: {
                        object6 = DataHolder$Builder.zaa((DataHolder$Builder)object);
                        int n21 = ((String[])object6).length;
                        if (n20 >= n21 || n16 == 0) break block87;
                        object5 = DataHolder$Builder.zaa((DataHolder$Builder)object);
                        object5 = object5[n20];
                        object6 = stringArray2.get(object5);
                        if (object6 != null) break block88;
                        n16 = (int)(object4.putNull(n14, n20) ? 1 : 0);
                    }
                    boolean bl2 = object6 instanceof String;
                    if (bl2) {
                        object6 = (String)object6;
                        n16 = (int)(object4.putString((String)object6, n14, n20) ? 1 : 0);
                    }
                    bl2 = object6 instanceof Long;
                    if (bl2) {
                        object6 = (Long)object6;
                        l10 = (Long)object6;
                        n16 = (int)(object4.putLong(l10, n14, n20) ? 1 : 0);
                    }
                    bl2 = object6 instanceof Integer;
                    if (bl2) {
                        object6 = (Integer)object6;
                        n16 = (Integer)object6;
                        l10 = n16;
                        n16 = (int)(object4.putLong(l10, n14, n20) ? 1 : 0);
                    }
                    bl2 = object6 instanceof Boolean;
                    if (bl2) {
                        block89: {
                            object6 = (Boolean)object6;
                            n16 = (int)(((Boolean)object6).booleanValue() ? 1 : 0);
                            if (n16 != 0) {
                                l10 = 1L;
                                d10 = Double.MIN_VALUE;
                                break block89;
                            }
                            l10 = 0L;
                            d10 = 0.0;
                        }
                        n16 = (int)(object4.putLong(l10, n14, n20) ? 1 : 0);
                    }
                    bl2 = object6 instanceof byte[];
                    if (bl2) {
                        object6 = (byte[])object6;
                        n16 = (int)(object4.putBlob((byte[])object6, n14, n20) ? 1 : 0);
                    }
                    bl2 = object6 instanceof Double;
                    if (bl2) {
                        object6 = (Double)object6;
                        d10 = (Double)object6;
                        n16 = (int)(object4.putDouble(d10, n14, n20) ? 1 : 0);
                    }
                    bl2 = object6 instanceof Float;
                    if (!bl2) break;
                    object6 = (Float)object6;
                    f11 = ((Float)object6).floatValue();
                    d10 = f11;
                    n16 = (int)(object4.putDouble(d10, n14, n20) ? 1 : 0);
                    ++n20;
                }
                try {
                    object2 = String.valueOf(object6);
                }
                catch (RuntimeException runtimeException) {
                    n10 = arrayList.size();
                    while (n13 < n10) {
                        object3 = (CursorWindow)arrayList.get(n13);
                        object3.close();
                        ++n13;
                    }
                    throw runtimeException;
                }
                object3 = String.valueOf(object5);
                n12 = ((String)object3).length() + 32;
                object4 = String.valueOf(object2);
                n17 = ((String)object4).length();
                n12 += n17;
                object4 = new StringBuilder(n12);
                object3 = "Unsupported object for column ";
                ((StringBuilder)object4).append((String)object3);
                ((StringBuilder)object4).append((String)object5);
                object3 = ": ";
                ((StringBuilder)object4).append((String)object3);
                ((StringBuilder)object4).append((String)object2);
                object2 = ((StringBuilder)object4).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            if (n16 == 0) {
                if (n15 == 0) {
                    n15 = 74;
                    stringArray2 = new StringBuilder(n15);
                    stringArray = "Couldn't populate window data for row ";
                    stringArray2.append((String)stringArray);
                    stringArray2.append(n14);
                    stringArray = " - allocating new window.";
                    stringArray2.append((String)stringArray);
                    stringArray = stringArray2.toString();
                    Log.d((String)string2, (String)stringArray);
                    object4.freeLastRow();
                    object4 = new CursorWindow(false);
                    object4.setStartPosition(n14);
                    stringArray = DataHolder$Builder.zaa((DataHolder$Builder)object);
                    n15 = stringArray.length;
                    object4.setNumColumns(n15);
                    arrayList.add((CursorWindow)object4);
                    n14 += -1;
                    n15 = n11;
                    continue;
                }
                object = "Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.";
                object2 = new DataHolder$zaa((String)object);
                throw object2;
            }
            n15 = 0;
            stringArray = null;
        }
        object = new CursorWindow[arrayList.size()];
        return arrayList.toArray((T[])object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static CursorWindow[] zaa(CursorWrapper cursorWindowArray) {
        ArrayList<CursorWindow> arrayList = new ArrayList<CursorWindow>();
        try {
            int n10;
            int n11;
            int n12 = cursorWindowArray.getCount();
            CursorWindow cursorWindow = cursorWindowArray.getWindow();
            if (cursorWindow != null && (n11 = cursorWindow.getStartPosition()) == 0) {
                cursorWindow.acquireReference();
                cursorWindowArray.setWindow(null);
                arrayList.add(cursorWindow);
                n10 = cursorWindow.getNumRows();
            } else {
                n10 = 0;
                cursorWindow = null;
            }
            while (n10 < n12 && (n11 = (int)(cursorWindowArray.moveToPosition(n10) ? 1 : 0)) != 0) {
                CursorWindow cursorWindow2 = cursorWindowArray.getWindow();
                if (cursorWindow2 != null) {
                    cursorWindow2.acquireReference();
                    cursorWindowArray.setWindow(null);
                } else {
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(n10);
                    cursorWindowArray.fillWindow(n10, cursorWindow2);
                }
                n10 = cursorWindow2.getNumRows();
                if (n10 != 0) {
                    arrayList.add(cursorWindow2);
                    n10 = cursorWindow2.getStartPosition();
                    n11 = cursorWindow2.getNumRows();
                    n10 += n11;
                    continue;
                }
                break;
            }
        }
        finally {
            cursorWindowArray.close();
        }
        cursorWindowArray = new CursorWindow[arrayList.size()];
        return arrayList.toArray(cursorWindowArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void close() {
        synchronized (this) {
            int n10 = this.mClosed;
            if (n10 == 0) {
                CursorWindow cursorWindow;
                int n11;
                this.mClosed = n10 = 1;
                Object var2_2 = null;
                for (n10 = 0; n10 < (n11 = ((CursorWindow[])(cursorWindow = this.zals)).length); ++n10) {
                    cursorWindow = cursorWindow[n10];
                    cursorWindow.close();
                }
            }
            return;
        }
    }

    public final void finalize() {
        block16: {
            int n10 = this.zalx;
            if (n10 == 0) break block16;
            Object object = this.zals;
            n10 = ((CursorWindow[])object).length;
            if (n10 <= 0) break block16;
            n10 = (int)(this.isClosed() ? 1 : 0);
            if (n10 != 0) break block16;
            this.close();
            object = "DataBuffer";
            String string2 = this.toString();
            String string3 = String.valueOf(string2);
            int n11 = string3.length() + 178;
            StringBuilder stringBuilder = new StringBuilder(n11);
            string3 = "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = ")";
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            Log.e((String)object, (String)string2);
        }
        return;
        finally {
            super.finalize();
        }
    }

    public final boolean getBoolean(String object, int n10, int n11) {
        this.zaa((String)object, n10);
        CursorWindow cursorWindow = this.zals[n11];
        Bundle bundle = this.zalr;
        int n12 = bundle.getInt((String)object);
        object = cursorWindow.getLong(n10, n12);
        long l10 = (Long)object;
        long l11 = 1L;
        n12 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        return n12 == 0;
    }

    public final byte[] getByteArray(String string2, int n10, int n11) {
        this.zaa(string2, n10);
        CursorWindow cursorWindow = this.zals[n11];
        int n12 = this.zalr.getInt(string2);
        return cursorWindow.getBlob(n10, n12);
    }

    public final int getCount() {
        return this.zalw;
    }

    public final int getInteger(String string2, int n10, int n11) {
        this.zaa(string2, n10);
        CursorWindow cursorWindow = this.zals[n11];
        int n12 = this.zalr.getInt(string2);
        return cursorWindow.getInt(n10, n12);
    }

    public final long getLong(String string2, int n10, int n11) {
        this.zaa(string2, n10);
        CursorWindow cursorWindow = this.zals[n11];
        int n12 = this.zalr.getInt(string2);
        return cursorWindow.getLong(n10, n12);
    }

    public final Bundle getMetadata() {
        return this.zalu;
    }

    public final int getStatusCode() {
        return this.zalt;
    }

    public final String getString(String string2, int n10, int n11) {
        this.zaa(string2, n10);
        CursorWindow cursorWindow = this.zals[n11];
        int n12 = this.zalr.getInt(string2);
        return cursorWindow.getString(n10, n12);
    }

    public final int getWindowIndex(int n10) {
        int n11;
        int[] nArray;
        int n12;
        int n13 = 0;
        if (n10 >= 0 && n10 < (n12 = this.zalw)) {
            n12 = 1;
        } else {
            n12 = 0;
            nArray = null;
        }
        Preconditions.checkState(n12 != 0);
        while (n13 < (n11 = (nArray = this.zalv).length)) {
            n11 = nArray[n13];
            if (n10 < n11) {
                n13 += -1;
                break;
            }
            ++n13;
        }
        if (n13 == (n10 = nArray.length)) {
            n13 += -1;
        }
        return n13;
    }

    public final boolean hasColumn(String string2) {
        return this.zalr.containsKey(string2);
    }

    public final boolean hasNull(String string2, int n10, int n11) {
        this.zaa(string2, n10);
        CursorWindow cursorWindow = this.zals[n11];
        int n12 = this.zalr.getInt(string2);
        return cursorWindow.isNull(n10, n12);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean isClosed() {
        synchronized (this) {
            return this.mClosed;
        }
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Bundle bundle = this.zalq;
        int n12 = 1;
        SafeParcelWriter.writeStringArray(parcel, n12, (String[])bundle, false);
        bundle = this.zals;
        SafeParcelWriter.writeTypedArray(parcel, 2, (Parcelable[])bundle, n10, false);
        int n13 = this.getStatusCode();
        SafeParcelWriter.writeInt(parcel, 3, n13);
        bundle = this.getMetadata();
        int n14 = 4;
        SafeParcelWriter.writeBundle(parcel, n14, bundle, false);
        n13 = this.zalf;
        int n15 = 1000;
        SafeParcelWriter.writeInt(parcel, n15, n13);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
        int n16 = n10 & 1;
        if (n16 != 0) {
            this.close();
        }
    }

    public final float zaa(String string2, int n10, int n11) {
        this.zaa(string2, n10);
        CursorWindow cursorWindow = this.zals[n11];
        int n12 = this.zalr.getInt(string2);
        return cursorWindow.getFloat(n10, n12);
    }

    public final void zaa(String string2, int n10, int n11, CharArrayBuffer charArrayBuffer) {
        this.zaa(string2, n10);
        CursorWindow cursorWindow = this.zals[n11];
        int n12 = this.zalr.getInt(string2);
        cursorWindow.copyStringToBuffer(n10, n12, charArrayBuffer);
    }

    public final double zab(String string2, int n10, int n11) {
        this.zaa(string2, n10);
        CursorWindow cursorWindow = this.zals[n11];
        int n12 = this.zalr.getInt(string2);
        return cursorWindow.getDouble(n10, n12);
    }

    public final void zaca() {
        Bundle bundle;
        Object object;
        int n10;
        int n11;
        Bundle bundle2;
        this.zalr = bundle2 = new Bundle();
        int n12 = 0;
        bundle2 = null;
        int[] nArray = null;
        for (n11 = 0; n11 < (n10 = ((String[])(object = this.zalq)).length); ++n11) {
            bundle = this.zalr;
            object = object[n11];
            bundle.putInt((String)object, n11);
        }
        nArray = new int[this.zals.length];
        this.zalv = nArray;
        n11 = 0;
        nArray = null;
        while (n12 < (n10 = ((String[])(object = this.zals)).length)) {
            this.zalv[n12] = n11;
            object = object[n12];
            int n13 = object.getStartPosition();
            n13 = n11 - n13;
            bundle = this.zals[n12];
            n10 = bundle.getNumRows() - n13;
            n11 += n10;
            ++n12;
        }
        this.zalw = n11;
    }
}

