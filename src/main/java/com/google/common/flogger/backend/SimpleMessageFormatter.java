/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.LogContext$Key;
import com.google.common.flogger.MetadataKey;
import com.google.common.flogger.backend.FormatChar;
import com.google.common.flogger.backend.FormatOptions;
import com.google.common.flogger.backend.KeyValueFormatter;
import com.google.common.flogger.backend.LogData;
import com.google.common.flogger.backend.Metadata;
import com.google.common.flogger.backend.SimpleMessageFormatter$1;
import com.google.common.flogger.backend.SimpleMessageFormatter$SimpleLogHandler;
import com.google.common.flogger.backend.Tags;
import com.google.common.flogger.backend.TemplateContext;
import com.google.common.flogger.parameter.DateTimeFormat;
import com.google.common.flogger.parameter.Parameter;
import com.google.common.flogger.parameter.ParameterVisitor;
import com.google.common.flogger.parser.MessageBuilder;
import com.google.common.flogger.parser.MessageParser;
import com.google.common.flogger.util.Checks;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Locale;
import java.util.logging.Level;

public final class SimpleMessageFormatter
extends MessageBuilder
implements ParameterVisitor {
    private static final String EXTRA_ARGUMENT_MESSAGE = " [ERROR: UNUSED LOG ARGUMENTS]";
    private static final Locale FORMAT_LOCALE = Locale.ROOT;
    private static final String MISSING_ARGUMENT_MESSAGE = "[ERROR: MISSING LOG ARGUMENT]";
    private final Object[] args;
    private int literalStart;
    private final StringBuilder out;

    private SimpleMessageFormatter(TemplateContext objectArray, Object[] objectArray2) {
        super((TemplateContext)objectArray);
        objectArray = new StringBuilder();
        this.out = objectArray;
        this.literalStart = 0;
        objectArray = (Object[])Checks.checkNotNull(objectArray2, "log arguments");
        this.args = objectArray;
    }

    private static String appendContext(StringBuilder stringBuilder, Metadata metadata) {
        int n10;
        KeyValueFormatter keyValueFormatter = new KeyValueFormatter("[CONTEXT ", " ]", stringBuilder);
        Object object = null;
        for (int i10 = 0; i10 < (n10 = metadata.size()); ++i10) {
            Object object2;
            MetadataKey metadataKey = metadata.getKey(i10);
            boolean bl2 = metadataKey.equals(object2 = LogContext$Key.LOG_CAUSE);
            if (bl2) continue;
            object2 = LogContext$Key.TAGS;
            boolean bl3 = metadataKey.equals(object2);
            if (bl3) {
                object = metadata.getValue(i10);
                object = (Tags)((MetadataKey)object2).cast(object);
                continue;
            }
            object2 = metadata.getValue(i10);
            metadataKey.emit(object2, keyValueFormatter);
        }
        if (object != null) {
            ((Tags)object).emitAll(keyValueFormatter);
        }
        keyValueFormatter.done();
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void appendFormatted(StringBuilder stringBuilder, Object object, FormatChar object2, FormatOptions object3) {
        Object object4;
        int n10;
        int n11;
        int n12;
        Object object5;
        block13: {
            block14: {
                object5 = SimpleMessageFormatter$1.$SwitchMap$com$google$common$flogger$backend$FormatChar;
                n12 = ((Enum)object2).ordinal();
                n11 = object5[n12];
                if (n11 == (n12 = 1)) break block14;
                n10 = 2;
                if (n11 != n10 && n11 != (n10 = 3)) {
                    n10 = 4;
                    if (n11 != n10) {
                        n10 = 5;
                        if (n11 == n10 && (n11 = (int)(((FormatOptions)object4).isDefault() ? 1 : 0)) != 0) {
                            boolean bl2 = object instanceof Character;
                            if (bl2) {
                                stringBuilder.append(object);
                                return;
                            }
                            int n13 = ((Number)(object = (Number)object)).intValue();
                            bl2 = Character.isBmpCodePoint(n13);
                            if (bl2) {
                                n13 = (char)n13;
                                stringBuilder.append((char)n13);
                                return;
                            }
                            object = Character.toChars(n13);
                            stringBuilder.append((char[])object);
                            return;
                        }
                        break block13;
                    } else {
                        object5 = ((FormatOptions)object4).filter(128, false, false);
                        n11 = (int)(((FormatOptions)object5).equals(object4) ? 1 : 0);
                        if (n11 != 0) {
                            object = (Number)object;
                            SimpleMessageFormatter.appendHex(stringBuilder, (Number)object, (FormatOptions)object4);
                            return;
                        }
                    }
                    break block13;
                } else {
                    n11 = (int)(((FormatOptions)object4).isDefault() ? 1 : 0);
                    if (n11 != 0) {
                        stringBuilder.append(object);
                        return;
                    }
                }
                break block13;
            }
            n11 = object instanceof Formattable;
            if (n11 != 0) {
                SimpleMessageFormatter.safeFormatTo((Formattable)object, stringBuilder, (FormatOptions)object4);
                return;
            }
            n11 = (int)(((FormatOptions)object4).isDefault() ? 1 : 0);
            if (n11 != 0) {
                object = SimpleMessageFormatter.safeToString(object);
                stringBuilder.append((String)object);
                return;
            }
        }
        object5 = ((FormatChar)((Object)object2)).getDefaultFormatString();
        n10 = (int)(((FormatOptions)object4).isDefault() ? 1 : 0);
        if (n10 == 0) {
            char c10 = ((FormatChar)((Object)object2)).getChar();
            n11 = (int)(((FormatOptions)object4).shouldUpperCase() ? 1 : 0);
            if (n11 != 0) {
                n11 = (char)-33;
                c10 = (char)(c10 & n11);
            }
            String string2 = "%";
            object5 = new StringBuilder(string2);
            object4 = ((FormatOptions)object4).appendPrintfOptions((StringBuilder)object5);
            ((StringBuilder)object4).append(c10);
            object5 = ((StringBuilder)object4).toString();
        }
        Locale locale = FORMAT_LOCALE;
        object4 = new Object[n12];
        object4[0] = object;
        object = String.format(locale, (String)object5, (Object[])object4);
        stringBuilder.append((String)object);
    }

    private static void appendHex(StringBuilder stringBuilder, long l10, boolean bl2) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            String string2 = "0";
            stringBuilder.append(string2);
        } else {
            String string3 = bl2 ? "0123456789ABCDEF" : "0123456789abcdef";
            object = Long.numberOfLeadingZeros(l10);
            for (object = (Object)(63 - object & 0xFFFFFFFC); object >= 0; object += -4) {
                long l13 = l10 >>> object;
                long l14 = 15;
                char c10 = (int)(l13 &= l14);
                c10 = string3.charAt(c10);
                stringBuilder.append(c10);
            }
        }
    }

    public static void appendHex(StringBuilder serializable, Number object, FormatOptions object2) {
        block9: {
            block5: {
                boolean bl2;
                block8: {
                    boolean bl3;
                    block7: {
                        block6: {
                            block4: {
                                bl2 = ((FormatOptions)object2).shouldUpperCase();
                                long l10 = ((Number)object).longValue();
                                bl3 = object instanceof Long;
                                if (!bl3) break block4;
                                SimpleMessageFormatter.appendHex((StringBuilder)serializable, l10, bl2);
                                break block5;
                            }
                            bl3 = object instanceof Integer;
                            if (!bl3) break block6;
                            long l11 = 0xFFFFFFFFL;
                            SimpleMessageFormatter.appendHex((StringBuilder)serializable, l10 &= l11, bl2);
                            break block5;
                        }
                        bl3 = object instanceof Byte;
                        if (!bl3) break block7;
                        long l12 = 255L;
                        SimpleMessageFormatter.appendHex((StringBuilder)serializable, l10 &= l12, bl2);
                        break block5;
                    }
                    bl3 = object instanceof Short;
                    if (!bl3) break block8;
                    long l13 = (char)-1;
                    SimpleMessageFormatter.appendHex((StringBuilder)serializable, l10 &= l13, bl2);
                    break block5;
                }
                int n10 = object instanceof BigInteger;
                if (n10 == 0) break block9;
                object = (BigInteger)object;
                n10 = 16;
                object = ((BigInteger)object).toString(n10);
                if (bl2) {
                    object2 = FORMAT_LOCALE;
                    object = ((String)object).toUpperCase((Locale)object2);
                }
                ((StringBuilder)serializable).append((String)object);
            }
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("unsupported number type: ");
        object = object.getClass();
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        serializable = new RuntimeException((String)object);
        throw serializable;
    }

    private static void appendInvalid(StringBuilder stringBuilder, Object object, String string2) {
        stringBuilder.append("[INVALID: format=");
        stringBuilder.append(string2);
        stringBuilder.append(", type=");
        string2 = object.getClass().getCanonicalName();
        stringBuilder.append(string2);
        stringBuilder.append(", value=");
        object = SimpleMessageFormatter.safeToString(object);
        stringBuilder.append((String)object);
        stringBuilder.append("]");
    }

    public static void format(LogData object, SimpleMessageFormatter$SimpleLogHandler simpleMessageFormatter$SimpleLogHandler) {
        Object object2;
        StringBuilder stringBuilder;
        Object object3 = object.getMetadata();
        Object object4 = LogContext$Key.LOG_CAUSE;
        object4 = (Throwable)((Metadata)object3).findValue((MetadataKey)object4);
        int n10 = ((Metadata)object3).size();
        int n11 = 1;
        if (n10 != 0 && ((n10 = ((Metadata)object3).size()) != n11 || object4 == null)) {
            n11 = 0;
            stringBuilder = null;
        }
        if ((object2 = object.getTemplateContext()) == null) {
            object2 = SimpleMessageFormatter.safeToString(object.getLiteralArgument());
            if (n11 == 0) {
                stringBuilder = new StringBuilder((String)object2);
                object2 = SimpleMessageFormatter.appendContext(stringBuilder, (Metadata)object3);
            }
        } else {
            object2 = SimpleMessageFormatter.formatMessage((LogData)object);
            object3 = n11 != 0 ? ((StringBuilder)object2).toString() : SimpleMessageFormatter.appendContext((StringBuilder)object2, (Metadata)object3);
            object2 = object3;
        }
        object = object.getLevel();
        simpleMessageFormatter$SimpleLogHandler.handleFormattedLogMessage((Level)object, (String)object2, (Throwable)object4);
    }

    private static StringBuilder formatMessage(LogData object) {
        int n10;
        Object object2 = object.getTemplateContext();
        Object[] objectArray = object.getArguments();
        SimpleMessageFormatter simpleMessageFormatter = new SimpleMessageFormatter((TemplateContext)object2, objectArray);
        object2 = (StringBuilder)simpleMessageFormatter.build();
        int n11 = ((Object[])(object = object.getArguments())).length;
        if (n11 > (n10 = simpleMessageFormatter.getExpectedArgumentCount())) {
            object = EXTRA_ARGUMENT_MESSAGE;
            ((StringBuilder)object2).append((String)object);
        }
        return object2;
    }

    private static String getErrorString(Object object, RuntimeException object2) {
        try {
            object2 = ((Throwable)object2).toString();
        }
        catch (RuntimeException runtimeException) {
            object2 = runtimeException.getClass().getSimpleName();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        String string2 = object.getClass().getName();
        stringBuilder.append(string2);
        stringBuilder.append("@");
        int n10 = System.identityHashCode(object);
        stringBuilder.append(n10);
        stringBuilder.append(": ");
        stringBuilder.append((String)object2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void safeFormatTo(Formattable object, StringBuilder appendable, FormatOptions formatOptions) {
        Locale locale;
        int n10;
        Formatter formatter;
        int n11;
        int n12 = formatOptions.getFlags() & 0xA2;
        if (n12 != 0) {
            n11 = n12 & 0x20;
            int n13 = 0;
            formatter = null;
            n11 = n11 != 0 ? 1 : 0;
            n10 = n12 & 0x80;
            if (n10 != 0) {
                n10 = 2;
            } else {
                n10 = 0;
                locale = null;
            }
            n11 |= n10;
            if ((n12 &= 2) != 0) {
                n13 = 4;
            }
            n12 = n11 | n13;
        }
        n11 = ((StringBuilder)appendable).length();
        locale = FORMAT_LOCALE;
        formatter = new Formatter(appendable, locale);
        try {
            n10 = formatOptions.getWidth();
        }
        catch (RuntimeException runtimeException) {
            ((StringBuilder)appendable).setLength(n11);
            try {
                appendable = formatter.out();
            }
            catch (IOException iOException) {
                return;
            }
            object = SimpleMessageFormatter.getErrorString(object, runtimeException);
            appendable.append((CharSequence)object);
            return;
        }
        int n14 = formatOptions.getPrecision();
        object.formatTo(formatter, n12, n10, n14);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String safeToString(Object object) {
        if (object == null) return "null";
        try {
            return SimpleMessageFormatter.toString(object);
        }
        catch (RuntimeException runtimeException) {
            return SimpleMessageFormatter.getErrorString(object, runtimeException);
        }
    }

    public static String toString(Object object) {
        Class<?> clazz = object.getClass();
        boolean bl2 = clazz.isArray();
        if (!bl2) {
            return String.valueOf(object);
        }
        bl2 = object instanceof int[];
        if (bl2) {
            return Arrays.toString((int[])object);
        }
        bl2 = object instanceof long[];
        if (bl2) {
            return Arrays.toString((long[])object);
        }
        bl2 = object instanceof byte[];
        if (bl2) {
            return Arrays.toString((byte[])object);
        }
        bl2 = object instanceof char[];
        if (bl2) {
            return Arrays.toString((char[])object);
        }
        bl2 = object instanceof short[];
        if (bl2) {
            return Arrays.toString((short[])object);
        }
        bl2 = object instanceof float[];
        if (bl2) {
            return Arrays.toString((float[])object);
        }
        bl2 = object instanceof double[];
        if (bl2) {
            return Arrays.toString((double[])object);
        }
        bl2 = object instanceof boolean[];
        if (bl2) {
            return Arrays.toString((boolean[])object);
        }
        return Arrays.toString((Object[])object);
    }

    public void addParameterImpl(int n10, int n11, Parameter parameter) {
        MessageParser messageParser = this.getParser();
        StringBuilder stringBuilder = this.out;
        String string2 = this.getMessage();
        int n12 = this.literalStart;
        messageParser.unescape(stringBuilder, string2, n12, n10);
        Object[] objectArray = this.args;
        parameter.accept((ParameterVisitor)this, objectArray);
        this.literalStart = n11;
    }

    public StringBuilder buildImpl() {
        MessageParser messageParser = this.getParser();
        StringBuilder stringBuilder = this.out;
        String string2 = this.getMessage();
        int n10 = this.literalStart;
        int n11 = this.getMessage().length();
        messageParser.unescape(stringBuilder, string2, n10, n11);
        return this.out;
    }

    public void visit(Object object, FormatChar object2, FormatOptions object3) {
        Object object4 = object2.getType();
        boolean bl2 = object4.canFormat(object);
        if (bl2) {
            object4 = this.out;
            SimpleMessageFormatter.appendFormatted((StringBuilder)object4, object, object2, (FormatOptions)object3);
        } else {
            object3 = this.out;
            object2 = object2.getDefaultFormatString();
            SimpleMessageFormatter.appendInvalid((StringBuilder)object3, object, (String)object2);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void visitDateTime(Object object, DateTimeFormat object2, FormatOptions object3) {
        boolean bl2 = object instanceof Date;
        if (!(bl2 || (bl2 = object instanceof Calendar) || (bl2 = object instanceof Long))) {
            object3 = this.out;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "%t";
            stringBuilder.append(string2);
            char c10 = ((DateTimeFormat)((Object)object2)).getChar();
            stringBuilder.append(c10);
            object2 = stringBuilder.toString();
            SimpleMessageFormatter.appendInvalid((StringBuilder)object3, object, (String)object2);
        } else {
            void var8_14;
            Object[] objectArray = "%";
            Serializable serializable = new StringBuilder((String)objectArray);
            serializable = ((FormatOptions)object3).appendPrintfOptions((StringBuilder)serializable);
            boolean c11 = ((FormatOptions)object3).shouldUpperCase();
            if (c11) {
                int n10 = 84;
            } else {
                int n11 = 116;
            }
            serializable.append((char)var8_14);
            char c12 = ((DateTimeFormat)((Object)object2)).getChar();
            serializable.append(c12);
            object2 = serializable.toString();
            object3 = this.out;
            serializable = FORMAT_LOCALE;
            int n12 = 1;
            objectArray = new Object[n12];
            objectArray[0] = object;
            object = String.format((Locale)serializable, (String)object2, objectArray);
            ((StringBuilder)object3).append((String)object);
        }
    }

    public void visitMissing() {
        this.out.append(MISSING_ARGUMENT_MESSAGE);
    }

    public void visitNull() {
        this.out.append("null");
    }

    public void visitPreformatted(Object object, String string2) {
        this.out.append(string2);
    }
}

