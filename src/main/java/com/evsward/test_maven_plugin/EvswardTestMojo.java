package com.evsward.test_maven_plugin;

import org.apache.maven.model.Build;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

/**
 * 
 * @author Evsward
 * @goal evswardtest
 * @phase pre-integration-test
 */
public class EvswardTestMojo extends AbstractMojo {

    /**
     * @parameter expression="${project}"
     * @readonly
     */
    private MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {
        Build build = project.getBuild();
        getLog().info("\n=========test here=================\n");
        getLog().info("build: " + build.getDefaultGoal() + build.getDirectory() + build.getFinalName());
        getLog().info("=======================");
    }

}
