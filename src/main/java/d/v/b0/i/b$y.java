/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package d.v.b0.i;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import d.v.b0.i.b;
import d.v.b0.i.b$y$a;
import d.v.b0.i.b$y$b;

public class b$y
extends Handler {
    public final /* synthetic */ b a;

    public b$y(b b10, Looper looper) {
        this.a = b10;
        super(looper);
    }

    public void handleMessage(Message object) {
        Object object2;
        super.handleMessage(object);
        int n10 = object.what;
        if (n10 != 0) {
            int n11 = 3;
            if (n10 == n11) {
                Object object3;
                object2 = b.a0(this.a);
                n10 = b.m0((Context)object2, (String)(object3 = "graphics/fxaa.bundle"));
                if (n10 <= 0) {
                    object = b.x0();
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("create Animoji3D item failed: ");
                    ((StringBuilder)object3).append(n10);
                    object2 = ((StringBuilder)object3).toString();
                    Log.w((String)object, (String)object2);
                    return;
                }
                object3 = this.a;
                b$y$b b$y$b = new b$y$b(this, n10);
                ((b)object3).F1(b$y$b);
            }
        } else {
            Object object4;
            object2 = b.a0(this.a);
            n10 = b.m0((Context)object2, (String)(object4 = "graphics/face_beautification.bundle"));
            if (n10 <= 0) {
                object = b.x0();
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("create face beauty item failed: ");
                ((StringBuilder)object4).append(n10);
                object2 = ((StringBuilder)object4).toString();
                Log.w((String)object, (String)object2);
                return;
            }
            object4 = this.a;
            b$y$a b$y$a = new b$y$a(this, n10);
            ((b)object4).F1(b$y$a);
        }
        if ((object2 = b.M0(this.a)) != null) {
            object2 = b.M0(this.a);
            int n12 = object.what;
            object2.a(n12);
        }
    }
}

