package com.company.Server;

import com.company.Shared.Commands.Command;
import com.company.Shared.Entities.Organization;
import com.company.Shared.Entities.Product;

import java.util.ArrayList;
import java.util.Vector;

public class ExecutePrintFieldAscendingManufacturer extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        StringBuilder response = new StringBuilder();
        ArrayList<Organization> ordered = new ArrayList();
        for (Product actual : ServerApp.products) {
            for (int i = 0; i < ordered.size(); i++) {
                if (ordered.get(i).getId() > actual.getManufacturer().getId()) {
                    ordered.add(i, actual.getManufacturer());
                    break;
                }
            }
            ordered.add(actual.getManufacturer());
        }
        for (Organization organization : ordered) {
            response.append("Id:" + organization.getId() + " Name:" + organization.getName());
        }
        return response.toString();
    }
}
