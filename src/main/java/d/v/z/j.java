/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.z;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import d.v.z.a;
import d.v.z.b;
import d.v.z.c;
import d.v.z.d;
import d.v.z.e;
import d.v.z.f;
import d.v.z.g;
import d.v.z.i;
import d.v.z.i$a;
import d.v.z.i$a$a;
import d.v.z.i$a$a$a;
import d.v.z.j$a;
import d.v.z.j$b;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Stream;

public class j {
    private static final String b = "version_info.json";
    private static final String c = "android";
    private static final String d = "ios";
    private i a;

    public static j a() {
        return j$b.a();
    }

    public static String b() {
        return "1.0.0";
    }

    public static /* synthetic */ boolean e(String string2, i$a object) {
        object = ((i$a)object).a();
        return string2.equals(object);
    }

    public static /* synthetic */ boolean f(i$a object) {
        boolean bl2;
        if ((object = ((i$a)object).b()) != null && !(bl2 = object.isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ Stream g(i$a i$a) {
        return i$a.b().stream();
    }

    public static /* synthetic */ boolean h(String string2, i$a$a object) {
        object = ((i$a$a)object).a();
        return string2.equals(object);
    }

    public static /* synthetic */ boolean i(i$a$a object) {
        boolean bl2;
        if ((object = ((i$a$a)object).b()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ List j(String string2, i$a$a object) {
        object = ((i$a$a)object).b();
        String string3 = c;
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            return ((i$a$a$a)object).a();
        }
        string3 = d;
        boolean bl3 = string3.equals(string2);
        if (bl3) {
            return ((i$a$a$a)object).b();
        }
        return null;
    }

    public static /* synthetic */ boolean k(String string2, String string3) {
        return string3.equals(string2);
    }

    public List c(String object, String object2, String string2) {
        boolean bl2;
        Object object3 = this.a;
        if (object3 == null) {
            object = new Object[]{};
            m.a.a.i("\u672a\u8c03\u7528ProtocolInfoManager.parseVersionInfo()\u6216\u6ca1\u6709\u7248\u672c\u4fe1\u606f", (Object[])object);
            return null;
        }
        object2 = ((String)object2).trim();
        Object object4 = "";
        object2 = ((String)object2).replace("_", (CharSequence)object4).replace(" ", (CharSequence)object4).toLowerCase();
        object3 = this.a.b();
        boolean bl3 = object3.contains(object2);
        if (!bl3) {
            return null;
        }
        object3 = this.a.a();
        if (object3 != null && !(bl2 = object3.isEmpty())) {
            string2 = string2.trim().toLowerCase();
            object = ((String)object).trim().toLowerCase();
            object3 = object3.stream();
            object4 = new g((String)object);
            object = object3.filter(object4);
            object3 = d.v.z.b.a;
            object = object.filter(object3);
            object3 = f.a;
            object = object.flatMap(object3);
            object3 = new c((String)object2);
            object = object.filter(object3);
            object2 = d.v.z.a.a;
            object = object.filter(object2);
            object2 = new d(string2);
            return object.map(object2).findFirst().orElse(null);
        }
        return null;
    }

    public boolean d(String string2, String stream, String object) {
        if ((stream = this.c(string2, (String)((Object)stream), (String)object)) == null) {
            return false;
        }
        string2 = string2.trim().toLowerCase();
        stream = stream.stream();
        object = new e(string2);
        return stream.anyMatch(object);
    }

    public void l(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            boolean bl3 = true;
            String string2 = b;
            bl2 = bl3;
            object = string2;
        } else {
            bl2 = false;
            Object var4_5 = null;
        }
        Object object2 = new j$a(this);
        object2 = ((TypeToken)object2).getType();
        this.a = object = (i)d.v.e.l.q2.c.e((String)object, (Type)object2, bl2);
    }
}

