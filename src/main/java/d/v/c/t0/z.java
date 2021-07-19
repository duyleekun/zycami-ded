/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.t0;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import d.v.c.t0.z$a;
import java.util.HashMap;

public class z
implements NavArgs {
    private final HashMap a;

    private z() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private z(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ z(HashMap hashMap, z$a z$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(z z10) {
        return z10.a;
    }

    public static z b(Bundle object) {
        z z10 = new z();
        Object object2 = z.class.getClassLoader();
        object.setClassLoader((ClassLoader)object2);
        object2 = "FileUrl";
        boolean bl2 = object.containsKey((String)object2);
        if (bl2) {
            if ((object = object.getString((String)object2)) != null) {
                z10.a.put(object2, object);
                return z10;
            }
            object = new IllegalArgumentException("Argument \"FileUrl\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Required argument \"FileUrl\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public String c() {
        return (String)this.a.get("FileUrl");
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "FileUrl";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        if (bl2) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        }
        return bundle;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            HashMap hashMap;
            boolean bl4;
            object = (z)object;
            object3 = this.a;
            object2 = "FileUrl";
            boolean bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((z)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.c())).equals(object = ((z)object).c())) : (object = ((z)object).c()) != null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        String string2 = this.c();
        if (string2 != null) {
            string2 = this.c();
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        return 31 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CEDirectPublishDialogArgs{FileUrl=");
        String string2 = this.c();
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

