/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.ConstraintReference;
import java.util.ArrayList;

public class ConstraintReference$IncorrectConstraintException
extends Exception {
    private final ArrayList mErrors;
    public final /* synthetic */ ConstraintReference this$0;

    public ConstraintReference$IncorrectConstraintException(ConstraintReference constraintReference, ArrayList arrayList) {
        this.this$0 = constraintReference;
        this.mErrors = arrayList;
    }

    public ArrayList getErrors() {
        return this.mErrors;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IncorrectConstraintException: ");
        String string2 = this.mErrors.toString();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

