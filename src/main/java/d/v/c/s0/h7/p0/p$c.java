/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 */
package d.v.c.s0.h7.p0;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.protocol.constants.Model;
import d.v.c.m1.b;
import d.v.c.s0.h7.l0;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.p0.a;
import d.v.c.s0.h7.p0.d;
import d.v.c.s0.h7.p0.e;
import d.v.c.s0.h7.p0.p;
import d.v.c.s0.h7.p0.q;
import d.v.e.l.n2;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;

public class p$c {
    public final /* synthetic */ p a;

    public p$c(p p10) {
        this.a = p10;
    }

    private void a(TemplatePOJO object) {
        ViewModel viewModel = p.n(this.a);
        CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_RECORD;
        ((m0)viewModel).g0(cameraSet$StoryState);
        viewModel = p.q(this.a);
        object = l0.a((TemplatePOJO)object);
        ((q)viewModel).p((String)object);
    }

    private /* synthetic */ void f(TemplateData object, int n10, DialogFragment dialogFragment) {
        p.n(this.a).f((TemplateData)object);
        object = p.n(this.a);
        ((m0)object).d0(n10 += -1);
    }

    public static /* synthetic */ void h(DialogFragment dialogFragment) {
    }

    public void b(TemplateData object, int n10) {
        Object object2 = this.a.getContext();
        k$b k$b = new k$b((Context)object2);
        k$b = (k$b)k$b.A(2131953114);
        object2 = d.v.c.s0.h7.p0.a.a;
        k$b = (k$b)k$b.p((d.v.f.f.a)object2);
        object2 = new d(this, (TemplateData)object, n10);
        object = (k$b)k$b.w((d.v.f.f.a)object2);
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        ((k$a)object).D(fragmentManager);
    }

    public void c(TemplateData object) {
        object = p.n(this.a);
        if (object != null) {
            object = p.n(this.a);
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_SAVE;
            ((m0)object).g0(cameraSet$StoryState);
        }
    }

    public void d() {
        m0 m02 = p.n(this.a);
        if (m02 != null) {
            m02 = p.n(this.a);
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_MORE;
            m02.g0(cameraSet$StoryState);
        }
    }

    public void e() {
        m0 m02 = p.n(this.a);
        if (m02 != null) {
            m02 = p.n(this.a);
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.NONE;
            m02.g0(cameraSet$StoryState);
        }
    }

    public /* synthetic */ void g(TemplateData templateData, int n10, DialogFragment dialogFragment) {
        this.f(templateData, n10, dialogFragment);
    }

    public void i(View object, int n10) {
        if (n10 == 0) {
            object = Model.SMOOTHQ3;
            Object object2 = p.r(this.a).x();
            if (object != object2) {
                object2 = this.a.getContext();
                object = new k$b((Context)object2);
                object2 = this.a.getResources();
                int n11 = 2131953155;
                object2 = g.o((Resources)object2, n11);
                object = (k$b)object.B((String)object2);
                object2 = e.a;
                object = (k$b)((k$b)object.w((d.v.f.f.a)object2)).s();
                object2 = this.a.getChildFragmentManager();
                object.D((FragmentManager)object2);
            } else {
                object = p.n(this.a);
                object2 = CameraSet$StoryState.STORY_PERSONAL;
                object.g0((CameraSet$StoryState)((Object)object2));
                object = p.q(this.a);
                object2 = "";
                object.p((String)object2);
            }
        } else {
            p.s(this.a);
            object = p.n(this.a).o();
            Object object3 = p.n(this.a);
            n10 = (int)(((m0)object3).M((TemplatePOJO)object) ? 1 : 0);
            if (n10 != 0) {
                object3 = object.getTemplateData();
                n10 = (int)(((TemplateData)object3).isPrimeUsable() ? 1 : 0);
                if (n10 == 0) {
                    this.a((TemplatePOJO)object);
                    return;
                }
                object3 = this.a.requireContext();
                n10 = (int)(b.b((Context)object3) ? 1 : 0);
                if (n10 != 0) {
                    this.a((TemplatePOJO)object);
                }
            } else {
                object = this.a.getResources();
                n10 = 2131953150;
                object = g.o((Resources)object, n10);
                n2.e((String)object);
            }
        }
    }

    public void j() {
        m0 m02 = p.n(this.a);
        if (m02 != null) {
            m02 = p.n(this.a);
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_DRAFT;
            m02.g0(cameraSet$StoryState);
        }
    }
}

