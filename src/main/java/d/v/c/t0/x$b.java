/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.t0;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import d.v.c.t0.x$a;
import java.util.HashMap;

public class x$b
implements NavDirections {
    private final HashMap a;

    private x$b(String object, String string2, String string3, String string4, int n10) {
        HashMap<Object, Object> hashMap;
        this.a = hashMap = new HashMap<Object, Object>();
        if (object != null) {
            String string5 = "fileUrl";
            hashMap.put(string5, object);
            if (string2 != null) {
                object = "coverUrl";
                hashMap.put(object, string2);
                if (string3 != null) {
                    object = "videoDuration";
                    hashMap.put(object, string3);
                    if (string4 != null) {
                        hashMap.put("startAt", string4);
                        object = n10;
                        hashMap.put("compositeDuration", object);
                        return;
                    }
                    object = new IllegalArgumentException("Argument \"startAt\" is marked as non-null but was passed a null value.");
                    throw object;
                }
                object = new IllegalArgumentException("Argument \"videoDuration\" is marked as non-null but was passed a null value.");
                throw object;
            }
            object = new IllegalArgumentException("Argument \"coverUrl\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Argument \"fileUrl\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public /* synthetic */ x$b(String string2, String string3, String string4, String string5, int n10, x$a x$a) {
        this(string2, string3, string4, string5, n10);
    }

    public int a() {
        return (Integer)this.a.get("compositeDuration");
    }

    public String b() {
        return (String)this.a.get("coverUrl");
    }

    public String c() {
        return (String)this.a.get("fileUrl");
    }

    public String d() {
        return (String)this.a.get("startAt");
    }

    public String e() {
        return (String)this.a.get("videoDuration");
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
            int n11;
            object = (x$b)object;
            object3 = this.a;
            object2 = "fileUrl";
            int n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (n11 = (hashMap = ((x$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl6 = ((String)(object3 = this.c())).equals(object2 = ((x$b)object).c())) : (object3 = ((x$b)object).c()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "coverUrl";
            int n13 = ((HashMap)object3).containsKey(object2);
            if (n13 != (n11 = (hashMap = ((x$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.b();
            if (object3 != null ? !(bl5 = ((String)(object3 = this.b())).equals(object2 = ((x$b)object).b())) : (object3 = ((x$b)object).b()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "videoDuration";
            int n14 = ((HashMap)object3).containsKey(object2);
            if (n14 != (n11 = (hashMap = ((x$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.e();
            if (object3 != null ? !(bl4 = ((String)(object3 = this.e())).equals(object2 = ((x$b)object).e())) : (object3 = ((x$b)object).e()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "startAt";
            int n15 = ((HashMap)object3).containsKey(object2);
            if (n15 != (n11 = (hashMap = ((x$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.d();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.d())).equals(object2 = ((x$b)object).d())) : (object3 = ((x$b)object).d()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "compositeDuration";
            int n16 = ((HashMap)object3).containsKey(object2);
            if (n16 != (n11 = (hashMap = ((x$b)object).a).containsKey(object2))) {
                return false;
            }
            int n17 = this.a();
            if (n17 != (n11 = ((x$b)object).a())) {
                return false;
            }
            int n18 = this.getActionId();
            if (n18 != (n10 = ((x$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public x$b f(int n10) {
        HashMap hashMap = this.a;
        Integer n11 = n10;
        hashMap.put("compositeDuration", n11);
        return this;
    }

    public x$b g(String object) {
        if (object != null) {
            this.a.put("coverUrl", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"coverUrl\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public int getActionId() {
        return 2131361857;
    }

    public Bundle getArguments() {
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

    public x$b h(String object) {
        if (object != null) {
            this.a.put("fileUrl", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"fileUrl\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.c();
        int n12 = 0;
        String string3 = null;
        if (string2 != null) {
            string2 = this.c();
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        int n13 = 31;
        n11 = (n11 + n13) * n13;
        String string4 = this.b();
        if (string4 != null) {
            string4 = this.b();
            n10 = string4.hashCode();
        } else {
            n10 = 0;
            string4 = null;
        }
        n11 = (n11 + n10) * n13;
        string4 = this.e();
        if (string4 != null) {
            string4 = this.e();
            n10 = string4.hashCode();
        } else {
            n10 = 0;
            string4 = null;
        }
        n11 = (n11 + n10) * n13;
        string4 = this.d();
        if (string4 != null) {
            string3 = this.d();
            n12 = string3.hashCode();
        }
        n11 = (n11 + n12) * n13;
        n12 = this.a();
        n11 = (n11 + n12) * n13;
        n12 = this.getActionId();
        return n11 + n12;
    }

    public x$b i(String object) {
        if (object != null) {
            this.a.put("startAt", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"startAt\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public x$b j(String object) {
        if (object != null) {
            this.a.put("videoDuration", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"videoDuration\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionCECompositeDialogToCECompositeFinishFragment(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){fileUrl=");
        String string2 = this.c();
        stringBuilder.append(string2);
        stringBuilder.append(", coverUrl=");
        string2 = this.b();
        stringBuilder.append(string2);
        stringBuilder.append(", videoDuration=");
        string2 = this.e();
        stringBuilder.append(string2);
        stringBuilder.append(", startAt=");
        string2 = this.d();
        stringBuilder.append(string2);
        stringBuilder.append(", compositeDuration=");
        n10 = this.a();
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

