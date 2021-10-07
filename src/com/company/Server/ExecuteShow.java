package com.company.Server;

import com.company.Shared.Commands.Command;

import java.util.Vector;

public class ExecuteShow extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        if (ServerApp.products.isEmpty()) {
            return "There are no dragons";
        }
        StringBuilder dataProduct = new StringBuilder();

        ServerApp.products.forEach(k -> dataProduct.append("\n").append(k.toString()));
        return dataProduct.toString();
    }
}
