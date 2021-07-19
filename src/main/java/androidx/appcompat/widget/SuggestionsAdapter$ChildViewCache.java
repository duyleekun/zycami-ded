/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$id;

public final class SuggestionsAdapter$ChildViewCache {
    public final ImageView mIcon1;
    public final ImageView mIcon2;
    public final ImageView mIconRefine;
    public final TextView mText1;
    public final TextView mText2;

    public SuggestionsAdapter$ChildViewCache(View view) {
        TextView textView;
        this.mText1 = textView = (TextView)view.findViewById(16908308);
        this.mText2 = textView = (TextView)view.findViewById(16908309);
        textView = (ImageView)view.findViewById(16908295);
        this.mIcon1 = textView;
        textView = (ImageView)view.findViewById(16908296);
        this.mIcon2 = textView;
        int n10 = R$id.edit_query;
        view = (ImageView)view.findViewById(n10);
        this.mIconRefine = view;
    }
}

