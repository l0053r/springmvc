package com.karan.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.karan.springmvc.model.customer;

@Component
public class customerValidator implements Validator {
public static final String JPEG_MIME_TYPE="image/jpeg";
public static final String PNG_MIME_TYPE="image/png";
public static final long FIFTY_KB_IN_BYTES =51200;
	@Override
	public boolean supports(Class<?> clazz) {
		return customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		customer cust = (customer)target;
		MultipartFile file = cust.getFile();
		System.out.println(file.getContentType());
		if(file.isEmpty()) {
			errors.rejectValue("file", "upload.file.required");
		}else if(!PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType()) && !JPEG_MIME_TYPE.equalsIgnoreCase(file.getContentType())) {
			errors.rejectValue("file", "upload.invalid.file.type");
		}else if(file.getSize()>FIFTY_KB_IN_BYTES) {
			errors.rejectValue("file", "upload.exceeded.file.size");
		}
	}

}
