/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.c.y1.f.x;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import d.v.c.q0.f.a;
import d.v.c.y1.f.q;
import d.v.c.y1.f.x.e0;
import d.v.c.y1.f.x.i0;
import d.v.c.y1.f.x.p;
import d.v.e.i.h;
import d.v.e.l.n2;
import d.v.f.g.b;
import d.v.f.i.g;
import java.util.List;

public class i0$a
implements a {
    public final /* synthetic */ i0 a;

    public i0$a(i0 i02) {
        this.a = i02;
    }

    private /* synthetic */ void d(List object) {
        long l10;
        e0 e02;
        Object object2 = object.stream();
        long l11 = 0L;
        Long l12 = l11;
        long l13 = (Long)(object2 = object2.reduce(l12, e02 = e0.a));
        long l14 = l13 - (l10 = (long)(object.size() * -1));
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 != false) {
            object3 = 1;
        } else {
            object3 = 0;
            object = null;
        }
        if (object3 != false) {
            object = this.a.requireContext();
            int n10 = 2131952064;
            n2.e(g.m((Context)object, n10));
            object = this.a;
            ((b)object).i();
        } else {
            object = this.a.requireContext();
            int n11 = 2131952061;
            object = g.m((Context)object, n11);
            n2.e((String)object);
        }
    }

    public void a(View view) {
        this.a.i();
    }

    public void b(View object) {
        boolean bl2;
        object = i0.w(this.a);
        boolean bl3 = ((MusicLocalImportViewModel)object).G();
        Object object2 = i0.x(this.a).d();
        int n10 = 0;
        while (true) {
            int n11 = object2.size();
            bl2 = true;
            if (n10 >= n11) break;
            q q10 = (q)object2.get(n10);
            boolean bl4 = q10.I();
            if (!bl4) {
                MusicLocalImportViewModel musicLocalImportViewModel;
                if (bl3) {
                    bl2 = q10.H();
                    if (bl2) {
                        q10.J(false);
                        i0.x(this.a).notifyItemChanged(n10);
                        musicLocalImportViewModel = i0.w(this.a);
                        musicLocalImportViewModel.T(q10);
                    }
                } else {
                    bl4 = q10.H();
                    if (!bl4) {
                        q10.J(bl2);
                        i0.x(this.a).notifyItemChanged(n10);
                        musicLocalImportViewModel = i0.w(this.a);
                        musicLocalImportViewModel.x(q10);
                    }
                }
            }
            ++n10;
        }
        object2 = i0.w(this.a).H();
        object = bl3 ^ bl2;
        h.g((MutableLiveData)object2, object);
    }

    public void c() {
        MusicLocalImportViewModel musicLocalImportViewModel = i0.w(this.a);
        p p10 = new p(this);
        musicLocalImportViewModel.S(p10);
    }

    public /* synthetic */ void e(List list) {
        this.d(list);
    }

    public void f() {
        i0.w(this.a).M();
        i0.y((i0)this.a).e.e();
    }
}

