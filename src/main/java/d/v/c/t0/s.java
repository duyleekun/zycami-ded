/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.t0;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import d.v.c.t0.s$a;
import java.util.HashMap;

public class s
implements NavArgs {
    private final HashMap a;

    private s() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private s(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ s(HashMap hashMap, s$a s$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(s s10) {
        return s10.a;
    }

    public static s b(Bundle object) {
        s s10 = new s();
        Object object2 = s.class.getClassLoader();
        object.setClassLoader((ClassLoader)object2);
        object2 = "fileUrl";
        boolean bl2 = object.containsKey((String)object2);
        if (bl2) {
            Object object3 = object.getString((String)object2);
            if (object3 != null) {
                HashMap hashMap = s10.a;
                hashMap.put(object2, object3);
                object2 = "coverUrl";
                bl2 = object.containsKey((String)object2);
                if (bl2) {
                    object3 = object.getString((String)object2);
                    if (object3 != null) {
                        hashMap = s10.a;
                        hashMap.put(object2, object3);
                        object2 = "videoDuration";
                        bl2 = object.containsKey((String)object2);
                        if (bl2) {
                            object3 = object.getString((String)object2);
                            if (object3 != null) {
                                hashMap = s10.a;
                                hashMap.put(object2, object3);
                                object2 = "startAt";
                                bl2 = object.containsKey((String)object2);
                                if (bl2) {
                                    object3 = object.getString((String)object2);
                                    if (object3 != null) {
                                        hashMap = s10.a;
                                        hashMap.put(object2, object3);
                                        object2 = "compositeDuration";
                                        bl2 = object.containsKey((String)object2);
                                        if (bl2) {
                                            int n10 = object.getInt((String)object2);
                                            object3 = s10.a;
                                            object = n10;
                                            ((HashMap)object3).put(object2, object);
                                            return s10;
                                        }
                                        object = new IllegalArgumentException("Required argument \"compositeDuration\" is missing and does not have an android:defaultValue");
                                        throw object;
                                    }
                                    object = new IllegalArgumentException("Argument \"startAt\" is marked as non-null but was passed a null value.");
                                    throw object;
                                }
                                object = new IllegalArgumentException("Required argument \"startAt\" is missing and does not have an android:defaultValue");
                                throw object;
                            }
                            object = new IllegalArgumentException("Argument \"videoDuration\" is marked as non-null but was passed a null value.");
                            throw object;
                        }
                        object = new IllegalArgumentException("Required argument \"videoDuration\" is missing and does not have an android:defaultValue");
                        throw object;
                    }
                    object = new IllegalArgumentException("Argument \"coverUrl\" is marked as non-null but was passed a null value.");
                    throw object;
                }
                object = new IllegalArgumentException("Required argument \"coverUrl\" is missing and does not have an android:defaultValue");
                throw object;
            }
            object = new IllegalArgumentException("Argument \"fileUrl\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Required argument \"fileUrl\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public int c() {
        return (Integer)this.a.get("compositeDuration");
    }

    public String d() {
        return (String)this.a.get("coverUrl");
    }

    public String e() {
        return (String)this.a.get("fileUrl");
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
            boolean bl4;
            boolean bl5;
            boolean bl6;
            HashMap hashMap;
            boolean bl7;
            object = (s)object;
            object3 = this.a;
            object2 = "fileUrl";
            boolean n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (bl7 = (hashMap = ((s)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.e();
            if (object3 != null ? !(bl6 = ((String)(object3 = this.e())).equals(object2 = ((s)object).e())) : (object3 = ((s)object).e()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "coverUrl";
            boolean bl8 = ((HashMap)object3).containsKey(object2);
            if (bl8 != (bl7 = (hashMap = ((s)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.d();
            if (object3 != null ? !(bl5 = ((String)(object3 = this.d())).equals(object2 = ((s)object).d())) : (object3 = ((s)object).d()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "videoDuration";
            boolean bl9 = ((HashMap)object3).containsKey(object2);
            if (bl9 != (bl7 = (hashMap = ((s)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.g();
            if (object3 != null ? !(bl4 = ((String)(object3 = this.g())).equals(object2 = ((s)object).g())) : (object3 = ((s)object).g()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "startAt";
            boolean bl10 = ((HashMap)object3).containsKey(object2);
            if (bl10 != (bl7 = (hashMap = ((s)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.f();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.f())).equals(object2 = ((s)object).f())) : (object3 = ((s)object).f()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "compositeDuration";
            boolean bl11 = ((HashMap)object3).containsKey(object2);
            if (bl11 != (bl7 = (hashMap = ((s)object).a).containsKey(object2))) {
                return false;
            }
            int n11 = this.c();
            if (n11 != (n10 = ((s)object).c())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public String f() {
        return (String)this.a.get("startAt");
    }

    public String g() {
        return (String)this.a.get("videoDuration");
    }

    public Bundle h() {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "fileUrl";
        boolean n10 = ((HashMap)object).containsKey(string2);
        if (n10) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        }
        if (bl5 = ((HashMap)(object = this.a)).containsKey(string2 = "coverUrl")) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        }
        if (bl4 = ((HashMap)(object = this.a)).containsKey(string2 = "videoDuration")) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        }
        if (bl3 = ((HashMap)(object = this.a)).containsKey(string2 = "startAt")) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        }
        if (bl2 = ((HashMap)(object = this.a)).containsKey(string2 = "compositeDuration")) {
            object = (Integer)this.a.get(string2);
            int n11 = (Integer)object;
            bundle.putInt(string2, n11);
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
        string4 = this.g();
        if (string4 != null) {
            string4 = this.g();
            n10 = string4.hashCode();
        } else {
            n10 = 0;
            string4 = null;
        }
        n11 = (n11 + n10) * n13;
        string4 = this.f();
        if (string4 != null) {
            string3 = this.f();
            n12 = string3.hashCode();
        }
        n11 = (n11 + n12) * n13;
        n12 = this.c();
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CECompositeFinishFragmentArgs{fileUrl=");
        String string2 = this.e();
        stringBuilder.append(string2);
        stringBuilder.append(", coverUrl=");
        string2 = this.d();
        stringBuilder.append(string2);
        stringBuilder.append(", videoDuration=");
        string2 = this.g();
        stringBuilder.append(string2);
        stringBuilder.append(", startAt=");
        string2 = this.f();
        stringBuilder.append(string2);
        stringBuilder.append(", compositeDuration=");
        int n10 = this.c();
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

