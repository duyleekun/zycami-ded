/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import d.v.e.l.i2$a;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;

public final class i2 {
    private static final String a = System.getProperty("line.separator");

    private i2() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("u can't instantiate me...");
        throw unsupportedOperationException;
    }

    public static i2$a a(String string2, boolean bl2) {
        boolean bl3 = true;
        String[] stringArray = new String[bl3];
        stringArray[0] = string2;
        return i2.f(stringArray, bl2, bl3);
    }

    public static i2$a b(String string2, boolean bl2, boolean bl3) {
        String[] stringArray = new String[]{string2};
        return i2.f(stringArray, bl2, bl3);
    }

    public static i2$a c(List stringArray, boolean bl2) {
        if (stringArray == null) {
            stringArray = null;
        } else {
            String[] stringArray2 = new String[]{};
            stringArray = stringArray.toArray(stringArray2);
        }
        return i2.f(stringArray, bl2, true);
    }

    public static i2$a d(List stringArray, boolean bl2, boolean bl3) {
        if (stringArray == null) {
            stringArray = null;
        } else {
            String[] stringArray2 = new String[]{};
            stringArray = stringArray.toArray(stringArray2);
        }
        return i2.f(stringArray, bl2, bl3);
    }

    public static i2$a e(String[] stringArray, boolean bl2) {
        return i2.f(stringArray, bl2, true);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static i2$a f(String[] object, boolean bl2, boolean bl3) {
        int n10;
        String string2;
        block65: {
            void var0_4;
            Reader reader;
            Object object2;
            Object object3;
            Object object4;
            block64: {
                Object object5;
                block66: {
                    String string3;
                    block63: {
                        block58: {
                            block56: {
                                block55: {
                                    Object object6;
                                    block61: {
                                        block62: {
                                            int n11;
                                            block57: {
                                                block60: {
                                                    Object object7;
                                                    string3 = "UTF-8";
                                                    string2 = "";
                                                    n10 = -1;
                                                    if (object == null) return new i2$a(n10, string2, string2);
                                                    int n12 = ((Object)object).length;
                                                    if (n12 == 0) break block65;
                                                    n12 = 0;
                                                    object4 = null;
                                                    try {
                                                        object6 = Runtime.getRuntime();
                                                        object3 = bl2 ? "su" : "sh";
                                                        object3 = ((Runtime)object6).exec((String)object3);
                                                    }
                                                    catch (Throwable throwable) {
                                                        bl2 = false;
                                                        object3 = null;
                                                        boolean bl4 = false;
                                                        object2 = null;
                                                        break block55;
                                                    }
                                                    catch (Exception exception) {
                                                        bl2 = false;
                                                        object3 = null;
                                                        bl3 = false;
                                                        object5 = null;
                                                        break block56;
                                                    }
                                                    try {
                                                        object2 = ((Process)object3).getOutputStream();
                                                        object6 = new DataOutputStream((OutputStream)object2);
                                                    }
                                                    catch (Throwable throwable) {
                                                        boolean bl5 = false;
                                                        object2 = null;
                                                        break block55;
                                                    }
                                                    catch (Exception exception) {
                                                        bl3 = false;
                                                        object5 = null;
                                                        break block56;
                                                    }
                                                    try {
                                                        int n13;
                                                        try {
                                                            n13 = ((Object)object).length;
                                                            reader = null;
                                                            for (n11 = 0; n11 < n13; ++n11) {
                                                                object7 = object[n11];
                                                                if (object7 == null) continue;
                                                                object7 = ((String)object7).getBytes();
                                                                ((FilterOutputStream)object6).write((byte[])object7);
                                                                object7 = a;
                                                                ((DataOutputStream)object6).writeBytes((String)object7);
                                                                ((DataOutputStream)object6).flush();
                                                            }
                                                            object = new StringBuilder();
                                                            object2 = "exit";
                                                            ((StringBuilder)object).append((String)object2);
                                                            object2 = a;
                                                            ((StringBuilder)object).append((String)object2);
                                                            object = ((StringBuilder)object).toString();
                                                            ((DataOutputStream)object6).writeBytes((String)object);
                                                            ((DataOutputStream)object6).flush();
                                                            n10 = ((Process)object3).waitFor();
                                                            if (!bl3) break block57;
                                                            object = new StringBuilder();
                                                        }
                                                        catch (Exception exception) {
                                                            bl3 = false;
                                                            object5 = null;
                                                            string3 = null;
                                                            boolean bl6 = false;
                                                            object2 = null;
                                                            boolean bl7 = false;
                                                            reader = null;
                                                            object4 = object6;
                                                            break block58;
                                                        }
                                                        try {
                                                            object5 = new StringBuilder();
                                                        }
                                                        catch (Exception exception) {
                                                            string3 = null;
                                                            n13 = 0;
                                                            object2 = null;
                                                            n11 = 0;
                                                            reader = null;
                                                            object4 = object6;
                                                            Exception exception2 = exception;
                                                            object5 = object;
                                                            object = exception2;
                                                            break block58;
                                                        }
                                                        try {
                                                            object7 = ((Process)object3).getInputStream();
                                                            reader = new InputStreamReader((InputStream)object7, string3);
                                                            object2 = new BufferedReader(reader);
                                                        }
                                                        catch (Exception exception) {
                                                            n13 = 0;
                                                            object2 = null;
                                                            n11 = 0;
                                                            reader = null;
                                                            break block60;
                                                        }
                                                    }
                                                    catch (Throwable throwable) {
                                                        boolean bl8 = false;
                                                        object2 = null;
                                                        boolean bl9 = false;
                                                        reader = null;
                                                        break block61;
                                                    }
                                                    try {
                                                        InputStream inputStream = ((Process)object3).getErrorStream();
                                                        object7 = new InputStreamReader(inputStream, string3);
                                                        reader = new BufferedReader((Reader)object7);
                                                    }
                                                    catch (Throwable throwable) {
                                                        n11 = 0;
                                                        reader = null;
                                                        break block61;
                                                    }
                                                    catch (Exception exception) {
                                                        n11 = 0;
                                                        reader = null;
                                                        break block60;
                                                    }
                                                    try {
                                                        string3 = ((BufferedReader)object2).readLine();
                                                        if (string3 != null) {
                                                            ((StringBuilder)object).append(string3);
                                                            while ((string3 = ((BufferedReader)object2).readLine()) != null) {
                                                                object4 = a;
                                                                ((StringBuilder)object).append((String)object4);
                                                                ((StringBuilder)object).append(string3);
                                                            }
                                                        }
                                                        if ((string3 = ((BufferedReader)reader).readLine()) != null) {
                                                            ((StringBuilder)object5).append(string3);
                                                            while ((string3 = ((BufferedReader)reader).readLine()) != null) {
                                                                object4 = a;
                                                                ((StringBuilder)object5).append((String)object4);
                                                                ((StringBuilder)object5).append(string3);
                                                            }
                                                        }
                                                        object4 = object2;
                                                        break block62;
                                                    }
                                                    catch (Throwable throwable) {
                                                        break block61;
                                                    }
                                                    catch (Exception exception) {}
                                                }
                                                object4 = object6;
                                                CharSequence charSequence = object5;
                                                object5 = object;
                                                object = string3;
                                                string3 = charSequence;
                                                break block58;
                                            }
                                            object = null;
                                            bl3 = false;
                                            object5 = null;
                                            n11 = 0;
                                            reader = null;
                                        }
                                        try {
                                            ((FilterOutputStream)object6).close();
                                        }
                                        catch (IOException iOException) {
                                            iOException.printStackTrace();
                                        }
                                        if (object4 != null) {
                                            try {
                                                ((BufferedReader)object4).close();
                                            }
                                            catch (IOException iOException) {
                                                iOException.printStackTrace();
                                            }
                                        }
                                        if (reader != null) {
                                            try {
                                                ((BufferedReader)reader).close();
                                            }
                                            catch (IOException iOException) {
                                                iOException.printStackTrace();
                                            }
                                        }
                                        if (object3 != null) {
                                            ((Process)object3).destroy();
                                        }
                                        break block66;
                                    }
                                    object4 = object6;
                                    break block64;
                                }
                                boolean bl10 = false;
                                reader = null;
                                break block64;
                            }
                            string3 = null;
                            boolean bl11 = false;
                            object2 = null;
                            boolean bl12 = false;
                            reader = null;
                        }
                        try {
                            ((Throwable)object).printStackTrace();
                            if (object4 == null) break block63;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                            break block64;
                        }
                        try {
                            ((FilterOutputStream)object4).close();
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }
                    if (object2 != null) {
                        try {
                            ((BufferedReader)object2).close();
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }
                    if (reader != null) {
                        try {
                            ((BufferedReader)reader).close();
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }
                    if (object3 != null) {
                        ((Process)object3).destroy();
                    }
                    object = object5;
                    object5 = string3;
                }
                object = object == null ? string2 : ((StringBuilder)object).toString();
                if (object5 != null) {
                    string2 = ((StringBuilder)object5).toString();
                }
                return new i2$a(n10, (String)object, string2);
            }
            if (object4 != null) {
                try {
                    ((FilterOutputStream)object4).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (object2 != null) {
                try {
                    ((BufferedReader)object2).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    ((BufferedReader)reader).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (object3 == null) throw var0_4;
            ((Process)object3).destroy();
            throw var0_4;
        }
        return new i2$a(n10, string2, string2);
    }
}

