/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.i1.t2;

import android.view.View;
import com.zhiyun.cama.data.database.model.Works;
import d.v.c.i1.t2.l0;

public final class v
implements View.OnClickListener {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Works c;

    public /* synthetic */ v(l0 l02, int n10, Works works) {
        this.a = l02;
        this.b = n10;
        this.c = works;
    }

    public final void onClick(View view) {
        l0 l02 = this.a;
        int n10 = this.b;
        Works works = this.c;
        l02.p(n10, works, view);
    }
}

