/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.CookieManager
 *  android.webkit.CookieSyncManager
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.sina.weibo.h$1;
import cn.sharesdk.sina.weibo.h$2;
import cn.sharesdk.sina.weibo.h$3;
import cn.sharesdk.sina.weibo.sdk.a.a;
import com.mob.tools.FakeActivity;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscribable;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$Thread;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.sina.weibo.sdk.api.ImageObject;
import java.util.ArrayList;

public class h
extends FakeActivity
implements View.OnClickListener {
    private String a;
    private String b;
    private Platform$ShareParams c;
    private AuthorizeListener d;
    private a e;
    private LinearLayout f;
    private TextView g;
    private WebView h;
    private Button i;
    private int j;

    public static /* synthetic */ int a(h h10) {
        return h10.j;
    }

    public static /* synthetic */ int a(h h10, int n10) {
        h10.j = n10;
        return n10;
    }

    private void a() {
        TextView textView;
        this.g = textView = this.e.b();
        textView = this.e.c();
        this.h = textView;
        textView = this.e.d();
        this.f = textView;
        textView = this.e.a();
        this.i = textView;
        this.g.setOnClickListener((View.OnClickListener)this);
        textView = this.i;
        textView.setOnClickListener((View.OnClickListener)this);
        boolean bl2 = ShareSDK.isRemoveCookieOnAuthorize();
        if (bl2) {
            CookieSyncManager.createInstance((Context)this.activity);
            textView = CookieManager.getInstance();
            textView.removeAllCookie();
        }
        textView = this.h;
        h$1 h$1 = new h$1(this);
        textView.setWebViewClient((WebViewClient)h$1);
        this.b();
    }

    public static /* synthetic */ void a(h h10, String string2) {
        h10.a(string2);
    }

    private void a(String object) {
        object = ResHelper.urlToBundle((String)object);
        Object object2 = object.getString("code");
        String string2 = object.getString("msg");
        Object object3 = this.d;
        if (object3 != null) {
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                object = this.d;
                object.onCancel();
            } else {
                object3 = "0";
                boolean bl3 = ((String)object3).equals(object2);
                if (bl3) {
                    object2 = this.d;
                    object2.onComplete((Bundle)object);
                } else {
                    object = this.d;
                    object2 = new Throwable(string2);
                    object.onError((Throwable)object2);
                }
            }
        }
        this.finish();
    }

    public static /* synthetic */ LinearLayout b(h h10) {
        return h10.f;
    }

    private String b() {
        Object object = new h$2(this);
        object = RxMob.create((RxMob$OnSubscribe)object);
        Object object2 = RxMob$Thread.NEW_THREAD;
        ((RxMob$Subscribable)object).subscribeOn((RxMob$Thread)((Object)object2));
        object2 = RxMob$Thread.UI_THREAD;
        ((RxMob$Subscribable)object).observeOn((RxMob$Thread)((Object)object2));
        object2 = new h$3(this);
        ((RxMob$Subscribable)object).subscribe((RxMob$Subscriber)object2);
        return null;
    }

    public static /* synthetic */ String b(h h10, String string2) {
        return h10.b(string2);
    }

    private String b(String object) {
        Object object2 = new ArrayList();
        String string2 = this.c.getText();
        Object object3 = new KVPair("title", string2);
        ((ArrayList)object2).add(object3);
        string2 = this.a;
        object3 = new KVPair("source", string2);
        ((ArrayList)object2).add(object3);
        string2 = this.b;
        object3 = new KVPair("access_token", string2);
        ((ArrayList)object2).add(object3);
        string2 = this.activity.getPackageName();
        object3 = new KVPair("packagename", string2);
        ((ArrayList)object2).add(object3);
        object3 = new KVPair("picinfo", object);
        ((ArrayList)object2).add(object3);
        object = new KVPair("luicode", "10000360");
        ((ArrayList)object2).add(object);
        object3 = this.getContext();
        string2 = this.activity.getPackageName();
        object3 = cn.sharesdk.sina.weibo.sdk.a.a((Context)object3, string2);
        object = new KVPair("key_hash", object3);
        ((ArrayList)object2).add(object);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("OP_");
        string2 = this.a;
        ((StringBuilder)object3).append(string2);
        object3 = ((StringBuilder)object3).toString();
        object = new KVPair("lfid", object3);
        ((ArrayList)object2).add(object);
        object = new KVPair("version", "0041005000");
        ((ArrayList)object2).add(object);
        object = new StringBuilder();
        ((StringBuilder)object).append("http://service.weibo.com/share/mobilesdk.php?");
        object2 = ResHelper.encodeUrl(object2);
        ((StringBuilder)object).append((String)object2);
        return ((StringBuilder)object).toString();
    }

    public static /* synthetic */ WebView c(h h10) {
        return h10.h;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private String c() {
        block64: {
            block63: {
                block62: {
                    block61: {
                        block60: {
                            block59: {
                                block58: {
                                    block57: {
                                        var1_1 /* !! */  = "data";
                                        var2_3 /* !! */  = "code";
                                        try {
                                            var3_4 = this.c;
                                        }
                                        catch (Throwable var1_2) {
                                            SSDKLog.b().d(var1_2);
                                            return null;
                                        }
                                        var3_4 = var3_4.getImageData();
                                        if (var3_4 != null) break block57;
                                        var4_5 = this.c;
                                        var4_5 = var4_5.getImagePath();
                                        var5_6 = TextUtils.isEmpty((CharSequence)var4_5);
                                        if (var5_6) break block57;
                                        var3_4 = this.c;
                                        var3_4 = var3_4.getImagePath();
                                        var3_4 = BitmapHelper.getBitmap((String)var3_4);
                                        break block58;
                                    }
                                    if (var3_4 == null) {
                                        var4_5 = this.c;
                                        var4_5 = var4_5.getImageUrl();
                                        var5_6 = TextUtils.isEmpty((CharSequence)var4_5);
                                        if (var5_6) break block58;
                                        var3_4 = this.getContext();
                                        var4_5 = this.c;
                                        var4_5 = var4_5.getImageUrl();
                                        var3_4 = BitmapHelper.getBitmap((Context)var3_4, (String)var4_5);
                                    }
                                }
                                if (var3_4 != null) {
                                    var4_5 = new ImageObject();
                                    var4_5.setImageData((Bitmap)var3_4);
                                    var3_4 = var4_5.imageData;
                                    if (var3_4 == null) break block59;
                                    var6_7 = ((Object)var3_4).length;
                                    if (var6_7 <= 0) break block59;
                                    var4_5 = var4_5.imageData;
                                    var4_5 = cn.sharesdk.sina.weibo.sdk.a.a((byte[])var4_5);
                                    var3_4 = new String((byte[])var4_5);
                                    break block60;
                                }
                            }
                            var6_7 = 0;
                            var3_4 = null;
                        }
                        var5_6 = TextUtils.isEmpty((CharSequence)var3_4);
                        if (!var5_6) break block61;
                        return null;
                    }
                    var7_8 = new NetworkHelper();
                    var8_9 = new ArrayList<Object>();
                    var9_10 = "img";
                    var4_5 = new KVPair(var9_10, var3_4);
                    var8_9.add(var4_5);
                    var10_11 = System.currentTimeMillis();
                    var12_12 = 1000L;
                    var10_11 /= var12_12;
                    var3_4 = String.valueOf(var10_11);
                    var9_10 = "oauth_timestamp";
                    var4_5 = new KVPair(var9_10, var3_4);
                    var8_9.add(var4_5);
                    var3_4 = new StringBuilder();
                    var4_5 = this.b;
                    var5_6 = TextUtils.isEmpty((CharSequence)var4_5);
                    if (var5_6) ** GOTO lbl103
                    var4_5 = this.b;
                    var3_4.append((String)var4_5);
lbl103:
                    // 2 sources

                    var4_5 = this.a;
                    var5_6 = TextUtils.isEmpty((CharSequence)var4_5);
                    if (var5_6) break block62;
                    var4_5 = this.a;
                    var3_4.append((String)var4_5);
                }
                var9_10 = "http://service.weibo.com/share/mobilesdk_uppic.php";
                var3_4 = var7_8.httpPost(var9_10, var8_9, null, null, null);
                var5_6 = TextUtils.isEmpty((CharSequence)var3_4);
                if (!var5_6) break block63;
                return null;
            }
            var4_5 = new Hashon();
            var3_4 = var4_5.fromJson((String)var3_4);
            if (var3_4 == null) break block64;
            var5_6 = var3_4.containsKey(var2_3 /* !! */ );
            if (!var5_6) break block64;
            var5_6 = var3_4.containsKey(var1_1 /* !! */ );
            if (!var5_6) break block64;
            var2_3 /* !! */  = var3_4.get(var2_3 /* !! */ );
            var2_3 /* !! */  = String.valueOf(var2_3 /* !! */ );
            var1_1 /* !! */  = var3_4.get(var1_1 /* !! */ );
            var1_1 /* !! */  = String.valueOf(var1_1 /* !! */ );
            var3_4 = "1";
            var14_13 = var3_4.equals(var2_3 /* !! */ );
            if (!var14_13) break block64;
            var14_13 = TextUtils.isEmpty((CharSequence)var1_1 /* !! */ );
            if (var14_13) break block64;
            return var1_1 /* !! */ ;
        }
        return null;
    }

    public static /* synthetic */ AuthorizeListener d(h h10) {
        return h10.d;
    }

    public static /* synthetic */ String e(h h10) {
        return h10.c();
    }

    public void a(Platform$ShareParams platform$ShareParams) {
        this.c = platform$ShareParams;
    }

    public void a(AuthorizeListener authorizeListener) {
        this.d = authorizeListener;
    }

    public void a(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public void onClick(View object) {
        TextView textView = this.g;
        if (object == textView) {
            object = this.d;
            if (object != null) {
                object.onCancel();
            }
            this.finish();
        } else {
            textView = this.i;
            if (object == textView) {
                this.f.setVisibility(8);
                object = this.h;
                textView = null;
                object.setVisibility(0);
                this.b();
            }
        }
    }

    public void onCreate() {
        a a10;
        Context context = this.getContext();
        this.e = a10 = new a(context);
        int n10 = ResHelper.getStringRes(this.getContext(), "ssdk_sina_web_title");
        context = this.activity;
        a10 = this.e.a(n10);
        context.setContentView((View)a10);
        this.a();
    }

    public void onDestroy() {
        WebView webView = this.h;
        if (webView != null) {
            webView.setFocusable(false);
        }
    }

    public boolean onFinish() {
        AuthorizeListener authorizeListener = this.d;
        if (authorizeListener != null) {
            authorizeListener = null;
            this.d = null;
        }
        return super.onFinish();
    }

    public boolean onKeyEvent(int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11 && (n10 = keyEvent.getAction()) == 0) {
            AuthorizeListener authorizeListener = this.d;
            if (authorizeListener != null) {
                authorizeListener.onCancel();
            }
            this.finish();
            return true;
        }
        return false;
    }
}

