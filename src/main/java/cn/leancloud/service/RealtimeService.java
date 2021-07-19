/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

import cn.leancloud.json.JSONObject;
import e.a.z;
import java.util.Map;

public interface RealtimeService {
    public z createSignature(JSONObject var1);

    public z queryMemberInfo(String var1, Map var2);

    public z subscribe(JSONObject var1);

    public z unsubscribe(JSONObject var1);
}

