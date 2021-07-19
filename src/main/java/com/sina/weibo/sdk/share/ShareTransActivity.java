/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ProgressBar
 */
package com.sina.weibo.sdk.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.c.a$a;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.share.BaseActivity;
import com.sina.weibo.sdk.share.ShareTransActivity$1;
import com.sina.weibo.sdk.share.ShareTransActivity$2;
import com.sina.weibo.sdk.share.b;
import com.sina.weibo.sdk.share.d;

public class ShareTransActivity
extends BaseActivity {
    private d C;
    private Intent u;
    private FrameLayout v;
    private Handler x;

    public ShareTransActivity() {
        Looper looper = Looper.getMainLooper();
        ShareTransActivity$1 shareTransActivity$1 = new ShareTransActivity$1(this, looper);
        this.x = shareTransActivity$1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(WeiboMultiMessage object) {
        CharSequence charSequence = "WBShareTag";
        Object object2 = "start wb composer";
        c.a((String)charSequence, (String)object2);
        try {
            object2 = this.u;
            String string2 = "start_flag";
            int n10 = -1;
            object2.putExtra(string2, n10);
            object2 = this.u;
            object2 = object2.getExtras();
            String string3 = "com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY";
            string2 = new Intent(string3);
            object = ((WeiboMultiMessage)object).writeToBundle((Bundle)object2);
            string2.putExtras((Bundle)object);
            object = "_weibo_sdkVersion";
            object2 = "0041005000";
            string2.putExtra((String)object, (String)object2);
            object = "_weibo_appPackage";
            object2 = this.getPackageName();
            string2.putExtra((String)object, (String)object2);
            object = "_weibo_appKey";
            object2 = a.a();
            object2 = ((AuthInfo)object2).getAppKey();
            string2.putExtra((String)object, (String)object2);
            object = "_weibo_flag";
            int n11 = 538116905;
            string2.putExtra((String)object, n11);
            object = "_weibo_sign";
            object2 = this.getPackageName();
            object2 = e.e((Context)this, (String)object2);
            object2 = com.sina.weibo.sdk.c.d.f((String)object2);
            string2.putExtra((String)object, (String)object2);
            object = this.u;
            object2 = "start_web_activity";
            object = object.getStringExtra((String)object2);
            n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            n10 = 10001;
            if (n11 == 0 && (n11 = (int)(((String)(object2 = "com.sina.weibo.sdk.web.WebActivity")).equals(object) ? 1 : 0)) != 0) {
                string2.setClassName((Context)this, (String)object);
                this.startActivityForResult((Intent)string2, n10);
                return;
            }
            boolean bl2 = a.a((Context)this);
            if (!bl2) {
                object = "Start weibo client's composer fail. And Weibo client is not installed.";
                this.c((String)object);
                return;
            }
            object = com.sina.weibo.sdk.c.a.c((Context)this);
            if (object != null) {
                object = ((a$a)object).packageName;
                string2.setPackage((String)object);
            }
            this.startActivityForResult((Intent)string2, n10);
            return;
        }
        catch (Throwable throwable) {
            object2 = new StringBuilder("start wb composer fail,");
            String string4 = throwable.getMessage();
            ((StringBuilder)object2).append(string4);
            object2 = ((StringBuilder)object2).toString();
            c.b((String)charSequence, (String)object2);
            charSequence = new StringBuilder("Start weibo client's composer fail. ");
            String string5 = throwable.getMessage();
            ((StringBuilder)charSequence).append(string5);
            string5 = ((StringBuilder)charSequence).toString();
            this.c(string5);
            return;
        }
    }

    public static /* synthetic */ void a(ShareTransActivity shareTransActivity) {
        int n10;
        FrameLayout frameLayout = shareTransActivity.v;
        if (frameLayout != null) {
            n10 = 8;
            frameLayout.setVisibility(n10);
        }
        frameLayout = new Intent();
        Bundle bundle = new Bundle();
        String string2 = "_weibo_resp_errcode";
        int n11 = 1;
        bundle.putInt(string2, n11);
        frameLayout.putExtras(bundle);
        n10 = -1;
        try {
            shareTransActivity.setResult(n10, (Intent)frameLayout);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        frameLayout = shareTransActivity.x;
        if (frameLayout != null) {
            n10 = 0;
            bundle = null;
            frameLayout.removeMessages(0);
            frameLayout = null;
            shareTransActivity.x = null;
        }
        shareTransActivity.finish();
    }

    public static /* synthetic */ void a(ShareTransActivity shareTransActivity, WeiboMultiMessage weiboMultiMessage) {
        shareTransActivity.a(weiboMultiMessage);
    }

    public static /* synthetic */ void a(ShareTransActivity shareTransActivity, String string2) {
        shareTransActivity.c(string2);
    }

    public static /* synthetic */ FrameLayout b(ShareTransActivity shareTransActivity) {
        return shareTransActivity.v;
    }

    private void c(String string2) {
        FrameLayout frameLayout = this.v;
        if (frameLayout != null) {
            int n10 = 4;
            frameLayout.setVisibility(n10);
        }
        frameLayout = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", string2);
        frameLayout.putExtras(bundle);
        this.setResult(-1, (Intent)frameLayout);
        this.finish();
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        String string2 = "onActivityResult.";
        c.a("WBShareTag", string2);
        Handler handler = this.x;
        if (handler != null) {
            n11 = 0;
            string2 = null;
            long l10 = 100;
            handler.sendEmptyMessageDelayed(0, l10);
        }
    }

    public void onCreate(Bundle object) {
        Object object2;
        super.onCreate((Bundle)object);
        object = "WBShareTag";
        c.a((String)object, "start share activity.");
        Object object3 = this.getIntent();
        this.u = object3;
        if (object3 == null) {
            this.finish();
            return;
        }
        Object[] objectArray = "start_flag";
        int n10 = -1;
        int n11 = object3.getIntExtra((String)objectArray, n10);
        if (n11 != 0) {
            this.finish();
            return;
        }
        object3 = new FrameLayout((Context)this);
        this.v = object3;
        object3 = this.getIntent();
        n11 = object3.getIntExtra((String)(objectArray = "progress_id"), n10);
        if (n11 != n10) {
            objectArray = (LayoutInflater)this.getSystemService("layout_inflater");
            n10 = 0;
            object2 = null;
            object3 = objectArray.inflate(n11, null);
        } else {
            object3 = new ProgressBar((Context)this);
        }
        n10 = -2;
        objectArray = new FrameLayout.LayoutParams(n10, n10);
        objectArray.gravity = n10 = 17;
        object2 = this.v;
        object2.addView((View)object3, (ViewGroup.LayoutParams)objectArray);
        object3 = this.v;
        int n12 = 0x33000000;
        object3.setBackgroundColor(n12);
        object3 = this.v;
        this.setContentView((View)object3);
        object3 = "prepare wb resource.";
        c.a((String)object, (String)object3);
        object = this.u.getExtras();
        if (object == null) {
            this.finish();
            return;
        }
        object3 = new WeiboMultiMessage();
        ((WeiboMultiMessage)object3).readFromBundle((Bundle)object);
        object = ((WeiboMultiMessage)object3).multiImageObject;
        if (object == null && (object = ((WeiboMultiMessage)object3).videoSourceObject) == null) {
            this.a((WeiboMultiMessage)object3);
            return;
        }
        object = this.C;
        n12 = 1;
        if (object != null) {
            object.cancel(n12 != 0);
        }
        object2 = new ShareTransActivity$2(this);
        object = new d((Context)this, (b)object2);
        this.C = object;
        objectArray = new WeiboMultiMessage[n12];
        objectArray[0] = object3;
        object.execute(objectArray);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String string2 = "start share activity again.";
        c.a("WBShareTag", string2);
        Handler handler = this.x;
        if (handler != null) {
            string2 = null;
            handler.removeMessages(0);
            handler = null;
            this.x = null;
        }
        this.setResult(-1, intent);
        this.finish();
    }
}

