package controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.InvoiceType;
import service.InvoiceService;
import service.InvoiceTypeService;
import service.UserService;





@Controller
public class InvoiceController {
	@Autowired
	 @Qualifier("userService")
	 UserService userService;
	@Autowired
	 @Qualifier("invoiceService")
	 InvoiceService invoiceService;
	
	@Autowired
	 @Qualifier("invoiceTypeService")
	InvoiceTypeService invoiceTypeService;
	
		
	
	@RequestMapping(value = { "/getTypeInfor/{id}" }, method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody void getTypeInfor(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") long id) {
		try {
			response.reset();
		 //   response.setContentType("image/jpeg");
		    byte[] decodedBytes = Base64.getDecoder().decode(this.invoiceTypeService.findbyId(id).getLogo());
		    response.getOutputStream().write(decodedBytes);
		} catch (IOException e) {
	        // Do something
	    }
		
	   }
	
}
