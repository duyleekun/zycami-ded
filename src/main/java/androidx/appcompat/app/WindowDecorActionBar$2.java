/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

public class WindowDecorActionBar$2
extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$2(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public void onAnimationEnd(View object) {
        object = this.this$0;
        object.mCurrentShowAnim = null;
        object.mContainerView.requestLayout();
    }
}

