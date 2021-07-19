/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.cache.SystemSetting;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.json.JSON;
import cn.leancloud.session.AVSessionCacheHelper$1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AVSessionCacheHelper$SessionTagCache {
    private static final String SESSION_TAG_CACHE_KEY = "session_tag_cache_key";
    public Map cachedTagMap;

    private AVSessionCacheHelper$SessionTagCache() {
        Map map = new Map();
        this.cachedTagMap = map = Collections.synchronizedMap(map);
        this.syncLocalToMemory(map);
    }

    public /* synthetic */ AVSessionCacheHelper$SessionTagCache(AVSessionCacheHelper$1 aVSessionCacheHelper$1) {
        this();
    }

    private void syncLocalToMemory(Map map) {
        boolean bl2;
        Object object = AppConfiguration.getDefaultSetting();
        String string2 = SESSION_TAG_CACHE_KEY;
        String string3 = "{}";
        object = object.getString("sessionids", string2, string3);
        Class<HashMap> clazz = HashMap.class;
        if ((object = (Map)JSON.parseObject((String)object, clazz)) != null && (bl2 = object.isEmpty())) {
            map.clear();
            map.putAll(object);
        }
    }

    private void syncTagsToLocal(Map object) {
        synchronized (this) {
            if (object != null) {
                SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
                String string2 = "sessionids";
                String string3 = SESSION_TAG_CACHE_KEY;
                object = JSON.toJSONString(object);
                systemSetting.saveString(string2, string3, (String)object);
            }
            return;
        }
    }

    public void addSession(String object, String string2) {
        Map map = this.cachedTagMap;
        map.put(object, string2);
        object = AVIMOptions.getGlobalOptions();
        boolean bl2 = ((AVIMOptions)object).isAutoOpen();
        if (bl2) {
            object = this.cachedTagMap;
            this.syncTagsToLocal((Map)object);
        }
    }

    public Map getAllSession() {
        HashMap hashMap = new HashMap();
        Map map = this.cachedTagMap;
        hashMap.putAll(map);
        return hashMap;
    }

    public void removeSession(String object) {
        Map map = this.cachedTagMap;
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            map = this.cachedTagMap;
            map.remove(object);
            object = AVIMOptions.getGlobalOptions();
            boolean bl3 = ((AVIMOptions)object).isAutoOpen();
            if (bl3) {
                object = this.cachedTagMap;
                this.syncTagsToLocal((Map)object);
            }
        }
    }
}

