/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.twitter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.e;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.twitter.MappedFileReader;
import cn.sharesdk.twitter.UpLoadViewCallBack;
import cn.sharesdk.twitter.b;
import cn.sharesdk.twitter.c$1;
import cn.sharesdk.twitter.c$2;
import cn.sharesdk.twitter.d;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class c
extends e {
    private static c b;
    private cn.sharesdk.framework.utils.b c;
    private cn.sharesdk.framework.a.b d;
    private MappedFileReader e;
    private int f = 0;
    private String g;
    private String h;

    private c(Platform object) {
        super((Platform)object);
        this.c = object = new cn.sharesdk.framework.utils.b();
        this.d = object = cn.sharesdk.framework.a.b.a();
    }

    public static /* synthetic */ MappedFileReader a(c c10) {
        return c10.e;
    }

    public static c a(Platform platform) {
        c c10 = b;
        if (c10 == null) {
            b = c10 = new c(platform);
        }
        return b;
    }

    private HashMap a(String string2, long l10, String string3) {
        String string4;
        boolean bl2;
        Object object = this.f(string2);
        if (object != null && (bl2 = ((String)(object = (String)((HashMap)object).get(string4 = "media_id_string"))).equals(string2))) {
            return this.d(string3, string2);
        }
        return null;
    }

    private HashMap a(String object, String object2, long l10) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = new KVPair("command", "INIT");
        arrayList.add(object);
        object = new KVPair("media_type", "video/mp4");
        arrayList.add(object);
        object = String.valueOf(l10);
        String string2 = "total_bytes";
        object2 = new KVPair(string2, object);
        arrayList.add(object2);
        object = this.c;
        String string3 = "https://upload.twitter.com/1.1/media/upload.json";
        object = ((cn.sharesdk.framework.utils.b)object).a(string3, arrayList);
        object2 = this.c;
        ArrayList arrayList2 = ((cn.sharesdk.framework.utils.b)object2).a((ArrayList)object);
        int n11 = 1;
        arrayList2.remove(n11);
        cn.sharesdk.framework.a.b b10 = this.d;
        int n12 = this.c();
        String string4 = "/1.1/media/upload.json";
        object = b10.a(string3, arrayList, null, arrayList2, string4, n12);
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public static /* synthetic */ void a(c c10, AuthorizeListener authorizeListener) {
        c10.b(authorizeListener);
    }

    public static /* synthetic */ void a(c c10, String string2, boolean bl2, UpLoadViewCallBack upLoadViewCallBack, String string3, long l10) {
        c10.a(string2, bl2, upLoadViewCallBack, string3, l10);
    }

    private void a(String object, boolean bl2, UpLoadViewCallBack upLoadViewCallBack, String string2, long l10) {
        int n10;
        Object object2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object3 = "APPEND";
        KVPair kVPair = new KVPair("command", object3);
        arrayList.add(kVPair);
        String string3 = "media_id";
        kVPair = new KVPair(string3, string2);
        arrayList.add(kVPair);
        if (bl2) {
            string2 = "media_data";
            object2 = new KVPair(string2, object);
            arrayList.add(object2);
        } else {
            string2 = "media";
            object2 = new KVPair(string2, object);
            arrayList.add(object2);
        }
        object2 = new StringBuilder();
        int n11 = this.f;
        ((StringBuilder)object2).append(n11);
        ((StringBuilder)object2).append("");
        object2 = ((StringBuilder)object2).toString();
        string2 = "segment_index";
        object = new KVPair(string2, object2);
        arrayList.add(object);
        this.f = n10 = this.f + 1;
        object = this.c;
        String string4 = "https://upload.twitter.com/1.1/media/upload.json";
        object = ((cn.sharesdk.framework.utils.b)object).a(string4, arrayList);
        object2 = this.c;
        ArrayList arrayList2 = ((cn.sharesdk.framework.utils.b)object2).a((ArrayList)object);
        object3 = this.d;
        int n12 = this.c();
        String string5 = "/1.1/media/upload.json";
        object = ((cn.sharesdk.framework.a.b)object3).a(string4, arrayList, null, arrayList2, string5, n12);
        if (upLoadViewCallBack != null) {
            upLoadViewCallBack.onResule((String)object);
        }
    }

    private byte[] a(MappedFileReader mappedFileReader) {
        int n10;
        int n11;
        if (mappedFileReader != null && (n11 = mappedFileReader.read()) != (n10 = -1)) {
            return mappedFileReader.getArray();
        }
        return null;
    }

    public static /* synthetic */ byte[] a(c c10, MappedFileReader mappedFileReader) {
        return c10.a(mappedFileReader);
    }

    private String b(String object, String string2, long l10) {
        int n10 = 524288;
        Object object2 = new MappedFileReader((String)object, n10);
        this.e = object2;
        object = this.a((MappedFileReader)object2);
        if (object == null) {
            return null;
        }
        String string3 = MappedFileReader.byteToBase64((byte[])object);
        c$2 c$2 = new c$2(this, string2, l10);
        object2 = this;
        this.a(string3, true, c$2, string2, l10);
        return "Done";
    }

    private HashMap f(String object) {
        int n10;
        ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
        Object object2 = new KVPair("command", "FINALIZE");
        arrayList.add((KVPair)object2);
        object2 = new KVPair("media_id", object);
        arrayList.add((KVPair)object2);
        object = this.c;
        String string2 = "https://upload.twitter.com/1.1/media/upload.json";
        object = ((cn.sharesdk.framework.utils.b)object).a(string2, arrayList);
        ArrayList arrayList2 = this.c.a((ArrayList)object);
        int n11 = 1;
        arrayList2.remove(n11);
        object2 = this.d;
        int n12 = this.c();
        String string3 = "/1.1/media/upload.json";
        object = ((cn.sharesdk.framework.a.b)object2).a(string2, arrayList, null, arrayList2, string3, n12);
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public HashMap a(String string2, String object, HashMap object2, HashMap hashMap) {
        int n10;
        int n11;
        Object object3;
        Object object4;
        Object object5;
        int n12;
        if (object == null) {
            return null;
        }
        ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
        if (object2 != null && (n12 = ((HashMap)object2).size()) > 0) {
            object2 = ((HashMap)object2).entrySet().iterator();
            while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object5 = object2.next();
                object4 = (String)object5.getKey();
                object5 = String.valueOf(object5.getValue());
                object3 = new KVPair((String)object4, object5);
                arrayList.add((KVPair)object3);
            }
        }
        if (hashMap != null && (n11 = hashMap.size()) > 0) {
            boolean bl2;
            object2 = hashMap.entrySet().iterator();
            n12 = 0;
            object5 = null;
            while (bl2 = object2.hasNext()) {
                object5 = (Map.Entry)object2.next();
                object4 = (String)object5.getKey();
                object5 = object5.getValue();
                object5 = object3 = new KVPair((String)object4, object5);
            }
            object4 = object5;
        } else {
            object4 = null;
        }
        object2 = ((String)object).toUpperCase();
        object5 = "GET";
        n11 = (int)(((String)object5).equals(object2) ? 1 : 0);
        if (n11 != 0) {
            object = this.c.b(string2, arrayList);
            object = this.c.a((ArrayList)object);
            object2 = this.d;
            string2 = ((NetworkHelper)object2).httpGet(string2, arrayList, (ArrayList)object, null);
        } else {
            object2 = "POST";
            boolean n102 = ((String)object2).equals(object = ((String)object).toUpperCase());
            if (n102) {
                int n13;
                if (hashMap != null && (n13 = hashMap.size()) > 0) {
                    object = new ArrayList();
                    object = this.c.a(string2, (ArrayList)object);
                    object2 = this.c;
                    object = ((cn.sharesdk.framework.utils.b)object2).a((ArrayList)object);
                    n11 = 1;
                    ((ArrayList)object).remove(n11);
                } else {
                    object = this.c.a(string2, arrayList);
                    object2 = this.c;
                    object = ((cn.sharesdk.framework.utils.b)object2).a((ArrayList)object);
                }
                object5 = this.d;
                object3 = string2;
                string2 = ((NetworkHelper)object5).httpPost(string2, arrayList, (KVPair)object4, (ArrayList)object, null);
            } else {
                string2 = null;
            }
        }
        if (string2 != null && (n10 = string2.length()) > 0) {
            object = new Hashon();
            return ((Hashon)object).fromJson(string2);
        }
        return null;
    }

    public HashMap a(String string2, String[] stringArray) {
        char c10;
        int n10;
        c c11 = this;
        Object object = stringArray;
        ArrayList arrayList = new ArrayList();
        Object object2 = this.c;
        String string3 = "https://upload.twitter.com/1.1/media/upload.json";
        object2 = ((cn.sharesdk.framework.utils.b)object2).a(string3, arrayList);
        Object object3 = this.c;
        ArrayList arrayList2 = ((cn.sharesdk.framework.utils.b)object3).a((ArrayList)object2);
        int n11 = 1;
        arrayList2.remove(n11);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Object> arrayList3 = new ArrayList<Object>();
        char c12 = '\u0000';
        for (int i10 = 0; i10 < (n11 = ((String[])object).length) && (n11 = arrayList3.size()) <= (n10 = 3); ++i10) {
            block27: {
                block26: {
                    object2 = object[i10];
                    object3 = "http";
                    n10 = (int)(((String)object2).startsWith((String)object3) ? 1 : 0);
                    if (n10 == 0) break block26;
                    object3 = MobSDK.getContext();
                    object2 = BitmapHelper.downloadBitmap((Context)object3, (String)object2);
                    break block27;
                }
                n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                if (n10 != 0) continue;
                object3 = new File((String)object2);
                n10 = (int)(((File)object3).exists() ? 1 : 0);
                if (n10 == 0) continue;
            }
            object3 = "media";
            KVPair kVPair = new KVPair((String)object3, object2);
            object2 = c11.d;
            String string4 = "/1.1/media/upload.json";
            int n12 = this.c();
            object3 = string3;
            Object object4 = arrayList;
            object2 = ((cn.sharesdk.framework.a.b)object2).a(string3, arrayList, kVPair, arrayList2, string4, n12);
            object3 = object[i10];
            stringBuilder.append((String)object3);
            object3 = ": ";
            stringBuilder.append((String)object3);
            stringBuilder.append((String)object2);
            object3 = "\n";
            stringBuilder.append((String)object3);
            if (object2 == null) continue;
            n10 = ((String)object2).length();
            if (n10 <= 0) continue;
            object3 = new Hashon();
            object2 = ((Hashon)object3).fromJson((String)object2);
            try {
                arrayList3.add(object2);
                continue;
            }
            catch (Exception exception) {
                object2 = SSDKLog.b();
                object3 = stringBuilder.toString();
                object4 = new Object[]{};
                ((NLog)object2).d(object3, object4);
            }
        }
        stringBuilder.setLength(0);
        while (c12 < (c10 = arrayList3.size())) {
            object = (HashMap)arrayList3.get(c12);
            c10 = (char)(((HashMap)object).containsKey(object2 = "image") ? 1 : 0);
            if (c10 != '\u0000') {
                c10 = stringBuilder.length();
                if (c10 > '\u0000') {
                    c10 = ',';
                    stringBuilder.append(c10);
                }
                object = (HashMap)arrayList3.get(c12);
                object2 = "media_id";
                object = String.valueOf(((HashMap)object).get(object2));
                stringBuilder.append((String)object);
            }
            ++c12;
        }
        object = stringBuilder.toString();
        object2 = string2;
        return c11.d(string2, (String)object);
    }

    public void a(AuthorizeListener authorizeListener, boolean bl2) {
        if (bl2) {
            this.b(authorizeListener);
            return;
        }
        c$1 c$1 = new c$1(this, authorizeListener);
        this.a(c$1);
    }

    public void a(String string2) {
        this.g = string2;
    }

    public void a(String object, PlatformActionListener platformActionListener) {
        block17: {
            int n10;
            HashMap<Object, Object> hashMap;
            block16: {
                hashMap = "com.twitter.android";
                n10 = 9;
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2 || platformActionListener == null) break block16;
                hashMap = "share text but text is null";
                object = new Throwable((String)((Object)hashMap));
                hashMap = this.getPlatform();
                platformActionListener.onError((Platform)((Object)hashMap), n10, (Throwable)object);
                return;
            }
            Object object2 = new Intent();
            String string2 = "android.intent.action.SEND";
            object2.setAction(string2);
            int n11 = 0x10000000;
            object2.addFlags(n11);
            object2.setPackage((String)((Object)hashMap));
            string2 = "com.twitter.composer.ComposerActivity";
            object2.setClassName((String)((Object)hashMap), string2);
            hashMap = "android.intent.extra.TEXT";
            object2.putExtra((String)((Object)hashMap), (String)object);
            hashMap = "text/plain";
            object2.setType((String)((Object)hashMap));
            hashMap = MobSDK.getContext();
            hashMap.startActivity((Intent)object2);
            hashMap = new HashMap<Object, Object>();
            object2 = "text";
            hashMap.put(object2, object);
            object = this.a;
            try {
                platformActionListener.onComplete((Platform)object, n10, hashMap);
            }
            catch (Throwable throwable) {
                if (platformActionListener == null) break block17;
                hashMap = SSDKLog.b();
                object2 = new StringBuilder();
                string2 = "Twitter system share text catch: ";
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(throwable);
                object2 = ((StringBuilder)object2).toString();
                ((NLog)((Object)hashMap)).w((String)object2);
                hashMap = this.getPlatform();
                platformActionListener.onError((Platform)((Object)hashMap), n10, throwable);
            }
        }
    }

    public void a(String string2, String string3) {
        this.c.a(string2, string3);
    }

    public void a(String string2, String string3, String string4) {
        this.c.a(string2, string3, string4);
        this.a(string2);
        this.b(string3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String var1_1, String var2_3, String var3_5, PlatformActionListener var4_6) {
        var5_8 = "com.twitter.android";
        var6_10 = 0;
        var7_11 = null;
        var8_12 = 9;
        var9_13 = TextUtils.isEmpty((CharSequence)var2_3);
        if (var9_13 == 0) ** GOTO lbl31
        var10_14 = TextUtils.isEmpty((CharSequence)var3_6);
        if (var10_14) ** GOTO lbl29
        try {
            var2_3 = MobSDK.getContext();
            var2_3 = BitmapHelper.downloadBitmap((Context)var2_3, (String)var3_6);
            ** GOTO lbl31
        }
        catch (Throwable var2_4) {
            if (var4_7 == null) ** GOTO lbl29
            try {
                var3_6 = new HashMap<String, Object>();
                var5_8 = "used imageUrl but download image catch: ";
                var3_6.append(var5_8);
                var2_5 = var2_4.getMessage();
                var3_6.append((String)var2_5);
                var2_5 = var3_6.toString();
                var1_1 = new Throwable((String)var2_5);
                var2_5 = this.getPlatform();
                var4_7.onError((Platform)var2_5, var8_12, (Throwable)var1_1);
                return;
lbl29:
                // 2 sources

                var10_14 = false;
                var2_3 = null;
lbl31:
                // 3 sources

                var3_6 = SSDKLog.b();
                var7_11 = new StringBuilder();
                var11_15 = "shareImage bypassApproval and resultPath is: ";
                var7_11.append((String)var11_15);
                var7_11.append((String)var2_3);
                var7_11 = var7_11.toString();
                var3_6.w((String)var7_11);
                var3_6 = new HashMap<String, Object>();
                var7_11 = "android.intent.action.SEND";
                var3_6.setAction((String)var7_11);
                var6_10 = 0x10000000;
                var3_6.addFlags(var6_10);
                var3_6.setPackage(var5_8);
                var7_11 = "com.twitter.composer.ComposerActivity";
                var3_6.setClassName(var5_8, (String)var7_11);
                var6_10 = (int)TextUtils.isEmpty((CharSequence)var1_1);
                if (var6_10 == 0) {
                    var7_11 = "android.intent.extra.TEXT";
                    var3_6.putExtra((String)var7_11, (String)var1_1);
                }
                var6_10 = Build.VERSION.SDK_INT;
                var9_13 = 29;
                var12_16 = "android.intent.extra.STREAM";
                if (var6_10 >= var9_13) {
                    var6_10 = (int)TextUtils.isEmpty((CharSequence)var2_3);
                    if (var6_10 == 0) {
                        try {
                            var7_11 = new File((String)var2_3);
                            var11_15 = MobSDK.getContext();
                            var13_17 /* !! */  = new StringBuilder();
                            var14_20 /* !! */  = MobSDK.getContext();
                            var14_20 /* !! */  = var14_20 /* !! */ .getPackageName();
                            var13_17 /* !! */ .append((String)var14_20 /* !! */ );
                            var14_20 /* !! */  = ".cn.sharesdk.ShareSDKFileProvider";
                            var13_17 /* !! */ .append((String)var14_20 /* !! */ );
                            var13_17 /* !! */  = var13_17 /* !! */ .toString();
                            var7_11 = ShareSDKFileProvider.a((Context)var11_15, (String)var13_17 /* !! */ , (File)var7_11);
                            var11_15 = MobSDK.getContext();
                            var15_22 = 3;
                            var11_15.grantUriPermission(var5_8, (Uri)var7_11, var15_22);
                            var3_6.putExtra((String)var12_16, (Parcelable)var7_11);
                        }
                        catch (Exception var5_9) {
                            var7_11 = SSDKLog.b();
                            var11_15 = "ShareSDK";
                            var16_24 = 1;
                            var12_16 = new Object[var16_24];
                            var15_23 = false;
                            var13_18 = null;
                            var14_21 = new StringBuilder();
                            var17_25 = "doShareToQQ() getUriForFile exception:";
                            var14_21.append(var17_25);
                            var14_21.append(var5_9);
                            var5_8 = var14_21.toString();
                            var12_16[0] = var5_8;
                            var7_11.d(var11_15, var12_16);
                        }
                    }
                } else {
                    var5_8 = MobSDK.getContext();
                    var5_8 = ResHelper.pathToContentUri((Context)var5_8, (String)var2_3);
                    var7_11 = SSDKLog.b();
                    var11_15 = new StringBuilder();
                    var13_19 = "pathToContentUri uri: ";
                    var11_15.append(var13_19);
                    var11_15.append((Object)var5_8);
                    var11_15 = var11_15.toString();
                    var7_11.w((String)var11_15);
                    var3_6.putExtra((String)var12_16, (Parcelable)var5_8);
                }
                var5_8 = "image/*";
                var3_6.setType(var5_8);
                var5_8 = MobSDK.getContext();
                var5_8.startActivity((Intent)var3_6);
                var3_6 = new HashMap<String, Object>();
                var5_8 = "text";
                var3_6.put(var5_8, var1_1);
                var1_1 = "imagePath";
                var3_6.put((String)var1_1, var2_3);
                var1_1 = this.a;
                var4_7.onComplete((Platform)var1_1, var8_12, var3_6);
                return;
            }
            catch (Throwable var1_2) {
                if (var4_7 == null) return;
                var2_3 = SSDKLog.b();
                var3_6 = new HashMap<String, Object>();
                var5_8 = "Twitter system share image catch: ";
                var3_6.append(var5_8);
                var3_6.append(var1_2);
                var3_6 = var3_6.toString();
                var2_3.w((String)var3_6);
                var2_3 = this.getPlatform();
                var4_7.onError((Platform)var2_3, var8_12, var1_2);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(String var1_1, String[] var2_3, PlatformActionListener var3_4) {
        block72: {
            block70: {
                block71: {
                    var4_5 = 9;
                    var5_6 = Arrays.asList(var2_3);
                    var6_7 = new ArrayList();
                    var5_6 = var5_6.iterator();
                    while (true) {
                        block69: {
                            block68: {
                                block67: {
                                    block66: {
                                        var7_8 = var5_6.hasNext();
                                        var8_9 = "com.twitter.android";
                                        if (var7_8 == 0) break;
                                        var9_10 = var5_6.next();
                                        var9_10 = (String)var9_10;
                                        var10_11 = "http";
                                        var11_12 = var9_10.startsWith((String)var10_11);
                                        if (var11_12 != 0) break block66;
                                        var10_11 = "https";
                                        var11_12 = var9_10.startsWith((String)var10_11);
                                        if (var11_12 == 0) break block67;
                                    }
                                    var10_11 = MobSDK.getContext();
                                    var9_10 = BitmapHelper.downloadBitmap((Context)var10_11, (String)var9_10);
                                }
                                var10_11 = new File((String)var9_10);
                                var12_13 = var10_11.exists();
                                if (var12_13 == 0) continue;
                                var13_14 = MobSDK.getContext();
                                var14_15 = "images";
                                var13_14 = ResHelper.getCachePath((Context)var13_14, (String)var14_15);
                                var15_16 /* !! */  = new StringBuilder();
                                var16_17 = System.currentTimeMillis();
                                var15_16 /* !! */ .append(var16_17);
                                var18_18 = var10_11.getName();
                                var15_16 /* !! */ .append(var18_18);
                                var15_16 /* !! */  = var15_16 /* !! */ .toString();
                                var14_15 = new File((String)var13_14, (String)var15_16 /* !! */ );
                                var13_14 = var14_15.getAbsolutePath();
                                var14_15.createNewFile();
                                var7_8 = (int)ResHelper.copyFile((String)var9_10, (String)var13_14);
                                if (var7_8 == 0) break block68;
                                var10_11 = var14_15;
                            }
                            var7_8 = Build.VERSION.SDK_INT;
                            var12_13 = 29;
                            if (var7_8 < var12_13) break block69;
                            var9_10 = MobSDK.getContext();
                            var13_14 = new StringBuilder();
                            var14_15 = MobSDK.getContext();
                            var14_15 = var14_15.getPackageName();
                            var13_14.append((String)var14_15);
                            var14_15 = ".cn.sharesdk.ShareSDKFileProvider";
                            var13_14.append((String)var14_15);
                            var13_14 = var13_14.toString();
                            var9_10 = ShareSDKFileProvider.a((Context)var9_10, (String)var13_14, (File)var10_11);
                            var10_11 = MobSDK.getContext();
                            var12_13 = 3;
                            var10_11.grantUriPermission((String)var8_9, (Uri)var9_10, var12_13);
                            var6_7.add(var9_10);
                            continue;
                        }
                        var19_19 = 24;
                        if (var7_8 < var19_19) ** GOTO lbl104
                        var9_10 = MobSDK.getContext();
                        var8_9 = var10_11.getAbsolutePath();
                        var9_10 = ResHelper.pathToContentUri((Context)var9_10, (String)var8_9);
                        var6_7.add(var9_10);
                        continue;
lbl104:
                        // 1 sources

                        var9_10 = Uri.fromFile((File)var10_11);
                        var6_7.add(var9_10);
                        continue;
                        break;
                    }
                    var5_6 = new Intent();
                    var7_8 = 0x10000000;
                    var5_6.addFlags(var7_8);
                    var5_6.setPackage((String)var8_9);
                    var9_10 = "com.twitter.composer.ComposerActivity";
                    var5_6.setClassName((String)var8_9, (String)var9_10);
                    var7_8 = (int)TextUtils.isEmpty((CharSequence)var1_1);
                    if (var7_8 != 0) ** GOTO lbl128
                    var9_10 = "android.intent.extra.TEXT";
                    var5_6.putExtra((String)var9_10, (String)var1_1);
lbl128:
                    // 2 sources

                    var7_8 = var6_7.size();
                    var8_9 = "android.intent.action.SEND";
                    if (var7_8 > 0) ** GOTO lbl139
                    var5_6.setAction((String)var8_9);
                    var6_7 = "text/plain";
                    var5_6.setType((String)var6_7);
                    ** GOTO lbl189
lbl139:
                    // 1 sources

                    var7_8 = var6_7.size();
                    var11_12 = 1;
                    var13_14 = "image/*";
                    var14_15 = "android.intent.extra.STREAM";
                    if (var7_8 != var11_12) break block70;
                    var7_8 = 0;
                    var9_10 = null;
                    var10_11 = var6_7.get(0);
                    if (var10_11 == null) break block70;
                    var5_6.setAction((String)var8_9);
                    var8_9 = var6_7.get(0);
                    var8_9 = (Parcelable)var8_9;
                    var5_6.putExtra((String)var14_15, (Parcelable)var8_9);
                    var8_9 = URLConnection.getFileNameMap();
                    var6_7 = var6_7.get(0);
                    var6_7 = (Uri)var6_7;
                    var6_7 = var6_7.toString();
                    var6_7 = var8_9.getContentTypeFor((String)var6_7);
                    if (var6_7 == null) break block71;
                    var7_8 = var6_7.length();
                    if (var7_8 <= 0) break block71;
                    var13_14 = var6_7;
                }
                var5_6.setType((String)var13_14);
                ** GOTO lbl189
            }
            var9_10 = "android.intent.action.SEND_MULTIPLE";
            var5_6.setAction((String)var9_10);
            var5_6.putParcelableArrayListExtra((String)var14_15, (ArrayList)var6_7);
            var5_6.setType((String)var13_14);
lbl189:
            // 3 sources

            var6_7 = MobSDK.getContext();
            var6_7.startActivity((Intent)var5_6);
            var5_6 = new HashMap();
            var6_7 = "text";
            var5_6.put(var6_7, var1_1);
            var1_1 = "imageArray";
            var5_6.put(var1_1, var2_3);
            var1_1 = this.a;
            try {
                var3_4.onComplete((Platform)var1_1, var4_5, (HashMap)var5_6);
            }
            catch (Throwable var1_2) {
                if (var3_4 == null) break block72;
                var2_3 = SSDKLog.b();
                var5_6 = new StringBuilder();
                var6_7 = "Twitter system share multiple image catch: ";
                var5_6.append((String)var6_7);
                var5_6.append(var1_2);
                var5_6 = var5_6.toString();
                var2_3.w((String)var5_6);
                var2_3 = this.getPlatform();
                var3_4.onError((Platform)var2_3, var4_5, var1_2);
            }
        }
    }

    public HashMap b(String object, String object2) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = "nextCursor";
        Object object3 = new KVPair(string2, object2);
        arrayList.add(object3);
        try {
            ResHelper.parseLong((String)object);
            n10 = 1;
        }
        catch (Throwable throwable) {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            object3 = "user_id";
            object2 = new KVPair((String)object3, object);
            arrayList.add(object2);
        } else {
            object3 = "screen_name";
            object2 = new KVPair((String)object3, object);
            arrayList.add(object2);
        }
        object = this.c;
        string2 = "https://api.twitter.com/1.1/friends/list.json";
        object = ((cn.sharesdk.framework.utils.b)object).b(string2, arrayList);
        object2 = this.c;
        ArrayList arrayList2 = ((cn.sharesdk.framework.utils.b)object2).a((ArrayList)object);
        object3 = this.d;
        int n11 = this.c();
        String string3 = "/1.1/friends/list.json";
        object = ((cn.sharesdk.framework.a.b)object3).a(string2, arrayList, arrayList2, null, string3, n11);
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public void b(String string2) {
        this.h = string2;
    }

    public String c(String object) {
        String string2;
        ArrayList<KVPair> arrayList;
        String string3 = "https://api.twitter.com/oauth/access_token";
        try {
            arrayList = new ArrayList<KVPair>();
            string2 = "oauth_verifier";
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
        Object object2 = new KVPair(string2, object);
        arrayList.add((KVPair)object2);
        object = this.c;
        object = ((cn.sharesdk.framework.utils.b)object).a(string3, arrayList);
        object2 = this.c;
        ArrayList arrayList2 = ((cn.sharesdk.framework.utils.b)object2).a((ArrayList)object);
        object2 = this.d;
        string2 = null;
        String string4 = "/oauth/access_token";
        int n10 = this.c();
        return ((cn.sharesdk.framework.a.b)object2).a(string3, arrayList, null, arrayList2, string4, n10);
    }

    public HashMap c(String object, String object2) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = "nextCursor";
        Object object3 = new KVPair(string2, object2);
        arrayList.add(object3);
        try {
            ResHelper.parseLong((String)object);
            n10 = 1;
        }
        catch (Throwable throwable) {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            object3 = "user_id";
            object2 = new KVPair((String)object3, object);
            arrayList.add(object2);
        } else {
            object3 = "screen_name";
            object2 = new KVPair((String)object3, object);
            arrayList.add(object2);
        }
        object = this.c;
        string2 = "https://api.twitter.com/1.1/followers/list.json";
        object = ((cn.sharesdk.framework.utils.b)object).b(string2, arrayList);
        object2 = this.c;
        ArrayList arrayList2 = ((cn.sharesdk.framework.utils.b)object2).a((ArrayList)object);
        object3 = this.d;
        int n11 = this.c();
        String string3 = "/1.1/followers/list.json";
        object = ((cn.sharesdk.framework.a.b)object3).a(string2, arrayList, arrayList2, null, string3, n11);
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public HashMap d(String object) {
        int n10;
        long l10;
        ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
        try {
            l10 = ResHelper.parseLong((String)object);
        }
        catch (Throwable throwable) {
            l10 = 0L;
            object = null;
        }
        object = object == null ? this.a.getDb().getUserId() : String.valueOf(l10);
        Object object2 = new KVPair("user_id", object);
        arrayList.add((KVPair)object2);
        object = this.c;
        String string2 = "https://api.twitter.com/1.1/users/show.json";
        object = ((cn.sharesdk.framework.utils.b)object).b(string2, arrayList);
        ArrayList arrayList2 = this.c.a((ArrayList)object);
        object2 = this.d;
        int n11 = this.c();
        String string3 = "/1.1/users/show.json";
        object = ((cn.sharesdk.framework.a.b)object2).a(string2, arrayList, arrayList2, null, string3, n11);
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public HashMap d(String object, String object2) {
        int n10;
        int n11;
        String string2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string3 = "status";
        Object object3 = new KVPair(string3, object);
        arrayList.add(object3);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            object3 = "media_ids";
            object = new KVPair((String)object3, object2);
            arrayList.add(object);
        }
        object = this.c;
        string3 = "https://api.twitter.com/1.1/statuses/update.json";
        object = ((cn.sharesdk.framework.utils.b)object).a(string3, arrayList);
        object3 = this.d;
        object2 = this.c;
        ArrayList arrayList2 = ((cn.sharesdk.framework.utils.b)object2).a((ArrayList)object);
        if ((object = ((cn.sharesdk.framework.a.b)object3).a(string3, arrayList, null, arrayList2, string2 = "/1.1/statuses/update.json", n11 = this.c())) != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public HashMap e(String string2) {
        return this.d(string2, null);
    }

    public HashMap e(String string2, String object) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = this.c;
        String string3 = "https://api.twitter.com/1.1/statuses/update_with_media.json";
        object2 = ((cn.sharesdk.framework.utils.b)object2).a(string3, arrayList);
        ArrayList arrayList2 = this.c.a((ArrayList)object2);
        int n11 = 1;
        arrayList2.remove(n11);
        object2 = new KVPair("status", string2);
        arrayList.add(object2);
        KVPair kVPair = new KVPair("media[]", object);
        object2 = this.d;
        int n12 = this.c();
        String string4 = "/1.1/statuses/update_with_media.json";
        string2 = ((cn.sharesdk.framework.a.b)object2).a(string3, arrayList, kVPair, arrayList2, string4, n12);
        if (string2 != null && (n10 = string2.length()) > 0) {
            object = new Hashon();
            return ((Hashon)object).fromJson(string2);
        }
        return null;
    }

    public HashMap f(String string2, String string3) {
        String string4;
        boolean bl2;
        long l10 = ResHelper.getFileSize(string3);
        this.f = 0;
        Object object = this.a(string2, string3, l10);
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = (String)((HashMap)object).get(string4 = "media_id_string")))) && (string3 = this.b(string3, (String)object, l10)) != null) {
            return this.a((String)object, l10, string2);
        }
        return null;
    }

    public String getAuthorizeUrl() {
        block35: {
            String string2 = "oauth_token";
            Object object = "https://api.twitter.com/oauth/request_token";
            ArrayList<String[]> arrayList = new ArrayList<String[]>();
            Object object2 = "oauth_callback";
            Object object3 = this.getRedirectUri();
            Object object4 = new KVPair((String)object2, object3);
            arrayList.add((String[])object4);
            this.a((String)null, (String)null);
            object4 = this.c;
            object4 = ((cn.sharesdk.framework.utils.b)object4).a((String)object, arrayList);
            object2 = this.c;
            object3 = ((cn.sharesdk.framework.utils.b)object2).a((ArrayList)object4);
            object4 = this.d;
            object2 = null;
            Object object5 = "/oauth/request_token";
            int n10 = this.c();
            object4 = ((cn.sharesdk.framework.a.b)object4).a((String)object, arrayList, null, (ArrayList)object3, (String)object5, n10);
            if (object4 == null) {
                return null;
            }
            object = "&";
            object4 = ((String)object4).split((String)object);
            object = new HashMap();
            int n11 = ((String[])object4).length;
            object2 = null;
            object3 = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                object5 = object4[i10];
                if (object5 == null) continue;
                String string3 = "=";
                object5 = object5.split(string3);
                n10 = ((String[])object5).length;
                int n12 = 2;
                if (n10 < n12) continue;
                string3 = object5[0];
                n12 = 1;
                object5 = object5[n12];
                ((HashMap)object).put(string3, object5);
            }
            boolean bl2 = ((HashMap)object).containsKey(string2);
            if (!bl2) break block35;
            string2 = ((HashMap)object).get(string2);
            object4 = "oauth_token_secret";
            object4 = ((HashMap)object).get(object4);
            object4 = (String)object4;
            this.a(string2, (String)object4);
            object4 = "/oauth/authorize";
            int n13 = this.c();
            ShareSDK.logApiEvent((String)object4, n13);
            object4 = new StringBuilder();
            object = "https://api.twitter.com/oauth/authorize?oauth_token=";
            ((StringBuilder)object4).append((String)object);
            try {
                ((StringBuilder)object4).append(string2);
                return ((StringBuilder)object4).toString();
            }
            catch (Throwable throwable) {
                object4 = SSDKLog.b();
                ((NLog)object4).d(throwable);
            }
        }
        return null;
    }

    public cn.sharesdk.framework.authorize.c getAuthorizeWebviewClient(g g10) {
        b b10 = new b(g10);
        return b10;
    }

    public String getRedirectUri() {
        return this.c.a().e;
    }

    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d object) {
        d d10 = new d((cn.sharesdk.framework.authorize.d)object);
        object = this.g;
        d10.a((String)object);
        object = this.h;
        d10.b((String)object);
        return d10;
    }
}

