/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;

public abstract class qh
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final StoryReviewVideoView b;
    public final View c;
    public final View d;
    public TemplateData e;

    public qh(Object object, View view, int n10, ConstraintLayout constraintLayout, StoryReviewVideoView storyReviewVideoView, View view2, View view3) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = storyReviewVideoView;
        this.c = view2;
        this.d = view3;
    }

    public static qh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qh.t(view, dataBindingComponent);
    }

    public static qh t(View view, Object object) {
        return (qh)ViewDataBinding.bind(object, view, 2131558786);
    }

    public static qh v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qh.y(layoutInflater, dataBindingComponent);
    }

    public static qh w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qh.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static qh x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (qh)ViewDataBinding.inflateInternal(layoutInflater, 2131558786, viewGroup, bl2, object);
    }

    public static qh y(LayoutInflater layoutInflater, Object object) {
        return (qh)ViewDataBinding.inflateInternal(layoutInflater, 2131558786, null, false, object);
    }

    public TemplateData u() {
        return this.e;
    }

    public abstract void z(TemplateData var1);
}

