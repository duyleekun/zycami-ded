/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.i1.t2;

import android.view.View;
import com.zhiyun.cama.data.database.model.Likes;
import d.v.c.i1.t2.j0;

public final class r
implements View.OnClickListener {
    public final /* synthetic */ j0 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Likes c;

    public /* synthetic */ r(j0 j02, int n10, Likes likes) {
        this.a = j02;
        this.b = n10;
        this.c = likes;
    }

    public final void onClick(View view) {
        j0 j02 = this.a;
        int n10 = this.b;
        Likes likes = this.c;
        j02.p(n10, likes, view);
    }
}

