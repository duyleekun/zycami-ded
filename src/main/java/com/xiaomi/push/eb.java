/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class eb
extends ed {
    public eb(Context context, int n10) {
        super(context, n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private String b() {
        var1_1 = new StringBuilder();
        var3_3 = "android.intent.action.BATTERY_CHANGED";
        var2_2 = new IntentFilter((String)var3_3);
        var3_3 = this.a;
        var4_4 = null;
        var2_2 = var3_3.registerReceiver(null, var2_2);
        if (var2_2 == null) ** GOTO lbl-1000
        var2_2 = var2_2.getExtras();
        if (var2_2 == null) ** GOTO lbl-1000
        var3_3 = var2_2.keySet();
        var4_4 = new JSONObject();
        if (var3_3 == null) ** GOTO lbl-1000
        var5_5 = var3_3.size();
        if (var5_5 <= 0) ** GOTO lbl-1000
        try {
            var3_3 = var3_3.iterator();
        }
        catch (Exception v0) {
            ** continue;
        }
        while (true) lbl-1000:
        // 3 sources

        {
            block21: {
                var5_5 = (int)var3_3.hasNext();
                if (var5_5 == 0) break block21;
                var6_6 /* !! */  = var3_3.next();
                var6_6 /* !! */  = (String)var6_6 /* !! */ ;
                var7_7 = TextUtils.isEmpty(var6_6 /* !! */ );
                if (var7_7) continue;
                var8_8 = var2_2.get(var6_6 /* !! */ );
                var8_8 = String.valueOf(var8_8);
                var4_4.put(var6_6 /* !! */ , var8_8);
            }
            var1_1.append(var4_4);
            break;
        }
lbl-1000:
        // 6 sources

        {
            return var1_1.toString();
            catch (Exception v1) {}
            ** while (true)
        }
    }

    public int a() {
        return 20;
    }

    public ho a() {
        return ho.v;
    }

    public String a() {
        return this.b();
    }
}

