def log = org.slf4j.LoggerFactory.getLogger('grails.plugins.twitterbootstrap.BootstrapResources')
def dev = grails.util.GrailsUtil.isDevelopmentEnv()

def pluginManager = grails.util.Holders.pluginManager
def lesscssPlugin = pluginManager.getGrailsPlugin('lesscss-resources') || pluginManager.getGrailsPlugin('less-resources')
def jqueryPlugin = pluginManager.getGrailsPlugin('jquery')
def configTagLib = grails.util.Holders.config.grails.plugins.twitterbootstrap.fixtaglib
def configDefaultBundle = grails.util.Holders.config.grails.plugins.twitterbootstrap.defaultBundle
if (!configDefaultBundle && !configDefaultBundle.equals(false)) {
    configDefaultBundle = 'bundle_bootstrap'
}

def dirLessSource
def dirTarget 

log.debug "dirLessSource: ${dirLessSource}"
log.debug "dirTarget: ${dirTarget}"

def cssFile = "bootstrap.css"
def cssminFile = "bootstrap.min.css"

log.debug "config: grails.plugins.twitterbootstrap.fixtaglib = ${configTagLib}"
log.debug "config: grails.plugins.twitterbootstrap.defaultBundle = ${configDefaultBundle}"

log.debug "is lesscss-resources plugin loaded? ${!!lesscssPlugin}"
log.debug "is jquery plugin loaded? ${!!jqueryPlugin}"

modules = {

    'bootstrap-fixtaglib' {
        defaultBundle 'fixtaglib'
        
        resource id: 'bootstrap-fixtaglib', url:[plugin: 'twitter-bootstrap', dir: 'css', file: 'bootstrap-fixtaglib.css'], disposition: 'head'
    }

    'bootstrap-css' {
        defaultBundle configDefaultBundle
        if (configTagLib) {
            dependsOn 'bootstrap-fixtaglib'
        }
        
        resource id: 'bootstrap-css', url:[plugin: 'twitter-bootstrap', dir: 'css', file: (dev ? cssFile : cssminFile)], disposition: 'head', exclude:'minify'
    }

    'bootstrap-theme-css' {
        resource id: 'bootstrap-theme-css', url:[plugin: 'twitter-bootstrap', dir: 'css', file: (dev ? 'bootstrap-theme.css' : 'bootstrap-theme.min.css')], disposition: 'head', exclude:'minify'
    }

    'bootstrap-alert' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource id: 'bootstrap-alert', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-alert.js']
    }

    'bootstrap-affix' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource id: 'bootstrap-affix', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-affix.js']
    }

    'bootstrap-dropdown' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource id: 'bootstrap-dropdown', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-dropdown.js']
    }

    'bootstrap-modal' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        
        resource id: 'bootstrap-modal', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-modal.js']
    }

    'bootstrap-popover' {
        defaultBundle configDefaultBundle
        dependsOn 'bootstrap-tooltip'
        
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource id: 'bootstrap-popover', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-popover.js']
    }

    'bootstrap-scrollspy' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        
        resource id: 'bootstrap-scrollspy', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-scrollspy.js']
    }

    'bootstrap-tab' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource id: 'bootstrap-tab', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-tab.js']
    }

    'bootstrap-tooltip' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource id: 'bootstrap-tooltip', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-tooltip.js']
    }

    'bootstrap-button' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource id: 'bootstrap-button', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-button.js']
    }

    'bootstrap-carousel' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource id: 'bootstrap-carousel', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-carousel.js']
    }

    'bootstrap-collapse' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource id: 'bootstrap-collapse', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-collapse.js']
    }

    'bootstrap-transition' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource id: 'bootstrap-transition', url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-transition.js']
    }

    'bootstrap-js' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        dependsOn 'bootstrap-transition,bootstrap-alert,bootstrap-dropdown,bootstrap-modal,bootstrap-scrollspy,bootstrap-tab,bootstrap-tooltip,bootstrap-popover,bootstrap-button,bootstrap-carousel,bootstrap-collapse,bootstrap-affix'
    }

    'bootstrap-less' {
        defaultBundle configDefaultBundle
        if (configTagLib) {
            dependsOn 'bootstrap-fixtaglib'
        }
        
        resource id:'bootstrap-less', url:[plugin: 'twitter-bootstrap', dir: 'less', file: 'bootstrap.less'], attrs:[rel: "stylesheet/less", type:'css', order:100], disposition: 'head'
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
