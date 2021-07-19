/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData$1;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData
implements Comparator,
Parcelable {
    public static final Parcelable.Creator CREATOR;
    private int hashCode;
    public final int schemeDataCount;
    private final DrmInitData$SchemeData[] schemeDatas;
    public final String schemeType;

    static {
        DrmInitData$1 drmInitData$1 = new DrmInitData$1();
        CREATOR = drmInitData$1;
    }

    public DrmInitData(Parcel drmInitData$SchemeDataArray) {
        int n10;
        String string2;
        this.schemeType = string2 = drmInitData$SchemeDataArray.readString();
        string2 = DrmInitData$SchemeData.CREATOR;
        drmInitData$SchemeDataArray = (DrmInitData$SchemeData[])Util.castNonNull((DrmInitData$SchemeData[])drmInitData$SchemeDataArray.createTypedArray((Parcelable.Creator)string2));
        this.schemeDatas = drmInitData$SchemeDataArray;
        this.schemeDataCount = n10 = drmInitData$SchemeDataArray.length;
    }

    public DrmInitData(String string2, List drmInitData$SchemeDataArray) {
        DrmInitData$SchemeData[] drmInitData$SchemeDataArray2 = new DrmInitData$SchemeData[]{};
        drmInitData$SchemeDataArray = drmInitData$SchemeDataArray.toArray(drmInitData$SchemeDataArray2);
        this(string2, false, drmInitData$SchemeDataArray);
    }

    private DrmInitData(String object, boolean bl2, DrmInitData$SchemeData ... object2) {
        int n10;
        this.schemeType = object;
        if (bl2) {
            object = object2.clone();
            object2 = object;
            object2 = (DrmInitData$SchemeData[])object;
        }
        this.schemeDatas = object2;
        this.schemeDataCount = n10 = ((DrmInitData$SchemeData[])object2).length;
        Arrays.sort(object2, this);
    }

    public DrmInitData(String string2, DrmInitData$SchemeData ... drmInitData$SchemeDataArray) {
        this(string2, true, drmInitData$SchemeDataArray);
    }

    public DrmInitData(List drmInitData$SchemeDataArray) {
        DrmInitData$SchemeData[] drmInitData$SchemeDataArray2 = new DrmInitData$SchemeData[]{};
        drmInitData$SchemeDataArray = drmInitData$SchemeDataArray.toArray(drmInitData$SchemeDataArray2);
        this(null, false, drmInitData$SchemeDataArray);
    }

    public DrmInitData(DrmInitData$SchemeData ... drmInitData$SchemeDataArray) {
        this((String)null, drmInitData$SchemeDataArray);
    }

    private static boolean containsSchemeDataWithUuid(ArrayList arrayList, int n10, UUID uUID) {
        for (int i10 = 0; i10 < n10; ++i10) {
            UUID uUID2 = ((DrmInitData$SchemeData)arrayList.get((int)i10)).uuid;
            boolean bl2 = uUID2.equals(uUID);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static DrmInitData createSessionCreationData(DrmInitData object, DrmInitData drmInitData$SchemeDataArray) {
        int n10;
        Object object2;
        DrmInitData$SchemeData drmInitData$SchemeData;
        int n11;
        Object object3;
        ArrayList<DrmInitData$SchemeData> arrayList = new ArrayList<DrmInitData$SchemeData>();
        int n12 = 0;
        DrmInitData drmInitData = null;
        if (object != null) {
            object3 = object.schemeType;
            object = object.schemeDatas;
            n11 = ((DrmInitData$SchemeData[])object).length;
            drmInitData$SchemeData = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                object2 = object[i10];
                boolean bl2 = ((DrmInitData$SchemeData)object2).hasData();
                if (!bl2) continue;
                arrayList.add((DrmInitData$SchemeData)object2);
            }
        } else {
            object3 = null;
        }
        if (drmInitData$SchemeDataArray != null) {
            if (object3 == null) {
                object3 = object = drmInitData$SchemeDataArray.schemeType;
            }
            n10 = arrayList.size();
            drmInitData$SchemeDataArray = drmInitData$SchemeDataArray.schemeDatas;
            n11 = drmInitData$SchemeDataArray.length;
            while (n12 < n11) {
                drmInitData$SchemeData = drmInitData$SchemeDataArray[n12];
                boolean bl3 = drmInitData$SchemeData.hasData();
                if (bl3 && !(bl3 = DrmInitData.containsSchemeDataWithUuid(arrayList, n10, (UUID)(object2 = drmInitData$SchemeData.uuid)))) {
                    arrayList.add(drmInitData$SchemeData);
                }
                ++n12;
            }
        }
        if ((n10 = arrayList.isEmpty()) == 0) {
            drmInitData = new DrmInitData((String)object3, arrayList);
        }
        return drmInitData;
    }

    public int compare(DrmInitData$SchemeData object, DrmInitData$SchemeData object2) {
        int n10;
        UUID uUID = C.UUID_NIL;
        UUID uUID2 = ((DrmInitData$SchemeData)object).uuid;
        boolean bl2 = uUID.equals(uUID2);
        if (bl2) {
            object = ((DrmInitData$SchemeData)object2).uuid;
            n10 = uUID.equals(object);
            if (n10 != 0) {
                n10 = 0;
                object = null;
            } else {
                n10 = 1;
            }
        } else {
            object = ((DrmInitData$SchemeData)object).uuid;
            object2 = ((DrmInitData$SchemeData)object2).uuid;
            n10 = ((UUID)object).compareTo((UUID)object2);
        }
        return n10;
    }

    public DrmInitData copyWithSchemeType(String string2) {
        Object object = this.schemeType;
        boolean bl2 = Util.areEqual(object, string2);
        if (bl2) {
            return this;
        }
        DrmInitData$SchemeData[] drmInitData$SchemeDataArray = this.schemeDatas;
        object = new DrmInitData(string2, false, drmInitData$SchemeDataArray);
        return object;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object objectArray) {
        Object object;
        Object object2;
        boolean bl2 = true;
        if (this == objectArray) {
            return bl2;
        }
        if (objectArray != null && (object2 = DrmInitData.class) == (object = objectArray.getClass())) {
            boolean bl3;
            objectArray = (DrmInitData)objectArray;
            object2 = this.schemeType;
            object = objectArray.schemeType;
            boolean bl4 = Util.areEqual(object2, object);
            if (!bl4 || !(bl3 = Arrays.equals(object2 = this.schemeDatas, objectArray = objectArray.schemeDatas))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public DrmInitData$SchemeData get(int n10) {
        return this.schemeDatas[n10];
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            String string2 = this.schemeType;
            if (string2 == null) {
                n10 = 0;
                string2 = null;
            } else {
                n10 = string2.hashCode();
            }
            n10 *= 31;
            Object[] objectArray = this.schemeDatas;
            int n11 = Arrays.hashCode(objectArray);
            this.hashCode = n10 += n11;
        }
        return this.hashCode;
    }

    public DrmInitData merge(DrmInitData objectArray) {
        boolean bl2;
        Object object;
        String string2 = this.schemeType;
        if (string2 != null && (object = objectArray.schemeType) != null && !(bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)object))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        Assertions.checkState(bl2);
        string2 = this.schemeType;
        if (string2 == null) {
            string2 = objectArray.schemeType;
        }
        object = this.schemeDatas;
        objectArray = objectArray.schemeDatas;
        objectArray = (DrmInitData$SchemeData[])Util.nullSafeArrayConcatenation(object, objectArray);
        object = new DrmInitData(string2, (DrmInitData$SchemeData[])objectArray);
        return object;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Parcelable[] parcelableArray = this.schemeType;
        parcel.writeString((String)parcelableArray);
        parcelableArray = this.schemeDatas;
        parcel.writeTypedArray(parcelableArray, 0);
    }
}

