/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.do;
import com.xiaomi.push.dy;
import com.xiaomi.push.dz;
import com.xiaomi.push.ea;
import com.xiaomi.push.eb;
import com.xiaomi.push.ec;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import com.xiaomi.push.eg;
import com.xiaomi.push.eh;
import com.xiaomi.push.ei;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class dx {
    private static volatile dx a;
    private Context a;

    private dx(Context context) {
        this.a = context;
    }

    private int a(int n10) {
        return Math.max(60, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static dx a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = dx.class;
        synchronized (object) {
            dx dx2 = a;
            if (dx2 != null) return a;
            a = dx2 = new dx(context);
            return a;
        }
    }

    public static /* synthetic */ void a(dx dx2) {
        dx2.b();
    }

    private void a(ak ak2, ai ai2, boolean bl2) {
        Object object = hr.a;
        int n10 = object.a();
        int n11 = 1;
        if ((n10 = (int)(ak2.a(n10, n11 != 0) ? 1 : 0)) != 0) {
            Context context = this.a;
            object = new ei(context);
            if (bl2) {
                hr hr2 = hr.b;
                int n12 = hr2.a();
                n11 = 86400;
                int n13 = ak2.a(n12, n11);
                n13 = this.a(n13);
                ai2.a((ai$a)object, n13);
            } else {
                ai2.a((ai$a)object);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private boolean a() {
        var1_1 = Build.VERSION.SDK_INT;
        var2_2 = 14;
        if (var1_1 >= var2_2) {
            var3_3 = this.a;
            var2_2 = var3_3 instanceof Application;
            if (var2_2 != 0) lbl-1000:
            // 2 sources

            {
                while (true) {
                    var3_3 = (Application)var3_3;
                    break;
                }
            } else {
                var3_3 = var3_3.getApplicationContext();
                ** continue;
            }
            var5_6 = this.a;
            var6_7 = System.currentTimeMillis();
            var8_8 = 1000L;
            var6_7 /= var8_8;
            var10_9 = String.valueOf(var6_7);
            var4_5 = new do(var5_6, var10_9);
            try {
                var3_3.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)var4_5);
                return true;
            }
            catch (Exception var3_4) {
                b.a(var3_4);
            }
        }
        return false;
    }

    private void b() {
        Object object;
        Object object2;
        Context context;
        long l10;
        long l11;
        long l12;
        long l13;
        String string2;
        ai ai2 = ai.a(this.a);
        ak ak2 = ak.a(this.a);
        Object object3 = this.a.getSharedPreferences("mipush_extra", 0);
        long l14 = object3.getLong(string2 = "first_try_ts", l13 = System.currentTimeMillis());
        long l15 = l14 - l13;
        Object object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object4 == false) {
            object3 = object3.edit().putLong(string2, l13);
            object3.commit();
        }
        if ((l12 = (l11 = (l10 = Math.abs(l13 - l14)) - (l13 = 172800000L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            return;
        }
        this.a(ak2, ai2, false);
        object3 = hr.aI;
        l12 = ((hr)((Object)object3)).a();
        boolean bl2 = true;
        l12 = (long)ak2.a((int)l12, bl2);
        int n10 = 86400;
        if (l12 != false) {
            object3 = hr.aJ;
            l12 = ((hr)((Object)object3)).a();
            l12 = ak2.a((int)l12, n10);
            l12 = this.a((int)l12);
            context = this.a;
            object2 = new eg(context, (int)l12);
            ai2.a((ai$a)object2, (int)l12, 0);
        }
        object3 = hr.aO;
        l12 = ((hr)((Object)object3)).a();
        l12 = (long)ak2.a((int)l12, false);
        int n11 = hr.aQ.a();
        context = null;
        object2 = ak2.a(n11, null);
        if (l12 != false && (l12 = (long)TextUtils.isEmpty((CharSequence)object2)) == false) {
            object3 = hr.aP;
            l12 = ((hr)((Object)object3)).a();
            l12 = ak2.a((int)l12, n10);
            l12 = this.a((int)l12);
            context = this.a;
            object = new ea(context, (int)l12, (String)object2);
            ai2.a((ai$a)object, (int)l12, 0);
        }
        l12 = hr.c.a();
        boolean bl3 = ak2.a((int)l12, bl2);
        l12 = hr.f.a();
        object4 = ak2.a((int)l12, bl2);
        l12 = hr.g.a();
        boolean bl4 = ak2.a((int)l12, bl2);
        l12 = hr.h.a();
        boolean bl5 = ak2.a((int)l12, bl2);
        object3 = hr.aq;
        l12 = ((hr)((Object)object3)).a();
        boolean bl6 = ak2.a((int)l12, bl2);
        l12 = 1209600;
        if (bl3 || object4 != false || bl4 || bl5 || bl6) {
            ef ef2;
            n10 = hr.i.a();
            n10 = ak2.a(n10, (int)l12);
            int n12 = this.a(n10);
            object2 = this.a;
            object = ef2;
            ef2 = new ef((Context)object2, n12, bl3, (boolean)object4, bl4, bl5, bl6);
            ai2.a(ef2, n12, 0);
        }
        n10 = hr.d.a();
        object4 = ak2.a(n10, false);
        n10 = hr.e.a();
        bl4 = ak2.a(n10, false);
        n10 = hr.ah.a();
        bl5 = ak2.a(n10, false);
        object = hr.ar;
        n10 = ((hr)((Object)object)).a();
        bl6 = ak2.a(n10, false);
        if (object4 != false || bl4 || bl5 || bl6) {
            n10 = hr.as.a();
            l12 = ak2.a(n10, (int)l12);
            l12 = this.a((int)l12);
            context = this.a;
            object2 = object;
            bl3 = l12;
            object = new ee(context, (int)l12, (boolean)object4, bl4, bl5, bl6);
            ai2.a((ai$a)object, (int)l12, 0);
        }
        l12 = Build.VERSION.SDK_INT;
        n10 = 21;
        n11 = 900;
        if (l12 < n10) {
            object3 = hr.l;
            l12 = ((hr)((Object)object3)).a();
            if ((l12 = (long)ak2.a((int)l12, false)) != false) {
                object3 = hr.m;
                l12 = ((hr)((Object)object3)).a();
                l12 = ak2.a((int)l12, n11);
                l12 = this.a((int)l12);
                context = this.a;
                object = new dz(context, (int)l12);
                ai2.a((ai$a)object, (int)l12, 0);
            }
        }
        object3 = hr.x;
        l12 = ((hr)((Object)object3)).a();
        if ((l12 = (long)ak2.a((int)l12, false)) != false) {
            object3 = hr.y;
            l12 = ((hr)((Object)object3)).a();
            n10 = 300;
            l12 = ak2.a((int)l12, n10);
            l12 = this.a((int)l12);
            context = this.a;
            object = new eh(context, (int)l12);
            ai2.a((ai$a)object, (int)l12, 0);
        }
        object3 = hr.Q;
        l12 = ((hr)((Object)object3)).a();
        if ((l12 = (long)ak2.a((int)l12, bl2)) != false) {
            object3 = hr.R;
            l12 = ((hr)((Object)object3)).a();
            l12 = ak2.a((int)l12, n11);
            l12 = this.a((int)l12);
            object2 = this.a;
            object = new ec((Context)object2, (int)l12);
            ai2.a((ai$a)object, (int)l12, 0);
        }
        object3 = hr.ap;
        l12 = ((hr)((Object)object3)).a();
        if ((l12 = (long)ak2.a((int)l12, false)) != false) {
            this.a();
        }
        object3 = hr.aD;
        l12 = ((hr)((Object)object3)).a();
        if ((l12 = (long)ak2.a((int)l12, false)) != false) {
            object3 = hr.aE;
            l12 = ((hr)((Object)object3)).a();
            n10 = 3600;
            l12 = ak2.a((int)l12, n10);
            l12 = this.a((int)l12);
            object2 = this.a;
            object = new eb((Context)object2, (int)l12);
            ai2.a((ai$a)object, (int)l12, 0);
        }
        this.a(ak2, ai2, bl2);
    }

    public void a() {
        ai ai2 = ai.a(this.a);
        dy dy2 = new dy(this);
        ai2.a(dy2);
    }
}

