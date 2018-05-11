package controller;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

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
import org.springframework.web.multipart.MultipartFile;

import model.Invoice;
import model.User;
import service.InvoiceService;
import service.InvoiceTypeService;
import service.UserService;
import sun.misc.BASE64Decoder;





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
	
	
	@RequestMapping(value = { "/createtype" }, method = RequestMethod.POST)
	public String createtype(Principal principal, Authentication authentication,
		
	        @RequestParam(value="file", required=true) String file,
	        @RequestParam(value="name", required=true) String name
	        ) {
			this.invoiceTypeService.create(name, file);
		 	
		 return "addtype";
	   }
	@RequestMapping(value = { "/addtype" }, method = RequestMethod.GET)
	public String addtype(Principal principal, Authentication authentication
	        ) 		{
		 return "addtype";
	   }
	
	@RequestMapping(value = { "/getTypeInfor/{id}" }, method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody void getTypeInfor(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") long id) {
		try {
			response.reset();
			BASE64Decoder decoder = new BASE64Decoder();
		    response.setContentType("image/jpeg");
		    byte[] decodedBytes = decoder.decodeBuffer(this.invoiceTypeService.findbyId(id).getLogo());
		    System.out.println(decodedBytes.length);
		    response.getOutputStream().write(decodedBytes);
		} catch (IOException e) {
	        // Do something
	    }
		
	   }
	
}
