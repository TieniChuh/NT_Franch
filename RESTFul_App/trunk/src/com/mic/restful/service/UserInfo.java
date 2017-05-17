/*
 * Creation : Apr 20, 2017
 */
package com.mic.restful.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.mic.restful.cache.UserCache;
import com.mic.restful.entity.User;
import com.mic.restful.warpper.ListWarpper;
import com.sun.jersey.api.NotFoundException;

// @Path here defines class level path. Identifies the URI path that
// a resource class will serve requests for.
@Path("UserInfoService")
public class UserInfo {

    // @GET here defines, this method will method will process HTTP GET
    // requests.
    @GET
    // @Path here defines method level path. Identifies the URI path that a
    // resource class method will serve requests for.
    @Path("/name/{i}")
    // @Produces here defines the media type(s) that the methods
    // of a resource class can produce.
    @Produces(MediaType.TEXT_XML)
    // @PathParam injects the value of URI parameter that defined in @Path
    // expression, into the method.
    public String userName(@PathParam("i") String i) {

        String name = i;
        return "<User>" + "<Name>" + name + "</Name>" + "</User>";
    }

    @GET
    @Path("/age/{j}")
    @Produces(MediaType.TEXT_XML)
    public String userAge(@PathParam("j") int j) {

        int age = j;
        return "<User>" + "<Age>" + age + "</Age>" + "</User>";
    }

    @Context
    UriInfo uriInfo;

    @GET
    @Path("/userList")
    @Produces(MediaType.APPLICATION_XML)
    public ListWarpper getUserList() {
        Map<String, User> useMap = UserCache.getUserCache();

        List uList = new ArrayList<User>();
        User user1 = new User("001", "zhaohongxuan", 24);
        User user = new User();
        user.setUserAge(11);
        user.setUserId("111");
        user.setUserName("1111");
        useMap.put("111", user);
        ListWarpper lw = new ListWarpper();
        uList.add(user1);
        uList.add(user);
        lw.setList(uList);
        return lw;
    }

    /**
     * 根据id查找User
     * 
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public User getUser(@PathParam("id") String id) {

        User user = UserCache.getUserCache().get(id);
        if (user == null) {
            throw new NotFoundException("No such User.");
        }
        return user;
    }

    /**
     * 增加用户
     * 
     * @param userId
     * @param userName
     * @param userAge
     * @param servletResponse
     * @throws IOException
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newUser(@FormParam("userId") String userId, @FormParam("userName") String userName, @FormParam("userAge") int userAge,
            @Context HttpServletResponse servletResponse) throws IOException {
        User user = new User(userId, userName, userAge);
        UserCache.getUserCache().put(userId, user);
        URI uri = uriInfo.getAbsolutePathBuilder().path(userId).build();
        Response.created(uri).build();
    }

    /**
     * 更新用户
     * 
     * @param jaxbContact
     * @return
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putUser(JAXBElement<User> jaxbContact, @PathParam("id") String id) {
        User user = jaxbContact.getValue();
        Response res;
        if (UserCache.getUserCache().containsKey(id)) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        UserCache.getUserCache().put(user.getUserId(), user);
        return res;
    }

    @DELETE
    @Path("/{id}")
    public void deleteContact(@PathParam("id") String id) {
        User user = UserCache.getUserCache().remove(id);
        if (user == null)
            throw new NotFoundException("No such User.");
    }

}