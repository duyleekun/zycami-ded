/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityWindowInfo
 */
package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = 255;
    private Object mInfo;

    private AccessibilityWindowInfoCompat(Object object) {
        this.mInfo = object;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfo.obtain());
        }
        return null;
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        int n10 = Build.VERSION.SDK_INT;
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat2 = null;
        int n11 = 21;
        if (n10 >= n11 && accessibilityWindowInfoCompat != null) {
            accessibilityWindowInfoCompat = AccessibilityWindowInfo.obtain((AccessibilityWindowInfo)((AccessibilityWindowInfo)accessibilityWindowInfoCompat.mInfo));
            accessibilityWindowInfoCompat2 = AccessibilityWindowInfoCompat.wrapNonNullInstance(accessibilityWindowInfoCompat);
        }
        return accessibilityWindowInfoCompat2;
    }

    private static String typeToString(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        return "<UNKNOWN>";
                    }
                    return "TYPE_ACCESSIBILITY_OVERLAY";
                }
                return "TYPE_SYSTEM";
            }
            return "TYPE_INPUT_METHOD";
        }
        return "TYPE_APPLICATION";
    }

    public static AccessibilityWindowInfoCompat wrapNonNullInstance(Object object) {
        if (object != null) {
            AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = new AccessibilityWindowInfoCompat(object);
            return accessibilityWindowInfoCompat;
        }
        return null;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        if (object == null) {
            return false;
        }
        boolean bl4 = object instanceof AccessibilityWindowInfoCompat;
        if (!bl4) {
            return false;
        }
        object = (AccessibilityWindowInfoCompat)object;
        Object object2 = this.mInfo;
        if (object2 == null ? (object = ((AccessibilityWindowInfoCompat)object).mInfo) != null : !(bl2 = object2.equals(object = ((AccessibilityWindowInfoCompat)object).mInfo))) {
            return false;
        }
        return bl3;
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getAnchor());
        }
        return null;
    }

    public void getBoundsInScreen(Rect rect) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            AccessibilityWindowInfo accessibilityWindowInfo = (AccessibilityWindowInfo)this.mInfo;
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }
    }

    public AccessibilityWindowInfoCompat getChild(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return AccessibilityWindowInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getChild(n10));
        }
        return null;
    }

    public int getChildCount() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityWindowInfo)this.mInfo).getChildCount();
        }
        return 0;
    }

    public int getId() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityWindowInfo)this.mInfo).getId();
        }
        return -1;
    }

    public int getLayer() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityWindowInfo)this.mInfo).getLayer();
        }
        return -1;
    }

    public AccessibilityWindowInfoCompat getParent() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return AccessibilityWindowInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getParent());
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getRoot() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getRoot());
        }
        return null;
    }

    public CharSequence getTitle() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return ((AccessibilityWindowInfo)this.mInfo).getTitle();
        }
        return null;
    }

    public int getType() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityWindowInfo)this.mInfo).getType();
        }
        return -1;
    }

    public int hashCode() {
        int n10;
        Object object = this.mInfo;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        return n10;
    }

    public boolean isAccessibilityFocused() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityWindowInfo)this.mInfo).isAccessibilityFocused();
        }
        return true;
    }

    public boolean isActive() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityWindowInfo)this.mInfo).isActive();
        }
        return true;
    }

    public boolean isFocused() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityWindowInfo)this.mInfo).isFocused();
        }
        return true;
    }

    public void recycle() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            AccessibilityWindowInfo accessibilityWindowInfo = (AccessibilityWindowInfo)this.mInfo;
            accessibilityWindowInfo.recycle();
        }
    }

    /*
     * WARNING - void declaration
     */
    public String toString() {
        boolean bl2;
        void var5_12;
        StringBuilder stringBuilder = new StringBuilder();
        Object object = new Rect();
        this.getBoundsInScreen((Rect)object);
        stringBuilder.append("AccessibilityWindowInfo[");
        stringBuilder.append("id=");
        int bl22 = this.getId();
        stringBuilder.append(bl22);
        stringBuilder.append(", type=");
        String string2 = AccessibilityWindowInfoCompat.typeToString(this.getType());
        stringBuilder.append(string2);
        stringBuilder.append(", layer=");
        int n10 = this.getLayer();
        stringBuilder.append(n10);
        string2 = ", bounds=";
        stringBuilder.append(string2);
        stringBuilder.append(object);
        stringBuilder.append(", focused=");
        boolean bl3 = this.isFocused();
        stringBuilder.append(bl3);
        stringBuilder.append(", active=");
        boolean bl4 = this.isActive();
        stringBuilder.append(bl4);
        stringBuilder.append(", hasParent=");
        object = this.getParent();
        boolean bl5 = true;
        if (object != null) {
            boolean bl6 = bl5;
        } else {
            boolean bl7 = false;
            object = null;
        }
        stringBuilder.append((boolean)var5_12);
        object = ", hasChildren=";
        stringBuilder.append((String)object);
        int n11 = this.getChildCount();
        if (n11 <= 0) {
            bl2 = false;
            string2 = null;
        }
        stringBuilder.append(bl2);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

