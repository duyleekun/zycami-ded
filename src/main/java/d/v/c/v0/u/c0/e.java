/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.c0;

import com.zhiyun.cama.data.me.remote.AppealTask;

public final class e
implements Runnable {
    public final /* synthetic */ AppealTask a;
    public final /* synthetic */ Exception b;

    public /* synthetic */ e(AppealTask appealTask, Exception exception) {
        this.a = appealTask;
        this.b = exception;
    }

    public final void run() {
        AppealTask appealTask = this.a;
        Exception exception = this.b;
        appealTask.h(exception);
    }
}

