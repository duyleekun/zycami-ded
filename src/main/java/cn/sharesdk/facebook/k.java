/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 */
package cn.sharesdk.facebook;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import cn.sharesdk.facebook.a;
import cn.sharesdk.facebook.k$1;
import cn.sharesdk.facebook.k$2;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

public class k
extends FakeActivity {
    private String a;
    private PlatformActionListener b;
    private a c;
    private RegisterView d;
    private WebView e;
    private boolean f;
    private boolean g;

    public static /* synthetic */ PlatformActionListener a(k k10) {
        return k10.b;
    }

    public static /* synthetic */ void a(k k10, String string2) {
        k10.b(string2);
    }

    private a b() {
        block13: {
            Object object;
            try {
                object = this.activity;
            }
            catch (Throwable throwable) {
                SSDKLog.b().d(throwable);
                return null;
            }
            object = object.getPackageManager();
            Object object2 = this.activity;
            object2 = object2.getComponentName();
            int n10 = 128;
            object = object.getActivityInfo((ComponentName)object2, n10);
            object = object.metaData;
            object2 = "FBWebShareAdapter";
            object = object.getString((String)object2);
            if (object == null) break block13;
            int n11 = object.length();
            if (n11 <= 0) break block13;
            object = Class.forName((String)object);
            object = object.newInstance();
            n11 = object instanceof a;
            if (n11 == 0) {
                return null;
            }
            return (a)object;
        }
        return null;
    }

    private void b(String object) {
        int n10;
        Object object2 = object == null ? "" : new String((String)object);
        object = ResHelper.urlToBundle((String)object);
        Object object3 = null;
        boolean bl2 = true;
        if (object == null) {
            this.f = bl2;
            this.finish();
            object = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to parse callback uri: ");
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            Throwable throwable = new Throwable((String)object2);
            object.onError(null, 0, throwable);
            return;
        }
        object2 = "post_id";
        String string2 = object.getString((String)object2);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            hashMap.put((String)object2, string2);
        }
        if ((n10 = object.containsKey((String)(object2 = "error_code"))) == 0 && (n10 = object.containsKey(string2 = "error")) == 0) {
            this.g = bl2;
            this.finish();
            this.b.onComplete(null, 0, hashMap);
            return;
        }
        object3 = this.b;
        if (object3 != null) {
            object3 = object.getString((String)object2);
            boolean bl4 = object.containsKey((String)object2);
            n10 = 9;
            if (bl4 && (bl4 = ((String)object3).equals(object2 = "4201"))) {
                object = this.b;
                object.onCancel(null, n10);
            } else {
                object = ResHelper.encodeUrl((Bundle)object);
                object2 = this.b;
                object3 = new Throwable((String)object);
                object2.onError(null, n10, (Throwable)object3);
            }
        }
        this.f = bl2;
        this.finish();
    }

    public RegisterView a() {
        Activity activity = this.activity;
        RegisterView registerView = new RegisterView((Context)activity);
        int n10 = registerView.c().getChildCount();
        Object object = registerView.c();
        int n11 = 1;
        object.getChildAt(n10 -= n11).setVisibility(8);
        activity = registerView.a();
        object = new k$1(this);
        activity.setOnClickListener((View.OnClickListener)object);
        activity = registerView.b();
        this.e = activity;
        activity = activity.getSettings();
        activity.setBuiltInZoomControls(n11 != 0);
        activity.setJavaScriptEnabled(n11 != 0);
        activity.setCacheMode(n11);
        activity.setDomStorageEnabled(n11 != 0);
        activity.setDatabaseEnabled(n11 != 0);
        activity.setSavePassword(false);
        String string2 = this.activity.getDir("database", 0).getPath();
        activity.setDatabasePath(string2);
        this.e.setVerticalScrollBarEnabled(false);
        this.e.setHorizontalScrollBarEnabled(false);
        activity = this.e;
        object = new k$2(this);
        activity.setWebViewClient((WebViewClient)object);
        return registerView;
    }

    public void a(PlatformActionListener platformActionListener) {
        this.b = platformActionListener;
    }

    public void a(String string2) {
        this.a = string2;
    }

    public void onCreate() {
        int n10;
        Object object;
        Object object2;
        block8: {
            object2 = this.a();
            this.d = object2;
            object2 = this.getContext();
            object = "ssdk_share_to_facebook";
            n10 = ResHelper.getStringRes((Context)object2, (String)object);
            if (n10 <= 0) break block8;
            object = this.d;
            object = ((RegisterView)((Object)object)).c();
            object = ((TitleLayout)((Object)object)).getTvTitle();
            try {
                object.setText(n10);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                ((NLog)object).d(throwable);
                object2 = this.d.c();
                int n11 = 8;
                object2.setVisibility(n11);
            }
        }
        object2 = this.c;
        object = this.d.d();
        ((a)object2).a((RelativeLayout)object);
        object2 = this.c;
        object = this.d.b();
        ((a)object2).a((WebView)object);
        object2 = this.c;
        object = this.d.c();
        ((a)object2).a((TitleLayout)((Object)object));
        this.c.a();
        this.disableScreenCapture();
        object2 = this.activity;
        object = this.d;
        object2.setContentView((View)object);
        object2 = DeviceHelper.getInstance((Context)this.activity).getDetailNetworkTypeForStatic();
        object = "none";
        n10 = (int)(((String)object).equals(object2) ? 1 : 0);
        if (n10 != 0) {
            this.f = true;
            this.finish();
            object2 = this.b;
            Throwable throwable = new Throwable("failed to load webpage, network disconnected.");
            object2.onError(null, 0, throwable);
            return;
        }
        object2 = this.d.b();
        object = this.a;
        object2.loadUrl((String)object);
    }

    public void onDestroy() {
        Object object;
        boolean bl2 = this.f;
        if (!bl2 && !(bl2 = this.g)) {
            object = this.b;
            object.onCancel(null, 0);
        }
        if ((object = this.e) != null) {
            object.setFocusable(false);
        }
        if ((object = this.c) != null) {
            ((a)object).b();
        }
    }

    public boolean onFinish() {
        a a10 = this.c;
        if (a10 != null) {
            return a10.h();
        }
        return super.onFinish();
    }

    public void onPause() {
        a a10 = this.c;
        if (a10 != null) {
            a10.d();
        }
    }

    public void onRestart() {
        a a10 = this.c;
        if (a10 != null) {
            a10.g();
        }
    }

    public void onResume() {
        a a10 = this.c;
        if (a10 != null) {
            a10.e();
        }
    }

    public void onStart() {
        a a10 = this.c;
        if (a10 != null) {
            a10.c();
        }
    }

    public void onStop() {
        a a10 = this.c;
        if (a10 != null) {
            a10.f();
        }
    }

    public void setActivity(Activity activity) {
        super.setActivity(activity);
        a a10 = this.c;
        if (a10 == null) {
            this.c = a10 = this.b();
            if (a10 == null) {
                this.c = a10 = new a();
            }
        }
        this.c.a(activity);
    }
}

