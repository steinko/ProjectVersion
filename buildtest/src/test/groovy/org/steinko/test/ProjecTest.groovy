package org.steinko.test

import spock.lang.Specification

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import java.nio.file.Files

import org.steinko.projectversion.test.ProjectDir

class ProjectTest  extends Specification { 
	def "should have a project" () {
		given:
		   Project project = ProjectBuilder
		   .builder()
		   .withProjectDir(new File(ProjectDir.path()))
		   .build()
		 
	
		//expect:
		//    project.name == 'ProjectVerion'		   
	}
}
