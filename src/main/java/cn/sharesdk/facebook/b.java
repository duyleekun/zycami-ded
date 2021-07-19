/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.view.View
 *  android.widget.LinearLayout
 *  com.facebook.CallbackManager
 *  com.facebook.CallbackManager$Factory
 *  com.facebook.FacebookCallback
 *  com.facebook.login.LoginManager
 */
package cn.sharesdk.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import cn.sharesdk.facebook.b$1;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.login.LoginManager;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import java.util.Collections;

public class b
extends FakeActivity {
    private CallbackManager a;
    private PlatformActionListener b;
    private Platform c;

    public b(PlatformActionListener object, Platform object2) {
        Object object3 = CallbackManager.Factory.create();
        this.a = object3;
        this.b = object;
        this.c = object2;
        object = SSDKLog.b();
        object2 = "FacebookOfficialAuth constuction ";
        try {
            ((NLog)object).w((String)object2);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            String string2 = "FacebookOfficialAuth catch ";
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(throwable);
            String string3 = ((StringBuilder)object3).toString();
            object3 = new Object[]{};
            ((NLog)object2).d(string3, (Object[])object3);
        }
    }

    public static /* synthetic */ Platform a(b b10) {
        return b10.c;
    }

    public static /* synthetic */ PlatformActionListener b(b b10) {
        return b10.b;
    }

    public void a() {
        SSDKLog.b().w("FacebookOfficialAuth loginManager");
        LoginManager loginManager = LoginManager.getInstance();
        Activity activity = this.activity;
        Object object = Collections.singleton("email");
        loginManager.logIn(activity, object);
        loginManager = LoginManager.getInstance();
        activity = this.a;
        object = new b$1(this);
        loginManager.registerCallback((CallbackManager)activity, (FacebookCallback)object);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        this.a.onActivityResult(n10, n11, intent);
        super.onActivityResult(n10, n11, intent);
        SSDKLog.b().w("FacebookOfficialAuth onActivityResult");
    }

    public void onCreate() {
        Object object;
        NLog nLog = SSDKLog.b();
        Object object2 = "FacebookOfficialAuth onCreate ";
        nLog.w((String)object2);
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
            object = new StringBuilder();
            String string2 = "FacebookOfficialAuth onCreate exception ";
            ((StringBuilder)object).append(string2);
            object2 = exception.getMessage();
            ((StringBuilder)object).append((String)object2);
            object2 = ((StringBuilder)object).toString();
            ((NLog)object3).w((String)object2);
        }
        this.a();
        object2 = SSDKLog.b();
        object3 = "FacebookOfficialAuth onCreate loginManager() ";
        try {
            ((NLog)object2).w((String)object3);
        }
        catch (Throwable throwable) {
            object3 = this.b;
            if (object3 != null) {
                object = this.c;
                object3.onError((Platform)object, n10, throwable);
            }
            nLog = SSDKLog.b();
            object3 = new StringBuilder();
            object = "FacebookOfficialAuth onCreate catch: ";
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(throwable);
            String string3 = ((StringBuilder)object3).toString();
            nLog.w(string3);
            this.finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("FacebookOfficialAuth onDestroy");
    }

    public void onPause() {
        super.onPause();
        SSDKLog.b().w("FacebookOfficialAuth onPause");
    }

    public void onResume() {
        super.onResume();
        SSDKLog.b().w("FacebookOfficialAuth onResume");
    }

    public void onStop() {
        super.onStop();
        SSDKLog.b().w("FacebookOfficialAuth onStop");
    }
}

