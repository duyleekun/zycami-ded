/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.view.View
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.tencent.qq.ReceiveActivity;
import cn.sharesdk.tencent.qq.e$1;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.HashMap;

public class e
extends FakeActivity {
    private Platform a;
    private String b;
    private PlatformActionListener c;
    private String d;

    public static int a(String string2, String string3) {
        int n10;
        String[] stringArray;
        int n11;
        int n12;
        block16: {
            n12 = 0;
            if (string2 == null && string3 == null) {
                return 0;
            }
            int n13 = 1;
            if (string2 != null && string3 == null) {
                return n13;
            }
            n11 = -1;
            if (string2 == null && string3 != null) {
                return n11;
            }
            stringArray = "\\.";
            String[] stringArray2 = string2.split((String)stringArray);
            stringArray = string3.split((String)stringArray);
            n10 = 0;
            while (true) {
                int n14 = stringArray2.length;
                if (n10 >= n14) break;
                n14 = stringArray.length;
                if (n10 >= n14) break;
                String string4 = stringArray2[n10];
                n14 = Integer.parseInt(string4);
                String string5 = stringArray[n10];
                int n15 = Integer.parseInt(string5);
                if (n14 < n15) {
                    return n11;
                }
                if (n14 > n15) {
                    return n13;
                }
                ++n10;
                continue;
                break;
            }
            try {
                int n16 = stringArray2.length;
                if (n16 <= n10) break block16;
                return n13;
            }
            catch (NumberFormatException numberFormatException) {
                return string2.compareTo(string3);
            }
        }
        int n17 = stringArray.length;
        if (n17 > n10) {
            n12 = n11;
        }
        return n12;
    }

    public static /* synthetic */ Activity a(e e10) {
        return e10.activity;
    }

    public static /* synthetic */ void a(e e10, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, int n10, String string10, String string11, String string12, int n11) {
        e10.b(string2, string3, string4, string5, string6, string7, string8, string9, n10, string10, string11, string12, n11);
    }

    private void a(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, int n10, String string10, String string11, String string12, int n11) {
        this.b(string2, string3, string4, string5, string6, string7, string8, string9, n10, string10, string11, string12, n11);
    }

    private int[] a() {
        Object object = MobSDK.getContext();
        object = object.getPackageManager();
        Object object2 = "com.tencent.mobileqq";
        object = object.getPackageInfo((String)object2, 0);
        try {
            object = ((PackageInfo)object).versionName;
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
            object = "0";
        }
        object2 = "\\.";
        object = ((String)object).split((String)object2);
        int n10 = ((Object)object).length;
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = object[i10];
            int n11 = ResHelper.parseInt((String)object3);
            try {
                nArray[i10] = n11;
                continue;
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                nLog.d(throwable);
                nArray[i10] = 0;
            }
        }
        return nArray;
    }

    public static int b(String string2) {
        return e.a(e.c("com.tencent.mobileqq"), string2);
    }

    private void b(String string2, String object, String objectArray, String objectArray2, String object2, String charSequence, String string3, String string4, int n10, String string5, String string6, String string7, int n11) {
        block20: {
            Object object3;
            Object object4;
            Object object5;
            int n12;
            block19: {
                block18: {
                    string2 = this.c(string2, (String)object, (String)objectArray, (String)objectArray2, (String)object2, (String)charSequence, string3, string4, n10, string5, string6, string7, n11);
                    object = new Intent("android.intent.action.VIEW");
                    objectArray = Uri.parse((String)string2);
                    object.setData((Uri)objectArray);
                    objectArray = SSDKLog.b();
                    n12 = 1;
                    object2 = new Object[n12];
                    charSequence = new StringBuilder();
                    string3 = " QQ ShareActivity advancedShare scheme: ";
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append(string2);
                    string2 = ((StringBuilder)charSequence).toString();
                    charSequence = null;
                    object2[0] = string2;
                    string2 = "ShareSDK";
                    objectArray.d(string2, (Object[])object2);
                    objectArray = this.a();
                    object2 = this.b;
                    ReceiveActivity.setUriScheme((String)object2);
                    object2 = this.c;
                    ReceiveActivity.setPlatformActionListener((PlatformActionListener)object2);
                    object5 = objectArray.length;
                    if (object5 <= n12) break block18;
                    object5 = objectArray[0];
                    object4 = 4;
                    if (object5 >= object4) break block19;
                    object3 = objectArray[n12];
                    object5 = 6;
                    if (object3 >= object5) break block19;
                }
                objectArray = "key_request_code";
                object.putExtra((String)objectArray, 0);
            }
            objectArray = "pkg_name";
            object2 = this.activity;
            object2 = object2.getPackageName();
            object.putExtra((String)objectArray, (String)object2);
            objectArray = this.activity;
            object5 = 256;
            objectArray.startActivityForResult((Intent)object, object5);
            int n13 = Build.VERSION.SDK_INT;
            object3 = 28;
            if (n13 < object3) break block20;
            object = SSDKLog.b();
            objectArray = new Object[n12];
            object2 = " QQ ShareActivity Build.VERSION.SDK_INT >= 28 activity.finish ";
            objectArray[0] = object2;
            ((NLog)object).d(string2, objectArray);
            object = this.activity;
            try {
                object.finish();
            }
            catch (Throwable throwable) {
                objectArray = this.c;
                if (objectArray != null) {
                    object2 = this.a;
                    object4 = 9;
                    objectArray.onError((Platform)object2, (int)object4, throwable);
                }
                objectArray = SSDKLog.b();
                objectArray2 = new Object[n12];
                object2 = new StringBuilder();
                string3 = " QQ ShareActivity catch ";
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(throwable);
                String string8 = ((StringBuilder)object2).toString();
                objectArray2[0] = string8;
                objectArray.d(string2, objectArray2);
                string2 = this.activity;
                string2.finish();
            }
        }
    }

    public static String c(String string2) {
        PackageManager packageManager = MobSDK.getContext().getPackageManager();
        try {
            string2 = packageManager.getPackageInfo(string2, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
        return ((PackageInfo)string2).versionName;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private String c(String var1_1, String var2_2, String var3_3, String var4_4, String var5_5, String var6_6, String var7_7, String var8_8, int var9_9, String var10_10, String var11_11, String var12_12, int var13_13) {
        block48: {
            var14_14 = var4_4;
            var15_15 = TextUtils.isEmpty((CharSequence)var4_4);
            var16_16 = "";
            if (var15_15) ** GOTO lbl24
            var15_15 = TextUtils.isEmpty((CharSequence)var5_5);
            if (!var15_15) {
                var17_17 = var5_5;
            } else {
                block49: {
                    var17_17 = "https";
                    var15_15 = var4_4.startsWith((String)var17_17);
                    if (var15_15) {
                        try {
                            var17_17 = this.activity;
                        }
                        catch (Throwable var17_18) {
                            var16_16 = SSDKLog.b();
                            var16_16.d(var17_18);
                            var15_15 = false;
                            var17_17 = null;
                            break block49;
                        }
                        var17_17 = BitmapHelper.downloadBitmap((Context)var17_17, (String)var4_4);
                        break block48;
                    }
lbl24:
                    // 3 sources

                    var17_17 = var5_5;
                }
                var16_16 = var14_14;
            }
        }
        var18_20 = TextUtils.isEmpty((CharSequence)var16_16);
        var19_21 = 2;
        var20_22 = "mqqapi://share/to_fri?src_type=app&version=1&file_type=news";
        if (var18_20 == 0) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&image_url=");
            var16_16 = Base64.encodeToString((byte[])var16_16.getBytes(), (int)var19_21);
            var14_14.append((String)var16_16);
            var20_22 = var14_14.toString();
        }
        if ((var18_20 = TextUtils.isEmpty((CharSequence)var1_1)) == 0) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&title=");
            var16_16 = Base64.encodeToString((byte[])var1_1.getBytes(), (int)var19_21);
            var14_14.append((String)var16_16);
            var20_22 = var14_14.toString();
        }
        if ((var18_20 = TextUtils.isEmpty((CharSequence)var3_3)) == 0) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&description=");
            var16_16 = Base64.encodeToString((byte[])var3_3.getBytes(), (int)var19_21);
            var14_14.append((String)var16_16);
            var20_22 = var14_14.toString();
        }
        var18_20 = TextUtils.isEmpty((CharSequence)var7_7);
        var16_16 = null;
        if (var18_20 == 0) {
            var18_20 = var7_7.length();
            if (var18_20 > (var21_23 = 20)) {
                var14_14 = new StringBuilder();
                var22_24 /* !! */  = var7_7;
                var23_25 = var7_7.substring(0, var21_23);
                var14_14.append((String)var23_25);
                var23_25 = "...";
                var14_14.append((String)var23_25);
                var14_14 = var14_14.toString();
                var22_24 /* !! */  = var14_14;
            } else {
                var22_24 /* !! */  = var7_7;
            }
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&app_name=");
            var20_22 = Base64.encodeToString((byte[])var22_24 /* !! */ .getBytes(), (int)var19_21);
            var14_14.append((String)var20_22);
            var20_22 = var14_14.toString();
        }
        if ((var18_20 = (int)TextUtils.isEmpty((CharSequence)var8_8)) == 0) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&share_id=");
            var20_22 = var8_8;
            var14_14.append(var8_8);
            var20_22 = var14_14.toString();
        }
        if ((var18_20 = (int)TextUtils.isEmpty((CharSequence)var2_2)) == 0) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&url=");
            var20_22 = Base64.encodeToString((byte[])var2_2.getBytes(), (int)var19_21);
            var14_14.append((String)var20_22);
            var20_22 = var14_14.toString();
        }
        if ((var18_20 = (int)TextUtils.isEmpty((CharSequence)var3_3)) == 0) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&share_qq_ext_str=");
            var20_22 = Base64.encodeToString((byte[])var3_3.getBytes(), (int)var19_21);
            var14_14.append((String)var20_22);
            var20_22 = var14_14.toString();
        }
        var18_20 = 15;
        var23_25 = "&req_type=";
        if (var13_13 == var18_20) {
            var18_20 = (int)TextUtils.isEmpty((CharSequence)var10_10);
            if (var18_20 == 0 && (var18_20 = (int)TextUtils.isEmpty((CharSequence)var11_11)) == 0) {
                var14_14 = new StringBuilder();
                var14_14.append((String)var20_22);
                var14_14.append((String)var23_25);
                var20_22 = Base64.encodeToString((byte[])"7".getBytes(), (int)var19_21);
                var14_14.append((String)var20_22);
                var20_22 = var14_14.toString();
            }
        } else {
            var18_20 = (int)TextUtils.isEmpty((CharSequence)var1_1);
            if (var18_20 != 0 && (var18_20 = (int)TextUtils.isEmpty((CharSequence)var3_3)) != 0 && (var18_20 = (int)TextUtils.isEmpty((CharSequence)var2_2)) != 0 && (var18_20 = (int)TextUtils.isEmpty((CharSequence)var17_17)) == 0) {
                var14_14 = new StringBuilder();
                var14_14.append((String)var20_22);
                var14_14.append((String)var23_25);
                var20_22 = Base64.encodeToString((byte[])"5".getBytes(), (int)var19_21);
                var14_14.append((String)var20_22);
                var20_22 = var14_14.toString();
            } else {
                var18_20 = (int)TextUtils.isEmpty((CharSequence)var1_1);
                if (var18_20 == 0 && (var18_20 = (int)TextUtils.isEmpty((CharSequence)var3_3)) == 0 && (var18_20 = (int)TextUtils.isEmpty((CharSequence)var2_2)) != 0) {
                    var14_14 = new StringBuilder();
                    var14_14.append((String)var20_22);
                    var14_14.append((String)var23_25);
                    var20_22 = Base64.encodeToString((byte[])"6".getBytes(), (int)var19_21);
                    var14_14.append((String)var20_22);
                    var20_22 = var14_14.toString();
                } else {
                    var18_20 = (int)TextUtils.isEmpty((CharSequence)var6_6);
                    if (var18_20 == 0) {
                        var14_14 = new StringBuilder();
                        var14_14.append((String)var20_22);
                        var14_14.append((String)var23_25);
                        var20_22 = Base64.encodeToString((byte[])"2".getBytes(), (int)var19_21);
                        var14_14.append((String)var20_22);
                        var14_14 = var14_14.toString();
                        var20_22 = new StringBuilder();
                        var20_22.append((String)var14_14);
                        var20_22.append("&audioUrl=");
                        var14_14 = Base64.encodeToString((byte[])var6_6.getBytes(), (int)var19_21);
                        var20_22.append((String)var14_14);
                        var20_22 = var20_22.toString();
                    } else {
                        var14_14 = new StringBuilder();
                        var14_14.append((String)var20_22);
                        var14_14.append((String)var23_25);
                        var20_22 = Base64.encodeToString((byte[])"1".getBytes(), (int)var19_21);
                        var14_14.append((String)var20_22);
                        var20_22 = var14_14.toString();
                    }
                }
            }
        }
        if ((var18_20 = (int)TextUtils.isEmpty((CharSequence)var10_10)) == 0) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&mini_program_appid=");
            var20_22 = Base64.encodeToString((byte[])var10_10.getBytes(), (int)var19_21);
            var14_14.append((String)var20_22);
            var20_22 = var14_14.toString();
        }
        if ((var18_20 = (int)TextUtils.isEmpty((CharSequence)var11_11)) == 0) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&mini_program_path=");
            var20_22 = Base64.encodeToString((byte[])var11_11.getBytes(), (int)var19_21);
            var14_14.append((String)var20_22);
            var20_22 = var14_14.toString();
        }
        if ((var18_20 = (int)TextUtils.isEmpty((CharSequence)var12_12)) == 0) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var20_22);
            var14_14.append("&mini_program_type=");
            var20_22 = Base64.encodeToString((byte[])var12_12.getBytes(), (int)var19_21);
            var14_14.append((String)var20_22);
            var20_22 = var14_14.toString();
        }
        var18_20 = Build.VERSION.SDK_INT;
        var21_23 = 29;
        var22_24 /* !! */  = "ShareSDK";
        var24_26 = 1;
        if (var18_20 >= var21_23) {
            var18_20 = (int)TextUtils.isEmpty((CharSequence)var17_17);
            if (var18_20 == 0) {
                var14_14 = new File((String)var17_17);
                var17_17 = MobSDK.getContext();
                var23_25 = new StringBuilder();
                var25_27 = MobSDK.getContext();
                var25_27 = var25_27.getPackageName();
                var23_25.append((String)var25_27);
                var25_27 = ".cn.sharesdk.ShareSDKFileProvider";
                var23_25.append((String)var25_27);
                var23_25 = var23_25.toString();
                var17_17 = ShareSDKFileProvider.a((Context)var17_17, (String)var23_25, (File)var14_14);
                var14_14 = MobSDK.getContext();
                var23_25 = "com.tencent.mobileqq";
                var26_28 = 3;
                var14_14.grantUriPermission((String)var23_25, (Uri)var17_17, var26_28);
                var14_14 = new StringBuilder();
                var14_14.append((String)var20_22);
                var23_25 = "&file_uri=";
                var14_14.append((String)var23_25);
                var17_17 = var17_17.toString();
                var17_17 = var17_17.getBytes();
                var17_17 = Base64.encodeToString((byte[])var17_17, (int)var19_21);
                try {
                    var14_14.append((String)var17_17);
                    var20_22 = var14_14.toString();
                }
                catch (Exception var17_19) {
                    var14_14 = SSDKLog.b();
                    var23_25 = new Object[var24_26];
                    var25_27 = new StringBuilder();
                    var27_29 = "doShareToQQ() getUriForFile exception:";
                    var25_27.append(var27_29);
                    var25_27.append(var17_19);
                    var23_25[0] = var17_17 = var25_27.toString();
                    var14_14.d(var22_24 /* !! */ , (Object[])var23_25);
                }
            }
        } else {
            var18_20 = (int)TextUtils.isEmpty((CharSequence)var17_17);
            if (var18_20 == 0) {
                var14_14 = new StringBuilder();
                var14_14.append((String)var20_22);
                var14_14.append("&file_data=");
                var17_17 = Base64.encodeToString((byte[])var17_17.getBytes(), (int)var19_21);
                var14_14.append((String)var17_17);
                var20_22 = var14_14.toString();
            }
        }
        var18_20 = var9_9;
        var17_17 = var9_9 == var24_26 ? "10" : "00";
        var14_14 = new StringBuilder();
        var14_14.append((String)var20_22);
        var14_14.append("&cflag=");
        var17_17 = Base64.encodeToString((byte[])var17_17.getBytes(), (int)var19_21);
        var14_14.append((String)var17_17);
        var17_17 = var14_14.toString();
        var14_14 = SSDKLog.b();
        var28_30 = new Object[var24_26];
        var20_22 = new StringBuilder();
        var20_22.append("QQ share params: ");
        var20_22.append((String)var17_17);
        var20_22 = var20_22.toString();
        var28_30[0] = var20_22;
        var14_14.d(var22_24 /* !! */ , var28_30);
        return var17_17;
    }

    public void a(Platform platform, PlatformActionListener platformActionListener) {
        this.a = platform;
        this.c = platformActionListener;
    }

    public void a(String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("tencent");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        this.b = charSequence;
        this.d = string2;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        int n12 = 256;
        if (n10 == n12 && n11 == 0 && (n10 = Build.VERSION.SDK_INT) < (n11 = 28)) {
            PlatformActionListener platformActionListener = this.c;
            Platform platform = this.a;
            n12 = 9;
            platformActionListener.onCancel(platform, n12);
        }
        this.activity.finish();
    }

    public void onCreate() {
        e e10 = this;
        Object object = SSDKLog.b();
        int n10 = 1;
        Object object2 = new Object[n10];
        int n11 = 0;
        String string2 = " QQ ShareActivity onCreate";
        object2[0] = string2;
        String string3 = "ShareSDK";
        ((NLog)object).d(string3, (Object[])object2);
        object2 = this.activity;
        object = new Object((Context)object2);
        object.setOrientation(n10);
        Object object3 = this.activity;
        try {
            object3.setContentView((View)object);
        }
        catch (Exception exception) {
            object3 = SSDKLog.b();
            ((NLog)object3).d(exception);
        }
        object = e10.activity.getIntent().getExtras();
        string2 = object.getString("title");
        String string4 = object.getString("titleUrl");
        String string5 = object.getString("summary");
        String string6 = object.getString("imageUrl");
        String string7 = object.getString("musicUrl");
        String string8 = DeviceHelper.getInstance((Context)e10.activity).getAppName();
        String string9 = object.getString("appId");
        int n12 = object.getInt("hidden");
        String string10 = object.getString("imagePath");
        String string11 = object.getString("mini_program_appid");
        String string12 = object.getString("mini_program_path");
        String string13 = object.getString("mini_program_type");
        object3 = "share_type";
        int n13 = object.getInt((String)object3);
        n10 = 15;
        if (n13 == n10) {
            object3 = "8.0.8";
            n10 = e.b((String)object3);
            n11 = 9;
            if (n10 < 0) {
                object = e10.c;
                if (object != null) {
                    object3 = e10.a;
                    string2 = "808\u4ee5\u4e0b\u4e0d\u652f\u6301\u5206\u4eab\u5c0f\u7a0b\u5e8f";
                    object2 = new Throwable(string2);
                    object.onError((Platform)object3, n11, (Throwable)object2);
                }
                return;
            }
            object3 = this;
            object2 = string2;
            string3 = string4;
            string2 = string5;
            string4 = string6;
            string5 = string10;
            string6 = string7;
            string7 = string8;
            string8 = string9;
            String string14 = string11;
            string10 = string12;
            string11 = string13;
            this.a((String)object2, string3, string2, string4, string5, string6, string7, string9, n12, string14, string12, string13, n13);
            object = e10.c;
            if (object != null) {
                object = new Object();
                object3 = e10.c;
                object2 = e10.a;
                n11 = 9;
                object3.onComplete((Platform)object2, n11, (HashMap)object);
            }
        } else {
            n10 = (int)(TextUtils.isEmpty((CharSequence)string11) ? 1 : 0);
            if (n10 != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string12) ? 1 : 0)) != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string13) ? 1 : 0)) != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string5) ? 1 : 0)) != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string4) ? 1 : 0)) != 0 && ((n10 = (int)(TextUtils.isEmpty((CharSequence)string10) ? 1 : 0)) != 0 || (n10 = (int)(((File)(object3 = new File(string10))).exists() ? 1 : 0)) == 0) && (n10 = (int)(TextUtils.isEmpty((CharSequence)string6) ? 1 : 0)) == 0) {
                e$1 e$1;
                object3 = e$1;
                object2 = this;
                string3 = string6;
                string6 = string7;
                string7 = string8;
                string8 = string9;
                String string15 = string11;
                string10 = string12;
                string11 = string13;
                e$1 = new e$1(this, string3, string2, string4, string5, string6, string7, string9, n12, string15, string12, string13, n13);
                e$1.start();
            } else {
                object3 = this;
                object2 = string2;
                string3 = string4;
                string2 = string5;
                string4 = string6;
                string5 = string10;
                string6 = string7;
                string7 = string8;
                string8 = string9;
                String string16 = string11;
                string10 = string12;
                string11 = string13;
                this.b((String)object2, string3, string2, string4, string5, string6, string7, string9, n12, string16, string12, string13, n13);
            }
        }
    }
}

