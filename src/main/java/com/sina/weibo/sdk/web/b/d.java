/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.web.b.b;
import com.sina.weibo.sdk.web.b.b$a;
import com.sina.weibo.sdk.web.b.d$1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class d
extends b {
    public WeiboMultiMessage aJ;
    private byte[] aK;
    public String aL;
    public String aj;
    public String packageName;
    private String text;

    public d(Context context) {
        this.ae = context;
    }

    public d(AuthInfo authInfo) {
        super(authInfo, 1, null, null);
    }

    public final void a(Bundle bundle) {
        Object object = this.aJ;
        if (object != null) {
            ((WeiboMultiMessage)object).writeToBundle(bundle);
        }
        object = this.aj;
        bundle.putString("token", (String)object);
        object = this.packageName;
        bundle.putString("packageName", (String)object);
    }

    public final void a(b$a b$a) {
        com.sina.weibo.sdk.b.e e10;
        AuthInfo authInfo = this.aH.a();
        Context context = this.ae;
        Object object = this.aK;
        String string2 = new String((byte[])object);
        String string3 = authInfo.getAppKey();
        String string4 = this.aj;
        d$1 d$1 = new d$1(this, b$a);
        object = e10;
        e10 = new com.sina.weibo.sdk.b.e(context, string2, string3, string4, d$1);
        com.sina.weibo.sdk.b.b$a.n().a(e10);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(Bundle var1_1) {
        block18: {
            block17: {
                block16: {
                    var2_5 = new WeiboMultiMessage();
                    this.aJ = var2_5;
                    var2_5.readFromBundle((Bundle)var1_1);
                    this.aj = var2_5 = var1_1.getString("token");
                    var1_1 = var1_1.getString("packageName");
                    this.packageName = var1_1;
                    var1_1 = new StringBuilder();
                    var2_5 = this.aJ.textObject;
                    if (var2_5 != null) {
                        var2_5 = var2_5.text;
                        var1_1.append((String)var2_5);
                    }
                    if ((var2_5 = this.aJ.imageObject) == null) break block18;
                    var3_8 = var2_5.imagePath;
                    var4_13 = TextUtils.isEmpty((CharSequence)var3_8);
                    if (var4_13 || (var6_15 = (var5_14 = new File((String)var3_8)).exists()) == 0 || (var6_15 = (int)var5_14.canRead()) == 0 || (var6_15 = (int)((cfr_temp_0 = (var7_16 = var5_14.length()) - (var9_17 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) <= 0) break block17;
                    var7_16 = var5_14.length();
                    var6_15 = (int)var7_16;
                    var3_8 = new byte[var6_15];
                    var11_18 = null;
                    try {
                        var12_19 = new FileInputStream(var5_14);
                    }
                    catch (Throwable var1_3) {
                        break block16;
                    }
                    catch (Exception var3_10) {
                        // empty catch block
                        ** GOTO lbl-1000
                    }
                    try {
                        var12_19.read((byte[])var3_8);
                        var3_8 = e.b((byte[])var3_8);
                        this.aK = (byte[])var3_8;
                    }
                    catch (Throwable var1_2) {
                        var11_18 = var12_19;
                        break block16;
                    }
                    catch (Exception var3_9) {
                        var11_18 = var12_19;
                        ** GOTO lbl-1000
                    }
                    try {
                        var12_19.close();
                    }
                    catch (IOException var2_6) {
                        var2_6.printStackTrace();
                    }
                    break block18;
lbl-1000:
                    // 2 sources

                    {
                        var3_11.printStackTrace();
                        ** if (var11_18 == null) goto lbl-1000
                    }
lbl-1000:
                    // 1 sources

                    {
                        try {
                            var11_18.close();
                        }
                        catch (IOException var3_12) {
                            var3_12.printStackTrace();
                        }
                    }
lbl-1000:
                    // 2 sources

                    {
                        break block17;
                    }
                }
                if (var11_18 == null) throw var1_4;
                try {
                    var11_18.close();
                    throw var1_4;
                }
                catch (IOException var2_7) {
                    var2_7.printStackTrace();
                }
                throw var1_4;
            }
            if ((var2_5 = (Object)var2_5.imageData) != null && (var6_15 = ((Object)var2_5).length) > 0) {
                var2_5 = e.b((byte[])var2_5);
                this.aK = (byte[])var2_5;
            }
        }
        this.text = var1_1 = var1_1.toString();
    }

    public final String getUrl() {
        boolean bl2;
        String string2;
        Uri.Builder builder = Uri.parse((String)"https://service.weibo.com/share/mobilesdk.php").buildUpon();
        String string3 = this.text;
        builder.appendQueryParameter("title", string3);
        CharSequence charSequence = "0041005000";
        builder.appendQueryParameter("version", (String)charSequence);
        string3 = this.aH.a().getAppKey();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) {
            charSequence = "source";
            builder.appendQueryParameter((String)charSequence, string3);
        }
        if (!(bl3 = TextUtils.isEmpty((CharSequence)(charSequence = this.aj)))) {
            charSequence = this.aj;
            string2 = "access_token";
            builder.appendQueryParameter(string2, (String)charSequence);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(charSequence = e.f(this.ae, string3))))) {
            string2 = "aid";
            builder.appendQueryParameter(string2, (String)charSequence);
        }
        if (!(bl3 = TextUtils.isEmpty((CharSequence)(charSequence = this.packageName)))) {
            charSequence = this.packageName;
            string2 = "packagename";
            builder.appendQueryParameter(string2, (String)charSequence);
        }
        if (!(bl3 = TextUtils.isEmpty((CharSequence)(charSequence = this.aL)))) {
            charSequence = this.aL;
            string2 = "picinfo";
            builder.appendQueryParameter(string2, (String)charSequence);
        }
        builder.appendQueryParameter("luicode", "10000360");
        charSequence = new StringBuilder("OP_");
        ((StringBuilder)charSequence).append(string3);
        string3 = ((StringBuilder)charSequence).toString();
        builder.appendQueryParameter("lfid", string3);
        return builder.build().toString();
    }

    public final boolean w() {
        int n10;
        byte[] byArray = this.aK;
        if (byArray != null && (n10 = byArray.length) > 0) {
            return true;
        }
        return super.w();
    }
}

