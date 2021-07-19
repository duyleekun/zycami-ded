/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater$Factory2
 *  android.view.View
 */
package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.view.LayoutInflaterFactory;

public class LayoutInflaterCompat$Factory2Wrapper
implements LayoutInflater.Factory2 {
    public final LayoutInflaterFactory mDelegateFactory;

    public LayoutInflaterCompat$Factory2Wrapper(LayoutInflaterFactory layoutInflaterFactory) {
        this.mDelegateFactory = layoutInflaterFactory;
    }

    public View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.mDelegateFactory.onCreateView(view, string2, context, attributeSet);
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        return this.mDelegateFactory.onCreateView(null, string2, context, attributeSet);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getClass().getName();
        stringBuilder.append((String)object);
        stringBuilder.append("{");
        object = this.mDelegateFactory;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

