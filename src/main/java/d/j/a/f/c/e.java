/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package d.j.a.f.c;

import android.util.Log;
import d.j.a.f.c.c;
import d.j.a.f.c.i;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class e
implements c {
    private final JSONObject a;

    public e(InputStream inputStream) {
        inputStream = this.b(inputStream);
        this.a = inputStream;
    }

    private JSONObject b(InputStream object) {
        String string2 = "InputStreamReader";
        if (object != null) {
            String string3 = "UTF-8";
            object = i.a((InputStream)object, string3);
            try {
                JSONObject jSONObject = new JSONObject((String)object);
                return jSONObject;
            }
            catch (JSONException jSONException) {
                object = "JSONException when reading the 'Config' from InputStream.";
            }
            catch (IOException iOException) {
                object = "IOException when reading the 'Config' from InputStream.";
            }
            Log.e((String)string2, (String)object);
        }
        object = new JSONObject();
        return object;
    }

    public String a(String string2, String string3) {
        block11: {
            int n10;
            int n11;
            Object object;
            Object object2 = "/";
            boolean bl2 = string2.endsWith((String)object2);
            if (bl2) {
                return string3;
            }
            object2 = string2.split((String)object2);
            try {
                object = this.a;
                n10 = n11 = 1;
            }
            catch (JSONException jSONException) {
                object2 = new StringBuilder();
                object = "JSONException when reading 'path': ";
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(string2);
                string2 = ((StringBuilder)object2).toString();
                object2 = "InputStreamReader";
                Log.w((String)object2, (String)string2);
            }
            while (true) {
                block12: {
                    int n12 = ((String[])object2).length;
                    if (n10 >= n12) break block11;
                    n12 = ((Object)object2).length - n11;
                    if (n10 != n12) break block12;
                    object2 = object2[n10];
                    object2 = object.get((String)object2);
                    return object2.toString();
                }
                Object object3 = object2[n10];
                object = object.getJSONObject((String)object3);
                ++n10;
                continue;
                break;
            }
        }
        return string3;
    }
}

