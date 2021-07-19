/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ArgbEvaluator
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Animatable2$AnimationCallback
 *  android.graphics.drawable.AnimatedVectorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$1;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$2;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCommon;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat
extends VectorDrawableCommon
implements Animatable2Compat {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState mAnimatedVectorState;
    public ArrayList mAnimationCallbacks = null;
    private Animator.AnimatorListener mAnimatorListener = null;
    private ArgbEvaluator mArgbEvaluator = null;
    public AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    public final Drawable.Callback mCallback;
    private Context mContext;

    public AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState, Resources resources) {
        AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState2;
        AnimatedVectorDrawableCompat$1 animatedVectorDrawableCompat$1 = new AnimatedVectorDrawableCompat$1(this);
        this.mCallback = animatedVectorDrawableCompat$1;
        this.mContext = context;
        this.mAnimatedVectorState = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState != null ? animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState : (animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState2 = new AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState, animatedVectorDrawableCompat$1, resources));
    }

    public static void clearAnimationCallbacks(Drawable drawable2) {
        int n10 = drawable2 instanceof Animatable;
        if (n10 == 0) {
            return;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            drawable2 = (AnimatedVectorDrawable)drawable2;
            drawable2.clearAnimationCallbacks();
        } else {
            drawable2 = (AnimatedVectorDrawableCompat)drawable2;
            drawable2.clearAnimationCallbacks();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AnimatedVectorDrawableCompat create(Context object, int n10) {
        Object object2 = "parser error";
        String string2 = LOGTAG;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            object2 = new AnimatedVectorDrawableCompat((Context)object);
            string2 = object.getResources();
            object = object.getTheme();
            object = ResourcesCompat.getDrawable((Resources)string2, n10, (Resources.Theme)object);
            ((VectorDrawableCommon)object2).mDelegateDrawable = object;
            Drawable.Callback callback = ((AnimatedVectorDrawableCompat)object2).mCallback;
            object.setCallback(callback);
            callback = ((VectorDrawableCommon)object2).mDelegateDrawable.getConstantState();
            object = new AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState((Drawable.ConstantState)callback);
            ((AnimatedVectorDrawableCompat)object2).mCachedConstantStateDelegate = object;
            return object2;
        }
        Resources resources = object.getResources();
        try {
            int n13;
            int n14;
            Object object3 = resources.getXml(n10);
            resources = Xml.asAttributeSet((XmlPullParser)object3);
            while ((n12 = object3.next()) != (n14 = 2) && n12 != (n13 = 1)) {
            }
            if (n12 == n14) {
                Resources resources2 = object.getResources();
                Resources.Theme theme = object.getTheme();
                return AnimatedVectorDrawableCompat.createFromXmlInner(object, resources2, (XmlPullParser)object3, (AttributeSet)resources, theme);
            }
            object3 = "No start tag found";
            object = new XmlPullParserException((String)object3);
            throw object;
        }
        catch (IOException iOException) {
            Log.e((String)string2, (String)object2, (Throwable)iOException);
            return null;
        }
        catch (XmlPullParserException xmlPullParserException) {
            Log.e((String)string2, (String)object2, (Throwable)xmlPullParserException);
        }
        return null;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    public static void registerAnimationCallback(Drawable drawable2, Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        if (drawable2 != null && animatable2Compat$AnimationCallback != null) {
            int n10 = drawable2 instanceof Animatable;
            if (n10 == 0) {
                return;
            }
            n10 = Build.VERSION.SDK_INT;
            int n11 = 24;
            if (n10 >= n11) {
                drawable2 = (AnimatedVectorDrawable)drawable2;
                AnimatedVectorDrawableCompat.registerPlatformCallback((AnimatedVectorDrawable)drawable2, animatable2Compat$AnimationCallback);
            } else {
                drawable2 = (AnimatedVectorDrawableCompat)drawable2;
                drawable2.registerAnimationCallback(animatable2Compat$AnimationCallback);
            }
        }
    }

    private static void registerPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        animatable2Compat$AnimationCallback = animatable2Compat$AnimationCallback.getPlatformCallback();
        animatedVectorDrawable.registerAnimationCallback((Animatable2.AnimationCallback)animatable2Compat$AnimationCallback);
    }

    private void removeAnimatorSetListener() {
        Animator.AnimatorListener animatorListener = this.mAnimatorListener;
        if (animatorListener != null) {
            AnimatorSet animatorSet = this.mAnimatedVectorState.mAnimatorSet;
            animatorSet.removeListener(animatorListener);
            animatorListener = null;
            this.mAnimatorListener = null;
        }
    }

    private void setupAnimatorsForTarget(String string2, Animator animator2) {
        Object object = this.mAnimatedVectorState.mVectorDrawable.getTargetByName(string2);
        animator2.setTarget(object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            this.setupColorAnimator(animator2);
        }
        object = this.mAnimatedVectorState;
        ArrayList arrayList = ((AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState)object).mAnimators;
        if (arrayList == null) {
            arrayList = new ArrayList();
            ((AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState)object).mAnimators = arrayList;
            object = this.mAnimatedVectorState;
            ((AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState)object).mTargetNameMap = arrayList = new ArrayMap();
        }
        this.mAnimatedVectorState.mAnimators.add(animator2);
        this.mAnimatedVectorState.mTargetNameMap.put(animator2, string2);
    }

    private void setupColorAnimator(Animator animator2) {
        int n10;
        String string2;
        Object object;
        boolean bl2 = animator2 instanceof AnimatorSet;
        if (bl2) {
            object = animator2;
            object = ((AnimatorSet)animator2).getChildAnimations();
            if (object != null) {
                int n11;
                string2 = null;
                for (n10 = 0; n10 < (n11 = object.size()); ++n10) {
                    Animator animator3 = (Animator)object.get(n10);
                    this.setupColorAnimator(animator3);
                }
            }
        }
        if ((bl2 = animator2 instanceof ObjectAnimator) && ((n10 = (string2 = "fillColor").equals(object = (animator2 = (ObjectAnimator)animator2).getPropertyName())) != 0 || (bl2 = (string2 = "strokeColor").equals(object)))) {
            object = this.mArgbEvaluator;
            if (object == null) {
                object = new ArgbEvaluator();
                this.mArgbEvaluator = object;
            }
            object = this.mArgbEvaluator;
            animator2.setEvaluator((TypeEvaluator)object);
        }
    }

    public static boolean unregisterAnimationCallback(Drawable drawable2, Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        int n10 = 0;
        if (drawable2 != null && animatable2Compat$AnimationCallback != null) {
            int n11 = drawable2 instanceof Animatable;
            if (n11 == 0) {
                return false;
            }
            n10 = Build.VERSION.SDK_INT;
            n11 = 24;
            if (n10 >= n11) {
                return AnimatedVectorDrawableCompat.unregisterPlatformCallback((AnimatedVectorDrawable)drawable2, animatable2Compat$AnimationCallback);
            }
            return ((AnimatedVectorDrawableCompat)drawable2).unregisterAnimationCallback(animatable2Compat$AnimationCallback);
        }
        return false;
    }

    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        animatable2Compat$AnimationCallback = animatable2Compat$AnimationCallback.getPlatformCallback();
        return animatedVectorDrawable.unregisterAnimationCallback((Animatable2.AnimationCallback)animatable2Compat$AnimationCallback);
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.applyTheme(drawable2, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return DrawableCompat.canApplyTheme(drawable2);
        }
        return false;
    }

    public void clearAnimationCallbacks() {
        Object object = this.mDelegateDrawable;
        if (object != null) {
            ((AnimatedVectorDrawable)object).clearAnimationCallbacks();
            return;
        }
        this.removeAnimatorSetListener();
        object = this.mAnimationCallbacks;
        if (object == null) {
            return;
        }
        ((ArrayList)object).clear();
    }

    public void draw(Canvas canvas) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
            return;
        }
        drawable2 = this.mAnimatedVectorState.mVectorDrawable;
        drawable2.draw(canvas);
        canvas = this.mAnimatedVectorState.mAnimatorSet;
        boolean bl2 = canvas.isStarted();
        if (bl2) {
            this.invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return DrawableCompat.getAlpha(drawable2);
        }
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getChangingConfigurations();
        }
        int n10 = super.getChangingConfigurations();
        int n11 = this.mAnimatedVectorState.mChangingConfigurations;
        return n10 | n11;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return DrawableCompat.getColorFilter(drawable2);
        }
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        int n10;
        int n11;
        Object object = this.mDelegateDrawable;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 24)) {
            Drawable.ConstantState constantState = this.mDelegateDrawable.getConstantState();
            object = new AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(constantState);
            return object;
        }
        return null;
    }

    public int getIntrinsicHeight() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getIntrinsicHeight();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getIntrinsicWidth();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getOpacity();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n10;
        Object object2 = this.mDelegateDrawable;
        if (object2 != null) {
            DrawableCompat.inflate(object2, object, xmlPullParser, attributeSet, theme);
            return;
        }
        int n11 = xmlPullParser.getEventType();
        int n12 = xmlPullParser.getDepth();
        int n13 = 1;
        while (n11 != n13 && ((n10 = xmlPullParser.getDepth()) >= (n12 += n13) || n11 != (n10 = 3))) {
            n10 = 2;
            if (n11 == n10) {
                Context context;
                object2 = xmlPullParser.getName();
                Object object3 = ANIMATED_VECTOR;
                n10 = (int)(((String)object3).equals(object2) ? 1 : 0);
                int n14 = 0;
                Object object4 = null;
                if (n10 != 0) {
                    object2 = AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE;
                    n10 = (object2 = TypedArrayUtils.obtainAttributes(object, theme, attributeSet, (int[])object2)).getResourceId(0, 0);
                    if (n10 != 0) {
                        object3 = VectorDrawableCompat.create(object, n10, theme);
                        ((VectorDrawableCompat)object3).setAllowCaching(false);
                        object4 = this.mCallback;
                        object3.setCallback(object4);
                        object4 = this.mAnimatedVectorState.mVectorDrawable;
                        if (object4 != null) {
                            context = null;
                            object4.setCallback(null);
                        }
                        object4 = this.mAnimatedVectorState;
                        object4.mVectorDrawable = object3;
                    }
                    object2.recycle();
                } else {
                    object3 = TARGET;
                    n11 = (int)(((String)object3).equals(object2) ? 1 : 0);
                    if (n11 != 0) {
                        object2 = AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET;
                        object2 = object.obtainAttributes(attributeSet, (int[])object2);
                        object3 = object2.getString(0);
                        n14 = object2.getResourceId(n13, 0);
                        if (n14 != 0) {
                            context = this.mContext;
                            if (context != null) {
                                object4 = AnimatorInflaterCompat.loadAnimator(context, n14);
                                this.setupAnimatorsForTarget((String)object3, (Animator)object4);
                            } else {
                                object2.recycle();
                                object = new IllegalStateException("Context can't be null when inflating animators");
                                throw object;
                            }
                        }
                        object2.recycle();
                    }
                }
            }
            n11 = xmlPullParser.next();
        }
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    public boolean isAutoMirrored() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return DrawableCompat.isAutoMirrored(drawable2);
        }
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return ((AnimatedVectorDrawable)drawable2).isRunning();
        }
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.isStateful();
        }
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
    }

    public boolean onLevelChange(int n10) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(n10);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(n10);
    }

    public boolean onStateChange(int[] nArray) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.setState(nArray);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setState(nArray);
    }

    public void registerAnimationCallback(Animatable2Compat$AnimationCallback object) {
        boolean bl2;
        Object object2 = this.mDelegateDrawable;
        if (object2 != null) {
            AnimatedVectorDrawableCompat.registerPlatformCallback((AnimatedVectorDrawable)object2, object);
            return;
        }
        if (object == null) {
            return;
        }
        object2 = this.mAnimationCallbacks;
        if (object2 == null) {
            object2 = new ArrayList();
            this.mAnimationCallbacks = object2;
        }
        if (bl2 = ((ArrayList)(object2 = this.mAnimationCallbacks)).contains(object)) {
            return;
        }
        object2 = this.mAnimationCallbacks;
        ((ArrayList)object2).add(object);
        object = this.mAnimatorListener;
        if (object == null) {
            object = new AnimatedVectorDrawableCompat$2(this);
            this.mAnimatorListener = object;
        }
        object = this.mAnimatedVectorState.mAnimatorSet;
        object2 = this.mAnimatorListener;
        object.addListener((Animator.AnimatorListener)object2);
    }

    public void setAlpha(int n10) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setAlpha(n10);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(n10);
    }

    public void setAutoMirrored(boolean bl2) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setAutoMirrored(drawable2, bl2);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(bl2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
    }

    public void setTint(int n10) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setTint(drawable2, n10);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTint(n10);
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setTintList(drawable2, colorStateList);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setTintMode(drawable2, mode);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.setVisible(bl2, bl3);
        }
        this.mAnimatedVectorState.mVectorDrawable.setVisible(bl2, bl3);
        return super.setVisible(bl2, bl3);
    }

    public void start() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            ((AnimatedVectorDrawable)drawable2).start();
            return;
        }
        drawable2 = this.mAnimatedVectorState.mAnimatorSet;
        boolean bl2 = drawable2.isStarted();
        if (bl2) {
            return;
        }
        this.mAnimatedVectorState.mAnimatorSet.start();
        this.invalidateSelf();
    }

    public void stop() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            ((AnimatedVectorDrawable)drawable2).stop();
            return;
        }
        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    public boolean unregisterAnimationCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        Object object = this.mDelegateDrawable;
        if (object != null) {
            object = (AnimatedVectorDrawable)object;
            AnimatedVectorDrawableCompat.unregisterPlatformCallback((AnimatedVectorDrawable)object, animatable2Compat$AnimationCallback);
        }
        if ((object = this.mAnimationCallbacks) != null && animatable2Compat$AnimationCallback != null) {
            boolean bl2 = ((ArrayList)object).remove(animatable2Compat$AnimationCallback);
            object = this.mAnimationCallbacks;
            int n10 = ((ArrayList)object).size();
            if (n10 == 0) {
                this.removeAnimatorSetListener();
            }
            return bl2;
        }
        return false;
    }
}

