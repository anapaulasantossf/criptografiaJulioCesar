package com.codenation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codenation.data.CustomResponseWrapper;
import com.codenation.data.DadosCriptografia;
import com.codenation.data.ErrorCripto;
import com.codenation.data.FormWrapper;
import com.codenation.service.CriptografiaService;

@RestController
//@RequestMapping("https://api.codenation.dev/v1/challenge/dev-ps")
@RequestMapping("juliocesar/")
//@RequestMapping(value = { "/test" }, method = { RequestMethod.POST })
public class CriptografiaController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	CriptografiaService criptografiaService;
	

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> uploadFileHandler(
	            @RequestParam("file") MultipartFile file,
	            HttpServletRequest request,
	            HttpServletResponse response) {

	    if (!file.isEmpty()) {
	        try {
	            byte[] bytes = file.getBytes();

	            // Create the file on server
	            File serverFile = new File("C:\\Users\\anaferreira\\Desktop\\answer.json");
	            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	            stream.write(bytes);
	            stream.close();

	            System.out.println("Server File Location=" + serverFile.getAbsolutePath());

	            return null;
	        } catch (Exception e) {
	            return null;
	        }
	    }
		return null;
	}
	
	@PostMapping
	@RequestMapping("/upload")
	public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file) 
	{
	    if (file.isEmpty()) {
	        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	    } else {
	    	return null;
	    }
	}

	@PostMapping("/decriptar")
	public DadosCriptografia decriptar(@RequestBody DadosCriptografia dadosCriptografia) {

		DadosCriptografia returnDadosCriptografia = null;
		try {
			returnDadosCriptografia = criptografiaService.decriptar(dadosCriptografia);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return returnDadosCriptografia;
	}

	@PostMapping("/api/upload/multi/model")
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, consumes = { "multipart/form-data" })
	Callable<ResponseEntity<?>> write(@RequestParam("file") MultipartFile file)	throws Exception {
		
			File fileForEmployee = fileFor();

			try (InputStream in = file.getInputStream(); OutputStream out = new FileOutputStream(fileForEmployee)) {
				FileCopyUtils.copy(in, out);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			return null;

			//URI location = fromCurrentRequest().buildAndExpand(id).toUri();

			//return ResponseEntity.created(location).build();
		
	}

	private File fileFor() {
		return new File("C:\\Users\\anaferreira\\Desktop\\answer.json");
	}
	
	@PostMapping("/api/upload/multi/model")
	public ResponseEntity<?> multiUploadFileModel(@ModelAttribute FormWrapper model) {
	    try {
	        // Save as you want as per requiremens
	    	criptografiaService.saveUploadedFile(model.getFile());
	        //formRepo.save(mode.getTitle(), model.getDescription());
	    } catch (IOException e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
	}

}
