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

public final class a$a
implements j {
    private m c;
    public final /* synthetic */ m d;
    public final /* synthetic */ Context e;

    public a$a(m m10, Context context) {
        this.d = m10;
        this.e = context;
        this.c = m10;
    }

    public void a() {
        Object object = "OpenCVManager/Helper";
        Log.d((String)object, (String)"Trying to install OpenCV Manager via Google Play");
        Object object2 = this.e;
        int n10 = a.b(object2);
        if (n10 != 0) {
            a.h = n10 = 1;
            object2 = "Package installation started";
            Log.d((String)object, (String)object2);
        } else {
            object2 = "OpenCV package was not installed!";
            Log.d((String)object, (String)object2);
            n10 = 2;
            CharSequence charSequence = new StringBuilder();
            String string2 = "Init finished with status ";
            charSequence.append(string2);
            charSequence.append(n10);
            charSequence = charSequence.toString();
            Log.d((String)object, (String)charSequence);
            Log.d((String)object, (String)"Unbind from service");
            charSequence = "Calling using callback";
            Log.d((String)object, (String)charSequence);
            object = this.c;
            object.b(n10);
        }
    }

    public void b() {
        Log.e((String)"OpenCVManager/Helper", (String)"Installation was not started! Nothing to wait!");
    }

    public void cancel() {
        String string2 = "OpenCVManager/Helper";
        Log.d((String)string2, (String)"OpenCV library installation was canceled");
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

