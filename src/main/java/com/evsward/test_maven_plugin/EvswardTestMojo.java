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
    /**
     * @parameter expression="${buildinfo.prefix}" 
     * default-value="+++"
     */
    private String prefix;

    public void execute() throws MojoExecutionException, MojoFailureException {
        Build build = project.getBuild();
        String outputDirectory = build.getOutputDirectory();
        String sourceDirectory = build.getSourceDirectory();
        String testOutputDirectory = build.getTestOutputDirectory();
        String testSourceDirectory = build.getTestSourceDirectory();
        getLog().info("\n==========================\nProject build info:");
        String[] info = { outputDirectory, sourceDirectory, testOutputDirectory, testSourceDirectory };
        for (String item : info) {
            getLog().info("\t" + prefix + "   " + item);
        }
        getLog().info("=======================");
    }

}
