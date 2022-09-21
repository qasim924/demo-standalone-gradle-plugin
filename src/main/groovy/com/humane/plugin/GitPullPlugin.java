package com.humane.plugin;

import com.humane.plugin.extensions.RemoteUrlExtension;
import com.humane.plugin.tasks.GitCloneTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GitPullPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        RemoteUrlExtension extension = project.getExtensions().create("remoteGit", RemoteUrlExtension.class);
        GitCloneTask gitCloneTask = project.getTasks().create("pull", GitCloneTask.class);
        gitCloneTask.getMessage().set(extension.getMessage());
    }
}
