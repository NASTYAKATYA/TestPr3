package ru.mirea;


import com.sun.source.tree.AssertTree;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
    class MatrixWithResult {
        int[][] matrix1;
        int[][] matrix2;
        int[][] resultMatrix;
        public MatrixWithResult(int[][] matrix1, int[][] matrix2, int[][] resultMatrix) {
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.resultMatrix = resultMatrix;
        }
        public int[][] getMatrix1() {
            return matrix1;
        }

        public int[][] getMatrix2() {
            return matrix2;
        }

        public int[][] getResultMatrix() {
            return resultMatrix;
        }
    }

    List<MatrixWithResult> matricesForAdd = new ArrayList<>();
    List<MatrixWithResult> matricesForSub = new ArrayList<>();
    List<MatrixWithResult> matricesForMul = new ArrayList<>();

    int[][] getMatrixByRowsAndCols(int rows, int cols)
    {
        return new int[rows][cols];
    }

    @Before
    public void setUp() {
        matricesForAdd.add(new MatrixWithResult(
                new int[][]{{1, 0},
                            {2, 3}},
                new int[][]{{1, 0},
                            {0, 5}},
                new int[][]{{2, 0},
                            {2, 8}}
        ));
        matricesForAdd.add(new MatrixWithResult(
                new int[][]{{1, 0},
                        {2, 3}},
                new int[][]{{1, 0},
                        {0, 5}},
                new int[][]{{2, 0},
                        {2, 8}}
        ));

        matricesForAdd.add(new MatrixWithResult(
                new int[][]{{3, 7, 6},
                        {12, -7, -3}},
                new int[][]{{0, -4, 2},
                        {-6, 4, 1}},
                new int[][]{{3, 3, 8},
                        {6, -3, -2}}
        ));

        matricesForSub.add(new MatrixWithResult(
                new int[][]{{12, 8, 5},
                        {2, -5, 3},
                        {9, 14, 0}},
                new int[][]{{11, -6, 0},
                        {-2, 5, 1},
                        {4, 10, 8}},
                new int[][]{{1, 14, 5},
                        {4, -10, 2},
                        {5, 4, -8}}
        ));

        matricesForSub.add(new MatrixWithResult(
                new int[][]{{3, 4},
                        {-8, 10},
                        {15, 0}},
                new int[][]{{7, -5},
                        {-1, 2},
                        {9, -6}},
                new int[][]{{-4, 9},
                        {-7, 8},
                        {6, 6}}
        ));

        matricesForMul.add(new MatrixWithResult(
                new int[][]{{1, 2},
                        {3, 4}},
                new int[][]{{5, 6},
                        {7, 8}},
                new int[][]{{19, 22},
                        {43, 50}}
        ));

        matricesForMul.add(new MatrixWithResult(
                new int[][]{{2, 3},
                        {6, 5}},
                new int[][]{{8, 9, 7},
                        {5, 3, 5}},
                new int[][]{{31, 27, 29},
                        {73, 69, 67}}
        ));
    }

    @Test
    public void multMatrices() {
        for (var matricesForMulEl: matricesForMul) {
            assertTrue(Arrays.deepEquals(matricesForMulEl.getResultMatrix(),
                    Main.multMatrices(matricesForMulEl.getMatrix1(), matricesForMulEl.getMatrix2())));
        }
    }

    @Test
    public void addMatrices() {
        for (var matricesForAddEl: matricesForAdd) {
            assertTrue(Arrays.deepEquals(matricesForAddEl.getResultMatrix(),
                    Main.addMatrices(matricesForAddEl.getMatrix1(), matricesForAddEl.getMatrix2())));
        }
    }

    @Test
    public void subtractMatrices() {
        for (var matricesForSubEl: matricesForSub) {
            assertTrue(Arrays.deepEquals(matricesForSubEl.getResultMatrix(),
                    Main.subtractMatrices(matricesForSubEl.getMatrix1(), matricesForSubEl.getMatrix2())));
        }
    }

    @Test
    public void checkForAddSub() {
        int start = 2, count = 7;
        for (int row1 = start; row1 < count; row1++) {
            for (int col1 = start; col1 < count; col1++) {
                for (int row2 = start; row2 < count; row2++) {
                    for (int col2 = start; col2 < count; col2++) {
                        if (row1 == row2 && col1 == col2) {
                            assertTrue("row1 = " + row1 + ";col1 = " + col1 +
                                    ";row2 = " + row2 + ";col2 = " + col2 + "\nExpected true, got false", Main.checkForAddSub(getMatrixByRowsAndCols(row1,col1),
                                    getMatrixByRowsAndCols(row2,col2)));
                        } else {
                            assertFalse("row1 = " + row1 + ";col1 = " + col1 +
                                    ";row2 = " + row2 + ";col2 = " + col2 + "\nExpected false, got true",Main.checkForAddSub(getMatrixByRowsAndCols(row1,col1),
                                    getMatrixByRowsAndCols(row2,col2)));
                        }
                    }
                }
            }
        }
    }

    @Test
    public void checkForMult() {
        int start = 2, count = 7;
        for (int row1 = start; row1 < count; row1++) {
            for (int col1 = start; col1 < count; col1++) {
                for (int row2 = start; row2 < count; row2++) {
                    for (int col2 = start; col2 < count; col2++) {
                        if (col1 == row2) {
                            assertTrue("row1 = " + row1 + ";col1 = " + col1 +
                                    ";row2 = " + row2 + ";col2 = " + col2 + "\nExpected true, got false", Main.checkForMult(getMatrixByRowsAndCols(row1,col1),
                                    getMatrixByRowsAndCols(row2,col2)));
                        } else {
                            assertFalse("row1 = " + row1 + ";col1 = " + col1 +
                                    ";row2 = " + row2 + ";col2 = " + col2 + "\nExpected false, got true",Main.checkForMult(getMatrixByRowsAndCols(row1,col1),
                                    getMatrixByRowsAndCols(row2,col2)));
                        }
                    }
                }
            }
        }
    }
}