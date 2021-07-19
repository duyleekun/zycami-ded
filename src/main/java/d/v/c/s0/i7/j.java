/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.i7;

import android.view.View;
import com.zhiyun.cama.camera.widget.StringScrollView$b;

public final class j
implements View.OnClickListener {
    public final /* synthetic */ StringScrollView$b a;
    public final /* synthetic */ int b;

    public /* synthetic */ j(StringScrollView$b b10, int n10) {
        this.a = b10;
        this.b = n10;
    }

    public final void onClick(View view) {
        StringScrollView$b stringScrollView$b = this.a;
        int n10 = this.b;
        stringScrollView$b.b(n10, view);
    }
}

