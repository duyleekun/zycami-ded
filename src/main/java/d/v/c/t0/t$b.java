/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.t0;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import d.v.c.t0.t$a;
import java.util.HashMap;

public class t$b
implements NavDirections {
    private final HashMap a;

    private t$b(String object) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put("FileUrl", object);
            return;
        }
        object = new IllegalArgumentException("Argument \"FileUrl\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public /* synthetic */ t$b(String string2, t$a t$a) {
        this(string2);
    }

    public String a() {
        return (String)this.a.get("FileUrl");
    }

    public t$b b(String object) {
        if (object != null) {
            this.a.put("FileUrl", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"FileUrl\" is marked as non-null but was passed a null value.");
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
            HashMap hashMap;
            boolean bl4;
            object = (t$b)object;
            object3 = this.a;
            object2 = "FileUrl";
            boolean n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (bl4 = (hashMap = ((t$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.a())).equals(object2 = ((t$b)object).a())) : (object3 = ((t$b)object).a()) != null) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((t$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return 2131361858;
    }

    public Bundle getArguments() {
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
        n11 = this.getActionId();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionCECompositeFinishFragmentToCEDirectPublishDialog(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){FileUrl=");
        String string2 = this.a();
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

