/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.tencent.qzone;

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
import cn.sharesdk.framework.utils.f;
import cn.sharesdk.tencent.qzone.QQClientNotExistException;
import cn.sharesdk.tencent.qzone.QZone$1;
import cn.sharesdk.tencent.qzone.QZone$2;
import cn.sharesdk.tencent.qzone.QZone$3;
import cn.sharesdk.tencent.qzone.b;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class QZone
extends Platform {
    public static final String NAME = "QZone";
    private String a;
    private boolean b;

    public static /* synthetic */ PlatformActionListener a(QZone qZone) {
        return qZone.listener;
    }

    private void a(Platform$ShareParams platform$ShareParams) {
        HashMap<String, Platform$ShareParams> hashMap = new HashMap<String, Platform$ShareParams>();
        ((f)((Object)hashMap)).a("com.qzone", "com.qzonex.module.operation.ui.QZonePublishMoodActivity");
        ((f)((Object)hashMap)).a(platform$ShareParams, this);
        hashMap = new HashMap<String, Platform$ShareParams>();
        hashMap.put("ShareParams", platform$ShareParams);
        this.listener.onComplete(this, 9, hashMap);
    }

    public static /* synthetic */ void a(QZone qZone, int n10, Object object) {
        qZone.afterRegister(n10, object);
    }

    public static /* synthetic */ PlatformActionListener b(QZone qZone) {
        return qZone.listener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Platform$ShareParams object) {
        Object object2 = ((InnerShareParams)object).getImageUrl();
        Object object3 = ((InnerShareParams)object).getImagePath();
        boolean bl2 = ((InnerShareParams)object).isShareTencentWeibo();
        int n10 = 9;
        try {
            boolean bl3 = TextUtils.isEmpty((CharSequence)object3);
            if (bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)object2))) {
                object3 = MobSDK.getContext();
                object2 = BitmapHelper.downloadBitmap((Context)object3, (String)object2);
                ((InnerShareParams)object).setImagePath((String)object2);
                this.doShare((Platform$ShareParams)object);
                return;
            }
            boolean bl4 = this.isAuthValid();
            if (!bl4) {
                object2 = this.getPlatformActionListener();
                object3 = new QZone$2(this, (PlatformActionListener)object2, (Platform$ShareParams)object);
                this.setPlatformActionListener((PlatformActionListener)object3);
                this.authorize();
                return;
            }
            object2 = ((InnerShareParams)object).getText();
            bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (bl3) {
                object = this.listener;
                if (object == null) return;
                object3 = "share params' value of text is empty!";
                object2 = new Throwable((String)object3);
                object.onError(this, n10, (Throwable)object2);
                return;
            }
            bl3 = false;
            Object object4 = null;
            object2 = this.getShortLintk((String)object2, false);
            ((InnerShareParams)object).setText((String)object2);
            object4 = cn.sharesdk.tencent.qzone.b.a(this);
            object2 = bl2 ? ((b)object4).b((String)object3, (String)object2) : ((b)object4).a((String)object3, (String)object2);
            if (object2 == null && (object3 = this.listener) != null) {
                object4 = "response is empty";
                Throwable throwable = new Throwable((String)object4);
                object3.onError(this, n10, throwable);
            }
            object3 = "ShareParams";
            ((HashMap)object2).put(object3, object);
            object = this.listener;
            if (object == null) return;
            object.onComplete(this, n10, (HashMap)object2);
            return;
        }
        catch (Throwable throwable) {
            object2 = this.listener;
            if (object2 == null) return;
            object2.onError(this, n10, throwable);
        }
    }

    public static /* synthetic */ PlatformDb c(QZone qZone) {
        return qZone.db;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(Platform$ShareParams platform$ShareParams) {
        QZone qZone = this;
        Object object = platform$ShareParams;
        int n10 = 9;
        try {
            File file;
            Object object2 = platform$ShareParams.getImageUrl();
            String string2 = platform$ShareParams.getImagePath();
            boolean bl2 = this.isClientValid();
            if (!bl2) {
                object = this.listener;
                if (object == null) return;
                object2 = new QQClientNotExistException();
                object.onError(this, n10, (Throwable)object2);
                return;
            }
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            Object object3 = !bl2 && (bl2 = (file = new File(string2)).exists()) ? string2 : object2;
            String string3 = platform$ShareParams.getTitle();
            object2 = platform$ShareParams.getTitleUrl();
            String string4 = platform$ShareParams.getSite();
            string2 = platform$ShareParams.getText();
            String string5 = platform$ShareParams.getFilePath();
            int n11 = platform$ShareParams.getShareType();
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            b b10 = null;
            if (!bl2) {
                string2 = qZone.getShortLintk(string2, false);
                ((InnerShareParams)object).setText(string2);
            }
            String string6 = string2;
            boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl3) {
                object2 = qZone.getShortLintk((String)object2, false);
                ((InnerShareParams)object).setTitleUrl((String)object2);
            }
            Object object4 = object2;
            String string7 = platform$ShareParams.getQQMiniProgramAppid();
            String string8 = platform$ShareParams.getQQMiniProgramPath();
            String string9 = platform$ShareParams.getQQMiniProgramType();
            String string10 = platform$ShareParams.getImageUrl();
            b10 = cn.sharesdk.tencent.qzone.b.a(this);
            object2 = new QZone$3(qZone, (Platform$ShareParams)object);
            b10.a(n11, string3, (String)object4, string6, (String)object3, string4, string5, string7, string8, string9, string10, (PlatformActionListener)object2);
            return;
        }
        catch (Throwable throwable) {
            PlatformActionListener platformActionListener = qZone.listener;
            if (platformActionListener == null) return;
            platformActionListener.onError(qZone, n10, throwable);
        }
    }

    public static /* synthetic */ PlatformDb d(QZone qZone) {
        return qZone.db;
    }

    public static /* synthetic */ PlatformDb e(QZone qZone) {
        return qZone.db;
    }

    public static /* synthetic */ PlatformDb f(QZone qZone) {
        return qZone.db;
    }

    public static /* synthetic */ PlatformDb g(QZone qZone) {
        return qZone.db;
    }

    public static /* synthetic */ PlatformDb h(QZone qZone) {
        return qZone.db;
    }

    public static /* synthetic */ PlatformDb i(QZone qZone) {
        return qZone.db;
    }

    public static /* synthetic */ PlatformActionListener j(QZone qZone) {
        return qZone.listener;
    }

    public static /* synthetic */ PlatformActionListener k(QZone qZone) {
        return qZone.listener;
    }

    public static /* synthetic */ PlatformActionListener l(QZone qZone) {
        return qZone.listener;
    }

    public static /* synthetic */ PlatformActionListener m(QZone qZone) {
        return qZone.listener;
    }

    public static /* synthetic */ PlatformActionListener n(QZone qZone) {
        return qZone.listener;
    }

    public static /* synthetic */ PlatformActionListener o(QZone qZone) {
        return qZone.listener;
    }

    public static /* synthetic */ PlatformActionListener p(QZone qZone) {
        return qZone.listener;
    }

    public static /* synthetic */ PlatformActionListener q(QZone qZone) {
        return qZone.listener;
    }

    public boolean checkAuthorize(int n10, Object object) {
        b b10 = cn.sharesdk.tencent.qzone.b.a(this);
        boolean bl2 = b10.b();
        int n11 = 9;
        boolean bl3 = true;
        if (bl2 && (bl2 = this.b) && n10 == n11) {
            return bl3;
        }
        bl2 = this.isAuthValid();
        if (!bl2 && n10 != n11) {
            this.innerAuthorize(n10, object);
            return false;
        }
        String string2 = this.a;
        b10.a(string2);
        string2 = this.db.getUserId();
        b10.b(string2);
        string2 = this.db.getToken();
        b10.c(string2);
        return bl3;
    }

    public void doAuthorize(String[] object) {
        b b10 = cn.sharesdk.tencent.qzone.b.a(this);
        String string2 = this.a;
        b10.a(string2);
        b10.a((String[])object);
        object = new QZone$1(this, b10);
        boolean bl2 = this.isSSODisable();
        b10.a((AuthorizeListener)object, bl2);
    }

    public void doCustomerProtocol(String object, String object2, int n10, HashMap serializable, HashMap hashMap) {
        int n11;
        b b10 = cn.sharesdk.tencent.qzone.b.a(this);
        object = b10.a((String)object, (String)object2, (HashMap)serializable, hashMap);
        if (object != null && (n11 = ((HashMap)object).size()) > 0) {
            object2 = "ret";
            boolean bl2 = ((HashMap)object).containsKey(object2);
            if (!bl2) {
                object = this.listener;
                if (object != null) {
                    object2 = new Throwable();
                    object.onError(this, n10, (Throwable)object2);
                }
                return;
            }
            n11 = (Integer)(object2 = (Integer)((HashMap)object).get(object2));
            if (n11 != 0) {
                object2 = this.listener;
                if (object2 != null) {
                    object2 = new Hashon();
                    object = ((Hashon)object2).fromHashMap((HashMap)object);
                    object2 = this.listener;
                    serializable = new Throwable((String)object);
                    object2.onError(this, n10, (Throwable)serializable);
                }
                return;
            }
            object2 = this.listener;
            if (object2 != null) {
                object2.onComplete(this, n10, (HashMap)object);
            }
            return;
        }
        object = this.listener;
        if (object != null) {
            object2 = new Throwable();
            object.onError(this, n10, (Throwable)object2);
        }
    }

    public void doShare(Platform$ShareParams platform$ShareParams) {
        Object object = cn.sharesdk.tencent.qzone.b.a(this);
        boolean bl2 = ((b)object).b();
        if (bl2 && (bl2 = this.b)) {
            try {
                this.a(platform$ShareParams);
            }
            catch (Throwable throwable) {
                object = this.listener;
                if (object != null) {
                    object = this.listener;
                    int n10 = 9;
                    object.onError(this, n10, throwable);
                }
            }
        } else {
            bl2 = platform$ShareParams.isShareTencentWeibo();
            if (bl2) {
                this.b(platform$ShareParams);
            } else {
                this.c(platform$ShareParams);
            }
        }
    }

    public HashMap filterFriendshipInfo(int n10, HashMap hashMap) {
        return null;
    }

    public f$a filterShareContent(Platform$ShareParams object, HashMap object2) {
        f$a f$a = new f$a();
        Object object3 = ((InnerShareParams)object).getText();
        f$a.b = object3;
        object3 = ((InnerShareParams)object).getImageUrl();
        String string2 = ((InnerShareParams)object).getImagePath();
        if (string2 != null) {
            object2 = f$a.e;
            ((ArrayList)object2).add(string2);
        } else {
            string2 = "large_url";
            Object v10 = ((HashMap)object2).get(string2);
            if (v10 != null) {
                object3 = f$a.d;
                object2 = String.valueOf(((HashMap)object2).get(string2));
                ((ArrayList)object3).add(object2);
            } else {
                string2 = "small_url";
                v10 = ((HashMap)object2).get(string2);
                if (v10 != null) {
                    object3 = f$a.d;
                    object2 = String.valueOf(((HashMap)object2).get(string2));
                    ((ArrayList)object3).add(object2);
                } else if (object3 != null) {
                    object2 = f$a.d;
                    ((ArrayList)object2).add(object3);
                }
            }
        }
        object2 = ((InnerShareParams)object).getTitleUrl();
        if (object2 != null) {
            object3 = f$a.c;
            ((ArrayList)object3).add(object2);
        }
        object2 = new HashMap();
        object3 = ((InnerShareParams)object).getTitle();
        ((HashMap)object2).put("title", object3);
        object3 = ((InnerShareParams)object).getTitleUrl();
        ((HashMap)object2).put("titleUrl", object3);
        object = ((InnerShareParams)object).getSite();
        ((HashMap)object2).put("site", object);
        f$a.g = object2;
        return f$a;
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
        return 6;
    }

    public int getVersion() {
        return 2;
    }

    public boolean hasShareCallback() {
        return true;
    }

    public void initDevInfo(String object) {
        int n10;
        object = "AppId";
        Object object2 = this.getDevinfo((String)object);
        this.a = object2;
        object2 = this.getDevinfo("BypassApproval");
        String string2 = "true";
        this.b = n10 = string2.equals(object2);
        object2 = this.a;
        if (object2 == null || (n10 = object2.length()) <= 0) {
            int n11;
            object2 = "QQ";
            this.a = string2 = this.getDevinfo((String)object2, (String)object);
            if (string2 != null && (n11 = string2.length()) > 0) {
                string2 = NAME;
                this.copyDevinfo((String)object2, string2);
                object = this.getDevinfo((String)object);
                this.a = object;
                object = SSDKLog.b();
                n10 = 0;
                object2 = new Object[]{};
                string2 = "Try to use the dev info of QQ, this will cause Id and SortId field are always 0.";
                ((NLog)object).d(string2, object2);
            }
        }
    }

    public boolean isClientValid() {
        b b10 = cn.sharesdk.tencent.qzone.b.a(this);
        String string2 = this.a;
        b10.a(string2);
        return b10.d();
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
            n10 = 24;
            this.a = string3 = this.getNetworkDevinfo(n10, (String)object, (String)objectArray);
            if (string3 != null && (n11 = string3.length()) > 0) {
                n11 = 6;
                this.copyNetworkDevinfo(n10, n11);
                object = this.getNetworkDevinfo((String)object, (String)objectArray);
                this.a = object;
                object = SSDKLog.b();
                objectArray = new Object[]{};
                string2 = "Try to use the dev info of QQ, this will cause Id and SortId field are always 0.";
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
            Object object5 = cn.sharesdk.tencent.qzone.b.a(this);
            try {
                int n12;
                object5 = ((b)object5).d((String)object);
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
                        string7 = "iconQQ";
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
                        String string12 = "icon";
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

