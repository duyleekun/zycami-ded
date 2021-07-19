/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package d.v.a.i.a.y0;

import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.GT3Listener;
import d.v.a.f.a.a;
import d.v.a.i.a.y0.d;
import d.v.a.i.a.y0.d$a$a;
import org.json.JSONException;
import org.json.JSONObject;

public class d$a
extends GT3Listener {
    public final /* synthetic */ d a;

    public d$a(d d10) {
        this.a = d10;
    }

    public void onButtonClick() {
        k.d d10 = d.v.a.f.a.a.a.b();
        d$a$a d$a$a = new d$a$a(this);
        d10.h(d$a$a);
    }

    public void onClosed(int n10) {
    }

    public void onDialogReady(String string2) {
    }

    public void onDialogResult(String string2) {
        block16: {
            Object object = new JSONObject(string2);
            string2 = object.toString();
            Object object2 = null;
            object2 = new Object[]{};
            m.a.a.i(string2, object2);
            string2 = "geetest_challenge";
            string2 = object.getString(string2);
            object2 = "geetest_validate";
            object2 = object.getString((String)object2);
            Object object3 = "geetest_seccode";
            object = object.getString((String)object3);
            object3 = this.a;
            object3 = d.a((d)object3);
            ((GT3GeetestUtils)object3).showSuccessDialog();
            object3 = this.a;
            object3 = d.b((d)object3);
            if (object3 == null) break block16;
            object3 = this.a;
            object3 = d.b((d)object3);
            try {
                object3.a(string2, (String)object2, (String)object);
            }
            catch (JSONException jSONException) {
                d.a(this.a).showFailedDialog();
                object = d.b(this.a);
                if (object != null) {
                    object = d.b(this.a);
                    object2 = "";
                    object.onFailed((String)object2);
                }
                jSONException.printStackTrace();
            }
        }
    }

    public void onFailed(GT3ErrorBean gT3ErrorBean) {
    }

    public void onReceiveCaptchaCode(int n10) {
    }

    public void onStatistics(String string2) {
    }

    public void onSuccess(String string2) {
    }
}

