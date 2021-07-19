/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.el;
import com.xiaomi.push.em;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.et;
import com.xiaomi.push.service.f;

public class ev
implements et {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Context context, String object) {
        String string2 = "provider";
        int n10 = 1008;
        try {
            String string3;
            String[] stringArray;
            int n11 = TextUtils.isEmpty((CharSequence)object);
            String string4 = "B get a incorrect message";
            if (n11 == 0 && context != null && (n11 = (stringArray = ((String)object).split(string3 = "/")).length) > 0) {
                n11 = stringArray.length + -1;
                string3 = stringArray[n11];
                if ((n11 = (int)(TextUtils.isEmpty((CharSequence)string3) ? 1 : 0)) == 0) {
                    n11 = stringArray.length + -1;
                    String string5 = stringArray[n11];
                    if ((n11 = (int)(TextUtils.isEmpty((CharSequence)string5) ? 1 : 0)) != 0) {
                        em.a(context, string2, n10, string4);
                        return;
                    }
                    String string6 = Uri.decode((String)string5);
                    n11 = (int)(TextUtils.isEmpty((CharSequence)string6) ? 1 : 0);
                    if (n11 != 0) {
                        em.a(context, string2, n10, string4);
                        return;
                    }
                    String string7 = el.b(string6);
                    n11 = (int)(TextUtils.isEmpty((CharSequence)string7) ? 1 : 0);
                    if (n11 == 0) {
                        n11 = 1007;
                        string4 = "play with provider successfully";
                        em.a(context, string7, n11, string4);
                        return;
                    }
                }
            }
            em.a(context, string2, n10, string4);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            String string8 = "B meet a exception";
            stringBuilder.append(string8);
            String string9 = exception.getMessage();
            stringBuilder.append(string9);
            String string10 = stringBuilder.toString();
            em.a(context, string2, n10, string10);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void b(Context var1_1, ep var2_2) {
        block16: {
            block14: {
                block15: {
                    var3_3 = var2_2.b();
                    var4_4 = var2_2.d();
                    var5_5 = var2_2.a();
                    var6_6 = 1008;
                    if (var1_1 == null || (var7_7 = TextUtils.isEmpty((CharSequence)var3_3)) != 0 || (var7_7 = TextUtils.isEmpty((CharSequence)var4_4)) != 0) break block16;
                    var7_7 = f.b(var1_1, var3_3);
                    if (var7_7 == 0) {
                        em.a(var1_1, var4_4, 1003, "B is not ready");
                        return;
                    }
                    em.a(var1_1, var4_4, 1002, "B is ready");
                    var7_7 = 1004;
                    var8_8 = "A is ready";
                    em.a(var1_1, var4_4, var7_7, var8_8);
                    var9_9 = el.a(var4_4);
                    try {
                        var10_10 = TextUtils.isEmpty((CharSequence)var9_9);
                        if (var10_10 != 0) break block14;
                        var10_10 = 1;
                        if (var5_5 != var10_10) ** GOTO lbl31
                    }
                    catch (Exception v0) {
                        b.a(v0);
                        em.a(var1_1, var4_4, var6_6, "A meet a exception when help B's provider");
                        return;
                    }
                    var5_5 = (int)eq.a(var1_1);
                    if (var5_5 != 0) ** GOTO lbl31
                    var2_2 = "A not in foreground";
                    em.a(var1_1, var4_4, var6_6, (String)var2_2);
                    return;
lbl31:
                    // 2 sources

                    var2_2 = var1_1.getContentResolver();
                    var3_3 = el.a(var3_3, var9_9);
                    var2_2 = var2_2.getType((Uri)var3_3);
                    var11_11 = TextUtils.isEmpty((CharSequence)var2_2);
                    if (var11_11) break block15;
                    var3_3 = "success";
                    var5_5 = (int)var3_3.equals(var2_2);
                    if (var5_5 == 0) break block15;
                    var5_5 = 1005;
                    var3_3 = "A is successful";
                    em.a(var1_1, var4_4, var5_5, var3_3);
                    em.a(var1_1, var4_4, 1006, "The job is finished");
                    return;
                }
                var2_2 = "A is fail to help B's provider";
                em.a(var1_1, var4_4, var6_6, (String)var2_2);
                return;
            }
            var2_2 = "info is empty";
            em.a(var1_1, var4_4, var6_6, (String)var2_2);
            return;
        }
        var5_5 = (int)TextUtils.isEmpty((CharSequence)var4_4);
        var3_3 = "argument error";
        if (var5_5 != 0) {
            var2_2 = "provider";
            em.a(var1_1, (String)var2_2, var6_6, var3_3);
        } else {
            em.a(var1_1, var4_4, var6_6, var3_3);
        }
    }

    public void a(Context context, Intent intent, String string2) {
        this.a(context, string2);
    }

    public void a(Context context, ep ep2) {
        if (ep2 != null) {
            this.b(context, ep2);
        } else {
            int n10 = 1008;
            String string2 = "provider";
            String string3 = "A receive incorrect message";
            em.a(context, string2, n10, string3);
        }
    }
}

