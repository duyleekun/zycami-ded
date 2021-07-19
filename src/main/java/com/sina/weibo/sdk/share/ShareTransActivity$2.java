/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.share;

import android.text.TextUtils;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.b;
import com.sina.weibo.sdk.share.c;

public final class ShareTransActivity$2
implements b {
    public final /* synthetic */ ShareTransActivity D;

    public ShareTransActivity$2(ShareTransActivity shareTransActivity) {
        this.D = shareTransActivity;
    }

    public final void a(c object) {
        Object object2 = ShareTransActivity.b(this.D);
        int n10 = 4;
        object2.setVisibility(n10);
        if (object == null) {
            ShareTransActivity.a(this.D, "Trans result is null.");
            return;
        }
        boolean bl2 = ((c)object).E;
        if (bl2) {
            object2 = this.D;
            object = ((c)object).F;
            ShareTransActivity.a((ShareTransActivity)((Object)object2), (WeiboMultiMessage)object);
            return;
        }
        object2 = ((c)object).errorMessage;
        bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            ShareTransActivity.a(this.D, "Trans resource fail.");
            return;
        }
        object2 = this.D;
        object = ((c)object).errorMessage;
        ShareTransActivity.a((ShareTransActivity)((Object)object2), (String)object);
    }
}

