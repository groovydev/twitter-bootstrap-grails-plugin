import org.apache.log4j.Logger
import org.groovydev.TwitterBootstrapTagLib

class TwitterBootstrapGrailsPlugin {
    
    // the plugin version
    def version = "2.0.1.23"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = ['resources':'1.0 > *']
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Karol Balejko"
    def authorEmail = "kb@groovydev.com"
    def organization = [ name: "GroovyDev", url: "http://groovydev.com/" ]
    def title = "Plugin Twitter Bootstrap CSS framework resource files"
    def description = '''Provides Twitter Bootstrap CSS framework resource files.
Bootstrap is Twitter's toolkit for kickstarting CSS for websites, apps, and more. It includes base CSS styles for typography, forms, buttons, tables, grids, navigation, alerts, and more.
To get started -- checkout http://twitter.github.com/bootstrap!
'''

    // URL to the plugin's documentation
    def documentation = "https://github.com/groovydev/twitter-bootstrap-grails-plugin/blob/master/README.md"
    def license = "APACHE"
    def issueManagement = [ system: "github", url: "https://github.com/groovydev/twitter-bootstrap-grails-plugin/issues" ]
    def scm = [ url: "https://github.com/groovydev/twitter-bootstrap-grails-plugin" ]

}
