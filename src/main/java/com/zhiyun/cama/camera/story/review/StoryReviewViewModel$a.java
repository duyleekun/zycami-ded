/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.story.review;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import d.v.h.c.b$a;

public class StoryReviewViewModel$a
implements b$a {
    public final /* synthetic */ StoryReviewViewModel a;

    public StoryReviewViewModel$a(StoryReviewViewModel storyReviewViewModel) {
        this.a = storyReviewViewModel;
    }

    public void a(Exception exception, String string2) {
        StoryReviewViewModel.b(this.a, false);
    }

    public void b(int n10) {
        MutableLiveData mutableLiveData = StoryReviewViewModel.c(this.a);
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public void c(String string2) {
        StoryReviewViewModel.d(this.a).setValue(string2);
        StoryReviewViewModel.b(this.a, false);
    }
}

