/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.HorizontalScrollView
 */
package com.zhiyun.cama.decoration.sticker;

import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment;
import d.v.c.x0.b.a;
import d.v.e.i.h;

public class EditorStickerFragment$a
extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ EditorStickerFragment a;

    public EditorStickerFragment$a(EditorStickerFragment editorStickerFragment) {
        this.a = editorStickerFragment;
    }

    private /* synthetic */ void a(View view) {
        float f10;
        float f11;
        HorizontalScrollView horizontalScrollView;
        HorizontalScrollView horizontalScrollView2 = EditorStickerFragment.y((EditorStickerFragment)this.a).b;
        int n10 = horizontalScrollView2.getWidth();
        float f12 = view.getX();
        float f13 = view.getWidth();
        HorizontalScrollView horizontalScrollView3 = EditorStickerFragment.y((EditorStickerFragment)this.a).b;
        int n11 = horizontalScrollView3.getScrollX() + n10;
        float f14 = (f12 += f13) - (f13 = (float)n11);
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object > 0) {
            horizontalScrollView = EditorStickerFragment.y((EditorStickerFragment)this.a).b;
            f13 = view.getX();
            int n12 = view.getWidth();
            float f15 = n12;
            f11 = n10;
            n10 = (int)((f13 += f15) - f11) + 100;
            horizontalScrollView3 = EditorStickerFragment.y((EditorStickerFragment)this.a).b;
            f13 = horizontalScrollView3.getY();
            n11 = (int)f13;
            horizontalScrollView.scrollTo(n10, n11);
        }
        if ((n10 = (int)((f10 = (f11 = view.getX()) - (f12 = (float)(object = (Object)(horizontalScrollView = EditorStickerFragment.y((EditorStickerFragment)this.a).b).getScrollX()))) == 0.0f ? 0 : (f10 < 0.0f ? -1 : 1))) < 0) {
            horizontalScrollView2 = EditorStickerFragment.y((EditorStickerFragment)this.a).b;
            f12 = view.getX();
            object = (int)f12 + -100;
            float f16 = view.getY();
            int n13 = (int)f16;
            horizontalScrollView2.scrollTo((int)object, n13);
        }
    }

    public /* synthetic */ void b(View view) {
        this.a(view);
    }

    public void onPageSelected(int n10) {
        Object object = EditorStickerFragment.x(this.a).c();
        Integer n11 = n10;
        h.g((MutableLiveData)object, n11);
        object = EditorStickerFragment.y((EditorStickerFragment)this.a).c;
        View view = object.getChildAt(n10);
        if (view != null) {
            object = new a(this, view);
            long l10 = 20;
            view.postDelayed((Runnable)object, l10);
        }
    }
}

