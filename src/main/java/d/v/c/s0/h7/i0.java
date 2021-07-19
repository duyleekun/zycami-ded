/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 */
package d.v.c.s0.h7;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.h7.a;
import d.v.c.s0.h7.c;
import d.v.c.s0.h7.d;
import d.v.c.s0.h7.i0$a;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.o0.v0;
import d.v.c.s0.h7.p0.p;
import d.v.c.s0.h7.r0.r;
import d.v.c.s0.h7.s0.y;
import d.v.c.s0.h7.t0.b;
import d.v.c.s0.h7.u0.l;
import d.v.c.s0.u6;
import d.v.c.w0.yh;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.e.l.n2;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.j0.d$c;
import d.v.j0.d$d;
import java.util.Iterator;

public class i0 {
    private final u6 a;
    private final m0 b;
    private final l c;
    private String d;
    private int[] e;
    private m2$d f;

    public i0(u6 u62, m0 m02, l l10) {
        this.a = u62;
        this.b = m02;
        this.c = l10;
    }

    public static /* synthetic */ int[] a(i0 i02) {
        return i02.e;
    }

    public static /* synthetic */ m2$d b(i0 i02) {
        return i02.f;
    }

    private /* synthetic */ void d(DialogFragment object) {
        Object object2 = this.c;
        boolean bl2 = object2.r();
        if (bl2) {
            object2 = this.b;
            ((m0)object2).e();
        }
        ((DialogFragment)object).dismiss();
        object = this.b;
        object2 = CameraSet$StoryState.STORY_LIST;
        ((m0)object).g0((CameraSet$StoryState)((Object)object2));
    }

    private /* synthetic */ void f(ExoVideoView object, d.v.j0.d d10) {
        m2$d m2$d = this.f;
        if (m2$d != null) {
            m2$d.a();
        }
        int n10 = d10.getDuration();
        i0$a i0$a = new i0$a(this, d10, n10, (ExoVideoView)object);
        this.f = object = m2.i(0L, 30, i0$a);
    }

    private /* synthetic */ boolean h(d.v.j0.d object, int n10, int n11) {
        int n12 = 3;
        if (n10 == n12) {
            object = this.b;
            n10 = 1;
            ((m0)object).i0(n10 != 0);
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private boolean m(Context object, boolean bl2, TemplatePOJO templatePOJO) {
        TemplateData templateData;
        boolean bl3;
        void var3_5;
        boolean bl4 = false;
        if (!bl2) {
            return false;
        }
        if (var3_5 == null || !(bl3 = (templateData = var3_5.getTemplateData()).isDownloadFinished())) {
            bl4 = true;
        }
        if (bl4) {
            object = object.getResources();
            int n10 = 2131953150;
            object = g.o((Resources)object, n10);
            n2.e((String)object);
        }
        return bl4;
    }

    public boolean c(Context object, TemplatePOJO templatePOJO) {
        m0 m02 = this.b;
        boolean bl2 = m02.I();
        boolean bl3 = this.m((Context)object, bl2, templatePOJO);
        boolean bl4 = false;
        if (bl3) {
            return false;
        }
        if (templatePOJO == null) {
            return false;
        }
        if (!bl2 || (object = this.b.l) != null) {
            bl4 = true;
        }
        return bl4;
    }

    public /* synthetic */ void e(DialogFragment dialogFragment) {
        this.d(dialogFragment);
    }

    public /* synthetic */ void g(ExoVideoView exoVideoView, d.v.j0.d d10) {
        this.f(exoVideoView, d10);
    }

    public /* synthetic */ boolean i(d.v.j0.d d10, int n10, int n11) {
        return this.h(d10, n10, n11);
    }

    /*
     * WARNING - void declaration
     */
    public void j(Context object, FragmentManager object2) {
        int n10;
        Object object3 = this.b.G();
        if (object3 != null && (n10 = object3.size()) != 0) {
            void var5_8;
            object3 = new k$b((Context)object);
            object = this.c;
            boolean n11 = ((l)object).r();
            if (n11) {
                int n12 = 2131953152;
            } else {
                int n13 = 2131952144;
            }
            object = (k$b)((k$a)object3).m((int)var5_8);
            n10 = h2.b(320.0f);
            object = (k$b)((k$a)object).g(n10, -1);
            d.v.f.f.a a10 = d.v.c.s0.h7.a.a;
            object = (k$b)((k$a)object).o(2131951833, a10);
            a10 = new d.v.c.s0.h7.b(this);
            ((k$b)((k$a)object).v(2131952621, a10)).D((FragmentManager)object2);
            return;
        }
        object = this.b;
        object2 = CameraSet$StoryState.STORY_LIST;
        ((m0)object).g0((CameraSet$StoryState)((Object)object2));
    }

    public void k(FragmentManager fragmentManager) {
        boolean bl2;
        Iterator iterator2 = fragmentManager.getFragments().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Fragment)iterator2.next();
            boolean bl3 = object instanceof y;
            if (!bl3 && !(bl3 = object instanceof p) && !(bl3 = object instanceof b) && !(bl3 = object instanceof r) && !(bl3 = object instanceof d.v.c.s0.h7.q0.y) && !(bl3 = object instanceof v0)) continue;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            object = fragmentTransaction.remove((Fragment)object);
            ((FragmentTransaction)object).commitNow();
        }
    }

    public void l(FragmentManager object, Fragment fragment) {
        if (fragment != null && object != null) {
            object = ((FragmentManager)object).beginTransaction();
            int n10 = 2131362491;
            String string2 = fragment.getClass().getName();
            object = ((FragmentTransaction)object).replace(n10, fragment, string2);
            ((FragmentTransaction)object).commit();
        }
    }

    public void n(yh object) {
        Object object2 = ((yh)object).b;
        Object object3 = this.b;
        boolean bl2 = ((m0)object3).F();
        boolean bl3 = true;
        if (bl2 ^= bl3) {
            object3 = this.d;
            bl2 = TextUtils.isEmpty((CharSequence)object3);
            if (!bl2) {
                ((ExoVideoView)object2).start();
                object = this.b;
                ((m0)object).i0(bl3);
            } else {
                object2 = this.b;
                int n10 = ((m0)object2).j();
                this.o((yh)object, n10, bl3);
            }
        } else {
            ((ExoVideoView)object2).E();
            object = this.b;
            boolean bl4 = false;
            object2 = null;
            ((m0)object).i0(false);
        }
    }

    public void o(yh object, int n10, boolean bl2) {
        CameraSet$StoryState cameraSet$StoryState;
        Object object2;
        Object object3;
        if (object == null) {
            return;
        }
        object = ((yh)object).b;
        boolean n11 = false;
        if (bl2 && (bl2 = ((m0)(object3 = this.b)).K((CameraSet$Mode)((Object)(object2 = this.a.I())), cameraSet$StoryState = this.b.v()))) {
            object3 = this.b.o();
            if (object3 == null) {
                return;
            }
            object3 = ((TemplatePOJO)object3).getTemplateData().getVideoUrl();
            object2 = this.b;
            Object object4 = ((m0)object2).g(n10);
            this.e = object4;
            if (object4 == null) {
                return;
            }
            object4 = this.d;
            n10 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
            if (n10 == 0 && (n10 = (int)((object4 = (Object)this.d).equals(object3) ? 1 : 0)) != 0) {
                object4 = this.e;
                n10 = object4[0];
                ((ExoVideoView)object).c(n10);
            } else {
                ((ExoVideoView)object).F(false);
                ((ExoVideoView)object).L(false);
                ((ExoVideoView)object).setMediaControllerDefault(false);
                ((ExoVideoView)object).A();
                n10 = 1;
                object2 = new String[n10];
                object2[0] = object3;
                ((ExoVideoView)object).setVideoPath((String[])object2);
                object2 = this.e;
                CameraSet$Mode cameraSet$Mode = object2[0];
                ((ExoVideoView)object).c((int)cameraSet$Mode);
                ((ExoVideoView)object).setLoopPlay(n10 != 0);
                ((ExoVideoView)object).start();
                n10 = 0;
                ((ExoVideoView)object).setVolume(0.0f);
                this.d = object3;
                object4 = new c;
                object4(this, (ExoVideoView)object);
                ((ExoVideoView)object).setOnPreparedListener((d$d)object4);
                object4 = new d;
                object4(this);
                ((ExoVideoView)object).setOnInfoListener((d$c)object4);
            }
        } else {
            ((ExoVideoView)object).F(false);
            this.d = null;
            object = this.f;
            if (object != null) {
                ((m2$d)object).a();
            }
            object = this.b;
            ((m0)object).i0(false);
        }
    }
}

