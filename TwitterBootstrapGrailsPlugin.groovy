class TwitterBootstrapGrailsPlugin {
    // the plugin version
    def version = "0.2"
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
    def title = "Twitter Bootstrap CSS framework resource files"
    def description = '''\\
Provides Twitter Bootstrap CSS framework resource files.

Bootstrap is Twitter's toolkit for kickstarting CSS for websites, apps, and more. It includes base CSS styles for typography, forms, buttons, tables, grids, navigation, alerts, and more.

To get started -- checkout http://twitter.github.com/bootstrap!

Including the resources

You must use the Grails resources framework to make use of this plugin. The resources exposed by this plugin are:

    bootstrap - twitter bootstrap css (version 1.2.0)

Usage

<r:require modules="bootstrap"/>


Copyright and License

Copyright 2011 Twitter, Inc.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/twitter-bootstrap"

}
