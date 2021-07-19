/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 */
package d.v.c.i1.t2;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.data.database.model.Likes;
import com.zhiyun.common.util.Windows;
import com.zhiyun.image.Images;
import d.v.c.h1.o;
import d.v.c.i1.t2.j0$a;
import d.v.c.i1.t2.r;
import d.v.c.n0.e;
import d.v.c.v0.u.w;
import d.v.c.w0.qf;
import d.v.e.l.h2;
import d.v.f.f.b;

public class j0
extends o {
    private static DiffUtil$ItemCallback h;
    private b g;

    static {
        j0$a j0$a = new j0$a();
        h = j0$a;
    }

    public j0() {
        DiffUtil$ItemCallback diffUtil$ItemCallback = h;
        super(diffUtil$ItemCallback);
    }

    private /* synthetic */ void o(int n10, Likes likes, View view) {
        this.g.a(view, n10, likes);
    }

    public int a(int n10) {
        return 2131558714;
    }

    public void i(e object, int n10) {
        qf qf2 = (qf)((e)object).a;
        Object object2 = qf2.a.getLayoutParams();
        int n11 = Windows.l(((RecyclerView$ViewHolder)object).itemView.getContext()).getWidth();
        int n12 = h2.b(50.0f);
        float f10 = (float)(n11 - n12) * 1.0f / 8.0f;
        n12 = 0x40400000;
        float f11 = 3.0f;
        object2.height = n11 = (int)(f10 *= f11);
        qf2.a.setLayoutParams(object2);
        object = (Likes)this.getItem(n10);
        if (object == null) {
            return;
        }
        object2 = qf2.a;
        String string2 = w.b(((Likes)object).getSourceUrls());
        float f12 = 12.0f;
        int n13 = h2.b(f12);
        int n14 = 2131232234;
        Images.H((ImageView)object2, string2, n13, n14);
        object2 = w.a(((Likes)object).getDuration());
        qf2.z((String)object2);
        object2 = this.g;
        if (object2 != null) {
            qf2 = qf2.a;
            object2 = new r(this, n10, (Likes)object);
            qf2.setOnClickListener((View.OnClickListener)object2);
        }
    }

    public /* synthetic */ void p(int n10, Likes likes, View view) {
        this.o(n10, likes, view);
    }

    public void q(b b10) {
        this.g = b10;
    }
}

