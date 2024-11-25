package com.youssef.gamal;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    @Inject
    TodoService todoService;

    @GET
    public List<TodoItem> getTodos() {
        return todoService.getAllTodos();
    }

    @GET
    @Path("/{id}")
    public Response getTodoById(@PathParam("id") Long id) {
        TodoItem todoItem = todoService.getTodoById(id);
        if (todoItem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(todoItem).build();
    }

    @POST
    public Response createTodo(TodoItem todoItem) {
        TodoItem createdTodo = todoService.createTodo(todoItem);
        return Response.status(Response.Status.CREATED).entity(createdTodo).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTodo(@PathParam("id") Long id, TodoItem todoItem) {
        TodoItem updatedTodo = todoService.updateTodo(id, todoItem);
        if (updatedTodo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedTodo).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTodo(@PathParam("id") Long id) {
        boolean deleted = todoService.deleteTodo(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
