/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.t0;

import android.view.View;
import com.zhiyun.cama.cloud_engine.CEVideoSizeDialog$a;

public final class r
implements Runnable {
    public final /* synthetic */ View a;

    public /* synthetic */ r(View view) {
        this.a = view;
    }

    public final void run() {
        CEVideoSizeDialog$a.c(this.a);
    }
}

