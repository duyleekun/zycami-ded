/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

public final class StandardSystemProperty
extends Enum {
    private static final /* synthetic */ StandardSystemProperty[] $VALUES;
    public static final /* enum */ StandardSystemProperty FILE_SEPARATOR;
    public static final /* enum */ StandardSystemProperty JAVA_CLASS_PATH;
    public static final /* enum */ StandardSystemProperty JAVA_CLASS_VERSION;
    public static final /* enum */ StandardSystemProperty JAVA_COMPILER;
    public static final /* enum */ StandardSystemProperty JAVA_EXT_DIRS;
    public static final /* enum */ StandardSystemProperty JAVA_HOME;
    public static final /* enum */ StandardSystemProperty JAVA_IO_TMPDIR;
    public static final /* enum */ StandardSystemProperty JAVA_LIBRARY_PATH;
    public static final /* enum */ StandardSystemProperty JAVA_SPECIFICATION_NAME;
    public static final /* enum */ StandardSystemProperty JAVA_SPECIFICATION_VENDOR;
    public static final /* enum */ StandardSystemProperty JAVA_SPECIFICATION_VERSION;
    public static final /* enum */ StandardSystemProperty JAVA_VENDOR;
    public static final /* enum */ StandardSystemProperty JAVA_VENDOR_URL;
    public static final /* enum */ StandardSystemProperty JAVA_VERSION;
    public static final /* enum */ StandardSystemProperty JAVA_VM_NAME;
    public static final /* enum */ StandardSystemProperty JAVA_VM_SPECIFICATION_NAME;
    public static final /* enum */ StandardSystemProperty JAVA_VM_SPECIFICATION_VENDOR;
    public static final /* enum */ StandardSystemProperty JAVA_VM_SPECIFICATION_VERSION;
    public static final /* enum */ StandardSystemProperty JAVA_VM_VENDOR;
    public static final /* enum */ StandardSystemProperty JAVA_VM_VERSION;
    public static final /* enum */ StandardSystemProperty LINE_SEPARATOR;
    public static final /* enum */ StandardSystemProperty OS_ARCH;
    public static final /* enum */ StandardSystemProperty OS_NAME;
    public static final /* enum */ StandardSystemProperty OS_VERSION;
    public static final /* enum */ StandardSystemProperty PATH_SEPARATOR;
    public static final /* enum */ StandardSystemProperty USER_DIR;
    public static final /* enum */ StandardSystemProperty USER_HOME;
    public static final /* enum */ StandardSystemProperty USER_NAME;
    private final String key;

    static {
        StandardSystemProperty standardSystemProperty;
        StandardSystemProperty standardSystemProperty2;
        StandardSystemProperty standardSystemProperty3;
        StandardSystemProperty standardSystemProperty4;
        StandardSystemProperty standardSystemProperty5;
        StandardSystemProperty standardSystemProperty6;
        StandardSystemProperty standardSystemProperty7;
        StandardSystemProperty standardSystemProperty8;
        StandardSystemProperty standardSystemProperty9;
        StandardSystemProperty standardSystemProperty10;
        StandardSystemProperty standardSystemProperty11;
        StandardSystemProperty standardSystemProperty12;
        StandardSystemProperty standardSystemProperty13;
        JAVA_VERSION = standardSystemProperty13 = new StandardSystemProperty("JAVA_VERSION", 0, "java.version");
        JAVA_VENDOR = standardSystemProperty12 = new StandardSystemProperty("JAVA_VENDOR", 1, "java.vendor");
        JAVA_VENDOR_URL = standardSystemProperty11 = new StandardSystemProperty("JAVA_VENDOR_URL", 2, "java.vendor.url");
        JAVA_HOME = standardSystemProperty10 = new StandardSystemProperty("JAVA_HOME", 3, "java.home");
        JAVA_VM_SPECIFICATION_VERSION = standardSystemProperty9 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VERSION", 4, "java.vm.specification.version");
        JAVA_VM_SPECIFICATION_VENDOR = standardSystemProperty8 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VENDOR", 5, "java.vm.specification.vendor");
        JAVA_VM_SPECIFICATION_NAME = standardSystemProperty7 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_NAME", 6, "java.vm.specification.name");
        JAVA_VM_VERSION = standardSystemProperty6 = new StandardSystemProperty("JAVA_VM_VERSION", 7, "java.vm.version");
        JAVA_VM_VENDOR = standardSystemProperty5 = new StandardSystemProperty("JAVA_VM_VENDOR", 8, "java.vm.vendor");
        JAVA_VM_NAME = standardSystemProperty4 = new StandardSystemProperty("JAVA_VM_NAME", 9, "java.vm.name");
        JAVA_SPECIFICATION_VERSION = standardSystemProperty3 = new StandardSystemProperty("JAVA_SPECIFICATION_VERSION", 10, "java.specification.version");
        JAVA_SPECIFICATION_VENDOR = standardSystemProperty2 = new StandardSystemProperty("JAVA_SPECIFICATION_VENDOR", 11, "java.specification.vendor");
        StandardSystemProperty[] standardSystemPropertyArray = new StandardSystemProperty("JAVA_SPECIFICATION_NAME", 12, "java.specification.name");
        JAVA_SPECIFICATION_NAME = standardSystemPropertyArray;
        StandardSystemProperty[] standardSystemPropertyArray2 = standardSystemPropertyArray;
        JAVA_CLASS_VERSION = standardSystemProperty = new StandardSystemProperty("JAVA_CLASS_VERSION", 13, "java.class.version");
        StandardSystemProperty standardSystemProperty14 = standardSystemProperty;
        standardSystemPropertyArray = new StandardSystemProperty("JAVA_CLASS_PATH", 14, "java.class.path");
        JAVA_CLASS_PATH = standardSystemPropertyArray;
        StandardSystemProperty[] standardSystemPropertyArray3 = standardSystemPropertyArray;
        JAVA_LIBRARY_PATH = standardSystemProperty = new StandardSystemProperty("JAVA_LIBRARY_PATH", 15, "java.library.path");
        StandardSystemProperty standardSystemProperty15 = standardSystemProperty;
        standardSystemPropertyArray = new StandardSystemProperty("JAVA_IO_TMPDIR", 16, "java.io.tmpdir");
        JAVA_IO_TMPDIR = standardSystemPropertyArray;
        StandardSystemProperty[] standardSystemPropertyArray4 = standardSystemPropertyArray;
        JAVA_COMPILER = standardSystemProperty = new StandardSystemProperty("JAVA_COMPILER", 17, "java.compiler");
        StandardSystemProperty standardSystemProperty16 = standardSystemProperty;
        standardSystemPropertyArray = new StandardSystemProperty("JAVA_EXT_DIRS", 18, "java.ext.dirs");
        JAVA_EXT_DIRS = standardSystemPropertyArray;
        StandardSystemProperty[] standardSystemPropertyArray5 = standardSystemPropertyArray;
        OS_NAME = standardSystemProperty = new StandardSystemProperty("OS_NAME", 19, "os.name");
        StandardSystemProperty standardSystemProperty17 = standardSystemProperty;
        standardSystemPropertyArray = new StandardSystemProperty("OS_ARCH", 20, "os.arch");
        OS_ARCH = standardSystemPropertyArray;
        StandardSystemProperty[] standardSystemPropertyArray6 = standardSystemPropertyArray;
        OS_VERSION = standardSystemProperty = new StandardSystemProperty("OS_VERSION", 21, "os.version");
        StandardSystemProperty standardSystemProperty18 = standardSystemProperty;
        standardSystemPropertyArray = new StandardSystemProperty("FILE_SEPARATOR", 22, "file.separator");
        FILE_SEPARATOR = standardSystemPropertyArray;
        StandardSystemProperty[] standardSystemPropertyArray7 = standardSystemPropertyArray;
        PATH_SEPARATOR = standardSystemProperty = new StandardSystemProperty("PATH_SEPARATOR", 23, "path.separator");
        StandardSystemProperty standardSystemProperty19 = standardSystemProperty;
        standardSystemPropertyArray = new StandardSystemProperty("LINE_SEPARATOR", 24, "line.separator");
        LINE_SEPARATOR = standardSystemPropertyArray;
        StandardSystemProperty[] standardSystemPropertyArray8 = standardSystemPropertyArray;
        USER_NAME = standardSystemProperty = new StandardSystemProperty("USER_NAME", 25, "user.name");
        StandardSystemProperty standardSystemProperty20 = standardSystemProperty;
        standardSystemPropertyArray = new StandardSystemProperty("USER_HOME", 26, "user.home");
        USER_HOME = standardSystemPropertyArray;
        StandardSystemProperty[] standardSystemPropertyArray9 = standardSystemPropertyArray;
        USER_DIR = standardSystemProperty = new StandardSystemProperty("USER_DIR", 27, "user.dir");
        standardSystemPropertyArray = new StandardSystemProperty[]{standardSystemProperty13, standardSystemProperty12, standardSystemProperty11, standardSystemProperty10, standardSystemProperty9, standardSystemProperty8, standardSystemProperty7, standardSystemProperty6, standardSystemProperty5, standardSystemProperty4, standardSystemProperty3, standardSystemProperty2, standardSystemPropertyArray2, standardSystemProperty14, standardSystemPropertyArray3, standardSystemProperty15, standardSystemPropertyArray4, standardSystemProperty16, standardSystemPropertyArray5, standardSystemProperty17, standardSystemPropertyArray6, standardSystemProperty18, standardSystemPropertyArray7, standardSystemProperty19, standardSystemPropertyArray8, standardSystemProperty20, standardSystemPropertyArray9, standardSystemProperty};
        $VALUES = standardSystemPropertyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private StandardSystemProperty() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.key = var3_1;
    }

    public static StandardSystemProperty valueOf(String string2) {
        return Enum.valueOf(StandardSystemProperty.class, string2);
    }

    public static StandardSystemProperty[] values() {
        return (StandardSystemProperty[])$VALUES.clone();
    }

    public String key() {
        return this.key;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.key();
        stringBuilder.append(string2);
        stringBuilder.append("=");
        string2 = this.value();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public String value() {
        return System.getProperty(this.key);
    }
}

