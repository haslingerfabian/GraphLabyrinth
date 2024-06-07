import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ReadingFromFile
{
    public ReadingFromFile() {};

    public char[][] readFileToCharArray(String filename) {
        List<char[]> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.toCharArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int numRows = lines.size();
        int numCols = lines.get(0).length;
        char[][] grid = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            grid[i] = lines.get(i);
        }

        return grid;
    }
}
