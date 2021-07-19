/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.tencent.qq;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.f;
import cn.sharesdk.tencent.qq.b;
import cn.sharesdk.tencent.qq.c$1;
import cn.sharesdk.tencent.qq.c$2;
import cn.sharesdk.tencent.qq.c$3;
import cn.sharesdk.tencent.qq.d;
import cn.sharesdk.tencent.qq.e;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscribable;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.RxMob$Thread;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class c
extends cn.sharesdk.framework.e {
    private static final String[] b = new String[]{"get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t"};
    private static c c;
    private String d;
    private String[] e;
    private String f;
    private String g;
    private String h;
    private String i;

    private c(Platform platform) {
        super(platform);
        this.b();
    }

    public static c a(Platform platform) {
        c c10 = c;
        if (c10 == null) {
            c = c10 = new c(platform);
        }
        return c;
    }

    public static /* synthetic */ String a(c c10) {
        return c10.h;
    }

    public static /* synthetic */ String a(c c10, String string2) {
        c10.g = string2;
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2, String object, String object2, String object3, String string3, String object4, PlatformActionListener platformActionListener) {
        int n10 = 9;
        try {
            int n11;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
            if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)string3))) {
                bl2 = false;
                object = null;
            } else {
                bl2 = true;
            }
            object4 = !bl2 ? "/t/add_t" : "/t/add_pic_t";
            Object object5 = object4;
            object4 = new StringBuilder();
            Object object6 = "https://graph.qq.com";
            ((StringBuilder)object4).append((String)object6);
            ((StringBuilder)object4).append((String)object5);
            String string4 = ((StringBuilder)object4).toString();
            ArrayList<Object> arrayList = new ArrayList<Object>();
            object6 = "oauth_consumer_key";
            Object object7 = this.d;
            object4 = new KVPair((String)object6, object7);
            arrayList.add(object4);
            object6 = "access_token";
            object7 = this.h;
            object4 = new KVPair((String)object6, object7);
            arrayList.add(object4);
            object6 = "openid";
            object7 = this.f;
            object4 = new KVPair((String)object6, object7);
            arrayList.add(object4);
            object6 = "format";
            object7 = "json";
            object4 = new KVPair((String)object6, object7);
            arrayList.add(object4);
            object6 = "content";
            object4 = new KVPair((String)object6, object2);
            arrayList.add(object4);
            if (bl2) {
                bl2 = TextUtils.isEmpty((CharSequence)object3);
                if (bl2) {
                    object = MobSDK.getContext();
                    object3 = BitmapHelper.downloadBitmap((Context)object, (String)string3);
                }
                object = "pic";
                object7 = new KVPair((String)object, object3);
                object6 = cn.sharesdk.framework.a.b.a();
                int n12 = this.c();
                object = ((cn.sharesdk.framework.a.b)object6).a(string4, arrayList, (KVPair)object7, (String)object5, n12);
            } else {
                object = cn.sharesdk.framework.a.b.a();
                n11 = this.c();
                object = ((cn.sharesdk.framework.a.b)object).b(string4, arrayList, (String)object5, n11);
            }
            if (object == null) return;
            n11 = ((String)object).length();
            if (n11 <= 0) return;
            if (platformActionListener == null) return;
            object2 = new Hashon();
            object2 = ((Hashon)object2).fromJson((String)object);
            object3 = "ret";
            object3 = ((HashMap)object2).get(object3);
            int n13 = (Integer)(object3 = (Integer)object3);
            if (n13 != 0) {
                object2 = this.a;
                object3 = new Exception((String)object);
                platformActionListener.onError((Platform)object2, n10, (Throwable)object3);
                return;
            }
            object = this.a;
            platformActionListener.onComplete((Platform)object, n10, (HashMap)object2);
            return;
        }
        catch (Throwable throwable) {
            if (platformActionListener == null) return;
            object2 = this.a;
            platformActionListener.onError((Platform)object2, n10, throwable);
        }
    }

    public static /* synthetic */ Platform b(c c10) {
        return c10.a;
    }

    public static /* synthetic */ String c(c c10) {
        return c10.g;
    }

    public static /* synthetic */ Platform d(c c10) {
        return c10.a;
    }

    private String d() {
        String[] stringArray = this.e;
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

    public static /* synthetic */ Platform e(c c10) {
        return c10.a;
    }

    public static /* synthetic */ Platform f(c c10) {
        return c10.a;
    }

    public void a() {
        Object object = new c$2(this);
        object = RxMob.create((RxMob$OnSubscribe)object);
        Object object2 = RxMob$Thread.NEW_THREAD;
        ((RxMob$Subscribable)object).subscribeOn((RxMob$Thread)((Object)object2));
        object2 = RxMob$Thread.IMMEDIATE;
        ((RxMob$Subscribable)object).observeOn((RxMob$Thread)((Object)object2));
        object2 = new c$3(this);
        ((RxMob$Subscribable)object).subscribe((RxMob$Subscriber)object2);
    }

    public void a(Platform platform, Platform$ShareParams platform$ShareParams, PlatformActionListener platformActionListener) {
        HashMap<String, Platform$ShareParams> hashMap = new HashMap<String, Platform$ShareParams>();
        String string2 = this.i;
        ((f)((Object)hashMap)).a(string2, "com.tencent.mobileqq.activity.JumpActivity");
        ((f)((Object)hashMap)).a(platform$ShareParams, platform);
        hashMap = new HashMap<String, Platform$ShareParams>();
        hashMap.put("ShareParams", platform$ShareParams);
        platformActionListener.onComplete(platform, 9, hashMap);
    }

    public void a(AuthorizeListener authorizeListener, boolean bl2) {
        c$1 c$1 = new c$1(this, authorizeListener);
        this.a(c$1);
    }

    public void a(String string2) {
        this.d = string2;
    }

    public void a(String string2, String string3, String string4, String string5, String objectArray, String string6, PlatformActionListener objectArray2, boolean bl2, int n10, String string7, String string8, String string9, int n11) {
        c c10 = this;
        Object object = string5;
        Context context = objectArray2;
        int n12 = 0;
        Intent intent = null;
        int n13 = 1;
        String string10 = "ShareSDK";
        if (bl2) {
            this.a(string2, string3, string4, string5, (String)objectArray, string6, (PlatformActionListener)objectArray2);
            object = SSDKLog.b();
            context = new Object[n13];
            String string11 = " QQ QQHelper addShare weiboShare ";
            context[0] = string11;
            ((NLog)object).d(string10, (Object[])context);
        } else {
            boolean bl3 = this.b();
            if (bl3) {
                Object object2;
                boolean bl4;
                Object object3;
                Object object4 = SSDKLog.b();
                Object object5 = new Object[n13];
                object5[0] = object3 = " QQ QQHelper addShare isQQInstalled ";
                ((NLog)object4).d(string10, (Object[])object5);
                bl3 = TextUtils.isEmpty((CharSequence)string5);
                if (!bl3 && (bl4 = ((File)(object4 = new File(string5))).exists()) && (bl4 = string5.startsWith((String)(object5 = "/data/")))) {
                    object5 = ResHelper.getCachePath(MobSDK.getContext(), "images");
                    StringBuilder stringBuilder = new StringBuilder();
                    long l10 = System.currentTimeMillis();
                    stringBuilder.append(l10);
                    object4 = ((File)object4).getName();
                    stringBuilder.append((String)object4);
                    object4 = stringBuilder.toString();
                    object3 = new File((String)object5, (String)object4);
                    object4 = ((File)object3).getAbsolutePath();
                    boolean bl5 = ResHelper.copyFile(string5, (String)object4);
                    if (bl5) {
                        object = SSDKLog.b();
                        object2 = new Object[n13];
                        object5 = new StringBuilder();
                        object3 = " QQ QQHelper imagePath ";
                        ((StringBuilder)object5).append((String)object3);
                        ((StringBuilder)object5).append((String)object4);
                        object2[0] = object5 = ((StringBuilder)object5).toString();
                        ((NLog)object).d(string10, object2);
                        object = object4;
                    } else {
                        bl5 = false;
                        object = null;
                        object4 = SSDKLog.b();
                        object2 = new Object[n13];
                        object2[0] = object5 = " QQ QQHelper imagePath is null";
                        ((NLog)object4).d(string10, object2);
                    }
                }
                intent = new Intent();
                string10 = string2;
                intent.putExtra("title", string2);
                string10 = string3;
                intent.putExtra("titleUrl", string3);
                string10 = string4;
                intent.putExtra("summary", string4);
                intent.putExtra("imagePath", (String)object);
                object2 = objectArray;
                intent.putExtra("imageUrl", (String)objectArray);
                object2 = string6;
                intent.putExtra("musicUrl", string6);
                object = c10.d;
                intent.putExtra("appId", (String)object);
                n13 = n10;
                intent.putExtra("hidden", n10);
                object2 = string7;
                intent.putExtra("mini_program_appid", string7);
                object2 = string8;
                intent.putExtra("mini_program_path", string8);
                object2 = string9;
                intent.putExtra("mini_program_type", string9);
                n13 = n11;
                intent.putExtra("share_type", n11);
                object = new e();
                object2 = c10.a;
                ((e)object).a((Platform)object2, (PlatformActionListener)context);
                context = c10.d;
                ((e)object).a((String)context);
                context = MobSDK.getContext();
                ((FakeActivity)object).show(context, intent);
            } else if (objectArray2 != null) {
                object = this.a;
                n12 = 9;
                string10 = "QQClientNotExistException";
                Throwable throwable = new Throwable(string10);
                objectArray2.onError((Platform)object, n12, throwable);
            }
        }
    }

    public void a(String[] stringArray) {
        this.e = stringArray;
    }

    public void b(String string2) {
        this.f = string2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b() {
        void var2_27;
        block10: {
            try {
                String string2;
                Context context = MobSDK.getContext();
                PackageManager packageManager = context.getPackageManager();
                String string3 = "com.tencent.mobileqq";
                PackageInfo packageInfo = packageManager.getPackageInfo(string3, 0);
                String string4 = packageInfo.versionName;
                this.i = string2 = packageInfo.packageName;
            }
            catch (Throwable throwable) {
                String string5;
                try {
                    String string6;
                    Context context = MobSDK.getContext();
                    PackageManager packageManager = context.getPackageManager();
                    string5 = "com.tencent.tim";
                    PackageInfo packageInfo = packageManager.getPackageInfo(string5, 0);
                    string5 = packageInfo.versionName;
                    this.i = string6 = packageInfo.packageName;
                }
                catch (Throwable throwable2) {
                    try {
                        String string7;
                        Context context = MobSDK.getContext();
                        PackageManager packageManager = context.getPackageManager();
                        string5 = "com.tencent.minihd.qq";
                        PackageInfo packageInfo = packageManager.getPackageInfo(string5, 0);
                        string5 = packageInfo.versionName;
                        this.i = string7 = packageInfo.packageName;
                    }
                    catch (Throwable throwable3) {
                        try {
                            String string8;
                            Context context = MobSDK.getContext();
                            PackageManager packageManager = context.getPackageManager();
                            string5 = "com.tencent.mobileqqi";
                            PackageInfo packageInfo = packageManager.getPackageInfo(string5, 0);
                            string5 = packageInfo.versionName;
                            this.i = string8 = packageInfo.packageName;
                        }
                        catch (Throwable throwable4) {
                            try {
                                String string9;
                                Context context = MobSDK.getContext();
                                PackageManager packageManager = context.getPackageManager();
                                string5 = "com.tencent.qqlite";
                                PackageInfo packageInfo = packageManager.getPackageInfo(string5, 0);
                                string5 = packageInfo.versionName;
                                this.i = string9 = packageInfo.packageName;
                            }
                            catch (Throwable throwable5) {
                                Object var2_26 = null;
                                NLog nLog = SSDKLog.b();
                                nLog.d(throwable);
                                break block10;
                            }
                        }
                    }
                }
                String string10 = string5;
            }
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)var2_27);
        return !bl2;
    }

    public HashMap c(String object) {
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
        object2 = cn.sharesdk.framework.a.b.a();
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

    public void d(String string2) {
        this.h = string2;
    }

    public HashMap e(String object) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = this.h;
        object = new KVPair("access_token", object2);
        arrayList.add(object);
        object2 = this.d;
        object = new KVPair("oauth_consumer_key", object2);
        arrayList.add(object);
        object2 = this.f;
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
        object2 = cn.sharesdk.framework.a.b.a();
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

    public String getAuthorizeUrl() {
        int n10 = this.c();
        ShareSDK.logApiEvent("/oauth2.0/authorize", n10);
        String string2 = this.d();
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
        b b10 = new b(g10);
        return b10;
    }

    public String getRedirectUri() {
        return "auth://tauth.qq.com/";
    }

    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d object) {
        d d10 = new d((cn.sharesdk.framework.authorize.d)object);
        d10.a(5656);
        object = this.d;
        String string2 = this.d();
        String string3 = this.i;
        d10.a((String)object, string2, string3);
        return d10;
    }
}

