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
 *  android.os.Parcelable
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
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.share.BaseActivity;
import com.sina.weibo.sdk.share.ShareStoryActivity$1;
import com.sina.weibo.sdk.share.ShareStoryActivity$2;
import com.sina.weibo.sdk.share.e;

public class ShareStoryActivity
extends BaseActivity {
    private e A;
    private Intent u;
    private FrameLayout v;
    private Handler x;

    public ShareStoryActivity() {
        Looper looper = Looper.getMainLooper();
        ShareStoryActivity$1 shareStoryActivity$1 = new ShareStoryActivity$1(this, looper);
        this.x = shareStoryActivity$1;
    }

    public static /* synthetic */ FrameLayout a(ShareStoryActivity shareStoryActivity) {
        return shareStoryActivity.v;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10, String string2) {
        Throwable throwable2222222;
        block7: {
            block6: {
                int n11;
                FrameLayout frameLayout = this.v;
                if (frameLayout != null) {
                    n11 = 4;
                    frameLayout.setVisibility(n11);
                }
                frameLayout = null;
                n11 = 0;
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                String string3 = "_weibo_resp_errcode";
                bundle.putInt(string3, n10);
                String string4 = "_weibo_resp_errstr";
                bundle.putString(string4, string2);
                intent.putExtras(bundle);
                n10 = -1;
                this.setResult(n10, intent);
                string4 = this.x;
                if (string4 == null) break block6;
                {
                    block8: {
                        Handler handler;
                        catch (Throwable throwable2222222) {
                            break block7;
                        }
                        catch (Exception exception) {}
                        {
                            exception.printStackTrace();
                            handler = this.x;
                            if (handler == null) break block8;
                        }
                        handler.removeMessages(0);
                        this.x = null;
                    }
                    this.finish();
                    return;
                }
                string4.removeMessages(0);
                this.x = null;
            }
            this.finish();
            return;
        }
        string2 = this.x;
        if (string2 != null) {
            string2.removeMessages(0);
            this.x = null;
        }
        this.finish();
        throw throwable2222222;
    }

    public static /* synthetic */ void a(ShareStoryActivity shareStoryActivity, StoryObject object) {
        String string2 = "android.intent.action.VIEW";
        String string3 = "sinaweibo://story/publish?forceedit=1&finish=true";
        try {
            string3 = Uri.parse((String)string3);
        }
        catch (Exception exception) {
            object = exception.getMessage();
            shareStoryActivity.c((String)object);
            return;
        }
        Intent intent = new Intent(string2, (Uri)string3);
        string2 = "com.sina.weibo";
        intent.setPackage(string2);
        string2 = "storyData";
        intent.putExtra(string2, (Parcelable)object);
        int n10 = 10001;
        shareStoryActivity.startActivityForResult(intent, n10);
    }

    public static /* synthetic */ void a(ShareStoryActivity shareStoryActivity, String string2) {
        shareStoryActivity.a(1, string2);
    }

    public static /* synthetic */ void b(ShareStoryActivity shareStoryActivity, String string2) {
        shareStoryActivity.c(string2);
    }

    private void c(String string2) {
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            handler = null;
            this.x = null;
        }
        this.a(2, string2);
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
        Object[] objectArray;
        super.onCreate((Bundle)object);
        object = this.getIntent();
        this.u = object;
        if (object == null) {
            this.finish();
            return;
        }
        Object object2 = "start_flag";
        int n10 = -1;
        int n11 = object.getIntExtra(object2, n10);
        if (n11 != 0) {
            this.finish();
            return;
        }
        object = new FrameLayout((Context)this);
        this.v = object;
        object = this.getIntent();
        n11 = object.getIntExtra(object2 = "progress_id", n10);
        if (n11 != n10) {
            object2 = (LayoutInflater)this.getSystemService("layout_inflater");
            n10 = 0;
            objectArray = null;
            object = object2.inflate(n11, null);
        } else {
            object = new ProgressBar((Context)this);
        }
        n10 = -2;
        object2 = new FrameLayout.LayoutParams(n10, n10);
        ((FrameLayout.LayoutParams)object2).gravity = n10 = 17;
        objectArray = this.v;
        objectArray.addView((View)object, (ViewGroup.LayoutParams)object2);
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
        object = this.getIntent();
        object2 = "_weibo_message_stroy";
        if ((object = (StoryMessage)object.getParcelableExtra(object2)) == null) {
            this.c("StoryMessage is null.");
            return;
        }
        n12 = (int)(((StoryMessage)object).checkResource() ? 1 : 0);
        if (n12 != 0 && (n12 = (int)(a.b((Context)this) ? 1 : 0)) != 0) {
            object2 = this.A;
            n10 = 1;
            if (object2 != null) {
                object2.cancel(n10 != 0);
            }
            ShareStoryActivity$2 shareStoryActivity$2 = new ShareStoryActivity$2(this);
            object2 = new e((Context)this, shareStoryActivity$2);
            this.A = object2;
            objectArray = new StoryMessage[n10];
            objectArray[0] = object;
            object2.execute(objectArray);
            return;
        }
        this.c("StoryMessage's resource is error.");
    }

    public void onNewIntent(Intent intent) {
        int n10;
        super.onNewIntent(intent);
        Object object = this.x;
        if (object != null) {
            object.removeMessages(0);
            object = null;
            this.x = null;
        }
        if ((n10 = intent.getIntExtra((String)(object = "backType"), 0)) == 0) {
            this.a(1, "cancel");
            return;
        }
        this.a(0, "ok");
    }
}

