/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
 *  android.view.ViewGroup
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  android.view.animation.Animation$AnimationListener
 */
package androidx.databinding.adapters;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.databinding.adapters.ViewGroupBindingAdapter$1;
import androidx.databinding.adapters.ViewGroupBindingAdapter$2;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnAnimationEnd;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnAnimationRepeat;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnAnimationStart;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnChildViewAdded;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnChildViewRemoved;

public class ViewGroupBindingAdapter {
    public static void setAnimateLayoutChanges(ViewGroup viewGroup, boolean bl2) {
        if (bl2) {
            LayoutTransition layoutTransition = new LayoutTransition();
            viewGroup.setLayoutTransition(layoutTransition);
        } else {
            bl2 = false;
            Object var2_3 = null;
            viewGroup.setLayoutTransition(null);
        }
    }

    public static void setListener(ViewGroup viewGroup, ViewGroupBindingAdapter$OnAnimationStart viewGroupBindingAdapter$OnAnimationStart, ViewGroupBindingAdapter$OnAnimationEnd viewGroupBindingAdapter$OnAnimationEnd, ViewGroupBindingAdapter$OnAnimationRepeat viewGroupBindingAdapter$OnAnimationRepeat) {
        if (viewGroupBindingAdapter$OnAnimationStart == null && viewGroupBindingAdapter$OnAnimationEnd == null && viewGroupBindingAdapter$OnAnimationRepeat == null) {
            viewGroupBindingAdapter$OnAnimationStart = null;
            viewGroup.setLayoutAnimationListener(null);
        } else {
            ViewGroupBindingAdapter$2 viewGroupBindingAdapter$2 = new ViewGroupBindingAdapter$2(viewGroupBindingAdapter$OnAnimationStart, viewGroupBindingAdapter$OnAnimationEnd, viewGroupBindingAdapter$OnAnimationRepeat);
            viewGroup.setLayoutAnimationListener((Animation.AnimationListener)viewGroupBindingAdapter$2);
        }
    }

    public static void setListener(ViewGroup viewGroup, ViewGroupBindingAdapter$OnChildViewAdded viewGroupBindingAdapter$OnChildViewAdded, ViewGroupBindingAdapter$OnChildViewRemoved viewGroupBindingAdapter$OnChildViewRemoved) {
        if (viewGroupBindingAdapter$OnChildViewAdded == null && viewGroupBindingAdapter$OnChildViewRemoved == null) {
            viewGroupBindingAdapter$OnChildViewAdded = null;
            viewGroup.setOnHierarchyChangeListener(null);
        } else {
            ViewGroupBindingAdapter$1 viewGroupBindingAdapter$1 = new ViewGroupBindingAdapter$1(viewGroupBindingAdapter$OnChildViewAdded, viewGroupBindingAdapter$OnChildViewRemoved);
            viewGroup.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)viewGroupBindingAdapter$1);
        }
    }
}

