/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cursoradapter.widget.CursorAdapter;

public abstract class ResourceCursorAdapter
extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    public ResourceCursorAdapter(Context context, int n10, Cursor cursor) {
        super(context, cursor);
        this.mDropDownLayout = n10;
        this.mLayout = n10;
        context = (LayoutInflater)context.getSystemService("layout_inflater");
        this.mInflater = context;
    }

    public ResourceCursorAdapter(Context context, int n10, Cursor cursor, int n11) {
        super(context, cursor, n11);
        this.mDropDownLayout = n10;
        this.mLayout = n10;
        context = (LayoutInflater)context.getSystemService("layout_inflater");
        this.mInflater = context;
    }

    public ResourceCursorAdapter(Context context, int n10, Cursor cursor, boolean bl2) {
        super(context, cursor, bl2);
        this.mDropDownLayout = n10;
        this.mLayout = n10;
        context = (LayoutInflater)context.getSystemService("layout_inflater");
        this.mInflater = context;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        context = this.mInflater;
        int n10 = this.mDropDownLayout;
        return context.inflate(n10, viewGroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        context = this.mInflater;
        int n10 = this.mLayout;
        return context.inflate(n10, viewGroup, false);
    }

    public void setDropDownViewResource(int n10) {
        this.mDropDownLayout = n10;
    }

    public void setViewResource(int n10) {
        this.mLayout = n10;
    }
}

