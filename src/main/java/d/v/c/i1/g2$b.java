/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.i1;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import d.v.c.i1.g2$a;
import java.io.Serializable;
import java.util.HashMap;

public class g2$b
implements NavDirections {
    private final HashMap a;

    private g2$b(boolean bl2) {
        HashMap<String, Boolean> hashMap;
        this.a = hashMap = new HashMap<String, Boolean>();
        Boolean bl3 = bl2;
        hashMap.put("isMusic", bl3);
    }

    public /* synthetic */ g2$b(boolean bl2, g2$a g2$a) {
        this(bl2);
    }

    public boolean a() {
        return (Boolean)this.a.get("isMusic");
    }

    public g2$b b(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("isMusic", bl3);
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
            object = (g2$b)object;
            serializable = this.a;
            object2 = "isMusic";
            boolean n12 = ((HashMap)serializable).containsKey(object2);
            if (n12 != (bl3 = (hashMap = ((g2$b)object).a).containsKey(object2))) {
                return false;
            }
            boolean bl4 = this.a();
            if (bl4 != (bl3 = ((g2$b)object).a())) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((g2$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return 2131361902;
    }

    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        Serializable serializable = this.a;
        String string2 = "isMusic";
        boolean bl2 = ((HashMap)serializable).containsKey(string2);
        if (bl2) {
            serializable = (Boolean)this.a.get(string2);
            bl2 = (Boolean)serializable;
            bundle.putBoolean(string2, bl2);
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
        stringBuilder.append("ActionEditorMainFragmentToEditorMusicVolumeFragment(actionId=");
        int bl2 = this.getActionId();
        stringBuilder.append(bl2);
        stringBuilder.append("){isMusic=");
        boolean bl3 = this.a();
        stringBuilder.append(bl3);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

