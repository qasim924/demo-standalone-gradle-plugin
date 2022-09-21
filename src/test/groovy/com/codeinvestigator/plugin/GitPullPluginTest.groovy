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
                url = 'https://www.mycustomurl.com'
            }
        """
        when:
        def result = GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withArguments('pull')
                .withPluginClasspath()
                .build()

        then:
        result.output.contains("url is https://www.mycustomurl.com")
        result.task(":pull").outcome == TaskOutcome.SUCCESS
    }
}
