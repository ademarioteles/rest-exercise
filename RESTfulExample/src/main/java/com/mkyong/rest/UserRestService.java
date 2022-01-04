package com.mkyong.rest;



import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/app")
public class UserRestService {


	@GET
	@Path("{param1}/{param2}/{param3}")
	//Criacao de um parametro header 
	public Response getUserHistory(@HeaderParam("chave-acesso") String userAgent) {
		return Response.ok().header("chave-acesso", "key12345").entity("").build();
	
	}

	@GET
	@Path("{param1}/{param2}/{param3}")
	public Response getUserHistory(@HeaderParam("chave-acesso") String userAgent, @PathParam("param1") String param1,
			@PathParam("param2") int param2, @PathParam("param3") Long param3) {

		//Serao aceitos 3 valores na URL o param3 é do tipo Long que se destina ao CPF
		String registro = "[Nome=" + param1 + ", Idade=" + param2 + ", Cpf=" + param3 +"]";

	
		//conferindo se o usuario ao acessar o REST inseriu corretamente o parametro header
		if(userAgent == "key12345"){
			return Response.status(200)
					.entity( registro)
					.build();
		}else {
			//caso tenha inserido incorretamente o parametro é retornado um erro 400
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("")
					.build();
		}
		
		}
	
	
	

	}
	