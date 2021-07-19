/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package d.v.q;

import android.content.Context;
import android.os.Build;
import com.zhiyun.common.util.Devices;
import d.v.e.l.d1;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static String a;
    private static final Map b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Serializable serializable = new StringBuilder();
        String string2 = "versionOS[";
        try {
            ((StringBuilder)serializable).append(string2);
            string2 = Build.VERSION.RELEASE;
            ((StringBuilder)serializable).append(string2);
            string2 = "]";
            ((StringBuilder)serializable).append(string2);
        }
        catch (Throwable throwable) {}
        a = ((StringBuilder)serializable).toString();
        serializable = new HashMap(10);
        b = serializable;
    }

    public static String a() {
        return a;
    }

    public static Map b(Context object) {
        Map map = b;
        boolean bl2 = map.isEmpty();
        if (bl2) {
            CharSequence charSequence = d1.a();
            map.put("appId", charSequence);
            charSequence = Build.BRAND;
            String string2 = "unionId";
            map.put(string2, charSequence);
            charSequence = new StringBuilder();
            object = Devices.n(object);
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append("(");
            object = Build.MODEL;
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(")");
            object = ((StringBuilder)charSequence).toString();
            map.put("deviceId", object);
            map.put("buildVersion", "");
            object = d1.g();
            map.put("appVersion", object);
            object = "platform";
            charSequence = "1";
            map.put(object, charSequence);
        }
        return map;
    }

    public static String c() {
        double d10 = Runtime.getRuntime().maxMemory();
        double d11 = 1.0;
        double d12 = 1048576.0;
        float f10 = (float)((d10 *= d11) / d12);
        float f11 = (float)((double)Runtime.getRuntime().totalMemory() * d11 / d12);
        float f12 = (float)((double)Runtime.getRuntime().freeMemory() * d11 / d12);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("maxMemory:[");
        stringBuilder.append(f10);
        stringBuilder.append("] totalMemory:[");
        stringBuilder.append(f11);
        stringBuilder.append("] freeMemory:[");
        stringBuilder.append(f12);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

