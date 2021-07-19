/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  org.json.JSONObject
 */
package cn.sharesdk.sina.weibo;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.security.MessageDigest;
import java.util.HashMap;
import org.json.JSONObject;

public class a {
    private static volatile a a;
    private MobCommunicator b;
    private String c;
    private String d;
    private String e;

    public a() {
        String string2;
        this.c = string2 = MobSDK.getAppkey();
        this.d = string2 = MobSDK.getContext().getPackageName();
        this.e = string2 = cn.sharesdk.sina.weibo.a.a(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static a a() {
        Class<a> clazz = a.class;
        // MONITORENTER : clazz
        a a10 = a;
        if (a10 == null) {
            // MONITORENTER : clazz
            a10 = a;
            if (a10 == null) {
                a = a10 = new a();
            }
            // MONITOREXIT : clazz
        }
        // MONITOREXIT : clazz
        return a;
    }

    public static String a(String signatureArray) {
        int n10;
        if ((signatureArray = cn.sharesdk.sina.weibo.a.b((String)signatureArray)) != null && (n10 = signatureArray.length) != 0) {
            int n11;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 0; i10 < (n11 = signatureArray.length); ++i10) {
                String string2 = cn.sharesdk.sina.weibo.a.a(signatureArray[i10].toByteArray());
                stringBuffer.append(string2);
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static final String a(byte[] object) {
        char[] cArray;
        int n10 = 16;
        char[] cArray2 = cArray = new char[n10];
        char[] cArray3 = cArray;
        cArray2[0] = 48;
        cArray3[1] = 49;
        cArray2[2] = 50;
        cArray3[3] = 51;
        cArray2[4] = 52;
        cArray3[5] = 53;
        cArray2[6] = 54;
        cArray3[7] = 55;
        cArray2[8] = 56;
        cArray3[9] = 57;
        cArray2[10] = 97;
        cArray3[11] = 98;
        cArray2[12] = 99;
        cArray3[13] = 100;
        cArray2[14] = 101;
        cArray3[15] = 102;
        Object object2 = "MD5";
        object2 = MessageDigest.getInstance((String)object2);
        ((MessageDigest)object2).update((byte[])object);
        object = ((MessageDigest)object2).digest();
        int n11 = ((byte[])object).length;
        int n12 = n11 * 2;
        char[] cArray4 = new char[n12];
        int n13 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n14 = object[i10];
            int n15 = n14 >>> 4 & 0xF;
            n15 = cArray[n15];
            cArray4[n13] = n15;
            ++n13;
            n14 &= 0xF;
            n14 = cArray[n14];
            cArray4[n13] = n14;
            ++n13;
            continue;
        }
        try {
            object = new String;
        }
        catch (Exception exception) {
            SSDKLog.b().d(exception);
            return null;
        }
        object(cArray4);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private MobCommunicator b() {
        synchronized (this) {
            MobCommunicator mobCommunicator = this.b;
            if (mobCommunicator != null) return this.b;
            int n10 = 1024;
            String string2 = "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f";
            String string3 = "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1";
            this.b = mobCommunicator = new MobCommunicator(n10, string2, string3);
            return this.b;
        }
    }

    private static Signature[] b(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            Object object = MobSDK.getContext().getPackageManager();
            int n11 = 64;
            try {
                string2 = object.getPackageInfo(string2, n11);
                if (string2 == null) {
                    return null;
                }
                return ((PackageInfo)string2).signatures;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = SSDKLog.b();
                ((NLog)object).d(nameNotFoundException);
            }
        }
        return null;
    }

    public HashMap a(String object, JSONObject object2, String hashMap, String string2, String string3, String string4) {
        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        Object object3 = this.c;
        hashMap2.put("appkey", object3);
        int n10 = 1;
        object3 = n10;
        hashMap2.put("plat", object3);
        object3 = this.d;
        hashMap2.put("androidPk", object3);
        object3 = this.e;
        String string5 = "androidPkSign";
        hashMap2.put(string5, object3);
        object3 = "summary";
        hashMap2.put(object3, object);
        hashMap2.put("image", object2);
        hashMap2.put("object_type", hashMap);
        hashMap2.put("display_name", string2);
        hashMap2.put("create_at", string3);
        object = "url";
        hashMap2.put(object, string4);
        object = this.b();
        object2 = "http://lks.share.mob.com/share/genShareInfo";
        boolean bl2 = false;
        hashMap = null;
        object = ((MobCommunicator)object).requestSynchronized(hashMap2, (String)object2, false);
        try {
            object = (HashMap)object;
        }
        catch (Exception exception) {
            boolean bl3;
            object = exception.getMessage();
            if (object != null && (bl3 = ((String)object).endsWith((String)(object2 = "}")))) {
                object2 = new Hashon();
                bl2 = ((HashMap)(object = ((Hashon)object2).fromJson((String)object))).containsKey(object2 = "error");
                if (bl2) {
                    hashMap = new HashMap<Object, Object>();
                    object = String.valueOf(((HashMap)object).get(object2));
                    hashMap.put(object2, object);
                    return hashMap;
                }
            }
            object = null;
        }
        return object;
    }
}

