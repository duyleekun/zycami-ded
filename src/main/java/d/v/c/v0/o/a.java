/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.o;

import com.zhiyun.cama.data.database.AppDatabaseComm;

public final class a
implements Runnable {
    public final /* synthetic */ AppDatabaseComm a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ a(AppDatabaseComm appDatabaseComm, Runnable runnable) {
        this.a = appDatabaseComm;
        this.b = runnable;
    }

    public final void run() {
        AppDatabaseComm appDatabaseComm = this.a;
        Runnable runnable = this.b;
        appDatabaseComm.f(runnable);
    }
}

