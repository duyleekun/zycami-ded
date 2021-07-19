/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.p;

import android.util.Log;
import d.c.a.s.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class m {
    private static final String d = "RequestTracker";
    private final Set a;
    private final List b;
    private boolean c;

    public m() {
        ArrayList arrayList = new ArrayList();
        arrayList = Collections.newSetFromMap(arrayList);
        this.a = arrayList;
        this.b = arrayList = new ArrayList();
    }

    public void a(d d10) {
        this.a.add(d10);
    }

    public boolean b(d d10) {
        boolean bl2 = true;
        if (d10 == null) {
            return bl2;
        }
        Set set = this.a;
        boolean bl3 = set.remove(d10);
        List list = this.b;
        boolean bl4 = list.remove(d10);
        if (!bl4 && !bl3) {
            bl2 = false;
        }
        if (bl2) {
            d10.clear();
        }
        return bl2;
    }

    public void c() {
        boolean bl2;
        Iterator iterator2 = d.c.a.u.m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            this.b(d10);
        }
        this.b.clear();
    }

    public boolean d() {
        return this.c;
    }

    public void e() {
        boolean bl2;
        boolean bl3;
        this.c = bl3 = true;
        Iterator iterator2 = d.c.a.u.m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            boolean bl4 = d10.isRunning();
            if (!bl4 && !(bl4 = d10.g())) continue;
            d10.clear();
            List list = this.b;
            list.add(d10);
        }
    }

    public void f() {
        boolean bl2;
        boolean bl3;
        this.c = bl3 = true;
        Iterator iterator2 = d.c.a.u.m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            boolean bl4 = d10.isRunning();
            if (!bl4) continue;
            d10.pause();
            List list = this.b;
            list.add(d10);
        }
    }

    public void g() {
        boolean bl2;
        Iterator iterator2 = d.c.a.u.m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            boolean bl3 = d10.g();
            if (bl3 || (bl3 = d10.e())) continue;
            d10.clear();
            bl3 = this.c;
            if (!bl3) {
                d10.begin();
                continue;
            }
            List list = this.b;
            list.add(d10);
        }
    }

    public void h() {
        boolean bl2;
        this.c = false;
        Iterator iterator2 = d.c.a.u.m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            boolean bl3 = d10.g();
            if (bl3 || (bl3 = d10.isRunning())) continue;
            d10.begin();
        }
        this.b.clear();
    }

    public void i(d d10) {
        Object object = this.a;
        object.add(d10);
        boolean bl2 = this.c;
        if (!bl2) {
            d10.begin();
        } else {
            d10.clear();
            String string2 = d;
            bl2 = Log.isLoggable((String)string2, (int)2);
            if (bl2) {
                object = "Paused, delaying request";
                Log.v((String)string2, (String)object);
            }
            object = this.b;
            object.add(d10);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = super.toString();
        stringBuilder.append(string2);
        stringBuilder.append("{numRequests=");
        int bl2 = this.a.size();
        stringBuilder.append(bl2);
        stringBuilder.append(", isPaused=");
        boolean bl3 = this.c;
        stringBuilder.append(bl3);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

