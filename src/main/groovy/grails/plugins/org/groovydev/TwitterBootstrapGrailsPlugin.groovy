package grails.plugins.org.groovydev

import grails.plugins.*

class TwitterBootstrapGrailsPlugin extends Plugin {
    def grailsVersion = "3.0.0 > *"
    def author = "Karol Balejko"
    def authorEmail = "kb@groovydev.com"
    def developers = [
        [ name: "Nicholas Wittstruck", email: "nicholas@spotmapping.com" ],
        [ name: "Michael Legart", email: "ml@code3.dk" ],
        [ name: "Dhiraj Mahapatro", email: "dmahapatro@netjets.com" ]
    ]
    def organization = [ name: "GroovyDev", url: "http://groovydev.com/" ]
    def title = "Plugin Bootstrap CSS framework resource files"
    def description = """Provides Bootstrap CSS framework resource files.

Bootstrap is a toolkit for kickstarting CSS for websites, apps, and more. It includes base CSS styles for typography, forms, buttons, tables, grids, navigation, alerts, and more.
To get started with Bootstrap checkout the [Bootstrap Documentation|http://getbootstrap.com/getting-started/]!
"""

    def documentation = "https://github.com/groovydev/twitter-bootstrap-grails-plugin/blob/master/README.md"
    def license = "APACHE"
    def issueManagement = [ system: "github", url: "https://github.com/groovydev/twitter-bootstrap-grails-plugin/issues" ]
    def scm = [ url: "https://github.com/groovydev/twitter-bootstrap-grails-plugin" ]
}
