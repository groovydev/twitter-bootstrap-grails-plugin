import org.codehaus.groovy.grails.commons.ApplicationHolder

eventAssetPrecompileStart = { assetConfig ->
	def grailsApplication = ApplicationHolder.getApplication()
	if(!grailsApplication.config.grails.assets.plugin."twitter-bootstrap".excludes || grailsApplication.config.grails.assets.plugin."twitter-bootstrap".excludes.size() == 0) {
		grailsApplication.config.grails.assets.plugin."twitter-bootstrap".excludes = ["**/*.less"]
	}
}
