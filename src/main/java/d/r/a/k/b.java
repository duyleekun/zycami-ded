/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Base64
 */
package d.r.a.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import d.r.a.k.d;
import d.r.a.r.e;
import d.r.a.u.d0;
import d.r.a.u.j;
import d.r.a.u.s;
import java.util.ArrayList;
import java.util.List;

public final class b
extends d {
    public b(Context context) {
        super(context);
    }

    public static boolean f(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            n11 = 1;
            if ((n10 &= n11) != 0) {
                return n11 != 0;
            }
            return false;
        }
        return d0.l("persist.sys.log.ctrl", "no").equals("yes");
    }

    public final String a() {
        return "com.vivo.pushservice.back_up";
    }

    public final List b(String stringArray) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)stringArray);
        if (bl2) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = TextUtils.isEmpty((CharSequence)stringArray);
        if (n10 == 0) {
            stringArray = stringArray.trim();
            String string2 = "@#";
            stringArray = stringArray.split(string2);
            n10 = stringArray.length;
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11;
                String string3 = stringArray[i10].trim();
                Object object = string3.trim();
                Object object2 = ",";
                int n12 = ((String[])(object = ((String)object).split((String)object2))).length;
                if (n12 < (n11 = 2)) continue;
                String string4 = object[0];
                object = object[0];
                int n13 = ((String)object).length() + 1;
                string3 = string3.substring(n13);
                object2 = new e(string4, string3);
                try {
                    arrayList.add(object2);
                    continue;
                }
                catch (Exception exception) {
                    object2 = "str2Clients E: ";
                    object = new StringBuilder((String)object2);
                    ((StringBuilder)object).append(exception);
                    string3 = ((StringBuilder)object).toString();
                    object = "AppConfigSettings";
                    s.m((String)object, string3);
                }
            }
        }
        return arrayList;
    }

    public final String c(String object) {
        String string2 = j.a(d.r.a.k.d.c);
        String string3 = j.a(d.r.a.k.d.d);
        object = Base64.decode((String)object, (int)2);
        object = j.b(string2, string3, (byte[])object);
        String string4 = new String((byte[])object, "utf-8");
        return string4;
    }

    public final int g() {
        String string2;
        boolean bl2;
        Object object = this.h("push_mode");
        int n10 = -1;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((e)object).b)))) {
            try {
                object = ((e)object).b;
            }
            catch (Exception exception) {}
            return Integer.parseInt((String)object);
        }
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final e h(String string2) {
        Object object = d.r.a.k.d.e;
        synchronized (object) {
            Object object2;
            String string3;
            boolean bl2;
            Object object3 = this.a;
            object3 = object3.iterator();
            do {
                boolean bl3;
                if (!(bl3 = object3.hasNext())) {
                    return null;
                }
                object2 = object3.next();
                object2 = (e)object2;
            } while ((bl2 = TextUtils.isEmpty((CharSequence)(string3 = ((e)object2).a))) || !(bl2 = (string3 = ((e)object2).a).equals(string2)));
            return object2;
        }
    }
}

