grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
    }
    plugins {
        /*compile ":resources:latest.integration"
        build(":release:latest.integration") {
            export = false
        }*/
        build(":tomcat:$grailsVersion",
                ":release:2.0.4") { export = false }
        build(":hibernate:$grailsVersion") { export = false }
        runtime ":resources:1.2-RC1"
    }
    dependencies {
    }
}
