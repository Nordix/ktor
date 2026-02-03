/*
 * Copyright 2014-2025 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import ktorbuild.targets.*
import ktorbuild.wirePackageJsonAggregationTasks

plugins {
    id("ktorbuild.doctor")
    id("ktorbuild.publish.verifier")
}

subprojects {
    // force logback-core:1.5.25 to resolve CVE-2026-1225 and CVE-2025-11226
    configurations.all {
        resolutionStrategy.force("ch.qos.logback:logback-core:1.5.25")
    }
}

logger.lifecycle("Build version: ${project.version}")
logger.lifecycle("Kotlin version: ${libs.versions.kotlin.get()}")

wirePackageJsonAggregationTasks()

configureYarn()
configureNodeJs()
