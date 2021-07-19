/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.c0;

import com.zhiyun.cama.data.api.entity.IntegerEntity;
import com.zhiyun.cama.data.me.remote.AppealTask;

public final class c
implements Runnable {
    public final /* synthetic */ AppealTask a;
    public final /* synthetic */ IntegerEntity b;

    public /* synthetic */ c(AppealTask appealTask, IntegerEntity integerEntity) {
        this.a = appealTask;
        this.b = integerEntity;
    }

    public final void run() {
        AppealTask appealTask = this.a;
        IntegerEntity integerEntity = this.b;
        appealTask.b(integerEntity);
    }
}

