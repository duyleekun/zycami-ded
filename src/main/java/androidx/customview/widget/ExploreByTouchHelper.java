/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityRecord
 */
package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityRecord;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.ExploreByTouchHelper$1;
import androidx.customview.widget.ExploreByTouchHelper$2;
import androidx.customview.widget.ExploreByTouchHelper$MyNodeProvider;
import androidx.customview.widget.FocusStrategy;
import androidx.customview.widget.FocusStrategy$BoundsAdapter;
import androidx.customview.widget.FocusStrategy$CollectionAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper
extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = 255;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS;
    private static final FocusStrategy$BoundsAdapter NODE_ADAPTER;
    private static final FocusStrategy$CollectionAdapter SPARSE_VALUES_ADAPTER;
    public int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    public int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private ExploreByTouchHelper$MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;

    static {
        Object object;
        int n10 = -1 >>> 1;
        int n11 = -1 << -1;
        INVALID_PARENT_BOUNDS = object = new Rect(n10, n10, n11, n11);
        object = new ExploreByTouchHelper$1();
        NODE_ADAPTER = object;
        object = new ExploreByTouchHelper$2();
        SPARSE_VALUES_ADAPTER = object;
    }

    public ExploreByTouchHelper(View object) {
        int n10;
        Object object2;
        this.mTempScreenRect = object2 = new Rect();
        this.mTempParentRect = object2 = new Rect();
        this.mTempVisibleRect = object2 = new Rect();
        object2 = new int[2];
        this.mTempGlobalRect = (int[])object2;
        this.mAccessibilityFocusedVirtualViewId = n10 = -1 << -1;
        this.mKeyboardFocusedVirtualViewId = n10;
        this.mHoveredVirtualViewId = n10;
        if (object != null) {
            this.mHost = object;
            object2 = object.getContext();
            String string2 = "accessibility";
            object2 = (AccessibilityManager)object2.getSystemService(string2);
            this.mManager = object2;
            n10 = 1;
            object.setFocusable(n10 != 0);
            int n11 = ViewCompat.getImportantForAccessibility(object);
            if (n11 == 0) {
                ViewCompat.setImportantForAccessibility(object, n10);
            }
            return;
        }
        super("View may not be null");
        throw object;
    }

    private boolean clearAccessibilityFocus(int n10) {
        int n11 = this.mAccessibilityFocusedVirtualViewId;
        if (n11 == n10) {
            this.mAccessibilityFocusedVirtualViewId = -1 << -1;
            this.mHost.invalidate();
            this.sendEventForVirtualView(n10, 65536);
            return true;
        }
        return false;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int n10 = this.mKeyboardFocusedVirtualViewId;
        int n11 = -1 << -1;
        n10 = n10 != n11 && (n10 = (int)(this.onPerformActionForVirtualView(n10, n11 = 16, null) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    private AccessibilityEvent createEvent(int n10, int n11) {
        int n12 = -1;
        if (n10 != n12) {
            return this.createEventForChild(n10, n11);
        }
        return this.createEventForHost(n11);
    }

    private AccessibilityEvent createEventForChild(int n10, int n11) {
        AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain((int)n11);
        Object object = this.obtainAccessibilityNodeInfo(n10);
        Object object2 = accessibilityEvent.getText();
        CharSequence charSequence = ((AccessibilityNodeInfoCompat)object).getText();
        object2.add(charSequence);
        object2 = ((AccessibilityNodeInfoCompat)object).getContentDescription();
        accessibilityEvent.setContentDescription((CharSequence)object2);
        boolean bl2 = ((AccessibilityNodeInfoCompat)object).isScrollable();
        accessibilityEvent.setScrollable(bl2);
        bl2 = ((AccessibilityNodeInfoCompat)object).isPassword();
        accessibilityEvent.setPassword(bl2);
        bl2 = ((AccessibilityNodeInfoCompat)object).isEnabled();
        accessibilityEvent.setEnabled(bl2);
        bl2 = ((AccessibilityNodeInfoCompat)object).isChecked();
        accessibilityEvent.setChecked(bl2);
        this.onPopulateEventForVirtualView(n10, accessibilityEvent);
        object2 = accessibilityEvent.getText();
        bl2 = object2.isEmpty();
        if (bl2 && (object2 = accessibilityEvent.getContentDescription()) == null) {
            RuntimeException runtimeException = new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            throw runtimeException;
        }
        object = ((AccessibilityNodeInfoCompat)object).getClassName();
        accessibilityEvent.setClassName((CharSequence)object);
        object = this.mHost;
        AccessibilityRecordCompat.setSource((AccessibilityRecord)accessibilityEvent, (View)object, n10);
        String string2 = this.mHost.getContext().getPackageName();
        accessibilityEvent.setPackageName((CharSequence)string2);
        return accessibilityEvent;
    }

    private AccessibilityEvent createEventForHost(int n10) {
        AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain((int)n10);
        this.mHost.onInitializeAccessibilityEvent(accessibilityEvent);
        return accessibilityEvent;
    }

    /*
     * WARNING - void declaration
     */
    private AccessibilityNodeInfoCompat createNodeForChild(int n10) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
        boolean bl2 = true;
        accessibilityNodeInfoCompat.setEnabled(bl2);
        accessibilityNodeInfoCompat.setFocusable(bl2);
        accessibilityNodeInfoCompat.setClassName(DEFAULT_CLASS_NAME);
        Object object = INVALID_PARENT_BOUNDS;
        accessibilityNodeInfoCompat.setBoundsInParent((Rect)object);
        accessibilityNodeInfoCompat.setBoundsInScreen((Rect)object);
        Object object2 = this.mHost;
        accessibilityNodeInfoCompat.setParent((View)object2);
        this.onPopulateNodeForVirtualView(n10, accessibilityNodeInfoCompat);
        object2 = accessibilityNodeInfoCompat.getText();
        if (object2 == null && (object2 = accessibilityNodeInfoCompat.getContentDescription()) == null) {
            RuntimeException runtimeException = new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            throw runtimeException;
        }
        object2 = this.mTempParentRect;
        accessibilityNodeInfoCompat.getBoundsInParent((Rect)object2);
        object2 = this.mTempParentRect;
        Object object3 = object2.equals(object);
        if (object3 == 0) {
            object3 = accessibilityNodeInfoCompat.getActions();
            int n11 = object3 & 0x40;
            if (n11 == 0) {
                n11 = 128;
                if ((object3 &= n11) == 0) {
                    boolean bl3;
                    View view;
                    Object object4;
                    void var1_4;
                    Object object5;
                    object2 = this.mHost.getContext().getPackageName();
                    accessibilityNodeInfoCompat.setPackageName((CharSequence)object2);
                    object2 = this.mHost;
                    accessibilityNodeInfoCompat.setSource((View)object2, n10);
                    object3 = this.mAccessibilityFocusedVirtualViewId;
                    if (object3 == n10) {
                        accessibilityNodeInfoCompat.setAccessibilityFocused(bl2);
                        accessibilityNodeInfoCompat.addAction(n11);
                    } else {
                        accessibilityNodeInfoCompat.setAccessibilityFocused(false);
                        object3 = 64;
                        accessibilityNodeInfoCompat.addAction((int)object3);
                    }
                    object3 = this.mKeyboardFocusedVirtualViewId;
                    if (object3 == n10) {
                        boolean bl4 = bl2;
                    } else {
                        boolean bl5 = false;
                        object5 = null;
                    }
                    if (var1_4 != false) {
                        object3 = 2;
                        accessibilityNodeInfoCompat.addAction((int)object3);
                    } else {
                        object3 = accessibilityNodeInfoCompat.isFocusable();
                        if (object3 != 0) {
                            accessibilityNodeInfoCompat.addAction((int)(bl2 ? 1 : 0));
                        }
                    }
                    accessibilityNodeInfoCompat.setFocused((boolean)var1_4);
                    object5 = this.mHost;
                    object2 = this.mTempGlobalRect;
                    object5.getLocationOnScreen((int[])object2);
                    object5 = this.mTempScreenRect;
                    accessibilityNodeInfoCompat.getBoundsInScreen((Rect)object5);
                    object5 = this.mTempScreenRect;
                    boolean bl6 = object5.equals(object);
                    if (bl6) {
                        object5 = this.mTempScreenRect;
                        accessibilityNodeInfoCompat.getBoundsInParent((Rect)object5);
                        int n12 = accessibilityNodeInfoCompat.mParentVirtualDescendantId;
                        object4 = -1;
                        if (n12 != object4) {
                            object5 = AccessibilityNodeInfoCompat.obtain();
                            object3 = accessibilityNodeInfoCompat.mParentVirtualDescendantId;
                            while (object3 != object4) {
                                view = this.mHost;
                                ((AccessibilityNodeInfoCompat)object5).setParent(view, (int)object4);
                                view = INVALID_PARENT_BOUNDS;
                                ((AccessibilityNodeInfoCompat)object5).setBoundsInParent((Rect)view);
                                this.onPopulateNodeForVirtualView((int)object3, (AccessibilityNodeInfoCompat)object5);
                                object2 = this.mTempParentRect;
                                ((AccessibilityNodeInfoCompat)object5).getBoundsInParent((Rect)object2);
                                object2 = this.mTempScreenRect;
                                view = this.mTempParentRect;
                                int n13 = view.left;
                                n11 = view.top;
                                object2.offset(n13, n11);
                                object3 = ((AccessibilityNodeInfoCompat)object5).mParentVirtualDescendantId;
                            }
                            ((AccessibilityNodeInfoCompat)object5).recycle();
                        }
                        object5 = this.mTempScreenRect;
                        object = this.mTempGlobalRect;
                        object4 = object[0];
                        object3 = this.mHost.getScrollX();
                        object4 -= object3;
                        object2 = this.mTempGlobalRect;
                        object3 = object2[bl2];
                        view = this.mHost;
                        n11 = view.getScrollY();
                        object5.offset(object4, object3 -= n11);
                    }
                    if (bl3 = (object5 = this.mHost).getLocalVisibleRect(object = this.mTempVisibleRect)) {
                        object5 = this.mTempVisibleRect;
                        object4 = this.mTempGlobalRect[0];
                        object3 = this.mHost.getScrollX();
                        object4 -= object3;
                        object2 = this.mTempGlobalRect;
                        object3 = object2[bl2];
                        view = this.mHost;
                        n11 = view.getScrollY();
                        object5.offset(object4, object3 -= n11);
                        object5 = this.mTempScreenRect;
                        object = this.mTempVisibleRect;
                        boolean bl7 = object5.intersect(object);
                        if (bl7) {
                            object5 = this.mTempScreenRect;
                            accessibilityNodeInfoCompat.setBoundsInScreen((Rect)object5);
                            object5 = this.mTempScreenRect;
                            boolean bl8 = this.isVisibleToUser((Rect)object5);
                            if (bl8) {
                                accessibilityNodeInfoCompat.setVisibleToUser(bl2);
                            }
                        }
                    }
                    return accessibilityNodeInfoCompat;
                }
                RuntimeException runtimeException = new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
                throw runtimeException;
            }
            RuntimeException runtimeException = new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            throw runtimeException;
        }
        RuntimeException runtimeException = new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        throw runtimeException;
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        Object object = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, (AccessibilityNodeInfoCompat)object);
        ArrayList arrayList = new ArrayList();
        this.getVisibleVirtualViews(arrayList);
        int n10 = ((AccessibilityNodeInfoCompat)object).getChildCount();
        if (n10 > 0 && (n10 = arrayList.size()) > 0) {
            object = new RuntimeException("Views cannot have both real and virtual children");
            throw object;
        }
        int n11 = arrayList.size();
        for (n10 = 0; n10 < n11; ++n10) {
            View view = this.mHost;
            Integer n12 = (Integer)arrayList.get(n10);
            int n13 = n12;
            ((AccessibilityNodeInfoCompat)object).addChild(view, n13);
        }
        return object;
    }

    private SparseArrayCompat getAllNodes() {
        int n10;
        ArrayList arrayList = new ArrayList();
        this.getVisibleVirtualViews(arrayList);
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            n10 = (Integer)arrayList.get(i10);
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.createNodeForChild(n10);
            Integer n11 = (Integer)arrayList.get(i10);
            int n12 = n11;
            sparseArrayCompat.put(n12, accessibilityNodeInfoCompat);
        }
        return sparseArrayCompat;
    }

    private void getBoundsInParent(int n10, Rect rect) {
        this.obtainAccessibilityNodeInfo(n10).getBoundsInParent(rect);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static Rect guessPreviouslyFocusedRect(View object, int n10, Rect rect) {
        void var2_3;
        void var1_2;
        int n11 = object.getWidth();
        int n12 = object.getHeight();
        int n13 = 17;
        if (var1_2 == n13) {
            var2_3.set(n11, 0, n11, n12);
            return var2_3;
        }
        n13 = 33;
        if (var1_2 == n13) {
            var2_3.set(0, n12, n11, n12);
            return var2_3;
        }
        n13 = 66;
        int n14 = -1;
        if (var1_2 == n13) {
            var2_3.set(n14, 0, n14, n12);
            return var2_3;
        }
        n12 = 130;
        if (var1_2 == n12) {
            var2_3.set(0, n14, n11, n14);
            return var2_3;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        throw illegalArgumentException;
    }

    private boolean isVisibleToUser(Rect rect) {
        int n10;
        boolean bl2 = false;
        if (rect != null && (n10 = rect.isEmpty()) == 0) {
            Object object;
            rect = this.mHost;
            n10 = rect.getWindowVisibility();
            if (n10 != 0) {
                return false;
            }
            rect = this.mHost.getParent();
            while ((object = rect instanceof View) != 0) {
                float f10 = (rect = (View)rect).getAlpha();
                float f11 = f10 - 0.0f;
                object = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
                if (object > 0 && (object = rect.getVisibility()) == 0) {
                    rect = rect.getParent();
                    continue;
                }
                return false;
            }
            if (rect != null) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private static int keyToDirection(int n10) {
        int n11 = 19;
        if (n10 != n11) {
            n11 = 21;
            if (n10 != n11) {
                n11 = 22;
                if (n10 != n11) {
                    return 130;
                }
                return 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean moveFocus(int n10, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        int n11;
        Object object;
        SparseArrayCompat sparseArrayCompat = this.getAllNodes();
        int n12 = this.mKeyboardFocusedVirtualViewId;
        int n13 = -1 << -1;
        if (n12 == n13) {
            n12 = 0;
            object = null;
        } else {
            object = (AccessibilityNodeInfoCompat)sparseArrayCompat.get(n12);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = object;
        n12 = 1;
        if (n10 != n12 && n10 != (n11 = 2)) {
            n12 = 17;
            if (n10 != n12 && n10 != (n12 = 33) && n10 != (n12 = 66) && n10 != (n12 = 130)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                throw illegalArgumentException;
            }
            Rect rect2 = new Rect();
            n12 = this.mKeyboardFocusedVirtualViewId;
            if (n12 != n13) {
                this.getBoundsInParent(n12, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                rect = this.mHost;
                ExploreByTouchHelper.guessPreviouslyFocusedRect((View)rect, n10, rect2);
            }
            FocusStrategy$CollectionAdapter focusStrategy$CollectionAdapter = SPARSE_VALUES_ADAPTER;
            FocusStrategy$BoundsAdapter focusStrategy$BoundsAdapter = NODE_ADAPTER;
            object = sparseArrayCompat;
            int n14 = n10;
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInAbsoluteDirection(sparseArrayCompat, focusStrategy$CollectionAdapter, focusStrategy$BoundsAdapter, accessibilityNodeInfoCompat2, rect2, n10);
        } else {
            int n15;
            rect = this.mHost;
            int n16 = ViewCompat.getLayoutDirection((View)rect);
            if (n16 == n12) {
                n15 = n12;
            } else {
                n16 = 0;
                rect = null;
                n15 = 0;
            }
            FocusStrategy$CollectionAdapter focusStrategy$CollectionAdapter = SPARSE_VALUES_ADAPTER;
            FocusStrategy$BoundsAdapter focusStrategy$BoundsAdapter = NODE_ADAPTER;
            object = sparseArrayCompat;
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInRelativeDirection(sparseArrayCompat, focusStrategy$CollectionAdapter, focusStrategy$BoundsAdapter, accessibilityNodeInfoCompat2, n10, n15 != 0, false);
        }
        if (accessibilityNodeInfoCompat != null) {
            n10 = sparseArrayCompat.indexOfValue(accessibilityNodeInfoCompat);
            n13 = sparseArrayCompat.keyAt(n10);
        }
        return this.requestKeyboardFocusForVirtualView(n13);
    }

    private boolean performActionForChild(int n10, int n11, Bundle bundle) {
        int n12 = 1;
        if (n11 != n12) {
            n12 = 2;
            if (n11 != n12) {
                n12 = 64;
                if (n11 != n12) {
                    n12 = 128;
                    if (n11 != n12) {
                        return this.onPerformActionForVirtualView(n10, n11, bundle);
                    }
                    return this.clearAccessibilityFocus(n10);
                }
                return this.requestAccessibilityFocus(n10);
            }
            return this.clearKeyboardFocusForVirtualView(n10);
        }
        return this.requestKeyboardFocusForVirtualView(n10);
    }

    private boolean performActionForHost(int n10, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHost, n10, bundle);
    }

    private boolean requestAccessibilityFocus(int n10) {
        AccessibilityManager accessibilityManager = this.mManager;
        int n11 = accessibilityManager.isEnabled();
        int n12 = 0;
        if (n11 != 0 && (n11 = (accessibilityManager = this.mManager).isTouchExplorationEnabled()) != 0 && (n11 = this.mAccessibilityFocusedVirtualViewId) != n10) {
            n12 = -1 << -1;
            if (n11 != n12) {
                this.clearAccessibilityFocus(n11);
            }
            this.mAccessibilityFocusedVirtualViewId = n10;
            this.mHost.invalidate();
            this.sendEventForVirtualView(n10, 32768);
            return true;
        }
        return false;
    }

    private void updateHoveredVirtualView(int n10) {
        int n11 = this.mHoveredVirtualViewId;
        if (n11 == n10) {
            return;
        }
        this.mHoveredVirtualViewId = n10;
        this.sendEventForVirtualView(n10, 128);
        this.sendEventForVirtualView(n11, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int n10) {
        int n11 = this.mKeyboardFocusedVirtualViewId;
        if (n11 != n10) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = -1 << -1;
        this.onVirtualViewKeyboardFocusChanged(n10, false);
        this.sendEventForVirtualView(n10, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        AccessibilityManager accessibilityManager = this.mManager;
        int n10 = accessibilityManager.isEnabled();
        boolean bl2 = false;
        if (n10 != 0 && (n10 = (accessibilityManager = this.mManager).isTouchExplorationEnabled()) != 0) {
            n10 = motionEvent.getAction();
            int n11 = 7;
            boolean bl3 = true;
            int n12 = -1 << -1;
            if (n10 != n11 && n10 != (n11 = 9)) {
                int n13 = 10;
                float f10 = 1.4E-44f;
                if (n10 != n13) {
                    return false;
                }
                n13 = this.mHoveredVirtualViewId;
                if (n13 != n12) {
                    this.updateHoveredVirtualView(n12);
                    return bl3;
                }
                return false;
            }
            float f11 = motionEvent.getX();
            float f12 = motionEvent.getY();
            int n14 = this.getVirtualViewAt(f11, f12);
            this.updateHoveredVirtualView(n14);
            if (n14 != n12) {
                bl2 = bl3;
            }
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int n10;
        int n11 = keyEvent.getAction();
        int n12 = 0;
        int n13 = 1;
        float f10 = Float.MIN_VALUE;
        if (n11 == n13) return n12 != 0;
        n11 = keyEvent.getKeyCode();
        if (n11 != (n10 = 61)) {
            n10 = 66;
            if (n11 != n10) {
                switch (n11) {
                    default: {
                        return n12 != 0;
                    }
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: {
                        n10 = (int)(keyEvent.hasNoModifiers() ? 1 : 0);
                        if (n10 == 0) return n12 != 0;
                        n11 = ExploreByTouchHelper.keyToDirection(n11);
                        int n14 = keyEvent.getRepeatCount() + n13;
                        n10 = 0;
                        while (n12 < n14) {
                            boolean bl2 = this.moveFocus(n11, null);
                            if (!bl2) return n10 != 0;
                            ++n12;
                            n10 = n13;
                        }
                        return n10 != 0;
                    }
                    case 23: 
                }
            }
            if ((n11 = (int)(keyEvent.hasNoModifiers() ? 1 : 0)) == 0) return n12 != 0;
            int n15 = keyEvent.getRepeatCount();
            if (n15 != 0) return n12 != 0;
            this.clickKeyboardFocusedVirtualView();
            return n13 != 0;
        }
        n11 = (int)(keyEvent.hasNoModifiers() ? 1 : 0);
        if (n11 != 0) {
            int n16 = 2;
            return this.moveFocus(n16, null) != 0;
        }
        boolean bl3 = keyEvent.hasModifiers(n13);
        if (!bl3) return n12 != 0;
        return this.moveFocus(n13, null) != 0;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View object) {
        object = this.mNodeProvider;
        if (object == null) {
            object = new ExploreByTouchHelper$MyNodeProvider(this);
            this.mNodeProvider = object;
        }
        return this.mNodeProvider;
    }

    public int getFocusedVirtualView() {
        return this.getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public abstract int getVirtualViewAt(float var1, float var2);

    public abstract void getVisibleVirtualViews(List var1);

    public final void invalidateRoot() {
        this.invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int n10) {
        this.invalidateVirtualView(n10, 0);
    }

    public final void invalidateVirtualView(int n10, int n11) {
        AccessibilityManager accessibilityManager;
        int n12 = -1 << -1;
        if (n10 != n12 && (n12 = (int)((accessibilityManager = this.mManager).isEnabled() ? 1 : 0)) != 0 && (accessibilityManager = this.mHost.getParent()) != null) {
            int n13 = 2048;
            AccessibilityEvent accessibilityEvent = this.createEvent(n10, n13);
            AccessibilityEventCompat.setContentChangeTypes(accessibilityEvent, n11);
            View view = this.mHost;
            accessibilityManager.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int n10) {
        int n11 = -1;
        if (n10 == n11) {
            return this.createNodeForHost();
        }
        return this.createNodeForChild(n10);
    }

    public final void onFocusChanged(boolean bl2, int n10, Rect rect) {
        int n11 = this.mKeyboardFocusedVirtualViewId;
        int n12 = -1 << -1;
        if (n11 != n12) {
            this.clearKeyboardFocusForVirtualView(n11);
        }
        if (bl2) {
            this.moveFocus(n10, rect);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        this.onPopulateEventForHost(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        this.onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    public abstract boolean onPerformActionForVirtualView(int var1, int var2, Bundle var3);

    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateEventForVirtualView(int n10, AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public abstract void onPopulateNodeForVirtualView(int var1, AccessibilityNodeInfoCompat var2);

    public void onVirtualViewKeyboardFocusChanged(int n10, boolean bl2) {
    }

    public boolean performAction(int n10, int n11, Bundle bundle) {
        int n12 = -1;
        if (n10 != n12) {
            return this.performActionForChild(n10, n11, bundle);
        }
        return this.performActionForHost(n11, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int n10) {
        View view = this.mHost;
        int n11 = view.isFocused();
        if (!n11 && !(n11 = (int)((view = this.mHost).requestFocus() ? 1 : 0))) {
            return false;
        }
        n11 = this.mKeyboardFocusedVirtualViewId;
        if (n11 == n10) {
            return false;
        }
        int n12 = -1 << -1;
        if (n11 != n12) {
            this.clearKeyboardFocusForVirtualView(n11);
        }
        if (n10 == n12) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = n10;
        n11 = 1;
        this.onVirtualViewKeyboardFocusChanged(n10, n11 != 0);
        this.sendEventForVirtualView(n10, 8);
        return n11 != 0;
    }

    public final boolean sendEventForVirtualView(int n10, int n11) {
        AccessibilityManager accessibilityManager;
        int n12 = -1 << -1;
        if (n10 != n12 && (n12 = (int)((accessibilityManager = this.mManager).isEnabled() ? 1 : 0)) != 0) {
            accessibilityManager = this.mHost.getParent();
            if (accessibilityManager == null) {
                return false;
            }
            AccessibilityEvent accessibilityEvent = this.createEvent(n10, n11);
            View view = this.mHost;
            return accessibilityManager.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }
}

