/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 *  android.widget.HorizontalScrollView
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.zhiyun.cama.widget.EditorHorizontalScrollView$b;
import com.zhiyun.common.util.Windows;
import java.util.ArrayList;
import java.util.Iterator;

public class EditorHorizontalScrollView
extends HorizontalScrollView
implements ScaleGestureDetector.OnScaleGestureListener {
    private ArrayList a;
    private View.OnScrollChangeListener b;
    public float c;
    public View.OnScrollChangeListener d;
    private ScaleGestureDetector e;
    private EditorHorizontalScrollView$b f;
    private boolean g;
    private boolean h;
    private long i;

    public EditorHorizontalScrollView(Context object) {
        super(object);
        super();
        this.a = object;
        super(this);
        this.b = object;
        super(this);
        this.d = object;
        this.b();
    }

    public EditorHorizontalScrollView(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        super();
        this.a = object;
        super(this);
        this.b = object;
        super(this);
        this.d = object;
        this.b();
    }

    public EditorHorizontalScrollView(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        super();
        this.a = object;
        super(this);
        this.b = object;
        super(this);
        this.d = object;
        this.b();
    }

    public EditorHorizontalScrollView(Context object, AttributeSet attributeSet, int n10, int n11) {
        super(object, attributeSet, n10, n11);
        super();
        this.a = object;
        super(this);
        this.b = object;
        super(this);
        this.d = object;
        this.b();
    }

    private void b() {
        ScaleGestureDetector scaleGestureDetector;
        float f10;
        this.c = f10 = (float)Windows.l(this.getContext()).getWidth();
        Context context = this.getContext();
        this.e = scaleGestureDetector = new ScaleGestureDetector(context, (ScaleGestureDetector.OnScaleGestureListener)this);
    }

    private /* synthetic */ void d(View view, int n10, int n11, int n12, int n13) {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10;
            Object object = e10 = iterator2.next();
            object = (View.OnScrollChangeListener)e10;
            object.onScrollChange(view, n10, n11, n12, n13);
        }
    }

    public void a(View.OnScrollChangeListener onScrollChangeListener) {
        if (onScrollChangeListener != null) {
            ArrayList arrayList = this.a;
            arrayList.add(onScrollChangeListener);
        }
        onScrollChangeListener = this.b;
        super.setOnScrollChangeListener(onScrollChangeListener);
    }

    public boolean c() {
        return this.g;
    }

    public /* synthetic */ void e(View view, int n10, int n11, int n12, int n13) {
        this.d(view, n10, n11, n12, n13);
    }

    public void f() {
        this.a.clear();
        super.setOnScrollChangeListener(null);
    }

    public void g(View.OnScrollChangeListener onScrollChangeListener) {
        if (onScrollChangeListener != null) {
            ArrayList arrayList = this.a;
            arrayList.remove(onScrollChangeListener);
        }
    }

    public long getPosition() {
        return this.i;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View.OnScrollChangeListener onScrollChangeListener = this.d;
        this.g(onScrollChangeListener);
        onScrollChangeListener = this.d;
        this.a(onScrollChangeListener);
    }

    public void onDetachedFromWindow() {
        View.OnScrollChangeListener onScrollChangeListener = this.d;
        this.g(onScrollChangeListener);
        super.onDetachedFromWindow();
    }

    public boolean onScale(ScaleGestureDetector object) {
        float f10;
        float f11 = object.getCurrentSpanX();
        float f12 = object.getPreviousSpanX();
        float f13 = (f12 = Math.abs(f11 -= f12)) - (f10 = 5.0f);
        Object object2 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object2 < 0) {
            return false;
        }
        object = this.f;
        if (object != null) {
            f10 = 0.1f;
            float f14 = f11 - 0.0f;
            Object object3 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            if (object3 <= 0) {
                f10 = -0.1f;
            }
            object.a(f10);
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        boolean bl2;
        this.g = bl2 = true;
        EditorHorizontalScrollView$b editorHorizontalScrollView$b = this.f;
        if (editorHorizontalScrollView$b != null) {
            editorHorizontalScrollView$b.c();
        }
        return bl2;
    }

    public void onScaleEnd(ScaleGestureDetector object) {
        object = this.f;
        if (object != null) {
            object.b();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        int n11 = this.g;
        int n12 = 1;
        if (n11 == 0 && (n11 = this.h) == 0 && (n11 = motionEvent.getPointerCount()) == n12) {
            this.h = n12;
        }
        if ((n11 = this.h) != 0) {
            n11 = (int)(super.onTouchEvent(motionEvent) ? 1 : 0);
        } else {
            ScaleGestureDetector scaleGestureDetector = this.e;
            n11 = (int)(scaleGestureDetector.onTouchEvent(motionEvent) ? 1 : 0);
        }
        int n13 = motionEvent.getPointerCount();
        if (n13 == n12 && ((n13 = motionEvent.getAction()) == n12 || (n10 = motionEvent.getAction()) == (n12 = 3))) {
            n10 = 0;
            motionEvent = null;
            this.h = false;
            this.g = false;
        }
        return n11 != 0;
    }

    public boolean overScrollBy(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, boolean bl2) {
        return super.overScrollBy(n10, n11, n12, n13, n14, n15, n16, n17, bl2);
    }

    public void scrollBy(int n10, int n11) {
        super.scrollBy(n10, n11);
    }

    public void scrollTo(int n10, int n11) {
        super.scrollTo(n10, n11);
    }

    public void setOnScaleGestureListener(EditorHorizontalScrollView$b editorHorizontalScrollView$b) {
        this.f = editorHorizontalScrollView$b;
    }

    public void setOnScrollChangeListener(View.OnScrollChangeListener object) {
        object = new RuntimeException("\u6b64\u65b9\u6cd5\u5df2\u7ecf\u88ab\u91cd\u5199,\u8bf7\u4f7f\u7528addOnScrollChangeListener(listener)\u65b9\u6cd5!");
        throw object;
    }

    public void setPosition(long l10) {
        this.i = l10;
    }

    public void setScrollX(int n10) {
        super.setScrollX(n10);
    }
}

