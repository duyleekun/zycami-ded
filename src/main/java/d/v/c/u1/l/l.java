/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.u1.l;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Pair;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity;
import com.zhiyun.cama.template.PlayLayout;
import com.zhiyun.cama.template.PlayState;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.util.DownloadState;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.u1.k;
import d.v.c.u1.l.a;
import d.v.c.u1.l.b;
import d.v.c.u1.l.c;
import d.v.c.u1.l.d;
import d.v.c.u1.l.e;
import d.v.c.u1.l.f;
import d.v.c.u1.l.g;
import d.v.c.u1.l.h;
import d.v.c.u1.l.i;
import d.v.c.u1.l.l$a;
import d.v.c.u1.l.l$b;
import d.v.c.u1.l.l$c;
import d.v.c.u1.l.m;
import d.v.c.w0.x7;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.j.g.b0;
import d.v.j.g.z;

public class l
extends d.v.c.q0.b {
    public static final String s = "templateDataID";
    private PlayLayout g;
    private ProgressBar h;
    private TextView i;
    private FrameLayout j;
    private ConstraintLayout k;
    private ConstraintLayout l;
    private x7 m;
    private long n;
    private d.v.j.f.g o;
    private m p;
    private z q;
    private k r;

    public static /* synthetic */ void A(l l10, TemplatePOJO templatePOJO) {
        l10.H(templatePOJO);
    }

    public static /* synthetic */ void B(l l10) {
        l10.v0();
    }

    public static /* synthetic */ void C(l l10) {
        l10.w0();
    }

    public static /* synthetic */ m D(l l10) {
        return l10.p;
    }

    public static /* synthetic */ void E(l l10, TemplatePOJO templatePOJO) {
        l10.F(templatePOJO);
    }

    private void F(TemplatePOJO object) {
        Object object2 = this.q;
        boolean bl2 = ((z)object2).g();
        if (bl2) {
            object2 = this.q;
            bl2 = ((z)object2).f();
            if (bl2) {
                object2 = d.v.f.i.g.o(this.getResources(), 2131951893);
                Object object3 = this.getContext();
                Object object4 = new k$b((Context)object3);
                object2 = (k$b)((k$a)object4).n((String)object2);
                object4 = new b(this);
                object2 = (k$b)((k$a)object2).p((d.v.f.f.a)object4);
                int n10 = 2131951892;
                object3 = new f(this, (TemplatePOJO)object);
                object = ((k$b)((k$b)((k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
                object2 = this.getChildFragmentManager();
                object4 = this.getClass().getSimpleName();
                ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
            } else {
                object2 = this.o;
                ((d.v.j.f.g)object2).d((TemplatePOJO)object);
            }
        } else {
            this.u0();
        }
    }

    public static Bundle G(long l10) {
        Bundle bundle = new Bundle();
        bundle.putLong(s, l10);
        return bundle;
    }

    private void H(TemplatePOJO templatePOJO) {
        TemplateData templateData = templatePOJO.getTemplateData();
        boolean bl2 = templateData.isPrimeUsable();
        if (!bl2 || (bl2 = d.v.c.m1.b.b((Context)(templateData = this.requireContext())))) {
            this.m0(templatePOJO);
        }
    }

    private void I(ViewDataBinding object) {
        d.v.j.f.g g10;
        Object object2 = d.v.i0.b.a(this);
        ViewModelProvider viewModelProvider = d.v.i0.b.c(this.requireActivity());
        this.o = g10 = (d.v.j.f.g)((ViewModelProvider)object2).get(d.v.j.f.g.class);
        this.p = object2 = (m)((ViewModelProvider)object2).get(m.class);
        this.q = object2 = (z)viewModelProvider.get(z.class);
        this.r = object2 = (k)viewModelProvider.get(k.class);
        object = (x7)object;
        this.m = object;
        object.setLifecycleOwner(this);
        object = this.m;
        object2 = this.o;
        ((x7)object).D((d.v.j.f.g)object2);
        object = this.m;
        object2 = this.p;
        ((x7)object).C((m)object2);
        object = this.m;
        object2 = new l$c(this);
        ((x7)object).B((l$c)object2);
        object = this.m;
        object2 = ((x7)object).d;
        this.h = object2;
        object2 = ((x7)object).h;
        this.i = object2;
        object2 = ((x7)object).a;
        this.j = object2;
        object2 = ((x7)object).c;
        this.k = object2;
        object2 = ((x7)object).b;
        this.l = object2;
        object = ((x7)object).e;
        this.g = object;
        this.r.n(1);
    }

    private void J() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            long l10;
            String string2 = s;
            this.n = l10 = bundle.getLong(string2);
        }
    }

    private void K(TemplateData templateData) {
        this.y0(null, templateData);
    }

    private void L() {
        Object object = this.getDialog();
        if (object == null) {
            return;
        }
        Object object2 = new h(this);
        object.setOnKeyListener((DialogInterface.OnKeyListener)object2);
        object = this.g;
        object2 = new c(this);
        ((PlayLayout)((Object)object)).setOnPlayStateChangeListener((d.v.c.u1.g)object2);
    }

    private void M() {
        Object object = this.o;
        long l10 = this.n;
        ((d.v.j.f.g)object).A(l10);
        object = this.o.j();
        Observer observer = new d(this);
        ((LiveData)object).observe(this, observer);
        object = this.o.e();
        observer = new i(this);
        ((LiveData)object).observe(this, observer);
        object = this.p.c;
        observer = new e(this);
        ((LiveData)object).observe(this, observer);
    }

    private void N(TemplateData templateData) {
        ViewTreeObserver viewTreeObserver = this.l.getViewTreeObserver();
        l$a l$a = new l$a(this, templateData);
        viewTreeObserver.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)l$a);
        this.l0(false);
        this.j.setClipToOutline(true);
    }

    private /* synthetic */ void O(DialogFragment dialogFragment) {
        this.q.i(false);
    }

    private /* synthetic */ void Q(TemplatePOJO templatePOJO, DialogFragment dialogFragment) {
        this.q.i(true);
        this.o.d(templatePOJO);
    }

    private /* synthetic */ boolean S(DialogInterface object, int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11) {
            object = this.g;
            n10 = 1;
            ((PlayLayout)((Object)object)).F(n10 != 0);
        }
        return false;
    }

    private /* synthetic */ void U(PlayState playState) {
        this.p.k(playState);
    }

    private /* synthetic */ void W(TemplatePOJO object) {
        if (object != null) {
            b0.b((TemplatePOJO)object);
            object = ((TemplatePOJO)object).getTemplateData();
            if (object != null) {
                this.N((TemplateData)object);
                this.K((TemplateData)object);
            }
        }
    }

    private /* synthetic */ void Y(Pair object) {
        long l10;
        long l11;
        long l12;
        long l13;
        DownloadEvent downloadEvent = (DownloadEvent)((Pair)object).second;
        if (downloadEvent != null && (l13 = (l12 = (l11 = this.n) - (l10 = ((Long)(object = (Long)((Pair)object).first)).longValue())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false && (object = this.o.g()) != null) {
            object = this.p;
            DownloadState downloadState = downloadEvent.getDownloadState();
            ((m)object).j(downloadState);
            object = this.o.g().getTemplateData();
            this.y0(downloadEvent, (TemplateData)object);
            this.s0(downloadEvent);
        }
    }

    private /* synthetic */ void a0(PlayState object) {
        int[] nArray = l$b.b;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) == n11) {
            object = this.getResources();
            n11 = 2131952066;
            object = d.v.f.i.g.o((Resources)object, n11);
            n2.e((String)object);
        }
    }

    private /* synthetic */ void c0(DialogFragment dialogFragment) {
        this.q.i(false);
        this.x0();
    }

    private /* synthetic */ void e0(DialogFragment object) {
        object = this.q;
        boolean bl2 = true;
        ((z)object).i(bl2);
        this.l0(bl2);
    }

    private void g0() {
        Window window;
        Dialog dialog = this.getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            int n10;
            dialog = dialog.getWindow();
            int n11 = 2131099762;
            dialog.setBackgroundDrawableResource(n11);
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            window = dialog.getAttributes();
            window.width = n10 = -1;
            window.height = n10;
            window.flags = 32;
            window.windowAnimations = 2132017745;
            window.gravity = n10 = 80;
            dialog.setAttributes((WindowManager.LayoutParams)window);
        }
    }

    private boolean i0(boolean bl2) {
        z z10 = this.q;
        int n10 = z10.g();
        if (n10 == 0) {
            this.x0();
            if (bl2) {
                Object object = this.getResources();
                n10 = 2131952827;
                object = d.v.f.i.g.o(object, n10);
                n2.e((String)object);
            }
            return true;
        }
        return false;
    }

    public static l j0(long l10) {
        return d.v.c.u1.l.l.k0(d.v.c.u1.l.l.G(l10));
    }

    public static l k0(Bundle bundle) {
        l l10 = new l();
        l10.setArguments(bundle);
        return l10;
    }

    private void m0(TemplatePOJO object) {
        Object object2 = this.r;
        boolean bl2 = ((k)object2).g();
        if (bl2) {
            object2 = this.r;
            ((k)object2).m((TemplatePOJO)object);
            this.i();
        } else {
            object2 = this.getActivity();
            object = ((TemplatePOJO)object).getTemplateData();
            long l10 = ((TemplateData)object).getId();
            EditorAddVideoActivity.o((Activity)object2, l10);
        }
    }

    private boolean o0(boolean bl2) {
        boolean bl3 = this.q.e();
        boolean bl4 = bl3 ^ true;
        this.n0(bl2, bl4);
        return bl3 ^ true;
    }

    private void p0(boolean bl2) {
        Object object;
        if (!bl2 && (bl2 = ((z)(object = this.q)).c())) {
            this.x0();
        } else {
            Object object2 = this.getContext();
            object = new k$b((Context)object2);
            object = (k$b)((k$a)object).m(2131951893);
            object2 = new g(this);
            object = (k$b)((k$a)object).p((d.v.f.f.a)object2);
            int n10 = 2131951892;
            Object object3 = new a(this);
            object = ((k$b)((k$b)((k$a)object).v(n10, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object3 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object3);
        }
    }

    private void q0(TemplateData object) {
        Drawable drawable2 = o1.o(this.getResources(), 2131230820);
        int n10 = drawable2.getMinimumWidth();
        int n11 = drawable2.getMinimumHeight();
        drawable2.setBounds(0, 0, n10, n11);
        drawable2 = this.i;
        Resources resources = this.getResources();
        Object[] objectArray = new Object[]{object = ((TemplateData)object).showResSize()};
        object = d.v.f.i.g.p(resources, 2131952035, objectArray);
        drawable2.setText((CharSequence)object);
        this.h.setProgress(100);
    }

    private void r0() {
        TextView textView = this.i;
        String string2 = d.v.f.i.g.o(this.getResources(), 2131951854);
        textView.setText((CharSequence)string2);
        this.h.setProgress(100);
    }

    private void t0(DownloadEvent object) {
        int n10 = ((DownloadEvent)object).getProgress();
        this.h.setProgress(n10);
        TextView textView = this.i;
        Resources resources = this.getResources();
        object = n10;
        Object[] objectArray = new Object[]{object};
        object = d.v.f.i.g.p(resources, 2131952036, objectArray);
        textView.setText((CharSequence)object);
    }

    private void u0() {
        n2.e(d.v.f.i.g.o(this.getResources(), 2131952827));
    }

    private void v0() {
        n2.e(d.v.f.i.g.o(this.getResources(), 2131952105));
    }

    public static /* synthetic */ ConstraintLayout w(l l10) {
        return l10.l;
    }

    private void w0() {
        n2.e(d.v.f.i.g.o(this.getResources(), 2131953150));
    }

    public static /* synthetic */ ConstraintLayout x(l l10) {
        return l10.k;
    }

    private void x0() {
        this.g.A();
    }

    public static /* synthetic */ PlayLayout y(l l10) {
        return l10.g;
    }

    public static /* synthetic */ d.v.j.f.g z(l l10) {
        return l10.o;
    }

    public /* synthetic */ void P(DialogFragment dialogFragment) {
        this.O(dialogFragment);
    }

    public /* synthetic */ void R(TemplatePOJO templatePOJO, DialogFragment dialogFragment) {
        this.Q(templatePOJO, dialogFragment);
    }

    public /* synthetic */ boolean T(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return this.S(dialogInterface, n10, keyEvent);
    }

    public /* synthetic */ void V(PlayState playState) {
        this.U(playState);
    }

    public /* synthetic */ void X(TemplatePOJO templatePOJO) {
        this.W(templatePOJO);
    }

    public /* synthetic */ void Z(Pair pair) {
        this.Y(pair);
    }

    public /* synthetic */ void b0(PlayState playState) {
        this.a0(playState);
    }

    public /* synthetic */ void d0(DialogFragment dialogFragment) {
        this.c0(dialogFragment);
    }

    public /* synthetic */ void f0(DialogFragment dialogFragment) {
        this.e0(dialogFragment);
    }

    public boolean h0(String string2) {
        return string2.startsWith("http");
    }

    public void l0(boolean bl2) {
        Object object = this.g;
        boolean bl3 = object.j();
        if (!bl3) {
            PlayLayout playLayout;
            object = this.o.l();
            boolean bl4 = this.h0((String)object);
            if (bl4) {
                if (bl2 = this.i0(bl2)) {
                    return;
                }
                playLayout = null;
                bl2 = this.o0(false);
                if (!bl2) {
                    return;
                }
            }
            playLayout = this.g;
            playLayout.t((String)object);
        }
    }

    public void n0(boolean bl2, boolean bl3) {
        if (!bl3) {
            this.p0(bl2);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.g.u();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.r.n(0);
    }

    public void onPause() {
        super.onPause();
        this.g.s();
    }

    public void onResume() {
        super.onResume();
        PlayLayout playLayout = this.g;
        boolean bl2 = playLayout.f();
        if (bl2) {
            bl2 = false;
            playLayout = null;
            this.l0(false);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.M();
    }

    public int s() {
        return 2131558586;
    }

    public void s0(DownloadEvent object) {
        int n10;
        if (object == null) {
            return;
        }
        boolean n102 = ((DownloadEvent)object).isSingleEvent();
        if (!n102) {
            return;
        }
        int[] nArray = l$b.a;
        object = ((DownloadEvent)object).getDownloadState();
        int n11 = ((Enum)object).ordinal();
        int n12 = 4;
        if ((n11 = nArray[n11]) != n12 && n11 != (n10 = 5)) {
            int n13 = 6;
            if (n11 != n13) {
                int n14 = 7;
                if (n11 == n14) {
                    this.u0();
                }
            } else {
                object = this.getResources();
                int n15 = 2131952100;
                object = d.v.f.i.g.o((Resources)object, n15);
                n2.e((String)object);
            }
        } else {
            this.v0();
        }
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        this.g0();
        this.J();
        this.I(viewDataBinding);
        this.L();
    }

    public void y0(DownloadEvent downloadEvent, TemplateData templateData) {
        int n10;
        if (templateData != null) {
            n10 = templateData.isDownloadFinished();
            if (n10 != 0) {
                this.r0();
            } else {
                this.q0(templateData);
            }
        }
        if (downloadEvent != null) {
            int[] nArray = l$b.a;
            DownloadState downloadState = downloadEvent.getDownloadState();
            int n11 = downloadState.ordinal();
            n10 = nArray[n11];
            if (n10 != (n11 = 1)) {
                int n12 = 2;
                if (n10 != n12) {
                    this.q0(templateData);
                } else {
                    this.r0();
                }
            } else {
                this.t0(downloadEvent);
            }
        }
    }

    public void z0() {
        Object object = this.g;
        boolean bl2 = object.i();
        if (bl2) {
            object = this.g;
            object.s();
        } else {
            object = this.o.l();
            boolean bl3 = this.h0((String)object);
            if (bl3) {
                bl3 = true;
                boolean bl4 = this.i0(bl3);
                if (bl4) {
                    return;
                }
                if (!(bl3 = this.o0(bl3))) {
                    return;
                }
            }
            PlayLayout playLayout = this.g;
            playLayout.t((String)object);
        }
    }
}

