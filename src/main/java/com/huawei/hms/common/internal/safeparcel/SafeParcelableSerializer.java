/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelable;
import com.huawei.hms.common.util.Base64Utils;
import java.util.ArrayList;

public final class SafeParcelableSerializer {
    public static SafeParcelable deserializeFromBytes(byte[] object, Parcelable.Creator creator) {
        Preconditions.checkNotNull(creator);
        Parcel parcel = Parcel.obtain();
        int n10 = ((byte[])object).length;
        parcel.unmarshall(object, 0, n10);
        parcel.setDataPosition(0);
        object = (SafeParcelable)creator.createFromParcel(parcel);
        parcel.recycle();
        return object;
    }

    public static SafeParcelable deserializeFromIntentExtra(Intent object, String string2, Parcelable.Creator creator) {
        if ((object = (Object)object.getByteArrayExtra(string2)) == null) {
            return null;
        }
        return SafeParcelableSerializer.deserializeFromBytes((byte[])object, creator);
    }

    public static SafeParcelable deserializeFromString(String string2, Parcelable.Creator creator) {
        return SafeParcelableSerializer.deserializeFromBytes(Base64Utils.decodeUrlSafe(string2), creator);
    }

    public static ArrayList deserializeIterableFromBundle(Bundle object, String arrayList, Parcelable.Creator creator) {
        int n10 = 0;
        SafeParcelable safeParcelable = null;
        if (object == null) {
            return null;
        }
        if ((object = (ArrayList)object.getSerializable((String)((Object)arrayList))) == null) {
            return null;
        }
        n10 = ((ArrayList)object).size();
        arrayList = new ArrayList<SafeParcelable>(n10);
        object = ((ArrayList)object).iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            safeParcelable = SafeParcelableSerializer.deserializeFromBytes((byte[])object.next(), creator);
            arrayList.add(safeParcelable);
        }
        return arrayList;
    }

    public static ArrayList deserializeIterableFromIntentExtra(Intent object, String arrayList, Parcelable.Creator creator) {
        if ((object = (ArrayList)object.getSerializableExtra((String)((Object)arrayList))) == null) {
            return null;
        }
        int n10 = ((ArrayList)object).size();
        arrayList = new ArrayList<SafeParcelable>(n10);
        object = ((ArrayList)object).iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            SafeParcelable safeParcelable = SafeParcelableSerializer.deserializeFromBytes((byte[])object.next(), creator);
            arrayList.add(safeParcelable);
        }
        return arrayList;
    }

    public static void serializeIterableToBundle(Iterable object, Bundle bundle, String string2) {
        boolean bl2;
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            byte[] byArray = SafeParcelableSerializer.serializeToBytes((SafeParcelable)object.next());
            arrayList.add(byArray);
        }
        bundle.putSerializable(string2, arrayList);
    }

    public static void serializeIterableToIntentExtra(Iterable object, Intent intent, String string2) {
        boolean bl2;
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            byte[] byArray = SafeParcelableSerializer.serializeToBytes((SafeParcelable)object.next());
            arrayList.add(byArray);
        }
        intent.putExtra(string2, arrayList);
    }

    public static byte[] serializeToBytes(SafeParcelable object) {
        Parcel parcel = Parcel.obtain();
        object.writeToParcel(parcel, 0);
        object = parcel.marshall();
        parcel.recycle();
        return object;
    }

    public static void serializeToIntentExtra(SafeParcelable object, Intent intent, String string2) {
        object = SafeParcelableSerializer.serializeToBytes((SafeParcelable)object);
        intent.putExtra(string2, (byte[])object);
    }

    public static String serializeToString(SafeParcelable safeParcelable) {
        return Base64Utils.encodeUrlSafe(SafeParcelableSerializer.serializeToBytes(safeParcelable));
    }
}

