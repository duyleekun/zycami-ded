/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Strings;
import java.util.Objects;

public final class Preconditions {
    private Preconditions() {
    }

    private static String badElementIndex(int n10, int n11, String charSequence) {
        int n12 = 1;
        int n13 = 2;
        if (n10 < 0) {
            Object[] objectArray = new Object[n13];
            objectArray[0] = charSequence;
            Integer n14 = n10;
            objectArray[n12] = n14;
            return Strings.lenientFormat("%s (%s) must not be negative", objectArray);
        }
        if (n11 >= 0) {
            Object[] objectArray = new Object[3];
            objectArray[0] = charSequence;
            Integer n15 = n10;
            objectArray[n12] = n15;
            n15 = n11;
            objectArray[n13] = n15;
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", objectArray);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("negative size: ");
        ((StringBuilder)charSequence).append(n11);
        String string2 = ((StringBuilder)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    private static String badPositionIndex(int n10, int n11, String charSequence) {
        int n12 = 1;
        int n13 = 2;
        if (n10 < 0) {
            Object[] objectArray = new Object[n13];
            objectArray[0] = charSequence;
            Integer n14 = n10;
            objectArray[n12] = n14;
            return Strings.lenientFormat("%s (%s) must not be negative", objectArray);
        }
        if (n11 >= 0) {
            Object[] objectArray = new Object[3];
            objectArray[0] = charSequence;
            Integer n15 = n10;
            objectArray[n12] = n15;
            n15 = n11;
            objectArray[n13] = n15;
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", objectArray);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("negative size: ");
        ((StringBuilder)charSequence).append(n11);
        String string2 = ((StringBuilder)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    private static String badPositionIndexes(int n10, int n11, int n12) {
        if (n10 >= 0 && n10 <= n12) {
            if (n11 >= 0 && n11 <= n12) {
                Object[] objectArray = new Object[2];
                Integer n13 = n11;
                objectArray[0] = n13;
                Integer n14 = n10;
                objectArray[1] = n14;
                return Strings.lenientFormat("end index (%s) must not be less than start index (%s)", objectArray);
            }
            return Preconditions.badPositionIndex(n11, n12, "end index");
        }
        return Preconditions.badPositionIndex(n10, n12, "start index");
    }

    public static void checkArgument(boolean bl2) {
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, Object object) {
        if (bl2) {
            return;
        }
        object = String.valueOf(object);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[1];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, char c10, char c11) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c12 = Character.valueOf(c10);
        objectArray[0] = c12;
        Character c13 = Character.valueOf(c11);
        objectArray[1] = c13;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, char c10, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, char c10, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, char c10, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        objectArray[1] = object;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, int n10, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, int n10, int n11) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n12 = n10;
        objectArray[0] = n12;
        Integer n13 = n11;
        objectArray[1] = n13;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, int n10, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, int n10, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        objectArray[1] = object;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[1];
        Long l11 = l10;
        objectArray[0] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, long l10, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, long l10, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, long l10, long l11) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l12 = l10;
        objectArray[0] = l12;
        Long l13 = l11;
        objectArray[1] = l13;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, long l10, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        objectArray[1] = object;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object};
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, Object object, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, Object object, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, Object object, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, Object object, Object object2) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object, object2};
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, Object object, Object object2, Object object3) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object, object2, object3};
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, Object object, Object object2, Object object3, Object object4) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object, object2, object3, object4};
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, Object ... objectArray) {
        if (bl2) {
            return;
        }
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static int checkElementIndex(int n10, int n11) {
        return Preconditions.checkElementIndex(n10, n11, "index");
    }

    public static int checkElementIndex(int n10, int n11, String string2) {
        if (n10 >= 0 && n10 < n11) {
            return n10;
        }
        String string3 = Preconditions.badElementIndex(n10, n11, string2);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string3);
        throw indexOutOfBoundsException;
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    public static Object checkNotNull(Object object, Object object2) {
        if (object != null) {
            return object;
        }
        object2 = String.valueOf(object2);
        object = new NullPointerException((String)object2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, char c10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[1];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, char c10, char c11) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Character c12 = Character.valueOf(c10);
        objectArray[0] = c12;
        Character c13 = Character.valueOf(c11);
        objectArray[1] = c13;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, char c10, int n10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, char c10, long l10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, char c10, Object object2) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        objectArray[1] = object2;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, int n10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, int n10, char c10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, int n10, int n11) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Integer n12 = n10;
        objectArray[0] = n12;
        Integer n13 = n11;
        objectArray[1] = n13;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, int n10, long l10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, int n10, Object object2) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        objectArray[1] = object2;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, long l10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[1];
        Long l11 = l10;
        objectArray[0] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, long l10, char c10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, long l10, int n10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, long l10, long l11) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Long l12 = l10;
        objectArray[0] = l12;
        Long l13 = l11;
        objectArray[1] = l13;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, long l10, Object object2) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        objectArray[1] = object2;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, Object object2) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[]{object2};
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, Object object2, char c10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object2;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, Object object2, int n10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object2;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, Object object2, long l10) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object2;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, Object object2, Object object3) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[]{object2, object3};
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, Object object2, Object object3, Object object4) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[]{object2, object3, object4};
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, Object object2, Object object3, Object object4, Object object5) {
        if (object != null) {
            return object;
        }
        Object[] objectArray = new Object[]{object2, object3, object4, object5};
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object checkNotNull(Object object, String string2, Object ... objectArray) {
        if (object != null) {
            return object;
        }
        string2 = Strings.lenientFormat(string2, objectArray);
        object = new NullPointerException(string2);
        throw object;
    }

    public static int checkPositionIndex(int n10, int n11) {
        return Preconditions.checkPositionIndex(n10, n11, "index");
    }

    public static int checkPositionIndex(int n10, int n11, String string2) {
        if (n10 >= 0 && n10 <= n11) {
            return n10;
        }
        String string3 = Preconditions.badPositionIndex(n10, n11, string2);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string3);
        throw indexOutOfBoundsException;
    }

    public static void checkPositionIndexes(int n10, int n11, int n12) {
        if (n10 >= 0 && n11 >= n10 && n11 <= n12) {
            return;
        }
        String string2 = Preconditions.badPositionIndexes(n10, n11, n12);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public static void checkState(boolean bl2) {
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, Object object) {
        if (bl2) {
            return;
        }
        object = String.valueOf(object);
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[1];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, char c10, char c11) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c12 = Character.valueOf(c10);
        objectArray[0] = c12;
        Character c13 = Character.valueOf(c11);
        objectArray[1] = c13;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, char c10, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, char c10, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, char c10, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        objectArray[1] = object;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, int n10, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, int n10, int n11) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n12 = n10;
        objectArray[0] = n12;
        Integer n13 = n11;
        objectArray[1] = n13;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, int n10, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, int n10, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        objectArray[1] = object;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[1];
        Long l11 = l10;
        objectArray[0] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, long l10, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, long l10, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, long l10, long l11) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l12 = l10;
        objectArray[0] = l12;
        Long l13 = l11;
        objectArray[1] = l13;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, long l10, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        objectArray[1] = object;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object};
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, Object object, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, Object object, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, Object object, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, Object object, Object object2) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object, object2};
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, Object object, Object object2, Object object3) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object, object2, object3};
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, Object object, Object object2, Object object3, Object object4) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object, object2, object3, object4};
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, Object ... objectArray) {
        if (bl2) {
            return;
        }
        string2 = Strings.lenientFormat(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }
}

