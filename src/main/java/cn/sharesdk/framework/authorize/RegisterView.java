/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 */
package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.RegisterView$1;
import cn.sharesdk.framework.authorize.RegisterView$2;
import cn.sharesdk.framework.authorize.ResizeLayout;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;

public class RegisterView
extends ResizeLayout {
    private TitleLayout a;
    private RelativeLayout b;
    private WebView c;
    private TextView d;

    public RegisterView(Context context) {
        super(context);
        this.a(context);
    }

    public RegisterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context);
    }

    public static /* synthetic */ TextView a(RegisterView registerView) {
        return registerView.d;
    }

    private void a(Context object) {
        float f10;
        Object object2;
        int n10;
        Object object3;
        int n11;
        int n12;
        int n13;
        block17: {
            n13 = -1;
            this.setBackgroundColor(n13);
            n12 = 1;
            this.setOrientation(n12);
            n11 = this.b((Context)object);
            this.a = object3 = new TitleLayout((Context)object);
            object3 = "ssdk_auth_title_back";
            n10 = ResHelper.getBitmapRes(object, (String)object3);
            if (n10 <= 0) break block17;
            object2 = this.a;
            try {
                object2.setBackgroundResource(n10);
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                object2.d(throwable);
            }
        }
        object3 = this.a.getBtnRight();
        int n14 = 8;
        object3.setVisibility(n14);
        object3 = this.getContext();
        Object object4 = "ssdk_weibo_oauth_regiseter";
        n10 = ResHelper.getStringRes((Context)object3, (String)object4);
        if (n10 > 0) {
            object4 = this.a.getTvTitle();
            object4.setText(n10);
        }
        object3 = this.a;
        this.addView((View)object3);
        object3 = new ImageView(object);
        object4 = "ssdk_logo";
        int n15 = ResHelper.getBitmapRes(object, (String)object4);
        if (n15 > 0) {
            object3.setImageResource(n15);
        }
        object4 = ImageView.ScaleType.CENTER_INSIDE;
        object3.setScaleType((ImageView.ScaleType)object4);
        n15 = 10;
        int n16 = ResHelper.dipToPx(object, n15);
        object3.setPadding(0, 0, n16, 0);
        int n17 = -2;
        Object object5 = new LinearLayout.LayoutParams(n17, n13);
        object3.setLayoutParams((ViewGroup.LayoutParams)object5);
        object5 = new RegisterView$1(this);
        object3.setOnClickListener((View.OnClickListener)object5);
        object5 = this.a;
        object5.addView((View)object3);
        object3 = new RelativeLayout(object);
        this.b = object3;
        object3 = new LinearLayout.LayoutParams(n13, 0);
        n16 = 1065353216;
        ((LinearLayout.LayoutParams)object3).weight = f10 = 1.0f;
        this.b.setLayoutParams((ViewGroup.LayoutParams)object3);
        object3 = this.b;
        this.addView((View)object3);
        object3 = new LinearLayout(object);
        object3.setOrientation(n12);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n13, n13);
        object3.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.b.addView((View)object3);
        layoutParams = new TextView(object);
        this.d = layoutParams;
        int n18 = 5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(n13, n18);
        layoutParams.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        layoutParams = this.d;
        int n19 = -12929302;
        layoutParams.setBackgroundColor(n19);
        layoutParams = this.d;
        object3.addView((View)layoutParams);
        layoutParams = this.d;
        layoutParams.setVisibility(n14);
        object2 = new WebView(object);
        this.c = object2;
        object = new LinearLayout.LayoutParams(n13, n13);
        object.weight = f10;
        Object object6 = this.c;
        object6.setLayoutParams((ViewGroup.LayoutParams)object);
        object = new RegisterView$2(this, n11);
        n13 = Build.VERSION.SDK_INT;
        if (n13 > n15 && n13 < (n11 = 17)) {
            object6 = this.c;
            object6 = object6.getClass();
            String string2 = "removeJavascriptInterface";
            object2 = new Class[n12];
            object4 = String.class;
            object2[0] = object4;
            object6 = ((Class)object6).getMethod(string2, (Class<?>)object2);
            ((Method)object6).setAccessible(n12 != 0);
            string2 = this.c;
            Object[] objectArray = new Object[n12];
            object2 = "searchBoxJavaBridge_";
            objectArray[0] = object2;
            try {
                ((Method)object6).invoke(string2, objectArray);
            }
            catch (Throwable throwable) {
                objectArray = SSDKLog.b();
                objectArray.d(throwable);
            }
        }
        this.c.setWebChromeClient((WebChromeClient)object);
        object = this.c;
        object3.addView((View)object);
        this.c.requestFocus();
    }

    private int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        boolean bl2 = context instanceof Activity;
        if (!bl2) {
            return 0;
        }
        if ((context = ((Activity)context).getWindowManager()) == null) {
            return 0;
        }
        context.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public View a() {
        return this.a.getBtnBack();
    }

    /*
     * WARNING - void declaration
     */
    public void a(boolean bl2) {
        void var1_4;
        TitleLayout titleLayout = this.a;
        if (bl2) {
            int n10 = 8;
        } else {
            boolean bl3 = false;
        }
        titleLayout.setVisibility((int)var1_4);
    }

    public WebView b() {
        return this.c;
    }

    public TitleLayout c() {
        return this.a;
    }

    public RelativeLayout d() {
        return this.b;
    }
}

