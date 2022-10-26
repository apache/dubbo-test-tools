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

import org.apache.dubbo.errorcode.config.ErrorCodeInspectorConfig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Tests of FileUtils.
 */
class FileUtilsTest {
    @Test
    void testLoadConfigurationFileInResources() {
        Assertions.assertTrue(
            FileUtils.loadConfigurationFileInResources("exclusions.cfg")
                .contains("dubbo-common\\target\\classes\\org\\apache\\dubbo\\common\\logger\\support\\FailsafeLogger.class"));
    }

    @Test
    void testOpenFileAsByteArray() {
        String path = FileUtils.getResourceFilePath("FileCacheStore.jcls");
        byte[] bytes = FileUtils.openFileAsByteArray(path);

        byte[] magic = new byte[]{(byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE};
        byte[] actualBytes = new byte[]{bytes[0], bytes[1], bytes[2], bytes[3]};

        Assertions.assertArrayEquals(magic, actualBytes);
    }

    @Test
    void testIgnoranceOfGetAllClassFilesInDirectory() {
        ErrorCodeInspectorConfig.EXCLUSIONS.add(
                "testing-mock-source\\target\\classes\\org\\apache\\dubbo\\errorcode\\mock\\GrandChildClass.class"
                        .replace('\\', File.separatorChar));

        Path rootOfResources = Paths.get(FileUtils.getResourceFilePath("FileCacheStore.jcls")).getParent();

        Path mockCodeBasePath = Paths.get(rootOfResources.toString(), "mock-source");
        Path mockModulePath = Paths.get(mockCodeBasePath.toString(), "testing-mock-source");
        Path fileToIgnore = Paths.get(mockModulePath.toString(), "target", "classes",
                "org", "apache", "dubbo", "errorcode", "mock", "GrandChildClass.class");

        Assertions.assertFalse(FileUtils.getAllClassFilesInDirectory(mockCodeBasePath, mockModulePath).contains(fileToIgnore));
    }
}
