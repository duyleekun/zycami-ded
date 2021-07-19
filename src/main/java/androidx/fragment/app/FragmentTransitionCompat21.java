/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.transition.Transition
 *  android.transition.Transition$EpicenterCallback
 *  android.transition.Transition$TransitionListener
 *  android.transition.TransitionManager
 *  android.transition.TransitionSet
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionCompat21$1;
import androidx.fragment.app.FragmentTransitionCompat21$2;
import androidx.fragment.app.FragmentTransitionCompat21$3;
import androidx.fragment.app.FragmentTransitionCompat21$4;
import androidx.fragment.app.FragmentTransitionCompat21$5;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionCompat21
extends FragmentTransitionImpl {
    private static boolean hasSimpleTarget(Transition object) {
        boolean bl2;
        List list = object.getTargetIds();
        boolean bl3 = FragmentTransitionImpl.isNullOrEmpty(list);
        if (bl3 && (bl3 = FragmentTransitionImpl.isNullOrEmpty(list = object.getTargetNames())) && (bl2 = FragmentTransitionImpl.isNullOrEmpty((List)(object = object.getTargetTypes())))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void addTarget(Object object, View view) {
        if (object != null) {
            object = (Transition)object;
            object.addTarget(view);
        }
    }

    public void addTargets(Object object, ArrayList arrayList) {
        block4: {
            List list;
            int n10;
            int n11;
            block3: {
                if ((object = (Transition)object) == null) {
                    return;
                }
                n11 = object instanceof TransitionSet;
                if (n11 == 0) break block3;
                object = (TransitionSet)object;
                n11 = object.getTransitionCount();
                for (n10 = 0; n10 < n11; ++n10) {
                    Transition transition = object.getTransitionAt(n10);
                    this.addTargets(transition, arrayList);
                }
                break block4;
            }
            n11 = FragmentTransitionCompat21.hasSimpleTarget((Transition)object);
            if (n11 != 0 || (n11 = (int)(FragmentTransitionImpl.isNullOrEmpty(list = object.getTargets()) ? 1 : 0)) == 0) break block4;
            n11 = arrayList.size();
            while (n10 < n11) {
                View view = (View)arrayList.get(n10);
                object.addTarget(view);
                ++n10;
            }
        }
    }

    public void beginDelayedTransition(ViewGroup viewGroup, Object object) {
        object = (Transition)object;
        TransitionManager.beginDelayedTransition((ViewGroup)viewGroup, (Transition)object);
    }

    public boolean canHandle(Object object) {
        return object instanceof Transition;
    }

    public Object cloneTransition(Object object) {
        object = object != null ? ((Transition)object).clone() : null;
        return object;
    }

    public Object mergeTransitionsInSequence(Object object, Object object2, Object object3) {
        object = (Transition)object;
        object2 = (Transition)object2;
        object3 = (Transition)object3;
        if (object != null && object2 != null) {
            TransitionSet transitionSet = new TransitionSet();
            object = transitionSet.addTransition((Transition)object).addTransition((Transition)object2);
            int n10 = 1;
            object = object.setOrdering(n10);
        } else if (object == null) {
            object = object2 != null ? object2 : null;
        }
        if (object3 != null) {
            object2 = new TransitionSet();
            if (object != null) {
                object2.addTransition((Transition)object);
            }
            object2.addTransition((Transition)object3);
            return object2;
        }
        return object;
    }

    public Object mergeTransitionsTogether(Object object, Object object2, Object object3) {
        TransitionSet transitionSet = new TransitionSet();
        if (object != null) {
            object = (Transition)object;
            transitionSet.addTransition((Transition)object);
        }
        if (object2 != null) {
            object2 = (Transition)object2;
            transitionSet.addTransition((Transition)object2);
        }
        if (object3 != null) {
            object3 = (Transition)object3;
            transitionSet.addTransition((Transition)object3);
        }
        return transitionSet;
    }

    public void removeTarget(Object object, View view) {
        if (object != null) {
            object = (Transition)object;
            object.removeTarget(view);
        }
    }

    public void replaceTargets(Object object, ArrayList arrayList, ArrayList arrayList2) {
        block6: {
            int n10;
            int n11;
            List list;
            int n12;
            int n13;
            block5: {
                object = (Transition)object;
                n13 = object instanceof TransitionSet;
                if (n13 == 0) break block5;
                object = (TransitionSet)object;
                n13 = object.getTransitionCount();
                for (n12 = 0; n12 < n13; ++n12) {
                    Transition transition = object.getTransitionAt(n12);
                    this.replaceTargets(transition, arrayList, arrayList2);
                }
                break block6;
            }
            n13 = FragmentTransitionCompat21.hasSimpleTarget((Transition)object);
            if (n13 != 0 || (list = object.getTargets()) == null || (n11 = list.size()) != (n10 = arrayList.size()) || (n13 = (int)(list.containsAll(arrayList) ? 1 : 0)) == 0) break block6;
            if (arrayList2 == null) {
                n13 = 0;
                list = null;
            } else {
                n13 = arrayList2.size();
            }
            while (n12 < n13) {
                View view = (View)arrayList2.get(n12);
                object.addTarget(view);
                ++n12;
            }
            for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
                list = (View)arrayList.get(i10);
                object.removeTarget((View)list);
            }
        }
    }

    public void scheduleHideFragmentView(Object object, View view, ArrayList arrayList) {
        object = (Transition)object;
        FragmentTransitionCompat21$2 fragmentTransitionCompat21$2 = new FragmentTransitionCompat21$2(this, view, arrayList);
        object.addListener((Transition.TransitionListener)fragmentTransitionCompat21$2);
    }

    public void scheduleRemoveTargets(Object object, Object object2, ArrayList arrayList, Object object3, ArrayList arrayList2, Object object4, ArrayList arrayList3) {
        Object object5 = object;
        object5 = (Transition)object;
        FragmentTransitionCompat21$3 fragmentTransitionCompat21$3 = new FragmentTransitionCompat21$3(this, object2, arrayList, object3, arrayList2, object4, arrayList3);
        object5.addListener((Transition.TransitionListener)fragmentTransitionCompat21$3);
    }

    public void setEpicenter(Object object, Rect rect) {
        if (object != null) {
            object = (Transition)object;
            FragmentTransitionCompat21$5 fragmentTransitionCompat21$5 = new FragmentTransitionCompat21$5(this, rect);
            object.setEpicenterCallback((Transition.EpicenterCallback)fragmentTransitionCompat21$5);
        }
    }

    public void setEpicenter(Object object, View object2) {
        if (object2 != null) {
            object = (Transition)object;
            Rect rect = new Rect();
            this.getBoundsOnScreen((View)object2, rect);
            object2 = new FragmentTransitionCompat21$1(this, rect);
            object.setEpicenterCallback((Transition.EpicenterCallback)object2);
        }
    }

    public void setListenerForTransitionEnd(Fragment object, Object object2, CancellationSignal cancellationSignal, Runnable runnable) {
        object2 = (Transition)object2;
        object = new FragmentTransitionCompat21$4(this, runnable);
        object2.addListener((Transition.TransitionListener)object);
    }

    public void setSharedElementTargets(Object object, View view, ArrayList arrayList) {
        object = (TransitionSet)object;
        List list = object.getTargets();
        list.clear();
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view2 = (View)arrayList.get(i10);
            FragmentTransitionImpl.bfsAddViewChildren(list, view2);
        }
        list.add(view);
        arrayList.add(view);
        this.addTargets(object, arrayList);
    }

    public void swapSharedElementTargets(Object object, ArrayList arrayList, ArrayList arrayList2) {
        if ((object = (TransitionSet)object) != null) {
            object.getTargets().clear();
            List list = object.getTargets();
            list.addAll(arrayList2);
            this.replaceTargets(object, arrayList, arrayList2);
        }
    }

    public Object wrapTransitionInSet(Object object) {
        if (object == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        object = (Transition)object;
        transitionSet.addTransition((Transition)object);
        return transitionSet;
    }
}

