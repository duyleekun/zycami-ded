/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.c.s0.h7.q0;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.util.DownloadState;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.q0.b;
import d.v.c.s0.h7.q0.c;
import d.v.c.s0.h7.q0.x$a;
import d.v.c.s0.h7.q0.z;
import d.v.c.w0.eh;
import d.v.e.i.j;
import d.v.e.l.n2;
import d.v.f.g.a;
import d.v.f.i.g;
import d.v.j.e.i.f1;
import java.util.Locale;

public class x
extends a {
    private eh f;
    private z g;
    private m0 h;
    private f1 i;

    private /* synthetic */ void A(TemplatePOJO object) {
        Object object2 = ((TemplatePOJO)object).getTemplateData();
        if (object2 != null) {
            Object[] objectArray;
            Object object3 = this.f.c;
            String string2 = object2.getVideoUrl();
            object3.n(string2);
            object3 = this.f.c;
            string2 = object2.getCoverUrl();
            object3.setCoverPath(string2);
            object3 = this.f.f;
            string2 = object2.showVideoCountP();
            object3.setText(string2);
            object3 = this.f.e;
            string2 = object2.showVideoTime();
            object3.setText(string2);
            object3 = this.f.h;
            string2 = object2.showTitle();
            object3.setText(string2);
            object3 = object2.getTemplateDescription();
            if (object3 != null) {
                object3 = this.f.g;
                string2 = object2.showDesc();
                object3.setText(string2);
            }
            int n10 = object2.isDownloadFinished();
            int n11 = 8;
            int n12 = -1;
            if (n10 != 0) {
                object = this.f.d;
                object2 = this.getResources();
                int n13 = 2131951854;
                object2 = d.v.f.i.g.o((Resources)object2, n13);
                object.setText((CharSequence)object2);
                this.f.d.setTextColor(n12);
                object = this.f.i;
                n10 = 2131232174;
                object.setBackgroundResource(n10);
                object = this.f.a;
                object.setVisibility(n11);
            } else if ((object = ((TemplatePOJO)object).getDownloadEvent()) != null && (object2 = DownloadState.DOWNLOADING) == (objectArray = ((DownloadEvent)object).getDownloadState())) {
                Object object4;
                object2 = this.f.d;
                object3 = Locale.getDefault();
                int n14 = 1;
                objectArray = new Object[n14];
                int n15 = ((DownloadEvent)object).getProgress();
                objectArray[0] = object4 = Integer.valueOf(n15);
                object4 = "%d%%";
                object3 = String.format((Locale)object3, (String)object4, objectArray);
                object2.setText((CharSequence)object3);
                this.f.d.setTextColor(n12);
                this.f.i.setBackgroundColor(0);
                this.f.a.setVisibility(0);
                object2 = this.f.a;
                n10 = object2.getProgress();
                n11 = ((DownloadEvent)object).getProgress();
                if (n10 != n11) {
                    object2 = this.f.a;
                    int n16 = ((DownloadEvent)object).getProgress();
                    object2.setProgress(n16);
                }
            } else {
                object = this.f.d;
                object2 = this.getResources();
                n12 = 2131952034;
                object2 = d.v.f.i.g.o((Resources)object2, n12);
                object.setText((CharSequence)object2);
                object = this.f.d;
                n10 = d.v.f.i.g.e(this, 2131099991);
                object.setTextColor(n10);
                object = this.f.i;
                n10 = 2131232177;
                object.setBackgroundResource(n10);
                object = this.f.a;
                object.setVisibility(n11);
            }
        }
    }

    public static x C() {
        x x10 = new x();
        return x10;
    }

    private void D() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            int n10 = -1;
            dialog.setLayout(n10, n10);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
        }
    }

    public static /* synthetic */ f1 u(x x10) {
        return x10.i;
    }

    public static /* synthetic */ m0 v(x x10) {
        return x10.h;
    }

    public static /* synthetic */ z w(x x10) {
        return x10.g;
    }

    private void x() {
        Object object = this.f.c;
        int n10 = 2131232095;
        ((StoryReviewVideoView)((Object)object)).setCoverBackground(n10);
        this.f.c.setCornerBackground(n10);
        object = this.g.a;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new c(this);
        ((j)object).observe(lifecycleOwner, observer);
        object = this.g.b;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new b(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
    }

    private /* synthetic */ void y(Integer object) {
        int n10;
        Resources resources = this.getResources();
        object = d.v.f.i.g.o(resources, n10 = ((Integer)object).intValue());
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            n2.e((String)object);
        }
    }

    public /* synthetic */ void B(TemplatePOJO templatePOJO) {
        this.A(templatePOJO);
    }

    public void onAttach(Context object) {
        m0 m02;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.h = m02 = (m0)((ViewModelProvider)object).get(m0.class);
        this.g = object = (z)((ViewModelProvider)object).get(z.class);
        this.i = object = (f1)d.v.i0.b.a(this).get(f1.class);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f.c.p();
    }

    public void onPause() {
        super.onPause();
        this.f.c.l();
    }

    public void onResume() {
        super.onResume();
        this.D();
        this.f.c.m();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.f;
        object2 = this.g;
        ((eh)object).B((z)object2);
        this.x();
    }

    public int s() {
        return 2131558780;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (eh)viewDataBinding;
        this.f = viewDataBinding;
        x$a x$a = new x$a(this);
        ((eh)viewDataBinding).A(x$a);
    }

    public /* synthetic */ void z(Integer n10) {
        this.y(n10);
    }
}

