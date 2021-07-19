/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.RemoteException
 *  android.util.Log
 */
package i.f.b;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import i.f.b.a;
import i.f.b.a$c;
import i.f.b.j;

public class a$c$b
implements j {
    public final /* synthetic */ a$c c;

    public a$c$b(a$c a$c) {
        this.c = a$c;
    }

    public void a() {
        Log.e((String)"OpenCVManager/Helper", (String)"Nothing to install we just wait current installation");
    }

    public void b() {
        i.f.d.a a10;
        Object object;
        String string2;
        Object object2;
        Object object3;
        block19: {
            block18: {
                object3 = "Calling using callback";
                object2 = "Unbind from service";
                string2 = "OpenCVManager/Helper";
                object = "Waiting for current installation";
                Log.d((String)string2, (String)object);
                object = this.c;
                object = ((a$c)object).a;
                a10 = ((a)object).a;
                object = ((a)object).c;
                boolean bl2 = a10.d((String)object);
                if (bl2) break block18;
                object = "OpenCV package was not installed!";
                Log.d((String)string2, (String)object);
                object = "Init finished with status 2";
                Log.d((String)string2, (String)object);
                Log.d((String)string2, (String)object3);
                object = this.c;
                object = ((a$c)object).a;
                object = ((a)object).b;
                int n10 = 2;
                object.b(n10);
                break block19;
            }
            object = "Waiting for package installation";
            Log.d((String)string2, (String)object);
        }
        Log.d((String)string2, (String)object2);
        object = this.c;
        object = ((a$c)object).a;
        a10 = ((a)object).d;
        object = ((a)object).e;
        try {
            a10.unbindService((ServiceConnection)object);
        }
        catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            Log.d((String)string2, (String)"Init finished with status 255");
            Log.d((String)string2, (String)object2);
            object2 = this.c.a;
            object = ((a)object2).d;
            object2 = ((a)object2).e;
            object.unbindService((ServiceConnection)object2);
            Log.d((String)string2, (String)object3);
            object3 = this.c.a.b;
            int n11 = 255;
            object3.b(n11);
        }
    }

    public void cancel() {
        String string2 = "OpenCVManager/Helper";
        Log.d((String)string2, (String)"OpenCV library installation was canceled");
        a.i = false;
        Log.d((String)string2, (String)"Init finished with status 3");
        Log.d((String)string2, (String)"Unbind from service");
        a a10 = this.c.a;
        Context context = a10.d;
        a10 = a10.e;
        context.unbindService((ServiceConnection)a10);
        Log.d((String)string2, (String)"Calling using callback");
        this.c.a.b.b(3);
    }

    public String getPackageName() {
        return "OpenCV library";
    }
}

