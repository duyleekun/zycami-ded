/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;

public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] nArray = sTempNestedScrollConsumed;
        if (nArray == null) {
            int n10 = 2;
            sTempNestedScrollConsumed = nArray = new int[n10];
        } else {
            nArray[0] = 0;
            int n11 = 1;
            nArray[n11] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, n10);
        }
    }

    public static boolean onNestedFling(ViewParent object, View view, float f10, float f11, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            try {
                return object.onNestedFling(view, f10, f11, bl2);
            }
            catch (AbstractMethodError abstractMethodError) {
                CharSequence charSequence = new StringBuilder();
                String string2 = "ViewParent ";
                charSequence.append(string2);
                charSequence.append(object);
                charSequence.append(" does not implement interface method onNestedFling");
                object = charSequence.toString();
                charSequence = TAG;
                Log.e((String)charSequence, (String)object, (Throwable)abstractMethodError);
            }
        } else {
            n10 = object instanceof NestedScrollingParent;
            if (n10 != 0) {
                return ((NestedScrollingParent)object).onNestedFling(view, f10, f11, bl2);
            }
        }
        return false;
    }

    public static boolean onNestedPreFling(ViewParent object, View view, float f10, float f11) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            try {
                return object.onNestedPreFling(view, f10, f11);
            }
            catch (AbstractMethodError abstractMethodError) {
                CharSequence charSequence = new StringBuilder();
                String string2 = "ViewParent ";
                charSequence.append(string2);
                charSequence.append(object);
                charSequence.append(" does not implement interface method onNestedPreFling");
                object = charSequence.toString();
                charSequence = TAG;
                Log.e((String)charSequence, (String)object, (Throwable)abstractMethodError);
            }
        } else {
            n10 = object instanceof NestedScrollingParent;
            if (n10 != 0) {
                return ((NestedScrollingParent)object).onNestedPreFling(view, f10, f11);
            }
        }
        return false;
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int n10, int n11, int[] nArray) {
        ViewParentCompat.onNestedPreScroll(viewParent, view, n10, n11, nArray, 0);
    }

    public static void onNestedPreScroll(ViewParent object, View view, int n10, int n11, int[] nArray, int n12) {
        int n13 = object instanceof NestedScrollingParent2;
        if (n13 != 0) {
            Object object2 = object;
            object2 = (NestedScrollingParent2)object;
            object2.onNestedPreScroll(view, n10, n11, nArray, n12);
        } else if (n12 == 0) {
            n12 = Build.VERSION.SDK_INT;
            n13 = 21;
            if (n12 >= n13) {
                try {
                    object.onNestedPreScroll(view, n10, n11, nArray);
                }
                catch (AbstractMethodError abstractMethodError) {
                    CharSequence charSequence = new StringBuilder();
                    String string2 = "ViewParent ";
                    charSequence.append(string2);
                    charSequence.append(object);
                    charSequence.append(" does not implement interface method onNestedPreScroll");
                    object = charSequence.toString();
                    charSequence = TAG;
                    Log.e((String)charSequence, (String)object, (Throwable)abstractMethodError);
                }
            } else {
                n12 = object instanceof NestedScrollingParent;
                if (n12 != 0) {
                    object = (NestedScrollingParent)object;
                    object.onNestedPreScroll(view, n10, n11, nArray);
                }
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int n10, int n11, int n12, int n13) {
        int[] nArray = ViewParentCompat.getTempNestedScrollConsumed();
        ViewParentCompat.onNestedScroll(viewParent, view, n10, n11, n12, n13, 0, nArray);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int n10, int n11, int n12, int n13, int n14) {
        int[] nArray = ViewParentCompat.getTempNestedScrollConsumed();
        ViewParentCompat.onNestedScroll(viewParent, view, n10, n11, n12, n13, n14, nArray);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int n10, int n11, int n12, int n13, int n14, int[] nArray) {
        Object object = viewParent;
        int n15 = viewParent instanceof NestedScrollingParent3;
        if (n15 != 0) {
            object = (NestedScrollingParent3)viewParent;
            View view2 = view;
            object.onNestedScroll(view, n10, n11, n12, n13, n14, nArray);
        } else {
            int n16;
            CharSequence charSequence = null;
            nArray[0] = n16 = nArray[0] + n12;
            n15 = 1;
            nArray[n15] = n16 = nArray[n15] + n13;
            n15 = viewParent instanceof NestedScrollingParent2;
            if (n15 != 0) {
                Object object2 = viewParent;
                object2 = (NestedScrollingParent2)viewParent;
                object2.onNestedScroll(view, n10, n11, n12, n13, n14);
            } else if (n14 == 0) {
                n15 = Build.VERSION.SDK_INT;
                n16 = 21;
                if (n15 >= n16) {
                    try {
                        viewParent.onNestedScroll(view, n10, n11, n12, n13);
                    }
                    catch (AbstractMethodError abstractMethodError) {
                        charSequence = new StringBuilder();
                        String string2 = "ViewParent ";
                        charSequence.append(string2);
                        charSequence.append(viewParent);
                        charSequence.append(" does not implement interface method onNestedScroll");
                        charSequence = charSequence.toString();
                        object = TAG;
                        Log.e((String)object, (String)charSequence, (Throwable)abstractMethodError);
                    }
                } else {
                    n15 = viewParent instanceof NestedScrollingParent;
                    if (n15 != 0) {
                        Object object3 = viewParent;
                        object3 = (NestedScrollingParent)viewParent;
                        object3.onNestedScroll(view, n10, n11, n12, n13);
                    }
                }
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int n10) {
        ViewParentCompat.onNestedScrollAccepted(viewParent, view, view2, n10, 0);
    }

    public static void onNestedScrollAccepted(ViewParent object, View view, View object2, int n10, int n11) {
        int n12 = object instanceof NestedScrollingParent2;
        if (n12 != 0) {
            object = (NestedScrollingParent2)object;
            object.onNestedScrollAccepted(view, (View)object2, n10, n11);
        } else if (n11 == 0) {
            n11 = Build.VERSION.SDK_INT;
            n12 = 21;
            if (n11 >= n12) {
                try {
                    object.onNestedScrollAccepted(view, (View)object2, n10);
                }
                catch (AbstractMethodError abstractMethodError) {
                    object2 = new StringBuilder();
                    String string2 = "ViewParent ";
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(object);
                    ((StringBuilder)object2).append(" does not implement interface method onNestedScrollAccepted");
                    object = ((StringBuilder)object2).toString();
                    object2 = TAG;
                    Log.e((String)object2, (String)object, (Throwable)abstractMethodError);
                }
            } else {
                n11 = object instanceof NestedScrollingParent;
                if (n11 != 0) {
                    object = (NestedScrollingParent)object;
                    object.onNestedScrollAccepted(view, (View)object2, n10);
                }
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int n10) {
        return ViewParentCompat.onStartNestedScroll(viewParent, view, view2, n10, 0);
    }

    public static boolean onStartNestedScroll(ViewParent object, View view, View object2, int n10, int n11) {
        int n12 = object instanceof NestedScrollingParent2;
        if (n12 != 0) {
            return ((NestedScrollingParent2)object).onStartNestedScroll(view, (View)object2, n10, n11);
        }
        if (n11 == 0) {
            n11 = Build.VERSION.SDK_INT;
            n12 = 21;
            if (n11 >= n12) {
                try {
                    return object.onStartNestedScroll(view, (View)object2, n10);
                }
                catch (AbstractMethodError abstractMethodError) {
                    object2 = new StringBuilder();
                    String string2 = "ViewParent ";
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(object);
                    ((StringBuilder)object2).append(" does not implement interface method onStartNestedScroll");
                    object = ((StringBuilder)object2).toString();
                    object2 = TAG;
                    Log.e((String)object2, (String)object, (Throwable)abstractMethodError);
                }
            } else {
                n11 = object instanceof NestedScrollingParent;
                if (n11 != 0) {
                    return ((NestedScrollingParent)object).onStartNestedScroll(view, (View)object2, n10);
                }
            }
        }
        return false;
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        ViewParentCompat.onStopNestedScroll(viewParent, view, 0);
    }

    public static void onStopNestedScroll(ViewParent object, View view, int n10) {
        int n11 = object instanceof NestedScrollingParent2;
        if (n11 != 0) {
            object = (NestedScrollingParent2)object;
            object.onStopNestedScroll(view, n10);
        } else if (n10 == 0) {
            n10 = Build.VERSION.SDK_INT;
            n11 = 21;
            if (n10 >= n11) {
                try {
                    object.onStopNestedScroll(view);
                }
                catch (AbstractMethodError abstractMethodError) {
                    CharSequence charSequence = new StringBuilder();
                    String string2 = "ViewParent ";
                    charSequence.append(string2);
                    charSequence.append(object);
                    charSequence.append(" does not implement interface method onStopNestedScroll");
                    object = charSequence.toString();
                    charSequence = TAG;
                    Log.e((String)charSequence, (String)object, (Throwable)abstractMethodError);
                }
            } else {
                n10 = object instanceof NestedScrollingParent;
                if (n10 != 0) {
                    object = (NestedScrollingParent)object;
                    object.onStopNestedScroll(view);
                }
            }
        }
    }

    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}

