/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.widget;

import androidx.core.widget.ContentLoadingProgressBar;

public class ContentLoadingProgressBar$1
implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar this$0;

    public ContentLoadingProgressBar$1(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.this$0 = contentLoadingProgressBar;
    }

    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.this$0;
        contentLoadingProgressBar.mPostedHide = false;
        contentLoadingProgressBar.mStartTime = -1;
        contentLoadingProgressBar.setVisibility(8);
    }
}

