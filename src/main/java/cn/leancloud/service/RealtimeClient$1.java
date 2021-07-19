/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

import cn.leancloud.service.RealtimeClient;
import cn.leancloud.service.RealtimeService;
import g.z;
import k.e$a;
import k.h$a;
import k.s;
import k.s$b;
import k.x.a.g;
import k.y.a.a;

public class RealtimeClient$1
implements e.a.v0.g {
    public final /* synthetic */ RealtimeClient this$0;
    public final /* synthetic */ z val$httpClient;

    public RealtimeClient$1(RealtimeClient realtimeClient, z z10) {
        this.this$0 = realtimeClient;
        this.val$httpClient = z10;
    }

    public void accept(String object) {
        Object object2 = new s$b();
        object = ((s$b)object2).c((String)object);
        object2 = a.a();
        object = ((s$b)object).b((h$a)object2);
        object2 = g.d();
        object = ((s$b)object).a((e$a)object2);
        object2 = this.val$httpClient;
        object = ((s$b)object).j((z)object2).f();
        object2 = this.this$0;
        object = (RealtimeService)((s)object).g(RealtimeService.class);
        RealtimeClient.access$002((RealtimeClient)object2, (RealtimeService)object);
    }
}

