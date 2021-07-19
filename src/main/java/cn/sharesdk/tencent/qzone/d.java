/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 */
package cn.sharesdk.tencent.qzone;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qzone.QZoneWebShareAdapter;
import cn.sharesdk.tencent.qzone.ReceiveActivity;
import cn.sharesdk.tencent.qzone.d$1;
import cn.sharesdk.tencent.qzone.d$2;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;
import java.util.HashMap;

public class d
extends FakeActivity {
    private String a;
    private boolean b;
    private PlatformActionListener c;
    private RegisterView d;
    private WebView e;
    private String f;
    private boolean g;
    private boolean h;
    private QZoneWebShareAdapter i;

    public static /* synthetic */ PlatformActionListener a(d d10) {
        return d10.c;
    }

    public static /* synthetic */ void a(d d10, String string2) {
        d10.b(string2);
    }

    private QZoneWebShareAdapter b() {
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
            object2 = "QZoneWebShareAdapter";
            object = object.getString((String)object2);
            if (object == null) break block13;
            int n11 = object.length();
            if (n11 <= 0) break block13;
            object = Class.forName((String)object);
            object = object.newInstance();
            n11 = object instanceof QZoneWebShareAdapter;
            if (n11 == 0) {
                return null;
            }
            return (QZoneWebShareAdapter)object;
        }
        return null;
    }

    public static /* synthetic */ String b(d d10) {
        return d10.f;
    }

    public static /* synthetic */ void b(d d10, String string2) {
        d10.c(string2);
    }

    private void b(String object) {
        boolean bl2;
        Object object2 = object == null ? "" : new String((String)object);
        object = ResHelper.urlToBundle((String)object);
        boolean bl3 = true;
        if (object == null) {
            this.h = bl3;
            this.finish();
            object = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to parse callback uri: ");
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            Throwable throwable = new Throwable((String)object2);
            object.onError(null, 0, throwable);
            return;
        }
        String string2 = "share";
        CharSequence charSequence = object.getString("action");
        boolean bl4 = string2.equals(charSequence);
        if (!bl4 && !(bl2 = (string2 = "shareToQzone").equals(charSequence))) {
            this.h = bl3;
            this.finish();
            object = this.c;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("action error: ");
            ((StringBuilder)charSequence).append((String)object2);
            object2 = ((StringBuilder)charSequence).toString();
            Throwable throwable = new Throwable((String)object2);
            object.onError(null, 0, throwable);
            return;
        }
        string2 = "cancel";
        charSequence = object.getString("result");
        bl4 = string2.equals(charSequence);
        if (bl4) {
            this.finish();
            this.c.onCancel(null, 0);
            return;
        }
        string2 = "complete";
        bl2 = string2.equals(charSequence);
        if (!bl2) {
            this.h = bl3;
            this.finish();
            object = this.c;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("operation failed: ");
            ((StringBuilder)charSequence).append((String)object2);
            object2 = ((StringBuilder)charSequence).toString();
            Throwable throwable = new Throwable((String)object2);
            object.onError(null, 0, throwable);
            return;
        }
        charSequence = "response";
        bl2 = TextUtils.isEmpty((CharSequence)(object = object.getString((String)charSequence)));
        if (bl2) {
            this.h = bl3;
            this.finish();
            object = this.c;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("response empty");
            ((StringBuilder)charSequence).append((String)object2);
            object2 = ((StringBuilder)charSequence).toString();
            Throwable throwable = new Throwable((String)object2);
            object.onError(null, 0, throwable);
            return;
        }
        this.g = bl3;
        this.finish();
        object2 = this.c;
        Hashon hashon = new Hashon();
        object = hashon.fromJson((String)object);
        object2.onComplete(null, 0, (HashMap)object);
    }

    private void c() {
        block9: {
            Object object = "android.intent.action.VIEW";
            Intent intent = new Intent((String)object);
            object = this.a;
            object = Uri.parse((String)object);
            intent.setData((Uri)object);
            object = "pkg_name";
            Object object2 = this.activity;
            object2 = object2.getPackageName();
            intent.putExtra((String)object, (String)object2);
            object = this.activity;
            int n10 = 100;
            try {
                object.startActivityForResult(intent, n10);
            }
            catch (Throwable throwable) {
                object = this.c;
                if (object == null) break block9;
                n10 = 0;
                object2 = null;
                object.onError(null, 0, throwable);
            }
        }
    }

    private void c(String object) {
        int n10;
        Object object2 = "android.intent.action.VIEW";
        Object object3 = new Intent((String)object2);
        object = Uri.parse((String)object);
        object3.setData((Uri)object);
        object = this.activity;
        object = object.getPackageManager();
        int n11 = 1;
        try {
            object = object.queryIntentActivities((Intent)object3, n11);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
            n10 = 0;
            object = null;
        }
        if (object != null && (n10 = object.size()) > 0) {
            try {
                this.startActivity((Intent)object3);
            }
            catch (Throwable throwable) {
                object3 = SSDKLog.b();
                ((NLog)object3).d(throwable);
            }
        }
    }

    private void d() {
        int n10;
        Object object;
        Object object2;
        block8: {
            object2 = this.a();
            this.d = object2;
            object2 = this.getContext();
            object = "ssdk_share_to_qzone";
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
        object2 = this.i;
        object = this.d.d();
        ((QZoneWebShareAdapter)object2).setBodyView((RelativeLayout)object);
        object2 = this.i;
        object = this.d.b();
        ((QZoneWebShareAdapter)object2).setWebView((WebView)object);
        object2 = this.i;
        object = this.d.c();
        ((QZoneWebShareAdapter)object2).setTitleView((TitleLayout)((Object)object));
        this.i.onCreate();
        object2 = this.activity;
        object = this.d;
        object2.setContentView((View)object);
        object2 = DeviceHelper.getInstance((Context)this.activity).getDetailNetworkTypeForStatic();
        object = "none";
        n10 = (int)(((String)object).equals(object2) ? 1 : 0);
        if (n10 != 0) {
            this.h = true;
            this.finish();
            object2 = this.c;
            Throwable throwable = new Throwable("failed to load webpage, network disconnected.");
            object2.onError(null, 0, throwable);
            return;
        }
        object2 = this.d.b();
        object = this.a;
        object2.loadUrl((String)object);
    }

    public RegisterView a() {
        Activity activity = this.activity;
        RegisterView registerView = new RegisterView((Context)activity);
        int n10 = registerView.c().getChildCount();
        Object object = registerView.c();
        int n11 = 1;
        object.getChildAt(n10 -= n11).setVisibility(8);
        activity = registerView.a();
        object = new d$1(this);
        activity.setOnClickListener((View.OnClickListener)object);
        activity = registerView.b();
        this.e = activity;
        activity = activity.getSettings();
        activity.setBuiltInZoomControls(n11 != 0);
        activity.setJavaScriptEnabled(n11 != 0);
        activity.setCacheMode(n11);
        activity.setDomStorageEnabled(n11 != 0);
        activity.setDatabaseEnabled(n11 != 0);
        object = this.activity.getDir("database", 0).getPath();
        activity.setDatabasePath((String)object);
        activity.setSavePassword(false);
        this.e.setVerticalScrollBarEnabled(false);
        this.e.setHorizontalScrollBarEnabled(false);
        activity = this.e;
        object = new d$2(this);
        activity.setWebViewClient((WebViewClient)object);
        return registerView;
    }

    public void a(PlatformActionListener platformActionListener) {
        this.c = platformActionListener;
    }

    public void a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tencent");
        stringBuilder.append(string2);
        this.f = string2 = stringBuilder.toString();
    }

    public void a(String string2, boolean bl2) {
        this.a = string2;
        this.b = bl2;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        int n12 = 100;
        if (n10 == n12 && n11 == 0) {
            PlatformActionListener platformActionListener = this.c;
            n11 = 0;
            n12 = 9;
            platformActionListener.onCancel(null, n12);
        }
        this.finish();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreate() {
        Object object = "cn.sharesdk.tencent.qq.ReceiveActivity";
        try {
            object = Class.forName((String)object);
            Object[] objectArray = "setUriScheme";
            int n10 = 1;
            Object[] objectArray2 = new Class[n10];
            Class<PlatformActionListener> clazz = String.class;
            objectArray2[0] = clazz;
            objectArray = ((Class)object).getMethod((String)objectArray, (Class<?>[])objectArray2);
            objectArray2 = new Object[n10];
            clazz = this.f;
            objectArray2[0] = clazz;
            objectArray.invoke(null, objectArray2);
            objectArray = "setPlatformActionListener";
            objectArray2 = new Class[n10];
            objectArray2[0] = clazz = PlatformActionListener.class;
            object = ((Class)object).getMethod((String)objectArray, (Class<?>[])objectArray2);
            objectArray = new Object[n10];
            PlatformActionListener platformActionListener = this.c;
            objectArray[0] = platformActionListener;
            ((Method)object).invoke(null, objectArray);
            boolean bl2 = this.b;
            if (bl2) {
                this.c();
                return;
            }
            this.d();
            return;
        }
        catch (Throwable throwable) {
            try {
                object = this.f;
                ReceiveActivity.a((String)object);
                object = this.c;
                ReceiveActivity.a((PlatformActionListener)object);
                boolean bl3 = this.b;
                if (bl3) {
                    this.c();
                    return;
                }
                this.d();
                return;
            }
            catch (Throwable throwable2) {
                this.activity.finish();
                PlatformActionListener platformActionListener = this.c;
                if (platformActionListener == null) return;
                int n11 = 9;
                platformActionListener.onError(null, n11, throwable2);
            }
        }
    }

    public void onDestroy() {
        Object object;
        boolean bl2 = this.b;
        if (!(bl2 || (bl2 = this.h) || (bl2 = this.g))) {
            object = this.c;
            object.onCancel(null, 0);
        }
        if ((object = this.e) != null) {
            object.setFocusable(false);
        }
        if ((object = this.i) != null) {
            ((QZoneWebShareAdapter)object).onDestroy();
        }
    }

    public boolean onFinish() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.i;
        if (qZoneWebShareAdapter != null) {
            return qZoneWebShareAdapter.onFinish();
        }
        return super.onFinish();
    }

    public void onPause() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onPause();
        }
    }

    public void onRestart() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onRestart();
        }
    }

    public void onResume() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onResume();
        }
    }

    public void onStart() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onStart();
        }
    }

    public void onStop() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onStop();
        }
    }

    public void setActivity(Activity activity) {
        super.setActivity(activity);
        QZoneWebShareAdapter qZoneWebShareAdapter = this.i;
        if (qZoneWebShareAdapter == null) {
            this.i = qZoneWebShareAdapter = this.b();
            if (qZoneWebShareAdapter == null) {
                this.i = qZoneWebShareAdapter = new QZoneWebShareAdapter();
            }
        }
        this.i.setActivity(activity);
    }
}

