/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

import cn.leancloud.core.AppConfiguration;
import cn.leancloud.json.JSONObject;
import cn.leancloud.service.RealtimeClient;
import e.a.v0.o;
import java.util.Map;

public class RealtimeClient$4
implements o {
    public final /* synthetic */ RealtimeClient this$0;

    public RealtimeClient$4(RealtimeClient realtimeClient) {
        this.this$0 = realtimeClient;
    }

    public JSONObject apply(Map map) {
        return AppConfiguration.getJsonParser().toJSONObject(map);
    }
}

