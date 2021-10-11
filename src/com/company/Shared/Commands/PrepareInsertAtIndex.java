package com.company.Shared.Commands;

import com.company.Shared.Entities.Product;
import com.company.Shared.ProductReader;

public class PrepareInsertAtIndex extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        command.setCommandType(CommandType.INSERT_AT_INDEX);
        dataBox = readDataCommandId(parts, comments);
        command.setDataBox(dataBox);
        return dataBox != null;
    }

    private DataBox readDataCommandId(String[] parts, StringBuilder comments) {
        if (parts.length < 2) {
            comments.append("The command is incomplete, you need to enter the index.");
            return null;
        }
        DataBox dataBox = new DataBox();
        try {
            dataBox.setIndex(Integer.parseInt(parts[1]));
        } catch (NumberFormatException e) {
            comments.append("The command is invalid.");
            return null;
        }
        Product product = readProduct();
        dataBox.setProduct(product);
        return dataBox;
    }

    private static Product readProduct() {
        ProductReader productReader = new ProductReader();
        return productReader.createProduct();
    }
}
