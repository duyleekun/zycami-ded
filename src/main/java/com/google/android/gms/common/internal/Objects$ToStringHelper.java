/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.List;

public final class Objects$ToStringHelper {
    private final List zza;
    private final Object zzb;

    private Objects$ToStringHelper(Object arrayList) {
        arrayList = Preconditions.checkNotNull(arrayList);
        this.zzb = arrayList;
        this.zza = arrayList = new ArrayList();
    }

    public /* synthetic */ Objects$ToStringHelper(Object object, zzt zzt2) {
        this(object);
    }

    public final Objects$ToStringHelper add(String string2, Object object) {
        List list = this.zza;
        string2 = (String)Preconditions.checkNotNull(string2);
        object = String.valueOf(object);
        int n10 = String.valueOf(string2).length() + 1;
        int n11 = String.valueOf(object).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append("=");
        stringBuilder.append((String)object);
        string2 = stringBuilder.toString();
        list.add(string2);
        return this;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);
        Object object = this.zzb.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append('{');
        object = this.zza;
        int n10 = object.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = (String)this.zza.get(i10);
            stringBuilder.append(string2);
            int n11 = n10 + -1;
            if (i10 >= n11) continue;
            string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

