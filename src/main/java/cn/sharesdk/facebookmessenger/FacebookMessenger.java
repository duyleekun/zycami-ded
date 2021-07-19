/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.facebookmessenger;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.facebookmessenger.FacebookMessenger$1;
import cn.sharesdk.facebookmessenger.FacebookMessengerClientNotExistException;
import cn.sharesdk.facebookmessenger.a;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FacebookMessenger
extends Platform {
    public static final String NAME = "FacebookMessenger";
    private String a;

    public static /* synthetic */ PlatformActionListener a(FacebookMessenger facebookMessenger) {
        return facebookMessenger.listener;
    }

    public static /* synthetic */ PlatformActionListener b(FacebookMessenger facebookMessenger) {
        return facebookMessenger.listener;
    }

    public static /* synthetic */ PlatformActionListener c(FacebookMessenger facebookMessenger) {
        return facebookMessenger.listener;
    }

    public static /* synthetic */ PlatformActionListener d(FacebookMessenger facebookMessenger) {
        return facebookMessenger.listener;
    }

    public static /* synthetic */ PlatformActionListener e(FacebookMessenger facebookMessenger) {
        return facebookMessenger.listener;
    }

    public static /* synthetic */ PlatformActionListener f(FacebookMessenger facebookMessenger) {
        return facebookMessenger.listener;
    }

    public boolean checkAuthorize(int n10, Object object) {
        boolean bl2 = this.isClientValid();
        if (!bl2 && (object = this.listener) != null) {
            FacebookMessengerClientNotExistException facebookMessengerClientNotExistException = new FacebookMessengerClientNotExistException();
            object.onError(this, n10, facebookMessengerClientNotExistException);
        }
        return this.isClientValid();
    }

    public void doAuthorize(String[] object) {
        boolean bl2 = this.isClientValid();
        int n10 = 1;
        if (bl2) {
            bl2 = false;
            object = null;
            this.afterRegister(n10, null);
        } else {
            object = this.listener;
            if (object != null) {
                FacebookMessengerClientNotExistException facebookMessengerClientNotExistException = new FacebookMessengerClientNotExistException();
                object.onError(this, n10, facebookMessengerClientNotExistException);
            }
        }
    }

    public void doCustomerProtocol(String object, String string2, int n10, HashMap hashMap, HashMap hashMap2) {
        object = this.listener;
        if (object != null) {
            object.onCancel(this, n10);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void doShare(Platform$ShareParams var1_1) {
        block70: {
            block69: {
                block68: {
                    block62: {
                        block61: {
                            block60: {
                                var2_2 = this;
                                var3_3 = cn.sharesdk.facebookmessenger.a.a();
                                var5_6 = var1_1;
                                var4_4 = new FacebookMessenger$1(this, var1_1);
                                var1_1.getShareType();
                                var6_7 = var1_1.getImageUrl();
                                var4_4 = var1_1.getImagePath();
                                var7_8 = var1_1.getTitle();
                                var8_9 = var1_1.getUrl();
                                var9_10 = var1_1.getImageArray();
                                var10_11 = var1_1.getComment();
                                var11_12 = new ArrayList<Object>();
                                var12_13 = TextUtils.isEmpty((CharSequence)var4_4);
                                if (var12_13 != 0) break block60;
                                var4_4 = var3_3.a((String)var4_4);
                                var11_12.add(var4_4);
lbl28:
                                // 9 sources

                                while (true) {
                                    continue;
                                    break;
                                }
                            }
                            var12_13 = TextUtils.isEmpty((CharSequence)var4_4);
                            if (var12_13 != 0) break block61;
                            var14_15 = new File((String)var4_4);
                            var15_16 = var14_15.exists();
                            if (var15_16 != 0) ** GOTO lbl28
                        }
                        var15_16 = TextUtils.isEmpty((CharSequence)var6_7);
                        if (var15_16 != 0) break block62;
                        var4_4 = MobSDK.getContext();
                        var4_4 = BitmapHelper.downloadBitmap((Context)var4_4, (String)var6_7);
                        var16_18 = TextUtils.isEmpty((CharSequence)var4_4);
                        if (var16_18) ** GOTO lbl28
                        var9_10 = new File((String)var4_4);
                        var16_18 = var9_10.exists();
                        if (!var16_18) ** GOTO lbl28
                        var11_12.add(var4_4);
                        ** GOTO lbl28
                    }
                    if (var9_10 == null) ** GOTO lbl28
                    var15_16 = ((String[])var9_10).length;
                    if (var15_16 <= 0) ** GOTO lbl28
                    var15_16 = (int)TextUtils.isEmpty((CharSequence)var8_9);
                    if (var15_16 != 0) ** GOTO lbl28
                    var15_16 = ((String[])var9_10).length;
                    var12_13 = 0;
                    var14_15 = null;
                    while (true) {
                        block67: {
                            block64: {
                                block66: {
                                    block65: {
                                        block63: {
                                            if (var12_13 < var15_16) ** break;
                                            ** continue;
                                            var17_20 = var9_10[var12_13];
                                            var18_21 = "http";
                                            var19_22 = var17_20.startsWith((String)var18_21);
                                            if (!var19_22) break block63;
                                            var18_21 = MobSDK.getContext();
                                            var17_20 = BitmapHelper.downloadBitmap((Context)var18_21, (String)var17_20);
                                        }
                                        var18_21 = new File((String)var17_20);
                                        var20_23 = var18_21.exists();
                                        if (!var20_23) break block64;
                                        var21_24 = "/data/";
                                        var20_23 = var17_20.startsWith((String)var21_24);
                                        if (!var20_23) break block65;
                                        var21_24 = MobSDK.getContext();
                                        var22_17 = "images";
                                        var22_17 = ResHelper.getCachePath((Context)var21_24, var22_17);
                                        var23_25 = new StringBuilder();
                                        var24_26 = var9_10;
                                        var13_14 = var7_8;
                                        var25_27 = System.currentTimeMillis();
                                        var23_25.append(var25_27);
                                        var9_10 = var18_21.getName();
                                        var23_25.append((String)var9_10);
                                        var9_10 = var23_25.toString();
                                        var21_24 = new File(var22_17, (String)var9_10);
                                        var9_10 = var21_24.getAbsolutePath();
                                        var21_24.createNewFile();
                                        var16_19 = ResHelper.copyFile((String)var17_20, (String)var9_10);
                                        if (var16_19) {
                                            var18_21 = var21_24;
                                        }
                                        break block66;
                                    }
                                    var24_26 = var9_10;
                                    var13_14 = var7_8;
                                }
                                var9_10 = var18_21.getAbsolutePath();
                                var11_12.add(var9_10);
                                break block67;
                            }
                            var24_26 = var9_10;
                            var13_14 = var7_8;
                        }
                        ++var12_13;
                        var7_8 = var13_14;
                        var9_10 = var24_26;
                    }
                    var13_14 = var7_8;
                    var15_16 = var11_12.size();
                    if (var15_16 > 0) ** GOTO lbl156
                    var15_16 = (int)TextUtils.isEmpty((CharSequence)var8_9);
                    if (var15_16 == 0) ** GOTO lbl156
                    var4_4 = var2_2.listener;
                    if (var4_4 == null) ** GOTO lbl155
                    var5_6 = "The params of image or url are missing!";
                    var3_3 = new Throwable((String)var5_6);
                    var27_28 = 9;
                    var4_4.onError(var2_2, var27_28, (Throwable)var3_3);
lbl155:
                    // 2 sources

                    return;
lbl156:
                    // 2 sources

                    if ((var15_16 = (int)TextUtils.isEmpty((CharSequence)var8_9)) != 0) break block68;
                    var15_16 = 0;
                    var4_4 = null;
                    var4_4 = var2_2.getShortLintk(var8_9, false);
                    var28_29 = 4;
                    var14_15 = var4_4;
                    break block69;
                }
                var15_16 = 2;
                var14_15 = var8_9;
                var28_29 = var15_16;
            }
            var4_4 = var2_2.a;
            var3_3.a(var2_2, (String)var4_4);
            var4_4 = var2_2.a;
            var9_10 = var2_2.listener;
            var22_17 = var1_1.getText();
            var5_6 = var4_4;
            var7_8 = var13_14;
            try {
                var3_3.a((String)var4_4, var28_29, (PlatformActionListener)var9_10, var13_14, (String)var14_15, var22_17, var6_7, var11_12, var10_11);
            }
            catch (Throwable var4_5) {
                SSDKLog.b().d(var4_5);
                var3_3 = var2_2.listener;
                if (var3_3 == null) break block70;
                var27_28 = 9;
                var3_3.onError(var2_2, var27_28, var4_5);
            }
        }
    }

    public HashMap filterFriendshipInfo(int n10, HashMap hashMap) {
        return null;
    }

    public f$a filterShareContent(Platform$ShareParams object, HashMap object2) {
        object2 = new f$a();
        Object object3 = ((InnerShareParams)object).getImageUrl();
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((InnerShareParams)object).getImagePath()));
        if (!bl2) {
            object3 = ((f$a)object2).e;
            ((ArrayList)object3).add(object);
        } else {
            boolean bl3 = TextUtils.isEmpty((CharSequence)object3);
            if (!bl3) {
                object = ((f$a)object2).d;
                ((ArrayList)object).add(object3);
            }
        }
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
        return 46;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return true;
    }

    public void initDevInfo(String string2) {
        this.a = string2 = this.getDevinfo("AppId");
    }

    public boolean isClientValid() {
        Context context;
        try {
            context = MobSDK.getContext();
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return false;
        }
        context = context.getPackageManager();
        String string2 = "com.facebook.orca";
        context.getPackageInfo(string2, 0);
        return true;
    }

    public void setNetworkDevinfo() {
        String string2;
        this.a = string2 = this.getNetworkDevinfo("api_key", "AppId");
    }

    public void timeline(int n10, int n11, String string2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            n11 = 7;
            platformActionListener.onCancel(this, n11);
        }
    }

    public void userInfor(String object) {
        object = this.listener;
        if (object != null) {
            int n10 = 8;
            object.onCancel(this, n10);
        }
    }
}

