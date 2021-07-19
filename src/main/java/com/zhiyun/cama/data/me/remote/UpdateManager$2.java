/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.zhiyun.cama.data.api.entity.VersionInfoEntity;
import com.zhiyun.cama.data.api.entity.VersionInfoEntity$Result;
import com.zhiyun.cama.data.me.remote.UpdateManager;
import d.v.a.f.b.a;

public class UpdateManager$2
extends a {
    public final /* synthetic */ UpdateManager this$0;
    public final /* synthetic */ VersionInfoEntity$Result val$checkResult;

    public UpdateManager$2(UpdateManager updateManager, VersionInfoEntity$Result versionInfoEntity$Result) {
        this.this$0 = updateManager;
        this.val$checkResult = versionInfoEntity$Result;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.this$0;
        VersionInfoEntity$Result versionInfoEntity$Result = this.val$checkResult;
        UpdateManager.access$100((UpdateManager)object, versionInfoEntity$Result, null, false);
    }

    public void onSuccess(VersionInfoEntity object) {
        UpdateManager updateManager = this.this$0;
        VersionInfoEntity$Result versionInfoEntity$Result = this.val$checkResult;
        object = ((VersionInfoEntity)object).result;
        UpdateManager.access$100(updateManager, versionInfoEntity$Result, (VersionInfoEntity$Result)object, true);
    }
}

