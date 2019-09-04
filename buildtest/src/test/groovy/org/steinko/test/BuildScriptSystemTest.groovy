package org.steinko.test
import spock.lang.Specification
import spock.lang.Shared
import org.gradle.testkit.runner.GradleRunner
import org.steinko.projectversion.test.ProjectDir

class BuildScriptSystemTest extends Specification { 
	@Shared
	def result
	
	def setupSpec() {
		result = GradleRunner.create()
		.withProjectDir(new File(ProjectDir.path()))
		.withArguments("properties")
		.build()		
	}
	
	def "should test build script"() {
		expect:
		   result.output.contains("BUILD SUCCESSFUL")
	}
	
	def "should conatn a prperty myProp with value myValue "() {
		expect:
		   result.output.contains("myProp: myValue")	
	}
	
	def "should contain a property someOtherPrpo with value 123" (){
         expect:
		   result.output.contains("someOtherProp: 123")	
	}
	
	def "should conatn a property version with value 0.1-SNAPSHOT"() {
		
		 expect:
		   result.output.contains("version: 0.1-SNAPSHOT")	   
	}
		  	
}