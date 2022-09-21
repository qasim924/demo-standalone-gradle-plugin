package com.codeinvestigator.plugin.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

abstract public class GitCloneTask extends DefaultTask {
    @Input
    abstract public Property<String> getMessage();

    @TaskAction
    public void pullFromRemote() {
        System.out.println("SUCCESS! The plugin got included " + getMessage().get() + ".");
    }
}
