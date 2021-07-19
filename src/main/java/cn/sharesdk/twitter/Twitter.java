/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.twitter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.twitter.Twitter$1;
import cn.sharesdk.twitter.c;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Twitter
extends Platform {
    public static final String NAME = "Twitter";
    private String a;
    private String b;
    private String c;
    private boolean d;

    public static /* synthetic */ PlatformDb a(Twitter twitter) {
        return twitter.db;
    }

    public static /* synthetic */ void a(Twitter twitter, int n10, Object object) {
        twitter.afterRegister(n10, object);
    }

    public static /* synthetic */ PlatformDb b(Twitter twitter) {
        return twitter.db;
    }

    public static /* synthetic */ PlatformDb c(Twitter twitter) {
        return twitter.db;
    }

    public static /* synthetic */ PlatformDb d(Twitter twitter) {
        return twitter.db;
    }

    public static /* synthetic */ PlatformDb e(Twitter twitter) {
        return twitter.db;
    }

    public static /* synthetic */ PlatformDb f(Twitter twitter) {
        return twitter.db;
    }

    public static /* synthetic */ PlatformDb g(Twitter twitter) {
        return twitter.db;
    }

    public static /* synthetic */ PlatformDb h(Twitter twitter) {
        return twitter.db;
    }

    public static /* synthetic */ PlatformActionListener i(Twitter twitter) {
        return twitter.listener;
    }

    public static /* synthetic */ PlatformActionListener j(Twitter twitter) {
        return twitter.listener;
    }

    public static /* synthetic */ PlatformActionListener k(Twitter twitter) {
        return twitter.listener;
    }

    public static /* synthetic */ PlatformActionListener l(Twitter twitter) {
        return twitter.listener;
    }

    public boolean checkAuthorize(int n10, Object object) {
        boolean bl2;
        Object object2;
        boolean bl3 = this.isAuthValid();
        boolean bl4 = true;
        if (bl3) {
            object2 = cn.sharesdk.twitter.c.a(this);
            String string2 = this.a;
            String string3 = this.b;
            String string4 = this.c;
            ((c)object2).a(string2, string3, string4);
            string2 = this.db.getToken();
            string3 = this.db.getTokenSecret();
            if (string2 != null && string3 != null) {
                ((c)object2).a(string2, string3);
                return bl4;
            }
        }
        object2 = "twitter checkAuthorize ACTION_SHARE return true";
        int n11 = 9;
        if (n10 == n11 && (bl2 = this.d)) {
            SSDKLog.b().w((String)object2);
            return bl4;
        }
        if (n10 == n11 && (n11 = (int)(this.isClientValid() ? 1 : 0)) != 0 && (n11 = (int)(this.d ? 1 : 0)) != 0) {
            SSDKLog.b().w((String)object2);
            return bl4;
        }
        this.innerAuthorize(n10, object);
        return false;
    }

    public void doAuthorize(String[] object) {
        object = cn.sharesdk.twitter.c.a(this);
        Object object2 = this.a;
        String string2 = this.b;
        String string3 = this.c;
        ((c)object).a((String)object2, string2, string3);
        object2 = new Twitter$1(this, (c)object);
        boolean bl2 = this.isSSODisable();
        ((c)object).a((AuthorizeListener)object2, bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void doCustomerProtocol(String object, String object2, int n10, HashMap object3, HashMap hashMap) {
        c c10 = cn.sharesdk.twitter.c.a(this);
        try {
            int n11;
            object = c10.a((String)object, (String)object2, (HashMap)object3, hashMap);
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void doShare(Platform$ShareParams object) {
        int n10;
        HashMap hashMap;
        block22: {
            Object object2 = cn.sharesdk.twitter.c.a(this);
            int n11 = 9;
            try {
                String string2;
                boolean bl2;
                block21: {
                    int n12;
                    int n13;
                    int n14;
                    String string3;
                    Object object3;
                    String string4;
                    String string5;
                    Object object4;
                    String[] stringArray;
                    block23: {
                        block24: {
                            int n15;
                            stringArray = ((InnerShareParams)object).getImageArray();
                            object4 = ((InnerShareParams)object).getImagePath();
                            string5 = ((InnerShareParams)object).getImageUrl();
                            string4 = ((InnerShareParams)object).getText();
                            object3 = ((InnerShareParams)object).getFilePath();
                            string3 = ((InnerShareParams)object).getUrl();
                            n14 = 0;
                            Object[] objectArray = null;
                            string3 = this.getShortLintk(string3, false);
                            n13 = ((InnerShareParams)object).getShareType();
                            boolean bl3 = this.d;
                            hashMap = null;
                            if (!bl3) break block23;
                            object3 = SSDKLog.b();
                            string3 = "Twitter bypassApproval ";
                            objectArray = new Object[]{};
                            ((NLog)object3).d(string3, objectArray);
                            if (stringArray == null || (n15 = stringArray.length) <= 0) break block24;
                            object4 = this.listener;
                            ((c)object2).a(string4, stringArray, (PlatformActionListener)object4);
                            break block21;
                        }
                        bl2 = TextUtils.isEmpty((CharSequence)object4);
                        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)string5))) {
                            bl2 = TextUtils.isEmpty((CharSequence)string4);
                            if (!bl2) {
                                PlatformActionListener platformActionListener = this.listener;
                                ((c)object2).a(string4, platformActionListener);
                                break block21;
                            } else {
                                object2 = this.listener;
                                if (object2 != null) {
                                    String string6 = "Please set params";
                                    object = new Throwable(string6);
                                    object2.onError(this, n11, (Throwable)object);
                                    return;
                                }
                            }
                            break block21;
                        } else {
                            PlatformActionListener platformActionListener = this.listener;
                            ((c)object2).a(string4, (String)object4, string5, platformActionListener);
                        }
                        break block21;
                    }
                    n14 = 6;
                    if (n13 == n14 && (n14 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0)) == 0) {
                        hashMap = ((c)object2).f(string4, (String)object3);
                    } else if (stringArray != null && (n12 = stringArray.length) > 0) {
                        hashMap = ((c)object2).a(string4, stringArray);
                    } else {
                        File file;
                        bl2 = TextUtils.isEmpty((CharSequence)object4);
                        if (!bl2 && (bl2 = (file = new File((String)object4)).exists())) {
                            hashMap = ((c)object2).e(string4, (String)object4);
                        } else {
                            bl2 = TextUtils.isEmpty((CharSequence)string5);
                            if (!bl2) {
                                Context context = MobSDK.getContext();
                                String string7 = BitmapHelper.downloadBitmap((Context)context, (String)string5);
                                object4 = new File(string7);
                                boolean bl4 = ((File)object4).exists();
                                if (bl4) {
                                    hashMap = ((c)object2).e(string4, string7);
                                }
                            } else {
                                bl2 = TextUtils.isEmpty((CharSequence)string3);
                                hashMap = !bl2 ? ((c)object2).e(string3) : ((c)object2).e(string4);
                            }
                        }
                    }
                }
                n10 = 8;
                if (hashMap == null) {
                    object = this.listener;
                    if (object != null) {
                        String string8 = "response is null";
                        Throwable throwable = new Throwable(string8);
                        object.onError(this, n10, throwable);
                    }
                    return;
                }
                String string9 = "error_code";
                bl2 = hashMap.containsKey(string9);
                if (bl2 || (bl2 = hashMap.containsKey(string2 = "error"))) break block22;
                object2 = "ShareParams";
                hashMap.put(object2, object);
            }
            catch (Throwable throwable) {
                object2 = this.listener;
                if (object2 != null) {
                    object2.onError(this, n11, throwable);
                }
                return;
            }
            object = this.listener;
            if (object != null) {
                object.onComplete(this, n11, hashMap);
            }
            return;
        }
        object = this.listener;
        if (object != null) {
            object = new Hashon();
            object = ((Hashon)object).fromHashMap(hashMap);
            PlatformActionListener platformActionListener = this.listener;
            Throwable throwable = new Throwable((String)object);
            platformActionListener.onError(this, n10, throwable);
        }
    }

    public HashMap filterFriendshipInfo(int n10, HashMap object) {
        CharSequence charSequence;
        Object object2;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int n11 = 2;
        ArrayList arrayList = "type";
        if (n10 != n11) {
            n11 = 10;
            if (n10 != n11) {
                n11 = 11;
                if (n10 != n11) {
                    return null;
                }
                object2 = "FOLLOWERS";
                hashMap.put((String)((Object)arrayList), object2);
            } else {
                object2 = "FRIENDS";
                hashMap.put((String)((Object)arrayList), object2);
            }
        } else {
            object2 = "FOLLOWING";
            hashMap.put((String)((Object)arrayList), object2);
        }
        n10 = this.getPlatformId();
        object2 = n10;
        hashMap.put("snsplat", object2);
        object2 = this.db.getUserId();
        String string2 = "snsuid";
        hashMap.put(string2, object2);
        object2 = "next_cursor";
        boolean bl2 = ((HashMap)object).containsKey(object2);
        if (bl2) {
            object2 = String.valueOf(((HashMap)object).get(object2));
        } else {
            n10 = 0;
            object2 = null;
        }
        arrayList = "users";
        object = ((HashMap)object).get(arrayList);
        if (object == null) {
            return null;
        }
        arrayList = new ArrayList();
        int n12 = ((ArrayList)(object = (ArrayList)object)).size();
        if (n12 <= 0) {
            return null;
        }
        object = ((ArrayList)object).iterator();
        while (true) {
            n12 = (int)(object.hasNext() ? 1 : 0);
            charSequence = "0";
            if (n12 == 0) break;
            Object object3 = (HashMap)object.next();
            if (object3 == null) continue;
            HashMap<CharSequence, Object> hashMap2 = new HashMap<CharSequence, Object>();
            String string3 = String.valueOf(((HashMap)object3).get("id"));
            hashMap2.put(string2, string3);
            string3 = "screen_name";
            String string4 = String.valueOf(((HashMap)object3).get(string3));
            hashMap2.put("nickname", string4);
            string4 = String.valueOf(((HashMap)object3).get("profile_image_url"));
            hashMap2.put("icon", string4);
            hashMap2.put("gender", "2");
            string4 = String.valueOf(((HashMap)object3).get("description"));
            hashMap2.put("resume", string4);
            string4 = String.valueOf(((HashMap)object3).get("verified"));
            String string5 = "true";
            boolean bl3 = string5.equals(string4);
            if (bl3) {
                charSequence = "1";
            }
            hashMap2.put("secretType", charSequence);
            charSequence = String.valueOf(((HashMap)object3).get("followers_count"));
            hashMap2.put("followerCount", charSequence);
            charSequence = String.valueOf(((HashMap)object3).get("friends_count"));
            hashMap2.put("favouriteCount", charSequence);
            charSequence = String.valueOf(((HashMap)object3).get("statuses_count"));
            hashMap2.put("shareCount", charSequence);
            long l10 = ResHelper.dateToLong(String.valueOf(((HashMap)object3).get("created_at")));
            charSequence = String.valueOf(l10);
            hashMap2.put("snsregat", charSequence);
            charSequence = new StringBuilder();
            string4 = "https://twitter.com/";
            ((StringBuilder)charSequence).append(string4);
            object3 = ((HashMap)object3).get(string3);
            ((StringBuilder)charSequence).append(object3);
            object3 = ((StringBuilder)charSequence).toString();
            charSequence = "snsUserUrl";
            hashMap2.put(charSequence, object3);
            arrayList.add(hashMap2);
        }
        int n13 = arrayList.size();
        if (n13 <= 0) {
            return null;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)object2);
        string2 = "_false";
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n11 != 0 || (n10 = (int)(((String)charSequence).equals(object2) ? 1 : 0)) != 0) {
            object = "0_true";
        }
        hashMap.put("nextCursor", object);
        hashMap.put("list", arrayList);
        return hashMap;
    }

    public f$a filterShareContent(Platform$ShareParams object, HashMap hashMap) {
        f$a f$a = new f$a();
        f$a.b = object = ((InnerShareParams)object).getText();
        if (hashMap != null) {
            int n10;
            String string2;
            object = (HashMap)hashMap.get("entities");
            if (object != null && (object = (ArrayList)((HashMap)object).get(string2 = "media")) != null && (n10 = ((ArrayList)object).size()) > 0) {
                n10 = 0;
                string2 = null;
                if ((object = (HashMap)((ArrayList)object).get(0)) != null) {
                    object = f$a.d;
                    string2 = String.valueOf(hashMap.get("media_url"));
                    ((ArrayList)object).add(string2);
                }
            }
            f$a.a = object = String.valueOf(hashMap.get("id"));
            f$a.g = hashMap;
        }
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
        HashMap hashMap;
        block12: {
            c c10;
            Object object;
            block11: {
                hashMap = null;
                n11 = (int)(TextUtils.isEmpty(null) ? 1 : 0);
                if (n11 != 0) {
                    object = this.db.getUserId();
                } else {
                    n11 = 0;
                    object = null;
                }
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (bl2) {
                    object = this.db.getUserName();
                }
                if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
                    return null;
                }
                c10 = cn.sharesdk.twitter.c.a(this);
                try {
                    boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
                    if (!bl3) break block11;
                    string2 = "0";
                }
                catch (Throwable throwable) {
                    SSDKLog.b().d(throwable);
                    return null;
                }
            }
            object = c10.c((String)object, string2);
            if (object == null) break block12;
            int n12 = ((HashMap)object).size();
            if (n12 <= 0) break block12;
            string2 = "error_code";
            n12 = (int)(((HashMap)object).containsKey(string2) ? 1 : 0);
            if (n12 != 0) break block12;
            string2 = "error";
            n12 = (int)(((HashMap)object).containsKey(string2) ? 1 : 0);
            if (n12 != 0) break block12;
            n12 = 11;
            hashMap = this.filterFriendshipInfo(n12, (HashMap)object);
        }
        return hashMap;
    }

    public HashMap getFollowings(int n10, int n11, String string2) {
        HashMap hashMap;
        block12: {
            c c10;
            Object object;
            block11: {
                hashMap = null;
                n11 = (int)(TextUtils.isEmpty(null) ? 1 : 0);
                if (n11 != 0) {
                    object = this.db.getUserId();
                } else {
                    n11 = 0;
                    object = null;
                }
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (bl2) {
                    object = this.db.getUserName();
                }
                if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
                    return null;
                }
                c10 = cn.sharesdk.twitter.c.a(this);
                try {
                    boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
                    if (!bl3) break block11;
                    string2 = "0";
                }
                catch (Throwable throwable) {
                    SSDKLog.b().d(throwable);
                    return null;
                }
            }
            object = c10.b((String)object, string2);
            if (object == null) break block12;
            int n12 = ((HashMap)object).size();
            if (n12 <= 0) break block12;
            string2 = "error_code";
            n12 = (int)(((HashMap)object).containsKey(string2) ? 1 : 0);
            if (n12 != 0) break block12;
            string2 = "error";
            n12 = (int)(((HashMap)object).containsKey(string2) ? 1 : 0);
            if (n12 != 0) break block12;
            n12 = 2;
            hashMap = this.filterFriendshipInfo(n12, (HashMap)object);
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void getFriendList(int n10, int n11, String object) {
        Object object2;
        Object object3 = null;
        n11 = (int)(TextUtils.isEmpty(null) ? 1 : 0);
        if (n11 != 0) {
            object3 = this.db.getUserId();
        }
        if ((n11 = (int)(TextUtils.isEmpty(object3) ? 1 : 0)) != 0) {
            object3 = this.db.getUserName();
        }
        n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
        int n12 = 2;
        if (n11 != 0 && (object2 = this.listener) != null) {
            String string2 = "The account do not authorize!";
            Throwable throwable = new Throwable(string2);
            object2.onError(this, n12, throwable);
        }
        object2 = cn.sharesdk.twitter.c.a(this);
        try {
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                object = "0";
            }
            if ((object3 = ((c)object2).b((String)object3, (String)object)) != null && (n11 = ((HashMap)object3).size()) > 0) {
                object2 = "error_code";
                n11 = (int)(((HashMap)object3).containsKey(object2) ? 1 : 0);
                if (n11 == 0 && (n11 = (int)(((HashMap)object3).containsKey(object2 = "error") ? 1 : 0)) == 0) {
                    object2 = this.listener;
                    if (object2 == null) return;
                    object2.onComplete(this, n12, (HashMap)object3);
                    return;
                }
                object2 = this.listener;
                if (object2 == null) return;
                object2 = new Hashon();
                object3 = ((Hashon)object2).fromHashMap((HashMap)object3);
                object2 = this.listener;
                object = new Throwable((String)object3);
                object2.onError(this, n12, (Throwable)object);
                return;
            }
            object3 = this.listener;
            if (object3 == null) return;
            object = "response is null";
            object2 = new Throwable((String)object);
            object3.onError(this, n12, (Throwable)object2);
            return;
        }
        catch (Throwable throwable) {
            object2 = this.listener;
            if (object2 == null) return;
            object2.onError(this, n12, throwable);
        }
    }

    public String getName() {
        return NAME;
    }

    public int getPlatformId() {
        return 11;
    }

    public int getVersion() {
        return 2;
    }

    public boolean hasShareCallback() {
        return true;
    }

    public void initDevInfo(String string2) {
        boolean bl2;
        this.a = string2 = this.getDevinfo("ConsumerKey");
        this.b = string2 = this.getDevinfo("ConsumerSecret");
        this.c = string2 = this.getDevinfo("CallbackUrl");
        string2 = this.getDevinfo("BypassApproval");
        this.d = bl2 = "true".equals(string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isClientValid() {
        Context context;
        boolean bl2 = false;
        try {
            context = MobSDK.getContext();
        }
        catch (Throwable throwable) {
            return bl2;
        }
        PackageManager packageManager = context.getPackageManager();
        String string2 = "com.twitter.android";
        PackageInfo packageInfo = packageManager.getPackageInfo(string2, 0);
        String string3 = packageInfo.versionName;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) return true;
        return false;
    }

    public void setNetworkDevinfo() {
        String string2;
        this.a = string2 = this.getNetworkDevinfo("consumer_key", "ConsumerKey");
        this.b = string2 = this.getNetworkDevinfo("consumer_secret", "ConsumerSecret");
        this.c = string2 = this.getNetworkDevinfo("redirect_uri", "CallbackUrl");
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
        Object object2 = "screen_name";
        Object object3 = cn.sharesdk.twitter.c.a(this);
        int n10 = 8;
        try {
            int n11;
            object3 = ((c)object3).d((String)object);
            if (object3 != null && (n11 = ((HashMap)object3).size()) > 0) {
                Object object4 = "error_code";
                n11 = (int)(((HashMap)object3).containsKey(object4) ? 1 : 0);
                if (n11 == 0 && (n11 = (int)(((HashMap)object3).containsKey(object4 = "error") ? 1 : 0)) == 0) {
                    if (object == null) {
                        object = this.db;
                        object4 = "nickname";
                        Object v10 = ((HashMap)object3).get(object2);
                        String string2 = String.valueOf(v10);
                        ((PlatformDb)object).put((String)object4, string2);
                        object = this.db;
                        object4 = "icon";
                        String string3 = "profile_image_url";
                        Object v11 = ((HashMap)object3).get(string3);
                        String string4 = String.valueOf(v11);
                        ((PlatformDb)object).put((String)object4, string4);
                        object = this.db;
                        object4 = "gender";
                        String string5 = "2";
                        ((PlatformDb)object).put((String)object4, string5);
                        object = this.db;
                        object4 = "resume";
                        String string6 = "description";
                        Object v12 = ((HashMap)object3).get(string6);
                        String string7 = String.valueOf(v12);
                        ((PlatformDb)object).put((String)object4, string7);
                        object = "true";
                        object4 = "verified";
                        object4 = ((HashMap)object3).get(object4);
                        object4 = String.valueOf(object4);
                        boolean bl2 = ((String)object).equals(object4);
                        object4 = this.db;
                        String string8 = "secretType";
                        object = bl2 ? "1" : "0";
                        ((PlatformDb)object4).put(string8, (String)object);
                        object = this.db;
                        object4 = "followerCount";
                        String string9 = "followers_count";
                        Object v13 = ((HashMap)object3).get(string9);
                        String string10 = String.valueOf(v13);
                        ((PlatformDb)object).put((String)object4, string10);
                        object = this.db;
                        object4 = "favouriteCount";
                        String string11 = "friends_count";
                        Object v14 = ((HashMap)object3).get(string11);
                        String string12 = String.valueOf(v14);
                        ((PlatformDb)object).put((String)object4, string12);
                        object = this.db;
                        object4 = "shareCount";
                        String string13 = "statuses_count";
                        Object v15 = ((HashMap)object3).get(string13);
                        String string14 = String.valueOf(v15);
                        ((PlatformDb)object).put((String)object4, string14);
                        object = "created_at";
                        object = ((HashMap)object3).get(object);
                        object = String.valueOf(object);
                        long l10 = ResHelper.dateToLong((String)object);
                        object = this.db;
                        String string15 = "snsregat";
                        object4 = String.valueOf(l10);
                        ((PlatformDb)object).put(string15, (String)object4);
                        object = new StringBuilder();
                        object4 = "https://twitter.com/";
                        ((StringBuilder)object).append((String)object4);
                        object2 = ((HashMap)object3).get(object2);
                        ((StringBuilder)object).append(object2);
                        object = ((StringBuilder)object).toString();
                        object2 = this.db;
                        object4 = "snsUserUrl";
                        ((PlatformDb)object2).put((String)object4, (String)object);
                    }
                    if ((object = this.listener) == null) return;
                    object.onComplete(this, n10, (HashMap)object3);
                    return;
                }
                object = this.listener;
                if (object == null) return;
                object = new Hashon();
                object = ((Hashon)object).fromHashMap((HashMap)object3);
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
}

