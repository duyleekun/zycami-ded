/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class m {
    private static m a;
    private Context a;
    private List a;
    private final List b;
    private final List c;

    private m(Context stringArray) {
        List list;
        boolean bl2;
        Object object = new ArrayList();
        this.a = object;
        object = new ArrayList();
        this.b = object;
        object = new ArrayList();
        this.c = object;
        object = stringArray.getApplicationContext();
        this.a = object;
        if (object == null) {
            this.a = stringArray;
        }
        stringArray = this.a;
        int n10 = 0;
        stringArray = stringArray.getSharedPreferences("mipush_app_info", 0);
        String string2 = "";
        object = stringArray.getString("unregistered_pkg_names", string2);
        Object object2 = ",";
        for (String object3 : ((String)object).split((String)object2)) {
            bl2 = TextUtils.isEmpty((CharSequence)object3);
            if (!bl2) continue;
            list = this.a;
            list.add(object3);
        }
        for (String string3 : stringArray.getString("disable_push_pkg_names", string2).split((String)object2)) {
            bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (bl2) continue;
            list = this.b;
            list.add(string3);
        }
        object = "disable_push_pkg_names_cache";
        stringArray = stringArray.getString((String)object, string2).split((String)object2);
        int n11 = stringArray.length;
        while (n10 < n11) {
            string2 = stringArray[n10];
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3) {
                object2 = this.c;
                object2.add(string2);
            }
            ++n10;
        }
    }

    public static m a(Context context) {
        m m10 = a;
        if (m10 == null) {
            a = m10 = new m(context);
        }
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String object) {
        List list = this.a;
        synchronized (list) {
            Object object2 = this.a;
            boolean bl2 = object2.contains(object);
            if (!bl2) {
                object2 = this.a;
                object2.add(object);
                object = this.a;
                object2 = ",";
                object = bf.a((Collection)object, (String)object2);
                object2 = this.a;
                String string2 = "mipush_app_info";
                object2 = object2.getSharedPreferences(string2, 0);
                object2 = object2.edit();
                string2 = "unregistered_pkg_names";
                object = object2.putString(string2, (String)object);
                object.commit();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(String string2) {
        List list = this.a;
        synchronized (list) {
            List list2 = this.a;
            return list2.contains(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(String object) {
        List list = this.b;
        synchronized (list) {
            Object object2 = this.b;
            boolean bl2 = object2.contains(object);
            if (!bl2) {
                object2 = this.b;
                object2.add(object);
                object = this.b;
                object2 = ",";
                object = bf.a((Collection)object, (String)object2);
                object2 = this.a;
                String string2 = "mipush_app_info";
                object2 = object2.getSharedPreferences(string2, 0);
                object2 = object2.edit();
                string2 = "disable_push_pkg_names";
                object = object2.putString(string2, (String)object);
                object.commit();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b(String string2) {
        List list = this.b;
        synchronized (list) {
            List list2 = this.b;
            return list2.contains(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(String object) {
        List list = this.c;
        synchronized (list) {
            Object object2 = this.c;
            boolean bl2 = object2.contains(object);
            if (!bl2) {
                object2 = this.c;
                object2.add(object);
                object = this.c;
                object2 = ",";
                object = bf.a((Collection)object, (String)object2);
                object2 = this.a;
                String string2 = "mipush_app_info";
                object2 = object2.getSharedPreferences(string2, 0);
                object2 = object2.edit();
                string2 = "disable_push_pkg_names_cache";
                object = object2.putString(string2, (String)object);
                object.commit();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c(String string2) {
        List list = this.c;
        synchronized (list) {
            List list2 = this.c;
            return list2.contains(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(String object) {
        List list = this.a;
        synchronized (list) {
            Object object2 = this.a;
            boolean bl2 = object2.contains(object);
            if (bl2) {
                object2 = this.a;
                object2.remove(object);
                object = this.a;
                object2 = ",";
                object = bf.a((Collection)object, (String)object2);
                object2 = this.a;
                String string2 = "mipush_app_info";
                object2 = object2.getSharedPreferences(string2, 0);
                object2 = object2.edit();
                string2 = "unregistered_pkg_names";
                object = object2.putString(string2, (String)object);
                object.commit();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e(String object) {
        List list = this.b;
        synchronized (list) {
            Object object2 = this.b;
            boolean bl2 = object2.contains(object);
            if (bl2) {
                object2 = this.b;
                object2.remove(object);
                object = this.b;
                object2 = ",";
                object = bf.a((Collection)object, (String)object2);
                object2 = this.a;
                String string2 = "mipush_app_info";
                object2 = object2.getSharedPreferences(string2, 0);
                object2 = object2.edit();
                string2 = "disable_push_pkg_names";
                object = object2.putString(string2, (String)object);
                object.commit();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(String object) {
        List list = this.c;
        synchronized (list) {
            Object object2 = this.c;
            boolean bl2 = object2.contains(object);
            if (bl2) {
                object2 = this.c;
                object2.remove(object);
                object = this.c;
                object2 = ",";
                object = bf.a((Collection)object, (String)object2);
                object2 = this.a;
                String string2 = "mipush_app_info";
                object2 = object2.getSharedPreferences(string2, 0);
                object2 = object2.edit();
                string2 = "disable_push_pkg_names_cache";
                object = object2.putString(string2, (String)object);
                object.commit();
            }
            return;
        }
    }
}

