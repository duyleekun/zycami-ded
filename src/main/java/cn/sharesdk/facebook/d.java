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
 *  com.facebook.share.model.ShareVideo
 *  com.facebook.share.model.ShareVideo$Builder
 *  com.facebook.share.model.ShareVideoContent
 *  com.facebook.share.model.ShareVideoContent$Builder
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
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;

public class d
extends FakeActivity
implements FacebookCallback {
    private ShareDialog a;
    private CallbackManager b;
    private PlatformActionListener c;
    private Platform d;
    private Uri e;
    private String f;

    public d(Platform platform, PlatformActionListener object) {
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

    public void a(Uri uri) {
        this.e = uri;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(Uri var1_1, String var2_3) {
        block40: {
            block39: {
                block38: {
                    var3_4 = 9;
                    if (var1_1 == null) ** GOTO lbl75
                    var4_5 /* !! */  = new ShareVideo.Builder();
                    var1_1 = var4_5 /* !! */ .setLocalUrl((Uri)var1_1);
                    var1_1 = var1_1.build();
                    var5_6 = TextUtils.isEmpty((CharSequence)var2_3 /* !! */ );
                    if (!var5_6) break block38;
                    var2_3 /* !! */  = new ShareVideoContent.Builder();
                    var1_1 = var2_3 /* !! */ .setVideo((ShareVideo)var1_1);
                    var1_1 = var1_1.build();
                    break block39;
                }
                var4_5 /* !! */  = new ShareVideoContent.Builder();
                var1_1 = var4_5 /* !! */ .setVideo((ShareVideo)var1_1);
                var4_5 /* !! */  = new ShareHashtag.Builder();
                var2_3 /* !! */  = var4_5 /* !! */ .setHashtag(var2_3 /* !! */ );
                var2_3 /* !! */  = var2_3 /* !! */ .build();
                var1_1 = var1_1.setShareHashtag((ShareHashtag)var2_3 /* !! */ );
                var1_1 = (ShareVideoContent.Builder)var1_1;
                var2_3 /* !! */  = "contentTitle";
                var1_1 = var1_1.setContentTitle((String)var2_3 /* !! */ );
                var2_3 /* !! */  = "contentText";
                var1_1 = var1_1.setContentDescription((String)var2_3 /* !! */ );
                var1_1 = var1_1.build();
            }
            var2_3 /* !! */  = ShareVideoContent.class;
            var6_7 = ShareDialog.canShow(var2_3 /* !! */ );
            if (!var6_7) ** GOTO lbl64
            var2_3 /* !! */  = this.a;
            if (var2_3 /* !! */  == null) ** GOTO lbl53
            var2_3 /* !! */ .show(var1_1);
            break block40;
lbl53:
            // 1 sources

            var1_1 = this.c;
            if (var1_1 == null) break block40;
            var2_3 /* !! */  = this.d;
            var7_8 = "shareDialog is null";
            var4_5 /* !! */  = new Throwable(var7_8);
            var1_1.onError((Platform)var2_3 /* !! */ , var3_4, (Throwable)var4_5 /* !! */ );
            this.finish();
            break block40;
lbl64:
            // 1 sources

            var1_1 = this.c;
            if (var1_1 == null) break block40;
            var2_3 /* !! */  = this.d;
            var7_9 = "ShareDialog.canShow(ShareVideoContent.class) is false, are you login first?";
            var4_5 /* !! */  = new Throwable(var7_9);
            var1_1.onError((Platform)var2_3 /* !! */ , var3_4, (Throwable)var4_5 /* !! */ );
            this.finish();
            break block40;
lbl75:
            // 1 sources

            var1_1 = this.c;
            if (var1_1 == null) break block40;
            var2_3 /* !! */  = this.d;
            var7_10 = "share video paramas is null";
            var4_5 /* !! */  = new Throwable(var7_10);
            try {
                var1_1.onError((Platform)var2_3 /* !! */ , var3_4, (Throwable)var4_5 /* !! */ );
                this.finish();
            }
            catch (Throwable var1_2) {
                var2_3 /* !! */  = SSDKLog.b();
                var4_5 /* !! */  = "shareVideoOfficial catch ";
                var2_3 /* !! */ .w((String)var4_5 /* !! */ );
                var2_3 /* !! */  = this.c;
                if (var2_3 /* !! */  != null) {
                    var4_5 /* !! */  = this.d;
                    var2_3 /* !! */ .onError((Platform)var4_5 /* !! */ , var3_4, var1_2);
                }
                this.finish();
            }
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

    public void a(String string2) {
        this.f = string2;
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
        LinearLayout linearLayout = new LinearLayout((Context)object);
        int n10 = 1;
        linearLayout.setOrientation(n10);
        object = this.activity;
        try {
            object.setContentView((View)linearLayout);
        }
        catch (Exception exception) {
            object = SSDKLog.b();
            ((NLog)object).d(exception);
        }
        SSDKLog.b().w("FacebookOfficialHelper onCreate");
        linearLayout = CallbackManager.Factory.create();
        this.b = linearLayout;
        object = this.activity;
        linearLayout = new ShareDialog((Activity)object);
        this.a = linearLayout;
        object = this.b;
        linearLayout.registerCallback((CallbackManager)object, (FacebookCallback)this);
        linearLayout = this.e;
        object = this.f;
        this.a((Uri)linearLayout, (String)object);
    }

    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("FacebookOfficialShareVideo onDestroy");
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
        SSDKLog.b().w("FacebookOfficialShareVideo onPause");
    }

    public void onResume() {
        super.onResume();
        SSDKLog.b().w("FacebookOfficialShareVideo onResume");
    }

    public void onStop() {
        super.onStop();
        SSDKLog.b().w("FacebookOfficialShareVideo onStop");
    }

    public /* synthetic */ void onSuccess(Object object) {
        object = (Sharer.Result)object;
        this.a((Sharer.Result)object);
    }
}

