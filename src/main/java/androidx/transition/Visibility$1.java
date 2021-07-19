/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.ViewGroupUtils;
import androidx.transition.Visibility;

public class Visibility$1
extends TransitionListenerAdapter {
    public final /* synthetic */ Visibility this$0;
    public final /* synthetic */ View val$finalOverlayView;
    public final /* synthetic */ ViewGroup val$overlayHost;
    public final /* synthetic */ View val$startView;

    public Visibility$1(Visibility visibility, ViewGroup viewGroup, View view, View view2) {
        this.this$0 = visibility;
        this.val$overlayHost = viewGroup;
        this.val$finalOverlayView = view;
        this.val$startView = view2;
    }

    public void onTransitionEnd(Transition transition) {
        Object object = this.val$startView;
        int n10 = R$id.save_overlay_view;
        object.setTag(n10, null);
        object = ViewGroupUtils.getOverlay(this.val$overlayHost);
        View view = this.val$finalOverlayView;
        object.remove(view);
        transition.removeListener(this);
    }

    public void onTransitionPause(Transition object) {
        object = ViewGroupUtils.getOverlay(this.val$overlayHost);
        View view = this.val$finalOverlayView;
        object.remove(view);
    }

    public void onTransitionResume(Transition object) {
        object = this.val$finalOverlayView.getParent();
        if (object == null) {
            object = ViewGroupUtils.getOverlay(this.val$overlayHost);
            View view = this.val$finalOverlayView;
            object.add(view);
        } else {
            object = this.this$0;
            ((Transition)object).cancel();
        }
    }
}

