/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.database.model.PublishLog;
import com.zhiyun.cama.data.me.PublishLogManager;

public final class l
implements Runnable {
    public final /* synthetic */ PublishLogManager a;
    public final /* synthetic */ PublishLog b;

    public /* synthetic */ l(PublishLogManager publishLogManager, PublishLog publishLog) {
        this.a = publishLogManager;
        this.b = publishLog;
    }

    public final void run() {
        PublishLogManager publishLogManager = this.a;
        PublishLog publishLog = this.b;
        publishLogManager.g(publishLog);
    }
}

