/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.widget.FrameLayout
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.sina.weibo.sdk.share;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.net.c;
import com.sina.weibo.sdk.share.ShareChatActivity;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareChatActivity$2
implements c {
    public final /* synthetic */ ShareChatActivity y;
    public final /* synthetic */ ChatObject z;

    public ShareChatActivity$2(ShareChatActivity shareChatActivity, ChatObject chatObject) {
        this.y = shareChatActivity;
        this.z = chatObject;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void a(Object object) {
        object = (String)object;
        FrameLayout frameLayout = ShareChatActivity.b(this.y);
        int n10 = 4;
        frameLayout.setVisibility(n10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            try {
                boolean bl3;
                JSONObject jSONObject = new JSONObject((String)object);
                object = "code";
                int n11 = jSONObject.optInt((String)object);
                String string3 = "errmsg";
                string3 = jSONObject.optString(string3);
                Object object2 = "data";
                String string4 = jSONObject.optString((String)object2);
                if (n11 == 0 && !(bl3 = TextUtils.isEmpty((CharSequence)string4))) {
                    object = new JSONObject(string4);
                    String string6 = "short_url";
                    string6 = object.optString(string6);
                    String string7 = "object_id";
                    object = object.optString(string7);
                    ShareChatActivity shareChatActivity = this.y;
                    object2 = this.z;
                    ShareChatActivity.a(shareChatActivity, (ChatObject)object2, string6, (String)object);
                    return;
                }
                ShareChatActivity shareChatActivity = this.y;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string3);
                String string8 = "(";
                ((StringBuilder)object2).append(string8);
                ((StringBuilder)object2).append(n11);
                object = ")";
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                ShareChatActivity.a(shareChatActivity, (String)object);
                return;
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
    }

    public final void onError(Throwable object) {
        ShareChatActivity.b(this.y).setVisibility(4);
        ShareChatActivity shareChatActivity = this.y;
        object = ((Throwable)object).getMessage();
        ShareChatActivity.a(shareChatActivity, (String)object);
    }
}

