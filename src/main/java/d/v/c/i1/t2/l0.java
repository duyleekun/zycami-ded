/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 */
package d.v.c.i1.t2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.data.database.model.Works;
import com.zhiyun.common.util.Windows;
import com.zhiyun.image.Images;
import d.v.c.h1.o;
import d.v.c.i1.t2.l0$a;
import d.v.c.i1.t2.v;
import d.v.c.n0.e;
import d.v.c.v0.u.w;
import d.v.c.w0.qf;
import d.v.e.l.h2;
import d.v.f.f.b;
import d.v.f.i.g;

public class l0
extends o {
    private static DiffUtil$ItemCallback h;
    private b g;

    static {
        l0$a l0$a = new l0$a();
        h = l0$a;
    }

    public l0() {
        DiffUtil$ItemCallback diffUtil$ItemCallback = h;
        super(diffUtil$ItemCallback);
    }

    private /* synthetic */ void o(int n10, Works works, View view) {
        this.g.a(view, n10, works);
    }

    public int a(int n10) {
        return 2131558714;
    }

    public void i(e object, int n10) {
        Object object2 = (qf)((e)object).a;
        Object object3 = ((qf)object2).a.getLayoutParams();
        int n11 = Windows.l(((RecyclerView$ViewHolder)object).itemView.getContext()).getWidth();
        int n12 = h2.b(50.0f);
        float f10 = (float)(n11 - n12) * 1.0f / 8.0f;
        n12 = 0x40400000;
        float f11 = 3.0f;
        ((ViewGroup.LayoutParams)object3).height = n11 = (int)(f10 *= f11);
        Object object4 = ((qf)object2).a;
        object4.setLayoutParams((ViewGroup.LayoutParams)object3);
        object3 = (Works)this.getItem(n10);
        if (object3 == null) {
            return;
        }
        object4 = ((qf)object2).a;
        String string2 = w.b(((Works)object3).getSourceUrls());
        float f12 = 12.0f;
        int n13 = h2.b(f12);
        int n14 = 2131232234;
        Images.H((ImageView)object4, string2, n13, n14);
        object4 = w.a(((Works)object3).getDuration());
        ((qf)object2).z((String)object4);
        object4 = ((Works)object3).getStatus();
        if (object4 == null) {
            object4 = "-1";
        }
        ((String)object4).hashCode();
        string2 = "2";
        n12 = (int)(((String)object4).equals(string2) ? 1 : 0);
        n13 = 0;
        f12 = 0.0f;
        if (n12 == 0) {
            string2 = "3";
            n11 = (int)(((String)object4).equals(string2) ? 1 : 0);
            if (n11 == 0) {
                object = ((qf)object2).b;
                n11 = 8;
                f10 = 1.1E-44f;
                object.setVisibility(n11);
            } else {
                ((qf)object2).b.setVisibility(0);
                object4 = ((qf)object2).b;
                object = ((RecyclerView$ViewHolder)object).itemView;
                n12 = 2131951682;
                f11 = 1.9539785E38f;
                object = d.v.f.i.g.q((View)object, n12);
                object4.setText((CharSequence)object);
            }
        } else {
            ((qf)object2).b.setVisibility(0);
            object4 = ((qf)object2).b;
            object = ((RecyclerView$ViewHolder)object).itemView;
            n12 = 2131951654;
            f11 = 1.9539729E38f;
            object = d.v.f.i.g.q((View)object, n12);
            object4.setText((CharSequence)object);
        }
        object = this.g;
        if (object != null) {
            object = ((qf)object2).a;
            object2 = new v(this, n10, (Works)object3);
            object.setOnClickListener((View.OnClickListener)object2);
        }
    }

    public /* synthetic */ void p(int n10, Works works, View view) {
        this.o(n10, works, view);
    }

    public void q(b b10) {
        this.g = b10;
    }
}

