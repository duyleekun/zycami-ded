/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.wechat.utils;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.h;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class h$2
extends Thread {
    public final /* synthetic */ PlatformActionListener a;
    public final /* synthetic */ h b;

    public h$2(h h10, PlatformActionListener platformActionListener) {
        this.b = h10;
        this.a = platformActionListener;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void run() {
        block122: {
            block121: {
                block120: {
                    block119: {
                        var1_1 = this;
                        var2_2 = "unionid";
                        var3_3 = "country";
                        var4_4 = "city";
                        var5_5 = "province";
                        var6_6 = "nickname";
                        var7_7 = "errcode";
                        var8_10 = "userTags";
                        var9_11 = "openid";
                        var10_12 = new ArrayList();
                        var12_14 = "access_token";
                        var13_15 = this.b;
                        var13_15 = h.a((h)var13_15);
                        var13_15 = var13_15.getDb();
                        var13_15 = var13_15.getToken();
                        var11_13 = new KVPair((String)var12_14, var13_15);
                        var10_12.add(var11_13);
                        var12_14 = this.b;
                        var12_14 = h.a((h)var12_14);
                        var12_14 = var12_14.getDb();
                        var12_14 = var12_14.get(var9_11);
                        var11_13 = new KVPair(var9_11, var12_14);
                        var10_12.add(var11_13);
                        var12_14 = "lang";
                        var13_15 = "zh_CN";
                        var11_13 = new KVPair((String)var12_14, var13_15);
                        var10_12.add(var11_13);
                        var11_13 = "https://api.weixin.qq.com/sns/userinfo";
                        var12_14 = this.b;
                        var12_14 = h.c((h)var12_14);
                        var13_15 = "/sns/userinfo";
                        var14_16 /* !! */  = this.b;
                        var15_17 = h.b((h)var14_16 /* !! */ );
                        var10_12 = var12_14.a((String)var11_13, (ArrayList)var10_12, (String)var13_15, var15_17);
                        var16_18 = TextUtils.isEmpty((CharSequence)var10_12);
                        var17_19 = 8;
                        if (!var16_18) ** GOTO lbl74
                        var7_7 = this.a;
                        if (var7_7 == null) ** GOTO lbl73
                        var2_2 = this.b;
                        var2_2 = h.a((h)var2_2);
                        var3_3 = new Throwable();
                        var7_7.onError((Platform)var2_2, var17_19, (Throwable)var3_3);
lbl73:
                        // 2 sources

                        return;
lbl74:
                        // 1 sources

                        var11_13 = SSDKLog.b();
                        var13_15 = new StringBuilder();
                        var14_16 /* !! */  = "getUserInfo ==>>";
                        var13_15.append((String)var14_16 /* !! */ );
                        var13_15.append((String)var10_12);
                        var13_15 = var13_15.toString();
                        var15_17 = 0;
                        var14_16 /* !! */  = null;
                        var14_16 /* !! */  = new Object[]{};
                        var11_13.d(var13_15, var14_16 /* !! */ );
                        var11_13 = new Hashon();
                        var10_12 = var11_13.fromJson((String)var10_12);
                        var16_18 = var10_12.containsKey(var7_7);
                        if (!var16_18) break block119;
                        var7_7 = var10_12.get(var7_7);
                        var7_7 = (Integer)var7_7;
                        var18_20 = var7_7.intValue();
                        if (var18_20 == 0) break block119;
                        var7_7 = this.a;
                        if (var7_7 == null) ** GOTO lbl123
                        var7_7 = new Hashon();
                        var7_7 = var7_7.fromHashMap((HashMap)var10_12);
                        var2_2 = this.a;
                        var3_3 = this.b;
                        var3_3 = h.a((h)var3_3);
                        var4_4 = new Throwable((String)var7_7);
                        var2_2.onError((Platform)var3_3, var17_19, (Throwable)var4_4);
lbl123:
                        // 2 sources

                        return;
                    }
                    var7_7 = var10_12.get(var9_11);
                    var11_13 = String.valueOf(var7_7);
                    var7_7 = var10_12.get(var6_6);
                    var13_15 = String.valueOf(var7_7);
                    var7_7 = "sex";
                    var7_7 = var10_12.get(var7_7);
                    var7_7 = String.valueOf(var7_7);
                    try {
                        var18_20 = ResHelper.parseInt((String)var7_7);
                    }
                    catch (Throwable var7_8) {
                        var19_21 = SSDKLog.b();
                        var19_21.d(var7_8);
                        var18_20 = 2;
                    }
                    var19_21 = var10_12.get(var5_5);
                    var19_21 = String.valueOf(var19_21);
                    var20_22 /* !! */  = var10_12.get(var4_4);
                    var20_22 /* !! */  = String.valueOf(var20_22 /* !! */ );
                    var21_23 = var10_12.get(var3_3);
                    var12_14 = String.valueOf(var21_23);
                    var14_16 /* !! */  = "headimgurl";
                    var14_16 /* !! */  = var10_12.get(var14_16 /* !! */ );
                    var14_16 /* !! */  = String.valueOf(var14_16 /* !! */ );
                    var22_24 /* !! */  = var10_12.get(var2_2);
                    var23_25 = var10_12;
                    var10_12 = String.valueOf(var22_24 /* !! */ );
                    var22_24 /* !! */  = var8_10;
                    var8_10 = var1_1.b;
                    var8_10 = h.a((h)var8_10);
                    var8_10 = var8_10.getDb();
                    var8_10.put(var6_6, (String)var13_15);
                    var24_26 = 1;
                    var8_10 = "gender";
                    if (var18_20 != var24_26) break block120;
                    var7_7 = var1_1.b;
                    var7_7 = h.a((h)var7_7);
                    var7_7 = var7_7.getDb();
                    var6_6 = "0";
                    var7_7.put((String)var8_10, var6_6);
                    ** GOTO lbl213
                }
                var24_26 = 2;
                if (var18_20 != var24_26) ** GOTO lbl205
                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var6_6 = "1";
                var7_7.put((String)var8_10, var6_6);
                ** GOTO lbl213
lbl205:
                // 1 sources

                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var6_6 = "2";
                var7_7.put((String)var8_10, var6_6);
lbl213:
                // 3 sources

                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var7_7.putUserId((String)var11_13);
                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var6_6 = "icon";
                var7_7.put(var6_6, (String)var14_16 /* !! */ );
                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var7_7.put(var5_5, (String)var19_21);
                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var7_7.put((String)var4_4, (String)var20_22 /* !! */ );
                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var7_7.put((String)var3_3, (String)var12_14);
                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var7_7.put(var9_11, (String)var11_13);
                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var7_7.put((String)var2_2, (String)var10_12);
                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var2_2 = var22_24 /* !! */ ;
                var7_7 = var7_7.get((String)var22_24 /* !! */ );
                if (var7_7 == null) break block121;
                var7_7 = var1_1.b;
                var7_7 = h.a((h)var7_7);
                var7_7 = var7_7.getDb();
                var7_7 = var7_7.get((String)var22_24 /* !! */ );
                var3_3 = var23_25;
                var23_25.put(var22_24 /* !! */ , var7_7);
                break block122;
            }
            var3_3 = var23_25;
        }
        var7_7 = var1_1.a;
        var2_2 = var1_1.b;
        var2_2 = h.a((h)var2_2);
        var25_27 = 8;
        var7_7.onComplete((Platform)var2_2, var25_27, (HashMap)var3_3);
        {
            catch (Throwable var7_9) {
                var2_2 = SSDKLog.b();
                var2_2.d(var7_9);
            }
        }
    }
}

