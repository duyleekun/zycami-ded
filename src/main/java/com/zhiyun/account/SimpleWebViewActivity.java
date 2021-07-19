/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.webkit.WebViewClient
 */
package com.zhiyun.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebViewClient;
import androidx.databinding.DataBindingUtil;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$string;
import com.zhiyun.account.SimpleWebViewActivity$a;
import com.zhiyun.account.SimpleWebViewActivity$b;
import com.zhiyun.account.SimpleWebViewActivity$c;
import com.zhiyun.common.util.StatusBarUtil;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;
import d.v.a.g.m0;
import d.v.e.l.b2;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.f.c.d;
import d.v.f.i.g;
import java.io.File;

public class SimpleWebViewActivity
extends d {
    private static final String c = "title";
    private static final String d = "url";
    private m0 b;

    private void d() {
        Object object = this.getWindow();
        int n10 = R$color.com_color_white;
        n10 = g.c((Context)this, n10);
        StatusBarUtil.z(object, n10);
        StatusBarUtil.E(this.getWindow(), true);
        object = this.getIntent();
        String string2 = c;
        object = object.getStringExtra(string2);
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            string2 = this.b.b;
            string2.setText((CharSequence)object);
        }
    }

    private void f() {
        Object object = this.getIntent();
        Object object2 = d;
        if ((object = object.getStringExtra(object2)) == null) {
            object = "";
        }
        this.b.c.loadUrl((String)object);
        object = this.b.c;
        object2 = new SimpleWebViewActivity$b(this);
        object.setWebViewClient((WebViewClient)object2);
    }

    public static void h(Activity activity, String string2, String string3) {
        Intent intent = new Intent();
        intent.setClass((Context)activity, SimpleWebViewActivity.class);
        intent.putExtra(c, string2);
        intent.putExtra(d, string3);
        activity.startActivity(intent);
    }

    public static void i(Context context, String string2, String string3) {
        Intent intent = new Intent(context, SimpleWebViewActivity.class);
        intent.putExtra(c, string2);
        intent.putExtra(d, string3);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public static void j(Context context, String string2, String object) {
        CharSequence charSequence = new StringBuilder();
        int n10 = R$string.base_agreement_uri;
        Object object2 = g.m(context, n10);
        object2 = ((String)object).replace((CharSequence)object2, "");
        String string3 = "/";
        Object object3 = "_";
        object2 = ((String)object2).replace(string3, (CharSequence)object3);
        ((StringBuilder)charSequence).append((String)object2);
        object2 = ".html";
        ((StringBuilder)charSequence).append((String)object2);
        charSequence = ((StringBuilder)charSequence).toString();
        n10 = (int)(b2.m(context) ? 1 : 0);
        if (n10 != 0) {
            object2 = DownLoadHelper.getInstance();
            string3 = k2.T().getAbsolutePath();
            object3 = new SimpleWebViewActivity$a();
            ((DownLoadHelper)object2).startDownLoad((String)object, string3, (String)charSequence, (DownLoadHelper$OnDownloadCallback)object3);
        } else {
            object2 = k2.T().getAbsolutePath();
            object = new File((String)object2, (String)charSequence);
            n10 = (int)(s1.p((File)object) ? 1 : 0);
            if (n10 != 0) {
                charSequence = new StringBuilder();
                object2 = "file:";
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(object);
                object = ((StringBuilder)charSequence).toString();
            } else {
                object = new StringBuilder();
                object2 = "file:///android_asset/";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)charSequence);
                object = ((StringBuilder)object).toString();
            }
        }
        SimpleWebViewActivity.i(context, string2, (String)object);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.getLayoutInflater();
        int n10 = R$layout.simple_webview_act;
        object = (m0)DataBindingUtil.inflate((LayoutInflater)object, n10, null, false);
        this.b = object;
        SimpleWebViewActivity$c simpleWebViewActivity$c = new SimpleWebViewActivity$c(this);
        ((m0)object).z(simpleWebViewActivity$c);
        object = this.b.getRoot();
        this.setContentView((View)object);
        this.d();
        this.f();
    }
}

