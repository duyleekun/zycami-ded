/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package androidx.core.os;

import android.os.Parcel;

public interface ParcelableCompatCreatorCallbacks {
    public Object createFromParcel(Parcel var1, ClassLoader var2);

    public Object[] newArray(int var1);
}

