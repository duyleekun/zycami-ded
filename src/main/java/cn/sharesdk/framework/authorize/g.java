/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Interpolator
 *  android.view.animation.ScaleAnimation
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 */
package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.AuthorizeAdapter;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.authorize.ResizeLayout$OnResizeListener;
import cn.sharesdk.framework.authorize.a;
import cn.sharesdk.framework.authorize.g$1;
import cn.sharesdk.framework.authorize.g$2;
import cn.sharesdk.framework.authorize.g$a;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;

public class g
extends a
implements Handler.Callback,
ResizeLayout$OnResizeListener {
    public AuthorizeListener b;
    private AuthorizeAdapter c;
    private RegisterView d;
    private WebView e;

    public static /* synthetic */ Activity a(g g10) {
        return g10.activity;
    }

    public static /* synthetic */ Activity b(g g10) {
        return g10.activity;
    }

    private AuthorizeAdapter c() {
        block18: {
            boolean bl2;
            Object object;
            Object object2;
            block20: {
                block19: {
                    try {
                        object2 = this.activity;
                    }
                    catch (Throwable throwable) {
                        SSDKLog.b().w(throwable);
                        return null;
                    }
                    object2 = object2.getPackageManager();
                    object = this.activity;
                    object = object.getComponentName();
                    int n10 = 128;
                    object2 = object2.getActivityInfo((ComponentName)object, n10);
                    object = object2.metaData;
                    if (object == null) break block18;
                    bl2 = object.isEmpty();
                    if (bl2) break block18;
                    object = object2.metaData;
                    String string2 = "AuthorizeAdapter";
                    object = object.getString(string2);
                    if (object == null) break block19;
                    n10 = ((String)object).length();
                    if (n10 > 0) break block20;
                }
                object2 = object2.metaData;
                object = "Adapter";
                object = object2.getString((String)object);
                if (object == null) break block18;
                int n11 = ((String)object).length();
                if (n11 <= 0) break block18;
            }
            object2 = Class.forName((String)object);
            object2 = object2.newInstance();
            bl2 = object2 instanceof AuthorizeAdapter;
            if (!bl2) {
                return null;
            }
            return (AuthorizeAdapter)object2;
        }
        return null;
    }

    public void OnResize(int n10, int n11, int n12, int n13) {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onResize(n10, n11, n12, n13);
        }
    }

    public void a(AuthorizeListener authorizeListener) {
        this.b = authorizeListener;
    }

    public RegisterView b() {
        CharSequence charSequence;
        Object object = this.activity;
        RegisterView registerView = new RegisterView((Context)object);
        object = registerView.a();
        Object object2 = new g$1(this);
        object.setOnClickListener((View.OnClickListener)object2);
        object = registerView.b();
        this.e = object;
        object = object.getSettings();
        boolean bl2 = true;
        object.setBuiltInZoomControls(bl2);
        object.setJavaScriptEnabled(bl2);
        object.setDomStorageEnabled(bl2);
        object.setAllowFileAccessFromFileURLs(bl2);
        bl2 = false;
        object2 = null;
        object.setSavePassword(false);
        this.e.setVerticalScrollBarEnabled(false);
        this.e.setHorizontalScrollBarEnabled(false);
        object = this.a.getAuthorizeWebviewClient(this);
        object2 = object != null ? object.getClass().getSimpleName() : "";
        boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl3 && (bl3 = ((String)object2).equals(charSequence = "GooglePlusAuthorizeWebviewClient")) || !(bl3 = TextUtils.isEmpty((CharSequence)object2)) && (bl3 = ((String)object2).contains(charSequence = "GooglePlus")) || (bl2 = ((String)object2).equals(charSequence = "YoutubeAuthorizeWebviewClient"))) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Mozilla/5.0 (Linux; Android 5.1; m2 note Build/LMY47D) ");
            ((StringBuilder)object2).append("AppleWebKit/537.36 (KHTML, like Gecko) ");
            object2 = ((StringBuilder)object2).toString();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append("Version/4.0 ");
            object2 = ((StringBuilder)charSequence).toString();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append("Chrome/40.0.2214.127 ");
            object2 = ((StringBuilder)charSequence).toString();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append("Mobile Safari/537.36");
            object2 = ((StringBuilder)charSequence).toString();
            charSequence = this.e.getSettings();
            charSequence.setUserAgentString((String)object2);
        }
        this.e.setWebViewClient((WebViewClient)object);
        object = new g$2(this);
        ((Thread)object).start();
        return registerView;
    }

    public boolean handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 2;
        if (n10 == n11) {
            n10 = ((Message)object).arg1;
            n11 = 1;
            String string2 = ")";
            if (n10 == n11) {
                object = this.a.getAuthorizeListener();
                if (object != null) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Network error (platform: ");
                    Object object2 = this.a.getPlatform().getName();
                    charSequence.append((String)object2);
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    object2 = new Throwable((String)charSequence);
                    object.onError((Throwable)object2);
                }
            } else {
                object = (String)((Message)object).obj;
                n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n10 != 0) {
                    this.finish();
                    object = this.a.getAuthorizeListener();
                    if (object != null) {
                        CharSequence charSequence = new StringBuilder();
                        charSequence.append("Authorize URL is empty (platform: ");
                        Object object3 = this.a.getPlatform().getName();
                        charSequence.append((String)object3);
                        charSequence.append(string2);
                        charSequence = charSequence.toString();
                        object3 = new Throwable((String)charSequence);
                        object.onError((Throwable)object3);
                    }
                } else {
                    WebView webView = this.e;
                    webView.loadUrl((String)object);
                }
            }
        }
        return false;
    }

    public void onCreate() {
        boolean bl2;
        int n10;
        String string2;
        AuthorizeAdapter authorizeAdapter;
        Object object;
        Object object2 = this.d;
        if (object2 == null) {
            object2 = this.b();
            this.d = object2;
            object2.a(this);
            object2 = this.d;
            int n11 = this.c.isNotitle();
            object2.a(n11 != 0);
            object2 = this.c;
            object = this.d.d();
            ((AuthorizeAdapter)object2).setBodyView((RelativeLayout)object);
            object2 = this.c;
            object = this.d.b();
            ((AuthorizeAdapter)object2).setWebView((WebView)object);
            object2 = this.d.c();
            this.c.setTitleView((TitleLayout)((Object)object2));
            object = this.a.getPlatform().getName();
            authorizeAdapter = this.c;
            CharSequence charSequence = this.a.getPlatform().getName();
            authorizeAdapter.setPlatformName((String)charSequence);
            authorizeAdapter = this.getContext();
            charSequence = new StringBuilder();
            string2 = "ssdk_";
            ((StringBuilder)charSequence).append(string2);
            object = ((String)object).toLowerCase();
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            n11 = ResHelper.getStringRes((Context)authorizeAdapter, (String)object);
            authorizeAdapter = ((TitleLayout)((Object)object2)).getTvTitle();
            try {
                authorizeAdapter.setText(n11);
            }
            catch (Throwable throwable) {
                authorizeAdapter = this.getContext();
                charSequence = "ssdk_weibo_oauth_regiseter";
                n10 = ResHelper.getStringRes((Context)authorizeAdapter, (String)charSequence);
                object2 = ((TitleLayout)((Object)object2)).getTvTitle();
                try {
                    object2.setText(n10);
                }
                catch (Throwable throwable2) {
                    object2 = SSDKLog.b();
                    ((NLog)object2).w(throwable);
                }
            }
        }
        this.c.onCreate();
        object2 = this.c;
        if (object2 != null && !(bl2 = ((AuthorizeAdapter)object2).isPopUpAnimationDisable())) {
            float f10 = 1.0f;
            string2 = null;
            float f11 = 1.0f;
            int n12 = 1;
            float f12 = 0.5f;
            int n13 = 1;
            float f13 = 0.5f;
            object = object2;
            object2 = new ScaleAnimation(0.0f, f10, 0.0f, f11, n12, f12, n13, f13);
            long l10 = 550L;
            object2.setDuration(l10);
            n10 = 0;
            authorizeAdapter = null;
            object = new g$a(null);
            object2.setInterpolator((Interpolator)object);
            object = this.d;
            object.setAnimation((Animation)object2);
        }
        this.disableScreenCapture();
        object2 = this.activity;
        object = this.d;
        object2.setContentView((View)object);
    }

    public void onDestroy() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onDestroy();
        }
        if ((authorizeAdapter = this.e) != null) {
            authorizeAdapter.setFocusable(false);
        }
    }

    public boolean onFinish() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            return authorizeAdapter.onFinish();
        }
        authorizeAdapter = this.e;
        if (authorizeAdapter != null) {
            authorizeAdapter.destroy();
            authorizeAdapter = this.e;
            authorizeAdapter.removeAllViews();
        }
        if ((authorizeAdapter = this.activity) != null) {
            authorizeAdapter = (ViewGroup)authorizeAdapter.getWindow().getDecorView();
            authorizeAdapter.removeAllViews();
        }
        return super.onFinish();
    }

    public boolean onKeyEvent(int n10, KeyEvent keyEvent) {
        AuthorizeListener authorizeListener;
        int n11;
        boolean bl2;
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            bl2 = authorizeAdapter.onKeyEvent(n10, keyEvent);
        } else {
            bl2 = false;
            authorizeAdapter = null;
        }
        if (!bl2 && n10 == (n11 = 4) && (n11 = keyEvent.getAction()) == 0 && (authorizeListener = this.a.getAuthorizeListener()) != null) {
            authorizeListener.onCancel();
        }
        n10 = bl2 ? 1 : (int)(super.onKeyEvent(n10, keyEvent) ? 1 : 0);
        return n10 != 0;
    }

    public void onPause() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onPause();
        }
    }

    public void onRestart() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onRestart();
        }
    }

    public void onResume() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onResume();
        }
    }

    public void onStart() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onStart();
        }
    }

    public void onStop() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onStop();
        }
    }

    public void setActivity(Activity activity) {
        super.setActivity(activity);
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter == null) {
            this.c = authorizeAdapter = this.c();
            if (authorizeAdapter == null) {
                this.c = authorizeAdapter = new AuthorizeAdapter();
            }
        }
        this.c.setActivity(activity);
    }
}

