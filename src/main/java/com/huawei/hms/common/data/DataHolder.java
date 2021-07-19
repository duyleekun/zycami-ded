/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.database.Cursor
 *  android.database.CursorWindow
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.data.DataHolder$1;
import com.huawei.hms.common.data.DataHolder$Builder;
import com.huawei.hms.common.data.DataHolderBuilderCreator;
import com.huawei.hms.common.data.DataHolderCreator;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class DataHolder
extends AbstractSafeParcelable
implements Closeable {
    public static final Parcelable.Creator CREATOR;
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private static final DataHolder$Builder builder;
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;

    static {
        Object object = new DataHolderCreator();
        CREATOR = object;
        String[] stringArray = new String[]{};
        builder = object = new DataHolderBuilderCreator(stringArray, null);
    }

    public DataHolder(int n10, String[] stringArray, CursorWindow[] cursorWindowArray, int n11, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = n10;
        this.columns = stringArray;
        this.cursorWindows = cursorWindowArray;
        this.statusCode = n11;
        this.metadata = bundle;
        this.collectColumsAndCount();
    }

    public DataHolder(Cursor cursor, int n10, Bundle bundle) {
        HMSCursorWrapper hMSCursorWrapper = new HMSCursorWrapper(cursor);
        this(hMSCursorWrapper, n10, bundle);
    }

    private DataHolder(DataHolder$Builder cursorWindowArray, int n10, Bundle stringArray) {
        stringArray = DataHolder$Builder.access$200((DataHolder$Builder)cursorWindowArray);
        cursorWindowArray = DataHolder.getCursorWindows((DataHolder$Builder)cursorWindowArray, -1);
        this(stringArray, cursorWindowArray, n10, null);
    }

    private DataHolder(DataHolder$Builder cursorWindowArray, int n10, Bundle bundle, int n11) {
        String[] stringArray = DataHolder$Builder.access$200((DataHolder$Builder)cursorWindowArray);
        cursorWindowArray = DataHolder.getCursorWindows((DataHolder$Builder)cursorWindowArray, -1);
        this(stringArray, cursorWindowArray, n10, bundle);
    }

    public /* synthetic */ DataHolder(DataHolder$Builder dataHolder$Builder, int n10, Bundle bundle, int n11, DataHolder$1 dataHolder$1) {
        this(dataHolder$Builder, n10, bundle, n11);
    }

    public /* synthetic */ DataHolder(DataHolder$Builder dataHolder$Builder, int n10, Bundle bundle, DataHolder$1 dataHolder$1) {
        this(dataHolder$Builder, n10, bundle);
    }

    private DataHolder(HMSCursorWrapper cursorWindowArray, int n10, Bundle bundle) {
        String[] stringArray = cursorWindowArray.getColumnNames();
        cursorWindowArray = DataHolder.getCursorWindows((HMSCursorWrapper)cursorWindowArray);
        this(stringArray, cursorWindowArray, n10, bundle);
    }

    public DataHolder(String[] stringArray, CursorWindow[] cursorWindowArray, int n10, Bundle bundle) {
        boolean bl2;
        Preconditions.checkNotNull(stringArray, "columnsP cannot be null");
        Preconditions.checkNotNull(stringArray, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = bl2 = true;
        this.version = (int)(bl2 ? 1 : 0);
        this.columns = stringArray;
        this.cursorWindows = cursorWindowArray;
        this.statusCode = n10;
        this.metadata = bundle;
        this.collectColumsAndCount();
    }

    public static DataHolder$Builder builder(String[] stringArray) {
        DataHolder$Builder dataHolder$Builder = new DataHolder$Builder(stringArray, null, null);
        return dataHolder$Builder;
    }

    private void checkAvailable(String charSequence, int n10) {
        boolean bl2;
        Object object = this.columnsBundle;
        if (object != null && (bl2 = object.containsKey((String)charSequence))) {
            int n11 = this.isClosed();
            if (n11 != 0) {
                charSequence = "buffer has been closed";
            } else if (n10 >= 0 && n10 < (n11 = this.dataCount)) {
                charSequence = "";
            } else {
                charSequence = new StringBuilder();
                object = "row is out of index:";
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(n10);
                charSequence = ((StringBuilder)charSequence).toString();
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            object = "cannot find column: ";
            stringBuilder.append((String)object);
            stringBuilder.append((String)charSequence);
            charSequence = stringBuilder.toString();
        }
        Preconditions.checkArgument(((String)charSequence).isEmpty(), charSequence);
    }

    public static DataHolder empty(int n10) {
        DataHolder$Builder dataHolder$Builder = builder;
        DataHolder dataHolder = new DataHolder(dataHolder$Builder, n10, null);
        return dataHolder;
    }

    private static CursorWindow[] getCursorWindows(DataHolder$Builder object, int n10) {
        CursorWindow[] cursorWindowArray;
        Object object2 = DataHolder$Builder.access$200((DataHolder$Builder)object);
        int n11 = ((String[])object2).length;
        if (n11 == 0) {
            return new CursorWindow[0];
        }
        if (n10 < 0 || n10 >= (n11 = ((ArrayList)(object2 = DataHolder$Builder.access$300((DataHolder$Builder)object))).size())) {
            cursorWindowArray = DataHolder$Builder.access$300((DataHolder$Builder)object);
            n10 = cursorWindowArray.size();
        }
        object2 = DataHolder$Builder.access$300((DataHolder$Builder)object).subList(0, n10);
        object = DataHolder.iterCursorWindow((DataHolder$Builder)object, n10, (List)object2);
        cursorWindowArray = new CursorWindow[((ArrayList)object).size()];
        return ((ArrayList)object).toArray(cursorWindowArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        CursorWindow[] cursorWindowArray = new ArrayList();
        try {
            int n10;
            int n11;
            int n12 = hMSCursorWrapper.getCount();
            CursorWindow cursorWindow = hMSCursorWrapper.getWindow();
            if (cursorWindow != null && (n11 = cursorWindow.getStartPosition()) == 0) {
                cursorWindow.acquireReference();
                n11 = 0;
                Object var5_9 = null;
                hMSCursorWrapper.setWindow(null);
                cursorWindowArray.add(cursorWindow);
                n10 = cursorWindow.getNumRows();
            } else {
                n10 = 0;
                cursorWindow = null;
            }
            CursorWindow[] cursorWindowArray2 = DataHolder.iterCursorWrapper(hMSCursorWrapper, n10, n12);
            cursorWindowArray.addAll(cursorWindowArray2);
            n12 = cursorWindowArray.size();
            cursorWindowArray2 = new CursorWindow[n12];
            cursorWindowArray = cursorWindowArray.toArray(cursorWindowArray2);
        }
        catch (Throwable throwable) {
            String string2 = TAG;
            try {
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "fail to getCursorWindows: ";
                stringBuilder.append(string3);
                CursorWindow[] cursorWindowArray3 = throwable.getMessage();
                stringBuilder.append((String)cursorWindowArray3);
                cursorWindowArray3 = stringBuilder.toString();
                HMSLog.e(string2, (String)cursorWindowArray3);
                cursorWindowArray3 = new CursorWindow[]{};
                return cursorWindowArray3;
            }
            finally {
                hMSCursorWrapper.close();
            }
        }
        hMSCursorWrapper.close();
        return cursorWindowArray;
    }

    private static ArrayList iterCursorWindow(DataHolder$Builder stringArray, int n10, List object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = new CursorWindow(null);
        int n11 = DataHolder$Builder.access$200((DataHolder$Builder)stringArray).length;
        object2.setNumColumns(n11);
        arrayList.add(object2);
        n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3;
            Object object4;
            String string2;
            block30: {
                block31: {
                    int n12 = object2.allocRow();
                    string2 = TAG;
                    if (n12 != 0) break block30;
                    object2 = "Failed to allocate a row";
                    HMSLog.d(string2, (String)object2);
                    object2 = new CursorWindow(null);
                    object2.setStartPosition(i10);
                    object4 = DataHolder$Builder.access$200((DataHolder$Builder)stringArray);
                    n12 = ((E)object4).length;
                    object2.setNumColumns(n12);
                    n12 = (int)(object2.allocRow() ? 1 : 0);
                    if (n12 != 0) break block31;
                    stringArray = "Failed to retry to allocate a row";
                    HMSLog.e(string2, (String)stringArray);
                    return arrayList;
                }
                arrayList.add(object2);
            }
            object4 = object.get(i10);
            object4 = (HashMap)object4;
            boolean bl2 = true;
            int n13 = 0;
            while (true) {
                String[] stringArray2 = DataHolder$Builder.access$200((DataHolder$Builder)stringArray);
                int n14 = stringArray2.length;
                if (n13 >= n14) break;
                Object object5 = DataHolder$Builder.access$200((DataHolder$Builder)stringArray);
                object5 = object5[n13];
                object5 = object4.get(object5);
                bl2 = DataHolder.putValue(object2, object5, i10, n13);
                if (!bl2) break;
                ++n13;
                continue;
                break;
            }
            if (bl2) continue;
            try {
                object3 = new StringBuilder();
                object = "fail to put data for row ";
            }
            catch (RuntimeException runtimeException) {
                boolean bl3;
                object3 = arrayList.iterator();
                while (bl3 = object3.hasNext()) {
                    object = (CursorWindow)object3.next();
                    object.close();
                }
                throw runtimeException;
            }
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(i10);
            object3 = ((StringBuilder)object3).toString();
            HMSLog.d(string2, (String)object3);
            object2.freeLastRow();
            object3 = new CursorWindow(null);
            object3.setStartPosition(i10);
            stringArray = DataHolder$Builder.access$200((DataHolder$Builder)stringArray);
            int n15 = stringArray.length;
            object3.setNumColumns(n15);
            arrayList.add(object3);
            break;
        }
        return arrayList;
    }

    private static ArrayList iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int n10, int n11) {
        int n12;
        ArrayList<CursorWindow> arrayList = new ArrayList<CursorWindow>();
        while (n10 < n11 && (n12 = hMSCursorWrapper.moveToPosition(n10)) != 0) {
            CursorWindow cursorWindow = hMSCursorWrapper.getWindow();
            if (cursorWindow == null) {
                cursorWindow = new CursorWindow(null);
                cursorWindow.setStartPosition(n10);
                hMSCursorWrapper.fillWindow(n10, cursorWindow);
            } else {
                cursorWindow.acquireReference();
                hMSCursorWrapper.setWindow(null);
            }
            n10 = cursorWindow.getNumRows();
            if (n10 == 0) break;
            arrayList.add(cursorWindow);
            n10 = cursorWindow.getNumRows();
            n12 = cursorWindow.getStartPosition();
            n10 += n12;
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow object, Object object2, int n10, int n11) {
        if (object2 == null) {
            return object.putNull(n10, n11);
        }
        boolean bl2 = object2 instanceof Boolean;
        if (bl2) {
            long l10;
            boolean bl3 = (Boolean)(object2 = (Boolean)object2);
            if (bl3) {
                l10 = 1L;
                double d10 = Double.MIN_VALUE;
            } else {
                l10 = 0L;
                double d11 = 0.0;
            }
            return object.putLong(l10, n10, n11);
        }
        bl2 = object2 instanceof Integer;
        if (bl2) {
            long l11 = ((Integer)object2).intValue();
            return object.putLong(l11, n10, n11);
        }
        bl2 = object2 instanceof Long;
        if (bl2) {
            long l12 = (Long)object2;
            return object.putLong(l12, n10, n11);
        }
        bl2 = object2 instanceof Float;
        if (bl2) {
            double d12 = ((Float)object2).floatValue();
            return object.putDouble(d12, n10, n11);
        }
        bl2 = object2 instanceof Double;
        if (bl2) {
            double d13 = (Double)object2;
            return object.putDouble(d13, n10, n11);
        }
        bl2 = object2 instanceof String;
        if (bl2) {
            object2 = (String)object2;
            return object.putString((String)object2, n10, n11);
        }
        bl2 = object2 instanceof byte[];
        if (bl2) {
            object2 = (byte[])object2;
            return object.putBlob((byte[])object2, n10, n11);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unsupported type for column: ");
        stringBuilder.append(object2);
        object2 = stringBuilder.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void close() {
        synchronized (this) {
            boolean bl2 = this.mClosed;
            if (!bl2) {
                for (CursorWindow cursorWindow : this.cursorWindows) {
                    cursorWindow.close();
                }
                this.mClosed = bl2 = true;
            }
            return;
        }
    }

    public final void collectColumsAndCount() {
        Object object;
        CursorWindow cursorWindow;
        int n10;
        int n11;
        Bundle bundle;
        this.columnsBundle = bundle = new Bundle();
        int n12 = 0;
        bundle = null;
        Object object2 = null;
        for (n11 = 0; n11 < (n10 = ((String[])(cursorWindow = this.columns)).length); ++n11) {
            object = this.columnsBundle;
            cursorWindow = cursorWindow[n11];
            object.putInt((String)cursorWindow, n11);
        }
        object2 = new int[this.cursorWindows.length];
        this.perCursorCounts = object2;
        n11 = 0;
        object2 = null;
        while (n12 < (n10 = ((String[])(cursorWindow = this.cursorWindows)).length)) {
            object = this.perCursorCounts;
            object[n12] = (Bundle)n11;
            object2 = cursorWindow[n12];
            n11 = object2.getStartPosition();
            cursorWindow = this.cursorWindows[n12];
            int n13 = cursorWindow.getNumRows();
            n11 += n13;
            ++n12;
        }
        this.dataCount = n11;
    }

    public final void copyToBuffer(String string2, int n10, int n11, CharArrayBuffer charArrayBuffer) {
        this.checkAvailable(string2, n10);
        CursorWindow cursorWindow = this.cursorWindows[n11];
        int n12 = this.columnsBundle.getInt(string2);
        cursorWindow.copyStringToBuffer(n10, n12, charArrayBuffer);
    }

    public final void finalize() {
        CursorWindow[] cursorWindowArray;
        int n10 = this.isInstance;
        if (n10 != 0 && (n10 = (cursorWindowArray = this.cursorWindows).length) > 0 && (n10 = (int)(this.isClosed() ? 1 : 0)) == 0) {
            this.close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    /*
     * WARNING - void declaration
     */
    public final Object getValue(String string2, int n10, int n11, String string3) {
        void var7_15;
        string3.hashCode();
        int n12 = string3.hashCode();
        boolean bl2 = true;
        int bl3 = -1;
        switch (n12) {
            default: {
                break;
            }
            case 1300508295: {
                String string4 = TYPE_BYTE_ARRAY;
                boolean bl4 = string3.equals(string4);
                if (!bl4) break;
                int n13 = 6;
                break;
            }
            case 878975158: {
                String string5 = TYPE_STRING;
                boolean bl5 = string3.equals(string5);
                if (!bl5) break;
                int n14 = 5;
                break;
            }
            case 519136353: {
                String string6 = TYPE_LONG;
                boolean bl6 = string3.equals(string6);
                if (!bl6) break;
                int n15 = 4;
                break;
            }
            case 445002870: {
                String string7 = TYPE_DOUBLE;
                boolean bl7 = string3.equals(string7);
                if (!bl7) break;
                int n16 = 3;
                break;
            }
            case -675993238: {
                String string8 = TYPE_INT;
                boolean bl8 = string3.equals(string8);
                if (!bl8) break;
                int n17 = 2;
                break;
            }
            case -870070237: {
                String string9 = TYPE_BOOLEAN;
                boolean bl9 = string3.equals(string9);
                if (!bl9) break;
                boolean bl10 = bl2;
                break;
            }
            case -1092271849: {
                String string10 = TYPE_FLOAT;
                boolean bl11 = string3.equals(string10);
                if (!bl11) break;
                boolean bl12 = false;
            }
        }
        switch (var7_15) {
            default: {
                return null;
            }
            case 6: {
                this.checkAvailable(string2, n10);
                CursorWindow cursorWindow = this.cursorWindows[n11];
                int n18 = this.columnsBundle.getInt(string2);
                return cursorWindow.getBlob(n10, n18);
            }
            case 5: {
                this.checkAvailable(string2, n10);
                CursorWindow cursorWindow = this.cursorWindows[n11];
                int n19 = this.columnsBundle.getInt(string2);
                return cursorWindow.getString(n10, n19);
            }
            case 4: {
                this.checkAvailable(string2, n10);
                CursorWindow cursorWindow = this.cursorWindows[n11];
                int n20 = this.columnsBundle.getInt(string2);
                return cursorWindow.getLong(n10, n20);
            }
            case 3: {
                this.checkAvailable(string2, n10);
                CursorWindow cursorWindow = this.cursorWindows[n11];
                int n21 = this.columnsBundle.getInt(string2);
                return cursorWindow.getDouble(n10, n21);
            }
            case 2: {
                this.checkAvailable(string2, n10);
                CursorWindow cursorWindow = this.cursorWindows[n11];
                int n22 = this.columnsBundle.getInt(string2);
                return cursorWindow.getInt(n10, n22);
            }
            case 1: {
                this.checkAvailable(string2, n10);
                CursorWindow cursorWindow = this.cursorWindows[n11];
                string3 = this.columnsBundle;
                int n23 = string3.getInt(string2);
                long l10 = cursorWindow.getLong(n10, n23);
                long l11 = 1L;
                n23 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n23 != 0) {
                    bl2 = false;
                }
                return bl2;
            }
            case 0: 
        }
        this.checkAvailable(string2, n10);
        CursorWindow cursorWindow = this.cursorWindows[n11];
        int n24 = this.columnsBundle.getInt(string2);
        return Float.valueOf(cursorWindow.getFloat(n10, n24));
    }

    public final int getWindowIndex(int n10) {
        int n11;
        int[] nArray;
        int n12;
        int n13 = 0;
        if (n10 < 0 && n10 >= (n12 = this.dataCount)) {
            n12 = 0;
            nArray = null;
        } else {
            n12 = 1;
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "rowIndex is out of index:";
        charSequence.append(string2);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Preconditions.checkArgument(n12 != 0, charSequence);
        while (n13 < (n11 = (nArray = this.perCursorCounts).length)) {
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
        return this.columnsBundle.containsKey(string2);
    }

    /*
     * WARNING - void declaration
     */
    public final boolean hasNull(String string2, int n10, int n11) {
        void var6_10;
        this.checkAvailable(string2, n10);
        CursorWindow cursorWindow = this.cursorWindows[n11];
        Bundle bundle = this.columnsBundle;
        int n12 = bundle.getInt(string2);
        n12 = cursorWindow.getType(n10, n12);
        if (n12 == 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            string2 = null;
        }
        return (boolean)var6_10;
    }

    public final boolean isClosed() {
        synchronized (this) {
            boolean bl2 = this.mClosed;
            return bl2;
        }
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Bundle bundle = this.columns;
        int n12 = 1;
        SafeParcelWriter.writeStringArray(parcel, n12, (String[])bundle, false);
        bundle = this.cursorWindows;
        SafeParcelWriter.writeTypedArray(parcel, 2, (Parcelable[])bundle, n10, false);
        int n13 = this.getStatusCode();
        SafeParcelWriter.writeInt(parcel, 3, n13);
        bundle = this.getMetadata();
        int n14 = 4;
        SafeParcelWriter.writeBundle(parcel, n14, bundle, false);
        n13 = this.version;
        int n15 = 1000;
        SafeParcelWriter.writeInt(parcel, n15, n13);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
        int n16 = n10 & 1;
        if (n16 != 0) {
            this.close();
        }
    }
}

