/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.y1.f.y;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import d.v.c.y1.f.y.d$a;
import java.io.Serializable;
import java.util.HashMap;

public class d
implements NavArgs {
    private final HashMap a;

    private d() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private d(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ d(HashMap hashMap, d$a d$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(d d10) {
        return d10.a;
    }

    public static d b(Bundle object) {
        d d10 = new d();
        Object object2 = d.class.getClassLoader();
        object.setClassLoader((ClassLoader)object2);
        object2 = "isMusic";
        boolean bl2 = object.containsKey((String)object2);
        if (bl2) {
            boolean bl3 = object.getBoolean((String)object2);
            HashMap hashMap = d10.a;
            object = bl3;
            hashMap.put(object2, object);
            return d10;
        }
        object = new IllegalArgumentException("Required argument \"isMusic\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public boolean c() {
        return (Boolean)this.a.get("isMusic");
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        Serializable serializable = this.a;
        String string2 = "isMusic";
        boolean bl2 = ((HashMap)serializable).containsKey(string2);
        if (bl2) {
            serializable = (Boolean)this.a.get(string2);
            bl2 = (Boolean)serializable;
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
            object = (d)object;
            serializable = this.a;
            object2 = "isMusic";
            boolean bl5 = ((HashMap)serializable).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((d)object).a).containsKey(object2))) {
                return false;
            }
            bl5 = this.c();
            if (bl5 != (bl3 = ((d)object).c())) {
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
        stringBuilder.append("EditorMusicVolumeFragmentArgs{isMusic=");
        boolean bl2 = this.c();
        stringBuilder.append(bl2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

