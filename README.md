Grails plugin: Twitter Bootstrap CSS framework resource files
===============================================

Provides Twitter Bootstrap CSS framework resource files.

Bootstrap is Twitter's toolkit for kickstarting CSS for websites, apps, and more. It includes base CSS styles for typography, forms, buttons, tables, grids, navigation, alerts, and more.

To get started -- checkout http://twitter.github.com/bootstrap!

Including the resources
------------------------

You must use the Grails resources framework to make use of this plugin. The resources exposed by this plugin are:

    bootstrap-js - all javascript resources
    bootstrap-css - all css resources (without responsive css)

    bootstrap-responsive-css - bootstrap responsive css resource
    bootstrap-responsive-less - bootstrap responsive less resource (use one or the other)

    bootstrap-alert - bootstrap alerts javascript resource
    bootstrap-affix - bootstrap affix javascript resource
    bootstrap-dropdown - bootstrap dropdown javascript resource
    bootstrap-modal - bootstrap modal javascript resource
    bootstrap-popover - bootstrap popover javascript resource
    bootstrap-scrollspy - bootstrap scrollspy javascript resource
    bootstrap-tab - bootstrap tabs javascript resource
    bootstrap-tooltip - bootstrap tooltips javascript resource
    bootstrap-button - bootstrap buttons javascript resource
    bootstrap-carousel - bootstrap carousel javascript resource
    bootstrap-typeahead - bootstrap typeahead javascript resource
    bootstrap-collapse - bootstrap collapse javascript resource
    bootstrap-transition - bootstrap transition javascript resource
    bootstrap-less - bootstrap less resource

    bootstrap - all bootstrap css (or less) and javascript resources, except bootstrap-responsive-css

Note
-----
A bootstrap resource depends on bootstrap-css and bootstrap-js.
If less-resources plugin is installed, bootstrap resource depends on bootstrap-less and bootstrap-js.
To use responsive css, you have to declare bootstrap-responsive-css.

Usage
-----

Declare bootstrap resource module in GSP page header:

    <r:require modules="bootstrap"/>

Edit your GSP page
------------------

    <html>
       <head>
          <meta name="layout" content="main"/>
          <r:require modules="bootstrap"/>
       </head>
    <body>
    <h1> Hello World </h1>
    </body>
    </html>


Edit your Sitemesh layout
-------------------------

Your grails-app/views/layouts/main.gsp:

    <!DOCTYPE html>
    <html lang="en">
       <head>
          <g:layoutTitle/>
          <r:layoutResources/>
       </head>
       <body>
          <g:layoutBody/>
          <r:layoutResources/>
       </body>
    </html>

Using LESS bootstrap
--------------------
If you need customize bootstrap, you cannot use precompiled CSS resource files. You need to use LESS bootstrap files and LESS resource mapper.
You can use less-resources plugin. It supports latest bootstrap and integrates fully with plugin.

http://grails.org/plugin/less-resources


Customize twitter-bootstrap
---------------------------

To use custom bootstrap less, you need copy custom files to 'web-app/less'. Any file in this
directory will override original bootstrap. Usually, one customize variables.less in 'web-app/less'.

Add custom-bootstrap.less file to /web-app/less/ directory:

    @import "bootstrap.less";

Add 'custom-bootstrap' resource module to Config.groovy:

    grails.resources.modules = {

        'custom-bootstrap' {
            dependsOn 'bootstrap'
            resource url:[dir: 'less', file: 'custom-bootstrap.less'], attrs:[rel: "stylesheet/less", type:'css']
        }

    }

Prepare customized variables.less file and copy to /web-app/less/ directory. You can use original variables.less
as base file (https://github.com/twitter/bootstrap/blob/v2.0.2/less/variables.less).


Config.groovy
-------------

Fix grails taglib g:paginate to work with bootstrap css.
 
    grails.plugins.twitterbootstrap.fixtaglib = true
    
Control plugin resources bundling.

    Configuration key:
    grails.plugins.twitterbootstrap.defaultBundle

    Configuration values:
        'bundle_name': bundle resources using bundle name
        false: disable bundling
        default value: 'bundle_bootstrap'

Example in grails-app/conf/Config.groovy:

    grails.plugins.twitterbootstrap.fixtaglib = true
    grails.plugins.twitterbootstrap.defaultBundle = 'bundle_bootstrap'


Example
-------
There is an [example grails project](http://github.com/robfletcher/twitter-bootstrap-scaffolding) that provides scaffolded views.robfletcher/twitter-bootstrap-scaffolding

Logging
-------

    grails.plugins.twitterbootstrap - log category


Versioning
----------

    Plugin version convention is <original-twitter-boostrap-version>.<plugin-version>

History
-------
2.3.2
- Upgraded to Bootstrap 2.3.2
    
2.3.1
- Upgraded to Bootstrap 2.3.1
    
2.3.0
- Upgraded to Bootstrap 2.3.0
    
2.2.2
- Fixed #50 and #51. Pagination now supports the mapping attribute and the plugin should no longer include the old grails style.
- Upgraded Bootstrap to 2.2.2.

2.2.1
- Upgraded Bootstrap to 2.2.1.

2.2.0
- Upgraded Bootstrap to 2.2.0.

2.1.1
- Upgraded Bootstrap to 2.1.1.

2.1.0.1
- Fixed resources dependency
	
2.1.0
- Upgraded Bootstrap to 2.1.0.
- Removed grails-style scaffolding

2.0.4
- Upgraded Bootstrap to v2.0.4 and Grails to 2.1.0

2.0.1.24
- Upgrade bootstrap to v2.0.2 and add some minor taglib fixes
- Added support for less-resources plugin, in order to compile bootstrap v2.0.2
- Improved less customization
- Deprecated copy-twitterbootstrap script

2.0.1.21
- Added support for custom less files

2.0.1.17
- Upgrade to twitter bootstrap v2.0.1.

2.0.0.15
- Upgrade to twitter bootstrap v2.0.0.

1.4.0.14
- Latest stable plugin edition with twitter-bootstrap v1.4.0
- Plugin documentation for v1.4.0.14 https://github.com/groovydev/twitter-bootstrap-grails-plugin/blob/v1.4.0.14/README.md

Copyright and License
---------------------

twitter-bootstrap plugin:

   Copyright 2011 Karol Balejko

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.


Twitter Bootstrap CSS files:

    Copyright 2011 Twitter, Inc.
    
    Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law
