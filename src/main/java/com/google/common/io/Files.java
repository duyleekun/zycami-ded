/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.TreeTraverser;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files$1;
import com.google.common.io.Files$2;
import com.google.common.io.Files$3;
import com.google.common.io.Files$FileByteSink;
import com.google.common.io.Files$FileByteSource;
import com.google.common.io.Files$FilePredicate;
import com.google.common.io.LineProcessor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Files {
    private static final SuccessorsFunction FILE_TREE;
    private static final TreeTraverser FILE_TREE_TRAVERSER;
    private static final int TEMP_DIR_ATTEMPTS = 10000;

    static {
        Object object = new Files$2();
        FILE_TREE_TRAVERSER = object;
        FILE_TREE = object = new Files$3();
    }

    private Files() {
    }

    public static /* synthetic */ Iterable access$200(File file) {
        return Files.fileTreeChildren(file);
    }

    public static void append(CharSequence charSequence, File file, Charset charset) {
        FileWriteMode fileWriteMode = FileWriteMode.APPEND;
        FileWriteMode[] fileWriteModeArray = new FileWriteMode[]{fileWriteMode};
        Files.asCharSink(file, charset, fileWriteModeArray).write(charSequence);
    }

    public static ByteSink asByteSink(File file, FileWriteMode ... fileWriteModeArray) {
        Files$FileByteSink files$FileByteSink = new Files$FileByteSink(file, fileWriteModeArray, null);
        return files$FileByteSink;
    }

    public static ByteSource asByteSource(File file) {
        Files$FileByteSource files$FileByteSource = new Files$FileByteSource(file, null);
        return files$FileByteSource;
    }

    public static CharSink asCharSink(File file, Charset charset, FileWriteMode ... fileWriteModeArray) {
        return Files.asByteSink(file, fileWriteModeArray).asCharSink(charset);
    }

    public static CharSource asCharSource(File file, Charset charset) {
        return Files.asByteSource(file).asCharSource(charset);
    }

    public static void copy(File object, File object2) {
        Preconditions.checkArgument(((File)object).equals(object2) ^ true, "Source %s and destination %s must be different", object, object2);
        object = Files.asByteSource((File)object);
        FileWriteMode[] fileWriteModeArray = new FileWriteMode[]{};
        object2 = Files.asByteSink((File)object2, fileWriteModeArray);
        ((ByteSource)object).copyTo((ByteSink)object2);
    }

    public static void copy(File file, OutputStream outputStream) {
        Files.asByteSource(file).copyTo(outputStream);
    }

    public static void copy(File file, Charset charset, Appendable appendable) {
        Files.asCharSource(file, charset).copyTo(appendable);
    }

    public static void createParentDirs(File object) {
        Preconditions.checkNotNull(object);
        Serializable serializable = ((File)object).getCanonicalFile().getParentFile();
        if (serializable == null) {
            return;
        }
        serializable.mkdirs();
        boolean bl2 = serializable.isDirectory();
        if (bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to create parent directories of ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        serializable = new IOException((String)object);
        throw serializable;
    }

    public static File createTempDir() {
        int n10;
        CharSequence charSequence = System.getProperty("java.io.tmpdir");
        Serializable serializable = new File((String)charSequence);
        charSequence = new StringBuilder();
        long l10 = System.currentTimeMillis();
        ((StringBuilder)charSequence).append(l10);
        ((StringBuilder)charSequence).append("-");
        charSequence = ((StringBuilder)charSequence).toString();
        StringBuilder stringBuilder = null;
        for (int i10 = 0; i10 < (n10 = 10000); ++i10) {
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append((String)charSequence);
            charSequence2.append(i10);
            charSequence2 = charSequence2.toString();
            File file = new File((File)serializable, (String)charSequence2);
            boolean bl2 = file.mkdir();
            if (!bl2) continue;
            return file;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to create directory within 10000 attempts (tried ");
        stringBuilder.append((String)charSequence);
        stringBuilder.append("0 to ");
        stringBuilder.append((String)charSequence);
        stringBuilder.append(9999);
        stringBuilder.append(')');
        charSequence = stringBuilder.toString();
        serializable = new IllegalStateException((String)charSequence);
        throw serializable;
    }

    public static boolean equal(File object, File object2) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        if (object != object2 && !(bl2 = ((File)object).equals(object2))) {
            long l10;
            long l11 = ((File)object).length();
            long l12 = ((File)object2).length();
            long l13 = 0L;
            long l14 = l11 - l13;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 != false && (l10 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1)) != false && (bl2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1))) {
                return false;
            }
            object = Files.asByteSource((File)object);
            object2 = Files.asByteSource((File)object2);
            return ((ByteSource)object).contentEquals((ByteSource)object2);
        }
        return true;
    }

    public static Traverser fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    private static Iterable fileTreeChildren(File fileArray) {
        boolean bl2 = fileArray.isDirectory();
        if (bl2 && (fileArray = fileArray.listFiles()) != null) {
            return Collections.unmodifiableList(Arrays.asList(fileArray));
        }
        return Collections.emptyList();
    }

    public static TreeTraverser fileTreeTraverser() {
        return FILE_TREE_TRAVERSER;
    }

    public static String getFileExtension(String string2) {
        Preconditions.checkNotNull(string2);
        File file = new File(string2);
        string2 = file.getName();
        int n10 = string2.lastIndexOf(46);
        int n11 = -1;
        string2 = n10 == n11 ? "" : string2.substring(++n10);
        return string2;
    }

    public static String getNameWithoutExtension(String string2) {
        Preconditions.checkNotNull(string2);
        File file = new File(string2);
        string2 = file.getName();
        int n10 = string2.lastIndexOf(46);
        int n11 = -1;
        if (n10 != n11) {
            n11 = 0;
            string2 = string2.substring(0, n10);
        }
        return string2;
    }

    public static HashCode hash(File file, HashFunction hashFunction) {
        return Files.asByteSource(file).hash(hashFunction);
    }

    public static Predicate isDirectory() {
        return Files$FilePredicate.IS_DIRECTORY;
    }

    public static Predicate isFile() {
        return Files$FilePredicate.IS_FILE;
    }

    public static MappedByteBuffer map(File file) {
        Preconditions.checkNotNull(file);
        FileChannel.MapMode mapMode = FileChannel.MapMode.READ_ONLY;
        return Files.map(file, mapMode);
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode) {
        return Files.mapInternal(file, mapMode, -1);
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode, long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "size (%s) may not be negative", l10);
        return Files.mapInternal(file, mapMode, l10);
    }

    private static MappedByteBuffer mapInternal(File object, FileChannel.MapMode mapMode, long l10) {
        Object object2;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(mapMode);
        Closer closer = Closer.create();
        try {
            object2 = FileChannel.MapMode.READ_ONLY;
            object2 = mapMode == object2 ? "r" : "rw";
        }
        catch (Throwable throwable) {
            RuntimeException runtimeException;
            try {
                runtimeException = closer.rethrow(throwable);
            }
            catch (Throwable throwable2) {
                closer.close();
                throw throwable2;
            }
            throw runtimeException;
        }
        Object object3 = new RandomAccessFile((File)object, (String)object2);
        object = closer.register((Closeable)object3);
        object = (RandomAccessFile)object;
        object = ((RandomAccessFile)object).getChannel();
        object3 = object = closer.register((Closeable)object);
        object3 = (FileChannel)object;
        long l11 = 0L;
        long l12 = -1;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (l13 == false) {
            l10 = ((FileChannel)object3).size();
        }
        l12 = l10;
        object2 = mapMode;
        object = ((FileChannel)object3).map(mapMode, l11, l10);
        closer.close();
        return object;
    }

    public static void move(File object, File object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        boolean bl2 = ((File)object).equals(object2) ^ true;
        String string2 = "Source %s and destination %s must be different";
        Preconditions.checkArgument(bl2, string2, object, object2);
        bl2 = ((File)object).renameTo((File)object2);
        if (!bl2) {
            Files.copy((File)object, (File)object2);
            bl2 = ((File)object).delete();
            if (!bl2) {
                bl2 = ((File)object2).delete();
                string2 = "Unable to delete ";
                if (!bl2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(object2);
                    object2 = stringBuilder.toString();
                    object = new IOException((String)object2);
                    throw object;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(object);
                object = stringBuilder.toString();
                object2 = new IOException((String)object);
                throw object2;
            }
        }
    }

    public static BufferedReader newReader(File file, Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)fileInputStream, charset);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader;
    }

    public static BufferedWriter newWriter(File file, Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)fileOutputStream, charset);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        return bufferedWriter;
    }

    public static Object readBytes(File file, ByteProcessor byteProcessor) {
        return Files.asByteSource(file).read(byteProcessor);
    }

    public static String readFirstLine(File file, Charset charset) {
        return Files.asCharSource(file, charset).readFirstLine();
    }

    public static Object readLines(File file, Charset charset, LineProcessor lineProcessor) {
        return Files.asCharSource(file, charset).readLines(lineProcessor);
    }

    public static List readLines(File object, Charset object2) {
        object = Files.asCharSource((File)object, (Charset)object2);
        object2 = new Files$1();
        return (List)((CharSource)object).readLines((LineProcessor)object2);
    }

    public static String simplifyPath(String charSequence) {
        int n10;
        Preconditions.checkNotNull(charSequence);
        int c10 = ((String)charSequence).length();
        Object object = ".";
        if (c10 == 0) {
            return object;
        }
        int n11 = 47;
        Object object2 = Splitter.on((char)n11).omitEmptyStrings().split(charSequence);
        Object object3 = new ArrayList();
        object2 = object2.iterator();
        while ((n10 = object2.hasNext()) != 0) {
            String string2 = (String)object2.next();
            string2.hashCode();
            boolean bl2 = string2.equals(object);
            if (bl2) continue;
            String string3 = "..";
            boolean bl3 = string2.equals(string3);
            if (!bl3) {
                object3.add(string2);
                continue;
            }
            n10 = object3.size();
            if (n10 > 0) {
                n10 = object3.size() + -1;
                string2 = (String)object3.get(n10);
                if ((n10 = (int)(string2.equals(string3) ? 1 : 0)) == 0) {
                    n10 = object3.size() + -1;
                    object3.remove(n10);
                    continue;
                }
            }
            object3.add(string3);
        }
        object2 = Joiner.on((char)n11).join((Iterable)object3);
        int n12 = ((String)charSequence).charAt(0);
        object3 = "/";
        if (n12 == n11) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object3);
            ((StringBuilder)charSequence).append((String)object2);
            object2 = ((StringBuilder)charSequence).toString();
        }
        while ((n12 = (int)(((String)object2).startsWith((String)(charSequence = "/../")) ? 1 : 0)) != 0) {
            n12 = 3;
            object2 = ((String)object2).substring(n12);
        }
        charSequence = "/..";
        n12 = (int)(((String)object2).equals(charSequence) ? 1 : 0);
        if (n12 != 0) {
            object = object3;
        } else {
            charSequence = "";
            n12 = (int)(((String)charSequence).equals(object2) ? 1 : 0);
            if (n12 == 0) {
                object = object2;
            }
        }
        return object;
    }

    public static byte[] toByteArray(File file) {
        return Files.asByteSource(file).read();
    }

    public static String toString(File file, Charset charset) {
        return Files.asCharSource(file, charset).read();
    }

    public static void touch(File object) {
        long l10;
        Preconditions.checkNotNull(object);
        boolean bl2 = ((File)object).createNewFile();
        if (!bl2 && !(bl2 = ((File)object).setLastModified(l10 = System.currentTimeMillis()))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to update modification time of ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            IOException iOException = new IOException((String)object);
            throw iOException;
        }
    }

    public static void write(CharSequence charSequence, File file, Charset charset) {
        FileWriteMode[] fileWriteModeArray = new FileWriteMode[]{};
        Files.asCharSink(file, charset, fileWriteModeArray).write(charSequence);
    }

    public static void write(byte[] byArray, File file) {
        FileWriteMode[] fileWriteModeArray = new FileWriteMode[]{};
        Files.asByteSink(file, fileWriteModeArray).write(byArray);
    }
}

