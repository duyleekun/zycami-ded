/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.f;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.d$1;
import cn.sharesdk.framework.d$2;
import cn.sharesdk.framework.d$3;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import java.util.HashMap;

public class d
implements PlatformActionListener {
    private PlatformActionListener a;
    private HashMap b;
    private int c;

    public d() {
        HashMap hashMap;
        this.b = hashMap = new HashMap();
    }

    public static /* synthetic */ PlatformActionListener a(d d10) {
        return d10.a;
    }

    public static /* synthetic */ PlatformActionListener a(d d10, PlatformActionListener platformActionListener) {
        d10.a = platformActionListener;
        return platformActionListener;
    }

    private String a(Platform platform) {
        PlatformDb platformDb = platform.getDb();
        String[] stringArray = "nickname";
        Object object = "icon";
        String string2 = "gender";
        String string3 = "snsUserUrl";
        String string4 = "resume";
        String string5 = "secretType";
        String string6 = "secret";
        String string7 = "birthday";
        String string8 = "followerCount";
        String string9 = "favouriteCount";
        String string10 = "shareCount";
        String string11 = "snsregat";
        String string12 = "snsUserLevel";
        String string13 = "educationJSONArrayStr";
        String string14 = "workJSONArrayStr";
        try {
            stringArray = new String[]{stringArray, object, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14};
            return stringArray;
        }
        finally {
            object = this;
        }
    }

    private String a(PlatformDb object, String[] object2) {
        CharSequence charSequence = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = ((String[])object2).length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            String string2 = object2[i10];
            if (n11 > 0) {
                c10 = '|';
                stringBuilder.append(c10);
                ((StringBuilder)charSequence).append(c10);
            }
            ++n11;
            c10 = (char)(TextUtils.isEmpty((CharSequence)(string2 = ((PlatformDb)object).get(string2))) ? 1 : 0);
            if (c10 != '\u0000') continue;
            ((StringBuilder)charSequence).append(string2);
            String string3 = "utf-8";
            string2 = Data.urlEncode(string2, string3);
            stringBuilder.append(string2);
        }
        object = SSDKLog.b();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("======UserData: ");
        charSequence = ((StringBuilder)charSequence).toString();
        ((StringBuilder)object2).append((String)charSequence);
        object2 = ((StringBuilder)object2).toString();
        charSequence = new Object[]{};
        ((NLog)object).i(object2, (Object[])charSequence);
        return stringBuilder.toString();
    }

    public static /* synthetic */ String a(d d10, Platform platform) {
        return d10.a(platform);
    }

    private void a(Platform platform, int n10, HashMap hashMap) {
        Object object = f.c().b();
        if (object == null) {
            this.b();
        }
        object = this.a;
        d$2 d$2 = new d$2(this, (PlatformActionListener)object, n10, hashMap);
        this.a = d$2;
        platform.showUser(null);
    }

    private String b(Platform stringArray) {
        String string2;
        Object[] objectArray;
        boolean bl2;
        PlatformDb platformDb = stringArray.getDb();
        Object object = stringArray.getName();
        boolean bl3 = "WechatMoments".equals(object);
        if ((bl3 || (bl2 = ((String)(object = "WechatFavorite")).equals(stringArray = stringArray.getName()))) && (bl2 = TextUtils.isEmpty((CharSequence)(stringArray = platformDb.getUserGender())))) {
            stringArray = "Wechat";
            try {
                stringArray = ShareSDK.getPlatform((String)stringArray);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                objectArray = new Object[]{};
                string2 = "InnerPlatformActionListener getUserDataBrief catch ";
                ((NLog)object).d(throwable, (Object)string2, objectArray);
                bl2 = false;
                stringArray = null;
            }
            if (stringArray != null) {
                platformDb = stringArray.getDb();
            }
        }
        stringArray = "gender";
        object = "birthday";
        objectArray = "secretType";
        string2 = "educationJSONArrayStr";
        String string3 = "workJSONArrayStr";
        try {
            stringArray = new String[]{stringArray, object, objectArray, string2, string3};
        }
        catch (Throwable throwable) {
            SSDKLog.b().w(throwable);
            return null;
        }
        return this.a(platformDb, stringArray);
    }

    private void b() {
        d$1 d$1 = new d$1(this);
        Thread thread = new Thread(d$1);
        thread.start();
    }

    private void b(Platform platform, int n10, HashMap hashMap) {
        NLog nLog;
        Object object = (Platform$ShareParams)this.b.remove(platform);
        if (hashMap != null) {
            object = (Platform$ShareParams)hashMap.remove("ShareParams");
        }
        Object object2 = hashMap.clone();
        try {
            object2 = (HashMap)object2;
        }
        catch (Throwable throwable) {
            nLog = SSDKLog.b();
            nLog.d(throwable);
            object2 = hashMap;
        }
        nLog = null;
        if (object != null) {
            int n11;
            cn.sharesdk.framework.b.b.f f10 = new cn.sharesdk.framework.b.b.f();
            Object object3 = ((InnerShareParams)object).getCustomFlag();
            f10.n = object3;
            object3 = platform.getDb().getUserId();
            Object object4 = "WechatMoments";
            Object object5 = platform.getName();
            boolean bl2 = ((String)object4).equals(object5);
            if ((bl2 || (bl2 = ((String)(object4 = "WechatFavorite")).equals(object5 = platform.getName()))) && (bl2 = TextUtils.isEmpty((CharSequence)object3))) {
                object5 = "Wechat";
                try {
                    object5 = ShareSDK.getPlatform((String)object5);
                }
                catch (Throwable throwable) {
                    object4 = SSDKLog.b();
                    Object[] objectArray = new Object[]{};
                    String string2 = "InnerPlatformActionListener wechat is null";
                    ((NLog)object4).d(throwable, (Object)string2, objectArray);
                    bl2 = false;
                    object5 = null;
                }
                if (object5 != null) {
                    object3 = ((Platform)object5).getDb().getUserId();
                }
            } else {
                object4 = "TencentWeibo";
                object5 = platform.getName();
                bl2 = ((String)object4).equals(object5);
                if (bl2) {
                    object3 = platform.getDb();
                    object5 = "name";
                    object3 = ((PlatformDb)object3).get((String)object5);
                }
            }
            f10.b = object3;
            f10.a = n11 = platform.getPlatformId();
            if ((object = platform.filterShareContent((Platform$ShareParams)object, (HashMap)object2)) != null) {
                f10.c = object2 = ((f$a)object).a;
                f10.d = object;
            }
            if (platform != null) {
                f10.m = object = this.b(platform);
            }
            if ((object = cn.sharesdk.framework.b.d.a()) != null) {
                ((cn.sharesdk.framework.b.d)object).a(f10);
            }
        }
        if ((object = this.a) != null) {
            object.onComplete(platform, n10, hashMap);
            this.a = null;
            try {
                this.c = 0;
            }
            catch (Throwable throwable) {
                NLog nLog2 = SSDKLog.b();
                nLog2.d(throwable);
            }
        }
    }

    public PlatformActionListener a() {
        return this.a;
    }

    public void a(Platform platform, int n10, Object object) {
        Object object2 = f.c().b();
        if (object2 == null) {
            this.b();
        }
        this.c = n10;
        object2 = this.a;
        d$3 d$3 = new d$3(this, (PlatformActionListener)object2, n10, object);
        this.a = d$3;
        platform.doAuthorize(null);
    }

    public void a(Platform platform, Platform$ShareParams platform$ShareParams) {
        this.b.put(platform, platform$ShareParams);
    }

    public void a(PlatformActionListener platformActionListener) {
        this.a = platformActionListener;
    }

    public void onCancel(Platform platform, int n10) {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            platformActionListener.onCancel(platform, n10);
            this.a = null;
            platform = null;
            this.c = 0;
        }
    }

    public void onComplete(Platform object, int n10, HashMap object2) {
        int n11 = object instanceof CustomPlatform;
        if (n11 != 0) {
            PlatformActionListener platformActionListener = this.a;
            if (platformActionListener != null) {
                platformActionListener.onComplete((Platform)object, n10, (HashMap)object2);
                this.a = null;
                this.c = 0;
            }
            return;
        }
        n11 = 1;
        if (n10 != n11) {
            n11 = 9;
            if (n10 != n11) {
                PlatformActionListener platformActionListener = this.a;
                if (platformActionListener != null) {
                    int n12;
                    platformActionListener.onComplete((Platform)object, n10, (HashMap)object2);
                    object = ((Platform)object).getName();
                    object2 = "Wechat";
                    boolean n122 = ((String)object2).equals(object);
                    if (!(n122 || (n12 = this.c) != 0 && n12 != n10)) {
                        this.a = null;
                        this.c = 0;
                    }
                }
            } else {
                this.b((Platform)object, n10, (HashMap)object2);
            }
        } else {
            this.a((Platform)object, n10, (HashMap)object2);
        }
    }

    public void onError(Platform platform, int n10, Throwable throwable) {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            platformActionListener.onError(platform, n10, throwable);
            this.a = null;
            platform = null;
            this.c = 0;
        }
    }
}

