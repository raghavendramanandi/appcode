package com.ikk.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikk.demo.Exception.DeviceCannotFindException;
import com.ikk.demo.Exception.InvalidModeException;
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

	public Response ClickAction(Integer id){
		
		//This segment of code will never fail
		boolean [] generatedData = generator.getRandomNumber(128);
		System.out.println(generatedData);
		String encryptedData = Util.GetString(encryper.getEncryptedValue(generatedData));
		
		try {
			DeviceEntity device = dDao.getDeviceById(id);
			device.setSecurityCode(encryptedData);
			dDao.saveOrUpdate(device);
			String mode = device.getOperationMode();
			System.out.println("Operation mode is" + mode + "Result: " + mode == "NORMAL");
			if (mode == "NORMAL") {
				return new SuccessResponse("200", "Success", Util.GetString(generatedData));
			}
			else if (mode == "SETPASSWORDA"){
				return new SuccessResponseTypeA("200", "Success", Util.GetString(generatedData), device.getConnName(),
						device.getConnPassword());
			}
			else if (mode == "SETPASSWORDB"){
				return new SuccessResponseTypeB("200", "Success", Util.GetString(generatedData), device.getConnName());
			}
			else{
				throw new InvalidModeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorResponse("Error", "200","");
		}
	}
}
