def dev = grails.util.GrailsUtil.isDevelopmentEnv()

def applicationContext = org.codehaus.groovy.grails.commons.ApplicationHolder.application.mainContext
def lesscssPlugin = applicationContext.pluginManager.getGrailsPlugin('lesscss-resources')
def configTagLib = org.codehaus.groovy.grails.commons.ApplicationHolder.application.config.grails.plugins.twitterbootstrap.fixtaglib
def cssVersion = '1.2.0' 
def cssFile = "bootstrap-${cssVersion}.css"
def cssminFile = "bootstrap-${cssVersion}.min.css"
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

    bootstrap {
        if (configTagLib) {
            dependsOn 'bootstrap-fixtaglib'
        }
        resource url:[plugin: 'twitter-bootstrap', dir: 'css', file: file], attrs:attrs, disposition: 'head', exclude:'minify', bundle: 'bundle_bootstrap'
    }

    'bootstrap-less' {
        if (configTagLib) {
            dependsOn 'bootstrap-fixtaglib'
        }
        resource url:[plugin: 'twitter-bootstrap', dir: 'css', file: lesscssFile], attrs:[rel: "stylesheet/less", type:'css'], disposition: 'head', exclude:'minify', bundle: 'bundle_bootstrap'
    }

}