package com.company.Server;

import com.company.Shared.Commands.Command;
import com.company.Shared.Entities.Product;

public class ExecuteUpdate extends ExecuteCommand {

    @Override
    public String execute(Command command) {

        int idValue;
        StringBuilder stringBuilder = new StringBuilder();
        idValue = ParseAll.tryParseInt(command.getDataBox().getId().toString(), 0, stringBuilder);
        if (stringBuilder.length() > 0) {
            return "The value was not a number, enter a valid value.";
        }

        for (Product actual : ServerApp.products) {

            if (actual.getId() == idValue) {
                ServerApp.products.remove(actual);
                Product product = command.getDataBox().getProduct();
                product.setId(idValue);
                ServerApp.products.add(product);
            }
        }
        return "the Product was updated";
    }
}
