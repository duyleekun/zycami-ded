/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import androidx.transition.Scene;
import androidx.transition.Transition;
import androidx.transition.TransitionManager$MultiListener;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TransitionManager {
    private static final String LOG_TAG = "TransitionManager";
    private static Transition sDefaultTransition;
    public static ArrayList sPendingTransitions;
    private static ThreadLocal sRunningTransitions;
    private ArrayMap mScenePairTransitions;
    private ArrayMap mSceneTransitions;

    static {
        ArrayList arrayList = new ArrayList();
        sDefaultTransition = arrayList;
        arrayList = new ArrayList();
        sRunningTransitions = arrayList;
        sPendingTransitions = arrayList = new ArrayList();
    }

    public TransitionManager() {
        ArrayMap arrayMap;
        this.mSceneTransitions = arrayMap = new ArrayMap();
        this.mScenePairTransitions = arrayMap = new ArrayMap();
    }

    public static void beginDelayedTransition(ViewGroup viewGroup) {
        TransitionManager.beginDelayedTransition(viewGroup, null);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = sPendingTransitions;
        boolean bl2 = arrayList.contains(viewGroup);
        if (!bl2 && (bl2 = ViewCompat.isLaidOut((View)viewGroup))) {
            arrayList = sPendingTransitions;
            arrayList.add(viewGroup);
            if (transition == null) {
                transition = sDefaultTransition;
            }
            transition = transition.clone();
            TransitionManager.sceneChangeSetup(viewGroup, transition);
            bl2 = false;
            arrayList = null;
            Scene.setCurrentScene(viewGroup, null);
            TransitionManager.sceneChangeRunTransition(viewGroup, transition);
        }
    }

    private static void changeScene(Scene scene, Transition transition) {
        Object object = sPendingTransitions;
        ViewGroup viewGroup = scene.getSceneRoot();
        boolean bl2 = ((ArrayList)object).contains(viewGroup);
        if (!bl2) {
            object = Scene.getCurrentScene(viewGroup);
            if (transition == null) {
                if (object != null) {
                    ((Scene)object).exit();
                }
                scene.enter();
            } else {
                ArrayList arrayList = sPendingTransitions;
                arrayList.add(viewGroup);
                transition = transition.clone();
                transition.setSceneRoot(viewGroup);
                if (object != null && (bl2 = ((Scene)object).isCreatedFromLayoutResource())) {
                    bl2 = true;
                    transition.setCanRemoveViews(bl2);
                }
                TransitionManager.sceneChangeSetup(viewGroup, transition);
                scene.enter();
                TransitionManager.sceneChangeRunTransition(viewGroup, transition);
            }
        }
    }

    public static void endTransitions(ViewGroup viewGroup) {
        boolean bl2;
        sPendingTransitions.remove(viewGroup);
        ArrayList arrayList = (ArrayList)TransitionManager.getRunningTransitions().get(viewGroup);
        if (arrayList != null && !(bl2 = arrayList.isEmpty())) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            for (int i10 = arrayList2.size() + -1; i10 >= 0; i10 += -1) {
                Transition transition = (Transition)arrayList2.get(i10);
                transition.forceToEnd(viewGroup);
            }
        }
    }

    public static ArrayMap getRunningTransitions() {
        Object object = (WeakReference)sRunningTransitions.get();
        if (object != null && (object = (ArrayMap)((Reference)object).get()) != null) {
            return object;
        }
        object = new ArrayMap();
        WeakReference<Object> weakReference = new WeakReference<Object>(object);
        sRunningTransitions.set(weakReference);
        return object;
    }

    private Transition getTransition(Scene object) {
        ArrayMap arrayMap;
        Object object2 = ((Scene)object).getSceneRoot();
        if (object2 != null && (object2 = Scene.getCurrentScene((ViewGroup)object2)) != null && (arrayMap = (ArrayMap)this.mScenePairTransitions.get(object)) != null && (object2 = (Transition)arrayMap.get(object2)) != null) {
            return object2;
        }
        object2 = this.mSceneTransitions;
        if ((object = (Transition)((SimpleArrayMap)object2).get(object)) == null) {
            object = sDefaultTransition;
        }
        return object;
    }

    public static void go(Scene scene) {
        Transition transition = sDefaultTransition;
        TransitionManager.changeScene(scene, transition);
    }

    public static void go(Scene scene, Transition transition) {
        TransitionManager.changeScene(scene, transition);
    }

    private static void sceneChangeRunTransition(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            TransitionManager$MultiListener transitionManager$MultiListener = new TransitionManager$MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)transitionManager$MultiListener);
            viewGroup = viewGroup.getViewTreeObserver();
            viewGroup.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)transitionManager$MultiListener);
        }
    }

    private static void sceneChangeSetup(ViewGroup object, Transition transition) {
        int n10;
        Object object2 = (ArrayList)TransitionManager.getRunningTransitions().get(object);
        if (object2 != null && (n10 = ((ArrayList)object2).size()) > 0) {
            object2 = ((ArrayList)object2).iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                Transition transition2 = (Transition)object2.next();
                transition2.pause((View)object);
            }
        }
        if (transition != null) {
            boolean bl2 = true;
            transition.captureValues((ViewGroup)object, bl2);
        }
        if ((object = Scene.getCurrentScene((ViewGroup)object)) != null) {
            ((Scene)object).exit();
        }
    }

    public void setTransition(Scene scene, Scene scene2, Transition transition) {
        ArrayMap arrayMap = (ArrayMap)this.mScenePairTransitions.get(scene2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = this.mScenePairTransitions;
            arrayMap2.put(scene2, arrayMap);
        }
        arrayMap.put(scene, transition);
    }

    public void setTransition(Scene scene, Transition transition) {
        this.mSceneTransitions.put(scene, transition);
    }

    public void transitionTo(Scene scene) {
        Transition transition = this.getTransition(scene);
        TransitionManager.changeScene(scene, transition);
    }
}

