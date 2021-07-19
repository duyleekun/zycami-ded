/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package cn.sharesdk.framework;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;

public class PlatformDb {
    private static final String DB_NAME = "cn_sharesdk_weibodb";
    private String platformNname;
    private int platformVersion;
    private SharePrefrenceHelper sp;

    public PlatformDb(String string2, int n10) {
        SharePrefrenceHelper sharePrefrenceHelper;
        Object object = MobSDK.getContext();
        this.sp = sharePrefrenceHelper = new SharePrefrenceHelper((Context)object);
        ((StringBuilder)object).append("cn_sharesdk_weibodb_");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        sharePrefrenceHelper.open((String)object, n10);
        this.platformNname = string2;
        this.platformVersion = n10;
    }

    public String exportData() {
        Object object;
        HashMap hashMap;
        try {
            hashMap = new HashMap();
            object = this.sp;
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
        object = ((SharePrefrenceHelper)object).getAll();
        hashMap.putAll(object);
        object = new Hashon();
        return ((Hashon)object).fromHashMap(hashMap);
    }

    public String get(String string2) {
        return this.sp.getString(string2);
    }

    public long getExpiresIn() {
        long l10;
        String string2 = "expiresIn";
        SharePrefrenceHelper sharePrefrenceHelper = this.sp;
        try {
            l10 = sharePrefrenceHelper.getLong(string2);
        }
        catch (Throwable throwable) {
            int n10;
            sharePrefrenceHelper = this.sp;
            try {
                n10 = sharePrefrenceHelper.getInt(string2);
            }
            catch (Throwable throwable2) {
                l10 = 0L;
            }
            l10 = n10;
        }
        return l10;
    }

    public long getExpiresTime() {
        long l10 = this.sp.getLong("expiresTime");
        long l11 = this.getExpiresIn() * 1000L;
        return l10 + l11;
    }

    public String getPlatformNname() {
        return this.platformNname;
    }

    public int getPlatformVersion() {
        return this.platformVersion;
    }

    public String getToken() {
        return this.sp.getString("token");
    }

    public String getTokenSecret() {
        return this.sp.getString("secret");
    }

    public String getUserGender() {
        String string2 = "0";
        String string3 = this.sp.getString("gender");
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            return "m";
        }
        string2 = "1";
        boolean bl3 = string2.equals(string3);
        if (bl3) {
            return "f";
        }
        return null;
    }

    public String getUserIcon() {
        return this.sp.getString("icon");
    }

    public String getUserId() {
        Object object = this.sp;
        String string2 = "userID";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((SharePrefrenceHelper)object).getString(string2)));
        if (bl2) {
            object = this.sp;
            string2 = "weibo";
            object = ((SharePrefrenceHelper)object).getString(string2);
        }
        return object;
    }

    public String getUserName() {
        return this.sp.getString("nickname");
    }

    public void importData(String object) {
        block6: {
            Object object2 = new Hashon();
            object = ((Hashon)object2).fromJson((String)object);
            if (object == null) break block6;
            object2 = this.sp;
            try {
                ((SharePrefrenceHelper)object2).putAll((HashMap)object);
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).d(throwable);
            }
        }
    }

    public boolean isValid() {
        int n10;
        String string2 = this.getToken();
        boolean bl2 = false;
        if (string2 != null && (n10 = string2.length()) > 0) {
            long l10;
            long l11 = this.getExpiresIn();
            long l12 = 0L;
            n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
            boolean bl3 = true;
            if (n10 == 0) {
                return bl3;
            }
            long l13 = this.getExpiresTime();
            long l14 = l13 - (l10 = System.currentTimeMillis());
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 > 0) {
                bl2 = bl3;
            }
        }
        return bl2;
    }

    public void put(String string2, String string3) {
        this.sp.putString(string2, string3);
    }

    public void putExpiresIn(long l10) {
        SharePrefrenceHelper sharePrefrenceHelper = this.sp;
        Object object = l10;
        sharePrefrenceHelper.putLong("expiresIn", (Long)object);
        object = this.sp;
        Long l11 = System.currentTimeMillis();
        ((SharePrefrenceHelper)object).putLong("expiresTime", l11);
    }

    public void putToken(String string2) {
        this.sp.putString("token", string2);
    }

    public void putTokenSecret(String string2) {
        this.sp.putString("secret", string2);
    }

    public void putUserId(String string2) {
        this.sp.putString("userID", string2);
    }

    public void removeAccount() {
        this.sp.clear();
    }
}

