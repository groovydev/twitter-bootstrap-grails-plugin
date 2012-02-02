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

    'bootstrap-alert' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-alert.js'], disposition: 'head'
    }
	
	'bootstrap-button' {
		defaultBundle configDefaultBundle
		if (jqueryPlugin) {
			dependsOn "jquery"
		}
		
		resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-button.js'], disposition: 'head'
	}

	'bootstrap-carousel' {
		defaultBundle configDefaultBundle
		if (jqueryPlugin) {
			dependsOn "jquery"
		}
		
		resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-carousel.js'], disposition: 'head'
	}

	'bootstrap-collapse' {
		defaultBundle configDefaultBundle
		if (jqueryPlugin) {
			dependsOn "jquery"
		}
		
		resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-collapse.js'], disposition: 'head'
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

    'bootstrap-tab' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-tab.js'], disposition: 'head'
    }

	'bootstrap-tooltip' {
		defaultBundle configDefaultBundle
		if (jqueryPlugin) {
			dependsOn "jquery"
		}
		
		resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-tooltip.js'], disposition: 'head'
	}
	
	'bootstrap-transition' {
		defaultBundle configDefaultBundle
		if (jqueryPlugin) {
			dependsOn "jquery"
		}
		
		resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-transition.js'], disposition: 'head'
	}
	
    'bootstrap-twipsy' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-twipsy.js'], disposition: 'head'
    }
	
	'bootstrap-typeahead' {
		defaultBundle configDefaultBundle
		if (jqueryPlugin) {
			dependsOn "jquery"
		}
		
		resource url:[plugin: 'twitter-bootstrap', dir: 'js', file: 'bootstrap-typeahead.js'], disposition: 'head'
	}

    'bootstrap-js' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        dependsOn 'bootstrap-alert,bootstrap-button,bootstrap-carousel,bootstrap-collapse,bootstrap-dropdown,bootstrap-modal,bootstrap-popover,bootstrap-scrollspy,bootstrap-tab,bootstrap-tooltip,bootstrap-transition,bootstrap-twipsy,bootstrap-typeahead'
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
