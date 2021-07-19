/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.TextView
 */
package d.v.e.l;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import d.v.e.l.o1;

public class n1 {
    public static void a(TextView textView, int n10) {
        Drawable drawable2 = o1.q((View)textView, n10);
        n1.b(textView, drawable2);
    }

    public static void b(TextView textView, Drawable drawable2) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, drawable2);
    }

    public static void c(TextView textView, int n10) {
        Drawable drawable2 = o1.q((View)textView, n10);
        n1.d(textView, drawable2);
    }

    public static void d(TextView textView, Drawable drawable2) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, null, null, null);
    }

    public static void e(TextView textView, int n10) {
        Drawable drawable2 = o1.q((View)textView, n10);
        n1.f(textView, drawable2);
    }

    public static void f(TextView textView, Drawable drawable2) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable2, null);
    }

    public static void g(TextView textView, int n10) {
        Drawable drawable2 = o1.q((View)textView, n10);
        n1.h(textView, drawable2);
    }

    public static void h(TextView textView, Drawable drawable2) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawable2, null, null);
    }
}

