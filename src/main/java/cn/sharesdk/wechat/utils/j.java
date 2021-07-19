/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package cn.sharesdk.wechat.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;
import cn.sharesdk.wechat.utils.WechatResp;
import cn.sharesdk.wechat.utils.b;
import cn.sharesdk.wechat.utils.c;
import cn.sharesdk.wechat.utils.e;
import cn.sharesdk.wechat.utils.f;
import cn.sharesdk.wechat.utils.g;
import cn.sharesdk.wechat.utils.i$a;
import cn.sharesdk.wechat.utils.k;
import cn.sharesdk.wechat.utils.m;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;
import java.security.MessageDigest;

public class j {
    private String a;

    private String a(Context object) {
        block18: {
            Object object2;
            Object object3;
            String string2 = "ShareSDK";
            int n10 = 1;
            try {
                object3 = object.getContentResolver();
                object = "content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk";
            }
            catch (Throwable throwable) {
                object3 = SSDKLog.b();
                Object[] objectArray = new Object[n10];
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("WechatCore catch ");
                ((StringBuilder)object2).append(throwable);
                String string3 = ((StringBuilder)object2).toString();
                objectArray[0] = string3;
                ((NLog)object3).e(string2, objectArray);
                return null;
            }
            object2 = Uri.parse((String)object);
            int n11 = 2;
            Object object4 = new String[n11];
            object = this.a;
            object4[0] = object;
            object = "621086720";
            object4[n10] = object;
            Object[] objectArray = null;
            CharSequence charSequence = null;
            object = object3.query((Uri)object2, null, null, object4, null);
            if (object == null) break block18;
            boolean bl2 = object.moveToFirst();
            if (!bl2) break block18;
            object3 = object.getString(0);
            object2 = SSDKLog.b();
            objectArray = new Object[n10];
            charSequence = new StringBuilder();
            object4 = "MicroMsg.SDK.WXApiImplV10(WechatCore) getTokenFromWX token is ";
            charSequence.append((String)object4);
            charSequence.append((String)object3);
            charSequence = charSequence.toString();
            objectArray[0] = charSequence;
            ((NLog)object2).d(string2, objectArray);
            object.close();
            return object3;
        }
        return null;
    }

    private boolean a(byte[] object, byte[] objectArray) {
        int n10;
        if (object != null && (n10 = ((byte[])object).length) != 0) {
            if (objectArray != null && (n10 = objectArray.length) != 0) {
                n10 = ((byte[])object).length;
                Object object2 = objectArray.length;
                if (n10 != object2) {
                    object = SSDKLog.b();
                    objectArray = new Object[0];
                    ((NLog)object).d("checkSumConsistent fail, length is different", objectArray);
                    return false;
                }
                for (n10 = 0; n10 < (object2 = ((Object)object).length); ++n10) {
                    object2 = object[n10];
                    byte by2 = objectArray[n10];
                    if (object2 == by2) continue;
                    object = SSDKLog.b();
                    objectArray = new Object[0];
                    ((NLog)object).d("checkSumConsistent fail, not match", objectArray);
                    return false;
                }
                return true;
            }
            object = SSDKLog.b();
            objectArray = new Object[0];
            ((NLog)object).d("checkSumConsistent fail, invalid arguments, checksum is empty", objectArray);
            return false;
        }
        object = SSDKLog.b();
        objectArray = new Object[0];
        ((NLog)object).d("checkSumConsistent fail, invalid arguments, \"_mmessage_checksum\" is empty", objectArray);
        return false;
    }

    private byte[] a(String object, String object2, int n10) {
        Object object3 = new StringBuffer();
        if (object != null) {
            ((StringBuffer)object3).append((String)object);
        }
        ((StringBuffer)object3).append(n10);
        ((StringBuffer)object3).append((String)object2);
        ((StringBuffer)object3).append("mMcShCsTr");
        object = ((StringBuffer)object3).toString().substring(1, 9).getBytes();
        int n11 = 16;
        Object object4 = object2 = (Object)new char[n11];
        object4[0] = 48;
        object4[1] = 49;
        object4[2] = 50;
        object4[3] = 51;
        object4[4] = 52;
        object4[5] = 53;
        object4[6] = 54;
        object4[7] = 55;
        object4[8] = 56;
        object4[9] = 57;
        object4[10] = 97;
        object4[11] = 98;
        object4[12] = 99;
        object4[13] = 100;
        object4[14] = 101;
        object4[15] = 102;
        n10 = 0;
        object3 = "MD5";
        object3 = MessageDigest.getInstance((String)object3);
        ((MessageDigest)object3).update((byte[])object);
        object = ((MessageDigest)object3).digest();
        int n12 = ((Object)object).length * 2;
        object3 = new char[n12];
        int n13 = 0;
        int n14 = 0;
        while (true) {
            Object object5 = ((Object)object).length;
            if (n13 >= object5) break;
            object5 = object[n13];
            Object object6 = object5 >>> 4 & 0xF;
            object6 = object2[object6];
            object3[n14] = object6;
            ++n14;
            object5 &= 0xF;
            object5 = object2[object5];
            object3[n14] = object5;
            ++n14;
            ++n13;
            continue;
            break;
        }
        try {
            object = new String((char[])object3);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
            object = null;
        }
        if (object != null) {
            return ((String)object).getBytes();
        }
        return null;
    }

    private String b(String string2) {
        String string3;
        block12: {
            int n10;
            block11: {
                String string4;
                block10: {
                    Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.plugin.provider/sharedpref");
                    string3 = "key";
                    string4 = "value";
                    String[] stringArray = new String[]{"_id", string3, "type", string4};
                    try {
                        string3 = MobSDK.getContext();
                    }
                    catch (Throwable throwable) {
                        SSDKLog.b().d(throwable);
                        return null;
                    }
                    string3 = string3.getContentResolver();
                    String string5 = "key = ?";
                    int n11 = 1;
                    String[] stringArray2 = new String[n11];
                    stringArray2[0] = string2;
                    string2 = string3.query(uri, stringArray, string5, stringArray2, null);
                    if (string2 != null) break block10;
                    return null;
                }
                n10 = string2.moveToFirst();
                if (n10 == 0) break block11;
                n10 = string2.getColumnIndex(string4);
                string3 = string2.getString(n10);
                break block12;
            }
            n10 = 0;
            string3 = null;
        }
        string2.close();
        return string3;
    }

    private boolean d() {
        NLog nLog = SSDKLog.b();
        Object[] objectArray = null;
        Object object = new Object[]{};
        String string2 = "checking signature of wechat client...";
        nLog.d(string2, object);
        nLog = MobSDK.getContext();
        nLog = nLog.getPackageManager();
        object = "com.tencent.mm";
        int n10 = 64;
        try {
            nLog = nLog.getPackageInfo((String)object, n10);
            object = ((PackageInfo)nLog).signatures;
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return false;
        }
        int n11 = ((Object[])object).length;
        string2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            String string3 = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";
            String string4 = ((PackageInfo)nLog).signatures[n10].toCharsString();
            boolean bl2 = string3.equals(string4);
            if (!bl2) continue;
            nLog = SSDKLog.b();
            objectArray = new Object[]{};
            nLog.d("pass!", objectArray);
            return true;
        }
        return false;
    }

    public void a(m object) {
        String string2;
        object = (g)object;
        ContentResolver contentResolver = MobSDK.getContext().getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
        String[] stringArray = new String[5];
        stringArray[0] = string2 = this.a;
        stringArray[1] = "1";
        stringArray[2] = string2 = String.valueOf(((g)object).a);
        stringArray[3] = string2 = ((g)object).b;
        object = ((g)object).c;
        int n10 = 4;
        stringArray[n10] = object;
        object = contentResolver.query(uri, null, null, stringArray, null);
        if (object != null) {
            object.close();
        }
        object = new Intent();
        object.setClassName("com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity");
        object.addFlags(0x10000000);
        object.addFlags(0x8000000);
        MobSDK.getContext().startActivity((Intent)object);
    }

    public void a(m object, boolean n10) {
        String string2 = "ShareSDK";
        boolean bl2 = this.b();
        if (bl2) {
            if ((n10 = ((m)object).a(n10 != 0)) != 0) {
                int n11;
                Object object2;
                String string3;
                block15: {
                    n10 = 621086720;
                    String string4 = MobSDK.getContext().getPackageName();
                    Object object3 = new StringBuilder();
                    ((StringBuilder)object3).append("weixin://sendreq?appid=");
                    string3 = this.a;
                    ((StringBuilder)object3).append(string3);
                    object3 = ((StringBuilder)object3).toString();
                    string3 = new Intent();
                    CharSequence charSequence = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                    string3.setClassName("com.tencent.mm", (String)charSequence);
                    Object object4 = new Bundle();
                    ((m)object).a((Bundle)object4);
                    string3.putExtras((Bundle)object4);
                    string3.putExtra("_mmessage_sdkVersion", n10);
                    string3.putExtra("_mmessage_appPackage", string4);
                    object4 = "_mmessage_content";
                    string3.putExtra((String)object4, (String)object3);
                    object2 = this.a((String)object3, string4, n10);
                    string3.putExtra("_mmessage_checksum", object2);
                    n11 = ((m)object).a();
                    n10 = 2;
                    bl2 = false;
                    string4 = null;
                    if (n11 == n10) {
                        n11 = 1;
                        object2 = MobSDK.getContext();
                        object2 = this.a((Context)object2);
                        boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
                        if (bl3) break block15;
                        object3 = "_message_token";
                        string3.putExtra((String)object3, (String)object2);
                        object3 = SSDKLog.b();
                        object4 = new Object[n11];
                        charSequence = new StringBuilder();
                        String string5 = " _message_token ";
                        ((StringBuilder)charSequence).append(string5);
                        ((StringBuilder)charSequence).append((String)object2);
                        object2 = ((StringBuilder)charSequence).toString();
                        object4[0] = object2;
                        try {
                            ((NLog)object3).d(string2, (Object[])object4);
                        }
                        catch (Exception exception) {
                            object3 = SSDKLog.b();
                            object = new Object[n11];
                            object4 = new StringBuilder();
                            charSequence = " WechatCore that put token catch ";
                            ((StringBuilder)object4).append((String)charSequence);
                            ((StringBuilder)object4).append(exception);
                            object2 = ((StringBuilder)object4).toString();
                            object[0] = object2;
                            ((NLog)object3).e(string2, (Object[])object);
                        }
                    }
                }
                n11 = 0x10000000;
                string3.addFlags(n11);
                string3.addFlags(0x8000000);
                string3.setFlags(n11);
                MobSDK.getContext().startActivity((Intent)string3);
                object = SSDKLog.b();
                object2 = new Object[0];
                ((NLog)object).d("starting activity, packageName=com.tencent.mm, className=com.tencent.mm.plugin.base.stub.WXEntryActivity", object2);
                return;
            }
            object = new Throwable("sendReq checkArgs fail");
            throw object;
        }
        object = new WechatClientNotExistException();
        throw object;
    }

    public boolean a() {
        Object object;
        Object object2;
        Object object3 = MobSDK.getContext();
        object3 = object3.getPackageManager();
        Object object4 = "com.tencent.mm";
        object3 = object3.getPackageInfo((String)object4, 0);
        object3 = ((PackageInfo)object3).versionName;
        object4 = SSDKLog.b();
        Object object5 = new StringBuilder();
        Object[] objectArray = "wechat versionName ==>> ";
        ((StringBuilder)object5).append((String)objectArray);
        ((StringBuilder)object5).append((String)object3);
        object5 = ((StringBuilder)object5).toString();
        objectArray = new Object[]{};
        try {
            ((NLog)object4).i(object5, objectArray);
        }
        catch (Throwable throwable) {
            object4 = SSDKLog.b();
            ((NLog)object4).d(throwable);
            object3 = "0";
        }
        object3 = ((String)object3).split("_")[0];
        object4 = "\\.";
        object3 = ((String)object3).split((String)object4);
        Object object6 = ((Object)object3).length;
        object5 = new int[object6];
        objectArray = null;
        for (object2 = 0; object2 < object6; ++object2) {
            Object object7 = object3[object2];
            int n10 = ResHelper.parseInt((String)object7);
            try {
                object5[object2] = n10;
                continue;
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                nLog.d(throwable);
                object5[object2] = false;
            }
        }
        Object object8 = 4;
        if (object6 >= object8 && (object8 = (Object)object5[0]) == (object6 = 6) && (object6 = (Object)object5[object8 = true]) == 0 && (object2 = (Object)object5[object6 = 2]) == object6 && (object6 = (Object)object5[3]) <= (object = 56)) {
            return object8;
        }
        return false;
    }

    public boolean a(WechatHandlerActivity object, k object2) {
        String string2;
        int n10;
        Intent intent = object.getIntent();
        if (intent == null) {
            return false;
        }
        Object object3 = intent.getStringExtra("wx_token_key");
        if (object3 != null && (n10 = ((String)object3).equals(string2 = "com.tencent.mm.openapi.token")) != 0) {
            object3 = intent.getStringExtra("_mmessage_appPackage");
            int n11 = TextUtils.isEmpty((CharSequence)object3);
            if (n11) {
                object = SSDKLog.b();
                object2 = new Object[]{};
                ((NLog)object).d("invalid argument, \"_mmessage_appPackage\" is empty", object2);
                return false;
            }
            string2 = intent.getStringExtra("_mmessage_content");
            String string3 = "_mmessage_sdkVersion";
            int n12 = intent.getIntExtra(string3, 0);
            byte[] byArray = intent.getByteArrayExtra("_mmessage_checksum");
            n10 = this.a(byArray, (byte[])(object3 = (Object)this.a(string2, (String)object3, n12)));
            if (n10 == 0) {
                object = SSDKLog.b();
                object2 = new Object[]{};
                ((NLog)object).d("checksum fail", object2);
                return false;
            }
            n10 = (intent = intent.getExtras()).getInt((String)(object3 = "_wxapi_command_type"), 0);
            if (n10 != (n11 = 1)) {
                n12 = 2;
                if (n10 != n12) {
                    int n13 = 3;
                    if (n10 != n13) {
                        n13 = 4;
                        if (n10 != n13) {
                            n13 = 19;
                            if (n10 != n13) {
                                return false;
                            }
                            object2 = new c((Bundle)intent);
                            object2 = object2.a;
                            ((WechatHandlerActivity)((Object)object)).onGetMessageFromWXReq((WXMediaMessage)object2);
                        } else {
                            object2 = new f((Bundle)intent);
                            object2 = object2.a;
                            ((WechatHandlerActivity)((Object)object)).onShowMessageFromWXReq((WXMediaMessage)object2);
                        }
                    } else {
                        object2 = new c((Bundle)intent);
                        object2 = object2.a;
                        ((WechatHandlerActivity)((Object)object)).onGetMessageFromWXReq((WXMediaMessage)object2);
                    }
                } else {
                    object = new e((Bundle)intent);
                    object2.a((WechatResp)object);
                }
            } else {
                object = new b((Bundle)intent);
                object2.a((WechatResp)object);
            }
            return n11 != 0;
        }
        object = SSDKLog.b();
        object2 = new Object[]{};
        ((NLog)object).d("invalid argument, \"wx_token_key\" is empty or does not equals \"com.tencent.mm.openapi.token\"", object2);
        return false;
    }

    public boolean a(String object) {
        this.a = object;
        boolean bl2 = this.d();
        Object[] objectArray = null;
        if (!bl2) {
            object = SSDKLog.b();
            Object[] objectArray2 = new Object[]{};
            ((NLog)object).d("register app failed for wechat app signature check failed", objectArray2);
            return false;
        }
        String string2 = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
        CharSequence charSequence = new StringBuilder();
        charSequence.append("weixin://registerapp?appid=");
        charSequence.append((String)object);
        object = charSequence.toString();
        charSequence = "com.tencent.mm.permission.MM_MESSAGE";
        CharSequence charSequence2 = MobSDK.getContext().getPackageName();
        int n10 = 621086720;
        Intent intent = new Intent(string2);
        intent.putExtra("_mmessage_sdkVersion", n10);
        intent.putExtra("_mmessage_appPackage", (String)charSequence2);
        intent.putExtra("_mmessage_content", (String)object);
        intent.putExtra("_mmessage_support_content_type", 0L);
        object = this.a((String)object, (String)charSequence2, n10);
        intent.putExtra("_mmessage_checksum", (byte[])object);
        MobSDK.getContext().sendBroadcast(intent, (String)charSequence);
        object = SSDKLog.b();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("sending broadcast, intent=");
        ((StringBuilder)charSequence2).append(string2);
        ((StringBuilder)charSequence2).append(", perm=");
        ((StringBuilder)charSequence2).append((String)charSequence);
        string2 = ((StringBuilder)charSequence2).toString();
        objectArray = new Object[]{};
        ((NLog)object).d(string2, objectArray);
        return true;
    }

    public void b(m object) {
        object = (i$a)object;
        ContentResolver contentResolver = MobSDK.getContext().getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
        String[] stringArray = new String[4];
        CharSequence charSequence = this.a;
        stringArray[0] = charSequence;
        charSequence = ((i$a)object).a;
        stringArray[1] = charSequence;
        charSequence = ((i$a)object).b;
        stringArray[2] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("");
        int n10 = ((i$a)object).c;
        ((StringBuilder)charSequence).append(n10);
        object = ((StringBuilder)charSequence).toString();
        int n11 = 3;
        stringArray[n11] = object;
        object = contentResolver.query(uri, null, null, stringArray, null);
        if (object != null) {
            object.close();
        }
        object = new Intent();
        object.setClassName("com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity");
        object.addFlags(0x10000000);
        object.addFlags(0x8000000);
        MobSDK.getContext().startActivity((Intent)object);
    }

    public boolean b() {
        boolean bl2 = this.d();
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    public boolean c() {
        void var2_8;
        void var2_5;
        String string2 = this.b("_build_info_sdk_int_");
        try {
            int bl2 = ResHelper.parseInt(string2);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            nLog.d(throwable);
            int n10 = -1;
        }
        int n11 = 0x21020001;
        if (var2_5 >= n11) {
            boolean bl2 = true;
        } else {
            boolean bl3 = false;
            string2 = null;
        }
        return (boolean)var2_8;
    }
}

