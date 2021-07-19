/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.util.AndroidRuntimeException
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.PathMotion;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.Transition$EpicenterCallback;
import androidx.transition.Transition$TransitionListener;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionSet$1;
import androidx.transition.TransitionSet$TransitionSetListener;
import androidx.transition.TransitionValues;
import androidx.transition.TransitionValuesMaps;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class TransitionSet
extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER;
    private int mChangeFlags;
    public int mCurrentListeners;
    private boolean mPlayTogether;
    public boolean mStarted;
    private ArrayList mTransitions;

    public TransitionSet() {
        ArrayList arrayList;
        this.mTransitions = arrayList = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ArrayList arrayList;
        this.mTransitions = arrayList = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        int[] nArray = Styleable.TRANSITION_SET;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        attributeSet = (XmlResourceParser)attributeSet;
        int n10 = TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)attributeSet, "transitionOrdering", 0, 0);
        this.setOrdering(n10);
        context.recycle();
    }

    private void addTransitionInternal(Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
    }

    private void setupStartEndListeners() {
        int n10;
        boolean bl2;
        TransitionSet$TransitionSetListener transitionSet$TransitionSetListener = new TransitionSet$TransitionSetListener(this);
        Iterator iterator2 = this.mTransitions.iterator();
        while (bl2 = iterator2.hasNext()) {
            Transition transition = (Transition)iterator2.next();
            transition.addListener(transitionSet$TransitionSetListener);
        }
        this.mCurrentListeners = n10 = this.mTransitions.size();
    }

    public TransitionSet addListener(Transition$TransitionListener transition$TransitionListener) {
        return (TransitionSet)super.addListener(transition$TransitionListener);
    }

    public TransitionSet addTarget(int n10) {
        Cloneable cloneable;
        int n11;
        for (int i10 = 0; i10 < (n11 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).addTarget(n10);
        }
        return (TransitionSet)super.addTarget(n10);
    }

    public TransitionSet addTarget(View view) {
        Cloneable cloneable;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).addTarget(view);
        }
        return (TransitionSet)super.addTarget(view);
    }

    public TransitionSet addTarget(Class clazz) {
        Cloneable cloneable;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).addTarget(clazz);
        }
        return (TransitionSet)super.addTarget(clazz);
    }

    public TransitionSet addTarget(String string2) {
        Cloneable cloneable;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).addTarget(string2);
        }
        return (TransitionSet)super.addTarget(string2);
    }

    public TransitionSet addTransition(Transition transition) {
        Object object;
        int n10;
        this.addTransitionInternal(transition);
        long l10 = this.mDuration;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            transition.setDuration(l10);
        }
        if ((n10 = this.mChangeFlags & 1) != 0) {
            object = this.getInterpolator();
            transition.setInterpolator((TimeInterpolator)object);
        }
        if ((n10 = this.mChangeFlags & 2) != 0) {
            object = this.getPropagation();
            transition.setPropagation((TransitionPropagation)object);
        }
        if ((n10 = this.mChangeFlags & 4) != 0) {
            object = this.getPathMotion();
            transition.setPathMotion((PathMotion)object);
        }
        if ((n10 = this.mChangeFlags & 8) != 0) {
            object = this.getEpicenterCallback();
            transition.setEpicenterCallback((Transition$EpicenterCallback)object);
        }
        return this;
    }

    public void cancel() {
        super.cancel();
        ArrayList arrayList = this.mTransitions;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = (Transition)this.mTransitions.get(i10);
            transition.cancel();
        }
    }

    public void captureEndValues(TransitionValues transitionValues) {
        Object object = transitionValues.view;
        boolean bl2 = this.isValidTarget((View)object);
        if (bl2) {
            boolean bl3;
            object = this.mTransitions.iterator();
            while (bl3 = object.hasNext()) {
                Object object2;
                Transition transition = (Transition)object.next();
                boolean bl4 = transition.isValidTarget((View)(object2 = transitionValues.view));
                if (!bl4) continue;
                transition.captureEndValues(transitionValues);
                object2 = transitionValues.mTargetedTransitions;
                ((ArrayList)object2).add(transition);
            }
        }
    }

    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        ArrayList arrayList = this.mTransitions;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = (Transition)this.mTransitions.get(i10);
            transition.capturePropagationValues(transitionValues);
        }
    }

    public void captureStartValues(TransitionValues transitionValues) {
        Object object = transitionValues.view;
        boolean bl2 = this.isValidTarget((View)object);
        if (bl2) {
            boolean bl3;
            object = this.mTransitions.iterator();
            while (bl3 = object.hasNext()) {
                Object object2;
                Transition transition = (Transition)object.next();
                boolean bl4 = transition.isValidTarget((View)(object2 = transitionValues.view));
                if (!bl4) continue;
                transition.captureStartValues(transitionValues);
                object2 = transitionValues.mTargetedTransitions;
                ((ArrayList)object2).add(transition);
            }
        }
    }

    public Transition clone() {
        ArrayList arrayList;
        TransitionSet transitionSet = (TransitionSet)super.clone();
        transitionSet.mTransitions = arrayList = new ArrayList();
        arrayList = this.mTransitions;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = ((Transition)this.mTransitions.get(i10)).clone();
            transitionSet.addTransitionInternal(transition);
        }
        return transitionSet;
    }

    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = this;
        long l10 = this.getStartDelay();
        ArrayList arrayList3 = this.mTransitions;
        int n10 = arrayList3.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object e10 = transitionSet.mTransitions.get(i10);
            Object object = e10;
            object = (Transition)e10;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0 && ((object2 = (Object)transitionSet.mPlayTogether) != false || i10 == 0)) {
                long l13 = ((Transition)object).getStartDelay();
                long l14 = l13 - l11;
                object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 > 0) {
                    ((Transition)object).setStartDelay(l13 += l10);
                } else {
                    ((Transition)object).setStartDelay(l10);
                }
            }
            ((Transition)object).createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    public Transition excludeTarget(int n10, boolean bl2) {
        Cloneable cloneable;
        int n11;
        for (int i10 = 0; i10 < (n11 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).excludeTarget(n10, bl2);
        }
        return super.excludeTarget(n10, bl2);
    }

    public Transition excludeTarget(View view, boolean bl2) {
        Cloneable cloneable;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).excludeTarget(view, bl2);
        }
        return super.excludeTarget(view, bl2);
    }

    public Transition excludeTarget(Class clazz, boolean bl2) {
        Cloneable cloneable;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).excludeTarget(clazz, bl2);
        }
        return super.excludeTarget(clazz, bl2);
    }

    public Transition excludeTarget(String string2, boolean bl2) {
        Cloneable cloneable;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).excludeTarget(string2, bl2);
        }
        return super.excludeTarget(string2, bl2);
    }

    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        ArrayList arrayList = this.mTransitions;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = (Transition)this.mTransitions.get(i10);
            transition.forceToEnd(viewGroup);
        }
    }

    public int getOrdering() {
        return this.mPlayTogether ^ 1;
    }

    public Transition getTransitionAt(int n10) {
        ArrayList arrayList;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (arrayList = this.mTransitions).size())) {
            return (Transition)this.mTransitions.get(n10);
        }
        return null;
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    public void pause(View view) {
        super.pause(view);
        ArrayList arrayList = this.mTransitions;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = (Transition)this.mTransitions.get(i10);
            transition.pause(view);
        }
    }

    public TransitionSet removeListener(Transition$TransitionListener transition$TransitionListener) {
        return (TransitionSet)super.removeListener(transition$TransitionListener);
    }

    public TransitionSet removeTarget(int n10) {
        Cloneable cloneable;
        int n11;
        for (int i10 = 0; i10 < (n11 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).removeTarget(n10);
        }
        return (TransitionSet)super.removeTarget(n10);
    }

    public TransitionSet removeTarget(View view) {
        Cloneable cloneable;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).removeTarget(view);
        }
        return (TransitionSet)super.removeTarget(view);
    }

    public TransitionSet removeTarget(Class clazz) {
        Cloneable cloneable;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).removeTarget(clazz);
        }
        return (TransitionSet)super.removeTarget(clazz);
    }

    public TransitionSet removeTarget(String string2) {
        Cloneable cloneable;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++i10) {
            cloneable = (Transition)this.mTransitions.get(i10);
            ((Transition)cloneable).removeTarget(string2);
        }
        return (TransitionSet)super.removeTarget(string2);
    }

    public TransitionSet removeTransition(Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    public void resume(View view) {
        super.resume(view);
        ArrayList arrayList = this.mTransitions;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = (Transition)this.mTransitions.get(i10);
            transition.resume(view);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void runAnimators() {
        Object object = this.mTransitions;
        boolean n10 = ((ArrayList)object).isEmpty();
        if (n10) {
            this.start();
            this.end();
            return;
        }
        this.setupStartEndListeners();
        boolean bl2 = this.mPlayTogether;
        if (!bl2) {
            Cloneable cloneable;
            int n11;
            void var2_5;
            boolean bl3 = true;
            while (++var2_5 < (n11 = ((ArrayList)(cloneable = this.mTransitions)).size())) {
                cloneable = this.mTransitions;
                void var5_10 = var2_5 + -1;
                cloneable = (Transition)((ArrayList)cloneable).get((int)var5_10);
                Transition transition = (Transition)this.mTransitions.get((int)var2_5);
                TransitionSet$1 transitionSet$1 = new TransitionSet$1(this, transition);
                ((Transition)cloneable).addListener(transitionSet$1);
            }
            object = this.mTransitions;
            n11 = 0;
            cloneable = null;
            if ((object = (Transition)((ArrayList)object).get(0)) != null) {
                ((Transition)object).runAnimators();
            }
        } else {
            boolean bl4;
            object = this.mTransitions.iterator();
            while (bl4 = object.hasNext()) {
                Transition transition = (Transition)object.next();
                transition.runAnimators();
            }
        }
    }

    public void setCanRemoveViews(boolean bl2) {
        super.setCanRemoveViews(bl2);
        ArrayList arrayList = this.mTransitions;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = (Transition)this.mTransitions.get(i10);
            transition.setCanRemoveViews(bl2);
        }
    }

    public TransitionSet setDuration(long l10) {
        ArrayList arrayList;
        super.setDuration(l10);
        long l11 = this.mDuration;
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 >= 0 && (arrayList = this.mTransitions) != null) {
            l13 = arrayList.size();
            for (int i10 = 0; i10 < l13; ++i10) {
                Transition transition = (Transition)this.mTransitions.get(i10);
                transition.setDuration(l10);
            }
        }
        return this;
    }

    public void setEpicenterCallback(Transition$EpicenterCallback transition$EpicenterCallback) {
        int n10;
        super.setEpicenterCallback(transition$EpicenterCallback);
        this.mChangeFlags = n10 = this.mChangeFlags | 8;
        ArrayList arrayList = this.mTransitions;
        n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = (Transition)this.mTransitions.get(i10);
            transition.setEpicenterCallback(transition$EpicenterCallback);
        }
    }

    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        int n10;
        this.mChangeFlags = n10 = this.mChangeFlags | 1;
        ArrayList arrayList = this.mTransitions;
        if (arrayList != null) {
            n10 = arrayList.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                Transition transition = (Transition)this.mTransitions.get(i10);
                transition.setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet)super.setInterpolator(timeInterpolator);
    }

    /*
     * Enabled aggressive block sorting
     */
    public TransitionSet setOrdering(int n10) {
        int n11 = 1;
        if (n10 == 0) {
            this.mPlayTogether = n11;
            return this;
        }
        if (n10 == n11) {
            n10 = 0;
            Object var3_3 = null;
            this.mPlayTogether = false;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid parameter for TransitionSet ordering: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException(string2);
        throw androidRuntimeException;
    }

    public void setPathMotion(PathMotion pathMotion) {
        int n10;
        super.setPathMotion(pathMotion);
        this.mChangeFlags = n10 = this.mChangeFlags | 4;
        ArrayList arrayList = this.mTransitions;
        if (arrayList != null) {
            Cloneable cloneable;
            int n11;
            arrayList = null;
            for (n10 = 0; n10 < (n11 = ((ArrayList)(cloneable = this.mTransitions)).size()); ++n10) {
                cloneable = (Transition)this.mTransitions.get(n10);
                ((Transition)cloneable).setPathMotion(pathMotion);
            }
        }
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        int n10;
        super.setPropagation(transitionPropagation);
        this.mChangeFlags = n10 = this.mChangeFlags | 2;
        ArrayList arrayList = this.mTransitions;
        n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = (Transition)this.mTransitions.get(i10);
            transition.setPropagation(transitionPropagation);
        }
    }

    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        ArrayList arrayList = this.mTransitions;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Transition transition = (Transition)this.mTransitions.get(i10);
            transition.setSceneRoot(viewGroup);
        }
        return this;
    }

    public TransitionSet setStartDelay(long l10) {
        return (TransitionSet)super.setStartDelay(l10);
    }

    public String toString(String string2) {
        Serializable serializable;
        int n10;
        Object object = super.toString(string2);
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(serializable = this.mTransitions)).size()); ++i10) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append((String)object);
            ((StringBuilder)serializable).append("\n");
            object = (Transition)this.mTransitions.get(i10);
            CharSequence charSequence = new StringBuilder();
            charSequence.append(string2);
            String string3 = "  ";
            charSequence.append(string3);
            charSequence = charSequence.toString();
            object = ((Transition)object).toString((String)charSequence);
            ((StringBuilder)serializable).append((String)object);
            object = ((StringBuilder)serializable).toString();
        }
        return object;
    }
}

