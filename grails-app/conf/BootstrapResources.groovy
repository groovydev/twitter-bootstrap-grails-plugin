def dev = grails.util.GrailsUtil.isDevelopmentEnv()

def applicationContext = org.codehaus.groovy.grails.commons.ApplicationHolder.application.mainContext
def lesscssPlugin = applicationContext.pluginManager.getGrailsPlugin('lesscss-resources')
def configTagLib = org.codehaus.groovy.grails.commons.ApplicationHolder.application.config.grails.plugins.twitterbootstrap.fixtaglib
def cssFile = "bootstrap.css"
def cssminFile = "bootstrap.min.css"
def lesscssFile = "bootstrap.less"

def file
def attrs

if (lesscssPlugin != null) {
    file = lesscssFile
    attrs = [rel: "stylesheet/less", type:'css']
} else {
    file = (dev ? cssFile : cssminFile)
    attrs = [:]
}

modules = {

    'bootstrap-fixtaglib' {
        resource url:[plugin: 'twitter-bootstrap', dir: 'css', file: 'bootstrap-fixtaglib.css'], disposition: 'head', exclude:'minify', bundle: 'bundle_bootstrap'
    }

    'bootstrap-css' {
        if (configTagLib) {
            dependsOn 'bootstrap-fixtaglib'
        }
        resource url:[plugin: 'twitter-bootstrap', dir: 'css', file: file], attrs:attrs, disposition: 'head', exclude:'minify', bundle: 'bundle_bootstrap'
    }

    'bootstrap-alerts' {
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-alerts.js'], attrs:attrs, disposition: 'head', bundle: 'bundle_bootstrap'
    }

    'bootstrap-dropdown' {
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-dropdown.js'], attrs:attrs, disposition: 'head', bundle: 'bundle_bootstrap'
    }

    'bootstrap-modal' {
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-modal.js'], attrs:attrs, disposition: 'head', bundle: 'bundle_bootstrap'
    }

    'bootstrap-popover' {
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-popover.js'], attrs:attrs, disposition: 'head', bundle: 'bundle_bootstrap'
    }

    'bootstrap-scrollspy' {
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-scrollspy.js'], attrs:attrs, disposition: 'head', bundle: 'bundle_bootstrap'
    }

    'bootstrap-tabs' {
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-tabs.js'], attrs:attrs, disposition: 'head', bundle: 'bundle_bootstrap'
    }

    'bootstrap-twipsy' {
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-twipsy.js'], attrs:attrs, disposition: 'head', bundle: 'bundle_bootstrap'
    }

    'bootstrap-js' {
        dependsOn 'bootstrap-alerts,bootstrap-dropdown,bootstrap-modal,bootstrap-popover,bootstrap-scrollspy,bootstrap-tabs,bootstrap-twipsy'
    }

    bootstrap {
        if (configTagLib) {
            dependsOn 'bootstrap-css,bootstrap-js'
        }
    }

    'bootstrap-less' {
        if (configTagLib) {
            dependsOn 'bootstrap-fixtaglib'
        }
        resource url:[plugin: 'twitter-bootstrap', dir: 'css', file: lesscssFile], attrs:[rel: "stylesheet/less", type:'css'], disposition: 'head', exclude:'minify', bundle: 'bundle_bootstrap'
    }

}