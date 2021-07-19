/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.PendingIntent
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.database.ContentObserver
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo$State
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Messenger
 *  android.os.Parcelable
 *  android.os.Process
 *  android.os.SystemClock
 *  android.provider.Settings$Secure
 *  android.provider.Settings$System
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.push.ab;
import com.xiaomi.push.ai;
import com.xiaomi.push.ao;
import com.xiaomi.push.bj;
import com.xiaomi.push.cz;
import com.xiaomi.push.di;
import com.xiaomi.push.eq;
import com.xiaomi.push.eu;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fl;
import com.xiaomi.push.fq;
import com.xiaomi.push.fs;
import com.xiaomi.push.ft;
import com.xiaomi.push.fv;
import com.xiaomi.push.fx;
import com.xiaomi.push.fy;
import com.xiaomi.push.fz;
import com.xiaomi.push.gd;
import com.xiaomi.push.gh;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gl;
import com.xiaomi.push.gx;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hh;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.i;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.jc;
import com.xiaomi.push.l;
import com.xiaomi.push.o;
import com.xiaomi.push.service.XMPushService$a;
import com.xiaomi.push.service.XMPushService$d;
import com.xiaomi.push.service.XMPushService$e;
import com.xiaomi.push.service.XMPushService$f;
import com.xiaomi.push.service.XMPushService$g;
import com.xiaomi.push.service.XMPushService$h;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.XMPushService$j;
import com.xiaomi.push.service.XMPushService$l;
import com.xiaomi.push.service.XMPushService$m;
import com.xiaomi.push.service.XMPushService$n;
import com.xiaomi.push.service.XMPushService$o;
import com.xiaomi.push.service.XMPushService$p;
import com.xiaomi.push.service.XMPushService$q;
import com.xiaomi.push.service.a;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.af;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ap$a;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$c;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.av;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.ax;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.b;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.be;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.bl;
import com.xiaomi.push.service.bm;
import com.xiaomi.push.service.bn;
import com.xiaomi.push.service.bo;
import com.xiaomi.push.service.bp;
import com.xiaomi.push.service.bq;
import com.xiaomi.push.service.br;
import com.xiaomi.push.service.bs;
import com.xiaomi.push.service.bt;
import com.xiaomi.push.service.bu;
import com.xiaomi.push.service.bv;
import com.xiaomi.push.service.bw;
import com.xiaomi.push.service.bx;
import com.xiaomi.push.service.c;
import com.xiaomi.push.service.d;
import com.xiaomi.push.service.e;
import com.xiaomi.push.service.g;
import com.xiaomi.push.service.k;
import com.xiaomi.push.service.l$a;
import com.xiaomi.push.service.m;
import com.xiaomi.push.service.n;
import com.xiaomi.push.service.w;
import com.xiaomi.push.t;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService
extends Service
implements fv {
    public static int a;
    private static final int d;
    private long a;
    private ContentObserver a;
    public Messenger a;
    private fq a;
    private fs a;
    private ft a;
    private fx a;
    private XMPushService$e a;
    private XMPushService$p a;
    private com.xiaomi.push.service.ao a;
    private az a;
    private d a;
    private g a;
    public Class a;
    private String a;
    private ArrayList a;
    private Collection a = null;
    private int b;
    private ContentObserver b = 0;
    private int c = 0;

    static {
        d = Process.myPid();
        String string2 = "cn.app.chat.xiaomi.net";
        cz.a(string2, string2);
        a = 1;
    }

    public XMPushService() {
        Object object = new ArrayList();
        object = Collections.synchronizedCollection(object);
        this.a = object;
        object = new ArrayList();
        this.a = object;
        this.a = object = new bl(this);
    }

    public static /* synthetic */ int a() {
        return d;
    }

    public static Notification a(Context context) {
        Notification.Builder builder = XMPushService.class;
        Intent intent = new Intent(context, builder);
        int n10 = Build.VERSION.SDK_INT;
        String string2 = "Push Service";
        int n11 = 11;
        if (n10 >= n11) {
            builder = new Notification.Builder(context);
            n11 = context.getApplicationInfo().icon;
            builder.setSmallIcon(n11);
            builder.setContentTitle((CharSequence)string2);
            builder.setContentText((CharSequence)string2);
            context = PendingIntent.getActivity((Context)context, (int)0, (Intent)intent, (int)0);
            builder.setContentIntent((PendingIntent)context);
            return builder.getNotification();
        }
        builder = new Notification();
        intent = PendingIntent.getService((Context)context, (int)0, (Intent)intent, (int)0);
        GenericDeclaration genericDeclaration = builder.getClass();
        Object[] objectArray = "setLatestEventInfo";
        int n12 = 4;
        Class[] classArray = new Class[n12];
        Class clazz = Context.class;
        classArray[0] = clazz;
        clazz = CharSequence.class;
        int n13 = 1;
        classArray[n13] = clazz;
        clazz = CharSequence.class;
        int n14 = 2;
        classArray[n14] = clazz;
        clazz = PendingIntent.class;
        int n15 = 3;
        classArray[n15] = clazz;
        genericDeclaration = ((Class)genericDeclaration).getMethod((String)objectArray, classArray);
        objectArray = new Object[n12];
        objectArray[0] = context;
        objectArray[n13] = string2;
        objectArray[n14] = string2;
        objectArray[n15] = intent;
        try {
            ((Method)genericDeclaration).invoke(builder, objectArray);
        }
        catch (Exception exception) {
            com.xiaomi.channel.commonutils.logger.b.a(exception);
        }
        return builder;
    }

    public static /* synthetic */ fs a(XMPushService xMPushService) {
        return xMPushService.a;
    }

    public static /* synthetic */ fs a(XMPushService xMPushService, fs fs2) {
        xMPushService.a = fs2;
        return fs2;
    }

    public static /* synthetic */ ft a(XMPushService xMPushService) {
        return xMPushService.a;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private gj a(gj var1_1, String var2_2, String var3_3) {
        block6: {
            var4_4 = ap.a();
            var5_5 /* !! */  = var4_4.a(var2_2);
            var6_6 = var5_5 /* !! */ .isEmpty();
            if (var6_6) {
                var1_1 = new StringBuilder();
                var3_3 = "open channel should be called first before sending a packet, pkg=";
lbl7:
                // 3 sources

                while (true) {
                    var1_1.append(var3_3);
                    var1_1.append(var2_2);
lbl12:
                    // 2 sources

                    while (true) {
                        continue;
                        break;
                    }
                    break;
                }
            }
            var1_1.o(var2_2);
            var2_2 = var1_1.k();
            var6_6 = TextUtils.isEmpty((CharSequence)var2_2);
            if (var6_6) {
                var7_7 = false;
                var2_2 = (String)var5_5 /* !! */ .get(0);
                var1_1.l(var2_2);
            }
            var5_5 /* !! */  = var1_1.m();
            var4_4 = var4_4.a(var2_2, (String)var5_5 /* !! */ );
            var8_8 = this.c();
            if (var8_8) break block6;
            var1_1 = new StringBuilder();
            var3_3 = "drop a packet as the channel is not connected, chid=";
            ** GOTO lbl7
        }
        if (var4_4 != null && (var5_5 /* !! */  = var4_4.a) == (var9_9 = ap$c.c)) {
            var2_2 = var4_4.i;
            var7_7 = TextUtils.equals((CharSequence)var3_3, (CharSequence)var2_2);
            if (!var7_7) {
                var1_1 = new StringBuilder();
                var2_2 = "invalid session. ";
                var1_1.append(var2_2);
                var1_1.append(var3_3);
                ** continue;
            }
            return var1_1;
        }
        var1_1 = new StringBuilder();
        var3_3 = "drop a packet as the channel is not opened, chid=";
        ** while (true)
        var1_1 = var1_1.toString();
        com.xiaomi.channel.commonutils.logger.b.a((String)var1_1);
        return null;
    }

    public static /* synthetic */ com.xiaomi.push.service.ao a(XMPushService xMPushService) {
        return xMPushService.a;
    }

    private ap$b a(String object, Intent intent) {
        boolean bl2;
        Object object2 = at.p;
        object2 = intent.getStringExtra((String)object2);
        ap ap2 = ap.a();
        object = ap2.a((String)object, (String)object2);
        if (object == null) {
            object = new ap$b(this);
        }
        object2 = at.r;
        object2 = intent.getStringExtra((String)object2);
        ((ap$b)object).g = object2;
        object2 = at.p;
        object2 = intent.getStringExtra((String)object2);
        ((ap$b)object).b = object2;
        object2 = at.t;
        object2 = intent.getStringExtra((String)object2);
        ((ap$b)object).c = object2;
        object2 = at.z;
        object2 = intent.getStringExtra((String)object2);
        ((ap$b)object).a = object2;
        object2 = at.x;
        object2 = intent.getStringExtra((String)object2);
        ((ap$b)object).e = object2;
        object2 = at.y;
        object2 = intent.getStringExtra((String)object2);
        ((ap$b)object).f = object2;
        object2 = at.w;
        ((ap$b)object).a = bl2 = intent.getBooleanExtra((String)object2, false);
        object2 = at.v;
        object2 = intent.getStringExtra((String)object2);
        ((ap$b)object).h = object2;
        object2 = at.C;
        object2 = intent.getStringExtra((String)object2);
        ((ap$b)object).i = object2;
        object2 = at.u;
        object2 = intent.getStringExtra((String)object2);
        ((ap$b)object).d = object2;
        ((ap$b)object).a = object2 = this.a;
        object2 = at.G;
        intent = (Messenger)intent.getParcelableExtra((String)object2);
        ((ap$b)object).a((Messenger)intent);
        intent = this.getApplicationContext();
        ((ap$b)object).a = intent;
        ap.a().a((ap$b)object);
        return object;
    }

    public static /* synthetic */ g a(XMPushService xMPushService) {
        return xMPushService.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private String a() {
        boolean bl2;
        String string2;
        ao.a();
        long l10 = SystemClock.elapsedRealtime();
        Object object = new Object();
        Object object2 = "com.xiaomi.xmsf";
        String string3 = this.getPackageName();
        boolean bl3 = ((String)object2).equals(string3);
        string3 = null;
        if (bl3) {
            int n10;
            object2 = aw.a((Context)this);
            string2 = null;
            while ((n10 = TextUtils.isEmpty((CharSequence)string2)) != 0 || (n10 = ((aw)object2).a()) == 0) {
                n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
                if (n10 != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(string2 = l.a("ro.miui.region"))) ? 1 : 0)) != 0) {
                    string2 = l.a("ro.product.locale.region");
                }
                long l11 = 100;
                object.wait(l11);
                // MONITOREXIT : object
            }
        } else {
            string2 = l.b();
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            com.xiaomi.push.service.a.a(this.getApplicationContext()).b(string2);
            object = l.a(string2);
            string3 = ((Enum)object).name();
        }
        long l12 = SystemClock.elapsedRealtime() - l10;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("wait region :");
        stringBuilder.append(string3);
        stringBuilder.append(" cost = ");
        stringBuilder.append(l12);
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        return string3;
    }

    public static /* synthetic */ String a(XMPushService xMPushService) {
        return xMPushService.a;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                this.unregisterReceiver(broadcastReceiver);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                com.xiaomi.channel.commonutils.logger.b.a(illegalArgumentException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Intent object) {
        Object object2 = at.z;
        object2 = object.getStringExtra((String)object2);
        String string2 = at.C;
        string2 = object.getStringExtra(string2);
        Bundle bundle = object.getBundleExtra("ext_packet");
        Object object3 = ap.a();
        Object object4 = null;
        if (bundle != null) {
            object = new gi(bundle);
            if ((object = (gi)this.a((gj)object, (String)object2, string2)) == null) {
                return;
            }
            object2 = ((gj)object).k();
            string2 = ((gj)object).m();
            object2 = object3.a((String)object2, (String)string2).h;
            object4 = fl.a((gj)object, (String)object2);
        } else {
            object2 = object.getByteArrayExtra("ext_raw_packet");
            if (object2 != null) {
                Object object5;
                string2 = at.p;
                long l10 = 0L;
                long l11 = object.getLongExtra(string2, l10);
                String string3 = at.q;
                string3 = object.getStringExtra(string3);
                String string4 = object.getStringExtra("ext_chid");
                if ((object3 = ((ap)object3).a(string4, (String)(object5 = Long.toString(l11)))) != null) {
                    object5 = new fl();
                    try {
                        int n10 = Integer.parseInt(string4);
                        ((fl)object5).a(n10);
                    }
                    catch (NumberFormatException numberFormatException) {}
                    string4 = "SECMSG";
                    ((fl)object5).a(string4, null);
                    ((fl)object5).a(l11, "xiaomi.com", string3);
                    string2 = "ext_pkt_id";
                    object = object.getStringExtra(string2);
                    ((fl)object5).a((String)object);
                    object = ((ap$b)object3).h;
                    ((fl)object5).a((byte[])object2, (String)object);
                    object4 = object5;
                }
            }
        }
        if (object4 != null) {
            object = new ba(this, (fl)object4);
            this.c((XMPushService$i)object);
        }
    }

    private void a(Intent object, int n10) {
        Object object2 = object.getByteArrayExtra("mipush_payload");
        boolean bl2 = true;
        boolean bl3 = object.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", bl2);
        il il2 = new il();
        iw.a(il2, (byte[])object2);
        object2 = this.getApplicationContext();
        object2 = ai.a((Context)object2);
        WeakReference<XMPushService> weakReference = new WeakReference<XMPushService>(this);
        b b10 = new b(il2, weakReference, bl3);
        try {
            ((ai)object2).a(b10, n10);
        }
        catch (jc jc2) {
            object = "aw_ping : send help app ping  error";
            com.xiaomi.channel.commonutils.logger.b.d((String)object);
        }
    }

    public static /* synthetic */ void a(XMPushService xMPushService) {
        xMPushService.e();
    }

    public static /* synthetic */ void a(XMPushService xMPushService, Intent intent) {
        xMPushService.c(intent);
    }

    private void a(String string2, int n10) {
        Object object = ap.a().a(string2);
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object object2;
                Object object3 = object2 = object.next();
                object3 = (ap$b)object2;
                if (object3 == null) continue;
                object2 = new Object(this, (ap$b)object3, n10, null, null);
                this.a((XMPushService$i)object2);
            }
        }
        ap.a().a(string2);
    }

    public static /* synthetic */ boolean a(XMPushService xMPushService) {
        return xMPushService.f();
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(String string2, Intent object) {
        Object object2 = at.p;
        object2 = object.getStringExtra((String)object2);
        ap ap2 = ap.a();
        object2 = ap2.a(string2, (String)object2);
        boolean bl2 = true;
        float f10 = Float.MIN_VALUE;
        boolean bl3 = false;
        float f11 = 0.0f;
        CharSequence charSequence = null;
        if (object2 != null && string2 != null) {
            boolean bl4;
            String string3 = at.C;
            string3 = object.getStringExtra(string3);
            String string4 = at.v;
            object = object.getStringExtra(string4);
            string4 = ((ap$b)object2).i;
            boolean bl5 = TextUtils.isEmpty((CharSequence)string4);
            if (!bl5 && !(bl5 = TextUtils.equals((CharSequence)string3, (CharSequence)(string4 = ((ap$b)object2).i)))) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("session changed. old session=");
                string4 = ((ap$b)object2).i;
                ((StringBuilder)charSequence).append(string4);
                string4 = ", new session=";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(string3);
                string3 = " chid = ";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                com.xiaomi.channel.commonutils.logger.b.a((String)charSequence);
                bl3 = bl2;
                f11 = f10;
            }
            if (!(bl4 = ((String)object).equals(object2 = ((ap$b)object2).h))) {
                object2 = new StringBuilder();
                charSequence = "security changed. chid = ";
                ((StringBuilder)object2).append((String)charSequence);
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(" sechash = ");
                string2 = com.xiaomi.push.be.a((String)object);
                ((StringBuilder)object2).append(string2);
                string2 = ((StringBuilder)object2).toString();
                com.xiaomi.channel.commonutils.logger.b.a(string2);
                return bl2;
            }
        }
        bl2 = bl3;
        f10 = f11;
        return bl2;
    }

    private int[] a() {
        block17: {
            Object object;
            Object object2 = ak.a(this.getApplicationContext());
            Object object3 = hr.aN;
            int n10 = ((hr)((Object)object3)).a();
            if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object2 = ((ak)object2).a(n10, ""))) ? 1 : 0)) == 0 && (object2 = ((String)object2).split((String)(object3 = ","))) != null && (n10 = ((String[])object2).length) >= (object = 2)) {
                object3 = new int[object];
                object = 0;
                String string2 = null;
                Object object4 = object2[0];
                object4 = Integer.valueOf((String)object4);
                int n11 = (Integer)object4;
                object3[0] = n11;
                n11 = 1;
                object2 = object2[n11];
                object2 = Integer.valueOf((String)object2);
                Object object5 = (Integer)object2;
                object3[n11] = object5;
                object5 = object3[0];
                if (object5 < 0) break block17;
                object5 = object3[0];
                Object object6 = 23;
                if (object5 > object6) break block17;
                object5 = object3[n11];
                if (object5 < 0) break block17;
                object5 = object3[n11];
                if (object5 > object6) break block17;
                object5 = object3[0];
                try {
                    object = object3[n11];
                    if (object5 != object) {
                        return object3;
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    object3 = new StringBuilder();
                    string2 = "parse falldown time range failure: ";
                    ((StringBuilder)object3).append(string2);
                    ((StringBuilder)object3).append(numberFormatException);
                    String string3 = ((StringBuilder)object3).toString();
                    com.xiaomi.channel.commonutils.logger.b.d(string3);
                }
            }
        }
        return null;
    }

    private void b(Intent object) {
        Object object2;
        Object object3 = at.z;
        object3 = object.getStringExtra((String)object3);
        fl[] flArray = at.C;
        flArray = object.getStringExtra((String)flArray);
        Object object4 = object.getParcelableArrayExtra("ext_packets");
        int n10 = ((Parcelable[])object4).length;
        gi[] giArray = new gi[n10];
        int n11 = 1;
        object.getBooleanExtra("ext_encrypt", n11 != 0);
        int n12 = 0;
        object = null;
        String string2 = null;
        for (int i10 = 0; i10 < (n11 = ((Parcelable[])object4).length); ++i10) {
            Bundle bundle = (Bundle)object4[i10];
            object2 = new gi(bundle);
            giArray[i10] = object2;
            object2 = giArray[i10];
            giArray[i10] = object2 = (gi)this.a((gj)object2, (String)object3, (String)flArray);
            object2 = giArray[i10];
            if (object2 != null) continue;
            return;
        }
        object3 = ap.a();
        flArray = new fl[n10];
        while (n12 < n10) {
            object4 = giArray[n12];
            string2 = ((gj)object4).k();
            object2 = ((gj)object4).m();
            string2 = object3.a((String)string2, (String)object2).h;
            flArray[n12] = object4 = fl.a((gj)object4, string2);
            ++n12;
        }
        object = new c(this, flArray);
        this.c((XMPushService$i)object);
    }

    public static /* synthetic */ void b(XMPushService xMPushService) {
        xMPushService.c();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(boolean bl2) {
        Object object;
        block3: {
            boolean bl3;
            block2: {
                long l10;
                this.a = l10 = System.currentTimeMillis();
                int n10 = this.c();
                bl3 = true;
                if (n10 == 0) break block2;
                object = this.a;
                n10 = ((fs)object).d();
                if (n10 != 0 || (n10 = ((fs)(object = this.a)).e()) != 0 || (n10 = com.xiaomi.push.az.d((Context)this)) != 0) break block3;
                n10 = 17;
                XMPushService$f xMPushService$f = new XMPushService$f(this, n10, null);
                this.c(xMPushService$f);
            }
            this.a(bl3);
            return;
        }
        object = new XMPushService$m(this, bl2);
        this.c((XMPushService$i)object);
    }

    public static /* synthetic */ boolean b(XMPushService xMPushService) {
        return xMPushService.g();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        boolean bl2;
        Object object;
        Object object2;
        block12: {
            block7: {
                block9: {
                    block11: {
                        block10: {
                            block8: {
                                object2 = com.xiaomi.push.service.a.a(this.getApplicationContext());
                                object = ((a)object2).a();
                                StringBuilder stringBuilder = new StringBuilder();
                                String string2 = "region of cache is ";
                                stringBuilder.append(string2);
                                stringBuilder.append((String)object);
                                String string3 = stringBuilder.toString();
                                com.xiaomi.channel.commonutils.logger.b.a(string3);
                                boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                                if (bl3) {
                                    object = this.a();
                                }
                                if (bl3 = TextUtils.isEmpty((CharSequence)object)) break block7;
                                this.a = object;
                                ((a)object2).a((String)object);
                                object2 = o.b.name();
                                object = this.a;
                                bl2 = ((String)object2).equals(object);
                                if (!bl2) break block8;
                                object2 = "app.chat.global.xiaomi.net";
                                break block9;
                            }
                            object2 = o.c.name();
                            bl2 = ((String)object2).equals(object = this.a);
                            if (!bl2) break block10;
                            object2 = "fr.app.chat.global.xiaomi.net";
                            break block9;
                        }
                        object2 = o.d.name();
                        bl2 = ((String)object2).equals(object = this.a);
                        if (!bl2) break block11;
                        object2 = "ru.app.chat.global.xiaomi.net";
                        break block9;
                    }
                    object2 = o.e.name();
                    bl2 = ((String)object2).equals(object = this.a);
                    if (!bl2) break block12;
                    object2 = "idmb.app.chat.global.xiaomi.net";
                }
                ft.a((String)object2);
                break block12;
            }
            this.a = object2 = o.a.name();
        }
        object2 = o.a.name();
        object = this.a;
        bl2 = ((String)object2).equals(object);
        if (bl2) {
            object2 = "cn.app.chat.xiaomi.net";
            ft.a((String)object2);
        }
        if (bl2 = this.h()) {
            int n10 = 11;
            object2 = new bv(this, n10);
            this.a((XMPushService$i)object2);
            object = new bw(this, (XMPushService$i)object2);
            com.xiaomi.push.service.l.a((l$a)object);
        }
        try {
            bl2 = t.a();
            if (!bl2) return;
            object2 = this.a;
            ((d)object2).a((Context)this);
            return;
        }
        catch (Exception exception) {
            com.xiaomi.channel.commonutils.logger.b.a(exception);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void c(Intent var1_1) {
        block84: {
            block114: {
                block115: {
                    block113: {
                        block85: {
                            block109: {
                                block112: {
                                    block94: {
                                        block98: {
                                            block105: {
                                                block111: {
                                                    block110: {
                                                        block107: {
                                                            block108: {
                                                                block106: {
                                                                    block104: {
                                                                        block102: {
                                                                            block103: {
                                                                                block101: {
                                                                                    block99: {
                                                                                        block100: {
                                                                                            block95: {
                                                                                                block97: {
                                                                                                    block96: {
                                                                                                        block93: {
                                                                                                            block91: {
                                                                                                                block92: {
                                                                                                                    block90: {
                                                                                                                        block89: {
                                                                                                                            block88: {
                                                                                                                                block87: {
                                                                                                                                    block86: {
                                                                                                                                        var2_4 /* !! */  = ap.a();
                                                                                                                                        var3_5 = at.d;
                                                                                                                                        var4_6 = var1_1 /* !! */ .getAction();
                                                                                                                                        var5_7 = var3_5.equalsIgnoreCase((String)var4_6);
                                                                                                                                        var6_8 = 2;
                                                                                                                                        var7_9 = 1;
                                                                                                                                        var8_10 = false;
                                                                                                                                        var9_11 = null;
                                                                                                                                        if (var5_7 != 0 || (var5_7 = (var3_5 = at.j).equalsIgnoreCase((String)(var10_12 = var1_1 /* !! */ .getAction()))) != 0) break block85;
                                                                                                                                        var3_5 = at.i;
                                                                                                                                        var10_12 = var1_1 /* !! */ .getAction();
                                                                                                                                        var5_7 = var3_5.equalsIgnoreCase((String)var10_12);
                                                                                                                                        if (var5_7 == 0) break block86;
                                                                                                                                        var3_5 = at.z;
                                                                                                                                        var3_5 = var1_1 /* !! */ .getStringExtra((String)var3_5);
                                                                                                                                        var11_13 = at.r;
                                                                                                                                        var10_12 = var1_1 /* !! */ .getStringExtra(var11_13);
                                                                                                                                        var11_13 = at.p;
                                                                                                                                        var12_22 = var1_1 /* !! */ .getStringExtra(var11_13);
                                                                                                                                        var1_1 /* !! */  = new StringBuilder();
                                                                                                                                        var1_1 /* !! */ .append("Service called close channel chid = ");
                                                                                                                                        var1_1 /* !! */ .append((String)var10_12);
                                                                                                                                        var1_1 /* !! */ .append(" res = ");
                                                                                                                                        var11_13 = ap$b.a(var12_22);
                                                                                                                                        var1_1 /* !! */ .append(var11_13);
                                                                                                                                        var1_1 /* !! */  = var1_1 /* !! */ .toString();
                                                                                                                                        com.xiaomi.channel.commonutils.logger.b.a((String)var1_1 /* !! */ );
                                                                                                                                        var13_25 = TextUtils.isEmpty((CharSequence)var10_12);
                                                                                                                                        if (var13_25) {
                                                                                                                                            var1_1 /* !! */  = var2_4 /* !! */ .a((String)var3_5).iterator();
                                                                                                                                            while (var14_39 = var1_1 /* !! */ .hasNext()) {
                                                                                                                                                var2_4 /* !! */  = (String)var1_1 /* !! */ .next();
                                                                                                                                                this.a((String)var2_4 /* !! */ , var6_8);
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            var13_25 = TextUtils.isEmpty((CharSequence)var12_22);
                                                                                                                                            if (var13_25) {
                                                                                                                                                this.a((String)var10_12, var6_8);
                                                                                                                                            } else {
                                                                                                                                                var15_42 = 2;
                                                                                                                                                var16_43 = false;
                                                                                                                                                var17_45 = null;
                                                                                                                                                var18_48 = false;
                                                                                                                                                var9_11 = this;
                                                                                                                                                this.a((String)var10_12, var12_22, var15_42, null, null);
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        break block84;
                                                                                                                                    }
                                                                                                                                    var3_5 = at.e;
                                                                                                                                    var4_6 = var1_1 /* !! */ .getAction();
                                                                                                                                    var5_7 = var3_5.equalsIgnoreCase((String)var4_6);
                                                                                                                                    if (var5_7 == 0) break block87;
                                                                                                                                    this.a(var1_1 /* !! */ );
                                                                                                                                    break block84;
                                                                                                                                }
                                                                                                                                var3_5 = at.g;
                                                                                                                                var4_6 = var1_1 /* !! */ .getAction();
                                                                                                                                var5_7 = var3_5.equalsIgnoreCase((String)var4_6);
                                                                                                                                if (var5_7 == 0) break block88;
                                                                                                                                this.b(var1_1 /* !! */ );
                                                                                                                                break block84;
                                                                                                                            }
                                                                                                                            var3_5 = at.f;
                                                                                                                            var4_6 = var1_1 /* !! */ .getAction();
                                                                                                                            var5_7 = var3_5.equalsIgnoreCase((String)var4_6);
                                                                                                                            var4_6 = "ext_packet";
                                                                                                                            if (var5_7 == 0) break block89;
                                                                                                                            var3_5 = at.z;
                                                                                                                            var3_5 = var1_1 /* !! */ .getStringExtra((String)var3_5);
                                                                                                                            var11_14 = at.C;
                                                                                                                            var11_14 = var1_1 /* !! */ .getStringExtra(var11_14);
                                                                                                                            var1_1 /* !! */  = var1_1 /* !! */ .getBundleExtra((String)var4_6);
                                                                                                                            var4_6 = new gh((Bundle)var1_1 /* !! */ );
                                                                                                                            if ((var1_1 /* !! */  = this.a((gj)var4_6, (String)var3_5, var11_14)) != null) {
                                                                                                                                var3_5 = var1_1 /* !! */ .k();
                                                                                                                                var4_6 = var1_1 /* !! */ .m();
                                                                                                                                var2_4 /* !! */  = var2_4 /* !! */ .a((String)var3_5, (String)var4_6).h;
                                                                                                                                var1_1 /* !! */  = fl.a((gj)var1_1 /* !! */ , (String)var2_4 /* !! */ );
                                                                                                                                var2_4 /* !! */  = new ba(this, (fl)var1_1 /* !! */ );
lbl83:
                                                                                                                                // 2 sources

                                                                                                                                while (true) {
                                                                                                                                    this.c((XMPushService$i)var2_4 /* !! */ );
                                                                                                                                    ** GOTO lbl656
                                                                                                                                    break;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            break block84;
                                                                                                                        }
                                                                                                                        var3_5 = at.h;
                                                                                                                        var10_12 = var1_1 /* !! */ .getAction();
                                                                                                                        var5_7 = var3_5.equalsIgnoreCase((String)var10_12);
                                                                                                                        if (var5_7 == 0) break block90;
                                                                                                                        var3_5 = at.z;
                                                                                                                        var3_5 = var1_1 /* !! */ .getStringExtra((String)var3_5);
                                                                                                                        var11_15 = at.C;
                                                                                                                        var11_15 = var1_1 /* !! */ .getStringExtra(var11_15);
                                                                                                                        var1_1 /* !! */  = var1_1 /* !! */ .getBundleExtra((String)var4_6);
                                                                                                                        var4_6 = new gl((Bundle)var1_1 /* !! */ );
                                                                                                                        if ((var1_1 /* !! */  = this.a((gj)var4_6, (String)var3_5, var11_15)) != null) {
                                                                                                                            var3_5 = var1_1 /* !! */ .k();
                                                                                                                            var4_6 = var1_1 /* !! */ .m();
                                                                                                                            var2_4 /* !! */  = var2_4 /* !! */ .a((String)var3_5, (String)var4_6).h;
                                                                                                                            var1_1 /* !! */  = fl.a((gj)var1_1 /* !! */ , (String)var2_4 /* !! */ );
                                                                                                                            var2_4 /* !! */  = new ba(this, (fl)var1_1 /* !! */ );
                                                                                                                            ** continue;
                                                                                                                        }
                                                                                                                        break block84;
                                                                                                                    }
                                                                                                                    var3_5 = at.k;
                                                                                                                    var4_6 = var1_1 /* !! */ .getAction();
                                                                                                                    var5_7 = var3_5.equals(var4_6);
                                                                                                                    if (var5_7 == 0) break block91;
                                                                                                                    var2_4 /* !! */  = at.r;
                                                                                                                    var2_4 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var2_4 /* !! */ );
                                                                                                                    var3_5 = at.p;
                                                                                                                    var3_5 = var1_1 /* !! */ .getStringExtra((String)var3_5);
                                                                                                                    if (var2_4 /* !! */  == null) break block84;
                                                                                                                    var4_6 = new StringBuilder();
                                                                                                                    var11_16 = "request reset connection from chid = ";
                                                                                                                    var4_6.append(var11_16);
                                                                                                                    var4_6.append((String)var2_4 /* !! */ );
                                                                                                                    com.xiaomi.channel.commonutils.logger.b.a(var4_6.toString());
                                                                                                                    var4_6 = ap.a();
                                                                                                                    var2_4 /* !! */  = var4_6.a((String)var2_4 /* !! */ , (String)var3_5);
                                                                                                                    if (var2_4 /* !! */  == null || !(var13_26 = (var3_5 = var2_4 /* !! */ .h).equals(var1_1 /* !! */  = var1_1 /* !! */ .getStringExtra((String)(var4_6 = at.v)))) || (var1_1 /* !! */  = var2_4 /* !! */ .a) != (var2_4 /* !! */  = ap$c.c)) break block84;
                                                                                                                    var1_1 /* !! */  = this.a();
                                                                                                                    if (var1_1 /* !! */  == null) break block92;
                                                                                                                    var19_50 = System.currentTimeMillis();
                                                                                                                    var21_52 = 15000L;
                                                                                                                    var13_26 = var1_1 /* !! */ .a(var19_50 -= var21_52);
                                                                                                                    if (var13_26) break block84;
                                                                                                                }
                                                                                                                var1_1 /* !! */  = new XMPushService$o(this);
lbl134:
                                                                                                                // 4 sources

                                                                                                                while (true) {
                                                                                                                    this.c((XMPushService$i)var1_1 /* !! */ );
                                                                                                                    break block84;
                                                                                                                    break;
                                                                                                                }
                                                                                                                break block84;
                                                                                                            }
                                                                                                            var3_5 = at.l;
                                                                                                            var4_6 = var1_1 /* !! */ .getAction();
                                                                                                            var5_7 = var3_5.equals(var4_6);
                                                                                                            var6_8 = 0;
                                                                                                            var4_6 = null;
                                                                                                            if (var5_7 == 0) break block93;
                                                                                                            var3_5 = at.z;
                                                                                                            var11_17 = var2_4 /* !! */ .a((String)(var3_5 = var1_1 /* !! */ .getStringExtra((String)var3_5)));
                                                                                                            var23_53 = var11_17.isEmpty();
                                                                                                            if (var23_53) {
                                                                                                                var1_1 /* !! */  = new StringBuilder();
                                                                                                                var2_4 /* !! */  = "open channel should be called first before update info, pkg=";
                                                                                                                var1_1 /* !! */ .append((String)var2_4 /* !! */ );
                                                                                                                var1_1 /* !! */ .append((String)var3_5);
                                                                                                                var1_1 /* !! */  = var1_1 /* !! */ .toString();
lbl156:
                                                                                                                // 3 sources

                                                                                                                while (true) {
                                                                                                                    com.xiaomi.channel.commonutils.logger.b.a((String)var1_1 /* !! */ );
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                            var3_5 = at.r;
                                                                                                            var3_5 = var1_1 /* !! */ .getStringExtra((String)var3_5);
                                                                                                            var10_12 = at.p;
                                                                                                            var10_12 = var1_1 /* !! */ .getStringExtra((String)var10_12);
                                                                                                            var24_54 = TextUtils.isEmpty((CharSequence)var3_5);
                                                                                                            if (var24_54) {
                                                                                                                var3_5 = (String)var11_17.get(0);
                                                                                                            }
                                                                                                            if ((var7_9 = (int)TextUtils.isEmpty((CharSequence)var10_12)) != 0) {
                                                                                                                if ((var2_4 /* !! */  = var2_4 /* !! */ .a((String)var3_5)) != null && (var5_7 = var2_4 /* !! */ .isEmpty()) == 0) {
                                                                                                                    var4_6 = var2_4 /* !! */  = var2_4 /* !! */ .iterator().next();
                                                                                                                    var4_6 = (ap$b)var2_4 /* !! */ ;
                                                                                                                }
                                                                                                            } else {
                                                                                                                var4_6 = var2_4 /* !! */ .a((String)var3_5, (String)var10_12);
                                                                                                            }
                                                                                                            if (var4_6 != null) {
                                                                                                                var2_4 /* !! */  = at.x;
                                                                                                                var14_40 = var1_1 /* !! */ .hasExtra((String)var2_4 /* !! */ );
                                                                                                                if (var14_40) {
                                                                                                                    var2_4 /* !! */  = at.x;
                                                                                                                    var2_4 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var2_4 /* !! */ );
                                                                                                                    var4_6.e = var2_4 /* !! */ ;
                                                                                                                }
                                                                                                                if (var14_40 = var1_1 /* !! */ .hasExtra((String)(var2_4 /* !! */  = at.y))) {
                                                                                                                    var2_4 /* !! */  = at.y;
                                                                                                                    var4_6.f = var1_1 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var2_4 /* !! */ );
                                                                                                                }
                                                                                                            }
                                                                                                            break block84;
                                                                                                        }
                                                                                                        var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                                                        var3_5 = "android.intent.action.SCREEN_ON";
                                                                                                        var14_41 = var3_5.equals(var2_4 /* !! */ );
                                                                                                        var10_12 = "android.intent.action.SCREEN_OFF";
                                                                                                        if (var14_41 != 0 || (var14_41 = var10_12.equals(var2_4 /* !! */  = var1_1 /* !! */ .getAction())) != 0) break block94;
                                                                                                        var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                                                        var14_41 = "com.xiaomi.mipush.REGISTER_APP".equals(var2_4 /* !! */ );
                                                                                                        var3_5 = "com.xiaomi.xmsf";
                                                                                                        var10_12 = "mipush_payload";
                                                                                                        var12_23 = "mipush_app_package";
                                                                                                        if (var14_41 == 0) break block95;
                                                                                                        var2_4 /* !! */  = aw.a(this.getApplicationContext());
                                                                                                        var14_41 = var2_4 /* !! */ .a();
                                                                                                        if (var14_41 == 0 || (var14_41 = (var2_4 /* !! */  = aw.a(this.getApplicationContext())).a()) != 0) break block96;
                                                                                                        var2_4 /* !! */  = new StringBuilder();
                                                                                                        var3_5 = "register without being provisioned. ";
                                                                                                        var2_4 /* !! */ .append((String)var3_5);
                                                                                                        var1_1 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var12_23);
                                                                                                        var2_4 /* !! */ .append((String)var1_1 /* !! */ );
                                                                                                        var1_1 /* !! */  = var2_4 /* !! */ .toString();
                                                                                                        ** GOTO lbl156
                                                                                                    }
                                                                                                    var10_12 = var1_1 /* !! */ .getByteArrayExtra((String)var10_12);
                                                                                                    var12_23 = var1_1 /* !! */ .getStringExtra((String)var12_23);
                                                                                                    var2_4 /* !! */  = "mipush_env_chanage";
                                                                                                    var14_41 = (int)var1_1 /* !! */ .getBooleanExtra((String)var2_4 /* !! */ , false);
                                                                                                    var4_6 = "mipush_env_type";
                                                                                                    var7_9 = var1_1 /* !! */ .getIntExtra((String)var4_6, var7_9);
                                                                                                    var1_1 /* !! */  = m.a((Context)this);
                                                                                                    var1_1 /* !! */ .d((String)var12_23);
                                                                                                    if (var14_41 == 0 || (var13_27 = var3_5.equals(var1_1 /* !! */  = this.getPackageName()))) break block97;
                                                                                                    var6_8 = 14;
                                                                                                    var2_4 /* !! */  = var1_1 /* !! */ ;
                                                                                                    var3_5 = this;
                                                                                                    var9_11 = var10_12;
                                                                                                    var10_12 = var12_23;
                                                                                                    var1_1 /* !! */  = new bx(this, var6_8, var7_9, (byte[])var9_11, (String)var12_23);
                                                                                                    ** GOTO lbl134
                                                                                                }
                                                                                                this.a((byte[])var10_12, (String)var12_23);
                                                                                                break block84;
                                                                                            }
                                                                                            var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                                            var14_41 = "com.xiaomi.mipush.SEND_MESSAGE".equals(var2_4 /* !! */ );
                                                                                            var25_55 = "com.xiaomi.mipush.UNREGISTER_APP";
                                                                                            if (var14_41 != 0 || (var14_41 = (int)var25_55.equals(var2_4 /* !! */  = var1_1 /* !! */ .getAction())) != 0) break block98;
                                                                                            var2_4 /* !! */  = ax.a;
                                                                                            var25_55 = var1_1 /* !! */ .getAction();
                                                                                            var14_41 = (int)var2_4 /* !! */ .equals(var25_55);
                                                                                            if (var14_41 != 0) {
                                                                                                var2_4 /* !! */  = "uninstall_pkg_name";
                                                                                                if ((var1_1 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var2_4 /* !! */ )) != null && (var14_41 = (int)TextUtils.isEmpty((CharSequence)(var2_4 /* !! */  = var1_1 /* !! */ .trim()))) == 0) {
                                                                                                    var2_4 /* !! */  = this.getPackageManager();
                                                                                                    var2_4 /* !! */ .getPackageInfo((String)var1_1 /* !! */ , 0);
                                                                                                    var7_9 = 0;
                                                                                                    var11_18 = null;
lbl245:
                                                                                                    // 2 sources

                                                                                                    while (true) {
                                                                                                        var2_4 /* !! */  = "com.xiaomi.channel";
                                                                                                        var14_41 = (int)var2_4 /* !! */ .equals(var1_1 /* !! */ );
                                                                                                        if (var14_41 != 0) {
                                                                                                            var2_4 /* !! */  = ap.a();
                                                                                                            var3_5 = "1";
                                                                                                            var14_41 = (int)(var2_4 /* !! */  = var2_4 /* !! */ .a((String)var3_5)).isEmpty();
                                                                                                            if (var14_41 == 0 && var7_9 != 0) {
                                                                                                                this.a((String)var3_5, 0);
                                                                                                                var1_1 /* !! */  = "close the miliao channel as the app is uninstalled.";
                                                                                                                ** continue;
                                                                                                            }
                                                                                                        }
                                                                                                        if ((var6_8 = (int)TextUtils.isEmpty((CharSequence)(var3_5 = (var2_4 /* !! */  = this.getSharedPreferences("pref_registered_pkg_names", 0)).getString((String)var1_1 /* !! */ , null)))) == 0 && var7_9 != 0) {
                                                                                                            var2_4 /* !! */  = var2_4 /* !! */ .edit();
                                                                                                            var2_4 /* !! */ .remove((String)var1_1 /* !! */ );
                                                                                                            var2_4 /* !! */ .commit();
                                                                                                            var14_41 = (int)aa.b((Context)this, (String)var1_1 /* !! */ );
                                                                                                            if (var14_41 != 0) {
                                                                                                                aa.b((Context)this, (String)var1_1 /* !! */ );
                                                                                                            }
                                                                                                            aa.a((Context)this, (String)var1_1 /* !! */ );
                                                                                                            var14_41 = (int)this.c();
                                                                                                            if (var14_41 != 0 && var3_5 != null) {
                                                                                                                var2_4 /* !! */  = w.a((String)var1_1 /* !! */ , (String)var3_5);
                                                                                                                w.a(this, (ii)var2_4 /* !! */ );
                                                                                                                var2_4 /* !! */  = new StringBuilder();
                                                                                                                var3_5 = "uninstall ";
                                                                                                                var2_4 /* !! */ .append((String)var3_5);
                                                                                                                var2_4 /* !! */ .append((String)var1_1 /* !! */ );
                                                                                                                var1_1 /* !! */  = " msg sent";
                                                                                                                var2_4 /* !! */ .append((String)var1_1 /* !! */ );
                                                                                                                var1_1 /* !! */  = var2_4 /* !! */ .toString();
                                                                                                                try {
                                                                                                                    com.xiaomi.channel.commonutils.logger.b.a((String)var1_1 /* !! */ );
                                                                                                                }
                                                                                                                catch (gd var1_2) {
                                                                                                                    var2_4 /* !! */  = new StringBuilder();
                                                                                                                    var2_4 /* !! */ .append("Fail to send Message: ");
                                                                                                                    var3_5 = var1_2.getMessage();
                                                                                                                    var2_4 /* !! */ .append((String)var3_5);
                                                                                                                    var2_4 /* !! */  = var2_4 /* !! */ .toString();
                                                                                                                    com.xiaomi.channel.commonutils.logger.b.d((String)var2_4 /* !! */ );
                                                                                                                    var14_41 = 10;
                                                                                                                    this.a(var14_41, (Exception)var1_2);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        break block84;
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                return;
                                                                                            }
                                                                                            var2_4 /* !! */  = ax.b;
                                                                                            var25_55 = var1_1 /* !! */ .getAction();
                                                                                            var14_41 = (int)var2_4 /* !! */ .equals(var25_55);
                                                                                            if (var14_41 == 0) break block99;
                                                                                            var2_4 /* !! */  = "data_cleared_pkg_name";
                                                                                            if ((var1_1 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var2_4 /* !! */ )) == null || (var14_41 = (int)TextUtils.isEmpty((CharSequence)(var2_4 /* !! */  = var1_1 /* !! */ .trim()))) != 0) break block100;
                                                                                            var2_4 /* !! */  = new StringBuilder();
                                                                                            var3_5 = "clear notifications of package ";
                                                                                            var2_4 /* !! */ .append((String)var3_5);
                                                                                            var2_4 /* !! */ .append((String)var1_1 /* !! */ );
                                                                                            var2_4 /* !! */  = var2_4 /* !! */ .toString();
                                                                                            com.xiaomi.channel.commonutils.logger.b.a((String)var2_4 /* !! */ );
                                                                                            aa.a((Context)this, (String)var1_1 /* !! */ );
                                                                                            break block84;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    var25_55 = "com.xiaomi.mipush.CLEAR_NOTIFICATION";
                                                                                    var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                                    var14_41 = (int)var25_55.equals(var2_4 /* !! */ );
                                                                                    if (var14_41 == 0) break block101;
                                                                                    var2_4 /* !! */  = at.z;
                                                                                    var2_4 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var2_4 /* !! */ );
                                                                                    var3_5 = at.A;
                                                                                    var5_7 = var1_1 /* !! */ .getIntExtra((String)var3_5, -2);
                                                                                    var6_8 = (int)TextUtils.isEmpty((CharSequence)var2_4 /* !! */ );
                                                                                    if (var6_8 == 0) {
                                                                                        var6_8 = -1;
                                                                                        if (var5_7 >= var6_8) {
                                                                                            aa.a((Context)this, (String)var2_4 /* !! */ , var5_7);
                                                                                        } else {
                                                                                            var3_5 = at.E;
                                                                                            var3_5 = var1_1 /* !! */ .getStringExtra((String)var3_5);
                                                                                            var4_6 = at.F;
                                                                                            var1_1 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var4_6);
                                                                                            aa.a((Context)this, (String)var2_4 /* !! */ , (String)var3_5, (String)var1_1 /* !! */ );
                                                                                        }
                                                                                    }
                                                                                    break block84;
                                                                                }
                                                                                var25_55 = "com.xiaomi.mipush.SET_NOTIFICATION_TYPE";
                                                                                var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                                var14_41 = (int)var25_55.equals(var2_4 /* !! */ );
                                                                                if (var14_41 == 0) break block102;
                                                                                var2_4 /* !! */  = at.z;
                                                                                var2_4 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var2_4 /* !! */ );
                                                                                var3_5 = at.D;
                                                                                var3_5 = var1_1 /* !! */ .getStringExtra((String)var3_5);
                                                                                var4_6 = at.B;
                                                                                var6_8 = (int)var1_1 /* !! */ .hasExtra((String)var4_6);
                                                                                if (var6_8 != 0) {
                                                                                    var4_6 = at.B;
                                                                                    var13_28 = var1_1 /* !! */ .getIntExtra((String)var4_6, 0);
                                                                                    var4_6 = new StringBuilder();
                                                                                    var4_6.append((String)var2_4 /* !! */ );
                                                                                    var4_6.append((int)var13_28);
                                                                                    var4_6 = com.xiaomi.push.be.b(var4_6.toString());
                                                                                    var7_9 = 0;
                                                                                    var11_19 = null;
                                                                                    var8_10 = var13_28;
                                                                                } else {
                                                                                    var4_6 = com.xiaomi.push.be.b((String)var2_4 /* !! */ );
                                                                                }
                                                                                var13_28 = TextUtils.isEmpty((CharSequence)var2_4 /* !! */ );
                                                                                if (var13_28 || !(var13_28 = (boolean)TextUtils.equals((CharSequence)var3_5, (CharSequence)var4_6))) break block103;
                                                                                if (var7_9 != 0) {
                                                                                    aa.b((Context)this, (String)var2_4 /* !! */ );
                                                                                } else {
                                                                                    aa.b((Context)this, (String)var2_4 /* !! */ , (int)var8_10);
                                                                                }
                                                                                break block84;
                                                                            }
                                                                            var1_1 /* !! */  = new StringBuilder();
                                                                            var3_5 = "invalid notification for ";
                                                                            var1_1 /* !! */ .append((String)var3_5);
                                                                            var1_1 /* !! */ .append((String)var2_4 /* !! */ );
                                                                            var1_1 /* !! */  = var1_1 /* !! */ .toString();
lbl381:
                                                                            // 2 sources

                                                                            while (true) {
                                                                                com.xiaomi.channel.commonutils.logger.b.d((String)var1_1 /* !! */ );
                                                                                break block84;
                                                                                break;
                                                                            }
                                                                        }
                                                                        var25_55 = "com.xiaomi.mipush.DISABLE_PUSH";
                                                                        var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                        var14_41 = (int)var25_55.equals(var2_4 /* !! */ );
                                                                        if (var14_41 == 0) break block104;
                                                                        var14_41 = (int)TextUtils.isEmpty((CharSequence)(var1_1 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var12_23)));
                                                                        if (var14_41 == 0) {
                                                                            var2_4 /* !! */  = m.a((Context)this);
                                                                            var2_4 /* !! */ .b((String)var1_1 /* !! */ );
                                                                        }
                                                                        if ((var13_29 = var3_5.equals(var1_1 /* !! */  = this.getPackageName())) == 0) {
                                                                            var13_29 = 19;
                                                                            this.a(var13_29, null);
                                                                            this.e();
                                                                            this.stopSelf();
                                                                        }
                                                                        break block84;
                                                                    }
                                                                    var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                    var4_6 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                                                                    var14_41 = (int)var4_6.equals(var2_4 /* !! */ );
                                                                    var25_55 = "android.net.conn.CONNECTIVITY_CHANGE";
                                                                    var17_46 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                                                                    if (var14_41 != 0 || (var14_41 = (int)var17_46.equals(var2_4 /* !! */  = var1_1 /* !! */ .getAction())) != 0) break block105;
                                                                    var4_6 = "com.xiaomi.mipush.SEND_TINYDATA";
                                                                    var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                    var14_41 = (int)var4_6.equals(var2_4 /* !! */ );
                                                                    if (var14_41 == 0) break block106;
                                                                    var2_4 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var12_23);
                                                                    var1_1 /* !! */  = (Intent)var1_1 /* !! */ .getByteArrayExtra((String)var10_12);
                                                                    var3_5 = new hq();
                                                                    iw.a((ix)var3_5, (byte[])var1_1 /* !! */ );
                                                                    var1_1 /* !! */  = hk.a((Context)this);
                                                                    try {
                                                                        var1_1 /* !! */ .a((hq)var3_5, (String)var2_4 /* !! */ );
                                                                    }
                                                                    catch (jc var1_3) {
                                                                        com.xiaomi.channel.commonutils.logger.b.a(var1_3);
                                                                    }
                                                                    break block84;
                                                                }
                                                                var4_6 = "com.xiaomi.push.timer";
                                                                var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                var14_41 = (int)var4_6.equalsIgnoreCase((String)var2_4 /* !! */ );
                                                                if (var14_41 == 0) break block107;
                                                                var1_1 /* !! */  = "Service called on timer";
                                                                com.xiaomi.channel.commonutils.logger.b.a((String)var1_1 /* !! */ );
                                                                var13_30 = this.i();
                                                                if (!var13_30) break block108;
                                                                var13_30 = fc.a();
                                                                if (!var13_30) break block84;
                                                                var1_1 /* !! */  = "enter falldown mode, stop alarm";
                                                                break block109;
                                                            }
                                                            fc.a(false);
                                                            var13_30 = this.e();
                                                            if (!var13_30) break block84;
                                                            break block110;
                                                        }
                                                        var4_6 = "com.xiaomi.push.check_alive";
                                                        var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                        var14_41 = (int)var4_6.equalsIgnoreCase((String)var2_4 /* !! */ );
                                                        if (var14_41 == 0) break block111;
                                                        var1_1 /* !! */  = "Service called on check alive.";
                                                        com.xiaomi.channel.commonutils.logger.b.a((String)var1_1 /* !! */ );
                                                        var13_31 = this.e();
                                                        if (!var13_31) break block84;
                                                    }
                                                    this.b(false);
                                                    break block84;
                                                }
                                                var4_6 = "com.xiaomi.mipush.thirdparty";
                                                var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                var14_41 = (int)var4_6.equals(var2_4 /* !! */ );
                                                if (var14_41 != 0) {
                                                    var2_4 /* !! */  = new StringBuilder();
                                                    var2_4 /* !! */ .append("on thirdpart push :");
                                                    var3_5 = var1_1 /* !! */ .getStringExtra("com.xiaomi.mipush.thirdparty_DESC");
                                                    var2_4 /* !! */ .append((String)var3_5);
                                                    com.xiaomi.channel.commonutils.logger.b.a(var2_4 /* !! */ .toString());
                                                    var2_4 /* !! */  = "com.xiaomi.mipush.thirdparty_LEVEL";
                                                    var13_32 = var1_1 /* !! */ .getIntExtra((String)var2_4 /* !! */ , 0);
                                                    fc.a((Context)this, var13_32);
                                                } else {
                                                    var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                    var14_41 = (int)var25_55.equals(var2_4 /* !! */ );
                                                    if (var14_41 != 0) {
                                                        this.d();
                                                    } else {
                                                        var4_6 = "action_cr_config";
                                                        var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                        var14_41 = (int)var4_6.equals(var2_4 /* !! */ );
                                                        if (var14_41 != 0) {
                                                            var14_41 = (int)var1_1 /* !! */ .getBooleanExtra("action_cr_event_switch", false);
                                                            var26_57 = 86400L;
                                                            var28_58 = var1_1 /* !! */ .getLongExtra("action_cr_event_frequency", var26_57);
                                                            var4_6 = "action_cr_perf_switch";
                                                            var6_8 = (int)var1_1 /* !! */ .getBooleanExtra((String)var4_6, false);
                                                            var9_11 = "action_cr_perf_frequency";
                                                            var30_59 = var1_1 /* !! */ .getLongExtra((String)var9_11, var26_57);
                                                            var7_9 = var1_1 /* !! */ .getBooleanExtra("action_cr_event_en", (boolean)var7_9);
                                                            var12_23 = "action_cr_max_file_size";
                                                            var32_60 = var1_1 /* !! */ .getLongExtra((String)var12_23, 0x100000L);
                                                            var1_1 /* !! */  = Config.getBuilder().setEventUploadSwitchOpen((boolean)var14_41).setEventUploadFrequency(var28_58).setPerfUploadSwitchOpen((boolean)var6_8).setPerfUploadFrequency(var30_59);
                                                            var2_4 /* !! */  = bj.a(this.getApplicationContext());
                                                            var1_1 /* !! */  = var1_1 /* !! */ .setAESKey((String)var2_4 /* !! */ ).setEventEncrypted((boolean)var7_9).setMaxFileLength(var32_60);
                                                            var2_4 /* !! */  = this.getApplicationContext();
                                                            var1_1 /* !! */  = var1_1 /* !! */ .build((Context)var2_4 /* !! */ );
                                                            var2_4 /* !! */  = this.getPackageName();
                                                            var14_41 = var3_5.equals(var2_4 /* !! */ );
                                                            if (var14_41 == 0 && (var6_8 = (int)((cfr_temp_0 = var28_58 - (var19_51 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) > 0 && (var6_8 = (int)(var30_59 == var19_51 ? 0 : (var30_59 < var19_51 ? -1 : 1))) > 0 && (var14_41 = var32_60 == var19_51 ? 0 : (var32_60 < var19_51 ? -1 : 1)) > 0) {
                                                                var2_4 /* !! */  = this.getApplicationContext();
                                                                fa.a((Context)var2_4 /* !! */ , (Config)var1_1 /* !! */ );
                                                            }
                                                        } else {
                                                            var4_6 = "action_help_ping";
                                                            var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                            var14_41 = (int)var4_6.equals(var2_4 /* !! */ );
                                                            if (var14_41 != 0) {
                                                                var2_4 /* !! */  = "extra_help_ping_switch";
                                                                var14_41 = (int)var1_1 /* !! */ .getBooleanExtra((String)var2_4 /* !! */ , false);
                                                                var4_6 = "extra_help_ping_frequency";
                                                                var6_8 = var1_1 /* !! */ .getIntExtra((String)var4_6, 0);
                                                                var7_9 = 30;
                                                                if (var6_8 >= 0 && var6_8 < var7_9) {
                                                                    var4_6 = "aw_ping: frquency need > 30s.";
                                                                    com.xiaomi.channel.commonutils.logger.b.c((String)var4_6);
                                                                    var6_8 = var7_9;
                                                                }
                                                                if (var6_8 >= 0) {
                                                                    var8_10 = var14_41;
                                                                }
                                                                var2_4 /* !! */  = new StringBuilder();
                                                                var2_4 /* !! */ .append("aw_ping: receive a aw_ping message. switch: ");
                                                                var2_4 /* !! */ .append(var8_10);
                                                                var11_20 = " frequency: ";
                                                                var2_4 /* !! */ .append(var11_20);
                                                                var2_4 /* !! */ .append(var6_8);
                                                                var2_4 /* !! */  = var2_4 /* !! */ .toString();
                                                                com.xiaomi.channel.commonutils.logger.b.a((String)var2_4 /* !! */ );
                                                                if (var8_10 && var6_8 > 0 && (var14_41 = var3_5.equals(var2_4 /* !! */  = this.getPackageName())) == 0) {
                                                                    this.a(var1_1 /* !! */ , var6_8);
                                                                }
                                                            } else {
                                                                var3_5 = "action_aw_app_logic";
                                                                var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                                                var14_41 = (int)var3_5.equals(var2_4 /* !! */ );
                                                                if (var14_41 != 0) {
                                                                    this.d(var1_1 /* !! */ );
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                break block84;
                                            }
                                            var11_21 = var1_1 /* !! */ .getStringExtra((String)var12_23);
                                            var12_23 = var1_1 /* !! */ .getByteArrayExtra((String)var10_12);
                                            var9_11 = var1_1 /* !! */ .getStringExtra("mipush_app_id");
                                            var10_12 = var1_1 /* !! */ .getStringExtra("mipush_app_token");
                                            var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                            var14_41 = (int)var4_6.equals(var2_4 /* !! */ );
                                            if (var14_41 != 0) {
                                                var2_4 /* !! */  = m.a((Context)this);
                                                var2_4 /* !! */ .c(var11_21);
                                            }
                                            if ((var14_41 = (int)var17_46.equals(var2_4 /* !! */  = var1_1 /* !! */ .getAction())) != 0) {
                                                m.a((Context)this).e(var11_21);
                                                var2_4 /* !! */  = m.a((Context)this);
                                                var2_4 /* !! */ .f(var11_21);
                                            }
                                            if (var12_23 == null) {
                                                var13_33 = 70000003;
                                                var2_4 /* !! */  = "null payload";
                                                com.xiaomi.push.service.o.a((Context)this, var11_21, (byte[])var12_23, var13_33, (String)var2_4 /* !! */ );
                                            } else {
                                                com.xiaomi.push.service.o.b(var11_21, (byte[])var12_23);
                                                var3_5 = var2_4 /* !! */ ;
                                                var4_6 = this;
                                                var2_4 /* !! */  = new n(this, var11_21, (String)var9_11, (String)var10_12, (byte[])var12_23);
                                                this.a((XMPushService$i)var2_4 /* !! */ );
                                                var1_1 /* !! */  = var1_1 /* !! */ .getAction();
                                                var13_34 = var17_46.equals(var1_1 /* !! */ );
                                                if (var13_34 && (var1_1 /* !! */  = this.a) == null) {
                                                    var1_1 /* !! */  = new XMPushService$e(this);
                                                    this.a = var1_1 /* !! */ ;
                                                    var1_1 /* !! */  = new IntentFilter(var25_55);
                                                    var2_4 /* !! */  = this.a;
                                                    this.registerReceiver((BroadcastReceiver)var2_4 /* !! */ , (IntentFilter)var1_1 /* !! */ );
                                                }
                                            }
                                            break block84;
                                        }
                                        var2_4 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var12_23);
                                        var3_5 = var1_1 /* !! */ .getByteArrayExtra((String)var10_12);
                                        var4_6 = "com.xiaomi.mipush.MESSAGE_CACHE";
                                        var6_8 = (int)var1_1 /* !! */ .getBooleanExtra((String)var4_6, (boolean)var7_9);
                                        var13_35 = var25_55.equals(var1_1 /* !! */  = var1_1 /* !! */ .getAction());
                                        if (var13_35) {
                                            var1_1 /* !! */  = m.a((Context)this);
                                            var1_1 /* !! */ .a((String)var2_4 /* !! */ );
                                        }
                                        this.a((String)var2_4 /* !! */ , (byte[])var3_5, (boolean)var6_8);
                                        break block84;
                                    }
                                    var2_4 /* !! */  = var1_1 /* !! */ .getAction();
                                    var14_41 = var3_5.equals(var2_4 /* !! */ );
                                    if (var14_41 == 0) break block112;
                                    var13_36 = this.i();
                                    if (!var13_36) {
                                        var1_1 /* !! */  = "exit falldown mode, activate alarm.";
                                        com.xiaomi.channel.commonutils.logger.b.a((String)var1_1 /* !! */ );
                                        this.e();
                                        var13_36 = this.c();
                                        if (!var13_36 && !(var13_36 = this.d())) lbl-1000:
                                        // 2 sources

                                        {
                                            while (true) {
                                                this.a((boolean)var7_9);
                                                ** GOTO lbl656
                                                break;
                                            }
                                        }
                                    }
                                    break block84;
                                }
                                var13_37 = var10_12.equals(var1_1 /* !! */  = var1_1 /* !! */ .getAction());
                                if (!var13_37 || !(var13_37 = this.i()) || !(var13_37 = fc.a())) break block84;
                                var1_1 /* !! */  = "enter falldown mode, stop alarm.";
                            }
                            com.xiaomi.channel.commonutils.logger.b.a((String)var1_1 /* !! */ );
                            fc.a();
                            break block84;
                        }
                        var2_4 /* !! */  = at.r;
                        var2_4 /* !! */  = var1_1 /* !! */ .getStringExtra((String)var2_4 /* !! */ );
                        var3_5 = at.v;
                        var5_7 = TextUtils.isEmpty((CharSequence)(var3_5 = var1_1 /* !! */ .getStringExtra((String)var3_5)));
                        if (var5_7 == 0) break block113;
                        var1_1 /* !! */  = "security is empty. ignore.";
                        ** GOTO lbl644
                    }
                    if (var2_4 /* !! */  == null) break block114;
                    var5_7 = this.a((String)var2_4 /* !! */ , var1_1 /* !! */ );
                    var25_56 = this.a((String)var2_4 /* !! */ , var1_1 /* !! */ );
                    var13_38 = com.xiaomi.push.az.b((Context)this);
                    if (!var13_38) {
                        var10_12 = this.a;
                        var16_44 = false;
                        var17_47 = null;
                        var18_49 = 2;
lbl623:
                        // 2 sources

                        while (true) {
                            var12_24 = this;
                            var10_12.a((Context)this, var25_56, var16_44, var18_49, null);
                            break block84;
                            break;
                        }
                    }
                    ** while (!(var13_38 = this.c()))
lbl628:
                    // 1 sources

                    var1_1 /* !! */  = var25_56.a;
                    var2_4 /* !! */  = ap$c.a;
                    if (var1_1 /* !! */  != var2_4 /* !! */ ) break block115;
                    var1_1 /* !! */  = new XMPushService$a(this, var25_56);
                    ** GOTO lbl134
                }
                if (var5_7 != 0) {
                    var1_1 /* !! */  = new XMPushService$n(this, var25_56);
                    ** continue;
                }
                var2_4 /* !! */  = ap$c.b;
                if (var1_1 /* !! */  == var2_4 /* !! */ ) {
                    var1_1 /* !! */  = new Object[var6_8];
                    var1_1 /* !! */ [0] = var2_4 /* !! */  = var25_56.g;
                    var1_1 /* !! */ [var7_9] = var2_4 /* !! */  = ap$b.a(var25_56.b);
                    var2_4 /* !! */  = "the client is binding. %1$s %2$s.";
                    var1_1 /* !! */  = String.format((String)var2_4 /* !! */ , (Object[])var1_1 /* !! */ );
lbl644:
                    // 2 sources

                    com.xiaomi.channel.commonutils.logger.b.a((String)var1_1 /* !! */ );
                } else {
                    var2_4 /* !! */  = ap$c.c;
                    if (var1_1 /* !! */  == var2_4 /* !! */ ) {
                        var10_12 = this.a;
                        var16_44 = true;
                        var18_49 = 0;
                        ** continue;
                    }
                }
                break block84;
            }
            var1_1 /* !! */  = "channel id is empty, do nothing!";
            ** while (true)
        }
        return;
        catch (PackageManager.NameNotFoundException v0) {
            ** continue;
        }
    }

    private void c(XMPushService$i xMPushService$i) {
        this.a.a(xMPushService$i);
    }

    public static /* synthetic */ void c(XMPushService xMPushService) {
        xMPushService.f();
    }

    private void c(boolean bl2) {
        block15: {
            Object object;
            block16: {
                int n10 = t.a();
                if (n10 == 0) break block15;
                if (!bl2) break block16;
                String string2 = "miui.intent.action.NETWORK_CONNECTED";
                object = new Intent(string2);
                this.sendBroadcast((Intent)object);
                object = this.a;
                string2 = null;
                af[] afArray = new af[]{};
                object = object.toArray(afArray);
                object = (af[])object;
                int n11 = ((Object)object).length;
                for (n10 = 0; n10 < n11; ++n10) {
                    Object object2 = object[n10];
                    object2.a();
                    continue;
                }
                break block15;
            }
            String string3 = "miui.intent.action.NETWORK_BLOCKED";
            object = new Intent(string3);
            try {
                this.sendBroadcast((Intent)object);
            }
            catch (Exception exception) {
                com.xiaomi.channel.commonutils.logger.b.a(exception);
            }
        }
    }

    private void d() {
        int n10;
        boolean bl2 = false;
        Object object = null;
        Object object2 = "connectivity";
        object2 = this.getSystemService((String)object2);
        object2 = (ConnectivityManager)object2;
        try {
            object2 = object2.getActiveNetworkInfo();
        }
        catch (Exception exception) {
            com.xiaomi.channel.commonutils.logger.b.a(exception);
            n10 = 0;
            object2 = null;
        }
        if (object2 != null) {
            CharSequence charSequence = "[";
            CharSequence charSequence2 = new StringBuilder((String)charSequence);
            charSequence2.append("type: ");
            String string2 = object2.getTypeName();
            charSequence2.append(string2);
            charSequence2.append((String)charSequence);
            charSequence = object2.getSubtypeName();
            charSequence2.append((String)charSequence);
            charSequence2.append("], state: ");
            charSequence = object2.getState();
            charSequence2.append(charSequence);
            charSequence2.append("/");
            charSequence = object2.getDetailedState();
            charSequence2.append(charSequence);
            charSequence = new StringBuilder();
            string2 = "network changed,";
            ((StringBuilder)charSequence).append(string2);
            charSequence2 = charSequence2.toString();
            ((StringBuilder)charSequence).append((String)charSequence2);
            com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)charSequence).toString());
            object2 = object2.getState();
            charSequence2 = NetworkInfo.State.SUSPENDED;
            if (object2 == charSequence2 || object2 == (charSequence2 = NetworkInfo.State.UNKNOWN)) {
                return;
            }
        } else {
            object2 = "network changed, no active network";
            com.xiaomi.channel.commonutils.logger.b.a((String)object2);
        }
        if ((object2 = he.a()) != null) {
            object2 = he.a();
            ((hd)object2).a();
        }
        gx.a((Context)this);
        object2 = this.a;
        ((fs)object2).d();
        n10 = com.xiaomi.push.az.b((Context)this);
        if (n10 != 0) {
            bl2 = this.c();
            if (bl2 && (bl2 = this.e())) {
                bl2 = false;
                object = null;
                this.b(false);
            }
            if (!(bl2 = this.c()) && !(bl2 = this.d())) {
                object = this.a;
                n10 = 1;
                ((g)object).a(n10);
                object = new XMPushService$d(this);
                this.a((XMPushService$i)object);
            }
            object = di.a((Context)this);
            ((di)object).a();
        } else {
            int n11 = 2;
            object2 = new XMPushService$f(this, n11, null);
            this.a((XMPushService$i)object2);
        }
        this.e();
    }

    private void d(Intent object) {
        block26: {
            int n10;
            String string2;
            Object object2;
            Object object3;
            block25: {
                object3 = this.getApplicationContext();
                object3 = eq.a(object3);
                object2 = new av();
                object3.a((eu)object2);
                object3 = "mipush_app_package";
                string2 = object.getStringExtra((String)object3);
                object3 = "mipush_payload";
                object = object.getByteArrayExtra((String)object3);
                if (object != null) break block25;
                return;
            }
            object3 = new il();
            iw.a((ix)object3, (byte[])object);
            String string3 = object3.b();
            object = object3.a();
            if (object == null) break block26;
            object3 = "extra_help_aw_info";
            Object object4 = object3 = object.get(object3);
            object4 = (String)object3;
            object3 = "extra_aw_app_online_cmd";
            object = object.get(object3);
            object = (String)object;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block26;
            try {
                n10 = Integer.parseInt((String)object);
            }
            catch (NumberFormatException numberFormatException) {
                n10 = 0;
                object = null;
            }
            int n11 = n10;
            n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
            if (n10 != 0) break block26;
            n10 = (int)(TextUtils.isEmpty((CharSequence)string3) ? 1 : 0);
            if (n10 != 0) break block26;
            n10 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
            if (n10 != 0) break block26;
            object = this.getApplicationContext();
            object2 = eq.a((Context)object);
            try {
                ((eq)object2).a((Context)this, (String)object4, n11, string2, string3);
            }
            catch (jc jc2) {
                object3 = new StringBuilder();
                object2 = "aw_logic: translate fail. ";
                object3.append((String)object2);
                String string4 = jc2.getMessage();
                object3.append(string4);
                string4 = object3.toString();
                com.xiaomi.channel.commonutils.logger.b.d(string4);
            }
        }
    }

    private void e() {
        boolean bl2 = this.a();
        if (bl2) {
            bl2 = fc.a();
            if (!bl2) {
                bl2 = true;
                fc.a(bl2);
            }
        } else {
            fc.a();
        }
    }

    private boolean e() {
        long l10 = System.currentTimeMillis();
        long l11 = this.a;
        long l12 = (l10 -= l11) - (l11 = 30000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            return false;
        }
        return com.xiaomi.push.az.c((Context)this);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void f() {
        boolean bl2;
        Object object;
        block6: {
            block5: {
                block4: {
                    object = this.a;
                    if (object == null || !(bl2 = ((fs)object).b())) break block4;
                    object = "try to connect while connecting.";
                    break block5;
                }
                object = this.a;
                if (object == null || !(bl2 = ((fs)object).c())) break block6;
                object = "try to connect while is connected.";
            }
            com.xiaomi.channel.commonutils.logger.b.d((String)object);
            return;
        }
        object = this.a;
        String string2 = com.xiaomi.push.az.a((Context)this);
        ((ft)object).b(string2);
        this.g();
        object = this.a;
        if (object == null) {
            ap.a().a((Context)this);
            bl2 = false;
            object = null;
            this.c(false);
        }
    }

    private boolean f() {
        int n10;
        String string2;
        String string3 = this.getPackageName();
        int n11 = "com.xiaomi.xmsf".equals(string3);
        int n12 = 0;
        if (n11 != 0 && (n11 = Settings.Secure.getInt((ContentResolver)(string3 = this.getContentResolver()), (String)(string2 = "EXTREME_POWER_MODE_ENABLE"), (int)0)) == (n10 = 1)) {
            n12 = n10;
        }
        return n12 != 0;
    }

    private void g() {
        fq fq2 = this.a;
        Object object = this.a;
        bo bo2 = new bo(this);
        fq2.a((fx)object, bo2);
        fq2 = this.a;
        fq2.e();
        fq2 = this.a;
        try {
            this.a = fq2;
        }
        catch (gd gd2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", (Throwable)gd2);
            object = this.a;
            int n10 = 3;
            ((fz)object).b(n10, gd2);
        }
    }

    private boolean g() {
        int n10;
        String string2;
        String string3 = this.getPackageName();
        int n11 = "com.xiaomi.xmsf".equals(string3);
        int n12 = 0;
        if (n11 != 0 && (n11 = Settings.System.getInt((ContentResolver)(string3 = this.getContentResolver()), (String)(string2 = "power_supersave_mode_open"), (int)0)) == (n10 = 1)) {
            n12 = n10;
        }
        return n12 != 0;
    }

    private void h() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11) {
            n10 = d;
            Notification notification = new Notification();
            this.startForeground(n10, notification);
            return;
        }
        Object object = this.a;
        Intent intent = new Intent((Context)this, (Class)object);
        object = new bp(this);
        this.bindService(intent, (ServiceConnection)object, 1);
    }

    private boolean h() {
        String string2 = "com.xiaomi.xmsf";
        Object object = this.getPackageName();
        boolean bl2 = string2.equals(object);
        if (!bl2 && (bl2 = ((m)(object = m.a((Context)this))).b(string2 = this.getPackageName()))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i() {
        ArrayList arrayList = this.a;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.a;
            arrayList2.clear();
            return;
        }
    }

    private boolean i() {
        String string2;
        String string3 = this.getApplicationContext().getPackageName();
        boolean bl2 = string3.equals(string2 = "com.xiaomi.xmsf");
        if (bl2 && (bl2 = this.j()) && !(bl2 = i.b((Context)this)) && !(bl2 = i.a((Context)(string3 = this.getApplicationContext())))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    private boolean j() {
        Comparable<Date> comparable = new Comparable<Date>();
        boolean bl2 = true;
        Object[] objectArray = new Object[bl2];
        objectArray[0] = comparable;
        comparable = Integer.valueOf(String.format("%tH", objectArray));
        int n10 = (Integer)comparable;
        int n11 = this.b;
        int n12 = this.c;
        if (!(n11 > n12 ? n10 >= n11 || n10 < n12 : n11 < n12 && n10 >= n11 && n10 < n12)) {
            bl2 = false;
        }
        return bl2;
    }

    private boolean k() {
        Object object = this.getPackageName();
        boolean bl2 = TextUtils.equals((CharSequence)object, (CharSequence)"com.xiaomi.xmsf");
        if (bl2) {
            return false;
        }
        object = ak.a((Context)this);
        int n10 = hr.H.a();
        return ((ak)object).a(n10, false);
    }

    public fs a() {
        return this.a;
    }

    public d a() {
        d d10 = new d();
        return d10;
    }

    public void a() {
        long l10 = System.currentTimeMillis();
        long l11 = this.a;
        int n10 = fy.a();
        long l12 = (l10 -= l11) - (l11 = (long)n10);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            return;
        }
        object = com.xiaomi.push.az.c((Context)this);
        if (object != false) {
            object = 1;
            this.b((boolean)object);
        }
    }

    public void a(int n10) {
        this.a.a(n10);
    }

    public void a(int n10, Exception exception) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("disconnect ");
        int n11 = this.hashCode();
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(", ");
        Object object2 = this.a;
        if (object2 == null) {
            n11 = 0;
            object2 = null;
        } else {
            n11 = object2.hashCode();
            object2 = n11;
        }
        ((StringBuilder)object).append(object2);
        com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
        object = this.a;
        if (object != null) {
            ((fs)object).b(n10, exception);
            this.a = null;
        }
        this.a(7);
        this.a(4);
        ap.a().a((Context)this, n10);
    }

    public void a(fl object) {
        fs fs2 = this.a;
        if (fs2 != null) {
            fs2.b((fl)object);
            return;
        }
        object = new gd("try send msg while connection is null.");
        throw object;
    }

    public void a(fs object) {
        he.a().a((fs)object);
        boolean bl2 = true;
        this.c(bl2);
        Object object2 = this.a;
        ((az)object2).a();
        boolean bl3 = fc.a();
        if (!bl3 && !(bl3 = this.i())) {
            object2 = "reconnection successful, reactivate alarm.";
            com.xiaomi.channel.commonutils.logger.b.a((String)object2);
            fc.a(bl2);
        }
        object = ap.a().a().iterator();
        while (bl3 = object.hasNext()) {
            object2 = (ap$b)object.next();
            XMPushService$a xMPushService$a = new XMPushService$a(this, (ap$b)object2);
            this.a(xMPushService$a);
        }
    }

    public void a(fs fs2, int n10, Exception exception) {
        hd hd2 = he.a();
        hd2.a(fs2, n10, exception);
        boolean bl2 = this.i();
        if (!bl2) {
            bl2 = false;
            fs2 = null;
            this.a(false);
        }
    }

    public void a(fs fs2, Exception exception) {
        hd hd2 = he.a();
        hd2.a(fs2, exception);
        fs2 = null;
        this.c(false);
        boolean bl2 = this.i();
        if (!bl2) {
            this.a(false);
        }
    }

    public void a(XMPushService$i xMPushService$i) {
        this.a(xMPushService$i, 0L);
    }

    public void a(XMPushService$i xMPushService$i, long l10) {
        g g10 = this.a;
        try {
            g10.a(xMPushService$i, l10);
        }
        catch (IllegalStateException illegalStateException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "can't execute job err = ";
            stringBuilder.append(string2);
            String string3 = illegalStateException.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            com.xiaomi.channel.commonutils.logger.b.a(string3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(XMPushService$l xMPushService$l) {
        ArrayList arrayList = this.a;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.a;
            arrayList2.add(xMPushService$l);
            return;
        }
    }

    public void a(ap$b ap$b) {
        if (ap$b != null) {
            long l10 = ap$b.a();
            Object object = new StringBuilder();
            String string2 = "schedule rebind job in ";
            ((StringBuilder)object).append(string2);
            long l11 = l10 / 1000L;
            ((StringBuilder)object).append(l11);
            com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
            object = new XMPushService$a(this, ap$b);
            this.a((XMPushService$i)object, l10);
        }
    }

    public void a(String string2, String string3, int n10, String string4, String string5) {
        Object object = ap.a();
        ap$b ap$b = ((ap)object).a(string2, string3);
        if (ap$b != null) {
            object = new XMPushService$q(this, ap$b, n10, string5, string4);
            this.a((XMPushService$i)object);
        }
        ap.a().a(string2, string3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(String string2, byte[] byArray, boolean bl2) {
        String string3;
        ap ap2 = ap.a();
        Collection collection = ap2.a(string3 = "5");
        boolean bl3 = collection.isEmpty();
        if (bl3) {
            if (!bl2) return;
        } else {
            ap$c ap$c = ((ap$b)collection.iterator().next()).a;
            ap$c ap$c2 = ap$c.c;
            if (ap$c == ap$c2) {
                int n10 = 4;
                bm bm2 = new bm(this, n10, string2, byArray);
                this.a(bm2);
                return;
            }
            if (!bl2) return;
        }
        com.xiaomi.push.service.o.b(string2, byArray);
    }

    public void a(boolean bl2) {
        this.a.a(bl2);
    }

    /*
     * Loose catch block
     */
    public void a(byte[] object, String string2) {
        block25: {
            Object object2;
            int n10;
            block24: {
                n10 = 70000003;
                if (object == null) {
                    String string3 = "null payload";
                    com.xiaomi.push.service.o.a((Context)this, string2, object, n10, string3);
                    object = "register request without payload";
                    com.xiaomi.channel.commonutils.logger.b.a((String)object);
                } else {
                    object2 = new ii();
                    iw.a((ix)object2, object);
                    Object object3 = ((ii)object2).a;
                    Object object4 = hm.a;
                    if (object3 != object4) break block24;
                    object3 = new im();
                    object4 = ((ii)object2).a();
                    iw.a((ix)object3, (byte[])object4);
                    object4 = ((ii)object2).b();
                    com.xiaomi.push.service.o.a((String)object4, object);
                    String string4 = ((ii)object2).b();
                    String string5 = ((im)object3).b();
                    String string6 = ((im)object3).c();
                    Object object5 = object4;
                    Object object6 = this;
                    object4 = new n(this, string4, string5, string6, (byte[])object);
                    this.a((XMPushService$i)object4);
                    object4 = this.getApplicationContext();
                    object5 = fb.a((Context)object4);
                    object6 = ((ii)object2).b();
                    string4 = "E100003";
                    string5 = ((im)object3).a();
                    int n11 = 6002;
                    try {
                        ((fb)object5).a((String)object6, string4, string5, n11, null);
                    }
                    catch (jc jc2) {
                        com.xiaomi.channel.commonutils.logger.b.a(jc2);
                        object2 = " data action error.";
                        com.xiaomi.push.service.o.a((Context)this, string2, object, n10, (String)object2);
                    }
                }
                break block25;
            }
            object2 = " registration action required.";
            com.xiaomi.push.service.o.a((Context)this, string2, object, n10, (String)object2);
            object2 = "register request with invalid payload";
            com.xiaomi.channel.commonutils.logger.b.a((String)object2);
            {
                catch (jc jc3) {
                    com.xiaomi.channel.commonutils.logger.b.a(jc3);
                    object2 = " data container error.";
                    com.xiaomi.push.service.o.a((Context)this, string2, object, n10, (String)object2);
                }
            }
        }
    }

    public void a(fl[] object) {
        fs fs2 = this.a;
        if (fs2 != null) {
            fs2.a((fl[])object);
            return;
        }
        object = new gd("try send msg while connection is null.");
        throw object;
    }

    public boolean a() {
        ap ap2;
        int n10 = com.xiaomi.push.az.b((Context)this);
        if (n10 != 0 && (n10 = (ap2 = ap.a()).a()) > 0 && (n10 = (int)(this.b() ? 1 : 0)) == 0 && (n10 = (int)(this.h() ? 1 : 0)) != 0 && (n10 = (int)(this.g() ? 1 : 0)) == 0 && (n10 = (int)(this.f() ? 1 : 0)) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            ap2 = null;
        }
        return n10 != 0;
    }

    public boolean a(int n10) {
        return this.a.a(n10);
    }

    public d b() {
        return this.a;
    }

    public void b() {
        boolean bl2;
        Object object = this.a;
        Object object2 = new ArrayList(object);
        object2 = ((ArrayList)object2).iterator();
        while (bl2 = object2.hasNext()) {
            object = (XMPushService$l)object2.next();
            object.a();
        }
    }

    public void b(fs fs2) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        he.a().b(fs2);
    }

    public void b(XMPushService$i xMPushService$i) {
        g g10 = this.a;
        int n10 = xMPushService$i.a;
        g10.a(n10, xMPushService$i);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean b() {
        Object object;
        boolean bl2 = false;
        Object object2 = "miui.os.Build";
        try {
            object2 = t.a((Context)this, (String)object2);
            object = "IS_CM_CUSTOMIZATION_TEST";
        }
        catch (Throwable throwable) {
            return bl2;
        }
        object = ((Class)object2).getField((String)object);
        Object object3 = "IS_CU_CUSTOMIZATION_TEST";
        object3 = ((Class)object2).getField((String)object3);
        String string2 = "IS_CT_CUSTOMIZATION_TEST";
        object2 = ((Class)object2).getField(string2);
        string2 = null;
        boolean bl3 = ((Field)object).getBoolean(null);
        if (bl3) return true;
        bl3 = ((Field)object3).getBoolean(null);
        if (bl3) return true;
        boolean bl4 = ((Field)object2).getBoolean(null);
        if (!bl4) return bl2;
        return true;
    }

    public boolean c() {
        boolean bl2;
        fs fs2 = this.a;
        if (fs2 != null && (bl2 = fs2.c())) {
            bl2 = true;
        } else {
            bl2 = false;
            fs2 = null;
        }
        return bl2;
    }

    public boolean d() {
        boolean bl2;
        fs fs2 = this.a;
        if (fs2 != null && (bl2 = fs2.b())) {
            bl2 = true;
        } else {
            bl2 = false;
            fs2 = null;
        }
        return bl2;
    }

    public IBinder onBind(Intent intent) {
        return this.a.getBinder();
    }

    public void onCreate() {
        Object object;
        super.onCreate();
        t.a((Context)this);
        Object object2 = com.xiaomi.push.service.l.a((Context)this);
        if (object2 != null) {
            object = ((k)object2).a;
            ab.a(object);
        }
        Object object3 = new bq(this);
        object2 = new Messenger((Handler)object3);
        this.a = object2;
        au.a(this);
        Object object4 = null;
        int n10 = 5222;
        String string2 = "xiaomi.com";
        Object object5 = object2;
        Object object6 = this;
        this.a = object2 = new br(this, null, n10, string2, null);
        int n11 = 1;
        ((ft)object2).a(n11 != 0);
        object5 = this.a;
        this.a = object2 = new fq(this, (ft)object5);
        this.a = object2 = this.a();
        fc.a((Context)this);
        this.a.a(this);
        this.a = object2 = new com.xiaomi.push.service.ao(this);
        this.a = object2 = new az(this);
        object2 = new e();
        ((e)object2).a();
        he.a().a(this);
        this.a = object2 = new g("Connection Controller Thread");
        object2 = ap.a();
        ((ap)object2).b();
        object5 = new bs(this);
        ((ap)object2).a((ap$a)object5);
        object = this.k();
        if (object != 0) {
            this.h();
        }
        object2 = hk.a((Context)this);
        object5 = new com.xiaomi.push.service.i(this);
        object6 = "UPLOADER_PUSH_CHANNEL";
        ((hk)object2).a((hl)object5, (String)object6);
        object2 = new hh((Context)this);
        this.a((XMPushService$l)object2);
        object2 = new XMPushService$g(this);
        this.a((XMPushService$i)object2);
        object2 = this.a;
        object5 = bg.a((Context)this);
        object2.add(object5);
        object = this.h();
        if (object != 0) {
            object2 = new XMPushService$e(this);
            this.a = object2;
            object2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            object5 = this.a;
            this.registerReceiver((BroadcastReceiver)object5, (IntentFilter)object2);
        }
        if ((object = (Object)((String)(object5 = "com.xiaomi.xmsf")).equals(object2 = this.getPackageName())) != 0) {
            Looper looper;
            object2 = Settings.Secure.getUriFor((String)"EXTREME_POWER_MODE_ENABLE");
            Object object7 = false;
            object5 = null;
            if (object2 != null) {
                looper = Looper.getMainLooper();
                object4 = new Handler(looper);
                object6 = new bt(this, (Handler)object4);
                this.a = object6;
                object6 = this.getContentResolver();
                object4 = this.a;
                try {
                    object6.registerContentObserver((Uri)object2, false, (ContentObserver)object4);
                }
                catch (Throwable throwable) {
                    object6 = new StringBuilder();
                    object4 = "register observer err:";
                    ((StringBuilder)object6).append((String)object4);
                    object2 = throwable.getMessage();
                    ((StringBuilder)object6).append((String)object2);
                    object2 = ((StringBuilder)object6).toString();
                    com.xiaomi.channel.commonutils.logger.b.a((String)object2);
                }
            }
            if ((object2 = Settings.System.getUriFor((String)"power_supersave_mode_open")) != null) {
                looper = Looper.getMainLooper();
                object4 = new Handler(looper);
                object6 = new bu(this, (Handler)object4);
                this.b = object6;
                object6 = this.getContentResolver();
                object4 = this.b;
                try {
                    object6.registerContentObserver((Uri)object2, false, (ContentObserver)object4);
                }
                catch (Throwable throwable) {
                    object6 = new StringBuilder();
                    object4 = "register super-power-mode observer err:";
                    ((StringBuilder)object6).append((String)object4);
                    object2 = throwable.getMessage();
                    ((StringBuilder)object6).append((String)object2);
                    object2 = ((StringBuilder)object6).toString();
                    com.xiaomi.channel.commonutils.logger.b.d((String)object2);
                }
            }
            if ((object2 = (Object)this.a()) != null) {
                object6 = new XMPushService$p(this);
                this.a = object6;
                object6 = new IntentFilter();
                object6.addAction("android.intent.action.SCREEN_ON");
                object6.addAction("android.intent.action.SCREEN_OFF");
                object4 = this.a;
                this.registerReceiver((BroadcastReceiver)object4, (IntentFilter)object6);
                object7 = object2[0];
                this.b = object7;
                this.c = object = (Object)object2[n11];
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("falldown initialized: ");
                n11 = this.b;
                ((StringBuilder)object2).append(n11);
                object3 = ",";
                ((StringBuilder)object2).append((String)object3);
                n11 = this.c;
                ((StringBuilder)object2).append(n11);
                object2 = ((StringBuilder)object2).toString();
                com.xiaomi.channel.commonutils.logger.b.a((String)object2);
            }
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("XMPushService created pid = ");
        n11 = d;
        ((StringBuilder)object2).append(n11);
        com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object2).toString());
    }

    public void onDestroy() {
        CharSequence charSequence;
        boolean bl2;
        Object object = this.a;
        CharSequence charSequence2 = null;
        if (object != null) {
            this.a((BroadcastReceiver)object);
            this.a = null;
        }
        if ((object = this.a) != null) {
            this.a((BroadcastReceiver)object);
            this.a = null;
        }
        if ((bl2 = ((String)(charSequence2 = "com.xiaomi.xmsf")).equals(object = this.getPackageName())) && (object = this.a) != null) {
            object = this.getContentResolver();
            charSequence = this.a;
            try {
                object.unregisterContentObserver((ContentObserver)charSequence);
            }
            catch (Throwable throwable) {
                charSequence = new StringBuilder();
                String string2 = "unregister observer err:";
                ((StringBuilder)charSequence).append(string2);
                object = throwable.getMessage();
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                com.xiaomi.channel.commonutils.logger.b.a((String)object);
            }
        }
        if ((bl2 = ((String)charSequence2).equals(object = this.getPackageName())) && (object = this.b) != null) {
            object = this.getContentResolver();
            charSequence2 = this.b;
            try {
                object.unregisterContentObserver((ContentObserver)charSequence2);
            }
            catch (Throwable throwable) {
                charSequence2 = new StringBuilder();
                charSequence = "unregister super-power-mode err:";
                ((StringBuilder)charSequence2).append((String)charSequence);
                object = throwable.getMessage();
                ((StringBuilder)charSequence2).append((String)object);
                object = ((StringBuilder)charSequence2).toString();
                com.xiaomi.channel.commonutils.logger.b.d((String)object);
            }
        }
        this.a.clear();
        this.a.b();
        object = new bn(this, 2);
        this.a((XMPushService$i)object);
        object = new XMPushService$j(this);
        this.a((XMPushService$i)object);
        ap.a().b();
        ap.a().a((Context)this, 15);
        ap.a().a();
        this.a.b(this);
        be.a().a();
        fc.a();
        this.i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.a("Service destroyed");
    }

    /*
     * Unable to fully structure code
     */
    public void onStart(Intent var1_1, int var2_2) {
        block5: {
            block6: {
                var3_3 = System.currentTimeMillis();
                if (var1_1 == null) {
                    var5_4 = "onStart() with intent NULL";
                    com.xiaomi.channel.commonutils.logger.b.d((String)var5_4);
                } else {
                    var2_2 = 5;
                    var5_4 = new Object[var2_2];
                    var6_5 = var1_1.getAction();
                    var5_4[0] = var6_5;
                    var6_5 = at.r;
                    var6_5 = var1_1.getStringExtra(var6_5);
                    var5_4[1] = var6_5;
                    var6_5 = at.z;
                    var6_5 = var1_1.getStringExtra(var6_5);
                    var5_4[2] = var6_5;
                    var6_5 = var1_1.getStringExtra("mipush_app_package");
                    var5_4[3] = var6_5;
                    var7_6 = 4;
                    var6_5 = var1_1.getStringExtra("ext_is_xmpushservice_bridge");
                    var5_4[var7_6] = var6_5;
                    var8_7 = "onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, from-bridge = %s";
                    var5_4 = String.format(var8_7, (Object[])var5_4);
                    com.xiaomi.channel.commonutils.logger.b.c((String)var5_4);
                }
                if (var1_1 == null || (var5_4 = var1_1.getAction()) == null) break block5;
                var8_7 = "com.xiaomi.push.timer";
                var5_4 = var1_1.getAction();
                var2_2 = (int)var8_7.equalsIgnoreCase((String)var5_4);
                if (var2_2 != 0 || (var2_2 = (int)(var8_7 = "com.xiaomi.push.check_alive").equalsIgnoreCase((String)(var5_4 = var1_1.getAction()))) != 0) break block6;
                var8_7 = "com.xiaomi.push.network_status_changed";
                var5_4 = var1_1.getAction();
                var2_2 = (int)var8_7.equalsIgnoreCase((String)var5_4);
                if (var2_2 != 0) break block5;
                var5_4 = new XMPushService$h(this, (Intent)var1_1);
                ** GOTO lbl46
            }
            var5_4 = this.a;
            var2_2 = (int)var5_4.a();
            if (var2_2 != 0) {
                com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                var1_1 = ap.a();
                var2_2 = 14;
                var1_1.a((Context)this, var2_2);
                this.stopSelf();
            } else {
                var5_4 = new XMPushService$h(this, (Intent)var1_1);
lbl46:
                // 2 sources

                this.a((XMPushService$i)var5_4);
            }
        }
        if ((var11_9 = (cfr_temp_0 = (var9_8 = System.currentTimeMillis() - var3_3) - (var3_3 = (long)50)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) > 0) {
            var12_10 = new StringBuilder();
            var13_11 = "[Prefs] spend ";
            var12_10.append(var13_11);
            var12_10.append(var9_8);
            var12_10.append(" ms, too more times.");
            var1_1 = var12_10.toString();
            com.xiaomi.channel.commonutils.logger.b.c((String)var1_1);
        }
    }

    public int onStartCommand(Intent intent, int n10, int n11) {
        this.onStart(intent, n11);
        return a;
    }
}

