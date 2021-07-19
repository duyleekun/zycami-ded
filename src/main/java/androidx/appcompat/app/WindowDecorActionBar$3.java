/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

public class WindowDecorActionBar$3
implements ViewPropertyAnimatorUpdateListener {
    public final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$3(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public void onAnimationUpdate(View view) {
        ((View)this.this$0.mContainerView.getParent()).invalidate();
    }
}

