/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import java.util.Iterator;

public abstract class FastSafeParcelableJsonResponse
extends FastJsonResponse
implements SafeParcelable {
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        Class<?> clazz = this.getClass();
        boolean bl4 = clazz.isInstance(object);
        if (!bl4) {
            return false;
        }
        object = (FastJsonResponse)object;
        clazz = this.getFieldMappings().values().iterator();
        while (bl2 = clazz.hasNext()) {
            Object object2;
            Object object3 = (FastJsonResponse$Field)clazz.next();
            boolean bl5 = this.isFieldSet((FastJsonResponse$Field)object3);
            if (!(bl5 ? !(bl5 = ((FastJsonResponse)object).isFieldSet((FastJsonResponse$Field)object3)) || !(bl2 = (object2 = this.getFieldValue((FastJsonResponse$Field)object3)).equals(object3 = ((FastJsonResponse)object).getFieldValue((FastJsonResponse$Field)object3))) : (bl2 = ((FastJsonResponse)object).isFieldSet((FastJsonResponse$Field)object3)))) continue;
            return false;
        }
        return bl3;
    }

    public Object getValueObject(String string2) {
        return null;
    }

    public int hashCode() {
        int n10;
        Iterator iterator2 = this.getFieldMappings().values().iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object = (FastJsonResponse$Field)iterator2.next();
            boolean bl2 = this.isFieldSet((FastJsonResponse$Field)object);
            if (!bl2) continue;
            n11 *= 31;
            object = this.getFieldValue((FastJsonResponse$Field)object);
            n10 = object.hashCode();
            n11 += n10;
        }
        return n11;
    }

    public boolean isPrimitiveFieldSet(String string2) {
        return false;
    }

    public byte[] toByteArray() {
        Parcel parcel = Parcel.obtain();
        this.writeToParcel(parcel, 0);
        byte[] byArray = parcel.marshall();
        parcel.recycle();
        return byArray;
    }
}

