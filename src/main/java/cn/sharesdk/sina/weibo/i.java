/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.a.b;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.sina.weibo.c;
import cn.sharesdk.sina.weibo.d;
import cn.sharesdk.sina.weibo.e;
import cn.sharesdk.sina.weibo.f;
import cn.sharesdk.sina.weibo.g;
import cn.sharesdk.sina.weibo.h;
import cn.sharesdk.sina.weibo.i$1;
import cn.sharesdk.sina.weibo.i$2;
import cn.sharesdk.sina.weibo.sdk.a;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class i
extends cn.sharesdk.framework.e {
    private static i b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String[] g;
    private b h;

    private i(Platform object) {
        super((Platform)object);
        object = new String[]{"follow_app_official_microblog"};
        this.g = object;
        this.h = object = cn.sharesdk.framework.a.b.a();
    }

    public static /* synthetic */ Platform a(i i10) {
        return i10.a;
    }

    public static i a(Platform object) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i i10 = b;
            if (i10 == null) {
                b = i10 = new i((Platform)object);
            }
            object = b;
            return object;
        }
    }

    public static /* synthetic */ String a(i i10, String string2) {
        i10.f = string2;
        return string2;
    }

    private String a(Object[] objectArray, String string2) {
        if (objectArray == null) {
            return null;
        }
        int n10 = objectArray.length;
        return this.a(objectArray, string2, 0, n10);
    }

    private String a(Object[] objectArray, String string2, int n10, int n11) {
        int n12;
        if (objectArray == null) {
            return null;
        }
        CharSequence charSequence = "";
        if (string2 == null) {
            string2 = charSequence;
        }
        if ((n12 = n11 - n10) <= 0) {
            return charSequence;
        }
        charSequence = new StringBuilder(n12 *= 16);
        Object object = objectArray[n10];
        if (object != null) {
            object = objectArray[n10];
            ((StringBuilder)charSequence).append(object);
        }
        while (++n10 < n11) {
            ((StringBuilder)charSequence).append(string2);
            object = objectArray[n10];
            if (object == null) continue;
            object = objectArray[n10];
            ((StringBuilder)charSequence).append(object);
        }
        return ((StringBuilder)charSequence).toString();
    }

    private void a(AuthorizeListener authorizeListener) {
        Object object = this.g;
        object = this.a((Object[])object, ",");
        String string2 = this.c;
        String string3 = this.e;
        g g10 = new g(string2, string3, (String)object, authorizeListener);
        authorizeListener = MobSDK.getContext();
        g10.show((Context)authorizeListener, null);
        SSDKLog.b().w("SinaWeibo SDK Web showWebAuthActivity ");
    }

    public static /* synthetic */ Platform b(i i10) {
        return i10.a;
    }

    public static /* synthetic */ Platform c(i i10) {
        return i10.a;
    }

    public static /* synthetic */ Platform d(i i10) {
        return i10.a;
    }

    public static /* synthetic */ Platform e(i i10) {
        return i10.a;
    }

    public static /* synthetic */ String f(i i10) {
        return i10.f;
    }

    public static /* synthetic */ Platform g(i i10) {
        return i10.a;
    }

    public static /* synthetic */ Platform h(i i10) {
        return i10.a;
    }

    public static /* synthetic */ Platform i(i i10) {
        return i10.a;
    }

    public static /* synthetic */ Platform j(i i10) {
        return i10.a;
    }

    public HashMap a(int n10, int n11, String object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = this.c;
        String string3 = "source";
        Object object2 = new KVPair(string3, string2);
        arrayList.add(object2);
        try {
            ResHelper.parseLong((String)object);
            bl2 = true;
        }
        catch (Throwable throwable) {
            bl2 = false;
            object2 = null;
        }
        if (bl2) {
            string2 = "uid";
            object2 = new KVPair(string2, object);
            arrayList.add(object2);
        } else {
            string2 = "screen_name";
            object2 = new KVPair(string2, object);
            arrayList.add(object2);
        }
        Object object3 = String.valueOf(n10);
        object = new KVPair("count", object3);
        arrayList.add(object);
        Object object4 = String.valueOf(n11);
        object3 = new KVPair("page", object4);
        arrayList.add(object3);
        object3 = this.h;
        n11 = this.c();
        object = "https://api.weibo.com/2/statuses/user_timeline.json";
        object2 = "/2/statuses/user_timeline.json";
        object3 = ((b)object3).a((String)object, arrayList, (String)object2, n11);
        if (object3 != null) {
            object4 = new Hashon();
            return ((Hashon)object4).fromJson((String)object3);
        }
        return null;
    }

    public HashMap a(String string2, String object, HashMap object2, HashMap object3) {
        int n10;
        block20: {
            block21: {
                Object object4;
                Object object5;
                Object object6;
                ArrayList<Object> arrayList;
                block19: {
                    int n11;
                    int n12;
                    if (object == null) {
                        return null;
                    }
                    arrayList = new ArrayList<Object>();
                    if (object2 != null && (n12 = ((HashMap)object2).size()) > 0) {
                        object2 = ((HashMap)object2).entrySet().iterator();
                        while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                            object6 = object2.next();
                            object5 = (String)object6.getKey();
                            object6 = String.valueOf(object6.getValue());
                            object4 = new KVPair((String)object5, object6);
                            arrayList.add(object4);
                        }
                    }
                    object6 = this.c;
                    object4 = "source";
                    object2 = new KVPair((String)object4, object6);
                    arrayList.add(object2);
                    object2 = this.f;
                    if (object2 != null) {
                        object4 = "access_token";
                        object6 = new KVPair((String)object4, object2);
                        arrayList.add(object6);
                    }
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
                    object2 = "GET";
                    object3 = ((String)object).toUpperCase();
                    n11 = (int)(((String)object2).equals(object3) ? 1 : 0);
                    if (n11 == 0) break block19;
                    object = new NetworkHelper();
                    string2 = ((NetworkHelper)object).httpGet(string2, arrayList, null, null);
                    break block20;
                }
                object2 = "POST";
                object = ((String)object).toUpperCase();
                n10 = (int)(((String)object2).equals(object) ? 1 : 0);
                if (n10 == 0) break block21;
                object6 = new NetworkHelper();
                object4 = string2;
                try {
                    string2 = ((NetworkHelper)object6).httpPost(string2, arrayList, (KVPair)object5, null, null);
                    break block20;
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

    public void a(Platform$ShareParams object, PlatformActionListener object2) {
        Object object3;
        Object object4;
        String string2;
        String string3;
        String[] stringArray;
        int n10;
        Object object5;
        int n11;
        Object object6;
        block42: {
            if (object == null) {
                if (object2 != null) {
                    object = this.a;
                    int n12 = 9;
                    String string4 = "Please set params";
                    Throwable throwable = new Throwable(string4);
                    object2.onError((Platform)object, n12, throwable);
                }
                return;
            }
            object6 = ((InnerShareParams)object).getImageData();
            if (object6 == null && (n11 = TextUtils.isEmpty((CharSequence)(object6 = ((InnerShareParams)object).getImagePath()))) != 0 && (n11 = (int)(TextUtils.isEmpty((CharSequence)(object6 = ((InnerShareParams)object).getImageUrl())) ? 1 : 0)) == 0) {
                object6 = MobSDK.getContext();
                object5 = ((InnerShareParams)object).getImageUrl();
                object6 = BitmapHelper.downloadBitmap((Context)object6, (String)object5);
                object5 = new File((String)object6);
                n11 = (int)(((File)object5).exists() ? 1 : 0);
                if (n11 == 0) break block42;
                object6 = ((File)object5).getAbsolutePath();
                try {
                    ((InnerShareParams)object).setImagePath((String)object6);
                }
                catch (Throwable throwable) {
                    object5 = SSDKLog.b();
                    ((NLog)object5).d(throwable);
                }
            }
        }
        object6 = ((InnerShareParams)object).getImageArray();
        object5 = null;
        if (object6 != null && (n11 = ((String[])(object6 = ((InnerShareParams)object).getImageArray())).length) > 0) {
            object6 = ((InnerShareParams)object).getImageArray();
            object6 = Arrays.asList(object6);
            n10 = object6.size();
            stringArray = new String[n10];
            object6 = object6.iterator();
            int n13 = 0;
            string3 = null;
            while (true) {
                block44: {
                    boolean bl2;
                    block43: {
                        boolean bl3 = object6.hasNext();
                        if (!bl3) break;
                        string2 = object6.next();
                        object4 = "http";
                        bl2 = string2.startsWith((String)object4);
                        if (!bl2) break block43;
                        object4 = MobSDK.getContext();
                        string2 = BitmapHelper.downloadBitmap((Context)object4, (String)string2);
                    }
                    object4 = new File(string2);
                    boolean bl4 = ((File)object4).exists();
                    if (!bl4) break block44;
                    object3 = "/data/";
                    bl4 = string2.startsWith((String)object3);
                    if (!bl4) break block44;
                    object3 = MobSDK.getContext();
                    Object object7 = "images";
                    object3 = ResHelper.getCachePath((Context)object3, (String)object7);
                    StringBuilder stringBuilder = new StringBuilder();
                    long l10 = System.currentTimeMillis();
                    stringBuilder.append(l10);
                    object4 = ((File)object4).getName();
                    stringBuilder.append((String)object4);
                    object4 = stringBuilder.toString();
                    object7 = new File((String)object3, (String)object4);
                    object4 = ((File)object7).getAbsolutePath();
                    ((File)object7).createNewFile();
                    bl2 = ResHelper.copyFile(string2, (String)object4);
                    if (!bl2) break block44;
                    string2 = ((File)object7).getAbsolutePath();
                }
                stringArray[n13] = string2;
                ++n13;
                continue;
                break;
            }
            try {
                ((InnerShareParams)object).setImageArray(stringArray);
            }
            catch (Throwable throwable) {
                stringArray = SSDKLog.b();
                stringArray.d(throwable);
            }
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object6 = ((InnerShareParams)object).getText()))) == 0) {
            stringArray = this.getPlatform();
            object6 = stringArray.getShortLintk((String)object6, false);
            ((InnerShareParams)object).setText((String)object6);
        }
        object3 = new i$1(this, (PlatformActionListener)object2, (Platform$ShareParams)object);
        object2 = this.g;
        string2 = this.a((Object[])object2, ",");
        stringArray = this.c;
        string3 = this.e;
        object5 = object2;
        object4 = object;
        object2 = new f((String)stringArray, string3, string2, (Platform$ShareParams)object, (AuthorizeListener)object3);
        object = MobSDK.getContext();
        ((FakeActivity)object2).show((Context)object, null);
    }

    public void a(AuthorizeListener authorizeListener, boolean bl2) {
        if (bl2) {
            this.a(authorizeListener);
            return;
        }
        Object object = this.g;
        object = this.a((Object[])object, ",");
        String string2 = this.c;
        String string3 = this.e;
        d d10 = new d(string2, string3, (String)object, authorizeListener);
        authorizeListener = MobSDK.getContext();
        d10.show((Context)authorizeListener, null);
        SSDKLog.b().w("SinaWeibo SDK Client doAuthorize ");
    }

    public void a(String string2) {
        this.e = string2;
    }

    public void a(String string2, String string3) {
        this.c = string2;
        this.d = string3;
    }

    public void a(String[] stringArray) {
        int n10;
        if (stringArray != null && (n10 = stringArray.length) > 0) {
            this.g = stringArray;
        }
    }

    public boolean a() {
        String string2;
        Object object;
        String string3;
        Object object2;
        Object object3;
        String string4;
        block37: {
            string4 = "remind_in";
            object3 = new ArrayList();
            String string5 = this.c;
            object2 = new KVPair("client_id", string5);
            ((ArrayList)object3).add(object2);
            string5 = this.d;
            object2 = new KVPair("client_secret", string5);
            ((ArrayList)object3).add(object2);
            string5 = this.e;
            object2 = new KVPair("redirect_uri", string5);
            ((ArrayList)object3).add(object2);
            string3 = "refresh_token";
            object2 = new KVPair("grant_type", string3);
            ((ArrayList)object3).add(object2);
            string5 = this.a.getDb().get(string3);
            object2 = new KVPair(string3, string5);
            ((ArrayList)object3).add(object2);
            object2 = "https://api.weibo.com/oauth2/access_token";
            string5 = null;
            try {
                object = this.h;
                string2 = "/oauth2/access_token";
            }
            catch (Throwable throwable) {
                SSDKLog.b().d(throwable);
                return false;
            }
            int n10 = this.c();
            object3 = ((b)object).b((String)object2, (ArrayList)object3, string2, n10);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
            if (bl2) {
                return false;
            }
            object2 = "error";
            bl2 = ((String)object3).contains((CharSequence)object2);
            if (bl2) {
                return false;
            }
            object2 = "error_code";
            bl2 = ((String)object3).contains((CharSequence)object2);
            if (!bl2) break block37;
            return false;
        }
        object2 = new Hashon();
        object3 = ((Hashon)object2).fromJson((String)object3);
        object2 = "uid";
        object2 = ((HashMap)object3).get(object2);
        object2 = String.valueOf(object2);
        object = "expires_in";
        object = ((HashMap)object3).get(object);
        object = String.valueOf(object);
        string2 = "access_token";
        string2 = ((HashMap)object3).get(string2);
        string2 = String.valueOf(string2);
        this.f = string2;
        string2 = ((HashMap)object3).get(string3);
        string2 = String.valueOf(string2);
        object3 = ((HashMap)object3).get(string4);
        object3 = String.valueOf(object3);
        Object object4 = this.a;
        object4 = ((Platform)object4).getDb();
        ((PlatformDb)object4).putUserId((String)object2);
        object2 = this.a;
        object2 = ((Platform)object2).getDb();
        object = Long.valueOf((String)object);
        long l10 = (Long)object;
        ((PlatformDb)object2).putExpiresIn(l10);
        object2 = this.a;
        object2 = ((Platform)object2).getDb();
        object = this.f;
        ((PlatformDb)object2).putToken((String)object);
        object2 = this.a;
        object2 = ((Platform)object2).getDb();
        ((PlatformDb)object2).put(string3, string2);
        object2 = this.a;
        object2 = ((Platform)object2).getDb();
        ((PlatformDb)object2).put(string4, (String)object3);
        return true;
    }

    public String b(String object) {
        ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
        String string2 = this.c;
        KVPair kVPair = new KVPair("client_id", string2);
        arrayList.add(kVPair);
        string2 = this.d;
        kVPair = new KVPair("client_secret", string2);
        arrayList.add(kVPair);
        string2 = this.e;
        kVPair = new KVPair("redirect_uri", string2);
        arrayList.add(kVPair);
        kVPair = new KVPair("grant_type", "authorization_code");
        arrayList.add(kVPair);
        kVPair = new KVPair("code", object);
        arrayList.add(kVPair);
        object = this.h;
        int n10 = this.c();
        String string3 = "/oauth2/access_token";
        object = ((b)object).b("https://api.weibo.com/oauth2/access_token", arrayList, string3, n10);
        int n11 = this.c();
        ShareSDK.logApiEvent(string3, n11);
        return object;
    }

    public HashMap b(int n10, int n11, String object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = this.c;
        String string2 = "source";
        Object object3 = new KVPair(string2, object2);
        arrayList.add(object3);
        object3 = this.f;
        if (object3 != null) {
            string2 = "access_token";
            object2 = new KVPair(string2, object3);
            arrayList.add(object2);
        }
        boolean bl2 = true;
        try {
            ResHelper.parseLong((String)object);
        }
        catch (Throwable throwable) {
            bl2 = false;
            object3 = null;
        }
        if (bl2) {
            object2 = "uid";
            object3 = new KVPair((String)object2, object);
            arrayList.add(object3);
        } else {
            object2 = "screen_name";
            object3 = new KVPair((String)object2, object);
            arrayList.add(object3);
        }
        Object object4 = String.valueOf(n10);
        object = new KVPair("count", object4);
        arrayList.add(object);
        Object object5 = String.valueOf(n11);
        object4 = new KVPair("cursor", object5);
        arrayList.add(object4);
        object4 = this.h;
        n11 = this.c();
        object = "https://api.weibo.com/2/friendships/friends.json";
        object3 = "/2/friendships/friends.json";
        object4 = ((b)object4).a((String)object, arrayList, (String)object3, n11);
        if (object4 != null) {
            object5 = new Hashon();
            return ((Hashon)object5).fromJson((String)object4);
        }
        return null;
    }

    public void b(Platform$ShareParams platform$ShareParams, PlatformActionListener object) {
        String string2;
        Object object2;
        Object object3 = platform$ShareParams.getUrl();
        int n10 = TextUtils.isEmpty((CharSequence)object3);
        if (n10 != 0) {
            object3 = platform$ShareParams.getText();
        } else {
            object3 = new StringBuilder();
            object2 = platform$ShareParams.getText();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(" ");
            object2 = platform$ShareParams.getUrl();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl2) {
            object2 = this.a;
            string2 = null;
            object3 = ((Platform)object2).getShortLintk((String)object3, false);
            platform$ShareParams.setText((String)object3);
        } else {
            object3 = MobSDK.getContext();
            n10 = ResHelper.getStringRes((Context)object3, (String)(object2 = "ssdk_weibo_upload_content"));
            if (n10 > 0) {
                object2 = MobSDK.getContext().getResources();
                object3 = object2.getString(n10);
                platform$ShareParams.setText((String)object3);
            }
        }
        object3 = new i$2(this, (PlatformActionListener)object, platform$ShareParams);
        object = new h();
        object2 = this.c;
        string2 = this.f;
        ((h)object).a((String)object2, string2);
        ((h)object).a(platform$ShareParams);
        ((h)object).a((AuthorizeListener)object3);
        platform$ShareParams = MobSDK.getContext();
        ((FakeActivity)object).show((Context)platform$ShareParams, null);
    }

    public boolean b() {
        String string2 = "android.intent.action.SEND";
        Intent intent = new Intent(string2);
        intent.setPackage("com.sina.weibo");
        String string3 = "image/*";
        intent.setType(string3);
        PackageManager packageManager = MobSDK.getContext().getPackageManager();
        boolean bl2 = false;
        intent = packageManager.resolveActivity(intent, 0);
        if (intent == null) {
            intent = new Intent(string2);
            intent.setPackage("com.sina.weibog3");
            intent.setType(string3);
            string2 = MobSDK.getContext().getPackageManager();
            intent = string2.resolveActivity(intent, 0);
        }
        if (intent != null) {
            bl2 = true;
        }
        return bl2;
    }

    public HashMap c(int n10, int n11, String object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = this.c;
        String string2 = "source";
        Object object3 = new KVPair(string2, object2);
        arrayList.add(object3);
        object3 = this.f;
        if (object3 != null) {
            string2 = "access_token";
            object2 = new KVPair(string2, object3);
            arrayList.add(object2);
        }
        boolean bl2 = true;
        try {
            ResHelper.parseLong((String)object);
        }
        catch (Throwable throwable) {
            bl2 = false;
            object3 = null;
        }
        if (bl2) {
            object2 = "uid";
            object3 = new KVPair((String)object2, object);
            arrayList.add(object3);
        } else {
            object2 = "screen_name";
            object3 = new KVPair((String)object2, object);
            arrayList.add(object3);
        }
        Object object4 = String.valueOf(n10);
        object = new KVPair("count", object4);
        arrayList.add(object);
        Object object5 = String.valueOf(n11);
        object4 = new KVPair("page", object5);
        arrayList.add(object4);
        object4 = this.h;
        n11 = this.c();
        object = "https://api.weibo.com/2/friendships/friends/bilateral.json";
        object3 = "/2/friendships/friends/bilateral.json";
        object4 = ((b)object4).a((String)object, arrayList, (String)object3, n11);
        if (object4 != null) {
            object5 = new Hashon();
            return ((Hashon)object5).fromJson((String)object4);
        }
        return null;
    }

    public void c(String string2) {
        this.f = string2;
    }

    public HashMap d(int n10, int n11, String object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = this.c;
        String string2 = "source";
        Object object3 = new KVPair(string2, object2);
        arrayList.add(object3);
        object3 = this.f;
        if (object3 != null) {
            string2 = "access_token";
            object2 = new KVPair(string2, object3);
            arrayList.add(object2);
        }
        boolean bl2 = true;
        try {
            ResHelper.parseLong((String)object);
        }
        catch (Throwable throwable) {
            bl2 = false;
            object3 = null;
        }
        if (bl2) {
            object2 = "uid";
            object3 = new KVPair((String)object2, object);
            arrayList.add(object3);
        } else {
            object2 = "screen_name";
            object3 = new KVPair((String)object2, object);
            arrayList.add(object3);
        }
        Object object4 = String.valueOf(n10);
        object = new KVPair("count", object4);
        arrayList.add(object);
        Object object5 = String.valueOf(n11);
        object4 = new KVPair("cursor", object5);
        arrayList.add(object4);
        object4 = this.h;
        n11 = this.c();
        object = "https://api.weibo.com/2/friendships/followers.json";
        object3 = "/2/friendships/followers.json";
        object4 = ((b)object4).a((String)object, arrayList, (String)object3, n11);
        if (object4 != null) {
            object5 = new Hashon();
            return ((Hashon)object5).fromJson((String)object4);
        }
        return null;
    }

    public HashMap d(String object) {
        Object object2 = new ArrayList();
        Object object3 = this.c;
        String string2 = "source";
        Object object4 = new KVPair(string2, object3);
        ((ArrayList)object2).add(object4);
        object4 = this.f;
        if (object4 != null) {
            string2 = "access_token";
            object3 = new KVPair(string2, object4);
            ((ArrayList)object2).add(object3);
        }
        int n10 = 1;
        try {
            ResHelper.parseLong((String)object);
        }
        catch (Throwable throwable) {
            n10 = 0;
            object4 = null;
        }
        if (n10 != 0) {
            object3 = "uid";
            object4 = new KVPair((String)object3, object);
            ((ArrayList)object2).add(object4);
        } else {
            object3 = "screen_name";
            object4 = new KVPair((String)object3, object);
            ((ArrayList)object2).add(object4);
        }
        object = this.h;
        n10 = this.c();
        object3 = "https://api.weibo.com/2/users/show.json";
        string2 = "/2/users/show.json";
        object = ((b)object).a((String)object3, (ArrayList)object2, string2, n10);
        if (object != null) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public boolean d() {
        Intent intent = new Intent();
        intent.setAction("com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER");
        Object object = MobSDK.getContext().getPackageName();
        intent.putExtra("_weibo_sdkVersion", "0031405000");
        intent.putExtra("_weibo_appPackage", (String)object);
        CharSequence charSequence = this.c;
        intent.putExtra("_weibo_appKey", (String)charSequence);
        intent.putExtra("_weibo_flag", 538116905);
        object = cn.sharesdk.sina.weibo.sdk.a.a(MobSDK.getContext(), (String)object);
        intent.putExtra("_weibo_sign", (String)object);
        object = SSDKLog.b();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("intent=");
        ((StringBuilder)charSequence).append(intent);
        ((StringBuilder)charSequence).append(", extra=");
        Object[] objectArray = intent.getExtras();
        ((StringBuilder)charSequence).append(objectArray);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray = new Object[]{};
        ((NLog)object).d(charSequence, objectArray);
        MobSDK.getContext().sendBroadcast(intent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
        return true;
    }

    public HashMap e(String object) {
        int n10;
        Object object2 = new ArrayList();
        String string2 = this.c;
        KVPair kVPair = new KVPair("source", string2);
        ((ArrayList)object2).add(kVPair);
        string2 = this.f;
        String string3 = "access_token";
        kVPair = new KVPair(string3, string2);
        ((ArrayList)object2).add(kVPair);
        try {
            ResHelper.parseLong((String)object);
            n10 = 1;
        }
        catch (Throwable throwable) {
            n10 = 0;
            kVPair = null;
        }
        if (n10 != 0) {
            string2 = "uid";
            kVPair = new KVPair(string2, object);
            ((ArrayList)object2).add(kVPair);
        } else {
            string2 = "screen_name";
            kVPair = new KVPair(string2, object);
            ((ArrayList)object2).add(kVPair);
        }
        object = this.h;
        n10 = this.c();
        string2 = "https://api.weibo.com/2/friendships/create.json";
        string3 = "/2/friendships/create.json";
        object = ((b)object).b(string2, (ArrayList)object2, string3, n10);
        if (object != null) {
            object2 = new Hashon();
            return ((Hashon)object2).fromJson((String)object);
        }
        return null;
    }

    public String getAuthorizeUrl() {
        return "";
    }

    public cn.sharesdk.framework.authorize.c getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.g g10) {
        c c10 = new c(g10);
        return c10;
    }

    public String getRedirectUri() {
        String string2 = this.e;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        string2 = bl2 ? "https://api.weibo.com/oauth2/default.html" : this.e;
        return string2;
    }

    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d object) {
        e e10 = new e((cn.sharesdk.framework.authorize.d)object);
        e10.a(32973);
        object = this.c;
        String string2 = this.e;
        String[] stringArray = this.g;
        e10.a((String)object, string2, stringArray);
        return e10;
    }
}

