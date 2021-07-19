/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.r.a.k;

import android.content.Context;
import android.text.TextUtils;
import d.r.a.k.b;
import d.r.a.k.e;
import d.r.a.k.f;
import d.r.a.u.c;
import d.r.a.u.s;
import java.util.HashSet;
import java.util.Set;

public class a
implements e {
    private static final String d = "ClientConfigManager";
    private static volatile a e;
    private Context a;
    private b b;
    private f c;

    private a(Context object) {
        Context context = this.a = (object = d.r.a.u.c.c(object).getApplicationContext());
        super(context);
        this.b = object;
        context = this.a;
        super(context);
        this.c = object;
    }

    public static a d(Context object) {
        Class<a> clazz = a.class;
        synchronized (clazz) {
            a a10 = e;
            if (a10 == null) {
                e = a10 = new a((Context)object);
            }
            object = e;
            return object;
        }
    }

    private void m() {
        b b10 = this.b;
        if (b10 == null) {
            Context context = this.a;
            this.b = b10 = new b(context);
            return;
        }
        b10.d();
    }

    private f n() {
        f f10 = this.c;
        if (f10 == null) {
            Context context = this.a;
            this.c = f10 = new f(context);
        } else {
            f10.d();
        }
        return this.c;
    }

    public boolean a(long l10) {
        String[] stringArray = this.n();
        String string2 = "BL";
        int n10 = TextUtils.isEmpty((CharSequence)(stringArray = stringArray.f(string2)));
        if (n10 == 0) {
            string2 = ",";
            for (String string3 : stringArray.split(string2)) {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
                if (bl2) continue;
                try {
                    long l11 = Long.parseLong(string3);
                    long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                    if (l12 != false) continue;
                    return true;
                }
                catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                }
            }
        }
        return false;
    }

    public void b() {
        this.b.e();
    }

    public Set c() {
        return null;
    }

    public int e() {
        int n10;
        block7: {
            Object object;
            block6: {
                object = this.n();
                String string2 = "DPL";
                object = ((f)object).f(string2);
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (bl2) break block6;
                try {
                    n10 = Integer.parseInt((String)object);
                    break block7;
                }
                catch (NumberFormatException numberFormatException) {
                    try {
                        numberFormatException.printStackTrace();
                    }
                    catch (NumberFormatException numberFormatException2) {
                        numberFormatException2.printStackTrace();
                    }
                }
            }
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public String f() {
        return this.n().f("CSPT");
    }

    public String g(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        this.c.d();
        return this.c.f(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set h() {
        HashSet<Long> hashSet = new HashSet<Long>();
        CharSequence charSequence = this.g("WLL");
        int n10 = TextUtils.isEmpty((CharSequence)charSequence);
        if (n10 == 0) {
            String string2 = ",";
            for (CharSequence charSequence2 : ((String)charSequence).split(string2)) {
                try {
                    long l10 = Long.parseLong((String)charSequence2);
                    Long l11 = l10;
                    hashSet.add(l11);
                }
                catch (Exception exception) {}
            }
        }
        charSequence = new StringBuilder(" initWhiteLogList ");
        ((StringBuilder)charSequence).append(hashSet);
        charSequence = ((StringBuilder)charSequence).toString();
        s.m(d, (String)charSequence);
        return hashSet;
    }

    public boolean i() {
        block3: {
            int n10;
            Object object = this.n();
            String string2 = "PSM";
            boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((f)object).f(string2)));
            if (!bl2) {
                try {
                    n10 = Integer.parseInt((String)object);
                    break block3;
                }
                catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                }
            }
            n10 = 0;
            object = null;
        }
        return (n10 &= 4) != 0;
    }

    public boolean j() {
        this.b.d();
        return d.r.a.k.b.f(this.b.g());
    }

    public boolean k(int n10) {
        return d.r.a.k.b.f(n10);
    }

    public boolean l() {
        this.m();
        Object object = this.b;
        String string2 = this.a.getPackageName();
        object = ((b)object).h(string2);
        if (object != null) {
            object = ((d.r.a.r.e)object).b;
            return "1".equals(object);
        }
        return true;
    }
}

