/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 */
package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;

public class VersionedParcelParcel
extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mFieldId;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;

    public VersionedParcelParcel(Parcel parcel) {
        int n10 = parcel.dataPosition();
        int n11 = parcel.dataSize();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        this(parcel, n10, n11, "", arrayMap, arrayMap2, arrayMap3);
    }

    private VersionedParcelParcel(Parcel parcel, int n10, int n11, String string2, ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        int n12;
        super();
        this.mPositionLookup = arrayMap;
        this.mCurrentField = n12 = -1;
        this.mNextRead = 0;
        this.mFieldId = n12;
        this.mParcel = parcel;
        this.mOffset = n10;
        this.mEnd = n11;
        this.mNextRead = n10;
        this.mPrefix = string2;
    }

    public void closeField() {
        int n10 = this.mCurrentField;
        if (n10 >= 0) {
            n10 = this.mPositionLookup.get(n10);
            Parcel parcel = this.mParcel;
            int n11 = parcel.dataPosition();
            int n12 = n11 - n10;
            Parcel parcel2 = this.mParcel;
            parcel2.setDataPosition(n10);
            this.mParcel.writeInt(n12);
            Parcel parcel3 = this.mParcel;
            parcel3.setDataPosition(n11);
        }
    }

    public VersionedParcel createSubParcel() {
        VersionedParcelParcel versionedParcelParcel;
        Parcel parcel = this.mParcel;
        int n10 = parcel.dataPosition();
        int n11 = this.mNextRead;
        int n12 = this.mOffset;
        if (n11 == n12) {
            n11 = this.mEnd;
        }
        n12 = n11;
        Object object = new StringBuilder();
        String string2 = this.mPrefix;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("  ");
        string2 = ((StringBuilder)object).toString();
        ArrayMap arrayMap = this.mReadCache;
        ArrayMap arrayMap2 = this.mWriteCache;
        ArrayMap arrayMap3 = this.mParcelizerCache;
        object = versionedParcelParcel;
        versionedParcelParcel = new VersionedParcelParcel(parcel, n10, n11, string2, arrayMap, arrayMap2, arrayMap3);
        return versionedParcelParcel;
    }

    public boolean readBoolean() {
        Parcel parcel = this.mParcel;
        int n10 = parcel.readInt();
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            parcel = null;
        }
        return n10 != 0;
    }

    public Bundle readBundle() {
        Parcel parcel = this.mParcel;
        ClassLoader classLoader = this.getClass().getClassLoader();
        return parcel.readBundle(classLoader);
    }

    public byte[] readByteArray() {
        Object object = this.mParcel;
        int n10 = object.readInt();
        if (n10 < 0) {
            return null;
        }
        object = new byte[n10];
        this.mParcel.readByteArray((byte[])object);
        return object;
    }

    public CharSequence readCharSequence() {
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        Parcel parcel = this.mParcel;
        return (CharSequence)creator.createFromParcel(parcel);
    }

    public double readDouble() {
        return this.mParcel.readDouble();
    }

    public boolean readField(int n10) {
        boolean bl2;
        int n11;
        while (true) {
            String string2;
            n11 = this.mNextRead;
            int n12 = this.mEnd;
            bl2 = true;
            if (n11 >= n12) break;
            n11 = this.mFieldId;
            if (n11 == n10) {
                return bl2;
            }
            String string3 = String.valueOf(n11);
            if ((n11 = string3.compareTo(string2 = String.valueOf(n10))) > 0) {
                return false;
            }
            string3 = this.mParcel;
            n12 = this.mNextRead;
            string3.setDataPosition(n12);
            string3 = this.mParcel;
            n11 = string3.readInt();
            string2 = this.mParcel;
            this.mFieldId = n12 = string2.readInt();
            this.mNextRead = n12 = this.mNextRead + n11;
        }
        n11 = this.mFieldId;
        if (n11 != n10) {
            bl2 = false;
        }
        return bl2;
    }

    public float readFloat() {
        return this.mParcel.readFloat();
    }

    public int readInt() {
        return this.mParcel.readInt();
    }

    public long readLong() {
        return this.mParcel.readLong();
    }

    public Parcelable readParcelable() {
        Parcel parcel = this.mParcel;
        ClassLoader classLoader = this.getClass().getClassLoader();
        return parcel.readParcelable(classLoader);
    }

    public String readString() {
        return this.mParcel.readString();
    }

    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    public void setOutputField(int n10) {
        this.closeField();
        this.mCurrentField = n10;
        SparseIntArray sparseIntArray = this.mPositionLookup;
        int n11 = this.mParcel.dataPosition();
        sparseIntArray.put(n10, n11);
        this.writeInt(0);
        this.writeInt(n10);
    }

    public void writeBoolean(boolean bl2) {
        this.mParcel.writeInt((int)(bl2 ? 1 : 0));
    }

    public void writeBundle(Bundle bundle) {
        this.mParcel.writeBundle(bundle);
    }

    public void writeByteArray(byte[] object) {
        if (object != null) {
            Parcel parcel = this.mParcel;
            int n10 = ((byte[])object).length;
            parcel.writeInt(n10);
            parcel = this.mParcel;
            parcel.writeByteArray(object);
        } else {
            object = this.mParcel;
            int n11 = -1;
            object.writeInt(n11);
        }
    }

    public void writeByteArray(byte[] object, int n10, int n11) {
        if (object != null) {
            Parcel parcel = this.mParcel;
            int n12 = ((byte[])object).length;
            parcel.writeInt(n12);
            parcel = this.mParcel;
            parcel.writeByteArray(object, n10, n11);
        } else {
            object = this.mParcel;
            n10 = -1;
            object.writeInt(n10);
        }
    }

    public void writeCharSequence(CharSequence charSequence) {
        Parcel parcel = this.mParcel;
        TextUtils.writeToParcel((CharSequence)charSequence, (Parcel)parcel, (int)0);
    }

    public void writeDouble(double d10) {
        this.mParcel.writeDouble(d10);
    }

    public void writeFloat(float f10) {
        this.mParcel.writeFloat(f10);
    }

    public void writeInt(int n10) {
        this.mParcel.writeInt(n10);
    }

    public void writeLong(long l10) {
        this.mParcel.writeLong(l10);
    }

    public void writeParcelable(Parcelable parcelable) {
        this.mParcel.writeParcelable(parcelable, 0);
    }

    public void writeString(String string2) {
        this.mParcel.writeString(string2);
    }

    public void writeStrongBinder(IBinder iBinder) {
        this.mParcel.writeStrongBinder(iBinder);
    }

    public void writeStrongInterface(IInterface iInterface) {
        this.mParcel.writeStrongInterface(iInterface);
    }
}

