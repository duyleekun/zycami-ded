/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package d.v.a.i.a.y0;

import com.geetest.sdk.GT3ConfigBean;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import d.v.a.i.a.y0.d;
import d.v.a.i.a.y0.d$a;
import k.f;
import k.r;
import org.json.JSONObject;

public class d$a$a
implements f {
    public final /* synthetic */ d$a a;

    public d$a$a(d$a d$a) {
        this.a = d$a;
    }

    public void onFailure(k.d d10, Throwable throwable) {
        d.a(this.a.a).getGeetest();
    }

    public void onResponse(k.d object, r object2) {
        object = this.a;
        object = ((d$a)object).a;
        object = d.c((d)object);
        object2 = ((r)object2).a();
        object2 = (JsonObject)object2;
        object2 = ((JsonElement)object2).toString();
        JSONObject jSONObject = new JSONObject((String)object2);
        try {
            ((GT3ConfigBean)object).setApi1Json(jSONObject);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        d.a(this.a.a).getGeetest();
    }
}

