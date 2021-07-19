/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.b.a.b;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.a0;
import d.b.a.b.h;
import d.b.a.b.h$a;

public final class c0 {
    public static h a(Bundle object, String string2, String object2) {
        boolean bl2;
        boolean bl3;
        h h10 = a0.l;
        int n10 = 1;
        if (object == null) {
            object = new Object[n10];
            object[0] = object2;
            object = String.format("%s got null owned items list", object);
            zzb.zzb(string2, (String)object);
            return h10;
        }
        int n11 = zzb.zza((Bundle)object, string2);
        Object object3 = zzb.zzb((Bundle)object, string2);
        Object object4 = h.c().c(n11);
        object3 = ((h$a)object4).b((String)object3).a();
        if (n11 != 0) {
            object = new Object[2];
            object[0] = object2;
            object[n10] = object2 = Integer.valueOf(n11);
            object = String.format("%s failed. Response code: %s", object);
            zzb.zzb(string2, (String)object);
            return object3;
        }
        Object object5 = "INAPP_PURCHASE_ITEM_LIST";
        boolean bl4 = object.containsKey((String)object5);
        if (bl4 && (bl3 = object.containsKey((String)(object3 = "INAPP_PURCHASE_DATA_LIST"))) && (bl2 = object.containsKey((String)(object4 = "INAPP_DATA_SIGNATURE_LIST")))) {
            object5 = object.getStringArrayList((String)object5);
            object3 = object.getStringArrayList((String)object3);
            object = object.getStringArrayList((String)object4);
            if (object5 == null) {
                object = new Object[n10];
                object[0] = object2;
                object = String.format("Bundle returned from %s contains null SKUs list.", object);
                zzb.zzb(string2, (String)object);
                return h10;
            }
            if (object3 == null) {
                object = new Object[n10];
                object[0] = object2;
                object = String.format("Bundle returned from %s contains null purchases list.", object);
                zzb.zzb(string2, (String)object);
                return h10;
            }
            if (object == null) {
                object = new Object[n10];
                object[0] = object2;
                object = String.format("Bundle returned from %s contains null signatures list.", object);
                zzb.zzb(string2, (String)object);
                return h10;
            }
            return a0.p;
        }
        object = new Object[n10];
        object[0] = object2;
        object = String.format("Bundle returned from %s doesn't contain required fields.", object);
        zzb.zzb(string2, (String)object);
        return h10;
    }
}

