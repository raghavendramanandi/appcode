package com.ikk.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ikk.demo.Exception.InvalidModeException;
import com.ikk.demo.Exception.InvalidRequestException;
import com.ikk.demo.Request.ClickRequest;
import com.ikk.demo.Util.Util;
import com.ikk.demo.dao.DeviceDAO;
import com.ikk.demo.dao.MessageDAO;
import com.ikk.demo.data.encryption.Encryper;
import com.ikk.demo.data.encryption.Generator;
import com.ikk.demo.model.DeviceEntity;
import com.ikk.demo.response.ErrorResponse;
import com.ikk.demo.response.Response;
import com.ikk.demo.response.SuccessResponse;
import com.ikk.demo.response.SuccessResponseTypeA;
import com.ikk.demo.response.SuccessResponseTypeB;

@Service
public class ClickServiceImple implements ClickService{
	@Autowired
	MessageDAO mDao;
	
	@Autowired
	DeviceDAO dDao;
	
	@Autowired
	Generator generator;
	
	@Autowired
	Encryper encryper;

	public Response ClickAction(Integer id, ClickRequest postData){
		
		//This segment of code will never fail
		boolean [] generatedData = generator.getRandomNumber(128);
		System.out.println(generatedData);
		String encryptedData = Util.GetString(encryper.getEncryptedValue(generatedData));
		
		try {
			DeviceEntity device = dDao.getDeviceById(id);
			authorizeClick(postData, device);
			device.setSecurityCode(encryptedData);
			dDao.saveOrUpdate(device);
			String mode = device.getOperationMode();
			System.out.println("GeneratedData: " + generatedData);
			return resolveResponseFor(generatedData, device, mode);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorResponse("500");
		}
	}

	private void authorizeClick(ClickRequest postData, DeviceEntity device) throws InvalidRequestException {
		if(!device.getSecurityCode().equals(postData.getCode())){
			throw new InvalidRequestException();
		}
	}

	private Response resolveResponseFor(boolean[] generatedData, DeviceEntity device, String mode)
			throws InvalidModeException {
		if (mode.equalsIgnoreCase("NORMAL")) {
			return new SuccessResponse("200", Util.GetString(generatedData));
		}
		else if (mode.equalsIgnoreCase("SETPASSWORDA")){
			return new SuccessResponseTypeA("200", Util.GetString(generatedData), device.getConnName(),
					device.getConnPassword());
		}
		else if (mode.equalsIgnoreCase("SETPASSWORDB")){
			return new SuccessResponseTypeB("200", Util.GetString(generatedData), device.getConnName(), device.getConnPassword());
		}
		else{
			throw new InvalidModeException();
		}
	}
	
	private void display(boolean[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]?'1':'0');
		}
		System.out.println();
	}
}
