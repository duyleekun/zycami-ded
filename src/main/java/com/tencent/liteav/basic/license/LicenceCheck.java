/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.os.Environment
 *  android.os.Process
 *  android.text.TextUtils
 *  android.util.Base64
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tencent.liteav.basic.license;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.license.LicenceCheck$1;
import com.tencent.liteav.basic.license.LicenceCheck$a;
import com.tencent.liteav.basic.license.c;
import com.tencent.liteav.basic.license.f;
import com.tencent.liteav.basic.license.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.d;
import java.io.File;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class LicenceCheck {
    private static LicenceCheck d;
    private Context a;
    private String b = "YTFaceSDK.licence";
    private String c = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";
    private LicenceCheck$a e;
    private LicenceCheck$a f;

    private LicenceCheck() {
        LicenceCheck$a licenceCheck$a;
        this.e = licenceCheck$a = new LicenceCheck$a(this, "TXUgcSDK.licence");
        this.f = licenceCheck$a = new LicenceCheck$a(this, "TXLiveSDK.licence");
    }

    private int a(LicenceCheck$a licenceCheck$a, Context context) {
        boolean bl2 = licenceCheck$a.g;
        if (bl2) {
            return 0;
        }
        Context context2 = this.a;
        if (context2 == null) {
            this.a = context;
        }
        int n10 = this.d(licenceCheck$a);
        bl2 = true;
        if (n10 == 0) {
            licenceCheck$a.g = bl2;
            return 0;
        }
        n10 = this.c(licenceCheck$a);
        if (n10 == 0) {
            licenceCheck$a.g = bl2;
            return 0;
        }
        return n10;
    }

    private int a(LicenceCheck$a object, f f10, Context context) {
        int n10 = this.a((LicenceCheck$a)object, context);
        if (n10 != 0) {
            this.a((LicenceCheck$a)object);
        }
        if (f10 != null) {
            f10.a = object = ((LicenceCheck$a)object).i;
        }
        return n10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int a(LicenceCheck$a var1_1, String var2_5, String var3_6) {
        block63: {
            block59: {
                block58: {
                    var4_8 = "LicenceCheck";
                    var5_9 = this.c;
                    var5_9 = this.a((String)var5_9);
                    var6_10 = Base64.decode((String)var2_5, (int)0);
                    var3_6 = Base64.decode((String)var3_6, (int)0);
                    try {
                        var7_11 = LicenceCheck.a((byte[])var6_10, (byte[])var3_6, (PublicKey)var5_9);
                    }
                    catch (Exception var3_7) {
                        var3_7.printStackTrace();
                        var5_9 = new StringBuilder();
                        var6_10 = "verifyLicence, exception is : ";
                        var5_9.append((String)var6_10);
                        var5_9.append(var3_7);
                        var3_6 = var5_9.toString();
                        TXCLog.e(var4_8, (String)var3_6);
                        var7_11 = 0;
                        var3_6 = null;
                    }
                    if (var7_11 == 0) {
                        var8_12 = -2;
                        this.a(var8_12);
                        TXCLog.e(var4_8, "verifyLicence, signature not pass!");
                        return var8_12;
                    }
                    var7_11 = TextUtils.isEmpty((CharSequence)(var2_5 = this.c((LicenceCheck$a)var1_1, (String)var2_5)));
                    if (var7_11 != 0) {
                        var8_13 = -3;
                        this.a(var8_13);
                        TXCLog.e(var4_8, "verifyLicence, decodeValue is empty!");
                        return var8_13;
                    }
                    var1_1.i = var2_5;
                    var7_11 = -1;
                    var5_9 = new JSONObject((String)var2_5);
                    var2_5 = "pituLicense";
                    var2_5 = var5_9.getString((String)var2_5);
                    var6_10 = "appData";
                    var5_9 = var5_9.optJSONArray((String)var6_10);
                    if (var5_9 != null) break block58;
                    var1_1 = "verifyLicence, appDataArray is null!";
                    TXCLog.e(var4_8, (String)var1_1);
                    this.a(var7_11);
                    return var7_11;
                }
                var9_18 = 0;
                var6_10 = null;
                var10_19 = false;
                var11_20 = null;
                var12_21 = false;
                var13_22 = false;
                while (true) {
                    block61: {
                        block62: {
                            block60: {
                                var14_23 = var5_9.length();
                                var15_24 = true;
                                if (var9_18 >= var14_23) break block59;
                                var16_25 /* !! */  = var5_9.getJSONObject(var9_18);
                                var17_26 = "packageName";
                                var17_26 = var16_25 /* !! */ .optString(var17_26);
                                var18_27 /* !! */  = new StringBuilder();
                                var19_28 = "verifyLicence, packageName:";
                                var18_27 /* !! */ .append(var19_28);
                                var18_27 /* !! */ .append(var17_26);
                                var18_27 /* !! */  = var18_27 /* !! */ .toString();
                                TXCLog.i(var4_8, (String)var18_27 /* !! */ );
                                var18_27 /* !! */  = this.a;
                                var18_27 /* !! */  = var18_27 /* !! */ .getPackageName();
                                var20_29 = var17_26.equals(var18_27 /* !! */ );
                                if (var20_29) break block60;
                                var16_25 /* !! */  = "verifyLicence, packageName not match!";
                                TXCLog.e(var4_8, (String)var16_25 /* !! */ );
                                break block61;
                            }
                            var11_20 = "endDate";
                            var11_20 = var16_25 /* !! */ .optString(var11_20);
                            var10_19 = this.d(var11_20);
                            if (!var10_19) break block62;
                            var10_19 = var15_24;
                            break block61;
                        }
                        var13_22 = this.a((LicenceCheck$a)var1_1, var16_25 /* !! */ , (String)var2_5);
                        if (var13_22) break;
                        var10_19 = var15_24;
                        var12_21 = var15_24;
                    }
                    ++var9_18;
                }
                var10_19 = var15_24;
                var12_21 = var15_24;
                var13_22 = var15_24;
            }
            if (!var10_19) {
                var8_14 = -4;
                this.a(var8_14);
                return var8_14;
            }
            if (!var12_21) {
                var8_15 = -5;
                this.a(var8_15);
                return var8_15;
            }
            if (!var13_22) {
                var8_16 = -11;
                this.a(var8_16);
                return var8_16;
            }
            var8_17 = TextUtils.isEmpty((CharSequence)var2_5);
            if (var8_17) ** GOTO lbl191
            {
                catch (JSONException var1_3) {
                    var1_3.printStackTrace();
                    var2_5 = new StringBuilder();
                    var2_5.append("verifyLicence, json format error ! exception = ");
                    var2_5.append((Object)var1_3);
                    var1_4 = var2_5.toString();
                    TXCLog.e(var4_8, var1_4);
                    this.a(var7_11);
                    return var7_11;
                }
            }
            var1_1 = Base64.decode((String)var2_5, (int)0);
            var2_5 = this.a;
            var5_9 = null;
            var2_5 = var2_5.getExternalFilesDir(null);
            if (var2_5 != null) break block63;
            return -10;
        }
        var2_5 = var2_5.getAbsolutePath();
        var6_10 = new StringBuilder();
        var6_10.append((String)var2_5);
        var2_5 = File.separator;
        var6_10.append((String)var2_5);
        var2_5 = this.b;
        var6_10.append((String)var2_5);
        var2_5 = var6_10.toString();
        var5_9 = new File((String)var2_5);
        var2_5 = var5_9.getAbsolutePath();
        com.tencent.liteav.basic.util.d.a((String)var2_5, (byte[])var1_1);
        var1_1 = var5_9.getAbsolutePath();
        try {
            TXCCommonUtil.setPituLicencePath((String)var1_1);
            ** GOTO lbl191
        }
        catch (Exception var1_2) {
            var2_5 = new StringBuilder();
            var5_9 = "decode pitu license error:";
            var2_5.append((String)var5_9);
            var2_5.append(var1_2);
            var1_1 = var2_5.toString();
            TXCLog.e(var4_8, (String)var1_1);
lbl191:
            // 3 sources

            var1_1 = this.a;
        }
        var21_30 = com.tencent.liteav.basic.datareport.a.aJ;
        TXCDRApi.txReportDAU((Context)var1_1, var21_30);
        return 0;
    }

    public static LicenceCheck a() {
        LicenceCheck licenceCheck = d;
        if (licenceCheck == null) {
            d = licenceCheck = new LicenceCheck();
        }
        return d;
    }

    private static String a(Context object) {
        boolean bl2;
        int n10 = Process.myPid();
        String string2 = "activity";
        object = ((ActivityManager)object.getSystemService(string2)).getRunningAppProcesses().iterator();
        while (bl2 = object.hasNext()) {
            string2 = (ActivityManager.RunningAppProcessInfo)object.next();
            int n11 = ((ActivityManager.RunningAppProcessInfo)string2).pid;
            if (n11 != n10) continue;
            return ((ActivityManager.RunningAppProcessInfo)string2).processName;
        }
        return "";
    }

    public static /* synthetic */ String a(LicenceCheck licenceCheck, LicenceCheck$a licenceCheck$a) {
        return licenceCheck.h(licenceCheck$a);
    }

    private void a(int n10) {
        Context context = this.a;
        int n11 = com.tencent.liteav.basic.datareport.a.aK;
        TXCDRApi.txReportDAU(context, n11, n10, "");
    }

    private void a(LicenceCheck$a licenceCheck$a, Context object, String string2, String string3) {
        boolean bl2;
        if (object != null) {
            Context context;
            this.a = context = object.getApplicationContext();
            TXCCommonUtil.setAppContext((Context)object);
        }
        licenceCheck$a.d = string3;
        licenceCheck$a.e = string2;
        object = this.a;
        if (object != null && (bl2 = this.c())) {
            object = this.a;
            string2 = null;
            if ((object = object.getExternalFilesDir(null)) != null) {
                licenceCheck$a.c = object = ((File)object).getAbsolutePath();
            }
            object = new StringBuilder();
            string2 = licenceCheck$a.c;
            ((StringBuilder)object).append(string2);
            string2 = File.separator;
            ((StringBuilder)object).append(string2);
            string2 = licenceCheck$a.a;
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            bl2 = this.b((String)object);
            if (!bl2) {
                string2 = "setLicense, sdcard file not exist, to download";
                TXCLog.i("LicenceCheck", string2);
                object = "";
                this.b(licenceCheck$a, (String)object);
            }
            this.a(licenceCheck$a);
        }
    }

    public static /* synthetic */ void a(LicenceCheck licenceCheck, LicenceCheck$a licenceCheck$a, String string2) {
        licenceCheck.b(licenceCheck$a, string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(LicenceCheck$a object, JSONObject object2, String string2) {
        int n10 = object2.optInt("feature");
        LicenceCheck$a licenceCheck$a = this.f;
        String string3 = "LicenceCheck";
        int n11 = 1;
        int n12 = 0;
        if (object == licenceCheck$a) {
            if ((n10 = n10 >> 4 & 0xF) >= n11) {
                ((LicenceCheck$a)object).h = n10;
            } else {
                n11 = 0;
            }
            object2 = new StringBuilder();
            string2 = "live parseVersionType, mLicenceVersionType = ";
            ((StringBuilder)object2).append(string2);
            int n13 = ((LicenceCheck$a)object).h;
            ((StringBuilder)object2).append(n13);
            object = ((StringBuilder)object2).toString();
            TXCLog.i(string3, (String)object);
            return n11 != 0;
        }
        licenceCheck$a = this.e;
        if (object != licenceCheck$a) return n12 != 0;
        int n14 = n10 & 0xF;
        if (n14 <= n11) {
            if (n14 != n11 && n10 != 0) {
                n11 = 0;
            } else {
                n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
                ((LicenceCheck$a)object).h = n10 == 0 ? (n10 = 5) : (n10 = 3);
            }
        } else {
            ((LicenceCheck$a)object).h = n14;
        }
        object2 = new StringBuilder();
        string2 = "ugc parseVersionType, mLicenceVersionType = ";
        ((StringBuilder)object2).append(string2);
        int n15 = ((LicenceCheck$a)object).h;
        ((StringBuilder)object2).append(n15);
        object = ((StringBuilder)object2).toString();
        TXCLog.i(string3, (String)object);
        return n11 != 0;
    }

    public static boolean a(byte[] byArray, byte[] byArray2, PublicKey publicKey) {
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initVerify(publicKey);
        signature.update(byArray);
        return signature.verify(byArray2);
    }

    public static /* synthetic */ int b(LicenceCheck licenceCheck, LicenceCheck$a licenceCheck$a, String string2) {
        return licenceCheck.d(licenceCheck$a, string2);
    }

    private String b(LicenceCheck$a object) {
        Context context = this.a;
        if (context == null) {
            return null;
        }
        context = context.getSharedPreferences("LicenceCheck.lastModified", 0);
        StringBuilder stringBuilder = new StringBuilder();
        object = ((LicenceCheck$a)object).a;
        stringBuilder.append((String)object);
        stringBuilder.append(".lastModified");
        object = stringBuilder.toString();
        return context.getString((String)object, null);
    }

    private void b(LicenceCheck$a object, String string2) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        context = context.getSharedPreferences("LicenceCheck.lastModified", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        object = ((LicenceCheck$a)object).a;
        stringBuilder.append((String)object);
        stringBuilder.append(".lastModified");
        object = stringBuilder.toString();
        context.putString((String)object, string2);
        context.commit();
    }

    public static /* synthetic */ void b(LicenceCheck licenceCheck, LicenceCheck$a licenceCheck$a) {
        licenceCheck.f(licenceCheck$a);
    }

    private boolean b(String string2) {
        return com.tencent.liteav.basic.util.d.a(string2);
    }

    private int c(LicenceCheck$a licenceCheck$a) {
        Object object = Environment.getExternalStorageState();
        CharSequence charSequence = "mounted";
        boolean bl2 = ((String)object).equals(charSequence);
        int n10 = -10;
        String string2 = "LicenceCheck";
        if (!bl2) {
            TXCLog.e(string2, "checkSdcardLicence, sdcard not mounted yet!");
            return n10;
        }
        object = this.a.getExternalFilesDir(null);
        if (object == null) {
            TXCLog.e(string2, "checkSdcardLicence, mContext.getExternalFilesDir is null!");
            return n10;
        }
        charSequence = new StringBuilder();
        object = ((File)object).getAbsolutePath();
        ((StringBuilder)charSequence).append((String)object);
        object = File.separator;
        ((StringBuilder)charSequence).append((String)object);
        object = licenceCheck$a.a;
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        n10 = (int)(this.b((String)object) ? 1 : 0);
        if (n10 == 0) {
            return -7;
        }
        try {
            object = com.tencent.liteav.basic.util.d.b((String)object);
        }
        catch (Exception exception) {
            charSequence = "read licence file error: ";
            TXCLog.e(string2, (String)charSequence, exception);
            object = "";
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 != 0) {
            TXCLog.e(string2, "checkSdcardLicence, licenceSdcardStr is empty");
            return -8;
        }
        return this.a(licenceCheck$a, (String)object);
    }

    private static long c(String object) {
        SimpleDateFormat simpleDateFormat;
        String string2 = "yyyy-MM-dd";
        try {
            simpleDateFormat = new SimpleDateFormat(string2);
        }
        catch (Exception exception) {
            TXCLog.e("LicenceCheck", "time str to millsecond failed.", exception);
            return -1;
        }
        object = simpleDateFormat.parse((String)object);
        return ((Date)object).getTime();
    }

    private String c(LicenceCheck$a object, String object2) {
        Object object3 = ((LicenceCheck$a)object).d;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        String string2 = "LicenceCheck";
        if (bl2) {
            TXCLog.e(string2, "decodeLicence, mKey is empty!!!");
            return "";
        }
        object = ((LicenceCheck$a)object).d.getBytes();
        object3 = new SecretKeySpec((byte[])object, "AES");
        object = this.nativeIvParameterSpec((byte[])object);
        IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object);
        object = Base64.decode((String)object2, (int)0);
        object2 = "AES/CBC/PKCS5Padding";
        object2 = Cipher.getInstance((String)object2);
        int n10 = 2;
        ((Cipher)object2).init(n10, (Key)object3, ivParameterSpec);
        object = ((Cipher)object2).doFinal((byte[])object);
        object3 = "UTF-8";
        object2 = new String((byte[])object, (String)object3);
        object = new StringBuilder();
        object3 = "decodeLicence : ";
        ((StringBuilder)object).append((String)object3);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        try {
            TXCLog.i(string2, (String)object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object2 = null;
        }
        return object2;
    }

    private boolean c() {
        Object object = Environment.getExternalStorageState();
        boolean bl2 = ((String)object).equals("mounted");
        String string2 = "LicenceCheck";
        if (!bl2) {
            TXCLog.e(string2, "checkSdcardLicence, sdcard not mounted yet!");
            return false;
        }
        object = this.a.getExternalFilesDir(null);
        if (object == null) {
            TXCLog.e(string2, "checkSdcardLicence, mContext.getExternalFilesDir is null!");
            return false;
        }
        return true;
    }

    private int d(LicenceCheck$a licenceCheck$a) {
        boolean bl2 = this.e(licenceCheck$a);
        if (!bl2) {
            return -6;
        }
        Object object = this.a;
        String string2 = licenceCheck$a.a;
        boolean bl3 = TextUtils.isEmpty((CharSequence)(object = com.tencent.liteav.basic.util.d.b(object, string2)));
        if (bl3) {
            TXCLog.e("LicenceCheck", "checkAssetLicence, licenceSdcardStr is empty");
            return -8;
        }
        return this.a(licenceCheck$a, (String)object);
    }

    private int d(LicenceCheck$a licenceCheck$a, String charSequence) {
        Object object;
        String string2 = "LicenceCheck";
        try {
            object = new JSONObject((String)charSequence);
            charSequence = "appId";
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            int n10 = -1;
            this.a(n10);
            return n10;
        }
        int n11 = object.optInt((String)charSequence);
        String string3 = "encryptedLicense";
        string3 = object.getString(string3);
        CharSequence charSequence2 = "signature";
        object = object.getString((String)charSequence2);
        charSequence2 = new StringBuilder();
        String string4 = "appid:";
        ((StringBuilder)charSequence2).append(string4);
        ((StringBuilder)charSequence2).append(n11);
        charSequence = ((StringBuilder)charSequence2).toString();
        TXCLog.i(string2, (String)charSequence);
        charSequence = new StringBuilder();
        charSequence2 = "encryptedLicense:";
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i(string2, (String)charSequence);
        charSequence = new StringBuilder();
        charSequence2 = "signature:";
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i(string2, (String)charSequence);
        return this.a(licenceCheck$a, string3, (String)object);
    }

    private boolean d(String string2) {
        long l10 = LicenceCheck.c(string2);
        long l11 = 0L;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = true;
        String string3 = "LicenceCheck";
        if (object < 0) {
            TXCLog.e(string3, "checkEndDate, end date millis < 0!");
            return bl2;
        }
        long l12 = System.currentTimeMillis();
        long l13 = l10 - l12;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            TXCLog.e(string3, "checkEndDate, end date expire!");
            return bl2;
        }
        return false;
    }

    private int e(LicenceCheck$a object, String string2) {
        int n10;
        JSONObject jSONObject;
        block13: {
            int n11;
            string2 = this.e(string2);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            String string3 = "LicenceCheck";
            if (bl2) {
                TXCLog.e(string3, "verifyOldLicence, decryptStr is empty");
                return -3;
            }
            ((LicenceCheck$a)object).i = string2;
            try {
                jSONObject = new JSONObject(string2);
                string2 = "packagename";
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                TXCLog.e(string3, "verifyOldLicence, json format error !");
                n11 = -1;
                this.a(n11);
                return n11;
            }
            string2 = jSONObject.getString(string2);
            Object object2 = this.a;
            object2 = LicenceCheck.a(object2);
            n10 = string2.equals(object2);
            if (n10 != 0) break block13;
            object = "packagename not match!";
            TXCLog.e(string3, (String)object);
            n11 = -4;
            this.a(n11);
            return n11;
        }
        string2 = "enddate";
        string2 = jSONObject.getString(string2);
        n10 = this.d(string2);
        if (n10 != 0) {
            return -5;
        }
        ((LicenceCheck$a)object).h = 5;
        object = this.a;
        n10 = com.tencent.liteav.basic.datareport.a.aJ;
        TXCDRApi.txReportDAU((Context)object, n10);
        return 0;
    }

    private String e(String object) {
        Object object2 = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKfMXaF6wx9lev2U\nIzkk6ydI2sdaSQAD2ZvDBLq+5Fm6nGwSSWawl03D4vHcWIUa3wnz6f19/y8wzrj4\nnTfcEnT94SPdB6GhGsqPwbwRp9MHAqd/2gWZxSb005il2yiOZafk6X4NGKCn2tGd\nyNaCF+m9rLykuLdZHB0Z53ivgseNAgMBAAECgYAvXI2pAH+Goxwd6uwuOu9svTGT\nRzaHnI6VWmxBUZQeh3+TOW4iYAG03291GN6bY0RFCOWouSGH7lzK9NFbbPCAQ/hx\ncO48PqioHoq7K8sqzd3XaYBv39HrRnM8JvZsqv0PLJwX/LGm2y/MRaKAC6bcHtse\npgh+NNmUxXNRcTMRAQJBANezmenBcR8HTcY5YaEk3SQRzOo+QhIXuuD4T/FESpVJ\nmVQGxJjLsEBua1j38WG2QuepE5JiVbkQ0jQSvhUiZK0CQQDHJa+vWu6l72lQAvIx\nwmRISorvLb/tnu5bH0Ele42oX+w4p/tm03awdVjhVANnpDjYS2H6EzrF/pfis7k9\nV2phAkB4E4gz47bYYhV+qsTZkw70HGCpab0YG1OyFylRkwW983nCl/3rXUChrZZe\nsbATCAZYtfuqOsmju2R5DpH4a+wFAkBmHlcWbmSNxlSUaM5U4b+WqlLQDv+qE6Na\nKo63b8HWI0n4S3tI4QqttZ7b/L66OKXFk/Ir0AyFVuX/o/VLFTZBAkAdSTEkGwE5\nGQmhxu95sKxmdlUY6Q0Gwwpi06C1BPBrj2VkGXpBP0twhPVAq/3xVjjb+2KXVTUW\nIpRLc06M4vhv";
        String string2 = null;
        object2 = Base64.decode((String)object2, (int)0);
        object = Base64.decode((String)object, (int)0);
        object = h.b((byte[])object, (byte[])object2);
        try {
            object2 = new String((byte[])object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object2 = new StringBuilder();
            string2 = "decryptLicenceStr, exception is : ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(exception);
            String string3 = ((StringBuilder)object2).toString();
            TXCLog.e("LicenceCheck", string3);
            object2 = null;
        }
        return object2;
    }

    private boolean e(LicenceCheck$a object) {
        Context context = this.a;
        object = ((LicenceCheck$a)object).a;
        return com.tencent.liteav.basic.util.d.a(context, (String)object);
    }

    private void f(LicenceCheck$a licenceCheck$a) {
        String string2;
        StringBuilder stringBuilder;
        Object object = this.a.getExternalFilesDir(null);
        String string3 = "LicenceCheck";
        if (object == null) {
            TXCLog.i(string3, "saveTempLocal sdcardDir is null");
            return;
        }
        Object object2 = new StringBuilder();
        object = ((File)object).getAbsolutePath();
        ((StringBuilder)object2).append((String)object);
        object = File.separator;
        ((StringBuilder)object2).append((String)object);
        Object object3 = licenceCheck$a.a;
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        object3 = new File((String)object2);
        boolean bl2 = ((File)object3).exists();
        if (bl2) {
            bl2 = ((File)object3).delete();
            stringBuilder = new StringBuilder();
            string2 = "delete dst file:";
            stringBuilder.append(string2);
            stringBuilder.append(bl2);
            object2 = stringBuilder.toString();
            TXCLog.i(string3, (String)object2);
        }
        stringBuilder = new StringBuilder();
        string2 = licenceCheck$a.c;
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        object = licenceCheck$a.b;
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new File((String)object);
        boolean bl3 = ((File)object2).exists();
        if (bl3) {
            bl3 = ((File)object2).renameTo((File)object3);
            object2 = new StringBuilder();
            object3 = "rename file:";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(bl3);
            object = ((StringBuilder)object2).toString();
            TXCLog.i(string3, (String)object);
        }
        licenceCheck$a.g = true;
    }

    private int g(LicenceCheck$a licenceCheck$a) {
        return licenceCheck$a.h;
    }

    private String h(LicenceCheck$a object) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = ((LicenceCheck$a)object).c;
        stringBuilder.append(string2);
        string2 = File.separator;
        stringBuilder.append(string2);
        object = ((LicenceCheck$a)object).b;
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        File file = new File((String)object);
        return com.tencent.liteav.basic.util.d.b(file.getAbsolutePath());
    }

    private native byte[] nativeIvParameterSpec(byte[] var1);

    public int a(LicenceCheck$a licenceCheck$a, String string2) {
        Object object;
        try {
            object = new JSONObject(string2);
        }
        catch (JSONException jSONException) {
            object = this.f;
            if (licenceCheck$a == object) {
                return -1;
            }
            return this.e(licenceCheck$a, string2);
        }
        return this.d(licenceCheck$a, string2);
    }

    public int a(f f10, Context context) {
        LicenceCheck$a licenceCheck$a = this.f;
        return this.a(licenceCheck$a, f10, context);
    }

    public PublicKey a(String object) {
        object = Base64.decode((String)object, (int)0);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec((byte[])object);
        return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    }

    public void a(Context context, String string2, String string3) {
        LicenceCheck$a licenceCheck$a = this.f;
        this.a(licenceCheck$a, context, string2, string3);
    }

    public void a(LicenceCheck$a licenceCheck$a) {
        Object object = licenceCheck$a.e;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        Object object2 = "LicenceCheck";
        if (bl2) {
            TXCLog.e((String)object2, "downloadLicense, mUrl is empty, ignore!");
            return;
        }
        bl2 = licenceCheck$a.f;
        if (bl2) {
            TXCLog.i((String)object2, "downloadLicense, in downloading, ignore");
            return;
        }
        LicenceCheck$1 licenceCheck$1 = new LicenceCheck$1(this, licenceCheck$a);
        object = this.a;
        if (object == null) {
            TXCLog.e((String)object2, "context is NULL !!! Please set context in method:setLicense(Context context, String url, String key)");
            return;
        }
        if ((object = object.getExternalFilesDir(null)) == null) {
            TXCLog.e((String)object2, "Please check permission WRITE_EXTERNAL_STORAGE permission has been set !!!");
            return;
        }
        String string2 = this.b(licenceCheck$a);
        licenceCheck$a.c = object = ((File)object).getAbsolutePath();
        Context context = this.a;
        String string3 = licenceCheck$a.e;
        String string4 = licenceCheck$a.c;
        String string5 = licenceCheck$a.b;
        object2 = new c(context, string3, string4, string5, licenceCheck$1, false, string2);
        object = new Thread((Runnable)object2);
        ((Thread)object).start();
        licenceCheck$a.f = true;
    }

    public int b() {
        LicenceCheck$a licenceCheck$a = this.f;
        return this.g(licenceCheck$a);
    }
}

