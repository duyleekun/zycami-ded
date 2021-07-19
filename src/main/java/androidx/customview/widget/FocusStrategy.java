/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package androidx.customview.widget;

import android.graphics.Rect;
import androidx.customview.widget.FocusStrategy$BoundsAdapter;
import androidx.customview.widget.FocusStrategy$CollectionAdapter;
import androidx.customview.widget.FocusStrategy$SequentialComparator;
import java.util.ArrayList;
import java.util.Collections;

public class FocusStrategy {
    private FocusStrategy() {
    }

    private static boolean beamBeats(int n10, Rect rect, Rect rect2, Rect rect3) {
        int n11 = FocusStrategy.beamsOverlap(n10, rect, rect2);
        boolean bl2 = FocusStrategy.beamsOverlap(n10, rect, rect3);
        boolean bl3 = false;
        if (!bl2 && n11 != 0) {
            n11 = FocusStrategy.isToDirectionOf(n10, rect, rect3);
            bl2 = true;
            if (n11 == 0) {
                return bl2;
            }
            n11 = 17;
            if (n10 != n11 && n10 != (n11 = 66)) {
                int n12 = FocusStrategy.majorAxisDistance(n10, rect, rect2);
                if (n12 < (n10 = FocusStrategy.majorAxisDistanceToFarEdge(n10, rect, rect3))) {
                    bl3 = bl2;
                }
                return bl3;
            }
            return bl2;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private static boolean beamsOverlap(int var0, Rect var1_1, Rect var2_2) {
        var3_3 = 17;
        var4_4 = true;
        if (var0 != var3_3) {
            var3_3 = 33;
            if (var0 != var3_3) {
                var3_3 = 66;
                if (var0 != var3_3) {
                    var3_3 = 130;
                    if (var0 != var3_3) {
                        var5_5 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        throw var5_5;
                    } else {
                        ** GOTO lbl-1000
                    }
                }
            } else lbl-1000:
            // 3 sources

            {
                if ((var0 = var2_2.right) < (var3_3 = var1_1.left) || (var0 = var2_2.left) > (var6_6 = var1_1.right)) {
                    var4_4 = false;
                }
                return var4_4;
            }
        }
        if ((var0 = var2_2.bottom) < (var3_3 = var1_1.top) || (var0 = var2_2.top) > (var6_7 = var1_1.bottom)) {
            var4_4 = false;
        }
        return var4_4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Object findNextFocusInAbsoluteDirection(Object object, FocusStrategy$CollectionAdapter focusStrategy$CollectionAdapter, FocusStrategy$BoundsAdapter focusStrategy$BoundsAdapter, Object object2, Rect rect, int n10) {
        int n11;
        int n12;
        Rect rect2;
        block9: {
            block10: {
                rect2 = new Rect(rect);
                n12 = 17;
                n11 = 0;
                if (n10 == n12) break block10;
                n12 = 33;
                if (n10 != n12) {
                    n12 = 66;
                    if (n10 != n12) {
                        n12 = 130;
                        if (n10 != n12) {
                            object = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                            throw object;
                        }
                        n12 = -(rect.height() + 1);
                        rect2.offset(0, n12);
                        break block9;
                    } else {
                        n12 = -(rect.width() + 1);
                        rect2.offset(n12, 0);
                    }
                    break block9;
                } else {
                    n12 = rect.height() + 1;
                    rect2.offset(0, n12);
                }
                break block9;
            }
            n12 = rect.width() + 1;
            rect2.offset(n12, 0);
        }
        n12 = 0;
        Object object3 = null;
        int n13 = focusStrategy$CollectionAdapter.size(object);
        Rect rect3 = new Rect();
        while (n11 < n13) {
            Object object4 = focusStrategy$CollectionAdapter.get(object, n11);
            if (object4 != object2) {
                focusStrategy$BoundsAdapter.obtainBounds(object4, rect3);
                boolean bl2 = FocusStrategy.isBetterCandidate(n10, rect, rect3, rect2);
                if (bl2) {
                    rect2.set(rect3);
                    object3 = object4;
                }
            }
            ++n11;
        }
        return object3;
    }

    public static Object findNextFocusInRelativeDirection(Object object, FocusStrategy$CollectionAdapter focusStrategy$CollectionAdapter, FocusStrategy$BoundsAdapter focusStrategy$BoundsAdapter, Object object2, int n10, boolean bl2, boolean bl3) {
        int n11 = focusStrategy$CollectionAdapter.size(object);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object3 = focusStrategy$CollectionAdapter.get(object, i10);
            arrayList.add(object3);
        }
        object = new FocusStrategy$SequentialComparator(bl2, focusStrategy$BoundsAdapter);
        Collections.sort(arrayList, object);
        int n12 = 1;
        if (n10 != n12) {
            n12 = 2;
            if (n10 == n12) {
                return FocusStrategy.getNextFocusable(object2, arrayList, bl3);
            }
            object = new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            throw object;
        }
        return FocusStrategy.getPreviousFocusable(object2, arrayList, bl3);
    }

    private static Object getNextFocusable(Object object, ArrayList arrayList, boolean bl2) {
        int n10 = arrayList.size();
        int n11 = object == null ? -1 : arrayList.lastIndexOf(object);
        if (++n11 < n10) {
            return arrayList.get(n11);
        }
        if (bl2 && n10 > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    private static Object getPreviousFocusable(Object object, ArrayList arrayList, boolean bl2) {
        int n10 = arrayList.size();
        int n11 = object == null ? n10 : arrayList.indexOf(object);
        if ((n11 += -1) >= 0) {
            return arrayList.get(n11);
        }
        if (bl2 && n10 > 0) {
            return arrayList.get(n10 += -1);
        }
        return null;
    }

    private static int getWeightedDistanceFor(int n10, int n11) {
        int n12 = n10 * 13 * n10;
        n11 *= n11;
        return n12 + n11;
    }

    private static boolean isBetterCandidate(int n10, Rect rect, Rect rect2, Rect rect3) {
        int n11 = FocusStrategy.isCandidate(rect, rect2, n10);
        boolean bl2 = false;
        if (n11 == 0) {
            return false;
        }
        n11 = FocusStrategy.isCandidate(rect, rect3, n10);
        boolean bl3 = true;
        if (n11 == 0) {
            return bl3;
        }
        n11 = FocusStrategy.beamBeats(n10, rect, rect2, rect3);
        if (n11 != 0) {
            return bl3;
        }
        n11 = FocusStrategy.beamBeats(n10, rect, rect3, rect2);
        if (n11 != 0) {
            return false;
        }
        n11 = FocusStrategy.majorAxisDistance(n10, rect, rect2);
        int n12 = FocusStrategy.minorAxisDistance(n10, rect, rect2);
        n12 = FocusStrategy.getWeightedDistanceFor(n11, n12);
        n11 = FocusStrategy.majorAxisDistance(n10, rect, rect3);
        n10 = FocusStrategy.minorAxisDistance(n10, rect, rect3);
        if (n12 < (n10 = FocusStrategy.getWeightedDistanceFor(n11, n10))) {
            bl2 = bl3;
        }
        return bl2;
    }

    private static boolean isCandidate(Rect object, Rect rect, int n10) {
        int n11;
        int n12;
        int n13 = 17;
        boolean bl2 = true;
        if (n10 != n13) {
            int n14;
            int n15;
            n13 = 33;
            if (n10 != n13) {
                int n16;
                int n17;
                n13 = 66;
                if (n10 != n13) {
                    n13 = 130;
                    if (n10 == n13) {
                        int n18;
                        int n19;
                        n10 = object.top;
                        n13 = rect.top;
                        if (n10 >= n13 && (n10 = object.bottom) > n13 || (n19 = object.bottom) >= (n18 = rect.bottom)) {
                            bl2 = false;
                        }
                        return bl2;
                    }
                    object = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw object;
                }
                n10 = object.left;
                n13 = rect.left;
                if (n10 >= n13 && (n10 = object.right) > n13 || (n17 = object.right) >= (n16 = rect.right)) {
                    bl2 = false;
                }
                return bl2;
            }
            n10 = object.bottom;
            n13 = rect.bottom;
            if (n10 <= n13 && (n10 = object.top) < n13 || (n15 = object.top) <= (n14 = rect.top)) {
                bl2 = false;
            }
            return bl2;
        }
        n10 = object.right;
        n13 = rect.right;
        if (n10 <= n13 && (n10 = object.left) < n13 || (n12 = object.left) <= (n11 = rect.left)) {
            bl2 = false;
        }
        return bl2;
    }

    private static boolean isToDirectionOf(int n10, Rect rect, Rect rect2) {
        int n11 = 17;
        boolean bl2 = true;
        if (n10 != n11) {
            n11 = 33;
            if (n10 != n11) {
                n11 = 66;
                if (n10 != n11) {
                    n11 = 130;
                    if (n10 == n11) {
                        n10 = rect.bottom;
                        int n12 = rect2.top;
                        if (n10 > n12) {
                            bl2 = false;
                        }
                        return bl2;
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw illegalArgumentException;
                }
                n10 = rect.right;
                int n13 = rect2.left;
                if (n10 > n13) {
                    bl2 = false;
                }
                return bl2;
            }
            n10 = rect.top;
            int n14 = rect2.bottom;
            if (n10 < n14) {
                bl2 = false;
            }
            return bl2;
        }
        n10 = rect.left;
        int n15 = rect2.right;
        if (n10 < n15) {
            bl2 = false;
        }
        return bl2;
    }

    private static int majorAxisDistance(int n10, Rect rect, Rect rect2) {
        n10 = FocusStrategy.majorAxisDistanceRaw(n10, rect, rect2);
        return Math.max(0, n10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int majorAxisDistanceRaw(int n10, Rect rect, Rect rect2) {
        int n11;
        int n12 = 17;
        if (n10 != n12) {
            n12 = 33;
            if (n10 != n12) {
                n12 = 66;
                if (n10 != n12) {
                    n12 = 130;
                    if (n10 == n12) {
                        n10 = rect2.top;
                        n11 = rect.bottom;
                        return n10 - n11;
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw illegalArgumentException;
                }
                n10 = rect2.left;
                n11 = rect.right;
                return n10 - n11;
            }
            n10 = rect.top;
            n11 = rect2.bottom;
            return n10 - n11;
        }
        n10 = rect.left;
        n11 = rect2.right;
        return n10 - n11;
    }

    private static int majorAxisDistanceToFarEdge(int n10, Rect rect, Rect rect2) {
        n10 = FocusStrategy.majorAxisDistanceToFarEdgeRaw(n10, rect, rect2);
        return Math.max(1, n10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int majorAxisDistanceToFarEdgeRaw(int n10, Rect rect, Rect rect2) {
        int n11;
        int n12 = 17;
        if (n10 != n12) {
            n12 = 33;
            if (n10 != n12) {
                n12 = 66;
                if (n10 != n12) {
                    n12 = 130;
                    if (n10 == n12) {
                        n10 = rect2.bottom;
                        n11 = rect.bottom;
                        return n10 - n11;
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw illegalArgumentException;
                }
                n10 = rect2.right;
                n11 = rect.right;
                return n10 - n11;
            }
            n10 = rect.top;
            n11 = rect2.top;
            return n10 - n11;
        }
        n10 = rect.left;
        n11 = rect2.left;
        return n10 - n11;
    }

    /*
     * Unable to fully structure code
     */
    private static int minorAxisDistance(int var0, Rect var1_1, Rect var2_2) {
        var3_3 = 17;
        if (var0 != var3_3) {
            var3_3 = 33;
            if (var0 != var3_3) {
                var3_3 = 66;
                if (var0 != var3_3) {
                    var3_3 = 130;
                    if (var0 != var3_3) {
                        var4_4 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        throw var4_4;
                    } else {
                        ** GOTO lbl-1000
                    }
                }
            } else lbl-1000:
            // 3 sources

            {
                var0 = var1_1.left;
                var5_5 = var1_1.width() / 2;
                var0 += var5_5;
                var5_5 = var2_2.left;
                var6_7 = var2_2.width() / 2;
                return Math.abs(var0 - (var5_5 += var6_7));
            }
        }
        var0 = var1_1.top;
        var5_6 = var1_1.height() / 2;
        var0 += var5_6;
        var5_6 = var2_2.top;
        var6_8 = var2_2.height() / 2;
        return Math.abs(var0 - (var5_6 += var6_8));
    }
}

