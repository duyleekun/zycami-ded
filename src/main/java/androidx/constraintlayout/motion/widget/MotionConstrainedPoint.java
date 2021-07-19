/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.SplineSet
 *  androidx.constraintlayout.motion.widget.SplineSet$CustomSet
 */
package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import androidx.constraintlayout.widget.ConstraintSet$Motion;
import androidx.constraintlayout.widget.ConstraintSet$PropertySet;
import androidx.constraintlayout.widget.ConstraintSet$Transform;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MotionConstrainedPoint
implements Comparable {
    public static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    public static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    public static String[] names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    private float alpha;
    private boolean applyElevation;
    public LinkedHashMap attributes;
    private float elevation;
    private float height;
    private int mDrawPath;
    private Easing mKeyFrameEasing;
    public int mMode;
    private float mPathRotate;
    private float mPivotX;
    private float mPivotY;
    private float mProgress;
    public double[] mTempDelta;
    public double[] mTempValue;
    public int mVisibilityMode;
    private float position;
    private float rotation;
    private float rotationX;
    public float rotationY;
    private float scaleX;
    private float scaleY;
    private float translationX;
    private float translationY;
    private float translationZ;
    public int visibility;
    private float width;
    private float x;
    private float y;

    public MotionConstrainedPoint() {
        float f10;
        this.alpha = f10 = 1.0f;
        this.mVisibilityMode = 0;
        this.applyElevation = false;
        this.elevation = 0.0f;
        this.rotation = 0.0f;
        this.rotationX = 0.0f;
        this.rotationY = 0.0f;
        this.scaleX = f10;
        this.scaleY = f10;
        this.mPivotX = f10 = 0.0f / 0.0f;
        this.mPivotY = f10;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.translationZ = 0.0f;
        this.mDrawPath = 0;
        this.mPathRotate = f10;
        this.mProgress = f10;
        Object object = new LinkedHashMap();
        this.attributes = object;
        this.mMode = 0;
        int n10 = 18;
        double[] dArray = new double[n10];
        this.mTempValue = dArray;
        object = new double[n10];
        this.mTempDelta = (double[])object;
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

    public void addValues(HashMap hashMap, int n10) {
        boolean bl2;
        Iterator iterator2 = hashMap.keySet().iterator();
        block32: while (bl2 = iterator2.hasNext()) {
            float f10;
            Object object;
            String string2;
            CharSequence charSequence = (String)iterator2.next();
            Object object2 = (SplineSet)hashMap.get(charSequence);
            ((String)charSequence).hashCode();
            int n11 = -1;
            int n12 = ((String)charSequence).hashCode();
            int n13 = 1;
            switch (n12) {
                default: {
                    break;
                }
                case 92909918: {
                    string2 = "alpha";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 13;
                    break;
                }
                case 37232917: {
                    string2 = "transitionPathRotate";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 12;
                    break;
                }
                case -4379043: {
                    string2 = "elevation";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 11;
                    break;
                }
                case -40300674: {
                    string2 = "rotation";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 10;
                    break;
                }
                case -760884509: {
                    string2 = "transformPivotY";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 9;
                    break;
                }
                case -760884510: {
                    string2 = "transformPivotX";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 8;
                    break;
                }
                case -908189617: {
                    string2 = "scaleY";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 7;
                    break;
                }
                case -908189618: {
                    string2 = "scaleX";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 6;
                    break;
                }
                case -1001078227: {
                    string2 = "progress";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 5;
                    break;
                }
                case -1225497655: {
                    string2 = "translationZ";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 4;
                    break;
                }
                case -1225497656: {
                    string2 = "translationY";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 3;
                    break;
                }
                case -1225497657: {
                    string2 = "translationX";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 2;
                    break;
                }
                case -1249320805: {
                    string2 = "rotationY";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = n13;
                    break;
                }
                case -1249320806: {
                    string2 = "rotationX";
                    n12 = ((String)charSequence).equals(string2) ? 1 : 0;
                    if (n12 == 0) break;
                    n11 = 0;
                    object = null;
                }
            }
            n12 = 1065353216;
            float f11 = 1.0f;
            float f12 = 0.0f;
            switch (n11) {
                default: {
                    object = "CUSTOM";
                    n11 = ((String)charSequence).startsWith((String)object) ? 1 : 0;
                    string2 = TAG;
                    if (n11 != 0) {
                        Serializable serializable = this.attributes;
                        object = ((String)charSequence).split(",")[n13];
                        n13 = ((HashMap)serializable).containsKey(object) ? 1 : 0;
                        if (n13 != 0) {
                            serializable = this.attributes;
                            object = (ConstraintAttribute)((LinkedHashMap)serializable).get(object);
                            n13 = object2 instanceof SplineSet.CustomSet;
                            if (n13 != 0) {
                                object2 = (SplineSet.CustomSet)object2;
                                object2.setPoint(n10, (ConstraintAttribute)object);
                                continue block32;
                            }
                            serializable = new StringBuilder();
                            ((StringBuilder)serializable).append((String)charSequence);
                            ((StringBuilder)serializable).append(" splineSet not a CustomSet frame = ");
                            ((StringBuilder)serializable).append(n10);
                            ((StringBuilder)serializable).append(", value");
                            f10 = ((ConstraintAttribute)object).getValueToInterpolate();
                            ((StringBuilder)serializable).append(f10);
                            ((StringBuilder)serializable).append(object2);
                            charSequence = ((StringBuilder)serializable).toString();
                            Log.e((String)string2, (String)charSequence);
                            continue block32;
                        }
                        charSequence = new StringBuilder();
                        object2 = "UNKNOWN customName ";
                        ((StringBuilder)charSequence).append((String)object2);
                        ((StringBuilder)charSequence).append((String)object);
                        charSequence = ((StringBuilder)charSequence).toString();
                        Log.e((String)string2, (String)charSequence);
                        continue block32;
                    }
                    object2 = new StringBuilder();
                    object = "UNKNOWN spline ";
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append((String)charSequence);
                    charSequence = ((StringBuilder)object2).toString();
                    Log.e((String)string2, (String)charSequence);
                    continue block32;
                }
                case 13: {
                    f10 = this.alpha;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f11 = this.alpha;
                    }
                    object2.setPoint(n10, f11);
                    continue block32;
                }
                case 12: {
                    f10 = this.mPathRotate;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.mPathRotate;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 11: {
                    f10 = this.elevation;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.elevation;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 10: {
                    f10 = this.rotation;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.rotation;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 9: {
                    f10 = this.mPivotY;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.mPivotY;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 8: {
                    f10 = this.mPivotX;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.mPivotX;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 7: {
                    f10 = this.scaleY;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f11 = this.scaleY;
                    }
                    object2.setPoint(n10, f11);
                    continue block32;
                }
                case 6: {
                    f10 = this.scaleX;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f11 = this.scaleX;
                    }
                    object2.setPoint(n10, f11);
                    continue block32;
                }
                case 5: {
                    f10 = this.mProgress;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.mProgress;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 4: {
                    f10 = this.translationZ;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.translationZ;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 3: {
                    f10 = this.translationY;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.translationY;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 2: {
                    f10 = this.translationX;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.translationX;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 1: {
                    f10 = this.rotationY;
                    bl2 = Float.isNaN(f10);
                    if (!bl2) {
                        f12 = this.rotationY;
                    }
                    object2.setPoint(n10, f12);
                    continue block32;
                }
                case 0: 
            }
            f10 = this.rotationX;
            bl2 = Float.isNaN(f10);
            if (!bl2) {
                f12 = this.rotationX;
            }
            object2.setPoint(n10, f12);
        }
    }

    public void applyParameters(View view) {
        float f10;
        float f11;
        int n10;
        this.visibility = n10 = view.getVisibility();
        n10 = view.getVisibility();
        if (n10 != 0) {
            n10 = 0;
            f11 = 0.0f;
        } else {
            f11 = view.getAlpha();
        }
        this.alpha = f11;
        f11 = 0.0f;
        this.applyElevation = false;
        n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            this.elevation = f10 = view.getElevation();
        }
        this.rotation = f10 = view.getRotation();
        this.rotationX = f10 = view.getRotationX();
        this.rotationY = f10 = view.getRotationY();
        this.scaleX = f10 = view.getScaleX();
        this.scaleY = f10 = view.getScaleY();
        this.mPivotX = f10 = view.getPivotX();
        this.mPivotY = f10 = view.getPivotY();
        this.translationX = f10 = view.getTranslationX();
        this.translationY = f10 = view.getTranslationY();
        if (n10 >= n11) {
            float f12;
            this.translationZ = f12 = view.getTranslationZ();
        }
    }

    public void applyParameters(ConstraintSet$Constraint constraintSet$Constraint) {
        float f10;
        float f11;
        int n10;
        int n11;
        int n12;
        Iterator iterator2 = constraintSet$Constraint.propertySet;
        this.mVisibilityMode = n12 = ((ConstraintSet$PropertySet)iterator2).mVisibilityMode;
        this.visibility = n11 = ((ConstraintSet$PropertySet)iterator2).visibility;
        if (n11 != 0 && n12 == 0) {
            n10 = 0;
            f11 = 0.0f;
            iterator2 = null;
        } else {
            f11 = ((ConstraintSet$PropertySet)iterator2).alpha;
        }
        this.alpha = f11;
        iterator2 = constraintSet$Constraint.transform;
        n12 = ((ConstraintSet$Transform)iterator2).applyElevation ? 1 : 0;
        this.applyElevation = n12;
        this.elevation = f10 = ((ConstraintSet$Transform)iterator2).elevation;
        this.rotation = f10 = ((ConstraintSet$Transform)iterator2).rotation;
        this.rotationX = f10 = ((ConstraintSet$Transform)iterator2).rotationX;
        this.rotationY = f10 = ((ConstraintSet$Transform)iterator2).rotationY;
        this.scaleX = f10 = ((ConstraintSet$Transform)iterator2).scaleX;
        this.scaleY = f10 = ((ConstraintSet$Transform)iterator2).scaleY;
        this.mPivotX = f10 = ((ConstraintSet$Transform)iterator2).transformPivotX;
        this.mPivotY = f10 = ((ConstraintSet$Transform)iterator2).transformPivotY;
        this.translationX = f10 = ((ConstraintSet$Transform)iterator2).translationX;
        this.translationY = f10 = ((ConstraintSet$Transform)iterator2).translationY;
        this.translationZ = f11 = ((ConstraintSet$Transform)iterator2).translationZ;
        iterator2 = Easing.getInterpolator(constraintSet$Constraint.motion.mTransitionEasing);
        this.mKeyFrameEasing = iterator2;
        iterator2 = constraintSet$Constraint.motion;
        this.mPathRotate = f10 = ((ConstraintSet$Motion)iterator2).mPathRotate;
        this.mDrawPath = n10 = ((ConstraintSet$Motion)iterator2).mDrawPath;
        this.mProgress = f11 = constraintSet$Constraint.propertySet.mProgress;
        iterator2 = constraintSet$Constraint.mCustomConstraints.keySet().iterator();
        while ((n12 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            ConstraintAttribute$AttributeType constraintAttribute$AttributeType;
            String string2 = (String)iterator2.next();
            ConstraintAttribute constraintAttribute = (ConstraintAttribute)constraintSet$Constraint.mCustomConstraints.get(string2);
            Object object = constraintAttribute.getType();
            if (object == (constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.STRING_TYPE)) continue;
            object = this.attributes;
            ((HashMap)object).put(string2, constraintAttribute);
        }
    }

    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        float f10 = this.position;
        float f11 = motionConstrainedPoint.position;
        return Float.compare(f10, f11);
    }

    public void different(MotionConstrainedPoint object, HashSet hashSet) {
        float f10;
        boolean bl2;
        int n10;
        int n11;
        String string2;
        float f11;
        float f12 = this.alpha;
        float f13 = ((MotionConstrainedPoint)object).alpha;
        int n12 = this.diff(f12, f13);
        String string3 = "alpha";
        if (n12 != 0) {
            hashSet.add(string3);
        }
        if ((n12 = this.diff(f12 = this.elevation, f11 = ((MotionConstrainedPoint)object).elevation)) != 0) {
            string2 = "elevation";
            hashSet.add(string2);
        }
        if ((n12 = this.visibility) != (n11 = ((MotionConstrainedPoint)object).visibility) && (n10 = this.mVisibilityMode) == 0 && (n12 == 0 || n11 == 0)) {
            hashSet.add(string3);
        }
        if ((n12 = (int)(this.diff(f12 = this.rotation, f13 = ((MotionConstrainedPoint)object).rotation) ? 1 : 0)) != 0) {
            string2 = "rotation";
            hashSet.add(string2);
        }
        if ((n12 = (int)(Float.isNaN(f12 = this.mPathRotate) ? 1 : 0)) == 0 || (n12 = (int)(Float.isNaN(f12 = ((MotionConstrainedPoint)object).mPathRotate) ? 1 : 0)) == 0) {
            string2 = "transitionPathRotate";
            hashSet.add(string2);
        }
        if ((n12 = (int)(Float.isNaN(f12 = this.mProgress) ? 1 : 0)) == 0 || (n12 = (int)(Float.isNaN(f12 = ((MotionConstrainedPoint)object).mProgress) ? 1 : 0)) == 0) {
            string2 = "progress";
            hashSet.add(string2);
        }
        if ((n12 = (int)(this.diff(f12 = this.rotationX, f13 = ((MotionConstrainedPoint)object).rotationX) ? 1 : 0)) != 0) {
            string2 = "rotationX";
            hashSet.add(string2);
        }
        if ((n12 = (int)(this.diff(f12 = this.rotationY, f13 = ((MotionConstrainedPoint)object).rotationY) ? 1 : 0)) != 0) {
            string2 = "rotationY";
            hashSet.add(string2);
        }
        if ((n12 = (int)(this.diff(f12 = this.mPivotX, f13 = ((MotionConstrainedPoint)object).mPivotX) ? 1 : 0)) != 0) {
            string2 = "transformPivotX";
            hashSet.add(string2);
        }
        if ((n12 = (int)(this.diff(f12 = this.mPivotY, f13 = ((MotionConstrainedPoint)object).mPivotY) ? 1 : 0)) != 0) {
            string2 = "transformPivotY";
            hashSet.add(string2);
        }
        if ((n12 = (int)(this.diff(f12 = this.scaleX, f13 = ((MotionConstrainedPoint)object).scaleX) ? 1 : 0)) != 0) {
            string2 = "scaleX";
            hashSet.add(string2);
        }
        if ((n12 = (int)(this.diff(f12 = this.scaleY, f13 = ((MotionConstrainedPoint)object).scaleY) ? 1 : 0)) != 0) {
            string2 = "scaleY";
            hashSet.add(string2);
        }
        if ((n12 = (int)(this.diff(f12 = this.translationX, f13 = ((MotionConstrainedPoint)object).translationX) ? 1 : 0)) != 0) {
            string2 = "translationX";
            hashSet.add(string2);
        }
        if ((n12 = (int)(this.diff(f12 = this.translationY, f13 = ((MotionConstrainedPoint)object).translationY) ? 1 : 0)) != 0) {
            string2 = "translationY";
            hashSet.add(string2);
        }
        if (bl2 = this.diff(f12 = this.translationZ, f10 = ((MotionConstrainedPoint)object).translationZ)) {
            object = "translationZ";
            hashSet.add(object);
        }
    }

    public void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] blArray, String[] stringArray) {
        boolean bl2;
        boolean bl3 = blArray[0];
        float f10 = this.position;
        float f11 = motionConstrainedPoint.position;
        boolean bl4 = this.diff(f10, f11);
        blArray[0] = bl3 |= bl4;
        int n10 = 1;
        bl3 = blArray[n10];
        f10 = this.x;
        f11 = motionConstrainedPoint.x;
        bl4 = this.diff(f10, f11);
        blArray[n10] = bl3 |= bl4;
        n10 = 2;
        bl3 = blArray[n10];
        f10 = this.y;
        f11 = motionConstrainedPoint.y;
        bl4 = this.diff(f10, f11);
        blArray[n10] = bl3 |= bl4;
        n10 = 3;
        bl3 = blArray[n10];
        f10 = this.width;
        f11 = motionConstrainedPoint.width;
        bl4 = this.diff(f10, f11);
        blArray[n10] = bl3 |= bl4;
        n10 = 4;
        bl3 = blArray[n10];
        f10 = this.height;
        float f12 = motionConstrainedPoint.height;
        blArray[n10] = bl2 = this.diff(f10, f12) | bl3;
    }

    public void fillStandard(double[] dArray, int[] nArray) {
        int n10 = 18;
        float[] fArray = new float[n10];
        float f10 = this.position;
        fArray[0] = f10;
        fArray[1] = f10 = this.x;
        fArray[2] = f10 = this.y;
        fArray[3] = f10 = this.width;
        fArray[4] = f10 = this.height;
        fArray[5] = f10 = this.alpha;
        fArray[6] = f10 = this.elevation;
        fArray[7] = f10 = this.rotation;
        fArray[8] = f10 = this.rotationX;
        fArray[9] = f10 = this.rotationY;
        fArray[10] = f10 = this.scaleX;
        fArray[11] = f10 = this.scaleY;
        fArray[12] = f10 = this.mPivotX;
        fArray[13] = f10 = this.mPivotY;
        fArray[14] = f10 = this.translationX;
        fArray[15] = f10 = this.translationY;
        fArray[16] = f10 = this.translationZ;
        f10 = this.mPathRotate;
        int n11 = 17;
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

    public boolean hasCustomData(String string2) {
        return this.attributes.containsKey(string2);
    }

    public void setBounds(float f10, float f11, float f12, float f13) {
        this.x = f10;
        this.y = f11;
        this.width = f12;
        this.height = f13;
    }

    public void setState(View view) {
        float f10 = view.getX();
        float f11 = view.getY();
        float f12 = view.getWidth();
        float f13 = view.getHeight();
        this.setBounds(f10, f11, f12, f13);
        this.applyParameters(view);
    }

    public void setState(ConstraintWidget object, ConstraintSet constraintSet, int n10) {
        float f10 = ((ConstraintWidget)object).getX();
        float f11 = ((ConstraintWidget)object).getY();
        float f12 = ((ConstraintWidget)object).getWidth();
        float f13 = ((ConstraintWidget)object).getHeight();
        this.setBounds(f10, f11, f12, f13);
        object = constraintSet.getParameters(n10);
        this.applyParameters((ConstraintSet$Constraint)object);
    }
}

