/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.t.f0;
import f.h2.t.s0;
import f.n2.m;
import f.q2.b;
import f.q2.d;
import f.q2.t;
import f.x1.c;
import f.x1.c$a;
import f.x1.n;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;

public class u
extends t {
    public static final String A1(byte[] byArray) {
        f0.p(byArray, "$this$decodeToString");
        Charset charset = d.a;
        String string2 = new String(byArray, charset);
        return string2;
    }

    private static final String A2(String string2) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2 = string2.toLowerCase();
        f0.o(string2, "(this as java.lang.String).toLowerCase()");
        return string2;
    }

    public static final String B1(byte[] object, int n10, int n11, boolean bl2) {
        f0.p(object, "$this$decodeToString");
        Object object2 = c.a;
        int n12 = ((byte[])object).length;
        ((c$a)object2).a(n10, n11, n12);
        if (!bl2) {
            object2 = d.a;
            String string2 = new String((byte[])object, n10, n11 -= n10, (Charset)object2);
            return string2;
        }
        CharsetDecoder charsetDecoder = d.a.newDecoder();
        object2 = CodingErrorAction.REPORT;
        charsetDecoder = charsetDecoder.onMalformedInput((CodingErrorAction)object2);
        object2 = CodingErrorAction.REPORT;
        charsetDecoder = charsetDecoder.onUnmappableCharacter((CodingErrorAction)object2);
        object = ByteBuffer.wrap(object, n10, n11 -= n10);
        object = charsetDecoder.decode((ByteBuffer)object).toString();
        f0.o(object, "decoder.decode(ByteBuffe\u2026- startIndex)).toString()");
        return object;
    }

    private static final String B2(String string2, Locale locale) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2 = string2.toLowerCase(locale);
        f0.o(string2, "(this as java.lang.String).toLowerCase(locale)");
        return string2;
    }

    public static /* synthetic */ String C1(byte[] byArray, int n10, int n11, boolean bl2, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n13 = n12 & 2) != 0) {
            n11 = byArray.length;
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return u.B1(byArray, n10, n11, bl2);
    }

    private static final Pattern C2(String object, int n10) {
        object = Pattern.compile((String)object, n10);
        f0.o(object, "java.util.regex.Pattern.compile(this, flags)");
        return object;
    }

    public static final byte[] D1(String object) {
        f0.p(object, "$this$encodeToByteArray");
        Charset charset = d.a;
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        return object;
    }

    public static /* synthetic */ Pattern D2(String object, int n10, int n11, Object object2) {
        if ((n11 &= 1) != 0) {
            n10 = 0;
        }
        object = Pattern.compile((String)object, n10);
        f0.o(object, "java.util.regex.Pattern.compile(this, flags)");
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final byte[] E1(String object, int n10, int n11, boolean bl2) {
        block5: {
            block4: {
                f0.p(object, "$this$encodeToByteArray");
                Object object2 = c.a;
                int n12 = ((String)object).length();
                ((c$a)object2).a(n10, n11, n12);
                if (!bl2) {
                    object = ((String)object).substring(n10, n11);
                    f0.o(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    Charset charset = d.a;
                    Objects.requireNonNull(object, "null cannot be cast to non-null type java.lang.String");
                    object = ((String)object).getBytes(charset);
                    f0.o(object, "(this as java.lang.String).getBytes(charset)");
                    return object;
                }
                CharsetEncoder charsetEncoder = d.a.newEncoder();
                object2 = CodingErrorAction.REPORT;
                charsetEncoder = charsetEncoder.onMalformedInput((CodingErrorAction)object2);
                object2 = CodingErrorAction.REPORT;
                charsetEncoder = charsetEncoder.onUnmappableCharacter((CodingErrorAction)object2);
                object = CharBuffer.wrap((CharSequence)object, n10, n11);
                n10 = (int)(((ByteBuffer)(object = charsetEncoder.encode((CharBuffer)object))).hasArray() ? 1 : 0);
                if (n10 == 0 || (n10 = ((ByteBuffer)object).arrayOffset()) != 0) break block4;
                n10 = ((Buffer)object).remaining();
                byte[] byArray = ((ByteBuffer)object).array();
                f0.m(byArray);
                n11 = byArray.length;
                if (n10 == n11) break block5;
            }
            n10 = ((Buffer)object).remaining();
            byte[] byArray = new byte[n10];
            ((ByteBuffer)object).get(byArray);
            return byArray;
        }
        object = ((ByteBuffer)object).array();
        String string2 = "byteBuffer.array()";
        f0.o(object, string2);
        return object;
    }

    private static final String E2(String string2) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2 = string2.toUpperCase();
        f0.o(string2, "(this as java.lang.String).toUpperCase()");
        return string2;
    }

    public static /* synthetic */ byte[] F1(String string2, int n10, int n11, boolean bl2, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n13 = n12 & 2) != 0) {
            n11 = string2.length();
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return u.E1(string2, n10, n11, bl2);
    }

    private static final String F2(String string2, Locale locale) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2 = string2.toUpperCase(locale);
        f0.o(string2, "(this as java.lang.String).toUpperCase(locale)");
        return string2;
    }

    public static final boolean G1(String string2, String string3, boolean bl2) {
        f0.p(string2, "$this$endsWith");
        String string4 = "suffix";
        f0.p(string3, string4);
        if (!bl2) {
            return string2.endsWith(string3);
        }
        int n10 = string2.length();
        int n11 = string3.length();
        int n12 = n10 - n11;
        int n13 = string3.length();
        return u.Z1(string2, n12, string3, 0, n13, true);
    }

    public static /* synthetic */ boolean H1(String string2, String string3, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return u.G1(string2, string3, bl2);
    }

    public static final boolean I1(String string2, String string3, boolean bl2) {
        if (string2 == null) {
            boolean bl3;
            if (string3 == null) {
                bl3 = true;
            } else {
                bl3 = false;
                string2 = null;
            }
            return bl3;
        }
        boolean bl4 = !bl2 ? string2.equals(string3) : string2.equalsIgnoreCase(string3);
        return bl4;
    }

    public static /* synthetic */ boolean J1(String string2, String string3, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return u.I1(string2, string3, bl2);
    }

    private static final /* synthetic */ String K1(String string2, Locale locale, Object ... objectArray) {
        int n10 = objectArray.length;
        objectArray = Arrays.copyOf(objectArray, n10);
        string2 = String.format(locale, string2, objectArray);
        f0.o(string2, "java.lang.String.format(locale, this, *args)");
        return string2;
    }

    private static final String L1(String string2, Object ... objectArray) {
        int n10 = objectArray.length;
        objectArray = Arrays.copyOf(objectArray, n10);
        string2 = String.format(string2, objectArray);
        f0.o(string2, "java.lang.String.format(this, *args)");
        return string2;
    }

    private static final String M1(s0 object, String string2, Object ... objectArray) {
        int n10 = objectArray.length;
        object = Arrays.copyOf(objectArray, n10);
        object = String.format(string2, object);
        f0.o(object, "java.lang.String.format(format, *args)");
        return object;
    }

    private static final /* synthetic */ String N1(s0 object, Locale locale, String string2, Object ... objectArray) {
        int n10 = objectArray.length;
        object = Arrays.copyOf(objectArray, n10);
        object = String.format(locale, string2, object);
        f0.o(object, "java.lang.String.format(locale, format, *args)");
        return object;
    }

    private static final String O1(String string2, Locale locale, Object ... objectArray) {
        int n10 = objectArray.length;
        objectArray = Arrays.copyOf(objectArray, n10);
        string2 = String.format(locale, string2, objectArray);
        f0.o(string2, "java.lang.String.format(locale, this, *args)");
        return string2;
    }

    private static final String P1(s0 object, Locale locale, String string2, Object ... objectArray) {
        int n10 = objectArray.length;
        object = Arrays.copyOf(objectArray, n10);
        object = String.format(locale, string2, object);
        f0.o(object, "java.lang.String.format(locale, format, *args)");
        return object;
    }

    public static final Comparator Q1(s0 object) {
        f0.p(object, "$this$CASE_INSENSITIVE_ORDER");
        object = String.CASE_INSENSITIVE_ORDER;
        f0.o(object, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return object;
    }

    private static final String R1(String string2) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2 = string2.intern();
        f0.o(string2, "(this as java.lang.String).intern()");
        return string2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final boolean S1(CharSequence var0) {
        block8: {
            block7: {
                var1_1 /* !! */  = "$this$isBlank";
                f0.p(var0, (String)var1_1 /* !! */ );
                var2_2 = var0.length();
                var3_3 = false;
                var4_4 = true;
                if (var2_2 == 0) break block7;
                var1_1 /* !! */  = StringsKt__StringsKt.Z2(var0);
                var5_5 = var1_1 /* !! */  instanceof Collection;
                if (var5_5 == 0) ** GOTO lbl-1000
                var6_6 = var1_1 /* !! */ ;
                var6_6 = (Collection)var1_1 /* !! */ ;
                var5_5 = var6_6.isEmpty();
                if (var5_5 != 0) {
                    while (true) {
                        var7_7 = var4_4;
                        break;
                    }
                } else lbl-1000:
                // 2 sources

                {
                    var1_1 /* !! */  = ((Iterable)var1_1 /* !! */ ).iterator();
                    do {
                        if ((var5_5 = var1_1 /* !! */ .hasNext()) == 0) ** continue;
                        var6_6 = var1_1 /* !! */ ;
                        var6_6 = var1_1 /* !! */ ;
                        var5_5 = var6_6.c();
                    } while ((var5_5 = (int)b.r(var0.charAt(var5_5))) != 0);
                    var7_7 = false;
                    var0 = null;
                }
                if (!var7_7) break block8;
            }
            var3_3 = var4_4;
        }
        return var3_3;
    }

    private static final int T1(String string2, char c10, int n10) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.indexOf(c10, n10);
    }

    private static final int U1(String string2, String string3, int n10) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.indexOf(string3, n10);
    }

    private static final int V1(String string2, char c10, int n10) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.lastIndexOf(c10, n10);
    }

    private static final int W1(String string2, String string3, int n10) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.lastIndexOf(string3, n10);
    }

    private static final int X1(String string2, int n10, int n11) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.offsetByCodePoints(n10, n11);
    }

    public static final boolean Y1(CharSequence charSequence, int n10, CharSequence charSequence2, int n11, int n12, boolean bl2) {
        f0.p(charSequence, "$this$regionMatches");
        String string2 = "other";
        f0.p(charSequence2, string2);
        boolean bl3 = charSequence instanceof String;
        if (bl3 && (bl3 = charSequence2 instanceof String)) {
            CharSequence charSequence3 = charSequence;
            charSequence3 = (String)charSequence;
            CharSequence charSequence4 = charSequence2;
            charSequence4 = (String)charSequence2;
            return u.Z1((String)charSequence3, n10, (String)charSequence4, n11, n12, bl2);
        }
        return StringsKt__StringsKt.S3(charSequence, n10, charSequence2, n11, n12, bl2);
    }

    public static final boolean Z1(String string2, int n10, String string3, int n11, int n12, boolean bl2) {
        boolean bl3;
        f0.p(string2, "$this$regionMatches");
        String string4 = "other";
        f0.p(string3, string4);
        if (!bl2) {
            bl3 = string2.regionMatches(n10, string3, n11, n12);
        } else {
            string4 = string2;
            bl3 = string2.regionMatches(bl2, n10, string3, n11, n12);
        }
        return bl3;
    }

    public static /* synthetic */ boolean a2(CharSequence charSequence, int n10, CharSequence charSequence2, int n11, int n12, boolean bl2, int n13, Object object) {
        if ((n13 &= 0x10) != 0) {
            bl2 = false;
        }
        return u.Y1(charSequence, n10, charSequence2, n11, n12, bl2);
    }

    public static /* synthetic */ boolean b2(String string2, int n10, String string3, int n11, int n12, boolean bl2, int n13, Object object) {
        if ((n13 &= 0x10) != 0) {
            bl2 = false;
        }
        return u.Z1(string2, n10, string3, n11, n12, bl2);
    }

    public static final String c2(CharSequence charSequence, int n10) {
        String string2;
        int n11;
        f0.p(charSequence, "$this$repeat");
        int n12 = 0;
        StringBuilder stringBuilder = null;
        int n13 = 1;
        if (n10 >= 0) {
            n11 = n13;
        } else {
            n11 = 0;
            string2 = null;
        }
        if (n11 != 0) {
            string2 = "";
            if (n10 != 0) {
                if (n10 != n13) {
                    int n14 = charSequence.length();
                    if (n14 != 0) {
                        if (n14 != n13) {
                            n11 = charSequence.length() * n10;
                            stringBuilder = new StringBuilder(n11);
                            if (n13 <= n10) {
                                while (true) {
                                    stringBuilder.append(charSequence);
                                    if (n13 == n10) break;
                                    ++n13;
                                }
                            }
                            string2 = stringBuilder.toString();
                            charSequence = "sb.toString()";
                            f0.o(string2, (String)charSequence);
                        } else {
                            char c10 = charSequence.charAt(0);
                            char[] cArray = new char[n10];
                            while (n12 < n10) {
                                cArray[n12] = c10;
                                ++n12;
                            }
                            string2 = new String(cArray);
                        }
                    }
                } else {
                    string2 = ((Object)charSequence).toString();
                }
            }
            return string2;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Count 'n' must be non-negative, but was ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append('.');
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    private static final String d1(StringBuffer stringBuffer) {
        String string2 = new String(stringBuffer);
        return string2;
    }

    public static final String d2(String string2, char c10, char c11, boolean bl2) {
        String string3 = "$this$replace";
        f0.p(string2, string3);
        if (!bl2) {
            string3 = string2.replace(c10, c11);
            f0.o(string3, "(this as java.lang.Strin\u2026replace(oldChar, newChar)");
            return string3;
        }
        char[] cArray = new char[]{c10};
        m m10 = StringsKt__StringsKt.L4(string2, cArray, bl2, 0, 4, null);
        String string4 = String.valueOf(c11);
        return SequencesKt___SequencesKt.V0(m10, string4, null, null, 0, null, null, 62, null);
    }

    private static final String e1(StringBuilder stringBuilder) {
        String string2 = new String(stringBuilder);
        return string2;
    }

    public static final String e2(String string2, String string3, String string4, boolean bl2) {
        f0.p(string2, "$this$replace");
        f0.p(string3, "oldValue");
        f0.p(string4, "newValue");
        Object object = new String[]{string3};
        Object object2 = string2;
        object2 = StringsKt__StringsKt.M4(string2, object, bl2, 0, 4, null);
        object = string4;
        return SequencesKt___SequencesKt.V0((m)object2, string4, null, null, 0, null, null, 62, null);
    }

    private static final String f1(byte[] byArray) {
        Charset charset = d.a;
        String string2 = new String(byArray, charset);
        return string2;
    }

    public static /* synthetic */ String f2(String string2, char c10, char c11, boolean bl2, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            bl2 = false;
        }
        return u.d2(string2, c10, c11, bl2);
    }

    private static final String g1(byte[] byArray, int n10, int n11) {
        Charset charset = d.a;
        String string2 = new String(byArray, n10, n11, charset);
        return string2;
    }

    public static /* synthetic */ String g2(String string2, String string3, String string4, boolean bl2, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            bl2 = false;
        }
        return u.e2(string2, string3, string4, bl2);
    }

    private static final String h1(byte[] byArray, int n10, int n11, Charset charset) {
        String string2 = new String(byArray, n10, n11, charset);
        return string2;
    }

    public static final String h2(String string2, char c10, char c11, boolean bl2) {
        String string3 = "$this$replaceFirst";
        f0.p(string2, string3);
        int n10 = 2;
        c10 = (char)StringsKt__StringsKt.i3(string2, c10, 0, bl2, n10, null);
        if (c10 >= '\u0000') {
            int n11 = c10 + '\u0001';
            String string4 = String.valueOf(c11);
            string2 = ((Object)StringsKt__StringsKt.y4(string2, c10, n11, string4)).toString();
        }
        return string2;
    }

    private static final String i1(byte[] byArray, Charset charset) {
        String string2 = new String(byArray, charset);
        return string2;
    }

    public static final String i2(String string2, String string3, String string4, boolean n10) {
        f0.p(string2, "$this$replaceFirst");
        f0.p(string3, "oldValue");
        String string5 = "newValue";
        f0.p(string4, string5);
        int n11 = 2;
        n10 = StringsKt__StringsKt.j3(string2, string3, 0, n10 != 0, n11, null);
        if (n10 >= 0) {
            int n12 = string3.length() + n10;
            string2 = ((Object)StringsKt__StringsKt.y4(string2, n10, n12, string4)).toString();
        }
        return string2;
    }

    private static final String j1(char[] cArray) {
        String string2 = new String(cArray);
        return string2;
    }

    public static /* synthetic */ String j2(String string2, char c10, char c11, boolean bl2, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            bl2 = false;
        }
        return u.h2(string2, c10, c11, bl2);
    }

    private static final String k1(char[] cArray, int n10, int n11) {
        String string2 = new String(cArray, n10, n11);
        return string2;
    }

    public static /* synthetic */ String k2(String string2, String string3, String string4, boolean bl2, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            bl2 = false;
        }
        return u.i2(string2, string3, string4, bl2);
    }

    private static final String l1(int[] nArray, int n10, int n11) {
        String string2 = new String(nArray, n10, n11);
        return string2;
    }

    public static final List l2(CharSequence object, Pattern serializable, int n10) {
        boolean bl2;
        f0.p(object, "$this$split");
        String string2 = "regex";
        f0.p(serializable, string2);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        if (bl2) {
            if (n10 == 0) {
                n10 = -1;
            }
            object = serializable.split((CharSequence)object, n10);
            f0.o(object, "regex.split(this, if (limit == 0) -1 else limit)");
            return n.t((Object[])object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Limit must be non-negative, but was ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append('.');
        object = ((StringBuilder)object).toString();
        object = object.toString();
        serializable = new IllegalArgumentException((String)object);
        throw serializable;
    }

    public static final String m1(String string2) {
        f0.p(string2, "$this$capitalize");
        Locale locale = Locale.getDefault();
        f0.o(locale, "Locale.getDefault()");
        return u.n1(string2, locale);
    }

    public static /* synthetic */ List m2(CharSequence charSequence, Pattern pattern, int n10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            n10 = 0;
        }
        return u.l2(charSequence, pattern, n10);
    }

    /*
     * WARNING - void declaration
     */
    public static final String n1(String string2, Locale object) {
        char c10;
        boolean bl2;
        void var3_6;
        f0.p(string2, "$this$capitalize");
        String string3 = "locale";
        f0.p(object, string3);
        int c102 = string2.length();
        int n10 = 1;
        String string4 = null;
        if (c102 > 0) {
            int n11 = n10;
        } else {
            boolean bl3 = false;
            string3 = null;
        }
        if (var3_6 != false && (bl2 = Character.isLowerCase(c10 = string2.charAt(0)))) {
            char c11;
            StringBuilder stringBuilder = new StringBuilder();
            char c12 = Character.toTitleCase(c10);
            if (c12 != (c11 = Character.toUpperCase(c10))) {
                stringBuilder.append(c12);
            } else {
                string3 = string2.substring(0, n10);
                f0.o(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                string4 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(string3, string4);
                object = string3.toUpperCase((Locale)object);
                string3 = "(this as java.lang.String).toUpperCase(locale)";
                f0.o(object, string3);
                stringBuilder.append((String)object);
            }
            string2 = string2.substring(n10);
            f0.o(string2, "(this as java.lang.String).substring(startIndex)");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object = "StringBuilder().apply(builderAction).toString()";
            f0.o(string2, (String)object);
        }
        return string2;
    }

    public static final boolean n2(String string2, String string3, int n10, boolean bl2) {
        f0.p(string2, "$this$startsWith");
        String string4 = "prefix";
        f0.p(string3, string4);
        if (!bl2) {
            return string2.startsWith(string3, n10);
        }
        int n11 = string3.length();
        string4 = string2;
        return u.Z1(string2, n10, string3, 0, n11, bl2);
    }

    private static final int o1(String string2, int n10) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.codePointAt(n10);
    }

    public static final boolean o2(String string2, String string3, boolean bl2) {
        f0.p(string2, "$this$startsWith");
        String string4 = "prefix";
        f0.p(string3, string4);
        if (!bl2) {
            return string2.startsWith(string3);
        }
        int n10 = string3.length();
        string4 = string2;
        return u.Z1(string2, 0, string3, 0, n10, bl2);
    }

    private static final int p1(String string2, int n10) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.codePointBefore(n10);
    }

    public static /* synthetic */ boolean p2(String string2, String string3, int n10, boolean bl2, int n11, Object object) {
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return u.n2(string2, string3, n10, bl2);
    }

    private static final int q1(String string2, int n10, int n11) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.codePointCount(n10, n11);
    }

    public static /* synthetic */ boolean q2(String string2, String string3, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return u.o2(string2, string3, bl2);
    }

    public static final int r1(String string2, String string3, boolean bl2) {
        f0.p(string2, "$this$compareTo");
        String string4 = "other";
        f0.p(string3, string4);
        if (bl2) {
            return string2.compareToIgnoreCase(string3);
        }
        return string2.compareTo(string3);
    }

    private static final String r2(String string2, int n10) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2 = string2.substring(n10);
        f0.o(string2, "(this as java.lang.String).substring(startIndex)");
        return string2;
    }

    public static /* synthetic */ int s1(String string2, String string3, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return u.r1(string2, string3, bl2);
    }

    private static final String s2(String string2, int n10, int n11) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2 = string2.substring(n10, n11);
        f0.o(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static final String t1(char[] cArray) {
        f0.p(cArray, "$this$concatToString");
        String string2 = new String(cArray);
        return string2;
    }

    private static final byte[] t2(String object, Charset charset) {
        Objects.requireNonNull(object, "null cannot be cast to non-null type java.lang.String");
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        return object;
    }

    public static final String u1(char[] cArray, int n10, int n11) {
        f0.p(cArray, "$this$concatToString");
        Object object = c.a;
        int n12 = cArray.length;
        ((c$a)object).a(n10, n11, n12);
        object = new String(cArray, n10, n11 -= n10);
        return object;
    }

    public static /* synthetic */ byte[] u2(String object, Charset charset, int n10, Object object2) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type java.lang.String");
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        return object;
    }

    public static /* synthetic */ String v1(char[] cArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = cArray.length;
        }
        return u.u1(cArray, n10, n11);
    }

    private static final char[] v2(String object) {
        Objects.requireNonNull(object, "null cannot be cast to non-null type java.lang.String");
        object = ((String)object).toCharArray();
        f0.o(object, "(this as java.lang.String).toCharArray()");
        return object;
    }

    private static final boolean w1(String string2, CharSequence charSequence) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.contentEquals(charSequence);
    }

    public static final char[] w2(String string2, int n10, int n11) {
        f0.p(string2, "$this$toCharArray");
        Object object = c.a;
        int n12 = string2.length();
        ((c$a)object).a(n10, n11, n12);
        object = new char[n11 - n10];
        string2.getChars(n10, n11, (char[])object, 0);
        return object;
    }

    private static final boolean x1(String string2, StringBuffer stringBuffer) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        return string2.contentEquals(stringBuffer);
    }

    private static final char[] x2(String string2, char[] cArray, int n10, int n11, int n12) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2.getChars(n11, n12, cArray, n10);
        return cArray;
    }

    public static final String y1(String string2) {
        CharSequence charSequence = "$this$decapitalize";
        f0.p(string2, (String)charSequence);
        int n10 = string2.length();
        int n11 = 1;
        String string3 = null;
        if (n10 > 0) {
            n10 = n11;
        } else {
            n10 = 0;
            charSequence = null;
        }
        if (n10 != 0 && (n10 = (int)(Character.isLowerCase(string2.charAt(0)) ? 1 : 0)) == 0) {
            charSequence = new StringBuilder();
            string3 = string2.substring(0, n11);
            f0.o(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            Objects.requireNonNull(string3, "null cannot be cast to non-null type java.lang.String");
            string3 = string3.toLowerCase();
            String string4 = "(this as java.lang.String).toLowerCase()";
            f0.o(string3, string4);
            ((StringBuilder)charSequence).append(string3);
            string2 = string2.substring(n11);
            String string5 = "(this as java.lang.String).substring(startIndex)";
            f0.o(string2, string5);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
        }
        return string2;
    }

    public static /* synthetic */ char[] y2(String string2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = string2.length();
        }
        return u.w2(string2, n10, n11);
    }

    public static final String z1(String string2, Locale object) {
        f0.p(string2, "$this$decapitalize");
        CharSequence charSequence = "locale";
        f0.p(object, (String)charSequence);
        int n10 = string2.length();
        int n11 = 1;
        String string3 = null;
        if (n10 > 0) {
            n10 = n11;
        } else {
            n10 = 0;
            charSequence = null;
        }
        if (n10 != 0 && (n10 = (int)(Character.isLowerCase(string2.charAt(0)) ? 1 : 0)) == 0) {
            charSequence = new StringBuilder();
            string3 = string2.substring(0, n11);
            f0.o(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            String string4 = "null cannot be cast to non-null type java.lang.String";
            Objects.requireNonNull(string3, string4);
            object = string3.toLowerCase((Locale)object);
            string3 = "(this as java.lang.String).toLowerCase(locale)";
            f0.o(object, string3);
            ((StringBuilder)charSequence).append((String)object);
            string2 = string2.substring(n11);
            object = "(this as java.lang.String).substring(startIndex)";
            f0.o(string2, (String)object);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
        }
        return string2;
    }

    public static /* synthetic */ char[] z2(String string2, char[] cArray, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = string2.length();
        }
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2.getChars(n11, n12, cArray, n10);
        return cArray;
    }
}

