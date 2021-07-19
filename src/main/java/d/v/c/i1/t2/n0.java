/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.i1.t2;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import d.v.c.i1.t2.n0$a;
import java.io.Serializable;
import java.util.HashMap;

public class n0
implements NavArgs {
    private final HashMap a;

    private n0() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private n0(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ n0(HashMap hashMap, n0$a n0$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(n0 n02) {
        return n02.a;
    }

    public static n0 b(Bundle object) {
        Serializable serializable = Boolean.FALSE;
        n0 n02 = new n0();
        Object object2 = n0.class.getClassLoader();
        object.setClassLoader((ClassLoader)object2);
        object2 = "url";
        boolean bl2 = object.containsKey((String)object2);
        if (bl2) {
            Object object3 = object.getString((String)object2);
            if (object3 != null) {
                HashMap hashMap = n02.a;
                hashMap.put(object2, object3);
                object2 = "useBgColor";
                bl2 = object.containsKey((String)object2);
                if (bl2) {
                    bl2 = object.getBoolean((String)object2);
                    hashMap = n02.a;
                    object3 = bl2;
                    hashMap.put(object2, object3);
                    object2 = "hideBack";
                    bl2 = object.containsKey((String)object2);
                    if (bl2) {
                        bl2 = object.getBoolean((String)object2);
                        hashMap = n02.a;
                        object3 = bl2;
                        hashMap.put(object2, object3);
                    } else {
                        object3 = n02.a;
                        ((HashMap)object3).put(object2, serializable);
                    }
                    object2 = "darkMode";
                    bl2 = object.containsKey((String)object2);
                    if (bl2) {
                        boolean bl3 = object.getBoolean((String)object2);
                        serializable = n02.a;
                        object = bl3;
                        ((HashMap)serializable).put(object2, object);
                    } else {
                        object = n02.a;
                        ((HashMap)object).put(object2, serializable);
                    }
                    return n02;
                }
                object = new IllegalArgumentException("Required argument \"useBgColor\" is missing and does not have an android:defaultValue");
                throw object;
            }
            object = new IllegalArgumentException("Argument \"url\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Required argument \"url\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public boolean c() {
        return (Boolean)this.a.get("darkMode");
    }

    public boolean d() {
        return (Boolean)this.a.get("hideBack");
    }

    public String e() {
        return (String)this.a.get("url");
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
            object = (n0)object;
            object3 = this.a;
            object2 = "url";
            boolean bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((n0)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.e();
            if (object3 != null ? !(bl5 = ((String)(object3 = this.e())).equals(object2 = ((n0)object).e())) : (object3 = ((n0)object).e()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "useBgColor";
            bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((n0)object).a).containsKey(object2))) {
                return false;
            }
            bl5 = this.f();
            if (bl5 != (bl4 = ((n0)object).f())) {
                return false;
            }
            object3 = this.a;
            object2 = "hideBack";
            bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((n0)object).a).containsKey(object2))) {
                return false;
            }
            bl5 = this.d();
            if (bl5 != (bl4 = ((n0)object).d())) {
                return false;
            }
            object3 = this.a;
            object2 = "darkMode";
            bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((n0)object).a).containsKey(object2))) {
                return false;
            }
            bl5 = this.c();
            if (bl5 != (bl3 = ((n0)object).c())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public boolean f() {
        return (Boolean)this.a.get("useBgColor");
    }

    public Bundle g() {
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "url";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        if (bl2) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        }
        if (bl2 = ((HashMap)(object = this.a)).containsKey(string2 = "useBgColor")) {
            object = (Boolean)this.a.get(string2);
            bl2 = (Boolean)object;
            bundle.putBoolean(string2, bl2);
        }
        if (bl2 = ((HashMap)(object = this.a)).containsKey(string2 = "hideBack")) {
            object = (Boolean)this.a.get(string2);
            bl2 = (Boolean)object;
            bundle.putBoolean(string2, bl2);
        } else {
            bundle.putBoolean(string2, false);
        }
        object = this.a;
        string2 = "darkMode";
        bl2 = ((HashMap)object).containsKey(string2);
        if (bl2) {
            object = (Boolean)this.a.get(string2);
            bl2 = (Boolean)object;
            bundle.putBoolean(string2, bl2);
        } else {
            bundle.putBoolean(string2, false);
        }
        return bundle;
    }

    public int hashCode() {
        int n10;
        String string2 = this.e();
        if (string2 != null) {
            string2 = this.e();
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        int n12 = this.f();
        n10 = (n10 + n12) * n11;
        int n13 = this.d();
        n10 = (n10 + n13) * n11;
        n11 = (int)(this.c() ? 1 : 0);
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WebViewFragmentArgs{url=");
        String string2 = this.e();
        stringBuilder.append(string2);
        stringBuilder.append(", useBgColor=");
        boolean bl2 = this.f();
        stringBuilder.append(bl2);
        stringBuilder.append(", hideBack=");
        bl2 = this.d();
        stringBuilder.append(bl2);
        stringBuilder.append(", darkMode=");
        bl2 = this.c();
        stringBuilder.append(bl2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

