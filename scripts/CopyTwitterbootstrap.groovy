import grails.util.BuildSettings
import grails.util.BuildSettingsHolder

includeTargets << grailsScript("Init")
includeTargets << grailsScript("_GrailsArgParsing")

target(main: "The description of the script goes here!") {
    parseArguments()
    def args = argsMap.params
    
    if (args.size() != 1) {
        println "usage: grails copy-twitterbootstrap [target-dir]"
        return
    }

    def dir = args[0]
    def srcDir = "${twitterBootstrapPluginDir}/web-app/less/"
    def destDir = "${BuildSettingsHolder.settings.baseDir}/web-app/${dir}"
    
    ant.mkdir(dir: destDir)
    ant.copydir(src: srcDir, dest:destDir)

    println "To activate custom twitter-bootstrap files, add configuration line to Config.groovy:"
    println "grails.plugins.twitterbootstrap.customDir = '${dir}'"
}

setDefaultTarget(main)
