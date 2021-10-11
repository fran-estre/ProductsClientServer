package com.company.Shared.Commands;

import com.company.Shared.ProductReader;
import com.company.Shared.Entities.Product;

public class PrepareUpdate extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        if (!isInteractive)
            return false;

        command.setCommandType(CommandType.UPDATE);
        dataBox = readDataCommandUpdate(parts,comments);
        command.setDataBox(dataBox);
        return dataBox != null;
    }

    private static Product readProduct() {
        ProductReader productReader = new ProductReader();
        return productReader.createProduct();
    }

    private DataBox readDataCommandUpdate(String[] parts, StringBuilder comments) {
        if (parts.length < 2) {
            comments.append("The command is incomplete, you need to enter the id.");
            return null;
        }
        DataBox dataBox = new DataBox();
        try {
            dataBox.setId(Integer.parseInt(parts[1]));
        } catch (NumberFormatException e) {
            comments.append("The command is invalid.");
            return null;
        }
        Product product = readProduct();
        dataBox.setProduct(product);
        return dataBox;
    }
}
