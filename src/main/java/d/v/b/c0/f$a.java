/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.SoundPool
 *  android.media.SoundPool$OnLoadCompleteListener
 */
package d.v.b.c0;

import android.media.SoundPool;
import d.v.b.c0.f;
import d.v.b.c0.f$b;

public class f$a
implements SoundPool.OnLoadCompleteListener {
    public final /* synthetic */ f a;

    public f$a(f f10) {
        this.a = f10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onLoadComplete(SoundPool soundPool, int n10, int n11) {
        f$b f$b;
        int n12;
        block9: {
            f$b[] f$bArray = f.a(this.a);
            int n13 = f$bArray.length;
            n12 = 0;
            int n14 = 0;
            while (n14 < n13) {
                f$b = f$bArray[n14];
                int n15 = f$b.b;
                if (n15 != n10) {
                    ++n14;
                    continue;
                }
                break block9;
            }
            return;
        }
        synchronized (f$b) {
            if (n11 != 0) {
                f$b.c = 0;
                f$b.b = 0;
                return;
            }
            n10 = f$b.c;
            n11 = 3;
            int n16 = 1;
            if (n10 != n16) {
                n16 = 2;
                if (n10 == n16) {
                    n12 = f$b.b;
                    f$b.c = n11;
                }
            } else {
                f$b.c = n11;
            }
        }
        if (n12 == 0) return;
        float f10 = 1.0f;
        float f11 = 1.0f;
        float f12 = 1.0f;
        soundPool.play(n12, f10, f11, 0, 0, f12);
    }
}

