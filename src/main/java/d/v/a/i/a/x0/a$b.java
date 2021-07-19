/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.a.i.a.x0;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$id;
import d.v.a.i.a.x0.a$a;
import java.io.Serializable;
import java.util.HashMap;

public class a$b
implements NavDirections {
    private final HashMap a;

    private a$b() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public /* synthetic */ a$b(a$a a$a) {
        this();
    }

    public boolean a() {
        return (Boolean)this.a.get("hideBack");
    }

    public a$b b(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("hideBack", bl3);
        return this;
    }

    public boolean equals(Object object) {
        Object object2;
        Serializable serializable;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (serializable = this.getClass()) == (object2 = object.getClass())) {
            int n10;
            HashMap hashMap;
            boolean bl3;
            object = (a$b)object;
            serializable = this.a;
            object2 = "hideBack";
            boolean n12 = ((HashMap)serializable).containsKey(object2);
            if (n12 != (bl3 = (hashMap = ((a$b)object).a).containsKey(object2))) {
                return false;
            }
            boolean bl4 = this.a();
            if (bl4 != (bl3 = ((a$b)object).a())) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((a$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return R$id.action_visitorBindFragment_to_setPassFragment;
    }

    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        Serializable serializable = this.a;
        String string2 = "hideBack";
        boolean bl2 = ((HashMap)serializable).containsKey(string2);
        if (bl2) {
            serializable = (Boolean)this.a.get(string2);
            bl2 = (Boolean)serializable;
            bundle.putBoolean(string2, bl2);
        } else {
            bl2 = false;
            serializable = null;
            bundle.putBoolean(string2, false);
        }
        return bundle;
    }

    public int hashCode() {
        int n10 = this.a();
        int n11 = 31;
        int n12 = (n10 + n11) * n11;
        n11 = this.getActionId();
        return n12 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionVisitorBindFragmentToSetPassFragment(actionId=");
        int bl2 = this.getActionId();
        stringBuilder.append(bl2);
        stringBuilder.append("){hideBack=");
        boolean bl3 = this.a();
        stringBuilder.append(bl3);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

