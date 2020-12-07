package com.example.web

import com.example.port.dto.CustomerDTO
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.ws.rs.*
import javax.ws.rs.core.MediaType


@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "crm")
interface CustomersResource {

    @GET
    @Operation(operationId = "listCustomers", description = "List Customers")
    fun list(): List<CustomerDTO>

    @GET
    @Path("{id}")
    @Operation(operationId = "getCustomer", description = "Get Single Customer")
    fun fetch(@PathParam("id") id: Int): CustomerDTO

    @POST
    @Operation(operationId = "createCustomer", description = "Add Customer")
    fun add(): CustomerDTO

    @DELETE
    @Path("{id}")
    @Operation(operationId = "deleteCustomer", description = "Delete Customer")
    fun delete(@PathParam("id") id: Int): List<CustomerDTO>
}