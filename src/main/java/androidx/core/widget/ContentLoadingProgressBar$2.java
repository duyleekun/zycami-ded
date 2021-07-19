/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.widget;

import androidx.core.widget.ContentLoadingProgressBar;

public class ContentLoadingProgressBar$2
implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar this$0;

    public ContentLoadingProgressBar$2(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.this$0 = contentLoadingProgressBar;
    }

    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.this$0;
        contentLoadingProgressBar.mPostedShow = false;
        boolean bl2 = contentLoadingProgressBar.mDismissed;
        if (!bl2) {
            long l10;
            contentLoadingProgressBar.mStartTime = l10 = System.currentTimeMillis();
            contentLoadingProgressBar = this.this$0;
            contentLoadingProgressBar.setVisibility(0);
        }
    }
}

