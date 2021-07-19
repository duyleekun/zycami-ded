/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.wechat.utils.WechatResp;
import cn.sharesdk.wechat.utils.h;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public class k {
    private Platform a;
    private Platform$ShareParams b;
    private PlatformActionListener c;
    private AuthorizeListener d;
    private h e;

    public k(Platform platform) {
        this.a = platform;
    }

    public Platform$ShareParams a() {
        return this.b;
    }

    public void a(Platform$ShareParams platform$ShareParams, PlatformActionListener platformActionListener) {
        this.b = platform$ShareParams;
        this.c = platformActionListener;
    }

    public void a(AuthorizeListener authorizeListener) {
        this.d = authorizeListener;
    }

    public void a(WechatResp object) {
        int n10 = ((WechatResp)object).g;
        int n11 = -4;
        Object object2 = "transaction";
        String string2 = "errStr";
        String string3 = "errCode";
        int n12 = 1;
        if (n10 != n11) {
            n11 = -3;
            int n13 = 2;
            int n14 = 9;
            if (n10 != n11) {
                n11 = -2;
                if (n10 != n11) {
                    if (n10 != 0) {
                        Object object3 = new HashMap();
                        Object object4 = object.getClass().getSimpleName();
                        String string4 = "req";
                        ((HashMap)object3).put(string4, object4);
                        n11 = ((WechatResp)object).g;
                        object4 = n11;
                        ((HashMap)object3).put(string3, object4);
                        object4 = ((WechatResp)object).h;
                        ((HashMap)object3).put(string2, object4);
                        object = ((WechatResp)object).i;
                        ((HashMap)object3).put(object2, object);
                        object4 = new Hashon();
                        object3 = ((Hashon)object4).fromHashMap((HashMap)object3);
                        object = new Throwable((String)object3);
                        object3 = this.c;
                        if (object3 != null) {
                            object4 = this.a;
                            object3.onError((Platform)object4, n14, (Throwable)object);
                        }
                        if ((object3 = this.d) != null) {
                            object3.onError((Throwable)object);
                        }
                    } else {
                        n10 = ((WechatResp)object).a();
                        if (n10 != n12) {
                            if (n10 == n13 && (object = this.c) != null) {
                                object = new HashMap();
                                Object object5 = this.b;
                                ((HashMap)object).put("ShareParams", object5);
                                object5 = this.c;
                                Platform platform = this.a;
                                object5.onComplete(platform, n14, (HashMap)object);
                            }
                        } else {
                            AuthorizeListener authorizeListener = this.d;
                            if (authorizeListener != null) {
                                authorizeListener = new Bundle();
                                ((WechatResp)object).b((Bundle)authorizeListener);
                                object = this.e;
                                AuthorizeListener authorizeListener2 = this.d;
                                ((h)object).a((Bundle)authorizeListener, authorizeListener2);
                            }
                        }
                    }
                } else {
                    int n15 = ((WechatResp)object).a();
                    if (n15 != n12) {
                        if (n15 == n13 && (object = this.c) != null) {
                            Platform platform = this.a;
                            object.onCancel(platform, n14);
                        }
                    } else {
                        object = this.d;
                        if (object != null) {
                            object.onCancel();
                        }
                    }
                }
            } else {
                Object object6 = new HashMap();
                n11 = ((WechatResp)object).g;
                Object object7 = n11;
                ((HashMap)object6).put(string3, object7);
                object7 = ((WechatResp)object).h;
                ((HashMap)object6).put(string2, object7);
                object7 = ((WechatResp)object).i;
                ((HashMap)object6).put(object2, object7);
                object2 = new Hashon();
                object6 = ((Hashon)object2).fromHashMap((HashMap)object6);
                object7 = new Throwable((String)object6);
                int n16 = ((WechatResp)object).a();
                if (n16 != n12) {
                    if (n16 == n13 && (object = this.c) != null) {
                        object6 = this.a;
                        object.onError((Platform)object6, n14, (Throwable)object7);
                    }
                } else {
                    object = this.d;
                    if (object != null) {
                        object.onError((Throwable)object7);
                    }
                }
            }
        } else {
            Object object8 = new HashMap();
            n11 = ((WechatResp)object).g;
            Object object9 = n11;
            ((HashMap)object8).put(string3, object9);
            object9 = ((WechatResp)object).h;
            ((HashMap)object8).put(string2, object9);
            object9 = ((WechatResp)object).i;
            ((HashMap)object8).put(object2, object9);
            object2 = new Hashon();
            object8 = ((Hashon)object2).fromHashMap((HashMap)object8);
            object9 = new Throwable((String)object8);
            int n17 = ((WechatResp)object).a();
            if (n17 == n12 && (object = this.d) != null) {
                object.onError((Throwable)object9);
            }
        }
    }

    public void a(h h10) {
        this.e = h10;
    }

    public Platform b() {
        return this.a;
    }

    public PlatformActionListener c() {
        return this.c;
    }
}

