/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  org.json.JSONObject
 */
package cn.sharesdk.tencent.qzone;

import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.authorize.d;
import cn.sharesdk.framework.authorize.e;
import cn.sharesdk.tencent.qzone.TencentSSOClientNotInstalledException;
import com.mob.tools.FakeActivity;
import org.json.JSONObject;

public class c
extends e {
    private String d;
    private String e;

    public c(d d10) {
        super(d10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        String string2;
        int n10;
        Object object;
        Object object2 = "com.tencent.mobileqq";
        try {
            object = this.a;
            object = ((FakeActivity)object).getContext();
            object = object.getPackageManager();
            n10 = 0;
            string2 = null;
            object = object.getPackageInfo((String)object2, 0);
            if (object == null) {
                this.a.finish();
                object2 = this.c;
                if (object2 != null) {
                    object = new TencentSSOClientNotInstalledException();
                    object2.onFailed((Throwable)object);
                }
                return;
            }
        }
        catch (Throwable throwable) {
            this.a.finish();
            object2 = this.c;
            if (object2 != null) {
                TencentSSOClientNotInstalledException tencentSSOClientNotInstalledException = new TencentSSOClientNotInstalledException();
                object2.onFailed(tencentSSOClientNotInstalledException);
            }
            return;
        }
        object = new Intent();
        String string3 = "com.tencent.open.agent.AgentActivity";
        object.setClassName((String)object2, string3);
        object2 = this.a.getContext().getPackageManager().resolveActivity((Intent)object, 0);
        if (object2 == null) {
            this.a.finish();
            object2 = this.c;
            if (object2 != null) {
                object = new TencentSSOClientNotInstalledException();
                object2.onFailed((Throwable)object);
            }
            return;
        }
        object2 = new Bundle();
        string2 = this.e;
        object2.putString("scope", string2);
        string2 = this.d;
        object2.putString("client_id", string2);
        object2.putString("pf", "openmobile_android");
        string3 = "1";
        object2.putString("need_pay", string3);
        object.putExtra("key_params", (Bundle)object2);
        int n11 = this.b;
        object.putExtra("key_request_code", n11);
        object2 = "key_action";
        string2 = "action_login";
        object.putExtra((String)object2, string2);
        try {
            object2 = this.a;
            n10 = this.b;
            ((FakeActivity)object2).startActivityForResult((Intent)object, n10);
            return;
        }
        catch (Throwable throwable) {
            this.a.finish();
            object = this.c;
            if (object != null) {
                object.onFailed(throwable);
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(int n10, int n11, Intent object) {
        int n12;
        Object object2 = "access_token";
        String string2 = "msg";
        String string3 = "pfkey";
        String string4 = "expires_in";
        String string5 = "pf";
        String string6 = "pay_token";
        String string7 = "ret";
        Object object3 = this.a;
        ((FakeActivity)object3).finish();
        if (n11 == 0) {
            object2 = this.c;
            if (object2 == null) return;
            object2.onCancel();
            return;
        }
        Object object4 = "response is empty";
        if (object == null) {
            object2 = this.c;
            if (object2 == null) return;
            object = new Throwable((String)object4);
            object2.onFailed((Throwable)object);
            return;
        }
        if ((object = object.getExtras()) == null) {
            object2 = this.c;
            if (object2 == null) return;
            object = new Throwable((String)object4);
            object2.onFailed((Throwable)object);
            return;
        }
        object3 = "key_response";
        boolean bl2 = object.containsKey((String)object3);
        if (!bl2) {
            object2 = this.c;
            if (object2 == null) return;
            object = new Throwable((String)object4);
            object2.onFailed((Throwable)object);
            return;
        }
        if ((object = object.getString((String)object3)) != null && (n12 = ((String)object).length()) > 0) {
            try {
                object4 = new JSONObject((String)object);
            }
            catch (Throwable throwable) {
                object4 = this.c;
                if (object4 == null) return;
                object4.onFailed(throwable);
                return;
            }
            object = new Bundle();
            n12 = object4.optInt(string7);
            object.putInt(string7, n12);
            string7 = object4.optString(string6);
            object.putString(string6, string7);
            string6 = object4.optString(string5);
            object.putString(string5, string6);
            string5 = "open_id";
            string6 = "openid";
            string6 = object4.optString(string6);
            object.putString(string5, string6);
            string5 = object4.optString(string4);
            object.putString(string4, string5);
            string4 = object4.optString(string3);
            object.putString(string3, string4);
            string3 = object4.optString(string2);
            object.putString(string2, string3);
            object4 = object4.optString((String)object2);
            object.putString((String)object2, (String)object4);
            object2 = this.c;
            if (object2 == null) return;
            object2.onComplete((Bundle)object);
            return;
        }
        object2 = this.c;
        if (object2 == null) return;
        object = new Throwable((String)object4);
        object2.onFailed((Throwable)object);
    }

    public void a(String string2, String string3) {
        this.d = string2;
        this.e = string3;
    }
}

