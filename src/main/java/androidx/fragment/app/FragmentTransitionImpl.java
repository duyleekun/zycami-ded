/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl$1;
import androidx.fragment.app.FragmentTransitionImpl$2;
import androidx.fragment.app.FragmentTransitionImpl$3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class FragmentTransitionImpl {
    public static void bfsAddViewChildren(List list, View view) {
        int n10 = list.size();
        int n11 = FragmentTransitionImpl.containedBeforeIndex(list, view, n10);
        if (n11 != 0) {
            return;
        }
        String string2 = ViewCompat.getTransitionName(view);
        if (string2 != null) {
            list.add(view);
        }
        for (int i10 = n10; i10 < (n11 = list.size()); ++i10) {
            string2 = (View)list.get(i10);
            int n12 = string2 instanceof ViewGroup;
            if (n12 == 0) continue;
            string2 = (ViewGroup)string2;
            n12 = string2.getChildCount();
            for (int i11 = 0; i11 < n12; ++i11) {
                String string3;
                View view2 = string2.getChildAt(i11);
                boolean bl2 = FragmentTransitionImpl.containedBeforeIndex(list, view2, n10);
                if (bl2 || (string3 = ViewCompat.getTransitionName(view2)) == null) continue;
                list.add(view2);
            }
        }
    }

    private static boolean containedBeforeIndex(List list, View view, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            Object e10 = list.get(i10);
            if (e10 != view) continue;
            return true;
        }
        return false;
    }

    public static String findKeyForValue(Map object, String string2) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object v10 = entry.getValue();
            boolean bl3 = string2.equals(v10);
            if (!bl3) continue;
            return (String)entry.getKey();
        }
        return null;
    }

    public static boolean isNullOrEmpty(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            bl2 = false;
            list = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public abstract void addTarget(Object var1, View var2);

    public abstract void addTargets(Object var1, ArrayList var2);

    public abstract void beginDelayedTransition(ViewGroup var1, Object var2);

    public abstract boolean canHandle(Object var1);

    public void captureTransitioningViews(ArrayList arrayList, View view) {
        int n10 = view.getVisibility();
        if (n10 == 0) {
            n10 = view instanceof ViewGroup;
            if (n10 != 0) {
                n10 = (int)(ViewGroupCompat.isTransitionGroup((ViewGroup)(view = (ViewGroup)view)) ? 1 : 0);
                if (n10 != 0) {
                    arrayList.add(view);
                } else {
                    n10 = view.getChildCount();
                    for (int i10 = 0; i10 < n10; ++i10) {
                        View view2 = view.getChildAt(i10);
                        this.captureTransitioningViews(arrayList, view2);
                    }
                }
            } else {
                arrayList.add(view);
            }
        }
    }

    public abstract Object cloneTransition(Object var1);

    public void findNamedViews(Map map, View view) {
        int n10 = view.getVisibility();
        if (n10 == 0) {
            String string2 = ViewCompat.getTransitionName(view);
            if (string2 != null) {
                map.put(string2, view);
            }
            if ((n10 = view instanceof ViewGroup) != 0) {
                view = (ViewGroup)view;
                n10 = view.getChildCount();
                for (int i10 = 0; i10 < n10; ++i10) {
                    View view2 = view.getChildAt(i10);
                    this.findNamedViews(map, view2);
                }
            }
        }
    }

    public void getBoundsOnScreen(View view, Rect rect) {
        int n10 = ViewCompat.isAttachedToWindow(view);
        if (n10 == 0) {
            return;
        }
        RectF rectF = new RectF();
        float f10 = view.getWidth();
        float f11 = view.getHeight();
        int n11 = 0;
        float f12 = 0.0f;
        rectF.set(0.0f, 0.0f, f10, f11);
        view.getMatrix().mapRect(rectF);
        int n12 = view.getLeft();
        f10 = n12;
        int n13 = view.getTop();
        f11 = n13;
        rectF.offset(f10, f11);
        Object object = view.getParent();
        while ((n13 = object instanceof View) != 0) {
            object = (View)object;
            f11 = -object.getScrollX();
            f12 = -object.getScrollY();
            rectF.offset(f11, f12);
            Matrix matrix = object.getMatrix();
            matrix.mapRect(rectF);
            n13 = object.getLeft();
            f11 = n13;
            n11 = object.getTop();
            f12 = n11;
            rectF.offset(f11, f12);
            object = object.getParent();
        }
        object = new int[2];
        view.getRootView().getLocationOnScreen((int[])object);
        float f13 = (float)object[0];
        f10 = (float)object[1];
        rectF.offset(f13, f10);
        int n14 = Math.round(rectF.left);
        n12 = Math.round(rectF.top);
        n13 = Math.round(rectF.right);
        n10 = Math.round(rectF.bottom);
        rect.set(n14, n12, n13, n10);
    }

    public abstract Object mergeTransitionsInSequence(Object var1, Object var2, Object var3);

    public abstract Object mergeTransitionsTogether(Object var1, Object var2, Object var3);

    public ArrayList prepareSetNameOverridesReordered(ArrayList arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<String>();
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = (View)arrayList.get(i10);
            String string2 = ViewCompat.getTransitionName(view);
            arrayList2.add(string2);
            string2 = null;
            ViewCompat.setTransitionName(view, null);
        }
        return arrayList2;
    }

    public abstract void removeTarget(Object var1, View var2);

    public abstract void replaceTargets(Object var1, ArrayList var2, ArrayList var3);

    public abstract void scheduleHideFragmentView(Object var1, View var2, ArrayList var3);

    public void scheduleNameReset(ViewGroup viewGroup, ArrayList arrayList, Map map) {
        FragmentTransitionImpl$3 fragmentTransitionImpl$3 = new FragmentTransitionImpl$3(this, arrayList, map);
        OneShotPreDrawListener.add((View)viewGroup, fragmentTransitionImpl$3);
    }

    public abstract void scheduleRemoveTargets(Object var1, Object var2, ArrayList var3, Object var4, ArrayList var5, Object var6, ArrayList var7);

    public abstract void setEpicenter(Object var1, Rect var2);

    public abstract void setEpicenter(Object var1, View var2);

    public void setListenerForTransitionEnd(Fragment fragment, Object object, CancellationSignal cancellationSignal, Runnable runnable) {
        runnable.run();
    }

    public void setNameOverridesOrdered(View view, ArrayList arrayList, Map map) {
        FragmentTransitionImpl$2 fragmentTransitionImpl$2 = new FragmentTransitionImpl$2(this, arrayList, map);
        OneShotPreDrawListener.add(view, fragmentTransitionImpl$2);
    }

    public void setNameOverridesReordered(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map object) {
        Object object2;
        Object object3;
        int n10 = arrayList2.size();
        ArrayList<Object> arrayList4 = new ArrayList<Object>();
        block0: for (int i10 = 0; i10 < n10; ++i10) {
            object3 = (View)arrayList.get(i10);
            object2 = ViewCompat.getTransitionName((View)object3);
            arrayList4.add(object2);
            if (object2 == null) continue;
            ViewCompat.setTransitionName((View)object3, null);
            object3 = (String)object.get(object2);
            for (int i11 = 0; i11 < n10; ++i11) {
                Object e10 = arrayList3.get(i11);
                boolean bl2 = ((String)object3).equals(e10);
                if (!bl2) continue;
                object3 = (View)arrayList2.get(i11);
                ViewCompat.setTransitionName((View)object3, (String)object2);
                continue block0;
            }
        }
        object3 = arrayList2;
        object2 = arrayList3;
        object = new FragmentTransitionImpl$1(this, n10, arrayList2, arrayList3, arrayList, arrayList4);
        OneShotPreDrawListener.add(view, (Runnable)object);
    }

    public abstract void setSharedElementTargets(Object var1, View var2, ArrayList var3);

    public abstract void swapSharedElementTargets(Object var1, ArrayList var2, ArrayList var3);

    public abstract Object wrapTransitionInSet(Object var1);
}

