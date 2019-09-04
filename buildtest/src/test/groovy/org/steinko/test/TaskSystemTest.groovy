package org.steinko.test
import spock.lang.Specification
import spock.lang.Shared
import org.gradle.testkit.runner.GradleRunner

import org.steinko.projectversion.test.ProjectDir

class TaskSystemTest extends Specification { 
	@Shared
	def result
	
	def setupSpec() {
		result = GradleRunner.create()
		.withProjectDir(new File("/Users/steinkorsveien/Development/TestWorkSpace/ProjectVersion"))
		.withArguments("printVersion")
		.build()
	}
	
	def "should exist a task with name printVersion" () {
	    
	    expect:
	       result.output.contains("BUILD SUCCESSFUL")
	}
	
	def "should print Version: 0.1-SNAPSHOT"  () {
		
		expect:
		   result.output.contains("Version: 0.1-SNAPSHOT")	
	}
	
	def "should print Before reading the project version" () {
		
		expect:
		   result.output.contains("Before reading the project version")
	}
	
	def "should print fisrt action" () {
		
		expect:
		   result.output.contains("First Action")
	}
	
	def "should print last action" () {
		
		expect:
		   result.output.contains("Last Action")
	}
	
}