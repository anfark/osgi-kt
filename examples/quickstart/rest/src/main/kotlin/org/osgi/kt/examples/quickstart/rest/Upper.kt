package org.osgi.kt.examples.quickstart.rest

import org.osgi.service.component.annotations.Component
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardResource
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Component(service = [Upper::class])
@JaxrsResource
@HttpWhiteboardResource(pattern = ["/quickstart/*"], prefix = "static")
class Upper {

    @GET
    @Path("rest/upper/{param}")
    fun toUpper(@PathParam("param") param: String) = param.toUpperCase()
}
