/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.view.WindowInsets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

public abstract class WindowInsetsAnimationCompat$Callback {
    public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
    public static final int DISPATCH_MODE_STOP;
    public WindowInsets mDispachedInsets;
    private final int mDispatchMode;

    public WindowInsetsAnimationCompat$Callback(int n10) {
        this.mDispatchMode = n10;
    }

    public final int getDispatchMode() {
        return this.mDispatchMode;
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }

    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }

    public abstract WindowInsetsCompat onProgress(WindowInsetsCompat var1, List var2);

    public WindowInsetsAnimationCompat$BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat) {
        return windowInsetsAnimationCompat$BoundsCompat;
    }
}

