/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.c0;

import com.zhiyun.cama.data.me.remote.AppealTask;

public final class b
implements Runnable {
    public final /* synthetic */ AppealTask a;

    public /* synthetic */ b(AppealTask appealTask) {
        this.a = appealTask;
    }

    public final void run() {
        this.a.f();
    }
}

