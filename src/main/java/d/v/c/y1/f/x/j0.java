/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package d.v.c.y1.f.x;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import d.v.c.y1.f.q;
import d.v.c.y1.f.s;
import d.v.c.y1.f.x.w;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.f.d.b$b;
import d.v.f.f.b;
import java.util.ArrayList;

public class j0
extends s {
    private static final int m = 0;
    private static final int n = 1;
    private b l;

    public j0(LifecycleOwner lifecycleOwner, MusicListViewModel musicListViewModel) {
        super(lifecycleOwner, musicListViewModel);
    }

    private /* synthetic */ boolean s(int n10, View view) {
        int n11;
        int n12 = 1;
        if (n10 >= n12 && n10 <= (n11 = this.getItemCount())) {
            Object object = this.d();
            int n13 = n10 + -1;
            object = (q)((ArrayList)object).get(n13);
            b b10 = this.l;
            b10.a(view, n10, object);
        }
        return n12 != 0;
    }

    public void b(b$b b$b, int n10, ViewDataBinding object) {
        int n11 = this.getItemViewType(n10);
        int n12 = 0;
        float f10 = 0.0f;
        int n13 = 1101004800;
        float f11 = 20.0f;
        if (n11 == 0) {
            b$b = b$b.itemView;
            n10 = h2.b(f11);
            int n14 = h2.b(f11);
            b$b.setPadding(n10, 0, n14, 0);
            return;
        }
        n11 = n10 + -1;
        super.b(b$b, n11, (ViewDataBinding)object);
        object = (RecyclerView$LayoutParams)b$b.itemView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)object).bottomMargin = 0;
        View view = b$b.itemView;
        view.setLayoutParams((ViewGroup.LayoutParams)object);
        object = b$b.itemView;
        n11 = h2.b(f11);
        f10 = 8.0f;
        int n15 = h2.b(f10);
        n13 = h2.b(f11);
        n12 = h2.b(f10);
        object.setPadding(n11, n15, n13, n12);
        object = b$b.itemView;
        n11 = o1.e((View)object, 2131099860);
        object.setBackgroundColor(n11);
        object = this.l;
        if (object != null) {
            b$b = b$b.itemView;
            object = new w(this, n10);
            b$b.setOnLongClickListener((View.OnLongClickListener)object);
        }
    }

    public int e(int n10) {
        n10 = n10 == 0 ? 2131558643 : 2131558641;
        return n10;
    }

    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    public int getItemViewType(int n10) {
        if (n10 == 0) {
            return 0;
        }
        return 1;
    }

    public /* synthetic */ boolean t(int n10, View view) {
        return this.s(n10, view);
    }

    public void u(b b10) {
        this.l = b10;
    }
}

