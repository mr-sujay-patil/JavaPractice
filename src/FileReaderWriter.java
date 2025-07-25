import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderWriter {

    public static void main(String[] args) throws IOException {
        try (FileWriter fileWriter = new FileWriter("my-file.txt")) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("Writing from java class\n");
                bufferedWriter.write("Next line functionality");
            }
        }

        try (FileReader fileReader = new FileReader("my-file.txt")) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String string = bufferedReader.lines().collect(Collectors.joining(" "));
                String collect = String.join("", string.split(" "));

                System.out.println(collect);
                System.out.println(string);

                String str=bufferedReader.readLine();
//                System.out.println(str);
            }
        }
    }
}
