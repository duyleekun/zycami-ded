/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;

public final class a
implements Runnable {
    public final /* synthetic */ AppDatabaseTemplate a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ a(AppDatabaseTemplate appDatabaseTemplate, Runnable runnable) {
        this.a = appDatabaseTemplate;
        this.b = runnable;
    }

    public final void run() {
        AppDatabaseTemplate appDatabaseTemplate = this.a;
        Runnable runnable = this.b;
        appDatabaseTemplate.f(runnable);
    }
}

