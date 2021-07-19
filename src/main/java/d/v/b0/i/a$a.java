/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package d.v.b0.i;

import android.content.Context;
import android.util.Log;
import com.faceunity.wrapper.faceunity;
import d.v.b0.i.a;
import d.v.b0.i.d;
import java.io.IOException;

public class a$a
implements Runnable {
    public final /* synthetic */ a a;

    public a$a(a a10) {
        this.a = a10;
    }

    public void run() {
        Object var2_2 = null;
        Object object = new byte[]{};
        Object object2 = d.a();
        int n10 = faceunity.fuSetup(object, (byte[])object2);
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        Object object3 = "fuSetup. isSetup: ";
        ((StringBuilder)object2).append((String)object3);
        object3 = n10 == 0 ? "no" : "yes";
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append("   isSetup:");
        ((StringBuilder)object2).append(n10);
        object = ((StringBuilder)object2).toString();
        object2 = "ZL";
        Log.d((String)object2, (String)object);
        long l10 = System.currentTimeMillis();
        object = this.a;
        Object object4 = d.v.b0.i.a.a((a)object);
        int n11 = 1024;
        Object object5 = "AI_model/ai_face_processor.bundle";
        n10 = d.v.b0.i.a.b((a)object, (Context)object4, (String)object5, n11);
        object4 = new StringBuilder();
        Object object6 = "face check result:";
        ((StringBuilder)object4).append((String)object6);
        ((StringBuilder)object4).append(n10);
        ((StringBuilder)object4).append("  load face model costum: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object4).append(l11);
        object = " ms";
        ((StringBuilder)object4).append((String)object);
        object3 = ((StringBuilder)object4).toString();
        Log.d((String)object2, (String)object3);
        int n12 = 4;
        faceunity.fuSetMaxFaces(n12);
        long l12 = System.currentTimeMillis();
        object6 = this.a;
        object5 = d.v.b0.i.a.a((a)object6);
        String string2 = "face_beautification.bundle";
        object6 = d.v.b0.i.a.h((a)object6, (Context)object5, string2);
        object5 = this.a;
        n11 = d.v.b0.i.a.k((a)object5, (byte[])object6);
        d.v.b0.i.a.j((a)object5, n11);
        object6 = new StringBuilder();
        object5 = "face beautiful handle: ";
        ((StringBuilder)object6).append((String)object5);
        object5 = this.a;
        int n13 = d.v.b0.i.a.i((a)object5);
        ((StringBuilder)object6).append(n13);
        object5 = " create face beautiful handle costum: ";
        ((StringBuilder)object6).append((String)object5);
        long l13 = System.currentTimeMillis() - l12;
        ((StringBuilder)object6).append(l13);
        ((StringBuilder)object6).append((String)object);
        object = ((StringBuilder)object6).toString();
        Log.d((String)object2, (String)object);
        object = this.a;
        object = d.v.b0.i.a.l((a)object);
        object2 = this.a;
        int n14 = d.v.b0.i.a.i((a)object2);
        object[0] = n14;
        object = this.a;
        n10 = d.v.b0.i.a.i((a)object);
        object2 = "is_beauty_on";
        l12 = 0x3FF0000000000000L;
        double d10 = 1.0;
        faceunity.fuItemSetParam(n10, (String)object2, d10);
        object = "cheek_thinning";
        object2 = "blur_level";
        object6 = "color_level";
        object5 = "eye_enlarging";
        string2 = "red_level";
        object = new String[]{object, object2, object6, object5, string2};
        n14 = 5;
        object6 = new double[n14];
        l13 = 4602678819172646912L;
        Object object7 = 0.5;
        object6[0] = object7;
        double d11 = 3.0;
        int n15 = 1;
        object6[n15] = d11;
        int n16 = 2;
        object6[n16] = d10;
        int n17 = 3;
        object6[n17] = object7;
        object6[n12] = object7;
        for (int i10 = 0; i10 < n14; ++i10) {
            object3 = this.a;
            n12 = d.v.b0.i.a.i((a)object3);
            byte by2 = object[i10];
            object7 = object6[i10];
            try {
                faceunity.fuItemSetParam(n12, (String)by2, object7);
                continue;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                break;
            }
        }
    }
}

