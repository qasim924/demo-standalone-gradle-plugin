package com.codeinvestigator.plugin

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import spock.lang.Specification
import spock.lang.TempDir

class GitPullPluginTest extends Specification{
    @TempDir File testProjectDir
    File buildFile

    def setup() {
        buildFile = new File(testProjectDir, "build.gradle")
        buildFile << """
            plugins {
                id 'com.codeinvestigator.weatherforecast'
            }
        """
    }

    def "can pull in from git"() {
        buildFile << """
            remoteGit {
                message = 'and this message was read properly'
            }
        """
        when:
        def result = GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments('pull')
                .withPluginClasspath()
                .build()

        then:
        result.output.contains("SUCCESS! The plugin got included and this message was read properly.")
        result.task(":pull").outcome == TaskOutcome.SUCCESS
    }
}
