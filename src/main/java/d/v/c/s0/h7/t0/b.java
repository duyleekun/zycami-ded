/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextWatcher
 *  android.view.View
 *  android.widget.EditText
 */
package d.v.c.s0.h7.t0;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.t0.a;
import d.v.c.s0.h7.t0.b$a;
import d.v.c.s0.h7.t0.b$b;
import d.v.c.s0.h7.t0.b$c;
import d.v.c.s0.h7.u0.l;
import d.v.c.w0.ei;
import d.v.e.l.s1;
import d.v.e.l.v1;
import d.v.f.i.g;

public class b
extends d.v.f.h.a {
    private ei b;
    private m0 c;
    private l d;
    private b$c e;

    public static /* synthetic */ b$c j(b b10) {
        return b10.e;
    }

    public static /* synthetic */ ei k(b b10) {
        return b10.b;
    }

    public static /* synthetic */ l l(b b10) {
        return b10.d;
    }

    public static /* synthetic */ void m(b b10) {
        b10.r();
    }

    public static /* synthetic */ void n(b b10) {
        b10.q();
    }

    public static /* synthetic */ void o(b b10) {
        b10.s();
    }

    public static /* synthetic */ m0 p(b b10) {
        return b10.c;
    }

    private void q() {
        m0 m02 = this.c;
        if (m02 != null) {
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_LIST;
            m02.g0(cameraSet$StoryState);
        }
    }

    private void r() {
        s1.i(Uri.parse((String)this.d.i));
        m0 m02 = this.c;
        if (m02 != null) {
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_REVIEW;
            m02.g0(cameraSet$StoryState);
        }
    }

    private void s() {
        this.c.e();
        String string2 = this.d.i;
        PublishActivity.l(this, string2);
    }

    private void t() {
        EditText editText = this.b.a;
        b$b b$b = new b$b(this);
        editText.addTextChangedListener((TextWatcher)b$b);
    }

    private void u() {
        Object object = this.b.c;
        int n10 = 2131232108;
        ((StoryReviewVideoView)((Object)object)).setCoverBackground(n10);
        this.b.c.setCornerBackground(n10);
        object = this.c.n();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        a a10 = new a(this);
        ((LiveData)object).observe(lifecycleOwner, a10);
    }

    private void v() {
        b$a b$a = new b$a(this, true);
        OnBackPressedDispatcher onBackPressedDispatcher = this.requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        onBackPressedDispatcher.addCallback(lifecycleOwner, b$a);
    }

    private /* synthetic */ void w(TemplatePOJO object) {
        Object object2 = this.d;
        boolean bl2 = ((l)object2).r();
        if (bl2) {
            object = this.b.b;
            object2 = this.getResources();
            int n10 = 2131953149;
            int n11 = 1;
            Object[] objectArray = new Object[n11];
            int n12 = this.d.k();
            Integer n13 = n12;
            objectArray[0] = n13;
            object2 = g.p((Resources)object2, n10, objectArray);
            object.setHint((CharSequence)object2);
            object2 = object = this.d.i;
        } else {
            object2 = ((TemplatePOJO)object).getTemplateData().showTitle();
            this.b.b.setHint((CharSequence)object2);
            Object object3 = this.b.b;
            object3.setText((CharSequence)object2);
            object2 = ((TemplatePOJO)object).getTemplateData().getTemplateDescription();
            if (object2 != null) {
                object2 = this.b.a;
                object3 = ((TemplatePOJO)object).getTemplateData().showDesc();
                object2.setText((CharSequence)object3);
            }
            object2 = ((TemplatePOJO)object).getTemplateData().getVideoUrl();
            object = ((TemplatePOJO)object).getTemplateData().getCoverUrl();
            Object object4 = object2;
            object2 = object;
            object = object4;
        }
        this.b.c.n((String)object);
        this.b.c.setCoverPath((String)object2);
    }

    public static b y() {
        b b10 = new b();
        return b10;
    }

    public int h() {
        return 2131558793;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (ei)object;
        this.b = object;
        l l10 = this.d;
        ((ei)object).B(l10);
        this.e = object = new b$c(this);
        this.b.A((b$c)object);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        m0 m02;
        super.onActivityResult(n10, n11, intent);
        n11 = 1;
        if (n10 == n11 && (m02 = this.c) != null) {
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_LIST;
            m02.g0(cameraSet$StoryState);
        }
    }

    public void onAttach(Context object) {
        m0 m02;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.c = m02 = (m0)((ViewModelProvider)object).get(m0.class);
        this.d = object = (l)((ViewModelProvider)object).get(l.class);
    }

    public void onDestroy() {
        this.b.c.p();
        Context context = this.requireContext();
        EditText editText = this.b.b;
        v1.d(context, (View)editText);
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.b.c.l();
    }

    public void onResume() {
        super.onResume();
        this.b.c.m();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.v();
        this.u();
        this.t();
    }

    public /* synthetic */ void x(TemplatePOJO templatePOJO) {
        this.w(templatePOJO);
    }
}

