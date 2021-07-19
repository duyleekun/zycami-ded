/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ax;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.ad;
import com.xiaomi.push.ai;
import com.xiaomi.push.bf;
import com.xiaomi.push.hr;
import com.xiaomi.push.il;
import com.xiaomi.push.service.ak;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class aw {
    public static /* synthetic */ String a(List list) {
        return aw.c(list);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String string2 = "last_sync_info";
        long l10 = -1;
        long l11 = sharedPreferences.getLong(string2, l10);
        long l12 = System.currentTimeMillis() / 1000L;
        ak ak2 = ak.a(context);
        hr hr2 = hr.B;
        int n10 = hr2.a();
        int n11 = 1209600;
        int n12 = ak2.a(n10, n11);
        long l13 = n12;
        Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (object != false) {
            l10 = Math.abs(l12 - l11);
            long l14 = l10 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 <= 0) return;
            boolean bl2 = true;
            aw.a(context, bl2);
        }
        context = sharedPreferences.edit().putLong(string2, l12);
        context.commit();
    }

    public static void a(Context context, il stringArray) {
        int n10;
        int n11;
        Object object;
        Object object2;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("need to update local info with: ");
        Map map = ((il)stringArray).a();
        ((StringBuilder)object3).append(map);
        com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object3).toString());
        object3 = (String)((il)stringArray).a().get("accept_time");
        int n12 = 0;
        map = null;
        if (object3 != null) {
            MiPushClient.removeAcceptTime(context);
            object2 = "-";
            object3 = ((String)object3).split((String)object2);
            int bl2 = ((String[])object3).length;
            int bl3 = 2;
            if (bl2 == bl3) {
                object2 = object3[0];
                boolean bl4 = true;
                object = object3[bl4];
                MiPushClient.addAcceptTime(context, (String)object2, (String)object);
                object2 = object3[0];
                object = "00:00";
                bl2 = (int)(((String)object).equals(object2) ? 1 : 0);
                if (bl2 != 0 && (n11 = ((String)object).equals(object3 = object3[bl4])) != 0) {
                    object3 = b.a(context);
                    ((b)object3).a(bl4);
                } else {
                    object3 = b.a(context);
                    ((b)object3).a(false);
                }
            }
        }
        object3 = (String)((il)stringArray).a().get("aliases");
        object2 = ",";
        String string2 = "";
        if (object3 != null) {
            MiPushClient.removeAllAliases(context);
            n10 = string2.equals(object3);
            if (n10 == 0) {
                for (String string3 : ((String)object3).split((String)object2)) {
                    MiPushClient.addAlias(context, string3);
                }
            }
        }
        object3 = ((il)stringArray).a();
        object = "topics";
        if ((object3 = (String)object3.get(object)) != null) {
            MiPushClient.removeAllTopics(context);
            n10 = (int)(string2.equals(object3) ? 1 : 0);
            if (n10 == 0) {
                for (String string4 : ((String)object3).split((String)object2)) {
                    MiPushClient.addTopic(context, string4);
                }
            }
        }
        stringArray = ((il)stringArray).a();
        object3 = "user_accounts";
        if ((stringArray = (String)stringArray.get(object3)) != null) {
            MiPushClient.removeAllAccounts(context);
            n11 = string2.equals(stringArray);
            if (n11 == 0) {
                stringArray = ((String)stringArray).split((String)object2);
                n11 = ((Object)stringArray).length;
                while (n12 < n11) {
                    object2 = stringArray[n12];
                    MiPushClient.addAccount(context, (String)object2);
                    ++n12;
                }
            }
        }
    }

    public static void a(Context context, boolean bl2) {
        ai ai2 = ai.a(context);
        ax ax2 = new ax(context, bl2);
        ai2.a(ax2);
    }

    public static /* synthetic */ String b(List list) {
        return aw.d(list);
    }

    private static String c(List object) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)(object = bf.a(aw.d((List)object))));
        if (n11 == 0 && (n11 = ((String)object).length()) > (n10 = 4)) {
            return ((String)object).substring(0, n10).toLowerCase();
        }
        return "";
    }

    private static String d(List iterator2) {
        boolean bl2 = ad.a((Collection)((Object)iterator2));
        String string2 = "";
        if (bl2) {
            return string2;
        }
        Object object = new ArrayList(iterator2);
        iterator2 = Collator.getInstance(Locale.CHINA);
        Collections.sort(object, iterator2);
        iterator2 = object.iterator();
        while (bl2 = iterator2.hasNext()) {
            StringBuilder stringBuilder;
            object = (String)iterator2.next();
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(",");
                string2 = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            string2 = stringBuilder.toString();
        }
        return string2;
    }
}

