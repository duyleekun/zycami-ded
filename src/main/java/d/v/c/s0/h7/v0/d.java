/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.h7.v0;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;

public final class d
implements View.OnClickListener {
    public final /* synthetic */ StoryReviewVideoView a;
    public final /* synthetic */ LifecycleOwner b;

    public /* synthetic */ d(StoryReviewVideoView storyReviewVideoView, LifecycleOwner lifecycleOwner) {
        this.a = storyReviewVideoView;
        this.b = lifecycleOwner;
    }

    public final void onClick(View view) {
        StoryReviewVideoView storyReviewVideoView = this.a;
        LifecycleOwner lifecycleOwner = this.b;
        storyReviewVideoView.i(lifecycleOwner, view);
    }
}

