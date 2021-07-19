/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.j1.a.q0;

import android.view.View;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView$a;

public final class d
implements View.OnClickListener {
    public final /* synthetic */ AddImageRecyclerView$a a;
    public final /* synthetic */ int b;

    public /* synthetic */ d(AddImageRecyclerView$a a10, int n10) {
        this.a = a10;
        this.b = n10;
    }

    public final void onClick(View view) {
        AddImageRecyclerView$a addImageRecyclerView$a = this.a;
        int n10 = this.b;
        addImageRecyclerView$a.f(n10, view);
    }
}

