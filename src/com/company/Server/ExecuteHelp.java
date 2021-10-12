package com.company.Server;

import com.company.Shared.Commands.Command;

public class ExecuteHelp extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        return "help : display help for available commands " +
                "\ninfo : output information about the collection (type, initialization date, number of elements, etc.) to the standard output stream.)" +
                "\nshow : output all the elements of the collection in a string representation to the standard output stream" +
                "\nadd : add a new item to the collection" +
                "\nupdate id: update the value of a collection element whose id is equal to the specified one" +
                "\nremove_by_id id : delete an item from the collection by its id" +
                "\nclear : clear the collection" +
                "\nsave : save the collection to a file" +
                "\nexecute_script file_name : read and execute the script from the specified file. The script contains commands in the same form as they are entered by the user in interactive mode." +
                "\nexit : end the program (without saving it to a file)" +
                "\ninsert_at index : add a new element to the specified position" +
                "\nremove_last : delete the last item from the collection" +
                "\nremove_greater : remove all items from the collection that exceed the specified limit" +
                "\nremove_all_by_manufacturer manufacturer : remove all items from the collection whose manufacturer field value is equivalent to the specified one" +
                "\ngroup_counting_by_part_number : group the elements of the collection by the value of the partNumber field, output the number of elements in each group" +
                "\nprint_field_ascending_manufacturer : output the values of the manufacturer field of all elements in ascending order";
    }
}
