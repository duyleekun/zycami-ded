/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowInsets
 *  android.widget.FrameLayout
 */
package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R$styleable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;

public final class FragmentContainerView
extends FrameLayout {
    private View.OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private ArrayList mDisappearingFragmentChildren;
    private boolean mDrawDisappearingViewsFirst;
    private ArrayList mTransitioningFragmentViews;

    public FragmentContainerView(Context context) {
        super(context);
        this.mDrawDisappearingViewsFirst = true;
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(Context object, AttributeSet object2, int n10) {
        super(object, object2, n10);
        n10 = 1;
        this.mDrawDisappearingViewsFirst = n10;
        if (object2 != null) {
            boolean bl2;
            String string2 = object2.getClassAttribute();
            Object object3 = R$styleable.FragmentContainerView;
            object = object.obtainStyledAttributes(object2, (int[])object3);
            if (string2 == null) {
                int n11 = R$styleable.FragmentContainerView_android_name;
                string2 = object.getString(n11);
                object2 = "android:name";
            } else {
                object2 = "class";
            }
            object.recycle();
            if (string2 != null && !(bl2 = this.isInEditMode())) {
                object3 = new StringBuilder;
                super();
                ((StringBuilder)object3).append("FragmentContainerView must be within a FragmentActivity to use ");
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append("=\"");
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append("\"");
                object2 = ((StringBuilder)object3).toString();
                super((String)object2);
                throw object;
            }
        }
    }

    public FragmentContainerView(Context object, AttributeSet object2, FragmentManager object3) {
        super((Context)object, object2);
        boolean bl2;
        this.mDrawDisappearingViewsFirst = bl2 = true;
        Object object4 = object2.getClassAttribute();
        Object object5 = R$styleable.FragmentContainerView;
        object5 = object.obtainStyledAttributes(object2, (int[])object5);
        if (object4 == null) {
            int n10 = R$styleable.FragmentContainerView_android_name;
            object4 = object5.getString(n10);
        }
        int n11 = R$styleable.FragmentContainerView_android_tag;
        String string2 = object5.getString(n11);
        object5.recycle();
        int n12 = this.getId();
        Object object6 = ((FragmentManager)object3).findFragmentById(n12);
        if (object4 != null && object6 == null) {
            if (n12 <= 0) {
                if (string2 != null) {
                    super();
                    object2 = " with tag ";
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                } else {
                    object = "";
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("FragmentContainerView must have an android:id to add Fragment ");
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                super((String)object);
                throw object2;
            }
            object5 = ((FragmentManager)object3).getFragmentFactory();
            object6 = object.getClassLoader();
            object4 = ((FragmentFactory)object5).instantiate((ClassLoader)object6, (String)object4);
            n12 = 0;
            object5 = null;
            ((Fragment)object4).onInflate((Context)object, (AttributeSet)object2, null);
            object = ((FragmentManager)object3).beginTransaction().setReorderingAllowed(bl2).add((ViewGroup)this, (Fragment)object4, string2);
            ((FragmentTransaction)object).commitNowAllowingStateLoss();
        }
        ((FragmentManager)object3).onContainerAvailable(this);
    }

    private void addDisappearingFragmentView(View view) {
        boolean bl2;
        ArrayList arrayList = this.mTransitioningFragmentViews;
        if (arrayList != null && (bl2 = arrayList.contains(view))) {
            arrayList = this.mDisappearingFragmentChildren;
            if (arrayList == null) {
                this.mDisappearingFragmentChildren = arrayList = new ArrayList();
            }
            arrayList = this.mDisappearingFragmentChildren;
            arrayList.add(view);
        }
    }

    public void addView(View object, int n10, ViewGroup.LayoutParams object2) {
        Fragment fragment = FragmentManager.getViewFragment(object);
        if (fragment != null) {
            super.addView(object, n10, (ViewGroup.LayoutParams)object2);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" is not associated with a Fragment.");
        object = ((StringBuilder)object2).toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public boolean addViewInLayout(View object, int n10, ViewGroup.LayoutParams object2, boolean bl2) {
        Fragment fragment = FragmentManager.getViewFragment(object);
        if (fragment != null) {
            return super.addViewInLayout(object, n10, (ViewGroup.LayoutParams)object2, bl2);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" is not associated with a Fragment.");
        object = ((StringBuilder)object2).toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.mApplyWindowInsetsListener;
        windowInsetsCompat = onApplyWindowInsetsListener != null ? WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsetsListener.onApplyWindowInsets((View)this, windowInsets)) : ViewCompat.onApplyWindowInsets((View)this, windowInsetsCompat);
        int n10 = windowInsetsCompat.isConsumed();
        if (n10 == 0) {
            n10 = this.getChildCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                View view = this.getChildAt(i10);
                ViewCompat.dispatchApplyWindowInsets(view, windowInsetsCompat);
            }
        }
        return windowInsets;
    }

    public void dispatchDraw(Canvas canvas) {
        ArrayList arrayList;
        int n10 = this.mDrawDisappearingViewsFirst;
        if (n10 != 0 && (arrayList = this.mDisappearingFragmentChildren) != null) {
            ArrayList arrayList2;
            int n11;
            arrayList = null;
            for (n10 = 0; n10 < (n11 = (arrayList2 = this.mDisappearingFragmentChildren).size()); ++n10) {
                arrayList2 = (View)this.mDisappearingFragmentChildren.get(n10);
                long l10 = this.getDrawingTime();
                super.drawChild(canvas, (View)arrayList2, l10);
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean drawChild(Canvas canvas, View view, long l10) {
        ArrayList arrayList;
        int n10 = this.mDrawDisappearingViewsFirst;
        if (n10 != 0 && (arrayList = this.mDisappearingFragmentChildren) != null && (n10 = arrayList.size()) > 0 && (n10 = (int)((arrayList = this.mDisappearingFragmentChildren).contains(view) ? 1 : 0)) != 0) {
            return false;
        }
        return super.drawChild(canvas, view, l10);
    }

    public void endViewTransition(View view) {
        ArrayList arrayList = this.mTransitioningFragmentViews;
        if (arrayList != null) {
            boolean bl2;
            arrayList.remove(view);
            arrayList = this.mDisappearingFragmentChildren;
            if (arrayList != null && (bl2 = arrayList.remove(view))) {
                this.mDrawDisappearingViewsFirst = bl2 = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int i10 = this.getChildCount() + -1; i10 >= 0; i10 += -1) {
            View view = this.getChildAt(i10);
            this.addDisappearingFragmentView(view);
        }
        super.removeAllViewsInLayout();
    }

    public void removeDetachedView(View view, boolean bl2) {
        if (bl2) {
            this.addDisappearingFragmentView(view);
        }
        super.removeDetachedView(view, bl2);
    }

    public void removeView(View view) {
        this.addDisappearingFragmentView(view);
        super.removeView(view);
    }

    public void removeViewAt(int n10) {
        View view = this.getChildAt(n10);
        this.addDisappearingFragmentView(view);
        super.removeViewAt(n10);
    }

    public void removeViewInLayout(View view) {
        this.addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int n10, int n11) {
        int n12;
        for (int i10 = n10; i10 < (n12 = n10 + n11); ++i10) {
            View view = this.getChildAt(i10);
            this.addDisappearingFragmentView(view);
        }
        super.removeViews(n10, n11);
    }

    public void removeViewsInLayout(int n10, int n11) {
        int n12;
        for (int i10 = n10; i10 < (n12 = n10 + n11); ++i10) {
            View view = this.getChildAt(i10);
            this.addDisappearingFragmentView(view);
        }
        super.removeViewsInLayout(n10, n11);
    }

    public void setDrawDisappearingViewsLast(boolean bl2) {
        this.mDrawDisappearingViewsFirst = bl2;
    }

    public void setLayoutTransition(LayoutTransition object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11) {
            super.setLayoutTransition(object);
            return;
        }
        object = new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
        throw object;
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.mApplyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        Object object = view.getParent();
        if (object == this) {
            object = this.mTransitioningFragmentViews;
            if (object == null) {
                object = new ArrayList();
                this.mTransitioningFragmentViews = object;
            }
            object = this.mTransitioningFragmentViews;
            ((ArrayList)object).add(view);
        }
        super.startViewTransition(view);
    }
}

