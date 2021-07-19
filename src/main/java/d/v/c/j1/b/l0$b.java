/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.j1.b;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import d.v.c.j1.b.l0$a;
import java.util.HashMap;

public class l0$b
implements NavDirections {
    private final HashMap a;

    private l0$b(String object, String string2, String string3) {
        HashMap<Object, Object> hashMap;
        this.a = hashMap = new HashMap<Object, Object>();
        if (object != null) {
            String string4 = "title";
            hashMap.put(string4, object);
            if (string2 != null) {
                object = "time";
                hashMap.put(object, string2);
                if (string3 != null) {
                    hashMap.put("content", string3);
                    return;
                }
                object = new IllegalArgumentException("Argument \"content\" is marked as non-null but was passed a null value.");
                throw object;
            }
            object = new IllegalArgumentException("Argument \"time\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public /* synthetic */ l0$b(String string2, String string3, String string4, l0$a l0$a) {
        this(string2, string3, string4);
    }

    public String a() {
        return (String)this.a.get("content");
    }

    public String b() {
        return (String)this.a.get("time");
    }

    public String c() {
        return (String)this.a.get("title");
    }

    public l0$b d(String object) {
        if (object != null) {
            this.a.put("content", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"content\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public l0$b e(String object) {
        if (object != null) {
            this.a.put("time", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"time\" is marked as non-null but was passed a null value.");
        throw object;
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
            HashMap hashMap;
            boolean bl6;
            object = (l0$b)object;
            object3 = this.a;
            object2 = "title";
            boolean n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (bl6 = (hashMap = ((l0$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl5 = ((String)(object3 = this.c())).equals(object2 = ((l0$b)object).c())) : (object3 = ((l0$b)object).c()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "time";
            boolean bl7 = ((HashMap)object3).containsKey(object2);
            if (bl7 != (bl6 = (hashMap = ((l0$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.b();
            if (object3 != null ? !(bl4 = ((String)(object3 = this.b())).equals(object2 = ((l0$b)object).b())) : (object3 = ((l0$b)object).b()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "content";
            boolean bl8 = ((HashMap)object3).containsKey(object2);
            if (bl8 != (bl6 = (hashMap = ((l0$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.a())).equals(object2 = ((l0$b)object).a())) : (object3 = ((l0$b)object).a()) != null) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((l0$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public l0$b f(String object) {
        if (object != null) {
            this.a.put("title", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public int getActionId() {
        return 2131361947;
    }

    public Bundle getArguments() {
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
        string4 = this.a();
        if (string4 != null) {
            string3 = this.a();
            n12 = string3.hashCode();
        }
        n11 = (n11 + n12) * n13;
        n12 = this.getActionId();
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionMessageSystemFragmentToMessageTextFragment(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){title=");
        String string2 = this.c();
        stringBuilder.append(string2);
        stringBuilder.append(", time=");
        string2 = this.b();
        stringBuilder.append(string2);
        stringBuilder.append(", content=");
        string2 = this.a();
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

