/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$styleable;

public class TabItem
extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context object, AttributeSet object2) {
        super((Context)object, object2);
        int[] nArray = R$styleable.TabItem;
        object = TintTypedArray.obtainStyledAttributes((Context)object, object2, nArray);
        int n10 = R$styleable.TabItem_android_text;
        object2 = ((TintTypedArray)object).getText(n10);
        this.text = object2;
        n10 = R$styleable.TabItem_android_icon;
        object2 = ((TintTypedArray)object).getDrawable(n10);
        this.icon = object2;
        n10 = R$styleable.TabItem_android_layout;
        this.customLayout = n10 = ((TintTypedArray)object).getResourceId(n10, 0);
        ((TintTypedArray)object).recycle();
    }
}

