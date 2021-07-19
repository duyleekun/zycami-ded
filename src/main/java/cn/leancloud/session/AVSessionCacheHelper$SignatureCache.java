/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.core.AppConfiguration;
import cn.leancloud.im.Signature;
import cn.leancloud.json.JSON;
import java.util.Map;

public class AVSessionCacheHelper$SignatureCache {
    private static final String SESSION_SIGNATURE_KEY = "com.avos.avoscloud.session.signature";

    public static void addSessionSignature(String object, Signature object2) {
        Map map = AVSessionCacheHelper$SignatureCache.getSessionSignatures();
        map.put(object, object2);
        object = AppConfiguration.getDefaultSetting();
        object2 = JSON.toJSONString(map);
        object.saveString(SESSION_SIGNATURE_KEY, "sessionids", (String)object2);
    }

    public static Signature getSessionSignature(String string2) {
        return (Signature)AVSessionCacheHelper$SignatureCache.getSessionSignatures().get(string2);
    }

    private static Map getSessionSignatures() {
        return (Map)JSON.parseObject(AppConfiguration.getDefaultSetting().getString(SESSION_SIGNATURE_KEY, "sessionids", "{}"), Map.class);
    }
}

