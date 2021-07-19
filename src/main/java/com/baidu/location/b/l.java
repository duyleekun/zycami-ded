/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.b.ac;
import com.baidu.location.b.b;
import com.baidu.location.b.k;
import com.baidu.location.b.l$a;
import com.baidu.location.f;
import com.baidu.location.f.a;
import com.baidu.location.f.h;
import com.baidu.location.f.i;
import java.util.Locale;

public abstract class l {
    public static String c;
    public h a = null;
    public a b = null;
    public final Handler d;
    private boolean e;
    private boolean f;
    private boolean g;
    private String h;
    private String i;
    private boolean j;

    public l() {
        boolean bl2;
        this.e = bl2 = true;
        this.f = bl2;
        this.g = false;
        l$a l$a = new l$a(this);
        this.d = l$a;
        this.h = null;
        this.i = null;
        this.j = false;
    }

    public static /* synthetic */ String a(l l10) {
        return l10.h;
    }

    public static /* synthetic */ String b(l l10) {
        return l10.i;
    }

    public String a(String object) {
        Object object2;
        Object object3;
        Object object4;
        int n10;
        block18: {
            int n11;
            int n12;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean n112;
            object = this.h;
            if (object == null) {
                this.h = object = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
            }
            if ((object = this.i) == null) {
                this.i = object = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
            }
            if ((object = this.b) == null || !(n112 = ((a)object).a())) {
                this.b = object = com.baidu.location.f.b.a().f();
            }
            if ((object = this.a) == null || !(bl4 = ((h)object).k())) {
                this.a = object = com.baidu.location.f.i.a().p();
            }
            object = com.baidu.location.f.f.a();
            boolean bl5 = ((com.baidu.location.f.f)object).k();
            n10 = 0;
            object4 = null;
            object3 = bl5 ? (object = com.baidu.location.f.f.a().h()) : null;
            object = this.b;
            if ((object == null || (bl3 = ((a)object).d()) || (bl2 = ((a)(object = this.b)).c())) && ((object = this.a) == null || (n12 = ((h)object).a()) == 0) && object3 == null) {
                return null;
            }
            object = this.b();
            object4 = k.a();
            n10 = ((k)object4).d();
            if (n10 == (n11 = -2)) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append((String)object);
                ((StringBuilder)object4).append("&imo=1");
                object = ((StringBuilder)object4).toString();
            }
            if ((n10 = com.baidu.location.h.l.c((Context)(object4 = com.baidu.location.f.getServiceContext()))) >= 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append("&lmd=");
                ((StringBuilder)object2).append(n10);
                object = ((StringBuilder)object2).toString();
                n10 = Build.VERSION.SDK_INT;
                n11 = 28;
                if (n10 >= n11 && (n10 = (int)(this.j ? 1 : 0)) == 0) {
                    n10 = 1;
                    this.j = n10;
                    object4 = com.baidu.location.f.getServiceContext();
                    object4 = object4.getPackageManager();
                    object2 = "android.hardware.wifi.rtt";
                    n10 = (int)(object4.hasSystemFeature((String)object2) ? 1 : 0);
                    if (n10 == 0) break block18;
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append((String)object);
                    object2 = "&rtt=1";
                    try {
                        ((StringBuilder)object4).append((String)object2);
                        object = ((StringBuilder)object4).toString();
                    }
                    catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        }
        if (((object4 = this.a) == null || (n10 = ((h)object4).a()) == 0) && (object4 = com.baidu.location.f.i.a().m()) != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object4);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
        }
        Object object5 = object;
        boolean bl6 = this.f;
        n10 = 0;
        object4 = null;
        if (bl6) {
            this.f = false;
            object2 = this.b;
            h h10 = this.a;
            return com.baidu.location.h.l.a((a)object2, h10, (Location)object3, (String)object, 0, true);
        }
        object = this.b;
        object2 = this.a;
        return com.baidu.location.h.l.a((a)object, (h)object2, (Location)object3, (String)object5, 0);
    }

    public abstract void a();

    public abstract void a(Message var1);

    public String b() {
        boolean bl2;
        Object object;
        int n10;
        Object object2;
        String string2 = com.baidu.location.b.b.a().d();
        Object object3 = com.baidu.location.f.i.a();
        boolean bl3 = ((i)object3).j();
        int n11 = 0;
        CharSequence charSequence = null;
        int n12 = 1;
        if (bl3) {
            object3 = "&cn=32";
        } else {
            object3 = Locale.CHINA;
            object2 = new Object[n12];
            n10 = com.baidu.location.f.b.a().e();
            object2[0] = object = Integer.valueOf(n10);
            object = "&cn=%d";
            object3 = String.format((Locale)object3, (String)object, (Object[])object2);
        }
        int n13 = Build.VERSION.SDK_INT;
        n10 = 18;
        if (n13 >= n10 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = com.baidu.location.h.l.d())))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object3);
            stringBuilder.append("&qcip6c=");
            stringBuilder.append((String)object);
            object3 = stringBuilder.toString();
        }
        if ((n10 = (int)(this.e ? 1 : 0)) != 0) {
            this.e = false;
            n11 = 17;
        } else {
            n11 = this.g;
            if (n11 == 0) {
                charSequence = ac.e();
                if (charSequence != null) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object3);
                    ((StringBuilder)object2).append((String)charSequence);
                    object3 = ((StringBuilder)object2).toString();
                }
                this.g = n12;
            }
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object3);
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }
}

