package org.osgi.core.kt.tests

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object BundleTests: Spek({
    describe("Something") {
        it("should do a thing") {
            println("Some test")
            assert(true)
        }
    }
})