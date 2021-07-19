/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;

public class e {
    private static e b;
    private SharePrefrenceHelper a;

    private e() {
        SharePrefrenceHelper sharePrefrenceHelper;
        Context context = MobSDK.getContext();
        this.a = sharePrefrenceHelper = new SharePrefrenceHelper(context);
        sharePrefrenceHelper.open("share_sdk", 1);
    }

    public static e a() {
        e e10 = b;
        if (e10 == null) {
            b = e10 = new e();
        }
        return b;
    }

    public void a(long l10) {
        SharePrefrenceHelper sharePrefrenceHelper = this.a;
        Long l11 = l10;
        sharePrefrenceHelper.putLong("device_time", l11);
    }

    public void a(String string2) {
        this.a.putString("trans_short_link", string2);
    }

    public void a(String string2, int n10) {
        SharePrefrenceHelper sharePrefrenceHelper = this.a;
        Integer n11 = n10;
        sharePrefrenceHelper.putInt(string2, n11);
    }

    public void a(String string2, Long l10) {
        this.a.putLong(string2, l10);
    }

    public void a(String string2, Object object) {
        this.a.put(string2, object);
    }

    public void a(boolean bl2) {
        SharePrefrenceHelper sharePrefrenceHelper = this.a;
        Boolean bl3 = bl2;
        sharePrefrenceHelper.putBoolean("connect_server", bl3);
    }

    public long b() {
        return this.a.getLong("service_time");
    }

    public void b(long l10) {
        SharePrefrenceHelper sharePrefrenceHelper = this.a;
        Long l11 = l10;
        sharePrefrenceHelper.putLong("connect_server_time", l11);
    }

    public void b(String string2) {
        this.a.putString("upload_device_info", string2);
    }

    public void b(boolean bl2) {
        SharePrefrenceHelper sharePrefrenceHelper = this.a;
        Boolean bl3 = bl2;
        sharePrefrenceHelper.putBoolean("sns_info_buffered", bl3);
    }

    public void c(String string2) {
        this.a.putString("upload_user_info", string2);
    }

    public boolean c() {
        Object object = this.a;
        String string2 = "upload_device_info";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((SharePrefrenceHelper)object).getString(string2)));
        if (bl2) {
            return true;
        }
        return Boolean.parseBoolean((String)object);
    }

    public void d(String string2) {
        this.a.putString("upload_share_content", string2);
    }

    public boolean d() {
        Object object = this.a;
        String string2 = "upload_user_info";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((SharePrefrenceHelper)object).getString(string2)));
        if (bl2) {
            return true;
        }
        return Boolean.parseBoolean((String)object);
    }

    public void e(String string2) {
        this.a.putString("open_login_plus", string2);
    }

    public boolean e() {
        Object object = this.a;
        String string2 = "trans_short_link";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((SharePrefrenceHelper)object).getString(string2)));
        if (bl2) {
            return false;
        }
        return Boolean.parseBoolean((String)object);
    }

    public int f() {
        String string2 = "true";
        String string3 = this.a.getString("upload_share_content");
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            return 1;
        }
        string2 = "false";
        boolean bl3 = string2.equals(string3);
        if (bl3) {
            return -1;
        }
        return 0;
    }

    public void f(String string2) {
        this.a.putString("open_sina_link_card", string2);
    }

    public void g(String string2) {
        SharePrefrenceHelper sharePrefrenceHelper = this.a;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("buffered_snsconf_");
        String string3 = MobSDK.getAppkey();
        charSequence.append(string3);
        charSequence = charSequence.toString();
        sharePrefrenceHelper.putString((String)charSequence, string2);
    }

    public boolean g() {
        Object object = this.a;
        String string2 = "open_login_plus";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((SharePrefrenceHelper)object).getString(string2)));
        if (bl2) {
            return false;
        }
        return Boolean.parseBoolean((String)object);
    }

    public long h(String string2) {
        return this.a.getLong(string2);
    }

    public boolean h() {
        Object object = this.a;
        String string2 = "open_sina_link_card";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((SharePrefrenceHelper)object).getString(string2)));
        if (bl2) {
            return false;
        }
        return Boolean.parseBoolean((String)object);
    }

    public int i(String string2) {
        return this.a.getInt(string2);
    }

    public String i() {
        SharePrefrenceHelper sharePrefrenceHelper = this.a;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("buffered_snsconf_");
        String string2 = MobSDK.getAppkey();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        return sharePrefrenceHelper.getString((String)charSequence);
    }

    public Long j() {
        return this.a.getLong("device_time");
    }

    public Object j(String string2) {
        return this.a.get(string2);
    }

    public boolean k() {
        return this.a.getBoolean("connect_server");
    }

    public Long l() {
        return this.a.getLong("connect_server_time");
    }

    public boolean m() {
        return this.a.getBoolean("sns_info_buffered");
    }
}

