/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
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
 *  com.facebook.share.model.SharePhoto
 *  com.facebook.share.model.SharePhoto$Builder
 *  com.facebook.share.model.SharePhotoContent
 *  com.facebook.share.model.SharePhotoContent$Builder
 *  com.facebook.share.widget.ShareDialog
 */
package cn.sharesdk.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;

public class c
extends FakeActivity
implements FacebookCallback {
    private ShareDialog a;
    private CallbackManager b;
    private PlatformActionListener c;
    private Platform d;
    private Bitmap e;
    private String f;

    public c(Platform object, PlatformActionListener object2) {
        this.d = object;
        this.c = object2;
        object = SSDKLog.b();
        object2 = "Facebook doShare official FacebookOfficialShareImage construction";
        try {
            ((NLog)object).w((String)object2);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Facebook doShare official FacebookOfficialShareImage catch:  ";
            stringBuilder.append(string2);
            stringBuilder.append(throwable);
            String string3 = stringBuilder.toString();
            ((NLog)object2).w(string3);
        }
    }

    public void a(Bitmap bitmap) {
        this.e = bitmap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Bitmap object, String object2) {
        int n10 = 9;
        try {
            Object object3 = SSDKLog.b();
            String string2 = "Facebook FacebookOfficialHelper shareImageOfficial";
            ((NLog)object3).w(string2);
            if (object == null) {
                object = this.c;
                if (object == null) return;
                object = SSDKLog.b();
                String string3 = "Facebook doShare shareImageOfficial set bitmap image is error, please check ";
                ((NLog)object).w(string3);
                object = this.c;
                Platform platform = this.d;
                string2 = "set bitmap image is error, please check";
                object3 = new Throwable(string2);
                object.onError(platform, n10, (Throwable)object3);
                this.finish();
                return;
            }
            object3 = new SharePhoto.Builder();
            object = object3.setBitmap((Bitmap)object);
            object = object.build();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                SharePhotoContent.Builder builder = new SharePhotoContent.Builder();
                object = builder.addPhoto((SharePhoto)object);
                object = object.build();
            } else {
                object3 = new SharePhotoContent.Builder();
                object = object3.addPhoto((SharePhoto)object);
                object3 = new ShareHashtag.Builder();
                ShareHashtag.Builder builder = object3.setHashtag((String)object2);
                ShareHashtag shareHashtag = builder.build();
                object = object.setShareHashtag(shareHashtag);
                object = (SharePhotoContent.Builder)object;
                object = object.build();
            }
            Class<SharePhotoContent> clazz = SharePhotoContent.class;
            boolean bl3 = ShareDialog.canShow(clazz);
            if (!bl3) {
                object = this.c;
                if (object == null) return;
                object = SSDKLog.b();
                String string4 = "Facebook doShare shareImageOfficial ShareDialog.canShow(SharePhotoContent.class) is false, are you login first? ";
                ((NLog)object).w(string4);
                object = this.c;
                Platform platform = this.d;
                string2 = "ShareDialog.canShow(SharePhotoContent.class) is false, are you login first?";
                object3 = new Throwable(string2);
                object.onError(platform, n10, (Throwable)object3);
                this.finish();
                return;
            }
            ShareDialog shareDialog = this.a;
            if (shareDialog != null) {
                shareDialog.show(object);
                object = SSDKLog.b();
                String string5 = "Facebook FacebookOfficialHelper shareImageOfficial shareDialog.show";
                ((NLog)object).w(string5);
                return;
            }
            object = this.c;
            if (object == null) return;
            object = SSDKLog.b();
            String string6 = "Facebook doShare shareImageOfficial shareDialog is null ";
            ((NLog)object).w(string6);
            object = this.c;
            Platform platform = this.d;
            string2 = "shareDialog is null";
            object3 = new Throwable(string2);
            object.onError(platform, n10, (Throwable)object3);
            this.finish();
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object object4 = "Facebook doShare shareImageOfficial shareImageOfficial catch ";
            nLog.w((String)object4);
            PlatformActionListener platformActionListener = this.c;
            if (platformActionListener != null) {
                object4 = this.d;
                platformActionListener.onError((Platform)object4, n10, throwable);
            }
            this.finish();
        }
    }

    public void a(Sharer.Result object) {
        object = this.c;
        if (object != null) {
            Platform platform = this.d;
            int n10 = 9;
            object.onComplete(platform, n10, null);
        }
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onSuccess ");
        this.finish();
    }

    public void a(String string2) {
        this.f = string2;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        this.b.onActivityResult(n10, n11, intent);
        super.onActivityResult(n10, n11, intent);
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onActivityResult ");
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            Platform platform = this.d;
            int n10 = 9;
            platformActionListener.onCancel(platform, n10);
        }
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onCancel ");
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
            SSDKLog.b().d(exception);
            object = SSDKLog.b();
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Facebook doShare official FacebookOfficialShareImage onCreate catch  ";
            stringBuilder.append(string2);
            object2 = exception.getMessage();
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            ((NLog)object).w((String)object2);
        }
        SSDKLog.b().w("Facebook FacebookOfficialHelper onCreate");
        object2 = CallbackManager.Factory.create();
        this.b = object2;
        object = this.activity;
        object2 = new ShareDialog((Activity)object);
        this.a = object2;
        object = this.b;
        object2.registerCallback((CallbackManager)object, (FacebookCallback)this);
        object2 = this.e;
        object = this.f;
        this.a((Bitmap)object2, (String)object);
    }

    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onDestroy ");
    }

    public void onError(FacebookException facebookException) {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            Platform platform = this.d;
            int n10 = 9;
            platformActionListener.onError(platform, n10, (Throwable)facebookException);
        }
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onError ");
        this.finish();
    }

    public void onPause() {
        super.onPause();
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onPause ");
    }

    public void onResume() {
        super.onResume();
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onResume ");
    }

    public void onStop() {
        super.onStop();
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onStop ");
    }

    public /* synthetic */ void onSuccess(Object object) {
        object = (Sharer.Result)object;
        this.a((Sharer.Result)object);
    }
}

