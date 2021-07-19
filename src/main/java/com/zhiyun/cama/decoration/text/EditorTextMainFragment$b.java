/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.TableLayout$LayoutParams
 */
package com.zhiyun.cama.decoration.text;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.zhiyun.cama.decoration.text.EditorTextMainFragment;

public class EditorTextMainFragment$b
extends FragmentPagerAdapter {
    public final /* synthetic */ EditorTextMainFragment a;

    public EditorTextMainFragment$b(EditorTextMainFragment editorTextMainFragment, FragmentManager fragmentManager, int n10) {
        this.a = editorTextMainFragment;
        super(fragmentManager, n10);
    }

    public View a(int n10) {
        Context context = this.a.requireContext();
        ImageView imageView = new ImageView(context);
        int n11 = -2;
        context = new TableLayout.LayoutParams(n11, n11);
        imageView.setLayoutParams((ViewGroup.LayoutParams)context);
        n10 = EditorTextMainFragment.E()[n10];
        imageView.setImageResource(n10);
        return imageView;
    }

    public int getCount() {
        return EditorTextMainFragment.D(this.a).length;
    }

    public Fragment getItem(int n10) {
        return EditorTextMainFragment.D(this.a)[n10];
    }
}

