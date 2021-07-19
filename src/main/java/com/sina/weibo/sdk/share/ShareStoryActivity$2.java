/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.share;

import android.text.TextUtils;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.share.ShareStoryActivity;
import com.sina.weibo.sdk.share.b;
import com.sina.weibo.sdk.share.c;

public final class ShareStoryActivity$2
implements b {
    public final /* synthetic */ ShareStoryActivity B;

    public ShareStoryActivity$2(ShareStoryActivity shareStoryActivity) {
        this.B = shareStoryActivity;
    }

    public final void a(c object) {
        Object object2 = ShareStoryActivity.a(this.B);
        int n10 = 4;
        object2.setVisibility(n10);
        if (object == null) {
            ShareStoryActivity.b(this.B, "Trans result is null.");
            return;
        }
        boolean bl2 = ((c)object).E;
        if (bl2) {
            object2 = this.B;
            object = ((c)object).G;
            ShareStoryActivity.a((ShareStoryActivity)((Object)object2), (StoryObject)object);
            return;
        }
        object2 = ((c)object).errorMessage;
        bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            ShareStoryActivity.b(this.B, "Trans story fail.");
            return;
        }
        object2 = this.B;
        object = ((c)object).errorMessage;
        ShareStoryActivity.b((ShareStoryActivity)((Object)object2), (String)object);
    }
}

