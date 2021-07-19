/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 */
package cn.sharesdk.wechat.moments;

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
import cn.sharesdk.wechat.moments.WechatMoments$1;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.WechatTimelineNotSupportedException;
import cn.sharesdk.wechat.utils.h;
import cn.sharesdk.wechat.utils.k;
import cn.sharesdk.wechat.utils.l;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.HashMap;

public class WechatMoments
extends Platform {
    public static final String NAME = "WechatMoments";
    private String a;
    private String b;
    private boolean c;

    public static /* synthetic */ PlatformActionListener a(WechatMoments wechatMoments) {
        return wechatMoments.listener;
    }

    public static /* synthetic */ void a(WechatMoments wechatMoments, int n10, Object object) {
        wechatMoments.afterRegister(n10, object);
    }

    public static /* synthetic */ PlatformActionListener b(WechatMoments wechatMoments) {
        return wechatMoments.listener;
    }

    public static /* synthetic */ PlatformActionListener c(WechatMoments wechatMoments) {
        return wechatMoments.listener;
    }

    private boolean c() {
        Object object = this.getDb();
        String string2 = "refresh_token";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((PlatformDb)object).get(string2)));
        if (!bl2) {
            int n10 = 23;
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

    public static /* synthetic */ PlatformActionListener d(WechatMoments wechatMoments) {
        return wechatMoments.listener;
    }

    public boolean checkAuthorize(int n10, Object object) {
        boolean bl2;
        boolean bl3;
        Object object2 = l.a();
        String string2 = this.a;
        ((l)object2).c(string2);
        boolean n11 = ((l)object2).c();
        if (!n11) {
            object = this.listener;
            if (object != null) {
                object2 = new WechatClientNotExistException();
                object.onError(this, n10, (Throwable)object2);
            }
            return false;
        }
        boolean bl4 = ((l)object2).d();
        int n12 = 1;
        if (!bl4) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                object = new WechatTimelineNotSupportedException();
                platformActionListener.onError(this, n12, (Throwable)object);
            }
            return false;
        }
        int n13 = 9;
        if (n10 != n13 && !(bl3 = this.isAuthValid()) && !(bl2 = this.c())) {
            this.innerAuthorize(n10, object);
            return false;
        }
        return n12 != 0;
    }

    public void doAuthorize(String[] object) {
        object = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b)))) {
            block8: {
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
                bl3 = ((l)object).d();
                if (!bl3) {
                    object = this.listener;
                    if (object != null) {
                        object2 = new WechatTimelineNotSupportedException();
                        object.onError(this, n10, (Throwable)object2);
                    }
                    return;
                }
                int n11 = 23;
                object2 = new h(this, n11);
                Object object3 = this.a;
                String string2 = this.b;
                ((h)object2).a((String)object3, string2);
                object3 = new k(this);
                ((k)object3).a((h)object2);
                object2 = new WechatMoments$1(this);
                ((k)object3).a((AuthorizeListener)object2);
                try {
                    ((l)object).a((k)object3);
                }
                catch (Throwable throwable) {
                    object2 = this.listener;
                    if (object2 == null) break block8;
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

    public void doShare(Platform$ShareParams object) {
        block12: {
            int n10 = 1;
            HashMap<Object, Platform$ShareParams> hashMap = n10;
            ((InnerShareParams)object).set("scene", hashMap);
            hashMap = l.a();
            Object object2 = this.a;
            ((l)((Object)hashMap)).c((String)object2);
            object2 = new k(this);
            boolean bl2 = this.c;
            int n11 = 9;
            if (bl2) {
                PlatformActionListener platformActionListener;
                try {
                    platformActionListener = this.listener;
                }
                catch (Throwable throwable) {
                    hashMap = this.listener;
                    if (hashMap != null) {
                        hashMap.onError(this, n11, throwable);
                    }
                    break block12;
                }
                ((l)((Object)hashMap)).a((k)object2, (Platform$ShareParams)object, platformActionListener);
            }
            PlatformActionListener platformActionListener = this.listener;
            ((k)object2).a((Platform$ShareParams)object, platformActionListener);
            ((l)((Object)hashMap)).c((k)object2);
            object2 = this.listener;
            if (object2 == null) break block12;
            n10 = (int)(((l)((Object)hashMap)).b() ? 1 : 0);
            if (n10 == 0) break block12;
            hashMap = new HashMap<Object, Platform$ShareParams>();
            object2 = "ShareParams";
            hashMap.put(object2, (Platform$ShareParams)object);
            object = this.listener;
            if (object == null) break block12;
            try {
                object.onComplete(this, n11, hashMap);
            }
            catch (Throwable throwable) {
                hashMap = this.listener;
                if (hashMap == null) break block12;
                hashMap.onError(this, n11, throwable);
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
        return 23;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return this.c ^ true;
    }

    public void initDevInfo(String object) {
        int n10;
        object = "AppId";
        Object[] objectArray = this.getDevinfo((String)object);
        this.a = objectArray;
        objectArray = this.getDevinfo("AppSecret");
        this.b = objectArray;
        objectArray = "BypassApproval";
        String string2 = this.getDevinfo((String)objectArray);
        String string3 = "true";
        this.c = n10 = string3.equals(string2);
        string2 = this.a;
        if (string2 == null || (n10 = string2.length()) <= 0) {
            int n11;
            String string4;
            string2 = "Wechat";
            this.a = string4 = this.getDevinfo(string2, (String)object);
            string4 = this.getDevinfo(string2, (String)objectArray);
            this.c = n11 = string3.equals(string4);
            string4 = this.a;
            if (string4 != null && (n11 = string4.length()) > 0) {
                boolean bl2;
                string4 = NAME;
                this.copyDevinfo(string2, string4);
                object = this.getDevinfo((String)object);
                this.a = object;
                object = this.getDevinfo((String)objectArray);
                this.c = bl2 = string3.equals(object);
                object = SSDKLog.b();
                objectArray = new Object[]{};
                string2 = "Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.";
                ((NLog)object).d(string2, objectArray);
            } else {
                objectArray = "WechatFavorite";
                this.a = string2 = this.getDevinfo((String)objectArray, (String)object);
                if (string2 != null && (n10 = string2.length()) > 0) {
                    string2 = NAME;
                    this.copyDevinfo((String)objectArray, string2);
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
        boolean bl2;
        l l10 = l.a();
        String string2 = this.a;
        l10.c(string2);
        boolean bl3 = l10.c();
        return bl3 && (bl2 = l10.d());
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
        String string6 = "Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.";
        int n12 = 37;
        int n13 = 22;
        int n14 = 23;
        if (string2 == null || (n11 = string2.length()) <= 0) {
            this.a = string2 = this.getNetworkDevinfo(n13, (String)object, (String)objectArray);
            if (string2 != null && (n11 = string2.length()) > 0) {
                this.copyNetworkDevinfo(n13, n14);
                object = this.getNetworkDevinfo((String)object, (String)objectArray);
                this.a = object;
                object = SSDKLog.b();
                objectArray = new Object[]{};
                ((NLog)object).d(string6, objectArray);
            } else {
                this.a = string2 = this.getNetworkDevinfo(n12, (String)object, (String)objectArray);
                if (string2 != null && (n11 = string2.length()) > 0) {
                    this.copyNetworkDevinfo(n14, n14);
                    this.a = object = this.getNetworkDevinfo((String)object, (String)objectArray);
                    object = SSDKLog.b();
                    objectArray = new Object[]{};
                    ((NLog)object).d(string5, objectArray);
                }
            }
        }
        if ((object = this.b) == null || (n10 = ((String)object).length()) <= 0) {
            object = this.getNetworkDevinfo(n13, string3, string4);
            this.b = object;
            if (object != null && (n10 = ((String)object).length()) > 0) {
                this.copyNetworkDevinfo(n13, n14);
                this.b = object = this.getNetworkDevinfo(string3, string4);
                object = SSDKLog.b();
                objectArray = new Object[]{};
                ((NLog)object).d(string6, objectArray);
            } else {
                object = this.getNetworkDevinfo(n12, string3, string4);
                this.b = object;
                if (object != null && (n10 = ((String)object).length()) > 0) {
                    this.copyNetworkDevinfo(n14, n14);
                    this.b = object = this.getNetworkDevinfo(string3, string4);
                    object = SSDKLog.b();
                    objectArray = new Object[]{};
                    ((NLog)object).d(string5, objectArray);
                }
            }
        }
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
                int n11 = 23;
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

