/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.mob.commons.filesys;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.ForbThrowable;
import com.mob.commons.MobProduct;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b;
import com.mob.commons.filesys.FileUploader$UploadedAudio;
import com.mob.commons.filesys.FileUploader$UploadedAvatar;
import com.mob.commons.filesys.FileUploader$UploadedFile;
import com.mob.commons.filesys.FileUploader$UploadedImage;
import com.mob.commons.filesys.FileUploader$UploadedVideo;
import com.mob.commons.j;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FileUploader
implements PublicMemberKeeper {
    private static String a = j.c("http://up.sdk.mob.com");

    private static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = a;
        stringBuilder.append(string2);
        stringBuilder.append("/image");
        return stringBuilder.toString();
    }

    private static String a(MobProduct object) {
        boolean bl2;
        int n10;
        Object object2 = new NetworkHelper();
        ArrayList arrayList = FileUploader.a((MobProduct)object, "1234567890abcdeffedcba0987654321");
        NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
        networkHelper$NetworkTimeOut.readTimout = 30000;
        networkHelper$NetworkTimeOut.connectionTimeout = n10 = 5000;
        Object object3 = FileUploader.f();
        String string2 = null;
        object = ((NetworkHelper)object2).httpPost((String)object3, null, null, arrayList, networkHelper$NetworkTimeOut);
        object2 = new Hashon();
        if ((object2 = ((Hashon)object2).fromJson((String)object)) != null && (bl2 = (string2 = "200").equals(object3 = String.valueOf(((HashMap)object2).get("status"))))) {
            object3 = "res";
            try {
                object2 = ((HashMap)object2).get(object3);
            }
            catch (Throwable throwable) {
                object3 = new Throwable((String)object, throwable);
                throw object3;
            }
            object2 = (HashMap)object2;
            object3 = "token";
            object2 = ((HashMap)object2).get(object3);
            return (String)object2;
        }
        object2 = new Throwable((String)object);
        throw object2;
    }

    private static Throwable a(long l10, long l11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"status\": ,\"error\":\"max size: ");
        stringBuilder.append(l11);
        stringBuilder.append(", file size: ");
        stringBuilder.append(l10);
        stringBuilder.append("\"}");
        String string2 = stringBuilder.toString();
        Throwable throwable = new Throwable(string2);
        return throwable;
    }

    private static ArrayList a(MobProduct object, String object2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        CharSequence charSequence = new StringBuilder();
        charSequence.append((String)object2);
        String string2 = MobSDK.getAppSecret();
        charSequence.append(string2);
        charSequence = Data.MD5(charSequence.toString());
        Object object3 = new KVPair("sign", charSequence);
        arrayList.add(object3);
        charSequence = MobSDK.getAppkey();
        object3 = new KVPair("key", charSequence);
        arrayList.add(object3);
        object3 = new KVPair("token", object2);
        arrayList.add(object3);
        object3 = object.getProductTag();
        object2 = new KVPair("product", object3);
        arrayList.add(object2);
        object = DeviceAuthorizer.authorize((MobProduct)object);
        object2 = new KVPair("cliid", object);
        arrayList.add(object2);
        return arrayList;
    }

    private static HashMap a(MobProduct object, String object2, HashMap object3, String string2, long l10) {
        boolean bl2 = b.aa();
        if (!bl2) {
            Object object4 = new File((String)object2);
            long l11 = ((File)object4).length();
            long l12 = l11 - l10;
            Object object5 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object5 <= 0) {
                boolean bl3;
                int n10;
                boolean bl4;
                NetworkHelper networkHelper = new NetworkHelper();
                String string3 = FileUploader.a((MobProduct)object);
                ArrayList arrayList = FileUploader.a((MobProduct)object, string3);
                ArrayList<KVPair> arrayList2 = new ArrayList<KVPair>();
                object = ((HashMap)object3).keySet().iterator();
                while (bl4 = object.hasNext()) {
                    string3 = (String)object.next();
                    object4 = String.valueOf(((HashMap)object3).get(string3));
                    KVPair kVPair = new KVPair(string3, object4);
                    arrayList2.add(kVPair);
                }
                KVPair kVPair = new KVPair("file", object2);
                NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
                networkHelper$NetworkTimeOut.readTimout = 30000;
                networkHelper$NetworkTimeOut.connectionTimeout = n10 = 5000;
                object = networkHelper.httpPost(string2, arrayList2, kVPair, arrayList, networkHelper$NetworkTimeOut);
                object2 = new Hashon();
                if ((object2 = ((Hashon)object2).fromJson((String)object)) != null && (bl3 = (string2 = "200").equals(object3 = String.valueOf(((HashMap)object2).get("status"))))) {
                    return (HashMap)((HashMap)object2).get("res");
                }
                object2 = new Throwable((String)object);
                throw object2;
            }
            throw FileUploader.a(((File)object4).length(), l10);
        }
        object = new ForbThrowable();
        throw object;
    }

    /*
     * WARNING - void declaration
     */
    private static HashMap a(MobProduct mobProduct, String string2, boolean bl2, String string3, String string4) {
        void var4_8;
        void var3_7;
        void var2_5;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        if (bl2) {
            int n10 = 2;
        } else {
            boolean bl3 = true;
        }
        Object object = (int)var2_5;
        Object object2 = "sm";
        hashMap.put(object2, object);
        boolean bl4 = TextUtils.isEmpty((CharSequence)var3_7);
        if (!bl4) {
            object = "zoomScaleWidths";
            hashMap.put(object, var3_7);
        }
        object2 = mobProduct;
        return FileUploader.a(mobProduct, string2, hashMap, (String)var4_8, 0xA00000L);
    }

    private static String b() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = a;
        stringBuilder.append(string2);
        stringBuilder.append("/avatar");
        return stringBuilder.toString();
    }

    private static String c() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = a;
        stringBuilder.append(string2);
        stringBuilder.append("/video");
        return stringBuilder.toString();
    }

    private static String d() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = a;
        stringBuilder.append(string2);
        stringBuilder.append("/audio");
        return stringBuilder.toString();
    }

    private static String e() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = a;
        stringBuilder.append(string2);
        stringBuilder.append("/file");
        return stringBuilder.toString();
    }

    private static String f() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = a;
        stringBuilder.append(string2);
        stringBuilder.append("/getToken");
        return stringBuilder.toString();
    }

    public static void setUploadServer(String string2) {
        String string3 = "/";
        boolean bl2 = string2.endsWith(string3);
        if (bl2) {
            bl2 = false;
            string3 = null;
            int n10 = string2.length() + -1;
            string2 = string2.substring(0, n10);
        }
        a = j.c(string2);
    }

    /*
     * WARNING - void declaration
     */
    public static FileUploader$UploadedAudio uploadAudio(MobProduct object, String string2, boolean bl2) {
        void var2_5;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        if (bl2) {
            int n10 = 2;
        } else {
            boolean bl3 = true;
        }
        Object object2 = (int)var2_5;
        hashMap.put("sm", (Integer)object2);
        String string3 = FileUploader.d();
        object = FileUploader.a((MobProduct)object, string2, hashMap, string3, 0xC800000L);
        object2 = new FileUploader$UploadedAudio((HashMap)object);
        return object2;
    }

    public static FileUploader$UploadedAvatar uploadAvatar(MobProduct mobProduct, String string2) {
        int[] nArray = new int[]{};
        return FileUploader.uploadAvatar(mobProduct, string2, false, nArray);
    }

    public static FileUploader$UploadedAvatar uploadAvatar(MobProduct object, String string2, boolean bl2, int ... object2) {
        int n10;
        String string3 = null;
        if (object2 != null && (n10 = ((int[])object2).length) > 0) {
            n10 = ((int[])object2).length;
            String string4 = "";
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11 = object2[i10];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string4);
                stringBuilder.append(",");
                stringBuilder.append(n11);
                string4 = stringBuilder.toString();
            }
            int n12 = string4.length();
            if (n12 > 0) {
                n12 = 1;
                string3 = string4.substring(n12);
            }
        }
        object2 = new FileUploader$UploadedAvatar;
        String string5 = FileUploader.b();
        object = FileUploader.a((MobProduct)object, string2, bl2, string3, string5);
        object2((HashMap)object);
        return object2;
    }

    /*
     * WARNING - void declaration
     */
    public static FileUploader$UploadedFile uploadFile(MobProduct object, String string2, boolean bl2) {
        void var2_5;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        if (bl2) {
            int n10 = 2;
        } else {
            boolean bl3 = true;
        }
        Object object2 = (int)var2_5;
        hashMap.put("sm", (Integer)object2);
        String string3 = FileUploader.e();
        object = FileUploader.a((MobProduct)object, string2, hashMap, string3, 0x3200000L);
        object2 = new FileUploader$UploadedFile((HashMap)object);
        return object2;
    }

    public static FileUploader$UploadedImage uploadImage(MobProduct mobProduct, String string2) {
        int[] nArray = new int[]{};
        return FileUploader.uploadImage(mobProduct, string2, false, nArray);
    }

    public static FileUploader$UploadedImage uploadImage(MobProduct object, String string2, boolean bl2, int ... object2) {
        int n10;
        String string3 = null;
        if (object2 != null && (n10 = ((int[])object2).length) > 0) {
            n10 = ((int[])object2).length;
            String string4 = "";
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11 = object2[i10];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string4);
                stringBuilder.append(",");
                stringBuilder.append(n11);
                string4 = stringBuilder.toString();
            }
            int n12 = string4.length();
            if (n12 > 0) {
                n12 = 1;
                string3 = string4.substring(n12);
            }
        }
        object2 = new FileUploader$UploadedImage;
        String string5 = FileUploader.a();
        object = FileUploader.a((MobProduct)object, string2, bl2, string3, string5);
        object2((HashMap)object);
        return object2;
    }

    /*
     * WARNING - void declaration
     */
    public static FileUploader$UploadedVideo uploadVideo(MobProduct object, String string2, boolean bl2) {
        void var2_5;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        if (bl2) {
            int n10 = 2;
        } else {
            boolean bl3 = true;
        }
        Object object2 = (int)var2_5;
        hashMap.put("sm", (Integer)object2);
        String string3 = FileUploader.c();
        object = FileUploader.a((MobProduct)object, string2, hashMap, string3, 0xC800000L);
        object2 = new FileUploader$UploadedVideo((HashMap)object);
        return object2;
    }
}

