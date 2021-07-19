/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.s0;

import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import e.a.v0.g;
import java.util.List;

public final class w
implements g {
    public final /* synthetic */ StoryReviewViewModel a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;

    public /* synthetic */ w(StoryReviewViewModel storyReviewViewModel, List list, List list2) {
        this.a = storyReviewViewModel;
        this.b = list;
        this.c = list2;
    }

    public final void accept(Object object) {
        StoryReviewViewModel storyReviewViewModel = this.a;
        List list = this.b;
        List list2 = this.c;
        object = (Integer)object;
        storyReviewViewModel.x(list, list2, (Integer)object);
    }
}

