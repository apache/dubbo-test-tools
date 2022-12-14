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

package org.apache.dubbo.errorcode.reporter.impl;

import org.apache.dubbo.errorcode.model.LoggerMethodInvocation;
import org.apache.dubbo.errorcode.reporter.InspectionResult;
import org.apache.dubbo.errorcode.util.FilePathComparator;
import org.apache.dubbo.errorcode.util.FileUtils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility of generating string content.
 */
final class StringifyUtil {
    private StringifyUtil() {
        throw new UnsupportedOperationException("No instance of StringifyUtil for you! ");
    }

    static void outputStringifyText(InspectionResult inspectionResult, PrintStream outputStream) {
        List<String> errorCodes = inspectionResult.getAllErrorCodes();
        List<String> notReachable = inspectionResult.getLinkNotReachableErrorCodes();

        outputStream.println("All error codes: " + errorCodes + ", totally " + errorCodes.size() + " codes.");
        outputStream.println();
        outputStream.println("Error codes which document links are not reachable: " + notReachable + ", totally " + notReachable.size() + " codes.");
        outputStream.println();
        outputStream.println(StringifyUtil.generateIllegalInvocationString(inspectionResult));
    }

    static String generateIllegalInvocationString(InspectionResult inspectionResult) {
        StringBuilder illegalInvocationReportStringBuilder = new StringBuilder();
        illegalInvocationReportStringBuilder.append("Illegal logger method invocations: ");
        illegalInvocationReportStringBuilder.append('\n');

        List<String> sortedFileNameKeys = new ArrayList<>(inspectionResult.getIllegalInvocations().keySet());
        sortedFileNameKeys.sort(FilePathComparator.getInstance());

        for (String key : sortedFileNameKeys) {

            illegalInvocationReportStringBuilder.append(FileUtils.getSourceFilePathFromClassFilePath(key));

            illegalInvocationReportStringBuilder.append(": ");
            illegalInvocationReportStringBuilder.append("\n");

            List<LoggerMethodInvocation> loggerMethodInvocations = inspectionResult.getInvalidLoggerMethodInvocationLocations().get(key);

            for (LoggerMethodInvocation mi : loggerMethodInvocations) {
                illegalInvocationReportStringBuilder.append("Line ");
                illegalInvocationReportStringBuilder.append(mi.getOccurredLines());
                illegalInvocationReportStringBuilder.append(": ");
                illegalInvocationReportStringBuilder.append(mi.getLoggerMethodInvocationCode());
                illegalInvocationReportStringBuilder.append('\n');
            }

            illegalInvocationReportStringBuilder.append('\n');
        }

        return illegalInvocationReportStringBuilder.toString();
    }
}
