/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.PopupWindow
 */
package com.zhiyun.ui;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FixedPopupWindow
extends PopupWindow {
    public FixedPopupWindow() {
    }

    public FixedPopupWindow(int n10, int n11) {
        super(n10, n11);
    }

    public FixedPopupWindow(Context context) {
        super(context);
    }

    public FixedPopupWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixedPopupWindow(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public FixedPopupWindow(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
    }

    public FixedPopupWindow(View view) {
        super(view);
    }

    public FixedPopupWindow(View view, int n10, int n11) {
        super(view, n10, n11);
    }

    public FixedPopupWindow(View view, int n10, int n11, boolean bl2) {
        super(view, n10, n11, bl2);
    }

    private Object execMethod(String object, Class[] classArray, Object[] objectArray) {
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (bl3) {
            return null;
        }
        Class<PopupWindow> clazz = PopupWindow.class;
        try {
            object = this.getMethod(clazz, (String)object, classArray);
            bl2 = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        ((Method)object).setAccessible(bl2);
        return ((Method)object).invoke((Object)this, objectArray);
    }

    private Method getMethod(Class genericDeclaration, String string2, Class[] classArray) {
        try {
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string2, classArray);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            try {
                genericDeclaration = ((Class)genericDeclaration).getMethod(string2, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException2) {
                Class clazz = ((Class)genericDeclaration).getSuperclass();
                if (clazz == null) {
                    return null;
                }
                genericDeclaration = ((Class)genericDeclaration).getSuperclass();
                genericDeclaration = this.getMethod((Class)genericDeclaration, string2, classArray);
            }
        }
        return genericDeclaration;
    }

    private Object getParam(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return null;
        }
        Class<PopupWindow> clazz = PopupWindow.class;
        try {
            object = clazz.getDeclaredField((String)object);
            bl2 = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        ((Field)object).setAccessible(bl2);
        return ((Field)object).get((Object)this);
    }

    private void setParam(String object, Object object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        Class<PopupWindow> clazz = PopupWindow.class;
        object = clazz.getDeclaredField((String)object);
        bl2 = true;
        ((Field)object).setAccessible(bl2);
        try {
            ((Field)object).set((Object)this, object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void update(int n10, int n11, int n12, int n13, boolean bl2) {
        Object object;
        Object object2;
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 24;
        if (n14 != n15) {
            super.update(n10, n11, n12, n13, bl2);
            return;
        }
        Object object3 = "mLastWidth";
        if (n12 >= 0) {
            object2 = n12;
            this.setParam((String)object3, object2);
            this.setWidth(n12);
        }
        object2 = "mLastHeight";
        if (n13 >= 0) {
            object = n13;
            this.setParam((String)object2, object);
            this.setHeight(n13);
        }
        object = this.getParam("mContentView");
        boolean bl3 = object instanceof View;
        Object object4 = null;
        object = bl3 ? (View)object : null;
        bl3 = this.isShowing();
        if (bl3 && object != null) {
            Object[] objectArray;
            int n16;
            Object object5;
            Object object6;
            int n17;
            int n18;
            object = this.getParam("mDecorView");
            bl3 = object instanceof View;
            object = bl3 ? (View)object : null;
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams)object.getLayoutParams();
            Object object7 = this.getParam("mWidthMode");
            int n19 = 0;
            if (object7 != null) {
                object7 = (Integer)object7;
                n18 = (Integer)object7;
            } else {
                n18 = 0;
                object7 = null;
            }
            Object object8 = this.getParam((String)object3);
            if (object8 != null) {
                object8 = (Integer)object8;
                n17 = (Integer)object8;
            } else {
                n17 = 0;
                object8 = null;
            }
            if (n18 >= 0) {
                n18 = n17;
            }
            n17 = -1;
            int n20 = 1;
            if (n12 != n17 && (n12 = layoutParams.width) != n18) {
                layoutParams.width = n18;
                object6 = n18;
                this.setParam((String)object3, object6);
                int n21 = n20;
            }
            if ((object6 = this.getParam("mHeightMode")) != null) {
                object6 = (Integer)object6;
                n12 = (Integer)object6;
            } else {
                n12 = 0;
                object6 = null;
            }
            object3 = this.getParam((String)object2);
            if (object3 != null) {
                object3 = (Integer)object3;
                n14 = (Integer)object3;
            } else {
                n14 = 0;
                object3 = null;
            }
            if (n12 >= 0) {
                n12 = n14;
            }
            if (n13 != n17 && (n13 = layoutParams.height) != n12) {
                layoutParams.height = n12;
                object6 = n12;
                this.setParam((String)object2, object6);
                int n22 = n20;
            }
            if ((n12 = layoutParams.x) != n10) {
                layoutParams.x = n10;
                int n23 = n20;
            }
            if ((n10 = layoutParams.y) != n11) {
                layoutParams.y = n11;
                int n24 = n20;
            }
            if ((object5 = this.execMethod("computeAnimationResource", null, null)) == null) {
                n10 = 0;
                object5 = null;
            } else {
                object5 = (Integer)object5;
                n10 = (Integer)object5;
            }
            n11 = layoutParams.windowAnimations;
            if (n10 != n11) {
                layoutParams.windowAnimations = n10;
                n16 = n20;
            }
            object5 = new Class[n20];
            object5[0] = objectArray = Integer.TYPE;
            objectArray = new Object[n20];
            n12 = layoutParams.flags;
            objectArray[0] = object6 = Integer.valueOf(n12);
            object6 = "computeFlags";
            if ((object5 = this.execMethod((String)object6, (Class[])object5, objectArray)) != null) {
                object5 = (Integer)object5;
                n19 = (Integer)object5;
            }
            n10 = layoutParams.flags;
            if (n19 != n10) {
                layoutParams.flags = n19;
            } else {
                n20 = n16;
            }
            if (n20 != 0) {
                this.execMethod("setLayoutDirectionFromAnchor", null, null);
                object5 = this.getParam("mWindowManager");
                n11 = object5 instanceof WindowManager;
                if (n11 != 0) {
                    object4 = object5;
                    object4 = (WindowManager)object5;
                }
                if (object4 != null) {
                    object4.updateViewLayout((View)object, (ViewGroup.LayoutParams)layoutParams);
                }
            }
        }
    }
}

