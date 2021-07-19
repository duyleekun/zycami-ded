/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.t0;

import android.content.Context;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.me.remote.PrimeManager;
import d.v.c.t0.h0;
import d.v.c.t0.i0$a;
import d.v.c.t0.i0$b;
import d.v.c.t0.i0$c;
import d.v.p.a;
import d.v.p.a$c;
import java.util.List;

public class i0 {
    private static volatile i0 e;
    private a a;
    private a$c b;
    private String c;
    private String d;

    public i0() {
        String string2;
        this.c = string2 = "";
        this.d = string2;
    }

    public static /* synthetic */ String a(i0 i02) {
        return i02.c;
    }

    public static /* synthetic */ String b(i0 i02, String string2) {
        i02.c = string2;
        return string2;
    }

    public static /* synthetic */ String c(i0 i02) {
        return i02.d;
    }

    public static /* synthetic */ String d(i0 i02, String string2) {
        i02.d = string2;
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static i0 e() {
        Class<i0> clazz = i0.class;
        synchronized (clazz) {
            i0 i02 = e;
            if (i02 == null) {
                e = i02 = new i0();
            }
            return e;
        }
    }

    public void f(Context object) {
        Object object2 = this.a;
        if (object2 == null) {
            object = d.v.p.a.c((Context)object);
            this.a = object;
        }
        if ((object = this.b) == null) {
            object = new i0$c(this);
            this.b = object;
        }
        object = this.a;
        object2 = this.b;
        ((a)object).e((a$c)object2);
    }

    public void g() {
        a a10 = this.a;
        if (a10 != null) {
            a$c a$c = this.b;
            a10.f(a$c);
        }
    }

    public void h(String string2, String string3, int n10, int n11) {
        i0$a i0$a;
        String string4;
        int n12;
        i0 i02 = this;
        Object object = DatabaseHelper.getInstance().getDataBase().ceUpLoadCloudLogInfoDao().loadCEUpLoadCloudLogInfoData();
        for (int i10 = 0; i10 < (n12 = object.size()); ++i10) {
            string4 = ((h0)object.get(i10)).g();
            n12 = (int)(string3.equals(string4) ? 1 : 0);
            if (n12 == 0) continue;
            return;
        }
        String string5 = i02.c;
        String string6 = i02.d;
        object = i0$a;
        string4 = string2;
        i0$a = new i0$a(this, string2, string3, n10, n11);
        PrimeManager.uploadCloudLog(string2, string5, string6, string3, n10, n11, 1, i0$a);
    }

    public void i() {
        List list = DatabaseHelper.getInstance().getDataBase().ceUpLoadCloudLogInfoDao().loadCEUpLoadCloudLogInfoData();
        int n10 = list.size();
        if (n10 > 0) {
            int n11;
            for (n10 = 0; n10 < (n11 = list.size()); ++n10) {
                h0 h02 = (h0)list.get(n10);
                String string2 = h02.e();
                String string3 = h02.c();
                String string4 = h02.b();
                String string5 = h02.g();
                int n12 = h02.f();
                int n13 = h02.a();
                int n14 = h02.d();
                i0$b i0$b = new i0$b(this, h02);
                PrimeManager.uploadCloudLog(string2, string3, string4, string5, n12, n13, n14, i0$b);
            }
        }
    }
}

