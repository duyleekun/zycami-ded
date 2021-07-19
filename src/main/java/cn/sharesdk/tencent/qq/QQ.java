/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package cn.sharesdk.tencent.qq;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qq.QQ$1;
import cn.sharesdk.tencent.qq.QQ$2;
import cn.sharesdk.tencent.qq.c;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class QQ
extends Platform {
    public static final String NAME = "QQ";
    private String a;
    private boolean b = true;
    private boolean c;

    public static /* synthetic */ PlatformActionListener a(QQ qQ) {
        return qQ.listener;
    }

    public static /* synthetic */ void a(QQ qQ, int n10, Object object) {
        qQ.afterRegister(n10, object);
    }

    public static /* synthetic */ PlatformActionListener b(QQ qQ) {
        return qQ.listener;
    }

    public static /* synthetic */ PlatformDb c(QQ qQ) {
        return qQ.db;
    }

    public static /* synthetic */ PlatformDb d(QQ qQ) {
        return qQ.db;
    }

    public static /* synthetic */ PlatformDb e(QQ qQ) {
        return qQ.db;
    }

    public static /* synthetic */ PlatformDb f(QQ qQ) {
        return qQ.db;
    }

    public static /* synthetic */ PlatformDb g(QQ qQ) {
        return qQ.db;
    }

    public static /* synthetic */ PlatformDb h(QQ qQ) {
        return qQ.db;
    }

    public static /* synthetic */ PlatformDb i(QQ qQ) {
        return qQ.db;
    }

    public static /* synthetic */ PlatformActionListener j(QQ qQ) {
        return qQ.listener;
    }

    public static /* synthetic */ PlatformActionListener k(QQ qQ) {
        return qQ.listener;
    }

    public static /* synthetic */ PlatformActionListener l(QQ qQ) {
        return qQ.listener;
    }

    public static /* synthetic */ PlatformActionListener m(QQ qQ) {
        return qQ.listener;
    }

    public static /* synthetic */ PlatformActionListener n(QQ qQ) {
        return qQ.listener;
    }

    public static /* synthetic */ PlatformActionListener o(QQ qQ) {
        return qQ.listener;
    }

    public static /* synthetic */ PlatformActionListener p(QQ qQ) {
        return qQ.listener;
    }

    public static /* synthetic */ PlatformActionListener q(QQ qQ) {
        return qQ.listener;
    }

    public boolean checkAuthorize(int n10, Object objectArray) {
        boolean bl2;
        String string2;
        c c10;
        block4: {
            block5: {
                c10 = cn.sharesdk.tencent.qq.c.a(this);
                boolean bl3 = c10.b();
                int n11 = 9;
                string2 = "ShareSDK";
                bl2 = true;
                if (bl3 && (bl3 = this.c) && n10 == n11) {
                    NLog nLog = SSDKLog.b();
                    objectArray = new Object[bl2];
                    objectArray[0] = "QQ checkAuthorize qq.isQQInstalled() return true ";
                    nLog.d(string2, objectArray);
                    return bl2;
                }
                bl3 = this.isAuthValid();
                if (bl3) break block4;
                if (n10 != n11 || objectArray == null || !(bl3 = objectArray instanceof Platform$ShareParams)) break block5;
                Object object = objectArray;
                object = (Platform$ShareParams)objectArray;
                bl3 = ((InnerShareParams)object).isShareTencentWeibo();
                if (!bl3) break block4;
            }
            this.innerAuthorize(n10, objectArray);
            return false;
        }
        Object object = this.a;
        c10.a((String)object);
        object = this.db.getUserId();
        c10.b((String)object);
        object = this.db.getToken();
        c10.d((String)object);
        object = SSDKLog.b();
        objectArray = new Object[bl2];
        objectArray[0] = "QQ checkAuthorize isAuthValid return true ";
        ((NLog)object).d(string2, objectArray);
        return bl2;
    }

    public void doAuthorize(String[] object) {
        Object object2 = SSDKLog.b();
        Object object3 = new Object[]{"QQ doAuthorize "};
        ((NLog)object2).d("ShareSDK", object3);
        object2 = cn.sharesdk.tencent.qq.c.a(this);
        object3 = this.a;
        ((c)object2).a((String)object3);
        ((c)object2).a((String[])object);
        object = new QQ$1(this, (c)object2);
        boolean bl2 = this.isSSODisable();
        ((c)object2).a((AuthorizeListener)object, bl2);
    }

    public void doCustomerProtocol(String object, String string2, int n10, HashMap hashMap, HashMap hashMap2) {
        object = this.listener;
        if (object != null) {
            object.onCancel(this, n10);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void doShare(Platform$ShareParams platform$ShareParams) {
        int n10;
        int n11;
        c c10;
        String string2;
        String string3;
        int n12;
        boolean bl2;
        Object object;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        int n13;
        Object object2;
        String string9;
        Object[] objectArray;
        Object object3;
        Object object4;
        block18: {
            int n14;
            block17: {
                String string10;
                Object[] objectArray2;
                int n15;
                object4 = this;
                object3 = platform$ShareParams;
                objectArray = " QQ doShare miniType: ";
                NLog nLog = SSDKLog.b();
                int n16 = 1;
                Object[] objectArray3 = new Object[n16];
                string9 = null;
                objectArray3[0] = " QQ doShare ";
                object2 = "ShareSDK";
                nLog.d(object2, objectArray3);
                c c11 = cn.sharesdk.tencent.qq.c.a((Platform)this);
                n13 = this.c;
                int n17 = 9;
                if (n13 != 0 && (n13 = c11.b()) != 0) {
                    try {
                        objectArray = this.listener;
                        c11.a((Platform)this, platform$ShareParams, (PlatformActionListener)objectArray);
                        object3 = SSDKLog.b();
                        objectArray = new Object[n16];
                        String string11 = " QQ byPassShare ";
                        objectArray[0] = string11;
                        ((NLog)object3).d(object2, objectArray);
                        return;
                    }
                    catch (Throwable throwable) {
                        objectArray = ((Platform)object4).listener;
                        if (objectArray != null) {
                            objectArray.onError((Platform)object4, n17, throwable);
                        }
                        objectArray = SSDKLog.b();
                        Object[] objectArray4 = new Object[n16];
                        StringBuilder stringBuilder = new StringBuilder();
                        String string12 = " QQ doShare catch: ";
                        stringBuilder.append(string12);
                        stringBuilder.append(throwable);
                        String string13 = stringBuilder.toString();
                        objectArray4[0] = string13;
                        objectArray.d(object2, objectArray4);
                        return;
                    }
                }
                string8 = platform$ShareParams.getTitle();
                string7 = platform$ShareParams.getText();
                string6 = platform$ShareParams.getImagePath();
                string5 = platform$ShareParams.getImageUrl();
                string4 = platform$ShareParams.getMusicUrl();
                object = platform$ShareParams.getTitleUrl();
                bl2 = platform$ShareParams.isShareTencentWeibo();
                n12 = platform$ShareParams.getHidden();
                string3 = platform$ShareParams.getQQMiniProgramAppid();
                string9 = platform$ShareParams.getQQMiniProgramPath();
                string2 = platform$ShareParams.getQQMiniProgramType();
                c10 = c11;
                n11 = platform$ShareParams.getShareType();
                try {
                    object3 = SSDKLog.b();
                    n15 = n11;
                    n14 = 1;
                }
                catch (Throwable throwable) {
                    break block17;
                }
                try {
                    objectArray2 = new Object[n14];
                    object4 = new StringBuilder();
                    n10 = n12;
                    string10 = " QQ doShare title: ";
                }
                catch (Throwable throwable) {
                    n11 = n15;
                    break block17;
                }
                try {
                    ((StringBuilder)object4).append(string10);
                    ((StringBuilder)object4).append(string8);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_55 = null;
                    objectArray2[0] = object4;
                    ((NLog)object3).d(object2, objectArray2);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray5 = new Object[n14];
                    object4 = new StringBuilder();
                    String string14 = " QQ doShare text: ";
                    ((StringBuilder)object4).append(string14);
                    ((StringBuilder)object4).append(string7);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_57 = null;
                    objectArray5[0] = object4;
                    ((NLog)object3).d(object2, objectArray5);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray6 = new Object[n14];
                    object4 = new StringBuilder();
                    String string15 = " QQ doShare imagePath: ";
                    ((StringBuilder)object4).append(string15);
                    ((StringBuilder)object4).append(string6);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_59 = null;
                    objectArray6[0] = object4;
                    ((NLog)object3).d(object2, objectArray6);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray7 = new Object[n14];
                    object4 = new StringBuilder();
                    String string16 = " QQ doShare imageUrl: ";
                    ((StringBuilder)object4).append(string16);
                    ((StringBuilder)object4).append(string5);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_61 = null;
                    objectArray7[0] = object4;
                    ((NLog)object3).d(object2, objectArray7);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray8 = new Object[n14];
                    object4 = new StringBuilder();
                    String string17 = " QQ doShare musicUrl: ";
                    ((StringBuilder)object4).append(string17);
                    ((StringBuilder)object4).append(string4);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_63 = null;
                    objectArray8[0] = object4;
                    ((NLog)object3).d(object2, objectArray8);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray9 = new Object[n14];
                    object4 = new StringBuilder();
                    String string18 = " QQ doShare titleUrl: ";
                    ((StringBuilder)object4).append(string18);
                    ((StringBuilder)object4).append((String)object);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_65 = null;
                    objectArray9[0] = object4;
                    ((NLog)object3).d(object2, objectArray9);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray10 = new Object[n14];
                    object4 = new StringBuilder();
                    String string19 = " QQ doShare miniAppId: ";
                    ((StringBuilder)object4).append(string19);
                    ((StringBuilder)object4).append(string3);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_67 = null;
                    objectArray10[0] = object4;
                    ((NLog)object3).d(object2, objectArray10);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray11 = new Object[n14];
                    object4 = new StringBuilder();
                    String string20 = " QQ doShare miniPath: ";
                    ((StringBuilder)object4).append(string20);
                    ((StringBuilder)object4).append(string9);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_69 = null;
                    objectArray11[0] = object4;
                    ((NLog)object3).d(object2, objectArray11);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray12 = new Object[n14];
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append((String)objectArray);
                    ((StringBuilder)object4).append(string2);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_70 = null;
                    objectArray12[0] = object4;
                    ((NLog)object3).d(object2, objectArray12);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray13 = new Object[n14];
                    object4 = new StringBuilder();
                    String string21 = " QQ doShare weiboShare: ";
                    ((StringBuilder)object4).append(string21);
                    ((StringBuilder)object4).append(bl2);
                    object4 = ((StringBuilder)object4).toString();
                    n12 = 0;
                    Object var26_72 = null;
                    objectArray13[0] = object4;
                    ((NLog)object3).d(object2, objectArray13);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    Object[] objectArray14 = new Object[n14];
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append((String)objectArray);
                    ((StringBuilder)object4).append(string2);
                    object4 = ((StringBuilder)object4).toString();
                    objectArray = null;
                    objectArray14[0] = object4;
                    ((NLog)object3).d(object2, objectArray14);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    objectArray = new Object[n14];
                    object4 = new StringBuilder();
                    String string22 = " QQ doShare hidden: ";
                    ((StringBuilder)object4).append(string22);
                    n12 = n10;
                }
                catch (Throwable throwable) {
                    n11 = n15;
                    n12 = n10;
                    break block17;
                }
                {
                    ((StringBuilder)object4).append(n10);
                    object4 = ((StringBuilder)object4).toString();
                    n11 = 0;
                    Object var10_31 = null;
                    objectArray[0] = object4;
                    ((NLog)object3).d(object2, objectArray);
                    object3 = SSDKLog.b();
                    n14 = 1;
                    objectArray = new Object[n14];
                    object4 = new StringBuilder();
                    String string23 = " QQ doShare shareType: ";
                    ((StringBuilder)object4).append(string23);
                    n11 = n15;
                }
                {
                    ((StringBuilder)object4).append(n15);
                    objectArray[0] = object4 = ((StringBuilder)object4).toString();
                    ((NLog)object3).d(object2, objectArray);
                    break block18;
                }
            }
            object3 = SSDKLog.b();
            n14 = 1;
            object4 = new Object[n14];
            object4[0] = objectArray = " ShareParams catch, don't worry ";
            ((NLog)object3).d(object2, (Object[])object4);
        }
        boolean bl3 = TextUtils.isEmpty((CharSequence)string8);
        if (bl3 && (bl3 = TextUtils.isEmpty((CharSequence)string7)) && (bl3 = TextUtils.isEmpty((CharSequence)string6)) && (bl3 = TextUtils.isEmpty((CharSequence)string5)) && (bl3 = TextUtils.isEmpty((CharSequence)string4)) && (bl3 = TextUtils.isEmpty((CharSequence)string3))) {
            object4 = this;
            object3 = this.listener;
            if (object3 == null) return;
            String string24 = "qq share must have one param at least";
            objectArray = new Throwable(string24);
            n13 = 9;
            object3.onError((Platform)this, n13, (Throwable)objectArray);
            return;
        }
        object4 = this;
        bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            objectArray = null;
            object3 = this.getShortLintk((String)object, false);
            object2 = platform$ShareParams;
            platform$ShareParams.setTitleUrl((String)object3);
            object = object3;
        } else {
            object2 = platform$ShareParams;
            objectArray = null;
        }
        bl3 = TextUtils.isEmpty((CharSequence)string7);
        if (!bl3) {
            object3 = ((Platform)object4).getShortLintk(string7, false);
            ((InnerShareParams)object2).setText((String)object3);
        } else {
            object3 = string7;
        }
        objectArray = new QQ$2((QQ)object4);
        n13 = n11;
        c c12 = c10;
        Object object5 = object3;
        bl3 = bl2;
        String string25 = string9;
        n10 = n11;
        c12.a(string8, (String)object, (String)object3, string6, string5, string4, (PlatformActionListener)objectArray, bl2, n12, string3, string9, string2, n11);
    }

    public HashMap filterFriendshipInfo(int n10, HashMap hashMap) {
        return null;
    }

    public f$a filterShareContent(Platform$ShareParams object, HashMap object2) {
        String string2;
        object2 = new f$a();
        String string3 = ((InnerShareParams)object).getTitleUrl();
        ((f$a)object2).c.add(string3);
        ((f$a)object2).a = string2 = this.a;
        string2 = ((InnerShareParams)object).getText();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            ((f$a)object2).b = string2;
        }
        HashMap<String, Object> hashMap = ((InnerShareParams)object).getImageUrl();
        String string4 = ((InnerShareParams)object).getImagePath();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string4);
        if (!bl3) {
            hashMap = ((f$a)object2).e;
            ((ArrayList)((Object)hashMap)).add(string4);
        } else {
            bl3 = TextUtils.isEmpty((CharSequence)((Object)hashMap));
            if (!bl3) {
                ArrayList arrayList = ((f$a)object2).d;
                arrayList.add(hashMap);
            }
        }
        hashMap = new HashMap<String, Object>();
        object = ((InnerShareParams)object).getTitle();
        hashMap.put("title", object);
        hashMap.put("url", string3);
        hashMap.put("imageLocalUrl", string4);
        hashMap.put("summary", string2);
        object = DeviceHelper.getInstance(MobSDK.getContext()).getAppName();
        hashMap.put("appName", object);
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
        return 24;
    }

    public int getVersion() {
        return 2;
    }

    public boolean hasShareCallback() {
        return this.b;
    }

    public void initDevInfo(String object) {
        int n10;
        object = "AppId";
        Object object2 = this.getDevinfo((String)object);
        this.a = object2;
        object2 = this.getDevinfo("BypassApproval");
        String string2 = "true";
        this.c = n10 = string2.equals(object2);
        object2 = this.a;
        if (object2 == null || (n10 = object2.length()) <= 0) {
            int n11;
            object2 = "QZone";
            this.a = string2 = this.getDevinfo((String)object2, (String)object);
            if (string2 != null && (n11 = string2.length()) > 0) {
                string2 = NAME;
                this.copyDevinfo((String)object2, string2);
                object = this.getDevinfo((String)object);
                this.a = object;
                object = SSDKLog.b();
                n10 = 0;
                object2 = new Object[]{};
                string2 = "Try to use the dev info of QZone, this will cause Id and SortId field are always 0.";
                ((NLog)object).d(string2, object2);
            }
        }
    }

    public boolean isClientValid() {
        c c10 = cn.sharesdk.tencent.qq.c.a(this);
        String string2 = this.a;
        c10.a(string2);
        return c10.b();
    }

    public void setNetworkDevinfo() {
        int n10;
        String string2;
        Object object = "app_id";
        Object[] objectArray = "AppId";
        this.a = string2 = this.getNetworkDevinfo((String)object, (String)objectArray);
        if (string2 == null || (n10 = string2.length()) <= 0) {
            int n11;
            String string3;
            n10 = 6;
            this.a = string3 = this.getNetworkDevinfo(n10, (String)object, (String)objectArray);
            if (string3 != null && (n11 = string3.length()) > 0) {
                n11 = 24;
                this.copyNetworkDevinfo(n10, n11);
                object = this.getNetworkDevinfo((String)object, (String)objectArray);
                this.a = object;
                object = SSDKLog.b();
                objectArray = new Object[]{};
                string2 = "Try to use the dev info of QZone, this will cause Id and SortId field are always 0.";
                ((NLog)object).d(string2, objectArray);
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

    public String uploadImageToFileServer(String string2) {
        return super.uploadImageToFileServer(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void userInfor(String object) {
        int n10;
        int n11;
        Object object2 = "1";
        Object object3 = "is_yellow_vip";
        String string2 = "figureurl";
        String string3 = "figureurl_1";
        String string4 = "figureurl_2";
        String string5 = "figureurl_qq_1";
        String string6 = "figureurl_qq_2";
        String string7 = "nickname";
        Object object4 = "ret";
        String string8 = "userTags";
        String string9 = "gender";
        if (object == null || (n11 = ((String)object).length()) < 0) {
            object = this.db.getUserId();
        }
        n11 = 8;
        if (object != null && (n10 = ((String)object).length()) >= 0) {
            Object object5 = cn.sharesdk.tencent.qq.c.a(this);
            try {
                int n12;
                object5 = ((c)object5).e((String)object);
                if (object5 != null && (n12 = ((HashMap)object5).size()) > 0) {
                    n12 = (int)(((HashMap)object5).containsKey(object4) ? 1 : 0);
                    if (n12 == 0) {
                        object = this.listener;
                        if (object == null) return;
                        object2 = new Throwable();
                        object.onError(this, n11, (Throwable)object2);
                        return;
                    }
                    object4 = ((HashMap)object5).get(object4);
                    int n13 = (Integer)(object4 = (Integer)object4);
                    if (n13 != 0) {
                        object = this.listener;
                        if (object == null) return;
                        object = new Hashon();
                        object = ((Hashon)object).fromHashMap((HashMap)object5);
                        object2 = this.listener;
                        object3 = new Throwable((String)object);
                        object2.onError(this, n11, (Throwable)object3);
                        return;
                    }
                    object4 = this.db;
                    if (object == (object4 = ((PlatformDb)object4).getUserId())) {
                        object = this.db;
                        object4 = ((HashMap)object5).get(string7);
                        object4 = String.valueOf(object4);
                        ((PlatformDb)object).put(string7, (String)object4);
                        boolean bl2 = ((HashMap)object5).containsKey(string6);
                        string7 = "icon";
                        if (bl2) {
                            object = this.db;
                            Object v10 = ((HashMap)object5).get(string6);
                            String string10 = String.valueOf(v10);
                            ((PlatformDb)object).put(string7, string10);
                        } else {
                            bl2 = ((HashMap)object5).containsKey(string5);
                            if (bl2) {
                                object = this.db;
                                Object v11 = ((HashMap)object5).get(string5);
                                String string11 = String.valueOf(v11);
                                ((PlatformDb)object).put(string7, string11);
                            }
                        }
                        bl2 = ((HashMap)object5).containsKey(string4);
                        String string12 = "iconQzone";
                        if (bl2) {
                            object = this.db;
                            Object v12 = ((HashMap)object5).get(string4);
                            String string13 = String.valueOf(v12);
                            ((PlatformDb)object).put(string12, string13);
                        } else {
                            bl2 = ((HashMap)object5).containsKey(string3);
                            if (bl2) {
                                object = this.db;
                                Object v13 = ((HashMap)object5).get(string3);
                                String string14 = String.valueOf(v13);
                                ((PlatformDb)object).put(string12, string14);
                            } else {
                                bl2 = ((HashMap)object5).containsKey(string2);
                                if (bl2) {
                                    object = this.db;
                                    Object v14 = ((HashMap)object5).get(string2);
                                    String string15 = String.valueOf(v14);
                                    ((PlatformDb)object).put(string12, string15);
                                }
                            }
                        }
                        object = this.db;
                        String string16 = "secretType";
                        Object v15 = ((HashMap)object5).get(object3);
                        String string17 = String.valueOf(v15);
                        ((PlatformDb)object).put(string16, string17);
                        object = ((HashMap)object5).get(object3);
                        object = String.valueOf(object);
                        bl2 = ((String)object).equals(object2);
                        if (bl2) {
                            object = this.db;
                            object3 = "snsUserLevel";
                            String string18 = "level";
                            Object v16 = ((HashMap)object5).get(string18);
                            String string19 = String.valueOf(v16);
                            ((PlatformDb)object).put((String)object3, string19);
                        }
                        object = ((HashMap)object5).get(string9);
                        object = String.valueOf(object);
                        object3 = MobSDK.getContext();
                        String string20 = "ssdk_gender_male";
                        int n14 = ResHelper.getStringRes((Context)object3, string20);
                        Context context = MobSDK.getContext();
                        String string21 = "ssdk_gender_female";
                        int n15 = ResHelper.getStringRes(context, string21);
                        Context context2 = MobSDK.getContext();
                        object3 = context2.getString(n14);
                        n14 = (int)(((String)object).equals(object3) ? 1 : 0);
                        if (n14 != 0) {
                            object = this.db;
                            object2 = "0";
                            ((PlatformDb)object).put(string9, (String)object2);
                        } else {
                            object3 = MobSDK.getContext();
                            bl2 = ((String)object).equals(object3 = object3.getString(n15));
                            if (bl2) {
                                object = this.db;
                                ((PlatformDb)object).put(string9, (String)object2);
                            } else {
                                object = this.db;
                                object2 = "2";
                                ((PlatformDb)object).put(string9, (String)object2);
                            }
                        }
                    }
                    if ((object = this.listener) == null) return;
                    object = this.db;
                    if ((object = ((PlatformDb)object).get(string8)) != null) {
                        object = this.db;
                        object = ((PlatformDb)object).get(string8);
                        ((HashMap)object5).put(string8, object);
                    }
                    object = this.listener;
                    object.onComplete(this, n11, (HashMap)object5);
                    return;
                }
                object = this.listener;
                if (object == null) return;
                object2 = new Throwable();
                object.onError(this, n11, (Throwable)object2);
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
        object3 = "qq account is null";
        object2 = new RuntimeException((String)object3);
        object.onError(this, n11, (Throwable)object2);
    }
}

