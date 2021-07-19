/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 */
package com.geetest.sdk;

import android.content.Context;
import android.os.Looper;
import com.geetest.sdk.aw;
import com.geetest.sdk.ax$a;
import com.geetest.sdk.ay;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.n;
import com.geetest.sdk.utils.p;
import com.geetest.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ax {
    private static final String b = "ax";
    private static List c;
    private boolean a = false;

    static {
        ArrayList arrayList;
        c = arrayList = new ArrayList();
    }

    private ax() {
    }

    public static void b() {
        int n10;
        Object object = c;
        if (object != null && (n10 = object.size()) > 0) {
            boolean bl2;
            object = c.iterator();
            while (bl2 = object.hasNext()) {
                ax ax2 = (ax)object.next();
                ax2.a();
            }
            object = c;
            object.clear();
        }
    }

    public static ax c() {
        ax ax2 = new ax();
        c.add(ax2);
        return ax2;
    }

    public void a() {
        this.a = true;
    }

    public void a(aw aw2, ay ay2) {
        t t10 = t.a();
        ax$a ax$a = new ax$a(this, aw2, ay2);
        t10.a(ax$a);
    }

    public void b(aw object, ay ay2) {
        Object object2;
        Object object3 = Looper.myLooper();
        if (object3 != (object2 = Looper.getMainLooper())) {
            object3 = b;
            object2 = new StringBuilder();
            CharSequence charSequence = ((aw)object).a();
            object2.append((String)charSequence);
            object2.append(" REQUEST START");
            object2 = object2.toString();
            l.b((String)object3, (String)object2);
            object2 = new StringBuilder();
            charSequence = ((aw)object).a();
            object2.append((String)charSequence);
            object2.append(" REQUEST URL: ");
            charSequence = ((aw)object).d();
            object2.append((String)charSequence);
            object2 = object2.toString();
            l.b((String)object3, (String)object2);
            System.currentTimeMillis();
            object2 = ((aw)object).b();
            boolean bl2 = p.a((Context)object2);
            if (!bl2) {
                object3 = new Object[]{};
                object3 = ((aw)object).b("Network Not Avaliable", object3);
                ((aw)object).a(-1, (String)object3);
                ((aw)object).a(ay2);
                return;
            }
            object2 = ((aw)object).f();
            boolean bl3 = this.a;
            if (bl3) {
                ((aw)object).b(ay2);
                return;
            }
            charSequence = ((aw)object).d();
            boolean bl4 = ((aw)object).e();
            Map map = ((aw)object).c();
            String string2 = ((aw)object).a();
            object2 = n.a((String)charSequence, bl4, map, (byte[])object2, string2);
            charSequence = new StringBuilder();
            String string3 = ((aw)object).a();
            ((StringBuilder)charSequence).append(string3);
            string3 = "REQUEST END";
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            l.b((String)object3, (String)charSequence);
            boolean bl5 = this.a;
            if (bl5) {
                ((aw)object).b(ay2);
                return;
            }
            ((aw)object).b((String)object2);
            ((aw)object).a(ay2);
            return;
        }
        object = new RuntimeException("This thread(ui) forbids invoke.");
        throw object;
    }
}

