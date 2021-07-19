/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.widget.TextView
 */
package d.v.f.e;

import android.graphics.Typeface;
import android.widget.TextView;
import d.v.e.l.h2;

public class b {
    public static void a(TextView textView, boolean bl2) {
        if (bl2) {
            Typeface typeface = Typeface.DEFAULT_BOLD;
            textView.setTypeface(typeface);
        } else {
            Typeface typeface = Typeface.DEFAULT;
            textView.setTypeface(typeface);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void b(TextView textView, boolean bl2, int n10) {
        void var2_4;
        float f10;
        textView = textView.getPaint();
        if (bl2) {
            int n11 = h2.b(2.0f);
            f10 = n11;
        } else {
            boolean bl3 = false;
            f10 = 0.0f;
        }
        textView.setShadowLayer(f10, 0.0f, 0.0f, (int)var2_4);
    }
}

