/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.app.Activity
 *  android.content.ClipData
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.Display
 *  android.view.KeyEvent
 *  android.view.PointerIcon
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.View$DragShadowBuilder
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.WindowInsets
 *  android.view.WindowManager
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.core.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.AccessibilityDelegateCompat$AccessibilityDelegateAdapter;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.OnReceiveContentListener;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat$1;
import androidx.core.view.ViewCompat$2;
import androidx.core.view.ViewCompat$3;
import androidx.core.view.ViewCompat$4;
import androidx.core.view.ViewCompat$5;
import androidx.core.view.ViewCompat$AccessibilityPaneVisibilityManager;
import androidx.core.view.ViewCompat$AccessibilityViewProperty;
import androidx.core.view.ViewCompat$Api21Impl;
import androidx.core.view.ViewCompat$Api23Impl;
import androidx.core.view.ViewCompat$Api29Impl;
import androidx.core.view.ViewCompat$Api30Impl;
import androidx.core.view.ViewCompat$CompatImplApi28;
import androidx.core.view.ViewCompat$OnUnhandledKeyEventListenerCompat;
import androidx.core.view.ViewCompat$UnhandledKeyEventManager;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 0xFFFFFF;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 0x1000000;
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static ViewCompat$AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static final AtomicInteger sNextGeneratedId;
    private static boolean sTempDetachBound;
    private static ThreadLocal sThreadLocalRect;
    private static WeakHashMap sTransitionNameMap;
    private static WeakHashMap sViewPropertyAnimatorMap;

    static {
        int n10;
        int n11;
        int n12 = 1;
        Object object = new AtomicInteger(n12);
        sNextGeneratedId = object;
        sViewPropertyAnimatorMap = null;
        sAccessibilityDelegateCheckFailed = false;
        int[] nArray = new int[32];
        nArray[0] = n11 = R$id.accessibility_custom_action_0;
        nArray[n12] = n10 = R$id.accessibility_custom_action_1;
        nArray[2] = n10 = R$id.accessibility_custom_action_2;
        nArray[3] = n10 = R$id.accessibility_custom_action_3;
        nArray[4] = n10 = R$id.accessibility_custom_action_4;
        nArray[5] = n10 = R$id.accessibility_custom_action_5;
        nArray[6] = n10 = R$id.accessibility_custom_action_6;
        nArray[7] = n10 = R$id.accessibility_custom_action_7;
        nArray[8] = n10 = R$id.accessibility_custom_action_8;
        nArray[9] = n10 = R$id.accessibility_custom_action_9;
        nArray[10] = n10 = R$id.accessibility_custom_action_10;
        nArray[11] = n10 = R$id.accessibility_custom_action_11;
        nArray[12] = n10 = R$id.accessibility_custom_action_12;
        nArray[13] = n10 = R$id.accessibility_custom_action_13;
        nArray[14] = n10 = R$id.accessibility_custom_action_14;
        nArray[15] = n10 = R$id.accessibility_custom_action_15;
        nArray[16] = n10 = R$id.accessibility_custom_action_16;
        nArray[17] = n10 = R$id.accessibility_custom_action_17;
        nArray[18] = n10 = R$id.accessibility_custom_action_18;
        nArray[19] = n10 = R$id.accessibility_custom_action_19;
        nArray[20] = n10 = R$id.accessibility_custom_action_20;
        nArray[21] = n10 = R$id.accessibility_custom_action_21;
        nArray[22] = n10 = R$id.accessibility_custom_action_22;
        nArray[23] = n10 = R$id.accessibility_custom_action_23;
        nArray[24] = n10 = R$id.accessibility_custom_action_24;
        nArray[25] = n10 = R$id.accessibility_custom_action_25;
        nArray[26] = n10 = R$id.accessibility_custom_action_26;
        nArray[27] = n10 = R$id.accessibility_custom_action_27;
        nArray[28] = n10 = R$id.accessibility_custom_action_28;
        nArray[29] = n10 = R$id.accessibility_custom_action_29;
        nArray[30] = n10 = R$id.accessibility_custom_action_30;
        nArray[31] = n10 = R$id.accessibility_custom_action_31;
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = nArray;
        NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = object = new ViewCompat$1();
        sAccessibilityPaneVisibilityManager = object = new ViewCompat$AccessibilityPaneVisibilityManager();
    }

    private static ViewCompat$AccessibilityViewProperty accessibilityHeadingProperty() {
        int n10 = R$id.tag_accessibility_heading;
        ViewCompat$5 viewCompat$5 = new ViewCompat$5(n10, Boolean.class, 28);
        return viewCompat$5;
    }

    public static int addAccessibilityAction(View view, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        int n10;
        int n11 = ViewCompat.getAvailableActionIdFromResources(view);
        if (n11 != (n10 = -1)) {
            AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(n11, charSequence, accessibilityViewCommand);
            ViewCompat.addAccessibilityAction(view, accessibilityNodeInfoCompat$AccessibilityActionCompat);
        }
        return n11;
    }

    private static void addAccessibilityAction(View view, AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
            n10 = accessibilityNodeInfoCompat$AccessibilityActionCompat.getId();
            ViewCompat.removeActionWithId(n10, view);
            List list = ViewCompat.getActionList(view);
            list.add(accessibilityNodeInfoCompat$AccessibilityActionCompat);
            accessibilityNodeInfoCompat$AccessibilityActionCompat = null;
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
        }
    }

    public static void addKeyboardNavigationClusters(View view, Collection collection, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 >= n12) {
            view.addKeyboardNavigationClusters(collection, n10);
        }
    }

    public static void addOnUnhandledKeyEventListener(View view, ViewCompat$OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            ViewCompat$CompatImplApi28.addOnUnhandledKeyEventListener(view, viewCompat$OnUnhandledKeyEventListenerCompat);
            return;
        }
        n10 = R$id.tag_unhandled_key_listeners;
        ArrayList<ViewCompat$OnUnhandledKeyEventListenerCompat> arrayList = (ArrayList<ViewCompat$OnUnhandledKeyEventListenerCompat>)view.getTag(n10);
        if (arrayList == null) {
            arrayList = new ArrayList<ViewCompat$OnUnhandledKeyEventListenerCompat>();
            view.setTag(n10, arrayList);
        }
        arrayList.add(viewCompat$OnUnhandledKeyEventListenerCompat);
        int n12 = arrayList.size();
        n10 = 1;
        if (n12 == n10) {
            ViewCompat$UnhandledKeyEventManager.registerListeningView(view);
        }
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        WeakHashMap weakHashMap = sViewPropertyAnimatorMap;
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            sViewPropertyAnimatorMap = weakHashMap;
        }
        if ((weakHashMap = (ViewPropertyAnimatorCompat)sViewPropertyAnimatorMap.get(view)) == null) {
            weakHashMap = new ViewPropertyAnimatorCompat(view);
            WeakHashMap weakHashMap2 = sViewPropertyAnimatorMap;
            weakHashMap2.put(view, weakHashMap);
        }
        return weakHashMap;
    }

    private static void bindTempDetach() {
        Object object = View.class;
        String string2 = "dispatchStartTemporaryDetach";
        Class[] classArray = null;
        Class[] classArray2 = new Class[]{};
        object = ((Class)object).getDeclaredMethod(string2, classArray2);
        sDispatchStartTemporaryDetach = object;
        object = View.class;
        string2 = "dispatchFinishTemporaryDetach";
        classArray = new Class[]{};
        object = ((Class)object).getDeclaredMethod(string2, classArray);
        try {
            sDispatchFinishTemporaryDetach = object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string2 = TAG;
            classArray = "Couldn't find method";
            Log.e((String)string2, (String)classArray, (Throwable)noSuchMethodException);
        }
        sTempDetachBound = true;
    }

    public static boolean canScrollHorizontally(View view, int n10) {
        return view.canScrollHorizontally(n10);
    }

    public static boolean canScrollVertically(View view, int n10) {
        return view.canScrollVertically(n10);
    }

    public static void cancelDragAndDrop(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            view.cancelDragAndDrop();
        }
    }

    public static int combineMeasuredStates(int n10, int n11) {
        return View.combineMeasuredStates((int)n10, (int)n11);
    }

    private static void compatOffsetLeftAndRight(View view, int n10) {
        view.offsetLeftAndRight(n10);
        n10 = view.getVisibility();
        if (n10 == 0) {
            ViewCompat.tickleInvalidationFlag(view);
            view = view.getParent();
            n10 = view instanceof View;
            if (n10 != 0) {
                ViewCompat.tickleInvalidationFlag(view);
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view, int n10) {
        view.offsetTopAndBottom(n10);
        n10 = view.getVisibility();
        if (n10 == 0) {
            ViewCompat.tickleInvalidationFlag(view);
            view = view.getParent();
            n10 = view instanceof View;
            if (n10 != 0) {
                ViewCompat.tickleInvalidationFlag(view);
            }
        }
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ViewCompat$Api21Impl.computeSystemWindowInsets(view, windowInsetsCompat, rect);
        }
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets;
        WindowInsets windowInsets2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11 && (windowInsets2 = windowInsetsCompat.toWindowInsets()) != null && (n10 = (int)((windowInsets = view.dispatchApplyWindowInsets(windowInsets2)).equals((Object)windowInsets2) ? 1 : 0)) == 0) {
            return WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        }
        return windowInsetsCompat;
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            view.dispatchFinishTemporaryDetach();
        } else {
            Object object;
            n10 = (int)(sTempDetachBound ? 1 : 0);
            if (n10 == 0) {
                ViewCompat.bindTempDetach();
            }
            if ((object = sDispatchFinishTemporaryDetach) != null) {
                n11 = 0;
                Object[] objectArray = null;
                objectArray = new Object[]{};
                try {
                    ((Method)object).invoke(view, objectArray);
                }
                catch (Exception exception) {
                    object = TAG;
                    objectArray = "Error calling dispatchFinishTemporaryDetach";
                    Log.d((String)object, (String)objectArray, (Throwable)exception);
                }
            } else {
                view.onFinishTemporaryDetach();
            }
        }
    }

    public static boolean dispatchNestedFling(View view, float f10, float f11, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return view.dispatchNestedFling(f10, f11, bl2);
        }
        n10 = view instanceof NestedScrollingChild;
        if (n10 != 0) {
            return ((NestedScrollingChild)view).dispatchNestedFling(f10, f11, bl2);
        }
        return false;
    }

    public static boolean dispatchNestedPreFling(View view, float f10, float f11) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return view.dispatchNestedPreFling(f10, f11);
        }
        n10 = view instanceof NestedScrollingChild;
        if (n10 != 0) {
            return ((NestedScrollingChild)view).dispatchNestedPreFling(f10, f11);
        }
        return false;
    }

    public static boolean dispatchNestedPreScroll(View view, int n10, int n11, int[] nArray, int[] nArray2) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 21;
        if (n12 >= n13) {
            return view.dispatchNestedPreScroll(n10, n11, nArray, nArray2);
        }
        n12 = view instanceof NestedScrollingChild;
        if (n12 != 0) {
            return ((NestedScrollingChild)view).dispatchNestedPreScroll(n10, n11, nArray, nArray2);
        }
        return false;
    }

    public static boolean dispatchNestedPreScroll(View view, int n10, int n11, int[] nArray, int[] nArray2, int n12) {
        boolean bl2 = view instanceof NestedScrollingChild2;
        if (bl2) {
            return ((NestedScrollingChild2)view).dispatchNestedPreScroll(n10, n11, nArray, nArray2, n12);
        }
        if (n12 == 0) {
            return ViewCompat.dispatchNestedPreScroll(view, n10, n11, nArray, nArray2);
        }
        return false;
    }

    public static void dispatchNestedScroll(View view, int n10, int n11, int n12, int n13, int[] nArray, int n14, int[] nArray2) {
        boolean bl2 = view instanceof NestedScrollingChild3;
        if (bl2) {
            Object object = view;
            object = (NestedScrollingChild3)view;
            object.dispatchNestedScroll(n10, n11, n12, n13, nArray, n14, nArray2);
        } else {
            ViewCompat.dispatchNestedScroll(view, n10, n11, n12, n13, nArray, n14);
        }
    }

    public static boolean dispatchNestedScroll(View view, int n10, int n11, int n12, int n13, int[] nArray) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 21;
        if (n14 >= n15) {
            return view.dispatchNestedScroll(n10, n11, n12, n13, nArray);
        }
        n14 = view instanceof NestedScrollingChild;
        if (n14 != 0) {
            return ((NestedScrollingChild)view).dispatchNestedScroll(n10, n11, n12, n13, nArray);
        }
        return false;
    }

    public static boolean dispatchNestedScroll(View view, int n10, int n11, int n12, int n13, int[] nArray, int n14) {
        boolean bl2 = view instanceof NestedScrollingChild2;
        if (bl2) {
            return ((NestedScrollingChild2)view).dispatchNestedScroll(n10, n11, n12, n13, nArray, n14);
        }
        if (n14 == 0) {
            return ViewCompat.dispatchNestedScroll(view, n10, n11, n12, n13, nArray);
        }
        return false;
    }

    public static void dispatchStartTemporaryDetach(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            view.dispatchStartTemporaryDetach();
        } else {
            Object object;
            n10 = (int)(sTempDetachBound ? 1 : 0);
            if (n10 == 0) {
                ViewCompat.bindTempDetach();
            }
            if ((object = sDispatchStartTemporaryDetach) != null) {
                n11 = 0;
                Object[] objectArray = null;
                objectArray = new Object[]{};
                try {
                    ((Method)object).invoke(view, objectArray);
                }
                catch (Exception exception) {
                    object = TAG;
                    objectArray = "Error calling dispatchStartTemporaryDetach";
                    Log.d((String)object, (String)objectArray, (Throwable)exception);
                }
            } else {
                view.onStartTemporaryDetach();
            }
        }
    }

    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return false;
        }
        return ViewCompat$UnhandledKeyEventManager.at(view).dispatch(view, keyEvent);
    }

    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return false;
        }
        return ViewCompat$UnhandledKeyEventManager.at(view).preDispatch(keyEvent);
    }

    public static void enableAccessibleClickableSpanSupport(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
        }
    }

    public static int generateViewId() {
        int n10;
        AtomicInteger atomicInteger;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            return View.generateViewId();
        }
        do {
            int n13;
            if ((n10 = (n12 = (atomicInteger = sNextGeneratedId).get()) + 1) <= (n13 = 0xFFFFFF)) continue;
            n10 = 1;
        } while ((n11 = (int)(atomicInteger.compareAndSet(n12, n10) ? 1 : 0)) == 0);
        return n12;
    }

    public static AccessibilityDelegateCompat getAccessibilityDelegate(View view) {
        if ((view = ViewCompat.getAccessibilityDelegateInternal(view)) == null) {
            return null;
        }
        boolean bl2 = view instanceof AccessibilityDelegateCompat$AccessibilityDelegateAdapter;
        if (bl2) {
            return ((AccessibilityDelegateCompat$AccessibilityDelegateAdapter)view).mCompat;
        }
        AccessibilityDelegateCompat accessibilityDelegateCompat = new AccessibilityDelegateCompat((View.AccessibilityDelegate)view);
        return accessibilityDelegateCompat;
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return view.getAccessibilityDelegate();
        }
        return ViewCompat.getAccessibilityDelegateThroughReflection(view);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(View object) {
        boolean bl2 = sAccessibilityDelegateCheckFailed;
        if (bl2) {
            return null;
        }
        Object object2 = sAccessibilityDelegateField;
        boolean bl3 = true;
        if (object2 == null) {
            object2 = View.class;
            String string2 = "mAccessibilityDelegate";
            try {
                object2 = ((Class)object2).getDeclaredField(string2);
            }
            catch (Throwable throwable) {
                sAccessibilityDelegateCheckFailed = bl3;
                return null;
            }
            sAccessibilityDelegateField = object2;
            ((Field)object2).setAccessible(bl3);
        }
        try {
            object2 = sAccessibilityDelegateField;
        }
        catch (Throwable throwable) {
            sAccessibilityDelegateCheckFailed = bl3;
            return null;
        }
        object = ((Field)object2).get(object);
        bl2 = object instanceof View.AccessibilityDelegate;
        if (bl2) {
            return (View.AccessibilityDelegate)object;
        }
        return null;
    }

    public static int getAccessibilityLiveRegion(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11 && (view = view.getAccessibilityNodeProvider()) != null) {
            AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = new AccessibilityNodeProviderCompat(view);
            return accessibilityNodeProviderCompat;
        }
        return null;
    }

    public static CharSequence getAccessibilityPaneTitle(View view) {
        return (CharSequence)ViewCompat.paneTitleProperty().get(view);
    }

    private static List getActionList(View view) {
        int n10 = R$id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList)view.getTag(n10);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(n10, arrayList);
        }
        return arrayList;
    }

    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    private static int getAvailableActionIdFromResources(View object) {
        int[] nArray;
        int n10;
        int n11;
        object = ViewCompat.getActionList((View)object);
        int n12 = n11 = -1;
        for (int i10 = 0; i10 < (n10 = (nArray = ACCESSIBILITY_ACTIONS_RESOURCE_IDS).length) && n12 == n11; ++i10) {
            int n13;
            int n14 = nArray[i10];
            n10 = 1;
            int n15 = n10;
            for (int i11 = 0; i11 < (n13 = object.size()); ++i11) {
                AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object.get(i11);
                n13 = accessibilityNodeInfoCompat$AccessibilityActionCompat.getId();
                if (n13 != n14) {
                    n13 = n10;
                } else {
                    n13 = 0;
                    accessibilityNodeInfoCompat$AccessibilityActionCompat = null;
                }
                n15 &= n13;
            }
            if (n15 == 0) continue;
            n12 = n14;
        }
        return n12;
    }

    public static ColorStateList getBackgroundTintList(View object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return object.getBackgroundTintList();
        }
        n10 = object instanceof TintableBackgroundView;
        object = n10 != 0 ? ((TintableBackgroundView)object).getSupportBackgroundTintList() : null;
        return object;
    }

    public static PorterDuff.Mode getBackgroundTintMode(View object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return object.getBackgroundTintMode();
        }
        n10 = object instanceof TintableBackgroundView;
        object = n10 != 0 ? ((TintableBackgroundView)object).getSupportBackgroundTintMode() : null;
        return object;
    }

    public static Rect getClipBounds(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return view.getClipBounds();
        }
        return null;
    }

    public static Display getDisplay(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return view.getDisplay();
        }
        n10 = (int)(ViewCompat.isAttachedToWindow(view) ? 1 : 0);
        if (n10 != 0) {
            return ((WindowManager)view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static float getElevation(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return view.getElevation();
        }
        return 0.0f;
    }

    private static Rect getEmptyTempRect() {
        Rect rect = sThreadLocalRect;
        if (rect == null) {
            rect = new ThreadLocal();
            sThreadLocalRect = rect;
        }
        if ((rect = (Rect)sThreadLocalRect.get()) == null) {
            rect = new Rect();
            ThreadLocal threadLocal = sThreadLocalRect;
            threadLocal.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    private static OnReceiveContentViewBehavior getFallback(View view) {
        boolean bl2 = view instanceof OnReceiveContentViewBehavior;
        if (bl2) {
            return (OnReceiveContentViewBehavior)view;
        }
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    public static boolean getFitsSystemWindows(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static int getImportantForAccessibility(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static int getImportantForAutofill(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int getLabelFor(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return view.getLabelFor();
        }
        return 0;
    }

    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int getMinimumHeight(View object) {
        Field field;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return object.getMinimumHeight();
        }
        n10 = (int)(sMinHeightFieldFetched ? 1 : 0);
        if (!n10) {
            n10 = 1;
            Object object2 = View.class;
            String string2 = "mMinHeight";
            try {
                sMinHeightField = object2 = ((Class)object2).getDeclaredField(string2);
                ((Field)object2).setAccessible(n10 != 0);
            }
            catch (NoSuchFieldException noSuchFieldException) {}
            sMinHeightFieldFetched = n10;
        }
        if ((field = sMinHeightField) != null) {
            try {
                object = field.get(object);
                object = (Integer)object;
                return (Integer)object;
            }
            catch (Exception exception) {}
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int getMinimumWidth(View object) {
        Field field;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return object.getMinimumWidth();
        }
        n10 = (int)(sMinWidthFieldFetched ? 1 : 0);
        if (!n10) {
            n10 = 1;
            Object object2 = View.class;
            String string2 = "mMinWidth";
            try {
                sMinWidthField = object2 = ((Class)object2).getDeclaredField(string2);
                ((Field)object2).setAccessible(n10 != 0);
            }
            catch (NoSuchFieldException noSuchFieldException) {}
            sMinWidthFieldFetched = n10;
        }
        if ((field = sMinWidthField) != null) {
            try {
                object = field.get(object);
                object = (Integer)object;
                return (Integer)object;
            }
            catch (Exception exception) {}
        }
        return 0;
    }

    public static int getNextClusterForwardId(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return view.getNextClusterForwardId();
        }
        return -1;
    }

    public static String[] getOnReceiveContentMimeTypes(View view) {
        int n10 = R$id.tag_on_receive_content_mime_types;
        return (String[])view.getTag(n10);
    }

    public static AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(View view) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = ViewCompat.getAccessibilityDelegate(view);
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
        return accessibilityDelegateCompat;
    }

    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    public static int getPaddingEnd(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static int getPaddingStart(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static ViewParent getParentForAccessibility(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return view.getParentForAccessibility();
        }
        return view.getParent();
    }

    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return ViewCompat$Api23Impl.getRootWindowInsets(view);
        }
        n11 = 21;
        if (n10 >= n11) {
            return ViewCompat$Api21Impl.getRootWindowInsets(view);
        }
        return null;
    }

    public static float getRotation(View view) {
        return view.getRotation();
    }

    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return view.getScrollIndicators();
        }
        return 0;
    }

    public static final CharSequence getStateDescription(View view) {
        return (CharSequence)ViewCompat.stateDescriptionProperty().get(view);
    }

    public static List getSystemGestureExclusionRects(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return view.getSystemGestureExclusionRects();
        }
        return Collections.emptyList();
    }

    public static String getTransitionName(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return view.getTransitionName();
        }
        WeakHashMap weakHashMap = sTransitionNameMap;
        if (weakHashMap == null) {
            return null;
        }
        return (String)weakHashMap.get(view);
    }

    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static WindowInsetsControllerCompat getWindowInsetsController(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            return ViewCompat$Api30Impl.getWindowInsetsController(view);
        }
        Context context = view.getContext();
        while (true) {
            n11 = context instanceof ContextWrapper;
            WindowInsetsControllerCompat windowInsetsControllerCompat = null;
            if (n11 == 0) break;
            n11 = context instanceof Activity;
            if (n11 != 0) {
                if ((context = ((Activity)context).getWindow()) != null) {
                    windowInsetsControllerCompat = WindowCompat.getInsetsController((Window)context, view);
                }
                return windowInsetsControllerCompat;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    public static int getWindowSystemUiVisibility(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float getX(View view) {
        return view.getX();
    }

    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean hasAccessibilityDelegate(View view) {
        boolean bl2;
        if ((view = ViewCompat.getAccessibilityDelegateInternal(view)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public static boolean hasExplicitFocusable(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return view.hasExplicitFocusable();
        }
        return view.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return view.hasNestedScrollingParent();
        }
        n10 = view instanceof NestedScrollingChild;
        if (n10 != 0) {
            return ((NestedScrollingChild)view).hasNestedScrollingParent();
        }
        return false;
    }

    public static boolean hasNestedScrollingParent(View object, int n10) {
        boolean bl2 = object instanceof NestedScrollingChild2;
        if (bl2) {
            object = (NestedScrollingChild2)object;
            object.hasNestedScrollingParent(n10);
        } else if (n10 == 0) {
            return ViewCompat.hasNestedScrollingParent((View)object);
        }
        return false;
    }

    public static boolean hasOnClickListeners(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 15;
        if (n10 >= n11) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean hasOverlappingRendering(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean hasTransientState(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean isAccessibilityHeading(View object) {
        boolean bl2;
        ViewCompat$AccessibilityViewProperty viewCompat$AccessibilityViewProperty = ViewCompat.accessibilityHeadingProperty();
        object = (Boolean)viewCompat$AccessibilityViewProperty.get((View)object);
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public static boolean isAttachedToWindow(View view) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return view.isAttachedToWindow();
        }
        if ((view = view.getWindowToken()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public static boolean isFocusedByDefault(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return view.isFocusedByDefault();
        }
        return false;
    }

    public static boolean isImportantForAccessibility(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return view.isImportantForAccessibility();
        }
        return true;
    }

    public static boolean isImportantForAutofill(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return view.isImportantForAutofill();
        }
        return true;
    }

    public static boolean isInLayout(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return view.isInLayout();
        }
        return false;
    }

    public static boolean isKeyboardNavigationCluster(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return view.isKeyboardNavigationCluster();
        }
        return false;
    }

    public static boolean isLaidOut(View view) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return view.isLaidOut();
        }
        n10 = view.getWidth();
        if (n10 > 0 && (bl2 = view.getHeight()) > false) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public static boolean isLayoutDirectionResolved(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return view.isLayoutDirectionResolved();
        }
        return false;
    }

    public static boolean isNestedScrollingEnabled(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return view.isNestedScrollingEnabled();
        }
        n10 = view instanceof NestedScrollingChild;
        if (n10 != 0) {
            return ((NestedScrollingChild)view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean isScreenReaderFocusable(View object) {
        boolean bl2;
        ViewCompat$AccessibilityViewProperty viewCompat$AccessibilityViewProperty = ViewCompat.screenReaderFocusableProperty();
        object = (Boolean)viewCompat$AccessibilityViewProperty.get((View)object);
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View view, View view2, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 >= n12) {
            return view.keyboardNavigationClusterSearch(view2, n10);
        }
        return null;
    }

    public static void notifyViewAccessibilityStateChangedIfNeeded(View object, int n10) {
        Object object2 = object.getContext();
        CharSequence charSequence = "accessibility";
        int n11 = (object2 = (AccessibilityManager)object2.getSystemService(charSequence)).isEnabled();
        if (n11 == 0) {
            return;
        }
        charSequence = ViewCompat.getAccessibilityPaneTitle(object);
        if (charSequence != null && (n11 = object.getVisibility()) == 0) {
            n11 = 1;
        } else {
            n11 = 0;
            charSequence = null;
        }
        int n12 = ViewCompat.getAccessibilityLiveRegion(object);
        int n13 = 32;
        if (n12 == 0 && n11 == 0) {
            if (n10 == n13) {
                charSequence = AccessibilityEvent.obtain();
                object.onInitializeAccessibilityEvent((AccessibilityEvent)charSequence);
                charSequence.setEventType(n13);
                charSequence.setContentChangeTypes(n10);
                charSequence.setSource(object);
                object.onPopulateAccessibilityEvent((AccessibilityEvent)charSequence);
                List list = charSequence.getText();
                object = ViewCompat.getAccessibilityPaneTitle(object);
                list.add(object);
                object2.sendAccessibilityEvent((AccessibilityEvent)charSequence);
            } else {
                object2 = object.getParent();
                if (object2 != null) {
                    object2 = object.getParent();
                    try {
                        object2.notifySubtreeAccessibilityStateChanged(object, object, n10);
                    }
                    catch (AbstractMethodError abstractMethodError) {
                        object2 = new StringBuilder();
                        object = object.getParent().getClass().getSimpleName();
                        ((StringBuilder)object2).append((String)object);
                        ((StringBuilder)object2).append(" does not fully implement ViewParent");
                        object = ((StringBuilder)object2).toString();
                        object2 = TAG;
                        Log.e((String)object2, (String)object, (Throwable)abstractMethodError);
                    }
                }
            }
        } else {
            object2 = AccessibilityEvent.obtain();
            if (n11 == 0) {
                n13 = 2048;
            }
            object2.setEventType(n13);
            object2.setContentChangeTypes(n10);
            if (n11 != 0) {
                List list = object2.getText();
                charSequence = ViewCompat.getAccessibilityPaneTitle(object);
                list.add(charSequence);
                ViewCompat.setViewImportanceForAccessibilityIfNeeded(object);
            }
            object.sendAccessibilityEventUnchecked((AccessibilityEvent)object2);
        }
    }

    public static void offsetLeftAndRight(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            view.offsetLeftAndRight(n10);
        } else {
            n12 = 21;
            if (n11 >= n12) {
                Rect rect = ViewCompat.getEmptyTempRect();
                n12 = 0;
                ViewParent viewParent = null;
                ViewParent viewParent2 = view.getParent();
                int n13 = viewParent2 instanceof View;
                if (n13 != 0) {
                    viewParent = viewParent2;
                    viewParent = (View)viewParent2;
                    n13 = viewParent.getLeft();
                    int n14 = viewParent.getTop();
                    int n15 = viewParent.getRight();
                    n12 = viewParent.getBottom();
                    rect.set(n13, n14, n15, n12);
                    n12 = view.getLeft();
                    n13 = view.getTop();
                    n14 = view.getRight();
                    n15 = view.getBottom();
                    n12 = rect.intersects(n12, n13, n14, n15) ^ 1;
                }
                ViewCompat.compatOffsetLeftAndRight(view, n10);
                if (n12 != 0) {
                    n10 = view.getLeft();
                    n12 = view.getTop();
                    n13 = view.getRight();
                    int n16 = view.getBottom();
                    if ((n16 = (int)(rect.intersect(n10, n12, n13, n16) ? 1 : 0)) != 0) {
                        viewParent2 = (View)viewParent2;
                        viewParent2.invalidate(rect);
                    }
                }
            } else {
                ViewCompat.compatOffsetLeftAndRight(view, n10);
            }
        }
    }

    public static void offsetTopAndBottom(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            view.offsetTopAndBottom(n10);
        } else {
            n12 = 21;
            if (n11 >= n12) {
                Rect rect = ViewCompat.getEmptyTempRect();
                n12 = 0;
                ViewParent viewParent = null;
                ViewParent viewParent2 = view.getParent();
                int n13 = viewParent2 instanceof View;
                if (n13 != 0) {
                    viewParent = viewParent2;
                    viewParent = (View)viewParent2;
                    n13 = viewParent.getLeft();
                    int n14 = viewParent.getTop();
                    int n15 = viewParent.getRight();
                    n12 = viewParent.getBottom();
                    rect.set(n13, n14, n15, n12);
                    n12 = view.getLeft();
                    n13 = view.getTop();
                    n14 = view.getRight();
                    n15 = view.getBottom();
                    n12 = rect.intersects(n12, n13, n14, n15) ^ 1;
                }
                ViewCompat.compatOffsetTopAndBottom(view, n10);
                if (n12 != 0) {
                    n10 = view.getLeft();
                    n12 = view.getTop();
                    n13 = view.getRight();
                    int n16 = view.getBottom();
                    if ((n16 = (int)(rect.intersect(n10, n12, n13, n16) ? 1 : 0)) != 0) {
                        viewParent2 = (View)viewParent2;
                        viewParent2.invalidate(rect);
                    }
                }
            } else {
                ViewCompat.compatOffsetTopAndBottom(view, n10);
            }
        }
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets;
        WindowInsets windowInsets2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11 && (windowInsets2 = windowInsetsCompat.toWindowInsets()) != null && (n10 = (int)((windowInsets = view.onApplyWindowInsets(windowInsets2)).equals((Object)windowInsets2) ? 1 : 0)) == 0) {
            return WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        }
        return windowInsetsCompat;
    }

    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat = accessibilityNodeInfoCompat.unwrap();
        view.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)accessibilityNodeInfoCompat);
    }

    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static ViewCompat$AccessibilityViewProperty paneTitleProperty() {
        int n10 = R$id.tag_accessibility_pane_title;
        ViewCompat$3 viewCompat$3 = new ViewCompat$3(n10, CharSequence.class, 8, 28);
        return viewCompat$3;
    }

    public static boolean performAccessibilityAction(View view, int n10, Bundle bundle) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            return view.performAccessibilityAction(n10, bundle);
        }
        return false;
    }

    public static ContentInfoCompat performReceiveContent(View object, ContentInfoCompat contentInfoCompat) {
        int n10;
        Object object2 = TAG;
        boolean bl2 = Log.isLoggable((String)object2, (int)3);
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("performReceiveContent: ");
            charSequence.append(contentInfoCompat);
            charSequence.append(", view=");
            String string2 = object.getClass().getSimpleName();
            charSequence.append(string2);
            charSequence.append("[");
            int n11 = object.getId();
            charSequence.append(n11);
            string2 = "]";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Log.d((String)object2, (String)charSequence);
        }
        if ((object2 = (OnReceiveContentListener)object.getTag(n10 = R$id.tag_on_receive_content_listener)) != null) {
            object = (contentInfoCompat = object2.onReceiveContent((View)object, contentInfoCompat)) == null ? null : ViewCompat.getFallback(object).onReceiveContent(contentInfoCompat);
            return object;
        }
        return ViewCompat.getFallback(object).onReceiveContent(contentInfoCompat);
    }

    public static void postInvalidateOnAnimation(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void postInvalidateOnAnimation(View view, int n10, int n11, int n12, int n13) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 16;
        if (n14 >= n15) {
            view.postInvalidateOnAnimation(n10, n11, n12, n13);
        } else {
            view.postInvalidate(n10, n11, n12, n13);
        }
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            view.postOnAnimation(runnable);
        } else {
            long l10 = ValueAnimator.getFrameDelay();
            view.postDelayed(runnable, l10);
        }
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long l10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            view.postOnAnimationDelayed(runnable, l10);
        } else {
            long l11 = ValueAnimator.getFrameDelay() + l10;
            view.postDelayed(runnable, l11);
        }
    }

    public static void removeAccessibilityAction(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            ViewCompat.removeActionWithId(n10, view);
            n10 = 0;
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
        }
    }

    private static void removeActionWithId(int n10, View object) {
        int n11;
        object = ViewCompat.getActionList((View)object);
        for (int i10 = 0; i10 < (n11 = object.size()); ++i10) {
            AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object.get(i10);
            n11 = accessibilityNodeInfoCompat$AccessibilityActionCompat.getId();
            if (n11 != n10) continue;
            object.remove(i10);
            break;
        }
    }

    public static void removeOnUnhandledKeyEventListener(View view, ViewCompat$OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            ViewCompat$CompatImplApi28.removeOnUnhandledKeyEventListener(view, viewCompat$OnUnhandledKeyEventListenerCompat);
            return;
        }
        n10 = R$id.tag_unhandled_key_listeners;
        ArrayList arrayList = (ArrayList)view.getTag(n10);
        if (arrayList != null) {
            arrayList.remove(viewCompat$OnUnhandledKeyEventListenerCompat);
            int n12 = arrayList.size();
            if (n12 == 0) {
                ViewCompat$UnhandledKeyEventManager.unregisterListeningView(view);
            }
        }
    }

    public static void replaceAccessibilityAction(View view, AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            int n10 = accessibilityNodeInfoCompat$AccessibilityActionCompat.getId();
            ViewCompat.removeAccessibilityAction(view, n10);
        } else {
            accessibilityNodeInfoCompat$AccessibilityActionCompat = accessibilityNodeInfoCompat$AccessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand);
            ViewCompat.addAccessibilityAction(view, accessibilityNodeInfoCompat$AccessibilityActionCompat);
        }
    }

    public static void requestApplyInsets(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 20;
        if (n10 >= n11) {
            view.requestApplyInsets();
        } else {
            n11 = 16;
            if (n10 >= n11) {
                view.requestFitSystemWindows();
            }
        }
    }

    public static View requireViewById(View object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            return object.requireViewById(n10);
        }
        if ((object = object.findViewById(n10)) != null) {
            return object;
        }
        object = new IllegalArgumentException("ID does not reference a View inside this View");
        throw object;
    }

    public static int resolveSizeAndState(int n10, int n11, int n12) {
        return View.resolveSizeAndState((int)n10, (int)n11, (int)n12);
    }

    public static boolean restoreDefaultFocus(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return view.restoreDefaultFocus();
        }
        return view.requestFocus();
    }

    public static void saveAttributeDataForStyleable(View view, Context context, int[] nArray, AttributeSet attributeSet, TypedArray typedArray, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 29;
        if (n12 >= n13) {
            ViewCompat$Api29Impl.saveAttributeDataForStyleable(view, context, nArray, attributeSet, typedArray, n10, n11);
        }
    }

    private static ViewCompat$AccessibilityViewProperty screenReaderFocusableProperty() {
        int n10 = R$id.tag_screen_reader_focusable;
        ViewCompat$2 viewCompat$2 = new ViewCompat$2(n10, Boolean.class, 28);
        return viewCompat$2;
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate accessibilityDelegate;
        boolean bl2;
        if (accessibilityDelegateCompat == null && (bl2 = (accessibilityDelegate = ViewCompat.getAccessibilityDelegateInternal(view)) instanceof AccessibilityDelegateCompat$AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        accessibilityDelegateCompat = accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge();
        view.setAccessibilityDelegate((View.AccessibilityDelegate)accessibilityDelegateCompat);
    }

    public static void setAccessibilityHeading(View view, boolean bl2) {
        ViewCompat$AccessibilityViewProperty viewCompat$AccessibilityViewProperty = ViewCompat.accessibilityHeadingProperty();
        Boolean bl3 = bl2;
        viewCompat$AccessibilityViewProperty.set(view, bl3);
    }

    public static void setAccessibilityLiveRegion(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            view.setAccessibilityLiveRegion(n10);
        }
    }

    public static void setAccessibilityPaneTitle(View view, CharSequence object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            ViewCompat$AccessibilityViewProperty viewCompat$AccessibilityViewProperty = ViewCompat.paneTitleProperty();
            viewCompat$AccessibilityViewProperty.set(view, object);
            if (object != null) {
                object = sAccessibilityPaneVisibilityManager;
                ((ViewCompat$AccessibilityPaneVisibilityManager)object).addAccessibilityPane(view);
            } else {
                object = sAccessibilityPaneVisibilityManager;
                ((ViewCompat$AccessibilityPaneVisibilityManager)object).removeAccessibilityPane(view);
            }
        }
    }

    public static void setActivated(View view, boolean bl2) {
        view.setActivated(bl2);
    }

    public static void setAlpha(View view, float f10) {
        view.setAlpha(f10);
    }

    public static void setAutofillHints(View view, String ... stringArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            view.setAutofillHints(stringArray);
        }
    }

    public static void setBackground(View view, Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            view.setBackground(drawable2);
        } else {
            view.setBackgroundDrawable(drawable2);
        }
    }

    public static void setBackgroundTintList(View object, ColorStateList colorStateList) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object.setBackgroundTintList(colorStateList);
            if (n10 == n11) {
                colorStateList = object.getBackground();
                Object object2 = object.getBackgroundTintList();
                if (object2 == null && (object2 = object.getBackgroundTintMode()) == null) {
                    n10 = 0;
                    object2 = null;
                } else {
                    n10 = 1;
                }
                if (colorStateList != null && n10 != 0) {
                    n10 = (int)(colorStateList.isStateful() ? 1 : 0);
                    if (n10 != 0) {
                        object2 = object.getDrawableState();
                        colorStateList.setState((int[])object2);
                    }
                    object.setBackground((Drawable)colorStateList);
                }
            }
        } else {
            n10 = object instanceof TintableBackgroundView;
            if (n10 != 0) {
                object = (TintableBackgroundView)object;
                object.setSupportBackgroundTintList(colorStateList);
            }
        }
    }

    public static void setBackgroundTintMode(View object, PorterDuff.Mode mode) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object.setBackgroundTintMode(mode);
            if (n10 == n11) {
                mode = object.getBackground();
                Object object2 = object.getBackgroundTintList();
                if (object2 == null && (object2 = object.getBackgroundTintMode()) == null) {
                    n10 = 0;
                    object2 = null;
                } else {
                    n10 = 1;
                }
                if (mode != null && n10 != 0) {
                    n10 = (int)(mode.isStateful() ? 1 : 0);
                    if (n10 != 0) {
                        object2 = object.getDrawableState();
                        mode.setState((int[])object2);
                    }
                    object.setBackground((Drawable)mode);
                }
            }
        } else {
            n10 = object instanceof TintableBackgroundView;
            if (n10 != 0) {
                object = (TintableBackgroundView)object;
                object.setSupportBackgroundTintMode(mode);
            }
        }
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean bl2) {
        String string2 = "Unable to invoke childrenDrawingOrderEnabled";
        Object object = sChildrenDrawingOrderMethod;
        boolean bl3 = true;
        String string3 = TAG;
        if (object == null) {
            object = ViewGroup.class;
            String string4 = "setChildrenDrawingOrderEnabled";
            Class[] classArray = new Class[bl3];
            Class<Boolean> clazz = Boolean.TYPE;
            classArray[0] = clazz;
            object = ((Class)object).getDeclaredMethod(string4, classArray);
            try {
                sChildrenDrawingOrderMethod = object;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                string4 = "Unable to find childrenDrawingOrderEnabled";
                Log.e((String)string3, (String)string4, (Throwable)noSuchMethodException);
            }
            object = sChildrenDrawingOrderMethod;
            ((Method)object).setAccessible(bl3);
        }
        object = sChildrenDrawingOrderMethod;
        Object[] objectArray = new Object[bl3];
        Boolean bl4 = bl2;
        objectArray[0] = bl4;
        try {
            ((Method)object).invoke(viewGroup, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.e((String)string3, (String)string2, (Throwable)invocationTargetException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Log.e((String)string3, (String)string2, (Throwable)illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)string3, (String)string2, (Throwable)illegalAccessException);
        }
    }

    public static void setClipBounds(View view, Rect rect) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            view.setClipBounds(rect);
        }
    }

    public static void setElevation(View view, float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            view.setElevation(f10);
        }
    }

    public static void setFitsSystemWindows(View view, boolean bl2) {
        view.setFitsSystemWindows(bl2);
    }

    public static void setFocusedByDefault(View view, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            view.setFocusedByDefault(bl2);
        }
    }

    public static void setHasTransientState(View view, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            view.setHasTransientState(bl2);
        }
    }

    public static void setImportantForAccessibility(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            view.setImportantForAccessibility(n10);
        } else {
            n12 = 16;
            if (n11 >= n12) {
                n11 = 4;
                if (n10 == n11) {
                    n10 = 2;
                }
                view.setImportantForAccessibility(n10);
            }
        }
    }

    public static void setImportantForAutofill(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 >= n12) {
            view.setImportantForAutofill(n10);
        }
    }

    public static void setKeyboardNavigationCluster(View view, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            view.setKeyboardNavigationCluster(bl2);
        }
    }

    public static void setLabelFor(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            view.setLabelFor(n10);
        }
    }

    public static void setLayerPaint(View view, Paint paint) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            view.setLayerPaint(paint);
        } else {
            n10 = view.getLayerType();
            view.setLayerType(n10, paint);
            view.invalidate();
        }
    }

    public static void setLayerType(View view, int n10, Paint paint) {
        view.setLayerType(n10, paint);
    }

    public static void setLayoutDirection(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            view.setLayoutDirection(n10);
        }
    }

    public static void setNestedScrollingEnabled(View object, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object.setNestedScrollingEnabled(bl2);
        } else {
            n10 = object instanceof NestedScrollingChild;
            if (n10 != 0) {
                object = (NestedScrollingChild)object;
                object.setNestedScrollingEnabled(bl2);
            }
        }
    }

    public static void setNextClusterForwardId(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 >= n12) {
            view.setNextClusterForwardId(n10);
        }
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            ViewCompat$Api21Impl.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
        }
    }

    public static void setOnReceiveContentListener(View view, String[] stringArray, OnReceiveContentListener onReceiveContentListener) {
        String string2;
        String string3;
        int n10;
        int n11;
        int n12;
        if (stringArray == null || !(n12 = stringArray.length)) {
            n11 = 0;
            stringArray = null;
        }
        n12 = 0;
        int n13 = 1;
        if (onReceiveContentListener != null) {
            if (stringArray != null) {
                n10 = n13;
            } else {
                n10 = 0;
                string3 = null;
            }
            string2 = "When the listener is set, MIME types must also be set";
            Preconditions.checkArgument(n10 != 0, string2);
        }
        if (stringArray != null) {
            n10 = stringArray.length;
            string2 = null;
            for (int i10 = 0; i10 < n10; i10 += 1) {
                String string4 = stringArray[i10];
                String string5 = "*";
                boolean bl2 = string4.startsWith(string5);
                if (!bl2) continue;
                n12 = n13;
                break;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("A MIME type set here must not start with *: ");
            string3 = Arrays.toString(stringArray);
            charSequence.append(string3);
            charSequence = charSequence.toString();
            Preconditions.checkArgument((n12 ^= n13) != 0, charSequence);
        }
        n12 = R$id.tag_on_receive_content_mime_types;
        view.setTag(n12, (Object)stringArray);
        n11 = R$id.tag_on_receive_content_listener;
        view.setTag(n11, (Object)onReceiveContentListener);
    }

    public static void setOverScrollMode(View view, int n10) {
        view.setOverScrollMode(n10);
    }

    public static void setPaddingRelative(View view, int n10, int n11, int n12, int n13) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 17;
        if (n14 >= n15) {
            view.setPaddingRelative(n10, n11, n12, n13);
        } else {
            view.setPadding(n10, n11, n12, n13);
        }
    }

    public static void setPivotX(View view, float f10) {
        view.setPivotX(f10);
    }

    public static void setPivotY(View view, float f10) {
        view.setPivotY(f10);
    }

    public static void setPointerIcon(View view, PointerIconCompat object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            object = object != null ? ((PointerIconCompat)object).getPointerIcon() : null;
            object = (PointerIcon)object;
            view.setPointerIcon((PointerIcon)object);
        }
    }

    public static void setRotation(View view, float f10) {
        view.setRotation(f10);
    }

    public static void setRotationX(View view, float f10) {
        view.setRotationX(f10);
    }

    public static void setRotationY(View view, float f10) {
        view.setRotationY(f10);
    }

    public static void setSaveFromParentEnabled(View view, boolean bl2) {
        view.setSaveFromParentEnabled(bl2);
    }

    public static void setScaleX(View view, float f10) {
        view.setScaleX(f10);
    }

    public static void setScaleY(View view, float f10) {
        view.setScaleY(f10);
    }

    public static void setScreenReaderFocusable(View view, boolean bl2) {
        ViewCompat$AccessibilityViewProperty viewCompat$AccessibilityViewProperty = ViewCompat.screenReaderFocusableProperty();
        Boolean bl3 = bl2;
        viewCompat$AccessibilityViewProperty.set(view, bl3);
    }

    public static void setScrollIndicators(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            view.setScrollIndicators(n10);
        }
    }

    public static void setScrollIndicators(View view, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 23;
        if (n12 >= n13) {
            view.setScrollIndicators(n10, n11);
        }
    }

    public static void setStateDescription(View view, CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            ViewCompat$AccessibilityViewProperty viewCompat$AccessibilityViewProperty = ViewCompat.stateDescriptionProperty();
            viewCompat$AccessibilityViewProperty.set(view, charSequence);
        }
    }

    public static void setSystemGestureExclusionRects(View view, List list) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            view.setTooltipText(charSequence);
        }
    }

    public static void setTransitionName(View view, String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            view.setTransitionName(string2);
        } else {
            WeakHashMap<View, String> weakHashMap = sTransitionNameMap;
            if (weakHashMap == null) {
                sTransitionNameMap = weakHashMap = new WeakHashMap<View, String>();
            }
            weakHashMap = sTransitionNameMap;
            weakHashMap.put(view, string2);
        }
    }

    public static void setTranslationX(View view, float f10) {
        view.setTranslationX(f10);
    }

    public static void setTranslationY(View view, float f10) {
        view.setTranslationY(f10);
    }

    public static void setTranslationZ(View view, float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            view.setTranslationZ(f10);
        }
    }

    private static void setViewImportanceForAccessibilityIfNeeded(View view) {
        int n10;
        int n11 = ViewCompat.getImportantForAccessibility(view);
        if (n11 == 0) {
            n11 = 1;
            ViewCompat.setImportantForAccessibility(view, n11);
        }
        ViewParent viewParent = view.getParent();
        while ((n10 = viewParent instanceof View) != 0) {
            int n12;
            ViewParent viewParent2 = viewParent;
            viewParent2 = (View)viewParent;
            n10 = ViewCompat.getImportantForAccessibility((View)viewParent2);
            if (n10 == (n12 = 4)) {
                n11 = 2;
                ViewCompat.setImportantForAccessibility(view, n11);
                break;
            }
            viewParent = viewParent.getParent();
        }
    }

    public static void setWindowInsetsAnimationCallback(View view, WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.setCallback(view, callback);
    }

    public static void setX(View view, float f10) {
        view.setX(f10);
    }

    public static void setY(View view, float f10) {
        view.setY(f10);
    }

    public static void setZ(View view, float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            view.setZ(f10);
        }
    }

    public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, object, n10);
        }
        return view.startDrag(clipData, dragShadowBuilder, object, n10);
    }

    public static boolean startNestedScroll(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return view.startNestedScroll(n10);
        }
        n11 = view instanceof NestedScrollingChild;
        if (n11 != 0) {
            return ((NestedScrollingChild)view).startNestedScroll(n10);
        }
        return false;
    }

    public static boolean startNestedScroll(View view, int n10, int n11) {
        boolean bl2 = view instanceof NestedScrollingChild2;
        if (bl2) {
            return ((NestedScrollingChild2)view).startNestedScroll(n10, n11);
        }
        if (n11 == 0) {
            return ViewCompat.startNestedScroll(view, n10);
        }
        return false;
    }

    private static ViewCompat$AccessibilityViewProperty stateDescriptionProperty() {
        int n10 = R$id.tag_state_description;
        ViewCompat$4 viewCompat$4 = new ViewCompat$4(n10, CharSequence.class, 64, 30);
        return viewCompat$4;
    }

    public static void stopNestedScroll(View object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object.stopNestedScroll();
        } else {
            n10 = object instanceof NestedScrollingChild;
            if (n10 != 0) {
                object = (NestedScrollingChild)object;
                object.stopNestedScroll();
            }
        }
    }

    public static void stopNestedScroll(View object, int n10) {
        boolean bl2 = object instanceof NestedScrollingChild2;
        if (bl2) {
            object = (NestedScrollingChild2)object;
            object.stopNestedScroll(n10);
        } else if (n10 == 0) {
            ViewCompat.stopNestedScroll((View)object);
        }
    }

    private static void tickleInvalidationFlag(View view) {
        float f10 = view.getTranslationY();
        float f11 = 1.0f + f10;
        view.setTranslationY(f11);
        view.setTranslationY(f10);
    }

    public static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }
}

