/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

public class WindowDecorActionBar$1
extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$1(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public void onAnimationEnd(View object) {
        object = this.this$0;
        boolean bl2 = ((WindowDecorActionBar)object).mContentAnimations;
        if (bl2 && (object = ((WindowDecorActionBar)object).mContentView) != null) {
            bl2 = false;
            object.setTranslationY(0.0f);
            object = this.this$0.mContainerView;
            object.setTranslationY(0.0f);
        }
        this.this$0.mContainerView.setVisibility(8);
        this.this$0.mContainerView.setTransitioning(false);
        object = this.this$0;
        bl2 = false;
        ((WindowDecorActionBar)object).mCurrentShowAnim = null;
        ((WindowDecorActionBar)object).completeDeferredDestroyActionMode();
        object = this.this$0.mOverlayLayout;
        if (object != null) {
            ViewCompat.requestApplyInsets((View)object);
        }
    }
}

