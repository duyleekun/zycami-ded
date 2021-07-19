/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.t0;

import android.view.View;
import com.zhiyun.cama.cloud_engine.CETemplateFragment;

public final class l
implements Runnable {
    public final /* synthetic */ View a;

    public /* synthetic */ l(View view) {
        this.a = view;
    }

    public final void run() {
        CETemplateFragment.s(this.a);
    }
}

