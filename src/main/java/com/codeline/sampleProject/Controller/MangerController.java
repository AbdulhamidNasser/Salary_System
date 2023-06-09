package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Manager;
import com.codeline.sampleProject.RequestObject.getManagerRequestObject;
import com.codeline.sampleProject.ResponseObject.GetManagerResponse;
import com.codeline.sampleProject.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MangerController {

    @Autowired
    ManagerService managerservice;

    @RequestMapping("manager/create")
    public void saveManager (@RequestBody getManagerRequestObject managerRequestObject)
    {
        createManager(managerRequestObject);
    }

    @RequestMapping("manager/get")
    public List<Manager> getmanager ()
    {
        return managerservice.getManager();
    }


    @RequestMapping("manager/get/{managerId}")
    public GetManagerResponse createManager (@PathVariable Integer managerId)
    {
        return managerservice.getManagerById(managerId);
    }

    public void createManager(getManagerRequestObject managerRequestObject)
    {
        Manager manager = new Manager();
        manager.setCreated_Date(new Date());
        manager.setTeamName("AGILE");
        manager.setDepartment("Ooredoo IT DEP");
        manager.setIS_Active(true);
        managerservice.saveManager(manager);
    }
}
