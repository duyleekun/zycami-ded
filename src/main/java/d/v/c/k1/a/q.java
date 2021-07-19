/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.k1.a;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import d.v.c.k1.a.q$a;
import java.util.HashMap;

public class q
implements NavArgs {
    private final HashMap a;

    private q() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private q(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ q(HashMap hashMap, q$a q$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(q q10) {
        return q10.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static q b(Bundle object) {
        Object object2;
        q q10 = new q();
        Object object3 = q.class.getClassLoader();
        object.setClassLoader((ClassLoader)object3);
        object3 = "add_video_type";
        boolean bl2 = object.containsKey((String)object3);
        if (bl2) {
            object2 = object.getString((String)object3);
            if (object2 == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Argument \"add_video_type\" is marked as non-null but was passed a null value.");
                throw illegalArgumentException;
            }
            HashMap hashMap = q10.a;
            hashMap.put(object3, object2);
        } else {
            object2 = q10.a;
            String string2 = "editor";
            ((HashMap)object2).put(object3, string2);
        }
        object3 = "max_count_selected";
        bl2 = object.containsKey((String)object3);
        if (bl2) {
            int n10 = object.getInt((String)object3);
            object2 = q10.a;
            Integer n11 = n10;
            ((HashMap)object2).put(object3, n11);
            return q10;
        }
        HashMap hashMap = q10.a;
        bl2 = false;
        object2 = 0;
        hashMap.put(object3, object2);
        return q10;
    }

    public String c() {
        return (String)this.a.get("add_video_type");
    }

    public int d() {
        return (Integer)this.a.get("max_count_selected");
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "add_video_type";
        boolean n10 = ((HashMap)object).containsKey(string2);
        if (n10) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        } else {
            object = "editor";
            bundle.putString(string2, (String)object);
        }
        object = this.a;
        string2 = "max_count_selected";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        if (bl2) {
            object = (Integer)this.a.get(string2);
            int n11 = (Integer)object;
            bundle.putInt(string2, n11);
        } else {
            boolean bl3 = false;
            object = null;
            bundle.putInt(string2, 0);
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
            int n10;
            boolean bl3;
            HashMap hashMap;
            boolean bl4;
            object = (q)object;
            object3 = this.a;
            object2 = "add_video_type";
            boolean n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (bl4 = (hashMap = ((q)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.c())).equals(object2 = ((q)object).c())) : (object3 = ((q)object).c()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "max_count_selected";
            boolean bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((q)object).a).containsKey(object2))) {
                return false;
            }
            int n11 = this.d();
            if (n11 != (n10 = ((q)object).d())) {
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
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        n11 = this.d();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EditorAddVideoActivityArgs{addVideoType=");
        String string2 = this.c();
        stringBuilder.append(string2);
        stringBuilder.append(", maxCountSelected=");
        int n10 = this.d();
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

