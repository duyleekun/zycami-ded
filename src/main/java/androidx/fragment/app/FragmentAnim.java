/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorInflater
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.os.CancellationSignal;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim$1;
import androidx.fragment.app.FragmentAnim$2;
import androidx.fragment.app.FragmentAnim$3;
import androidx.fragment.app.FragmentAnim$AnimationOrAnimator;
import androidx.fragment.app.FragmentAnim$EndViewTransitionAnimation;
import androidx.fragment.app.FragmentTransition$Callback;

public class FragmentAnim {
    private FragmentAnim() {
    }

    public static void animateRemoveFragment(Fragment fragment, FragmentAnim$AnimationOrAnimator object, FragmentTransition$Callback fragmentTransition$Callback) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        CancellationSignal cancellationSignal = new CancellationSignal();
        Object object2 = new FragmentAnim$1(fragment);
        cancellationSignal.setOnCancelListener((CancellationSignal$OnCancelListener)object2);
        fragmentTransition$Callback.onStart(fragment, cancellationSignal);
        object2 = ((FragmentAnim$AnimationOrAnimator)object).animation;
        if (object2 != null) {
            object = ((FragmentAnim$AnimationOrAnimator)object).animation;
            object2 = new FragmentAnim$EndViewTransitionAnimation((Animation)object, viewGroup, view);
            object = fragment.mView;
            fragment.setAnimatingAway((View)object);
            object = new FragmentAnim$2(viewGroup, fragment, fragmentTransition$Callback, cancellationSignal);
            object2.setAnimationListener((Animation.AnimationListener)object);
            fragment = fragment.mView;
            fragment.startAnimation((Animation)object2);
        } else {
            FragmentAnim$3 fragmentAnim$3;
            object = ((FragmentAnim$AnimationOrAnimator)object).animator;
            fragment.setAnimator((Animator)object);
            object2 = fragmentAnim$3;
            fragmentAnim$3 = new FragmentAnim$3(viewGroup, view, fragment, fragmentTransition$Callback, cancellationSignal);
            object.addListener((Animator.AnimatorListener)fragmentAnim$3);
            fragment = fragment.mView;
            object.setTarget((Object)fragment);
            object.start();
        }
    }

    private static int getNextAnim(Fragment fragment, boolean bl2, boolean bl3) {
        if (bl3) {
            if (bl2) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        }
        if (bl2) {
            return fragment.getEnterAnim();
        }
        return fragment.getExitAnim();
    }

    public static FragmentAnim$AnimationOrAnimator loadAnimation(Context object, Fragment object2, boolean bl2, boolean bl3) {
        block19: {
            FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator;
            int n10;
            int n11;
            int n12 = ((Fragment)object2).getNextTransition();
            int n13 = FragmentAnim.getNextAnim((Fragment)object2, bl2, bl3);
            boolean bl4 = false;
            ((Fragment)object2).setAnimations(0, 0, 0, 0);
            Object object3 = ((Fragment)object2).mContainer;
            if (object3 != null && (object3 = object3.getTag(n11 = R$id.visible_removing_fragment_view_tag)) != null) {
                object3 = ((Fragment)object2).mContainer;
                object3.setTag(n11, null);
            }
            if ((object3 = ((Fragment)object2).mContainer) != null && (object3 = object3.getLayoutTransition()) != null) {
                return null;
            }
            object3 = ((Fragment)object2).onCreateAnimation(n12, bl2, n13);
            if (object3 != null) {
                object = new FragmentAnim$AnimationOrAnimator((Animation)object3);
                return object;
            }
            if ((object2 = ((Fragment)object2).onCreateAnimator(n12, bl2, n13)) != null) {
                object = new FragmentAnim$AnimationOrAnimator((Animator)object2);
                return object;
            }
            if (n13 == 0 && n12 != 0) {
                n10 = FragmentAnim.transitToAnimResourceId(n12, bl2);
            }
            if (n10 == false) break block19;
            String string2 = "anim";
            object2 = object.getResources().getResourceTypeName(n10);
            boolean bl5 = string2.equals(object2);
            if (bl5) {
                block18: {
                    string2 = AnimationUtils.loadAnimation((Context)object, (int)n10);
                    if (string2 == null) break block18;
                    try {
                        fragmentAnim$AnimationOrAnimator = new FragmentAnim$AnimationOrAnimator((Animation)string2);
                        return fragmentAnim$AnimationOrAnimator;
                    }
                    catch (Resources.NotFoundException notFoundException) {
                        throw notFoundException;
                    }
                    catch (RuntimeException runtimeException) {}
                }
                bl4 = true;
            }
            if (!bl4) {
                string2 = AnimatorInflater.loadAnimator((Context)object, (int)n10);
                if (string2 == null) break block19;
                try {
                    fragmentAnim$AnimationOrAnimator = new FragmentAnim$AnimationOrAnimator((Animator)string2);
                    return fragmentAnim$AnimationOrAnimator;
                }
                catch (RuntimeException runtimeException) {
                    if (!bl5) {
                        if ((object = AnimationUtils.loadAnimation((Context)object, (int)n10)) != null) {
                            object2 = new FragmentAnim$AnimationOrAnimator((Animation)object);
                            return object2;
                        }
                        break block19;
                    }
                    throw runtimeException;
                }
            }
        }
        return null;
    }

    private static int transitToAnimResourceId(int n10, boolean bl2) {
        int n11 = 4097;
        n10 = n10 != n11 ? (n10 != (n11 = 4099) ? (n10 != (n11 = 8194) ? -1 : (bl2 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit)) : (bl2 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit)) : (bl2 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit);
        return n10;
    }
}

