/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 *  android.media.SoundPool
 *  android.media.SoundPool$Builder
 *  android.media.SoundPool$OnLoadCompleteListener
 */
package d.v.c.s0;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import d.v.c.s0.r6$a;
import d.v.c.s0.r6$b;
import m.a.a;

public class r6 {
    private static final int d = 1;
    private static volatile r6 e;
    private static final int[] f;
    public static final int g = 0;
    public static final int h = 1;
    private static final int i = 0;
    private static final int j = 1;
    private static final int k = 2;
    private static final int l = 3;
    private SoundPool a;
    private r6$b[] b;
    private SoundPool.OnLoadCompleteListener c;

    static {
        int[] nArray = new int[]{2131886081, 2131886082};
        f = nArray;
    }

    private r6() {
        r6$a r6$a = new r6$a(this);
        this.c = r6$a;
    }

    public static /* synthetic */ r6$b[] a(r6 r62) {
        return r62.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static r6 b() {
        Object object = e;
        if (object != null) return e;
        object = r6.class;
        synchronized (object) {
            r6 r62 = e;
            if (r62 != null) return e;
            e = r62 = new r6();
            return e;
        }
    }

    private void c() {
        r6$b[] r6$bArray = this.a;
        if (r6$bArray == null) {
            r6$bArray = new SoundPool.Builder();
            int n10 = 1;
            r6$bArray = r6$bArray.setMaxStreams(n10);
            Object object = new AudioAttributes.Builder();
            int n11 = 13;
            object = object.setUsage(n11);
            r6$b[] r6$bArray2 = object.setFlags(n10);
            int n12 = 4;
            r6$bArray2 = r6$bArray2.setContentType(n12).build();
            r6$bArray = r6$bArray.setAudioAttributes((AudioAttributes)r6$bArray2).build();
            this.a = r6$bArray;
            r6$bArray2 = this.c;
            r6$bArray.setOnLoadCompleteListener((SoundPool.OnLoadCompleteListener)r6$bArray2);
            r6$bArray = new r6$b[f.length];
            this.b = r6$bArray;
            r6$bArray = null;
            for (int i10 = 0; i10 < (n12 = (r6$bArray2 = this.b).length); ++i10) {
                object = new r6$b(this, i10);
                r6$bArray2[i10] = object;
            }
        }
    }

    private int e(Context context, r6$b r6$b) {
        SoundPool soundPool = this.a;
        int[] nArray = f;
        int n10 = r6$b.a;
        int n11 = nArray[n10];
        int n12 = 1;
        int n13 = soundPool.load(context, n11, n12);
        if (n13 > 0) {
            r6$b.c = n12;
            r6$b.b = n13;
            return n13;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(Context context) {
        this.c();
        int n10 = 0;
        Object object;
        int n11;
        while (n10 < (n11 = ((int[])(object = f)).length)) {
            int n12 = object[n10];
            r6$b r6$b = this.b[n10];
            synchronized (r6$b) {
                Object[] objectArray;
                CharSequence charSequence;
                int n13 = r6$b.c;
                if (n13 == 0) {
                    n13 = this.e(context, r6$b);
                    if (n13 <= 0) {
                        charSequence = "load() error loading sound: %s";
                        int n14 = 1;
                        objectArray = new Object[n14];
                        object = n12;
                        objectArray[0] = object;
                        m.a.a.e((String)charSequence, objectArray);
                    }
                } else {
                    charSequence = new StringBuilder();
                    objectArray = "load() called in wrong state: ";
                    ((StringBuilder)charSequence).append((String)objectArray);
                    ((StringBuilder)charSequence).append(r6$b);
                    objectArray = " for sound: ";
                    ((StringBuilder)charSequence).append((String)objectArray);
                    ((StringBuilder)charSequence).append(n12);
                    object = ((StringBuilder)charSequence).toString();
                    charSequence = new Object[]{};
                    m.a.a.e((String)object, (Object[])charSequence);
                }
            }
            ++n10;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(int n10) {
        Object object;
        block5: {
            int n11;
            if (n10 < 0 || n10 >= (n11 = ((int[])(object = f)).length)) break block5;
            object = this.b[n10];
            synchronized (object) {
                block4: {
                    block7: {
                        block6: {
                            int n12 = object.c;
                            int n13 = 0;
                            if (n12 == 0) break block6;
                            int n14 = 1;
                            float f10 = Float.MIN_VALUE;
                            if (n12 == n14) break block7;
                            n14 = 3;
                            f10 = 4.2E-45f;
                            if (n12 != n14) {
                                Object[] objectArray = new StringBuilder();
                                String string2 = "play() called in wrong state: ";
                                objectArray.append(string2);
                                n14 = object.c;
                                objectArray.append(n14);
                                string2 = " for sound: ";
                                objectArray.append(string2);
                                objectArray.append(n10);
                                String string3 = objectArray.toString();
                                objectArray = new Object[]{};
                                m.a.a.e(string3, objectArray);
                                break block4;
                            } else {
                                SoundPool soundPool = this.a;
                                n13 = object.b;
                                n14 = 1045220557;
                                f10 = 0.2f;
                                float f11 = 0.2f;
                                float f12 = 1.0f;
                                soundPool.play(n13, f10, f11, 0, 0, f12);
                            }
                            break block4;
                        }
                        Object[] objectArray = new StringBuilder();
                        String string4 = "play() error loading sound: ";
                        objectArray.append(string4);
                        objectArray.append(n10);
                        String string5 = objectArray.toString();
                        objectArray = new Object[]{};
                        m.a.a.e(string5, objectArray);
                    }
                    object.c = n10 = 2;
                }
                return;
            }
        }
        object = new RuntimeException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown sound requested: ");
        stringBuilder.append(n10);
        String string6 = stringBuilder.toString();
        object(string6);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g() {
        r6$b[] r6$bArray = this.a;
        if (r6$bArray != null) {
            for (r6$b r6$b : this.b) {
                synchronized (r6$b) {
                    r6$b.c = 0;
                    r6$b.b = 0;
                }
            }
            this.a.release();
            r6$bArray = null;
            this.a = null;
        }
    }
}

