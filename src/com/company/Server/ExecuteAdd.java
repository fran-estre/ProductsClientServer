package com.company.Server;

import com.company.Shared.Commands.Command;
import com.company.Shared.Entities.Product;

public class ExecuteAdd extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        Product product=command.getDataBox().getProduct();
        product.setId(getProductId());
        product.getManufacturer().setId(getIdOrganization());
        ServerApp.products.add(product);
        return "The product was inserted.";
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