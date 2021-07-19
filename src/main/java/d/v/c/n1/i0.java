/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.n1;

import android.view.View;
import com.zhiyun.cama.publish.PublishFragment$f;

public final class i0
implements Runnable {
    public final /* synthetic */ PublishFragment$f a;
    public final /* synthetic */ View b;

    public /* synthetic */ i0(PublishFragment$f publishFragment$f, View view) {
        this.a = publishFragment$f;
        this.b = view;
    }

    public final void run() {
        PublishFragment$f publishFragment$f = this.a;
        View view = this.b;
        publishFragment$f.m(view);
    }
}

