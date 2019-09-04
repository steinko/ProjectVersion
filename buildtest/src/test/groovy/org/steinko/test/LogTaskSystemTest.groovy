package org.steinko.test
import spock.lang.Specification
import org.gradle.testkit.runner.GradleRunner
import spock.lang.Shared

import java.util.ArrayList
import java.util.List

import org.steinko.projectversion.test.ProjectDir

class LogTasktSystemTest extends Specification { 
	@Shared
	def result
	
	def setupSpec() { 
		
		List<String> arguments = new ArrayList<String>()
		arguments.add("logVersion")
		arguments.add("-q")
		
		result = GradleRunner.create()
		.withProjectDir(new File(ProjectDir.path()))
		.withArguments(arguments)
		.build()
		
	}
	
	def "should contain a logger task" () {
		 expect:
		   result.output.contains("BUILD SUCCESSFUL")
		   
	}
	
	def "should print Version: 0.1-SNAPSHOT"  () {
		
		expect:
		   result.output.contains("Version: 0.1-SNAPSHOT")
	}

	def "should contain a group versoning"  () {
		
		expect:
		   result.output.contains("Task :logVersion")
	}
	
}