/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.j1.b;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import d.v.c.j1.b.n0$a;
import java.util.HashMap;

public class n0$b
implements NavDirections {
    private final HashMap a;

    private n0$b(String object, boolean bl2) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put("url", object);
            object = bl2;
            hashMap.put("useBgColor", object);
            return;
        }
        object = new IllegalArgumentException("Argument \"url\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public /* synthetic */ n0$b(String string2, boolean bl2, n0$a n0$a) {
        this(string2, bl2);
    }

    public boolean a() {
        return (Boolean)this.a.get("darkMode");
    }

    public boolean b() {
        return (Boolean)this.a.get("hideBack");
    }

    public String c() {
        return (String)this.a.get("url");
    }

    public boolean d() {
        return (Boolean)this.a.get("useBgColor");
    }

    public n0$b e(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("darkMode", bl3);
        return this;
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
            object = (n0$b)object;
            object3 = this.a;
            object2 = "url";
            boolean n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (bl4 = (hashMap = ((n0$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.c())).equals(object2 = ((n0$b)object).c())) : (object3 = ((n0$b)object).c()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "useBgColor";
            boolean bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((n0$b)object).a).containsKey(object2))) {
                return false;
            }
            boolean bl6 = this.d();
            if (bl6 != (bl4 = ((n0$b)object).d())) {
                return false;
            }
            object3 = this.a;
            object2 = "hideBack";
            boolean bl7 = ((HashMap)object3).containsKey(object2);
            if (bl7 != (bl4 = (hashMap = ((n0$b)object).a).containsKey(object2))) {
                return false;
            }
            boolean bl8 = this.b();
            if (bl8 != (bl4 = ((n0$b)object).b())) {
                return false;
            }
            object3 = this.a;
            object2 = "darkMode";
            boolean bl9 = ((HashMap)object3).containsKey(object2);
            if (bl9 != (bl4 = (hashMap = ((n0$b)object).a).containsKey(object2))) {
                return false;
            }
            boolean bl10 = this.a();
            if (bl10 != (bl4 = ((n0$b)object).a())) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((n0$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public n0$b f(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("hideBack", bl3);
        return this;
    }

    public n0$b g(String object) {
        if (object != null) {
            this.a.put("url", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"url\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public int getActionId() {
        return 2131361949;
    }

    public Bundle getArguments() {
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

    public n0$b h(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("useBgColor", bl3);
        return this;
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
        int n13 = this.b();
        n10 = (n10 + n13) * n11;
        int n14 = this.a();
        n10 = (n10 + n14) * n11;
        n11 = this.getActionId();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionMessageTextFragmentToWebViewFragment(actionId=");
        int bl2 = this.getActionId();
        stringBuilder.append(bl2);
        stringBuilder.append("){url=");
        String string2 = this.c();
        stringBuilder.append(string2);
        stringBuilder.append(", useBgColor=");
        boolean bl3 = this.d();
        stringBuilder.append(bl3);
        stringBuilder.append(", hideBack=");
        boolean bl4 = this.b();
        stringBuilder.append(bl4);
        stringBuilder.append(", darkMode=");
        boolean bl5 = this.a();
        stringBuilder.append(bl5);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

