/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.s0;

import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import e.a.v0.g;

public final class v
implements g {
    public final /* synthetic */ StoryReviewViewModel a;
    public final /* synthetic */ String b;

    public /* synthetic */ v(StoryReviewViewModel storyReviewViewModel, String string2) {
        this.a = storyReviewViewModel;
        this.b = string2;
    }

    public final void accept(Object object) {
        StoryReviewViewModel storyReviewViewModel = this.a;
        String string2 = this.b;
        object = (Integer)object;
        storyReviewViewModel.A(string2, (Integer)object);
    }
}

