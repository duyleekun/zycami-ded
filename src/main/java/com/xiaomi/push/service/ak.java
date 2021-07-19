/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.util.Pair
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ad;
import com.xiaomi.push.bc;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak$a;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ak {
    private static volatile ak a;
    public SharedPreferences a;
    private HashSet a;

    private ak(Context context) {
        HashSet hashSet;
        this.a = hashSet = new HashSet();
        context = context.getSharedPreferences("mipush_oc", 0);
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ak a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = ak.class;
        synchronized (object) {
            ak ak2 = a;
            if (ak2 != null) return a;
            a = ak2 = new ak(context);
            return a;
        }
    }

    private String a(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("normal_oc_");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    private void a(SharedPreferences.Editor editor, Pair object, String string2) {
        object = ((Pair)object).second;
        int n10 = object instanceof Integer;
        if (n10 != 0) {
            object = (Integer)object;
            int n11 = (Integer)object;
            editor.putInt(string2, n11);
        } else {
            n10 = object instanceof Long;
            if (n10 != 0) {
                object = (Long)object;
                long l10 = (Long)object;
                editor.putLong(string2, l10);
            } else {
                n10 = object instanceof String;
                if (n10 != 0) {
                    object = (String)object;
                    n10 = hr.aQ.a();
                    String string3 = this.a(n10);
                    if ((n10 = (int)(string2.equals(string3) ? 1 : 0)) != 0) {
                        object = bc.a((String)object);
                    }
                    editor.putString(string2, (String)object);
                } else {
                    n10 = object instanceof Boolean;
                    if (n10 != 0) {
                        object = (Boolean)object;
                        boolean bl2 = (Boolean)object;
                        editor.putBoolean(string2, bl2);
                    }
                }
            }
        }
    }

    private String b(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("custom_oc_");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public int a(int n10, int n11) {
        SharedPreferences sharedPreferences = this.a;
        String string2 = this.b(n10);
        boolean bl2 = sharedPreferences.contains(string2);
        if (bl2) {
            return this.a.getInt(string2, 0);
        }
        string2 = this.a;
        String string3 = this.a(n10);
        boolean bl3 = string2.contains(string3);
        if (bl3) {
            return this.a.getInt(string3, 0);
        }
        return n11;
    }

    public String a(int n10, String string2) {
        SharedPreferences sharedPreferences = this.a;
        String string3 = this.b(n10);
        boolean bl2 = sharedPreferences.contains(string3);
        if (bl2) {
            return this.a.getString(string3, null);
        }
        string3 = this.a;
        String string4 = this.a(n10);
        boolean bl3 = string3.contains(string4);
        if (bl3) {
            return this.a.getString(string4, null);
        }
        return string2;
    }

    public void a() {
        synchronized (this) {
            HashSet hashSet = this.a;
            hashSet.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(ak$a ak$a) {
        synchronized (this) {
            HashSet hashSet = this.a;
            boolean bl2 = hashSet.contains(ak$a);
            if (!bl2) {
                hashSet = this.a;
                hashSet.add(ak$a);
            }
            return;
        }
    }

    public void a(List object) {
        boolean bl2;
        boolean bl3 = ad.a((Collection)object);
        if (bl3) {
            return;
        }
        SharedPreferences.Editor editor = this.a.edit();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2;
            Pair pair = (Pair)object.next();
            Object object3 = pair.first;
            if (object3 == null || (object2 = pair.second) == null) continue;
            int n10 = (Integer)object3;
            object3 = this.a(n10);
            this.a(editor, pair, (String)object3);
        }
        editor.commit();
    }

    public boolean a(int n10, boolean bl2) {
        SharedPreferences sharedPreferences = this.a;
        String string2 = this.b(n10);
        boolean bl3 = sharedPreferences.contains(string2);
        if (bl3) {
            return this.a.getBoolean(string2, false);
        }
        string2 = this.a;
        String string3 = this.a(n10);
        boolean bl4 = string2.contains(string3);
        if (bl4) {
            return this.a.getBoolean(string3, false);
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object;
        b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            object = this.a;
            hashSet.addAll(object);
        }
        object = hashSet.iterator();
        while (true) {
            boolean bl2;
            if (!(bl2 = object.hasNext())) {
                hashSet.clear();
                return;
            }
            ak$a ak$a = (ak$a)object.next();
            if (ak$a == null) continue;
            ak$a.run();
        }
    }

    public void b(List object) {
        boolean bl2;
        boolean bl3 = ad.a((Collection)object);
        if (bl3) {
            return;
        }
        SharedPreferences.Editor editor = this.a.edit();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Pair pair = (Pair)object.next();
            Object object2 = pair.first;
            if (object2 == null) continue;
            int n10 = (Integer)object2;
            object2 = this.b(n10);
            Object object3 = pair.second;
            if (object3 == null) {
                editor.remove((String)object2);
                continue;
            }
            this.a(editor, pair, (String)object2);
        }
        editor.commit();
    }
}

