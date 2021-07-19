/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Base64
 */
package cn.sharesdk.tencent.qzone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.e;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.tencent.qzone.a;
import cn.sharesdk.tencent.qzone.b$1;
import cn.sharesdk.tencent.qzone.b$2;
import cn.sharesdk.tencent.qzone.b$3;
import cn.sharesdk.tencent.qzone.c;
import cn.sharesdk.tencent.qzone.d;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscribable;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$Thread;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class b
extends e {
    private static final String[] b = new String[]{"get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t"};
    private static b c;
    private String d;
    private String e;
    private String f;
    private String g;
    private cn.sharesdk.framework.a.b h;
    private String[] i;

    private b(Platform object) {
        super((Platform)object);
        this.h = object = cn.sharesdk.framework.a.b.a();
    }

    public static b a(Platform platform) {
        b b10 = c;
        if (b10 == null) {
            c = b10 = new b(platform);
        }
        return c;
    }

    public static /* synthetic */ String a(b b10) {
        return b10.f;
    }

    public static /* synthetic */ String a(b b10, String string2) {
        b10.g = string2;
        return string2;
    }

    public static /* synthetic */ Platform b(b b10) {
        return b10.a;
    }

    public static /* synthetic */ String c(b b10) {
        return b10.g;
    }

    public static /* synthetic */ Platform d(b b10) {
        return b10.a;
    }

    public static /* synthetic */ Platform e(b b10) {
        return b10.a;
    }

    private String e() {
        String[] stringArray = this.i;
        if (stringArray == null) {
            stringArray = b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = stringArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = stringArray[i10];
            if (n11 > 0) {
                char c10 = ',';
                stringBuilder.append(c10);
            }
            stringBuilder.append(string2);
            ++n11;
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ Platform f(b b10) {
        return b10.a;
    }

    private String f(String object) {
        int n10 = Build.VERSION.SDK_INT;
        String string2 = "";
        int n11 = 10;
        if (n10 > n11) {
            Object[] objectArray = "android.media.MediaMetadataRetriever";
            try {
                objectArray = ReflectHelper.getClass((String)objectArray);
            }
            catch (Throwable throwable) {}
            Object t10 = objectArray.newInstance();
            Object object2 = "setDataSource";
            int n12 = 1;
            Class[] classArray = new Class[n12];
            Class<String> clazz = String.class;
            classArray[0] = clazz;
            objectArray = objectArray.getMethod((String)object2, classArray);
            object2 = new Object[n12];
            object2[0] = object;
            objectArray.invoke(t10, object2);
            object = "extractMetadata";
            objectArray = new Object[n12];
            int n13 = 9;
            object2 = n13;
            objectArray[0] = object2;
            object = ReflectHelper.invokeInstanceMethod(t10, (String)object, objectArray);
            return (String)object;
        }
        return string2;
    }

    public HashMap a(String object, String object2) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = this.f;
        Object object3 = new KVPair("access_token", string2);
        arrayList.add(object3);
        string2 = this.d;
        object3 = new KVPair("oauth_consumer_key", string2);
        arrayList.add(object3);
        string2 = this.e;
        object3 = new KVPair("openid", string2);
        arrayList.add(object3);
        string2 = "format";
        Object object4 = "json";
        object3 = new KVPair(string2, object4);
        arrayList.add(object3);
        int n11 = TextUtils.isEmpty((CharSequence)object2);
        if (n11 == 0) {
            int n12;
            n11 = ((String)object2).length();
            if (n11 > (n12 = 200)) {
                object3 = new StringBuilder();
                int n13 = 199;
                object2 = ((String)object2).substring(0, n13);
                ((StringBuilder)object3).append((String)object2);
                object2 = MobSDK.getContext();
                string2 = MobSDK.getContext();
                object4 = "ssdk_symbol_ellipsis";
                n12 = ResHelper.getStringRes((Context)string2, (String)object4);
                object2 = object2.getString(n12);
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
            }
            string2 = "photodesc";
            object3 = new KVPair(string2, object2);
            arrayList.add(object3);
        }
        object2 = new KVPair("mobile", "1");
        arrayList.add(object2);
        object4 = new KVPair("picture", object);
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        object2 = new StringBuilder();
        object3 = System.getProperties().getProperty("http.agent");
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(" ArzenAndroidSDK");
        object2 = ((StringBuilder)object2).toString();
        object = new KVPair("User-Agent", object2);
        arrayList2.add(object);
        object3 = this.h;
        int n14 = this.c();
        string2 = "https://graph.qq.com/photo/upload_pic";
        String string3 = "/photo/upload_pic";
        object = ((cn.sharesdk.framework.a.b)object3).a(string2, arrayList, (KVPair)object4, arrayList2, string3, n14);
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public HashMap a(String string2, String object, HashMap object2, HashMap object3) {
        int n10;
        block19: {
            block20: {
                ArrayList arrayList;
                Object object4;
                Object object5;
                Object object6;
                ArrayList<Object> arrayList2;
                block18: {
                    int n11;
                    int n12;
                    if (object == null) {
                        return null;
                    }
                    arrayList2 = new ArrayList<Object>();
                    if (object2 != null && (n12 = ((HashMap)object2).size()) > 0) {
                        object2 = ((HashMap)object2).entrySet().iterator();
                        while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                            object6 = object2.next();
                            object5 = (String)object6.getKey();
                            object6 = String.valueOf(object6.getValue());
                            object4 = new KVPair((String)object5, object6);
                            arrayList2.add(object4);
                        }
                    }
                    object6 = this.f;
                    object2 = new KVPair("access_token", object6);
                    arrayList2.add(object2);
                    object6 = this.d;
                    object2 = new KVPair("oauth_consumer_key", object6);
                    arrayList2.add(object2);
                    object6 = this.e;
                    object2 = new KVPair("openid", object6);
                    arrayList2.add(object2);
                    object6 = "format";
                    object4 = "json";
                    object2 = new KVPair((String)object6, object4);
                    arrayList2.add(object2);
                    if (object3 != null && (n11 = ((HashMap)object3).size()) > 0) {
                        object2 = ((HashMap)object3).entrySet().iterator();
                        object3 = null;
                        while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                            object3 = object2.next();
                            object4 = (String)object3.getKey();
                            object3 = object3.getValue();
                            object3 = object6 = new KVPair((String)object4, object3);
                        }
                        object5 = object3;
                    } else {
                        object5 = null;
                    }
                    arrayList = new ArrayList();
                    object3 = new StringBuilder();
                    object6 = System.getProperties();
                    object4 = "http.agent";
                    object6 = ((Properties)object6).getProperty((String)object4);
                    ((StringBuilder)object3).append((String)object6);
                    ((StringBuilder)object3).append(" ArzenAndroidSDK");
                    object3 = ((StringBuilder)object3).toString();
                    object6 = "User-Agent";
                    object2 = new KVPair((String)object6, object3);
                    arrayList.add(object2);
                    object2 = "GET";
                    object3 = ((String)object).toUpperCase();
                    n11 = (int)(((String)object2).equals(object3) ? 1 : 0);
                    if (n11 == 0) break block18;
                    object = new NetworkHelper();
                    string2 = ((NetworkHelper)object).httpGet(string2, arrayList2, arrayList, null);
                    break block19;
                }
                object2 = "POST";
                object = ((String)object).toUpperCase();
                n10 = (int)(((String)object2).equals(object) ? 1 : 0);
                if (n10 == 0) break block20;
                object6 = new NetworkHelper();
                object4 = string2;
                try {
                    string2 = ((NetworkHelper)object6).httpPost(string2, arrayList2, (KVPair)object5, arrayList, null);
                    break block19;
                }
                catch (Throwable throwable) {
                    object = SSDKLog.b();
                    ((NLog)object).d(throwable);
                }
            }
            string2 = null;
        }
        if (string2 != null && (n10 = string2.length()) > 0) {
            object = new Hashon();
            return ((Hashon)object).fromJson(string2);
        }
        return null;
    }

    public void a() {
        Object object = new b$2(this);
        object = RxMob.create((RxMob$OnSubscribe)object);
        Object object2 = RxMob$Thread.NEW_THREAD;
        ((RxMob$Subscribable)object).subscribeOn((RxMob$Thread)((Object)object2));
        object2 = RxMob$Thread.IMMEDIATE;
        ((RxMob$Subscribable)object).observeOn((RxMob$Thread)((Object)object2));
        object2 = new b$3(this);
        ((RxMob$Subscribable)object).subscribe((RxMob$Subscriber)object2);
    }

    public void a(int n10, String string2, String string3, String string4, String string5, String string6, String string7, PlatformActionListener platformActionListener) {
        int n11;
        int n12;
        Object object;
        StringBuilder stringBuilder;
        CharSequence charSequence;
        Object[] objectArray;
        boolean bl2;
        String string8;
        b b10 = this;
        Object object2 = string5;
        Object object3 = string7;
        PlatformActionListener platformActionListener2 = platformActionListener;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string7);
        Object object4 = "3";
        String string9 = "1";
        CharSequence charSequence2 = null;
        String string10 = "4";
        if (!bl3) {
            string8 = string10;
        } else {
            bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (bl3 && (bl3 = TextUtils.isEmpty((CharSequence)string3))) {
                string8 = object4;
            } else {
                bl3 = TextUtils.isEmpty((CharSequence)string3);
                if (bl3) {
                    if (platformActionListener2 != null) {
                        int n13 = 9;
                        String string11 = "The param of title or titleUrl is null !";
                        object3 = new Throwable(string11);
                        platformActionListener2.onError(null, n13, (Throwable)object3);
                    }
                    return;
                }
                string8 = string9;
            }
        }
        boolean bl4 = TextUtils.isEmpty((CharSequence)string5);
        if (!bl4 && (bl2 = (objectArray = new File((String)object2)).exists()) && (bl2 = ((String)object2).startsWith((String)(charSequence = "/data/")))) {
            charSequence = ResHelper.getCachePath(MobSDK.getContext(), "images");
            stringBuilder = new StringBuilder();
            long l10 = System.currentTimeMillis();
            stringBuilder.append(l10);
            objectArray = objectArray.getName();
            stringBuilder.append((String)objectArray);
            objectArray = stringBuilder.toString();
            object = new File((String)charSequence, (String)objectArray);
            objectArray = ((File)object).getAbsolutePath();
            n12 = (int)(ResHelper.copyFile((String)object2, (String)objectArray) ? 1 : 0);
            if (n12 == 0) {
                bl4 = false;
                objectArray = null;
            }
        } else {
            objectArray = object2;
        }
        n12 = TextUtils.isEmpty((CharSequence)string4);
        bl2 = false;
        charSequence = null;
        if (n12 == 0 && (n12 = string4.length()) > (n11 = 600)) {
            object2 = string4;
            object2 = string4.substring(0, n11);
        } else {
            object2 = string4;
        }
        object = object2;
        stringBuilder = new StringBuilder();
        if (string8 != object4 && string8 != string10) {
            object2 = "mqqapi://share/to_qzone?src_type=app&version=1&file_type=news";
            stringBuilder.append((String)object2);
        } else {
            object2 = "mqqapi://qzone/publish?src_type=app&version=1&file_type=news";
            stringBuilder.append((String)object2);
        }
        n12 = (int)(TextUtils.isEmpty((CharSequence)objectArray) ? 1 : 0);
        String string12 = "utf-8";
        int n14 = 2;
        if (n12 == 0) {
            n12 = Build.VERSION.SDK_INT;
            int n15 = 29;
            charSequence2 = "&image_url=";
            if (n12 >= n15) {
                object2 = new File((String)objectArray);
                Context context = MobSDK.getContext();
                charSequence = new StringBuilder();
                Context context2 = MobSDK.getContext();
                object4 = context2.getPackageName();
                ((StringBuilder)charSequence).append((String)object4);
                object4 = ".cn.sharesdk.ShareSDKFileProvider";
                ((StringBuilder)charSequence).append((String)object4);
                object4 = ((StringBuilder)charSequence).toString();
                object2 = ShareSDKFileProvider.a(context, (String)object4, (File)object2);
                object4 = MobSDK.getContext();
                charSequence = "com.tencent.mobileqq";
                n15 = 3;
                object4.grantUriPermission((String)charSequence, (Uri)object2, n15);
                object4 = "&image_uri=";
                stringBuilder.append((String)object4);
                object2 = String.valueOf(object2);
                object2 = ((String)object2).getBytes(string12);
                object2 = Base64.encodeToString((byte[])object2, (int)n14);
                stringBuilder.append((String)object2);
                stringBuilder.append((String)charSequence2);
                object2 = objectArray.getBytes(string12);
                object2 = Base64.encodeToString((byte[])object2, (int)n14);
                try {
                    stringBuilder.append((String)object2);
                }
                catch (Throwable throwable) {
                    object4 = SSDKLog.b();
                    objectArray = new Object[1];
                    charSequence2 = new StringBuilder();
                    charSequence = "doShareToQzone() getUriForFile exception:";
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    ((StringBuilder)charSequence2).append(throwable);
                    object2 = ((StringBuilder)charSequence2).toString();
                    charSequence2 = null;
                    objectArray[0] = object2;
                    object2 = "ShareSDK";
                    ((NLog)object4).d(object2, objectArray);
                }
            } else {
                stringBuilder.append((String)charSequence2);
                object2 = Base64.encodeToString((byte[])objectArray.getBytes(string12), (int)n14);
                stringBuilder.append((String)object2);
            }
        }
        if ((n12 = (int)(TextUtils.isEmpty((CharSequence)string7) ? 1 : 0)) == 0 && (n12 = (int)(string8.equals(string10) ? 1 : 0)) != 0) {
            ResHelper.getFileSize(string7);
            object2 = String.valueOf(string6);
            object4 = b10.f((String)object3);
            charSequence2 = "&videoPath=";
            stringBuilder.append((String)charSequence2);
            object3 = Base64.encodeToString((byte[])((String)object3).getBytes(string12), (int)n14);
            stringBuilder.append((String)object3);
            object3 = "&videoSize=";
            stringBuilder.append((String)object3);
            object2 = Base64.encodeToString((byte[])((String)object2).getBytes(string12), (int)n14);
            stringBuilder.append((String)object2);
            n12 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
            if (n12 == 0) {
                stringBuilder.append("&videoDuration=");
                object2 = Base64.encodeToString((byte[])((String)object4).getBytes(string12), (int)n14);
                stringBuilder.append((String)object2);
            }
        }
        if ((n12 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) == 0) {
            stringBuilder.append("&title=");
            object3 = string2;
            object2 = Base64.encodeToString((byte[])string2.getBytes(string12), (int)n14);
            stringBuilder.append((String)object2);
        }
        if ((n12 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0)) == 0) {
            stringBuilder.append("&description=");
            object2 = Base64.encodeToString((byte[])((String)object).getBytes(string12), (int)n14);
            stringBuilder.append((String)object2);
        }
        stringBuilder.append("&share_id=");
        object2 = b10.d;
        stringBuilder.append((String)object2);
        n12 = (int)(TextUtils.isEmpty((CharSequence)string3) ? 1 : 0);
        if (n12 == 0) {
            stringBuilder.append("&url=");
            object3 = string3;
            object2 = Base64.encodeToString((byte[])string3.getBytes(string12), (int)n14);
            stringBuilder.append((String)object2);
        }
        stringBuilder.append("&app_name=");
        object3 = string6;
        object2 = Base64.encodeToString((byte[])string6.getBytes(string12), (int)n14);
        stringBuilder.append((String)object2);
        n12 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n12 == 0) {
            stringBuilder.append("&share_qq_ext_str=");
            object2 = Base64.encodeToString((byte[])((String)object).getBytes(), (int)n14);
            stringBuilder.append((String)object2);
        }
        stringBuilder.append("&req_type=");
        object2 = Base64.encodeToString((byte[])string8.getBytes(string12), (int)n14);
        stringBuilder.append((String)object2);
        n12 = (int)(this.d() ? 1 : 0);
        if (n12 == 0) {
            string9 = "0";
        }
        stringBuilder.append("&cflag=");
        object2 = Base64.encodeToString((byte[])string9.getBytes(string12), (int)n14);
        stringBuilder.append((String)object2);
        object2 = new Intent("android.intent.action.VIEW");
        object3 = Uri.parse((String)stringBuilder.toString());
        object2.setData((Uri)object3);
        object3 = MobSDK.getContext().getPackageManager();
        bl3 = true;
        object2 = object3.resolveActivity((Intent)object2, (int)(bl3 ? 1 : 0));
        if (object2 != null) {
            object2 = new d();
            object3 = stringBuilder.toString();
            ((d)object2).a((String)object3, bl3);
            ((d)object2).a(platformActionListener2);
            object3 = b10.d;
            ((d)object2).a((String)object3);
            object3 = MobSDK.getContext();
            platformActionListener2 = null;
            ((FakeActivity)object2).show((Context)object3, null);
        }
    }

    public void a(int n10, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, PlatformActionListener platformActionListener) {
        int n11;
        int n12 = TextUtils.isEmpty((CharSequence)string6);
        String string12 = n12 != 0 ? DeviceHelper.getInstance(MobSDK.getContext()).getAppName() : string6;
        int n13 = string12.length();
        if (n13 > (n11 = 20)) {
            StringBuilder stringBuilder = new StringBuilder();
            string12 = string12.substring(0, n11);
            stringBuilder.append(string12);
            stringBuilder.append("...");
            string12 = stringBuilder.toString();
        }
        String string13 = string12;
        n12 = TextUtils.isEmpty((CharSequence)string2);
        if (n12 == 0 && (n12 = string2.length()) > (n13 = 200)) {
            string12 = string2;
            string12 = string2.substring(0, n13);
        } else {
            string12 = string2;
        }
        this.a(n10, string12, string3, string4, string5, string13, string7, platformActionListener);
    }

    public void a(AuthorizeListener authorizeListener, boolean bl2) {
        b$1 b$1 = new b$1(this, authorizeListener);
        this.a(b$1);
    }

    public void a(String string2) {
        this.d = string2;
    }

    public void a(String[] stringArray) {
        this.i = stringArray;
    }

    public HashMap b(String object, String object2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)object) ^ 1;
        Object object3 = n11 != 0 ? "/t/add_pic_t" : "/t/add_t";
        String string2 = object3;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("https://graph.qq.com");
        ((StringBuilder)object3).append(string2);
        String string3 = ((StringBuilder)object3).toString();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object4 = this.d;
        object3 = new KVPair("oauth_consumer_key", object4);
        arrayList.add(object3);
        object4 = this.f;
        object3 = new KVPair("access_token", object4);
        arrayList.add(object3);
        object4 = this.e;
        object3 = new KVPair("openid", object4);
        arrayList.add(object3);
        Object object5 = "json";
        object3 = new KVPair("format", object5);
        arrayList.add(object3);
        object4 = "content";
        object3 = new KVPair((String)object4, object2);
        arrayList.add(object3);
        if (n11 != 0) {
            object2 = "pic";
            object5 = new KVPair((String)object2, object);
            object4 = this.h;
            int n12 = this.c();
            object = ((cn.sharesdk.framework.a.b)object4).a(string3, arrayList, (KVPair)object5, string2, n12);
        } else {
            object = this.h;
            n10 = this.c();
            object = ((cn.sharesdk.framework.a.b)object).b(string3, arrayList, string2, n10);
        }
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            Integer n13 = (Integer)((HashMap)(object2 = ((Hashon)object2).fromJson((String)object))).get("ret");
            n11 = n13;
            if (n11 == 0) {
                return object2;
            }
            object2 = new Throwable((String)object);
            throw object2;
        }
        return null;
    }

    public void b(String string2) {
        this.e = string2;
    }

    public boolean b() {
        int n10;
        String[] stringArray = "com.qzone";
        Object object = MobSDK.getContext();
        object = object.getPackageManager();
        try {
            stringArray = object.getPackageInfo((String)stringArray, 0);
            if (stringArray == null) {
                return false;
            }
            stringArray = stringArray.versionName;
            object = "\\.";
            stringArray = stringArray.split((String)object);
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return false;
        }
        int n11 = stringArray.length;
        int[] nArray = new int[n11];
        for (n10 = 0; n10 < n11; ++n10) {
            String string2 = stringArray[n10];
            int n12 = ResHelper.parseInt(string2);
            try {
                nArray[n10] = n12;
                continue;
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                nLog.d(throwable);
                nArray[n10] = 0;
            }
        }
        int n13 = 1;
        if (n11 > n13 && ((n11 = nArray[0]) >= (n10 = 4) || (n11 = nArray[n13]) >= n13)) {
            return n13 != 0;
        }
        return false;
    }

    public void c(String string2) {
        this.f = string2;
    }

    public HashMap d(String object) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = this.f;
        object = new KVPair("access_token", object2);
        arrayList.add(object);
        object2 = this.d;
        object = new KVPair("oauth_consumer_key", object2);
        arrayList.add(object);
        object2 = this.e;
        object = new KVPair("openid", object2);
        arrayList.add(object);
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        object2 = new StringBuilder();
        String string2 = System.getProperties().getProperty("http.agent");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" ArzenAndroidSDK");
        object2 = ((StringBuilder)object2).toString();
        object = new KVPair("User-Agent", object2);
        arrayList2.add(object);
        object2 = this.h;
        int n11 = this.c();
        string2 = "https://graph.qq.com/user/get_simple_userinfo";
        String string3 = "/user/get_simple_userinfo";
        object = ((cn.sharesdk.framework.a.b)object2).a(string2, arrayList, arrayList2, null, string3, n11);
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public boolean d() {
        boolean bl2;
        Object object = MobSDK.getContext();
        object = object.getPackageManager();
        Object object2 = "com.tencent.mobileqq";
        object = object.getPackageInfo((String)object2, 0);
        try {
            object = object.versionName;
        }
        catch (Throwable throwable) {
            object2 = MobSDK.getContext();
            object2 = object2.getPackageManager();
            String string2 = "com.tencent.tim";
            object2 = object2.getPackageInfo(string2, 0);
            try {
                object = ((PackageInfo)object2).versionName;
            }
            catch (Throwable throwable2) {
                object2 = MobSDK.getContext();
                object2 = object2.getPackageManager();
                string2 = "com.tencent.minihd.qq";
                object2 = object2.getPackageInfo(string2, 0);
                try {
                    object = ((PackageInfo)object2).versionName;
                }
                catch (Throwable throwable3) {
                    object2 = SSDKLog.b();
                    ((NLog)object2).d(throwable);
                    bl2 = false;
                    object = null;
                }
            }
        }
        bl2 = TextUtils.isEmpty((CharSequence)object);
        return !bl2;
    }

    public HashMap e(String object) {
        int n10;
        ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
        Object object2 = new KVPair("access_token", object);
        arrayList.add((KVPair)object2);
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        object2 = new StringBuilder();
        String string2 = System.getProperties().getProperty("http.agent");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" ArzenAndroidSDK");
        object2 = ((StringBuilder)object2).toString();
        object = new KVPair("User-Agent", object2);
        arrayList2.add(object);
        object2 = this.h;
        int n102 = this.c();
        string2 = "https://graph.qq.com/oauth2.0/me";
        String string3 = "/oauth2.0/me";
        object = ((cn.sharesdk.framework.a.b)object2).a(string2, arrayList, arrayList2, null, string3, n102);
        object2 = "callback";
        boolean n11 = ((String)object).startsWith((String)object2);
        if (n11) {
            int n12;
            int n13;
            while (true) {
                object2 = "{";
                int n14 = ((String)object).startsWith((String)object2);
                n13 = 1;
                if (n14 != 0 || (n14 = ((String)object).length()) <= 0) break;
                object = ((String)object).substring(n13);
            }
            while ((n12 = ((String)object).endsWith((String)(object2 = "}"))) == 0 && (n12 = ((String)object).length()) > 0) {
                n12 = 0;
                object2 = null;
                int n15 = ((String)object).length() - n13;
                object = ((String)object).substring(0, n15);
            }
        }
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public String getAuthorizeUrl() {
        int n10 = this.c();
        ShareSDK.logApiEvent("/oauth2.0/authorize", n10);
        String string2 = this.e();
        String string3 = this.getRedirectUri();
        Object object = "utf-8";
        try {
            string3 = Data.urlEncode(string3, (String)object);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            ((NLog)object).d(throwable);
            string3 = this.getRedirectUri();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=");
        String string4 = this.d;
        ((StringBuilder)object).append(string4);
        ((StringBuilder)object).append("&redirect_uri=");
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append("&display=mobile&scope=");
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
    }

    public cn.sharesdk.framework.authorize.c getAuthorizeWebviewClient(g g10) {
        a a10 = new a(g10);
        return a10;
    }

    public String getRedirectUri() {
        return "auth://tauth.qq.com/";
    }

    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d object) {
        c c10 = new c((cn.sharesdk.framework.authorize.d)object);
        c10.a(5656);
        object = this.d;
        String string2 = this.e();
        c10.a((String)object, string2);
        return c10;
    }
}

