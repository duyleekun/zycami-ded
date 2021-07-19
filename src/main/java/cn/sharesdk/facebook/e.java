/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.LinearLayout
 *  com.facebook.CallbackManager
 *  com.facebook.CallbackManager$Factory
 *  com.facebook.FacebookCallback
 *  com.facebook.FacebookException
 *  com.facebook.share.Sharer$Result
 *  com.facebook.share.model.ShareHashtag
 *  com.facebook.share.model.ShareHashtag$Builder
 *  com.facebook.share.model.ShareLinkContent
 *  com.facebook.share.model.ShareLinkContent$Builder
 *  com.facebook.share.widget.ShareDialog
 */
package cn.sharesdk.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;

public class e
extends FakeActivity
implements FacebookCallback {
    private ShareDialog a;
    private CallbackManager b;
    private PlatformActionListener c;
    private Platform d;

    public e(Platform platform, PlatformActionListener object) {
        this.d = platform;
        try {
            this.c = object;
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "FacebookOfficialShare catch ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            ((NLog)object).d(string3, objectArray);
        }
    }

    public void a(Sharer.Result object) {
        object = this.c;
        if (object != null) {
            Platform platform = this.d;
            int n10 = 9;
            object.onComplete(platform, n10, null);
        }
        this.finish();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String object, String object2, String object3) {
        Object object4;
        int n10 = 9;
        try {
            boolean bl2;
            boolean bl3 = TextUtils.isEmpty((CharSequence)object);
            if (bl3) {
                object = this.c;
                if (object == null) return;
                Platform platform = this.d;
                String string2 = "share link params is null";
                object4 = new Throwable(string2);
                object.onError(platform, n10, (Throwable)object4);
                this.finish();
                return;
            }
            bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)object4))) {
                ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
                object = Uri.parse((String)object);
                object = builder.setContentUrl((Uri)object);
                object = (ShareLinkContent.Builder)object;
                ShareHashtag.Builder builder2 = new ShareHashtag.Builder();
                ShareHashtag.Builder builder3 = builder2.setHashtag((String)object2);
                ShareHashtag shareHashtag = builder3.build();
                object = object.setShareHashtag(shareHashtag);
                object = (ShareLinkContent.Builder)object;
                object = object.setQuote((String)object4);
                object = object.build();
            } else {
                bl3 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl3) {
                    object4 = new ShareLinkContent.Builder();
                    object = Uri.parse((String)object);
                    object = object4.setContentUrl((Uri)object);
                    object = (ShareLinkContent.Builder)object;
                    object4 = new ShareHashtag.Builder();
                    ShareHashtag.Builder builder = object4.setHashtag((String)object2);
                    ShareHashtag shareHashtag = builder.build();
                    object = object.setShareHashtag(shareHashtag);
                    object = (ShareLinkContent.Builder)object;
                    object = object.build();
                } else {
                    bl2 = TextUtils.isEmpty((CharSequence)object4);
                    if (!bl2) {
                        ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
                        object = Uri.parse((String)object);
                        object = builder.setContentUrl((Uri)object);
                        object = (ShareLinkContent.Builder)object;
                        object = object.setQuote((String)object4);
                        object = object.build();
                    } else {
                        ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
                        object = Uri.parse((String)object);
                        object = builder.setContentUrl((Uri)object);
                        object = (ShareLinkContent.Builder)object;
                        object = object.build();
                    }
                }
            }
            Class<ShareLinkContent> clazz = ShareLinkContent.class;
            bl2 = ShareDialog.canShow(clazz);
            if (!bl2) {
                object = this.c;
                if (object == null) return;
                Platform platform = this.d;
                String string3 = "ShareDialog.canShow(ShareLinkContent.class) is false, are you login first?";
                object4 = new Throwable(string3);
                object.onError(platform, n10, (Throwable)object4);
                this.finish();
                return;
            }
            ShareDialog shareDialog = this.a;
            if (shareDialog != null) {
                shareDialog.show(object);
                return;
            }
            object = this.c;
            if (object == null) return;
            Platform platform = this.d;
            String string4 = "shareDialog is null";
            object4 = new Throwable(string4);
            object.onError(platform, n10, (Throwable)object4);
            this.finish();
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            object4 = "shareLinkOfficial catch ";
            nLog.w((String)object4);
            PlatformActionListener platformActionListener = this.c;
            if (platformActionListener != null) {
                object4 = this.d;
                platformActionListener.onError((Platform)object4, n10, throwable);
            }
            this.finish();
        }
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        this.b.onActivityResult(n10, n11, intent);
        super.onActivityResult(n10, n11, intent);
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            Platform platform = this.d;
            int n10 = 9;
            platformActionListener.onCancel(platform, n10);
        }
        this.finish();
    }

    public void onCreate() {
        Object object = this.activity;
        Object object2 = new LinearLayout((Context)object);
        int n10 = 1;
        object2.setOrientation(n10);
        object = this.activity;
        try {
            object.setContentView((View)object2);
        }
        catch (Exception exception) {
            object = SSDKLog.b();
            ((NLog)object).d(exception);
        }
        SSDKLog.b().w("FacebookOfficialHelper onCreate");
        object2 = CallbackManager.Factory.create();
        this.b = object2;
        object = this.activity;
        object2 = new ShareDialog((Activity)object);
        this.a = object2;
        object = this.b;
        object2.registerCallback((CallbackManager)object, (FacebookCallback)this);
        object2 = this.activity.getIntent();
        object = object2.getStringExtra("params_linkurl");
        String string2 = object2.getStringExtra("params_Hashtag");
        object2 = object2.getStringExtra("params_Quote");
        NLog nLog = SSDKLog.b();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Share params url is: ");
        charSequence.append((String)object);
        charSequence.append(" hashtag: ");
        charSequence.append(string2);
        charSequence.append(" quote: ");
        charSequence.append((String)object2);
        charSequence = charSequence.toString();
        nLog.w((String)charSequence);
        this.a((String)object, string2, (String)object2);
    }

    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("FacebookOfficialShareWebPage onDestroy");
    }

    public void onError(FacebookException facebookException) {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            Platform platform = this.d;
            int n10 = 9;
            platformActionListener.onError(platform, n10, (Throwable)facebookException);
        }
        this.finish();
    }

    public void onPause() {
        super.onPause();
        SSDKLog.b().w("FacebookOfficialShareWebPage onPause");
    }

    public void onResume() {
        super.onResume();
        SSDKLog.b().w("FacebookOfficialShareWebPage onResume");
    }

    public void onStop() {
        super.onStop();
        SSDKLog.b().w("FacebookOfficialShareWebPage onStop");
    }

    public /* synthetic */ void onSuccess(Object object) {
        object = (Sharer.Result)object;
        this.a((Sharer.Result)object);
    }
}

