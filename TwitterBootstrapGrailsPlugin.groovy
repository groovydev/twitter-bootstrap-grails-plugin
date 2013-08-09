import org.groovydev.TwitterBootstrapTagLib

class TwitterBootstrapGrailsPlugin {

    // the plugin version
    def version = "3.0.0.RC1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"

    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Karol Balejko"
    def authorEmail = "kb@groovydev.com"
    def developers = [ [ name: "Nicholas Wittstruck", email: "nicholas@spotmapping.com" ]]
    def organization = [ name: "GroovyDev", url: "http://groovydev.com/" ]
    def title = "Plugin Twitter Bootstrap CSS framework resource files"
    def description = """Provides Twitter Bootstrap CSS framework resource files.

Bootstrap is Twitter's toolkit for kickstarting CSS for websites, apps, and more. It includes base CSS styles for typography, forms, buttons, tables, grids, navigation, alerts, and more.
To get started with Bootstrap checkout the [Bootstrap Documentation|http://getbootstrap.com/getting-started/]!
"""

    // URL to the plugin's documentation
    def documentation = "https://github.com/groovydev/twitter-bootstrap-grails-plugin/blob/master/README.md"
    def license = "APACHE"
    def issueManagement = [ system: "github", url: "https://github.com/groovydev/twitter-bootstrap-grails-plugin/issues" ]
    def scm = [ url: "https://github.com/groovydev/twitter-bootstrap-grails-plugin" ]

}
