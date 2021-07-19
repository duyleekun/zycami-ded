/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater$Factory2
 *  android.view.View
 */
package l.a.p;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import l.a.p.b;

public class a$a
implements LayoutInflater.Factory2 {
    public final b a;

    public a$a(b b10) {
        this.a = b10;
    }

    public View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.a.onCreateView(view, string2, context, attributeSet);
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        return this.a.onCreateView(null, string2, context, attributeSet);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getClass().getName();
        stringBuilder.append((String)object);
        stringBuilder.append("{");
        object = this.a;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

