import org.apache.log4j.Logger;
import org.groovydev.TwitterBootstrapTagLib;

class TwitterBootstrapGrailsPlugin {
    
    Logger log = Logger.getLogger('grails.plugins.twitterBootstrap.TwitterBootstrapGrailsPlugin')
    
    // the plugin version
    def version = "0.3"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = ['resources':'1.0 > *']
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Karol Balejko"
    def authorEmail = "kb@groovydev.org"
    def title = "Twitter Bootstrap CSS framework resource files plugin"
    def description = '''\\
Provides Twitter Bootstrap CSS framework resource files.

Bootstrap is Twitter's toolkit for kickstarting CSS for websites, apps, and more. It includes base CSS styles for typography, forms, buttons, tables, grids, navigation, alerts, and more.

To get started -- checkout http://twitter.github.com/bootstrap!

Including the resources
-----------------------

You must use the Grails resources framework to make use of this plugin. The resources exposed by this plugin are:

    bootstrap - twitter bootstrap css (version 1.2.0)
    bootstrap-less - twitter bootstrap use with less (version 1.2.0)

Usage
-----

    <r:require modules="bootstrap"/>

Configuration
-------------

Fix grails taglib g:paginate to work with bootstrap css. 
 
    grails.plugins.twitterbootstrap.fixtaglib = true

'''

    // URL to the plugin's documentation
    def documentation = "https://github.com/groovydev/twitter-bootstrap-grails-plugin/blob/master/README.md"

    def doWithSpring = {
     
        def configTabLib = application.config.grails.plugins.twitterbootstrap.fixtaglib
        if (application.config.grails.plugins.twitterbootstrap.fixtaglib) {
            log.debug "Found config grails.plugins.twitterbootstrap.fixtaglib = ${configTabLib}"
            application.addArtefact('TagLib', TwitterBootstrapTagLib)
            log.debug "TwitterBootstrapTagLib added"
        }
    }
    
}
