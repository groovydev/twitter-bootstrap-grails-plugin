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

    bootstrap-alert - bootstrap alerts javascript resource
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

    bootstrap - all bootstrap css (or less) and javascript resources 

Note 
-----
A bootstrap resource depends on bootstrap-css and bootstrap-js. 
In case of lesscss-resources plugin is installed, bootstrap resource depends on bootstrap-less and bootstrap-js.   

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

    <html>
       <head>
          <g:layoutTitle/>
          <r:layoutResources/>
       </head>
       <body>
          <g:layoutBody/>
          <r:layoutResources/>
       </body>
    </html>


Customize twitter-bootstrap
---------------------------

Run script copy-twitterbootstrap with dir name to make copy of original bootstrap less files:

    $ grails copy-twitterbootstrap twitterbootstrap

It copy original less files to 'web-app/twitterbootstrap'. Any file in this dir will override original file.
Now, you can customize variables.less in 'web-app/twitterbootstrap'.

To activate custom less files, add line to grails-app/conf/Config.groovy:

    grails.plugins.twitterbootstrap.customDir = 'twitterbootstrap'


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

Logging
-------

    grails.plugins.twitterbootstrap - log category
    
Versioning
----------

    Plugin version convention is <original-twitter-boostrap-version>.<plugin-version>

History
-------

2.0.1.20
    Added support for custom less files

2.0.1.17
    Upgrade to twitter bootstrap v2.0.1.

2.0.0.15
    Upgrade to twitter bootstrap v2.0.0.

1.4.0.14
    Latest stable plugin edition with twitter-bootstrap v1.4.0
    Plugin documentation for v1.4.0.14 https://github.com/groovydev/twitter-bootstrap-grails-plugin/blob/v1.4.0.14/README.md

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
