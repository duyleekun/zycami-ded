/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.LinearLayout
 */
package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.sina.weibo.g$1;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;

public class g
extends FakeActivity {
    private IWBAPI a;
    private String b;
    private String c;
    private String d;
    private AuthorizeListener e;

    public g(String string2, String string3, String string4, AuthorizeListener authorizeListener) {
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = authorizeListener;
    }

    public static /* synthetic */ AuthorizeListener a(g g10) {
        return g10.e;
    }

    private void a() {
        Object object = SSDKLog.b();
        Object object2 = "SinaWeiboWebAuthOfficial onCreate ";
        ((NLog)object).w((String)object2);
        object = this.a;
        if (object != null) {
            object2 = new g$1(this);
            object.authorizeWeb((WbAuthListener)object2);
        } else {
            object = this.e;
            if (object != null) {
                String string2 = "SinaWeibo SDK init failed";
                object2 = new Throwable(string2);
                object.onError((Throwable)object2);
            }
            this.finish();
        }
    }

    public void onCreate() {
        CharSequence charSequence;
        CharSequence charSequence2;
        super.onCreate();
        Object object = SSDKLog.b();
        Object object2 = "SinaWeiboWebAuthOfficial onCreate ";
        ((NLog)object).w((String)object2);
        int n10 = 1;
        Object object3 = this.activity;
        object2 = new LinearLayout((Context)object3);
        object2.setOrientation(n10);
        object3 = this.activity;
        try {
            object3.setContentView((View)object2);
        }
        catch (Exception exception) {
            SSDKLog.b().d(exception);
            object3 = SSDKLog.b();
            charSequence2 = new StringBuilder();
            charSequence = "SinaWeiboOfficialAuth onCreate exception ";
            charSequence2.append((String)charSequence);
            object2 = exception.getMessage();
            charSequence2.append((String)object2);
            object2 = charSequence2.toString();
            ((NLog)object3).w((String)object2);
        }
        object3 = this.activity;
        charSequence2 = this.b;
        charSequence = this.c;
        String string2 = this.d;
        object2 = new AuthInfo((Context)object3, (String)charSequence2, (String)charSequence, string2);
        object3 = this.activity;
        object3 = WBAPIFactory.createWBAPI((Context)object3);
        this.a = object3;
        charSequence2 = this.activity;
        try {
            object3.registerApp((Context)charSequence2, (AuthInfo)object2);
        }
        catch (Throwable throwable) {
            object3 = SSDKLog.b();
            object = new Object[n10];
            charSequence2 = null;
            charSequence = new StringBuilder();
            string2 = "onCreate AuthInfo ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(throwable);
            object[0] = object2 = ((StringBuilder)charSequence).toString();
            object2 = "SinaWeiboWebAuthOfficial";
            ((NLog)object3).d(object2, (Object[])object);
            object = this.e;
            if (object != null && object != null) {
                object3 = "SinaWeibo SDK init failed";
                object2 = new Throwable((String)object3);
                object.onError((Throwable)object2);
            }
            this.finish();
        }
        this.a();
        object = SSDKLog.b();
        object2 = "SinaWeiboWebAuthOfficial onCreate loginManager() ";
        try {
            ((NLog)object).w((String)object2);
        }
        catch (Throwable throwable) {
            object2 = this.e;
            if (object2 != null) {
                object3 = new StringBuilder();
                charSequence2 = "Authorize catch: ";
                ((StringBuilder)object3).append((String)charSequence2);
                ((StringBuilder)object3).append(throwable);
                object3 = ((StringBuilder)object3).toString();
                object2 = new Throwable((String)object3);
                object3 = this.e;
                object3.onError((Throwable)object2);
            }
            object2 = SSDKLog.b();
            object3 = new StringBuilder();
            charSequence2 = "SinaWeiboWebAuthOfficial onCreate catch: ";
            ((StringBuilder)object3).append((String)charSequence2);
            ((StringBuilder)object3).append(throwable);
            String string3 = ((StringBuilder)object3).toString();
            ((NLog)object2).w(string3);
            this.finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onDestroy");
    }

    public void onPause() {
        super.onPause();
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onPause");
    }

    public void onResume() {
        super.onResume();
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onResume");
    }

    public void onStop() {
        super.onStop();
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onStop");
    }
}

