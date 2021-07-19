/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.facebook;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.facebook.Facebook$1;
import cn.sharesdk.facebook.Facebook$2;
import cn.sharesdk.facebook.b;
import cn.sharesdk.facebook.c;
import cn.sharesdk.facebook.d;
import cn.sharesdk.facebook.e;
import cn.sharesdk.facebook.h;
import cn.sharesdk.facebook.i;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.f;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

public class Facebook
extends Platform {
    public static final String NAME = "Facebook";
    public static final String PARAMS_HASHTAG = "params_Hashtag";
    public static final String PARAMS_LINKURL = "params_linkurl";
    public static final String PARAMS_QUOTE = "params_Quote";
    private String a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;

    public static /* synthetic */ PlatformActionListener a(Facebook facebook) {
        return facebook.listener;
    }

    public static /* synthetic */ void a(Facebook facebook, int n10, Object object) {
        facebook.afterRegister(n10, object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(Platform object, Platform$ShareParams object2, PlatformActionListener objectArray) {
        Object object3;
        Object object4;
        int n10;
        block18: {
            block16: {
                block17: {
                    n10 = 9;
                    object4 = "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias";
                    object3 = new f();
                    String string2 = "com.facebook.katana";
                    ((f)object3).a(string2, (String)object4);
                    int n11 = ((InnerShareParams)object2).getShareType();
                    int n12 = 6;
                    if (n11 != n12) break block16;
                    object4 = ((InnerShareParams)object2).getFilePath();
                    n11 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
                    if (n11 != 0) break block17;
                    object4 = ((InnerShareParams)object2).getFilePath();
                    ((f)object3).a((String)object4, (Platform)object, (PlatformActionListener)objectArray);
                    break block18;
                }
                if (objectArray == null) return;
                object4 = "Share type is VIDEO, But FilePath is null";
                object2 = new Throwable((String)object4);
                objectArray.onError((Platform)object, n10, (Throwable)object2);
                return;
            }
            ((f)object3).a((Platform$ShareParams)object2, (Platform)object);
        }
        object4 = new HashMap();
        object3 = "ShareParams";
        ((HashMap)object4).put(object3, object2);
        try {
            objectArray.onComplete((Platform)object, n10, (HashMap)object4);
            return;
        }
        catch (Throwable throwable) {
            if (objectArray != null) {
                objectArray.onError((Platform)object, n10, throwable);
            }
            object = SSDKLog.b();
            objectArray = new Object[]{};
            String string3 = "Facebook share byPassShare catch ";
            ((NLog)object).d(throwable, (Object)string3, objectArray);
        }
    }

    public static /* synthetic */ PlatformActionListener b(Facebook facebook) {
        return facebook.listener;
    }

    public static /* synthetic */ PlatformDb c(Facebook facebook) {
        return facebook.db;
    }

    public static /* synthetic */ PlatformDb d(Facebook facebook) {
        return facebook.db;
    }

    public static /* synthetic */ PlatformActionListener e(Facebook facebook) {
        return facebook.listener;
    }

    public static /* synthetic */ PlatformActionListener f(Facebook facebook) {
        return facebook.listener;
    }

    public static /* synthetic */ PlatformActionListener g(Facebook facebook) {
        return facebook.listener;
    }

    public static /* synthetic */ PlatformActionListener h(Facebook facebook) {
        return facebook.listener;
    }

    public static /* synthetic */ PlatformActionListener i(Facebook facebook) {
        return facebook.listener;
    }

    public static /* synthetic */ PlatformActionListener j(Facebook facebook) {
        return facebook.listener;
    }

    public static /* synthetic */ PlatformActionListener k(Facebook facebook) {
        return facebook.listener;
    }

    public static /* synthetic */ PlatformActionListener l(Facebook facebook) {
        return facebook.listener;
    }

    public boolean checkAuthorize(int n10, Object object) {
        SSDKLog.b().w("Facebook checkAuthorize ");
        NLog nLog = SSDKLog.b();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Facebook checkAuthorize action == ");
        String string2 = String.valueOf(n10);
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        nLog.w((String)object2);
        nLog = SSDKLog.b();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Facebook checkAuthorize shareByAppClient == ");
        string2 = String.valueOf(this.c);
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        nLog.w((String)object2);
        nLog = SSDKLog.b();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Facebook checkAuthorize isClientValid == ");
        int n11 = this.isClientValid();
        string2 = String.valueOf(n11 != 0);
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        nLog.w((String)object2);
        boolean bl2 = true;
        int n12 = 9;
        if (n10 == n12 && (n12 = (int)(this.c ? 1 : 0)) != 0 && (n12 = (int)(this.isClientValid() ? 1 : 0)) != 0) {
            SSDKLog.b().w("Facebook checkAuthorize ACTION_SHARE return true");
            return bl2;
        }
        n12 = 6;
        if (n10 == n12) {
            SSDKLog.b().w("Facebook checkAuthorize ACTION_FOLLOWING_USER return true");
            return bl2;
        }
        n12 = (int)(this.isAuthValid() ? 1 : 0);
        if (n12 != 0) {
            SSDKLog.b().w("Facebook checkAuthorize isAuthValid return true");
            object2 = h.a(this);
            string2 = this.a;
            ((h)object2).a(string2);
            string2 = this.db.getToken();
            long l10 = this.db.getExpiresIn();
            String string3 = String.valueOf(l10);
            if (string2 != null && string3 != null) {
                ((h)object2).a(string2, string3);
                n12 = (int)(((h)object2).a() ? 1 : 0);
                if (n12 != 0) {
                    return bl2;
                }
            }
        } else {
            n12 = object instanceof Platform$ShareParams;
            if (n12 != 0) {
                object2 = object;
                object2 = (Platform$ShareParams)object;
                n12 = ((InnerShareParams)object2).getShareType();
                if (n12 == (n11 = 4)) {
                    SSDKLog.b().w("Facebook checkAuthorize SHARE_WEBPAGE return true");
                    return bl2;
                }
            }
        }
        this.innerAuthorize(n10, object);
        SSDKLog.b().w("Facebook checkAuthorize return false");
        return false;
    }

    public void doAuthorize(String[] object) {
        boolean bl2 = this.d;
        if (bl2) {
            object = SSDKLog.b();
            Object object2 = "Facebook doAuthorize by official";
            ((NLog)object).w((String)object2);
            object2 = this.listener;
            object = new b((PlatformActionListener)object2, this);
            object2 = MobSDK.getContext();
            int n10 = 0;
            StringBuilder stringBuilder = null;
            ((FakeActivity)object).show((Context)object2, null);
            object = SSDKLog.b();
            object2 = "Facebook doAuthorize ";
            try {
                ((NLog)object).w((String)object2);
            }
            catch (Throwable throwable) {
                object2 = this.listener;
                if (object2 != null) {
                    n10 = 1;
                    object2.onError(this, n10, throwable);
                }
                object2 = SSDKLog.b();
                stringBuilder = new StringBuilder();
                String string2 = "Facebook doAuthorize catch: ";
                stringBuilder.append(string2);
                stringBuilder.append(throwable);
                String string3 = stringBuilder.toString();
                ((NLog)object2).w(string3);
            }
        } else {
            SSDKLog.b().w("Facebook doAuthorize by origianl");
            h h10 = h.a(this);
            String string4 = this.a;
            h10.a(string4);
            string4 = this.b;
            h10.c(string4);
            h10.a((String[])object);
            object = new Facebook$1(this, h10);
            boolean bl3 = this.isSSODisable();
            h10.a((AuthorizeListener)object, bl3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void doCustomerProtocol(String object, String object2, int n10, HashMap object3, HashMap hashMap) {
        h h10 = h.a(this);
        try {
            int n11;
            object = h10.a((String)object, (String)object2, (HashMap)object3, hashMap);
            if (object != null && (n11 = ((HashMap)object).size()) > 0) {
                object2 = "error_code";
                n11 = (int)(((HashMap)object).containsKey(object2) ? 1 : 0);
                if (n11 == 0 && (n11 = (int)(((HashMap)object).containsKey(object2 = "error") ? 1 : 0)) == 0) {
                    object2 = this.listener;
                    if (object2 == null) return;
                    object2.onComplete(this, n10, (HashMap)object);
                    return;
                }
                object2 = this.listener;
                if (object2 == null) return;
                object2 = new Hashon();
                object = ((Hashon)object2).fromHashMap((HashMap)object);
                object2 = this.listener;
                object3 = new Throwable((String)object);
                object2.onError(this, n10, (Throwable)object3);
                return;
            }
            object = this.listener;
            if (object == null) return;
            object3 = "response is null";
            object2 = new Throwable((String)object3);
            object.onError(this, n10, (Throwable)object2);
            return;
        }
        catch (Throwable throwable) {
            object2 = this.listener;
            if (object2 == null) return;
            object2.onError(this, n10, throwable);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void doShare(Platform$ShareParams var1_1) {
        SSDKLog.b().w("Facebook doShare");
        var2_7 = h.a(this);
        var3_8 = this.a;
        var2_7.a(var3_8);
        var4_9 = 9;
        var5_10 = var1_1.getText();
        var6_11 = 0;
        var7_12 = null;
        this.getShortLintk((String)var5_10, false);
        var5_10 = var1_1.getImagePath();
        var8_13 = var1_1.getImageUrl();
        var9_14 = var1_1.getUrl();
        var10_15 = new ArrayList();
        var11_16 = var1_1.getImageArray();
        if (var11_16 != null) {
            var10_15 = var1_1.getImageArray();
            var10_15 = Arrays.asList(var10_15);
        }
        var12_17 = this.e;
        if (var12_17 != 0) {
            var13_18 = this.c;
            if (var13_18) {
                var2_7 = SSDKLog.b();
                var5_10 = "Facebook bypassApproval ";
                var7_12 = new Object[]{};
                var2_7.d(var5_10, (Object[])var7_12);
                var2_7 = this.listener;
                this.a(this, (Platform$ShareParams)var1_1, (PlatformActionListener)var2_7);
                return;
            }
            var1_1 = this.listener;
            var2_7 = "Set share bypassApproval but no client or ShareByAppClient is false";
            if (var1_1 != null) {
                var1_1 = new Throwable((String)var2_7);
                var5_10 = this.listener;
                var5_10.onError(this, var4_9, (Throwable)var1_1);
            }
            var1_1 = SSDKLog.b();
            var5_10 = new Object[]{};
            var1_1.d(var2_7, (Object[])var5_10);
            return;
        }
        var12_17 = this.c;
        if (var12_17 == 0) ** GOTO lbl375
        var11_16 = SSDKLog.b();
        var14_20 /* !! */  = "Facebook doShare \u5e94\u7528\u9080\u8bf7\u529f\u80fd";
        var11_16.w((String)var14_20 /* !! */ );
        var12_17 = var1_1.getShareType();
        var15_21 = 7;
        var16_22 = null;
        if (var12_17 == var15_21) {
            var2_7 = new i();
            var5_10 = this.listener;
            var2_7.a((PlatformActionListener)var5_10, this, (Platform$ShareParams)var1_1);
            var1_1 = this.a;
            var2_7.a((String)var1_1);
            var1_1 = MobSDK.getContext();
            var2_7.show((Context)var1_1, null);
            return;
        }
        var12_17 = (int)this.d;
        var15_21 = 1;
        if (var12_17 != var15_21) ** GOTO lbl272
        var10_15 = SSDKLog.b();
        var11_16 = "Facebook FacebookOfficialHelper shareImageOfficiall";
        var10_15.w((String)var11_16);
        var17_23 = var1_1.getShareType();
        var12_17 = 2;
        if (var17_23 != var12_17) ** GOTO lbl192
        var10_15 = SSDKLog.b();
        var11_16 = "Facebook share by official SHARE_IMAGE";
        var14_20 /* !! */  = new Object[]{};
        var10_15.d(var11_16, (Object[])var14_20 /* !! */ );
        var10_15 = var1_1.getImageData();
        var11_16 = var1_1.getHashtag();
        var14_20 /* !! */  = var1_1.getImagePath();
        if (var10_15 != null) {
            var1_1 = SSDKLog.b();
            var2_7 = "Facebook share by official that picImageData";
            var5_10 = new Object[]{};
            var1_1.d(var2_7, (Object[])var5_10);
            var2_7 = this.listener;
            var1_1 = new c(this, (PlatformActionListener)var2_7);
            var1_1.a((Bitmap)var10_15);
            var1_1.a((String)var11_16);
            var2_7 = MobSDK.getContext();
            var1_1.show((Context)var2_7, null);
            return;
        }
        var17_23 = (int)TextUtils.isEmpty((CharSequence)var14_20 /* !! */ );
        if (var17_23 != 0) ** GOTO lbl128
        try {
            var1_1 = SSDKLog.b();
            var2_7 = "Facebook share by official that ImagePath";
            var5_10 = new Object[]{};
            var1_1.d(var2_7, (Object[])var5_10);
            var1_1 = new FileInputStream((String)var14_20 /* !! */ );
            var1_1 = BitmapFactory.decodeStream((InputStream)var1_1);
            var5_10 = this.listener;
            var2_7 = new c(this, (PlatformActionListener)var5_10);
            var2_7.a((Bitmap)var1_1);
            var2_7.a((String)var11_16);
            var1_1 = MobSDK.getContext();
            var2_7.show((Context)var1_1, null);
            return;
        }
        catch (Throwable var1_2) {
            var2_7 = this.listener;
            if (var2_7 == null) return;
            var2_7 = SSDKLog.b();
            var5_10 = new StringBuilder();
            var8_13 = "Facebook share image by imagePath catch: ";
            var5_10.append((String)var8_13);
            var5_10.append(var1_2);
            var5_10 = var5_10.toString();
            var7_12 = new Object[]{};
            var2_7.d(var5_10, (Object[])var7_12);
            var2_7 = this.listener;
            var2_7.onError(this, var4_9, var1_2);
            return;
lbl128:
            // 1 sources

            var17_23 = (int)TextUtils.isEmpty((CharSequence)var8_13);
            if (var17_23 != 0) ** GOTO lbl180
            var1_1 = SSDKLog.b();
            var2_7 = "Facebook share by official that imageUrl";
            var5_10 = new Object[]{};
            var1_1.d(var2_7, (Object[])var5_10);
            var1_1 = MobSDK.getContext();
            var1_1 = BitmapHelper.downloadBitmap((Context)var1_1, (String)var8_13);
            {
                catch (Throwable var1_3) {
                    var2_7 = this.listener;
                    if (var2_7 == null) return;
                    var5_10 = new StringBuilder();
                    var8_13 = "Picture download catch: ";
                    var5_10.append((String)var8_13);
                    var5_10.append(var1_3);
                    var1_4 = var5_10.toString();
                    var2_7 = new Throwable((String)var1_4);
                    var1_4 = this.listener;
                    var1_4.onError(this, var4_9, (Throwable)var2_7);
                    return;
                }
            }
            try {
                var2_7 = new FileInputStream((String)var1_1);
                var1_1 = BitmapFactory.decodeStream((InputStream)var2_7);
                var5_10 = this.listener;
                var2_7 = new c(this, (PlatformActionListener)var5_10);
                var2_7.a((Bitmap)var1_1);
                var2_7.a((String)var11_16);
                var1_1 = MobSDK.getContext();
                var2_7.show((Context)var1_1, null);
                return;
            }
            catch (Throwable var1_5) {
                try {
                    block48: {
                        var2_7 = SSDKLog.b();
                        var5_10 = new StringBuilder();
                        var8_13 = "Facebook share image by imageUrl catch: ";
                        var5_10.append((String)var8_13);
                        var5_10.append(var1_5);
                        var5_10 = var5_10.toString();
                        var7_12 = new Object[]{};
                        var2_7.d(var5_10, (Object[])var7_12);
                        var2_7 = this.listener;
                        if (var2_7 == null) return;
                        var2_7.onError(this, var4_9, var1_5);
                        return;
lbl180:
                        // 1 sources

                        var7_12 = this.listener;
                        if (var7_12 != null) {
                            var1_1 = SSDKLog.b();
                            var2_7 = "Facebook doShare official please set imageData params";
                            var1_1.w((String)var2_7);
                            var1_1 = this.listener;
                            var5_10 = "please set imageData or imagePath or imageUrl params";
                            var2_7 = new Throwable((String)var5_10);
                            var1_1.onError(this, var4_9, (Throwable)var2_7);
                            return;
                        }
                        break block48;
lbl192:
                        // 1 sources

                        var17_23 = var1_1.getShareType();
                        if (var17_23 == (var12_17 = 6)) {
                            var10_15 = SSDKLog.b();
                            var11_16 = "Facebook share by official that SHARE_VIDEO";
                            var7_12 = new Object[]{};
                            var10_15.d(var11_16, (Object[])var7_12);
                            var7_12 = var1_1.getVideoUri();
                            var10_15 = var1_1.getHashtag();
                            if (var7_12 != null) {
                                var2_7 = this.listener;
                                var1_1 = new d(this, (PlatformActionListener)var2_7);
                                var1_1.a((Uri)var7_12);
                                var1_1.a((String)var10_15);
                                var2_7 = MobSDK.getContext();
                                var1_1.show((Context)var2_7, null);
                                return;
                            }
                            var7_12 = this.listener;
                            if (var7_12 != null) {
                                var1_1 = SSDKLog.b();
                                var2_7 = "Facebook doShare official please set video uri";
                                var1_1.w((String)var2_7);
                                var1_1 = this.listener;
                                var5_10 = "please set video uri";
                                var2_7 = new Throwable((String)var5_10);
                                var1_1.onError(this, var4_9, (Throwable)var2_7);
                                return;
                            }
                            break block48;
                        } else {
                            var17_23 = var1_1.getShareType();
                            if (var17_23 == (var12_17 = 4)) {
                                var10_15 = SSDKLog.b();
                                var11_16 = "Facebook share by official that SHARE_WEBPAGE";
                                var7_12 = new Object[]{};
                                var10_15.d(var11_16, (Object[])var7_12);
                                var7_12 = var1_1.getUrl();
                                var10_15 = var1_1.getQuote();
                                var11_16 = var1_1.getHashtag();
                                var15_21 = (int)TextUtils.isEmpty((CharSequence)var7_12);
                                if (var15_21 == 0) {
                                    var2_7 = this.listener;
                                    var1_1 = new e(this, (PlatformActionListener)var2_7);
                                    var2_7 = new Intent();
                                    var5_10 = "params_linkurl";
                                    var2_7.putExtra((String)var5_10, (String)var7_12);
                                    var5_10 = "params_Quote";
                                    var2_7.putExtra((String)var5_10, (String)var10_15);
                                    var5_10 = "params_Hashtag";
                                    var2_7.putExtra((String)var5_10, (String)var11_16);
                                    var5_10 = MobSDK.getContext();
                                    var1_1.show((Context)var5_10, (Intent)var2_7);
                                    return;
                                }
                                var7_12 = this.listener;
                                if (var7_12 != null) {
                                    var1_1 = SSDKLog.b();
                                    var2_7 = "Facebook doShare official please set webpage url";
                                    var1_1.w((String)var2_7);
                                    var1_1 = this.listener;
                                    var5_10 = "please set webpage url";
                                    var2_7 = new Throwable((String)var5_10);
                                    var1_1.onError(this, var4_9, (Throwable)var2_7);
                                    return;
                                }
                                break block48;
                            } else {
                                var7_12 = this.listener;
                                if (var7_12 != null) {
                                    var1_1 = SSDKLog.b();
                                    var2_7 = "Facebook doShare official please set share Type";
                                    var1_1.w((String)var2_7);
                                    var1_1 = this.listener;
                                    var5_10 = "please set share Type";
                                    var2_7 = new Throwable((String)var5_10);
                                    var1_1.onError(this, var4_9, (Throwable)var2_7);
                                    return;
                                }
                            }
                        }
                        break block48;
lbl272:
                        // 1 sources

                        var9_14 = SSDKLog.b();
                        var11_16 = "Facebook share by primordial";
                        var14_20 /* !! */  = new Object[]{};
                        var9_14.d(var11_16, (Object[])var14_20 /* !! */ );
                        var9_14 = "images";
                        if (var10_15 != null && (var12_17 = var10_15.size()) > 0) {
                            var5_10 = var10_15.iterator();
                            while (var18_24 = var5_10.hasNext()) {
                                var8_13 = var5_10.next();
                                var11_16 = "http";
                                var12_17 = (int)var8_13.startsWith((String)var11_16);
                                if (var12_17 != 0) {
                                    var11_16 = MobSDK.getContext();
                                    var8_13 = BitmapHelper.downloadBitmap((Context)var11_16, (String)var8_13);
                                    var10_15.set(var6_11, var8_13);
                                }
                                if ((var15_21 = (int)(var11_16 = new File((String)var8_13)).exists()) != 0 && (var15_21 = (int)var8_13.startsWith((String)(var14_20 /* !! */  = "/data/"))) != 0) {
                                    var10_15.remove(var8_13);
                                    var14_20 /* !! */  = MobSDK.getContext();
                                    var14_20 /* !! */  = ResHelper.getCachePath(var14_20 /* !! */ , (String)var9_14);
                                    var19_25 /* !! */  = new StringBuilder();
                                    var20_26 = System.currentTimeMillis();
                                    var19_25 /* !! */ .append(var20_26);
                                    var22_27 = var11_16.getName();
                                    var19_25 /* !! */ .append(var22_27);
                                    var19_25 /* !! */  = var19_25 /* !! */ .toString();
                                    var16_22 = new File((String)var14_20 /* !! */ , (String)var19_25 /* !! */ );
                                    var14_20 /* !! */  = var16_22.getAbsolutePath();
                                    var16_22.createNewFile();
                                    var18_24 = ResHelper.copyFile((String)var8_13, (String)var14_20 /* !! */ );
                                    if (var18_24) {
                                        var8_13 = var11_16.getAbsolutePath();
                                        var10_15.add(var8_13);
                                    }
                                }
                                ++var6_11;
                            }
                        } else {
                            var12_17 = (int)TextUtils.isEmpty((CharSequence)var5_10);
                            if (var12_17 != 0 || (var12_17 = (int)(var11_16 = new File((String)var5_10)).exists()) == 0) {
                                var11_16 = var1_1.getImageData();
                                if (var11_16 != null && (var15_21 = (int)var11_16.isRecycled()) == 0) {
                                    var5_10 = MobSDK.getContext();
                                    var5_10 = ResHelper.getCachePath((Context)var5_10, (String)var9_14);
                                    var9_14 = new StringBuilder();
                                    var23_28 = System.currentTimeMillis();
                                    var9_14.append(var23_28);
                                    var14_20 /* !! */  = ".png";
                                    var9_14.append((String)var14_20 /* !! */ );
                                    var9_14 = var9_14.toString();
                                    var8_13 = new File((String)var5_10, (String)var9_14);
                                    var5_10 = new FileOutputStream((File)var8_13);
                                    var9_14 = Bitmap.CompressFormat.PNG;
                                    var15_21 = 100;
                                    var11_16.compress((Bitmap.CompressFormat)var9_14, var15_21, (OutputStream)var5_10);
                                    var5_10.flush();
                                    var5_10.close();
                                    var5_10 = var8_13.getAbsolutePath();
                                    var8_13 = SSDKLog.b();
                                    var9_14 = new StringBuilder();
                                    var11_16 = "Facebook share by primordial imagepath: ";
                                    var9_14.append((String)var11_16);
                                    var9_14.append((String)var5_10);
                                    var9_14 = var9_14.toString();
                                    var7_12 = new Object[]{};
                                    var8_13.d(var9_14, (Object[])var7_12);
                                } else {
                                    var25_29 = TextUtils.isEmpty((CharSequence)var8_13);
                                    if (!var25_29) {
                                        var5_10 = MobSDK.getContext();
                                        var5_10 = BitmapHelper.downloadBitmap((Context)var5_10, (String)var8_13);
                                        var8_13 = SSDKLog.b();
                                        var9_14 = new StringBuilder();
                                        var11_16 = "Facebook share by primordial dowanload imagepath: ";
                                        var9_14.append((String)var11_16);
                                        var9_14.append((String)var5_10);
                                        var9_14 = var9_14.toString();
                                        var7_12 = new Object[]{};
                                        var8_13.d(var9_14, (Object[])var7_12);
                                    }
                                }
                            }
                            if ((var6_11 = TextUtils.isEmpty((CharSequence)var5_10)) == 0) {
                                var10_15.add(var5_10);
                                var26_30 = var10_15.size();
                                var5_10 = new String[var26_30];
                                var5_10 = var10_15.toArray((T[])var5_10);
                                var5_10 = (String[])var5_10;
                                var1_1.setImageArray((String[])var5_10);
                            }
                        }
                        var5_10 = this.listener;
                        var2_7.a((PlatformActionListener)var5_10, (Platform$ShareParams)var1_1);
                        return;
                    }
                    if ((var6_11 = TextUtils.isEmpty((CharSequence)var9_14)) == 0) {
                        var6_11 = TextUtils.isEmpty((CharSequence)var8_13);
                        if (var6_11 != 0 && (var6_11 = TextUtils.isEmpty((CharSequence)var5_10)) == 0 && (var6_11 = (var7_12 = new File((String)var5_10)).exists()) != 0) {
                            var5_10 = this.uploadImageToFileServer((String)var5_10);
                            var1_1.setImageUrl((String)var5_10);
                        }
                        var5_10 = new Facebook$2(this, (Platform$ShareParams)var1_1);
                        var2_7.a((Platform$ShareParams)var1_1, (PlatformActionListener)var5_10);
                        return;
                    }
                    var13_19 = TextUtils.isEmpty((CharSequence)var5_10);
                    var7_12 = "Please install the facebook client";
                    if (!var13_19 && (var13_19 = (var2_7 = new File((String)var5_10)).exists())) {
                        var1_1 = this.listener;
                        if (var1_1 == null) return;
                        var2_7 = new Throwable((String)var7_12);
                        var1_1.onError(this, var4_9, (Throwable)var2_7);
                        return;
                    }
                    var13_19 = TextUtils.isEmpty((CharSequence)var8_13);
                    if (!var13_19) {
                        var1_1 = this.listener;
                        if (var1_1 != null) {
                            var2_7 = new Throwable((String)var7_12);
                            var1_1.onError(this, var4_9, (Throwable)var2_7);
                            return;
                        }
                    } else {
                        var27_31 = TextUtils.isEmpty((CharSequence)(var1_1 = var1_1.getFilePath()));
                        if (!var27_31) {
                            var1_1 = this.listener;
                            if (var1_1 != null) {
                                var5_10 = "Share video only supports facebook client, please install facebook client";
                                var2_7 = new Throwable((String)var5_10);
                                var1_1.onError(this, var4_9, (Throwable)var2_7);
                                return;
                            }
                        } else {
                            var1_1 = this.listener;
                            if (var1_1 != null) {
                                var5_10 = "Share parameter error, please check";
                                var2_7 = new Throwable((String)var5_10);
                                var1_1.onError(this, var4_9, (Throwable)var2_7);
                                return;
                            }
                        }
                    }
                    if ((var1_1 = this.listener) == null) return;
                    var5_10 = "response is null";
                    var2_7 = new Throwable((String)var5_10);
                    var1_1.onError(this, var4_9, (Throwable)var2_7);
                    return;
                }
                catch (Throwable var1_6) {
                    var2_7 = this.listener;
                    if (var2_7 == null) return;
                    var2_7.onError(this, var4_9, var1_6);
                    return;
                }
            }
        }
    }

    public HashMap filterFriendshipInfo(int n10, HashMap object) {
        String string2;
        Object object2 = object;
        CharSequence charSequence = "start_date";
        String string3 = "year";
        String string4 = "end_date";
        Object object3 = "birthday";
        Object object4 = "data";
        Object object5 = ((HashMap)object).get(object4);
        HashMap<Object, Object> hashMap = null;
        if (object5 == null) {
            return null;
        }
        HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
        hashMap2.put("type", "FOLLOWING");
        int n11 = this.getPlatformId();
        Object object6 = n11;
        hashMap2.put("snsplat", object6);
        object6 = this;
        Object object7 = this.db.getUserId();
        Object object8 = "snsuid";
        hashMap2.put((String)object8, object7);
        object7 = (Integer)((HashMap)object).get("current_cursor");
        int n12 = (Integer)object7;
        String string5 = "current_limit";
        object2 = (Integer)((HashMap)object).get(string5);
        int n13 = (Integer)object2;
        ArrayList arrayList = new ArrayList();
        object5 = (ArrayList)object5;
        int n14 = ((ArrayList)object5).size();
        if (n14 <= 0) {
            return null;
        }
        object5 = ((ArrayList)object5).iterator();
        while (true) {
            int n15;
            Object object9;
            Object object10;
            Object object11;
            String string6;
            String string7;
            Object object12;
            block70: {
                n14 = (int)(object5.hasNext() ? 1 : 0);
                string2 = "list";
                if (n14 == 0) break;
                object12 = object2 = object5.next();
                object12 = (HashMap)object2;
                if (object12 == null) continue;
                hashMap = new HashMap<Object, Object>();
                object2 = String.valueOf(((HashMap)object12).get("id"));
                hashMap.put(object8, object2);
                object = object5;
                object5 = "name";
                object2 = String.valueOf(((HashMap)object12).get(object5));
                hashMap.put("nickname", object2);
                object2 = "gender";
                object6 = String.valueOf(((HashMap)object12).get(object2));
                string7 = object8;
                n11 = (int)("male".equals(object6) ? 1 : 0);
                object8 = "0";
                string6 = "1";
                object6 = n11 != 0 ? object8 : string6;
                hashMap.put(object2, object6);
                object2 = String.valueOf(((HashMap)object12).get("verified"));
                object6 = "true";
                n14 = (int)(((String)object6).equals(object2) ? 1 : 0);
                if (n14 != 0) {
                    object8 = string6;
                }
                hashMap.put("secretType", object8);
                object2 = "link";
                object6 = String.valueOf(((HashMap)object12).get(object2));
                object8 = "snsUserUrl";
                hashMap.put(object8, object6);
                object2 = String.valueOf(((HashMap)object12).get(object2));
                object6 = "resume";
                hashMap.put(object6, object2);
                object2 = "picture";
                n11 = (int)(((HashMap)object12).containsKey(object2) ? 1 : 0);
                if (n11 != 0) {
                    object2 = (HashMap)((HashMap)object12).get(object2);
                } else {
                    n14 = 0;
                    object2 = null;
                }
                if (object2 != null) {
                    n11 = (int)(((HashMap)object2).containsKey(object4) ? 1 : 0);
                    if (n11 != 0) {
                        object2 = (HashMap)((HashMap)object2).get(object4);
                    } else {
                        n14 = 0;
                        object2 = null;
                    }
                    if (object2 != null) {
                        object2 = String.valueOf(((HashMap)object2).get("url"));
                        object6 = "icon";
                        hashMap.put(object6, object2);
                    }
                }
                try {
                    n14 = (int)(((HashMap)object12).containsKey(object3) ? 1 : 0);
                    if (n14 == 0) break block70;
                }
                catch (Throwable throwable) {}
                try {
                    object2 = ((HashMap)object12).get(object3);
                    object2 = String.valueOf(object2);
                    object6 = "/";
                    object2 = ((String)object2).split((String)object6);
                    object6 = Calendar.getInstance();
                    int n16 = 2;
                    object11 = object2[n16];
                    n16 = ResHelper.parseInt((String)object11);
                    return n16;
                }
                finally {
                    object11 = object4;
                }
            }
            object11 = object4;
            object2 = "education";
            int n17 = ((HashMap)object12).containsKey(object2);
            if (n17 != 0) {
                object2 = (ArrayList)((HashMap)object12).get(object2);
            } else {
                n14 = 0;
                object2 = null;
            }
            if (object2 != null) {
                object6 = new ArrayList();
                object8 = ((ArrayList)object2).iterator();
                while ((n14 = (int)(object8.hasNext() ? 1 : 0)) != 0) {
                    object2 = (HashMap)object8.next();
                    object4 = new HashMap();
                    object10 = object3;
                    string6 = null;
                    object3 = 0;
                    object9 = object8;
                    ((HashMap)object4).put("school_type", object3);
                    object3 = "school";
                    object8 = (HashMap)((HashMap)object2).get(object3);
                    if (object8 != null) {
                        object8 = String.valueOf(((HashMap)object8).get(object5));
                        ((HashMap)object4).put(object3, object8);
                    }
                    object2 = ((HashMap)object2).get(string3);
                    object2 = (HashMap)object2;
                    object2 = ((HashMap)object2).get(object5);
                    object2 = String.valueOf(object2);
                    n14 = ResHelper.parseInt((String)object2);
                    object2 = n14;
                    try {
                        ((HashMap)object4).put(string3, object2);
                    }
                    catch (Throwable throwable) {
                        object3 = SSDKLog.b();
                        ((NLog)object3).d(throwable);
                    }
                    n15 = 0;
                    object2 = 0;
                    ((HashMap)object4).put("background", object2);
                    ((ArrayList)object6).add(object4);
                    object3 = object10;
                    object8 = object9;
                }
                object10 = object3;
                object2 = new HashMap();
                ((HashMap)object2).put(string2, object6);
                object3 = new Hashon();
                object2 = ((Hashon)object3).fromHashMap((HashMap)object2);
                n15 = ((String)object2).length() - 1;
                n17 = 8;
                object2 = ((String)object2).substring(n17, n15);
                object3 = "educationJSONArrayStr";
                hashMap.put(object3, object2);
            } else {
                object10 = object3;
            }
            object2 = "work";
            n15 = ((HashMap)object12).containsKey(object2);
            if (n15 != 0) {
                object2 = (ArrayList)((HashMap)object12).get(object2);
            } else {
                n14 = 0;
                object2 = null;
            }
            if (object2 != null) {
                object3 = new ArrayList();
                object4 = ((ArrayList)object2).iterator();
                while ((n14 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                    object6 = object2 = object4.next();
                    object6 = (HashMap)object2;
                    object8 = new HashMap();
                    object2 = (HashMap)((HashMap)object6).get("employer");
                    if (object2 != null) {
                        object2 = String.valueOf(((HashMap)object2).get(object5));
                        object12 = "company";
                        ((HashMap)object8).put(object12, object2);
                    }
                    if ((object12 = (HashMap)((HashMap)object6).get(object2 = "position")) != null) {
                        object12 = String.valueOf(((HashMap)object12).get(object5));
                        ((HashMap)object8).put(object2, object12);
                    }
                    object2 = ((HashMap)object6).get(charSequence);
                    object2 = String.valueOf(object2);
                    object12 = "-";
                    object2 = ((String)object2).split((String)object12);
                    int n18 = 0;
                    object12 = null;
                    object9 = object2[0];
                    n18 = ResHelper.parseInt((String)object9) * 100;
                    int n19 = 1;
                    object2 = object2[n19];
                    n14 = ResHelper.parseInt((String)object2);
                    n18 += n14;
                    object2 = n18;
                    try {
                        ((HashMap)object8).put(charSequence, object2);
                    }
                    catch (Throwable throwable) {
                        object12 = SSDKLog.b();
                        ((NLog)object12).d(throwable);
                    }
                    object2 = ((HashMap)object6).get(string4);
                    object2 = String.valueOf(object2);
                    object6 = "-";
                    object2 = ((String)object2).split((String)object6);
                    n11 = 0;
                    object6 = null;
                    object12 = object2[0];
                    n11 = ResHelper.parseInt((String)object12) * 100;
                    n18 = 1;
                    object2 = object2[n18];
                    n14 = ResHelper.parseInt((String)object2);
                    n11 += n14;
                    object2 = n11;
                    try {
                        ((HashMap)object8).put(string4, object2);
                        n11 = 0;
                        object6 = null;
                    }
                    catch (Throwable throwable) {
                        SSDKLog.b().d(throwable);
                        n11 = 0;
                        object6 = null;
                        object2 = 0;
                        ((HashMap)object8).put(string4, object2);
                    }
                    ((ArrayList)object3).add(object8);
                }
                object2 = new HashMap();
                ((HashMap)object2).put(string2, object3);
                object3 = new Hashon();
                object2 = ((Hashon)object3).fromHashMap((HashMap)object2);
                n15 = ((String)object2).length() - 1;
                n17 = 8;
                object2 = ((String)object2).substring(n17, n15);
                object3 = "workJSONArrayStr";
                hashMap.put(object3, object2);
            }
            arrayList.add(hashMap);
            object6 = this;
            object5 = object;
            object8 = string7;
            object4 = object11;
            object3 = object10;
            hashMap = null;
        }
        n14 = arrayList.size();
        if (n14 <= 0) {
            return null;
        }
        n14 = arrayList.size();
        object2 = n13 >= n14 ? "_true" : "_false";
        charSequence = new StringBuilder();
        int n20 = arrayList.size();
        ((StringBuilder)charSequence).append(n12 += n20);
        ((StringBuilder)charSequence).append((String)object2);
        object2 = ((StringBuilder)charSequence).toString();
        hashMap2.put("nextCursor", object2);
        hashMap2.put(string2, arrayList);
        return hashMap2;
    }

    public f$a filterShareContent(Platform$ShareParams object, HashMap hashMap) {
        f$a f$a = new f$a();
        Object object2 = ((InnerShareParams)object).getText();
        f$a.b = object2;
        if (hashMap != null) {
            int n10;
            if (hashMap != null && (n10 = (int)(hashMap.containsKey(object2 = "source") ? 1 : 0)) != 0) {
                object = f$a.d;
                object2 = String.valueOf(hashMap.get(object2));
                ((ArrayList)object).add(object2);
            } else {
                int n11 = 4;
                n10 = ((InnerShareParams)object).getShareType();
                if (n11 == n10) {
                    object2 = f$a.d;
                    String string2 = ((InnerShareParams)object).getImageUrl();
                    ((ArrayList)object2).add(string2);
                    object2 = ((InnerShareParams)object).getTitleUrl();
                    n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                    if (n10 != 0) {
                        object2 = ((InnerShareParams)object).getUrl();
                    }
                    object = f$a.c;
                    ((ArrayList)object).add(object2);
                }
            }
            object = hashMap.get("post_id");
            object = object == null ? null : String.valueOf(object);
            f$a.a = object;
            f$a.g = hashMap;
        }
        return f$a;
    }

    public void follow(String object) {
        object = this.listener;
        if (object != null) {
            int n10 = 7;
            object.onCancel(this, n10);
        }
    }

    public HashMap getBilaterals(int n10, int n11, String string2) {
        return null;
    }

    public HashMap getFollowers(int n10, int n11, String string2) {
        return null;
    }

    public HashMap getFollowings(int n10, int n11, String object) {
        block10: {
            Object object2 = h.a(this);
            try {
                object = ((h)object2).a(n10, n11, (String)object);
                if (object == null) break block10;
            }
            catch (Throwable throwable) {
                SSDKLog.b().d(throwable);
                return null;
            }
            int n12 = ((HashMap)object).size();
            if (n12 <= 0) break block10;
            object2 = "error_code";
            n12 = (int)(((HashMap)object).containsKey(object2) ? 1 : 0);
            if (n12 != 0) break block10;
            object2 = "error";
            n12 = (int)(((HashMap)object).containsKey(object2) ? 1 : 0);
            if (n12 != 0) break block10;
            object2 = "current_limit";
            Object object3 = n10;
            ((HashMap)object).put(object2, object3);
            object3 = "current_cursor";
            Integer n13 = n11;
            ((HashMap)object).put(object3, n13);
            n10 = 2;
            return this.filterFriendshipInfo(n10, (HashMap)object);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void getFriendList(int n10, int n11, String object) {
        h h10 = h.a(this);
        n11 *= n10;
        int n12 = 2;
        try {
            Object object2 = h10.a(n10, n11, (String)object);
            if (object2 != null && (n11 = ((HashMap)object2).size()) > 0) {
                Object object3 = "error_code";
                n11 = (int)(((HashMap)object2).containsKey(object3) ? 1 : 0);
                if (n11 == 0 && (n11 = (int)(((HashMap)object2).containsKey(object3 = "error") ? 1 : 0)) == 0) {
                    object3 = this.listener;
                    if (object3 == null) return;
                    object3.onComplete(this, n12, (HashMap)object2);
                    return;
                }
                object3 = this.listener;
                if (object3 == null) return;
                object3 = new Hashon();
                object2 = ((Hashon)object3).fromHashMap((HashMap)object2);
                object3 = this.listener;
                object = new Throwable((String)object2);
                object3.onError(this, n12, (Throwable)object);
                return;
            }
            object2 = this.listener;
            if (object2 == null) return;
            object = "response is null";
            Throwable throwable = new Throwable((String)object);
            object2.onError(this, n12, throwable);
            return;
        }
        catch (Throwable throwable) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener == null) return;
            platformActionListener.onError(this, n12, throwable);
        }
    }

    public String getName() {
        return NAME;
    }

    public int getPlatformId() {
        return 10;
    }

    public int getVersion() {
        return 2;
    }

    public boolean hasShareCallback() {
        return true;
    }

    public void initDevInfo(String object) {
        boolean bl2;
        object = this.getDevinfo("ConsumerKey");
        this.a = object;
        object = this.getDevinfo("RedirectUrl");
        this.b = object;
        object = "ShareByAppClient";
        Object object2 = this.getDevinfo((String)object);
        CharSequence charSequence = "true";
        this.c = bl2 = ((String)charSequence).equals(object2);
        object2 = this.getDevinfo("BypassApproval");
        this.e = bl2 = ((String)charSequence).equals(object2);
        object2 = SSDKLog.b();
        charSequence = new StringBuilder();
        String string2 = "Facebook initDevInfo ShareByAppClient value is: ";
        ((StringBuilder)charSequence).append(string2);
        object = this.getDevinfo((String)object);
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        ((NLog)object2).w((String)object);
        object = this.getDevinfo("OfficialVersion");
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            this.d = bl3 = true;
            object = SSDKLog.b();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Facebook Official value is: ");
            charSequence = this.getDevinfo("Official");
            ((StringBuilder)object2).append((String)charSequence);
            object2 = ((StringBuilder)object2).toString();
            ((NLog)object).w((String)object2);
        } else {
            bl3 = false;
            object = null;
            this.d = false;
        }
    }

    public boolean isClientValid() {
        h h10 = h.a(this);
        String string2 = this.a;
        h10.a(string2);
        return h10.b();
    }

    public void setNetworkDevinfo() {
        String string2;
        this.a = string2 = this.getNetworkDevinfo("api_key", "ConsumerKey");
        String string3 = "RedirectUrl";
        this.b = string2 = this.getNetworkDevinfo("redirect_uri", string3);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            this.b = string2 = "fbconnect://success";
        }
    }

    public void timeline(int n10, int n11, String string2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            n11 = 7;
            platformActionListener.onCancel(this, n11);
        }
    }

    /*
     * Exception decompiling
     */
    public void userInfor(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [160[CATCHBLOCK]], but top level block is 45[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

