/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.q.h;

import android.text.TextUtils;
import com.zhiyun.net.NetConfiguration;
import d.v.e.l.d1;
import d.v.q.h.d;
import g.b0;
import g.v;
import g.w;
import g.w$a;
import g.w$c;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import k.f;

public class e {
    public static final String a = "https://collect.zhiyun-tech.com/logan_web_war/logan/";

    public static void a() {
        NetConfiguration netConfiguration = NetConfiguration.create();
        Object object = netConfiguration.getZyProduction();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        object = bl2 ? d1.a() : netConfiguration.getZyProduction();
        object = netConfiguration.setZyProduction((String)object);
        String string2 = netConfiguration.getAppVersion();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        string2 = bl3 ? d1.g() : netConfiguration.getAppVersion();
        object = ((NetConfiguration)object).setAppVersion(string2);
        string2 = netConfiguration.getEnv();
        bl3 = TextUtils.isEmpty((CharSequence)string2);
        string2 = bl3 ? "ENV" : netConfiguration.getEnv();
        object = ((NetConfiguration)object).setEnv(string2);
        boolean bl4 = netConfiguration.isLogEnable();
        if (!bl4 && !(bl4 = d.v.q.d.a)) {
            bl4 = false;
            netConfiguration = null;
        } else {
            bl4 = true;
        }
        ((NetConfiguration)object).setLogEnable(bl4);
    }

    public static void b(File object, f f10) {
        Object object2 = w.j;
        object2 = b0.create((File)object, (v)object2);
        object = ((File)object).getName();
        object = w$c.g("file", (String)object, (b0)object2);
        d.a.b((w$c)object).h(f10);
    }

    private static void c(String string2, f f10) {
        File file = new File(string2);
        e.b(file, f10);
    }

    public static void d(Map map, File object, f f10) {
        if (map == null) {
            e.b((File)object, f10);
            return;
        }
        Object object2 = new w$a();
        v v10 = w.j;
        object2 = ((w$a)object2).g(v10);
        String string2 = ((File)object).getName();
        object = b0.create((File)object, v10);
        object = ((w$a)object2).b("file", string2, (b0)object);
        object2 = d.a;
        object = ((w$a)object).f();
        object2.a(map, (b0)object).h(f10);
    }

    public static void e(File[] fileArray, f f10) {
        ArrayList<w$c> arrayList = new ArrayList<w$c>();
        for (File file : fileArray) {
            Object object = w.j;
            object = b0.create(file, (v)object);
            String string2 = file.getName();
            String string3 = "file";
            w$c object2 = w$c.g(string3, string2, (b0)object);
            arrayList.add(object2);
        }
        d.a.c(arrayList).h(f10);
    }
}

