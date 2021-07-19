/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet$State;
import androidx.constraintlayout.widget.StateSet$Variant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private SparseArray mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    public int mCurrentConstraintNumber;
    public int mCurrentStateId;
    public ConstraintSet mDefaultConstraintSet;
    public int mDefaultState;
    private SparseArray mStateList;

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        SparseArray sparseArray;
        int n10;
        this.mDefaultState = n10 = -1;
        this.mCurrentStateId = n10;
        this.mCurrentConstraintNumber = n10;
        this.mStateList = sparseArray = new SparseArray();
        this.mConstraintSetMap = sparseArray = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.load(context, xmlPullParser);
    }

    /*
     * Unable to fully structure code
     */
    private void load(Context var1_1, XmlPullParser var2_4) {
        var3_5 = Xml.asAttributeSet((XmlPullParser)var2_4);
        var4_6 = R$styleable.StateSet;
        var3_5 = var1_1.obtainStyledAttributes((AttributeSet)var3_5, (int[])var4_6);
        var5_7 = var3_5.getIndexCount();
        var7_9 = null;
        for (var6_8 = 0; var6_8 < var5_7; ++var6_8) {
            var8_10 = var3_5.getIndex(var6_8);
            if (var8_10 != (var9_11 = R$styleable.StateSet_defaultState)) continue;
            var9_11 = this.mDefaultState;
            this.mDefaultState = var8_10 = var3_5.getResourceId(var8_10, var9_11);
        }
        var3_5.recycle();
        var3_5 = null;
        var5_7 = var2_4.getEventType();
        while (var5_7 != (var6_8 = 1)) {
            block31: {
                block32: {
                    block30: {
                        if (var5_7 == 0) ** GOTO lbl99
                        var10_12 = "StateSet";
                        var9_11 = 3;
                        var11_13 = 2;
                        if (var5_7 == var11_13) break block30;
                        if (var5_7 != var9_11) ** GOTO lbl101
                        var4_6 = var2_4.getName();
                        var5_7 = (int)var10_12.equals(var4_6);
                        if (var5_7 != 0) {
                            return;
                        }
                        ** GOTO lbl101
                    }
                    var4_6 = var2_4.getName();
                    var12_14 = -1;
                    var13_15 = var4_6.hashCode();
                    switch (var13_15) {
                        default: {
                            break;
                        }
                        case 1901439077: {
                            var10_12 = "Variant";
                            var8_10 = (int)var4_6.equals(var10_12);
                            if (var8_10 == 0) break;
                            var12_14 = var9_11;
                            break;
                        }
                        case 1382829617: {
                            var8_10 = (int)var4_6.equals(var10_12);
                            if (var8_10 == 0) break;
                            var12_14 = var6_8;
                            break;
                        }
                        case 1301459538: {
                            var10_12 = "LayoutDescription";
                            var8_10 = (int)var4_6.equals(var10_12);
                            if (var8_10 == 0) break;
                            var12_14 = 0;
                            break;
                        }
                        case 80204913: {
                            var10_12 = "State";
                            var8_10 = (int)var4_6.equals(var10_12);
                            if (var8_10 == 0) break;
                            var12_14 = var11_13;
                        }
                    }
                    if (var12_14 == 0 || var12_14 == var6_8) ** GOTO lbl101
                    if (var12_14 == var11_13) break block31;
                    if (var12_14 == var9_11) break block32;
                    var7_9 = "ConstraintLayoutStates";
                    var10_12 = new StringBuilder();
                    var14_16 = "unknown tag ";
                    var10_12.append(var14_16);
                    var10_12.append((String)var4_6);
                    var4_6 = var10_12.toString();
                    Log.v((String)var7_9, (String)var4_6);
                    ** GOTO lbl101
                }
                var4_6 = new StateSet$Variant(var1_1, var2_4);
                if (var3_5 == null) ** GOTO lbl101
                var3_5.add((StateSet$Variant)var4_6);
                ** GOTO lbl101
            }
            var3_5 = new StateSet$State(var1_1, var2_4);
            var4_6 = this.mStateList;
            var6_8 = var3_5.mId;
            try {
                block33: {
                    var4_6.put(var6_8, var3_5);
                    break block33;
lbl99:
                    // 1 sources

                    var2_4.getName();
                }
                var5_7 = var2_4.next();
            }
            catch (IOException var1_2) {
                var1_2.printStackTrace();
                break;
            }
            catch (XmlPullParserException var1_3) {
                var1_3.printStackTrace();
                break;
            }
        }
    }

    public int convertToConstraintSet(int n10, int n11, float f10, float f11) {
        int n12;
        StateSet$State stateSet$State = (StateSet$State)this.mStateList.get(n11);
        if (stateSet$State == null) {
            return n11;
        }
        n11 = -1082130432;
        float f12 = -1.0f;
        float f13 = f10 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false && (n11 = (int)(f11 == f12 ? 0 : (f11 > f12 ? 1 : -1))) != 0) {
            boolean bl2;
            n11 = 0;
            f12 = 0.0f;
            StateSet$Variant stateSet$Variant = null;
            Iterator iterator2 = stateSet$State.mVariants.iterator();
            while (bl2 = iterator2.hasNext()) {
                StateSet$Variant stateSet$Variant2 = (StateSet$Variant)iterator2.next();
                boolean bl3 = stateSet$Variant2.match(f10, f11);
                if (!bl3) continue;
                n11 = stateSet$Variant2.mConstraintID;
                if (n10 == n11) {
                    return n10;
                }
                stateSet$Variant = stateSet$Variant2;
            }
            if (stateSet$Variant != null) {
                return stateSet$Variant.mConstraintID;
            }
            return stateSet$State.mConstraintID;
        }
        n11 = stateSet$State.mConstraintID;
        if (n11 == n10) {
            return n10;
        }
        Iterator iterator3 = stateSet$State.mVariants.iterator();
        while ((n12 = iterator3.hasNext()) != 0) {
            StateSet$Variant stateSet$Variant = (StateSet$Variant)iterator3.next();
            n12 = stateSet$Variant.mConstraintID;
            if (n10 != n12) continue;
            return n10;
        }
        return stateSet$State.mConstraintID;
    }

    public boolean needsToChange(int n10, float f10, float f11) {
        ArrayList arrayList;
        StateSet$Variant stateSet$Variant;
        int n11 = this.mCurrentStateId;
        boolean bl2 = true;
        if (n11 != n10) {
            return bl2;
        }
        int n12 = -1;
        Object object = n10 == n12 ? this.mStateList.valueAt(0) : this.mStateList.get(n11);
        object = (StateSet$State)object;
        n11 = this.mCurrentConstraintNumber;
        if (n11 != n12 && (n11 = (int)((stateSet$Variant = (StateSet$Variant)(arrayList = ((StateSet$State)object).mVariants).get(n11)).match(f10, f11) ? 1 : 0)) != 0) {
            return false;
        }
        n11 = this.mCurrentConstraintNumber;
        n10 = ((StateSet$State)object).findMatch(f10, f11);
        if (n11 == n10) {
            return false;
        }
        return bl2;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int n10, int n11, int n12) {
        float f10 = n11;
        float f11 = n12;
        return this.updateConstraints(-1, n10, f10, f11);
    }

    public int updateConstraints(int n10, int n11, float f10, float f11) {
        int n12 = -1;
        if (n10 == n11) {
            StateSet$Variant stateSet$Variant;
            int n13;
            Object object;
            if (n11 == n12) {
                object = this.mStateList;
                n13 = 0;
                stateSet$Variant = null;
                object = (StateSet$State)object.valueAt(0);
            } else {
                object = this.mStateList;
                n13 = this.mCurrentStateId;
                object = (StateSet$State)object.get(n13);
            }
            if (object == null) {
                return n12;
            }
            n13 = this.mCurrentConstraintNumber;
            if (n13 != n12 && (n13 = (int)((stateSet$Variant = (StateSet$Variant)((StateSet$State)object).mVariants.get(n10)).match(f10, f11) ? 1 : 0)) != 0) {
                return n10;
            }
            int n14 = ((StateSet$State)object).findMatch(f10, f11);
            if (n10 == n14) {
                return n10;
            }
            if (n14 == n12) {
                n10 = ((StateSet$State)object).mConstraintID;
            } else {
                StateSet$Variant stateSet$Variant2 = (StateSet$Variant)((StateSet$State)object).mVariants.get(n14);
                n10 = stateSet$Variant2.mConstraintID;
            }
            return n10;
        }
        Object object = (StateSet$State)this.mStateList.get(n11);
        if (object == null) {
            return n12;
        }
        n11 = ((StateSet$State)object).findMatch(f10, f11);
        if (n11 == n12) {
            n10 = ((StateSet$State)object).mConstraintID;
        } else {
            object = (StateSet$Variant)((StateSet$State)object).mVariants.get(n11);
            n10 = ((StateSet$Variant)object).mConstraintID;
        }
        return n10;
    }
}

