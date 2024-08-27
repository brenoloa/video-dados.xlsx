import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantidade_dados;
        System.out.print("Digite a quantidade de produtos: ");
        quantidade_dados = scan.nextInt();//def quantidade
        
        scan.nextLine(); //reseta

        //matriz.
        String[][] produtos = new String[quantidade_dados][3];
        String[] cabecalho = {"PRODUTO", "CÓDIGO", "VALIDADE"};

        for (int i = 0; i < quantidade_dados; i++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(cabecalho[x] + " >>: ");
                produtos[i][x] = scan.nextLine();

            }
            
        }
        // exportando pra excel.

        try (FileWriter writer = new FileWriter("dados.xlsx")) {
            //topo cabecalho
            for (int x = 0; x < 3; x++) {
                writer.write(cabecalho[x] + "\t");
             
            }
            writer.write("\n");
            
            for (int i = 0; i < quantidade_dados; i++) {
                for (int x = 0; x < 3; x++) {
                    writer.write(produtos[i][x] + "\t");                               
                }
            writer.write("\n");  
            }
        
            System.out.println("#### ARQUIVO GERADO ####");            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
