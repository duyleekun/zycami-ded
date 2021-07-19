/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.ops.OperationBuilder$OperationType;

public class OperationBuilder$1 {
    public static final /* synthetic */ int[] $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        OperationBuilder$OperationType operationBuilder$OperationType;
        int n12 = OperationBuilder$OperationType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType = nArray;
        try {
            operationBuilder$OperationType = OperationBuilder$OperationType.Add;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.Set;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.Delete;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.AddRelation;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.AddUnique;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.Remove;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.RemoveRelation;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.Increment;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.Decrement;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.BitAnd;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.BitOr;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.BitXor;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
            operationBuilder$OperationType = OperationBuilder$OperationType.Compound;
            n11 = operationBuilder$OperationType.ordinal();
            nArray[n11] = n10 = 13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

