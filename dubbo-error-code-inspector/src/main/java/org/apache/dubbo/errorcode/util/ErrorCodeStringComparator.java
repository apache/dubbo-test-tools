package org.apache.dubbo.errorcode.util;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator for Error codes.
 */
public final class ErrorCodeStringComparator implements Comparator<String> {

    private ErrorCodeStringComparator() {}

    private static class Holder {
        static final ErrorCodeStringComparator instance = new ErrorCodeStringComparator();
    }

    public static ErrorCodeStringComparator getInstance() {
        return Holder.instance;
    }

    @Override
    public int compare(String o1, String o2) {
        int[] firstCodeSegments = Arrays.stream(o1.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] secondCodeSegments = Arrays.stream(o2.split("-")).mapToInt(Integer::parseInt).toArray();

        if (firstCodeSegments[0] == secondCodeSegments[0]) {
            return Integer.compare(firstCodeSegments[1], secondCodeSegments[1]);
        }

        return Integer.compare(firstCodeSegments[0], secondCodeSegments[0]);
    }
}
