/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.utag;

import com.mob.commons.utag.TagRequester;
import com.mob.commons.utag.TagRequester$UserTagsResponse;
import com.mob.commons.utag.UserTagError;
import com.mob.tools.RxMob$Subscriber;
import java.util.HashMap;

public class TagRequester$1
extends RxMob$Subscriber {
    public final /* synthetic */ TagRequester a;

    public TagRequester$1(TagRequester tagRequester) {
        this.a = tagRequester;
    }

    public void a(HashMap hashMap) {
        TagRequester$UserTagsResponse tagRequester$UserTagsResponse = TagRequester.a(this.a);
        if (tagRequester$UserTagsResponse != null) {
            tagRequester$UserTagsResponse = TagRequester.a(this.a);
            tagRequester$UserTagsResponse.onResponse(hashMap);
        }
    }

    public void onError(Throwable throwable) {
        UserTagError userTagError = TagRequester.b(this.a);
        if (userTagError != null) {
            userTagError = TagRequester.b(this.a);
            userTagError.onError(throwable);
        }
    }

    public /* synthetic */ void onNext(Object object) {
        object = (HashMap)object;
        this.a((HashMap)object);
    }
}

