/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.zhiyun.cama.data.api.entity.VersionInfoEntity;
import com.zhiyun.cama.data.api.entity.VersionInfoEntity$Result;
import com.zhiyun.cama.data.me.remote.UpdateManager;
import d.v.a.f.b.a;

public class UpdateManager$1
extends a {
    public final /* synthetic */ UpdateManager this$0;

    public UpdateManager$1(UpdateManager updateManager) {
        this.this$0 = updateManager;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        UpdateManager.access$000(this.this$0, null);
    }

    public void onSuccess(VersionInfoEntity object) {
        UpdateManager updateManager = this.this$0;
        object = ((VersionInfoEntity)object).result;
        UpdateManager.access$000(updateManager, (VersionInfoEntity$Result)object);
    }
}

