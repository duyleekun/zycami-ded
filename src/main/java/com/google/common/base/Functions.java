/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Functions$ConstantFunction;
import com.google.common.base.Functions$ForMapWithDefault;
import com.google.common.base.Functions$FunctionComposition;
import com.google.common.base.Functions$FunctionForMapNoDefault;
import com.google.common.base.Functions$IdentityFunction;
import com.google.common.base.Functions$PredicateFunction;
import com.google.common.base.Functions$SupplierFunction;
import com.google.common.base.Functions$ToStringFunction;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import java.util.Map;

public final class Functions {
    private Functions() {
    }

    public static Function compose(Function function, Function function2) {
        Functions$FunctionComposition functions$FunctionComposition = new Functions$FunctionComposition(function, function2);
        return functions$FunctionComposition;
    }

    public static Function constant(Object object) {
        Functions$ConstantFunction functions$ConstantFunction = new Functions$ConstantFunction(object);
        return functions$ConstantFunction;
    }

    public static Function forMap(Map map) {
        Functions$FunctionForMapNoDefault functions$FunctionForMapNoDefault = new Functions$FunctionForMapNoDefault(map);
        return functions$FunctionForMapNoDefault;
    }

    public static Function forMap(Map map, Object object) {
        Functions$ForMapWithDefault functions$ForMapWithDefault = new Functions$ForMapWithDefault(map, object);
        return functions$ForMapWithDefault;
    }

    public static Function forPredicate(Predicate predicate) {
        Functions$PredicateFunction functions$PredicateFunction = new Functions$PredicateFunction(predicate, null);
        return functions$PredicateFunction;
    }

    public static Function forSupplier(Supplier supplier) {
        Functions$SupplierFunction functions$SupplierFunction = new Functions$SupplierFunction(supplier, null);
        return functions$SupplierFunction;
    }

    public static Function identity() {
        return Functions$IdentityFunction.INSTANCE;
    }

    public static Function toStringFunction() {
        return Functions$ToStringFunction.INSTANCE;
    }
}

