package com.codeinvestigator.plugin.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

abstract public class GitCloneTask extends DefaultTask {
    @Input
    abstract public Property<String> getUrl();

    @TaskAction
    public void pullFromRemote() {
        System.out.println("url is " + getUrl().get());
    }
}
