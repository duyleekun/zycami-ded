/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.session.AVSessionCacheHelper;
import cn.leancloud.utils.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class AVSessionCacheHelper$IMSessionTokenCache {
    private static final String SESSION_TOKEN_KEY = "com.avos.avoscloud.session.token";
    private static final Map imSessionTokenMap;

    static {
        HashMap hashMap;
        imSessionTokenMap = hashMap = new HashMap();
    }

    public static void addIMSessionToken(String string2, String string3, long l10) {
        Object object = AVIMOptions.getGlobalOptions();
        boolean bl2 = ((AVIMOptions)object).isAutoOpen();
        if (bl2) {
            object = AppConfiguration.getDefaultSetting();
            String string4 = SESSION_TOKEN_KEY;
            object.saveString(string4, string2, string3);
            string2 = AVSessionCacheHelper$IMSessionTokenCache.getSessionTokenExpiredAtKey(string2);
            string3 = String.valueOf(l10);
            object.saveString(string4, string2, string3);
        } else {
            Map map = imSessionTokenMap;
            map.put(string2, string3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String getIMSessionToken(String string2) {
        Object object = AVIMOptions.getGlobalOptions();
        boolean bl2 = ((AVIMOptions)object).isAutoOpen();
        if (bl2) {
            long l10;
            object = AppConfiguration.getDefaultSetting();
            String string3 = SESSION_TOKEN_KEY;
            String string4 = object.getString(string3, string2, null);
            string2 = AVSessionCacheHelper$IMSessionTokenCache.getSessionTokenExpiredAtKey(string2);
            string2 = object.getString(string3, string2, null);
            bl2 = StringUtil.isEmpty(string4);
            if (bl2 || (bl2 = StringUtil.isEmpty(string2))) return null;
            try {
                l10 = Long.parseLong(string2);
            }
            catch (Exception exception) {
                object = AVSessionCacheHelper.access$100();
                ((AVLogger)object).w(exception);
                return null;
            }
            long l11 = System.currentTimeMillis();
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 <= 0) return null;
            return string4;
        } else {
            object = imSessionTokenMap;
            boolean bl3 = object.containsKey(string2);
            if (!bl3) return null;
            return (String)object.get(string2);
        }
    }

    private static String getSessionTokenExpiredAtKey(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(".expiredAt");
        return stringBuilder.toString();
    }

    public static void removeIMSessionToken(String string2) {
        Object object = AVIMOptions.getGlobalOptions();
        boolean bl2 = ((AVIMOptions)object).isAutoOpen();
        if (bl2) {
            object = AppConfiguration.getDefaultSetting();
            String string3 = SESSION_TOKEN_KEY;
            object.removeKey(string3, string2);
            string2 = AVSessionCacheHelper$IMSessionTokenCache.getSessionTokenExpiredAtKey(string2);
            object.removeKey(string3, string2);
        } else {
            object = imSessionTokenMap;
            object.remove(string2);
        }
    }
}

