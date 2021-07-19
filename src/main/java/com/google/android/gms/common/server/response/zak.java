/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zak
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private final HashMap zaqv;
    private final ArrayList zaqw;
    private final String zaqx;

    static {
        zan zan2 = new zan();
        CREATOR = zan2;
    }

    public zak(int n10, ArrayList arrayList, String string2) {
        this.zalf = n10;
        n10 = 0;
        this.zaqw = null;
        Object object = new HashMap();
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            zal zal2 = (zal)arrayList.get(i10);
            String string3 = zal2.className;
            HashMap<String, zam> hashMap = new HashMap<String, zam>();
            ArrayList arrayList2 = zal2.zaqy;
            int n12 = arrayList2.size();
            for (int i11 = 0; i11 < n12; ++i11) {
                AbstractSafeParcelable abstractSafeParcelable = (zam)zal2.zaqy.get(i11);
                String string4 = abstractSafeParcelable.zaqz;
                abstractSafeParcelable = abstractSafeParcelable.zara;
                hashMap.put(string4, (zam)abstractSafeParcelable);
            }
            ((HashMap)object).put(string3, hashMap);
        }
        this.zaqv = object;
        this.zaqx = object = (String)Preconditions.checkNotNull(string2);
        this.zacr();
    }

    public zak(Class object) {
        HashMap hashMap;
        this.zalf = 1;
        this.zaqw = null;
        this.zaqv = hashMap = new HashMap();
        this.zaqx = object = ((Class)object).getCanonicalName();
    }

    public final String toString() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator2 = this.zaqv.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object = (String)iterator2.next();
            stringBuilder.append((String)object);
            stringBuilder.append(":\n");
            object = (Map)this.zaqv.get(object);
            Iterator iterator3 = object.keySet().iterator();
            while (bl3 = iterator3.hasNext()) {
                String string2 = (String)iterator3.next();
                stringBuilder.append("  ");
                stringBuilder.append(string2);
                String string3 = ": ";
                stringBuilder.append(string3);
                string2 = object.get(string2);
                stringBuilder.append((Object)string2);
            }
        }
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        boolean bl2;
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.zalf;
        int n12 = 1;
        SafeParcelWriter.writeInt(parcel, n12, n11);
        ArrayList<zal> arrayList = new ArrayList<zal>();
        Object object = this.zaqv.keySet().iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            Map map = (Map)this.zaqv.get(string2);
            zal zal2 = new zal(string2, map);
            arrayList.add(zal2);
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        object = this.zaqx;
        SafeParcelWriter.writeString(parcel, 3, (String)object, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }

    public final void zaa(Class object, Map map) {
        HashMap hashMap = this.zaqv;
        object = ((Class)object).getCanonicalName();
        hashMap.put(object, map);
    }

    public final boolean zaa(Class object) {
        HashMap hashMap = this.zaqv;
        object = ((Class)object).getCanonicalName();
        return hashMap.containsKey(object);
    }

    public final void zacr() {
        boolean bl2;
        Iterator iterator2 = this.zaqv.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object = (String)iterator2.next();
            object = (Map)this.zaqv.get(object);
            Iterator iterator3 = object.keySet().iterator();
            while (bl3 = iterator3.hasNext()) {
                Object object2 = (String)iterator3.next();
                object2 = (FastJsonResponse$Field)object.get(object2);
                ((FastJsonResponse$Field)object2).zaa(this);
            }
        }
    }

    public final void zacs() {
        boolean bl2;
        Iterator iterator2 = this.zaqv.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            String string2 = (String)iterator2.next();
            Map map = (Map)this.zaqv.get(string2);
            HashMap<String, FastJsonResponse$Field> hashMap = new HashMap<String, FastJsonResponse$Field>();
            Iterator iterator3 = map.keySet().iterator();
            while (bl3 = iterator3.hasNext()) {
                String string3 = (String)iterator3.next();
                FastJsonResponse$Field fastJsonResponse$Field = ((FastJsonResponse$Field)map.get(string3)).zacl();
                hashMap.put(string3, fastJsonResponse$Field);
            }
            map = this.zaqv;
            ((HashMap)map).put(string2, hashMap);
        }
    }

    public final String zact() {
        return this.zaqx;
    }

    public final Map zai(String string2) {
        return (Map)this.zaqv.get(string2);
    }
}

