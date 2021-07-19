/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.webkit.SslErrorHandler
 *  android.webkit.URLUtil
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package d.j.f.a.a.l;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.LogsUtil;
import com.huawei.secure.android.common.webview.WebViewLoadCallBack;
import com.huawei.secure.android.common.webview.WebViewLoadCallBack$ErrorCode;
import d.j.f.a.a.l.b;
import d.j.f.a.a.l.c$b;
import d.j.f.a.a.l.c$c;
import d.j.f.a.a.l.c$d;
import d.j.f.a.a.l.d;
import java.util.Arrays;
import java.util.Map;

public class c
extends WebView {
    private static final String f = "SafeWebView";
    private String a;
    private String[] b;
    private String[] c;
    private String[] d;
    private WebViewLoadCallBack e;

    public c(Context context) {
        super(context);
        this.a();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a();
    }

    public c(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a();
    }

    public c(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        this.a();
    }

    private void a() {
        d.j.f.a.a.l.b.f(this);
        this.setWebViewClient(null);
    }

    private boolean b(String string2) {
        return URLUtil.isHttpUrl((String)string2);
    }

    public boolean c(String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            LogsUtil.l(f, "url is null");
            return false;
        }
        n11 = URLUtil.isNetworkUrl((String)string2);
        if (n11 == 0) {
            return true;
        }
        String[] stringArray = this.getWhitelistWithPath();
        String[] stringArray2 = this.getWhitelistNotMathcSubDomain();
        String[] stringArray3 = this.getWhitelist();
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            return d.j.f.a.a.l.d.c(string2, stringArray);
        }
        if (stringArray2 != null && (n11 = stringArray2.length) != 0) {
            return d.j.f.a.a.l.d.h(string2, stringArray2);
        }
        return d.j.f.a.a.l.d.e(string2, stringArray3);
    }

    public final void d(WebView object, String string2) {
        Object object2 = f;
        LogsUtil.m(object2, "onCheckError url is not in white list ", string2);
        object.stopLoading();
        String string3 = this.getDefaultErrorPage();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            object.loadUrl(string3);
        } else {
            object = this.getWebViewLoadCallBack();
            if (object != null) {
                Log.e((String)object2, (String)"onPageStarted WebViewLoadCallBack");
                object = this.getWebViewLoadCallBack();
                object2 = WebViewLoadCallBack$ErrorCode.URL_NOT_IN_WHITE_LIST;
                object.a(string2, (WebViewLoadCallBack$ErrorCode)((Object)object2));
            }
        }
    }

    public void e(WebViewClient webViewClient, boolean bl2) {
        c$d c$d = new c$d(this, webViewClient, bl2, null);
        super.setWebViewClient((WebViewClient)c$d);
    }

    public final void f(String object, String string2, String string3, String string4, SslErrorHandler sslErrorHandler) {
        Object object2 = this.getContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(object2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            builder.setTitle((CharSequence)object);
        }
        object = new c$c(sslErrorHandler);
        object2 = new c$b(sslErrorHandler);
        builder.setMessage((CharSequence)string2);
        builder.setPositiveButton((CharSequence)string3, (DialogInterface.OnClickListener)object);
        builder.setNegativeButton((CharSequence)string4, (DialogInterface.OnClickListener)object2);
        builder.create().show();
    }

    public String getDefaultErrorPage() {
        return this.a;
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.e;
    }

    public String[] getWhitelist() {
        String[] stringArray = this.b;
        if (stringArray == null) {
            stringArray = null;
        } else {
            int n10 = stringArray.length;
            stringArray = Arrays.copyOf(stringArray, n10);
        }
        return stringArray;
    }

    public String[] getWhitelistNotMathcSubDomain() {
        String[] stringArray = this.c;
        if (stringArray == null) {
            stringArray = null;
        } else {
            int n10 = stringArray.length;
            stringArray = Arrays.copyOf(stringArray, n10);
        }
        return stringArray;
    }

    public String[] getWhitelistWithPath() {
        String[] stringArray = this.d;
        if (stringArray == null) {
            stringArray = null;
        } else {
            int n10 = stringArray.length;
            stringArray = Arrays.copyOf(stringArray, n10);
        }
        return stringArray;
    }

    public void loadDataWithBaseURL(String string2, String object, String object2, String string3, String string4) {
        boolean bl2 = this.b(string2);
        if (bl2) {
            String string5 = f;
            Log.e((String)string5, (String)"loadDataWithBaseURL: http url , not safe");
            String string6 = this.a;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string6);
            if (!bl3) {
                String string7 = this.a;
                super.loadDataWithBaseURL(string7, (String)object, object2, string3, string4);
            } else {
                object = this.getWebViewLoadCallBack();
                if (object != null) {
                    Log.e((String)string5, (String)"WebViewLoadCallBack");
                    object = this.getWebViewLoadCallBack();
                    object2 = WebViewLoadCallBack$ErrorCode.HTTP_URL;
                    object.a(string2, (WebViewLoadCallBack$ErrorCode)((Object)object2));
                }
            }
            return;
        }
        super.loadDataWithBaseURL(string2, (String)object, object2, string3, string4);
    }

    public void loadUrl(String string2) {
        boolean bl2 = this.b(string2);
        if (bl2) {
            Object object = f;
            Log.e((String)object, (String)"loadUrl: http url , not safe");
            Object object2 = this.a;
            boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl3) {
                string2 = this.a;
                super.loadUrl(string2);
            } else {
                object2 = this.getWebViewLoadCallBack();
                if (object2 != null) {
                    Log.e((String)object, (String)"WebViewLoadCallBack");
                    object = this.getWebViewLoadCallBack();
                    object2 = WebViewLoadCallBack$ErrorCode.HTTP_URL;
                    object.a(string2, (WebViewLoadCallBack$ErrorCode)((Object)object2));
                }
            }
            return;
        }
        super.loadUrl(string2);
    }

    public void loadUrl(String string2, Map object) {
        boolean bl2 = this.b(string2);
        if (bl2) {
            Object object2 = f;
            Log.e((String)object2, (String)"loadUrl: http url , not safe");
            String string3 = this.a;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl3) {
                string2 = this.a;
                super.loadUrl(string2, (Map)object);
            } else {
                object = this.getWebViewLoadCallBack();
                if (object != null) {
                    Log.e((String)object2, (String)"WebViewLoadCallBack");
                    object = this.getWebViewLoadCallBack();
                    object2 = WebViewLoadCallBack$ErrorCode.HTTP_URL;
                    object.a(string2, (WebViewLoadCallBack$ErrorCode)((Object)object2));
                }
            }
            return;
        }
        super.loadUrl(string2, (Map)object);
    }

    public void postUrl(String string2, byte[] object) {
        boolean bl2 = this.b(string2);
        if (bl2) {
            Object object2 = f;
            Log.e((String)object2, (String)"postUrl: http url , not safe");
            String string3 = this.a;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl3) {
                string2 = this.a;
                super.postUrl(string2, (byte[])object);
            } else {
                object = this.getWebViewLoadCallBack();
                if (object != null) {
                    Log.e((String)object2, (String)"WebViewLoadCallBack");
                    object = this.getWebViewLoadCallBack();
                    object2 = WebViewLoadCallBack$ErrorCode.HTTP_URL;
                    object.a(string2, (WebViewLoadCallBack$ErrorCode)((Object)object2));
                }
            }
            return;
        }
        super.postUrl(string2, (byte[])object);
    }

    public void setDefaultErrorPage(String string2) {
        this.a = string2;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        c$d c$d = new c$d(this, webViewClient, true, null);
        super.setWebViewClient((WebViewClient)c$d);
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack webViewLoadCallBack) {
        this.e = webViewLoadCallBack;
    }

    public void setWhitelist(String[] stringArray) {
        if (stringArray == null) {
            stringArray = null;
        } else {
            int n10 = stringArray.length;
            stringArray = Arrays.copyOf(stringArray, n10);
        }
        this.b = stringArray;
    }

    public void setWhitelistNotMathcSubDomain(String[] stringArray) {
        if (stringArray == null) {
            stringArray = null;
        } else {
            int n10 = stringArray.length;
            stringArray = Arrays.copyOf(stringArray, n10);
        }
        this.c = stringArray;
    }

    public void setWhitelistWithPath(String[] stringArray) {
        if (stringArray == null) {
            stringArray = null;
        } else {
            int n10 = stringArray.length;
            stringArray = Arrays.copyOf(stringArray, n10);
        }
        this.d = stringArray;
    }
}

