/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package i.f.b;

import android.content.Context;
import android.util.Log;
import i.f.b.a;
import i.f.b.j;
import i.f.b.m;

public final class a$b
implements j {
    private m c;
    public final /* synthetic */ m d;
    public final /* synthetic */ Context e;

    public a$b(m m10, Context context) {
        this.d = m10;
        this.e = context;
        this.c = m10;
    }

    public void a() {
        Log.e((String)"OpenCVManager/Helper", (String)"Nothing to install we just wait current installation");
    }

    public void b() {
        a.b(this.e);
    }

    public void cancel() {
        String string2 = "OpenCVManager/Helper";
        Log.d((String)string2, (String)"Waiting for OpenCV canceled by user");
        a.h = false;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Init finished with status ");
        int n10 = 3;
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Log.d((String)string2, (String)charSequence);
        Log.d((String)string2, (String)"Calling using callback");
        this.c.b(n10);
    }

    public String getPackageName() {
        return "OpenCV Manager";
    }
}

