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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import d.v.c.y1.f.q;
import d.v.c.y1.f.x.c0;
import d.v.c.y1.f.x.d0;
import d.v.c.y1.f.x.g0;
import d.v.c.y1.f.x.h;
import d.v.c.y1.f.x.i;
import d.v.c.y1.f.x.j;
import d.v.c.y1.f.x.k;
import d.v.c.y1.f.x.l0;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class g0$a {
    public final /* synthetic */ g0 a;

    public g0$a(g0 g02) {
        this.a = g02;
    }

    public static /* synthetic */ void a(List object, List object2, q q10) {
        String string2;
        String string3 = q10.G().g();
        boolean bl2 = string3.startsWith(string2 = d.v.c.d0.b(EditConfig$ResourceType.MUSIC).getAbsolutePath());
        if (bl2) {
            object2 = q10.G().g();
            object.add(object2);
        } else {
            object = q10.G().g();
            object2.add(object);
        }
    }

    private /* synthetic */ void b(DialogFragment object) {
        ((DialogFragment)object).dismissAllowingStateLoss();
        g0.x(this.a).m();
        object = g0.x(this.a);
        int n10 = -1;
        ((MusicPlayVieModel)object).l(n10);
        object = new ArrayList();
        ArrayList arrayList = new ArrayList();
        MusicLocalImportViewModel musicLocalImportViewModel = (MusicLocalImportViewModel)b.a(this.a).get(MusicLocalImportViewModel.class);
        Stream stream = g0.w(this.a).d().stream();
        Object object2 = c0.a;
        stream = stream.filter(object2);
        object2 = new k(arrayList, (List)object);
        stream.forEach(object2);
        int n11 = object.size();
        int n12 = arrayList.size();
        n11 += n12;
        object2 = g0.w(this.a);
        n12 = ((d.v.f.d.b)object2).getItemCount();
        if (n11 == n12) {
            n11 = 1;
        } else {
            n11 = 0;
            stream = null;
        }
        musicLocalImportViewModel.V((List)object);
        musicLocalImportViewModel.U(arrayList);
        object = g0.v(this.a);
        ((l0)object).j(0);
        if (n11 != 0) {
            object = this.a;
            g0.u((g0)object);
        }
    }

    public static /* synthetic */ void d(q q10) {
        q10.J(false);
    }

    public static /* synthetic */ void e(q q10) {
        q10.J(true);
    }

    public /* synthetic */ void c(DialogFragment dialogFragment) {
        this.b(dialogFragment);
    }

    public void f(View view) {
        g0.u(this.a);
    }

    public void g(View object) {
        Context context = object.getContext();
        Object object2 = new k$b(context);
        object = g.q((View)object, 2131952024);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = d0.a;
        object = (k$b)((k$a)object).o(2131951833, (a)object2);
        object2 = new i(this);
        object = (k$b)((k$a)object).v(2131951887, (a)object2);
        object2 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public void h(View object) {
        object = g0.v(this.a);
        boolean bl2 = ((l0)object).c();
        if (bl2) {
            object = g0.v(this.a);
            boolean bl3 = false;
            ((l0)object).i(false);
            g0.v(this.a).j(0);
            object = g0.w(this.a).d();
            j j10 = j.a;
            ((ArrayList)object).forEach(j10);
        } else {
            g0.v(this.a).i(true);
            object = g0.v(this.a);
            int n10 = g0.w(this.a).getItemCount();
            ((l0)object).j(n10);
            object = g0.w(this.a).d();
            h h10 = h.a;
            ((ArrayList)object).forEach(h10);
        }
        g0.w(this.a).notifyDataSetChanged();
    }
}

