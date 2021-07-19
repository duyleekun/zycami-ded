/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package cn.sharesdk.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.facebook.f;
import cn.sharesdk.facebook.g;
import cn.sharesdk.facebook.h$1;
import cn.sharesdk.facebook.j;
import cn.sharesdk.facebook.k;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.a.b;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.c;
import cn.sharesdk.framework.authorize.d;
import cn.sharesdk.framework.e;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class h
extends e {
    private static final String[] b = new String[]{"email", "public_profile"};
    private static h c;
    private String d;
    private String e;
    private long f;
    private String g;
    private b h;
    private String[] i;
    private String j;

    private h(Platform object) {
        super((Platform)object);
        this.h = object = cn.sharesdk.framework.a.b.a();
    }

    public static h a(Platform platform) {
        h h10 = c;
        if (h10 == null) {
            c = h10 = new h(platform);
        }
        return c;
    }

    public static /* synthetic */ void a(h h10, AuthorizeListener authorizeListener) {
        h10.b(authorizeListener);
    }

    public HashMap a(int n10, int n11, String string2) {
        String string3 = string2 != null ? string2 : "me";
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string4 = this.e;
        Object object = new KVPair("access_token", string4);
        arrayList.add(object);
        String string5 = "json";
        object = new KVPair("format", string5);
        arrayList.add(object);
        Object object2 = String.valueOf(n10);
        string4 = "limit";
        object = new KVPair(string4, object2);
        arrayList.add(object);
        Object object3 = String.valueOf(n11);
        object2 = new KVPair("offset", object3);
        arrayList.add(object2);
        object3 = "fields";
        object = "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,cover,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture,quotes,relationship_status,religion,significant_other,video_upload_limits,website,work";
        object2 = new KVPair((String)object3, object);
        arrayList.add(object2);
        n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        object2 = n10 == 0 ? "/taggable_friends" : "/friends";
        object3 = new StringBuilder();
        string2 = "https://graph.facebook.com/v7.0/";
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append((String)object2);
        object2 = ((StringBuilder)object3).toString();
        object3 = this.h;
        int n12 = this.c();
        string3 = "friends";
        object2 = ((b)object3).a((String)object2, arrayList, string3, n12);
        if (object2 != null && (n11 = ((String)object2).length()) > 0) {
            object3 = new Hashon();
            return ((Hashon)object3).fromJson((String)object2);
        }
        return null;
    }

    public HashMap a(String string2, String object, HashMap object2, HashMap object3) {
        int n10;
        int n11;
        Object object4;
        Object object5;
        Object object6;
        int n12;
        if (object == null) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object2 != null && (n12 = ((HashMap)object2).size()) > 0) {
            object2 = ((HashMap)object2).entrySet().iterator();
            while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object6 = object2.next();
                object5 = (String)object6.getKey();
                object6 = String.valueOf(object6.getValue());
                object4 = new KVPair((String)object5, object6);
                arrayList.add(object4);
            }
        }
        object6 = this.e;
        object2 = new KVPair("access_token", object6);
        arrayList.add(object2);
        object6 = "format";
        object4 = "json";
        object2 = new KVPair((String)object6, object4);
        arrayList.add(object2);
        if (object3 != null && (n11 = ((HashMap)object3).size()) > 0) {
            object2 = ((HashMap)object3).entrySet().iterator();
            object3 = null;
            while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object3 = object2.next();
                object4 = (String)object3.getKey();
                object3 = object3.getValue();
                object3 = object6 = new KVPair((String)object4, object3);
            }
            object5 = object3;
        } else {
            object5 = null;
        }
        object2 = ((String)object).toUpperCase();
        object3 = "GET";
        n11 = (int)(((String)object3).equals(object2) ? 1 : 0);
        if (n11 != 0) {
            object = this.h;
            string2 = ((NetworkHelper)object).httpGet(string2, arrayList, null, null);
        } else {
            object2 = "POST";
            boolean n102 = ((String)object2).equals(object = ((String)object).toUpperCase());
            if (n102) {
                object6 = this.h;
                object4 = string2;
                string2 = ((NetworkHelper)object6).httpPost(string2, arrayList, (KVPair)object5, null, null);
            } else {
                string2 = null;
            }
        }
        if (string2 != null && (n10 = string2.length()) > 0) {
            object = new Hashon();
            return ((Hashon)object).fromJson(string2);
        }
        return null;
    }

    public void a(Platform$ShareParams object, PlatformActionListener platformActionListener) {
        boolean bl2;
        String string2 = ((InnerShareParams)object).getImageUrl();
        String string3 = ((InnerShareParams)object).getTitle();
        String string4 = ((InnerShareParams)object).getText();
        String string5 = ((InnerShareParams)object).getMusicUrl();
        Object object2 = ((InnerShareParams)object).getUrl();
        String string6 = ((InnerShareParams)object).getTitleUrl();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string6);
        if (!bl3) {
            object2 = this.a;
            string6 = ((Platform)object2).getShortLintk(string6, false);
            ((InnerShareParams)object).setTitleUrl(string6);
        } else {
            bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl3) {
                string6 = this.a.getShortLintk((String)object2, false);
                ((InnerShareParams)object).setUrl(string6);
            }
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("https://www.facebook.com/dialog/feed?");
        ((StringBuilder)object2).append("app_id=");
        String string7 = this.g;
        ((StringBuilder)object2).append(string7);
        ((StringBuilder)object2).append("&redirect_uri=fbconnect://success");
        ((StringBuilder)object2).append("&link=");
        string7 = "utf-8";
        string6 = Data.urlEncode(string6, string7);
        ((StringBuilder)object2).append(string6);
        string6 = ((InnerShareParams)object).getQuote();
        boolean bl4 = TextUtils.isEmpty((CharSequence)string6);
        if (!bl4) {
            string6 = "&quote=";
            ((StringBuilder)object2).append(string6);
            object = Data.urlEncode(((InnerShareParams)object).getQuote(), string7);
            ((StringBuilder)object2).append((String)object);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            ((StringBuilder)object2).append("&picture=");
            object = Data.urlEncode(string2, string7);
            ((StringBuilder)object2).append((String)object);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            ((StringBuilder)object2).append("&caption=");
            object = Data.urlEncode(string3, string7);
            ((StringBuilder)object2).append((String)object);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string4))) {
            ((StringBuilder)object2).append("&description=");
            object = Data.urlEncode(string4, string7);
            ((StringBuilder)object2).append((String)object);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string5))) {
            ((StringBuilder)object2).append("&source=");
            object = Data.urlEncode(string5, string7);
            ((StringBuilder)object2).append((String)object);
            bl2 = TextUtils.isEmpty((CharSequence)string4);
            if (!bl2) {
                ((StringBuilder)object2).append("&name=");
                object = Data.urlEncode(string4, string7);
                ((StringBuilder)object2).append((String)object);
            }
        }
        object = new k();
        string2 = ((StringBuilder)object2).toString();
        ((k)object).a(string2);
        ((k)object).a(platformActionListener);
        platformActionListener = MobSDK.getContext();
        ((FakeActivity)object).show((Context)platformActionListener, null);
    }

    public void a(PlatformActionListener platformActionListener, Platform$ShareParams platform$ShareParams) {
        NLog nLog = SSDKLog.b();
        Object object = new Object[]{};
        nLog.d("Facebook share by primordial appClientShare", (Object[])object);
        nLog = new Intent();
        object = platform$ShareParams.getTitle();
        nLog.putExtra("TITLE", (String)object);
        object = new j();
        Platform platform = this.a;
        String string2 = this.g;
        ((j)object).a(platformActionListener, platform, platform$ShareParams, string2);
        platformActionListener = MobSDK.getContext();
        ((FakeActivity)object).show((Context)platformActionListener, (Intent)nLog);
    }

    public void a(AuthorizeListener authorizeListener, boolean bl2) {
        if (bl2) {
            this.b(authorizeListener);
            return;
        }
        h$1 h$1 = new h$1(this, authorizeListener);
        this.a(h$1);
    }

    public void a(String string2) {
        this.g = string2;
    }

    public void a(String object, String object2) {
        boolean bl2;
        this.e = object;
        if (object2 != null && !(bl2 = ((String)object2).equals(object = "0"))) {
            long l10 = System.currentTimeMillis();
            object = Long.valueOf((String)object2);
            long l11 = (Long)object;
            long l12 = 1000L;
            l10 += (l11 *= l12);
            try {
                this.f = l10;
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).d(throwable);
            }
        }
    }

    public void a(String[] stringArray) {
        this.i = stringArray;
    }

    public boolean a() {
        long l10;
        long l11;
        long l12;
        long l13;
        int n10;
        String string2 = this.e;
        if (string2 != null && ((n10 = (l13 = (l12 = this.f) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == 0 || (n10 = (l10 = (l12 = System.currentTimeMillis()) - (l11 = this.f)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0)) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }

    public HashMap b(String string2) {
        int n10;
        Object[] objectArray;
        Object object;
        if (string2 != null) {
            object = new StringBuilder();
            objectArray = "/";
            ((StringBuilder)object).append((String)objectArray);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
        } else {
            string2 = "/me";
        }
        object = new ArrayList();
        CharSequence charSequence = this.e;
        objectArray = new KVPair("access_token", charSequence);
        ((ArrayList)object).add(objectArray);
        objectArray = new KVPair("format", "json");
        ((ArrayList)object).add(objectArray);
        objectArray = new KVPair("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture.type(large),quotes,relationship_status,religion,significant_other,video_upload_limits,website,work");
        ((ArrayList)object).add(objectArray);
        objectArray = this.h;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("https://graph.facebook.com/v7.0");
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        int n11 = this.c();
        String string3 = "get_user_info";
        string2 = objectArray.a(string2, (ArrayList)object, string3, n11);
        object = SSDKLog.b();
        objectArray = new Object[]{};
        charSequence = "facebook helper getUser";
        ((NLog)object).i(charSequence, objectArray);
        if (string2 != null && (n10 = string2.length()) > 0) {
            object = new Hashon();
            return ((Hashon)object).fromJson(string2);
        }
        return null;
    }

    public boolean b() {
        int n10;
        Signature[] signatureArray = new Intent();
        signatureArray.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        Object object = this.g;
        String string2 = "client_id";
        signatureArray.putExtra(string2, (String)object);
        object = this.i;
        if (object != null && (n10 = ((String[])object).length) > 0) {
            object = TextUtils.join((CharSequence)",", (Object[])object);
            string2 = "scope";
            signatureArray.putExtra(string2, (String)object);
        }
        object = MobSDK.getContext().getPackageManager();
        n10 = 0;
        string2 = null;
        if ((signatureArray = object.resolveActivity((Intent)signatureArray, 0)) == null) {
            return false;
        }
        signatureArray = signatureArray.activityInfo.packageName;
        object = MobSDK.getContext();
        object = object.getPackageManager();
        int n11 = 64;
        signatureArray = object.getPackageInfo((String)signatureArray, n11);
        signatureArray = signatureArray.signatures;
        int n12 = signatureArray.length;
        for (n11 = 0; n11 < n12; ++n11) {
            String string3;
            Object object2;
            try {
                object2 = signatureArray[n11];
                string3 = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            object2 = object2.toCharsString();
            boolean bl2 = string3.equals(object2);
            if (!bl2) continue;
            return true;
            break;
        }
        return false;
    }

    public void c(String string2) {
        this.j = string2;
    }

    public String getAuthorizeUrl() {
        Object object = new Bundle();
        Object object2 = this.g;
        object.putString("app_id", (String)object2);
        object2 = this.g;
        object.putString("client_id", (String)object2);
        object.putString("auth_type", "rerequest");
        object.putString("default_audience", "friends");
        object.putString("display", "touch");
        object.putString("fbapp_pres", "1");
        object2 = this.j;
        object.putString("redirect_uri", (String)object2);
        object.putString("response_type", "token,signed_request");
        object.putString("return_scopes", "true");
        object.putString("sdk", "android");
        object.putString("sdk_version", "5.4.0");
        object.putString("state", "{\"challenge\":\"G/I5SknMfRmyvIr/q5bFJNwIqI8=\"}");
        object.putString("title", "Log In");
        CharSequence charSequence = "user_agent";
        object.putString("type", (String)charSequence);
        object2 = this.i;
        if (object2 == null) {
            object2 = b;
        }
        charSequence = new StringBuilder();
        int n10 = ((String[])object2).length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = object2[i10];
            if (n11 > 0) {
                char c10 = ',';
                ((StringBuilder)charSequence).append(c10);
            }
            ((StringBuilder)charSequence).append(string2);
            ++n11;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("https://m.facebook.com/v4.0/dialog/oauth");
        ((StringBuilder)object2).append("?");
        object = ResHelper.encodeUrl((Bundle)object);
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        this.d = object;
        int n12 = this.c();
        ShareSDK.logApiEvent("/dialog/oauth", n12);
        object = SSDKLog.b();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("FbHelper===> ");
        charSequence = this.d;
        ((StringBuilder)object2).append((String)charSequence);
        object2 = ((StringBuilder)object2).toString();
        ((NLog)object).w((String)object2);
        return this.d;
    }

    public c getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.g g10) {
        g g11 = new g(g10);
        return g11;
    }

    public String getRedirectUri() {
        return this.j;
    }

    public cn.sharesdk.framework.authorize.e getSSOProcessor(d object) {
        f f10 = new f((d)object);
        int n10 = 32525;
        f10.a(n10);
        object = this.g;
        String[] stringArray = this.i;
        if (stringArray == null) {
            stringArray = b;
        }
        f10.a((String)object, stringArray);
        return f10;
    }
}

