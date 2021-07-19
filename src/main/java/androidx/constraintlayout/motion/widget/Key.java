/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Key {
    public static final String ALPHA = "alpha";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String PIVOT_X = "transformPivotX";
    public static final String PIVOT_Y = "transformPivotY";
    public static final String PROGRESS = "progress";
    public static final String ROTATION = "rotation";
    public static final String ROTATION_X = "rotationX";
    public static final String ROTATION_Y = "rotationY";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = 255;
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_VARIES_BY = "waveVariesBy";
    public HashMap mCustomConstraints;
    public int mFramePosition;
    public int mTargetId;
    public String mTargetString;
    public int mType;

    public Key() {
        int n10;
        this.mFramePosition = n10 = UNSET;
        this.mTargetId = n10;
        this.mTargetString = null;
    }

    public abstract void addValues(HashMap var1);

    public abstract void getAttributeNames(HashSet var1);

    public abstract void load(Context var1, AttributeSet var2);

    public boolean matches(String string2) {
        String string3 = this.mTargetString;
        if (string3 != null && string2 != null) {
            return string2.matches(string3);
        }
        return false;
    }

    public void setInterpolation(HashMap hashMap) {
    }

    public abstract void setValue(String var1, Object var2);

    public boolean toBoolean(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Boolean;
        if (bl3) {
            object = (Boolean)object;
            bl2 = (Boolean)object;
        } else {
            object = object.toString();
            bl2 = Boolean.parseBoolean((String)object);
        }
        return bl2;
    }

    public float toFloat(Object object) {
        float f10;
        boolean bl2 = object instanceof Float;
        if (bl2) {
            object = (Float)object;
            f10 = ((Float)object).floatValue();
        } else {
            object = object.toString();
            f10 = Float.parseFloat((String)object);
        }
        return f10;
    }

    public int toInt(Object object) {
        int n10;
        boolean bl2 = object instanceof Integer;
        if (bl2) {
            object = (Integer)object;
            n10 = (Integer)object;
        } else {
            object = object.toString();
            n10 = Integer.parseInt((String)object);
        }
        return n10;
    }
}

