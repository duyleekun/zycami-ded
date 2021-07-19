/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.Uri
 */
package com.mob.commons.b;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import com.mob.commons.b.c;
import com.mob.commons.b.f;
import com.mob.commons.b.g$1;
import com.mob.commons.b.g$a;
import com.mob.commons.k;

public class g
extends f {
    private g$a c;
    private g$a d;
    private g$a e;
    private g$a f;
    private g$a g;
    private BroadcastReceiver h;

    public g(Context object) {
        super((Context)object);
        String string2 = k.a(71);
        super(string2);
        this.c = object;
        string2 = k.a(69);
        super(string2);
        this.d = object;
        string2 = k.a(70);
        super(string2);
        this.e = object;
        string2 = k.a(75);
        super(string2);
        this.f = object;
        string2 = k.a(125);
        super(string2);
        this.g = object;
    }

    public static /* synthetic */ g$a a(g g10) {
        return g10.c;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(Context context, g$a object, boolean n10) {
        int n11;
        if (object == null) {
            return null;
        }
        if (n10 == 0 && (n11 = (int)(((g$a)object).b() ? 1 : 0)) != 0) {
            return g$a.a((g$a)object);
        }
        n11 = 124;
        String string2 = k.a(n11);
        Uri uri = Uri.parse((String)string2);
        try {
            boolean bl2;
            ContentResolver contentResolver = context.getContentResolver();
            boolean bl3 = true;
            String[] stringArray = new String[bl3];
            stringArray[0] = string2 = g$a.b((g$a)object);
            string2 = contentResolver.query(uri, null, null, stringArray, null);
            if (string2 != null) {
                void var7_12;
                string2.moveToFirst();
                int n12 = 126;
                String string3 = k.a(n12);
                n12 = string2.getColumnIndex(string3);
                if (n12 >= 0) {
                    String string4 = string2.getString(n12);
                    ((g$a)object).a(string4);
                } else {
                    n12 = 0;
                    Object var7_11 = null;
                }
                if (n10 == 0) {
                    n10 = 130;
                    String string5 = k.a(n10);
                    if ((n10 = string2.getColumnIndex(string5)) >= 0) {
                        long l10 = string2.getLong(n10);
                        ((g$a)object).a(l10);
                    }
                    int n13 = 119;
                    object = k.a(n13);
                    if ((n13 = string2.getColumnIndex((String)object)) >= 0 && (n13 = string2.getInt(n13)) != (n10 = 1000)) {
                        this.j();
                        n13 = (int)(this.a(false) ? 1 : 0);
                        if (n13 == 0) {
                            this.a(bl3);
                        }
                    }
                }
                string2.close();
                return var7_12;
            }
            if (n10 != 0) {
                String string6 = "1";
                ((g$a)object).a(string6);
            }
            if (!(bl2 = this.a(false))) return null;
            this.a(bl3);
            return null;
        }
        catch (Throwable throwable) {
            object = com.mob.commons.b.c.a();
            ((c)object).a(throwable);
        }
        return null;
    }

    private boolean a(boolean bl2) {
        Object object;
        String string2 = "0";
        if (!bl2 && (object = this.g) != null && (object = ((g$a)object).a()) != null) {
            return this.g.a().equals(string2);
        }
        object = this.a;
        g$a g$a = this.g;
        boolean bl3 = true;
        if ((object = this.a((Context)object, g$a, bl3)) == null || !(bl2 = string2.equals(object))) {
            bl3 = false;
        }
        return bl3;
    }

    public static /* synthetic */ g$a b(g g10) {
        return g10.d;
    }

    public static /* synthetic */ g$a c(g g10) {
        return g10.e;
    }

    public static /* synthetic */ g$a d(g g10) {
        return g10.f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        try {
            BroadcastReceiver broadcastReceiver = this.h;
            if (broadcastReceiver != null) return;
            broadcastReceiver = new IntentFilter();
            int n10 = 131;
            String string2 = k.a(n10);
            broadcastReceiver.addAction(string2);
            g$1 g$1 = new g$1(this);
            this.h = g$1;
            Context context = this.a;
            int n11 = 132;
            String string3 = k.a(n11);
            context.registerReceiver((BroadcastReceiver)g$1, (IntentFilter)broadcastReceiver, string3, null);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    public String b() {
        synchronized (this) {
            Object object;
            block7: {
                object = this.a;
                if (object != null) break block7;
                return null;
            }
            object = object.getApplicationContext();
            g$a g$a = this.f;
            object = this.a((Context)object, g$a, false);
            return object;
        }
    }

    public String e() {
        synchronized (this) {
            Object object;
            block7: {
                object = this.a;
                if (object != null) break block7;
                return null;
            }
            object = object.getApplicationContext();
            g$a g$a = this.d;
            object = this.a((Context)object, g$a, false);
            return object;
        }
    }

    public String f() {
        synchronized (this) {
            Object object;
            block7: {
                object = this.a;
                if (object != null) break block7;
                return null;
            }
            object = object.getApplicationContext();
            g$a g$a = this.c;
            object = this.a((Context)object, g$a, false);
            return object;
        }
    }

    public String g() {
        synchronized (this) {
            Object object;
            block7: {
                object = this.a;
                if (object != null) break block7;
                return null;
            }
            object = object.getApplicationContext();
            g$a g$a = this.e;
            object = this.a((Context)object, g$a, false);
            return object;
        }
    }
}

