/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.AVLogger;
import cn.leancloud.ops.BaseOperation;
import cn.leancloud.ops.BitAndOperation;
import cn.leancloud.ops.BitOrOperation;
import cn.leancloud.ops.BitXOROperation;
import cn.leancloud.ops.CompoundOperation;
import cn.leancloud.ops.DecrementOperation;
import cn.leancloud.ops.DeleteOperation;
import cn.leancloud.ops.IncrementOperation;
import cn.leancloud.ops.NullOperation;
import cn.leancloud.ops.ObjectFieldOperation;
import cn.leancloud.ops.SetOperation;
import java.util.HashMap;
import java.util.Map;

public abstract class NumericOperation
extends BaseOperation {
    public NumericOperation(String object, String string2, Object object2) {
        super((String)object, string2, object2, false);
        object = this.getValue();
        boolean bl2 = object instanceof Number;
        if (bl2) {
            return;
        }
        object = new IllegalArgumentException("Value is not number!");
        throw object;
    }

    public static Number addNumbers(Number number, Number number2) {
        boolean bl2 = number instanceof Double;
        if (!bl2 && !(bl2 = number2 instanceof Double)) {
            bl2 = number instanceof Float;
            if (!bl2 && !(bl2 = number2 instanceof Float)) {
                bl2 = number instanceof Long;
                if (!bl2 && !(bl2 = number2 instanceof Long)) {
                    int n10 = number.intValue();
                    int n11 = number2.intValue();
                    return n10 + n11;
                }
                long l10 = number.longValue();
                long l11 = number2.longValue();
                return l10 + l11;
            }
            float f10 = number.floatValue();
            float f11 = number2.floatValue();
            return Float.valueOf(f10 + f11);
        }
        double d10 = number.doubleValue();
        double d11 = number2.doubleValue();
        return d10 + d11;
    }

    public static Long calculateLongs(Number number, Number number2, char n10) {
        number = number.longValue();
        number2 = number2.longValue();
        long l10 = 0L;
        Long l11 = l10;
        int n11 = 65;
        if (n10 != n11) {
            n11 = 79;
            if (n10 != n11) {
                n11 = 88;
                if (n10 == n11) {
                    l10 = (Long)number;
                    long l12 = (Long)number2 ^ l10;
                    l11 = l12;
                }
            } else {
                l10 = (Long)number;
                long l13 = (Long)number2 | l10;
                l11 = l13;
            }
        } else {
            l10 = (Long)number;
            long l14 = (Long)number2 & l10;
            l11 = l14;
        }
        return l11;
    }

    public static Number subNumbers(Number number, Number number2) {
        boolean bl2 = number instanceof Double;
        if (!bl2 && !(bl2 = number2 instanceof Double)) {
            bl2 = number instanceof Float;
            if (!bl2 && !(bl2 = number2 instanceof Float)) {
                bl2 = number instanceof Long;
                if (!bl2 && !(bl2 = number2 instanceof Long)) {
                    int n10 = number.intValue();
                    int n11 = number2.intValue();
                    return n10 - n11;
                }
                long l10 = number.longValue();
                long l11 = number2.longValue();
                return l10 - l11;
            }
            float f10 = number.floatValue();
            float f11 = number2.floatValue();
            return Float.valueOf(f10 - f11);
        }
        double d10 = number.doubleValue();
        double d11 = number2.doubleValue();
        return d10 - d11;
    }

    public Object apply(Object object) {
        Object object2;
        block14: {
            char c10;
            block13: {
                block12: {
                    object2 = 0;
                    if (object != null) break block12;
                    object = object2;
                    break block13;
                }
                c10 = object instanceof Number;
                if (c10 == '\u0000') break block14;
                object = (Number)object;
            }
            c10 = this instanceof DecrementOperation;
            if (c10 != '\u0000') {
                object2 = (Number)((BaseOperation)this).value;
                object2 = NumericOperation.subNumbers((Number)object, (Number)object2);
            } else {
                c10 = this instanceof IncrementOperation;
                if (c10 != '\u0000') {
                    object2 = (Number)((BaseOperation)this).value;
                    object2 = NumericOperation.addNumbers((Number)object, (Number)object2);
                } else {
                    c10 = this instanceof BitXOROperation;
                    if (c10 != '\u0000') {
                        object2 = (Number)((BaseOperation)this).value;
                        c10 = 'X';
                        object2 = NumericOperation.calculateLongs((Number)object, (Number)object2, c10);
                    } else {
                        c10 = this instanceof BitAndOperation;
                        if (c10 != '\u0000') {
                            object2 = (Number)((BaseOperation)this).value;
                            c10 = 'A';
                            object2 = NumericOperation.calculateLongs((Number)object, (Number)object2, c10);
                        } else {
                            c10 = this instanceof BitOrOperation;
                            if (c10 != '\u0000') {
                                object2 = (Number)((BaseOperation)this).value;
                                c10 = 'O';
                                object2 = NumericOperation.calculateLongs((Number)object, (Number)object2, c10);
                            }
                        }
                    }
                }
            }
            return object2;
        }
        object2 = BaseOperation.LOGGER;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("cannot apply AddOperation on non number attribute. targetValueType=");
        String string2 = object.getClass().getSimpleName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        ((AVLogger)object2).w((String)charSequence);
        return object;
    }

    public Map encode() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        HashMap hashMap2 = this.getOperation();
        String string2 = "__op";
        hashMap.put(string2, hashMap2);
        boolean bl2 = this instanceof IncrementOperation;
        if (!bl2 && !(bl2 = this instanceof DecrementOperation)) {
            hashMap2 = this.getValue();
            string2 = "value";
            hashMap.put(string2, hashMap2);
        } else {
            hashMap2 = ((BaseOperation)this).getValue();
            string2 = "amount";
            hashMap.put(string2, hashMap2);
        }
        hashMap2 = new HashMap();
        string2 = ((BaseOperation)this).getField();
        hashMap2.put(string2, hashMap);
        return hashMap2;
    }

    public ObjectFieldOperation mergeWithPrevious(ObjectFieldOperation objectFieldOperation) {
        boolean bl2 = objectFieldOperation instanceof SetOperation;
        if (!bl2 && !(bl2 = objectFieldOperation instanceof DeleteOperation)) {
            bl2 = objectFieldOperation instanceof NumericOperation;
            if (bl2) {
                String string2 = this.field;
                ObjectFieldOperation[] objectFieldOperationArray = new ObjectFieldOperation[]{objectFieldOperation, this};
                CompoundOperation compoundOperation = new CompoundOperation(string2, objectFieldOperationArray);
                return compoundOperation;
            }
            bl2 = objectFieldOperation instanceof CompoundOperation;
            if (bl2) {
                return ((CompoundOperation)objectFieldOperation).mergeWithPrevious(this);
            }
            this.reportIllegalOperations(this, objectFieldOperation);
            objectFieldOperation = NullOperation.gInstance;
        }
        return objectFieldOperation;
    }
}

