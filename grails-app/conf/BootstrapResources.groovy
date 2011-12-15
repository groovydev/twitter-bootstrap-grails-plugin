def log = org.apache.log4j.Logger.getLogger('grails.plugins.twitterbootstrap.BootstrapResources')
def dev = grails.util.GrailsUtil.isDevelopmentEnv()

def applicationContext = org.codehaus.groovy.grails.commons.ApplicationHolder.application.mainContext
def lesscssPlugin = applicationContext.pluginManager.getGrailsPlugin('lesscss-resources')
def jqueryPlugin = applicationContext.pluginManager.getGrailsPlugin('jquery')
def configTagLib = org.codehaus.groovy.grails.commons.ApplicationHolder.application.config.grails.plugins.twitterbootstrap.fixtaglib
def configDefaultBundle = org.codehaus.groovy.grails.commons.ApplicationHolder.application.config.grails.plugins.twitterbootstrap.defaultBundle 
if (!configDefaultBundle && !configDefaultBundle.equals(false)) {
    configDefaultBundle = 'bundle_bootstrap'
}
def cssFile = "bootstrap.css"
def cssminFile = "bootstrap.min.css"

log.debug "config: grails.plugins.twitterbootstrap.fixtaglib = ${configTagLib}"
log.debug "config: grails.plugins.twitterbootstrap.defaultBundle = ${configDefaultBundle}"
log.debug "is lesscss-resources plugin loaded? ${!!lesscssPlugin}"
log.debug "is jquery plugin loaded? ${!!jqueryPlugin}"

modules = {

    'bootstrap-fixtaglib' {
        defaultBundle configDefaultBundle
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'css', file: 'bootstrap-fixtaglib.css'], disposition: 'head'
    }

    'bootstrap-css' {
        defaultBundle configDefaultBundle
        if (configTagLib) {
            dependsOn 'bootstrap-fixtaglib'
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'css', file: (dev ? cssFile : cssminFile)], disposition: 'head', exclude:'minify'
    }

    'bootstrap-alerts' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-alerts.js'], disposition: 'head'
    }

    'bootstrap-dropdown' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-dropdown.js'], disposition: 'head'
    }

    'bootstrap-modal' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-modal.js'], disposition: 'head'
    }

    'bootstrap-popover' {
        defaultBundle configDefaultBundle
        dependsOn 'bootstrap-twipsy'
        
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-popover.js'], disposition: 'head'
    }

    'bootstrap-scrollspy' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-scrollspy.js'], disposition: 'head'
    }

    'bootstrap-tabs' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-tabs.js'], disposition: 'head'
    }

    'bootstrap-twipsy' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-twipsy.js'], disposition: 'head'
    }

    'bootstrap-buttons' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-buttons.js'], disposition: 'head'
    }

    'bootstrap-js' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        dependsOn 'bootstrap-alerts,bootstrap-dropdown,bootstrap-modal,bootstrap-scrollspy,bootstrap-tabs,bootstrap-twipsy,bootstrap-popover,bootstrap-buttons'
    }

    'bootstrap-less' {
        defaultBundle configDefaultBundle
        if (configTagLib) {
            dependsOn 'bootstrap-fixtaglib'
        }
        resource id:'bootstrap-less', url:[plugin: 'twitter-bootstrap', dir: 'css', file: 'bootstrap.less'], attrs:[rel: "stylesheet/less", type:'css'], disposition: 'head'
    }

    bootstrap {
        defaultBundle configDefaultBundle
        if (lesscssPlugin) {
            dependsOn 'bootstrap-less'
        } else {
            dependsOn 'bootstrap-css'
        }
        dependsOn 'bootstrap-js'
    }
       
}
