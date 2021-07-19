/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$Lambda$1;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$Lambda$2;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$Lambda$3;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$Lambda$4;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$Lambda$5;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$Lambda$6;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class CrashlyticsReportPersistence {
    private static final String EVENT_COUNTER_FORMAT = "%010d";
    private static final int EVENT_COUNTER_WIDTH = 10;
    private static final FilenameFilter EVENT_FILE_FILTER;
    private static final String EVENT_FILE_NAME_PREFIX = "event";
    private static final int EVENT_NAME_LENGTH = 0;
    private static final Comparator LATEST_SESSION_ID_FIRST_COMPARATOR;
    private static final int MAX_OPEN_SESSIONS = 8;
    private static final String NATIVE_REPORTS_DIRECTORY = "native-reports";
    private static final String NORMAL_EVENT_SUFFIX = "";
    private static final String OPEN_SESSIONS_DIRECTORY_NAME = "sessions";
    private static final String PRIORITY_EVENT_SUFFIX = "_";
    private static final String PRIORITY_REPORTS_DIRECTORY = "priority-reports";
    private static final String REPORTS_DIRECTORY = "reports";
    private static final String REPORT_FILE_NAME = "report";
    private static final CrashlyticsReportJsonTransform TRANSFORM;
    private static final String USER_FILE_NAME = "user";
    private static final Charset UTF_8;
    private static final String WORKING_DIRECTORY_NAME = "report-persistence";
    private final AtomicInteger eventCounter;
    private final File nativeReportsDirectory;
    private final File openSessionsDirectory;
    private final File priorityReportsDirectory;
    private final File reportsDirectory;
    private final SettingsDataProvider settingsDataProvider;

    static {
        CrashlyticsReportJsonTransform crashlyticsReportJsonTransform;
        UTF_8 = Charset.forName("UTF-8");
        EVENT_NAME_LENGTH = 15;
        TRANSFORM = crashlyticsReportJsonTransform = new CrashlyticsReportJsonTransform();
        LATEST_SESSION_ID_FIRST_COMPARATOR = CrashlyticsReportPersistence$$Lambda$5.lambdaFactory$();
        EVENT_FILE_FILTER = CrashlyticsReportPersistence$$Lambda$6.lambdaFactory$();
    }

    public CrashlyticsReportPersistence(File file, SettingsDataProvider settingsDataProvider) {
        Serializable serializable;
        this.eventCounter = serializable = new AtomicInteger(0);
        super(file, WORKING_DIRECTORY_NAME);
        this.openSessionsDirectory = file = new File((File)serializable, OPEN_SESSIONS_DIRECTORY_NAME);
        this.priorityReportsDirectory = file = new File((File)serializable, PRIORITY_REPORTS_DIRECTORY);
        this.reportsDirectory = file = new File((File)serializable, REPORTS_DIRECTORY);
        this.nativeReportsDirectory = file = new File((File)serializable, NATIVE_REPORTS_DIRECTORY);
        this.settingsDataProvider = settingsDataProvider;
    }

    public static /* synthetic */ boolean access$lambda$0(File file, String string2) {
        return CrashlyticsReportPersistence.isNormalPriorityEventFile(file, string2);
    }

    public static /* synthetic */ int access$lambda$1(File file, File file2) {
        return CrashlyticsReportPersistence.oldestEventFileFirst(file, file2);
    }

    private List capAndGetOpenSessions(String object) {
        boolean bl2;
        object = CrashlyticsReportPersistence$$Lambda$2.lambdaFactory$((String)object);
        object = CrashlyticsReportPersistence.getFilesInDirectory(this.openSessionsDirectory, (FileFilter)object);
        Object object2 = LATEST_SESSION_ID_FIRST_COMPARATOR;
        Collections.sort(object, object2);
        int n10 = object.size();
        int n11 = 8;
        if (n10 <= n11) {
            return object;
        }
        n10 = object.size();
        object2 = object.subList(n11, n10).iterator();
        while (bl2 = object2.hasNext()) {
            File file = (File)object2.next();
            CrashlyticsReportPersistence.recursiveDelete(file);
        }
        return object.subList(0, n11);
    }

    private static int capFilesCount(List object, int n10) {
        boolean bl2;
        int n11 = object.size();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            File file = (File)object.next();
            if (n11 <= n10) {
                return n11;
            }
            CrashlyticsReportPersistence.recursiveDelete(file);
            n11 += -1;
        }
        return n11;
    }

    private void capFinalizedReports() {
        boolean bl2;
        Object object = this.settingsDataProvider.getSettings().getSessionData();
        int n10 = ((SessionSettingsData)object).maxCompleteSessionsCount;
        Object object2 = this.getAllFinalizedReportFiles();
        int n11 = object2.size();
        if (n11 <= n10) {
            return;
        }
        object = object2.subList(n10, n11).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (File)object.next();
            ((File)object2).delete();
        }
    }

    private static List combineReportFiles(List ... listArray) {
        ArrayList arrayList = new ArrayList();
        int n10 = listArray.length;
        int n11 = 0;
        List list = null;
        int n12 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            List list2 = listArray[i10];
            int n13 = list2.size();
            n12 += n13;
        }
        arrayList.ensureCapacity(n12);
        n10 = listArray.length;
        while (n11 < n10) {
            list = listArray[n11];
            arrayList.addAll(list);
            ++n11;
        }
        return arrayList;
    }

    private static String generateEventFilename(int n10, boolean bl2) {
        Object object;
        Serializable serializable = Locale.US;
        int n11 = 1;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object = Integer.valueOf(n10);
        object = String.format((Locale)serializable, EVENT_COUNTER_FORMAT, objectArray);
        String string2 = bl2 ? PRIORITY_EVENT_SUFFIX : NORMAL_EVENT_SUFFIX;
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(EVENT_FILE_NAME_PREFIX);
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append(string2);
        return ((StringBuilder)serializable).toString();
    }

    private static List getAllFilesInDirectory(File file) {
        return CrashlyticsReportPersistence.getFilesInDirectory(file, null);
    }

    private List getAllFinalizedReportFiles() {
        List list;
        int n10 = 2;
        List[] listArray = new List[n10];
        Object object = new List[n10];
        object[0] = list = CrashlyticsReportPersistence.getAllFilesInDirectory(this.priorityReportsDirectory);
        list = CrashlyticsReportPersistence.getAllFilesInDirectory(this.nativeReportsDirectory);
        int n11 = 1;
        object[n11] = list;
        listArray[0] = object = CrashlyticsReportPersistence.combineReportFiles(object);
        listArray[n11] = object = CrashlyticsReportPersistence.getAllFilesInDirectory(this.reportsDirectory);
        return CrashlyticsReportPersistence.sortAndCombineReportFiles(listArray);
    }

    private static String getEventNameWithoutPriority(String string2) {
        int n10 = EVENT_NAME_LENGTH;
        return string2.substring(0, n10);
    }

    private static List getFilesInDirectory(File object, FileFilter fileFilter) {
        boolean bl2 = object.isDirectory();
        if (!bl2) {
            return Collections.emptyList();
        }
        object = fileFilter == null ? object.listFiles() : object.listFiles(fileFilter);
        object = object != null ? Arrays.asList(object) : Collections.emptyList();
        return object;
    }

    private static List getFilesInDirectory(File object, FilenameFilter filenameFilter) {
        boolean bl2 = object.isDirectory();
        if (!bl2) {
            return Collections.emptyList();
        }
        object = filenameFilter == null ? object.listFiles() : object.listFiles(filenameFilter);
        object = object != null ? Arrays.asList(object) : Collections.emptyList();
        return object;
    }

    private File getSessionDirectoryById(String string2) {
        File file = this.openSessionsDirectory;
        File file2 = new File(file, string2);
        return file2;
    }

    private static boolean isHighPriorityEventFile(String string2) {
        boolean bl2;
        String string3 = EVENT_FILE_NAME_PREFIX;
        boolean bl3 = string2.startsWith(string3);
        if (bl3 && (bl2 = string2.endsWith(string3 = PRIORITY_EVENT_SUFFIX))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private static boolean isNormalPriorityEventFile(File object, String string2) {
        object = EVENT_FILE_NAME_PREFIX;
        boolean bl2 = string2.startsWith((String)object);
        if (bl2 && !(bl2 = string2.endsWith((String)(object = PRIORITY_EVENT_SUFFIX)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ boolean lambda$capAndGetOpenSessions$3(String string2, File object) {
        boolean bl2;
        boolean bl3 = ((File)object).isDirectory();
        if (bl3 && !(bl2 = ((String)(object = ((File)object).getName())).equals(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static /* synthetic */ boolean lambda$deleteFinalizedReport$2(String string2, File file, String string3) {
        return string3.startsWith(string2);
    }

    public static /* synthetic */ int lambda$static$0(File object, File object2) {
        object2 = ((File)object2).getName();
        object = ((File)object).getName();
        return ((String)object2).compareTo((String)object);
    }

    public static /* synthetic */ boolean lambda$static$1(File file, String string2) {
        return string2.startsWith(EVENT_FILE_NAME_PREFIX);
    }

    private static boolean makeDirectory(File file) {
        boolean bl2;
        boolean bl3 = file.exists();
        if (!bl3 && !(bl2 = file.mkdirs())) {
            bl2 = false;
            file = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static int oldestEventFileFirst(File object, File object2) {
        object = CrashlyticsReportPersistence.getEventNameWithoutPriority(((File)object).getName());
        object2 = CrashlyticsReportPersistence.getEventNameWithoutPriority(((File)object2).getName());
        return ((String)object).compareTo((String)object2);
    }

    private static File prepareDirectory(File object) {
        boolean bl2 = CrashlyticsReportPersistence.makeDirectory((File)object);
        if (bl2) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not create directory ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IOException iOException = new IOException((String)object);
        throw iOException;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String readTextFile(File object) {
        int n10 = 8192;
        byte[] byArray = new byte[n10];
        Object object2 = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream((File)object);
        while (true) {
            int n11 = fileInputStream.read(byArray);
            if (n11 <= 0) break;
            ((ByteArrayOutputStream)object2).write(byArray, 0, n11);
            continue;
            break;
        }
        try {
            byArray = ((ByteArrayOutputStream)object2).toByteArray();
        }
        catch (Throwable throwable) {
            try {
                fileInputStream.close();
            }
            catch (Throwable throwable2) {
                throw throwable;
            }
            throw throwable;
        }
        object2 = UTF_8;
        object = new String(byArray, (Charset)object2);
        fileInputStream.close();
        return object;
    }

    private static void recursiveDelete(File file) {
        if (file == null) {
            return;
        }
        boolean bl2 = file.isDirectory();
        if (bl2) {
            for (File file2 : file.listFiles()) {
                CrashlyticsReportPersistence.recursiveDelete(file2);
            }
        }
        file.delete();
    }

    private static List sortAndCombineReportFiles(List ... listArray) {
        int n10 = listArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            List list = listArray[i10];
            Comparator comparator = LATEST_SESSION_ID_FIRST_COMPARATOR;
            Collections.sort(list, comparator);
        }
        return CrashlyticsReportPersistence.combineReportFiles(listArray);
    }

    private static void synthesizeNativeReportFile(File object, File object2, CrashlyticsReport$FilesPayload object3, String charSequence) {
        Object object4 = TRANSFORM;
        Object object5 = CrashlyticsReportPersistence.readTextFile((File)object);
        object5 = ((CrashlyticsReportJsonTransform)object4).reportFromJson((String)object5);
        object3 = ((CrashlyticsReport)object5).withNdkPayload((CrashlyticsReport$FilesPayload)object3);
        object2 = CrashlyticsReportPersistence.prepareDirectory((File)object2);
        object5 = new File((File)object2, (String)charSequence);
        object2 = ((CrashlyticsReportJsonTransform)object4).reportToJson((CrashlyticsReport)object3);
        try {
            CrashlyticsReportPersistence.writeTextFile((File)object5, (String)object2);
        }
        catch (IOException iOException) {
            object3 = Logger.getLogger();
            charSequence = new StringBuilder();
            object4 = "Could not synthesize final native report file for ";
            ((StringBuilder)charSequence).append((String)object4);
            ((StringBuilder)charSequence).append(object);
            object = ((StringBuilder)charSequence).toString();
            ((Logger)object3).w((String)object, iOException);
        }
    }

    private void synthesizeReport(File object, long l10) {
        Object object2;
        Object object3;
        Object object4;
        boolean bl2;
        boolean bl3;
        Object object5 = EVENT_FILE_FILTER;
        boolean bl4 = (object5 = CrashlyticsReportPersistence.getFilesInDirectory((File)object, (FilenameFilter)object5)).isEmpty();
        if (bl4) {
            Logger logger = Logger.getLogger();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Session ");
            object = ((File)object).getName();
            stringBuilder.append((String)object);
            stringBuilder.append(" has no events.");
            object = stringBuilder.toString();
            logger.v((String)object);
            return;
        }
        Collections.sort(object5);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object5 = object5.iterator();
        bl4 = false;
        Object object6 = null;
        block9: while (true) {
            bl3 = false;
            while (bl2 = object5.hasNext()) {
                block14: {
                    object4 = (File)object5.next();
                    try {
                        object3 = TRANSFORM;
                    }
                    catch (IOException iOException) {
                        object2 = Logger.getLogger();
                        StringBuilder stringBuilder = new StringBuilder();
                        String string2 = "Could not add event to report for ";
                        stringBuilder.append(string2);
                        stringBuilder.append(object4);
                        object4 = stringBuilder.toString();
                        ((Logger)object2).w((String)object4, iOException);
                        continue;
                    }
                    object2 = CrashlyticsReportPersistence.readTextFile((File)object4);
                    object3 = ((CrashlyticsReportJsonTransform)object3).eventFromJson((String)object2);
                    arrayList.add(object3);
                    if (bl3) break block14;
                    object3 = ((File)object4).getName();
                    bl2 = CrashlyticsReportPersistence.isHighPriorityEventFile((String)object3);
                    if (!bl2) continue block9;
                }
                bl3 = bl2 = true;
            }
            break;
        }
        boolean bl5 = arrayList.isEmpty();
        if (bl5) {
            Logger logger = Logger.getLogger();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not parse event files for session ");
            object = ((File)object).getName();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            logger.w((String)object);
            return;
        }
        bl5 = false;
        object5 = null;
        object4 = USER_FILE_NAME;
        object6 = new File((File)object, (String)object4);
        bl2 = ((File)object6).isFile();
        if (bl2) {
            try {
                object5 = CrashlyticsReportPersistence.readTextFile((File)object6);
            }
            catch (IOException iOException) {
                object4 = Logger.getLogger();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Could not read user ID file in ");
                object2 = ((File)object).getName();
                ((StringBuilder)object3).append((String)object2);
                object3 = ((StringBuilder)object3).toString();
                ((Logger)object4).w((String)object3, iOException);
            }
        }
        object2 = object5;
        object6 = REPORT_FILE_NAME;
        object5 = new File((File)object, (String)object6);
        object = bl3 ? this.priorityReportsDirectory : this.reportsDirectory;
        object6 = object;
        CrashlyticsReportPersistence.synthesizeReportFile((File)object5, (File)object, arrayList, l10, bl3, (String)object2);
    }

    private static void synthesizeReportFile(File object, File object2, List object3, long l10, boolean bl2, String string2) {
        Object object4;
        CrashlyticsReportJsonTransform crashlyticsReportJsonTransform;
        block14: {
            crashlyticsReportJsonTransform = TRANSFORM;
            Object object5 = CrashlyticsReportPersistence.readTextFile((File)object);
            object5 = crashlyticsReportJsonTransform.reportFromJson((String)object5);
            object4 = ((CrashlyticsReport)object5).withSessionEndFields(l10, bl2, string2);
            object3 = ImmutableList.from((List)object3);
            object3 = ((CrashlyticsReport)object4).withEvents((ImmutableList)object3);
            object4 = ((CrashlyticsReport)object3).getSession();
            if (object4 != null) break block14;
            return;
        }
        object2 = CrashlyticsReportPersistence.prepareDirectory((File)object2);
        object4 = ((CrashlyticsReport$Session)object4).getIdentifier();
        Object object6 = new File((File)object2, (String)object4);
        object2 = crashlyticsReportJsonTransform.reportToJson((CrashlyticsReport)object3);
        try {
            CrashlyticsReportPersistence.writeTextFile((File)object6, (String)object2);
        }
        catch (IOException iOException) {
            object3 = Logger.getLogger();
            object4 = new StringBuilder();
            object6 = "Could not synthesize final report file for ";
            ((StringBuilder)object4).append((String)object6);
            ((StringBuilder)object4).append(object);
            object = ((StringBuilder)object4).toString();
            ((Logger)object3).w((String)object, iOException);
        }
    }

    private static int trimEvents(File object, int n10) {
        Object object2 = CrashlyticsReportPersistence$$Lambda$3.lambdaFactory$();
        object = CrashlyticsReportPersistence.getFilesInDirectory((File)object, (FilenameFilter)object2);
        object2 = CrashlyticsReportPersistence$$Lambda$4.lambdaFactory$();
        Collections.sort(object, object2);
        return CrashlyticsReportPersistence.capFilesCount((List)object, n10);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void writeTextFile(File comparable, String string2) {
        FileOutputStream fileOutputStream = new FileOutputStream((File)comparable);
        Charset charset = UTF_8;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)fileOutputStream, charset);
        try {
            void var1_3;
            outputStreamWriter.write((String)var1_3);
        }
        catch (Throwable throwable) {
            try {
                outputStreamWriter.close();
            }
            catch (Throwable throwable2) {
                throw throwable;
            }
            throw throwable;
        }
        outputStreamWriter.close();
    }

    public void deleteAllReports() {
        boolean bl2;
        Iterator iterator2 = this.getAllFinalizedReportFiles().iterator();
        while (bl2 = iterator2.hasNext()) {
            File file = (File)iterator2.next();
            file.delete();
        }
    }

    public void deleteFinalizedReport(String iterator2) {
        iterator2 = CrashlyticsReportPersistence$$Lambda$1.lambdaFactory$((String)((Object)iterator2));
        int n10 = 3;
        Object object = new List[n10];
        Object object2 = CrashlyticsReportPersistence.getFilesInDirectory(this.priorityReportsDirectory, (FilenameFilter)((Object)iterator2));
        object[0] = object2;
        object2 = CrashlyticsReportPersistence.getFilesInDirectory(this.nativeReportsDirectory, (FilenameFilter)((Object)iterator2));
        int n11 = 1;
        object[n11] = object2;
        object2 = this.reportsDirectory;
        iterator2 = CrashlyticsReportPersistence.getFilesInDirectory((File)object2, (FilenameFilter)((Object)iterator2));
        int n12 = 2;
        object[n12] = iterator2;
        iterator2 = CrashlyticsReportPersistence.combineReportFiles((List[])object).iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (File)iterator2.next();
            ((File)object).delete();
        }
    }

    public void finalizeReports(String object, long l10) {
        boolean bl2;
        object = this.capAndGetOpenSessions((String)object).iterator();
        while (bl2 = object.hasNext()) {
            File file = (File)object.next();
            Logger logger = Logger.getLogger();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Finalizing report for session ");
            String string2 = file.getName();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            logger.v((String)charSequence);
            this.synthesizeReport(file, l10);
            CrashlyticsReportPersistence.recursiveDelete(file);
        }
        this.capFinalizedReports();
    }

    public void finalizeSessionWithNativeEvent(String string2, CrashlyticsReport$FilesPayload crashlyticsReport$FilesPayload) {
        File file = this.getSessionDirectoryById(string2);
        File file2 = new File(file, REPORT_FILE_NAME);
        file = this.nativeReportsDirectory;
        CrashlyticsReportPersistence.synthesizeNativeReportFile(file2, file, crashlyticsReport$FilesPayload, string2);
    }

    public boolean hasFinalizedReports() {
        return this.getAllFinalizedReportFiles().isEmpty() ^ true;
    }

    public List listSortedOpenSessionIds() {
        boolean bl2;
        Object object = CrashlyticsReportPersistence.getAllFilesInDirectory(this.openSessionsDirectory);
        ArrayList<String> arrayList = LATEST_SESSION_ID_FIRST_COMPARATOR;
        Collections.sort(object, arrayList);
        arrayList = new ArrayList<String>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2 = ((File)object.next()).getName();
            arrayList.add(string2);
        }
        return arrayList;
    }

    public List loadFinalizedReports() {
        boolean bl2;
        Object object = this.getAllFinalizedReportFiles();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = object.size();
        arrayList.ensureCapacity(n10);
        object = this.getAllFinalizedReportFiles().iterator();
        while (bl2 = object.hasNext()) {
            File file = (File)object.next();
            Object object2 = TRANSFORM;
            Object object3 = CrashlyticsReportPersistence.readTextFile(file);
            object2 = ((CrashlyticsReportJsonTransform)object2).reportFromJson((String)object3);
            object3 = file.getName();
            object2 = CrashlyticsReportWithSessionId.create((CrashlyticsReport)object2, (String)object3);
            try {
                arrayList.add(object2);
            }
            catch (IOException iOException) {
                object3 = Logger.getLogger();
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Could not load report file ");
                charSequence.append(file);
                String string2 = "; deleting";
                charSequence.append(string2);
                charSequence = charSequence.toString();
                ((Logger)object3).w((String)charSequence, iOException);
                file.delete();
            }
        }
        return arrayList;
    }

    public void persistEvent(CrashlyticsReport$Session$Event crashlyticsReport$Session$Event, String string2) {
        this.persistEvent(crashlyticsReport$Session$Event, string2, false);
    }

    public void persistEvent(CrashlyticsReport$Session$Event object, String string2, boolean bl2) {
        SessionSettingsData sessionSettingsData = this.settingsDataProvider.getSettings().getSessionData();
        int n10 = sessionSettingsData.maxCustomExceptionEvents;
        File file = this.getSessionDirectoryById(string2);
        object = TRANSFORM.eventToJson((CrashlyticsReport$Session$Event)object);
        Serializable serializable = this.eventCounter;
        int n11 = ((AtomicInteger)serializable).getAndIncrement();
        Object object2 = CrashlyticsReportPersistence.generateEventFilename(n11, bl2);
        serializable = new File(file, (String)object2);
        try {
            CrashlyticsReportPersistence.writeTextFile((File)serializable, (String)object);
        }
        catch (IOException iOException) {
            object2 = Logger.getLogger();
            serializable = new StringBuilder();
            String string3 = "Could not persist event for session ";
            ((StringBuilder)serializable).append(string3);
            ((StringBuilder)serializable).append(string2);
            string2 = ((StringBuilder)serializable).toString();
            ((Logger)object2).w(string2, iOException);
        }
        CrashlyticsReportPersistence.trimEvents(file, n10);
    }

    public void persistReport(CrashlyticsReport object) {
        Object object2 = ((CrashlyticsReport)object).getSession();
        if (object2 == null) {
            Logger.getLogger().d("Could not get session for report");
            return;
        }
        object2 = ((CrashlyticsReport$Session)object2).getIdentifier();
        Object object3 = this.getSessionDirectoryById((String)object2);
        object3 = CrashlyticsReportPersistence.prepareDirectory((File)object3);
        Object object4 = TRANSFORM;
        object = ((CrashlyticsReportJsonTransform)object4).reportToJson((CrashlyticsReport)object);
        String string2 = REPORT_FILE_NAME;
        object4 = new File((File)object3, string2);
        try {
            CrashlyticsReportPersistence.writeTextFile((File)object4, (String)object);
        }
        catch (IOException iOException) {
            object3 = Logger.getLogger();
            object4 = new StringBuilder();
            string2 = "Could not persist report for session ";
            ((StringBuilder)object4).append(string2);
            ((StringBuilder)object4).append((String)object2);
            object2 = ((StringBuilder)object4).toString();
            ((Logger)object3).d((String)object2, iOException);
        }
    }

    public void persistUserIdForSession(String string2, String string3) {
        Object object = this.getSessionDirectoryById(string3);
        String string4 = USER_FILE_NAME;
        Comparable<File> comparable = new Comparable<File>((File)object, string4);
        try {
            CrashlyticsReportPersistence.writeTextFile((File)comparable, string2);
        }
        catch (IOException iOException) {
            object = Logger.getLogger();
            comparable = new Comparable<File>();
            string4 = "Could not persist user ID for session ";
            ((StringBuilder)comparable).append(string4);
            ((StringBuilder)comparable).append(string3);
            string3 = ((StringBuilder)comparable).toString();
            ((Logger)object).w(string3, iOException);
        }
    }
}

