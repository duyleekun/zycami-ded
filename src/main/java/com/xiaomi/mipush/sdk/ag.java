/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.z;
import java.util.ArrayList;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ag {
    private static volatile ag a;
    private Context a;
    private List a;

    private ag(Context context) {
        Context context2;
        this.a = context2 = new ArrayList();
        this.a = context2 = context.getApplicationContext();
        if (context2 == null) {
            this.a = context;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ag a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = ag.class;
        synchronized (object) {
            ag ag2 = a;
            if (ag2 != null) return a;
            a = ag2 = new ag(context);
            return a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(String iterator2) {
        List list = this.a;
        synchronized (list) {
            Object object;
            boolean bl2;
            z z10 = new z();
            z10.a = iterator2;
            iterator2 = this.a;
            int n10 = iterator2.contains(z10);
            if (n10 == 0) return 0;
            iterator2 = this.a;
            iterator2 = iterator2.iterator();
            do {
                boolean bl3;
                if (!(bl3 = iterator2.hasNext())) return 0;
                object = iterator2.next();
            } while (!(bl2 = ((z)(object = (z)object)).equals(z10)));
            return ((z)object).a;
        }
    }

    public String a(av object) {
        synchronized (this) {
            Context context = this.a;
            String string2 = "mipush_extra";
            context = context.getSharedPreferences(string2, 0);
            object = object.name();
            string2 = "";
            object = context.getString((String)object, string2);
            return object;
        }
    }

    public void a(av object, String string2) {
        synchronized (this) {
            Context context = this.a;
            String string3 = "mipush_extra";
            context = context.getSharedPreferences(string3, 0);
            object = object.name();
            context = context.edit();
            object = context.putString((String)object, string2);
            object.commit();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String object) {
        List list = this.a;
        synchronized (list) {
            z z10 = new z();
            z10.a = 0;
            z10.a = object;
            object = this.a;
            boolean bl2 = object.contains(z10);
            if (bl2) {
                object = this.a;
                object.remove(z10);
            }
            object = this.a;
            object.add(z10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(String object) {
        List list = this.a;
        synchronized (list) {
            z z10 = new z();
            z10.a = object;
            object = this.a;
            boolean bl2 = object.contains(z10);
            if (!bl2) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(String object) {
        List list = this.a;
        synchronized (list) {
            z z10 = new z();
            z10.a = object;
            object = this.a;
            int n10 = object.contains(z10);
            if (n10 != 0) {
                boolean bl2;
                object = this.a;
                object = object.iterator();
                while (bl2 = object.hasNext()) {
                    Object object2 = object.next();
                    boolean bl3 = z10.equals(object2 = (z)object2);
                    if (!bl3) continue;
                    z10 = object2;
                    break;
                }
            }
            z10.a = n10 = z10.a + 1;
            object = this.a;
            object.remove(z10);
            object = this.a;
            object.add(z10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(String object) {
        List list = this.a;
        synchronized (list) {
            z z10 = new z();
            z10.a = object;
            object = this.a;
            boolean bl2 = object.contains(z10);
            if (bl2) {
                object = this.a;
                object.remove(z10);
            }
            return;
        }
    }
}

