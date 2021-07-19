/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package cn.sharesdk.tencent.qq;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.e;
import cn.sharesdk.tencent.qq.a;
import com.mob.tools.FakeActivity;
import org.json.JSONObject;

public class d
extends e {
    private String d;
    private String e;
    private String f;

    public d(cn.sharesdk.framework.authorize.d d10) {
        super(d10);
    }

    private void b() {
        a a10 = new a();
        SSOListener sSOListener = this.c;
        a10.a(sSOListener);
        sSOListener = this.a.getContext();
        a10.show((Context)sSOListener, null);
    }

    public void a() {
        Object object;
        Object object2 = this.f;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2 && !(bl2 = ((String)(object2 = this.f)).equals(object = "com.tencent.qqlite"))) {
            object2 = new Intent();
            object = this.f;
            object2.setClassName((String)object, "com.tencent.open.agent.AgentActivity");
            object = this.a.getContext().getPackageManager();
            int n10 = 0;
            String string2 = null;
            object = object.resolveActivity((Intent)object2, 0);
            if (object == null) {
                this.a.finish();
                object2 = this.c;
                if (object2 != null) {
                    this.b();
                }
                return;
            }
            object = new Bundle();
            string2 = this.e;
            object.putString("scope", string2);
            string2 = this.d;
            object.putString("client_id", string2);
            object.putString("pf", "openmobile_android");
            String string3 = "1";
            object.putString("need_pay", string3);
            object2.putExtra("key_params", (Bundle)object);
            int n11 = this.b;
            object2.putExtra("key_request_code", n11);
            object = "key_action";
            string2 = "action_login";
            object2.putExtra((String)object, string2);
            try {
                object = this.a;
            }
            catch (Throwable throwable) {
                this.a.finish();
                object = this.c;
                if (object != null) {
                    object.onFailed(throwable);
                }
                return;
            }
            n10 = this.b;
            ((FakeActivity)object).startActivityForResult((Intent)object2, n10);
            return;
        }
        this.b();
        this.a.finish();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, int n11, Intent object) {
        int n12;
        Object object2 = "access_token";
        String string2 = "pfkey";
        String string3 = "expires_in";
        String string4 = "pf";
        String string5 = "pay_token";
        String string6 = "ret";
        String string7 = "msg";
        Object object3 = this.a;
        ((FakeActivity)object3).finish();
        if (n11 == 0) {
            object2 = this.c;
            if (object2 != null) {
                object2.onCancel();
            }
            return;
        }
        Object object4 = "response is empty";
        if (object == null) {
            object2 = this.c;
            if (object2 != null) {
                object = new Throwable((String)object4);
                object2.onFailed((Throwable)object);
            }
            return;
        }
        if ((object = object.getExtras()) == null) {
            object2 = this.c;
            if (object2 != null) {
                object = new Throwable((String)object4);
                object2.onFailed((Throwable)object);
            }
            return;
        }
        object3 = "key_response";
        boolean bl2 = object.containsKey((String)object3);
        if (!bl2) {
            object2 = this.c;
            if (object2 != null) {
                object = new Throwable((String)object4);
                object2.onFailed((Throwable)object);
            }
            return;
        }
        if ((object = object.getString((String)object3)) != null && (n12 = ((String)object).length()) > 0) {
            try {
                object4 = new JSONObject((String)object);
                object = new Bundle();
                n12 = object4.optInt(string6);
                object.putInt(string6, n12);
                string6 = object4.optString(string5);
                object.putString(string5, string6);
                string5 = object4.optString(string4);
                object.putString(string4, string5);
                string4 = "open_id";
                string5 = "openid";
                string5 = object4.optString(string5);
                object.putString(string4, string5);
                string4 = object4.optString(string3);
                object.putString(string3, string4);
                string3 = object4.optString(string2);
                object.putString(string2, string3);
                string2 = object4.optString(string7);
                object.putString(string7, string2);
                string2 = object4.optString((String)object2);
                object.putString((String)object2, string2);
                object2 = object4.optString(string7);
                n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                if (n11 == 0 && (object4 = this.c) != null) {
                    object = new Throwable((String)object2);
                    object4.onFailed((Throwable)object);
                    return;
                }
                object2 = this.c;
                if (object2 != null) {
                    object2.onComplete((Bundle)object);
                    object2 = null;
                    this.c = null;
                }
                return;
            }
            catch (Throwable throwable) {
                object4 = this.c;
                if (object4 != null) {
                    object4.onFailed(throwable);
                }
                return;
            }
        }
        object2 = this.c;
        if (object2 != null) {
            object = new Throwable((String)object4);
            object2.onFailed((Throwable)object);
        }
    }

    public void a(String string2, String string3, String string4) {
        this.d = string2;
        this.e = string3;
        this.f = string4;
    }
}

