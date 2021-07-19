/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData$Item
 *  android.content.Context
 *  android.text.Spanned
 */
package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Spanned;

public final class TextViewOnReceiveContentListener$ApiImpl {
    private TextViewOnReceiveContentListener$ApiImpl() {
    }

    public static CharSequence coerce(Context object, ClipData.Item item, int n10) {
        object = item.coerceToText(object);
        int n11 = n10 & 1;
        if (n11 != 0 && (n11 = object instanceof Spanned) != 0) {
            object = ((CharSequence)object).toString();
        }
        return object;
    }
}

