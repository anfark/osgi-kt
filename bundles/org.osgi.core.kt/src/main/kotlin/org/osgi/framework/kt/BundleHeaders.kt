package org.osgi.framework.kt

import org.osgi.framework.Bundle
import org.osgi.framework.Constants
import java.net.URL


/**
 * Reads the optional {Constants.BUNDLE_ACTIVATOR} attribute from the bundle headers.
 *
 * @return the name of the resource containing the bundle activator or <code>null</code> if none is used.
 */
inline var Bundle.activator: String?
    get() = headers[Constants.BUNDLE_ACTIVATOR]
    set(value) { headers.put(Constants.BUNDLE_ACTIVATOR, value)}


/**
 *  Reads the optional {Constants.BUNDLE_ACTIVATIONPOLICY} attribute from the bundle headers.
 */
inline val Bundle.activationPolicy: String?
    get() = headers[Constants.BUNDLE_ACTIVATIONPOLICY]

/**
 * Checks if the activation policiy of this bundle is lazy.
 *
 * @returns <code>true</code> if the activation policy is {Constants.ACTIVATION_LAZY}
 *
 * @see Constants.BUNDLE_ACTIVATIONPOLICY
 * @see Constants.ACTIVATION_LAZY
 */
inline val Bundle.isLazy: Boolean
    get() = activationPolicy == Constants.ACTIVATION_LAZY

/**
 * Reads the optional {Constants.BUNDLE_CATEGORY} attribute from the bundle headers.
 *
 * @see Constants.BUNDLE_CATEGORY
 */
inline val Bundle.category: String?
    get() = headers[Constants.BUNDLE_CATEGORY]


/**
 * Reads the optional {Constants.BUNDLE_CLASSPATH} attribute from the bundle headers.
 *
 * Manifest header identifying a list of directories and embedded JAR files,
 * which are bundle resources used to extend the bundle's classpath.
 *
 * @see Constants.BUNDLE_CLASSPATH
 */
inline val Bundle.classpath: String?
    get() = headers[Constants.BUNDLE_CLASSPATH]


/**
 * Reads the optional {Constants.BUNDLE_CONTACTADDRESS} attribute from the bundle headers.
 *
 * Manifest header identifying the contact address where problems with the bundle may be reported;
 * for example, an email address.
 *
 * @see Constants.BUNDLE_CONTACTADDRESS
 */
inline val Bundle.contactAddress: String?
    get() = headers[Constants.BUNDLE_CONTACTADDRESS]


/**
 * Reads the optional {Constants.BUNDLE_COPYRIGHT} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's copyright information.
 *
 * @see Constants.BUNDLE_COPYRIGHT
 */
inline val Bundle.copyright: String?
    get() = headers[Constants.BUNDLE_COPYRIGHT]

/**
 * Reads the optional {Constants.BUNDLE_DESCRIPTION} attribute from the bundle headers.
 *
 * Manifest header containing a brief description of the bundle's functionality.
 *
 * @see Constants.BUNDLE_DESCRIPTION
 */
inline val Bundle.description: String?
    get() = headers[Constants.BUNDLE_DESCRIPTION]

/**
 * Reads the optional {Constants.BUNDLE_DEVELOPERS} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's developers.
 *
 * @see Constants.BUNDLE_DEVELOPERS
 */
inline val Bundle.developers: String?
    get() = headers[Constants.BUNDLE_DEVELOPERS]


/**
 * Reads the optional {Constants.BUNDLE_DOCURL} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's documentation URL, from which further information about the bundle may be obtained.
 *
 * @see Constants.BUNDLE_DOCURL
 */
inline val Bundle.docUrl: URL?
    get() = headers[Constants.BUNDLE_DOCURL]?.let { URL(it) }

/**
 * Reads the optional {Constants.BUNDLE_ICON} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's icon URLs.
 *
 * @see Constants.BUNDLE_ICON
 */
inline val Bundle.iconUrl: URL?
    get() = headers[Constants.BUNDLE_ICON]?.let { URL(it) }

/**
 * Reads the optional {Constants.BUNDLE_LICENSE} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's license information.
 *
 * @see Constants.BUNDLE_LICENSE
 */
inline val Bundle.license: String?
    get() = headers[Constants.BUNDLE_LICENSE]

/**
 * Reads the optional {Constants.BUNDLE_LOCALIZATION} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's license information.
 *
 * If this value is not set in the headers, then {Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME} will be
 * returned instead.
 *
 * @see Constants.BUNDLE_LOCALIZATION
 * @see Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME
 */
inline val Bundle.localization: String
    get() = headers[Constants.BUNDLE_LOCALIZATION] ?: Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME



/**
 * Reads the {Constants.BUNDLE_MANIFESTVERSION} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle manifest version. A bundle manifest may express the version of the syntax in
 * which it is written by specifying a bundle manifest version. Bundles exploiting OSGi Release 4, or later, syntax must
 * specify a bundle manifest version.
 *
 * The bundle manifest version defined by OSGi Release 4 or, more specifically, by version 1.3 of the OSGi Core
 * Specification is "2".
 *
 * @see Constants.BUNDLE_MANIFESTVERSION
 */
inline val Bundle.manifestVersion: String
    get() = headers[Constants.BUNDLE_MANIFESTVERSION]


/**
 * Reads the optional {Constants.BUNDLE_NAME} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's name.
 *
 * @see Constants.BUNDLE_NAME
 */
inline val Bundle.name: String?
    get() = headers[Constants.BUNDLE_NAME]

/**
 * Reads the optional {Constants.BUNDLE_NATIVECODE} attribute from the bundle headers.
 *
 * Manifest header identifying a number of hardware environments and the native language code libraries that the bundle
 * is carrying for each of these environments.
 *
 * @see Constants.BUNDLE_NATIVECODE
 */
inline val Bundle.nativeCode: String?
    // TODO this attribute seams to be some kind of map. Maybe there's a better way in reading this value
    get() = headers[Constants.BUNDLE_NATIVECODE]


/**
 * Reads the optional {Constants.BUNDLE_SCM} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's software configuration management system.
 *
 * @see Constants.BUNDLE_SCM
 */
inline val Bundle.scm: String?
    get() = headers[Constants.BUNDLE_SCM]


/**
 * Reads the optional {Constants.BUNDLE_UPDATELOCATION} attribute from the bundle headers.
 *
 * Manifest header identifying the location from which a new bundle version is obtained during a
 * bundle update operation.
 *
 * @see Constants.BUNDLE_UPDATELOCATION
 * @see Bundle.updateLocationUrl
 */
inline val Bundle.updateLocation: String?
    get() = headers[Constants.BUNDLE_UPDATELOCATION]

/**
 * Tries to interpret the {Bundle.updateLocation} attribute of this bundle as an URL.
 *
 * @see Constants.BUNDLE_UPDATELOCATION
 */
inline val Bundle.updateLocationUrl: URL?
    get() = updateLocation?.let { URL(it) }

/**
 * Reads the optional {Constants.BUNDLE_VENDOR} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's vendor.
 *
 * @see Constants.BUNDLE_VENDOR
 */
inline val Bundle.vendor: String?
    get() = headers[Constants.BUNDLE_VENDOR]

/**
 * Reads the optional {Constants.BUNDLE_VERSION} attribute from the bundle headers.
 *
 * Manifest header identifying the bundle's version.
 *
 * @see Constants.BUNDLE_VERSION
 */
inline val Bundle.version: String?
    get() = headers[Constants.BUNDLE_VERSION]