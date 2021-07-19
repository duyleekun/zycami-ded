/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatableTransition;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimationDrawableTransition;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition;
import androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState;
import androidx.appcompat.graphics.drawable.StateListDrawable;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat
extends StateListDrawable
implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = AnimatedStateListDrawableCompat.class.getSimpleName();
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListDrawableCompat$AnimatedStateListState mState;
    private AnimatedStateListDrawableCompat$Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    public AnimatedStateListDrawableCompat(AnimatedStateListDrawableCompat$AnimatedStateListState object, Resources resources) {
        super(null);
        int n10;
        this.mTransitionToIndex = n10 = -1;
        this.mTransitionFromIndex = n10;
        AnimatedStateListDrawableCompat$AnimatedStateListState animatedStateListDrawableCompat$AnimatedStateListState = new AnimatedStateListDrawableCompat$AnimatedStateListState((AnimatedStateListDrawableCompat$AnimatedStateListState)((Object)object), this, resources);
        this.setConstantState(animatedStateListDrawableCompat$AnimatedStateListState);
        object = this.getState();
        this.onStateChange((int[])object);
        this.jumpToCurrentState();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AnimatedStateListDrawableCompat create(Context object, int n10, Resources.Theme theme) {
        String string2 = "parser error";
        try {
            int n11;
            int n12;
            int n13;
            Resources resources = object.getResources();
            Object object2 = resources.getXml(n10);
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)object2);
            while ((n13 = object2.next()) != (n12 = 2) && n13 != (n11 = 1)) {
            }
            if (n13 == n12) {
                return AnimatedStateListDrawableCompat.createFromXmlInner(object, resources, (XmlPullParser)object2, attributeSet, theme);
            }
            object2 = "No start tag found";
            object = new XmlPullParserException((String)object2);
            throw object;
        }
        catch (IOException iOException) {
            String string3 = LOGTAG;
            Log.e((String)string3, (String)string2, (Throwable)iOException);
            return null;
        }
        catch (XmlPullParserException xmlPullParserException) {
            String string4 = LOGTAG;
            Log.e((String)string4, (String)string2, (Throwable)xmlPullParserException);
        }
        return null;
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(Context object, Resources object2, XmlPullParser object3, AttributeSet attributeSet, Resources.Theme theme) {
        String string2;
        Object object4 = object3.getName();
        boolean bl2 = ((String)object4).equals(string2 = "animated-selector");
        if (bl2) {
            object4 = new AnimatedStateListDrawableCompat();
            ((AnimatedStateListDrawableCompat)object4).inflate((Context)object, (Resources)object2, (XmlPullParser)object3, attributeSet, theme);
            return object4;
        }
        object2 = new StringBuilder();
        object3 = object3.getPositionDescription();
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(": invalid animated-selector tag ");
        ((StringBuilder)object2).append((String)object4);
        object2 = ((StringBuilder)object2).toString();
        object = new XmlPullParserException((String)object2);
        throw object;
    }

    private void inflateChildElements(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n10;
        int n11;
        int n12;
        int n13 = xmlPullParser.getDepth();
        int n14 = 1;
        while ((n12 = xmlPullParser.next()) != n14 && ((n11 = xmlPullParser.getDepth()) >= (n13 += n14) || n12 != (n10 = 3))) {
            String string2;
            n10 = 2;
            if (n12 != n10 || n11 > n13) continue;
            String string3 = xmlPullParser.getName();
            n12 = (int)(string3.equals(string2 = ELEMENT_ITEM) ? 1 : 0);
            if (n12 != 0) {
                this.parseItem(context, resources, xmlPullParser, attributeSet, theme);
                continue;
            }
            string3 = xmlPullParser.getName();
            n12 = (int)(string3.equals(string2 = ELEMENT_TRANSITION) ? 1 : 0);
            if (n12 == 0) continue;
            this.parseTransition(context, resources, xmlPullParser, attributeSet, theme);
        }
    }

    private void init() {
        int[] nArray = this.getState();
        this.onStateChange(nArray);
    }

    private int parseItem(Context object, Resources object2, XmlPullParser object3, AttributeSet attributeSet, Resources.Theme theme) {
        int n10;
        Object object4;
        Object object5 = R$styleable.AnimatedStateListDrawableItem;
        object5 = TypedArrayUtils.obtainAttributes((Resources)object2, theme, attributeSet, object5);
        int n11 = R$styleable.AnimatedStateListDrawableItem_android_id;
        String string2 = null;
        n11 = object5.getResourceId(n11, 0);
        int n12 = R$styleable.AnimatedStateListDrawableItem_android_drawable;
        int n13 = -1;
        if ((n12 = object5.getResourceId(n12, n13)) > 0) {
            object4 = ResourceManagerInternal.get();
            object = ((ResourceManagerInternal)object4).getDrawable((Context)object, n12);
        } else {
            n10 = 0;
            object = null;
        }
        object5.recycle();
        object5 = this.extractStateSet(attributeSet);
        string2 = ITEM_MISSING_DRAWABLE_ERROR;
        if (object == null) {
            while ((n10 = object3.next()) == (n13 = 4)) {
            }
            n13 = 2;
            if (n10 == n13) {
                object = object3.getName();
                n10 = (int)(((String)object).equals(object4 = "vector") ? 1 : 0);
                object = n10 != 0 ? VectorDrawableCompat.createFromXmlInner((Resources)object2, object3, attributeSet, theme) : ((n10 = Build.VERSION.SDK_INT) >= (n13 = 21) ? Drawable.createFromXmlInner((Resources)object2, (XmlPullParser)object3, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)object2, (XmlPullParser)object3, (AttributeSet)attributeSet));
            } else {
                object2 = new StringBuilder();
                object3 = object3.getPositionDescription();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                object = new XmlPullParserException((String)object2);
                throw object;
            }
        }
        if (object != null) {
            return this.mState.addStateSet((int[])object5, (Drawable)object, n11);
        }
        object2 = new StringBuilder();
        object3 = object3.getPositionDescription();
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        object = new XmlPullParserException((String)object2);
        throw object;
    }

    private int parseTransition(Context object, Resources object2, XmlPullParser object3, AttributeSet attributeSet, Resources.Theme theme) {
        Object object4;
        Object object5 = R$styleable.AnimatedStateListDrawableTransition;
        object5 = TypedArrayUtils.obtainAttributes((Resources)object2, theme, attributeSet, object5);
        int n10 = R$styleable.AnimatedStateListDrawableTransition_android_fromId;
        int n11 = -1;
        n10 = object5.getResourceId(n10, n11);
        int n12 = R$styleable.AnimatedStateListDrawableTransition_android_toId;
        n12 = object5.getResourceId(n12, n11);
        int n13 = R$styleable.AnimatedStateListDrawableTransition_android_drawable;
        if ((n13 = object5.getResourceId(n13, n11)) > 0) {
            ResourceManagerInternal resourceManagerInternal = ResourceManagerInternal.get();
            object4 = resourceManagerInternal.getDrawable((Context)object, n13);
        } else {
            n13 = 0;
            object4 = null;
        }
        int bl2 = R$styleable.AnimatedStateListDrawableTransition_android_reversible;
        int n14 = 0;
        String string2 = null;
        boolean bl3 = object5.getBoolean(bl2, false);
        object5.recycle();
        object5 = TRANSITION_MISSING_DRAWABLE_ERROR;
        if (object4 == null) {
            while ((n13 = object3.next()) == (n14 = 4)) {
            }
            n14 = 2;
            if (n13 == n14) {
                int n15;
                object4 = object3.getName();
                n13 = (int)(((String)object4).equals(string2 = "animated-vector") ? 1 : 0);
                object4 = n13 != 0 ? AnimatedVectorDrawableCompat.createFromXmlInner(object, (Resources)object2, (XmlPullParser)object3, attributeSet, theme) : ((n15 = Build.VERSION.SDK_INT) >= (n13 = 21) ? Drawable.createFromXmlInner((Resources)object2, (XmlPullParser)object3, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)object2, (XmlPullParser)object3, (AttributeSet)attributeSet));
            } else {
                object2 = new StringBuilder();
                object3 = object3.getPositionDescription();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append((String)object5);
                object2 = ((StringBuilder)object2).toString();
                object = new XmlPullParserException((String)object2);
                throw object;
            }
        }
        if (object4 != null) {
            if (n10 != n11 && n12 != n11) {
                return this.mState.addTransition(n10, n12, (Drawable)object4, bl3);
            }
            object2 = new StringBuilder();
            object3 = object3.getPositionDescription();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(TRANSITION_MISSING_FROM_TO_ID);
            object2 = ((StringBuilder)object2).toString();
            object = new XmlPullParserException((String)object2);
            throw object;
        }
        object2 = new StringBuilder();
        object3 = object3.getPositionDescription();
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append((String)object5);
        object2 = ((StringBuilder)object2).toString();
        object = new XmlPullParserException((String)object2);
        throw object;
    }

    private boolean selectTransition(int n10) {
        block8: {
            AnimatedStateListDrawableCompat$Transition animatedStateListDrawableCompat$Transition;
            int n11;
            boolean bl2;
            block10: {
                Drawable drawable2;
                block11: {
                    block9: {
                        int bl3;
                        Object object = this.mTransition;
                        bl2 = true;
                        if (object != null) {
                            n11 = this.mTransitionToIndex;
                            if (n10 == n11) {
                                return bl2;
                            }
                            n11 = this.mTransitionFromIndex;
                            if (n10 == n11 && (n11 = (int)(((AnimatedStateListDrawableCompat$Transition)object).canReverse() ? 1 : 0)) != 0) {
                                int n12;
                                ((AnimatedStateListDrawableCompat$Transition)object).reverse();
                                this.mTransitionToIndex = n12 = this.mTransitionFromIndex;
                                this.mTransitionFromIndex = n10;
                                return bl2;
                            }
                            n11 = this.mTransitionToIndex;
                            ((AnimatedStateListDrawableCompat$Transition)object).stop();
                        } else {
                            n11 = this.getCurrentIndex();
                        }
                        this.mTransition = null;
                        this.mTransitionFromIndex = bl3 = -1;
                        this.mTransitionToIndex = bl3;
                        object = this.mState;
                        int n12 = ((AnimatedStateListDrawableCompat$AnimatedStateListState)((Object)object)).getKeyframeIdAt(n11);
                        int n13 = ((AnimatedStateListDrawableCompat$AnimatedStateListState)((Object)object)).getKeyframeIdAt(n10);
                        if (n13 == 0 || n12 == 0) break block8;
                        int n14 = ((AnimatedStateListDrawableCompat$AnimatedStateListState)((Object)object)).indexOfTransition(n12, n13);
                        if (n14 < 0) {
                            return false;
                        }
                        boolean bl4 = ((AnimatedStateListDrawableCompat$AnimatedStateListState)((Object)object)).transitionHasReversibleFlag(n12, n13);
                        this.selectDrawable(n14);
                        drawable2 = this.getCurrent();
                        boolean bl5 = drawable2 instanceof AnimationDrawable;
                        if (!bl5) break block9;
                        boolean bl6 = ((AnimatedStateListDrawableCompat$AnimatedStateListState)((Object)object)).isTransitionReversed(n12, n13);
                        drawable2 = (AnimationDrawable)drawable2;
                        animatedStateListDrawableCompat$Transition = new AnimatedStateListDrawableCompat$AnimationDrawableTransition((AnimationDrawable)drawable2, bl6, bl4);
                        break block10;
                    }
                    boolean bl7 = drawable2 instanceof AnimatedVectorDrawableCompat;
                    if (!bl7) break block11;
                    drawable2 = (AnimatedVectorDrawableCompat)drawable2;
                    animatedStateListDrawableCompat$Transition = new AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat)drawable2);
                    break block10;
                }
                boolean bl8 = drawable2 instanceof Animatable;
                if (!bl8) break block8;
                drawable2 = (Animatable)drawable2;
                animatedStateListDrawableCompat$Transition = new AnimatedStateListDrawableCompat$AnimatableTransition((Animatable)drawable2);
            }
            animatedStateListDrawableCompat$Transition.start();
            this.mTransition = animatedStateListDrawableCompat$Transition;
            this.mTransitionFromIndex = n11;
            this.mTransitionToIndex = n10;
            return bl2;
        }
        return false;
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        AnimatedStateListDrawableCompat$AnimatedStateListState animatedStateListDrawableCompat$AnimatedStateListState = this.mState;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            n10 = animatedStateListDrawableCompat$AnimatedStateListState.mChangingConfigurations;
            n11 = typedArray.getChangingConfigurations();
            animatedStateListDrawableCompat$AnimatedStateListState.mChangingConfigurations = n10 |= n11;
        }
        n10 = R$styleable.AnimatedStateListDrawableCompat_android_variablePadding;
        n11 = (int)(animatedStateListDrawableCompat$AnimatedStateListState.mVariablePadding ? 1 : 0);
        n10 = (int)(typedArray.getBoolean(n10, n11 != 0) ? 1 : 0);
        animatedStateListDrawableCompat$AnimatedStateListState.setVariablePadding(n10 != 0);
        n10 = R$styleable.AnimatedStateListDrawableCompat_android_constantSize;
        n11 = (int)(animatedStateListDrawableCompat$AnimatedStateListState.mConstantSize ? 1 : 0);
        n10 = typedArray.getBoolean(n10, n11 != 0);
        animatedStateListDrawableCompat$AnimatedStateListState.setConstantSize(n10 != 0);
        n10 = R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration;
        n11 = animatedStateListDrawableCompat$AnimatedStateListState.mEnterFadeDuration;
        n10 = typedArray.getInt(n10, n11);
        animatedStateListDrawableCompat$AnimatedStateListState.setEnterFadeDuration(n10);
        n10 = R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration;
        n11 = animatedStateListDrawableCompat$AnimatedStateListState.mExitFadeDuration;
        n10 = typedArray.getInt(n10, n11);
        animatedStateListDrawableCompat$AnimatedStateListState.setExitFadeDuration(n10);
        n10 = R$styleable.AnimatedStateListDrawableCompat_android_dither;
        boolean bl2 = animatedStateListDrawableCompat$AnimatedStateListState.mDither;
        boolean bl3 = typedArray.getBoolean(n10, bl2);
        this.setDither(bl3);
    }

    public void addState(int[] object, Drawable drawable2, int n10) {
        if (drawable2 != null) {
            this.mState.addStateSet((int[])object, drawable2, n10);
            object = this.getState();
            this.onStateChange((int[])object);
            return;
        }
        object = new IllegalArgumentException;
        object("Drawable must not be null");
        throw object;
    }

    public void addTransition(int n10, int n11, Drawable drawable2, boolean bl2) {
        if (drawable2 != null) {
            this.mState.addTransition(n10, n11, drawable2, bl2);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Transition drawable must not be null");
        throw illegalArgumentException;
    }

    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    public AnimatedStateListDrawableCompat$AnimatedStateListState cloneConstantState() {
        AnimatedStateListDrawableCompat$AnimatedStateListState animatedStateListDrawableCompat$AnimatedStateListState = this.mState;
        AnimatedStateListDrawableCompat$AnimatedStateListState animatedStateListDrawableCompat$AnimatedStateListState2 = new AnimatedStateListDrawableCompat$AnimatedStateListState(animatedStateListDrawableCompat$AnimatedStateListState, this, null);
        return animatedStateListDrawableCompat$AnimatedStateListState2;
    }

    public void inflate(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Object object = R$styleable.AnimatedStateListDrawableCompat;
        object = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, object);
        int bl2 = R$styleable.AnimatedStateListDrawableCompat_android_visible;
        boolean bl3 = true;
        boolean bl4 = object.getBoolean(bl2, bl3);
        this.setVisible(bl4, bl3);
        this.updateStateFromTypedArray((TypedArray)object);
        this.updateDensity(resources);
        object.recycle();
        this.inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        this.init();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        AnimatedStateListDrawableCompat$Transition animatedStateListDrawableCompat$Transition = this.mTransition;
        if (animatedStateListDrawableCompat$Transition != null) {
            animatedStateListDrawableCompat$Transition.stop();
            animatedStateListDrawableCompat$Transition = null;
            this.mTransition = null;
            int n10 = this.mTransitionToIndex;
            this.selectDrawable(n10);
            this.mTransitionToIndex = n10 = -1;
            this.mTransitionFromIndex = n10;
        }
    }

    public Drawable mutate() {
        Object object;
        boolean bl2 = this.mMutated;
        if (!bl2 && (object = super.mutate()) == this) {
            object = this.mState;
            ((AnimatedStateListDrawableCompat$AnimatedStateListState)((Object)object)).mutate();
            this.mMutated = bl2 = true;
        }
        return this;
    }

    public boolean onStateChange(int[] nArray) {
        int n10;
        AnimatedStateListDrawableCompat$AnimatedStateListState animatedStateListDrawableCompat$AnimatedStateListState = this.mState;
        int n11 = animatedStateListDrawableCompat$AnimatedStateListState.indexOfKeyframe(nArray);
        if (n11 != (n10 = this.getCurrentIndex()) && ((n10 = (int)(this.selectTransition(n11) ? 1 : 0)) != 0 || (n11 = (int)(this.selectDrawable(n11) ? 1 : 0)))) {
            n11 = 1;
        } else {
            n11 = 0;
            animatedStateListDrawableCompat$AnimatedStateListState = null;
        }
        Drawable drawable2 = this.getCurrent();
        if (drawable2 != null) {
            boolean bl2 = drawable2.setState(nArray);
            n11 |= bl2;
        }
        return n11 != 0;
    }

    public void setConstantState(DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState) {
        super.setConstantState(drawableContainer$DrawableContainerState);
        boolean bl2 = drawableContainer$DrawableContainerState instanceof AnimatedStateListDrawableCompat$AnimatedStateListState;
        if (bl2) {
            drawableContainer$DrawableContainerState = (AnimatedStateListDrawableCompat$AnimatedStateListState)drawableContainer$DrawableContainerState;
            this.mState = drawableContainer$DrawableContainerState;
        }
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        boolean bl4 = super.setVisible(bl2, bl3);
        AnimatedStateListDrawableCompat$Transition animatedStateListDrawableCompat$Transition = this.mTransition;
        if (animatedStateListDrawableCompat$Transition != null && (bl4 || bl3)) {
            if (bl2) {
                animatedStateListDrawableCompat$Transition.start();
            } else {
                this.jumpToCurrentState();
            }
        }
        return bl4;
    }
}

