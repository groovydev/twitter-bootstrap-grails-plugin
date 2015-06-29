# Bootstrap CSS  for Grails
## CSS framework as Grails plugin

## Grails 3 Compatibility
Latest 3.3.5-SNAPSHOT comes with Grails 3 compatibility and bootstrap upgraded to v3.3.5

Usage in `build.gradle`:  

```  
compile "org.grails.plugins:twitter-bootstrap:3.3.5-SNAPSHOT"
```

### Notes:
 1. No support for resources plugin
 2. Initial commit misses less support. Working on it.
 3. Removed deprecated copy-twitterbootstrap command.


## Grails 2.* Usage
Provides Bootstrap CSS framework resource files.

Use in `BuildConfig.groovy`
```groovy
plugins {
    /// whatever
    runtime ':twitter-bootstrap:$version' // current: 3.3.5
    // else whatever
}
```

# Description

Bootstrap is a toolkit for kickstarting CSS for websites, apps, and more. It includes base CSS styles for typography, forms, buttons, tables, grids, navigation, alerts, and more.

To get started -- checkout http://twbs.github.io/bootstrap !

# Including the resources with Asset-Pipeline plugin

The recommended way is to use the [asset-pipeline plugin](http://grails.org/plugin/asset-pipeline) (minimal 0.1.7). It is
the default since Grails 2.4.0 and replaces the resources plugin.

To include your bootstrap resources add the following to your application's css
or js file.

Javascript `grails-app/assets/javascripts/application.js`:
```javascript
//= require bootstrap

console.log("My javascript goes here");
```

Stylesheet `grails-app/assets/javascripts/application.css`:
```css
/*
*= require bootstrap
*/
```

## LESS Support
LESS Is also available if [less-asset-pipeline](http://grails.org/plugin/less-asset-pipeline) plugin is used.

1. Install the `less-asset-pipeline` plugin
2. Add the following to `Config.groovy` to optimize compilation

   ```groovy
   grails.assets.less.compile = 'less4j'
   grails.assets.plugin."twitter-bootstrap".excludes = ["**/*.less"]
   grails.assets.plugin."twitter-bootstrap".includes = ["bootstrap.less"]
   ```
3. Create `grails-app/assets/stylesheets/custom-bootstrap.less`:

   ```css
   @import "bootstrap.less";
   ```
   and override variables in this file.

4. Import the `custom-bootstrap.less` in `application.css`:

   ```css
   /*
    *= require custom-bootstrap
    */
   ```

## Template

Since its the default for 2.4.0 you will not have to do anything in that version.
However, if you are using < 2.4.0 and the asset-pipeline plugin, double check if any of the assets include a bootstrap required files (css or/and javascript).

## Layout

Your `grails-app/views/layouts/main.gsp`:
```gsp
<!DOCTYPE html>
<html>
<head>
    <title><g:layoutTitle default="Grails"/></title>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>
<body>
    <g:layoutBody/>
    <asset:javascript src="application.js"/>
</body>
</html>
```

# Resources plugin

You may also use the Grails resources framework to make use of this plugin. The resources exposed
by this plugin are:

    bootstrap-js - all javascript resources
    bootstrap-css - all css resources

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

    bootstrap - all bootstrap css (or less) and javascript resources

A bootstrap resource depends on `bootstrap-css` and `bootstrap-js`.

## Usage in Grails Resources support

Declare bootstrap resource module in GSP page header:
```gsp
<r:require modules="bootstrap"/>
```

## Usage in GSP page with Resource support
```gsp
<html>
    <head>
        <meta name="layout" content="main"/>
        <r:require modules="bootstrap"/>
    </head>
<body>
    <h1> Hello World </h1>
</body>
</html>
```

## Edit your Sitemesh layout

Your `grails-app/views/layouts/main.gsp`:
```gsp
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
```

## LESS support

To use less you must use the `asset-pipeline` plugin, since the less plugins for
resources ([less-resources](http://grails.org/plugin/less-resources) and [lesscss-resources](http://grails.org/plugin/lesscss-resources)) has not been updated to LESS 1.6,
which is required since Bootstrap 3.1.

# Config.groovy

Fix grails taglib `<g:paginate/>` to work with bootstrap css.
```groovy
grails.plugins.twitterbootstrap.fixtaglib = true
```

## Control plugin resources bundling.
Configuration key `grails.plugins.twitterbootstrap.defaultBundle`
Configuration values:
* `bundle_name`: bundle resources using bundle name
* `false`: disable bundling
* default value: `bundle_bootstrap`

Example in `grails-app/conf/Config.groovy`:
```groovy
grails.plugins.twitterbootstrap.fixtaglib = true
grails.plugins.twitterbootstrap.defaultBundle = 'bundle_bootstrap'
```

# Example

There is an [example grails project](http://github.com/robfletcher/twitter-bootstrap-scaffolding) that provides scaffolded views.robfletcher/twitter-bootstrap-scaffolding

# Logging

`grails.plugins.twitterbootstrap` - log category

# Versioning

Plugin version convention is `<original-twitter-boostrap-version>.<plugin-version>`


# Upgrading to 3.0.0

Bootstrap 3.0.0 is not directly compatible with Bootstrap 2. It is mobile first and
for example the span classes have been renamed to col and now behave different on
mobile, tablet and desktop - it is responsive by default and therefore the bootstrap-responsive
resources has been removed.

Divshot.com is working on a tool to help upgrading to Bootstrap 3: http://code.divshot.com/bootstrap3_upgrader/

The typeahead javascript has been removed from Bootstrap, instead Twitter Typeahead.js
is recommended as a replacement. There is a Grails plugin at http://grails.org/plugin/twitter-typeahead
which also includes Bootstrap layout.

See http://getbootstrap.com/css/ for the updated documentation.

# History

3.3.5
- Grails 3 and Bootstrap 3.3.5 upgrade

3.3.4
- Upgraded to Bootstrap 3.3.4

3.3.2.1
- Added missing less files from 3.3.2

3.3.2
- Upgraded to Bootstrap 3.3.2

3.3.1
- Upgraded to Bootstrap 3.3.1

3.3.0
- Upgraded to Bootstrap 3.3.0

3.2.0.2
- Added missing mixin less files. Less now works for Bootstrap 3.2

3.2.1
- Fixed g:paginate for Grails 2.4

3.2.0
- Upgraded to Bootstrap 3.2.0

3.1.1.3
- Support for Grails 2.4

3.1.1
- Upgraded to Bootstrap 3.1.1

3.1.0
- Upgraded to Bootstrap 3.1.0

3.0.3
- Upgraded to Bootstrap 3.0.3

3.0.2
- Upgraded to Bootstrap 3.0.2

3.0.1
- Upgraded to Bootstrap 3.0.1

3.0.0
- Upgraded to Bootstrap 3.0.0

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

# Copyright and License


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


Bootstrap CSS files:

    Copyright 2011 Twitter, Inc.

    Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law
