/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 *  android.widget.TextView
 */
package d.v.c.s0.h7.q0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.camera.data.MoreDevice;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.ui.FixedPopupWindow;
import d.v.c.h1.s;
import d.v.c.s0.a7.m1;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.q0.a;
import d.v.c.s0.h7.q0.d;
import d.v.c.s0.h7.q0.e;
import d.v.c.s0.h7.q0.f;
import d.v.c.s0.h7.q0.g;
import d.v.c.s0.h7.q0.i;
import d.v.c.s0.h7.q0.j;
import d.v.c.s0.h7.q0.k;
import d.v.c.s0.h7.q0.l;
import d.v.c.s0.h7.q0.m;
import d.v.c.s0.h7.q0.n;
import d.v.c.s0.h7.q0.o;
import d.v.c.s0.h7.q0.p;
import d.v.c.s0.h7.q0.q;
import d.v.c.s0.h7.q0.r;
import d.v.c.s0.h7.q0.x;
import d.v.c.s0.h7.q0.y$a;
import d.v.c.s0.h7.q0.y$b;
import d.v.c.s0.h7.q0.z;
import d.v.c.w0.gh;
import d.v.e.l.h2;
import d.v.e.l.n1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;

public class y
extends d.v.c.h1.q {
    private z g;
    private m0 h;
    private BleViewModel i;
    private CheckBox j;
    private FixedPopupWindow k;

    public static /* synthetic */ void L(y y10) {
        y10.N();
    }

    private void M() {
        CheckBox checkBox = this.j;
        if (checkBox != null) {
            return;
        }
        Object object = this.requireContext();
        this.j = checkBox = new CheckBox(object);
        checkBox.setBackground(null);
        this.j.setButtonDrawable(null);
        this.j.setTextSize(16.0f);
        int n10 = -2;
        checkBox = new FrameLayout.LayoutParams(n10, n10);
        checkBox.gravity = 8388629;
        checkBox.rightMargin = n10 = h2.b(20.0f);
        object = this.j;
        int n11 = h2.b(8.0f);
        object.setCompoundDrawablePadding(n11);
        object = this.j;
        Drawable drawable2 = d.v.f.i.g.f(this.requireContext(), 2131231649);
        n1.f((TextView)object, drawable2);
        this.j.setLayoutParams((ViewGroup.LayoutParams)checkBox);
        checkBox = this.j;
        n10 = d.v.f.i.g.c(this.requireContext(), 2131100016);
        checkBox.setTextColor(n10);
        checkBox = this.j;
        object = new p(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        checkBox = this.b.a;
        object = this.j;
        checkBox.addView((View)object);
        this.Q();
    }

    private void N() {
        this.g.b();
        m0 m02 = this.h;
        if (m02 != null) {
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_LIST;
            m02.g0(cameraSet$StoryState);
        }
    }

    private void O(View view) {
        view.setSystemUiVisibility(5894);
    }

    public static y P() {
        y y10 = new y();
        return y10;
    }

    private void Q() {
        Object object = this.g;
        Object object2 = this.i.x();
        ((z)object).g((Model)((Object)object2));
        object = this.g.f();
        object2 = this.getViewLifecycleOwner();
        j j10 = new j(this);
        ((LiveData)object).observe((LifecycleOwner)object2, j10);
    }

    private void R() {
        y$a y$a = new y$a(this, true);
        OnBackPressedDispatcher onBackPressedDispatcher = this.requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        onBackPressedDispatcher.addCallback(lifecycleOwner, y$a);
    }

    public static /* synthetic */ void S(y y10, View view) {
        y10.t0(view);
    }

    private /* synthetic */ void T(CompoundButton compoundButton, boolean bl2) {
        if (bl2) {
            this.v0();
            compoundButton = this.j;
            Context context = this.requireContext();
            int n10 = 2131231646;
            context = d.v.f.i.g.f(context, n10);
            n1.f((TextView)compoundButton, (Drawable)context);
        } else {
            compoundButton = this.j;
            Context context = this.requireContext();
            int n11 = 2131231649;
            context = d.v.f.i.g.f(context, n11);
            n1.f((TextView)compoundButton, (Drawable)context);
        }
    }

    private /* synthetic */ void V(View object, int n10, TemplatePOJO templatePOJO) {
        if (templatePOJO != null) {
            Object object2;
            object = templatePOJO.getTemplateData();
            boolean bl2 = ((TemplateData)object).isFirstLoaded();
            if (bl2) {
                object = this.h;
                object2 = templatePOJO.getTemplateData();
                long l10 = ((TemplateData)object2).getId();
                ((m0)object).f0(l10);
            }
            this.g.b.setValue(templatePOJO);
            object = x.C();
            object2 = this.getChildFragmentManager();
            ((d.v.f.g.b)object).q((FragmentManager)object2);
        }
    }

    private /* synthetic */ void X(View object, int n10, TemplatePOJO templatePOJO) {
        if (templatePOJO != null) {
            object = templatePOJO.getTemplateData();
            boolean bl2 = ((TemplateData)object).isFirstLoaded();
            if (bl2) {
                object = this.h;
                TemplateData templateData = templatePOJO.getTemplateData();
                long l10 = templateData.getId();
                ((m0)object).f0(l10);
            }
            if (bl2 = ((TemplateData)(object = templatePOJO.getTemplateData())).isDownloadFinished()) {
                this.u0(templatePOJO);
            } else {
                object = this.g;
                ((z)object).d(templatePOJO);
            }
        }
    }

    private /* synthetic */ void Z(MoreDevice object) {
        CheckBox checkBox = this.j;
        Resources resources = this.getResources();
        int n10 = object.getStringRes();
        object = d.v.f.i.g.o(resources, n10);
        checkBox.setText((CharSequence)object);
        this.C();
    }

    private /* synthetic */ void b0(Integer object) {
        Object object2 = this.getResources();
        int n10 = (Integer)object;
        object = d.v.f.i.g.o((Resources)object2, n10);
        Context context = this.getContext();
        object2 = new k$b(context);
        object = (k$b)((k$b)((k$a)object2).A(2131953193)).n((String)object);
        object2 = f.a;
        object = (k$b)((k$a)object).w((d.v.f.f.a)object2);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private /* synthetic */ void d0(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.b.d;
            ((RecyclerView)object).scrollToPosition(0);
        }
    }

    private /* synthetic */ void f0() {
        StatusView statusView = this.b.f;
        Object object = d.v.f.i.g.f(this.requireContext(), 2131231801);
        statusView.setEmptyImage((Drawable)object);
        statusView = this.b.f;
        object = d.v.f.i.g.s(this, 2131953129);
        statusView.setEmptyText((String)object);
        statusView = this.b.f;
        int n10 = d.v.f.i.g.c(this.requireContext(), 2131100003);
        statusView.setTextColor(n10);
        this.b.f.setErrorImage(2131231805);
        this.b.f.setBackgroundColor(0);
    }

    public static /* synthetic */ void h0(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void i0(TemplatePOJO object, DialogFragment object2) {
        this.g.c((TemplatePOJO)object);
        object2 = this.h;
        object = ((TemplatePOJO)object).getTemplateData();
        ((m0)object2).f((TemplateData)object);
    }

    private /* synthetic */ void k0(View view) {
        this.k.dismiss();
    }

    private /* synthetic */ void m0(RadioGroup object, int n10) {
        object = (RadioButton)object.findViewById(n10);
        z z10 = this.g;
        object = MoreDevice.fromName((String)object.getTag());
        z10.x((MoreDevice)((Object)object));
        this.k.dismiss();
    }

    private /* synthetic */ void o0() {
        this.j.setChecked(false);
    }

    private /* synthetic */ void q0() {
        FixedPopupWindow fixedPopupWindow = this.k;
        FrameLayout frameLayout = this.b.a;
        int n10 = h2.b(20.0f);
        int n11 = h2.b(48.0f);
        fixedPopupWindow.showAtLocation((View)frameLayout, 8388661, n10, n11);
        fixedPopupWindow = this.k.getContentView();
        this.O((View)fixedPopupWindow);
        this.k.setFocusable(true);
        this.k.update();
    }

    private void s0() {
        TextView textView = this.b.g;
        int n10 = d.v.f.i.g.e(this, 2131100016);
        textView.setTextColor(n10);
        this.b.b.setImageResource(2131231362);
        this.b.c.setBackgroundResource(2131230921);
    }

    private void t0(View view) {
        this.N();
    }

    private void u0(TemplatePOJO object) {
        Object object2 = this.getContext();
        Object object3 = new k$b((Context)object2);
        object3 = (k$b)((k$a)object3).A(2131953114);
        object2 = a.a;
        object3 = (k$b)((k$a)object3).o(2131951833, (d.v.f.f.a)object2);
        object2 = new o(this, (TemplatePOJO)object);
        object = (k$b)((k$a)object3).v(2131951903, (d.v.f.f.a)object2);
        object3 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    private void v0() {
        Object object = MoreDevice.values();
        Object object2 = LayoutInflater.from((Context)this.requireContext());
        int n10 = 2131558781;
        object2 = object2.inflate(n10, null, false);
        Object object3 = gh.s((View)object2);
        MoreDevice moreDevice = (MoreDevice)((Object)this.g.f().getValue());
        int n11 = ((MoreDevice[])object).length;
        int n12 = -1;
        int n13 = n12;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object4 = object[i10];
            Context context = this.requireContext();
            RadioGroup radioGroup = ((gh)object3).a;
            int n14 = object4.getStringRes();
            String string2 = object4.name();
            context = m1.c(context, radioGroup, n14, string2);
            radioGroup = ((gh)object3).a;
            radioGroup.addView((View)context);
            if (object4 != moreDevice) continue;
            n13 = context.getId();
            object4 = new d(this);
            context.setOnClickListener((View.OnClickListener)object4);
        }
        if (n12 != n13) {
            object = ((gh)object3).a;
            object.check(n13);
        }
        object = ((gh)object3).a;
        object3 = new n(this);
        object.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object3);
        n10 = -2;
        object = new FixedPopupWindow((View)object2, n10, n10);
        this.k = object;
        object.setOutsideTouchable(true);
        this.k.setFocusable(false);
        object = this.k;
        object2 = new l(this);
        object.setOnDismissListener((PopupWindow.OnDismissListener)object2);
        object = this.b.a;
        object2 = new i(this);
        object.post((Runnable)object2);
    }

    public void B() {
        this.g.s();
    }

    public void C() {
        this.g.w();
    }

    public /* synthetic */ void U(CompoundButton compoundButton, boolean bl2) {
        this.T(compoundButton, bl2);
    }

    public /* synthetic */ void W(View view, int n10, TemplatePOJO templatePOJO) {
        this.V(view, n10, templatePOJO);
    }

    public /* synthetic */ void Y(View view, int n10, TemplatePOJO templatePOJO) {
        this.X(view, n10, templatePOJO);
    }

    public /* synthetic */ void a0(MoreDevice moreDevice) {
        this.Z(moreDevice);
    }

    public /* synthetic */ void c0(Integer n10) {
        this.b0(n10);
    }

    public /* synthetic */ void e0(Boolean bl2) {
        this.d0(bl2);
    }

    public /* synthetic */ void g0() {
        this.f0();
    }

    public /* synthetic */ void j0(TemplatePOJO templatePOJO, DialogFragment dialogFragment) {
        this.i0(templatePOJO, dialogFragment);
    }

    public s k() {
        y$b y$b = new y$b();
        d.v.f.f.b b10 = new k(this);
        y$b.r(b10);
        b10 = new m(this);
        y$b.z(b10);
        y$b.setHasStableIds(true);
        return y$b;
    }

    public LiveData l() {
        return this.g.e();
    }

    public /* synthetic */ void l0(View view) {
        this.k0(view);
    }

    public RecyclerView$ItemDecoration m() {
        return null;
    }

    public RecyclerView$LayoutManager n() {
        s s10 = this.d;
        Context context = this.getContext();
        return s10.h(context, 1, 3);
    }

    public /* synthetic */ void n0(RadioGroup radioGroup, int n10) {
        this.m0(radioGroup, n10);
    }

    public /* synthetic */ void p0() {
        this.o0();
    }

    public /* synthetic */ void r0() {
        this.q0();
    }

    public void s() {
        int n10;
        this.J(true);
        Object object = d.v.f.i.g.o(this.getResources(), 2131953125);
        this.H((String)object);
        object = this.b.a.getLayoutParams();
        ((ViewGroup.LayoutParams)object).height = n10 = h2.b(64.0f);
        this.b.a.setLayoutParams((ViewGroup.LayoutParams)object);
        object = this.b.d;
        float f10 = 10.0f;
        int n11 = h2.b(f10);
        n10 = h2.b(f10);
        object.setPadding(n11, 0, n10, 0);
        object = new g(this);
        this.G((View.OnClickListener)object);
        this.R();
        object = this.g.a;
        Object object2 = this.getViewLifecycleOwner();
        Observer observer = new r(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        this.M();
        this.s0();
        object = this.g.c;
        object2 = this.getViewLifecycleOwner();
        observer = new q(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.b.f;
        object2 = new e(this);
        object.post((Runnable)object2);
    }

    public void t() {
        ViewModel viewModel;
        Object object = d.v.i0.b.c(this.requireActivity());
        this.h = viewModel = (m0)((ViewModelProvider)object).get(m0.class);
        viewModel = (z)((ViewModelProvider)object).get(z.class);
        this.g = viewModel;
        this.i = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
    }

    public boolean u() {
        return true;
    }
}

