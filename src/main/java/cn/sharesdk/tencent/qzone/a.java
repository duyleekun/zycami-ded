/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.net.http.SslError
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebView
 */
package cn.sharesdk.tencent.qzone;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.c;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qzone.a$1;
import cn.sharesdk.tencent.qzone.a$2;
import cn.sharesdk.tencent.qzone.b;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import java.net.URLDecoder;
import java.util.HashMap;

public class a
extends c {
    public a(g g10) {
        super(g10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(HashMap object) {
        Object object2 = "openid";
        Object object3 = "access_token";
        String string2 = (String)((HashMap)object).get(object3);
        String string3 = "expires_in";
        String string4 = (String)((HashMap)object).get(string3);
        Object object4 = (String)((HashMap)object).get("error");
        String string5 = (String)((HashMap)object).get("error_description");
        String string6 = "pf";
        String string7 = (String)((HashMap)object).get(string6);
        String string8 = "pfkey";
        String string9 = (String)((HashMap)object).get(string8);
        String string10 = "pay_token";
        object = (String)((HashMap)object).get(string10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            try {
                int n10;
                object4 = this.activity;
                object4 = ((cn.sharesdk.framework.authorize.a)object4).a();
                object4 = object4.getPlatform();
                object4 = b.a((Platform)object4);
                object4 = ((b)object4).e(string2);
                if (object4 != null && (n10 = ((HashMap)object4).size()) > 0) {
                    n10 = (int)(((HashMap)object4).containsKey(object2) ? 1 : 0);
                    if (n10 == 0) {
                        object = this.listener;
                        if (object == null) return;
                        object2 = new Throwable();
                        object.onError((Throwable)object2);
                        return;
                    }
                    string5 = new Bundle();
                    string5.putString((String)object3, string2);
                    object3 = "open_id";
                    object2 = ((HashMap)object4).get(object2);
                    object2 = String.valueOf(object2);
                    string5.putString((String)object3, (String)object2);
                    string5.putString(string3, string4);
                    string5.putString(string6, string7);
                    string5.putString(string8, string9);
                    string5.putString(string10, (String)object);
                    object = this.listener;
                    if (object == null) return;
                    object.onComplete((Bundle)string5);
                    return;
                }
                object = this.listener;
                if (object == null) return;
                object2 = new Throwable();
                object.onError((Throwable)object2);
                return;
            }
            catch (Throwable throwable) {
                object2 = this.listener;
                if (object2 == null) return;
                object2.onError(throwable);
                return;
            }
        }
        boolean bl3 = TextUtils.isEmpty((CharSequence)object4);
        if (!bl3) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string5);
            ((StringBuilder)object).append(" (");
            ((StringBuilder)object).append((String)object4);
            ((StringBuilder)object).append(")");
            object = ((StringBuilder)object).toString();
            object2 = this.listener;
            if (object2 == null) return;
            object3 = new Throwable((String)object);
            object2.onError((Throwable)object3);
            return;
        }
        object = this.listener;
        object2 = new Throwable();
        object.onError((Throwable)object2);
    }

    /*
     * WARNING - void declaration
     */
    public void onComplete(String object) {
        void var1_3;
        HashMap<String, String> hashMap = this.redirectUri;
        int n10 = ((String)object).startsWith((String)((Object)hashMap));
        int n11 = 1;
        if (n10 != 0) {
            n10 = ((String)object).indexOf(35) + n11;
            String string2 = ((String)object).substring(n10);
        }
        String[] stringArray = var1_3.split("&");
        hashMap = new HashMap<String, String>();
        for (String string3 : stringArray) {
            String string4 = "=";
            String[] stringArray2 = string3.split(string4);
            int n12 = stringArray2.length;
            int n13 = 2;
            String string5 = "";
            if (n12 < n13) {
                String string6 = URLDecoder.decode(stringArray2[0]);
                hashMap.put(string6, string5);
                continue;
            }
            string4 = URLDecoder.decode(stringArray2[0]);
            String string7 = stringArray2[n11];
            if (string7 != null) {
                string5 = stringArray2[n11];
            }
            String string8 = URLDecoder.decode(string5);
            hashMap.put(string4, string8);
        }
        this.a(hashMap);
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
            object = new a$2(this, (SslErrorHandler)object2);
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

    public boolean shouldOverrideUrlLoading(WebView object, String string2) {
        String string3 = this.redirectUri;
        boolean bl2 = string2.startsWith(string3);
        boolean bl3 = true;
        if (bl2) {
            object.setVisibility(4);
            object.stopLoading();
            this.activity.finish();
            object = new a$1(this, string2);
            ((Thread)object).start();
            return bl3;
        }
        object.loadUrl(string2);
        return bl3;
    }
}

