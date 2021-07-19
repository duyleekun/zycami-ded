/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 */
package cn.sharesdk.sina.weibo.sdk.a;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.sina.weibo.sdk.LoadingBar;
import cn.sharesdk.sina.weibo.sdk.a.a$1;
import cn.sharesdk.sina.weibo.sdk.a.a$2;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;

public class a {
    private TextView a;
    private TextView b;
    private WebView c;
    private LoadingBar d;
    private LinearLayout e;
    private TextView f;
    private Button g;
    private Context h;

    public a(Context context) {
        this.h = context;
    }

    public static /* synthetic */ LoadingBar a(a a10) {
        return a10.d;
    }

    private void e() {
        Object object = new StringBuilder();
        Object object2 = Build.MANUFACTURER;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("-");
        object2 = Build.MODEL;
        ((StringBuilder)object).append((String)object2);
        object2 = "_";
        ((StringBuilder)object).append((String)object2);
        Object[] objectArray = Build.VERSION.RELEASE;
        ((StringBuilder)object).append((String)objectArray);
        ((StringBuilder)object).append((String)object2);
        objectArray = "weibosdk";
        ((StringBuilder)object).append((String)objectArray);
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("0031405000");
        ((StringBuilder)object).append("_android");
        object2 = this.c.getSettings();
        int n10 = 1;
        object2.setJavaScriptEnabled(n10 != 0);
        this.c.getSettings().setSavePassword(false);
        object2 = this.c.getSettings();
        object = ((StringBuilder)object).toString();
        object2.setUserAgentString((String)object);
        this.c.requestFocus();
        object = this.c;
        object.setScrollBarStyle(0);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 10;
        if (n11 > n12 && n11 < (n12 = 17)) {
            object = this.c;
            object = object.getClass();
            object2 = "removeJavascriptInterface";
            Object object3 = new Class[n10];
            Class<String> clazz = String.class;
            object3[0] = clazz;
            object = ((Class)object).getMethod((String)object2, (Class<?>)object3);
            ((Method)object).setAccessible(n10 != 0);
            object2 = this.c;
            objectArray = new Object[n10];
            object3 = "searchBoxJavaBridge_";
            objectArray[0] = object3;
            try {
                ((Method)object).invoke(object2, objectArray);
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).d(throwable);
            }
        }
        object = this.c;
        object2 = new a$2(this);
        object.setWebChromeClient((WebChromeClient)object2);
    }

    public Button a() {
        return this.g;
    }

    public RelativeLayout a(int n10) {
        Object object = this.h;
        RelativeLayout relativeLayout = new RelativeLayout(object);
        int n11 = -1;
        object = new RelativeLayout.LayoutParams(n11, n11);
        relativeLayout.setLayoutParams((ViewGroup.LayoutParams)object);
        relativeLayout.setBackgroundColor(n11);
        Context context = this.h;
        object = new RelativeLayout(context);
        int n12 = ResHelper.getIdRes(this.h, "ssdk_sina_web_title_id");
        object.setId(n12);
        object.setBackgroundColor(-131587);
        context = this.h;
        n12 = ResHelper.dipToPx(context, 55);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n11, n12);
        n12 = 10;
        layoutParams.addRule(n12);
        relativeLayout.addView((View)object, (ViewGroup.LayoutParams)layoutParams);
        Context context2 = this.h;
        layoutParams = new TextView(context2);
        this.a = layoutParams;
        int n13 = 1;
        layoutParams.setTextSize(n13, 17.0f);
        layoutParams = this.a;
        int n14 = -32256;
        int n15 = 1728020992;
        float f10 = 6.0330076E23f;
        Object object2 = cn.sharesdk.sina.weibo.sdk.a.a(n14, n15);
        layoutParams.setTextColor(object2);
        layoutParams = this.h;
        object2 = "ssdk_sina_web_close";
        int n16 = ResHelper.getStringRes((Context)layoutParams, (String)object2);
        if (n16 > 0) {
            object2 = this.a;
            object2.setText(n16);
        }
        n12 = ResHelper.dipToPx(this.h, n12);
        this.a.setPadding(n12, 0, n12, 0);
        layoutParams = this.a;
        object2 = new a$1(this);
        layoutParams.setOnTouchListener((View.OnTouchListener)object2);
        n14 = -2;
        layoutParams = new RelativeLayout.LayoutParams(n14, n14);
        layoutParams.addRule(15);
        Object object3 = this.a;
        object.addView((View)object3, (ViewGroup.LayoutParams)layoutParams);
        object3 = this.h;
        layoutParams = new TextView((Context)object3);
        this.b = layoutParams;
        layoutParams.setTextColor(-11382190);
        layoutParams = this.b;
        n15 = 1099956224;
        f10 = 18.0f;
        layoutParams.setTextSize(n13, f10);
        if (n10 > 0) {
            layoutParams = this.b;
            layoutParams.setText(n10);
        }
        Object object4 = new RelativeLayout.LayoutParams(n14, n14);
        n16 = 13;
        object4.addRule(n16);
        object3 = this.b;
        object.addView((View)object3, (ViewGroup.LayoutParams)object4);
        object3 = this.h;
        object4 = new WebView((Context)object3);
        this.c = object4;
        object4 = new RelativeLayout.LayoutParams(n11, n11);
        n15 = object.getId();
        int n17 = 3;
        object4.addRule(n17, n15);
        object3 = this.c;
        relativeLayout.addView((View)object3, (ViewGroup.LayoutParams)object4);
        object3 = this.h;
        object4 = new LoadingBar((Context)object3);
        this.d = object4;
        n10 = ResHelper.dipToPx(this.h, n17);
        object3 = new RelativeLayout.LayoutParams(n11, n10);
        n10 = object.getId();
        object3.addRule(n17, n10);
        object4 = this.d;
        relativeLayout.addView((View)object4, (ViewGroup.LayoutParams)object3);
        object = this.h;
        object4 = new View(object);
        object = this.h;
        String string2 = "ssdk_weibo_common_shadow_top";
        int n18 = ResHelper.getBitmapRes(object, string2);
        if (n18 > 0) {
            object4.setBackgroundResource(n18);
        }
        relativeLayout.addView((View)object4, (ViewGroup.LayoutParams)object3);
        object = this.h;
        object4 = new LinearLayout(object);
        this.e = object4;
        n18 = 8;
        float f11 = 1.1E-44f;
        object4.setVisibility(n18);
        object4 = this.e;
        n11 = 17;
        object4.setGravity(n11);
        this.e.setOrientation(n13);
        object4 = new RelativeLayout.LayoutParams(n14, n14);
        object4.addRule(n16);
        layoutParams = this.e;
        relativeLayout.addView((View)layoutParams, (ViewGroup.LayoutParams)object4);
        layoutParams = this.h;
        object4 = new ImageView((Context)layoutParams);
        layoutParams = this.h;
        object3 = "ssdk_weibo_empty_failed";
        n16 = ResHelper.getBitmapRes((Context)layoutParams, (String)object3);
        if (n16 > 0) {
            object4.setImageResource(n16);
        }
        layoutParams = new LinearLayout.LayoutParams(n14, n14);
        object3 = this.h;
        layoutParams.bottomMargin = n18 = ResHelper.dipToPx((Context)object3, n18);
        this.e.addView((View)object4, (ViewGroup.LayoutParams)layoutParams);
        object = this.h;
        object4 = new TextView(object);
        this.f = object4;
        object4 = this.h;
        object = "ssdk_sina_web_net_error";
        n10 = ResHelper.getStringRes((Context)object4, (String)object);
        if (n10 > 0) {
            object = this.f;
            object.setText(n10);
        }
        this.f.setTextColor(-4342339);
        this.f.setTextSize(n13, 14.0f);
        object4 = new LinearLayout.LayoutParams(n14, n14);
        object = this.e;
        layoutParams = this.f;
        object.addView((View)layoutParams, (ViewGroup.LayoutParams)object4);
        object = this.h;
        object4 = new Button(object);
        this.g = object4;
        object4.setTextColor(-8882056);
        this.g.setGravity(n11);
        object4 = this.g;
        n18 = 1098907648;
        f11 = 16.0f;
        object4.setTextSize(n13, f11);
        object4 = this.h;
        object = "ssdk_sina_web_refresh";
        n10 = ResHelper.getStringRes((Context)object4, (String)object);
        if (n10 > 0) {
            object = this.g;
            object.setText(n10);
        }
        n10 = ResHelper.dipToPx(this.h, 142);
        n18 = ResHelper.dipToPx(this.h, 46);
        string2 = new LinearLayout.LayoutParams(n10, n18);
        ((LinearLayout.LayoutParams)string2).topMargin = n12;
        object4 = this.e;
        object = this.g;
        object4.addView((View)object, (ViewGroup.LayoutParams)string2);
        this.e();
        return relativeLayout;
    }

    public TextView b() {
        return this.a;
    }

    public WebView c() {
        return this.c;
    }

    public LinearLayout d() {
        return this.e;
    }
}

