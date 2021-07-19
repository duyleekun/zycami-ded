/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.account.data.me.remote;

import android.text.TextUtils;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.remote.AccountManager$1;
import com.zhiyun.account.data.me.remote.AccountManager$2;
import com.zhiyun.account.data.me.remote.AccountManager$3;
import com.zhiyun.account.data.me.remote.AccountManager$4;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.AccountManager$ThirdBindData;
import com.zhiyun.common.util.Devices;
import d.v.a.f.a.a;
import d.v.a.f.c.d.d;
import d.v.a.i.a.w0.c;
import d.v.e.l.w1;
import k.f;

public class AccountManager {
    public static void bindAccount(String object, String string2, String string3, String string4, d.v.a.f.b.a a10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string5 = "";
        if (!bl2 && !(bl2 = c.c(string3))) {
            int n10 = 127;
            a10.onError(null, n10, string5);
        } else {
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2 && !(bl2 = c.b(string3))) {
                int n11 = 125;
                a10.onError(null, n11, string5);
            } else {
                a a11 = a.a;
                string2 = c.f(string2, string3);
                object = a11.v(string2, string4, (String)object);
                object.h(a10);
            }
        }
    }

    public static void bindLeanCloudPush(String object, String object2, String string2) {
        a a10 = a.a;
        String string3 = w1.a();
        object = a10.h((String)object, (String)object2, string2, string3);
        object2 = AccountManager.getApiCallBack();
        object.h((f)object2);
    }

    public static void bindThird(String string2, String string3, AccountManager$AuthData accountManager$AuthData, d.v.a.f.b.a a10) {
        a a11 = a.a;
        AccountManager$ThirdBindData accountManager$ThirdBindData = new AccountManager$ThirdBindData(string2, string3, accountManager$AuthData);
        a11.t(accountManager$ThirdBindData).h(a10);
    }

    public static void bindThirdPartyAccount(String object, AccountManager$AuthData object2, d.v.a.f.b.a a10) {
        a a11 = a.a;
        object2 = ((AccountManager$AuthData)object2).toJsonString();
        object = a11.r((String)object, (String)object2);
        object2 = AccountManager.getApiCallBack(a10);
        object.h((f)object2);
    }

    public static void bindVerify(String string2, String string3, String string4, d.v.a.f.b.a a10) {
        a a11 = a.a;
        string2 = c.f(string2, string3);
        a11.d(string2, string4).h(a10);
    }

    public static UserInfo convertUserInfoResponse(UserInfo userInfo) {
        if (userInfo != null) {
            String string2 = userInfo.getCountry();
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            String string3 = "";
            string2 = bl2 ? string3 : userInfo.getCountry();
            userInfo.setCountry(string2);
            string2 = userInfo.getCity();
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            string2 = bl2 ? string3 : userInfo.getCity();
            userInfo.setCity(string2);
            string2 = userInfo.getIntroduction();
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            string2 = bl2 ? string3 : userInfo.getIntroduction();
            userInfo.setIntroduction(string2);
            string2 = userInfo.getHobby();
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                string3 = userInfo.getHobby();
            }
            userInfo.setHobby(string3);
            string2 = userInfo.getToken();
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            string2 = bl2 ? d.F().K() : userInfo.getToken();
            userInfo.setToken(string2);
        }
        return userInfo;
    }

    private static d.v.a.f.b.a getApiCallBack() {
        AccountManager$2 accountManager$2 = new AccountManager$2();
        return accountManager$2;
    }

    private static d.v.a.f.b.a getApiCallBack(d.v.a.f.b.a a10) {
        AccountManager$1 accountManager$1 = new AccountManager$1(a10);
        return accountManager$1;
    }

    public static void getBindThirdList(String string2, d.v.a.f.b.a a10) {
        a.a.f(string2).h(a10);
    }

    public static void getFacebookToken(String string2, f f10) {
        a.a.n("https://graph.facebook.com/v5.0/me", string2, "token_for_business").h(f10);
    }

    public static void initPassword(String string2, String string3, d.v.a.f.b.a a10) {
        a.a.A(string2, string3).h(a10);
    }

    public static void loginByImei(d.v.a.f.b.a a10) {
        Object object = Devices.k(d.v.e.f.a().c());
        object = a.a.q((String)object);
        a10 = AccountManager.getApiCallBack(a10);
        object.h(a10);
    }

    public static void queryUserDetail(int n10, d.v.a.f.b.a a10) {
        Object object = a.a;
        Object object2 = d.F().K();
        object = object.e(n10, (String)object2);
        object2 = new AccountManager$3(n10, a10);
        object.h((f)object2);
    }

    public static void quickLogin(String object, String object2, String string2, d.v.a.f.b.a a10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string3 = "";
        if (!bl2 && !(bl2 = c.c((String)object2))) {
            int n10 = 127;
            a10.onError(null, n10, string3);
        } else {
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2 && !(bl2 = c.b((String)object2))) {
                int n11 = 125;
                a10.onError(null, n11, string3);
            } else {
                a a11 = a.a;
                object = c.f((String)object, (String)object2);
                object = a11.o((String)object, string2);
                object2 = AccountManager.getApiCallBack(a10);
                object.h((f)object2);
            }
        }
    }

    public static void removeBind(boolean bl2, String string2, d.v.a.f.b.a a10) {
        a a11 = a.a;
        String string3 = bl2 ? "2" : "1";
        a11.i(string3, string2).h(a10);
    }

    public static void removeThird(int n10, String string2, d.v.a.f.b.a a10) {
        a.a.a(n10, string2).h(a10);
    }

    public static void requestCode(String string2, String string3, String string4, String string5, String string6, boolean bl2, d.v.a.f.b.a a10) {
        d.v.a.f.b.a a11 = a10;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        String string7 = "";
        if (n10 == 0 && (n10 = c.c(string3)) == 0) {
            n10 = 127;
            a10.onError(null, n10, string7);
        } else {
            n10 = TextUtils.isEmpty((CharSequence)string2);
            if (n10 != 0 && (n10 = (int)(c.b(string3) ? 1 : 0)) == 0) {
                n10 = 125;
                a11.onError(null, n10, string7);
            } else {
                a a12 = a.a;
                String string8 = c.f(string2, string3);
                String string9 = w1.a();
                Object object = bl2 ? "Y" : "N";
                object = a12.u(string8, string9, string4, string5, string6, (String)object);
                object.h(a11);
            }
        }
    }

    public static void requestLogout() {
        Object object = d.F().K();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            Object object2 = d.F().J();
            AccountManager.unbindLeanCloudPush((String)object, (String)object2);
            object = a.a.w((String)object);
            object2 = AccountManager.getApiCallBack();
            object.h((f)object2);
        }
    }

    public static void requestPasswordReset(String object, String string2, String string3, String string4, String string5, d.v.a.f.b.a a10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string6 = "";
        if (!bl2 && !(bl2 = c.c(string2))) {
            int n10 = 127;
            a10.onError(null, n10, string6);
        } else {
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2 && !(bl2 = c.b(string2))) {
                int n11 = 125;
                a10.onError(null, n11, string6);
            } else {
                a a11 = a.a;
                String string7 = c.f((String)object, string2);
                String string8 = w1.a();
                object = a11.z(string7, string8, string3, string4, string5);
                object.h(a10);
            }
        }
    }

    public static void requestSignIn(String object, String object2, String string2, d.v.a.f.b.a a10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string3 = "";
        if (!bl2 && !(bl2 = c.c((String)object2))) {
            int n10 = 127;
            a10.onError(null, n10, string3);
        } else {
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2 && !(bl2 = c.b((String)object2))) {
                int n11 = 125;
                a10.onError(null, n11, string3);
            } else {
                a a11 = a.a;
                object = c.f((String)object, (String)object2);
                object = a11.g((String)object, string2);
                object2 = AccountManager.getApiCallBack(a10);
                object.h((f)object2);
            }
        }
    }

    public static void requestSignUp(String object, String string2, String string3, String string4, boolean bl2, d.v.a.f.b.a a10) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        String string5 = "";
        if (!bl3 && !(bl3 = c.c(string2))) {
            int n10 = 127;
            a10.onError(null, n10, string5);
        } else {
            bl3 = TextUtils.isEmpty((CharSequence)object);
            if (bl3 && !(bl3 = c.b(string2))) {
                int n11 = 125;
                a10.onError(null, n11, string5);
            } else {
                bl3 = c.e(string3);
                if (!bl3) {
                    int n12 = 10124;
                    a10.onError(null, n12, string5);
                } else {
                    a a11 = a.a;
                    object = c.f((String)object, string2);
                    object = a11.c((String)object, string3, string4, (int)(bl2 ? 1 : 0));
                    object.h(a10);
                }
            }
        }
    }

    public static void requestVerifyVCode(String object, String string2, String string3, boolean bl2, d.v.a.f.b.a a10) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        String string4 = "";
        if (!bl3 && !(bl3 = c.c(string2))) {
            int n10 = 127;
            a10.onError(null, n10, string4);
        } else {
            bl3 = TextUtils.isEmpty((CharSequence)object);
            if (bl3 && !(bl3 = c.b(string2))) {
                int n11 = 125;
                a10.onError(null, n11, string4);
            } else {
                a a11 = a.a;
                object = c.f((String)object, string2);
                string2 = bl2 ? "Y" : "N";
                object = a11.k((String)object, string3, string2);
                object.h(a10);
            }
        }
    }

    public static void resetPassword(String object, String object2, String string2, String string3, d.v.a.f.b.a a10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string4 = "";
        if (!bl2 && !(bl2 = c.c((String)object2))) {
            int n10 = 127;
            a10.onError(null, n10, string4);
        } else {
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2 && !(bl2 = c.b((String)object2))) {
                int n11 = 125;
                a10.onError(null, n11, string4);
            } else {
                bl2 = c.e(string2);
                if (!bl2) {
                    int n12 = 10124;
                    a10.onError(null, n12, string4);
                } else {
                    object = c.f((String)object, (String)object2);
                    object2 = a.a;
                    object = object2.m((String)object, string2, string3);
                    object.h(a10);
                }
            }
        }
    }

    public static void setAdnotification(int n10, d.v.a.f.b.a a10) {
        a a11 = a.a;
        String string2 = d.F().K();
        a11.p(string2, n10).h(a10);
    }

    public static void unbindLeanCloudPush(String object, String object2) {
        object = a.a.j((String)object, (String)object2);
        object2 = AccountManager.getApiCallBack();
        object.h((f)object2);
    }

    public static void updateLangLeanCloudPush(String object, String object2, String string2, String string3) {
        object = a.a.s((String)object, (String)object2, string2, string3);
        object2 = AccountManager.getApiCallBack();
        object.h((f)object2);
    }

    public static void updateUserDetail(UserInfo object, d.v.a.f.b.a a10) {
        Object object2 = a.a;
        String string2 = d.F().K();
        String string3 = ((UserInfo)object).getAvatar();
        String string4 = ((UserInfo)object).getNickname();
        String string5 = ((UserInfo)object).getCountry();
        String string6 = ((UserInfo)object).getIntroduction();
        CharSequence charSequence = new StringBuilder();
        int n10 = ((UserInfo)object).getSex();
        charSequence.append(n10);
        charSequence.append("");
        charSequence = charSequence.toString();
        object = object2.y(string2, string3, string4, string5, string6, (String)charSequence);
        object2 = new AccountManager$4(a10);
        object.h((f)object2);
    }

    public static void webLogin(String string2, String string3, d.v.a.f.b.a a10) {
        a.a.x(string2, string3).h(a10);
    }
}

