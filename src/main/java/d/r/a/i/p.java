/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.h$t;
import d.r.a.h$u;
import d.r.a.i.p$a;
import d.r.a.i.p$b;
import d.r.a.l;
import d.r.a.n;
import d.r.a.o;
import d.r.a.u.f;
import java.util.ArrayList;
import java.util.List;

public final class p
extends d.r.a.i.o {
    public p(o o10) {
        super(o10);
    }

    public static /* synthetic */ Context d(p p10) {
        return p10.a;
    }

    public static /* synthetic */ Context e(p p10) {
        return p10.a;
    }

    public final void a(o object) {
        int n10;
        boolean bl2;
        Object object2;
        boolean bl3;
        object = (h$u)object;
        Object object3 = ((h$u)object).e;
        Object object4 = ((h$u)object).f;
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        Object object5 = new ArrayList();
        ArrayList<Object> arrayList3 = new ArrayList<Object>();
        int n11 = ((h$t)object).d;
        String string2 = ((h$t)object).c;
        Object object6 = "";
        Object object7 = "tag/";
        String string3 = "ali/";
        if (object3 != null) {
            object3 = object3.iterator();
            while (bl3 = object3.hasNext()) {
                object2 = (String)object3.next();
                boolean bl4 = ((String)object2).startsWith(string3);
                if (bl4) {
                    object2 = ((String)object2).replace(string3, (CharSequence)object6);
                    arrayList2.add((String)object2);
                    continue;
                }
                bl4 = ((String)object2).startsWith((String)object7);
                if (!bl4) continue;
                object2 = ((String)object2).replace((CharSequence)object7, (CharSequence)object6);
                arrayList.add((String)object2);
            }
        }
        if (object4 != null) {
            object3 = object4.iterator();
            while (bl2 = object3.hasNext()) {
                object4 = (String)object3.next();
                bl3 = ((String)object4).startsWith(string3);
                if (bl3) {
                    object4 = ((String)object4).replace(string3, (CharSequence)object6);
                    arrayList3.add(object4);
                    continue;
                }
                bl3 = ((String)object4).startsWith((String)object7);
                if (!bl3) continue;
                object4 = ((String)object4).replace((CharSequence)object7, (CharSequence)object6);
                object5.add(object4);
            }
        }
        if ((n10 = arrayList.size()) > 0 || (n10 = object5.size()) > 0) {
            n10 = arrayList.size();
            if (n10 > 0) {
                object3 = l.b();
                ((l)object3).j(arrayList);
            }
            object3 = l.b();
            object4 = ((h$t)object).c;
            int n12 = object5.size();
            n12 = n12 > 0 ? 10000 : n11;
            ((l)object3).g((String)object4, n12);
            object6 = object3;
            object7 = this;
            object2 = string2;
            object3 = new p$a(this, n11, arrayList, (List)object5, string2);
            n.c((Runnable)object3);
        }
        if ((n10 = arrayList2.size()) > 0 || (n10 = arrayList3.size()) > 0) {
            n10 = arrayList2.size();
            if (n10 > 0) {
                object3 = l.b();
                bl2 = false;
                ((l)object3).k = object4 = (String)arrayList2.get(0);
                object3 = ((l)object3).i;
                object6 = "APP_ALIAS";
                ((f)object3).g((String)object6, (String)object4);
            }
            object3 = l.b();
            object = ((h$t)object).c;
            ((l)object3).g((String)object, n11);
            object5 = object;
            object2 = this;
            object = new p$b(this, n11, arrayList2, arrayList3, string2);
            n.c((Runnable)object);
        }
    }
}

