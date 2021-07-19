/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  android.widget.TextView
 */
package l.a.q.g0;

import android.content.res.TypedArray;
import android.widget.TextView;
import l.a.q.g0.p;
import l.a.q.j;
import skin.support.appcompat.R$styleable;

public class t {
    public final TextView a;
    private int b = 0;
    private int c = 0;

    public t(TextView textView) {
        this.a = textView;
    }

    private void a() {
        int n10;
        this.c = n10 = j.b(this.c);
        if (n10 != 0) {
            Object object = this.a.getContext().getResources();
            int n11 = this.c;
            object = p.h(object, n11);
            TextView textView = this.a;
            textView.setHint((CharSequence)object);
        }
    }

    private void c() {
        int n10;
        this.b = n10 = j.b(this.b);
        if (n10 != 0) {
            Object object = this.a.getContext().getResources();
            int n11 = this.b;
            object = p.h(object, n11);
            TextView textView = this.a;
            textView.setText((CharSequence)object);
        }
    }

    public void b() {
        this.c();
        this.a();
    }

    public void d(TypedArray typedArray) {
        int n10 = R$styleable.SkinCompatTextHelper_android_text;
        boolean bl2 = typedArray.hasValue(n10);
        if (bl2) {
            this.b = n10 = typedArray.getResourceId(n10, 0);
        }
        if (bl2 = typedArray.hasValue(n10 = R$styleable.SkinTextAppearance_android_text)) {
            this.b = n10 = typedArray.getResourceId(n10, 0);
        }
        if (bl2 = typedArray.hasValue(n10 = R$styleable.SkinCompatTextHelper_android_hint)) {
            this.c = n10 = typedArray.getResourceId(n10, 0);
        }
        if (bl2 = typedArray.hasValue(n10 = R$styleable.SkinTextAppearance_android_hint)) {
            int n11;
            this.c = n11 = typedArray.getResourceId(n10, 0);
        }
    }
}

