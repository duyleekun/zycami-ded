/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package d.v.c.s0.h7.r0;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;
import com.zhiyun.common.util.Windows;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.n0.c;
import d.v.c.n0.e;
import d.v.c.s0.h7.r0.j;
import d.v.c.s0.h7.r0.t;
import d.v.c.s0.h7.r0.u;
import d.v.c.w0.mh;
import d.v.c.w0.qh;
import d.v.e.l.h2;
import java.util.ArrayList;
import java.util.List;

public class t$b
extends c {
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    public final /* synthetic */ t f;

    public t$b(t t10) {
        int n10;
        this.f = t10;
        this.b = 1001;
        this.c = 1002;
        this.d = n10 = Windows.l(t10.requireContext()).getHeight() / 3;
        float f10 = 4.0f;
        int n11 = h2.b(f10);
        n10 = (int)((double)(n10 - n11) * 1.7778);
        int n12 = h2.b(f10);
        this.e = n10 += n12;
    }

    public static /* synthetic */ void e(t$b t$b) {
        t$b.i();
    }

    private /* synthetic */ void g(int n10, View object) {
        object = t.l(this.f);
        int n11 = ((u)object).b();
        if (n11 > n10) {
            object = this.f;
            t.q((t)object, n10 += -2);
        } else {
            object = this.f;
            t.q((t)object, n10);
        }
    }

    private void i() {
        Object object = this.f;
        RecyclerView recyclerView = object.f.b;
        int n10 = t.l((t)object).b();
        boolean bl2 = (object = recyclerView.findViewHolderForAdapterPosition(n10)) instanceof e;
        if (bl2) {
            object = ((qh)((e)object).a).b;
            ((StoryReviewVideoView)((Object)object)).p();
        }
    }

    public int a(int n10) {
        int n11 = 1002;
        if (n11 != n10 && (n11 = 1001) != n10) {
            return 2131558786;
        }
        return 2131558784;
    }

    public void b(e object, int n10) {
        int n11 = 1001;
        int n12 = this.getItemViewType(n10);
        if (n11 != n12 && (n11 = 1002) != n12) {
            object = (qh)((e)object).a;
            Object object2 = ((ViewDataBinding)object).getRoot();
            n11 = 0;
            object2.setVisibility(0);
            object2 = this.f(n10).getTemplateData();
            ((qh)object).z((TemplateData)object2);
            Object object3 = ((qh)object).b;
            String string2 = ((TemplateData)object2).getCoverUrl();
            ((StoryReviewVideoView)((Object)object3)).setCoverPath(string2);
            object3 = this.f;
            int n13 = t.p((t)object3);
            if (n13 != 0 && (n13 = ((u)(object3 = t.l(this.f))).b()) == n10) {
                Object object4 = ((qh)object).c;
                n11 = 8;
                object4.setVisibility(n11);
                object4 = ((qh)object).b;
                object2 = ((TemplateData)object2).getVideoUrl();
                ((StoryReviewVideoView)((Object)object4)).n((String)object2);
                object = ((qh)object).b;
                n10 = 1;
                ((StoryReviewVideoView)((Object)object)).o(n10 != 0);
            } else {
                ((qh)object).c.setVisibility(0);
                ((qh)object).b.p();
                ((qh)object).b.o(false);
                ((qh)object).b.a();
                object = ((qh)object).c;
                object2 = new j(this, n10);
                object.setOnClickListener((View.OnClickListener)object2);
            }
        } else {
            object = ((e)object).a.getRoot();
            n10 = 4;
            object.setVisibility(n10);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public e c(ViewGroup object, int n10) {
        void var2_3;
        e e10 = super.c((ViewGroup)object, (int)var2_3);
        int n11 = 1001;
        float f10 = 1.403E-42f;
        if (n11 != var2_3) {
            n11 = 1002;
            f10 = 1.404E-42f;
            if (n11 != var2_3) {
                int n12;
                Object object2 = (qh)e10.a;
                ViewGroup.LayoutParams layoutParams = ((qh)object2).b.getLayoutParams();
                layoutParams.height = n12 = this.d;
                layoutParams.width = n12 = this.e;
                StoryReviewVideoView storyReviewVideoView = ((qh)object2).b;
                storyReviewVideoView.setLayoutParams(layoutParams);
                object2 = ((qh)object2).b;
                f10 = 2.0f;
                n11 = h2.b(f10);
                ((StoryReviewVideoView)((Object)object2)).setVideoMargin(n11);
                return e10;
            }
        }
        mh mh2 = (mh)e10.a;
        ViewGroup.LayoutParams layoutParams = mh2.a.getLayoutParams();
        t t10 = this.f;
        int n13 = t.o(t10);
        int n14 = this.e;
        n13 -= n14;
        float f11 = 16.0f;
        n14 = h2.b(f11);
        layoutParams.width = n13 = (n13 - n14) / 2;
        mh2 = mh2.a;
        mh2.setLayoutParams(layoutParams);
        return e10;
    }

    public void d(List arrayList) {
        int n10;
        if (arrayList != null && (n10 = arrayList.size()) > 0) {
            super.d(arrayList);
        } else {
            arrayList = new ArrayList();
            super.d(arrayList);
        }
    }

    public TemplatePOJO f(int n10) {
        int n11;
        if (n10 > 0 && n10 < (n11 = this.getItemCount() + -1)) {
            return (TemplatePOJO)super.getItem(n10 += -1);
        }
        return null;
    }

    public int getItemCount() {
        return super.getItemCount() + 2;
    }

    public int getItemViewType(int n10) {
        if (n10 == 0) {
            return 1001;
        }
        int n11 = this.getItemCount() + -1;
        if (n11 == n10) {
            return 1002;
        }
        return super.getItemViewType(n10);
    }

    public /* synthetic */ void h(int n10, View view) {
        this.g(n10, view);
    }
}

