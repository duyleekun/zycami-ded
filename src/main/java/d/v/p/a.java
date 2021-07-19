/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.p;

import android.content.Context;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.LocationClientOption;
import d.v.p.a$b;
import d.v.p.a$c;
import d.v.p.c;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final String d = "BDLocationManager";
    private static volatile a e;
    private c a;
    private Map b;
    private a$b c;

    private a(Context context) {
        Object object = new HashMap();
        this.b = object;
        context = context.getApplicationContext();
        this.a = object = new c(context);
    }

    public static /* synthetic */ a$b a(a a10) {
        return a10.c;
    }

    private void b(a$c a$c) {
        Map map = this.b;
        if (map == null) {
            this.b = map = new Map();
        }
        map = new Map(this, a$c);
        this.b.put(a$c, map);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a c(Context context) {
        Object object = e;
        if (object != null) return e;
        object = a.class;
        synchronized (object) {
            a a10 = e;
            if (a10 != null) return e;
            e = a10 = new a(context);
            return e;
        }
    }

    public void d(a$b a$b) {
        this.c = a$b;
    }

    public void e(a$c object) {
        this.f((a$c)object);
        this.b((a$c)object);
        Object object2 = this.b;
        if (object2 != null && (object2 = object2.get(object)) != null) {
            object2 = this.a;
            Map map = this.b;
            object = (BDAbstractLocationListener)map.get(object);
            ((c)object2).d((BDAbstractLocationListener)object);
            object = this.a;
            object2 = ((c)object).a();
            ((c)object).f((LocationClientOption)object2);
            object = this.a;
            ((c)object).g();
        }
    }

    public void f(a$c a$c) {
        Object object = this.b;
        if (object != null && (object = object.get(a$c)) != null) {
            object = this.a;
            BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener)this.b.get(a$c);
            ((c)object).i(bDAbstractLocationListener);
            this.a.h();
            object = this.b;
            object.remove(a$c);
        }
    }
}

