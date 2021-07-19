/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState;
import androidx.appcompat.graphics.drawable.StateListDrawable$StateListState;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StateListDrawable
extends DrawableContainer {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawable";
    private boolean mMutated;
    private StateListDrawable$StateListState mStateListState;

    public StateListDrawable() {
        this(null, null);
    }

    public StateListDrawable(StateListDrawable$StateListState stateListDrawable$StateListState) {
        if (stateListDrawable$StateListState != null) {
            this.setConstantState(stateListDrawable$StateListState);
        }
    }

    public StateListDrawable(StateListDrawable$StateListState object, Resources resources) {
        StateListDrawable$StateListState stateListDrawable$StateListState = new StateListDrawable$StateListState((StateListDrawable$StateListState)((Object)object), this, resources);
        this.setConstantState(stateListDrawable$StateListState);
        object = this.getState();
        this.onStateChange((int[])object);
    }

    private void inflateChildElements(Context object, Resources object2, XmlPullParser object3, AttributeSet attributeSet, Resources.Theme theme) {
        int n10;
        int n11;
        int n12;
        StateListDrawable$StateListState stateListDrawable$StateListState = this.mStateListState;
        int n13 = object3.getDepth();
        int n14 = 1;
        while ((n12 = object3.next()) != n14 && ((n11 = object3.getDepth()) >= (n13 += n14) || n12 != (n10 = 3))) {
            String string2;
            Object object4;
            n10 = 2;
            if (n12 != n10 || n11 > n13 || (n12 = (int)(((String)(object4 = object3.getName())).equals(string2 = "item") ? 1 : 0)) == 0) continue;
            object4 = R$styleable.StateListDrawableItem;
            object4 = TypedArrayUtils.obtainAttributes((Resources)object2, theme, attributeSet, (int[])object4);
            n11 = 0;
            string2 = null;
            int n15 = R$styleable.StateListDrawableItem_android_drawable;
            int n16 = -1;
            if ((n15 = object4.getResourceId(n15, n16)) > 0) {
                string2 = ResourceManagerInternal.get().getDrawable((Context)object, n15);
            }
            object4.recycle();
            object4 = this.extractStateSet(attributeSet);
            if (string2 == null) {
                while ((n11 = object3.next()) == (n15 = 4)) {
                }
                if (n11 == n10) {
                    n11 = Build.VERSION.SDK_INT;
                    n10 = 21;
                    string2 = n11 >= n10 ? Drawable.createFromXmlInner((Resources)object2, (XmlPullParser)object3, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)object2, (XmlPullParser)object3, (AttributeSet)attributeSet);
                } else {
                    object2 = new StringBuilder();
                    object3 = object3.getPositionDescription();
                    ((StringBuilder)object2).append((String)object3);
                    ((StringBuilder)object2).append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    object2 = ((StringBuilder)object2).toString();
                    object = new XmlPullParserException((String)object2);
                    throw object;
                }
            }
            stateListDrawable$StateListState.addStateSet((int[])object4, (Drawable)string2);
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        boolean bl2;
        StateListDrawable$StateListState stateListDrawable$StateListState = this.mStateListState;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            n10 = stateListDrawable$StateListState.mChangingConfigurations;
            n11 = typedArray.getChangingConfigurations();
            stateListDrawable$StateListState.mChangingConfigurations = n10 |= n11;
        }
        n10 = R$styleable.StateListDrawable_android_variablePadding;
        n11 = (int)(stateListDrawable$StateListState.mVariablePadding ? 1 : 0);
        n10 = (int)(typedArray.getBoolean(n10, n11 != 0) ? 1 : 0);
        stateListDrawable$StateListState.mVariablePadding = n10;
        n10 = R$styleable.StateListDrawable_android_constantSize;
        n11 = (int)(stateListDrawable$StateListState.mConstantSize ? 1 : 0);
        stateListDrawable$StateListState.mConstantSize = n10 = typedArray.getBoolean(n10, n11 != 0);
        n10 = R$styleable.StateListDrawable_android_enterFadeDuration;
        n11 = stateListDrawable$StateListState.mEnterFadeDuration;
        stateListDrawable$StateListState.mEnterFadeDuration = n10 = typedArray.getInt(n10, n11);
        n10 = R$styleable.StateListDrawable_android_exitFadeDuration;
        n11 = stateListDrawable$StateListState.mExitFadeDuration;
        stateListDrawable$StateListState.mExitFadeDuration = n10 = typedArray.getInt(n10, n11);
        n10 = R$styleable.StateListDrawable_android_dither;
        n11 = (int)(stateListDrawable$StateListState.mDither ? 1 : 0);
        stateListDrawable$StateListState.mDither = bl2 = typedArray.getBoolean(n10, n11 != 0);
    }

    public void addState(int[] nArray, Drawable drawable2) {
        if (drawable2 != null) {
            StateListDrawable$StateListState stateListDrawable$StateListState = this.mStateListState;
            stateListDrawable$StateListState.addStateSet(nArray, drawable2);
            nArray = this.getState();
            this.onStateChange(nArray);
        }
    }

    public void applyTheme(Resources.Theme object) {
        super.applyTheme((Resources.Theme)object);
        object = this.getState();
        this.onStateChange((int[])object);
    }

    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    public StateListDrawable$StateListState cloneConstantState() {
        StateListDrawable$StateListState stateListDrawable$StateListState = this.mStateListState;
        StateListDrawable$StateListState stateListDrawable$StateListState2 = new StateListDrawable$StateListState(stateListDrawable$StateListState, this, null);
        return stateListDrawable$StateListState2;
    }

    public int[] extractStateSet(AttributeSet attributeSet) {
        int n10 = attributeSet.getAttributeCount();
        int[] nArray = new int[n10];
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12;
            int n13 = attributeSet.getAttributeNameResource(i10);
            if (n13 == 0 || n13 == (n12 = 0x10100D0) || n13 == (n12 = 0x1010199)) continue;
            n12 = n11 + 1;
            boolean bl2 = attributeSet.getAttributeBooleanValue(i10, false);
            if (!bl2) {
                n13 = -n13;
            }
            nArray[n11] = n13;
            n11 = n12;
        }
        return StateSet.trimStateSet((int[])nArray, (int)n11);
    }

    public int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    public Drawable getStateDrawable(int n10) {
        return this.mStateListState.getChild(n10);
    }

    public int getStateDrawableIndex(int[] nArray) {
        return this.mStateListState.indexOfStateSet(nArray);
    }

    public StateListDrawable$StateListState getStateListState() {
        return this.mStateListState;
    }

    public int[] getStateSet(int n10) {
        return this.mStateListState.mStateSets[n10];
    }

    public void inflate(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Object object2 = R$styleable.StateListDrawable;
        object2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, object2);
        int bl2 = R$styleable.StateListDrawable_android_visible;
        boolean bl3 = true;
        boolean bl4 = object2.getBoolean(bl2, bl3);
        this.setVisible(bl4, bl3);
        this.updateStateFromTypedArray((TypedArray)object2);
        this.updateDensity(resources);
        object2.recycle();
        this.inflateChildElements((Context)object, resources, xmlPullParser, attributeSet, theme);
        object = this.getState();
        this.onStateChange((int[])object);
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        Object object;
        boolean bl2 = this.mMutated;
        if (!bl2 && (object = super.mutate()) == this) {
            object = this.mStateListState;
            ((StateListDrawable$StateListState)((Object)object)).mutate();
            this.mMutated = bl2 = true;
        }
        return this;
    }

    public boolean onStateChange(int[] object) {
        boolean bl2 = super.onStateChange((int[])object);
        Object object2 = this.mStateListState;
        int n10 = object2.indexOfStateSet((int[])object);
        if (n10 < 0) {
            object = (Object)this.mStateListState;
            object2 = StateSet.WILD_CARD;
            n10 = ((StateListDrawable$StateListState)((Object)object)).indexOfStateSet((int[])object2);
        }
        if (!(n10 = (int)(this.selectDrawable(n10) ? 1 : 0)) && !bl2) {
            n10 = 0;
            object = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public void setConstantState(DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState) {
        super.setConstantState(drawableContainer$DrawableContainerState);
        boolean bl2 = drawableContainer$DrawableContainerState instanceof StateListDrawable$StateListState;
        if (bl2) {
            drawableContainer$DrawableContainerState = (StateListDrawable$StateListState)drawableContainer$DrawableContainerState;
            this.mStateListState = drawableContainer$DrawableContainerState;
        }
    }
}

