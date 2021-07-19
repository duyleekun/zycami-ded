/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package androidx.core.view;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.R$id;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewCompat$OnUnhandledKeyEventListenerCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class ViewCompat$UnhandledKeyEventManager {
    private static final ArrayList sViewsWithListeners;
    private SparseArray mCapturedKeys = null;
    private WeakReference mLastDispatchedPreViewKeyEvent = null;
    private WeakHashMap mViewsContainingListeners = null;

    static {
        ArrayList arrayList;
        sViewsWithListeners = arrayList = new ArrayList();
    }

    public static ViewCompat$UnhandledKeyEventManager at(View view) {
        int n10 = R$id.tag_unhandled_key_event_manager;
        ViewCompat$UnhandledKeyEventManager viewCompat$UnhandledKeyEventManager = (ViewCompat$UnhandledKeyEventManager)view.getTag(n10);
        if (viewCompat$UnhandledKeyEventManager == null) {
            viewCompat$UnhandledKeyEventManager = new ViewCompat$UnhandledKeyEventManager();
            view.setTag(n10, (Object)viewCompat$UnhandledKeyEventManager);
        }
        return viewCompat$UnhandledKeyEventManager;
    }

    private View dispatchInOrder(View view, KeyEvent keyEvent) {
        boolean bl2;
        WeakHashMap weakHashMap = this.mViewsContainingListeners;
        if (weakHashMap != null && (bl2 = weakHashMap.containsKey(view))) {
            boolean bl3;
            bl2 = view instanceof ViewGroup;
            if (bl2) {
                weakHashMap = view;
                weakHashMap = (ViewGroup)view;
                for (int i10 = weakHashMap.getChildCount() + -1; i10 >= 0; i10 += -1) {
                    View view2 = weakHashMap.getChildAt(i10);
                    if ((view2 = this.dispatchInOrder(view2, keyEvent)) == null) continue;
                    return view2;
                }
            }
            if (bl3 = this.onUnhandledKeyEvent(view, keyEvent)) {
                return view;
            }
        }
        return null;
    }

    private SparseArray getCapturedKeys() {
        SparseArray sparseArray = this.mCapturedKeys;
        if (sparseArray == null) {
            this.mCapturedKeys = sparseArray = new SparseArray();
        }
        return this.mCapturedKeys;
    }

    private boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        int n10 = R$id.tag_unhandled_key_listeners;
        ArrayList arrayList = (ArrayList)view.getTag(n10);
        if (arrayList != null) {
            int n11 = arrayList.size();
            int n12 = 1;
            n11 -= n12;
            while (n11 >= 0) {
                ViewCompat$OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat = (ViewCompat$OnUnhandledKeyEventListenerCompat)arrayList.get(n11);
                boolean bl2 = viewCompat$OnUnhandledKeyEventListenerCompat.onUnhandledKeyEvent(view, keyEvent);
                if (bl2) {
                    return n12 != 0;
                }
                n11 += -1;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void recalcViewsWithUnhandled() {
        int n10;
        Boolean bl2 = Boolean.TRUE;
        Object object = this.mViewsContainingListeners;
        if (object != null) {
            ((WeakHashMap)object).clear();
        }
        if ((n10 = ((ArrayList)(object = sViewsWithListeners)).isEmpty()) != 0) {
            return;
        }
        synchronized (object) {
            WeakHashMap weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap == null) {
                this.mViewsContainingListeners = weakHashMap = new WeakHashMap();
            }
            n10 = ((ArrayList)object).size() + -1;
            while (n10 >= 0) {
                Object object2 = sViewsWithListeners;
                Object object3 = ((ArrayList)object2).get(n10);
                object3 = (WeakReference)object3;
                object3 = ((Reference)object3).get();
                if ((object3 = (View)object3) == null) {
                    ((ArrayList)object2).remove(n10);
                } else {
                    boolean bl3;
                    object2 = this.mViewsContainingListeners;
                    ((WeakHashMap)object2).put(object3, bl2);
                    object2 = object3.getParent();
                    while (bl3 = object2 instanceof View) {
                        object3 = this.mViewsContainingListeners;
                        Object object4 = object2;
                        object4 = (View)object2;
                        ((WeakHashMap)object3).put((Object)object4, (Boolean)bl2);
                        object2 = ((ViewParent)object2).getParent();
                    }
                }
                n10 += -1;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void registerListeningView(View view) {
        ArrayList arrayList = sViewsWithListeners;
        synchronized (arrayList) {
            Object object;
            Object object2 = arrayList.iterator();
            do {
                boolean bl2;
                if (!(bl2 = object2.hasNext())) {
                    object2 = sViewsWithListeners;
                    object = new Object((View)view);
                    ((ArrayList)object2).add(object);
                    return;
                }
                object = object2.next();
                object = (WeakReference)object;
            } while ((object = ((Reference)object).get()) != view);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void unregisterListeningView(View view) {
        ArrayList arrayList = sViewsWithListeners;
        synchronized (arrayList) {
            int n10 = 0;
            ArrayList arrayList2;
            int n11;
            while (n10 < (n11 = (arrayList2 = sViewsWithListeners).size())) {
                Object object = arrayList2.get(n10);
                object = (WeakReference)object;
                if ((object = ((Reference)object).get()) == view) {
                    arrayList2.remove(n10);
                    return;
                }
                ++n10;
            }
            return;
        }
    }

    public boolean dispatch(View view, KeyEvent keyEvent) {
        boolean bl2;
        int n10 = keyEvent.getAction();
        if (n10 == 0) {
            this.recalcViewsWithUnhandled();
        }
        view = this.dispatchInOrder(view, keyEvent);
        n10 = keyEvent.getAction();
        if (n10 == 0) {
            int n11 = keyEvent.getKeyCode();
            if (view != null && (n10 = (int)(KeyEvent.isModifierKey((int)n11) ? 1 : 0)) == 0) {
                SparseArray sparseArray = this.getCapturedKeys();
                WeakReference<View> weakReference = new WeakReference<View>(view);
                sparseArray.put(n11, weakReference);
            }
        }
        if (view != null) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public boolean preDispatch(KeyEvent keyEvent) {
        int n10;
        WeakReference weakReference = this.mLastDispatchedPreViewKeyEvent;
        boolean bl2 = false;
        if (weakReference != null && (weakReference = weakReference.get()) == keyEvent) {
            return false;
        }
        weakReference = new WeakReference(keyEvent);
        this.mLastDispatchedPreViewKeyEvent = weakReference;
        int n11 = 0;
        weakReference = null;
        SparseArray sparseArray = this.getCapturedKeys();
        int n12 = keyEvent.getAction();
        if (n12 == (n10 = 1)) {
            n12 = keyEvent.getKeyCode();
            if ((n12 = sparseArray.indexOfKey(n12)) >= 0) {
                weakReference = (WeakReference)sparseArray.valueAt(n12);
                sparseArray.removeAt(n12);
            }
        }
        if (weakReference == null) {
            n11 = keyEvent.getKeyCode();
            weakReference = (WeakReference)sparseArray.get(n11);
        }
        if (weakReference != null) {
            if ((weakReference = (View)weakReference.get()) != null && (bl2 = ViewCompat.isAttachedToWindow(weakReference))) {
                this.onUnhandledKeyEvent((View)weakReference, keyEvent);
            }
            return n10 != 0;
        }
        return false;
    }
}

