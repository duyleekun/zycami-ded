/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel$ReviewStatus;
import d.v.c.s0.h7.s0.y;

public final class n
implements Observer {
    public final /* synthetic */ y a;

    public /* synthetic */ n(y y10) {
        this.a = y10;
    }

    public final void onChanged(Object object) {
        y y10 = this.a;
        object = (StoryReviewViewModel$ReviewStatus)((Object)object);
        y10.a0((StoryReviewViewModel$ReviewStatus)((Object)object));
    }
}

