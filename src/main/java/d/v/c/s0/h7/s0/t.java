/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.s0;

import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import d.v.h.e.d;
import java.util.List;
import java.util.function.Consumer;

public final class t
implements Consumer {
    public final /* synthetic */ StoryReviewViewModel a;
    public final /* synthetic */ List b;

    public /* synthetic */ t(StoryReviewViewModel storyReviewViewModel, List list) {
        this.a = storyReviewViewModel;
        this.b = list;
    }

    public final void accept(Object object) {
        StoryReviewViewModel storyReviewViewModel = this.a;
        List list = this.b;
        object = (d)object;
        storyReviewViewModel.G(list, (d)object);
    }
}

