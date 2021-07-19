/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.transition.ViewOverlayApi14;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ViewOverlayApi14$OverlayViewGroup
extends ViewGroup {
    public static Method sInvalidateChildInParentFastMethod;
    private boolean mDisposed;
    public ArrayList mDrawables = null;
    public ViewGroup mHostView;
    public View mRequestingView;
    public ViewOverlayApi14 mViewOverlay;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static {
        int n10;
        Class[] classArray;
        Object object = ViewGroup.class;
        String string2 = "invalidateChildInParentFast";
        int n11 = 3;
        try {
            classArray = new Class[n11];
            n10 = 0;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return;
        }
        Class<Integer> clazz = Integer.TYPE;
        classArray[0] = clazz;
        n10 = 1;
        classArray[n10] = clazz;
        n10 = 2;
        clazz = Rect.class;
        classArray[n10] = clazz;
        object = ((Class)object).getDeclaredMethod(string2, classArray);
        sInvalidateChildInParentFastMethod = object;
    }

    public ViewOverlayApi14$OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
        super(context);
        this.mHostView = viewGroup;
        this.mRequestingView = view;
        int n10 = viewGroup.getWidth();
        this.setRight(n10);
        n10 = viewGroup.getHeight();
        this.setBottom(n10);
        viewGroup.addView((View)this);
        this.mViewOverlay = viewOverlayApi14;
    }

    private void assertNotDisposed() {
        boolean bl2 = this.mDisposed;
        if (!bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        throw illegalStateException;
    }

    private void disposeIfEmpty() {
        ArrayList arrayList;
        int n10 = this.getChildCount();
        if (n10 == 0 && ((arrayList = this.mDrawables) == null || (n10 = arrayList.size()) == 0)) {
            n10 = 1;
            this.mDisposed = n10;
            arrayList = this.mHostView;
            arrayList.removeView((View)this);
        }
    }

    private void getOffset(int[] nArray) {
        int n10 = 2;
        int[] nArray2 = new int[n10];
        int[] nArray3 = new int[n10];
        this.mHostView.getLocationOnScreen(nArray2);
        this.mRequestingView.getLocationOnScreen(nArray3);
        int n11 = nArray3[0];
        int n12 = nArray2[0];
        nArray[0] = n11 -= n12;
        int n13 = 1;
        n10 = nArray3[n13];
        int n14 = nArray2[n13];
        nArray[n13] = n10 -= n14;
    }

    public void add(Drawable drawable2) {
        boolean bl2;
        this.assertNotDisposed();
        Rect rect = this.mDrawables;
        if (rect == null) {
            this.mDrawables = rect = new ArrayList();
        }
        if (!(bl2 = (rect = this.mDrawables).contains(drawable2))) {
            this.mDrawables.add(drawable2);
            rect = drawable2.getBounds();
            this.invalidate(rect);
            drawable2.setCallback((Drawable.Callback)this);
        }
    }

    public void add(View view) {
        this.assertNotDisposed();
        ViewParent viewParent = view.getParent();
        boolean bl2 = viewParent instanceof ViewGroup;
        if (bl2) {
            Object object;
            Object object2;
            viewParent = (ViewGroup)view.getParent();
            if (viewParent != (object2 = this.mHostView) && (object2 = viewParent.getParent()) != null && (object = ViewCompat.isAttachedToWindow((View)viewParent)) != 0) {
                object = 2;
                int[] nArray = new int[object];
                object2 = new int[object];
                viewParent.getLocationOnScreen(nArray);
                this.mHostView.getLocationOnScreen((int[])object2);
                int n10 = nArray[0];
                Object object3 = object2[0];
                ViewCompat.offsetLeftAndRight(view, n10 -= object3);
                object3 = true;
                int n11 = nArray[object3];
                object = object2[object3];
                ViewCompat.offsetTopAndBottom(view, n11 -= object);
            }
            viewParent.removeView(view);
            object2 = view.getParent();
            if (object2 != null) {
                viewParent.removeView(view);
            }
        }
        super.addView(view);
    }

    public void dispatchDraw(Canvas canvas) {
        int n10 = 2;
        Object object = new int[n10];
        Object object2 = new int[n10];
        this.mHostView.getLocationOnScreen(object);
        this.mRequestingView.getLocationOnScreen((int[])object2);
        int n11 = 0;
        int n12 = object2[0];
        int n13 = object[0];
        float f10 = n12 - n13;
        n13 = 1;
        n10 = object2[n13];
        int n14 = object[n13];
        float f11 = n10 -= n14;
        canvas.translate(f10, f11);
        object2 = new Rect;
        object = this.mRequestingView;
        n14 = object.getWidth();
        View view = this.mRequestingView;
        n12 = view.getHeight();
        object2(0, 0, n14, n12);
        canvas.clipRect((Rect)object2);
        super.dispatchDraw(canvas);
        object2 = this.mDrawables;
        if (object2 == null) {
            n10 = 0;
            object2 = null;
            f11 = 0.0f;
        } else {
            n10 = ((ArrayList)object2).size();
        }
        while (n11 < n10) {
            object = (Drawable)this.mDrawables.get(n11);
            object.draw(canvas);
            ++n11;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public ViewParent invalidateChildInParent(int[] nArray, Rect rect) {
        ViewGroup viewGroup = this.mHostView;
        if (viewGroup != null) {
            boolean n10 = false;
            viewGroup = null;
            Object object = nArray[0];
            int n11 = 1;
            int n12 = nArray[n11];
            rect.offset(object, n12);
            Object object2 = this.mHostView;
            object = object2 instanceof ViewGroup;
            if (object != 0) {
                nArray[0] = 0;
                nArray[n11] = 0;
                object2 = new int[2];
                this.getOffset((int[])object2);
                ViewGroup viewGroup2 = object2[0];
                object = object2[n11];
                rect.offset((int)viewGroup2, object);
                return super.invalidateChildInParent(nArray, rect);
            }
            this.invalidate(rect);
        }
        return null;
    }

    public ViewParent invalidateChildInParentFast(int n10, int n11, Rect rect) {
        Object object = this.mHostView;
        int n12 = object instanceof ViewGroup;
        if (n12 != 0 && (object = sInvalidateChildInParentFastMethod) != null) {
            n12 = 2;
            Object object2 = new int[n12];
            this.getOffset((int[])object2);
            object2 = sInvalidateChildInParentFastMethod;
            ViewGroup viewGroup = this.mHostView;
            int n13 = 3;
            Object[] objectArray = new Object[n13];
            Integer n14 = n10;
            objectArray[0] = n14;
            n10 = 1;
            Integer n15 = n11;
            objectArray[n10] = n15;
            objectArray[n12] = rect;
            try {
                ((Method)object2).invoke(viewGroup, objectArray);
            }
            catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
        return null;
    }

    public void invalidateDrawable(Drawable drawable2) {
        drawable2 = drawable2.getBounds();
        this.invalidate((Rect)drawable2);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
    }

    public void remove(Drawable drawable2) {
        ArrayList arrayList = this.mDrawables;
        if (arrayList != null) {
            arrayList.remove(drawable2);
            arrayList = drawable2.getBounds();
            this.invalidate((Rect)arrayList);
            arrayList = null;
            drawable2.setCallback(null);
            this.disposeIfEmpty();
        }
    }

    public void remove(View view) {
        super.removeView(view);
        this.disposeIfEmpty();
    }

    public boolean verifyDrawable(Drawable drawable2) {
        boolean bl2;
        ArrayList arrayList;
        boolean bl3 = super.verifyDrawable(drawable2);
        if (!(bl3 || (arrayList = this.mDrawables) != null && (bl2 = arrayList.contains(drawable2)))) {
            bl2 = false;
            drawable2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

