import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class TestLineNumbering {
    public static void main(String[] args) {
        String fileName = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku: ");
        fileName = scan.nextLine();
        try {
            File file = new File(fileName+".txt");
            if (file.createNewFile()) {
                System.out.println("Utworzono plik: " + file.getName());
                System.out.println("Wprowadź tekst linijka pod linijką: ");
                try {
                    int i = 1;
                    FileWriter fileWriter = new FileWriter(fileName+".txt");
                    while(scan.hasNextLine()){
                        fileWriter.write(i+". "+scan.nextLine()+"\t\\"+i+"\n");
                        i++;
                        if(scan.nextLine().equals("koniec")){ //wpisać "koniec" aby zakończyć pętle, nie koniecznie działa :(
                            break;
                        }
                    }
                    fileWriter.close();
                    System.out.println("Zapisano do pliku");
                } catch (IOException e) {
                    System.out.println("Napotkano błąd.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Plik już istnieje!");
            }
        } catch (IOException e) {
            System.out.println("Napotkano błąd.");
            e.printStackTrace();
        }
    }
}
