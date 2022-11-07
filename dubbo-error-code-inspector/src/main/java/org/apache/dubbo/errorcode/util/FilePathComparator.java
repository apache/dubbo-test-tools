/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.errorcode.util;

import java.io.File;
import java.util.Comparator;

/**
 * Comparator for File paths.
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
