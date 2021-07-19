/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.JdkPattern;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$AndPredicate;
import com.google.common.base.Predicates$CompositionPredicate;
import com.google.common.base.Predicates$ContainsPatternFromStringPredicate;
import com.google.common.base.Predicates$ContainsPatternPredicate;
import com.google.common.base.Predicates$InPredicate;
import com.google.common.base.Predicates$InstanceOfPredicate;
import com.google.common.base.Predicates$IsEqualToPredicate;
import com.google.common.base.Predicates$NotPredicate;
import com.google.common.base.Predicates$ObjectPredicate;
import com.google.common.base.Predicates$OrPredicate;
import com.google.common.base.Predicates$SubtypeOfPredicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public final class Predicates {
    private Predicates() {
    }

    public static /* synthetic */ String access$800(String string2, Iterable iterable) {
        return Predicates.toStringHelper(string2, iterable);
    }

    public static Predicate alwaysFalse() {
        return Predicates$ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    public static Predicate alwaysTrue() {
        return Predicates$ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static Predicate and(Predicate object, Predicate predicate) {
        object = (Predicate)Preconditions.checkNotNull(object);
        predicate = (Predicate)Preconditions.checkNotNull(predicate);
        object = Predicates.asList((Predicate)object, predicate);
        Predicates$AndPredicate predicates$AndPredicate = new Predicates$AndPredicate((List)object, null);
        return predicates$AndPredicate;
    }

    public static Predicate and(Iterable iterable) {
        iterable = Predicates.defensiveCopy(iterable);
        Predicates$AndPredicate predicates$AndPredicate = new Predicates$AndPredicate((List)iterable, null);
        return predicates$AndPredicate;
    }

    public static Predicate and(Predicate ... object) {
        object = Predicates.defensiveCopy(object);
        Predicates$AndPredicate predicates$AndPredicate = new Predicates$AndPredicate((List)object, null);
        return predicates$AndPredicate;
    }

    private static List asList(Predicate predicate, Predicate predicate2) {
        Predicate[] predicateArray = new Predicate[]{predicate, predicate2};
        return Arrays.asList(predicateArray);
    }

    public static Predicate compose(Predicate predicate, Function function) {
        Predicates$CompositionPredicate predicates$CompositionPredicate = new Predicates$CompositionPredicate(predicate, function, null);
        return predicates$CompositionPredicate;
    }

    public static Predicate contains(Pattern pattern) {
        JdkPattern jdkPattern = new JdkPattern(pattern);
        Predicates$ContainsPatternPredicate predicates$ContainsPatternPredicate = new Predicates$ContainsPatternPredicate(jdkPattern);
        return predicates$ContainsPatternPredicate;
    }

    public static Predicate containsPattern(String string2) {
        Predicates$ContainsPatternFromStringPredicate predicates$ContainsPatternFromStringPredicate = new Predicates$ContainsPatternFromStringPredicate(string2);
        return predicates$ContainsPatternFromStringPredicate;
    }

    public static List defensiveCopy(Iterable object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = Preconditions.checkNotNull(object.next());
            arrayList.add(object2);
        }
        return arrayList;
    }

    private static List defensiveCopy(Object ... objectArray) {
        return Predicates.defensiveCopy(Arrays.asList(objectArray));
    }

    public static Predicate equalTo(Object object) {
        if (object == null) {
            object = Predicates.isNull();
        } else {
            Predicates$IsEqualToPredicate predicates$IsEqualToPredicate = new Predicates$IsEqualToPredicate(object, null);
            object = predicates$IsEqualToPredicate;
        }
        return object;
    }

    public static Predicate in(Collection collection) {
        Predicates$InPredicate predicates$InPredicate = new Predicates$InPredicate(collection, null);
        return predicates$InPredicate;
    }

    public static Predicate instanceOf(Class clazz) {
        Predicates$InstanceOfPredicate predicates$InstanceOfPredicate = new Predicates$InstanceOfPredicate(clazz, null);
        return predicates$InstanceOfPredicate;
    }

    public static Predicate isNull() {
        return Predicates$ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static Predicate not(Predicate predicate) {
        Predicates$NotPredicate predicates$NotPredicate = new Predicates$NotPredicate(predicate);
        return predicates$NotPredicate;
    }

    public static Predicate notNull() {
        return Predicates$ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static Predicate or(Predicate object, Predicate predicate) {
        object = (Predicate)Preconditions.checkNotNull(object);
        predicate = (Predicate)Preconditions.checkNotNull(predicate);
        object = Predicates.asList((Predicate)object, predicate);
        Predicates$OrPredicate predicates$OrPredicate = new Predicates$OrPredicate((List)object, null);
        return predicates$OrPredicate;
    }

    public static Predicate or(Iterable iterable) {
        iterable = Predicates.defensiveCopy(iterable);
        Predicates$OrPredicate predicates$OrPredicate = new Predicates$OrPredicate((List)iterable, null);
        return predicates$OrPredicate;
    }

    public static Predicate or(Predicate ... object) {
        object = Predicates.defensiveCopy(object);
        Predicates$OrPredicate predicates$OrPredicate = new Predicates$OrPredicate((List)object, null);
        return predicates$OrPredicate;
    }

    public static Predicate subtypeOf(Class clazz) {
        Predicates$SubtypeOfPredicate predicates$SubtypeOfPredicate = new Predicates$SubtypeOfPredicate(clazz, null);
        return predicates$SubtypeOfPredicate;
    }

    private static String toStringHelper(String object, Iterable iterable) {
        boolean bl2;
        String string2 = "Predicates.";
        StringBuilder stringBuilder = new StringBuilder(string2);
        stringBuilder.append((String)object);
        char c10 = '(';
        stringBuilder.append(c10);
        object = iterable.iterator();
        char c11 = '\u0001';
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            if (c11 == '\u0000') {
                c11 = ',';
                stringBuilder.append(c11);
            }
            stringBuilder.append((Object)string2);
            c11 = '\u0000';
            iterable = null;
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

