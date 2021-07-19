/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.CheckedTextView
 */
package d.v.c.s0.h7.s0;

import android.content.Context;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel$ReviewStatus;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.s0.a;
import d.v.c.s0.h7.s0.d;
import d.v.c.s0.h7.s0.e;
import d.v.c.s0.h7.s0.y;
import d.v.c.s0.h7.u0.l;
import d.v.e.l.h2;
import d.v.e.l.s1;
import d.v.g0.k$b;
import d.v.v.g.g;
import java.util.List;

public class y$b {
    public final /* synthetic */ y a;

    public y$b(y y10) {
        this.a = y10;
    }

    /*
     * WARNING - void declaration
     */
    private void d() {
        void var3_6;
        Object object = this.a.getContext();
        k$b k$b = new k$b((Context)object);
        object = y.r(this.a);
        boolean n10 = ((l)object).r();
        if (n10) {
            int n11 = 2131953152;
        } else {
            int n12 = 2131952144;
        }
        k$b = (k$b)k$b.m((int)var3_6);
        int n13 = h2.b(320.0f);
        k$b = (k$b)((k$b)k$b.g(n13, -1)).j(270);
        d.v.f.f.a a10 = d.v.c.s0.h7.s0.a.a;
        k$b = (k$b)k$b.o(2131951833, a10);
        a10 = new e(this);
        k$b = (k$b)k$b.v(2131952621, a10);
        object = this.a.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    private /* synthetic */ void e(DialogFragment object) {
        Object object2 = y.r(this.a);
        boolean bl2 = object2.r();
        if (bl2) {
            object2 = y.m(this.a);
            ((m0)object2).e();
        }
        ((DialogFragment)object).dismiss();
        y.k(this.a).e();
        object = y.m(this.a);
        object2 = CameraSet$StoryState.STORY_LIST;
        ((m0)object).g0((CameraSet$StoryState)((Object)object2));
    }

    private /* synthetic */ void g(View object) {
        object = y.k(this.a);
        String string2 = y.m(this.a).o().getTemplateData().getTextEn();
        List list = y.j(this.a).Y();
        ((StoryReviewViewModel)object).H(string2, list);
    }

    public void a() {
        this.d();
    }

    public void b() {
        y.s((y)this.a).m.b();
        ViewModel viewModel = y.k(this.a);
        Object object = StoryReviewViewModel$ReviewStatus.TOTAL_REVIEW;
        ((StoryReviewViewModel)viewModel).M((StoryReviewViewModel$ReviewStatus)((Object)object));
        viewModel = y.j(this.a);
        object = y.s((y)this.a).m.getPlayerView();
        ((TemplateEditViewModel)viewModel).w((g)((Object)object));
        viewModel = y.j(this.a);
        long l10 = y.j(this.a).K();
        ((TemplateEditViewModel)viewModel).G0(l10);
    }

    public void c(View view, int n10) {
        view = (CheckedTextView)view;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n10 = 0;
                Object var4_4 = null;
            } else {
                StoryReviewViewModel storyReviewViewModel = y.k(this.a);
                n10 = (int)(storyReviewViewModel.N() ? 1 : 0);
            }
        } else {
            StoryReviewViewModel storyReviewViewModel = y.k(this.a);
            n10 = (int)(storyReviewViewModel.P() ? 1 : 0);
        }
        view.setChecked(n10 != 0);
    }

    public /* synthetic */ void f(DialogFragment dialogFragment) {
        this.e(dialogFragment);
    }

    public /* synthetic */ void h(View view) {
        this.g(view);
    }

    public void i(int n10) {
        int n11;
        Object object = y.j(this.a);
        boolean n112 = ((TemplateEditViewModel)object).t0();
        if (n112 && n10 != (n11 = ((StoryReviewViewModel)(object = y.k(this.a))).r())) {
            object = y.l(this.a);
            int n12 = object.indexOfKey(n10);
            if (n12 >= 0) {
                y.k(this.a).L(n10);
                y.m(this.a).c0(n10);
                Object object2 = this.a;
                y.n((y)object2, false, n12);
                object2 = y.k(this.a);
                boolean bl2 = true;
                ((StoryReviewViewModel)object2).K(bl2);
                object2 = this.a;
                y.o((y)object2);
            } else {
                object = this.a;
                y.p((y)object, n10);
            }
        }
    }

    public void j(View view) {
        int n10 = y.k(this.a).r();
        s1.h(y.m(this.a).k());
        y.m(this.a).a0(n10);
        MutableLiveData mutableLiveData = y.m(this.a).s();
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
        y.p(this.a, n10);
    }

    public void k(View view) {
        y.q(this.a);
    }

    public d.v.f.f.d l() {
        Object object = y.m(this.a).o();
        if (object == null) {
            return null;
        }
        object = new d(this);
        return object;
    }
}

