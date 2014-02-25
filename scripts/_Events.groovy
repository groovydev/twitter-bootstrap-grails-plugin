eventAssetPrecompileStart = { assetConfig ->
	if(!config.grails.assets.plugin."twitter-bootstrap".excludes || config.grails.assets.plugin."twitter-bootstrap".excludes.size() == 0) {
		config.grails.assets.plugin."twitter-bootstrap".excludes = ["**/*.less"]
	}
}
