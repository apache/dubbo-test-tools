package org.apache.dubbo.errorcode.util;

import java.io.File;
import java.util.Comparator;

/**
 * Comparator for Error codes.
 */
public final class FilePathComparator implements Comparator<String> {

    private static final String SEPARATOR = File.separatorChar == '\\' ? "\\\\" : File.separator;

    private FilePathComparator() {}

    private static class Holder {
        static final FilePathComparator instance = new FilePathComparator();
    }

    public static FilePathComparator getInstance() {
        return Holder.instance;
    }

    @Override
    public int compare(String o1, String o2) {

        String[] segments1 = o1.split(SEPARATOR);
        String[] segments2 = o2.split(SEPARATOR);

        for (int i = 0; i < Math.min(segments1.length, segments2.length); i++) {
            if (!segments1[i].equals(segments2[i])) {
                return segments1[i].compareTo(segments2[i]);
            }
        }

        return o1.compareTo(o2);
    }
}
