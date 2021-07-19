/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.TransitionDrawable
 *  android.view.View
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.view.animation.RotateAnimation
 *  android.widget.EditText
 */
package d.v.e.l;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import com.zhiyun.common.R$anim;
import d.v.e.l.z0$a;

public class z0 {
    public static void a(View view, int n10, int n11, int n12, float ... fArray) {
        view = ObjectAnimator.ofFloat((Object)view, (String)"alpha", (float[])fArray);
        long l10 = n10;
        view = view.setDuration(l10);
        view.setRepeatMode(n11);
        view.setRepeatCount(n12);
        view.start();
    }

    public static void b(View view, int n10, float ... fArray) {
        view = ObjectAnimator.ofFloat((Object)view, (String)"alpha", (float[])fArray);
        long l10 = n10;
        view.setDuration(l10).start();
    }

    public static TransitionDrawable c(Drawable drawable2, Drawable drawable3) {
        Drawable[] drawableArray = new Drawable[2];
        drawableArray[0] = drawable2;
        boolean bl2 = true;
        drawableArray[bl2] = drawable3;
        drawable3 = new TransitionDrawable(drawableArray);
        drawable3.setCrossFadeEnabled(bl2);
        return drawable3;
    }

    public static Animation d(float f10, float f11) {
        RotateAnimation rotateAnimation = new RotateAnimation(f10, f11, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(200L);
        rotateAnimation.setFillAfter(true);
        return rotateAnimation;
    }

    public static Animation e() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(2);
        return alphaAnimation;
    }

    public static void f(View view, int n10, float ... fArray) {
        view = ObjectAnimator.ofFloat((Object)view, (String)"rotation", (float[])fArray);
        long l10 = n10;
        view.setDuration(l10).start();
    }

    public static void g(EditText editText) {
        Context context = editText.getContext();
        int n10 = R$anim.shake_error;
        context = AnimationUtils.loadAnimation((Context)context, (int)n10);
        editText.startAnimation((Animation)context);
    }

    public static void h(View view, int n10, float ... fArray) {
        view = ObjectAnimator.ofFloat((Object)view, (String)"translationX", (float[])fArray);
        long l10 = n10;
        view.setDuration(l10).start();
    }

    public static void i(View view, int n10, float ... fArray) {
        view = ObjectAnimator.ofFloat((Object)view, (String)"translationY", (float[])fArray);
        long l10 = n10;
        view.setDuration(l10).start();
    }

    public static void j(View view, int n10, float ... fArray) {
        z0$a z0$a = new z0$a(view);
        view = ObjectAnimator.ofFloat((Object)z0$a, (String)"width", (float[])fArray);
        long l10 = n10;
        view.setDuration(l10).start();
    }
}

