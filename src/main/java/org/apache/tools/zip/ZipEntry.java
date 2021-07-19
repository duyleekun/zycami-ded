/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import java.util.NoSuchElementException;
import java.util.Vector;
import org.apache.tools.zip.ExtraFieldUtils;
import org.apache.tools.zip.ZipExtraField;
import org.apache.tools.zip.ZipShort;

public class ZipEntry
extends java.util.zip.ZipEntry
implements Cloneable {
    private static final int PLATFORM_FAT = 0;
    private static final int PLATFORM_UNIX = 3;
    private long externalAttributes;
    private Vector extraFields;
    private int internalAttributes = 0;
    private String name;
    private int platform = 0;

    public ZipEntry() {
        super("");
        this.externalAttributes = 0L;
        this.extraFields = null;
        this.name = null;
    }

    public ZipEntry(String string2) {
        super(string2);
        this.externalAttributes = 0L;
        this.extraFields = null;
        this.name = null;
    }

    public ZipEntry(java.util.zip.ZipEntry zipExtraFieldArray) {
        super((java.util.zip.ZipEntry)zipExtraFieldArray);
        long l10;
        this.externalAttributes = l10 = 0L;
        this.extraFields = null;
        this.name = null;
        zipExtraFieldArray = (ZipExtraField[])zipExtraFieldArray.getExtra();
        if (zipExtraFieldArray != null) {
            zipExtraFieldArray = ExtraFieldUtils.parse((byte[])zipExtraFieldArray);
            this.setExtraFields(zipExtraFieldArray);
        } else {
            this.setExtra();
        }
    }

    public ZipEntry(ZipEntry zipExtraFieldArray) {
        this((java.util.zip.ZipEntry)zipExtraFieldArray);
        int n10 = zipExtraFieldArray.getInternalAttributes();
        this.setInternalAttributes(n10);
        long l10 = zipExtraFieldArray.getExternalAttributes();
        this.setExternalAttributes(l10);
        zipExtraFieldArray = zipExtraFieldArray.getExtraFields();
        this.setExtraFields(zipExtraFieldArray);
    }

    public void addExtraField(ZipExtraField zipExtraField) {
        Vector vector = this.extraFields;
        if (vector == null) {
            vector = new Vector();
            this.extraFields = vector;
        }
        vector = zipExtraField.getHeaderId();
        Vector vector2 = this.extraFields;
        int n10 = vector2.size();
        boolean bl2 = false;
        Vector vector3 = null;
        for (int i10 = 0; !bl2 && i10 < n10; ++i10) {
            ZipShort zipShort = ((ZipExtraField)this.extraFields.elementAt(i10)).getHeaderId();
            boolean bl3 = zipShort.equals(vector);
            if (!bl3) continue;
            vector3 = this.extraFields;
            vector3.setElementAt(zipExtraField, i10);
            bl2 = true;
        }
        if (!bl2) {
            vector = this.extraFields;
            vector.addElement(zipExtraField);
        }
        this.setExtra();
    }

    public Object clone() {
        int n10;
        ZipEntry zipEntry = (ZipEntry)super.clone();
        ZipExtraField[] zipExtraFieldArray = this.extraFields;
        if (zipExtraFieldArray != null) {
            zipExtraFieldArray = (Vector)zipExtraFieldArray.clone();
        } else {
            n10 = 0;
            zipExtraFieldArray = null;
        }
        zipEntry.extraFields = zipExtraFieldArray;
        n10 = this.getInternalAttributes();
        zipEntry.setInternalAttributes(n10);
        long l10 = this.getExternalAttributes();
        zipEntry.setExternalAttributes(l10);
        zipExtraFieldArray = this.getExtraFields();
        zipEntry.setExtraFields(zipExtraFieldArray);
        return zipEntry;
    }

    public boolean equals(Object object) {
        boolean bl2;
        if (this == object) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public byte[] getCentralDirectoryExtra() {
        return ExtraFieldUtils.mergeCentralDirectoryData(this.getExtraFields());
    }

    public long getExternalAttributes() {
        return this.externalAttributes;
    }

    public ZipExtraField[] getExtraFields() {
        Object[] objectArray = this.extraFields;
        if (objectArray == null) {
            return new ZipExtraField[0];
        }
        objectArray = new ZipExtraField[objectArray.size()];
        this.extraFields.copyInto(objectArray);
        return objectArray;
    }

    public int getInternalAttributes() {
        return this.internalAttributes;
    }

    public byte[] getLocalFileDataExtra() {
        byte[] byArray = this.getExtra();
        if (byArray == null) {
            byArray = new byte[]{};
        }
        return byArray;
    }

    public String getName() {
        String string2 = this.name;
        if (string2 == null) {
            string2 = super.getName();
        }
        return string2;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getUnixMode() {
        return (int)(this.getExternalAttributes() >> 16 & (long)((char)-1));
    }

    public int hashCode() {
        return this.getName().hashCode();
    }

    public boolean isDirectory() {
        return this.getName().endsWith("/");
    }

    public void removeExtraField(ZipShort object) {
        Vector vector = this.extraFields;
        if (vector == null) {
            this.extraFields = vector = new Vector();
        }
        vector = this.extraFields;
        int n10 = vector.size();
        boolean bl2 = false;
        Vector vector2 = null;
        for (int i10 = 0; !bl2 && i10 < n10; ++i10) {
            ZipShort zipShort = ((ZipExtraField)this.extraFields.elementAt(i10)).getHeaderId();
            boolean bl3 = zipShort.equals(object);
            if (!bl3) continue;
            vector2 = this.extraFields;
            vector2.removeElementAt(i10);
            bl2 = true;
        }
        if (bl2) {
            this.setExtra();
            return;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public void setComprSize(long l10) {
        this.setCompressedSize(l10);
    }

    public void setExternalAttributes(long l10) {
        this.externalAttributes = l10;
    }

    public void setExtra() {
        byte[] byArray = ExtraFieldUtils.mergeLocalFileDataData(this.getExtraFields());
        super.setExtra(byArray);
    }

    public void setExtra(byte[] objectArray) {
        try {
            objectArray = ExtraFieldUtils.parse(objectArray);
        }
        catch (Exception exception) {
            String string2 = exception.getMessage();
            RuntimeException runtimeException = new RuntimeException(string2);
            throw runtimeException;
        }
        this.setExtraFields((ZipExtraField[])objectArray);
    }

    public void setExtraFields(ZipExtraField[] zipExtraFieldArray) {
        int n10;
        Vector vector;
        this.extraFields = vector = new Vector();
        vector = null;
        for (int i10 = 0; i10 < (n10 = zipExtraFieldArray.length); ++i10) {
            Vector vector2 = this.extraFields;
            ZipExtraField zipExtraField = zipExtraFieldArray[i10];
            vector2.addElement(zipExtraField);
        }
        this.setExtra();
    }

    public void setInternalAttributes(int n10) {
        this.internalAttributes = n10;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setPlatform(int n10) {
        this.platform = n10;
    }

    public void setUnixMode(int n10) {
        int n11 = n10 << 16;
        int n12 = 0;
        n10 = (n10 &= 0x80) == 0 ? 1 : 0;
        n10 |= n11;
        n11 = (int)(this.isDirectory() ? 1 : 0);
        if (n11 != 0) {
            n12 = 16;
        }
        long l10 = n10 | n12;
        this.setExternalAttributes(l10);
        this.platform = 3;
    }
}

