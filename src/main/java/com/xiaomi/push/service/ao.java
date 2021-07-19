/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.a;
import com.xiaomi.push.cv;
import com.xiaomi.push.cz;
import com.xiaomi.push.di;
import com.xiaomi.push.ek$b;
import com.xiaomi.push.ek$d;
import com.xiaomi.push.ek$g;
import com.xiaomi.push.ek$h;
import com.xiaomi.push.ek$i;
import com.xiaomi.push.ek$j;
import com.xiaomi.push.ek$k;
import com.xiaomi.push.fh;
import com.xiaomi.push.fl;
import com.xiaomi.push.ft;
import com.xiaomi.push.gg;
import com.xiaomi.push.gh;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gx;
import com.xiaomi.push.hg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$c;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.be;
import com.xiaomi.push.service.d;
import java.util.Date;

public class ao {
    private XMPushService a;

    public ao(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(gg object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((gg)object).c()));
        if (!bl2) {
            int n10;
            object = ((String)object).split(";");
            Object object2 = cz.a();
            String string2 = ft.a();
            if ((object2 = ((cz)object2).a(string2, false)) != null && (n10 = ((String[])object).length) > 0) {
                ((cv)object2).a((String[])object);
                object = this.a;
                n10 = 0;
                string2 = null;
                ((XMPushService)object).a(20, null);
                object = this.a;
                bl2 = true;
                ((XMPushService)object).a(bl2);
            }
        }
    }

    private void b(gj object) {
        Object object2;
        Object object3 = ((gj)object).l();
        Object object4 = ((gj)object).k();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object4)) && (object3 = ((ap)(object2 = ap.a())).a((String)object4, (String)object3)) != null) {
            object4 = this.a;
            object2 = ((ap$b)object3).a;
            object = ((gj)object).a();
            int n10 = gx.a((String)object);
            long l10 = n10;
            boolean bl3 = true;
            boolean bl4 = true;
            long l11 = System.currentTimeMillis();
            gx.a((Context)object4, (String)object2, l10, bl3, bl4, l11);
        }
    }

    private void c(fl fl2) {
        Object object;
        Object object2 = fl2.g();
        int n10 = fl2.a();
        Object object3 = Integer.toString(n10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object3)) && (object2 = ((ap)(object = ap.a())).a((String)object3, (String)object2)) != null) {
            object3 = this.a;
            object = ((ap$b)object2).a;
            int n11 = fl2.c();
            long l10 = n11;
            boolean bl3 = true;
            boolean bl4 = true;
            long l11 = System.currentTimeMillis();
            gx.a((Context)object3, (String)object, l10, bl3, bl4, l11);
        }
    }

    public void a(fl object) {
        int n10 = 5;
        int n11 = ((fl)object).a();
        if (n10 != n11) {
            this.c((fl)object);
        }
        try {
            this.b((fl)object);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("handle Blob chid = ");
            int n12 = ((fl)object).a();
            stringBuilder.append(n12);
            stringBuilder.append(" cmd = ");
            String string2 = ((fl)object).a();
            stringBuilder.append(string2);
            string2 = " packetid = ";
            stringBuilder.append(string2);
            object = ((fl)object).e();
            stringBuilder.append((String)object);
            stringBuilder.append(" failure ");
            object = stringBuilder.toString();
            b.a((String)object, (Throwable)exception);
        }
    }

    public void a(gj object) {
        Object object2;
        boolean bl2;
        Object object3 = "5";
        String string2 = ((gj)object).k();
        boolean bl3 = ((String)object3).equals(string2);
        if (!bl3) {
            this.b((gj)object);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((gj)object).k()))) {
            string2 = "1";
            ((gj)object).l(string2);
        }
        if (bl2 = string2.equals(object3 = "0")) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Received wrong packet with chid = 0 : ");
            object2 = ((gj)object).a();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            b.a((String)object3);
        }
        if (bl2 = object instanceof gh) {
            object3 = ((gj)object).a("kick");
            if (object3 != null) {
                object = ((gj)object).l();
                String string3 = ((gg)object3).a("type");
                String string4 = ((gg)object3).a("reason");
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("kicked by server, chid=");
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(" res=");
                object2 = ap$b.a((String)object);
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append(" type=");
                ((StringBuilder)object3).append(string3);
                object2 = " reason=";
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append(string4);
                b.a(((StringBuilder)object3).toString());
                object3 = "wait";
                bl2 = ((String)object3).equals(string3);
                if (bl2) {
                    object3 = ap.a();
                    ap$b ap$b = ((ap)object3).a(string2, (String)object);
                    if (ap$b != null) {
                        object = this.a;
                        ((XMPushService)object).a(ap$b);
                        ap$c ap$c = ap$c.a;
                        int n10 = 3;
                        ap$b.a(ap$c, n10, 0, string4, string3);
                    }
                } else {
                    object3 = this.a;
                    int n11 = 3;
                    object2 = string2;
                    Object object4 = object;
                    ((XMPushService)object3).a(string2, (String)object, n11, string4, string3);
                    object3 = ap.a();
                    ((ap)object3).a(string2, (String)object);
                }
                return;
            }
        } else {
            bl2 = object instanceof gi;
            if (bl2) {
                object3 = object;
                String string5 = "redir";
                object3 = (gi)object;
                object2 = ((gi)object3).b();
                boolean bl4 = string5.equals(object2);
                if (bl4) {
                    object = ((gj)object3).a("hosts");
                    if (object != null) {
                        this.a((gg)object);
                    }
                    return;
                }
            }
        }
        object3 = this.a.b();
        object2 = this.a;
        ((d)object3).a((XMPushService)object2, string2, (gj)object);
    }

    /*
     * Unable to fully structure code
     */
    public void b(fl var1_1) {
        block17: {
            block25: {
                block27: {
                    block26: {
                        block24: {
                            block18: {
                                block21: {
                                    block23: {
                                        block22: {
                                            block19: {
                                                block20: {
                                                    var2_2 = var1_1.a();
                                                    var3_3 = var1_1.a();
                                                    var4_4 = null;
                                                    var5_5 = null;
                                                    if (var3_3 == 0) break block18;
                                                    var3_3 = var1_1.a();
                                                    var6_6 = Integer.toString(var3_3);
                                                    var8_11 = "SECMSG";
                                                    var7_8 = var1_1.a();
                                                    var9_13 = var8_11.equals(var7_8);
                                                    if (!var9_13) break block19;
                                                    var10_15 = var1_1.a();
                                                    if (var10_15) break block20;
                                                    var2_2 = this.a.b();
                                                    var4_4 = this.a;
                                                    var2_2.a((XMPushService)var4_4, var6_6, (fl)var1_1);
                                                    break block17;
                                                }
                                                var2_2 = new StringBuilder();
                                                var2_2.append("Recv SECMSG errCode = ");
                                                var3_3 = var1_1.b();
                                                var2_2.append(var3_3);
                                                var6_6 = " errStr = ";
                                                var2_2.append(var6_6);
                                                var1_1 = var1_1.c();
lbl29:
                                                // 3 sources

                                                while (true) {
                                                    var2_2.append((String)var1_1);
                                                    var1_1 = var2_2.toString();
lbl33:
                                                    // 2 sources

                                                    while (true) {
                                                        b.a((String)var1_1);
                                                        break block17;
                                                        break;
                                                    }
                                                    break;
                                                }
                                            }
                                            var7_8 = "BIND";
                                            var9_13 = var7_8.equals(var2_2);
                                            var8_11 = "wait";
                                            var11_19 = " reason=";
                                            if (!var9_13) break block21;
                                            var2_2 = ek$d.a(var1_1.a());
                                            var7_8 = var1_1.g();
                                            var12_21 = ap.a();
                                            var13_24 = var12_21.a(var6_6, (String)var7_8);
                                            if (var13_24 == null) {
                                                return;
                                            }
                                            var14_28 = var2_2.a();
                                            if (!var14_28) break block22;
                                            var2_2 = new StringBuilder();
                                            var6_6 = "SMACK: channel bind succeeded, chid=";
                                            var2_2.append(var6_6);
                                            var15_30 = var1_1.a();
                                            var2_2.append(var15_30);
                                            var1_1 = var2_2.toString();
                                            b.a((String)var1_1);
                                            var16_33 = ap$c.c;
                                            var17_37 = 1;
                                            var18_42 = false;
                                            var19_45 = null;
                                            var20_47 = null;
                                            var21_51 = null;
                                            var13_24.a(var16_33, var17_37, 0, null, null);
                                            break block17;
                                        }
                                        var1_1 = "auth";
                                        var21_52 = var2_2.a();
                                        var15_31 = var1_1.equals(var21_52);
                                        if (var15_31 == 0) break block23;
                                        var8_11 = "invalid-sig";
                                        var1_1 = var2_2.b();
                                        var15_31 = var8_11.equals(var1_1);
                                        if (var15_31 != 0) {
                                            var1_1 = new StringBuilder();
                                            var1_1.append("SMACK: bind error invalid-sig token = ");
                                            var8_11 = var13_24.c;
                                            var1_1.append(var8_11);
                                            var1_1.append(" sec = ");
                                            var8_11 = var13_24.h;
                                            var1_1.append(var8_11);
                                            b.a(var1_1.toString());
                                            var1_1 = fh.Q;
                                            var15_31 = var1_1.a();
                                            var22_53 = 1;
                                            hg.a(0, var15_31, var22_53, null, 0);
                                        }
                                        var16_34 = ap$c.a;
                                        var17_38 = 1;
                                        var18_43 = 5;
                                        ** GOTO lbl103
                                    }
                                    var1_1 = "cancel";
                                    var15_31 = var1_1.equals(var21_52);
                                    if (var15_31 != 0) {
                                        var16_34 = ap$c.a;
                                        var17_38 = 1;
                                        var18_43 = 7;
lbl103:
                                        // 2 sources

                                        var20_48 = var2_2.b();
                                        var13_24.a(var16_34, var17_38, var18_43, var20_48, var21_52);
                                        var1_1 = ap.a();
                                        var1_1.a(var6_6, (String)var7_8);
                                    } else {
                                        var15_31 = var8_11.equals(var21_52);
                                        if (var15_31 != 0) {
                                            var1_1 = this.a;
                                            var1_1.a(var13_24);
                                            var16_35 = ap$c.a;
                                            var17_39 = 1;
                                            var18_44 = 7;
                                            var20_49 = var2_2.b();
                                            var13_24.a(var16_35, var17_39, var18_44, var20_49, var21_52);
                                        }
                                    }
                                    var1_1 = new StringBuilder();
                                    var4_4 = "SMACK: channel bind failed, chid=";
                                    var1_1.append((String)var4_4);
                                    var1_1.append(var6_6);
                                    var1_1.append((String)var11_19);
                                    var2_2 = var2_2.b();
                                    var1_1.append((String)var2_2);
                                    var1_1 = var1_1.toString();
                                    ** while (true)
                                }
                                var4_4 = "KICK";
                                var10_16 = var4_4.equals(var2_2);
                                if (var10_16) {
                                    var2_2 = ek$g.a(var1_1.a());
                                    var1_1 = var1_1.g();
                                    var20_50 = var2_2.a();
                                    var19_46 = var2_2.b();
                                    var2_2 = new StringBuilder();
                                    var2_2.append("kicked by server, chid=");
                                    var2_2.append(var6_6);
                                    var2_2.append(" res= ");
                                    var4_4 = ap$b.a((String)var1_1);
                                    var2_2.append((String)var4_4);
                                    var4_4 = " type=";
                                    var2_2.append((String)var4_4);
                                    var2_2.append(var20_50);
                                    var2_2.append((String)var11_19);
                                    var2_2.append(var19_46);
                                    var2_2 = var2_2.toString();
                                    b.a((String)var2_2);
                                    var10_16 = var8_11.equals(var20_50);
                                    if (var10_16) {
                                        var2_2 = ap.a();
                                        var12_22 = var2_2.a(var6_6, (String)var1_1);
                                        if (var12_22 != null) {
                                            var1_1 = this.a;
                                            var1_1.a(var12_22);
                                            var13_25 = ap$c.a;
                                            var23_54 = 3;
                                            var17_40 = false;
                                            var12_22.a(var13_25, var23_54, 0, var19_46, var20_50);
                                        }
                                    } else {
                                        var7_8 = this.a;
                                        var14_29 = 3;
                                        var8_11 = var6_6;
                                        var11_19 = var1_1;
                                        var13_26 = var19_46;
                                        var16_36 = var20_50;
                                        var7_8.a(var6_6, (String)var1_1, var14_29, var19_46, var20_50);
                                        var2_2 = ap.a();
                                        var2_2.a(var6_6, (String)var1_1);
                                    }
                                }
                                break block17;
                            }
                            var6_7 = "PING";
                            var3_3 = (int)var6_7.equals(var2_2);
                            if (var3_3 == 0) break block24;
                            var2_2 = var1_1.a();
                            if (var2_2 != null && (var3_3 = ((Object)var2_2).length) > 0 && (var3_3 = (int)(var2_2 = ek$j.a((byte[])var2_2)).b()) != 0) {
                                var6_7 = be.a();
                                var2_2 = var2_2.a();
                                var6_7.a((ek$b)var2_2);
                            }
                            if (!(var10_17 = (var6_7 = "com.xiaomi.xmsf").equals(var2_2 = this.a.getPackageName()))) {
                                var2_2 = this.a;
                                var2_2.a();
                            }
                            if (var15_32 = (var2_2 = "1").equals(var1_1 = var1_1.e())) {
                                var1_1 = "received a server ping";
                                b.a((String)var1_1);
                            } else {
                                hg.b();
                            }
                            var1_1 = this.a;
                            var1_1.b();
                            break block17;
                        }
                        var6_7 = "SYNC";
                        var10_18 = var6_7.equals(var2_2);
                        if (!var10_18) break block25;
                        var6_7 = "CONF";
                        var2_2 = var1_1.b();
                        var10_18 = var6_7.equals(var2_2);
                        if (!var10_18) break block26;
                        var1_1 = ek$b.a(var1_1.a());
                        var2_2 = be.a();
                        var2_2.a((ek$b)var1_1);
                        break block17;
                    }
                    var6_7 = "U";
                    var2_2 = var1_1.b();
                    var10_18 = TextUtils.equals((CharSequence)var6_7, (CharSequence)var2_2);
                    if (!var10_18) break block27;
                    var2_2 = ek$k.a(var1_1.a());
                    var7_9 = di.a((Context)this.a);
                    var8_12 = var2_2.a();
                    var11_20 = var2_2.b();
                    var24_56 = var2_2.a();
                    var12_23 = new Date(var24_56);
                    var24_56 = var2_2.b();
                    var13_27 = new Date(var24_56);
                    var3_3 = var2_2.c();
                    var23_55 = var3_3 * 1024;
                    var17_41 = var2_2.e();
                    var7_9.a(var8_12, var11_20, var12_23, var13_27, var23_55, var17_41);
                    var2_2 = new fl();
                    var2_2.a(0);
                    var6_7 = var1_1.a();
                    var4_4 = "UCA";
                    var2_2.a((String)var6_7, (String)var4_4);
                    var1_1 = var1_1.e();
                    var2_2.a((String)var1_1);
                    var1_1 = this.a;
                    var6_7 = new ba((XMPushService)var1_1, (fl)var2_2);
                    var1_1.a((XMPushService$i)var6_7);
                    break block17;
                }
                var6_7 = "P";
                var2_2 = var1_1.b();
                var10_18 = TextUtils.equals((CharSequence)var6_7, (CharSequence)var2_2);
                if (!var10_18) break block17;
                var2_2 = ek$i.a(var1_1.a());
                var6_7 = new fl();
                var6_7.a(0);
                var5_5 = var1_1.a();
                var7_10 = "PCA";
                var6_7.a((String)var5_5, var7_10);
                var5_5 = var1_1.e();
                var6_7.a((String)var5_5);
                var5_5 = new ek$i();
                var9_14 = var2_2.a();
                if (var9_14) {
                    var2_2 = var2_2.a();
                    var5_5.a((a)var2_2);
                }
                var2_2 = var5_5.a();
                var6_7.a((byte[])var2_2, null);
                var2_2 = this.a;
                var4_4 = new ba((XMPushService)var2_2, (fl)var6_7);
                var2_2.a((XMPushService$i)var4_4);
                var2_2 = new StringBuilder();
                var6_7 = "ACK msgP: id = ";
                var2_2.append((String)var6_7);
                var1_1 = var1_1.e();
                ** GOTO lbl29
            }
            var6_7 = "NOTIFY";
            var2_2 = var1_1.a();
            var10_18 = var6_7.equals(var2_2);
            if (var10_18) {
                var1_1 = ek$h.a(var1_1.a());
                var2_2 = new StringBuilder();
                var2_2.append("notify by server err = ");
                var3_3 = var1_1.c();
                var2_2.append(var3_3);
                var6_7 = " desc = ";
                var2_2.append((String)var6_7);
                var1_1 = var1_1.a();
                ** continue;
            }
        }
    }
}

