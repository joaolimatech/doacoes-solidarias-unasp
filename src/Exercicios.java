import java.util.Scanner;
public class Exercicios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("FAZENDO EXERCICIOS JAVA%nEscreva o primeiro numero: ");
        int n1 = scanner.nextInt();
        System.out.printf("Escreva o segundo numero (maior que %d): ", n1);
        int n2 = scanner.nextInt();

        System.out.printf("Incluindo os numeros digitados, quantos numeros nesse intervalo (%d - %d) são ímpares?: ", n1, n2);
        int respostaImpares = scanner.nextInt();

        int certaRepostaImpares = 0;
        for (int i =n1; i<=n2; i++){
            if (i%2==1){
                certaRepostaImpares++;
            }
        }

        if (respostaImpares == certaRepostaImpares){
            System.out.printf("Você acertou! %d numeros impares no intervalo de (%d - %d)", certaRepostaImpares, n1,n2);
        } else {
            System.out.printf("Errado! Existem %d numeros impares inteiros nesse intervalo", certaRepostaImpares);
        }

        System.out.printf("%nAfinal, você sabe a diferença entre Inteiro e Decimal?%n");
        String resp = scanner.nextLine().strip().toLowerCase();
        System.out.println(resp);
        if (resp.equals("nao") || resp.equals("não")){
        System.out.println("Explicaçao blablabla");
        } else {
            System.out.println("Quer uma revisao? ");
            String resp1 = scanner.nextLine().strip().toLowerCase();
            if (resp1.equals("sim")){System.out.println("lbalba explica");
            }else {System.exit(0);}
        }

        for(int i = 0; i <= 10; i++){
            System.out.println(i);
        }


    }
}
