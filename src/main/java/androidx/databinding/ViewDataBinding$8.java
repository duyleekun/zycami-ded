/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package androidx.databinding;

import android.view.Choreographer;
import androidx.databinding.ViewDataBinding;

public class ViewDataBinding$8
implements Choreographer.FrameCallback {
    public final /* synthetic */ ViewDataBinding this$0;

    public ViewDataBinding$8(ViewDataBinding viewDataBinding) {
        this.this$0 = viewDataBinding;
    }

    public void doFrame(long l10) {
        ViewDataBinding.access$100(this.this$0).run();
    }
}

