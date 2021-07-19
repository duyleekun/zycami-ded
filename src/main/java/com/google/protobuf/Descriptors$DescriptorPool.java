/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool$DescriptorIntPair;
import com.google.protobuf.Descriptors$DescriptorPool$PackageDescriptor;
import com.google.protobuf.Descriptors$DescriptorPool$SearchFilter;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Descriptors$DescriptorPool {
    private boolean allowUnknownDependencies;
    private final Set dependencies;
    private final Map descriptorsByName;
    private final Map enumValuesByNumber;
    private final Map fieldsByNumber;

    public Descriptors$DescriptorPool(Descriptors$FileDescriptor[] object, boolean n10) {
        int n11;
        Object object2 = new HashMap();
        this.descriptorsByName = object2;
        object2 = new HashMap();
        this.fieldsByNumber = object2;
        object2 = new HashMap();
        this.enumValuesByNumber = object2;
        this.dependencies = object2;
        this.allowUnknownDependencies = n10;
        Object object3 = null;
        for (n10 = 0; n10 < (n11 = ((Descriptors$FileDescriptor[])object).length); ++n10) {
            object2 = this.dependencies;
            Descriptors$FileDescriptor descriptors$FileDescriptor = object[n10];
            object2.add(descriptors$FileDescriptor);
            object2 = object[n10];
            this.importPublicDependencies((Descriptors$FileDescriptor)object2);
        }
        object = this.dependencies.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object3 = (Descriptors$FileDescriptor)object.next();
            try {
                object2 = ((Descriptors$FileDescriptor)object3).getPackage();
            }
            catch (Descriptors$DescriptorValidationException descriptors$DescriptorValidationException) {
                object3 = new AssertionError((Object)descriptors$DescriptorValidationException);
                throw object3;
            }
            this.addPackage((String)object2, (Descriptors$FileDescriptor)object3);
        }
    }

    public static /* synthetic */ Map access$1600(Descriptors$DescriptorPool descriptors$DescriptorPool) {
        return descriptors$DescriptorPool.fieldsByNumber;
    }

    public static /* synthetic */ Map access$2500(Descriptors$DescriptorPool descriptors$DescriptorPool) {
        return descriptors$DescriptorPool.enumValuesByNumber;
    }

    private void importPublicDependencies(Descriptors$FileDescriptor object) {
        boolean bl2;
        object = ((Descriptors$FileDescriptor)object).getPublicDependencies().iterator();
        while (bl2 = object.hasNext()) {
            Set set = this.dependencies;
            Descriptors$FileDescriptor descriptors$FileDescriptor = (Descriptors$FileDescriptor)object.next();
            boolean bl3 = set.add(descriptors$FileDescriptor);
            if (!bl3) continue;
            this.importPublicDependencies(descriptors$FileDescriptor);
        }
    }

    public static void validateSymbolName(Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        Object object = descriptors$GenericDescriptor.getName();
        int n10 = ((String)object).length();
        if (n10 != 0) {
            int n11;
            Descriptors$DescriptorValidationException descriptors$DescriptorValidationException = null;
            for (n10 = 0; n10 < (n11 = ((String)object).length()); ++n10) {
                int n12 = 97;
                n11 = ((String)object).charAt(n10);
                if (n12 <= n11 && n11 <= (n12 = 122) || (n12 = 65) <= n11 && n11 <= (n12 = 90) || n11 == (n12 = 95) || (n12 = 48) <= n11 && n11 <= (n12 = 57) && n10 > 0) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('\"');
                stringBuilder.append((String)object);
                stringBuilder.append("\" is not a valid identifier.");
                object = stringBuilder.toString();
                descriptors$DescriptorValidationException = new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, (String)object, null);
                throw descriptors$DescriptorValidationException;
            }
            return;
        }
        object = new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, "Missing name.", null);
        throw object;
    }

    public void addEnumValueByNumber(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        Object object = descriptors$EnumValueDescriptor.getType();
        object = this.enumValuesByNumber;
        int n10 = descriptors$EnumValueDescriptor.getNumber();
        Descriptors$DescriptorPool$DescriptorIntPair descriptors$DescriptorPool$DescriptorIntPair = new Descriptors$DescriptorPool$DescriptorIntPair((Descriptors$GenericDescriptor)object, n10);
        if ((descriptors$EnumValueDescriptor = object.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$EnumValueDescriptor)) != null) {
            object = this.enumValuesByNumber;
            object.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$EnumValueDescriptor);
        }
    }

    public void addFieldByNumber(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        Object object = descriptors$FieldDescriptor.getContainingType();
        int n10 = descriptors$FieldDescriptor.getNumber();
        Object object2 = new Descriptors$DescriptorPool$DescriptorIntPair((Descriptors$GenericDescriptor)object, n10);
        if ((object = this.fieldsByNumber.put(object2, descriptors$FieldDescriptor)) == null) {
            return;
        }
        this.fieldsByNumber.put(object2, object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field number ");
        int n11 = descriptors$FieldDescriptor.getNumber();
        stringBuilder.append(n11);
        stringBuilder.append(" has already been used in \"");
        String string2 = descriptors$FieldDescriptor.getContainingType().getFullName();
        stringBuilder.append(string2);
        stringBuilder.append("\" by field \"");
        object = ((Descriptors$FieldDescriptor)object).getName();
        stringBuilder.append((String)object);
        stringBuilder.append("\".");
        object = stringBuilder.toString();
        object2 = new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)descriptors$FieldDescriptor, (String)object, null);
        throw object2;
    }

    public void addPackage(String object, Descriptors$FileDescriptor descriptors$FileDescriptor) {
        Object object2;
        String string2;
        int n10;
        int n11 = ((String)object).lastIndexOf(46);
        if (n11 == (n10 = -1)) {
            string2 = object;
        } else {
            n10 = 0;
            object2 = ((String)object).substring(0, n11);
            this.addPackage((String)object2, descriptors$FileDescriptor);
            string2 = ((String)object).substring(++n11);
        }
        object2 = this.descriptorsByName;
        Object object3 = new Descriptors$DescriptorPool$PackageDescriptor(string2, (String)object, descriptors$FileDescriptor);
        object2 = object2.put(object, object3);
        if (object2 != null) {
            object3 = this.descriptorsByName;
            object3.put(object, object2);
            boolean bl2 = object2 instanceof Descriptors$DescriptorPool$PackageDescriptor;
            if (!bl2) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append('\"');
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append("\" is already defined (as something other than a package) in file \"");
                string2 = ((Descriptors$GenericDescriptor)object2).getFile().getName();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append("\".");
                string2 = ((StringBuilder)object3).toString();
                object = new Descriptors$DescriptorValidationException(descriptors$FileDescriptor, string2, null);
                throw object;
            }
        }
    }

    public void addSymbol(Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        Descriptors$DescriptorPool.validateSymbolName(descriptors$GenericDescriptor);
        String string2 = descriptors$GenericDescriptor.getFullName();
        Object object = this.descriptorsByName.put(string2, descriptors$GenericDescriptor);
        if (object != null) {
            this.descriptorsByName.put(string2, object);
            Object object2 = descriptors$GenericDescriptor.getFile();
            Object object3 = ((Descriptors$GenericDescriptor)object).getFile();
            String string3 = "\".";
            int n10 = 34;
            if (object2 == object3) {
                int n11;
                int n12 = string2.lastIndexOf(46);
                if (n12 == (n11 = -1)) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((char)n10);
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append("\" is already defined.");
                    string2 = ((StringBuilder)object2).toString();
                    object = new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, string2, null);
                    throw object;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((char)n10);
                n10 = n12 + 1;
                String string4 = string2.substring(n10);
                ((StringBuilder)object3).append(string4);
                ((StringBuilder)object3).append("\" is already defined in \"");
                string2 = string2.substring(0, n12);
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(string3);
                string2 = ((StringBuilder)object3).toString();
                object2 = new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, string2, null);
                throw object2;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((char)n10);
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append("\" is already defined in file \"");
            string2 = ((Descriptors$GenericDescriptor)object).getFile().getName();
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(string3);
            string2 = ((StringBuilder)object3).toString();
            object2 = new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, string2, null);
            throw object2;
        }
    }

    public Descriptors$GenericDescriptor findSymbol(String string2) {
        Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter = Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS;
        return this.findSymbol(string2, descriptors$DescriptorPool$SearchFilter);
    }

    public Descriptors$GenericDescriptor findSymbol(String string2, Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter) {
        boolean bl2;
        Object object;
        Object object2 = (Descriptors$GenericDescriptor)this.descriptorsByName.get(string2);
        if (object2 != null && (descriptors$DescriptorPool$SearchFilter == (object = Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS) || descriptors$DescriptorPool$SearchFilter == (object = Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY) && (bl2 = this.isType((Descriptors$GenericDescriptor)object2)) || descriptors$DescriptorPool$SearchFilter == (object = Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY) && (bl2 = this.isAggregate((Descriptors$GenericDescriptor)object2)))) {
            return object2;
        }
        object2 = this.dependencies.iterator();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter2;
            object = (Descriptors$GenericDescriptor)Descriptors$FileDescriptor.access$1500((Descriptors$FileDescriptor)((Descriptors$FileDescriptor)object2.next())).descriptorsByName.get(string2);
            if (object == null || descriptors$DescriptorPool$SearchFilter != (descriptors$DescriptorPool$SearchFilter2 = Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS) && (descriptors$DescriptorPool$SearchFilter != (descriptors$DescriptorPool$SearchFilter2 = Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY) || !(bl3 = this.isType((Descriptors$GenericDescriptor)object))) && (descriptors$DescriptorPool$SearchFilter != (descriptors$DescriptorPool$SearchFilter2 = Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY) || !(bl3 = this.isAggregate((Descriptors$GenericDescriptor)object)))) continue;
            return object;
        }
        return null;
    }

    public boolean isAggregate(Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        boolean bl2;
        boolean bl3 = descriptors$GenericDescriptor instanceof Descriptors$Descriptor;
        if (!(bl3 || (bl3 = descriptors$GenericDescriptor instanceof Descriptors$EnumDescriptor) || (bl3 = descriptors$GenericDescriptor instanceof Descriptors$DescriptorPool$PackageDescriptor) || (bl2 = descriptors$GenericDescriptor instanceof Descriptors$ServiceDescriptor))) {
            bl2 = false;
            descriptors$GenericDescriptor = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isType(Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        boolean bl2;
        boolean bl3 = descriptors$GenericDescriptor instanceof Descriptors$Descriptor;
        if (!bl3 && !(bl2 = descriptors$GenericDescriptor instanceof Descriptors$EnumDescriptor)) {
            bl2 = false;
            descriptors$GenericDescriptor = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Descriptors$GenericDescriptor lookupSymbol(String var1_1, Descriptors$GenericDescriptor var2_2, Descriptors$DescriptorPool$SearchFilter var3_3) {
        block8: {
            var4_4 = ".";
            var5_5 = var1_1.startsWith((String)var4_4);
            if (var5_5 == 0) break block8;
            var6_6 = 1;
            var4_4 = var1_1.substring(var6_6);
            var7_7 /* !! */  = this.findSymbol((String)var4_4, (Descriptors$DescriptorPool$SearchFilter)var3_3);
            ** GOTO lbl37
        }
        var5_5 = var1_1.indexOf(46);
        var9_9 = var5_5 == (var8_8 = -1) ? var1_1 : var1_1.substring(0, var5_5);
        var11_11 = var2_2.getFullName();
        var10_10 = new StringBuilder(var11_11);
        while (true) {
            block11: {
                block10: {
                    block9: {
                        if ((var12_12 = var10_10.lastIndexOf((String)var4_4)) != var8_8) break block9;
                        var7_7 /* !! */  = this.findSymbol((String)var1_1, (Descriptors$DescriptorPool$SearchFilter)var3_3);
                        var4_4 = var1_1;
                        break block10;
                    }
                    var13_13 = var12_12 + 1;
                    var10_10.setLength(var13_13);
                    var10_10.append((String)var9_9);
                    var14_14 = var10_10.toString();
                    var15_15 = Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY;
                    var14_14 = this.findSymbol((String)var14_14, var15_15);
                    if (var14_14 == null) break block11;
                    if (var5_5 != var8_8) {
                        var10_10.setLength(var13_13);
                        var10_10.append((String)var1_1);
                        var4_4 = var10_10.toString();
                        var4_4 = this.findSymbol((String)var4_4, (Descriptors$DescriptorPool$SearchFilter)var3_3);
                        var7_7 /* !! */  = var4_4;
                    } else {
                        var7_7 /* !! */  = var14_14;
                    }
                    var4_4 = var10_10.toString();
                }
                if (var7_7 /* !! */  == null) {
                    var5_5 = (int)this.allowUnknownDependencies;
                    if (var5_5 != 0 && var3_3 == (var7_7 /* !! */  = Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY)) {
                        var2_2 = Descriptors.access$100();
                        var3_3 = new StringBuilder();
                        var3_3.append("The descriptor for message type \"");
                        var3_3.append((String)var1_1);
                        var3_3.append("\" can not be found and a placeholder is created for it");
                        var1_1 = var3_3.toString();
                        var2_2.warning((String)var1_1);
                        var1_1 = new Descriptors$Descriptor((String)var4_4);
                        var2_2 = this.dependencies;
                        var3_3 = var1_1.getFile();
                        var2_2.add(var3_3);
                        return var1_1;
                    }
                    var4_4 = new StringBuilder();
                    var4_4.append('\"');
                    var4_4.append((String)var1_1);
                    var4_4.append("\" is not defined.");
                    var1_1 = var4_4.toString();
                    var3_3 = new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)var2_2, (String)var1_1, null);
                    throw var3_3;
                }
                return var7_7 /* !! */ ;
            }
            var10_10.setLength(var12_12);
        }
    }
}

