/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.webkit.URLUtil
 */
package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.push.k;
import com.huawei.hms.push.q;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;
import java.util.ArrayList;

public class j {
    public static final String[] a = new String[]{"url", "app", "cosa", "rp"};
    public Context b;
    public k c;

    public j(Context context, k k10) {
        this.b = context;
        this.c = k10;
    }

    public static boolean b(String string2) {
        for (String string3 : a) {
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public final String a(String string2) {
        CharSequence charSequence;
        String string3;
        CharSequence charSequence2;
        block32: {
            Object object;
            int n10;
            block31: {
                int n11;
                charSequence2 = "&";
                string3 = "PushSelfShowLog";
                int n12 = 63;
                n12 = string2.indexOf(n12);
                n10 = -1;
                if (n12 == n10) {
                    return string2;
                }
                n10 = n12 + 1;
                object = string2.substring(n10);
                object = ((String)object).split((String)charSequence2);
                ArrayList<String> arrayList = new ArrayList<String>();
                int n13 = ((String[])object).length;
                for (n11 = 0; n11 < n13; ++n11) {
                    String string4 = object[n11];
                    String string5 = "h_w_hiapp_referrer";
                    boolean bl2 = string4.startsWith(string5);
                    if (bl2) continue;
                    string5 = "h_w_gp_referrer";
                    bl2 = string4.startsWith(string5);
                    if (bl2) continue;
                    arrayList.add(string4);
                }
                object = new StringBuilder();
                n13 = arrayList.size();
                for (n11 = 0; n11 < n13; ++n11) {
                    Object e10 = arrayList.get(n11);
                    String string6 = (String)e10;
                    ((StringBuilder)object).append(string6);
                    int n14 = arrayList.size() + -1;
                    if (n11 >= n14) continue;
                    ((StringBuilder)object).append((String)charSequence2);
                }
                try {
                    int n15 = arrayList.size();
                    if (n15 != 0) break block31;
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("delete referrer exception.");
                    String string7 = exception.toString();
                    ((StringBuilder)charSequence).append(string7);
                    string7 = ((StringBuilder)charSequence).toString();
                    HMSLog.e(string3, string7);
                    return string2;
                }
                charSequence2 = string2.substring(0, n12);
                break block32;
            }
            charSequence2 = new StringBuilder();
            charSequence = string2.substring(0, n10);
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence = ((StringBuilder)object).toString();
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence2 = ((StringBuilder)charSequence2).toString();
        }
        charSequence = new StringBuilder();
        String string8 = "after delete referrer, the new IntentUri is:";
        ((StringBuilder)charSequence).append(string8);
        ((StringBuilder)charSequence).append((String)charSequence2);
        charSequence = ((StringBuilder)charSequence).toString();
        HMSLog.d(string3, (String)charSequence);
        return charSequence2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a() {
        String string2 = "PushSelfShowLog";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Object object = "enter launchApp, appPackageName =";
            stringBuilder.append((String)object);
            object = this.c;
            object = ((k)object).d();
            stringBuilder.append((String)object);
            object = ",and msg.intentUri is ";
            stringBuilder.append((String)object);
            object = this.c;
            object = ((k)object).n();
            stringBuilder.append((String)object);
            String string3 = stringBuilder.toString();
            HMSLog.i(string2, string3);
            Context context = this.b;
            object = this.c;
            object = ((k)object).d();
            boolean bl2 = q.c(context, (String)object);
            if (bl2) {
                this.b();
                return;
            }
            this.d();
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "launchApp error:";
            stringBuilder.append(string4);
            String string5 = exception.toString();
            stringBuilder.append(string5);
            String string6 = stringBuilder.toString();
            HMSLog.e(string2, string6);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void b() {
        block57: {
            block58: {
                var1_1 = "PushSelfShowLog";
                var2_2 = "run into launchCosaApp";
                HMSLog.i(var1_1, (String)var2_2);
                var2_2 = new StringBuilder();
                var3_5 = "enter launchExistApp cosa, appPackageName =";
                var2_2.append((String)var3_5);
                var3_5 = this.c;
                var3_5 = var3_5.d();
                var2_2.append((String)var3_5);
                var3_5 = ",and msg.intentUri is ";
                var2_2.append((String)var3_5);
                var3_5 = this.c;
                var3_5 = var3_5.n();
                var2_2.append((String)var3_5);
                var2_2 = var2_2.toString();
                HMSLog.i(var1_1, (String)var2_2);
                var2_2 = this.b;
                var3_5 = this.c;
                var3_5 = var3_5.d();
                var2_2 = q.b((Context)var2_2, (String)var3_5);
                var3_5 = this.c;
                var3_5 = var3_5.n();
                var4_7 = false;
                var5_8 = null;
                if (var3_5 == null) ** GOTO lbl-1000
                var3_5 = this.c;
                var3_5 = var3_5.n();
                var3_5 = Intent.parseUri((String)var3_5, (int)0);
                var6_9 = false;
                var7_11 = null;
                var3_5.setSelector(null);
                var7_11 = new StringBuilder();
                var8_13 = "Intent.parseUri(msg.intentUri, 0), action:";
                var7_11.append((String)var8_13);
                var8_13 = var3_5.getAction();
                var7_11.append((String)var8_13);
                var7_11 = var7_11.toString();
                HMSLog.i(var1_1, (String)var7_11);
                var7_11 = this.b;
                var8_13 = this.c;
                var8_13 = var8_13.d();
                var7_11 = q.a((Context)var7_11, (String)var8_13, (Intent)var3_5);
                try {
                    var4_7 = var7_11.booleanValue();
                    if (var4_7) {
                        var2_2 = var3_5;
                    }
                    break block57;
                }
                catch (Exception var3_6) {
                    var7_11 = new StringBuilder();
                    var8_13 = "intentUri error.";
                    var7_11.append((String)var8_13);
                    var3_5 = var3_6.toString();
                    var7_11.append((String)var3_5);
                    var3_5 = var7_11.toString();
                    HMSLog.w(var1_1, (String)var3_5);
                }
                break block57;
lbl-1000:
                // 1 sources

                {
                    var3_5 = this.c;
                }
                var3_5 = var3_5.a();
                if (var3_5 == null) break block58;
                var7_12 = this.c;
                var7_12 = var7_12.a();
                var3_5 = new Intent((String)var7_12);
                var7_12 = this.b;
                var8_14 = this.c;
                var8_14 = var8_14.d();
                var7_12 = q.a((Context)var7_12, (String)var8_14, (Intent)var3_5);
                var6_10 = var7_12.booleanValue();
                if (!var6_10) break block58;
                var2_2 = var3_5;
            }
            var3_5 = this.c;
            var3_5 = var3_5.d();
            var2_2.setPackage((String)var3_5);
        }
        if (var2_2 == null) {
            var2_2 = "launchCosaApp,intent == null";
            HMSLog.i(var1_1, (String)var2_2);
            return;
        }
        if (var4_7) {
            var9_15 = 0x10000000;
            var2_2.addFlags(var9_15);
        } else {
            var9_16 = 0x30020000;
            var2_2.setFlags(var9_16);
        }
        var3_5 = new StringBuilder();
        var5_8 = "start ";
        var3_5.append(var5_8);
        var5_8 = var2_2.toURI();
        var3_5.append(var5_8);
        var3_5 = var3_5.toString();
        HMSLog.i(var1_1, (String)var3_5);
        var3_5 = this.b;
        var3_5.startActivity((Intent)var2_2);
        {
            catch (Exception var2_3) {
                var3_5 = new StringBuilder();
                var5_8 = "launch Cosa App exception.";
                var3_5.append(var5_8);
                var2_4 = var2_3.toString();
                var3_5.append(var2_4);
                var2_4 = var3_5.toString();
                HMSLog.e(var1_1, var2_4);
            }
        }
    }

    public void c() {
        String string2 = "PushSelfShowLog";
        HMSLog.d(string2, "enter launchNotify()");
        Object object = this.b;
        if (object != null && (object = this.c) != null) {
            String string3 = "app";
            boolean bl2 = string3.equals(object = ((k)object).i());
            if (bl2) {
                this.a();
            } else {
                string3 = "cosa";
                object = this.c.i();
                bl2 = string3.equals(object);
                if (bl2) {
                    this.b();
                } else {
                    string3 = "rp";
                    object = this.c.i();
                    bl2 = string3.equals(object);
                    if (bl2) {
                        object = new StringBuilder();
                        string3 = this.c.i();
                        ((StringBuilder)object).append(string3);
                        string3 = " not support rich message.";
                        ((StringBuilder)object).append(string3);
                        object = ((StringBuilder)object).toString();
                        HMSLog.w(string2, (String)object);
                    } else {
                        string3 = "url";
                        object = this.c.i();
                        bl2 = string3.equals(object);
                        if (bl2) {
                            object = new StringBuilder();
                            string3 = this.c.i();
                            ((StringBuilder)object).append(string3);
                            string3 = " not support URL.";
                            ((StringBuilder)object).append(string3);
                            object = ((StringBuilder)object).toString();
                            HMSLog.w(string2, (String)object);
                        } else {
                            object = new StringBuilder();
                            string3 = this.c.i();
                            ((StringBuilder)object).append(string3);
                            string3 = " is not exist in hShowType";
                            ((StringBuilder)object).append(string3);
                            object = ((StringBuilder)object).toString();
                            HMSLog.d(string2, (String)object);
                        }
                    }
                }
            }
            return;
        }
        HMSLog.d(string2, "launchNotify  context or msg is null");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void d() {
        Object object = "com.android.vending";
        CharSequence charSequence = "com.huawei.appmarket";
        String string2 = "android.intent.action.VIEW";
        String string3 = "PushSelfShowLog";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Object object2 = this.c;
            object2 = ((k)object2).n();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                object2 = "&referrer=";
                stringBuilder.append((String)object2);
                object2 = this.c;
                object2 = ((k)object2).n();
                object2 = this.a((String)object2);
                object2 = Uri.encode((String)object2);
                stringBuilder.append((String)object2);
            }
            object2 = new StringBuilder();
            Object object3 = "market://details?id=";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.c;
            object3 = ((k)object3).d();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append((Object)stringBuilder);
            String string4 = ((StringBuilder)object2).toString();
            object2 = new Intent(string2);
            object3 = Uri.parse((String)string4);
            object2.setData((Uri)object3);
            object2.setPackage((String)charSequence);
            object3 = new Intent(string2);
            string2 = Uri.parse((String)string4);
            object3.setData((Uri)string2);
            object3.setPackage((String)object);
            string2 = this.b;
            object = q.a((Context)string2, (String)object, (Intent)object3);
            boolean bl3 = (Boolean)object;
            int n10 = 0x18000000;
            if (bl3) {
                object3.setFlags(n10);
                object = new StringBuilder();
                charSequence = "open google play store's app detail, IntentUrl is:";
                ((StringBuilder)object).append((String)charSequence);
                charSequence = object3.toURI();
                ((StringBuilder)object).append((String)charSequence);
                object = ((StringBuilder)object).toString();
                HMSLog.i(string3, (String)object);
                object = this.b;
                object.startActivity((Intent)object3);
                return;
            }
            object = this.b;
            bl3 = (Boolean)(object = q.a((Context)object, (String)charSequence, (Intent)object2));
            if (bl3) {
                object2.setFlags(n10);
                object = new StringBuilder();
                charSequence = "open HiApp's app detail, IntentUrl is:";
                ((StringBuilder)object).append((String)charSequence);
                charSequence = object2.toURI();
                ((StringBuilder)object).append((String)charSequence);
                object = ((StringBuilder)object).toString();
                HMSLog.i(string3, (String)object);
                object = this.b;
                object.startActivity((Intent)object2);
                return;
            }
            object = "open app detail by browser.";
            HMSLog.i(string3, (String)object);
            this.e();
            return;
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            string2 = "open market app detail failed,exception:";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(exception);
            String string5 = ((StringBuilder)charSequence).toString();
            HMSLog.e(string3, string5);
        }
    }

    /*
     * Loose catch block
     */
    public final void e() {
        String string2;
        Object object;
        String string3;
        CharSequence charSequence;
        CharSequence charSequence2;
        block18: {
            String string4;
            block19: {
                charSequence2 = "parse h_w_hiapp_referrer failed";
                charSequence = "";
                string3 = "PushSelfShowLog";
                object = this.c;
                object = ((k)object).n();
                object = Uri.decode((String)object);
                object = Uri.parse((String)object);
                string2 = "h_w_hiapp_referrer";
                try {
                    string2 = object.getQueryParameter(string2);
                }
                catch (Exception exception) {
                    HMSLog.i(string3, (String)charSequence2);
                    string2 = charSequence;
                }
                string4 = "h_w_gp_referrer";
                try {
                    charSequence = object.getQueryParameter(string4);
                    break block18;
                }
                catch (Exception exception) {
                    try {
                        HMSLog.i(string3, (String)charSequence2);
                        break block18;
                    }
                    catch (Exception exception2) {
                        break block19;
                    }
                }
                {
                    catch (Exception exception) {
                        string2 = charSequence;
                    }
                }
            }
            object = new StringBuilder();
            string4 = "parse intentUri error.";
            ((StringBuilder)object).append(string4);
            charSequence2 = ((Throwable)((Object)charSequence2)).toString();
            ((StringBuilder)object).append((String)charSequence2);
            charSequence2 = ((StringBuilder)object).toString();
            HMSLog.w(string3, (String)charSequence2);
        }
        charSequence2 = null;
        boolean bl2 = Util.isEMUI();
        if (bl2 && (bl2 = Util.isChinaROM())) {
            charSequence = new StringBuilder();
            object = "It is China device, open Huawei market web, referrer: ";
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            HMSLog.i(string3, (String)charSequence);
            charSequence = Uri.decode((String)string2);
            bl2 = URLUtil.isValidUrl((String)charSequence);
            if (bl2) {
                charSequence2 = charSequence;
            } else {
                charSequence = this.b;
                if (charSequence != null) {
                    ResourceLoaderUtil.setmContext((Context)charSequence);
                    charSequence2 = ResourceLoaderUtil.getString("hms_push_vmall");
                }
            }
        } else {
            charSequence2 = new StringBuilder();
            object = "not EMUI system or not in China, open google play web, referrer: ";
            ((StringBuilder)charSequence2).append((String)object);
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            HMSLog.i(string3, (String)charSequence2);
            charSequence2 = Uri.decode((String)charSequence);
            boolean bl3 = URLUtil.isValidUrl((String)charSequence2);
            if (!bl3) {
                ResourceLoaderUtil.setmContext(this.b);
                charSequence2 = new StringBuilder();
                charSequence = ResourceLoaderUtil.getString("hms_push_google");
                ((StringBuilder)charSequence2).append((String)charSequence);
                charSequence = this.c.d();
                ((StringBuilder)charSequence2).append((String)charSequence);
                charSequence2 = ((StringBuilder)charSequence2).toString();
            }
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("open the URL by browser: ");
        ((StringBuilder)charSequence).append((String)charSequence2);
        charSequence = ((StringBuilder)charSequence).toString();
        HMSLog.i(string3, (String)charSequence);
        q.e(this.b, (String)charSequence2);
    }
}

