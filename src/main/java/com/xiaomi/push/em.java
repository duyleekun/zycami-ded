/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.en;
import com.xiaomi.push.eq;
import com.xiaomi.push.eu;
import java.util.HashMap;

public class em {
    public static void a(Context context, String string2, int n10, String string3) {
        ai ai2 = ai.a(context);
        en en2 = new en(context, string2, n10, string3);
        ai2.a(en2);
    }

    private static void a(Context context, HashMap hashMap) {
        eu eu2 = eq.a(context).a();
        if (eu2 != null) {
            eu2.a(context, hashMap);
        }
    }

    public static /* synthetic */ void b(Context context, String string2, int n10, String string3) {
        em.c(context, string2, n10, string3);
    }

    private static void b(Context context, HashMap hashMap) {
        eu eu2 = eq.a(context).a();
        if (eu2 != null) {
            eu2.c(context, hashMap);
        }
    }

    private static void c(Context context, String object, int n10, String string2) {
        boolean bl2;
        if (context != null && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            HashMap<String, String> hashMap;
            block15: {
                block13: {
                    block14: {
                        hashMap = new HashMap<String, String>();
                        String string3 = "awake_info";
                        hashMap.put(string3, (String)object);
                        object = "event_type";
                        String string4 = String.valueOf(n10);
                        hashMap.put((String)object, string4);
                        object = "description";
                        hashMap.put((String)object, string2);
                        object = eq.a(context);
                        int n11 = ((eq)object).a();
                        n10 = 1;
                        if (n11 == n10) break block13;
                        n10 = 2;
                        if (n11 == n10) break block14;
                        n10 = 3;
                        if (n11 != n10) break block15;
                        em.a(context, hashMap);
                    }
                    em.c(context, hashMap);
                    break block15;
                }
                em.a(context, hashMap);
            }
            try {
                em.b(context, hashMap);
            }
            catch (Exception exception) {
                b.a(exception);
            }
        }
    }

    private static void c(Context context, HashMap hashMap) {
        eu eu2 = eq.a(context).a();
        if (eu2 != null) {
            eu2.b(context, hashMap);
        }
    }
}

