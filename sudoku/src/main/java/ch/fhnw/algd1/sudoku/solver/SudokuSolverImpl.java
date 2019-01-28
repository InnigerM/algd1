/*
 * Created on 03.12.2013
 */
package ch.fhnw.algd1.sudoku.solver;

import ch.fhnw.algd1.sudoku.framework.SudokuChecker;
import ch.fhnw.algd1.sudoku.framework.SudokuModel;
import ch.fhnw.algd1.sudoku.framework.SudokuSolver;

/**
 * @author
 */
public final class SudokuSolverImpl implements SudokuSolver {
    private final SudokuChecker checker;

    /**
     * Create a new solver based on a checker
     *
     * @param checker the SudokuChecker this solver will be using to determine the
     *                validity of partial solutions
     */
    public SudokuSolverImpl(SudokuChecker checker) {
        this.checker = checker;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * ch.fhnw.algd1.sudoku.SudokuSolver#solved(ch.fhnw.algd1.sudoku.SudokuModel)
     */
    @Override
    public boolean solved(SudokuModel model) {
        // TODO start recursive search at square (0,0)
        return solved(model, 0);
    }

    public boolean solved(SudokuModel model, int fieldNr){
        if(fieldNr == model.size() * model.size()) return true;
        else{
            int i = fieldNr / model.size(), j = fieldNr % model.size();
            if(model.get(i, j) != 0){
                return solved(model, fieldNr + 1);
            } else{
                boolean found = false;
                int value = 1;
                while(value <= model.size() && !found) {
                    model.set(i, j, value);
                    if(checker.oneOK(model, i, j)) found = solved(model, fieldNr + 1);
                    value++;
                }
                if(!found) model.clear(i, j);
                return found;
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * ch.fhnw.algd1.sudoku.SudokuSolver#nofSolutions(ch.fhnw.algd1.sudoku.SudokuModel
     * )
     */
    @Override
    public int nofSolutions(SudokuModel model) {
        // TODO start recursive enumeration of solutions, beginning at (0,0)
        return nofSolutions(model, 50);
    }

    public int nofSolutions(SudokuModel model, int maxValue){
        if(maxValue == 0) return 50;
        else{
            return 0;
        }
    }
}
