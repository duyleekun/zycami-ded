/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
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
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.b.b;
import com.sina.weibo.sdk.b.b$a;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.b.d;
import com.sina.weibo.sdk.share.BaseActivity;
import com.sina.weibo.sdk.share.ShareChatActivity$1;
import com.sina.weibo.sdk.share.ShareChatActivity$2;
import java.util.concurrent.FutureTask;

public class ShareChatActivity
extends BaseActivity {
    private Intent u;
    private FrameLayout v;
    private d w;
    private Handler x;

    public ShareChatActivity() {
        Looper looper = Looper.getMainLooper();
        ShareChatActivity$1 shareChatActivity$1 = new ShareChatActivity$1(this, looper);
        this.x = shareChatActivity$1;
    }

    public static /* synthetic */ void a(ShareChatActivity shareChatActivity) {
        int n10;
        FrameLayout frameLayout = shareChatActivity.v;
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
            shareChatActivity.setResult(n10, (Intent)frameLayout);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        frameLayout = shareChatActivity.x;
        if (frameLayout != null) {
            n10 = 0;
            bundle = null;
            frameLayout.removeMessages(0);
            frameLayout = null;
            shareChatActivity.x = null;
        }
        shareChatActivity.finish();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void a(ShareChatActivity shareChatActivity, ChatObject object, String string2, String string3) {
        String string4;
        Bundle bundle;
        try {
            bundle = new Bundle();
            string4 = "page_url";
        }
        catch (Exception exception) {
            return;
        }
        bundle.putString(string4, string2);
        string2 = "page_id";
        bundle.putString(string2, string3);
        string2 = "page_type";
        boolean bl2 = false;
        string3 = null;
        bundle.putInt(string2, 0);
        string2 = "composer_launch_type";
        int n10 = 4002;
        bundle.putInt(string2, n10);
        string2 = "page_showcard";
        boolean bl3 = true;
        bundle.putBoolean(string2, bl3);
        string2 = "page_pic";
        string3 = ((ChatObject)object).image_url;
        bundle.putString(string2, string3);
        string2 = "page_title";
        object = ((ChatObject)object).content;
        bundle.putString(string2, (String)object);
        object = new Intent();
        string2 = "android.intent.action.VIEW";
        object.setAction(string2);
        string2 = "sinaweibo://extendthirdshare";
        string2 = Uri.parse((String)string2);
        object.setData((Uri)string2);
        string2 = "com.sina.weibo";
        object.setPackage(string2);
        string2 = new Bundle();
        string3 = "param_bundle";
        string2.putBundle(string3, bundle);
        string3 = "share_type";
        int n11 = 1001;
        string2.putInt(string3, n11);
        object.putExtras((Bundle)string2);
        int n12 = 10001;
        shareChatActivity.startActivityForResult((Intent)object, n12);
    }

    public static /* synthetic */ void a(ShareChatActivity shareChatActivity, String string2) {
        FrameLayout frameLayout = shareChatActivity.v;
        if (frameLayout != null) {
            int n10 = 4;
            frameLayout.setVisibility(n10);
        }
        frameLayout = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", string2);
        frameLayout.putExtras(bundle);
        shareChatActivity.setResult(-1, (Intent)frameLayout);
        shareChatActivity.finish();
    }

    public static /* synthetic */ FrameLayout b(ShareChatActivity shareChatActivity) {
        return shareChatActivity.v;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        Handler handler = this.x;
        if (handler != null) {
            n11 = 0;
            long l10 = 100;
            handler.sendEmptyMessageDelayed(0, l10);
        }
    }

    public void onCreate(Bundle object) {
        Object object2;
        super.onCreate((Bundle)object);
        object = this.getIntent();
        this.u = object;
        if (object == null) {
            this.finish();
            return;
        }
        Object object3 = "start_flag";
        int n10 = -1;
        int n11 = object.getIntExtra((String)object3, n10);
        if (n11) {
            this.finish();
            return;
        }
        object = new FrameLayout((Context)this);
        this.v = object;
        object = this.getIntent();
        n11 = object.getIntExtra((String)(object3 = "progress_id"), n10);
        if (n11 != n10) {
            object3 = (LayoutInflater)this.getSystemService("layout_inflater");
            n10 = 0;
            object2 = null;
            object = object3.inflate(n11, null);
        } else {
            object = new ProgressBar((Context)this);
        }
        n10 = -2;
        object3 = new FrameLayout.LayoutParams(n10, n10);
        n10 = 17;
        ((FrameLayout.LayoutParams)object3).gravity = n10;
        object2 = this.v;
        object2.addView((View)object, (ViewGroup.LayoutParams)object3);
        object = this.v;
        int n12 = 0x33000000;
        object.setBackgroundColor(n12);
        object = this.v;
        this.setContentView((View)object);
        object = this.u.getExtras();
        if (object == null) {
            this.finish();
            return;
        }
        object3 = "chat_object";
        if ((object = (ChatObject)object.getParcelable((String)object3)) != null) {
            object3 = this.w;
            if (object3 != null) {
                object3 = ((c)object3).S;
                n10 = 1;
                ((FutureTask)object3).cancel(n10 != 0);
            }
            object2 = new ShareChatActivity$2(this, (ChatObject)object);
            this.w = object3 = new d((Context)this, (ChatObject)object, (com.sina.weibo.sdk.net.c)object2);
            object = b$a.n();
            object3 = this.w;
            ((b)object).a((c)object3);
            return;
        }
        this.v.setVisibility(4);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            handler = null;
            this.x = null;
        }
        this.setResult(-1, intent);
        this.finish();
    }
}

