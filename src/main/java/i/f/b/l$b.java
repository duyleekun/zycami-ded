/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package i.f.b;

import android.util.Log;
import i.f.b.e;
import i.f.b.e$b;
import i.f.b.l;
import i.f.b.l$a;
import org.opencv.core.Mat;

public class l$b
implements Runnable {
    public final /* synthetic */ l a;

    private l$b(l l10) {
        this.a = l10;
    }

    public /* synthetic */ l$b(l l10, l$a l$a) {
        this(l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        Object object;
        boolean bl2;
        do {
            Object object2;
            int n11;
            object = this.a;
            // MONITORENTER : object
            try {
                while ((n11 = l.u((l)((Object)(object2 = this.a)))) == 0 && (n11 = l.w((l)((Object)(object2 = this.a)))) == 0) {
                    object2 = this.a;
                    object2.wait();
                }
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            object2 = this.a;
            n11 = l.u((l)((Object)object2));
            int n10 = 0;
            int n12 = 1;
            if (n11 != 0) {
                object2 = this.a;
                int n13 = l.x((l)((Object)object2));
                n13 = 1 - n13;
                l.y((l)((Object)object2), n13);
                object2 = this.a;
                l.v((l)((Object)object2), false);
                n10 = n12;
                // MONITOREXIT : object
            }
            object = this.a;
            bl2 = l.w((l)((Object)object));
            if (bl2 || n10 == 0) continue;
            object = l.z(this.a);
            object2 = this.a;
            n11 = l.x((l)((Object)object2));
            bl2 = ((Mat)(object = object[n11 = 1 - n11])).G();
            if (bl2) continue;
            object = this.a;
            object2 = ((l)object).E;
            n10 = l.x((l)((Object)object));
            object2 = object2[n12 -= n10];
            ((e)((Object)object)).f((e$b)object2);
        } while (!(bl2 = l.w((l)((Object)(object = this.a)))));
        Log.d((String)"JavaCameraView", (String)"Finish processing thread");
    }
}

