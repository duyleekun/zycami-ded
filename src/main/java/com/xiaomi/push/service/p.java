/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  org.json.JSONException
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.df;
import com.xiaomi.push.fb;
import com.xiaomi.push.fl;
import com.xiaomi.push.g;
import com.xiaomi.push.gd;
import com.xiaomi.push.gg;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gx;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ic;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.aa$c;
import com.xiaomi.push.service.ac;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.k;
import com.xiaomi.push.service.l;
import com.xiaomi.push.service.m;
import com.xiaomi.push.service.q;
import com.xiaomi.push.service.r;
import com.xiaomi.push.service.s;
import com.xiaomi.push.service.u;
import com.xiaomi.push.service.v;
import com.xiaomi.push.service.w;
import com.xiaomi.push.t;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class p {
    public static Intent a(byte[] object, long l10) {
        ii ii2 = p.a(object);
        if (ii2 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", object);
        object = Long.toString(l10);
        intent.putExtra("mrt", (String)object);
        object = ii2.b;
        intent.setPackage((String)object);
        return intent;
    }

    public static ii a(Context object, ii cloneable) {
        Object object2;
        Object object3 = new ic();
        Object object4 = ((ii)cloneable).a();
        ((ic)object3).b((String)object4);
        object4 = ((ii)cloneable).a();
        if (object4 != null) {
            object2 = ((hz)object4).a();
            ((ic)object3).a((String)object2);
            long l10 = ((hz)object4).a();
            ((ic)object3).a(l10);
            object2 = ((hz)object4).b();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                object4 = ((hz)object4).b();
                ((ic)object3).c((String)object4);
            }
        }
        short s10 = iw.a((Context)object, (ii)cloneable);
        ((ic)object3).a(s10);
        object = ((ii)cloneable).b();
        object4 = ((ii)cloneable).a();
        object2 = hm.f;
        object = w.a((String)object, (String)object4, (ix)object3, (hm)((Object)object2));
        cloneable = ((ii)cloneable).a().a();
        object3 = Long.toString(System.currentTimeMillis());
        ((hz)cloneable).a("mat", (String)object3);
        ((ii)object).a((hz)cloneable);
        return object;
    }

    public static ii a(byte[] byArray) {
        ii ii2 = new ii();
        try {
            iw.a(ii2, byArray);
            return ii2;
        }
        catch (Throwable throwable) {
            b.a(throwable);
            return null;
        }
    }

    private static void a(XMPushService xMPushService, ii ii2) {
        q q10 = new q(4, xMPushService, ii2);
        xMPushService.a(q10);
    }

    private static void a(XMPushService xMPushService, ii ii2, String string2) {
        u u10 = new u(4, xMPushService, ii2, string2);
        xMPushService.a(u10);
    }

    private static void a(XMPushService xMPushService, ii ii2, String string2, String string3) {
        v v10 = new v(4, xMPushService, ii2, string2, string3);
        xMPushService.a(v10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(XMPushService xMPushService, String string2, byte[] byArray, Intent intent) {
        Object object;
        hz hz2;
        ii ii2;
        Object object2;
        XMPushService xMPushService2;
        block31: {
            boolean bl2;
            Object object3;
            block33: {
                block35: {
                    block36: {
                        void var13_86;
                        void var12_71;
                        void var11_54;
                        int n10;
                        CharSequence charSequence;
                        block38: {
                            block41: {
                                void var13_88;
                                void var12_73;
                                void var11_56;
                                block40: {
                                    block39: {
                                        block37: {
                                            boolean bl3;
                                            block34: {
                                                String string3;
                                                boolean bl4;
                                                boolean bl5;
                                                block32: {
                                                    String string4;
                                                    Map map;
                                                    int n11;
                                                    String string5;
                                                    String string6;
                                                    long l10;
                                                    String string7;
                                                    int n12;
                                                    String string8;
                                                    String string9;
                                                    String string10;
                                                    int n13;
                                                    int n14;
                                                    xMPushService2 = xMPushService;
                                                    byte[] byArray2 = byArray;
                                                    object2 = intent;
                                                    ii2 = p.a(byArray);
                                                    hz2 = ii2.a();
                                                    boolean bl6 = false;
                                                    object = null;
                                                    if (byArray != null) {
                                                        String string11 = ii2.b();
                                                        Context context = xMPushService.getApplicationContext();
                                                        hm hm2 = ii2.a();
                                                        n14 = byArray.length;
                                                        df.a(string11, context, null, hm2, n14);
                                                    }
                                                    if ((n13 = p.c(ii2)) != 0 && (n13 = p.a((Context)xMPushService, string2)) != 0) {
                                                        boolean bl7 = aa.e(ii2);
                                                        if (bl7) {
                                                            object2 = fb.a(xMPushService.getApplicationContext());
                                                            object = ii2.b();
                                                            String string12 = aa.b(ii2);
                                                            String string13 = hz2.a();
                                                            String string14 = "5";
                                                            ((fb)object2).a((String)object, string12, string13, string14);
                                                        }
                                                        p.c(xMPushService2, ii2);
                                                        return;
                                                    }
                                                    n13 = p.a(ii2);
                                                    if (n13 != 0 && (n13 = p.a((Context)xMPushService, string2)) == 0 && (n13 = p.b(ii2)) == 0) {
                                                        boolean bl8 = aa.e(ii2);
                                                        if (bl8) {
                                                            object2 = fb.a(xMPushService.getApplicationContext());
                                                            object = ii2.b();
                                                            String string15 = aa.b(ii2);
                                                            String string16 = hz2.a();
                                                            String string17 = "6";
                                                            ((fb)object2).a((String)object, string15, string16, string17);
                                                        }
                                                        p.d(xMPushService2, ii2);
                                                        return;
                                                    }
                                                    n13 = aa.a(ii2);
                                                    if ((n13 == 0 || (n13 = g.b((Context)xMPushService2, string10 = ii2.b)) == 0) && (n13 = p.a((Context)xMPushService2, (Intent)object2)) == 0) break block31;
                                                    hm hm3 = hm.a;
                                                    hm hm4 = ii2.a();
                                                    String string18 = "eventMessageType";
                                                    charSequence = "messageId";
                                                    if (hm3 == hm4) {
                                                        string9 = ii2.b();
                                                        SharedPreferences.Editor editor = xMPushService2.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                                                        String string19 = ii2.a;
                                                        editor.putString(string9, string19);
                                                        editor.commit();
                                                        object3 = fb.a(xMPushService.getApplicationContext());
                                                        string8 = hz2.a();
                                                        n12 = 6003;
                                                        string7 = "E100003";
                                                        ((fb)object3).a(string9, string7, string8, n12, null);
                                                        String string20 = hz2.a();
                                                        n13 = (int)(TextUtils.isEmpty((CharSequence)string20) ? 1 : 0);
                                                        if (n13 == 0) {
                                                            String string21 = hz2.a();
                                                            object2.putExtra((String)charSequence, string21);
                                                            n13 = 6000;
                                                            object2.putExtra(string18, n13);
                                                        }
                                                    }
                                                    if ((n13 = aa.c(ii2)) != 0) {
                                                        object3 = fb.a(xMPushService.getApplicationContext());
                                                        string9 = ii2.b();
                                                        string7 = aa.b(ii2);
                                                        string8 = hz2.a();
                                                        n12 = 1001;
                                                        l10 = System.currentTimeMillis();
                                                        ((fb)object3).a(string9, string7, string8, n12, l10, null);
                                                        String string22 = hz2.a();
                                                        n13 = TextUtils.isEmpty((CharSequence)string22);
                                                        if (n13 == 0) {
                                                            String string23 = hz2.a();
                                                            object2.putExtra((String)charSequence, string23);
                                                            n13 = 1000;
                                                            object2.putExtra(string18, n13);
                                                        }
                                                    }
                                                    if ((n13 = aa.b(ii2)) != 0) {
                                                        object3 = fb.a(xMPushService.getApplicationContext());
                                                        string9 = ii2.b();
                                                        string7 = aa.b(ii2);
                                                        string8 = hz2.a();
                                                        n12 = 2001;
                                                        l10 = System.currentTimeMillis();
                                                        ((fb)object3).a(string9, string7, string8, n12, l10, null);
                                                        String string24 = hz2.a();
                                                        n13 = (int)(TextUtils.isEmpty((CharSequence)string24) ? 1 : 0);
                                                        if (n13 == 0) {
                                                            String string25 = hz2.a();
                                                            object2.putExtra((String)charSequence, string25);
                                                            n13 = 2000;
                                                            object2.putExtra(string18, n13);
                                                        }
                                                    }
                                                    if ((n13 = aa.a(ii2)) != 0) {
                                                        object3 = fb.a(xMPushService.getApplicationContext());
                                                        string9 = ii2.b();
                                                        string7 = aa.b(ii2);
                                                        string8 = hz2.a();
                                                        n12 = 3001;
                                                        l10 = System.currentTimeMillis();
                                                        ((fb)object3).a(string9, string7, string8, n12, l10, null);
                                                        String string26 = hz2.a();
                                                        n13 = (int)(TextUtils.isEmpty((CharSequence)string26) ? 1 : 0);
                                                        if (n13 == 0) {
                                                            String string27 = hz2.a();
                                                            object2.putExtra((String)charSequence, string27);
                                                            n13 = 3000;
                                                            object2.putExtra(string18, n13);
                                                        }
                                                    }
                                                    object3 = "com.xiaomi.xmsf";
                                                    if (hz2 == null || (n13 = TextUtils.isEmpty((CharSequence)(string6 = hz2.c()))) != 0 || (n13 = TextUtils.isEmpty((CharSequence)(string5 = hz2.d()))) != 0 || (n13 = hz2.b) == (n11 = 1) || (n13 = (int)(aa.a(map = hz2.a()) ? 1 : 0)) == 0 && (n13 = (int)(aa.a((Context)xMPushService2, string4 = ii2.b) ? 1 : 0)) != 0) break block32;
                                                    if (hz2 != null) {
                                                        object2 = hz2.a;
                                                        if (object2 != null) {
                                                            object = object2 = object2.get("jobkey");
                                                            object = (String)object2;
                                                        }
                                                        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
                                                            object = object2 = hz2.a();
                                                        }
                                                        object2 = ii2.b;
                                                        bl2 = ac.a(xMPushService2, (String)object2, (String)object);
                                                    } else {
                                                        bl2 = false;
                                                        object2 = null;
                                                    }
                                                    if (bl2) {
                                                        object2 = fb.a(xMPushService.getApplicationContext());
                                                        String string28 = ii2.b();
                                                        String string29 = aa.b(ii2);
                                                        String string30 = hz2.a();
                                                        charSequence = new StringBuilder();
                                                        String string31 = "1:";
                                                        ((StringBuilder)charSequence).append(string31);
                                                        ((StringBuilder)charSequence).append((String)object);
                                                        charSequence = ((StringBuilder)charSequence).toString();
                                                        ((fb)object2).c(string28, string29, string30, (String)charSequence);
                                                        object2 = new StringBuilder();
                                                        String string32 = "drop a duplicate message, key=";
                                                        ((StringBuilder)object2).append(string32);
                                                        ((StringBuilder)object2).append((String)object);
                                                        object2 = ((StringBuilder)object2).toString();
                                                        b.a((String)object2);
                                                    } else {
                                                        boolean bl9;
                                                        object2 = aa.a((Context)xMPushService2, ii2, byArray2);
                                                        long l11 = ((aa$c)object2).a;
                                                        long l12 = 0L;
                                                        long l13 = l11 - l12;
                                                        Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                                                        if (object4 > 0 && !(bl9 = TextUtils.isEmpty((CharSequence)(object = ((aa$c)object2).a)))) {
                                                            object = ((aa$c)object2).a;
                                                            long l14 = ((aa$c)object2).a;
                                                            boolean bl10 = true;
                                                            n14 = 0;
                                                            charSequence = null;
                                                            long l15 = System.currentTimeMillis();
                                                            object2 = xMPushService;
                                                            gx.a((Context)xMPushService, (String)object, l14, bl10, false, l15);
                                                        }
                                                        if (!(bl2 = aa.a(ii2))) {
                                                            object2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                                                            object2.putExtra("mipush_payload", byArray2);
                                                            object = ii2.b;
                                                            object2.setPackage((String)object);
                                                            try {
                                                                boolean bl11;
                                                                object = xMPushService.getPackageManager();
                                                                object = object.queryBroadcastReceivers((Intent)object2, 0);
                                                                if (object != null && !(bl11 = object.isEmpty())) {
                                                                    object = ii2.b;
                                                                    object = w.a((String)object);
                                                                    xMPushService2.sendBroadcast((Intent)object2, (String)object);
                                                                }
                                                            }
                                                            catch (Exception exception) {
                                                                object = w.a(ii2.b);
                                                                xMPushService2.sendBroadcast((Intent)object2, (String)object);
                                                                object2 = fb.a(xMPushService.getApplicationContext());
                                                                object = ii2.b();
                                                                String string33 = aa.b(ii2);
                                                                String string34 = hz2.a();
                                                                String string35 = "1";
                                                                ((fb)object2).b((String)object, string33, string34, string35);
                                                            }
                                                        }
                                                    }
                                                    p.b(xMPushService2, ii2);
                                                    break block33;
                                                }
                                                object = ii2.b;
                                                boolean bl12 = ((String)object3).contains((CharSequence)object);
                                                if (!bl12 || (bl5 = ii2.b()) || hz2 == null || (object = hz2.a()) == null || !(bl4 = (object = hz2.a()).containsKey(string3 = "ab"))) break block34;
                                                p.b(xMPushService2, ii2);
                                                object2 = new StringBuilder();
                                                ((StringBuilder)object2).append("receive abtest message. ack it.");
                                                object = hz2.a();
                                                ((StringBuilder)object2).append((String)object);
                                                object2 = ((StringBuilder)object2).toString();
                                                b.c((String)object2);
                                                break block33;
                                            }
                                            object = string2;
                                            boolean bl13 = p.a(xMPushService2, string2, ii2, hz2);
                                            if (!bl13) break block35;
                                            if (hz2 == null || (bl3 = TextUtils.isEmpty((CharSequence)(object = hz2.a())))) break block36;
                                            boolean bl14 = aa.b(ii2);
                                            if (!bl14) break block37;
                                            object = xMPushService.getApplicationContext();
                                            fb fb2 = fb.a((Context)object);
                                            String string36 = ii2.b();
                                            String string37 = aa.b(ii2);
                                            charSequence = hz2.a();
                                            n10 = 2002;
                                            break block38;
                                        }
                                        boolean bl15 = aa.a(ii2);
                                        if (!bl15) break block39;
                                        object = fb.a(xMPushService.getApplicationContext());
                                        String string38 = ii2.b();
                                        String string39 = aa.b(ii2);
                                        String string40 = hz2.a();
                                        charSequence = "7";
                                        break block40;
                                    }
                                    boolean bl16 = aa.c(ii2);
                                    if (!bl16) break block41;
                                    object = fb.a(xMPushService.getApplicationContext());
                                    String string41 = ii2.b();
                                    String string42 = aa.b(ii2);
                                    String string43 = hz2.a();
                                    charSequence = "8";
                                }
                                ((fb)object).a((String)var11_56, (String)var12_73, (String)var13_88, (String)charSequence);
                                break block36;
                            }
                            boolean bl17 = aa.d(ii2);
                            if (!bl17) break block36;
                            object = xMPushService.getApplicationContext();
                            fb fb3 = fb.a((Context)object);
                            String string44 = ii2.b();
                            charSequence = hz2.a();
                            n10 = 6004;
                            String string45 = "E100003";
                        }
                        var11_54.a((String)var12_71, (String)var13_86, (String)charSequence, n10, null);
                    }
                    object = w.a(ii2.b);
                    xMPushService2.sendBroadcast((Intent)object2, (String)object);
                    break block33;
                }
                object2 = fb.a(xMPushService.getApplicationContext());
                object = ii2.b();
                String string46 = aa.b(ii2);
                String string47 = hz2.a();
                String string48 = "9";
                ((fb)object2).a((String)object, string46, string47, string48);
            }
            object2 = ii2.a();
            object = hm.b;
            if (object2 != object) return;
            object2 = xMPushService.getPackageName();
            bl2 = ((String)object3).equals(object2);
            if (bl2) return;
            xMPushService.stopSelf();
            return;
        }
        object2 = ii2.b;
        boolean bl18 = g.b((Context)xMPushService2, (String)object2);
        if (bl18) {
            object2 = "receive a mipush message, we can see the app, but we can't see the receiver.";
            b.a((String)object2);
            bl18 = aa.e(ii2);
            if (!bl18) return;
            object2 = fb.a(xMPushService.getApplicationContext());
            object = ii2.b();
            String string49 = aa.b(ii2);
            String string50 = hz2.a();
            String string51 = "3";
            ((fb)object2).b((String)object, string49, string50, string51);
            return;
        }
        bl18 = aa.e(ii2);
        if (bl18) {
            object2 = fb.a(xMPushService.getApplicationContext());
            object = ii2.b();
            String string52 = aa.b(ii2);
            String string53 = hz2.a();
            String string54 = "2";
            ((fb)object2).b((String)object, string52, string53, string54);
        }
        p.a(xMPushService2, ii2);
    }

    private static void a(XMPushService object, byte[] object2, long l10) {
        boolean bl2;
        int n10;
        Object object3;
        Object object4 = p.a((byte[])object2);
        if (object4 == null) {
            return;
        }
        Object object5 = ((ii)object4).b;
        int n11 = (int)(TextUtils.isEmpty((CharSequence)object5) ? 1 : 0);
        if (n11 != 0) {
            b.a("receive a mipush message without package name");
            return;
        }
        long l11 = System.currentTimeMillis();
        object5 = l11;
        long l12 = (Long)object5;
        Object object6 = p.a((byte[])object2, l12);
        String string2 = aa.a((ii)object4);
        boolean bl3 = true;
        boolean bl4 = true;
        long l13 = System.currentTimeMillis();
        Object object7 = object;
        String string3 = string2;
        gx.a((Context)object, string2, l10, bl3, bl4, l13);
        Object object8 = ((ii)object4).a();
        if (object8 != null) {
            long l14 = (Long)object5;
            object3 = Long.toString(l14);
            object5 = "mrt";
            ((hz)object8).a((String)object5, (String)object3);
        }
        object3 = hm.e;
        object5 = ((ii)object4).a();
        object7 = "";
        if (object3 == object5 && (n11 = ((m)(object5 = m.a((Context)object))).a(string3 = ((ii)object4).b)) != 0 && (n11 = aa.a((ii)object4)) == 0) {
            if (object8 != null) {
                object7 = ((hz)object8).a();
                boolean bl5 = aa.e((ii)object4);
                if (bl5) {
                    object2 = fb.a(object.getApplicationContext());
                    object8 = ((ii)object4).b();
                    object3 = aa.b((ii)object4);
                    object5 = "1";
                    ((fb)object2).a((String)object8, (String)object3, (String)object7, (String)object5);
                }
            }
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            ((StringBuilder)object2).append("Drop a message for unregistered, msgid=");
            ((StringBuilder)object2).append((String)object7);
            b.a(((StringBuilder)object2).toString());
            object2 = ((ii)object4).b;
            p.a((XMPushService)object, (ii)object4, (String)object2);
            return;
        }
        object5 = ((ii)object4).a();
        if (object3 == object5 && (n11 = ((m)(object5 = m.a((Context)object))).c(string3 = ((ii)object4).b)) != 0 && (n11 = aa.a((ii)object4)) == 0) {
            if (object8 != null) {
                object7 = ((hz)object8).a();
                boolean bl6 = aa.e((ii)object4);
                if (bl6) {
                    object2 = fb.a(object.getApplicationContext());
                    object8 = ((ii)object4).b();
                    object3 = aa.b((ii)object4);
                    object5 = "2";
                    ((fb)object2).a((String)object8, (String)object3, (String)object7, (String)object5);
                }
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Drop a message for push closed, msgid=");
            ((StringBuilder)object2).append((String)object7);
            b.a(((StringBuilder)object2).toString());
            object2 = ((ii)object4).b;
            p.a((XMPushService)object, (ii)object4, (String)object2);
            return;
        }
        object5 = ((ii)object4).a();
        if (object3 == object5 && (n10 = TextUtils.equals((CharSequence)(object3 = object.getPackageName()), (CharSequence)(object5 = "com.xiaomi.xmsf"))) == 0 && (n10 = (int)(TextUtils.equals((CharSequence)(object3 = object.getPackageName()), (CharSequence)(object5 = ((ii)object4).b)) ? 1 : 0)) == 0) {
            boolean bl7;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Receive a message with wrong package name, expect ");
            object3 = object.getPackageName();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(", received ");
            object3 = ((ii)object4).b;
            ((StringBuilder)object2).append((String)object3);
            b.a(((StringBuilder)object2).toString());
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("package should be ");
            object3 = object.getPackageName();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(", but got ");
            object3 = ((ii)object4).b;
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            object3 = "unmatched_package";
            p.a((XMPushService)object, (ii)object4, (String)object3, (String)object2);
            if (object8 != null && (bl7 = aa.e((ii)object4))) {
                object = fb.a(object.getApplicationContext());
                object2 = ((ii)object4).b();
                object3 = aa.b((ii)object4);
                object8 = ((hz)object8).a();
                object4 = "3";
                ((fb)object).a((String)object2, (String)object3, (String)object8, (String)object4);
            }
            return;
        }
        if (object8 != null && (object3 = ((hz)object8).a()) != null) {
            n10 = 2;
            object3 = new Object[n10];
            object3[0] = object7 = ((ii)object4).a();
            n11 = 1;
            object3[n11] = object7 = ((hz)object8).a();
            object5 = "receive a message, appid=%1$s, msgid= %2$s";
            object3 = String.format((String)object5, (Object[])object3);
            b.a((String)object3);
        }
        if (object8 != null && (object3 = ((hz)object8).a()) != null && (bl2 = object3.containsKey(object5 = "hide")) && (n10 = (int)(((String)(object5 = "true")).equalsIgnoreCase((String)(object3 = (String)object3.get(object5))) ? 1 : 0)) != 0) {
            p.b((XMPushService)object, (ii)object4);
            return;
        }
        if (object8 != null && (object3 = ((hz)object8).a()) != null && (n10 = (int)((object3 = ((hz)object8).a()).containsKey(object5 = "__miid") ? 1 : 0)) != 0) {
            object3 = (String)((hz)object8).a().get(object5);
            object5 = t.a(object.getApplicationContext());
            bl2 = TextUtils.isEmpty((CharSequence)object5);
            if (bl2 || !(bl2 = TextUtils.equals((CharSequence)object3, (CharSequence)object5))) {
                boolean bl8 = aa.e((ii)object4);
                if (bl8) {
                    object2 = fb.a(object.getApplicationContext());
                    object6 = ((ii)object4).b();
                    object7 = aa.b((ii)object4);
                    object8 = ((hz)object8).a();
                    string3 = "4";
                    ((fb)object2).a((String)object6, (String)object7, (String)object8, string3);
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object3);
                object8 = " should be login, but got ";
                ((StringBuilder)object2).append((String)object8);
                ((StringBuilder)object2).append((String)object5);
                b.a(((StringBuilder)object2).toString());
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append((String)object8);
                ((StringBuilder)object2).append((String)object5);
                object2 = ((StringBuilder)object2).toString();
                p.a((XMPushService)object, (ii)object4, "miid already logout or anther already login", (String)object2);
                return;
            }
        }
        p.a((XMPushService)object, string2, (byte[])object2, object6);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(Context object, Intent intent) {
        object = object.getPackageManager();
        int n10 = 32;
        boolean bl2 = true;
        try {
            object = object.queryBroadcastReceivers(intent, n10);
            if (object == null) return false;
        }
        catch (Exception exception) {
            return bl2;
        }
        boolean bl3 = object.isEmpty();
        if (bl3) return false;
        return bl2;
    }

    private static boolean a(Context object, String string2) {
        boolean bl2;
        block6: {
            block5: {
                Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
                intent.setPackage(string2);
                String string3 = "com.xiaomi.mipush.miui.RECEIVE_MESSAGE";
                Object object2 = new Intent(string3);
                object2.setPackage(string2);
                object = object.getPackageManager();
                bl2 = false;
                string2 = null;
                int n10 = 32;
                try {
                    object2 = object.queryBroadcastReceivers((Intent)object2, n10);
                }
                catch (Exception exception) {
                    b.a(exception);
                    return false;
                }
                object = object.queryIntentServices(intent, n10);
                boolean bl3 = object2.isEmpty();
                if (!bl3) break block5;
                boolean bl4 = object.isEmpty();
                if (bl4) break block6;
            }
            bl2 = true;
        }
        return bl2;
    }

    private static boolean a(ii object) {
        boolean bl2;
        String string2 = "com.xiaomi.xmsf";
        Object object2 = ((ii)object).b;
        boolean bl3 = string2.equals(object2);
        if (bl3 && (object2 = ((ii)object).a()) != null && (object2 = ((ii)object).a().a()) != null && (bl2 = (object = ((ii)object).a().a()).containsKey(object2 = "miui_package_name"))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static boolean a(XMPushService xMPushService, String object, ii object2, hz object3) {
        String string2;
        boolean bl2;
        Object object4;
        boolean bl3 = true;
        if (object3 != null && (object4 = ((hz)object3).a()) != null && (bl2 = (object4 = ((hz)object3).a()).containsKey(string2 = "__check_alive")) && (bl2 = (object4 = ((hz)object3).a()).containsKey(string2 = "__awake"))) {
            object4 = new il();
            Object object5 = ((ii)object2).a();
            ((il)object4).b((String)object5);
            ((il)object4).d((String)object);
            object5 = hw.G.a;
            ((il)object4).c((String)object5);
            object5 = ((hz)object3).a();
            ((il)object4).a((String)object5);
            object5 = new HashMap();
            ((il)object4).a = object5;
            boolean bl4 = g.a(xMPushService.getApplicationContext(), (String)object);
            object5 = ((il)object4).a;
            String string3 = Boolean.toString(bl4);
            String string4 = "app_running";
            object5.put(string4, string3);
            if (!bl4) {
                object = (String)((hz)object3).a().get(string2);
                bl4 = Boolean.parseBoolean((String)object);
                object3 = ((il)object4).a;
                string2 = Boolean.toString(bl4);
                object5 = "awaked";
                object3.put(object5, string2);
                if (!bl4) {
                    bl3 = false;
                }
            }
            object = ((ii)object2).b();
            object2 = ((ii)object2).a();
            object3 = hm.i;
            object = w.a((String)object, (String)object2, (ix)object4, (hm)((Object)object3));
            try {
                w.a(xMPushService, (ii)object);
            }
            catch (gd gd2) {
                b.a(gd2);
            }
        }
        return bl3;
    }

    private static void b(XMPushService xMPushService, ii ii2) {
        r r10 = new r(4, xMPushService, ii2);
        xMPushService.a(r10);
    }

    private static boolean b(ii object) {
        String string2;
        boolean bl2;
        if ((object = ((ii)object).a().a()) != null && (bl2 = object.containsKey(string2 = "notify_effect"))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static void c(XMPushService xMPushService, ii ii2) {
        s s10 = new s(4, xMPushService, ii2);
        xMPushService.a(s10);
    }

    private static boolean c(ii ii2) {
        Object object = ii2.a();
        if (object != null && (object = ii2.a().a()) != null) {
            ii2 = ii2.a().a().get("obslete_ads_message");
            return "1".equals(ii2);
        }
        return false;
    }

    private static void d(XMPushService xMPushService, ii ii2) {
        com.xiaomi.push.service.t t10 = new com.xiaomi.push.service.t(4, xMPushService, ii2);
        xMPushService.a(t10);
    }

    /*
     * WARNING - void declaration
     */
    public void a(Context context, ap$b object, boolean bl2, int n10, String string2) {
        block7: {
            String string3;
            if (!bl2 && (object = l.a(context)) != null && (bl2 = (string3 = "token-expired").equals(string2))) {
                void var1_4;
                string3 = ((k)object).f;
                String string4 = ((k)object).d;
                object = ((k)object).e;
                try {
                    l.a(context, string3, string4, (String)object);
                    break block7;
                }
                catch (JSONException jSONException) {
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                b.a((Throwable)var1_4);
            }
        }
    }

    public void a(XMPushService xMPushService, fl fl2, ap$b object) {
        object = ((ap$b)object).h;
        object = fl2.a((String)object);
        int n10 = fl2.c();
        long l10 = n10;
        try {
            p.a(xMPushService, (byte[])object, l10);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            b.a(illegalArgumentException);
        }
    }

    public void a(XMPushService object, gj object2, ap$b object3) {
        boolean bl2 = object2 instanceof gi;
        if (bl2) {
            Object object4 = object2;
            object4 = (gi)object2;
            gg gg2 = ((gj)object4).a("s");
            if (gg2 != null) {
                object3 = ((ap$b)object3).h;
                object4 = ((gj)object4).j();
                object3 = ay.a((String)object3, (String)object4);
                object4 = gg2.c();
                object3 = ay.a((byte[])object3, (String)object4);
                object2 = ((gj)object2).a();
                int n10 = gx.a((String)object2);
                long l10 = n10;
                try {
                    p.a((XMPushService)object, (byte[])object3, l10);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    b.a(illegalArgumentException);
                }
            }
        } else {
            object = "not a mipush message";
            b.a((String)object);
        }
    }
}

