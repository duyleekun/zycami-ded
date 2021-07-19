/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 */
package cn.sharesdk.wechat.friends;

import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.friends.Wechat$1;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.h;
import cn.sharesdk.wechat.utils.k;
import cn.sharesdk.wechat.utils.l;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.HashMap;

public class Wechat
extends Platform {
    public static final String NAME = "Wechat";
    private String a;
    private String b;
    private boolean c;
    private String d;
    private String e;
    private boolean f;
    private int g;

    public static /* synthetic */ PlatformActionListener a(Wechat wechat) {
        return wechat.listener;
    }

    public static /* synthetic */ void a(Wechat wechat, int n10, Object object) {
        wechat.afterRegister(n10, object);
    }

    public static /* synthetic */ PlatformActionListener b(Wechat wechat) {
        return wechat.listener;
    }

    public static /* synthetic */ PlatformActionListener c(Wechat wechat) {
        return wechat.listener;
    }

    private boolean c() {
        Object object = this.getDb();
        String string2 = "refresh_token";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((PlatformDb)object).get(string2)));
        if (!bl2) {
            int n10 = 22;
            object = new h(this, n10);
            string2 = this.a;
            String string3 = this.b;
            ((h)object).a(string2, string3);
            bl2 = ((h)object).a();
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ PlatformActionListener d(Wechat wechat) {
        return wechat.listener;
    }

    public boolean checkAuthorize(int n10, Object object) {
        int n11 = this.isClientValid();
        if (n11 == 0) {
            object = this.listener;
            if (object != null) {
                WechatClientNotExistException wechatClientNotExistException = new WechatClientNotExistException();
                object.onError(this, n10, wechatClientNotExistException);
            }
            return false;
        }
        n11 = 9;
        boolean bl2 = true;
        if (n10 != n11 && (n11 = (int)(this.isAuthValid() ? 1 : 0)) == 0 && (n11 = (int)(this.c() ? 1 : 0)) == 0) {
            Object object2 = this.getDb();
            String string2 = "refresh_token";
            n11 = (int)(TextUtils.isEmpty((CharSequence)(object2 = ((PlatformDb)object2).get(string2))) ? 1 : 0);
            if (n11 == 0) {
                int n12 = 22;
                object2 = new h(this, n12);
                string2 = this.a;
                String string3 = this.b;
                try {
                    ((h)object2).a(string2, string3);
                    n11 = (int)(((h)object2).a() ? 1 : 0);
                    if (n11 != 0) {
                        return bl2;
                    }
                }
                catch (Exception exception) {
                    NLog nLog = SSDKLog.b();
                    nLog.d(exception);
                }
            }
            this.innerAuthorize(n10, object);
            return false;
        }
        return bl2;
    }

    public void doAuthorize(String[] object) {
        object = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b)))) {
            block6: {
                object = l.a();
                Object object2 = this.a;
                ((l)object).c((String)object2);
                boolean bl3 = ((l)object).c();
                int n10 = 1;
                if (!bl3) {
                    object = this.listener;
                    if (object != null) {
                        object2 = new WechatClientNotExistException();
                        object.onError(this, n10, (Throwable)object2);
                    }
                    return;
                }
                int n11 = 22;
                object2 = new h(this, n11);
                Object object3 = this.a;
                String string2 = this.b;
                ((h)object2).a((String)object3, string2);
                object3 = new k(this);
                ((k)object3).a((h)object2);
                object2 = new Wechat$1(this);
                ((k)object3).a((AuthorizeListener)object2);
                try {
                    ((l)object).a((k)object3);
                }
                catch (Throwable throwable) {
                    object2 = this.listener;
                    if (object2 == null) break block6;
                    object2 = this.listener;
                    object2.onError(this, n10, throwable);
                }
            }
            return;
        }
        object = this.listener;
        if (object != null) {
            int n12 = 8;
            String string3 = "The params of appID or appSecret is missing !";
            Throwable throwable = new Throwable(string3);
            object.onError(this, n12, throwable);
        }
    }

    public void doCustomerProtocol(String object, String string2, int n10, HashMap hashMap, HashMap hashMap2) {
        object = this.listener;
        if (object != null) {
            object.onCancel(this, n10);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void doShare(Platform$ShareParams platform$ShareParams) {
        block11: {
            void var4_15;
            void var4_11;
            Object object = 0;
            platform$ShareParams.set("scene", object);
            object = l.a();
            Object object2 = platform$ShareParams.getWxPath();
            boolean n10 = TextUtils.isEmpty((CharSequence)object2);
            object2 = n10 ? this.e : platform$ShareParams.getWxPath();
            this.e = object2;
            object2 = platform$ShareParams.getWxUserName();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            object2 = bl2 ? this.d : platform$ShareParams.getWxUserName();
            this.d = object2;
            object2 = platform$ShareParams.toMap();
            Object object3 = "wxWithShareTicket";
            boolean bl3 = ((HashMap)object2).containsKey(object3);
            if (!bl3) {
                boolean bl4 = this.f;
            } else {
                boolean bl5 = platform$ShareParams.getWxWithShareTicket();
            }
            this.f = var4_11;
            object2 = platform$ShareParams.toMap();
            object3 = "wxMiniProgramType";
            boolean bl6 = ((HashMap)object2).containsKey(object3);
            if (!bl6) {
                int n11 = this.g;
            } else {
                int n12 = platform$ShareParams.getWxMiniProgramType();
            }
            this.g = var4_15;
            object2 = this.e;
            ((l)object).a((String)object2);
            object2 = this.d;
            ((l)object).b((String)object2);
            boolean bl7 = this.f;
            ((l)object).a(bl7);
            int n13 = this.g;
            ((l)object).a(n13);
            object2 = this.a;
            ((l)object).c((String)object2);
            object2 = new k(this);
            boolean bl8 = this.c;
            int n14 = 9;
            if (bl8) {
                try {
                    object3 = this.listener;
                }
                catch (Throwable throwable) {
                    object = this.listener;
                    if (object != null) {
                        object.onError(this, n14, throwable);
                    }
                    break block11;
                }
                ((l)object).a((k)object2, platform$ShareParams, (PlatformActionListener)object3);
            }
            object3 = this.listener;
            ((k)object2).a(platform$ShareParams, (PlatformActionListener)object3);
            try {
                ((l)object).c((k)object2);
            }
            catch (Throwable throwable) {
                object = this.listener;
                if (object == null) break block11;
                object = this.listener;
                object.onError(this, n14, throwable);
            }
        }
    }

    public HashMap filterFriendshipInfo(int n10, HashMap hashMap) {
        return null;
    }

    public f$a filterShareContent(Platform$ShareParams object, HashMap object2) {
        String string2;
        object2 = new f$a();
        ((f$a)object2).b = string2 = ((InnerShareParams)object).getText();
        Object object3 = ((InnerShareParams)object).getImageUrl();
        HashMap<String, Object> hashMap = ((InnerShareParams)object).getImagePath();
        Bitmap bitmap = ((InnerShareParams)object).getImageData();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl2) {
            hashMap = ((f$a)object2).d;
            ((ArrayList)((Object)hashMap)).add(object3);
        } else if (hashMap != null) {
            object3 = ((f$a)object2).e;
            ((ArrayList)object3).add(hashMap);
        } else if (bitmap != null) {
            object3 = ((f$a)object2).f;
            ((ArrayList)object3).add(bitmap);
        }
        object3 = ((InnerShareParams)object).getUrl();
        if (object3 != null) {
            hashMap = ((f$a)object2).c;
            ((ArrayList)((Object)hashMap)).add(object3);
        }
        hashMap = new HashMap<String, Object>();
        object = ((InnerShareParams)object).getTitle();
        hashMap.put("title", object);
        hashMap.put("url", object3);
        hashMap.put("extInfo", null);
        hashMap.put("content", string2);
        object = ((f$a)object2).d;
        hashMap.put("image", object);
        hashMap.put("musicFileUrl", object3);
        ((f$a)object2).g = hashMap;
        return object2;
    }

    public void follow(String object) {
        object = this.listener;
        if (object != null) {
            int n10 = 6;
            object.onCancel(this, n10);
        }
    }

    public HashMap getBilaterals(int n10, int n11, String string2) {
        return null;
    }

    public HashMap getFollowers(int n10, int n11, String string2) {
        return null;
    }

    public HashMap getFollowings(int n10, int n11, String string2) {
        return null;
    }

    public void getFriendList(int n10, int n11, String string2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            n11 = 2;
            platformActionListener.onCancel(this, n11);
        }
    }

    public String getName() {
        return NAME;
    }

    public int getPlatformId() {
        return 22;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return this.c ^ true;
    }

    public void initDevInfo(String object) {
        boolean bl2;
        object = "AppId";
        Object[] objectArray = this.getDevinfo((String)object);
        this.a = objectArray;
        objectArray = this.getDevinfo("AppSecret");
        this.b = objectArray;
        objectArray = "BypassApproval";
        String string2 = this.getDevinfo((String)objectArray);
        String string3 = "true";
        this.c = bl2 = string3.equals(string2);
        string2 = "UserName";
        Object object2 = this.getDevinfo(string2);
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 != 0) {
            string2 = "userName";
        }
        this.d = string2 = this.getDevinfo(string2);
        string2 = "Path";
        object2 = this.getDevinfo(string2);
        n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 != 0) {
            string2 = "path";
        }
        this.e = string2 = this.getDevinfo(string2);
        string2 = this.getDevinfo("WithShareTicket");
        this.f = bl2 = string3.equals(string2);
        bl2 = false;
        string2 = null;
        object2 = "MiniprogramType";
        object2 = this.getDevinfo((String)object2);
        object2 = Integer.valueOf((String)object2);
        n10 = (Integer)object2;
        try {
            this.g = n10;
        }
        catch (Throwable throwable) {
            this.g = 0;
        }
        object2 = this.a;
        if (object2 == null || (n10 = ((String)object2).length()) <= 0) {
            int n11;
            String string4;
            object2 = "WechatMoments";
            this.a = string4 = this.getDevinfo((String)object2, (String)object);
            string4 = this.getDevinfo((String)object2, (String)objectArray);
            this.c = n11 = string3.equals(string4);
            string4 = this.a;
            if (string4 != null && (n11 = string4.length()) > 0) {
                boolean bl3;
                string4 = NAME;
                this.copyDevinfo((String)object2, string4);
                object = this.getDevinfo((String)object);
                this.a = object;
                object = this.getDevinfo((String)objectArray);
                this.c = bl3 = string3.equals(object);
                object = SSDKLog.b();
                objectArray = new Object[]{};
                string2 = "Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.";
                ((NLog)object).d(string2, objectArray);
            } else {
                int n12;
                objectArray = "WechatFavorite";
                this.a = string3 = this.getDevinfo((String)objectArray, (String)object);
                if (string3 != null && (n12 = string3.length()) > 0) {
                    string3 = NAME;
                    this.copyDevinfo((String)objectArray, string3);
                    object = this.getDevinfo((String)object);
                    this.a = object;
                    object = SSDKLog.b();
                    objectArray = new Object[]{};
                    string2 = "Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.";
                    ((NLog)object).d(string2, objectArray);
                }
            }
        }
    }

    public boolean isClientValid() {
        l l10 = l.a();
        String string2 = this.a;
        l10.c(string2);
        boolean bl2 = l10.c();
        return bl2;
    }

    public void setNetworkDevinfo() {
        int n10;
        int n11;
        String string2;
        String string3;
        Object object = "app_id";
        Object[] objectArray = "AppId";
        this.a = string3 = this.getNetworkDevinfo((String)object, (String)objectArray);
        string3 = "app_secret";
        String string4 = "AppSecret";
        this.b = string2 = this.getNetworkDevinfo(string3, string4);
        string2 = this.a;
        String string5 = "Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.";
        String string6 = "Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.";
        int n12 = 22;
        int n13 = 37;
        int n14 = 23;
        if (string2 == null || (n11 = string2.length()) <= 0) {
            this.a = string2 = this.getNetworkDevinfo(n14, (String)object, (String)objectArray);
            if (string2 != null && (n11 = string2.length()) > 0) {
                this.copyNetworkDevinfo(n14, n12);
                object = this.getNetworkDevinfo((String)object, (String)objectArray);
                this.a = object;
                object = SSDKLog.b();
                objectArray = new Object[]{};
                ((NLog)object).d(string6, objectArray);
            } else {
                this.a = string2 = this.getNetworkDevinfo(n13, (String)object, (String)objectArray);
                if (string2 != null && (n11 = string2.length()) > 0) {
                    this.copyNetworkDevinfo(n13, n12);
                    this.a = object = this.getNetworkDevinfo((String)object, (String)objectArray);
                    object = SSDKLog.b();
                    objectArray = new Object[]{};
                    ((NLog)object).d(string5, objectArray);
                }
            }
        }
        if ((object = this.b) == null || (n10 = ((String)object).length()) <= 0) {
            object = this.getNetworkDevinfo(n14, string3, string4);
            this.b = object;
            if (object != null && (n10 = ((String)object).length()) > 0) {
                this.copyNetworkDevinfo(n14, n12);
                this.b = object = this.getNetworkDevinfo(string3, string4);
                object = SSDKLog.b();
                objectArray = new Object[]{};
                ((NLog)object).d(string6, objectArray);
            } else {
                object = this.getNetworkDevinfo(n13, string3, string4);
                this.b = object;
                if (object != null && (n10 = ((String)object).length()) > 0) {
                    this.copyNetworkDevinfo(n13, n12);
                    this.b = object = this.getNetworkDevinfo(string3, string4);
                    object = SSDKLog.b();
                    objectArray = new Object[]{};
                    ((NLog)object).d(string5, objectArray);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void subscribeAuth(Platform$ShareParams object) {
        Object object2 = this.a;
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)(object2 = this.b))) == 0) {
            object2 = l.a();
            Object[] objectArray = this.a;
            ((l)object2).c((String)objectArray);
            boolean bl2 = ((l)object2).c();
            int n11 = 1;
            if (!bl2) {
                object = this.listener;
                if (object == null) return;
                object2 = new WechatClientNotExistException();
                object.onError(this, n11, (Throwable)object2);
                return;
            }
            objectArray = new k(this);
            PlatformActionListener platformActionListener = this.listener;
            objectArray.a((Platform$ShareParams)object, platformActionListener);
            try {
                ((l)object2).b((k)objectArray);
                object = this.listener;
                if (object != null) {
                    n10 = 9;
                    bl2 = false;
                    objectArray = null;
                    object.onComplete(this, n10, null);
                }
                object = SSDKLog.b();
                object2 = "ShareSDK";
                objectArray = new Object[n11];
                platformActionListener = null;
                String string2 = "subscribeAuth start on Wechat";
                objectArray[0] = string2;
                ((NLog)object).d(object2, objectArray);
                return;
            }
            catch (Throwable throwable) {
                object2 = this.listener;
                if (object2 == null) return;
                object2.onError(this, n11, throwable);
            }
            return;
        }
        object = this.listener;
        if (object == null) return;
        n10 = 8;
        String string3 = "The params of appID or appSecret is missing !";
        Throwable throwable = new Throwable(string3);
        object.onError(this, n10, throwable);
    }

    public void timeline(int n10, int n11, String string2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            n11 = 7;
            platformActionListener.onCancel(this, n11);
        }
    }

    public void userInfor(String object) {
        object = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        int n10 = 8;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b)))) {
            block5: {
                int n11 = 22;
                object = new h(this, n11);
                Object object2 = this.a;
                String string2 = this.b;
                ((h)object).a((String)object2, string2);
                object2 = this.listener;
                try {
                    ((h)object).a((PlatformActionListener)object2);
                }
                catch (Throwable throwable) {
                    SSDKLog.b().d(throwable);
                    object2 = this.listener;
                    if (object2 == null) break block5;
                    object2.onError(this, n10, throwable);
                }
            }
            return;
        }
        object = this.listener;
        if (object != null) {
            String string3 = "The params of appID or appSecret is missing !";
            Throwable throwable = new Throwable(string3);
            object.onError(this, n10, throwable);
        }
    }
}

