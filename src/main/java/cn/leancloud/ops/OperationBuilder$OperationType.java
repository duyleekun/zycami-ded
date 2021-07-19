/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

public final class OperationBuilder$OperationType
extends Enum {
    private static final /* synthetic */ OperationBuilder$OperationType[] $VALUES;
    public static final /* enum */ OperationBuilder$OperationType Add;
    public static final /* enum */ OperationBuilder$OperationType AddRelation;
    public static final /* enum */ OperationBuilder$OperationType AddUnique;
    public static final /* enum */ OperationBuilder$OperationType BitAnd;
    public static final /* enum */ OperationBuilder$OperationType BitOr;
    public static final /* enum */ OperationBuilder$OperationType BitXor;
    public static final /* enum */ OperationBuilder$OperationType Compound;
    public static final /* enum */ OperationBuilder$OperationType Decrement;
    public static final /* enum */ OperationBuilder$OperationType Delete;
    public static final /* enum */ OperationBuilder$OperationType Increment;
    public static final /* enum */ OperationBuilder$OperationType Remove;
    public static final /* enum */ OperationBuilder$OperationType RemoveRelation;
    public static final /* enum */ OperationBuilder$OperationType Set;

    static {
        OperationBuilder$OperationType operationBuilder$OperationType;
        OperationBuilder$OperationType operationBuilder$OperationType2;
        OperationBuilder$OperationType operationBuilder$OperationType3;
        OperationBuilder$OperationType operationBuilder$OperationType4;
        OperationBuilder$OperationType operationBuilder$OperationType5;
        OperationBuilder$OperationType operationBuilder$OperationType6;
        OperationBuilder$OperationType operationBuilder$OperationType7;
        OperationBuilder$OperationType operationBuilder$OperationType8;
        OperationBuilder$OperationType operationBuilder$OperationType9;
        OperationBuilder$OperationType operationBuilder$OperationType10;
        OperationBuilder$OperationType operationBuilder$OperationType11;
        OperationBuilder$OperationType operationBuilder$OperationType12;
        OperationBuilder$OperationType operationBuilder$OperationType13;
        Set = operationBuilder$OperationType13 = new OperationBuilder$OperationType("Set", 0);
        Delete = operationBuilder$OperationType12 = new OperationBuilder$OperationType("Delete", 1);
        Add = operationBuilder$OperationType11 = new OperationBuilder$OperationType("Add", 2);
        AddUnique = operationBuilder$OperationType10 = new OperationBuilder$OperationType("AddUnique", 3);
        Remove = operationBuilder$OperationType9 = new OperationBuilder$OperationType("Remove", 4);
        AddRelation = operationBuilder$OperationType8 = new OperationBuilder$OperationType("AddRelation", 5);
        RemoveRelation = operationBuilder$OperationType7 = new OperationBuilder$OperationType("RemoveRelation", 6);
        Increment = operationBuilder$OperationType6 = new OperationBuilder$OperationType("Increment", 7);
        Decrement = operationBuilder$OperationType5 = new OperationBuilder$OperationType("Decrement", 8);
        BitAnd = operationBuilder$OperationType4 = new OperationBuilder$OperationType("BitAnd", 9);
        BitOr = operationBuilder$OperationType3 = new OperationBuilder$OperationType("BitOr", 10);
        BitXor = operationBuilder$OperationType2 = new OperationBuilder$OperationType("BitXor", 11);
        int n10 = 12;
        Compound = operationBuilder$OperationType = new OperationBuilder$OperationType("Compound", n10);
        OperationBuilder$OperationType[] operationBuilder$OperationTypeArray = new OperationBuilder$OperationType[13];
        operationBuilder$OperationTypeArray[0] = operationBuilder$OperationType13;
        operationBuilder$OperationTypeArray[1] = operationBuilder$OperationType12;
        operationBuilder$OperationTypeArray[2] = operationBuilder$OperationType11;
        operationBuilder$OperationTypeArray[3] = operationBuilder$OperationType10;
        operationBuilder$OperationTypeArray[4] = operationBuilder$OperationType9;
        operationBuilder$OperationTypeArray[5] = operationBuilder$OperationType8;
        operationBuilder$OperationTypeArray[6] = operationBuilder$OperationType7;
        operationBuilder$OperationTypeArray[7] = operationBuilder$OperationType6;
        operationBuilder$OperationTypeArray[8] = operationBuilder$OperationType5;
        operationBuilder$OperationTypeArray[9] = operationBuilder$OperationType4;
        operationBuilder$OperationTypeArray[10] = operationBuilder$OperationType3;
        operationBuilder$OperationTypeArray[11] = operationBuilder$OperationType2;
        operationBuilder$OperationTypeArray[n10] = operationBuilder$OperationType;
        $VALUES = operationBuilder$OperationTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OperationBuilder$OperationType() {
        void var2_-1;
        void var1_-1;
    }

    public static OperationBuilder$OperationType valueOf(String string2) {
        return Enum.valueOf(OperationBuilder$OperationType.class, string2);
    }

    public static OperationBuilder$OperationType[] values() {
        return (OperationBuilder$OperationType[])$VALUES.clone();
    }
}

