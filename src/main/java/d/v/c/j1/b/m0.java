/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.j1.b;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import d.v.c.j1.b.m0$a;
import java.util.HashMap;

public class m0
implements NavArgs {
    private final HashMap a;

    private m0() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private m0(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ m0(HashMap hashMap, m0$a m0$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(m0 m02) {
        return m02.a;
    }

    public static m0 b(Bundle object) {
        m0 m02 = new m0();
        Object object2 = m0.class.getClassLoader();
        object.setClassLoader((ClassLoader)object2);
        object2 = "title";
        boolean bl2 = object.containsKey((String)object2);
        if (bl2) {
            String string2 = object.getString((String)object2);
            if (string2 != null) {
                HashMap hashMap = m02.a;
                hashMap.put(object2, string2);
                object2 = "time";
                bl2 = object.containsKey((String)object2);
                if (bl2) {
                    string2 = object.getString((String)object2);
                    if (string2 != null) {
                        hashMap = m02.a;
                        hashMap.put(object2, string2);
                        object2 = "content";
                        bl2 = object.containsKey((String)object2);
                        if (bl2) {
                            if ((object = object.getString((String)object2)) != null) {
                                m02.a.put(object2, object);
                                return m02;
                            }
                            object = new IllegalArgumentException("Argument \"content\" is marked as non-null but was passed a null value.");
                            throw object;
                        }
                        object = new IllegalArgumentException("Required argument \"content\" is missing and does not have an android:defaultValue");
                        throw object;
                    }
                    object = new IllegalArgumentException("Argument \"time\" is marked as non-null but was passed a null value.");
                    throw object;
                }
                object = new IllegalArgumentException("Required argument \"time\" is missing and does not have an android:defaultValue");
                throw object;
            }
            object = new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Required argument \"title\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public String c() {
        return (String)this.a.get("content");
    }

    public String d() {
        return (String)this.a.get("time");
    }

    public String e() {
        return (String)this.a.get("title");
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
            object = (m0)object;
            object3 = this.a;
            object2 = "title";
            boolean bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((m0)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.e();
            if (object3 != null ? !(bl5 = ((String)(object3 = this.e())).equals(object2 = ((m0)object).e())) : (object3 = ((m0)object).e()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "time";
            bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((m0)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.d();
            if (object3 != null ? !(bl5 = ((String)(object3 = this.d())).equals(object2 = ((m0)object).d())) : (object3 = ((m0)object).d()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "content";
            bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((m0)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.c())).equals(object = ((m0)object).c())) : (object = ((m0)object).c()) != null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public Bundle f() {
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "title";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        if (bl2) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        }
        if (bl2 = ((HashMap)(object = this.a)).containsKey(string2 = "time")) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        }
        if (bl2 = ((HashMap)(object = this.a)).containsKey(string2 = "content")) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        }
        return bundle;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.e();
        int n12 = 0;
        String string3 = null;
        if (string2 != null) {
            string2 = this.e();
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        int n13 = 31;
        n11 = (n11 + n13) * n13;
        String string4 = this.d();
        if (string4 != null) {
            string4 = this.d();
            n10 = string4.hashCode();
        } else {
            n10 = 0;
            string4 = null;
        }
        n11 = (n11 + n10) * n13;
        String string5 = this.c();
        if (string5 != null) {
            string3 = this.c();
            n12 = string3.hashCode();
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MessageTextFragmentArgs{title=");
        String string2 = this.e();
        stringBuilder.append(string2);
        stringBuilder.append(", time=");
        string2 = this.d();
        stringBuilder.append(string2);
        stringBuilder.append(", content=");
        string2 = this.c();
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

