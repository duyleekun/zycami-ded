/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVQuery$CachePolicy;
import cn.leancloud.AVUser;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.ops.Utils;
import e.a.z;
import java.util.Map;

public class AVCloud {
    private static boolean isProduction = true;

    private AVCloud() {
    }

    public static z callFunctionInBackground(AVUser aVUser, String string2, Map map) {
        StorageClient storageClient = PaasClient.getStorageClient();
        map = Utils.getParsedMap(map);
        return storageClient.callFunction(aVUser, string2, map);
    }

    public static z callFunctionInBackground(String string2, Map map) {
        return AVCloud.callFunctionInBackground(null, string2, map);
    }

    public static z callFunctionWithCacheInBackground(AVUser aVUser, String string2, Map map, AVQuery.CachePolicy cachePolicy, long l10) {
        StorageClient storageClient = PaasClient.getStorageClient();
        Map map2 = Utils.getParsedMap(map);
        return storageClient.callFunctionWithCachePolicy(aVUser, string2, map2, cachePolicy, l10);
    }

    public static z callFunctionWithCacheInBackground(String string2, Map map, AVQuery.CachePolicy cachePolicy, long l10) {
        return AVCloud.callFunctionWithCacheInBackground(null, string2, map, cachePolicy, l10);
    }

    public static z callRPCInBackground(AVUser aVUser, String string2, Object object) {
        StorageClient storageClient = PaasClient.getStorageClient();
        object = Utils.getParsedObject(object);
        return storageClient.callRPC(aVUser, string2, object);
    }

    public static z callRPCInBackground(String string2, Object object) {
        return AVCloud.callRPCInBackground(null, string2, object);
    }

    public static z callRPCWithCacheInBackground(AVUser aVUser, String string2, Map map, AVQuery.CachePolicy cachePolicy, long l10) {
        StorageClient storageClient = PaasClient.getStorageClient();
        Map map2 = Utils.getParsedMap(map);
        return storageClient.callRPCWithCachePolicy(aVUser, string2, map2, cachePolicy, l10);
    }

    public static z callRPCWithCacheInBackground(String string2, Map map, AVQuery.CachePolicy cachePolicy, long l10) {
        return AVCloud.callRPCWithCacheInBackground(null, string2, map, cachePolicy, l10);
    }

    public static boolean isProductionMode() {
        return isProduction;
    }

    public static void setProductionMode(boolean bl2) {
        isProduction = bl2;
    }
}

