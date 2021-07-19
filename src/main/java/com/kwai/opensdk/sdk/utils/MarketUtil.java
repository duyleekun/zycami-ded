/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 */
package com.kwai.opensdk.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class MarketUtil {
    public static Map MARKET_DEFAULT;
    private static final String PACKAGE_360_MARKET = "com.qihoo.appstore";
    private static final String PACKAGE_ALI_MARKET = "com.pp.assistant";
    private static final String PACKAGE_COOL_MARKET = "com.coolapk.market";
    private static final String PACKAGE_HUAWEI_MARKET = "com.huawei.appmarket";
    private static final String PACKAGE_MEIZU_MARKET = "com.meizu.mstore";
    private static final String PACKAGE_MI_MARKET = "com.xiaomi.market";
    private static final String PACKAGE_OPPO_MARKET = "com.oppo.market";
    private static final String PACKAGE_TENCENT_MARKET = "com.tencent.android.qqdownloader";
    private static final String PACKAGE_UCWEB_MARKET = "com.UCMobile";
    private static final String PACKAGE_VIVO_MARKET = "com.bbk.appstore";
    private static final String PACKAGE_WANDOUJIA_MARKET = "com.wandoujia.phoenix2";
    private static final String PACKAGE_ZTE_MARKET = "zte.com.market";

    static {
        HashMap<String, String> hashMap;
        MARKET_DEFAULT = hashMap = new HashMap<String, String>();
        hashMap.put("xiaomi", PACKAGE_MI_MARKET);
        MARKET_DEFAULT.put("meizu", PACKAGE_MEIZU_MARKET);
        MARKET_DEFAULT.put("vivo", PACKAGE_VIVO_MARKET);
        MARKET_DEFAULT.put("oppo", PACKAGE_OPPO_MARKET);
        MARKET_DEFAULT.put("huawei", PACKAGE_HUAWEI_MARKET);
        MARKET_DEFAULT.put("360", PACKAGE_360_MARKET);
        MARKET_DEFAULT.put("ysdk", PACKAGE_TENCENT_MARKET);
        MARKET_DEFAULT.put("uc", PACKAGE_UCWEB_MARKET);
        MARKET_DEFAULT.put("zte", PACKAGE_ZTE_MARKET);
        MARKET_DEFAULT.put("pp", PACKAGE_ALI_MARKET);
        MARKET_DEFAULT.put("wdj", PACKAGE_WANDOUJIA_MARKET);
        MARKET_DEFAULT.put("cool", PACKAGE_COOL_MARKET);
    }

    private static String choseMarket(Context context) {
        boolean bl2;
        Iterator iterator2 = MARKET_DEFAULT.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            String string2 = (String)entry.getValue();
            boolean bl3 = MarketUtil.isPackageExist(context, string2);
            if (!bl3) continue;
            return (String)entry.getValue();
        }
        return null;
    }

    private static Intent getLaunchIntent(Context object, String string2) {
        Intent intent = object.getPackageManager().getLaunchIntentForPackage(string2);
        if (intent != null) {
            return intent;
        }
        intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(string2);
        object = object.getPackageManager();
        int n10 = 0;
        ComponentName componentName = null;
        object = object.queryIntentActivities(intent, 0);
        if (object != null && (n10 = object.size()) > 0 && (object = (ResolveInfo)object.iterator().next()) != null) {
            object = object.activityInfo.name;
            componentName = new ComponentName(string2, (String)object);
            intent.setComponent(componentName);
        }
        return intent;
    }

    public static boolean gotoMarket(Context context, String string2) {
        boolean bl2;
        String string3 = MarketUtil.choseMarket(context);
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = "market://details?id=";
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        string2 = Uri.parse((String)stringBuilder.toString());
        intent.setData((Uri)string2);
        if (string3 != null) {
            intent.setPackage(string3);
        }
        int n10 = 0x10000000;
        intent.addFlags(n10);
        boolean bl3 = MarketUtil.isIntentAvailable(context, intent);
        boolean bl4 = true;
        if (bl3) {
            try {
                context.startActivity(intent);
                return bl4;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        if (string3 != null && (bl2 = MarketUtil.isPackageExist(context, string3)) && (string3 = MarketUtil.getLaunchIntent(context, string3)) != null) {
            string3.addFlags(n10);
            try {
                context.startActivity((Intent)string3);
                return bl4;
            }
            catch (Exception exception) {}
        }
        return false;
    }

    private static boolean isIntentAvailable(Context object, Intent intent) {
        object = object.getPackageManager();
        boolean bl2 = true;
        int n10 = (object = object.queryIntentActivities(intent, (int)(bl2 ? 1 : 0))).size();
        if (n10 <= 0) {
            bl2 = false;
        }
        return bl2;
    }

    private static boolean isPackageExist(Context object, String string2) {
        boolean bl2;
        boolean bl3;
        int n10;
        object = object.getPackageManager();
        Intent intent = new Intent();
        if ((object = object.queryIntentActivities((Intent)(string2 = intent.setPackage(string2)), n10 = 32)) != null && (bl3 = object.size()) >= (bl2 = true)) {
            return bl2;
        }
        return false;
    }
}

