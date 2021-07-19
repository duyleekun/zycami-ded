/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.y0.c;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import d.v.c.y0.c.p$a;
import java.io.Serializable;
import java.util.HashMap;

public class p
implements NavArgs {
    private final HashMap a;

    private p() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private p(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ p(HashMap hashMap, p$a p$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(p p10) {
        return p10.a;
    }

    public static p b(Bundle object) {
        p p10 = new p();
        Object object2 = p.class.getClassLoader();
        object.setClassLoader((ClassLoader)object2);
        object2 = "showNoReminders";
        boolean bl2 = object.containsKey((String)object2);
        if (bl2) {
            boolean bl3 = object.getBoolean((String)object2);
            HashMap hashMap = p10.a;
            object = bl3;
            hashMap.put(object2, object);
        } else {
            object = p10.a;
            Boolean bl4 = Boolean.TRUE;
            ((HashMap)object).put(object2, bl4);
        }
        return p10;
    }

    public boolean c() {
        return (Boolean)this.a.get("showNoReminders");
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        Serializable serializable = this.a;
        String string2 = "showNoReminders";
        boolean bl2 = ((HashMap)serializable).containsKey(string2);
        if (bl2) {
            serializable = (Boolean)this.a.get(string2);
            bl2 = (Boolean)serializable;
            bundle.putBoolean(string2, bl2);
        } else {
            bl2 = true;
            bundle.putBoolean(string2, bl2);
        }
        return bundle;
    }

    public boolean equals(Object object) {
        Object object2;
        Serializable serializable;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (serializable = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            HashMap hashMap;
            boolean bl4;
            object = (p)object;
            serializable = this.a;
            object2 = "showNoReminders";
            boolean bl5 = ((HashMap)serializable).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((p)object).a).containsKey(object2))) {
                return false;
            }
            bl5 = this.c();
            if (bl5 != (bl3 = ((p)object).c())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.c();
        return 31 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FirmwareUpgradeFragmentArgs{showNoReminders=");
        boolean bl2 = this.c();
        stringBuilder.append(bl2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

