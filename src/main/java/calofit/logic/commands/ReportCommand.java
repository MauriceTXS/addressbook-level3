package calofit.logic.commands;

import static java.util.Objects.requireNonNull;

import calofit.logic.commands.exceptions.CommandException;
import calofit.model.Model;

/**
 * Generates a statistical report containing various data.
 */
public class ReportCommand extends Command {

    public static final String COMMAND_WORD = "report";

    public static final String MESSAGE_SUCCESS = "Report has been generated";

    public static final String MESSAGE_FAILURE =
            "You currently have no meals in CaloFit for this month. Get Started! :)";

    /**
     * Updates the Statistics of CaloFit and returns the Command Result.
     * @param model {@code Model} which the command should operate on.
     * @return the CommandResult of the ReportCommand.
     * @throws CommandException if there are no meals in the MealLog in the current month.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (model.getMealLog().getCurrentMonthMeals().size() == 0) {
            throw new CommandException(MESSAGE_FAILURE);
        }
        return new CommandResult(MESSAGE_SUCCESS, false, true, false);
    }

}
