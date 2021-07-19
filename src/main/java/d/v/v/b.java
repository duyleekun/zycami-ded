/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.v;

import android.content.Context;
import com.meicam.sdk.NvsStreamingContext;
import d.v.v.b$a;
import m.a.a;

public class b {
    private Context a;

    public static b b() {
        return b$a.a();
    }

    public Context a() {
        return this.a;
    }

    public void c(Context objectArray) {
        this.a = objectArray;
        NvsStreamingContext.init((Context)objectArray, "assets:/5819-231-8f3e08cc104e8e78cf2dd96967963c26.lic", 8193);
        objectArray = new Object[3];
        Integer n10 = NvsStreamingContext.getInstance().getSdkVersion().majorVersion;
        objectArray[0] = n10;
        n10 = NvsStreamingContext.getInstance().getSdkVersion().minorVersion;
        objectArray[1] = n10;
        n10 = NvsStreamingContext.getInstance().getSdkVersion().revisionNumber;
        objectArray[2] = n10;
        m.a.a.b("nvsSdkVersion = %s.%s.%s", objectArray);
    }
}

