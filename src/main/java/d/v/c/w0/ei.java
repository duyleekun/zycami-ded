/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;
import d.v.c.s0.h7.t0.b$c;
import d.v.c.s0.h7.u0.l;

public abstract class ei
extends ViewDataBinding {
    public final EditText a;
    public final EditText b;
    public final StoryReviewVideoView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public b.c g;
    public l h;

    public ei(Object object, View view, int n10, EditText editText, EditText editText2, StoryReviewVideoView storyReviewVideoView, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = editText;
        this.b = editText2;
        this.c = storyReviewVideoView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static ei s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ei.t(view, dataBindingComponent);
    }

    public static ei t(View view, Object object) {
        return (ei)ViewDataBinding.bind(object, view, 2131558793);
    }

    public static ei w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ei.z(layoutInflater, dataBindingComponent);
    }

    public static ei x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ei.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ei y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ei)ViewDataBinding.inflateInternal(layoutInflater, 2131558793, viewGroup, bl2, object);
    }

    public static ei z(LayoutInflater layoutInflater, Object object) {
        return (ei)ViewDataBinding.inflateInternal(layoutInflater, 2131558793, null, false, object);
    }

    public abstract void A(b.c var1);

    public abstract void B(l var1);

    public b.c u() {
        return this.g;
    }

    public l v() {
        return this.h;
    }
}

