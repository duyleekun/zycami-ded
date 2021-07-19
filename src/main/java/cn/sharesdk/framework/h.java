/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Handler
 */
package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.authorize.f;
import cn.sharesdk.framework.b.b.a;
import cn.sharesdk.framework.b.d;
import cn.sharesdk.framework.h$1;
import cn.sharesdk.framework.loopshare.LoopSharePasswordListener;
import cn.sharesdk.framework.loopshare.LoopShareResultListener;
import cn.sharesdk.framework.loopshare.MobLinkAPI;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.loopshare.watermark.FirstPic;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.loopshare.watermark.c;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.i;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class h {
    public static Bitmap a(String string2, int n10, int n11) {
        i.a();
        return i.a(string2, n10, n11, "UTF_8", "H", "2", -16777216, -1);
    }

    public static ArrayList a() {
        ArrayList arrayList = h.f();
        h.a(arrayList);
        return arrayList;
    }

    public static HashMap a(HashMap object) {
        int n10;
        HashMap<Object, HashMap> hashMap = null;
        if (object != null && (n10 = ((HashMap)object).size()) > 0) {
            boolean bl2;
            String string2 = "fakelist";
            if ((object = (ArrayList)((HashMap)object).get(string2)) == null) {
                return null;
            }
            hashMap = new HashMap<Object, HashMap>();
            string2 = "ShareSDK";
            String string3 = "parseDevInfo";
            EventRecorder.addBegin(string2, string3);
            object = ((ArrayList)object).iterator();
            while (bl2 = object.hasNext()) {
                int n11;
                HashMap hashMap2 = (HashMap)object.next();
                if (hashMap2 == null) continue;
                Object object2 = String.valueOf(hashMap2.get("snsplat"));
                int n12 = -1;
                try {
                    n11 = ResHelper.parseInt((String)object2);
                }
                catch (Throwable throwable) {
                    NLog nLog = SSDKLog.b();
                    nLog.w(throwable);
                    n11 = n12;
                }
                if (n11 == n12) continue;
                object2 = n11;
                hashMap.put(object2, hashMap2);
            }
            EventRecorder.addEnd(string2, string3);
        }
        return hashMap;
    }

    public static void a(int n10, Platform platform) {
        Object object;
        cn.sharesdk.framework.b.b.d d10 = new cn.sharesdk.framework.b.b.d();
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 == n11) {
                            d10.a = object = "SHARESDK_CANCEL_SHARE";
                        }
                    } else {
                        d10.a = object = "SHARESDK_FAILED_SHARE";
                    }
                } else {
                    d10.a = object = "SHARESDK_EDIT_SHARE";
                }
            } else {
                object = "SHARESDK_CANCEL_SHAREMENU";
                d10.a = object;
            }
        } else {
            object = "SHARESDK_ENTER_SHAREMENU";
            d10.a = object;
        }
        if (platform != null) {
            d10.b = n10 = platform.getPlatformId();
        }
        if ((object = d.a()) != null) {
            ((d)object).a(d10);
        }
    }

    public static void a(Activity activity) {
        b b10 = b.c();
        if (b10 != null) {
            b10.a(activity);
        }
    }

    public static void a(Context context, ReadQrImageListener readQrImageListener) {
        FirstPic.a(context, readQrImageListener);
    }

    public static void a(Handler handler) {
        d d10 = d.a();
        if (d10 != null) {
            d10.a(handler);
            d10.e();
        }
    }

    public static void a(LoopShareResultListener loopShareResultListener) {
        try {
            MobLinkAPI.a();
            MobLinkAPI.b(loopShareResultListener);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "ShareSDKCore prepareLoopShare ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            nLog.e(string3, objectArray);
        }
    }

    public static void a(String string2, int n10) {
        d d10 = d.a();
        if (d10 == null) {
            return;
        }
        a a10 = new a();
        a10.b = string2;
        a10.a = n10;
        d10.a(a10);
    }

    public static void a(String string2, String string3, String string4, String string5, WaterMarkListener waterMarkListener) {
        c.a(string2, string3, string4, string5, waterMarkListener);
    }

    public static void a(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        h$1 h$1 = new h$1();
        Collections.sort(arrayList, h$1);
    }

    public static void a(HashMap hashMap, MoblinkActionListener object) {
        MobLinkAPI.a();
        try {
            MobLinkAPI.a(hashMap, (MoblinkActionListener)object);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "ShareSDKCore mobLinkGetMobID ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            ((NLog)object).e(string3, objectArray);
        }
    }

    public static void a(HashMap hashMap, String object, LoopSharePasswordListener objectArray) {
        MobLinkAPI.a();
        try {
            MobLinkAPI.a(hashMap, (String)object, (LoopSharePasswordListener)objectArray);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            objectArray = new StringBuilder();
            String string2 = "ShareSDKCore preparePassWord ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            ((NLog)object).e(string3, objectArray);
        }
    }

    public static void a(boolean bl2) {
        b b10 = b.c();
        if (b10 != null) {
            b10.a(bl2);
        }
    }

    public static void a(boolean bl2, LoopSharePasswordListener object) {
        MobLinkAPI.a();
        try {
            MobLinkAPI.a(bl2, (LoopSharePasswordListener)object);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "ShareSDKCore readPassWord ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            ((NLog)object).e(string3, objectArray);
        }
    }

    public static Activity b() {
        return b.c().b();
    }

    public static void b(boolean bl2) {
        f f10 = f.c();
        if (f10 != null) {
            f10.a(bl2);
        }
    }

    public static boolean c() {
        return b.c().a();
    }

    public static boolean d() {
        return f.c().a();
    }

    public static HashMap e() {
        MobLinkAPI.a();
        return MobLinkAPI.d();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ArrayList f() {
        Object object = "cn.sharesdk.sina.weibo.SinaWeibo";
        Object[] objectArray = "cn.sharesdk.kaixin.KaiXin";
        String string2 = "cn.sharesdk.linkedin.LinkedIn";
        String string3 = "cn.sharesdk.system.email.Email";
        String string4 = "cn.sharesdk.system.text.ShortMessage";
        String string5 = "cn.sharesdk.tencent.qq.QQ";
        String string6 = "cn.sharesdk.tencent.qzone.QZone";
        String string7 = "cn.sharesdk.tencent.weibo.TencentWeibo";
        String string8 = "cn.sharesdk.twitter.Twitter";
        String string9 = "cn.sharesdk.wechat.friends.Wechat";
        String string10 = "cn.sharesdk.wechat.moments.WechatMoments";
        String string11 = "cn.sharesdk.wechat.favorite.WechatFavorite";
        String string12 = "cn.sharesdk.youdao.YouDao";
        String string13 = "cn.sharesdk.google.GooglePlus";
        String string14 = "cn.sharesdk.foursquare.FourSquare";
        String string15 = "cn.sharesdk.pinterest.Pinterest";
        String string16 = "cn.sharesdk.flickr.Flickr";
        String string17 = "cn.sharesdk.tumblr.Tumblr";
        String string18 = "cn.sharesdk.dropbox.Dropbox";
        String string19 = "cn.sharesdk.vkontakte.VKontakte";
        String string20 = "cn.sharesdk.instagram.Instagram";
        String string21 = "cn.sharesdk.yixin.friends.Yixin";
        String string22 = "cn.sharesdk.yixin.moments.YixinMoments";
        String string23 = "cn.sharesdk.mingdao.Mingdao";
        String string24 = "cn.sharesdk.line.Line";
        String string25 = "cn.sharesdk.kakao.story.KakaoStory";
        String string26 = "cn.sharesdk.kakao.talk.KakaoTalk";
        String string27 = "cn.sharesdk.whatsapp.WhatsApp";
        String string28 = "cn.sharesdk.pocket.Pocket";
        String string29 = "cn.sharesdk.instapaper.Instapaper";
        String string30 = "cn.sharesdk.facebookmessenger.FacebookMessenger";
        String string31 = "cn.sharesdk.alipay.friends.Alipay";
        String string32 = "cn.sharesdk.alipay.moments.AlipayMoments";
        String string33 = "cn.sharesdk.dingding.friends.Dingding";
        String string34 = "cn.sharesdk.youtube.Youtube";
        String string35 = "cn.sharesdk.meipai.Meipai";
        String string36 = "cn.sharesdk.telegram.Telegram";
        String string37 = "cn.sharesdk.cmcc.Cmcc";
        String string38 = "cn.sharesdk.reddit.Reddit";
        String string39 = "cn.sharesdk.telecom.Telecom";
        String string40 = "cn.sharesdk.accountkit.Accountkit";
        String string41 = "cn.sharesdk.douyin.Douyin";
        String string42 = "cn.sharesdk.wework.Wework";
        String string43 = "cn.sharesdk.oasis.Oasis";
        String string44 = "cn.sharesdk.hwaccount.HWAccount";
        String string45 = "cn.sharesdk.xmaccount.XMAccount";
        String string46 = "cn.sharesdk.snapchat.Snapchat";
        String string47 = "cn.sharesdk.littleredbook.Littleredbook";
        String string48 = "cn.sharesdk.kuaishou.Kuaishou";
        String string49 = "cn.sharesdk.watermelonvideo.Watermelonvideo";
        String string50 = "cn.sharesdk.tiktok.Tiktok";
        String[] stringArray = new String[]{"cn.sharesdk.douban.Douban", "cn.sharesdk.evernote.Evernote", "cn.sharesdk.facebook.Facebook", "cn.sharesdk.renren.Renren", object, objectArray, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, string24, string25, string26, string27, string28, string29, string30, string31, string32, string33, string34, string35, string36, string37, string38, string39, string40, string41, string42, string43, string44, string45, string46, string47, string48, string49, string50};
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = 0;
        int n11;
        while (n10 < (n11 = 55)) {
            object = stringArray[n10];
            try {
                object = ReflectHelper.importClass((String)object);
                objectArray = new Object[]{};
                object = ReflectHelper.newInstance((String)object, objectArray);
                object = (Platform)object;
                arrayList.add(object);
            }
            catch (Throwable throwable) {}
            ++n10;
        }
        return arrayList;
    }
}

