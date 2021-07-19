/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets
 *  android.view.WindowInsetsAnimation
 *  android.view.WindowInsetsAnimation$Bounds
 *  android.view.WindowInsetsAnimation$Callback
 */
package androidx.core.view;

import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WindowInsetsAnimationCompat$Impl30$ProxyCallback
extends WindowInsetsAnimation.Callback {
    private final HashMap mAnimations;
    private final WindowInsetsAnimationCompat$Callback mCompat;
    private List mRORunningAnimations;
    private ArrayList mTmpRunningAnimations;

    public WindowInsetsAnimationCompat$Impl30$ProxyCallback(WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        HashMap hashMap;
        int n10 = windowInsetsAnimationCompat$Callback.getDispatchMode();
        super(n10);
        this.mAnimations = hashMap = new HashMap();
        this.mCompat = windowInsetsAnimationCompat$Callback;
    }

    private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat)this.mAnimations.get(windowInsetsAnimation);
        if (windowInsetsAnimationCompat == null) {
            windowInsetsAnimationCompat = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(windowInsetsAnimation);
            HashMap hashMap = this.mAnimations;
            hashMap.put(windowInsetsAnimation, windowInsetsAnimationCompat);
        }
        return windowInsetsAnimationCompat;
    }

    public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback = this.mCompat;
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.getWindowInsetsAnimationCompat(windowInsetsAnimation);
        windowInsetsAnimationCompat$Callback.onEnd(windowInsetsAnimationCompat);
        this.mAnimations.remove(windowInsetsAnimation);
    }

    public void onPrepare(WindowInsetsAnimation object) {
        WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback = this.mCompat;
        object = this.getWindowInsetsAnimationCompat((WindowInsetsAnimation)object);
        windowInsetsAnimationCompat$Callback.onPrepare((WindowInsetsAnimationCompat)object);
    }

    public WindowInsets onProgress(WindowInsets object, List object2) {
        List list = this.mTmpRunningAnimations;
        if (list == null) {
            int n10 = object2.size();
            this.mTmpRunningAnimations = list = new List(n10);
            this.mRORunningAnimations = list = Collections.unmodifiableList(list);
        } else {
            list.clear();
        }
        for (int i10 = object2.size() + -1; i10 >= 0; i10 += -1) {
            Object object3 = (WindowInsetsAnimation)object2.get(i10);
            WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.getWindowInsetsAnimationCompat((WindowInsetsAnimation)object3);
            float f10 = object3.getFraction();
            windowInsetsAnimationCompat.setFraction(f10);
            object3 = this.mTmpRunningAnimations;
            ((ArrayList)object3).add(windowInsetsAnimationCompat);
        }
        object2 = this.mCompat;
        object = WindowInsetsCompat.toWindowInsetsCompat(object);
        list = this.mRORunningAnimations;
        return ((WindowInsetsAnimationCompat$Callback)object2).onProgress((WindowInsetsCompat)object, list).toWindowInsets();
    }

    public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation object, WindowInsetsAnimation.Bounds object2) {
        WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback = this.mCompat;
        object = this.getWindowInsetsAnimationCompat((WindowInsetsAnimation)object);
        object2 = WindowInsetsAnimationCompat$BoundsCompat.toBoundsCompat(object2);
        return windowInsetsAnimationCompat$Callback.onStart((WindowInsetsAnimationCompat)object, (WindowInsetsAnimationCompat$BoundsCompat)object2).toBounds();
    }
}

