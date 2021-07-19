/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.ops.AddOperation;
import cn.leancloud.ops.AddRelationOperation;
import cn.leancloud.ops.AddUniqueOperation;
import cn.leancloud.ops.BaseOperation;
import cn.leancloud.ops.BitAndOperation;
import cn.leancloud.ops.BitOrOperation;
import cn.leancloud.ops.BitXOROperation;
import cn.leancloud.ops.CompoundOperation;
import cn.leancloud.ops.DecrementOperation;
import cn.leancloud.ops.DeleteOperation;
import cn.leancloud.ops.IncrementOperation;
import cn.leancloud.ops.NullOperation;
import cn.leancloud.ops.OperationBuilder$1;
import cn.leancloud.ops.OperationBuilder$OperationType;
import cn.leancloud.ops.RemoveOperation;
import cn.leancloud.ops.RemoveRelationOperation;
import cn.leancloud.ops.SetOperation;

public class OperationBuilder {
    public static final OperationBuilder gBuilder;

    static {
        OperationBuilder operationBuilder;
        gBuilder = operationBuilder = new OperationBuilder();
    }

    private OperationBuilder() {
    }

    public BaseOperation create(OperationBuilder$OperationType object, String string2, Object object2) {
        int[] nArray = OperationBuilder$1.$SwitchMap$cn$leancloud$ops$OperationBuilder$OperationType;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new NullOperation(string2, object2);
                break;
            }
            case 13: {
                object = new CompoundOperation(string2);
                break;
            }
            case 12: {
                object = new BitXOROperation(string2, object2);
                break;
            }
            case 11: {
                object = new BitOrOperation(string2, object2);
                break;
            }
            case 10: {
                object = new BitAndOperation(string2, object2);
                break;
            }
            case 9: {
                object = new DecrementOperation(string2, object2);
                break;
            }
            case 8: {
                object = new IncrementOperation(string2, object2);
                break;
            }
            case 7: {
                object = new RemoveRelationOperation(string2, object2);
                break;
            }
            case 6: {
                object = new RemoveOperation(string2, object2);
                break;
            }
            case 5: {
                object = new AddUniqueOperation(string2, object2);
                break;
            }
            case 4: {
                object = new AddRelationOperation(string2, object2);
                break;
            }
            case 3: {
                object = new DeleteOperation(string2);
                break;
            }
            case 2: {
                object = new SetOperation(string2, object2);
                break;
            }
            case 1: {
                object = new AddOperation(string2, object2);
            }
        }
        return object;
    }
}

