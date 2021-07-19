/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package cn.sharesdk.framework;

import android.graphics.Bitmap;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.f;
import java.util.HashMap;

public abstract class Platform {
    public static final int ACTION_AUTHORIZING = 1;
    public static final int ACTION_CUSTOMER = 655360;
    public static final int ACTION_FOLLOWING_USER = 6;
    public static final int ACTION_GETTING_BILATERAL_LIST = 10;
    public static final int ACTION_GETTING_FOLLOWER_LIST = 11;
    public static final int ACTION_GETTING_FRIEND_LIST = 2;
    public static final int ACTION_SENDING_DIRECT_MESSAGE = 5;
    public static final int ACTION_SHARE = 9;
    public static final int ACTION_TIMELINE = 7;
    public static final int ACTION_USER_INFOR = 8;
    public static final int CUSTOMER_ACTION_MASK = 65535;
    public static final int INSTAGRAM_FRIEND = 13;
    public static final int KAKAO_COMMERCE_TEMPLATE = 18;
    public static final int KAKAO_CUSTOM_TEMPLATE = 20;
    public static final int KAKAO_FEED_TEMPLATE = 16;
    public static final int KAKAO_TEXT_TEMPLATE = 19;
    public static final int KAKAO_URL_TEMPLATE = 17;
    public static final int OPEN_WXMINIPROGRAM = 12;
    public static final int QQ_MINI_PROGRAM = 15;
    public static final int SHARE_APPS = 7;
    public static final int SHARE_EMOJI = 9;
    public static final int SHARE_FILE = 8;
    public static final int SHARE_IMAGE = 2;
    public static final int SHARE_LINKCARD = 14;
    public static final int SHARE_MUSIC = 5;
    public static final int SHARE_TEXT = 1;
    public static final int SHARE_VIDEO = 6;
    public static final int SHARE_WEBPAGE = 4;
    public static final int SHARE_WXMINIPROGRAM = 11;
    public static final int SHARE_ZHIFUBAO = 10;
    private f a;
    public final PlatformDb db;
    public PlatformActionListener listener;

    public Platform() {
        Object object = new f(this);
        this.a = object;
        this.db = object = ((f)object).g();
        this.listener = object = this.a.i();
    }

    public void SSOSetting(boolean bl2) {
        this.a.a(bl2);
    }

    public void a() {
        this.a.a(false);
        f f10 = this.a;
        String string2 = this.getName();
        f10.a(string2);
    }

    public void afterRegister(int n10, Object object) {
        this.a.b(n10, object);
    }

    public void authorize() {
        this.authorize(null);
    }

    public void authorize(String[] stringArray) {
        this.a.a(stringArray);
    }

    public boolean b() {
        return this.a.f();
    }

    public abstract boolean checkAuthorize(int var1, Object var2);

    public void copyDevinfo(String string2, String string3) {
        ShareSDK.a(string2, string3);
    }

    public void copyNetworkDevinfo(int n10, int n11) {
        ShareSDK.a(n10, n11);
    }

    public void customerProtocol(String string2, String string3, short s10, HashMap hashMap, HashMap hashMap2) {
        this.a.a(string2, string3, s10, hashMap, hashMap2);
    }

    public abstract void doAuthorize(String[] var1);

    public abstract void doCustomerProtocol(String var1, String var2, int var3, HashMap var4, HashMap var5);

    public abstract void doShare(Platform$ShareParams var1);

    public abstract HashMap filterFriendshipInfo(int var1, HashMap var2);

    public abstract f.a filterShareContent(Platform$ShareParams var1, HashMap var2);

    public abstract void follow(String var1);

    public void followFriend(String string2) {
        this.a.b(string2);
    }

    public abstract HashMap getBilaterals(int var1, int var2, String var3);

    public PlatformDb getDb() {
        return this.db;
    }

    public String getDevinfo(String string2) {
        String string3 = this.getName();
        return this.getDevinfo(string3, string2);
    }

    public String getDevinfo(String string2, String string3) {
        return ShareSDK.getDevinfo(string2, string3);
    }

    public abstract HashMap getFollowers(int var1, int var2, String var3);

    public abstract HashMap getFollowings(int var1, int var2, String var3);

    public abstract void getFriendList(int var1, int var2, String var3);

    public int getId() {
        return this.a.a();
    }

    public abstract String getName();

    public String getNetworkDevinfo(int n10, String string2, String string3) {
        return this.a.a(n10, string2, string3);
    }

    public String getNetworkDevinfo(String string2, String string3) {
        int n10 = this.getPlatformId();
        return this.getNetworkDevinfo(n10, string2, string3);
    }

    public PlatformActionListener getPlatformActionListener() {
        return this.a.c();
    }

    public abstract int getPlatformId();

    public String getShortLintk(String string2, boolean bl2) {
        return this.a.a(string2, bl2);
    }

    public int getSortId() {
        return this.a.b();
    }

    public void getTimeLine(String string2, int n10, int n11) {
        this.a.a(string2, n10, n11);
    }

    public abstract int getVersion();

    public abstract boolean hasShareCallback();

    public abstract void initDevInfo(String var1);

    public void innerAuthorize(int n10, Object object) {
        this.a.a(n10, object);
    }

    public boolean isAuthValid() {
        return this.a.d();
    }

    public boolean isClientValid() {
        return false;
    }

    public boolean isSSODisable() {
        return this.a.e();
    }

    public void listFriend(int n10, int n11, String string2) {
        this.a.a(n10, n11, string2);
    }

    public void removeAccount(boolean bl2) {
        this.a.h();
        ShareSDK.removeCookieOnAuthorize(bl2);
    }

    public abstract void setNetworkDevinfo();

    public void setPlatformActionListener(PlatformActionListener platformActionListener) {
        this.a.a(platformActionListener);
    }

    public void share(Platform$ShareParams platform$ShareParams) {
        this.a.b(platform$ShareParams);
    }

    public void showUser(String string2) {
        this.a.c(string2);
    }

    public void subscribeAuth(Platform$ShareParams platform$ShareParams) {
        this.a.a(platform$ShareParams);
    }

    public abstract void timeline(int var1, int var2, String var3);

    public String uploadImageToFileServer(Bitmap bitmap) {
        return this.a.a(bitmap);
    }

    public String uploadImageToFileServer(String string2) {
        return this.a.d(string2);
    }

    public abstract void userInfor(String var1);
}

