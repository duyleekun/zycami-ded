/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.ArrayAdapter
 */
package androidx.appcompat.app;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AlertController$CheckedItemAdapter
extends ArrayAdapter {
    public AlertController$CheckedItemAdapter(Context context, int n10, int n11, CharSequence[] charSequenceArray) {
        super(context, n10, n11, (Object[])charSequenceArray);
    }

    public long getItemId(int n10) {
        return n10;
    }

    public boolean hasStableIds() {
        return true;
    }
}

