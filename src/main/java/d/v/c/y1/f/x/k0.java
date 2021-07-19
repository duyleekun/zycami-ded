/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.y1.f.x;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import d.v.c.w0.ub;
import d.v.c.y1.f.q;
import d.v.c.y1.f.s;
import d.v.c.y1.f.x.x;
import d.v.f.d.b$b;
import d.v.f.f.b;

public class k0
extends s {
    private b l;

    public k0(LifecycleOwner lifecycleOwner, MusicListViewModel musicListViewModel) {
        super(lifecycleOwner, musicListViewModel);
    }

    private /* synthetic */ void p(int n10, View view) {
        int n11;
        Object object = this.l;
        if (object == null) {
            return;
        }
        if (n10 >= 0 && n10 < (n11 = this.getItemCount())) {
            object = (q)this.d().get(n10);
            b b10 = this.l;
            b10.a(view, n10, object);
        }
    }

    public void b(b$b object, int n10, ViewDataBinding object2) {
        super.b((b$b)object, n10, (ViewDataBinding)object2);
        object2 = (ub)object2;
        object = Boolean.TRUE;
        ((ub)object2).F((Boolean)object);
        object = ((ub)object2).a;
        object2 = new x(this, n10);
        object.setOnClickListener((View.OnClickListener)object2);
    }

    public /* synthetic */ void s(int n10, View view) {
        this.p(n10, view);
    }

    public void t(b b10) {
        this.l = b10;
    }
}

