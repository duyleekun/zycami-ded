/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaRecorder$OnInfoListener
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g;

import android.media.MediaRecorder;
import android.util.Size;
import android.view.Surface;

public class b {
    public Size a;
    public Surface b;
    public int c;
    public int d;
    public double e;
    public int f;
    public boolean g;
    public String h;
    public MediaRecorder.OnInfoListener i;
    public int j;
    public int k;

    public b(Size size, Surface surface, int n10, int n11, double d10, int n12, boolean bl2, String string2, int n13) {
        this.a = size;
        this.b = surface;
        this.c = n10;
        this.d = n11;
        this.e = d10;
        this.f = n12;
        this.g = bl2;
        this.h = string2;
        this.k = n13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoProfile{videoSize=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", surface=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(", orientation=");
        int n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append(", fps=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append(", captureRate=");
        double d10 = this.e;
        stringBuilder.append(d10);
        stringBuilder.append(", bitRate=");
        n10 = this.f;
        stringBuilder.append(n10);
        stringBuilder.append(", mute=");
        n10 = (int)(this.g ? 1 : 0);
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", path='");
        object = this.h;
        stringBuilder.append((String)object);
        stringBuilder.append(", micType='");
        n10 = this.k;
        stringBuilder.append(n10);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

