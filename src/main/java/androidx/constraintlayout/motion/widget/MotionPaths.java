/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import androidx.constraintlayout.widget.ConstraintSet$Motion;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MotionPaths
implements Comparable {
    public static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    public static final int OFF_HEIGHT = 4;
    public static final int OFF_PATH_ROTATE = 5;
    public static final int OFF_POSITION = 0;
    public static final int OFF_WIDTH = 3;
    public static final int OFF_X = 1;
    public static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    public static String[] names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    public LinkedHashMap attributes;
    public float height;
    public int mDrawPath = 0;
    public Easing mKeyFrameEasing;
    public int mMode;
    public int mPathMotionArc;
    public float mPathRotate;
    public float mProgress;
    public double[] mTempDelta;
    public double[] mTempValue;
    public float position;
    public float time;
    public float width;
    public float x;
    public float y;

    public MotionPaths() {
        int n10;
        float f10;
        this.mPathRotate = f10 = 0.0f / 0.0f;
        this.mProgress = f10;
        this.mPathMotionArc = n10 = Key.UNSET;
        Object object = new LinkedHashMap();
        this.attributes = object;
        this.mMode = 0;
        int n11 = 18;
        object = new double[n11];
        this.mTempValue = (double[])object;
        double[] dArray = new double[n11];
        this.mTempDelta = dArray;
    }

    public MotionPaths(int n10, int n11, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int n12;
        float f10;
        this.mPathRotate = f10 = 0.0f / 0.0f;
        this.mProgress = f10;
        this.mPathMotionArc = n12 = Key.UNSET;
        Object object = new LinkedHashMap();
        this.attributes = object;
        this.mMode = 0;
        int n13 = 18;
        object = new double[n13];
        this.mTempValue = (double[])object;
        double[] dArray = new double[n13];
        this.mTempDelta = dArray;
        n13 = keyPosition.mPositionType;
        n12 = 1;
        f10 = Float.MIN_VALUE;
        if (n13 != n12) {
            n12 = 2;
            f10 = 2.8E-45f;
            if (n13 != n12) {
                this.initCartesian(keyPosition, motionPaths, motionPaths2);
                return;
            }
            this.initScreen(n10, n11, keyPosition, motionPaths, motionPaths2);
            return;
        }
        this.initPath(keyPosition, motionPaths, motionPaths2);
    }

    private boolean diff(float f10, float f11) {
        boolean bl2;
        boolean bl3 = Float.isNaN(f10);
        boolean bl4 = true;
        if (!bl3 && !(bl3 = Float.isNaN(f11))) {
            f10 = Math.abs(f10 - f11);
            int n10 = 897988541;
            f11 = 1.0E-6f;
            float f12 = f10 - f11;
            float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (f13 <= 0) {
                bl4 = false;
            }
            return bl4;
        }
        boolean bl5 = Float.isNaN(f10);
        if (bl5 == (bl2 = Float.isNaN(f11))) {
            bl4 = false;
        }
        return bl4;
    }

    private static final float xRotate(float f10, float f11, float f12, float f13, float f14, float f15) {
        f14 -= f12;
        f15 -= f13;
        return (f14 *= f11) - (f15 *= f10) + f12;
    }

    private static final float yRotate(float f10, float f11, float f12, float f13, float f14, float f15) {
        f14 -= f12;
        f15 -= f13;
        return (f14 *= f10) + (f15 *= f11) + f13;
    }

    public void applyParameters(ConstraintSet$Constraint constraintSet$Constraint) {
        float f10;
        int n10;
        float f11;
        int n11;
        Iterator iterator2 = Easing.getInterpolator(constraintSet$Constraint.motion.mTransitionEasing);
        this.mKeyFrameEasing = iterator2;
        iterator2 = constraintSet$Constraint.motion;
        this.mPathMotionArc = n11 = ((ConstraintSet$Motion)iterator2).mPathMotionArc;
        this.mPathRotate = f11 = ((ConstraintSet$Motion)iterator2).mPathRotate;
        this.mDrawPath = n10 = ((ConstraintSet$Motion)iterator2).mDrawPath;
        this.mProgress = f10 = constraintSet$Constraint.propertySet.mProgress;
        iterator2 = constraintSet$Constraint.mCustomConstraints.keySet().iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            ConstraintAttribute$AttributeType constraintAttribute$AttributeType;
            String string2 = (String)iterator2.next();
            ConstraintAttribute constraintAttribute = (ConstraintAttribute)constraintSet$Constraint.mCustomConstraints.get(string2);
            Object object = constraintAttribute.getType();
            if (object == (constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.STRING_TYPE)) continue;
            object = this.attributes;
            ((HashMap)object).put(string2, constraintAttribute);
        }
    }

    public int compareTo(MotionPaths motionPaths) {
        float f10 = this.position;
        float f11 = motionPaths.position;
        return Float.compare(f10, f11);
    }

    public void different(MotionPaths motionPaths, boolean[] blArray, String[] stringArray, boolean bl2) {
        boolean bl3;
        boolean bl4 = blArray[0];
        float f10 = this.position;
        float f11 = motionPaths.position;
        boolean bl5 = this.diff(f10, f11);
        blArray[0] = bl4 |= bl5;
        int n10 = 1;
        bl4 = blArray[n10];
        f10 = this.x;
        f11 = motionPaths.x;
        bl5 = this.diff(f10, f11) | bl2;
        blArray[n10] = bl4 |= bl5;
        n10 = 2;
        bl4 = blArray[n10];
        f10 = this.y;
        f11 = motionPaths.y;
        bl5 = this.diff(f10, f11);
        blArray[n10] = bl2 = bl2 | bl5 | bl4;
        n10 = 3;
        bl2 = blArray[n10];
        float f12 = this.width;
        f10 = motionPaths.width;
        bl4 = this.diff(f12, f10);
        blArray[n10] = bl2 |= bl4;
        n10 = 4;
        bl2 = blArray[n10];
        f12 = this.height;
        float f13 = motionPaths.height;
        blArray[n10] = bl3 = this.diff(f12, f13) | bl2;
    }

    public void fillStandard(double[] dArray, int[] nArray) {
        int n10 = 6;
        float[] fArray = new float[n10];
        float f10 = this.position;
        fArray[0] = f10;
        fArray[1] = f10 = this.x;
        fArray[2] = f10 = this.y;
        fArray[3] = f10 = this.width;
        fArray[4] = f10 = this.height;
        f10 = this.mPathRotate;
        int n11 = 5;
        fArray[n11] = f10;
        int n12 = 0;
        f10 = 0.0f;
        for (int i10 = 0; i10 < (n11 = nArray.length); ++i10) {
            double d10;
            n11 = nArray[i10];
            if (n11 >= n10) continue;
            n11 = n12 + 1;
            int n13 = nArray[i10];
            float f11 = fArray[n13];
            dArray[n12] = d10 = (double)f11;
            n12 = n11;
        }
    }

    public void getBounds(int[] nArray, double[] dArray, float[] fArray, int n10) {
        int n11;
        float f10 = this.width;
        float f11 = this.height;
        for (int i10 = 0; i10 < (n11 = nArray.length); ++i10) {
            double d10 = dArray[i10];
            float f12 = (float)d10;
            int n12 = nArray[i10];
            int n13 = 3;
            if (n12 != n13) {
                n13 = 4;
                if (n12 != n13) continue;
                f11 = f12;
                continue;
            }
            f10 = f12;
        }
        fArray[n10] = f10;
        fArray[++n10] = f11;
    }

    public void getCenter(int[] nArray, double[] dArray, float[] fArray, int n10) {
        float f10 = this.x;
        float f11 = this.y;
        float f12 = this.width;
        float f13 = this.height;
        int n11 = 0;
        while (true) {
            int n12 = nArray.length;
            int n13 = 1;
            if (n11 >= n12) break;
            double d10 = dArray[n11];
            float f14 = (float)d10;
            int n14 = nArray[n11];
            if (n14 != n13) {
                n13 = 2;
                if (n14 != n13) {
                    n13 = 3;
                    if (n14 != n13) {
                        n13 = 4;
                        if (n14 == n13) {
                            f13 = f14;
                        }
                    } else {
                        f12 = f14;
                    }
                } else {
                    f11 = f14;
                }
            } else {
                f10 = f14;
            }
            ++n11;
        }
        float f15 = 2.0f;
        fArray[n10] = f10 = f10 + (f12 /= f15) + 0.0f;
        fArray[n10 += n13] = f11 = f11 + (f13 /= f15) + 0.0f;
    }

    public int getCustomData(String object, double[] dArray, int n10) {
        int n11;
        LinkedHashMap linkedHashMap = this.attributes;
        int n12 = ((ConstraintAttribute)(object = (ConstraintAttribute)linkedHashMap.get(object))).noOfInterpValues();
        if (n12 == (n11 = 1)) {
            double d10;
            dArray[n10] = d10 = (double)((ConstraintAttribute)object).getValueToInterpolate();
            return n11;
        }
        n12 = ((ConstraintAttribute)object).noOfInterpValues();
        float[] fArray = new float[n12];
        ((ConstraintAttribute)object).getValuesToInterpolate(fArray);
        object = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            double d11;
            int n13 = n10 + 1;
            float f10 = fArray[i10];
            dArray[n10] = d11 = (double)f10;
            n10 = n13;
        }
        return n12;
    }

    public int getCustomDataCount(String string2) {
        return ((ConstraintAttribute)this.attributes.get(string2)).noOfInterpValues();
    }

    public void getRect(int[] nArray, double[] dArray, float[] fArray, int n10) {
        float f10;
        int n11;
        float f11 = this.x;
        float f12 = this.y;
        float f13 = this.width;
        float f14 = this.height;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < (n11 = nArray.length); ++i10) {
            double d10 = dArray[i10];
            f10 = (float)d10;
            int n12 = nArray[i10];
            int n13 = 1;
            if (n12 != n13) {
                n13 = 2;
                if (n12 != n13) {
                    n13 = 3;
                    if (n12 != n13) {
                        n13 = 4;
                        if (n12 != n13) continue;
                        f14 = f10;
                        continue;
                    }
                    f13 = f10;
                    continue;
                }
                f12 = f10;
                continue;
            }
            f11 = f10;
        }
        f14 += f12;
        float f16 = 0.0f / 0.0f;
        Float.isNaN(f16);
        Float.isNaN(f16);
        float f17 = f11 + 0.0f;
        f15 = f12 + 0.0f;
        f10 = (f13 += f11) + 0.0f;
        float f18 = f14 + 0.0f;
        int n14 = n10 + 1;
        fArray[n10] = f17;
        int n15 = n14 + 1;
        fArray[n14] = f15;
        n14 = n15 + 1;
        fArray[n15] = f10;
        n15 = n14 + 1;
        fArray[n14] = f12 += 0.0f;
        n14 = n15 + 1;
        fArray[n15] = f13 += 0.0f;
        n15 = n14 + 1;
        fArray[n14] = f18;
        n14 = n15 + 1;
        fArray[n15] = f11 += 0.0f;
        fArray[n14] = f14 += 0.0f;
    }

    public boolean hasCustomData(String string2) {
        return this.attributes.containsKey(string2);
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10;
        int n10;
        float f11;
        MotionPaths motionPaths3 = this;
        KeyPosition keyPosition2 = keyPosition;
        Object object = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        int n11 = keyPosition.mFramePosition;
        this.time = f11 = (float)n11 / 100.0f;
        this.mDrawPath = n10 = keyPosition.mDrawPath;
        float f12 = keyPosition.mPercentWidth;
        n10 = Float.isNaN(f12) ? 1 : 0;
        f12 = n10 != 0 ? f11 : keyPosition.mPercentWidth;
        float f13 = keyPosition2.mPercentHeight;
        boolean bl2 = Float.isNaN(f13);
        f13 = bl2 ? f11 : keyPosition2.mPercentHeight;
        float f14 = motionPaths4.width;
        float f15 = ((MotionPaths)object).width;
        float f16 = f14 - f15;
        float f17 = motionPaths4.height;
        float f18 = ((MotionPaths)object).height;
        float f19 = f17 - f18;
        motionPaths3.position = f10 = motionPaths3.time;
        f10 = ((MotionPaths)object).x;
        float f20 = 2.0f;
        float f21 = f15 / f20 + f10;
        float f22 = ((MotionPaths)object).y;
        float f23 = f18 / f20;
        f23 = f22 + f23;
        float f24 = motionPaths4.x;
        f24 += (f14 /= f20);
        float f25 = motionPaths4.y;
        f25 += (f17 /= f20);
        f14 = (f24 -= f21) * f11;
        f10 += f14;
        f16 *= f12;
        f12 = f16 / f20;
        motionPaths3.x = f14 = (float)((int)(f10 -= f12));
        f14 = (f25 -= f23) * f11;
        f22 += f14;
        f19 *= f13;
        f13 = f19 / f20;
        motionPaths3.y = f22 = (float)((int)(f22 - f13));
        motionPaths3.width = f22 = (float)((int)(f15 += f16));
        int n12 = (int)(f18 += f19);
        motionPaths3.height = f22 = (float)n12;
        keyPosition2 = keyPosition;
        f14 = keyPosition.mPercentX;
        boolean bl3 = Float.isNaN(f14);
        f14 = bl3 ? f11 : keyPosition.mPercentX;
        f15 = keyPosition2.mAltPercentY;
        boolean bl4 = Float.isNaN(f15);
        f16 = 0.0f;
        if (bl4) {
            bl4 = false;
            f15 = 0.0f;
        } else {
            f15 = keyPosition2.mAltPercentY;
        }
        f17 = keyPosition2.mPercentY;
        boolean bl5 = Float.isNaN(f17);
        if (!bl5) {
            f11 = keyPosition2.mPercentY;
        }
        f17 = keyPosition2.mAltPercentX;
        bl5 = Float.isNaN(f17);
        if (!bl5) {
            f16 = keyPosition2.mAltPercentX;
        }
        motionPaths3.mMode = 2;
        f18 = motionPaths.x;
        motionPaths3.x = f12 = (float)((int)((f18 += (f14 *= f24)) + (f16 *= f25) - f12));
        f12 = motionPaths.y;
        motionPaths3.y = f24 = (float)((int)((f12 += (f24 *= f15)) + (f25 *= f11) - f13));
        motionPaths3.mKeyFrameEasing = object = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        motionPaths3.mPathMotionArc = n12 = keyPosition2.mPathMotionArc;
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int n10;
        int n11;
        float f10;
        MotionPaths motionPaths3 = this;
        Object object = keyPosition;
        MotionPaths motionPaths4 = motionPaths;
        MotionPaths motionPaths5 = motionPaths2;
        int n12 = keyPosition.mFramePosition;
        this.time = f10 = (float)n12 / 100.0f;
        this.mDrawPath = n11 = keyPosition.mDrawPath;
        float f11 = keyPosition.mPercentWidth;
        n11 = Float.isNaN(f11) ? 1 : 0;
        f11 = n11 != 0 ? f10 : keyPosition.mPercentWidth;
        float f12 = ((KeyPosition)object).mPercentHeight;
        boolean bl2 = Float.isNaN(f12);
        f12 = bl2 ? f10 : ((KeyPosition)object).mPercentHeight;
        float f13 = motionPaths5.width;
        float f14 = motionPaths4.width;
        f13 -= f14;
        f14 = motionPaths5.height;
        float f15 = motionPaths4.height;
        f14 -= f15;
        motionPaths3.position = f15 = motionPaths3.time;
        f15 = ((KeyPosition)object).mPercentX;
        int n13 = Float.isNaN(f15);
        if (n13 == 0) {
            f10 = ((KeyPosition)object).mPercentX;
        }
        f15 = motionPaths4.x;
        float f16 = motionPaths4.width;
        float f17 = 2.0f;
        float f18 = f16 / f17 + f15;
        float f19 = motionPaths4.y;
        float f20 = motionPaths4.height;
        float f21 = f20 / f17 + f19;
        float f22 = motionPaths5.x;
        float f23 = motionPaths5.width / f17;
        f22 += f23;
        f23 = motionPaths5.y;
        float f24 = motionPaths5.height / f17;
        f23 += f24;
        f24 = (f22 -= f18) * f10;
        f15 += f24;
        f13 *= f11;
        f11 = f13 / f17;
        motionPaths3.x = f15 = (float)((int)(f15 - f11));
        f19 += (f10 *= (f23 -= f21));
        f14 *= f12;
        f12 = f14 / f17;
        n13 = (int)(f19 -= f12);
        motionPaths3.y = f15 = (float)n13;
        f16 += f13;
        motionPaths3.width = f13 = (float)((int)f16);
        int n14 = (int)(f20 += f14);
        motionPaths3.height = f13 = (float)n14;
        KeyPosition keyPosition2 = keyPosition;
        f14 = keyPosition.mPercentY;
        boolean bl3 = Float.isNaN(f14);
        if (bl3) {
            bl3 = false;
            f14 = 0.0f;
        } else {
            f14 = keyPosition.mPercentY;
        }
        f23 = -f23 * f14;
        motionPaths3.mMode = 1;
        motionPaths3.x = f24 = (float)((int)(motionPaths.x + f24 - f11));
        motionPaths3.y = f10 = (float)((int)(motionPaths.y + f10 - f12));
        motionPaths3.x = f24 += f23;
        motionPaths3.y = f10 += (f22 *= f14);
        motionPaths3.mKeyFrameEasing = object = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        motionPaths3.mPathMotionArc = n10 = keyPosition2.mPathMotionArc;
    }

    public void initScreen(int n10, int n11, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10;
        int n12;
        float f11;
        MotionPaths motionPaths3 = this;
        KeyPosition keyPosition2 = keyPosition;
        Object object = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        int n13 = keyPosition.mFramePosition;
        this.time = f11 = (float)n13 / 100.0f;
        this.mDrawPath = n12 = keyPosition.mDrawPath;
        float f12 = keyPosition.mPercentWidth;
        n12 = Float.isNaN(f12) ? 1 : 0;
        f12 = n12 != 0 ? f11 : keyPosition.mPercentWidth;
        float f13 = keyPosition2.mPercentHeight;
        boolean bl2 = Float.isNaN(f13);
        f13 = bl2 ? f11 : keyPosition2.mPercentHeight;
        float f14 = motionPaths4.width;
        float f15 = ((MotionPaths)object).width;
        float f16 = f14 - f15;
        float f17 = motionPaths4.height;
        float f18 = ((MotionPaths)object).height;
        float f19 = f17 - f18;
        motionPaths3.position = f10 = motionPaths3.time;
        f10 = ((MotionPaths)object).x;
        float f20 = 2.0f;
        float f21 = f15 / f20 + f10;
        float f22 = ((MotionPaths)object).y;
        float f23 = f18 / f20;
        f23 = f22 + f23;
        float f24 = motionPaths4.x;
        f24 += (f14 /= f20);
        float f25 = motionPaths4.y;
        f25 += (f17 /= f20);
        f24 -= f21;
        f25 -= f23;
        f10 += (f24 *= f11);
        f24 = (f16 *= f12) / f20;
        f10 -= f24;
        motionPaths3.x = f24 = (float)((int)f10);
        f24 = (f19 *= f13) / f20;
        motionPaths3.y = f24 = (float)((int)((f22 += (f25 *= f11)) - f24));
        motionPaths3.width = f24 = (float)((int)(f15 += f16));
        motionPaths3.height = f24 = (float)((int)(f18 += f19));
        int n14 = 3;
        f24 = 4.2E-45f;
        motionPaths3.mMode = n14;
        keyPosition2 = keyPosition;
        f22 = keyPosition.mPercentX;
        int n15 = Float.isNaN(f22);
        if (n15 == 0) {
            n15 = n10;
            f22 = n10;
            f25 = motionPaths3.width;
            n15 = (int)(f22 - f25);
            f25 = keyPosition.mPercentX;
            f22 = n15;
            n15 = (int)(f25 *= f22);
            motionPaths3.x = f22 = (float)n15;
        }
        if ((n15 = (int)(Float.isNaN(f22 = keyPosition2.mPercentY) ? 1 : 0)) == 0) {
            n15 = n11;
            f22 = n11;
            f25 = motionPaths3.height;
            n15 = (int)(f22 - f25);
            f25 = keyPosition2.mPercentY;
            f22 = n15;
            n15 = (int)(f25 *= f22);
            motionPaths3.y = f22 = (float)n15;
        }
        motionPaths3.mKeyFrameEasing = object = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        motionPaths3.mPathMotionArc = n14 = keyPosition2.mPathMotionArc;
    }

    public void setBounds(float f10, float f11, float f12, float f13) {
        this.x = f10;
        this.y = f11;
        this.width = f12;
        this.height = f13;
    }

    public void setDpDt(float f10, float f11, float[] fArray, int[] nArray, double[] dArray, double[] dArray2) {
        int[] nArray2 = nArray;
        int n10 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        while (true) {
            int n11 = nArray2.length;
            int n12 = 1;
            if (n10 >= n11) break;
            float f17 = (float)dArray[n10];
            double cfr_ignored_0 = dArray2[n10];
            int n13 = nArray2[n10];
            if (n13 != n12) {
                n12 = 2;
                if (n13 != n12) {
                    n12 = 3;
                    if (n13 != n12) {
                        n12 = 4;
                        if (n13 == n12) {
                            f16 = f17;
                        }
                    } else {
                        f14 = f17;
                    }
                } else {
                    f15 = f17;
                }
            } else {
                f13 = f17;
            }
            ++n10;
        }
        float f18 = 0.0f * f14;
        f12 = 2.0f;
        f18 = 0.0f * f16 / f12;
        f15 -= f18;
        f18 = 1.0f;
        f14 *= f18;
        f16 *= f18;
        f14 += (f13 -= (f18 /= f12));
        f16 += f15;
        f12 = f18 - f10;
        f13 *= f12;
        fArray[0] = f13 = f13 + (f14 *= f10) + 0.0f;
        f15 *= (f18 -= f11);
        fArray[n12] = f15 = f15 + (f16 *= f11) + 0.0f;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setView(View view, int[] nArray, double[] dArray, double[] dArray2, double[] dArray3) {
        int n10;
        double d10;
        float f10;
        double d11;
        float f11;
        float f12;
        double d12;
        int n11;
        double[] dArray4;
        int n12;
        double[] dArray5;
        int n13;
        double[] dArray6;
        MotionPaths motionPaths = this;
        View view2 = view;
        int[] nArray2 = nArray;
        float f13 = this.x;
        float f14 = this.y;
        float f15 = this.width;
        float f16 = this.height;
        int n14 = nArray.length;
        int n15 = 1;
        float f17 = Float.MIN_VALUE;
        if (n14 != 0) {
            dArray6 = this.mTempValue;
            n14 = dArray6.length;
            n13 = nArray.length - n15;
            if (n14 <= (n13 = nArray[n13])) {
                n14 = nArray.length - n15;
                n14 = nArray[n14] + n15;
                dArray5 = new double[n14];
                this.mTempValue = dArray5;
                dArray6 = new double[n14];
                this.mTempDelta = dArray6;
            }
        }
        dArray6 = motionPaths.mTempValue;
        double d13 = 0.0 / 0.0;
        Arrays.fill(dArray6, d13);
        dArray5 = null;
        for (n13 = 0; n13 < (n12 = nArray2.length); ++n13) {
            dArray4 = motionPaths.mTempValue;
            n11 = nArray2[n13];
            dArray4[n11] = d12 = dArray[n13];
            dArray4 = motionPaths.mTempDelta;
            n11 = nArray2[n13];
            dArray4[n11] = d12 = dArray2[n13];
        }
        dArray4 = null;
        n11 = 2143289344;
        float f18 = 0.0f / 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        float f22 = 0.0f;
        for (n12 = 0; n12 < (n13 = (dArray6 = motionPaths.mTempValue).length); ++n12) {
            block17: {
                block13: {
                    block12: {
                        block14: {
                            block15: {
                                block16: {
                                    double d14;
                                    double d15;
                                    block11: {
                                        double d16;
                                        n14 = Double.isNaN(dArray6[n12]) ? 1 : 0;
                                        d15 = 0.0;
                                        if (n14 == 0 || dArray3 != null && (n14 = (int)((d16 = (d14 = dArray3[n12]) - d15) == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1))) != 0) break block11;
                                        f12 = f13;
                                        n14 = n15;
                                        f11 = f17;
                                        break block12;
                                    }
                                    if (dArray3 != null) {
                                        d15 = dArray3[n12];
                                    }
                                    if ((n14 = (int)(Double.isNaN(d14 = (dArray6 = motionPaths.mTempValue)[n12]) ? 1 : 0)) == 0) {
                                        dArray6 = motionPaths.mTempValue;
                                        d14 = dArray6[n12];
                                        d15 = d14 + d15;
                                    }
                                    f12 = f13;
                                    d11 = d15;
                                    f10 = (float)d15;
                                    double[] dArray7 = motionPaths.mTempDelta;
                                    d10 = dArray7[n12];
                                    f13 = (float)d10;
                                    n14 = 1;
                                    f11 = Float.MIN_VALUE;
                                    if (n12 == n14) break block13;
                                    n15 = 2;
                                    f17 = 2.8E-45f;
                                    if (n12 == n15) break block14;
                                    n15 = 3;
                                    f17 = 4.2E-45f;
                                    if (n12 == n15) break block15;
                                    n15 = 4;
                                    f17 = 5.6E-45f;
                                    if (n12 == n15) break block16;
                                    n10 = 5;
                                    f13 = 7.0E-45f;
                                    if (n12 != n10) break block12;
                                    f13 = f12;
                                    f18 = f10;
                                    break block17;
                                }
                                f16 = f10;
                                f22 = f13;
                                break block12;
                            }
                            f15 = f10;
                            f20 = f13;
                            break block12;
                        }
                        f14 = f10;
                        f21 = f13;
                    }
                    f13 = f12;
                    break block17;
                }
                f19 = f13;
                f13 = f10;
            }
            n15 = n14;
            f17 = f11;
        }
        f12 = f13;
        n14 = n15;
        f11 = f17;
        int n16 = Float.isNaN(f18);
        if (n16 != 0) {
            n16 = 2143289344;
            f10 = 0.0f / 0.0f;
            n10 = Float.isNaN(f10);
            if (n10 == 0) {
                view2.setRotation(f10);
            }
        } else {
            n16 = 2143289344;
            f10 = 0.0f / 0.0f;
            n10 = Float.isNaN(f10);
            if (n10 != 0) {
                n16 = 0;
                f10 = 0.0f;
                nArray2 = null;
            }
            n10 = 0x40000000;
            f13 = 2.0f;
            d11 = f10;
            d10 = f18;
            double d17 = f21 += (f22 /= f13);
            d12 = f19 += (f20 /= f13);
            d17 = Math.toDegrees(Math.atan2(d17, d12));
            f10 = (float)(d11 += (d10 += d17));
            view2.setRotation(f10);
        }
        f10 = 0.5f;
        f13 = f12 + f10;
        n15 = (int)f13;
        n16 = (int)(f14 += f10);
        n10 = (int)(f13 += f15);
        int n17 = (int)(f14 += f16);
        int n18 = n10 - n15;
        int n19 = n17 - n16;
        n13 = view.getMeasuredWidth();
        int n20 = n18 == n13 && n19 == (n13 = view.getMeasuredHeight()) ? 0 : n14;
        if (n20 != 0) {
            n14 = 0x40000000;
            f11 = 2.0f;
            n18 = View.MeasureSpec.makeMeasureSpec((int)n18, (int)n14);
            n19 = View.MeasureSpec.makeMeasureSpec((int)n19, (int)n14);
            view2.measure(n18, n19);
        }
        view2.layout(n15, n16, n10, n17);
    }
}

