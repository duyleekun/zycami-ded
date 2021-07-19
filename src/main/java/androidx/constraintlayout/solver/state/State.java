/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.Dimension;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State$1;
import androidx.constraintlayout.solver.state.State$Direction;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.state.helpers.GuidelineReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import java.util.HashMap;
import java.util.Iterator;

public class State {
    public static final int CONSTRAINT_RATIO = 2;
    public static final int CONSTRAINT_SPREAD = 0;
    public static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = 0;
    public static final int UNKNOWN = 255;
    public HashMap mHelperReferences;
    public final ConstraintReference mParent;
    public HashMap mReferences;
    private int numHelpers;

    public State() {
        Object object = new HashMap();
        this.mReferences = object;
        object = new HashMap();
        this.mHelperReferences = object;
        this.mParent = object = new ConstraintReference(this);
        this.numHelpers = 0;
        HashMap hashMap = this.mReferences;
        Integer n10 = PARENT;
        hashMap.put(n10, object);
    }

    private String createHelperKey() {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("__HELPER_KEY_");
        int n11 = this.numHelpers;
        this.numHelpers = n10 = n11 + 1;
        stringBuilder.append(n11);
        stringBuilder.append("__");
        return stringBuilder.toString();
    }

    public void apply(ConstraintWidgetContainer iterator2) {
        boolean bl2;
        Object object;
        Object object2;
        ((WidgetContainer)((Object)iterator2)).removeAllChildren();
        Object object3 = this.mParent.getWidth();
        Object object4 = null;
        ((Dimension)object3).apply(this, (ConstraintWidget)((Object)iterator2), 0);
        object3 = this.mParent.getHeight();
        int n10 = 1;
        ((Dimension)object3).apply(this, (ConstraintWidget)((Object)iterator2), n10);
        object3 = this.mHelperReferences.keySet().iterator();
        while ((n10 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            object4 = object3.next();
            object2 = ((HelperReference)this.mHelperReferences.get(object4)).getHelperWidget();
            if (object2 == null) continue;
            object = (Reference)this.mReferences.get(object4);
            if (object == null) {
                object = this.constraints(object4);
            }
            object.setConstraintWidget((ConstraintWidget)object2);
        }
        object3 = this.mReferences.keySet().iterator();
        while ((n10 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            object4 = object3.next();
            if ((object4 = (Reference)this.mReferences.get(object4)) != (object2 = this.mParent)) {
                object2 = object4.getConstraintWidget();
                object = null;
                ((ConstraintWidget)object2).setParent(null);
                boolean bl3 = object4 instanceof GuidelineReference;
                if (bl3) {
                    ((Reference)object4).apply();
                }
                ((WidgetContainer)((Object)iterator2)).add((ConstraintWidget)object2);
                continue;
            }
            object4.setConstraintWidget((ConstraintWidget)((Object)iterator2));
        }
        iterator2 = this.mHelperReferences.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl4;
            object3 = iterator2.next();
            object4 = ((HelperReference)(object3 = (HelperReference)this.mHelperReferences.get(object3))).getHelperWidget();
            if (object4 == null) continue;
            object4 = ((HelperReference)object3).mReferences.iterator();
            while (bl4 = object4.hasNext()) {
                object2 = object4.next();
                object2 = (Reference)this.mReferences.get(object2);
                object = ((HelperReference)object3).getHelperWidget();
                object2 = object2.getConstraintWidget();
                ((HelperWidget)object).add((ConstraintWidget)object2);
            }
            ((HelperReference)object3).apply();
        }
        iterator2 = this.mReferences.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            object3 = iterator2.next();
            object4 = this.mReferences;
            object3 = (Reference)((HashMap)object4).get(object3);
            object3.apply();
        }
    }

    public BarrierReference barrier(Object object, State$Direction state$Direction) {
        State$Helper state$Helper = State$Helper.BARRIER;
        object = (BarrierReference)this.helper(object, state$Helper);
        ((BarrierReference)object).setBarrierDirection(state$Direction);
        return object;
    }

    public AlignHorizontallyReference centerHorizontally(Object ... objectArray) {
        Object object = State$Helper.ALIGN_HORIZONTALLY;
        object = (AlignHorizontallyReference)this.helper(null, (State$Helper)((Object)object));
        ((HelperReference)object).add(objectArray);
        return object;
    }

    public AlignVerticallyReference centerVertically(Object ... objectArray) {
        Object object = State$Helper.ALIGN_VERTICALLY;
        object = (AlignVerticallyReference)this.helper(null, (State$Helper)((Object)object));
        ((HelperReference)object).add(objectArray);
        return object;
    }

    public ConstraintReference constraints(Object object) {
        boolean bl2;
        Reference reference = (Reference)this.mReferences.get(object);
        if (reference == null) {
            reference = this.createConstraintReference(object);
            HashMap hashMap = this.mReferences;
            hashMap.put(object, reference);
            reference.setKey(object);
        }
        if (bl2 = reference instanceof ConstraintReference) {
            return (ConstraintReference)reference;
        }
        return null;
    }

    public int convertDimension(Object object) {
        boolean bl2 = object instanceof Float;
        if (bl2) {
            return ((Float)object).intValue();
        }
        bl2 = object instanceof Integer;
        if (bl2) {
            return (Integer)object;
        }
        return 0;
    }

    public ConstraintReference createConstraintReference(Object object) {
        object = new ConstraintReference(this);
        return object;
    }

    public void directMapping() {
        boolean bl2;
        Iterator iterator2 = this.mReferences.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object k10 = iterator2.next();
            ConstraintReference constraintReference = this.constraints(k10);
            constraintReference.setView(k10);
        }
    }

    public GuidelineReference guideline(Object object, int n10) {
        Reference reference = (Reference)this.mReferences.get(object);
        if (reference == null) {
            reference = new GuidelineReference(this);
            ((GuidelineReference)reference).setOrientation(n10);
            ((GuidelineReference)reference).setKey(object);
            HashMap hashMap = this.mReferences;
            hashMap.put(object, reference);
        }
        return (GuidelineReference)reference;
    }

    public State height(Dimension dimension) {
        return this.setHeight(dimension);
    }

    public HelperReference helper(Object object, State$Helper object2) {
        Object object3;
        block1: {
            block7: {
                block8: {
                    block2: {
                        block3: {
                            block4: {
                                block5: {
                                    block6: {
                                        if (object == null) {
                                            object = this.createHelperKey();
                                        }
                                        if ((object3 = (HelperReference)this.mHelperReferences.get(object)) != null) break block1;
                                        object3 = State$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper;
                                        int n10 = object2.ordinal();
                                        Object object4 = object3[n10];
                                        if (object4 == (n10 = 1)) break block2;
                                        n10 = 2;
                                        if (object4 == n10) break block3;
                                        n10 = 3;
                                        if (object4 == n10) break block4;
                                        n10 = 4;
                                        if (object4 == n10) break block5;
                                        n10 = 5;
                                        if (object4 == n10) break block6;
                                        object3 = new HelperReference(this, (State$Helper)((Object)object2));
                                        break block7;
                                    }
                                    object2 = new BarrierReference(this);
                                    break block8;
                                }
                                object2 = new AlignVerticallyReference(this);
                                break block8;
                            }
                            object2 = new AlignHorizontallyReference(this);
                            break block8;
                        }
                        object2 = new VerticalChainReference(this);
                        break block8;
                    }
                    object2 = new HorizontalChainReference(this);
                }
                object3 = object2;
            }
            object2 = this.mHelperReferences;
            ((HashMap)object2).put(object, object3);
        }
        return object3;
    }

    public HorizontalChainReference horizontalChain(Object ... objectArray) {
        Object object = State$Helper.HORIZONTAL_CHAIN;
        object = (HorizontalChainReference)this.helper(null, (State$Helper)((Object)object));
        ((HelperReference)object).add(objectArray);
        return object;
    }

    public GuidelineReference horizontalGuideline(Object object) {
        return this.guideline(object, 0);
    }

    public void map(Object object, Object object2) {
        this.constraints(object).setView(object2);
    }

    public Reference reference(Object object) {
        return (Reference)this.mReferences.get(object);
    }

    public void reset() {
        this.mHelperReferences.clear();
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public VerticalChainReference verticalChain(Object ... objectArray) {
        Object object = State$Helper.VERTICAL_CHAIN;
        object = (VerticalChainReference)this.helper(null, (State$Helper)((Object)object));
        ((HelperReference)object).add(objectArray);
        return object;
    }

    public GuidelineReference verticalGuideline(Object object) {
        return this.guideline(object, 1);
    }

    public State width(Dimension dimension) {
        return this.setWidth(dimension);
    }
}

