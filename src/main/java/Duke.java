import duke.command.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * An interactive chatBot that helps it user to maintain their tasks
 *
 * @author Angky Akdi Frandy Putrakelana
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui = new Ui();

    /**
     * Constructs an instance of Duke chatBot.
     *
     */
    public Duke() {
        try {
            this.storage = new Storage();
            this.tasks = this.storage.load();
        } catch (DukeException var2) {
            this.tasks = new TaskList();
        }
    }

    /**
     * Runs the duke chatBot.
     *
     */
    private void run() {
        this.ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = this.ui.readCommand();
                this.ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(this.tasks, this.ui, this.storage);
                isExit = c.isExit();
                this.storage.writeFile(this.tasks);
            } catch (DukeException var7) {
                this.ui.showError(var7.getMessage());
            } finally {
                this.ui.showLine();
            }
        }

    }

    /**
     * Starts the duke chatBot.
     *
     */
    public static void main(String[] args) {
        Duke duke = new Duke();
        String logo = " ____        _        \n|  _ \\ _   _| | _____ \n| | | | | | | |/ / _ \\\n| |_| | |_| |   "
                    + "<  __/\n|____/ \\__,_|_|\\_\\___|\n";
        duke.run();
    }
}
