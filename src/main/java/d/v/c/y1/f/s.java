/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.text.TextPaint
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.TextView
 */
package d.v.c.y1.f;

import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import d.v.c.v0.q.c;
import d.v.c.w0.ub;
import d.v.c.y1.f.g;
import d.v.c.y1.f.q;
import d.v.c.y1.f.s$a;
import d.v.c.y1.f.u;
import d.v.e.f;
import d.v.e.l.d2;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.f.d.b;
import d.v.f.d.b$b;

public class s
extends b {
    private static final float i = o1.j(f.a().c().getResources(), 2131165370);
    private static final float j = o1.j(f.a().c().getResources(), 2131165369);
    private static final int k = h2.b(6.0f);
    private MusicListViewModel g;
    private u h;

    public s(LifecycleOwner lifecycleOwner, MusicListViewModel musicListViewModel) {
        s$a s$a = new s$a();
        super(lifecycleOwner, musicListViewModel, s$a);
        this.g = musicListViewModel;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int o(TextView object) {
        TextPaint textPaint = object.getPaint();
        String string2 = d.v.f.i.g.q((View)object, 2131952034);
        float f10 = d2.d((Paint)textPaint, string2);
        int n10 = k * 2;
        float f11 = n10;
        float f12 = (f10 += f11) - (f11 = i);
        Object object2 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object2 >= 0) {
            f11 = j;
            float f13 = f10 - f11;
            Object object3 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object3 <= 0) return (int)f10;
        }
        f10 = f11;
        return (int)f10;
    }

    private /* synthetic */ void p(int n10, View object) {
        object = (q)this.d().get(n10);
        boolean bl2 = ((c)object).z();
        if (bl2) {
            u u10 = this.h;
            if (u10 != null) {
                u10.i((q)object);
            }
        } else {
            this.notifyItemChanged(n10);
            this.g.n();
            MusicListViewModel musicListViewModel = this.g;
            musicListViewModel.o((q)object);
        }
    }

    public void b(b$b object, int n10, ViewDataBinding object2) {
        int n11;
        object2 = (ub)object2;
        object = (q)this.d().get(n10);
        ((ub)object2).C((q)object);
        object = n10;
        ((ub)object2).E((Integer)object);
        this.g.n();
        object = this.g;
        ((ub)object2).D((MusicListViewModel)object);
        object = ((ub)object2).h.getLayoutParams();
        TextView textView = ((ub)object2).h;
        ((ViewGroup.LayoutParams)object).width = n11 = this.o(textView);
        ((ub)object2).h.setLayoutParams((ViewGroup.LayoutParams)object);
        object = ((ub)object2).e;
        object2 = new g(this, n10);
        object.setOnClickListener((View.OnClickListener)object2);
    }

    public int e(int n10) {
        return 2131558641;
    }

    public /* synthetic */ void q(int n10, View view) {
        this.p(n10, view);
    }

    public void r(u u10) {
        this.h = u10;
    }
}

