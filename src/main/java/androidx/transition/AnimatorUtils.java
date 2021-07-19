/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  android.animation.AnimatorListenerAdapter
 *  android.os.Build$VERSION
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import androidx.transition.AnimatorUtils$AnimatorPauseListenerCompat;
import java.util.ArrayList;

public class AnimatorUtils {
    private AnimatorUtils() {
    }

    public static void addPauseListener(Animator animator2, AnimatorListenerAdapter animatorListenerAdapter) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            animator2.addPauseListener((Animator.AnimatorPauseListener)animatorListenerAdapter);
        }
    }

    public static void pause(Animator animator2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            animator2.pause();
        } else {
            ArrayList arrayList = animator2.getListeners();
            if (arrayList != null) {
                int n12 = arrayList.size();
                for (n11 = 0; n11 < n12; ++n11) {
                    Object object = (Animator.AnimatorListener)arrayList.get(n11);
                    boolean bl2 = object instanceof AnimatorUtils$AnimatorPauseListenerCompat;
                    if (!bl2) continue;
                    object = (AnimatorUtils$AnimatorPauseListenerCompat)object;
                    object.onAnimationPause(animator2);
                }
            }
        }
    }

    public static void resume(Animator animator2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            animator2.resume();
        } else {
            ArrayList arrayList = animator2.getListeners();
            if (arrayList != null) {
                int n12 = arrayList.size();
                for (n11 = 0; n11 < n12; ++n11) {
                    Object object = (Animator.AnimatorListener)arrayList.get(n11);
                    boolean bl2 = object instanceof AnimatorUtils$AnimatorPauseListenerCompat;
                    if (!bl2) continue;
                    object = (AnimatorUtils$AnimatorPauseListenerCompat)object;
                    object.onAnimationResume(animator2);
                }
            }
        }
    }
}

