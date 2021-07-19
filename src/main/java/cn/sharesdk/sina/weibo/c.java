/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.webkit.WebView
 */
package cn.sharesdk.sina.weibo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.sina.weibo.c$1;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;

public class c
extends cn.sharesdk.framework.authorize.c {
    private boolean a;

    public c(g g10) {
        super(g10);
    }

    private Intent a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("smsto:");
        stringBuilder.append(string2);
        string2 = Uri.parse((String)stringBuilder.toString());
        stringBuilder = new Intent("android.intent.action.SENDTO", (Uri)string2);
        stringBuilder.putExtra("sms_body", "");
        stringBuilder.setFlags(0x10000000);
        return stringBuilder;
    }

    public static /* synthetic */ AuthorizeListener a(c c10) {
        return c10.listener;
    }

    private void a(Platform platform, String string2) {
        c$1 c$1 = new c$1(this, platform, string2);
        c$1.start();
    }

    public static /* synthetic */ AuthorizeListener b(c c10) {
        return c10.listener;
    }

    public static /* synthetic */ AuthorizeListener c(c c10) {
        return c10.listener;
    }

    public void onComplete(String object) {
        boolean bl2 = this.a;
        if (bl2) {
            return;
        }
        this.a = bl2 = true;
        object = ResHelper.urlToBundle((String)object);
        Object object2 = object.getString("error");
        Object object3 = object.getString("error_code");
        Object object4 = this.listener;
        if (object4 != null) {
            if (object2 == null && object3 == null) {
                object2 = "code";
                bl2 = TextUtils.isEmpty((CharSequence)(object = object.getString((String)object2)));
                if (bl2) {
                    object2 = this.listener;
                    object4 = "Authorize code is empty";
                    object3 = new Throwable((String)object4);
                    object2.onError((Throwable)object3);
                }
                object2 = this.activity.a().getPlatform();
                this.a((Platform)object2, (String)object);
            } else {
                object = "access_denied";
                boolean n10 = ((String)object2).equals(object);
                if (n10) {
                    object = this.listener;
                    object.onCancel();
                } else {
                    int n11;
                    boolean bl3 = false;
                    object = null;
                    try {
                        n11 = ResHelper.parseInt((String)object3);
                    }
                    catch (Throwable throwable) {
                        object4 = SSDKLog.b();
                        ((NLog)object4).d(throwable);
                    }
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append((String)object2);
                    ((StringBuilder)object3).append(" (");
                    ((StringBuilder)object3).append(n11);
                    ((StringBuilder)object3).append(")");
                    object = ((StringBuilder)object3).toString();
                    object2 = this.listener;
                    object3 = new Throwable((String)object);
                    object2.onError((Throwable)object3);
                }
            }
        }
    }

    public void onPageStarted(WebView object, String object2, Bitmap bitmap) {
        block12: {
            String string2 = this.redirectUri;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2 && (bl2 = ((String)object2).startsWith(string2 = this.redirectUri))) {
                object.stopLoading();
                object = this.activity;
                ((FakeActivity)object).finish();
                this.onComplete((String)object2);
            } else {
                string2 = "sms:";
                bl2 = ((String)object2).startsWith(string2);
                if (bl2) {
                    int n10 = 4;
                    object2 = ((String)object2).substring(n10);
                    try {
                        bitmap = this.a((String)object2);
                        string2 = "com.android.mms";
                    }
                    catch (Throwable throwable) {
                        try {
                            object2 = this.a((String)object2);
                        }
                        catch (Throwable throwable2) {
                            object2 = this.listener;
                            if (object2 != null) {
                                object2.onError(throwable2);
                            }
                            break block12;
                        }
                        object = object.getContext();
                        object.startActivity((Intent)object2);
                        break block12;
                    }
                    bitmap.setPackage(string2);
                    string2 = object.getContext();
                    string2.startActivity((Intent)bitmap);
                }
                super.onPageStarted((WebView)object, (String)object2, bitmap);
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String object) {
        boolean bl2;
        String string2 = this.redirectUri;
        boolean n10 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = true;
        if (!n10 && (bl2 = ((String)object).startsWith(string2 = this.redirectUri))) {
            webView.stopLoading();
            this.activity.finish();
            this.onComplete((String)object);
            return bl3;
        }
        string2 = "sms:";
        boolean bl4 = ((String)object).startsWith(string2);
        if (bl4) {
            block10: {
                int n11 = 4;
                object = ((String)object).substring(n11);
                string2 = this.a((String)object);
                String string3 = "com.android.mms";
                string2.setPackage(string3);
                string3 = webView.getContext();
                try {
                    string3.startActivity((Intent)string2);
                }
                catch (Throwable throwable) {
                    object = this.a((String)object);
                    webView = webView.getContext();
                    try {
                        webView.startActivity((Intent)object);
                    }
                    catch (Throwable throwable2) {
                        object = this.listener;
                        if (object == null) break block10;
                        object.onError(throwable2);
                    }
                }
            }
            return bl3;
        }
        return super.shouldOverrideUrlLoading(webView, (String)object);
    }
}

