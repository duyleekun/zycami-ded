/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.transition.Transition;
import androidx.transition.Transition$TransitionListener;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionManager$MultiListener$1;
import java.util.ArrayList;

public class TransitionManager$MultiListener
implements ViewTreeObserver.OnPreDrawListener,
View.OnAttachStateChangeListener {
    public ViewGroup mSceneRoot;
    public Transition mTransition;

    public TransitionManager$MultiListener(Transition transition, ViewGroup viewGroup) {
        this.mTransition = transition;
        this.mSceneRoot = viewGroup;
    }

    private void removeListeners() {
        this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        this.mSceneRoot.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    public boolean onPreDraw() {
        int n10;
        Object object;
        this.removeListeners();
        Object object2 = TransitionManager.sPendingTransitions;
        ViewGroup viewGroup = this.mSceneRoot;
        boolean bl2 = ((ArrayList)object2).remove(viewGroup);
        boolean bl3 = true;
        if (!bl2) {
            return bl3;
        }
        object2 = TransitionManager.getRunningTransitions();
        Object object3 = this.mSceneRoot;
        object3 = (ArrayList)((SimpleArrayMap)object2).get(object3);
        ViewGroup viewGroup2 = null;
        if (object3 == null) {
            object3 = new ArrayList();
            object = this.mSceneRoot;
            ((SimpleArrayMap)object2).put(object, object3);
        } else {
            n10 = ((ArrayList)object3).size();
            if (n10 > 0) {
                viewGroup2 = new ArrayList(object3);
            }
        }
        object = this.mTransition;
        ((ArrayList)object3).add(object);
        object3 = this.mTransition;
        object = new TransitionManager$MultiListener$1(this, (ArrayMap)object2);
        ((Transition)object3).addListener((Transition$TransitionListener)object);
        object2 = this.mTransition;
        object3 = this.mSceneRoot;
        n10 = 0;
        object = null;
        ((Transition)object2).captureValues((ViewGroup)object3, false);
        if (viewGroup2 != null) {
            boolean bl4;
            object2 = viewGroup2.iterator();
            while (bl4 = object2.hasNext()) {
                object3 = (Transition)object2.next();
                viewGroup2 = this.mSceneRoot;
                ((Transition)object3).resume((View)viewGroup2);
            }
        }
        object2 = this.mTransition;
        object3 = this.mSceneRoot;
        ((Transition)object2).playTransition((ViewGroup)object3);
        return bl3;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View object) {
        int n10;
        this.removeListeners();
        object = TransitionManager.sPendingTransitions;
        Object object2 = this.mSceneRoot;
        ((ArrayList)object).remove(object2);
        object = TransitionManager.getRunningTransitions();
        object2 = this.mSceneRoot;
        object = (ArrayList)((SimpleArrayMap)object).get(object2);
        if (object != null && (n10 = ((ArrayList)object).size()) > 0) {
            object = ((ArrayList)object).iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (Transition)object.next();
                ViewGroup viewGroup = this.mSceneRoot;
                ((Transition)object2).resume((View)viewGroup);
            }
        }
        this.mTransition.clearValues(true);
    }
}

