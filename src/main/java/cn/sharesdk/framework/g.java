/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.Bitmap
 *  android.net.http.SslError
 *  android.os.Message
 *  android.view.KeyEvent
 *  android.webkit.HttpAuthHandler
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package cn.sharesdk.framework;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.sharesdk.framework.g$1;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;

public class g
extends WebViewClient {
    public static final int ERROR_AUTHENTICATION = 252;
    public static final int ERROR_BAD_URL = 244;
    public static final int ERROR_CONNECT = 250;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = 245;
    public static final int ERROR_FILE = 243;
    public static final int ERROR_FILE_NOT_FOUND = 242;
    public static final int ERROR_HOST_LOOKUP = 254;
    public static final int ERROR_IO = 249;
    public static final int ERROR_PROXY_AUTHENTICATION = 251;
    public static final int ERROR_REDIRECT_LOOP = 247;
    public static final int ERROR_TIMEOUT = 248;
    public static final int ERROR_TOO_MANY_REQUESTS = 241;
    public static final int ERROR_UNKNOWN = 255;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = 253;
    public static final int ERROR_UNSUPPORTED_SCHEME = 246;

    public void doUpdateVisitedHistory(WebView webView, String string2, boolean bl2) {
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onLoadResource(WebView webView, String string2) {
    }

    public void onPageFinished(WebView webView, String string2) {
    }

    public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
    }

    public void onReceivedError(WebView webView, int n10, String string2, String string3) {
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String string2, String string3) {
        httpAuthHandler.cancel();
    }

    public void onReceivedSslError(WebView object, SslErrorHandler object2, SslError sslError) {
        Context context = object.getContext();
        int n10 = context instanceof Activity;
        if (n10 != 0) {
            String string2;
            Object object3;
            Object object4;
            object = (Activity)object.getContext();
            context = DeviceHelper.getInstance((Context)object).getOSLanguage();
            String string3 = "zh";
            n10 = string3.equals(context);
            int n11 = 4;
            int n12 = 3;
            int n13 = 1;
            int n14 = 2;
            if (n10 != 0) {
                n10 = 5;
                context = new String[n10];
                int n15 = 14;
                char[] cArray = object4 = new char[n15];
                char[] cArray2 = object4;
                cArray[0] = 19981;
                cArray2[1] = 21463;
                cArray[2] = 20449;
                cArray2[3] = 20219;
                cArray[4] = 30340;
                cArray2[5] = 35777;
                cArray[6] = 20070;
                cArray2[7] = 12290;
                cArray[8] = 20320;
                cArray2[9] = 35201;
                cArray[10] = 32487;
                cArray2[11] = 32493;
                cArray[12] = 21527;
                cArray2[13] = 65311;
                object4 = String.valueOf(object4);
                context[0] = object4;
                int n16 = 12;
                Object object5 = object4 = new char[n16];
                Object object6 = object4;
                object5[0] = 35777;
                object6[1] = 20070;
                object5[2] = 24050;
                object6[3] = 36807;
                object5[4] = 26399;
                object6[5] = 12290;
                object5[6] = 20320;
                object6[7] = 35201;
                object5[8] = 32487;
                object6[9] = 32493;
                object5[10] = 21527;
                object6[11] = 65311;
                object4 = String.valueOf(object4);
                context[n13] = object4;
                Object object7 = object3 = (Object)new char[n15];
                object7[0] = 35777;
                object7[1] = 20070;
                object7[2] = 73;
                object7[3] = 68;
                object7[4] = 19981;
                object7[5] = 21305;
                object7[6] = 37197;
                object7[7] = 12290;
                object7[8] = 20320;
                object7[9] = 35201;
                object7[10] = 32487;
                object7[11] = 32493;
                object7[12] = 21527;
                object7[13] = 65311;
                context[n14] = object3 = String.valueOf((char[])object3);
                Object object8 = object3 = (Object)new char[13];
                object8[0] = 35777;
                object8[1] = 20070;
                object8[2] = 23578;
                object8[3] = 26410;
                object8[4] = 29983;
                object8[5] = 25928;
                object8[6] = 12290;
                object8[7] = 20320;
                object8[8] = 35201;
                object8[9] = 32487;
                object8[10] = 32493;
                object8[11] = 21527;
                object8[12] = 65311;
                context[n12] = object3 = String.valueOf((char[])object3);
                n15 = 11;
                Object object9 = object3 = (Object)new char[n15];
                object9[0] = 35777;
                object9[1] = 20070;
                object9[2] = 38169;
                object9[3] = 35823;
                object9[4] = 12290;
                object9[5] = 20320;
                object9[6] = 35201;
                object9[7] = 32487;
                object9[8] = 32493;
                object9[9] = 21527;
                object9[10] = 65311;
                context[n11] = object3 = String.valueOf((char[])object3);
                Object object10 = object3 = (Object)new char[n11];
                object10[0] = 35777;
                object10[1] = 20070;
                object10[2] = 38169;
                object10[3] = 35823;
                object3 = String.valueOf((char[])object3);
                object4 = new char[n14];
                object4[0] = 32487;
                object4[1] = 32493;
                String.valueOf(object4);
                object4 = new char[n14];
                object4[0] = 20572;
                object4[1] = 27490;
                object4 = String.valueOf(object4);
            } else {
                string2 = "Certificate is not yet valid. Do you want to continue anyway?";
                String string4 = "Certificate error. Do you want to continue anyway?";
                context = new String[]{"Certificate is untrusted. Do you want to continue anyway?", "Certificate has expired. Do you want to continue anyway?", "Certificate ID is mismatched. Do you want to continue anyway?", string2, string4};
                object3 = "SSL Certificate Error";
                object4 = "No";
            }
            string2 = new AlertDialog.Builder((Context)object);
            string2.setTitle((CharSequence)object3);
            int n17 = sslError.getPrimaryError();
            if (n17 != 0) {
                if (n17 != n13) {
                    if (n17 != n14) {
                        if (n17 != n12) {
                            object = context[n11];
                            string2.setMessage((CharSequence)object);
                        } else {
                            object = context[0];
                            string2.setMessage((CharSequence)object);
                        }
                    } else {
                        object = context[n14];
                        string2.setMessage((CharSequence)object);
                    }
                } else {
                    object = context[n13];
                    string2.setMessage((CharSequence)object);
                }
            } else {
                object = context[n12];
                string2.setMessage((CharSequence)object);
            }
            string2.setCancelable(false);
            object = new g$1(this, (SslErrorHandler)object2);
            string2.setNegativeButton((CharSequence)object4, (DialogInterface.OnClickListener)object);
            object = string2.create();
            try {
                object.show();
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).w(throwable);
            }
        } else {
            object2.cancel();
        }
    }

    public void onScaleChanged(WebView webView, float f10, float f11) {
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        return false;
    }
}

