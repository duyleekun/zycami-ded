/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 */
package i.f.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import i.f.b.a;
import i.f.b.a$c$a;
import i.f.b.a$c$b;
import i.f.b.j;
import i.f.b.m;
import i.f.d.a$a;
import org.opencv.core.Core;

public class a$c
implements ServiceConnection {
    public final /* synthetic */ a a;

    public a$c(a a10) {
        this.a = a10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceConnected(ComponentName object, IBinder object2) {
        object = "Calling using callback";
        String string2 = "Unbind from service";
        String string3 = "OpenCVManager/Helper";
        Log.d((String)string3, (String)"Service connection created");
        Object object3 = this.a;
        ((a)object3).a = object2 = a$a.o((IBinder)object2);
        object2 = this.a.a;
        if (object2 == null) {
            Log.d((String)string3, (String)"OpenCV Manager Service connection fails. May be service was not installed?");
            object = this.a;
            object2 = ((a)object).d;
            object = ((a)object).b;
            i.f.b.a.a((Context)object2, (m)object);
            return;
        }
        int n10 = 0;
        object3 = null;
        i.f.b.a.h = false;
        int n11 = 255;
        try {
            int n12 = object2.b();
            int n13 = 2;
            if (n12 < n13) {
                object2 = "Init finished with status 4";
                Log.d((String)string3, (String)object2);
                Log.d((String)string3, (String)string2);
                object2 = this.a;
                object3 = ((a)object2).d;
                object2 = ((a)object2).e;
                object3.unbindService((ServiceConnection)object2);
                Log.d((String)string3, (String)object);
                object2 = this.a;
                object2 = ((a)object2).b;
                n10 = 4;
                object2.b(n10);
                return;
            }
            object2 = "Trying to get library path";
            Log.d((String)string3, (String)object2);
            object2 = this.a;
            Object object4 = ((a)object2).a;
            object2 = ((a)object2).c;
            object2 = object4.g((String)object2);
            if (object2 != null && (n13 = ((String)object2).length()) != 0) {
                object4 = "Trying to get library list";
                Log.d((String)string3, (String)object4);
                i.f.b.a.i = false;
                object4 = this.a;
                Object object5 = ((a)object4).a;
                object4 = ((a)object4).c;
                object4 = object5.m((String)object4);
                object5 = new StringBuilder();
                Object object6 = "Library list: \"";
                ((StringBuilder)object5).append((String)object6);
                ((StringBuilder)object5).append((String)object4);
                object6 = "\"";
                ((StringBuilder)object5).append((String)object6);
                object5 = ((StringBuilder)object5).toString();
                Log.d((String)string3, (String)object5);
                object5 = "First attempt to load libs";
                Log.d((String)string3, (String)object5);
                object5 = this.a;
                n12 = (int)(i.f.b.a.c((a)object5, (String)object2, (String)object4) ? 1 : 0);
                if (n12 != 0) {
                    object2 = "First attempt to load libs is OK";
                    Log.d((String)string3, (String)object2);
                    object2 = "line.separator";
                    object2 = System.getProperty((String)object2);
                    object4 = Core.O0();
                    object2 = ((String)object4).split((String)object2);
                    n13 = ((Object)object2).length;
                    object5 = null;
                    for (int i10 = 0; i10 < n13; ++i10) {
                        object6 = object2[i10];
                        Log.i((String)string3, (String)object6);
                    }
                } else {
                    object2 = "First attempt to load libs fails";
                    Log.d((String)string3, (String)object2);
                    n10 = n11;
                }
                object2 = new StringBuilder();
                object4 = "Init finished with status ";
                ((StringBuilder)object2).append((String)object4);
                ((StringBuilder)object2).append(n10);
                object2 = ((StringBuilder)object2).toString();
                Log.d((String)string3, (String)object2);
                Log.d((String)string3, (String)string2);
                object2 = this.a;
                object4 = ((a)object2).d;
                object2 = ((a)object2).e;
                object4.unbindService((ServiceConnection)object2);
                Log.d((String)string3, (String)object);
                object2 = this.a;
                object2 = ((a)object2).b;
                object2.b(n10);
                return;
            }
            n12 = (int)(i.f.b.a.i ? 1 : 0);
            if (n12 == 0) {
                object2 = new a$c$a(this);
                object4 = this.a;
                object4 = ((a)object4).b;
                object4.a(0, (j)object2);
                return;
            }
            object2 = new a$c$b(this);
            object3 = this.a;
            object3 = ((a)object3).b;
            n13 = 1;
            object3.a(n13, (j)object2);
            return;
        }
        catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            Log.d((String)string3, (String)"Init finished with status 255");
            Log.d((String)string3, (String)string2);
            object2 = this.a;
            string2 = ((a)object2).d;
            object2 = ((a)object2).e;
            string2.unbindService((ServiceConnection)object2);
            Log.d((String)string3, (String)object);
            object = this.a.b;
            object.b(n11);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.a = null;
    }
}

