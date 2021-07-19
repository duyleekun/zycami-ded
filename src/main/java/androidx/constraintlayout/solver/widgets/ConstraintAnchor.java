/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.SolverVariable$Type;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$1;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    private static final int UNSET_GONE_MARGIN = 255;
    private HashSet mDependents = null;
    private int mFinalValue;
    public int mGoneMargin = -1;
    private boolean mHasFinalValue;
    public int mMargin = 0;
    public final ConstraintWidget mOwner;
    public SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final ConstraintAnchor$Type mType;

    public ConstraintAnchor(ConstraintWidget constraintWidget, ConstraintAnchor$Type constraintAnchor$Type) {
        this.mOwner = constraintWidget;
        this.mType = constraintAnchor$Type;
    }

    private boolean isConnectionToMe(ConstraintWidget object, HashSet hashSet) {
        int n10 = hashSet.contains(object);
        if (n10 != 0) {
            return false;
        }
        hashSet.add(object);
        ConstraintWidget constraintWidget = this.getOwner();
        boolean bl2 = true;
        if (object == constraintWidget) {
            return bl2;
        }
        object = ((ConstraintWidget)object).getAnchors();
        n10 = ((ArrayList)object).size();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl3;
            Object object2 = (ConstraintAnchor)((ArrayList)object).get(i10);
            boolean bl4 = ((ConstraintAnchor)object2).isSimilarDimensionConnection(this);
            if (!bl4 || !(bl4 = ((ConstraintAnchor)object2).isConnected()) || !(bl3 = this.isConnectionToMe((ConstraintWidget)(object2 = ((ConstraintAnchor)object2).getTarget().getOwner()), hashSet))) continue;
            return bl2;
        }
        return false;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int n10) {
        return this.connect(constraintAnchor, n10, -1, false);
    }

    public boolean connect(ConstraintAnchor object, int n10, int n11, boolean bl2) {
        boolean bl3 = true;
        if (object == null) {
            this.reset();
            return bl3;
        }
        if (!bl2 && !(bl2 = this.isValidConnection((ConstraintAnchor)object))) {
            return false;
        }
        this.mTarget = object;
        HashSet hashSet = ((ConstraintAnchor)object).mDependents;
        if (hashSet == null) {
            ((ConstraintAnchor)object).mDependents = hashSet = new HashSet();
        }
        if ((object = this.mTarget.mDependents) != null) {
            ((HashSet)object).add(this);
        }
        this.mMargin = n10 > 0 ? n10 : 0;
        this.mGoneMargin = n11;
        return bl3;
    }

    public void copyFrom(ConstraintAnchor constraintAnchor, HashMap object) {
        int n10;
        int n11;
        Object object2 = this.mTarget;
        if (object2 != null && (object2 = ((ConstraintAnchor)object2).mDependents) != null) {
            ((HashSet)object2).remove(this);
        }
        if ((object2 = constraintAnchor.mTarget) != null) {
            object2 = ((ConstraintAnchor)object2).getType();
            ConstraintWidget constraintWidget = constraintAnchor.mTarget.mOwner;
            this.mTarget = object = ((ConstraintWidget)((HashMap)object).get(constraintWidget)).getAnchor((ConstraintAnchor$Type)((Object)object2));
        } else {
            n11 = 0;
            object = null;
            this.mTarget = null;
        }
        object = this.mTarget;
        if (object != null) {
            object2 = ((ConstraintAnchor)object).mDependents;
            if (object2 == null) {
                object2 = new HashSet();
                ((ConstraintAnchor)object).mDependents = object2;
            }
            object = this.mTarget.mDependents;
            ((HashSet)object).add(this);
        }
        this.mMargin = n11 = constraintAnchor.mMargin;
        this.mGoneMargin = n10 = constraintAnchor.mGoneMargin;
    }

    public void findDependents(int n10, ArrayList arrayList, WidgetGroup widgetGroup) {
        Object object = this.mDependents;
        if (object != null) {
            boolean bl2;
            object = ((HashSet)object).iterator();
            while (bl2 = object.hasNext()) {
                ConstraintWidget constraintWidget = ((ConstraintAnchor)object.next()).mOwner;
                Grouping.findDependents(constraintWidget, n10, arrayList, widgetGroup);
            }
        }
    }

    public HashSet getDependents() {
        return this.mDependents;
    }

    public int getFinalValue() {
        boolean bl2 = this.mHasFinalValue;
        if (!bl2) {
            return 0;
        }
        return this.mFinalValue;
    }

    public int getMargin() {
        int n10;
        Object object = this.mOwner;
        int n11 = ((ConstraintWidget)object).getVisibility();
        if (n11 == (n10 = 8)) {
            return 0;
        }
        n11 = this.mGoneMargin;
        int n12 = -1;
        if (n11 > n12 && (object = this.mTarget) != null && (n11 = ((ConstraintWidget)(object = ((ConstraintAnchor)object).mOwner)).getVisibility()) == n10) {
            return this.mGoneMargin;
        }
        return this.mMargin;
    }

    public final ConstraintAnchor getOpposite() {
        Object object = ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        Object object2 = this.mType;
        int n10 = object2.ordinal();
        int n11 = object[n10];
        switch (n11) {
            default: {
                object = new AssertionError;
                object2 = this.mType.name();
                object(object2);
                throw object;
            }
            case 5: {
                return this.mOwner.mTop;
            }
            case 4: {
                return this.mOwner.mBottom;
            }
            case 3: {
                return this.mOwner.mLeft;
            }
            case 2: {
                return this.mOwner.mRight;
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
        }
        return null;
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public ConstraintAnchor$Type getType() {
        return this.mType;
    }

    public boolean hasCenteredDependents() {
        boolean bl2;
        Object object = this.mDependents;
        if (object == null) {
            return false;
        }
        object = ((HashSet)object).iterator();
        while (bl2 = object.hasNext()) {
            ConstraintAnchor constraintAnchor = ((ConstraintAnchor)object.next()).getOpposite();
            bl2 = constraintAnchor.isConnected();
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public boolean hasDependents() {
        HashSet hashSet = this.mDependents;
        boolean bl2 = false;
        if (hashSet == null) {
            return false;
        }
        int n10 = hashSet.size();
        if (n10 > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean hasFinalValue() {
        return this.mHasFinalValue;
    }

    public boolean isConnected() {
        boolean bl2;
        ConstraintAnchor constraintAnchor = this.mTarget;
        if (constraintAnchor != null) {
            bl2 = true;
        } else {
            bl2 = false;
            constraintAnchor = null;
        }
        return bl2;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget) {
        Object object = new HashSet();
        boolean bl2 = this.isConnectionToMe(constraintWidget, (HashSet)object);
        if (bl2) {
            return false;
        }
        object = this.getOwner().getParent();
        boolean bl3 = true;
        if (object == constraintWidget) {
            return bl3;
        }
        if ((constraintWidget = constraintWidget.getParent()) == object) {
            return bl3;
        }
        return false;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return this.isConnectionAllowed(constraintWidget);
    }

    public boolean isSideAnchor() {
        Object object = ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        Object object2 = this.mType;
        int n10 = object2.ordinal();
        int n11 = object[n10];
        switch (n11) {
            default: {
                object = new AssertionError;
                object2 = this.mType.name();
                object(object2);
                throw object;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return true;
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
        }
        return false;
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor object) {
        object = object.getType();
        Object object2 = this.mType;
        boolean bl2 = true;
        if (object == object2) {
            return bl2;
        }
        int[] nArray = ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        int n10 = object2.ordinal();
        n10 = nArray[n10];
        nArray = null;
        switch (n10) {
            default: {
                object2 = this.mType.name();
                object = new AssertionError(object2);
                throw object;
            }
            case 9: {
                return false;
            }
            case 4: 
            case 5: 
            case 6: 
            case 8: {
                object2 = ConstraintAnchor$Type.TOP;
                if (object != object2 && object != (object2 = ConstraintAnchor$Type.BOTTOM) && object != (object2 = ConstraintAnchor$Type.CENTER_Y) && object != (object2 = ConstraintAnchor$Type.BASELINE)) {
                    bl2 = false;
                }
                return bl2;
            }
            case 2: 
            case 3: 
            case 7: {
                object2 = ConstraintAnchor$Type.LEFT;
                if (object != object2 && object != (object2 = ConstraintAnchor$Type.RIGHT) && object != (object2 = ConstraintAnchor$Type.CENTER_X)) {
                    bl2 = false;
                }
                return bl2;
            }
            case 1: 
        }
        object2 = ConstraintAnchor$Type.BASELINE;
        if (object == object2) {
            bl2 = false;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isValidConnection(ConstraintAnchor object) {
        boolean bl2 = false;
        String string2 = null;
        if (object == null) {
            return false;
        }
        ConstraintAnchor$Type constraintAnchor$Type = ((ConstraintAnchor)object).getType();
        ConstraintAnchor$Type constraintAnchor$Type2 = this.mType;
        boolean bl3 = true;
        float f10 = Float.MIN_VALUE;
        if (constraintAnchor$Type == constraintAnchor$Type2) {
            boolean bl4;
            constraintAnchor$Type = ConstraintAnchor$Type.BASELINE;
            if (!(constraintAnchor$Type2 != constraintAnchor$Type || (bl4 = ((ConstraintWidget)(object = ((ConstraintAnchor)object).getOwner())).hasBaseline()) && (bl4 = ((ConstraintWidget)(object = this.getOwner())).hasBaseline()))) {
                return false;
            }
            return bl3;
        }
        int[] nArray = ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        int n10 = constraintAnchor$Type2.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                string2 = this.mType.name();
                object = new AssertionError((Object)string2);
                throw object;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return false;
            }
            case 4: 
            case 5: {
                boolean bl4;
                constraintAnchor$Type2 = ConstraintAnchor$Type.TOP;
                if (constraintAnchor$Type != constraintAnchor$Type2 && constraintAnchor$Type != (constraintAnchor$Type2 = ConstraintAnchor$Type.BOTTOM)) {
                    boolean bl6 = false;
                    constraintAnchor$Type2 = null;
                } else {
                    boolean bl7 = bl3;
                }
                object = ((ConstraintAnchor)object).getOwner();
                boolean bl6 = object instanceof Guideline;
                if (bl6) {
                    void var10_16;
                    if (var10_16 != false || constraintAnchor$Type == (object = ConstraintAnchor$Type.CENTER_Y)) {
                        bl2 = bl3;
                    }
                    bl4 = bl2;
                }
                return bl4;
            }
            case 2: 
            case 3: {
                boolean bl8;
                constraintAnchor$Type2 = ConstraintAnchor$Type.LEFT;
                if (constraintAnchor$Type != constraintAnchor$Type2 && constraintAnchor$Type != (constraintAnchor$Type2 = ConstraintAnchor$Type.RIGHT)) {
                    boolean bl9 = false;
                    constraintAnchor$Type2 = null;
                } else {
                    boolean bl10 = bl3;
                }
                object = ((ConstraintAnchor)object).getOwner();
                boolean bl7 = object instanceof Guideline;
                if (bl7) {
                    void var10_20;
                    if (var10_20 != false || constraintAnchor$Type == (object = ConstraintAnchor$Type.CENTER_X)) {
                        bl2 = bl3;
                    }
                    bl8 = bl2;
                }
                return bl8;
            }
            case 1: 
        }
        object = ConstraintAnchor$Type.BASELINE;
        if (constraintAnchor$Type != object && constraintAnchor$Type != (object = ConstraintAnchor$Type.CENTER_X) && constraintAnchor$Type != (object = ConstraintAnchor$Type.CENTER_Y)) {
            bl2 = bl3;
        }
        return bl2;
    }

    public boolean isVerticalAnchor() {
        Object object = ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        Object object2 = this.mType;
        int n10 = object2.ordinal();
        int n11 = object[n10];
        switch (n11) {
            default: {
                object = new AssertionError;
                object2 = this.mType.name();
                object(object2);
                throw object;
            }
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 9: {
                return true;
            }
            case 1: 
            case 2: 
            case 3: 
            case 7: 
        }
        return false;
    }

    public void reset() {
        Object object = this.mTarget;
        if (object != null && (object = ((ConstraintAnchor)object).mDependents) != null) {
            ((HashSet)object).remove(this);
            object = this.mTarget.mDependents;
            int n10 = ((HashSet)object).size();
            if (n10 == 0) {
                object = this.mTarget;
                ((ConstraintAnchor)object).mDependents = null;
            }
        }
        this.mDependents = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public void resetFinalResolution() {
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public void resetSolverVariable(Cache object) {
        object = this.mSolverVariable;
        if (object == null) {
            SolverVariable$Type solverVariable$Type = SolverVariable$Type.UNRESTRICTED;
            this.mSolverVariable = object = new SolverVariable(solverVariable$Type, null);
        } else {
            ((SolverVariable)object).reset();
        }
    }

    public void setFinalValue(int n10) {
        this.mFinalValue = n10;
        this.mHasFinalValue = true;
    }

    public void setGoneMargin(int n10) {
        boolean bl2 = this.isConnected();
        if (bl2) {
            this.mGoneMargin = n10;
        }
    }

    public void setMargin(int n10) {
        boolean bl2 = this.isConnected();
        if (bl2) {
            this.mMargin = n10;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.mOwner.getDebugName();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        string2 = this.mType.toString();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

