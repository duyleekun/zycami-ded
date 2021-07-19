/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.ObjectAnimator
 *  android.animation.StateListAnimator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewOutlineProvider
 */
package com.google.android.material.appbar;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.internal.ThemeEnforcement;

public class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS;

    static {
        int[] nArray = new int[]{16843848};
        STATE_LIST_ANIM_ATTRS = nArray;
    }

    public static void setBoundsViewOutlineProvider(View view) {
        ViewOutlineProvider viewOutlineProvider = ViewOutlineProvider.BOUNDS;
        view.setOutlineProvider(viewOutlineProvider);
    }

    public static void setDefaultAppBarLayoutStateListAnimator(View view, float f10) {
        int n10;
        Object object = view.getResources();
        int n11 = R$integer.app_bar_elevation_anim_duration;
        int n12 = object.getInteger(n11);
        StateListAnimator stateListAnimator = new StateListAnimator();
        Object[] objectArray = new int[3];
        objectArray[0] = n10 = 0x101000E;
        int n13 = R$attr.state_liftable;
        int n14 = 1;
        objectArray[n14] = n13;
        objectArray[2] = n13 = -R$attr.state_lifted;
        Object object2 = new float[n14];
        object2[0] = 0.0f;
        String string2 = "elevation";
        object2 = ObjectAnimator.ofFloat((Object)view, (String)string2, (float[])object2);
        long l10 = n12;
        object = object2.setDuration(l10);
        stateListAnimator.addState(objectArray, (Animator)object);
        object = new int[n14];
        object[0] = (Resources)n10;
        objectArray = new float[n14];
        objectArray[0] = (int)f10;
        Object object3 = ObjectAnimator.ofFloat((Object)view, (String)string2, (float[])objectArray).setDuration(l10);
        stateListAnimator.addState((int[])object, (Animator)object3);
        object3 = new int[0];
        object = new float[n14];
        object[0] = (Resources)0.0f;
        object = ObjectAnimator.ofFloat((Object)view, (String)string2, (float[])object).setDuration(0L);
        stateListAnimator.addState((int[])object3, (Animator)object);
        view.setStateListAnimator(stateListAnimator);
    }

    public static void setStateListAnimatorFromAttrs(View view, AttributeSet attributeSet, int n10, int n11) {
        block6: {
            Context context = view.getContext();
            int[] nArray = STATE_LIST_ANIM_ATTRS;
            int[] nArray2 = new int[]{};
            attributeSet = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, nArray, n10, n11, nArray2);
            n10 = (int)(attributeSet.hasValue(0) ? 1 : 0);
            if (n10 == 0) break block6;
            n10 = attributeSet.getResourceId(0, 0);
            StateListAnimator stateListAnimator = AnimatorInflater.loadStateListAnimator((Context)context, (int)n10);
            view.setStateListAnimator(stateListAnimator);
        }
        return;
        finally {
            attributeSet.recycle();
        }
    }
}

