/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.t0;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import d.v.c.t0.g0$a;
import java.util.HashMap;

public class g0$b
implements NavDirections {
    private final HashMap a;

    private g0$b(int n10, long l10, int n11) {
        HashMap<String, Integer> hashMap;
        this.a = hashMap = new HashMap<String, Integer>();
        Number number = n10;
        hashMap.put("max_count_selected", (Integer)number);
        number = l10;
        hashMap.put("templateDataID", (Integer)number);
        number = n11;
        hashMap.put("media_type_load", (Integer)number);
    }

    public /* synthetic */ g0$b(int n10, long l10, int n11, g0$a g0$a) {
        this(n10, l10, n11);
    }

    public String a() {
        return (String)this.a.get("add_video_type");
    }

    public int b() {
        return (Integer)this.a.get("max_count_selected");
    }

    public int c() {
        return (Integer)this.a.get("media_type_load");
    }

    public long d() {
        return (Long)this.a.get("templateDataID");
    }

    public g0$b e(String object) {
        if (object != null) {
            this.a.put("add_video_type", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"add_video_type\" is marked as non-null but was passed a null value.");
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
            long l10;
            boolean bl3;
            HashMap hashMap;
            int n11;
            object = (g0$b)object;
            object3 = this.a;
            object2 = "add_video_type";
            int n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (n11 = (hashMap = ((g0$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? !(bl3 = ((String)(object3 = this.a())).equals(object2 = ((g0$b)object).a())) : (object3 = ((g0$b)object).a()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "max_count_selected";
            int n13 = ((HashMap)object3).containsKey(object2);
            if (n13 != (n11 = (hashMap = ((g0$b)object).a).containsKey(object2))) {
                return false;
            }
            int n14 = this.b();
            if (n14 != (n11 = ((g0$b)object).b())) {
                return false;
            }
            object3 = this.a;
            object2 = "templateDataID";
            int n15 = ((HashMap)object3).containsKey(object2);
            if (n15 != (n11 = (int)((hashMap = ((g0$b)object).a).containsKey(object2) ? 1 : 0))) {
                return false;
            }
            long l11 = this.d();
            long l12 = l11 - (l10 = ((g0$b)object).d());
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false) {
                return false;
            }
            object3 = this.a;
            object2 = "media_type_load";
            int n16 = ((HashMap)object3).containsKey(object2);
            if (n16 != (n11 = (int)((hashMap = ((g0$b)object).a).containsKey(object2) ? 1 : 0))) {
                return false;
            }
            int n17 = this.c();
            if (n17 != (n11 = ((g0$b)object).c())) {
                return false;
            }
            int n18 = this.getActionId();
            if (n18 != (n10 = ((g0$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public g0$b f(int n10) {
        HashMap hashMap = this.a;
        Integer n11 = n10;
        hashMap.put("max_count_selected", n11);
        return this;
    }

    public g0$b g(int n10) {
        HashMap hashMap = this.a;
        Integer n11 = n10;
        hashMap.put("media_type_load", n11);
        return this;
    }

    public int getActionId() {
        return 2131361860;
    }

    public Bundle getArguments() {
        boolean bl2;
        boolean bl3;
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "add_video_type";
        boolean n10 = ((HashMap)object).containsKey(string2);
        if (n10) {
            object = (String)this.a.get(string2);
            bundle.putString(string2, (String)object);
        } else {
            object = "cloudEngine";
            bundle.putString(string2, (String)object);
        }
        object = this.a;
        string2 = "max_count_selected";
        boolean bl4 = ((HashMap)object).containsKey(string2);
        if (bl4) {
            object = (Integer)this.a.get(string2);
            int n11 = (Integer)object;
            bundle.putInt(string2, n11);
        }
        if (bl3 = ((HashMap)(object = this.a)).containsKey(string2 = "templateDataID")) {
            object = (Long)this.a.get(string2);
            long l10 = (Long)object;
            bundle.putLong(string2, l10);
        }
        if (bl2 = ((HashMap)(object = this.a)).containsKey(string2 = "media_type_load")) {
            object = (Integer)this.a.get(string2);
            int n12 = (Integer)object;
            bundle.putInt(string2, n12);
        }
        return bundle;
    }

    public g0$b h(long l10) {
        HashMap hashMap = this.a;
        Long l11 = l10;
        hashMap.put("templateDataID", l11);
        return this;
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
        long l10 = this.d();
        long l11 = this.d() >>> 32;
        n12 = (int)(l10 ^ l11);
        n10 = (n10 + n12) * n11;
        n12 = this.c();
        n10 = (n10 + n12) * n11;
        n11 = this.getActionId();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionCETemplatePreviewDialogToAddVideoFragment(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){addVideoType=");
        String string2 = this.a();
        stringBuilder.append(string2);
        stringBuilder.append(", maxCountSelected=");
        n10 = this.b();
        stringBuilder.append(n10);
        stringBuilder.append(", templateDataID=");
        long l10 = this.d();
        stringBuilder.append(l10);
        stringBuilder.append(", mediaTypeLoad=");
        n10 = this.c();
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

