/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.SoundPool
 *  android.media.SoundPool$OnLoadCompleteListener
 */
package d.v.c.s0;

import android.media.SoundPool;
import d.v.c.s0.r6;
import d.v.c.s0.r6$b;
import m.a.a;

public class r6$a
implements SoundPool.OnLoadCompleteListener {
    public final /* synthetic */ r6 a;

    public r6$a(r6 r62) {
        this.a = r62;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onLoadComplete(SoundPool object, int n10, int n11) {
        r6$b r6$b;
        int n12;
        block10: {
            r6$b[] r6$bArray = r6.a(this.a);
            int n13 = r6$bArray.length;
            n12 = 0;
            int n14 = 0;
            while (n14 < n13) {
                r6$b = r6$bArray[n14];
                int n15 = r6$b.b;
                if (n15 != n10) {
                    ++n14;
                    continue;
                }
                break block10;
            }
            return;
        }
        synchronized (r6$b) {
            if (n11 != 0) {
                r6$b.c = 0;
                r6$b.b = 0;
                object = new StringBuilder();
                Object[] objectArray = "OnLoadCompleteListener() error: ";
                ((StringBuilder)object).append((String)objectArray);
                ((StringBuilder)object).append(n11);
                objectArray = " loading sound: ";
                ((StringBuilder)object).append((String)objectArray);
                n10 = r6$b.a;
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                objectArray = new Object[]{};
                m.a.a.e((String)object, objectArray);
                return;
            }
            n10 = r6$b.c;
            n11 = 3;
            int n16 = 1;
            if (n10 != n16) {
                n16 = 2;
                if (n10 != n16) {
                    CharSequence charSequence = new StringBuilder();
                    Object[] objectArray = "OnLoadCompleteListener() called in wrong state: ";
                    charSequence.append((String)objectArray);
                    n11 = r6$b.c;
                    charSequence.append(n11);
                    objectArray = " for sound: ";
                    charSequence.append((String)objectArray);
                    n11 = r6$b.a;
                    charSequence.append(n11);
                    charSequence = charSequence.toString();
                    objectArray = new Object[]{};
                    m.a.a.e((String)charSequence, objectArray);
                } else {
                    n12 = r6$b.b;
                    r6$b.c = n11;
                }
            } else {
                r6$b.c = n11;
            }
        }
        if (n12 == 0) return;
        float f10 = 1.0f;
        float f11 = 1.0f;
        float f12 = 1.0f;
        object.play(n12, f10, f11, 0, 0, f12);
    }
}

