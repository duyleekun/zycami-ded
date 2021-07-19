/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipException;
import org.apache.tools.zip.UnrecognizedExtraField;
import org.apache.tools.zip.ZipExtraField;
import org.apache.tools.zip.ZipShort;

public class ExtraFieldUtils {
    public static /* synthetic */ Class class$org$apache$tools$zip$AsiExtraField;
    public static /* synthetic */ Class class$org$apache$tools$zip$JarMarker;
    private static Hashtable implementations;

    static {
        Serializable serializable;
        implementations = serializable = new Serializable();
        serializable = class$org$apache$tools$zip$AsiExtraField;
        if (serializable == null) {
            serializable = ExtraFieldUtils.class$("org.apache.tools.zip.AsiExtraField");
            class$org$apache$tools$zip$AsiExtraField = serializable;
        }
        ExtraFieldUtils.register(serializable);
        serializable = class$org$apache$tools$zip$JarMarker;
        if (serializable == null) {
            serializable = ExtraFieldUtils.class$("org.apache.tools.zip.JarMarker");
            class$org$apache$tools$zip$JarMarker = serializable;
        }
        ExtraFieldUtils.register(serializable);
    }

    public static /* synthetic */ Class class$(String string2) {
        try {
            return Class.forName(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            String string3 = classNotFoundException.getMessage();
            NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(string3);
            throw noClassDefFoundError;
        }
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) {
        Object object = (Class)implementations.get(zipShort);
        if (object != null) {
            return (ZipExtraField)((Class)object).newInstance();
        }
        object = new UnrecognizedExtraField();
        ((UnrecognizedExtraField)object).setHeaderId(zipShort);
        return object;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArray) {
        int n10;
        ZipShort zipShort;
        int n11;
        int n12;
        int n13 = zipExtraFieldArray.length * 4;
        for (n12 = 0; n12 < (n11 = zipExtraFieldArray.length); ++n12) {
            zipShort = zipExtraFieldArray[n12].getCentralDirectoryLength();
            n11 = zipShort.getValue();
            n13 += n11;
        }
        byte[] byArray = new byte[n13];
        n11 = 0;
        zipShort = null;
        for (n12 = 0; n12 < (n10 = zipExtraFieldArray.length); ++n12) {
            byte[] byArray2 = zipExtraFieldArray[n12].getHeaderId().getBytes();
            int n14 = 2;
            System.arraycopy(byArray2, 0, byArray, n11, n14);
            byArray2 = zipExtraFieldArray[n12].getCentralDirectoryLength().getBytes();
            int n15 = n11 + 2;
            System.arraycopy(byArray2, 0, byArray, n15, n14);
            byArray2 = zipExtraFieldArray[n12].getCentralDirectoryData();
            n14 = n11 + 4;
            n15 = byArray2.length;
            System.arraycopy(byArray2, 0, byArray, n14, n15);
            n10 = byArray2.length + 4;
            n11 += n10;
        }
        return byArray;
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArray) {
        int n10;
        ZipShort zipShort;
        int n11;
        int n12;
        int n13 = zipExtraFieldArray.length * 4;
        for (n12 = 0; n12 < (n11 = zipExtraFieldArray.length); ++n12) {
            zipShort = zipExtraFieldArray[n12].getLocalFileDataLength();
            n11 = zipShort.getValue();
            n13 += n11;
        }
        byte[] byArray = new byte[n13];
        n11 = 0;
        zipShort = null;
        for (n12 = 0; n12 < (n10 = zipExtraFieldArray.length); ++n12) {
            byte[] byArray2 = zipExtraFieldArray[n12].getHeaderId().getBytes();
            int n14 = 2;
            System.arraycopy(byArray2, 0, byArray, n11, n14);
            byArray2 = zipExtraFieldArray[n12].getLocalFileDataLength().getBytes();
            int n15 = n11 + 2;
            System.arraycopy(byArray2, 0, byArray, n15, n14);
            byArray2 = zipExtraFieldArray[n12].getLocalFileDataData();
            n14 = n11 + 4;
            n15 = byArray2.length;
            System.arraycopy(byArray2, 0, byArray, n14, n15);
            n10 = byArray2.length + 4;
            n11 += n10;
        }
        return byArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ZipExtraField[] parse(byte[] object) {
        String string2;
        String string3;
        Object object2 = new Vector();
        int n10 = 0;
        while (true) {
            int n11;
            int n12 = ((Object)object).length + -4;
            string3 = " is in unknown format";
            string2 = "data starting at ";
            if (n10 > n12) break;
            Object object3 = new ZipShort((byte[])object, n10);
            int n13 = n10 + 2;
            n13 = n10 + 4;
            ZipShort zipShort = new ZipShort((byte[])object, n13);
            int n14 = zipShort.getValue();
            int n15 = n13 + n14;
            if (n15 > (n11 = ((Object)object).length)) {
                object2 = new StringBuffer();
                ((StringBuffer)object2).append(string2);
                ((StringBuffer)object2).append(n10);
                ((StringBuffer)object2).append(string3);
                object2 = ((StringBuffer)object2).toString();
                object = new ZipException((String)object2);
                throw object;
            }
            try {
                object3 = ExtraFieldUtils.createExtraField((ZipShort)object3);
                object3.parseFromLocalFileData((byte[])object, n13, n14);
                ((Vector)object2).addElement(object3);
                n10 += (n14 += 4);
            }
            catch (IllegalAccessException illegalAccessException) {
                String string4 = illegalAccessException.getMessage();
                object2 = new ZipException(string4);
                throw object2;
            }
            catch (InstantiationException instantiationException) {
                String string5 = instantiationException.getMessage();
                object2 = new ZipException(string5);
                throw object2;
            }
        }
        int n16 = ((Object)object).length;
        if (n10 == n16) {
            object = new ZipExtraField[((Vector)object2).size()];
            ((Vector)object2).copyInto((Object[])object);
            return object;
        }
        object2 = new StringBuffer();
        ((StringBuffer)object2).append(string2);
        ((StringBuffer)object2).append(n10);
        ((StringBuffer)object2).append(string3);
        object2 = ((StringBuffer)object2).toString();
        object = new ZipException((String)object2);
        throw object;
    }

    public static void register(Class object) {
        Object object2 = ((Class)object).newInstance();
        object2 = (ZipExtraField)object2;
        Serializable serializable = implementations;
        object2 = object2.getHeaderId();
        try {
            ((Hashtable)serializable).put(object2, object);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            serializable = new StringBuffer();
            ((StringBuffer)serializable).append(object);
            ((StringBuffer)serializable).append("'s no-arg constructor is not public");
            object = ((StringBuffer)serializable).toString();
            object2 = new RuntimeException((String)object);
            throw object2;
        }
        catch (InstantiationException instantiationException) {
            serializable = new StringBuffer();
            ((StringBuffer)serializable).append(object);
            ((StringBuffer)serializable).append(" is not a concrete class");
            object = ((StringBuffer)serializable).toString();
            object2 = new RuntimeException((String)object);
            throw object2;
        }
        catch (ClassCastException classCastException) {
            serializable = new StringBuffer();
            ((StringBuffer)serializable).append(object);
            ((StringBuffer)serializable).append(" doesn't implement ZipExtraField");
            object = ((StringBuffer)serializable).toString();
            object2 = new RuntimeException((String)object);
            throw object2;
        }
    }
}

