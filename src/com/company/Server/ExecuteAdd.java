package com.company.Server;

import com.company.Shared.Commands.Command;
import com.company.Shared.Entities.Product;

import java.util.Vector;

public class ExecuteAdd extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        command.getDataCommand().getProduct().setId(getProductId());
        command.getDataCommand().getProduct().getManufacturer().setId(getIdOrganization());
        ServerApp.products.add(command.getDataCommand().getProduct());
        return "The dragon was inserted.";
    }

    private static Integer getProductId() {
        Integer maxKey = 0;
        for (Product actual : ServerApp.products) {
            if (actual.getId() > maxKey) {
                maxKey = actual.getId();
            }
        }
        maxKey++;
        return maxKey;
    }

    private static Integer getIdOrganization() {
        Integer maxKey = 0;
        for (Product actual : ServerApp.products) {
            if (actual.getId() > maxKey) {
                maxKey = actual.getId();
            }
        }
        maxKey++;
        return maxKey;
    }
}