/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.view.View$OnLongClickListener
 */
package com.davemorrissey.labs.subscaleview;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class SubsamplingScaleImageView$1
implements Handler.Callback {
    public final /* synthetic */ SubsamplingScaleImageView this$0;

    public SubsamplingScaleImageView$1(SubsamplingScaleImageView subsamplingScaleImageView) {
        this.this$0 = subsamplingScaleImageView;
    }

    public boolean handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 == n11 && (object = SubsamplingScaleImageView.access$000(this.this$0)) != null) {
            SubsamplingScaleImageView.access$102(this.this$0, 0);
            object = this.this$0;
            View.OnLongClickListener onLongClickListener = SubsamplingScaleImageView.access$000((SubsamplingScaleImageView)((Object)object));
            SubsamplingScaleImageView.access$201((SubsamplingScaleImageView)((Object)object), onLongClickListener);
            this.this$0.performLongClick();
            object = this.this$0;
            onLongClickListener = null;
            SubsamplingScaleImageView.access$301((SubsamplingScaleImageView)((Object)object), null);
        }
        return n11 != 0;
    }
}

