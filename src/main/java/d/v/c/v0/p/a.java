/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 */
package d.v.c.v0.p;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.cama.camera.data.CameraSet$Theme;
import d.v.c.v0.p.a$a;
import d.v.c.v0.p.a$b;
import d.v.c.v0.p.a$c;
import d.v.c.v0.p.a$d;
import d.v.c.v0.p.a$e;
import d.v.e.f;
import d.v.e.l.q2.c;
import d.v.e0.ce;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a {
    private static final String a = "device_theme_preference";
    private static final String b = "connect_device_theme";
    private static final String c = "user_theme_info_list";
    private static final String d = "user_save_device_theme";
    private static final String e = "user_connect_device_sn";
    private static final String f = "user_login_show_state";

    public static a g() {
        return a$e.a();
    }

    private List h() {
        boolean bl2;
        Object object = d.v.e.f.a().b().getSharedPreferences(a, 0);
        Object object2 = e;
        String string2 = "";
        if ((object = object.getString((String)object2, string2)) != null && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            object2 = new a$d(this);
            return d.v.e.l.q2.c.b(((TypeToken)object2).getType(), (String)object);
        }
        object = new ArrayList();
        return object;
    }

    private void o(List object) {
        boolean bl2;
        Application application = d.v.e.f.a().b();
        Object object2 = a;
        application = application.getSharedPreferences((String)object2, 0).edit();
        if (object != null && !(bl2 = object.isEmpty())) {
            object2 = new a$c(this);
            object2 = ((TypeToken)object2).getType();
            object = d.v.e.l.q2.c.i((Type)object2, (List)object);
        } else {
            object = "";
        }
        application.putString(e, (String)object);
        application.apply();
    }

    public void a() {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(a, 0).edit();
        editor.remove(e);
        editor.apply();
    }

    public void b() {
        Application application = d.v.e.f.a().b();
        boolean bl2 = false;
        String string2 = null;
        application = application.getSharedPreferences(a, 0).edit();
        Iterator iterator2 = this.h().iterator();
        while (bl2 = iterator2.hasNext()) {
            string2 = (String)iterator2.next();
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = d;
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            application.remove(string2);
            application.apply();
        }
        this.a();
    }

    public void c() {
        this.d();
        this.e();
        this.b();
    }

    public void d() {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(a, 0).edit();
        editor.remove(b);
        editor.apply();
    }

    public void e() {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(a, 0).edit();
        editor.remove(c);
        editor.apply();
    }

    public CameraSet$Theme f() {
        boolean bl2 = ce.z1();
        if (!bl2) {
            return CameraSet$Theme.DEFAULT;
        }
        return CameraSet$Theme.fromId(d.v.e.f.a().b().getSharedPreferences(a, 0).getInt(b, 0));
    }

    public boolean i() {
        return d.v.e.f.a().b().getSharedPreferences(a, 0).getBoolean(f, true);
    }

    public CameraSet$Theme j(String object) {
        SharedPreferences sharedPreferences = d.v.e.f.a().b().getSharedPreferences(a, 0);
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = d;
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        int n10 = -1;
        int n11 = sharedPreferences.getInt(object, n10);
        if (n11 == n10) {
            n11 = 0;
            object = null;
        } else {
            object = CameraSet$Theme.fromId(n11);
        }
        return object;
    }

    public List k() {
        boolean bl2;
        Object object = d.v.e.f.a().b().getSharedPreferences(a, 0);
        Object object2 = c;
        String string2 = "";
        if ((object = object.getString((String)object2, string2)) != null && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            object2 = new a$b(this);
            return d.v.e.l.q2.c.b(((TypeToken)object2).getType(), (String)object);
        }
        return Collections.emptyList();
    }

    public boolean l() {
        int n10;
        String string2;
        Application application = d.v.e.f.a().b();
        boolean bl2 = false;
        int n11 = (application = application.getSharedPreferences(a, 0)).getInt(string2 = b, n10 = -1);
        if (n11 != n10) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean m() {
        boolean bl2;
        Object object = d.v.e.f.a().b();
        boolean bl3 = false;
        object = object.getSharedPreferences(a, 0);
        String string2 = c;
        String string3 = "empty";
        if ((object = object.getString(string2, string3)) != null && !(bl2 = ((String)object).equals(string3))) {
            bl3 = true;
        }
        return bl3;
    }

    public void n(CameraSet$Theme cameraSet$Theme) {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(a, 0).edit();
        int n10 = cameraSet$Theme.getId();
        editor.putInt(b, n10);
        editor.apply();
    }

    public void p(boolean bl2) {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(a, 0).edit();
        editor.putBoolean(f, bl2);
        editor.apply();
    }

    public void q(String string2, CameraSet$Theme object) {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(a, 0).edit();
        CharSequence charSequence = new StringBuilder();
        String string3 = d;
        charSequence.append(string3);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        int n10 = object.getId();
        editor.putInt((String)charSequence, n10);
        object = this.h();
        if (object == null) {
            object = new ArrayList();
        }
        object.add(string2);
        this.o((List)object);
        editor.apply();
    }

    public void r(List object) {
        boolean bl2;
        Application application = d.v.e.f.a().b();
        Object object2 = a;
        application = application.getSharedPreferences((String)object2, 0).edit();
        if (object != null && !(bl2 = object.isEmpty())) {
            object2 = new a$a(this);
            object2 = ((TypeToken)object2).getType();
            object = d.v.e.l.q2.c.i((Type)object2, (List)object);
        } else {
            object = "";
        }
        application.putString(c, (String)object);
        application.apply();
    }
}

