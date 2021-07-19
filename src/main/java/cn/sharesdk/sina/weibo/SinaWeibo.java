/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package cn.sharesdk.sina.weibo;

import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.a.e;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.sina.weibo.SinaWeibo$1;
import cn.sharesdk.sina.weibo.a;
import cn.sharesdk.sina.weibo.b;
import cn.sharesdk.sina.weibo.i;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class SinaWeibo
extends Platform {
    public static final String NAME = "SinaWeibo";
    private String a;
    private String b;
    private String c;
    private boolean d;

    public static /* synthetic */ PlatformDb a(SinaWeibo sinaWeibo) {
        return sinaWeibo.db;
    }

    public static /* synthetic */ void a(SinaWeibo sinaWeibo, int n10, Object object) {
        sinaWeibo.afterRegister(n10, object);
    }

    public static /* synthetic */ PlatformDb b(SinaWeibo sinaWeibo) {
        return sinaWeibo.db;
    }

    public static /* synthetic */ PlatformDb c(SinaWeibo sinaWeibo) {
        return sinaWeibo.db;
    }

    private boolean c() {
        Object object = this.getDb();
        String string2 = "refresh_token";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((PlatformDb)object).get(string2)));
        if (!bl2) {
            object = i.a(this);
            string2 = this.a;
            String string3 = this.b;
            ((i)object).a(string2, string3);
            string2 = this.c;
            ((i)object).a(string2);
            bl2 = ((i)object).a();
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ PlatformDb d(SinaWeibo sinaWeibo) {
        return sinaWeibo.db;
    }

    public static /* synthetic */ PlatformDb e(SinaWeibo sinaWeibo) {
        return sinaWeibo.db;
    }

    public static /* synthetic */ PlatformActionListener f(SinaWeibo sinaWeibo) {
        return sinaWeibo.listener;
    }

    public static /* synthetic */ PlatformActionListener g(SinaWeibo sinaWeibo) {
        return sinaWeibo.listener;
    }

    public static /* synthetic */ PlatformActionListener h(SinaWeibo sinaWeibo) {
        return sinaWeibo.listener;
    }

    public static /* synthetic */ PlatformActionListener i(SinaWeibo sinaWeibo) {
        return sinaWeibo.listener;
    }

    public boolean checkAuthorize(int n10, Object object) {
        i i10 = i.a(this);
        String string2 = this.db.getToken();
        i10.c(string2);
        string2 = this.a;
        String string3 = this.b;
        i10.a(string2, string3);
        string2 = this.c;
        i10.a(string2);
        i10.d();
        boolean bl2 = true;
        int n11 = 9;
        if (n10 == n11) {
            return bl2;
        }
        n11 = (int)(this.isAuthValid() ? 1 : 0);
        if (n11 == 0 && (n11 = (int)(this.c() ? 1 : 0)) == 0) {
            this.innerAuthorize(n10, object);
            return false;
        }
        return bl2;
    }

    public void doAuthorize(String[] object) {
        i i10 = i.a(this);
        String string2 = this.a;
        String string3 = this.b;
        i10.a(string2, string3);
        string2 = this.c;
        i10.a(string2);
        i10.a((String[])object);
        object = new SinaWeibo$1(this, i10);
        boolean bl2 = this.isSSODisable();
        i10.a((AuthorizeListener)object, bl2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void doCustomerProtocol(String object, String object2, int n10, HashMap serializable, HashMap hashMap) {
        String string2 = "error_code";
        try {
            int n11;
            void var5_7;
            i i10 = i.a(this);
            object = i10.a((String)object, (String)object2, (HashMap)serializable, (HashMap)var5_7);
            if (object != null && (n11 = ((HashMap)object).size()) > 0) {
                n11 = (int)(((HashMap)object).containsKey(string2) ? 1 : 0);
                if (n11 != 0) {
                    object2 = ((HashMap)object).get(string2);
                    n11 = (Integer)(object2 = (Integer)object2);
                    if (n11 != 0) {
                        object2 = this.listener;
                        if (object2 == null) return;
                        object2 = new Hashon();
                        object = ((Hashon)object2).fromHashMap((HashMap)object);
                        object2 = this.listener;
                        Throwable throwable = new Throwable((String)object);
                        object2.onError(this, n10, throwable);
                        return;
                    }
                }
                if ((object2 = this.listener) == null) return;
                object2.onComplete(this, n10, (HashMap)object);
                return;
            }
            object = this.listener;
            if (object == null) return;
            object2 = new Throwable();
            object.onError(this, n10, (Throwable)object2);
            return;
        }
        catch (Throwable throwable) {
            object2 = this.listener;
            object2.onError(this, n10, throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void doShare(Platform$ShareParams object) {
        Object object2 = "url";
        String string2 = "error";
        Object object3 = i.a(this);
        Object object4 = this.a;
        String string3 = this.b;
        ((i)object3).a((String)object4, string3);
        boolean bl2 = this.d;
        int n10 = 9;
        if (bl2 && (bl2 = ((i)object3).b())) {
            try {
                String string4 = ((InnerShareParams)object).getLcSummary();
                JSONObject jSONObject = ((InnerShareParams)object).getLcImage();
                String string5 = ((InnerShareParams)object).getLcObjectType();
                String string6 = ((InnerShareParams)object).getLcDisplayName();
                String string7 = ((InnerShareParams)object).getLcCreateAt();
                String string8 = ((InnerShareParams)object).getLcUrl();
                object4 = e.a();
                bl2 = ((e)object4).h();
                if (bl2 && string4 != null && jSONObject != null && string5 != null && string6 != null && string7 != null && string8 != null) {
                    boolean bl3;
                    Object object5 = cn.sharesdk.sina.weibo.a.a();
                    object4 = ((a)object5).a(string4, jSONObject, string5, string6, string7, string8);
                    if (object4 != null && (bl3 = ((HashMap)object4).containsKey(string2)) && (object5 = this.listener) != null) {
                        object2 = new StringBuilder();
                        object3 = "error: ";
                        ((StringBuilder)object2).append((String)object3);
                        Object v10 = ((HashMap)object4).get(string2);
                        ((StringBuilder)object2).append(v10);
                        object2 = ((StringBuilder)object2).toString();
                        object = new Throwable((String)object2);
                        object2 = this.listener;
                        object2.onError(this, n10, (Throwable)object);
                        return;
                    }
                    int n11 = ((HashMap)object4).size();
                    if (n11 <= 0) return;
                    Object v11 = ((HashMap)object4).get(object2);
                    if (v11 == null) return;
                    object2 = ((HashMap)object4).get(object2);
                    object2 = String.valueOf(object2);
                    String string9 = ((InnerShareParams)object).getText();
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append(string9);
                    ((StringBuilder)object4).append((String)object2);
                    object2 = ((StringBuilder)object4).toString();
                    ((InnerShareParams)object).setText((String)object2);
                    object2 = this.listener;
                    ((i)object3).a((Platform$ShareParams)object, (PlatformActionListener)object2);
                    object = cn.sharesdk.sina.weibo.b.a();
                    int n12 = 2;
                    ((b)object).a(n12);
                    return;
                }
                object2 = this.listener;
                ((i)object3).a((Platform$ShareParams)object, (PlatformActionListener)object2);
                object = cn.sharesdk.sina.weibo.b.a();
                int n13 = 3;
                ((b)object).a(n13);
                return;
            }
            catch (Throwable throwable) {
                object2 = this.listener;
                object2.onError(this, n10, throwable);
                return;
            }
        }
        try {
            object2 = this.listener;
            ((i)object3).b((Platform$ShareParams)object, (PlatformActionListener)object2);
            return;
        }
        catch (Throwable throwable) {
            object2 = this.listener;
            object2.onError(this, n10, throwable);
        }
    }

    public HashMap filterFriendshipInfo(int n10, HashMap hashMap) {
        CharSequence charSequence;
        Object object;
        int n11 = n10;
        HashMap hashMap2 = hashMap;
        HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
        int n12 = 2;
        int n13 = 10;
        String string2 = "type";
        boolean bl2 = false;
        String string3 = null;
        if (n10 != n12) {
            if (n10 != n13) {
                n12 = 11;
                if (n10 != n12) {
                    return null;
                }
                object = "FOLLOWERS";
                hashMap3.put(string2, object);
            } else {
                object = "FRIENDS";
                hashMap3.put(string2, object);
            }
        } else {
            object = "FOLLOWING";
            hashMap3.put(string2, object);
        }
        n12 = this.getPlatformId();
        object = n12;
        hashMap3.put("snsplat", object);
        object = this;
        string2 = this.db.getUserId();
        String string4 = "snsuid";
        hashMap3.put(string4, string2);
        string2 = String.valueOf(hashMap2.get("current_cursor"));
        int n14 = Integer.parseInt(string2);
        String string5 = String.valueOf(hashMap2.get("total_number"));
        int n15 = Integer.parseInt(string5);
        if (n15 == 0) {
            return null;
        }
        Object object2 = hashMap2.get("users");
        if (object2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int n16 = ((ArrayList)(object2 = (ArrayList)object2)).size();
        if (n16 <= 0) {
            return null;
        }
        object2 = ((ArrayList)object2).iterator();
        while ((n16 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            HashMap hashMap4 = (HashMap)object2.next();
            if (hashMap4 == null) continue;
            HashMap<CharSequence, CharSequence> hashMap5 = new HashMap<CharSequence, CharSequence>();
            String string6 = String.valueOf(hashMap4.get("id"));
            hashMap5.put(string4, string6);
            string6 = String.valueOf(hashMap4.get("screen_name"));
            hashMap5.put("nickname", string6);
            string6 = String.valueOf(hashMap4.get("avatar_hd"));
            hashMap5.put("icon", string6);
            string6 = String.valueOf(hashMap4.get("verified"));
            boolean bl3 = string6.equals("true");
            String string7 = "1";
            String string8 = "0";
            charSequence = "secretType";
            if (bl3) {
                hashMap5.put(charSequence, string7);
            } else {
                hashMap5.put(charSequence, string8);
            }
            charSequence = String.valueOf(hashMap4.get("verified_reason"));
            hashMap5.put("secret", charSequence);
            charSequence = "gender";
            string6 = String.valueOf(hashMap4.get(charSequence));
            string3 = "m";
            bl2 = string6.equals(string3);
            if (bl2) {
                hashMap5.put(charSequence, string8);
            } else {
                string3 = "f";
                bl2 = string6.equals(string3);
                if (bl2) {
                    hashMap5.put(charSequence, string7);
                } else {
                    string3 = "2";
                    hashMap5.put(charSequence, string3);
                }
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("http://weibo.com/");
            string3 = String.valueOf(hashMap4.get("profile_url"));
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            hashMap5.put("snsUserUrl", charSequence);
            charSequence = String.valueOf(hashMap4.get("description"));
            hashMap5.put("resume", charSequence);
            charSequence = String.valueOf(hashMap4.get("followers_count"));
            hashMap5.put("followerCount", charSequence);
            charSequence = String.valueOf(hashMap4.get("friends_count"));
            hashMap5.put("favouriteCount", charSequence);
            charSequence = String.valueOf(hashMap4.get("statuses_count"));
            hashMap5.put("shareCount", charSequence);
            long l10 = ResHelper.dateToLong(String.valueOf(hashMap4.get("created_at")));
            charSequence = String.valueOf(l10);
            hashMap5.put("snsregat", charSequence);
            arrayList.add(hashMap5);
            n13 = 10;
            bl2 = false;
            string3 = null;
        }
        n13 = arrayList.size();
        if (n13 <= 0) {
            return null;
        }
        charSequence = "nextCursor";
        string3 = "_true";
        string4 = "_false";
        int n17 = 10;
        if (n17 == n11) {
            Object object3 = (Integer)hashMap2.get("page_count");
            n11 = (Integer)object3;
            int n18 = n14 + 1;
            if ((n11 *= n18) >= n15) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(n14);
                ((StringBuilder)object3).append(string3);
            } else {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(n18);
                ((StringBuilder)object3).append(string4);
            }
            object3 = ((StringBuilder)object3).toString();
            hashMap3.put((String)charSequence, object3);
        } else {
            CharSequence charSequence2;
            n11 = arrayList.size();
            if ((n14 += n11) >= n15) {
                charSequence2 = new StringBuilder();
                charSequence2.append(n15);
                charSequence2.append(string3);
            } else {
                charSequence2 = new StringBuilder();
                charSequence2.append(n14);
                charSequence2.append(string4);
            }
            charSequence2 = charSequence2.toString();
            hashMap3.put((String)charSequence, charSequence2);
        }
        hashMap3.put("list", arrayList);
        return hashMap3;
    }

    public f$a filterShareContent(Platform$ShareParams object, HashMap hashMap) {
        f$a f$a = new f$a();
        f$a.b = object = ((InnerShareParams)object).getText();
        if (hashMap != null) {
            f$a.a = object = String.valueOf(hashMap.get("id"));
            object = f$a.d;
            String string2 = String.valueOf(hashMap.get("original_pic"));
            ((ArrayList)object).add(string2);
            f$a.g = hashMap;
        }
        return f$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void follow(String object) {
        Object object2 = "error_code";
        Object object3 = i.a(this);
        int n10 = 6;
        try {
            object = ((i)object3).e((String)object);
            if (object == null) {
                object = this.listener;
                if (object == null) return;
                object2 = new Throwable();
                object.onError(this, n10, (Throwable)object2);
                return;
            }
            boolean bl2 = ((HashMap)object).containsKey(object2);
            if (bl2) {
                object2 = ((HashMap)object).get(object2);
                int n11 = (Integer)(object2 = (Integer)object2);
                if (n11 != 0) {
                    object2 = this.listener;
                    if (object2 == null) return;
                    object2 = new Hashon();
                    object = ((Hashon)object2).fromHashMap((HashMap)object);
                    object2 = this.listener;
                    object3 = new Throwable((String)object);
                    object2.onError(this, n10, (Throwable)object3);
                    return;
                }
            }
            if ((object2 = this.listener) == null) return;
            object2.onComplete(this, n10, (HashMap)object);
            return;
        }
        catch (Throwable throwable) {
            object2 = this.listener;
            object2.onError(this, n10, throwable);
        }
    }

    public HashMap getBilaterals(int n10, int n11, String object) {
        Object object2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = this.db.getUserId();
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            object = this.db;
            object2 = "nickname";
            object = ((PlatformDb)object).get((String)object2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            return null;
        }
        object2 = i.a(this);
        try {
            object = ((i)object2).c(n10, n11, (String)object);
            if (object == null) {
                return null;
            }
            object2 = "error_code";
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
        bl2 = ((HashMap)object).containsKey(object2);
        if (bl2) {
            return null;
        }
        object2 = "page_count";
        Object object3 = n10;
        ((HashMap)object).put(object2, object3);
        object3 = "current_cursor";
        Integer n12 = n11;
        ((HashMap)object).put(object3, n12);
        n10 = 10;
        return this.filterFriendshipInfo(n10, (HashMap)object);
    }

    public HashMap getFollowers(int n10, int n11, String object) {
        HashMap hashMap;
        Object object2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = this.db.getUserId();
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            object = this.db;
            object2 = "nickname";
            object = ((PlatformDb)object).get((String)object2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            return null;
        }
        object2 = i.a(this);
        try {
            hashMap = ((i)object2).d(n10, n11, (String)object);
            if (hashMap == null) {
                return null;
            }
            object = "error_code";
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
        boolean bl3 = hashMap.containsKey(object);
        if (bl3) {
            return null;
        }
        object = "current_cursor";
        Integer n12 = n11;
        hashMap.put(object, n12);
        n11 = 11;
        return this.filterFriendshipInfo(n11, hashMap);
    }

    public HashMap getFollowings(int n10, int n11, String object) {
        HashMap hashMap;
        Object object2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = this.db.getUserId();
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            object = this.db;
            object2 = "nickname";
            object = ((PlatformDb)object).get((String)object2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            return null;
        }
        object2 = i.a(this);
        try {
            hashMap = ((i)object2).b(n10, n11, (String)object);
            if (hashMap == null) {
                return null;
            }
            object = "error_code";
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
        boolean bl3 = hashMap.containsKey(object);
        if (bl3) {
            return null;
        }
        object = "current_cursor";
        Integer n12 = n11;
        hashMap.put(object, n12);
        n11 = 2;
        return this.filterFriendshipInfo(n11, hashMap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void getFriendList(int n10, int n11, String object) {
        Object object2;
        String string2 = "error_code";
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = this.db.getUserId();
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            object = this.db;
            object2 = "nickname";
            object = ((PlatformDb)object).get((String)object2);
        }
        bl2 = TextUtils.isEmpty((CharSequence)object);
        int n12 = 2;
        if (bl2) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener == null) return;
            object = "Both weibo id and screen_name are null";
            RuntimeException runtimeException = new RuntimeException((String)object);
            platformActionListener.onError(this, n12, runtimeException);
            return;
        }
        object2 = i.a(this);
        try {
            Object object3;
            Object object4 = ((i)object2).b(n10, n11, (String)object);
            if (object4 == null) {
                object4 = this.listener;
                if (object4 == null) return;
                Throwable throwable = new Throwable();
                object4.onError(this, n12, throwable);
                return;
            }
            n11 = (int)(((HashMap)object4).containsKey(string2) ? 1 : 0);
            if (n11 != 0) {
                object3 = ((HashMap)object4).get(string2);
                n11 = (Integer)(object3 = (Integer)object3);
                if (n11 != 0) {
                    object3 = this.listener;
                    if (object3 == null) return;
                    object3 = new Hashon();
                    object4 = ((Hashon)object3).fromHashMap((HashMap)object4);
                    object3 = this.listener;
                    object = new Throwable((String)object4);
                    object3.onError(this, n12, (Throwable)object);
                    return;
                }
            }
            if ((object3 = this.listener) == null) return;
            object3.onComplete(this, n12, (HashMap)object4);
            return;
        }
        catch (Throwable throwable) {
            PlatformActionListener platformActionListener = this.listener;
            platformActionListener.onError(this, n12, throwable);
        }
    }

    public String getName() {
        return NAME;
    }

    public int getPlatformId() {
        return 1;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return true;
    }

    public void initDevInfo(String string2) {
        boolean bl2;
        this.a = string2 = this.getDevinfo("AppKey");
        this.b = string2 = this.getDevinfo("AppSecret");
        this.c = string2 = this.getDevinfo("RedirectUrl");
        string2 = this.getDevinfo("ShareByAppClient");
        this.d = bl2 = "false".equals(string2) ^ true;
    }

    public boolean isClientValid() {
        return i.a(this).b();
    }

    public void setNetworkDevinfo() {
        String string2;
        this.a = string2 = this.getNetworkDevinfo("app_key", "AppKey");
        this.b = string2 = this.getNetworkDevinfo("app_secret", "AppSecret");
        this.c = string2 = this.getNetworkDevinfo("redirect_uri", "RedirectUrl");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void timeline(int n10, int n11, String object) {
        Object object2;
        String string2 = "error_code";
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = this.db.getUserId();
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            object = this.db;
            object2 = "nickname";
            object = ((PlatformDb)object).get((String)object2);
        }
        bl2 = TextUtils.isEmpty((CharSequence)object);
        int n12 = 7;
        if (bl2) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener == null) return;
            object = "Both weibo id and screen_name are null";
            RuntimeException runtimeException = new RuntimeException((String)object);
            platformActionListener.onError(this, n12, runtimeException);
            return;
        }
        object2 = i.a(this);
        try {
            Object object3;
            Object object4 = ((i)object2).a(n10, n11, (String)object);
            if (object4 == null) {
                object4 = this.listener;
                if (object4 == null) return;
                Throwable throwable = new Throwable();
                object4.onError(this, n12, throwable);
                return;
            }
            n11 = (int)(((HashMap)object4).containsKey(string2) ? 1 : 0);
            if (n11 != 0) {
                object3 = ((HashMap)object4).get(string2);
                n11 = (Integer)(object3 = (Integer)object3);
                if (n11 != 0) {
                    object3 = this.listener;
                    if (object3 == null) return;
                    object3 = new Hashon();
                    object4 = ((Hashon)object3).fromHashMap((HashMap)object4);
                    object3 = this.listener;
                    object = new Throwable((String)object4);
                    object3.onError(this, n12, (Throwable)object);
                    return;
                }
            }
            if ((object3 = this.listener) == null) return;
            object3.onComplete(this, n12, (HashMap)object4);
            return;
        }
        catch (Throwable throwable) {
            PlatformActionListener platformActionListener = this.listener;
            platformActionListener.onError(this, n12, throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void userInfor(String object) {
        Object object2;
        float f10;
        Object object3 = "error_code";
        Object object4 = "gender";
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        boolean bl3 = true;
        float f11 = Float.MIN_VALUE;
        if (bl2) {
            object = this.db.getUserId();
            bl2 = bl3;
            f10 = f11;
        } else {
            bl2 = false;
            f10 = 0.0f;
            object2 = null;
        }
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string2 = "nickname";
        if (n10 != 0) {
            object = this.db.get(string2);
        } else {
            bl3 = bl2;
            f11 = f10;
        }
        bl2 = TextUtils.isEmpty((CharSequence)object);
        n10 = 8;
        if (bl2) {
            object = this.listener;
            if (object == null) return;
            object4 = "Both weibo id and screen_name are null";
            object3 = new RuntimeException((String)object4);
            object.onError(this, n10, (Throwable)object3);
            return;
        }
        object2 = i.a(this);
        try {
            int n11;
            object = ((i)object2).d((String)object);
            if (object == null) {
                object = this.listener;
                if (object == null) return;
                object3 = new Throwable();
                object.onError(this, n10, (Throwable)object3);
                return;
            }
            bl2 = ((HashMap)object).containsKey(object3);
            if (bl2) {
                object3 = ((HashMap)object).get(object3);
                n11 = (Integer)(object3 = (Integer)object3);
                if (n11 != 0) {
                    object3 = this.listener;
                    if (object3 == null) return;
                    object3 = new Hashon();
                    object = ((Hashon)object3).fromHashMap((HashMap)object);
                    object3 = this.listener;
                    object4 = new Throwable((String)object);
                    object3.onError(this, n10, (Throwable)object4);
                    return;
                }
            }
            if (bl3) {
                object3 = this.db;
                object2 = "id";
                object2 = ((HashMap)object).get(object2);
                object2 = String.valueOf(object2);
                ((PlatformDb)object3).putUserId((String)object2);
                object3 = this.db;
                object2 = "screen_name";
                object2 = ((HashMap)object).get(object2);
                object2 = String.valueOf(object2);
                ((PlatformDb)object3).put(string2, (String)object2);
                object3 = this.db;
                object2 = "icon";
                String string3 = "avatar_hd";
                Object v10 = ((HashMap)object).get(string3);
                String string4 = String.valueOf(v10);
                ((PlatformDb)object3).put((String)object2, string4);
                object3 = "verified";
                object3 = ((HashMap)object).get(object3);
                object3 = String.valueOf(object3);
                object2 = "true";
                n11 = (int)(((String)object3).equals(object2) ? 1 : 0);
                object2 = "1";
                String string5 = "0";
                string2 = "secretType";
                if (n11 != 0) {
                    object3 = this.db;
                    ((PlatformDb)object3).put(string2, (String)object2);
                } else {
                    object3 = this.db;
                    ((PlatformDb)object3).put(string2, string5);
                }
                object3 = this.db;
                string2 = "secret";
                String string6 = "verified_reason";
                Object v11 = ((HashMap)object).get(string6);
                String string7 = String.valueOf(v11);
                ((PlatformDb)object3).put(string2, string7);
                object3 = ((HashMap)object).get(object4);
                object3 = String.valueOf(object3);
                string2 = "m";
                boolean bl4 = ((String)object3).equals(string2);
                if (bl4) {
                    object3 = this.db;
                    ((PlatformDb)object3).put((String)object4, string5);
                } else {
                    String string8 = "f";
                    n11 = (int)(((String)object3).equals(string8) ? 1 : 0);
                    if (n11 != 0) {
                        object3 = this.db;
                        ((PlatformDb)object3).put((String)object4, (String)object2);
                    } else {
                        object3 = this.db;
                        object2 = "2";
                        ((PlatformDb)object3).put((String)object4, (String)object2);
                    }
                }
                object3 = this.db;
                object4 = "snsUserUrl";
                object2 = new StringBuilder();
                String string9 = "http://weibo.com/";
                ((StringBuilder)object2).append(string9);
                String string10 = "profile_url";
                Object v12 = ((HashMap)object).get(string10);
                String string11 = String.valueOf(v12);
                ((StringBuilder)object2).append(string11);
                object2 = ((StringBuilder)object2).toString();
                ((PlatformDb)object3).put((String)object4, (String)object2);
                object3 = this.db;
                object4 = "resume";
                object2 = "description";
                object2 = ((HashMap)object).get(object2);
                object2 = String.valueOf(object2);
                ((PlatformDb)object3).put((String)object4, (String)object2);
                object3 = this.db;
                object4 = "followerCount";
                object2 = "followers_count";
                object2 = ((HashMap)object).get(object2);
                object2 = String.valueOf(object2);
                ((PlatformDb)object3).put((String)object4, (String)object2);
                object3 = this.db;
                object4 = "favouriteCount";
                object2 = "friends_count";
                object2 = ((HashMap)object).get(object2);
                object2 = String.valueOf(object2);
                ((PlatformDb)object3).put((String)object4, (String)object2);
                object3 = this.db;
                object4 = "shareCount";
                object2 = "statuses_count";
                object2 = ((HashMap)object).get(object2);
                object2 = String.valueOf(object2);
                ((PlatformDb)object3).put((String)object4, (String)object2);
                object3 = "created_at";
                object3 = ((HashMap)object).get(object3);
                object3 = String.valueOf(object3);
                long l10 = ResHelper.dateToLong((String)object3);
                object2 = this.db;
                String string12 = "snsregat";
                object3 = String.valueOf(l10);
                ((PlatformDb)object2).put(string12, (String)object3);
            }
            if ((object3 = this.listener) == null) return;
            object3.onComplete(this, n10, (HashMap)object);
            return;
        }
        catch (Throwable throwable) {
            object3 = this.listener;
            object3.onError(this, n10, throwable);
        }
    }
}

