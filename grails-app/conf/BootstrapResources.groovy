import org.apache.commons.io.FileUtils

def log = org.apache.log4j.Logger.getLogger('grails.plugins.twitterbootstrap.BootstrapResources')
def dev = grails.util.GrailsUtil.isDevelopmentEnv()

def applicationContext = org.codehaus.groovy.grails.commons.ApplicationHolder.application.mainContext
def lesscssPlugin = applicationContext.pluginManager.getGrailsPlugin('lesscss-resources')
def jqueryPlugin = applicationContext.pluginManager.getGrailsPlugin('jquery')
def twitterbootstrapPlugin = applicationContext.pluginManager.getGrailsPlugin('twitter-bootstrap')
def configTagLib = org.codehaus.groovy.grails.commons.ApplicationHolder.application.config.grails.plugins.twitterbootstrap.fixtaglib
def configDefaultBundle = org.codehaus.groovy.grails.commons.ApplicationHolder.application.config.grails.plugins.twitterbootstrap.defaultBundle
if (!configDefaultBundle && !configDefaultBundle.equals(false)) {
    configDefaultBundle = 'bundle_bootstrap'
}

def configCustomDir = org.codehaus.groovy.grails.commons.ApplicationHolder.application.config.grails.plugins.twitterbootstrap.customDir ?: 'less'
def twitterbootstrapPluginDir = applicationContext.getResource(twitterbootstrapPlugin.pluginPath).file
def dirLessSource = new File(twitterbootstrapPluginDir, 'less')
def dirTarget = new File(twitterbootstrapPluginDir, 'work')

log.debug "twitterbootstrapPluginDir: ${twitterbootstrapPluginDir}"
log.debug "configCustomDir: ${configCustomDir}"
log.debug "dirLessSource: ${dirLessSource}"
log.debug "dirTarget: ${dirTarget}"

FileUtils.forceMkdir(dirTarget)
FileUtils.copyDirectory(dirLessSource, dirTarget)

if (configCustomDir) {
    try {
        def dirCustomSource = applicationContext.getResource(configCustomDir).file
        log.debug "dirCustomSource: ${dirCustomSource}"
        FileUtils.copyDirectory(dirCustomSource, dirTarget)
    } catch (Exception e) {
        log.debug "Cannot find resource ${configCustomDir}", e
    }
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

    'bootstrap-responsive-css' {
        defaultBundle configDefaultBundle
        dependsOn 'bootstrap-css'

        resource url:[plugin: 'twitter-bootstrap', dir: 'css', file: (dev ? 'bootstrap-responsive.css' : 'bootstrap-responsive.min.css')], disposition: 'head', exclude:'minify'
    }

    'bootstrap-alert' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-alert.js']
    }

    'bootstrap-dropdown' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-dropdown.js']
    }

    'bootstrap-modal' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-modal.js']
    }

    'bootstrap-popover' {
        defaultBundle configDefaultBundle
        dependsOn 'bootstrap-tooltip'
        
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-popover.js']
    }

    'bootstrap-scrollspy' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-scrollspy.js']
    }

    'bootstrap-tab' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-tab.js']
    }

    'bootstrap-tooltip' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-tooltip.js']
    }

    'bootstrap-button' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-button.js']
    }

    'bootstrap-carousel' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-carousel.js']
    }

    'bootstrap-typeahead' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-typeahead.js']
    }

    'bootstrap-collapse' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-collapse.js']
    }

    'bootstrap-transition' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-transition.js']
    }

    'bootstrap-js' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        dependsOn 'bootstrap-transition,bootstrap-alert,bootstrap-dropdown,bootstrap-modal,bootstrap-scrollspy,bootstrap-tab,bootstrap-tooltip,bootstrap-popover,bootstrap-button,bootstrap-carousel,bootstrap-typeahead,bootstrap-collapse'
    }

    'bootstrap-less' {
        defaultBundle configDefaultBundle
        if (configTagLib) {
            dependsOn 'bootstrap-fixtaglib'
        }
        resource id:'bootstrap-less', url:[plugin: 'twitter-bootstrap', dir: 'work', file: 'bootstrap.less'], attrs:[rel: "stylesheet/less", type:'css'], disposition: 'head'
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
