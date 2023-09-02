package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.storage.Storage;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printExit();
    }
    @Override
    public boolean isExit() {
        return true;
    }
}