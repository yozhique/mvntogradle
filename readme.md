<pre>
Steps I did to migrate to gradle:

1. Install gradle - make it runnable from command line
2. run gradle init and delete wrappers
3. delete pom.xml
4. right-click gradle.build and import gradle project
5. run "gradle build" - have jave version problem, correct it
6. build again - lombok problem, add annotationProcessor, also! - make lombok compileOnly
7. Apply spring boot plugin 
   id 'org.springframework.boot' version '2.5.5'
8. You can run the app with it

    springBoot {
       mainClass = 'com.countryapi.countryapi.CountryApiApp'
    }

9. Make use of springboot parent pom and remove explicitly specified versions for spring parent pom managed dependencies
   id 'io.spring.dependency-management' version '1.0.11.RELEASE'

10. try to run gradle test, then tests from IDE - no tests were run, fix it
    
    tasks.test {
        useJUnitPlatform()
    }
    
11. Add little more info on tests
    
    testLogging {
        events "passed", "skipped", "failed"
    }
    
12. Apply some experienced gradler wisdom to better organise dependency management

</pre>
