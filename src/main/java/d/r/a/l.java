/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package d.r.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import d.r.a.a;
import d.r.a.b;
import d.r.a.h$a0;
import d.r.a.h$c;
import d.r.a.h$h;
import d.r.a.l$b;
import d.r.a.l$e;
import d.r.a.l$f;
import d.r.a.m;
import d.r.a.n;
import d.r.a.o;
import d.r.a.u.a0;
import d.r.a.u.c;
import d.r.a.u.d0;
import d.r.a.u.f;
import d.r.a.u.s;
import d.r.a.u.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class l {
    private static volatile l s;
    public long a;
    public long b;
    public long c;
    public long d;
    private long e;
    private long f;
    public Context g;
    public boolean h;
    public f i;
    public String j;
    public String k;
    private SparseArray l;
    private int m;
    private Boolean n;
    private Long o;
    public boolean p;
    public b q;
    public int r;

    private l() {
        Object object;
        long l10;
        this.a = l10 = (long)-1;
        this.b = l10;
        this.c = l10;
        this.d = l10;
        this.e = l10;
        this.f = l10;
        this.h = true;
        this.l = object = new SparseArray();
        this.m = 0;
        this.q = object;
    }

    public static l b() {
        Class<l> clazz = l.class;
        synchronized (clazz) {
            l l10 = s;
            if (l10 == null) {
                s = l10 = new l();
            }
            l10 = s;
            return l10;
        }
    }

    public static boolean k(long l10) {
        long l11;
        long l12;
        long l13 = SystemClock.elapsedRealtime();
        long l14 = -1;
        long l15 = l10 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        return object == false || (object = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1)) <= 0 || (l12 = (l11 = l13 - (l10 += (l14 = 2000L))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0;
        {
        }
    }

    public final l$f a(h$c h$c, a object) {
        l$f l$f = new l$f(h$c, (a)object);
        h$c.c = object = this.c(l$f);
        l$b l$b = new l$b(this, h$c, (String)object);
        l$f.d = l$b;
        return l$f;
    }

    public final String c(l$f object) {
        synchronized (this) {
            int n10;
            SparseArray sparseArray = this.l;
            int n11 = this.m;
            sparseArray.put(n11, object);
            int n12 = this.m;
            this.m = n10 = n12 + 1;
            object = Integer.toString(n12);
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void d(Context object) {
        synchronized (this) {
            Object object2 = this.g;
            if (object2 == null) {
                boolean bl2;
                object2 = d.r.a.u.c.c((Context)object);
                object2 = object2.getApplicationContext();
                this.g = object2;
                object2 = object.getPackageName();
                String string2 = "com.vivo.pushclient.action.RECEIVE";
                this.p = bl2 = w.d((Context)object, (String)object2, string2);
                object2 = a0.m();
                string2 = this.g;
                ((a0)object2).l((Context)string2);
                object2 = new h$h();
                this.e((o)object2);
                this.i = object2 = new f();
                string2 = "com.vivo.push_preferences.appconfig_v1";
                ((f)object2).c((Context)object, string2);
                this.j = object = this.s();
                object = this.i;
                object2 = "APP_ALIAS";
                this.k = object = ((f)object).a((String)object2);
            }
            return;
        }
    }

    public final void e(o object) {
        Object object2 = d.r.a.l.b().g;
        CharSequence charSequence = "PushClientManager";
        if (object == null) {
            object = "sendCommand, null command!";
            d.r.a.u.s.a((String)charSequence, (String)object);
            if (object2 != null) {
                object = "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4\u7a7a\uff01";
                d.r.a.u.s.l((Context)object2, (String)object);
            }
            return;
        }
        Object object3 = this.q.c((o)object);
        if (object3 == null) {
            String string2 = "sendCommand, null command task! pushCommand = ";
            object3 = new StringBuilder(string2);
            ((StringBuilder)object3).append(object);
            object3 = ((StringBuilder)object3).toString();
            d.r.a.u.s.a((String)charSequence, (String)object3);
            if (object2 != null) {
                object3 = "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4";
                charSequence = new StringBuilder((String)object3);
                ((StringBuilder)charSequence).append(object);
                ((StringBuilder)charSequence).append("\u4efb\u52a1\u7a7a\uff01");
                object = ((StringBuilder)charSequence).toString();
                d.r.a.u.s.l((Context)object2, (String)object);
            }
            return;
        }
        object2 = new StringBuilder("client--sendCommand, command = ");
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        d.r.a.u.s.m((String)charSequence, (String)object);
        d.r.a.n.a((m)object3);
    }

    public final void f(String string2) {
        this.j = string2;
        this.i.g("APP_TOKEN", string2);
    }

    public final void g(String object, int n10) {
        if ((object = this.l((String)object)) != null) {
            Object[] objectArray = new Object[]{};
            ((l$f)object).b(n10, objectArray);
            return;
        }
        d.r.a.u.s.m("PushClientManager", "notifyStatusChanged token is null");
    }

    public final void h(String object, int n10, Object ... objectArray) {
        if ((object = this.l((String)object)) != null) {
            ((l$f)object).b(n10, objectArray);
            return;
        }
        d.r.a.u.s.m("PushClientManager", "notifyApp token is null");
    }

    public final void i(ArrayList object, a object2) {
        int n10;
        Object object3 = this.g;
        if (object3 == null) {
            if (object2 != null) {
                int n11 = 102;
                object2.onStateChanged(n11);
            }
            return;
        }
        object3 = object3.getPackageName();
        h$a0 h$a0 = new h$a0(true, (String)object3, (ArrayList)object);
        h$a0.g = n10 = 500;
        int n12 = this.p;
        if (n12 != 0) {
            n12 = this.t();
            if (n12 == 0) {
                if (object2 != null) {
                    int n13 = 101;
                    object2.onStateChanged(n13);
                }
                return;
            }
            long l10 = this.e;
            n12 = d.r.a.l.k(l10);
            if (n12 == 0) {
                if (object2 != null) {
                    int n14 = 1002;
                    object2.onStateChanged(n14);
                }
                return;
            }
            this.e = l10 = SystemClock.elapsedRealtime();
            Object object4 = new l$f(h$a0, (a)object2);
            h$a0.c = object2 = this.c((l$f)object4);
            object4 = this.j;
            n12 = TextUtils.isEmpty((CharSequence)object4);
            if (n12 != 0) {
                this.g((String)object2, 20001);
                return;
            }
            n12 = ((ArrayList)object).size();
            if (n12 < 0) {
                this.g((String)object2, 20002);
                return;
            }
            object4 = this.m();
            n12 = object4.size();
            int n15 = ((ArrayList)object).size() + n12;
            if (n15 > n10) {
                this.g((String)object2, 20004);
                return;
            }
            object = ((ArrayList)object).iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                long l11;
                object3 = (String)object.next();
                l10 = ((String)object3).length();
                long l12 = l10 - (l11 = (long)70);
                n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n10 <= 0) continue;
                this.g((String)object2, 20003);
                return;
            }
            this.e(h$a0);
            this.p((String)object2);
            return;
        }
        this.e(h$a0);
        if (object2 != null) {
            boolean bl2 = false;
            object = null;
            object2.onStateChanged(0);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void j(List object) {
        String string2 = "APP_TAGS";
        try {
            Object object2;
            int n10 = object.size();
            if (n10 <= 0) {
                return;
            }
            Object object3 = this.i;
            boolean bl2 = TextUtils.isEmpty((CharSequence)(object3 = ((f)object3).a(string2)));
            if (bl2) {
                object3 = new JSONObject();
            } else {
                object2 = new JSONObject((String)object3);
                object3 = object2;
            }
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = object.next();
                object2 = (String)object2;
                long l10 = System.currentTimeMillis();
                object3.put((String)object2, l10);
            }
            object = object3.toString();
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 != 0) {
                object = this.i;
                ((f)object).k(string2);
                return;
            }
            object3 = this.i;
            ((f)object3).g(string2, (String)object);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            this.i.k(string2);
            return;
        }
    }

    public final l$f l(String string2) {
        synchronized (this) {
            if (string2 != null) {
                int n10 = Integer.parseInt(string2);
                Object object = this.l;
                object = object.get(n10);
                object = (l$f)object;
                SparseArray sparseArray = this.l;
                try {
                    sparseArray.delete(n10);
                    return object;
                }
                catch (Throwable throwable) {
                    throw throwable;
                }
                catch (Exception exception) {}
            }
            return null;
        }
    }

    public final List m() {
        Object object;
        boolean bl2;
        ArrayList<JSONObject> arrayList;
        String string2;
        Object object2;
        block8: {
            object2 = this.i;
            string2 = "APP_TAGS";
            object2 = ((f)object2).a(string2);
            arrayList = new ArrayList<JSONObject>();
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) break block8;
            return arrayList;
        }
        try {
            object = new JSONObject((String)object2);
            object2 = object.keys();
        }
        catch (JSONException jSONException) {
            this.i.k(string2);
            arrayList.clear();
            object2 = "PushClientManager";
            string2 = "getTags error";
            d.r.a.u.s.m((String)object2, string2);
        }
        while (true) {
            bl2 = object2.hasNext();
            if (!bl2) break;
            object = object2.next();
            arrayList.add((JSONObject)object);
            continue;
            break;
        }
        return arrayList;
    }

    public final void n(ArrayList object, a object2) {
        int n10;
        Object object3 = this.g;
        if (object3 == null) {
            if (object2 != null) {
                int n11 = 102;
                object2.onStateChanged(n11);
            }
            return;
        }
        object3 = object3.getPackageName();
        int n12 = 0;
        Object object4 = null;
        h$a0 h$a0 = new h$a0(false, (String)object3, (ArrayList)object);
        h$a0.g = n10 = 500;
        boolean bl2 = this.p;
        if (bl2) {
            n12 = this.t();
            if (n12 == 0) {
                if (object2 != null) {
                    int n13 = 101;
                    object2.onStateChanged(n13);
                }
                return;
            }
            long l10 = this.f;
            n12 = d.r.a.l.k(l10);
            if (n12 == 0) {
                if (object2 != null) {
                    int n14 = 1002;
                    object2.onStateChanged(n14);
                }
                return;
            }
            this.f = l10 = SystemClock.elapsedRealtime();
            object4 = new l$f(h$a0, (a)object2);
            h$a0.c = object2 = this.c((l$f)object4);
            object4 = this.j;
            n12 = TextUtils.isEmpty((CharSequence)object4);
            if (n12 != 0) {
                this.g((String)object2, 20001);
                return;
            }
            n12 = ((ArrayList)object).size();
            if (n12 < 0) {
                this.g((String)object2, 20002);
                return;
            }
            n12 = ((ArrayList)object).size();
            if (n12 > n10) {
                this.g((String)object2, 20004);
                return;
            }
            object = ((ArrayList)object).iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                long l11;
                object3 = (String)object.next();
                l10 = ((String)object3).length();
                long l12 = l10 - (l11 = (long)70);
                n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n10 <= 0) continue;
                this.g((String)object2, 20003);
                return;
            }
            this.e(h$a0);
            this.p((String)object2);
            return;
        }
        this.e(h$a0);
        if (object2 != null) {
            object2.onStateChanged(0);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void o(List object) {
        String string2 = "APP_TAGS";
        try {
            Object object2;
            int n10 = object.size();
            if (n10 <= 0) {
                return;
            }
            Object object3 = this.i;
            boolean bl2 = TextUtils.isEmpty((CharSequence)(object3 = ((f)object3).a(string2)));
            if (bl2) {
                object3 = new JSONObject();
            } else {
                object2 = new JSONObject((String)object3);
                object3 = object2;
            }
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = object.next();
                object2 = (String)object2;
                object3.remove((String)object2);
            }
            object = object3.toString();
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 != 0) {
                object = this.i;
                ((f)object).k(string2);
                return;
            }
            object3 = this.i;
            ((f)object3).g(string2, (String)object);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            this.i.k(string2);
            return;
        }
    }

    public final void p(String string2) {
        l$e l$e = new l$e(this, string2);
        d.r.a.n.b(l$e);
    }

    public final boolean q() {
        Object object = this.g;
        if (object == null) {
            d.r.a.u.s.m("PushClientManager", "support:context is null");
            return false;
        }
        object = this.t();
        this.n = object;
        return (Boolean)object;
    }

    public final void r() {
        this.k = null;
        this.i.k("APP_ALIAS");
    }

    public final String s() {
        String string2;
        Object object = this.i;
        String string3 = "APP_TOKEN";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((f)object).a(string3)));
        if (!bl2 && (bl2 = d0.h((Context)(string3 = this.g), string2 = string3.getPackageName(), (String)object))) {
            this.i.b();
            object = null;
        }
        return object;
    }

    public final boolean t() {
        Comparable<Boolean> comparable = this.n;
        if (comparable == null) {
            long l10;
            comparable = this.g;
            if (comparable == null) {
                l10 = -1;
            } else {
                Long l11 = this.o;
                if (l11 == null) {
                    l10 = d0.i((Context)comparable);
                    comparable = l10;
                    this.o = comparable;
                }
                comparable = this.o;
                l10 = (Long)comparable;
            }
            long l12 = 1230L;
            long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (l13 >= 0 && (l13 = (long)d0.r(comparable = this.g)) != false) {
                l13 = 1;
            } else {
                l13 = 0;
                comparable = null;
            }
            comparable = (boolean)l13;
            this.n = comparable;
        }
        return this.n;
    }
}

