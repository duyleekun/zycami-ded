/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.k1.a;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import d.v.c.k1.a.o$a;
import java.util.HashMap;

public class o
implements NavArgs {
    private final HashMap a;

    private o() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private o(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ o(HashMap hashMap, o$a o$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(o o10) {
        return o10.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static o b(Bundle object) {
        Object object2;
        Object object3;
        o o10 = new o();
        Object object4 = o.class.getClassLoader();
        object.setClassLoader((ClassLoader)object4);
        object4 = "add_video_type";
        int n10 = object.containsKey((String)object4);
        if (n10 != 0) {
            object3 = object.getString((String)object4);
            if (object3 == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Argument \"add_video_type\" is marked as non-null but was passed a null value.");
                throw illegalArgumentException;
            }
            object2 = o10.a;
            ((HashMap)object2).put(object4, object3);
        } else {
            object3 = o10.a;
            object2 = "cloudEngine";
            ((HashMap)object3).put(object4, object2);
        }
        object4 = "max_count_selected";
        n10 = object.containsKey((String)object4);
        if (n10 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required argument \"max_count_selected\" is missing and does not have an android:defaultValue");
            throw illegalArgumentException;
        }
        n10 = object.getInt((String)object4);
        object2 = o10.a;
        object3 = n10;
        ((HashMap)object2).put(object4, object3);
        object4 = "templateDataID";
        n10 = (int)(object.containsKey((String)object4) ? 1 : 0);
        if (n10 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required argument \"templateDataID\" is missing and does not have an android:defaultValue");
            throw illegalArgumentException;
        }
        long l10 = object.getLong((String)object4);
        HashMap hashMap = o10.a;
        object3 = l10;
        hashMap.put(object4, object3);
        object4 = "media_type_load";
        n10 = (int)(object.containsKey((String)object4) ? 1 : 0);
        if (n10 != 0) {
            int n11 = object.getInt((String)object4);
            object3 = o10.a;
            Integer n12 = n11;
            ((HashMap)object3).put(object4, n12);
            return o10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required argument \"media_type_load\" is missing and does not have an android:defaultValue");
        throw illegalArgumentException;
    }

    public String c() {
        return (String)this.a.get("add_video_type");
    }

    public int d() {
        return (Integer)this.a.get("max_count_selected");
    }

    public int e() {
        return (Integer)this.a.get("media_type_load");
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
            long l10;
            boolean bl3;
            HashMap hashMap;
            int n11;
            object = (o)object;
            object3 = this.a;
            object2 = "add_video_type";
            int n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (n11 = (hashMap = ((o)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.c())).equals(object2 = ((o)object).c())) : (object3 = ((o)object).c()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "max_count_selected";
            int n13 = ((HashMap)object3).containsKey(object2);
            if (n13 != (n11 = (hashMap = ((o)object).a).containsKey(object2))) {
                return false;
            }
            int n14 = this.d();
            if (n14 != (n11 = ((o)object).d())) {
                return false;
            }
            object3 = this.a;
            object2 = "templateDataID";
            int n15 = ((HashMap)object3).containsKey(object2);
            if (n15 != (n11 = (int)((hashMap = ((o)object).a).containsKey(object2) ? 1 : 0))) {
                return false;
            }
            long l11 = this.f();
            long l12 = l11 - (l10 = ((o)object).f());
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false) {
                return false;
            }
            object3 = this.a;
            object2 = "media_type_load";
            int n16 = ((HashMap)object3).containsKey(object2);
            if (n16 != (n11 = (int)((hashMap = ((o)object).a).containsKey(object2) ? 1 : 0))) {
                return false;
            }
            int n17 = this.e();
            if (n17 != (n10 = ((o)object).e())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public long f() {
        return (Long)this.a.get("templateDataID");
    }

    public Bundle g() {
        boolean bl2;
        boolean bl3;
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "add_video_type";
        boolean n10 = ((HashMap)object).containsKey(string2);
        if (n10) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        } else {
            object = "cloudEngine";
            bundle.putString(string2, (String)object);
        }
        object = this.a;
        string2 = "max_count_selected";
        boolean bl4 = ((HashMap)object).containsKey(string2);
        if (bl4) {
            object = (Integer)this.a.get(string2);
            int n11 = (Integer)object;
            bundle.putInt(string2, n11);
        }
        if (bl3 = ((HashMap)(object = this.a)).containsKey(string2 = "templateDataID")) {
            object = (Long)this.a.get(string2);
            long l10 = (Long)object;
            bundle.putLong(string2, l10);
        }
        if (bl2 = ((HashMap)(object = this.a)).containsKey(string2 = "media_type_load")) {
            object = (Integer)this.a.get(string2);
            int n12 = (Integer)object;
            bundle.putInt(string2, n12);
        }
        return bundle;
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
        int n12 = this.d();
        n10 = (n10 + n12) * n11;
        long l10 = this.f();
        long l11 = this.f() >>> 32;
        n12 = (int)(l10 ^ l11);
        n10 = (n10 + n12) * n11;
        n11 = this.e();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AddVideoFragmentArgs{addVideoType=");
        String string2 = this.c();
        stringBuilder.append(string2);
        stringBuilder.append(", maxCountSelected=");
        int n10 = this.d();
        stringBuilder.append(n10);
        stringBuilder.append(", templateDataID=");
        long l10 = this.f();
        stringBuilder.append(l10);
        stringBuilder.append(", mediaTypeLoad=");
        n10 = this.e();
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

