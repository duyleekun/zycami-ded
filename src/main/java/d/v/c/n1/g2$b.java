/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.n1;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import d.v.c.n1.g2$a;
import java.util.HashMap;

public class g2$b
implements NavDirections {
    private final HashMap a;

    private g2$b() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public /* synthetic */ g2$b(g2$a g2$a) {
        this();
    }

    public String a() {
        return (String)this.a.get("add_video_type");
    }

    public int b() {
        return (Integer)this.a.get("max_count_selected");
    }

    public g2$b c(String object) {
        if (object != null) {
            this.a.put("add_video_type", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"add_video_type\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public g2$b d(int n10) {
        HashMap hashMap = this.a;
        Integer n11 = n10;
        hashMap.put("max_count_selected", n11);
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
            int n11;
            object = (g2$b)object;
            object3 = this.a;
            object2 = "add_video_type";
            int n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (n11 = (hashMap = ((g2$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.a())).equals(object2 = ((g2$b)object).a())) : (object3 = ((g2$b)object).a()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "max_count_selected";
            int n13 = ((HashMap)object3).containsKey(object2);
            if (n13 != (n11 = (hashMap = ((g2$b)object).a).containsKey(object2))) {
                return false;
            }
            int n14 = this.b();
            if (n14 != (n11 = ((g2$b)object).b())) {
                return false;
            }
            int n15 = this.getActionId();
            if (n15 != (n10 = ((g2$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return 2131361893;
    }

    public Bundle getArguments() {
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

    public int hashCode() {
        int n10;
        String string2 = this.a();
        if (string2 != null) {
            string2 = this.a();
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        int n12 = this.b();
        n10 = (n10 + n12) * n11;
        n11 = this.getActionId();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionCreationFragmentToEditorAddVideoActivity(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){addVideoType=");
        String string2 = this.a();
        stringBuilder.append(string2);
        stringBuilder.append(", maxCountSelected=");
        n10 = this.b();
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

